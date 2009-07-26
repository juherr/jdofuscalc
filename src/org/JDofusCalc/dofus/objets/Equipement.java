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

package org.JDofusCalc.dofus.objets;

import java.util.ArrayList;

import org.JDofusCalc.dofus.autres.Effets;
import org.JDofusCalc.dofus.conditions.Condition;

/**
 * Classe repésentant un équipement du jeu.
 * 
 * @author PAPAYA Alexandre
 * @category Dofus
 * @version 1.0
 */
public class Equipement
{
	/*
	 * Constantes / Enums
	 */
	
	/**
	 * Enum des types des équipements du jeu.
	 * 
	 * @author PAPAYA Alexandre
	 * @category Flags
	 * @version 1.0
	 */
	public enum FlagsTypesEquipements
	{
		/**
		 * Une amulette.
		 */
		Amulette(1, "Amulette"),
		/**
		 * Un anneau.
		 */
		Anneau(2, "Anneau"),
		/**
		 * Un anneau (main gauche).
		 */
		AnneauG(2, "Anneau"),
		/**
		 * Un anneau (main droite).
		 */
		AnneauD(2, "Anneau"),
		/**
		 * Une paire de bottes.
		 */
		Bottes(7, "Bottes"),
		/**
		 * Un bouclier.
		 */
		Bouclier(3, "Bouclier"),
		/**
		 * Une cape.
		 */
		Cape(4, "Cape"),
		/**
		 * Une ceinture.
		 */
		Ceinture(5, "Ceinture"),
		/**
		 * Une coiffe.
		 */
		Coiffe(6, "Coiffe");
		
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
		private FlagsTypesEquipements(int id, String nom)
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
		public final static FlagsTypesEquipements getFlag(String chaine)
		{
			if(chaine.equals("amulette"))
			{
				return FlagsTypesEquipements.Amulette;
			}
			else if(chaine.equals("anneau G."))
			{
				return FlagsTypesEquipements.AnneauG;
			}
			else if(chaine.equals("anneau D."))
			{
				return FlagsTypesEquipements.AnneauD;
			}
			else if(chaine.equals("ceinture"))
			{
				return FlagsTypesEquipements.Ceinture;
			}
			else if(chaine.equals("bottes"))
			{
				return FlagsTypesEquipements.Bottes;
			}
			else if(chaine.equals("coiffe"))
			{
				return FlagsTypesEquipements.Coiffe;
			}
			else if(chaine.equals("cape"))
			{
				return FlagsTypesEquipements.Cape;
			}
			else if(chaine.equals("bouclier"))
			{
				return FlagsTypesEquipements.Bouclier;
			}
			else
			{
				System.err.println("La chaine '" + chaine + "' ne correspond à aucun FlagsTypesEquipements.");
				return null;
			}
		}
		
