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

import fr.ayapap.ASQL;
import fr.ayapap.ASQLRequete;

/**
 * Classe représentant les dégâts générés par un sort ou par une arme.
 * 
 * @author PAPAYA Alexandre
 * @category Dofus
 * @version 1.0
 */
public class Degats
{
	/*
	 * Constantes / Enums
	 */
	
	/**
	 * Enum des types des dégâts du jeu.
	 * 
	 * @author PAPAYA Alexandre
	 * @category Flags
	 * @version 1.0
	 */
	public enum FlagsTypesDegats
	{
		/*
		 * Elements
		 */
		
		DegatsNeutreMin("Dégâts neutre minimums", "DEGATS_NEUTRE_MINI"),
		DegatsTerreMin("Dégâts terre minimums", "DEGATS_TERRE_MINI"),
		DegatsFeuMin("Dégâts feu minimums", "DEGATS_FEU_MINI"),
		DegatsEauMin("Dégâts eau minimums", "DEGATS_EAU_MINI"),
		DegatsAirMin("Dégâts air minimums", "DEGATS_AIR_MINI"),
		DegatsNeutreMax("Dégâts neutre maximums", "DEGATS_NEUTRE_MAXI"),
		DegatsTerreMax("Dégâts terre maximums", "DEGATS_TERRE_MAXI"),
		DegatsFeuMax("Dégâts feu maximums", "DEGATS_FEU_MAXI"),
		DegatsEauMax("Dégâts eau maximums", "DEGATS_EAU_MAXI"),
		DegatsAirMax("Dégâts air maximums", "DEGATS_AIR_MAXI"),
		VoleNeutreMin("Vols de vie neutre minimums", "VOLE_NEUTRE_MINI"),
		VoleTerreMin("Vols de vie terre minimums", "VOLE_TERRE_MINI"),
		VoleFeuMin("Vols de vie feu minimums", "VOLE_FEU_MINI"),
		VoleEauMin("Vols de vie eau minimums", "VOLE_EAU_MINI"),
		VoleAirMin("Vols de vie air minimums", "VOLE_AIR_MINI"),
		VoleNeutreMax("Vols de vie neutre maximums", "VOLE_NEUTRE_MAXI"),
		VoleTerreMax("Vols de vie terre maximums", "VOLE_TERRE_MAXI"),
		VoleFeuMax("Vols de vie feu maximums", "VOLE_FEU_MAXI"),
		VoleEauMax("Vols de vie eau maximums", "VOLE_EAU_MAXI"),
		VoleAirMax("Vols de vie air maximums", "VOLE_AIR_MAXI"),
		SoinsMin("Soins minimums", "SOINS_MINI"),
		SoinsMax("Soins maximums", "SOINS_MAXI");
		
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
		private FlagsTypesDegats(String nom, String champ)
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
		public final static FlagsTypesDegats getFlag(String chaine)
		{
			for(FlagsTypesDegats flag : FlagsTypesDegats.values())
			{
				if(flag.getNom().equals(chaine))
					return flag;
			}
			
			System.err.println("Flag \"" + chaine + "\" introuvable.");
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
	 * Id des dégâts.
	 */
	private int id = 0;

	/**
	 * Les Dégâts.
	 */
	protected HashMap<FlagsTypesDegats, Integer> degats = new HashMap<FlagsTypesDegats, Integer>();
	
	/*
	 * Constructeurs / Destructeur
	 */

	/**
	 * Construit de nouveaux dégâts.
	 * 
	 * @category Constructeur
	 */
	public Degats()
	{
		for(FlagsTypesDegats flag : FlagsTypesDegats.values())
		{
			this.degats.put(flag, 0);
		}
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
				ASQLRequete req = bdd.requete("INSERT INTO DEGATS VALUES(null, '" + ASQL.securise(table) + "', '" + ASQL.securise(champ) + "', " + this.degats.get(FlagsTypesDegats.DegatsNeutreMin) + ", " + this.degats.get(FlagsTypesDegats.DegatsNeutreMax) + ", " + this.degats.get(FlagsTypesDegats.DegatsTerreMin) + ", " + this.degats.get(FlagsTypesDegats.DegatsTerreMax) + ", " + this.degats.get(FlagsTypesDegats.DegatsFeuMin) + ", " + this.degats.get(FlagsTypesDegats.DegatsFeuMax) + ", " + this.degats.get(FlagsTypesDegats.DegatsEauMin) + ", " + this.degats.get(FlagsTypesDegats.DegatsEauMax) + ", " + this.degats.get(FlagsTypesDegats.DegatsAirMin) + ", " + this.degats.get(FlagsTypesDegats.DegatsAirMax) + ", " + this.degats.get(FlagsTypesDegats.VoleNeutreMin) + ", " + this.degats.get(FlagsTypesDegats.VoleNeutreMax) + ", " + this.degats.get(FlagsTypesDegats.VoleTerreMin) + ", " + this.degats.get(FlagsTypesDegats.VoleTerreMax) + ", " + this.degats.get(FlagsTypesDegats.VoleFeuMin) + ", " + this.degats.get(FlagsTypesDegats.VoleFeuMax) + ", " + this.degats.get(FlagsTypesDegats.VoleEauMin) + ", " + this.degats.get(FlagsTypesDegats.VoleEauMax) + ", " + this.degats.get(FlagsTypesDegats.VoleAirMin) + ", " + this.degats.get(FlagsTypesDegats.VoleAirMax) + ", " + this.degats.get(FlagsTypesDegats.SoinsMin) + ", " + this.degats.get(FlagsTypesDegats.SoinsMax) + ")", true);
				req.getClefs().next();
				this.id = (int) req.getClefs().getLong(1);
			}
			else
			{
				bdd.requete("UPDATE DEGATS SET DEGATS_NEUTRE_MINI=" + this.degats.get(FlagsTypesDegats.DegatsNeutreMin) + ", DEGATS_NEUTRE_MAXI=" + this.degats.get(FlagsTypesDegats.DegatsNeutreMax) + ", DEGATS_TERRE_MINI=" + this.degats.get(FlagsTypesDegats.DegatsTerreMin) + ", DEGATS_TERRE_MAXI=" + this.degats.get(FlagsTypesDegats.DegatsTerreMax) + ", DEGATS_FEU_MINI=" + this.degats.get(FlagsTypesDegats.DegatsFeuMin) + ", DEGATS_FEU_MAXI=" + this.degats.get(FlagsTypesDegats.DegatsFeuMax) + ", DEGATS_EAU_MINI=" + this.degats.get(FlagsTypesDegats.DegatsEauMin) + ", DEGATS_EAU_MAXI=" + this.degats.get(FlagsTypesDegats.DegatsEauMax) + ", DEGATS_AIR_MINI=" + this.degats.get(FlagsTypesDegats.DegatsAirMin) + ", DEGATS_AIR_MAXI=" + this.degats.get(FlagsTypesDegats.DegatsAirMax) + ", VOLE_NEUTRE_MINI=" + this.degats.get(FlagsTypesDegats.VoleNeutreMin) + ", VOLE_NEUTRE_MAXI=" + this.degats.get(FlagsTypesDegats.VoleNeutreMax) + ", VOLE_TERRE_MINI=" + this.degats.get(FlagsTypesDegats.VoleTerreMin) + ", VOLE_TERRE_MAXI=" + this.degats.get(FlagsTypesDegats.VoleTerreMax) + ", VOLE_FEU_MINI=" + this.degats.get(FlagsTypesDegats.VoleFeuMin) + ", VOLE_FEU_MAXI=" + this.degats.get(FlagsTypesDegats.VoleFeuMax) + ", VOLE_EAU_MINI=" + this.degats.get(FlagsTypesDegats.VoleEauMin) + ", VOLE_EAU_MAXI=" + this.degats.get(FlagsTypesDegats.VoleEauMax) + ", VOLE_AIR_MINI=" + this.degats.get(FlagsTypesDegats.VoleAirMin) + ", VOLE_AIR_MAXI=" + this.degats.get(FlagsTypesDegats.VoleAirMax) + ", SOINS_MINI=" + this.degats.get(FlagsTypesDegats.SoinsMin) + ", SOINS_MAXI=" + this.degats.get(FlagsTypesDegats.SoinsMax) + " WHERE ID=" + this.id);
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
	public Degats charger(ResultSet res, String prefix)
	{
		try
		{
			if(res.getInt(prefix + "_" + "ID") != 0)
			{
				this.id = res.getInt(prefix + "_" + "ID");
				for(FlagsTypesDegats flag : FlagsTypesDegats.values())
				{
					if(flag.getChamp() != null)
						this.degats.put(flag, res.getInt(prefix + "_" + flag.getChamp()));
				}
				
				return this;
			}
			else
			{
				return null;
			}
		}
		catch(SQLException exception)
		{
			ASQL.erreur(exception);
			return null;
		}
	}
	
	/*
	 * Accesseurs
	 */

	/**
	 * Renvoie la valeur des dégâts {@code clef}.
	 * 
	 * @param type - Type des dégâts à renvoyer.
	 * @return La valeur des dégâts.
	 * @category Accesseur
	 */
	public int get(FlagsTypesDegats type)
	{
		return this.degats.get(type);
	}

	/**
	 * Définit la valeur {@code valeur} des dégâts {@code clef}.
	 * 
	 * @param clef - Nom des dégâts.
	 * @param valeur - Valeur des dégâts.
	 * @category Accesseur
	 */
	public void set(FlagsTypesDegats clef, int valeur)
	{
		this.degats.put(clef, valeur);
	}
}