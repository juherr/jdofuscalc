/**
 * Projet JDofusCalc
 * 
 * Copyright PAPAYA Alexandre, (2008, 2009) 
 * 
 * alexandre.papaya@gmail.com
 * 
 * Ce logiciel est un programme informatique servant à gérer les personnages
 * de l'utilisateur sur le jeu Dofus(c) et à calculer et tester les répercutions
 * sur le jeu de la modification de divers paramètres tels que les équipements,
 * les caractéristiques, ect. Ce programme est codé en java et utilise des
 * bibliothèques dont les licences sont compatibles avec la licence CeCILL.
 * 
 * Ce logiciel est régi par la licence CeCILL soumise au droit français et
 * respectant les principes de diffusion des logiciels libres. Vous pouvez
 * utiliser, modifier et/ou redistribuer ce programme sous les conditions
 * de la licence CeCILL telle que diffusée par le CEA, le CNRS et l'INRIA 
 * sur le site "http://www.cecill.info".
 * 
 * En contrepartie de l'accessibilité au code source et des droits de copie,
 * de modification et de redistribution accordés par cette licence, il n'est
 * offert aux utilisateurs qu'une garantie limitée.  Pour les mêmes raisons,
 * seule une responsabilité restreinte pèse sur l'auteur du programme,  le
 * titulaire des droits patrimoniaux et les concédants successifs.
 * 
 * A cet égard  l'attention de l'utilisateur est attirée sur les risques
 * associés au chargement,  à l'utilisation,  à la modification et/ou au
 * développement et à la reproduction du logiciel par l'utilisateur étant 
 * donné sa spécificité de logiciel libre, qui peut le rendre complexe à 
 * manipuler et qui le réserve donc à des développeurs et des professionnels
 * avertis possédant  des  connaissances  informatiques approfondies.  Les
 * utilisateurs sont donc invités à charger  et  tester  l'adéquation  du
 * logiciel à leurs besoins dans des conditions permettant d'assurer la
 * sécurité de leurs systèmes et ou de leurs données et, plus généralement, 
 * à l'utiliser et l'exploiter dans les mêmes conditions de sécurité. 
 * 
 * Le fait que vous puissiez accéder à cet en-tête signifie que vous avez 
 * pris connaissance de la licence CeCILL, et que vous en avez accepté les
 * termes.
 */

package org.JDofusCalc.modeles;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.JDofusCalc.Main;
import org.JDofusCalc.observateurs.ObservateurUpdate;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import fr.ayapap.AFile;
import fr.ayapap.ATelechargeur;
import fr.ayapap.AUtil;
import fr.ayapap.observateurs.ObservateurTelechargeur;

/**
 * Modèle de mise à jour.
 * 
 * @author PAPAYA Alexandre
 * @category Modele
 * @version 1.0
 */
public class ModeleUpdateur extends Modele implements ObservateurTelechargeur
{
	/*
	 * Variables d'instances
	 */

	/**
	 * Chemin vers le serveur de mise à jour.
	 */
	private String cheminServeur;

	/**
	 * Fichier XML.
	 */
	private Document fichierXML;

	/**
	 * Dossier updateur.
	 */
	private File dossierUpdateur = new File("updateur");

	/* Les threads */

	/**
	 * Le Thread du constructeur de la classe.
	 */
	private ThreadConstructeur threadConstructeur;

	/**
	 * Le Thread de téléchargement de la classe.
	 */
	private ThreadTelechargement threadTelechargement;

	/*
	 * Constructeurs / Destructeur
	 */

	/**
	 * Construit un nouveau modèle de mise ç jour de l'application.
	 * 
	 * @category Constructeur
	 */
	public ModeleUpdateur()
	{
		// Execution du constructeur père
		super();

		this.threadConstructeur = new ThreadConstructeur();
		this.threadConstructeur.start();
	}