		/**
		 * Associe un entier à un flag.
		 * 
		 * @param entier - L'entier.
		 * @return Retoune le flag correspondant à l'entier ou {@code null}.
		 */
		public final static FlagsTypesEquipements getFlag(int entier)
		{
			if(entier == 1)
			{
				return FlagsTypesEquipements.Amulette;
			}
			else if(entier == 2)
			{
				return FlagsTypesEquipements.Anneau;
			}
			else if(entier == 3)
			{
				return FlagsTypesEquipements.Bouclier;
			}
			else if(entier == 4)
			{
				return FlagsTypesEquipements.Cape;
			}
			else if(entier == 5)
			{
				return FlagsTypesEquipements.Ceinture;
			}
			else if(entier == 6)
			{
				return FlagsTypesEquipements.Coiffe;
			}
			else if(entier == 7)
			{
				return FlagsTypesEquipements.Bottes;
			}
			else
			{
				System.err.println("L'entier '" + entier + "' ne correspond à aucun FlagsTypesEquipements.");
				return null;
			}
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
	 * Id de l'équipement.
	 */
	private int id;

	/**
	 * Nom de l'équipement.
	 */
	private String nom;

	/**
	 * Type de l'équipement.
	 */
	private FlagsTypesEquipements type;

	/**
	 * Description de l'équipement.
	 */
	private String description;

	/**
	 * Niveau de l'équipement.
	 */
	private int niveau;

	/**
	 * Conditions pour porter l'équipement.
	 */
	private ArrayList<Condition> conditions;

	/**
	 * Panoplie de l'équipement.
	 */
	private int panoplie;

	/**
	 * Effets minimums de l'équipement.
	 */
	private Effets effetsMinimums;

	/**
	 * Effets maximums de l'équipement.
	 */
	private Effets effetsMaximums;

	/*
	 * Constructeurs / Destructeur
	 */

	/**
	 * Construit un nouvel équipement.
	 * 
	 * @param nomEquipement - Nom de l'équipement.
	 * @category Constructeur
	 */
	public Equipement(String nomEquipement)
	{
		this.nom = nomEquipement;
	}
	
	/*
	 * Accesseurs
	 */

	/**
	 * Renvoie {@code conditions}.
	 * 
	 * @return Les conditions pour porter l'équipement.
	 * @category Accesseur
	 */
	public final ArrayList<Condition> getConditions()
	{
		return this.conditions;
	}

	/**
	 * Renvoie {@code description}.
	 * 
	 * @return La description de l'équipement.
	 * @category Accesseur
	 */
	public final String getDescription()
	{
		return this.description;
	}

	/**
	 * Renvoie {@code effetsMaximums}.
	 * 
	 * @return Les effets maximums de l'équipement.
	 * @category Accesseur
	 */
	public final Effets getEffetsMaximums()
	{
		return this.effetsMaximums;
	}

	/**
	 * Renvoie {@code effetsMinimums}.
	 * 
	 * @return Les effets minimums de l'équipement.
	 * @category Accesseur
	 */
	public final Effets getEffetsMinimums()
	{
		return this.effetsMinimums;
	}

	/**
	 * Renvoie {@code id}.
	 * 
	 * @return L'id de l'équipement.
	 * @category Accesseur
	 */
	public final int getId()
	{
		return this.id;
	}

	/**
	 * Renvoie {@code niveau}.
	 * 
	 * @return Le niveau nécessaire pour porter l'équipement.
	 * @category Accesseur
	 */
	public final int getNiveau()
	{
		return this.niveau;
	}

	/**
	 * Renvoie {@code nom}.
	 * 
	 * @return Le nom de l'équipement.
	 * @category Accesseur
	 */
	public final String getNom()
	{
		return this.nom;
	}

	/**
	 * Renvoie {@code panoplie}.
	 * 
	 * @return L'id de la panoplie de l'équipement.
	 * @category Accesseur
	 */
	public final int getPanoplie()
	{
		return this.panoplie;
	}
	
	/**
	 * Renvoie {@code type}.
	 * 
	 * @return Le type de l'équipement.
	 * @category Accesseur
	 */
	public final FlagsTypesEquipements getType()
	{
		return this.type;
	}

	/**
	 * Définit {@code conditions}.
	 * 
	 * @param conditions - Les conditions pour porter l'équipement.
	 * @category Accesseur
	 */
	public final void setConditions(ArrayList<Condition> conditions)
	{
		this.conditions = conditions;
	}

	/**
	 * Définit {@code description}.
	 * 
	 * @param description - La description de l'équipement.
	 * @category Accesseur
	 */
	public final void setDescription(String description)
	{
		this.description = description;
	}

	/**
	 * Définit {@code effetsMaximums}.
	 * 
	 * @param effetsMaximums - Les effets maximums de l'équipement.
	 * @category Accesseur
	 */
	public final void setEffetsMaximums(Effets effetsMaximums)
	{
		this.effetsMaximums = effetsMaximums;
	}

	/**
	 * Définit {@code effetsMinimums}.
	 * 
	 * @param effetsMinimums - Les effets minimums de l'équipement.
	 * @category Accesseur
	 */
	public final void setEffetsMinimums(Effets effetsMinimums)
	{
		this.effetsMinimums = effetsMinimums;
	}

	/**
	 * Définit {@code id}.
	 * 
	 * @param id - Id de l'équipement.
	 * @category Accesseur
	 */
	public final void setId(int id)
	{
		this.id = id;
	}

	/**
	 * Définit {@code niveau}.
	 * 
	 * @param niveau - Le niveau nécessaire pour porter l'équipement.
	 * @category Accesseur
	 */
	public final void setNiveau(int niveau)
	{
		this.niveau = niveau;
	}

	/**
	 * Définit {@code nom}.
	 * 
	 * @param nom - Le nom de l'équipement.
	 * @category Accesseur
	 */
	public final void setNom(String nom)
	{
		this.nom = nom;
	}

	/**
	 * Définit {@code panoplie}.
	 * 
	 * @param panoplie - L'id de la panoplie de l'équipement.
	 * @category Accesseur
	 */
	public final void setPanoplie(int panoplie)
	{
		this.panoplie = panoplie;
	}

	/**
	 * Définit {@code type}.
	 * 
	 * @param type - Le type de l'équipement.
	 * @category Accesseur
	 */
	public final void setType(FlagsTypesEquipements type)
	{
		this.type = type;
	}
}