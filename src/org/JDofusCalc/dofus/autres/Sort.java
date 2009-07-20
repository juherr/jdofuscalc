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

import java.util.HashMap;

/**
 * Classe représentant un sort du jeu.
 * 
 * @author PAPAYA Alexandre
 * @category Dofus
 * @version 1.0
 */
public class Sort
{
	/*
	 * Enums
	 */
	
	/**
	 * Enum des natures des sorts.
	 * 
	 * @author PAPAYA Alexandre
	 * @category Dofus
	 * @version 1.0
	 */
	public enum NatureSortsFlags
	{
		/**
		 * Sort d'attaque.
		 */
		Attaque(),
		/**
		 * Sort de soin.
		 */
		Soin(),
		/**
		 * Piège.
		 */
		Piege(),
		/**
		 * Punition.
		 */
		Punition();

		/*
		 * Constructeurs / Destructeur
		 */

		/**
		 * Construit un nouveau flag.
		 * 
		 * @category Constructeur
		 */
		NatureSortsFlags()
		{
		}

		/*
		 * Méthodes statiques
		 */
		
		/**
		 * Asscocie une chaine à un flag.
		 * 
		 * @param chaine - La chaine.
		 */
		public final static NatureSortsFlags getType(String chaine)
		{
			if(chaine.equals("attaque"))
			{
				return NatureSortsFlags.Attaque;
			}
			else if(chaine.equals("soin"))
			{
				return NatureSortsFlags.Soin;
			}
			else if(chaine.equals("piege"))
			{
				return NatureSortsFlags.Piege;
			}
			else if(chaine.equals("punition"))
			{
				return NatureSortsFlags.Punition;
			}
			else
			{
				System.err.println("Aucun type n'a été trouvé pour '" + chaine + "'");
				return null;
			}
		}
	}
	
	/*
	 * Variables d'instances
	 */
	
	/**
	 * Id du sort.
	 */
	private int id;

	/**
	 * Nom du sort.
	 */
	private String nom;

	/**
	 * Nature du sort.
	 */
	private NatureSortsFlags nature;

	/**
	 * Les caractéristiques du sort.
	 */
	HashMap<Integer, HashMap<String, Object>> caracteristiquesSort;

	/*
	 * Constructeurs / Destructeur
	 */

	/**
	 * Construit une nouvelle arme.
	 * 
	 * @param nom - Nom du sort.
	 * @category Constructeur
	 */
	public Sort(String nom)
	{
		this.caracteristiquesSort = new HashMap<Integer, HashMap<String, Object>>();

		HashMap<String, Object> niveau1 = Sort.getNouveauNiveau();
		HashMap<String, Object> niveau2 = Sort.getNouveauNiveau();
		HashMap<String, Object> niveau3 = Sort.getNouveauNiveau();
		HashMap<String, Object> niveau4 = Sort.getNouveauNiveau();
		HashMap<String, Object> niveau5 = Sort.getNouveauNiveau();
		HashMap<String, Object> niveau6 = Sort.getNouveauNiveau();

		this.caracteristiquesSort.put(1, niveau1);
		this.caracteristiquesSort.put(2, niveau2);
		this.caracteristiquesSort.put(3, niveau3);
		this.caracteristiquesSort.put(4, niveau4);
		this.caracteristiquesSort.put(5, niveau5);
		this.caracteristiquesSort.put(6, niveau6);

		this.nom = nom;
	}
	
	/*
	 * Méthodes statiques
	 */
	
	/**
	 * Renvoie un nouveau niveau de sort.
	 * 
	 * @return Une {@code HashMap} d'un nouveau niveau de sort.
	 */
	private final static HashMap<String, Object> getNouveauNiveau()
	{
		HashMap<String, Object> niveau = new HashMap<String, Object>();
		niveau.put("PA", 0);
		niveau.put("CC", 0);
		niveau.put("EC", 0);
		niveau.put("Degats", null);
		niveau.put("DegatsCC", null);

		return niveau;
	}
	
	/*
	 * Accesseurs
	 */

	/**
	 * Renvoie la valeur de la caractéristique {@code clef} du niveau {@code niveau} du sort.
	 * 
	 * @param niveau - Niveau du sort.
	 * @param clef - Caractérisrique du sort.
	 * @return La caractérisrique du sort demandée comme le coût en PA ou encore les dégâts.
	 */
	public final Object get(int niveau, String clef)
	{
		return this.caracteristiquesSort.get(niveau).get(clef);
	}

	/**
	 * Renvoie {@code id}.
	 * 
	 * @return L'id du sort.
	 * @category Accesseur
	 */
	public final int getId()
	{
		return this.id;
	}

	/**
	 * Renvoie {@code nature}.
	 * 
	 * @return La nature du sort.
	 * @category Accesseur
	 */
	public final NatureSortsFlags getNature()
	{
		return this.nature;
	}

	/**
	 * Renvoie {@code nom}.
	 * 
	 * @return Le nom du sort.
	 * @category Accesseur
	 */
	public final String getNom()
	{
		return this.nom;
	}

	/**
	 * Définit la valeur de la caractéristique {@code clef} au niveau {@code niveau} du sort.
	 * 
	 * @param niveau - Niveau du sort.
	 * @param clef - Caractérisrique du sort.
	 * @param valeur - Valeur de la caractérisrique.
	 */
	public final void set(int niveau, String clef, Object valeur)
	{
		HashMap<String, Object> hashmap = this.caracteristiquesSort.get(niveau);
		hashmap.put(clef, valeur);
		this.caracteristiquesSort.put(niveau, hashmap);
	}

	/**
	 * Définit {@code id}.
	 * 
	 * @param id - Id du sort.
	 * @category Accesseur
	 */
	public final void setId(int id)
	{
		this.id = id;
	}

	/**
	 * Définit {@code nature}.
	 * 
	 * @param nature - Nature du sort.
	 * @category Accesseur
	 */
	public final void setNature(NatureSortsFlags nature)
	{
		this.nature = nature;
	}

	/**
	 * Définit {@code nom}.
	 * 
	 * @param nom - Le nom du sort.
	 * @category Accesseur
	 */
	public final void setNom(String nom)
	{
		this.nom = nom;
	}
}