	/**
	 * Thread du constructeur du {@link ModeleUpdateur}.
	 * 
	 * @author PAPAYA Alexandre
	 * @category Thread
	 * @version 1.0
	 */
	public class ThreadConstructeur extends Thread
	{
		@Override
		public void run()
		{
			InputStream input = null;
			try
			{
				// Récupération du chemin du serveur de mise à jour
				Properties props = new Properties();
				props.load(new FileInputStream(Main.FICHIER_PROPERTIES));
				ModeleUpdateur.this.cheminServeur = (String) props.get("Updateur.serveur");

				// Logger
				logger.debug("Connexion au serveur de mise à jour " + ModeleUpdateur.this.cheminServeur + ".");
				
				// Génération de l'URL
				URL url = new URL(ModeleUpdateur.this.cheminServeur + "versions.xml");
				// Ouverture de la connexion
				URLConnection connexion = url.openConnection();
				connexion.setUseCaches(false);
				// Connexion
				connexion.connect();

				// Recupération du fichier
				input = connexion.getInputStream();
				// Création du fichier xml
				SAXBuilder builder = new SAXBuilder();
				ModeleUpdateur.this.fichierXML = builder.build(input);
			}
			catch(MalformedURLException e)
			{
				// Logger
				logger.error("Connexion au serveur de mise à jour impossible : " + e.getMessage() + ".");

				e.printStackTrace();
			}
			catch(IOException e)
			{
				// Logger
				logger.error("Connexion au serveur de mise à jour impossible : " + e.getMessage() + ".");

				e.printStackTrace();
			}
			catch(JDOMException e)
			{
				// Logger
				logger.error("Connexion au serveur de mise à jour impossible : " + e.getMessage() + ".");

				e.printStackTrace();
			}
			finally
			{
				try
				{
					input.close();
				}
				catch(IOException e)
				{
					// Logger
					logger.error("Connexion au serveur de mise à jour impossible : " + e.getMessage() + ".");
					
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Vérifie si une nouvelle version est disponible au téléchargement.
	 * 
	 * @return Retourne {@code true} si une nouvelle version est disponible.
	 */
	public boolean existNouvelleVersion()
	{
		if(this.fichierXML != null)
		{
			// Logger
			logger.debug("Vérification des versions.");
			
			// Récupération des versions
			Element racine = this.fichierXML.getRootElement();

			// Dernière version disponible
			String derniereVersion = racine.getChild("derniereVersion").getChildText("numero");
			String versionActuelle = Main.getVersion();
			// Si une nouvelle version de l'application est disponible
			if(this.comparerVerisons(versionActuelle, derniereVersion))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}

	/**
	 * Verifie si la connexion au serveur de mise à jour a été correctement efféctuée.
	 * 
	 * @return Retourne {@code true} si la connexion a été effectuée, sinon {@code false}.
	 */
	public boolean isConnecte()
	{
		if(this.fichierXML == null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	/**
	 * Compare deux versions du type X.X.X(Dev|Beta).
	 * 
	 * @param versionComparee - Numéro de version à comparer avec la {@code versionComparant}.
	 * @param versionComparant - Numéro de version que l'on compare avec la {@code versionComparee}.
	 * @return Retourne {@code true} si la version comparant est plus récente que la version comparée.
	 */
	public boolean comparerVerisons(String versionComparee, String versionComparant)
	{
		// Séparation des éléments des numéros de version
		String[] tableauVersionComparee = versionComparee.split("\\.");
		String[] tableauVersionComparant = versionComparant.split("\\.");

		// Boucle des éléments
		for(int i = 0; i < tableauVersionComparee.length; i++)
		{
			int numeroVersionComparee = 0;
			try
			{
				numeroVersionComparee = Integer.parseInt(tableauVersionComparee[i]);
			}
			// Si le cast a échoué, l'élément est terminer par un tag qu'il faut
			// enlever
			catch(NumberFormatException exception)
			{
				String partieVersionComparee = tableauVersionComparee[i];
				if(partieVersionComparee.endsWith("Dev"))
				{
					partieVersionComparee = partieVersionComparee.substring(0, (partieVersionComparee.length() - 3));
				}
				if(partieVersionComparee.endsWith("Beta"))
				{
					partieVersionComparee = partieVersionComparee.substring(0, (partieVersionComparee.length() - 4));
				}

				numeroVersionComparee = Integer.parseInt(partieVersionComparee);
			}

			int numeroVersionComparant = 0;
			try
			{
				numeroVersionComparant = Integer.parseInt(tableauVersionComparant[i]);
			}
			// Si le cast a échoué, l'élément est terminer par un tag qu'il faut
			// enlever
			catch(NumberFormatException exception)
			{
				String partieVersionComparant = tableauVersionComparant[i];
				if(partieVersionComparant.endsWith("Dev"))
				{
					partieVersionComparant = partieVersionComparant.substring(0, (partieVersionComparant.length() - 3));
				}
				if(partieVersionComparant.endsWith("Beta"))
				{
					partieVersionComparant = partieVersionComparant.substring(0, (partieVersionComparant.length() - 4));
				}

				numeroVersionComparant = Integer.parseInt(partieVersionComparant);
			}

			// Si l'élément en cours de la version comparée est inférieur au
			// comparant, alors le comparant est plus récent
			if(numeroVersionComparee < numeroVersionComparant)
			{
				return true;
			}
			else if(numeroVersionComparee == numeroVersionComparant)
			{
				if(i != (tableauVersionComparee.length - 1))
				{
					continue;
				}
				else
				{
					return false;
				}
			}
			// Si l'élément en cours de la version comparée est supérieur au comparant, alors le comparant est plus vieux
			else
			{
				return false;
			}
		}

		return false;
	}

	/**
	 * Télécharge la nouvelle version de l'application.
	 */
	public void getDerniereVersion()
	{
		// Logger
		logger.debug("Récupération de la dernière version.");

		this.threadTelechargement = new ThreadTelechargement();
		this.threadTelechargement.start();
	}

	/**
	 * Thread du téléchargement.
	 * 
	 * @author PAPAYA Alexandre
	 * @category Thread
	 * @version 1.0
	 */
	public class ThreadTelechargement extends Thread
	{
		/**
		 * Téléchargeur.
		 */
		private ATelechargeur telechargeur;

		/**
		 * Enregistre le télécahrgeur dans le Thread.
		 * 
		 * @param telechargeur - Téléchargeur du fichier.
		 * @category Accesseur
		 */
		public void setTelechargeur(ATelechargeur telechargeur)
		{
			this.telechargeur = telechargeur;
		}

		/**
		 * Renvoie le téléchargeur enregistré dans le Thread.
		 * 
		 * @return Téléchargeur du fichier.
		 * @category Accesseur
		 */
		public ATelechargeur getTelechargeur()
		{
			return this.telechargeur;
		}

		@Override
		@SuppressWarnings("unchecked")
		public void run()
		{
			try
			{
				// Lancement de l'évenement
				ObservateurUpdate[] observateurs = ModeleUpdateur.this.listeObservateurs.getListeners(ObservateurUpdate.class);
				for(ObservateurUpdate observateur : observateurs)
				{
					observateur.changementAction("Génération de la liste des fichiers à télécharger");
				}

				Element racine = ModeleUpdateur.this.fichierXML.getRootElement();

				// Création des dossiers
				ModeleUpdateur.this.dossierUpdateur.mkdir();
				new File(ModeleUpdateur.this.dossierUpdateur.getPath() + File.separator + "archives").mkdir();
				new File(ModeleUpdateur.this.dossierUpdateur.getPath() + File.separator + "fichiers").mkdir();

				// Dernière version disponible
				String derniereVersion = racine.getChild("derniereVersion").getChildText("numero");

				/* Génération de la liste des fichier à télécharger */
				ArrayList<HashMap<String, String>> listeZip = new ArrayList<HashMap<String, String>>();
				List listeVersions = racine.getChild("versions").getChildren("version");
				Iterator iteratorListeVersions = listeVersions.iterator();
				System.out.println(listeVersions.size());
				// Boucle des versions du fichier XML
				while(iteratorListeVersions.hasNext())
				{
					Element version = (Element) iteratorListeVersions.next();
					
					System.out.println(version.getChildText("numero"));

					// Si la version en cours de boucle est plus récente que
					// celle-ci
					if(ModeleUpdateur.this.comparerVerisons(Main.getVersion(), version.getChildText("numero")))
					{
						System.out.println("OK :" + version.getChildText("numero"));
						List listePatchs = version.getChild("patchs").getChildren("patch");
						Iterator iteratorListePatchs = listePatchs.iterator();
						// Boucle des patchs
						while(iteratorListePatchs.hasNext())
						{
							Element patch = (Element) iteratorListePatchs.next();
							
							System.out.println(patch.getChildText("nom"));
							
							// Si le patch correspond à l'environnement de
							// l'utilisateur
							if(((patch.getChildText("plateforme").equals(AUtil.getOS().getAbreviation()) || patch.getChildText("plateforme").equals("all")) && (patch.getChildText("architecture").equals(AUtil.getArchitecture()))) || patch.getChildText("architecture").equals("all"))
							{
								// On rentre les informations dans la HashMap
								HashMap<String, String> hashMapPatch = new HashMap<String, String>();
								hashMapPatch.put("nom", patch.getChildText("nom"));
								hashMapPatch.put("source", patch.getChildText("source"));
								listeZip.add(hashMapPatch);

								/* On télécharge le fichier */
								
								URL url = new URL(ModeleUpdateur.this.cheminServeur + hashMapPatch.get("source"));
								this.telechargeur = new ATelechargeur(url, ModeleUpdateur.this.dossierUpdateur.getPath() + File.separator + "archives" + File.separator);

								// Logger
								logger.debug("Téléchargement du fichier " + url.toString() + ".");
								
								// Lancement de l'évenement
								for(ObservateurUpdate observateur : observateurs)
								{
									observateur.changementAction("Téléchargement de : <strong>" + hashMapPatch.get("nom") + "</strong>");
									observateur.changementFichier(this.telechargeur.getNomFichier(url));
								}

								this.telechargeur.addObservateur(ModeleUpdateur.this);
								this.telechargeur.telecharger();
								while((this.telechargeur.getEtat() == ATelechargeur.TELECHARGE) || (this.telechargeur.getEtat() == ATelechargeur.EN_PAUSE))
								{
									try
									{
										Thread.sleep(100);
									}
									catch(InterruptedException e)
									{
										e.printStackTrace();
									}
								}

								if(this.telechargeur.getEtat() != ATelechargeur.COMPLET)
								{
									// Logger
									logger.error("Erreur lors du téléchargement des mises à jour.");
									
									this.interrupt();
									return;
								}
							}
						}
					}
					else
					{
						break;
					}
				}

				// Boucle inversée de decompression des zips
				for(int i = (listeZip.size() - 1); i >= 0; i--)
				{
					HashMap<String, String> hashMapPatch = listeZip.get(i);
					
					// Logger
					logger.debug("Extraction du fichier " + hashMapPatch.get("nom") + ".");

					// Lancement de l'évenement
					for(ObservateurUpdate observateur : observateurs)
					{
						observateur.changementAction("Extraction de : <strong>" + hashMapPatch.get("nom") + "</strong>");
						observateur.changementVitesse(0);
					}

					// Génération du nom du fichier zip à partir du chemin sur
					// le serveur
					String[] sourceSplitee = hashMapPatch.get("source").split("/");
					String nomZip = sourceSplitee[(sourceSplitee.length - 1)];

					ZipInputStream zipInput = null;
					try
					{
						/* Extraction des fichiers */
						FileInputStream input = new FileInputStream(ModeleUpdateur.this.dossierUpdateur.getPath() + File.separator + "archives" + File.separator + nomZip);
						BufferedInputStream buffInput = new BufferedInputStream(input, 1024);
						zipInput = new ZipInputStream(buffInput);
						ZipEntry entry;
						// Boucle d'extraction fichier par fichier
						while((entry = zipInput.getNextEntry()) != null)
						{
							// Mise en forme du chemin du fichier en cours pour
							// le rendre compatible avec l'environnement de
							// l'utilisateur
							String cheminEntry = entry.getName().replace("/", File.separator);

							// Lancement de l'evenement
							for(ObservateurUpdate observateur : observateurs)
							{
								observateur.changementFichier(cheminEntry);
							}

							// Si le fichier en cours est en fait un dossier
							File fichierEntry = new File(ModeleUpdateur.this.dossierUpdateur.getPath() + File.separator + cheminEntry);
							if(cheminEntry.endsWith(File.separator))
							{
								fichierEntry.mkdirs();
								continue;
							}

							// Si le ficher a extraire est un script sql
							if(entry.getName().endsWith(".sql"))
							{
								BufferedReader reader = null;
								RandomAccessFile writer = null;
								try
								{
									// Création du dossier script
									File fichier = new File(ModeleUpdateur.this.dossierUpdateur.getPath() + File.separator + "scripts" + File.separator + "bdd_sauvegardes.sql");
									File dossier = new File(fichier.getParent());
									dossier.mkdirs();

									// Ecriture ligne par ligne du script sql
									// dans un ficher global
									InputStream inputSteam = zipInput;
									reader = new BufferedReader(new InputStreamReader(inputSteam));
									writer = new RandomAccessFile(fichier, "rw");
									writer.seek(writer.length());
									String ligne;
									String sautLigne = System.getProperty("line.separator");
									while((ligne = reader.readLine()) != null)
									{
										writer.write(ligne.getBytes());
										writer.write(sautLigne.getBytes());
									}
								}
								catch(IOException e)
								{
									// Logger
									logger.error(e.getMessage());

									e.printStackTrace();
								}
								finally
								{
									// Fermeture des connexions
									try
									{
										writer.close();
									}
									catch(IOException e)
									{
										// Logger
										logger.error(e.getMessage());
										
										e.printStackTrace();
									}
									/*
									 * try { reader.close(); } catch(IOException e) { e.printStackTrace(); }
									 */
								}
							}
							// Si c'est un fichier normal à remplacer
							else
							{
								BufferedOutputStream buffOutput = null;
								try
								{
									// Logger
									logger.debug("Ecrasement du lanceur.");
									
									// Si c'est le lanceur, on remplace
									// directement le fichier
									File fichier;
									if(entry.getName().equals("fichiers/JDofusCalc.jar"))
									{
										fichier = new File("JDofusCalc.jar");
									}
									else
									{
										fichier = new File(ModeleUpdateur.this.dossierUpdateur.getPath() + File.separator + cheminEntry);
										File dossier = new File(fichier.getParent());
										dossier.mkdirs();
									}

									// Ecriture du fichier
									FileOutputStream output = new FileOutputStream(fichier);
									buffOutput = new BufferedOutputStream(output, 1024);
									byte[] buffer = new byte[1024];
									int byteCourant;
									while((byteCourant = zipInput.read(buffer, 0, 1024)) != -1)
									{
										buffOutput.write(buffer, 0, byteCourant);
									}
									buffOutput.flush();
								}
								catch(IOException e)
								{
									// Logger
									logger.error(e.getMessage());
									
									e.printStackTrace();
								}
								finally
								{
									// Fermeture des connexions
									try
									{
										buffOutput.close();
									}
									catch(IOException e)
									{
										// Logger
										logger.error(e.getMessage());
										
										e.printStackTrace();
									}
								}
							}
						}
					}
					catch(IOException e)
					{
						// Logger
						logger.error(e.getMessage());
						
						e.printStackTrace();
					}
					finally
					{
						// Fermeture des connexions
						try
						{
							zipInput.close();
						}
						catch(IOException e)
						{
							// Logger
							logger.error(e.getMessage());
							
							e.printStackTrace();
						}
					}
				}

				// Enregistrement du fichier properties temporaire
				Properties props = new Properties();
				props.load(new FileInputStream(Main.FICHIER_PROPERTIES));
				props.setProperty("JDofusCalc.version", derniereVersion);
				props.store(new FileOutputStream(ModeleUpdateur.this.dossierUpdateur.getPath() + File.separator + Main.FICHIER_PROPERTIES), "Properties de JDofusCalc. Ne pas modifier.");

				// Logger
				logger.debug("Mise à jour terminée.");
				
				// Lancement de l'évenement
				for(ObservateurUpdate observateur : observateurs)
				{
					observateur.finTelechargement();
				}
			}
			catch(FileNotFoundException e)
			{
				// Logger
				logger.error(e.getMessage());
				
				e.printStackTrace();
				ModeleUpdateur.this.supprimerDossierUpdateur();
			}
			catch(SocketException e)
			{
				// Logger
				logger.error(e.getMessage());
				
				e.printStackTrace();
				ModeleUpdateur.this.supprimerDossierUpdateur();
			}
			catch(IOException e)
			{
				// Logger
				logger.error(e.getMessage());
				
				e.printStackTrace();
				ModeleUpdateur.this.supprimerDossierUpdateur();
			}
		}
	}

	/**
	 * Supprime le dossier updateur.
	 * 
	 * @return Retourne {@code true} si l'action a réussi, sinon {@code false}.
	 */
	public boolean supprimerDossierUpdateur()
	{
		return AFile.supprimerDossier(this.dossierUpdateur);
	}
	
	/*
	 * Héritages
	 */
	
	public void changementAvancement(float avancement)
	{
		// Lancement de l'evenement
		ObservateurUpdate[] observateurs = this.listeObservateurs.getListeners(ObservateurUpdate.class);
		for(ObservateurUpdate observateur : observateurs)
		{
			observateur.changementAvancement(avancement);
		}
	}

	public void changementEtat(int etat)
	{
		// TODO
	}

	public void changementVitesse(float vitesse)
	{
		// Lancement de l'evenement
		ObservateurUpdate[] observateurs = this.listeObservateurs.getListeners(ObservateurUpdate.class);
		for(ObservateurUpdate observateur : observateurs)
		{
			observateur.changementVitesse(vitesse);
		}
	}

	/*
	 * Accesseurs
	 */

	/**
	 * @return threadConstructeur
	 * @category Accesseur
	 */
	public final ThreadConstructeur getThreadConstructeur()
	{
		return this.threadConstructeur;
	}

	/**
	 * @return threadTelechargement
	 * @category Accesseur
	 */
	public final ThreadTelechargement getThreadTelechargement()
	{
		return this.threadTelechargement;
	}
}