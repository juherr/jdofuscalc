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

import org.JDofusCalc.dofus.autres.Effets.FlagsTypesEffets;

/**
 * Classe d'une condition de caractéristique.
 *
 * @author PAPAYA Alexandre
 * @category Dofus
 * @version 1.0
 */
public class ConditionCaracteristique extends Condition
{
	/*
	 * Variables d'instances
	 */
	
	/**
	 * Le {@code serialVersionUID} nécessaire à la sérialisation.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Le nom de la caractérisrique.
	 */
	private FlagsTypesEffets caracteristique;

	/*
	 * Constructeurs / Destructeur
	 */

	/**
	 * Construit une nouvelle condition de caractéristique.
	 * 
	 * @param operateur - Opérateur de la condtition.
	 * @param caracteristique - Caractéristique.
	 * @param valeur - Valeur de la condition.
	 * @category Constructeur
	 */
	public ConditionCaracteristique(Operateur operateur, FlagsTypesEffets caracteristique, int valeur)
	{
		super(operateur, valeur);

		this.caracteristique = caracteristique;
	}
	
	/*
	 * Méthodes heritées
	 */
	
	@Override
	public final String tester(Object valeurATester)
	{
		int entierATester = Integer.parseInt(String.valueOf(valeurATester));
		int valeur = Integer.parseInt(String.valueOf(this.valeur));

		if(this.operateur == Operateur.Egal)
		{
			if(valeur == entierATester)
			{
				return null;
			}
			else
			{
				return "Vous devez avoir " + valeur + " point(s) en " + this.caracteristique.getNom() + " pour porter cet objet (" + entierATester + " actuellement).";
			}
		}
		else if(this.operateur == Operateur.Different)
		{
			if(valeur != entierATester)
			{
				return null;
			}
			else
			{
				return "Vous ne pouvez pas avoir " + valeur + " point(s) en " + this.caracteristique.getNom() + " pour porter cet objet.";
			}
		}
		else if(this.operateur == Operateur.Superieur)
		{
			if(entierATester > valeur)
			{
				return null;
			}
			else
			{
				return "Il vous manque " + (Math.abs(valeur - entierATester) + 1) + " point(s) en " + this.caracteristique.getNom() + " pour porter cet objet.";
			}
		}
		else if(this.operateur == Operateur.Inferieur)
		{
			if(entierATester < valeur)
			{
				return null;
			}
			else
			{
				return "Vous avez un excès de " + (Math.abs(valeur - entierATester) + 1) + " point(s) en " + this.caracteristique.getNom() + " pour porter cet objet.";
			}
		}
		else if(this.operateur == Operateur.SuperieurOuEgal)
		{
			if(entierATester >= valeur)
			{
				return null;
			}
			else
			{
				return "Il vous manque " + (Math.abs(valeur - entierATester) + 1) + " point(s) en " + this.caracteristique.getNom() + " pour porter cet objet.";
			}
		}
		else if(this.operateur == Operateur.InferieurOuEgal)
		{
			if(entierATester <= valeur)
			{
				return null;
			}
			else
			{
				return "Vous avez un excès de " + (Math.abs(valeur - entierATester) + 1) + " point(s) en " + this.caracteristique.getNom() + " pour cet objet.";
			}
		}

		return null;
	}

	/*
	 * Accesseurs
	 */
	
	/**
	 * Renvoie {@code nomCaracteristique}.
	 * 
	 * @return La caractérisrique.
	 * @category Accesseur
	 */
	public final FlagsTypesEffets getCaracteristique()
	{
		return this.caracteristique;
	}

	/**
	 * Définit {@code caracteristique}.
	 * 
	 * @param caracteristique - La caractérisrique.
	 * @category Accesseur
	 */
	public final void setCaracteristique(FlagsTypesEffets caracteristique)
	{
		this.caracteristique = caracteristique;
	}
}