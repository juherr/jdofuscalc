/**
 * Fichier : ATelechargeur.java
 * Auteur : PAPAYA Alexandre
 * 
 * Copyright Alexandre, 2009, tous droits réservés.
 */

package fr.ayapap;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.event.EventListenerList;

import org.apache.log4j.Logger;

import fr.ayapap.observateurs.ObservateurTelechargeur;

/**
 * Classe de téléchargement de fichier.
 * 
 * @author PAPAYA Alexandre
 * @version 1.0
 * @category Telechargeur
 */
public class ATelechargeur implements Runnable
{
	/*
	 * Constantes d'état du téléchargement
	 */

	/**
	 * Téléchargement en cours.
	 */
	public final static int TELECHARGE = 1;
	/**
	 * Téléchargement en pause.
	 */
	public final static int EN_PAUSE = 2;
	/**
	 * Téléchargement terminé.
	 */
	public final static int COMPLET = 3;
	/**
	 * Erreur lors du téléchargement.
	 */
	public final static int ERREUR = 4;
	/**
	 * Téléchargement annulé.
	 */
	public final static int ANNULE = 5;

	/*
	 * Constantes
	 */

	/**
	 * Taille maximum du buffer.
	 */
	private final static int TAILLE_MAX_BUFFER = 1024;

	/*
	 * Variables d'instance
	 */

	/**
	 * Liste des observateurs enregistrés.
	 */
	private EventListenerList listeObservateurs = new EventListenerList();

	/**
	 * URL du fichier à télécharger.
	 */
	private URL url;

	/**
	 * Chemin vers le fichier de destination.
	 */
	private String destination;

	/**
	 * Taille en bytes du fichier source.
	 */
	private int taille;

	/**
	 * Etat du télécahrgement.
	 */
	private int etat;

	/**
	 * Nombre de bytes téléchargés.
	 */
	private long bytesTelecharges;

	/**
	 * Timer de calcul de la vitesse de téléchargement.
	 */
	private Timer timerVitesse;
	
	/**
	 * Logger.
	 */
	private final static Logger logger = Logger.getLogger("fr.ayapap.ATelechargeur");

	/*
	 * Constructeurs / Destructeur
	 */

	/**
	 * Construit un {@link ATelechargeur}.
	 * 
	 * @param url - URL du fichier à télécharger.
	 * @param destination - Dossier de destination du fichier téléchargé.
	 * @category Constructeur
	 */
	public ATelechargeur(URL url, String destination)
	{
		this.url = url;
		this.destination = destination;
		this.taille = -1;
		this.bytesTelecharges = 0;
		this.etat = TELECHARGE;
		
		ATelechargeur.logger.trace("Création d'une nouvelle instance. Paramètres : URL : '" + url + "', destination : '" + destination + "'.");
	}

	/*
	 * Actions
	 */

	/**
	 * Met en pause le téléchargement.
	 */
	public void mettreEnPause()
	{
		this.etat = EN_PAUSE;
		
		ATelechargeur.logger.trace("Mise en pause du télécahrgement.");

		this.changementEtat();
	}

	/**
	 * Relance le téléchargement.
	 */
	public void relancer()
	{
		this.etat = TELECHARGE;
		
		ATelechargeur.logger.trace("Lancement du télécahrgement.");
		
		this.changementEtat();

		this.telecharger();
	}

	/**
	 * Annule le télécahrgement.
	 */
	public void annuler()
	{
		this.etat = ANNULE;
		
		ATelechargeur.logger.trace("Annulation du télécahrgement.");
		
		this.changementEtat();
	}

	/**
	 * Marque le téléchargement avec une erreur.
	 * 
	 * @param message
	 */
	private void erreur(String message)
	{
		this.etat = ERREUR;
		this.changementEtat();

		ATelechargeur.logger.error("Erreur lors du téléchargement : " + message + ".");
	}

	/*
	 * Méthodes de téléchargement
	 */

	/**
	 * Lance ou relance le téléchargement.
	 */
	public void telecharger()
	{
		Thread thread = new Thread(this);
		thread.start();
	}

