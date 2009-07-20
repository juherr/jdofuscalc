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

package org.JDofusCalc.dofus.autres;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map.Entry;

import fr.ayapap.ASQL;
import fr.ayapap.ASQLRequete;

/**
 * Classe représentant les effets d'un objet.
 * 
 * @author PAPAYA Alexandre
 * @category Dofus
 * @version 1.0
 */
public class Effets
{
	/*
	 * Constantes / Enums
	 */
	
	/**
	 * Enum des types des effets du jeu.
	 * 
	 * @author PAPAYA Alexandre
	 * @category Flags
	 * @version 1.0
	 */
	public enum FlagsTypesEffets
	{
		/*
		 * Elements
		 */
		
		Vie("Vie", "VIE"),
		Pa("Pa", "PA"),
		Pm("Pm", "PM"),
		Po("Po", "PO"),
		Initiative("Initiative", "INITIATIVE"),
		Prospection("Prospection", "PP"),
		Vitalite("Vitalité", "VITALITE"),
		Sagesse("Sagesse", "SAGESSE"),
		Force("Force", "FORCE"),
		Intelligence("Intelligence", "INTELLIGENCE"),
		Chance("Chance", "CHANCE"),
		Agilite("Agilité", "AGILITE"),
		Dommages("Dommages", "DOMMAGES"),
		DommagesMagiques("Dommages magiques", null),
		DommagesPhysiques("Dommages physiques", null),
		PourcentagesDommages("% Dommages", "POURCENTAGES_DOMMAGES"),
		DommagesPieges("Pièges", "PIEGES"),
		PourcentagesDommagesPieges("% Pièges", "POURCENTAGES_PIEGES"),
		CoupsCritiques("Coups critiques", "CC"),
		EchecsCritiques("Echecs critiques", "EC"),
		Soins("Soins", "SOINS"),
		CreaturesInvocables("Créatures invocables", "CREATURES_INVOCABLES"),
		Pods("Pods", "PODS"),
		Renvois("Renvois", "RENVOIS"),
		EsquivePa("Esquive PA", null),
		EsquivePm("Esquive PM", null),
		ResistancesMagiques("Résistances magiques", "RESISTANCE_MAGIQUE"),
		ResistancesPhysiques("Résistances physiques", "RESISTANCE_PHYSIQUE"),
		ResistancesNeutre("Résistances neutre", "RESISTANCE_NEUTRE"),
		ResistancesTerre("Résistances terre", "RESISTANCE_TERRE"),
		ResistancesFeu("Résistances feu", "RESISTANCE_FEU"),
		ResistancesEau("Résistances eau", "RESISTANCE_EAU"),
		ResistancesAir("Résistances air", "RESISTANCE_AIR"),
		PourcentagesResistancesNeutre("% Résistances neutre", "POURCENTAGES_RESISTANCE_NEUTRE"),
		PourcentagesResistancesTerre("% Résistances terre", "POURCENTAGES_RESISTANCE_TERRE"),
		PourcentagesResistancesFeu("% Résistances feu", "POURCENTAGES_RESISTANCE_FEU"),
		PourcentagesResistancesEau("% Résistances eau", "POURCENTAGES_RESISTANCE_EAU"),
		PourcentagesResistancesAir("% Résistances air", "POURCENTAGES_RESISTANCE_AIR"),
		ResistancesNeutrePvp("Résistances neutre pvp", "RESISTANCE_NEUTRE_COMBATTANTS"),
		ResistancesTerrePvp("Résistances terre pvp", "RESISTANCE_TERRE_COMBATTANTS"),
		ResistancesFeuPvp("Résistances feu pvp", "RESISTANCE_FEU_COMBATTANTS"),
		ResistancesEauPvp("Résistances eau pvp", "RESISTANCE_EAU_COMBATTANTS"),
		ResistancesAirPvp("Résistances air pvp", "RESISTANCE_AIR_COMBATTANTS"),
		PourcentagesResistancesNeutrePvp("% Résistances neutre pvp", "POURCENTAGES_RESISTANCE_NEUTRE_COMBATTANTS"),
		PourcentagesResistancesTerrePvp("% Résistances terre pvp", "POURCENTAGES_RESISTANCE_TERRE_COMBATTANTS"),
		PourcentagesResistancesFeuPvp("% Résistances feu pvp", "POURCENTAGES_RESISTANCE_FEU_COMBATTANTS"),
		PourcentagesResistancesEauPvp("% Résistances eau pvp", "POURCENTAGES_RESISTANCE_EAU_COMBATTANTS"),
		PourcentagesResistancesAirPvp("% Résistances air pvp", "POURCENTAGES_RESISTANCE_AIR_COMBATTANTS");
				
		/*
		 * Variables d'intances
		 */
		
		/**
		 * Nom du flag.
		 */
		private String nom;
		
