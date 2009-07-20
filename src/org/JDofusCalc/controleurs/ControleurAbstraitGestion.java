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

package org.JDofusCalc.controleurs;

import org.JDofusCalc.modeles.ModeleDofus;
import org.JDofusCalc.modeles.ModeleSauvegardes;
import org.JDofusCalc.vues.Vue;

/**
 * Controleur abstrait de gestion des objets.
 * 
 * @author PAPAYA Alexandre
 * @category Controleur
 * @version 1.0
 */
public abstract class ControleurAbstraitGestion extends Controleur
{
	/*
	 * Variables d'instances
	 */

	/**
	 * Modèle {@link ModeleDofus} du controleur.
	 */
	protected ModeleDofus modeleDofus;
	/**
	 * Modèle {@link ModeleSauvegardes} du controleur.
	 */
	protected ModeleSauvegardes modeleSauvegardes;

	/**
	 * Vue du controleur.
	 */
	protected Vue vue;

	/**
	 * Controleur {@link ControleurPrincipal} parent.
	 */
	protected ControleurPrincipal controleurParent;

	/*
	 * Constructeurs / Destructeur
	 */

	/**
	 * Constuit un controleur de gestion des objets.
	 * 
	 * @param controleurParent - Controleur parent.
	 * @param type - Type d'objets à gérer.
	 * @category Constructeur
	 */
	public ControleurAbstraitGestion(ControleurPrincipal controleurParent)
	{
		// Enregistre le controleur parent
		this.controleurParent = controleurParent;

		// Enregistre le modele dans le controleur
		this.modeleSauvegardes = this.controleurParent.getModeleSauvegardes();
		this.modeleDofus = this.controleurParent.getModeleDofus();
	}

	/*
	 * Traitements des notifications
	 */

	/**
	 * Traite la demande de sauvegarde.
	 * 
	 * @param sauvegarde - Classe représentant l'objet à sauvegarder.
	 */
	public abstract void notifierSauvegarde(Object sauvegarde);

	/**
	 * Traite la demande de création d'une nouvelle sauvegarde.
	 * 
	 * @param nom - Nom de sauvegarde de l'objet à créer.
	 */
	public abstract void notifierCreation(String nom);

	/**
	 * Traite la demande de suppression d'une sauvegarde.
	 * 
	 * @param sauvegarde - Classe représentant l'objet à supprimer.
	 */
	public abstract void notifierSuppression(Object sauvegarde);

	/**
	 * Traite la demande de fermeture de la vue.
	 */
	public abstract void notifierFermeture();

	/*
	 * Accesseurs
	 */

	/**
	 * Renvoie le modèle {@link ModeleDofus} du controleur.
	 * 
	 * @return Le modèle {@link ModeleDofus}.
	 * @category Accesseur
	 */
	public final ModeleDofus getModeleDofus()
	{
		return this.modeleDofus;
	}

	/**
	 * Renvoie le modèle {@link ModeleSauvegardes} du controleur.
	 * 
	 * @return Le modèle {@link ModeleSauvegardes}.
	 * @category Accesseur
	 */
	public final ModeleSauvegardes getModeleSauvegardes()
	{
		return this.modeleSauvegardes;
	}

	/**
	 * Renvoie la vue du controleur.
	 * 
	 * @return La vue.
	 * @category Accesseur
	 */
	public final Vue getVue()
	{
		return this.vue;
	}

	/**
	 * Renvoie le type d'objet à gérer par le controleur.
	 * 
	 * @return Le type d'objet.
	 * @category Accesseur
	 */
	public abstract Object getTypeObjet();
}