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
 * Classe abstraire représentant un animal du jeu.
 * 
 * @author PAPAYA Alexandre
 * @category Dofus
 * @version 1.0
 * @see {@link Monture} et {@link Familier}.
 */
public abstract class Animal
{
	/*
	 * Constantes / Enums
	 */
	
	/**
	 * Enum des types des animaux du jeu.
	 * 
	 * @author PAPAYA Alexandre
	 * @category Flags
	 * @version 1.0
	 */
	public enum FlagsTypesAnimaux
	{
		/**
		 * Un familier.
		 */
		Familier(8, "Familier"),
		/**
		 * Une monture.
		 */
		Monture(0, "Monture");
		
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
		private FlagsTypesAnimaux(int id, String nom)
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
		public final static FlagsTypesAnimaux getFlag(String chaine)
		{
			return null;
		}
		
		/**
		 * Associe un entier à un flag.
		 * 
		 * @param entier - L'entier.
		 * @return Retoune le flag correspondant à l'entier ou {@code null}.
		 */
		public final static FlagsTypesAnimaux getFlag(int entier)
		{
			for(FlagsTypesAnimaux flag : FlagsTypesAnimaux.values())
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
	 * Id de l'animal.
	 */
	protected int id;

	/**
	 * Nom de l'animal.
	 */
	protected String nom;

	/**
	 * Niveau nécessaire pour porter l'animal.
	 */
	protected int niveau;

	/**
	 * Type.
	 */
	protected FlagsTypesAnimaux type;

	/**
	 * Conditions pour porter l'animal.
	 */
	protected ArrayList<Condition> conditions;

	/**
	 * Effets minimums de l'animal.
	 */
	protected Effets effetsMinimums;

	/**
	 * Effets maximums de l'animal.
	 */
	protected Effets effetsMaximums;

	/*
	 * Constructeurs / Destructeur
	 */

	/**
	 * Construit un nouvel animal.
	 * 
	 * @param nomAnimal - Nom de l'animal.
	 * @category Constructeur
	 */
	public Animal(String nomAnimal)
	{
		this.nom = nomAnimal;
	}
	
	/*
	 * Accesseurs
	 */
	
	/**
	 * Renvoie {@code conditions}.
	 * 
	 * @return Les conditions pour porter l'animal.
	 * @category Accesseur
	 */
	public final ArrayList<Condition> getConditions()
	{
		return conditions;
	}

	/**
	 * Renvoie {@code effetsMaximums}.
	 * 
	 * @return Les effets maximums de l'animal.
	 * @category Accesseur
	 */
	public final Effets getEffetsMaximums()
	{
		return effetsMaximums;
	}

	/**
	 * Renvoie {@code effetsMinimums}.
	 * 
	 * @return Les effets minimums de l'animal.
	 * @category Accesseur
	 */
	public final Effets getEffetsMinimums()
	{
		return effetsMinimums;
	}

	/**
	 * Renvoie {@code id}.
	 * 
	 * @return L'id du l'animal.
	 * @category Accesseur
	 */
	public final int getId()
	{
		return id;
	}

	/**
	 * Renvoie {@code niveau}.
	 * 
	 * @return Le niveau nécessaire pour porter l'animal.
	 * @category Accesseur
	 */
	public final int getNiveau()
	{
		return niveau;
	}

	/**
	 * Renvoie {@code nom}.
	 * 
	 * @return Le nom de l'animal.
	 * @category Accesseur
	 */
	public final String getNom()
	{
		return nom;
	}

	/**
	 * Renvoie {@code type}.
	 * 
	 * @return Le type de l'animal.
	 * @category Accesseur
	 */
	public final FlagsTypesAnimaux getType()
	{
		return type;
	}

	/**
	 * Définit {@code conditions}.
	 * 
	 * @param conditions - Les conditions pour porter l'animal.
	 * @category Accesseur
	 */
	public final void setConditions(ArrayList<Condition> conditions)
	{
		this.conditions = conditions;
	}

	/**
	 * Définit {@code effetsMaximums}.
	 * 
	 * @param effetsMaximums - Les effets maximums de l'animal.
	 * @category Accesseur
	 */
	public final void setEffetsMaximums(Effets effetsMaximums)
	{
		this.effetsMaximums = effetsMaximums;
	}

	/**
	 * Définit {@code effetsMinimums}.
	 * 
	 * @param effetsMinimums - Les effets minimums de l'animal.
	 * @category Accesseur
	 */
	public final void setEffetsMinimums(Effets effetsMinimums)
	{
		this.effetsMinimums = effetsMinimums;
	}

	/**
	 * Définit {@code id}.
	 * 
	 * @param id - Id de l'animal.
	 * @category Accesseur
	 */
	public final void setId(int id)
	{
		this.id = id;
	}

	/**
	 * Définit {@code niveau}.
	 * 
	 * @param niveau - Le niveau nécessaire pour porter l'animal.
	 * @category Accesseur
	 */
	public final void setNiveau(int niveau)
	{
		this.niveau = niveau;
	}

	/**
	 * Définit {@code nom}.
	 * 
	 * @param nom - Le nom de l'animal .
	 * @category Accesseur
	 */
	public final void setNom(String nom)
	{
		this.nom = nom;
	}

	/**
	 * Définit {@code type}.
	 * 
	 * @param type - Le type de l'animal.
	 * @category Accesseur
	 */
	public final void setType(FlagsTypesAnimaux type)
	{
		this.type = type;
	}
}