	/**
	 * Méthode {@code run} invoquée lors du lancement du thread de téléchargement.
	 */
	public void run()
	{
		RandomAccessFile output = null;
		InputStream input = null;
		try
		{
			ATelechargeur.logger.trace("Préparation du téléchargement.");

			// Ouvre la connexion à l'url
			HttpURLConnection connexion = (HttpURLConnection) this.url.openConnection();

			// Specifie quelle portion du fichier nous voulons télécharger
			connexion.setRequestProperty("Range", "bytes=" + this.bytesTelecharges + "-");

			// Connexion au serveur
			connexion.connect();

			// Vérifie que la connexion au serveur s'est correctement effectuée
			if((connexion.getResponseCode() / 100) != 2)
			{
				this.erreur("Impossible de se connecter au serveur : [" + connexion.getResponseCode() + "]" + connexion.getResponseMessage());
			}

			// Vérifie si la tailleà télécharger est valide
			int tailleATelecharger = connexion.getContentLength();
			if(tailleATelecharger < 1)
			{
				this.erreur("Fichier introuvable (" + this.url.toString() + ")");
			}

			// Enregistre la taille du fichier à télécharger
			if(this.taille == -1)
			{
				this.taille = tailleATelecharger;
				this.changementAvancement();
			}

			// Ouvre le fichier de destination et place le curseur
			File fichier = new File(this.destination + this.getNomFichier(this.url));
			fichier.delete();
			output = new RandomAccessFile(fichier, "rw");
			output.seek(this.bytesTelecharges);

			// Initialisation du timer chargé de calculer la vitesse de
			// téléchargement
			this.timerVitesse = new Timer();
			this.timerVitesse.schedule(new TimerVitesse(fichier), 0, 1000);

			// Boucle de lecture
			input = connexion.getInputStream();
			while(this.etat == TELECHARGE)
			{
				// Génération du buffer
				byte[] buffer;
				if((this.taille - this.bytesTelecharges) > TAILLE_MAX_BUFFER)
				{
					buffer = new byte[TAILLE_MAX_BUFFER];
				}
				else
				{
					buffer = new byte[(int) (this.taille - this.bytesTelecharges)];
				}

				// Lecture de la portion du fichier sur le seveur
				int byteCourant = input.read(buffer);
				if(byteCourant == -1)
				{
					break;
				}

				// Ecriture de la portoin du fichier sur le disque
				output.write(buffer, 0, byteCourant);

				this.bytesTelecharges += byteCourant;
				
				ATelechargeur.logger.trace(this.bytesTelecharges + " sur " + this.taille + " effectué.");

				this.changementAvancement();
			}

			if(this.etat == TELECHARGE)
			{
				this.etat = COMPLET;
				this.changementEtat();
			}
		}
		catch(IOException e)
		{
			this.erreur(e.getMessage());
		}
		finally
		{
			/* Fermeture des connexions */

			if(output != null)
			{
				try
				{
					output.close();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}

			if(input != null)
			{
				try
				{
					input.close();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Timer chargé du calcul de la vitesse de téléchargement.
	 * 
	 * @author PAPAYA Alexandre
	 * @category Timer
	 * @version 1.0
	 */
	private class TimerVitesse extends TimerTask
	{
		/**
		 * Fichier à vérifier.
		 */
		private File fichier;

		/**
		 * Taille en bytes du fichier lors du dernier appel au timer.
		 */
		private long taillePrecedente = 0;

		/**
		 * Construit le timer.
		 * 
		 * @param fichier - Fichier en cours de téléchargement.
		 * @category Constructeur
		 */
		private TimerVitesse(File fichier)
		{
			this.fichier = fichier;
		}

		@Override
		public void run()
		{
			long tailleTelechargee = this.fichier.length() - this.taillePrecedente;
			this.taillePrecedente = this.fichier.length();

			float vitesse = (float) AMath.arrondir(((float) tailleTelechargee / (float) 1000), 2);

			ATelechargeur.this.changementVitesse(vitesse);
		}
	}

	/*
	 * Gestion des observateurs
	 */

	/**
	 * Enregistre un nouvel observateur à la classe.
	 * 
	 * @param observateur
	 */
	public void addObservateur(ObservateurTelechargeur observateur)
	{
		this.listeObservateurs.add(ObservateurTelechargeur.class, observateur);
	}

	/**
	 * Supprime un observateur à la classe.
	 * 
	 * @param observateur
	 */
	public void removeObservateur(ObservateurTelechargeur observateur)
	{
		this.listeObservateurs.remove(ObservateurTelechargeur.class, observateur);
	}

	/**
	 * Previent les observateurs que l'etat du téléchargement a changé.
	 */
	private void changementEtat()
	{
		if((this.etat != TELECHARGE) && (this.timerVitesse != null))
		{
			this.timerVitesse.cancel();
		}

		ObservateurTelechargeur[] observateurs = this.listeObservateurs.getListeners(ObservateurTelechargeur.class);
		for(ObservateurTelechargeur observateur : observateurs)
		{
			observateur.changementEtat(this.etat);
		}
	}

	/**
	 * Previent les observateurs que l'avancement du téléchargement a changé.
	 */
	private void changementAvancement()
	{
		ObservateurTelechargeur[] observateurs = this.listeObservateurs.getListeners(ObservateurTelechargeur.class);
		for(ObservateurTelechargeur observateur : observateurs)
		{
			observateur.changementAvancement(this.getAvancement());
		}
	}

	/**
	 * Previent les observateurs que la vitesse du téléchargement a changé.
	 * 
	 * @param vitesse
	 */
	private void changementVitesse(float vitesse)
	{
		ObservateurTelechargeur[] observateurs = this.listeObservateurs.getListeners(ObservateurTelechargeur.class);
		for(ObservateurTelechargeur observateur : observateurs)
		{
			observateur.changementVitesse(vitesse);
		}
	}

	/*
	 * Accesseurs
	 */

	/**
	 * Renvoie le nom du fichier caractérisé par l'<code>url</code>.
	 * 
	 * @param url - {@link URL} du fichier.
	 * @return Le nom du fichier de l'<code>url</code>, ou une chaine vide s'il n'existe pas.
	 */
	public String getNomFichier(URL url)
	{
		String nomFichier = url.getFile();
		return nomFichier.substring(nomFichier.lastIndexOf('/') + 1);
	}

	/**
	 * Renvoie l'avancement du téléchargement en pourcent.
	 * 
	 * @return L'avancement du téléchargement en pourcent.
	 */
	public float getAvancement()
	{
		return (float) AMath.arrondir((((float) this.bytesTelecharges / this.taille) * 100), 2);
	}

	/**
	 * Renvoie l'état du téléchargement.
	 * 
	 * @return L'état du téléchargement.
	 */
	public int getEtat()
	{
		return this.etat;
	}
}