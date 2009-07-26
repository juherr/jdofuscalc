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

package org.JDofusCalc.dofus.conditions;

import java.io.Serializable;

/**
 * Classe abstraite des conditions d'endossage des objets.
 * 
 * @author PAPAYA Alexandre
 * @category Dofus
 * @version 1.0
 */
public abstract class Condition implements Serializable
{
	/*
	 * Constantes et enums
	 */
	
	/**
	 * Enum listant les opérateurs des conditions.
	 *
	 * @author PAPAYA Alexandre
	 * @category Condition
	 */
	public enum Operateur
	{
		/**
		 * Signe égal.
		 */
		Egal("="),
		/**
		 * Signe différent.
		 */
		Different("!="),
		/**
		 * Signe strictement supérieur.
		 */
		Superieur(">"),
		/**
		 * Signe strictement inférieur.
		 */
		Inferieur("<"),
		/**
		 * Signe supérieur ou égal.
		 */
		SuperieurOuEgal(">="),
		/**
		 * Signe inférieur ou égal.
		 */
		InferieurOuEgal("<=");

		/**
		 * Symbole mathématique de l'opérateur.
		 */
		private String symbole;

		/**
		 * Construit un nouvel opérateur.
		 * 
		 * @param symbole - Symbole mathématique de l'opérateur.
		 * @category Constructeur
		 */
		private Operateur(String symbole)
		{
			this.symbole = symbole;
		}
		
		/*
		 * Méthodes héritées
		 */

		@Override
		public String toString()
		{
			return this.getSymbole();
		}
		
		/*
		 * Méthodes statiques
		 */

		/**
		 * Asscocie une chaine à un opérateur.
		 * 
		 * @param chaine - La chaine.
		 */
		public final static Operateur getOperateur(String chaine)
		{
			if(chaine.equals("="))
			{
				return Operateur.Egal;
			}
			else if(chaine.equals("!="))
			{
				return Operateur.Different;
			}
			else if(chaine.equals(">"))
			{
				return Operateur.Superieur;
			}
			else if(chaine.equals("<"))
			{
				return Operateur.Inferieur;
			}
			else if(chaine.equals(">="))
			{
				return Operateur.SuperieurOuEgal;
			}
			else if(chaine.equals("<="))
			{
				return Operateur.InferieurOuEgal;
			}
			else
			{
				return null;
			}
		}
		
		/*
		 * Accesseurs
		 */

		/**
		 * Renvoie {@code symbole}.
		 * 
		 * @return Le symbole de l'opérateur.
		 * @category Accesseur
		 */
		public final String getSymbole()
		{
			return this.symbole;
		}
	}
	
	/*
	 * Variables d'instances
	 */

	/**
	 * Le {@code serialVersionUID} nécessaire à la sérialisation.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Opérateur de la condition.
	 */
	protected Operateur operateur;

	/**
	 * Valeur de la condition.
	 */
	protected Object valeur;

	/*
	 * Constructeurs / Destructeur
	 */

	/**
	 * Construit une nouvelle condition.
	 * 
	 * @param operateur - Opérateur de la condtition.
	 * @param valeur - Valeur de la condition.
	 * @category Constructeur
	 */
	public Condition(Operateur operateur, Object valeur)
	{
		if((operateur == null) || (valeur == null))
		{
			throw new NullPointerException("Operateur : " + operateur + ", Valeur : " + valeur);
		}

		if((operateur == Operateur.Superieur) || (operateur == Operateur.SuperieurOuEgal) || (operateur == Operateur.Inferieur) || (operateur == Operateur.InferieurOuEgal))
		{
			try
			{
				Double.parseDouble(String.valueOf(valeur));
			}
			catch(NumberFormatException exception)
			{
				throw new NumberFormatException("La valeur entrée (" + valeur + ") est incompatible avec l'opérateur.");
			}
		}

		this.operateur = operateur;
		this.valeur = valeur;
	}
	
	/*
	 * Méthodes
	 */

	/**
	 * Teste le paramètre {@code valeurATester} et retourne une chaine de caractères.
	 * 
	 * @param valeurATester - Valeur à tester par rapport aux paramètres de la condition.
	 * @return Retourne {@code null} si la valeur vérifie la condition. Sinon, la méthode
	 * 		retourne une chaine de caractères expliquant pourquoi la valeur ne correspond pas.
	 */
	public abstract String tester(Object valeurATester);
	
	/*
	 * Accesseurs
	 */

	/**
	 * Renvoie {@code operateur}.
	 * 
	 * @return L'opérateur de la condition.
	 * @category Accesseur
	 */
	public final Operateur getOperateur()
	{
		return this.operateur;
	}
	
	/**
	 * Renvoie {@code valeur}.
	 * 
	 * @return La valeur de la condition.
	 * @category Accesseur
	 */
	public final Object getValeur()
	{
		return this.valeur;
	}

	/**
	 * Définit {@code operateur}.
	 * 
	 * @param operateur - L'opérateur de la condition.
	 * @category Accesseur
	 */
	public final void setOperateur(Operateur operateur)
	{
		this.operateur = operateur;
	}

	/**
	 * Définit {@code valeur}.
	 * 
	 * @param valeur - La valeur de la condition.
	 * @category Accesseur
	 */
	public final void setValeur(Object valeur)
	{
		this.valeur = valeur;
	}
}