		/**
		 * Nom du champ du flag en base de données.
		 */
		private String champ;
		
		/*
		 * Constructeurs / Destructeur
		 */

		/**
		 * Construit un nouvel enum.
		 * 
		 * @param nom - Nom du flag.
		 * @param champ - Nom du champ du flag en base de données.
		 * @category Constructeur
		 */
		private FlagsTypesEffets(String nom, String champ)
		{
			this.nom = nom;
			this.champ = champ;
		}
		
		/*
		 * Méthodes statiques
		 */
		
		/**
		 * Associe une chaine à un flag.
		 * 
		 * @param chaine - La chaine.
		 * @return Retoune le flag correspondant à la chaine ou {@code null}.
		 */
		public final static FlagsTypesEffets getFlag(String chaine)
		{
			for(FlagsTypesEffets flag : FlagsTypesEffets.values())
			{
				if(flag.getNom().toLowerCase().equals(chaine.toLowerCase()))
					return flag;
			}
			
			System.err.println("Effet " + chaine + " introuvable.");
			return null;
		}

		/**
		 * Associe un effet à un son équivalent pvp.
		 * 
		 * @param chaine - La chaine.
		 * @return Retoune le flag correspondant à la chaine ou {@code null}.
		 */
		public final static FlagsTypesEffets getEquivalentPvp(FlagsTypesEffets flag)
		{
			if(flag == FlagsTypesEffets.ResistancesNeutre)
				return FlagsTypesEffets.ResistancesNeutrePvp;
			else if(flag == FlagsTypesEffets.ResistancesTerre)
				return FlagsTypesEffets.ResistancesTerrePvp;
			else if(flag == FlagsTypesEffets.ResistancesFeu)
				return FlagsTypesEffets.ResistancesFeuPvp;
			else if(flag == FlagsTypesEffets.ResistancesEau)
				return FlagsTypesEffets.ResistancesEauPvp;
			else if(flag == FlagsTypesEffets.ResistancesAir)
				return FlagsTypesEffets.ResistancesAirPvp;
			else if(flag == FlagsTypesEffets.PourcentagesResistancesNeutre)
				return FlagsTypesEffets.PourcentagesResistancesNeutrePvp;
			else if(flag == FlagsTypesEffets.PourcentagesResistancesTerre)
				return FlagsTypesEffets.PourcentagesResistancesTerrePvp;
			else if(flag == FlagsTypesEffets.PourcentagesResistancesFeu)
				return FlagsTypesEffets.PourcentagesResistancesFeuPvp;
			else if(flag == FlagsTypesEffets.PourcentagesResistancesEau)
				return FlagsTypesEffets.PourcentagesResistancesEauPvp;
			else if(flag == FlagsTypesEffets.PourcentagesResistancesAir)
				return FlagsTypesEffets.PourcentagesResistancesAirPvp;
			else
				return null;
		}
		
		
		/*
		 * Accesseurs
		 */

		/**
		 * Renvoie le nom du flag.
		 * 
		 * @return Le nom du flag.
		 * @category Accesseur
		 */
		public final String getNom()
		{
			return this.nom;
		}
		
		/**
		 * Renvoie le nom du champ du flag en base de données.
		 * 
		 * @return Le nom du champ du flag en base de données.
		 * @category Accesseur
		 */
		public final String getChamp()
		{
			return this.champ;
		}
	}
	
	
	/*
	 * Variables d'instances
	 */
	
	/**
	 * Id des effets.
	 */
	private int id = 0;

	/**
	 * Liste des effets.
	 */
	private HashMap<FlagsTypesEffets, Double> effets = new HashMap<FlagsTypesEffets, Double>(); 

	/*
	 * Constructeurs / Destructeur
	 */

	/**
	 * Construit de nouveaux effets.
	 * 
	 * @category Constructeur
	 */
	public Effets()
	{
		for(FlagsTypesEffets flag : FlagsTypesEffets.values())
		{
			this.effets.put(flag, 0.0);
		}
	}
	
	/*
	 * Méthodes héritées
	 */

	@Override
	public String toString()
	{
		String retour = "Effets de l'objet :\n";
		for(Entry<FlagsTypesEffets, Double> entry : this.effets.entrySet())
		{
			FlagsTypesEffets clef = entry.getKey();
			double valeur = entry.getValue();

			if(valeur != 0)
			{
				retour += clef.getNom() + " : " + valeur + "\n";
			}
		}

		return retour;
	}
	
	/*
	 * Méthodes de paramètrage de l'instance
	 */

