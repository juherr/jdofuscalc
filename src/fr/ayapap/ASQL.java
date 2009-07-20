/**
 * Fichier : ASQL.java
 * Auteur : PAPAYA Alexandre
 * 
 * Copyright Alexandre, 2009, tous droits réservés.
 */

package fr.ayapap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * Classe de gestions des connexions et requêtes à une base de données de type SQL.
 * 
 * @author PAPAYA Alexandre
 * @version 1.0
 * @category SQL
 */
public class ASQL
{
	/*
	 * Variables d'instances
	 */
	
	/* Paramètres de connexion */
	
	/**
	 * Pilote JDBC du SGBD.
	 */
	private String pilote;

	/**
	 * Nom d'utilisateur.
	 */
	private String utilisateur;
	/**
	 * Mot de passe.
	 */
	private String mdp;
	/**
	 * URL de la base de données.
	 */
	private String url;
	/**
	 * Nom de la base de données.
	 */
	private String nomBdd;

	/* Autres */
	
	/**
	 * Logger.
	 */
	private final static Logger logger = Logger.getLogger("fr.ayapap.ASQL");
	
	/**
	 * Connexion à la base de données.
	 */
	private Connection connexion;
	
	/**
	 * Nombre de requêtes effectuées par l'instance.
	 */
	private int nbRequetes = 0;
	
	/*
	 * Constructeurs / Destructeur
	 */

	/**
	 * Construit une nouvelle connexion à une base de données.
	 * 
	 * @param pilote - Pilote du SGBD.
	 * @param url - URL de la base de données.
	 * @param nom - Nom de la base de données.
	 * @param utilisateur - Utilisateur de la base de données.
	 * @param mdp - Mot de passe de l'utilisateur.
	 * @category Constructeur
	 */
	public ASQL(String pilote, String url, String nomBdd, String utilisateur, String mdp)
	{
		DOMConfigurator.configure("log4j.xml");
		
		this.pilote = pilote;
		this.utilisateur = utilisateur;
		this.mdp = mdp;
		this.url = url;
		this.nomBdd = nomBdd;
		
		ASQL.logger.trace("Création d'une nouvelle instance. Paramètres : Pilote : '" + pilote + "', URL : '" + url + "', Nom : '" + nomBdd + "', Utilisateur : '" + utilisateur + "', MDP : '" + mdp + "'.");
	}
	
	/**
	 * Le destructeur de l'instance.
	 * 
	 * @category Destructeur
	 */
	@Override
	public void finalize()
	{
		ASQL.logger.trace("Destruction d'une instance ASQL (" + this.nomBdd + ").");
		this.fermeture();
	}
	
	/*
	 * Méthodes
	 */

	/**
	 * Connecte l'instance à la base de données.
	 */
	private void connexion()
	{
		ASQL.logger.debug("Tentative de connexion à la base de données '" + this.nomBdd + "'.");
		
		try
		{
			// Enregistrement du driver
			Class.forName(this.pilote).newInstance();

			// Lancement de la connexion
			this.connexion = DriverManager.getConnection("jdbc:" + this.url, this.utilisateur, this.mdp);
			
			ASQL.logger.debug("Connexion à la base de données '" + this.nomBdd + "' effectuée.");
		}
		catch(InstantiationException exception)
		{
			exception.printStackTrace();
			ASQL.logger.error(exception.getMessage());
		}
		catch(IllegalAccessException exception)
		{
			exception.printStackTrace();
			ASQL.logger.error(exception.getMessage());
		}
		catch(ClassNotFoundException exception)
		{
			SQLException sqlException = new SQLException("Driver " + this.pilote + " introuvable");
			sqlException.setStackTrace(exception.getStackTrace());
			ASQL.erreur(sqlException);
		}
		catch(SQLException exception)
		{
			ASQL.erreur(exception);
		}
	}
	
	/**
	 * Ferme la connexion à la base de données.
	 */
	public void fermeture()
	{
		ASQL.logger.trace("Fermeture de la connexion à " + this.nomBdd + ".");

		if(this.connexion != null)
		{
			try
			{
				this.connexion.close();
				this.connexion = null;
			}
			catch(SQLException exception)
			{
				ASQL.erreur(exception);
			}
		}
	}


