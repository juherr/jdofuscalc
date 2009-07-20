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
 * Classe d'une condition de sexe.
 *
 * @author PAPAYA Alexandre
 * @category Dofus
 * @version 1.0
 */
public class ConditionSexe extends Condition
{
	/*
	 * Constantes et enums
	 */
	
	/**
	 * Enum listant les sexes.
	 *
	 * @author PAPAYA Alexandre
	 * @category Condition
	 */
	public enum Sexe
	{
		/**
		 * Personnage masculin.
		 */
		Masculin("Masculin"),
		/**
		 * Personnage féminin.
		 */
		Feminin("Féminin");

		/**
		 * Nom du sexe.
		 */
		private String nom;

		/**
		 * Construit un nouvel sexe.
		 * 
		 * @param nom - Nom du sexe.
		 * @category Constructeur
		 */
		private Sexe(String nom)
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
		 * Asscocie un caractère à un sexe.
		 * 
		 * @param chaine - La chaine.
		 */
		public static Sexe getSexe(char sexe)
		{
			if(sexe == 'm')
			{
				return Sexe.Masculin;
			}
			else if(sexe == 'f')
			{
				return Sexe.Feminin;
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
		 * @return Le nom du sexe.
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
	 * Construit une nouvelle condition de sexe.
	 * 
	 * @param operateur - Opérateur de la condtition.
	 * @param valeur - Valeur de la condition.
	 * @category Constructeur
	 */
	public ConditionSexe(Operateur operateur, Sexe valeur)
	{
		super(operateur, valeur);
	}

	/*
	 * Méthodes heritées
	 */

	@Override
	public final String tester(Object valeurATester)
	{
		Sexe sexeATester = (Sexe) valeurATester;
		Sexe valeur = (Sexe) this.valeur;

		if(this.operateur == Operateur.Egal)
		{
			if(valeur == sexeATester)
			{
				return null;
			}
			else
			{
				return "Vous devez être de sexe " + valeur + " pour pouvoir porter cet objet.";
			}
		}
		else if(this.operateur == Operateur.Different)
		{
			if(valeur != sexeATester)
			{
				return null;
			}
			else
			{
				return "Vous ne pouvez pas être de sexe " + valeur + " pour pouvoir porter cet objet.";
			}
		}

		return null;
	}
}