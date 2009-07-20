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

import org.JDofusCalc.dofus.autres.DegatsArme;
import org.JDofusCalc.dofus.autres.Effets;
import org.JDofusCalc.dofus.conditions.Condition;

/**
 * Classe représentant une arme du jeu.
 * 
 * @author PAPAYA Alexandre
 * @category Dofus
 * @version 1.0
 */
public class Arme
{
	/*
	 * Constantes / Enums
	 */
	
	/**
	 * Enum des types des armes du jeu.
	 * 
	 * @author PAPAYA Alexandre
	 * @category Flags
	 * @version 1.0
	 */
	public enum FlagsTypesArmes
	{
		/**
		 * Un arc.
		 */
		Arc(1, "Arcs"),
		/**
		 * Une dague.
		 */
		Dague(2, "Dagues"),
		/**
		 * Une épée.
		 */
		Epee(3, "Epées"),
		/**
		 * Une faux.
		 */
		Faux(4, "Faux"),
		/**
		 * Une hache.
		 */
		Hache(5, "Haches"),
		/**
		 * Un outil.
		 */
		Outil(6, "Outils"),
		/**
		 * Une baguette.
		 */
		Baguette(7, "Baguettes"),
		/**
		 * Un bâton.
		 */
		Baton(8, "Bâtons"),
		/**
		 * Une pelle.
		 */
		Pelle(9, "Pelles"),
		/**
		 * Une pioche.
		 */
		Pioche(10, "Pioches"),
		/**
		 * Un marteau.
		 */
		Marteau(11, "Marteaux");
		
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
		private FlagsTypesArmes(int id, String nom)
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
		@Deprecated
		public final static FlagsTypesArmes getFlag(String chaine)
		{
			return null;
		}
		