	/**
	 * Execute la requête SQL {@code requete}.
	 * 
	 * @param requete - Requête SQL.
	 * @param getGeneratedKeys - Boolean qui indique si les clefs auto-générées doivent être retournée.
	 * @return Un {@link ASQLRequete} des resulats et des clefs auto-générées si demandées.
	 */
	public ASQLRequete requete(String requete, boolean getGeneratedKeys)
	{
		ASQL.logger.debug("Execution de la requête SQL : \"" + requete + "\"");
		
		// Connexion à la base de données si c'est pas déjà fait
		if(this.connexion == null)
		{
			this.connexion();
		}

		/*
		 * Execution de la requête
		 */
		try
		{
			ASQLRequete retour = new ASQLRequete();

			Statement statement = this.connexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			// Si on demande les clefs auto-générées
			if(getGeneratedKeys == true)
			{
				statement.executeUpdate(requete, Statement.RETURN_GENERATED_KEYS);

				retour.setResultats(statement.getResultSet());
				retour.setClefs(statement.getGeneratedKeys());
			}
			else
			{
				if(statement.execute(requete))
				{
					retour.setResultats(statement.getResultSet());
				}
			}

			this.nbRequetes++;
			return retour;
		}
		catch(SQLException exception)
		{
			ASQL.erreur(exception);
			return null;
		}
	}

	/**
	 * Execute la requête SQL {@code requete}.
	 * 
	 * @param requete - Requête SQL.
	 * @return Un {@link ASQLRequete} des resulats .
	 */
	public ASQLRequete requete(String requete)
	{
		return this.requete(requete, false);
	}

	/**
	 * Compile et execute la requête SQL {@code requete}.
	 * 
	 * @param requete - Requête SQL à compiler.
	 * @param parametres - Tableau des paramètres de la requête.
	 * @return Un {@link ASQLRequete} des resulats.
	 */
	public ASQLRequete requetePreparee(String requete, Object[] parametres)
	{
		ASQL.logger.debug("Execution de la requête préparée SQL : \"" + requete + "\"");
		ASQL.logger.trace("Paramètres : " + parametres.toString());
		
		// Connexion à la base de données si c'est pas déjà fait
		if(this.connexion == null)
		{
			this.connexion();
		}

		/*
		 * Execution de la requete
		 */
		try
		{
			ASQLRequete retour = new ASQLRequete();

			PreparedStatement statement = this.connexion.prepareStatement(requete, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			for(int i = 0; i < parametres.length; i++)
			{
				statement.setObject((i + 1), parametres[i]);
			}

			if(statement.execute())
			{
				retour.setResultats(statement.getResultSet());
			}

			this.nbRequetes++;
			return retour;
		}
		catch(SQLException exception)
		{
			ASQL.erreur(exception);
			return null;
		}
	}

	/**
	 * Renvoie le nombre de resultats d'un ResultSet.
	 * 
	 * @param resultats - Le {@link ResultSet}.
	 * @return Le nombre de resultats.
	 */
	public final static int getRows(ResultSet resultats)
	{
		int nbLignes = 0;

		try
		{
			// Positionne le curseur à la fin du ResultSet
			resultats.last();
			// Enregistre l'index du dernier resultat
			nbLignes = resultats.getRow();
			// Positionne le cursuer au debut du ResultSet
			resultats.beforeFirst();
			
			ASQL.logger.trace("Retour de la fonction ASQL.getRows() : " + nbLignes);

			return nbLignes;
		}
		catch(SQLException exception)
		{
			ASQL.erreur(exception);
			return -1;
		}
	}

	/**
	 * Gère les exceptions de type SQL levées par une classe.
	 * 
	 * @param exception - L'exception {@link SQLException}.
	 */
	public final static void erreur(SQLException exception)
	{
		String message = "Erreur SQL :\n" + "[" + exception.getErrorCode() + "] " + exception.getMessage();
		ASQL.logger.error(message);
		exception.printStackTrace();
	}
	
	/**
	 * Sécurise la chaine {@code chaine} pour l'enregistrer en base de données.
	 * 
	 * @param chaine - La chaine à sécuriser.
	 * @return La chaine sécurisée.
	 */
	public final static String securise(String chaine)
	{
		return chaine.replace("'", "''");
	}
}