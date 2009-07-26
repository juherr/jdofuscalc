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
 * les caractéristiques, ect. Ce logiciel est programmé en java et utilise des
 * bibliothèques dont les licences sont en accord avec celle de ce logiciel.
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

package org.JDofusCalc.dofus.objets;

import org.JDofusCalc.dofus.autres.Effets;

/**
 * Dofus.
 * 
 * @author PAPAYA Alexandre
 * @category version Dofus
 */
public class Dofus
{
	/*
	 * Constantes / Enums
	 */
	
	/**
	 * Enum des types des Dofus du jeu.
	 * 
	 * @author PAPAYA Alexandre
	 * @category Flags
	 * @version 1.0
	 */
	public enum FlagsTypesDofus
	{
		/**
		 * Dofawa.
		 */
		Dofawa(1, "Dofawa"),

		/**
		 * Dofus Cawotte.
		 */
		Cawotte(2, "Dofus Cawotte"),

		/**
		 * Dofus Emeraude.
		 */
		Emeraude(3, "Dofus Emeraude"),

		/**
		 * Dofus Kaliptus.
		 */
		Kaliptus(4, "Dofus Kaliptus"),

		/**
		 * Dofus Ocre.
		 */
		Ocre(5, "Dofus Ocre"),

		/**
		 * Dofus Pourpre.
		 */
		Pourpre(6, "Dofus Pourpre"),

		/**
		 * Dofus Turquoise.
		 */
		Turquoise(7, "Dofus Turquoise"),

		/**
		 * Dofus Vulbis.
		 */
		Vulbis(8, "Dofus Vulbis");
		
		/*
		 * Variables d'intances
		 */
		
		/**
		 * Id du flag en base de données.
		 */
		private int id;
		
		/**
		 * Nom du flags.
		 */
		private String nom;
		
		/*
		 * Constructeurs / Destructeur
		 */

		/**
		 * Construit un nouvel enum.
		 * 
		 * @param id - Id de l'objet en base de données.
		 * @param nom - Nom du flag.
		 * @category Constructeur
		 */
		private FlagsTypesDofus(int id, String nom)
		{
			this.id = id;
			this.nom = nom;
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
		public final static FlagsTypesDofus getFlag(String chaine)
		{
			if(chaine.equals("Dofawa"))
			{
				return FlagsTypesDofus.Dofawa;
			}
			else if(chaine.equals("Dofus Cawotte"))
			{
				return FlagsTypesDofus.Cawotte;
			}
			else if(chaine.equals("Dofus Emeraude"))
			{
				return FlagsTypesDofus.Emeraude;
			}
			else if(chaine.equals("Dofus Kaliptus"))
			{
				return FlagsTypesDofus.Kaliptus;
			}
			else if(chaine.equals("Dofus Ocre"))
			{
				return FlagsTypesDofus.Ocre;
			}
			else if(chaine.equals("Dofus Pourpre"))
			{
				return FlagsTypesDofus.Pourpre;
			}
			else if(chaine.equals("Dofus Turquoise"))
			{
				return FlagsTypesDofus.Turquoise;
			}
			else if(chaine.equals("Dofus Vulbis"))
			{
				return FlagsTypesDofus.Vulbis;
			}
			else
			{
				System.err.println("La chaine '" + chaine + "' ne correspond à aucun FlagsTypesDofus.");
				return null;
			}
		}
		
		/**
		 * Associe un entier à un flag.
		 * 
		 * @param entier - L'entier.
		 * @return Retoune le flag correspondant à l'entier ou {@code null}.
		 */
		public final static FlagsTypesDofus getFlag(int entier)
		{
			for(FlagsTypesDofus flag : FlagsTypesDofus.values())
			{
				if(flag.getId() == entier)
					return flag;
			}
			
			return null;
		}
		
		/*
		 * Accesseurs
		 */		

		/**
		 * Renvoie l'id du flag en base de données.
		 * 
		 * @return L'id du flag.
		 * @category Accesseur
		 */
		public final int getId()
		{
			return id;
		}

		/**
		 * Renvoie le nom du flag.
		 * 
		 * @return Le nom du flag.
		 * @category Accesseur
		 */
		public final String getNom()
		{
			return nom;
		}
	}
	
	/*
	 * Variables d'instances
	 */
	
	/**
	 * Id du Dofus en base de données.
	 */
	private int id;

	/**
	 * Nom du Dofus.
	 */
	private String nom;

	/**
	 * Type du Dofus.
	 */
	private FlagsTypesDofus type;

	/**
	 * Description du Dofus.
	 */
	private String description;

	/**
	 * Niveau du Dofus.
	 */
	private int niveau;

	/**
	 * Effets minimums du Dofus.
	 */
	private Effets effetsMinimums;

	/**
	 * Effets maximums du Dofus.
	 */
	private Effets effetsMaximums;

	/**
	 * Constructeur.
	 * 
	 * @param nom
	 */
	public Dofus(String nom)
	{
		this.nom = nom;
	}

	/**
	 * @return id
	 * @category Accesseur
	 */
	public final int getId()
	{
		return this.id;
	}

	/**
	 * @param id
	 *            id
	 * @category Accesseur
	 */
	public final void setId(int id)
	{
		this.id = id;
	}

	/**
	 * @return nom
	 * @category Accesseur
	 */
	public final String getNom()
	{
		return this.nom;
	}

	/**
	 * @param nom
	 *            nom
	 * @category Accesseur
	 */
	public final void setNom(String nom)
	{
		this.nom = nom;
	}

	/**
	 * @return description
	 * @category Accesseur
	 */
	public final String getDescription()
	{
		return this.description;
	}

	/**
	 * @param description
	 *            description
	 * @category Accesseur
	 */
	public final void setDescription(String description)
	{
		this.description = description;
	}

	/**
	 * @return niveau
	 * @category Accesseur
	 */
	public final int getNiveau()
	{
		return this.niveau;
	}

	/**
	 * @param niveau
	 *            niveau
	 * @category Accesseur
	 */
	public final void setNiveau(int niveau)
	{
		this.niveau = niveau;
	}

	/**
	 * @return effetsMinimum
	 * @category Accesseur
	 */
	public final Effets getEffetsMinimum()
	{
		return this.effetsMinimums;
	}

	/**
	 * @param effetsMinimum
	 *            effetsMinimum
	 * @category Accesseur
	 */
	public final void setEffetsMinimums(Effets effetsMinimum)
	{
		this.effetsMinimums = effetsMinimum;
	}

	/**
	 * @return effetsMaximum
	 * @category Accesseur
	 */
	public final Effets getEffetsMaximum()
	{
		return this.effetsMaximums;
	}

	/**
	 * @param effetsMaximum
	 *            effetsMaximum
	 * @category Accesseur
	 */
	public final void setEffetsMaximums(Effets effetsMaximum)
	{
		this.effetsMaximums = effetsMaximum;
	}

	/**
	 * @return type
	 * @category Accesseur
	 */
	public final FlagsTypesDofus getType()
	{
		return this.type;
	}

	/**
	 * @param type
	 *            type
	 * @category Accesseur
	 */
	public final void setType(FlagsTypesDofus type)
	{
		this.type = type;
	}
}
