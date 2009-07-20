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

/**
 * Classe d'une condition d'alignement.
 *
 * @author PAPAYA Alexandre
 * @category Dofus
 * @version 1.0
 */
public class ConditionAlignement extends Condition
{
	/*
	 * Constantes et enums
	 */
	
	/**
	 * Enum listant les alignements.
	 *
	 * @author PAPAYA Alexandre
	 * @category Condition
	 */
	public enum Alignement
	{
		/**
		 * Personnage non-aligné.
		 */
		Neutre("Neutre"),
		/**
		 * Personnage brakmârien.
		 */
		Brakmarien("Brakmârien"),
		/**
		 * Personnage bontais.
		 */
		Bontais("Bontais"),
		/**
		 * Personnage mercenaire.
		 */
		Mercenaire("Mercenaire");

		/**
		 * Nom de l'alignement.
		 */
		private String nom;
		
		/*
		 * Constructeurs / Destructeur
		 */

		/**
		 * Construit un nouvel alignement.
		 * 
		 * @param nom - Nom de l'alignement.
		 * @category Constructeur
		 */
		private Alignement(String nom)
		{
			this.nom = nom;
		}
		
		/*
		 * Méthodes héritées
		 */

		@Override
		public String toString()
		{
			return this.getNom();
		}
		
		/*
		 * Méthodes statiques
		 */

		/**
		 * Asscocie une chaine à un alignement.
		 * 
		 * @param chaine - La chaine.
		 */
		public final static Alignement getAlignement(String chaine)
		{
			if(chaine.toLowerCase().equals("neutre"))
			{
				return Alignement.Neutre;
			}
			else if(chaine.toLowerCase().equals("bonta"))
			{
				return Alignement.Bontais;
			}
			else if(chaine.toLowerCase().equals("brâkmar"))
			{
				return Alignement.Brakmarien;
			}
			else if(chaine.toLowerCase().equals("mercenaire"))
			{
				return Alignement.Mercenaire;
			}
			else
			{
				return null;
			}
		}

		/**
		 * Asscocie un entier à un alignement.
		 * 
		 * @param index - L'entier.
		 */
		public final static Alignement getAlignement(int index)
		{
			if(index == 0)
			{
				return Alignement.Neutre;
			}
			else if(index == 1)
			{
				return Alignement.Bontais;
			}
			else if(index == 2)
			{
				return Alignement.Brakmarien;
			}
			else if(index == 3)
			{
				return Alignement.Mercenaire;
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
		 * Renvoie {@code nom}.
		 * 
		 * @return Le nom de l'alignement.
		 * @category Accesseur
		 */
		public final String getNom()
		{
			return this.nom;
		}
	}
	
	/*
	 * Variables d'instances
	 */

	/**
	 * Le {@code serialVersionUID} nécessaire à la sérialisation.
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * Constructeurs / Destructeur
	 */

	/**
	 * Construit une nouvelle condition d'alignement.
	 * 
	 * @param operateur - Opérateur de la condtition.
	 * @param valeur - Valeur de la condition.
	 * @category Constructeur
	 */
	public ConditionAlignement(Operateur operateur, Alignement valeur)
	{
		super(operateur, valeur);
	}

	/*
	 * Méthodes heritées
	 */
	
	@Override
	public final String tester(Object valeurATester)
	{
		Alignement alignementATester = (Alignement) valeurATester;
		Alignement valeur = (Alignement) this.valeur;

		if(this.operateur == Operateur.Egal)
		{
			if(valeur == alignementATester)
			{
				return null;
			}
			else
			{
				return "Vous devez être " + valeur + " pour pouvoir porter cet objet.";
			}
		}
		else if(this.operateur == Operateur.Different)
		{
			if(valeur != alignementATester)
			{
				return null;
			}
			else
			{
				return "Vous ne pouvez pas être " + valeur + " pour pouvoir porter cet objet.";
			}
		}

		return null;
	}
}