		/**
		 * Associe un entier à un flag.
		 * 
		 * @param entier - L'entier.
		 * @return Retoune le flag correspondant à l'entier ou {@code null}.
		 */
		public final static FlagsTypesArmes getFlag(int entier)
		{
			for(FlagsTypesArmes flag : FlagsTypesArmes.values())
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
	 * Id de l'arme.
	 */
	private int id;

	/**
	 * Nom de l'arme.
	 */
	private String nom;

	/**
	 * Type de l'arme.
	 */
	private FlagsTypesArmes type;

	/**
	 * Description de l'arme.
	 */
	private String description = "";

	/**
	 * Niveau de l'arme.
	 */
	private int niveau = 1;

	/**
	 * Conditions pour porter l'arme.
	 */
	private ArrayList<Condition> conditions;

	/**
	 * Panoplie de l'arme.
	 */
	private int panoplie = 0;

	/**
	 * Effets minimums de l'arme.
	 */
	private Effets effetsMinimums;

	/**
	 * Effets maximums de l'arme.
	 */
	private Effets effetsMaximums;

	/**
	 * Les 5 lignes de dégâts de l'arme.
	 */
	private DegatsArme[] degats = new DegatsArme[5];

	/**
	 * Probabilité de faire un coup critique avec l'arme.
	 */
	private int coupsCritiques;

	/**
	 * Bonus de dommages lors d'un coup critique.
	 */
	private int dommagesCoupsCritiques;

	/**
	 * Probabilité de faire un échec critique avec l'arme.
	 */
	private int echecsCritiques;

	/**
	 * Coût d'utilisation de l'arme en PA.
	 */
	private int coutUtilisation;

	/*
	 * Constructeurs / Destructeur
	 */

	/**
	 * Construit une nouvelle arme.
	 * 
	 * @param nom - Nom de l'arme.
	 * @category Constructeur
	 */
	public Arme(String nom)
	{
		this.nom = nom;
	}
	
	/*
	 * Accesseurs
	 */

	/**
	 * Renvoie {@code conditions}.
	 * 
	 * @return Les conditions pour porter l'arme.
	 * @category Accesseur
	 */
	public final ArrayList<Condition> getConditions()
	{
		return this.conditions;
	}

	/**
	 * Renvoie {@code coupsCritiques}.
	 * 
	 * @return La probabilité de faire un coup critique avec l'arme.
	 * @category Accesseur
	 */
	public final int getCoupsCritiques()
	{
		return this.coupsCritiques;
	}

	/**
	 * Renvoie {@code coutUtilisation}.
	 * 
	 * @return Le coût d'utilisation de l'arme en PA.
	 * @category Accesseur
	 */
	public final int getCoutUtilisation()
	{
		return this.coutUtilisation;
	}

	/**
	 * Renvoie les dégâts générés par la ligne de dégâts {@code ligne}.
	 * 
	 * @param ligne - Numéro de la ligne de dégâts.
	 * @return Les dégâts de la ligne {@code ligne}.
	 * @category Accesseur
	 */
	public final DegatsArme getDegats(int ligne)
	{
		if((ligne > 0) && (ligne < 6))
		{
			return this.degats[ligne - 1];
		}
		else
		{
			return null;
		}
	}

	/**
	 * Renvoie {@code description}.
	 * 
	 * @return La description de l'arme.
	 * @category Accesseur
	 */
	public final String getDescription()
	{
		return this.description;
	}

	/**
	 * Renvoie {@code dommagesCoupsCritiques}.
	 * 
	 * @return Le bonus de dommages lors d'un coup critique.
	 * @category Accesseur
	 */
	public final int getDommagesCoupsCritiques()
	{
		return this.dommagesCoupsCritiques;
	}

	/**
	 * Renvoie {@code echecsCritiques}.
	 * 
	 * @return La probabilité de faire un échec critique avec l'arme.
	 * @category Accesseur
	 */
	public final int getEchecsCritiques()
	{
		return this.echecsCritiques;
	}

	/**
	 * Renvoie {@code effetsMaximums}.
	 * 
	 * @return Les effets maximums de l'arme.
	 * @category Accesseur
	 */
	public final Effets getEffetsMaximums()
	{
		return this.effetsMaximums;
	}

	/**
	 * Renvoie {@code effetsMinimums}.
	 * 
	 * @return Les effets minimums de l'arme.
	 * @category Accesseur
	 */
	public final Effets getEffetsMinimums()
	{
		return this.effetsMinimums;
	}

	/**
	 * Renvoie {@code id}.
	 * 
	 * @return L'id de l'arme.
	 * @category Accesseur
	 */
	public final int getId()
	{
		return this.id;
	}

	/**
	 * Renvoie {@code niveau}.
	 * 
	 * @return Le niveau nécessaire pour porter l'arme.
	 * @category Accesseur
	 */
	public final int getNiveau()
	{
		return this.niveau;
	}

	/**
	 * Renvoie {@code nom}.
	 * 
	 * @return Le nom de l'arme.
	 * @category Accesseur
	 */
	public final String getNom()
	{
		return this.nom;
	}

	/**
	 * Renvoie {@code panoplie}.
	 * 
	 * @return L'id de la panoplie de l'arme.
	 * @category Accesseur
	 */
	public final int getPanoplie()
	{
		return this.panoplie;
	}

	/**
	 * Renvoie {@code type}.
	 * 
	 * @return Le type de l'arme.
	 * @category Accesseur
	 */
	public final FlagsTypesArmes getType()
	{
		return this.type;
	}

	/**
	 * Définit {@code conditions}.
	 * 
	 * @param conditions - Les conditions pour porter l'arme.
	 * @category Accesseur
	 */
	public final void setConditions(ArrayList<Condition> conditions)
	{
		this.conditions = conditions;
	}

	/**
	 * Définit {@code coupsCritiques}.
	 * 
	 * @param coupsCritiques - La probabilité de faire un coup critique avec l'arme.
	 * @category Accesseur
	 */
	public final void setCoupsCritiques(int coupsCritiques)
	{
		this.coupsCritiques = coupsCritiques;
	}

	/**
	 * Définit {@code coutUtilisation}.
	 * 
	 * @param coutUtilisation - Le coût d'utilisation de l'arme en PA.
	 * @category Accesseur
	 */
	public final void setCoutUtilisation(int coutUtilisation)
	{
		this.coutUtilisation = coutUtilisation;
	}

	/**
	 * Définit la ligne de dégâts {@code ligne}.
	 * 
	 * @param ligne - Numéro de la ligne de dégâts.
	 * @param degats - Les dégâts de la ligne.
	 * @category Accesseur
	 */
	public final void setDegats(int ligne, DegatsArme degats)
	{
		if((ligne > 0) && (ligne < 6))
		{
			this.degats[ligne - 1] = degats;
		}
	}

	/**
	 * Définit {@code description}.
	 * 
	 * @param description - La description de l'arme.
	 * @category Accesseur
	 */
	public final void setDescription(String description)
	{
		this.description = description;
	}

	/**
	 * Définit {@code dommagesCoupsCritiques}.
	 * 
	 * @param dommagesCoupsCritiques - Le bonus de dommages lors d'un coup critique.
	 * @category Accesseur
	 */
	public final void setDommagesCoupsCritiques(int dommagesCoupsCritiques)
	{
		this.dommagesCoupsCritiques = dommagesCoupsCritiques;
	}

	/**
	 * Définit {@code echecsCritiques}.
	 * 
	 * @param echecsCritiques - La probabilité de faire un échec critique avec l'arme.
	 * @category Accesseur
	 */
	public final void setEchecsCritiques(int echecsCritiques)
	{
		this.echecsCritiques = echecsCritiques;
	}

	/**
	 * Définit {@code effetsMaximums}.
	 * 
	 * @param effetsMaximums - Les effets maximums de l'arme.
	 * @category Accesseur
	 */
	public final void setEffetsMaximums(Effets effetsMaximums)
	{
		this.effetsMaximums = effetsMaximums;
	}

	/**
	 * Définit {@code effetsMinimums}.
	 * 
	 * @param effetsMinimums - Les effets minimums de l'arme.
	 * @category Accesseur
	 */
	public final void setEffetsMinimums(Effets effetsMinimums)
	{
		this.effetsMinimums = effetsMinimums;
	}

	/**
	 * Définit {@code id}.
	 * 
	 * @param id - Id de l'arme.
	 * @category Accesseur
	 */
	public final void setId(int id)
	{
		this.id = id;
	}

	/**
	 * Définit {@code niveau}.
	 * 
	 * @param niveau - Le niveau nécessaire pour porter l'arme.
	 * @category Accesseur
	 */
	public final void setNiveau(int niveau)
	{
		this.niveau = niveau;
	}

	/**
	 * Définit {@code nom}.
	 * 
	 * @param nom - Le nom de l'arme.
	 * @category Accesseur
	 */
	public final void setNom(String nom)
	{
		this.nom = nom;
	}

	/**
	 * Définit {@code panoplie}.
	 * 
	 * @param panoplie - L'id de la panoplie de l'arme.
	 * @category Accesseur
	 */
	public final void setPanoplie(int panoplie)
	{
		this.panoplie = panoplie;
	}

	/**
	 * Définit {@code type}.
	 * 
	 * @param type - Le type de l'arme.
	 * @category Accesseur
	 */
	public final void setType(FlagsTypesArmes type)
	{
		this.type = type;
	}
}