	/**
	 * Sauvegarde l'instance de l'objet dans une base de données.
	 * 
	 * @param bdd - Connexion à la base de données.
	 * @param table - Nom de la table pointant vers cet objet.
	 * @param champ - Nom du champ pointant vers cet objet.
	 * @return Retourne l'id de objet.
	 */
	public int sauvegarder(ASQL bdd, String table, String champ)
	{
		try
		{
			if(this.id == 0)
			{
				String requete = "INSERT INTO EFFETS";
				String nomChamps = "(ID, TABLE, CHAMP, ";
				String valeurChamps = "VALUES(null, '" + table + "', '" + champ + "', ";
				for(FlagsTypesEffets typeEffet : FlagsTypesEffets.values())
				{
					String nomChamp = typeEffet.getChamp();
					if(nomChamp != null)
					{
						nomChamps+= nomChamp + ", ";
						valeurChamps+= this.getDouble(typeEffet) + ", ";
					}
				}
				nomChamps = nomChamps.substring(0, (nomChamps.length() - 2));
				nomChamps+= ")";
				valeurChamps = valeurChamps.substring(0, (valeurChamps.length() - 2));
				valeurChamps+= ");";
				requete+= nomChamps + " " + valeurChamps;
				
				ASQLRequete req = bdd.requete(requete, true);
				req.getClefs().next();
				this.id = (int) req.getClefs().getLong(1);
			}
			else
			{
				String requete = "UPDATE EFFETS SET ";
				for(FlagsTypesEffets typeEffet : FlagsTypesEffets.values())
				{
					String nomChamp = typeEffet.getChamp();
					if(nomChamp != null)
						requete+= nomChamp + "=" + this.getDouble(typeEffet) + ", ";
				}
				requete = requete.substring(0, (requete.length() - 2));
				requete+= "WHERE ID=" + this.id;
				
				bdd.requete(requete);
			}

			return this.id;
		}
		catch(SQLException exception)
		{
			ASQL.erreur(exception);
			return -1;
		}
	}
	
	/**
	 * Charge l'objet à partir d'un ResultSet.
	 * 
	 * @param res - ResultSet de la requête avec jointure.
	 * @param prefix - Prefix de la table des champs de la jointure.
	 * @return Retourne l'objet.
	 */
	public Effets charger(ResultSet res, String prefix)
	{
		try
		{
			this.id = res.getInt(prefix + "_" + "ID");
			for(FlagsTypesEffets flag : FlagsTypesEffets.values())
			{
				if(flag.getChamp() != null)
					this.effets.put(flag, res.getDouble(prefix + "_" + flag.getChamp()));
			}
			
			return this;
		}
		catch(SQLException exception)
		{
			ASQL.erreur(exception);
			return null;
		}
	}

	/*
	 * Méthodes d'opérations sur l'objet
	 */
	
	/**
	 * Ajoute tous les effets de l'objet {@code effets} dans cette instance.
	 * 
	 * @param effets - Classe {@link Effets} à ajouter.
	 */
	public final void add(Effets effets)
	{
		for(Entry<FlagsTypesEffets, Double> entry : this.effets.entrySet())
		{
			this.effets.put(entry.getKey(), entry.getValue() + effets.getDouble(entry.getKey()));
		}
	}
	
	/*
	 * Accesseurs
	 */

	/**
	 * Renvoie la valeur entière de l'effet {@code clef}.
	 * 
	 * @param clef - Flag de l'effet.
	 * @return La valeur entière de l'effet.
	 * @category Accesseur
	 */
	public final int getInt(FlagsTypesEffets clef)
	{
		return (new Double(this.effets.get(clef))).intValue();
	}

	/**
	 * Renvoie la valeur décimale de l'effet {@code clef}.
	 * 
	 * @param clef - Flag de l'effet.
	 * @return La valeur décimale de l'effet.
	 * @category Accesseur
	 */
	public final Double getDouble(FlagsTypesEffets clef)
	{
		return this.effets.get(clef);
	}

	/**
	 * Définit la valeur entière {@code valeur} de de l'effet {@code clef}.
	 * 
	 * @param clef - Flag de l'effet.
	 * @param valeur - Valeur entière de l'effet.
	 * @category Accesseur
	 */
	public final void setInt(FlagsTypesEffets clef, int valeur)
	{
		this.effets.put(clef, (double) valeur);
	}

	/**
	 * Définit la valeur décimale {@code valeur} de de l'effet {@code clef}.
	 * 
	 * @param clef - Flag de l'effet.
	 * @param valeur - Valeur décimale de l'effet.
	 * @category Accesseur
	 */
	public final void setDouble(FlagsTypesEffets clef, double valeur)
	{
		this.effets.put(clef, valeur);
	}

	/**
	 * Renvoie la {@code HashMap} contenant toutes les valeurs.
	 * 
	 * @return La {@code HashMap} des valeurs.
	 * @category Accesseur
	 */
	public final HashMap<FlagsTypesEffets, Double> getHashMap()
	{
		return this.effets;
	}
}