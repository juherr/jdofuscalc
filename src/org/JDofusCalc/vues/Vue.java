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

package org.JDofusCalc.vues;

import org.apache.log4j.Logger;

/**
 * Vue abstraite.
 * 
 * @author PAPAYA Alexandre
 * @category Vue
 * @version 1.0
 */
public abstract class Vue
{
	/*
	 * Variables d'instances
	 */

	/**
	 * Logger.
	 */
	protected final static Logger logger = Logger.getLogger("org.JDofusCalc.Vue");

	/*
	 * Constructeurs / Destructeur
	 */

	/**
	 * Construit une nouvelle vue.
	 * 
	 * @category Constructeur
	 */
	public Vue()
	{
	}
	
	/*
	 *  Méthodes d'affichage des boîtes de dialogue
	 */

	/**
	 * Affiche une boîte de dialogue {@code information}.
	 * 
	 * @param titre - Titre de la boîte de dialogue.
	 * @param message - Message de la boîte de dialogue.
	 */
	public abstract void boiteDialogueInfo(String titre, String message);

	/**
	 * Affiche une boîte de dialogue {@code information}.
	 * 
	 * @param message - Message de la boîte de dialogue.
	 */
	public void boiteDialogueInfo(String message)
	{
		this.boiteDialogueInfo("Information", message);
	}

	/**
	 * Affiche une boîte de dialogue {@code question}.
	 * 
	 * @param titre - Titre de la boîte de dialogue.
	 * @param message - Message de la boîte de dialogue.
	 * @return Retourne {@code true} si réponse positive, sinon {@code false}.
	 */
	public abstract boolean boiteDialogueQuestion(String titre, String message);

	/**
	 * Affiche une boîte de dialogue {@code question}.
	 * 
	 * @param message - Message de la boîte de dialogue.
	 * @return Retourne {@code true} si réponse positive, sinon {@code false}.
	 */
	public boolean boiteDialogueQuestion(String message)
	{
		return this.boiteDialogueQuestion("Question", message);
	}

	/**
	 * Affiche une boîte de dialogue {@code erreur}.
	 * 
	 * @param titre - Titre de la boîte de dialogue.
	 * @param message - Message de la boîte de dialogue.
	 */
	public abstract void boiteDialogueErreur(String titre, String message);

	/**
	 * Affiche une boîte de dialogue {@code erreur}.
	 * 
	 * @param message - Message de la boîte de dialogue.
	 */
	public void boiteDialogueErreur(String message)
	{
		this.boiteDialogueErreur("Erreur", message);
	}

	/**
	 * Affiche une boîte de dialogue {@code avertissement}.
	 * 
	 * @param titre - Titre de la boîte de dialogue.
	 * @param message - Message de la boîte de dialogue.
	 */
	public abstract void boiteDialogueAvert(String titre, String message);

	/**
	 * Affiche une boîte de dialogue {@code avertissement}.
	 * 
	 * @param message - Message de la boîte de dialogue.
	 */
	public void boiteDialogueAvert(String message)
	{
		this.boiteDialogueAvert("Avertissement", message);
	}
	
	/*
	 * Méthodes d'affichage et de fermeture des vues
	 */
	
	/**
	 * Affiche la vue à l'écran.
	 */
	public abstract void afficher();

	/**
	 * Ferme la vue.
	 */
	public abstract void fermer();
}