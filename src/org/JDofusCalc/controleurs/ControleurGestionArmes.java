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

import org.JDofusCalc.dofus.objets.Arme.FlagsTypesArmes;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeArme;
import org.JDofusCalc.observateurs.ObservateurSauvegardesArmes;
import org.JDofusCalc.vues.Qt.VQtGestionArmes;

/**
 * Controleur de gestion des armes.
 * 
 * @author PAPAYA Alexandre
 * @category Controleur
 * @version 1.0
 */
public class ControleurGestionArmes extends ControleurAbstraitGestion
{
	/*
	 * Variables d'instances
	 */
	
	/**
	 * Type de l'objet.
	 */
	protected FlagsTypesArmes typeObjet;
	
	/*
	 * Constructeurs / Destructeur
	 */
	
	/**
	 * Construit un controleur de gestion des armes.
	 * 
	 * @param controleurParent - Controleur parent.
	 * @param typeArme - Type de l'arme à gérer.
	 * @category Constructeur
	 */
	public ControleurGestionArmes(ControleurPrincipal controleurParent, FlagsTypesArmes typeArme)
	{
		super(controleurParent);
		this.typeObjet = typeArme;

		// Enregistre la vue dans le controleur
		this.vue = new VQtGestionArmes(this, this.controleurParent.getVue().getFenetre());
		this.modeleSauvegardes.addObservateurSauvegardesArmes((ObservateurSauvegardesArmes) this.vue);

		// Affiche la vue enregistrée
		this.vue.afficher();
	}

	/*
	 * Traitements des notifications
	 */

	@Override
	public void notifierSauvegarde(Object sauvegarde)
	{
		// Cast
		SauvegardeArme sauvegardeArme = (SauvegardeArme) sauvegarde;
		
		// Logger
		logger.trace("Notification d'une demande de sauvegarde d'une arme " + sauvegardeArme.getNom() + ".");

		if(!sauvegardeArme.getNom().equals(""))
		{
			this.modeleSauvegardes.sauvegarderArme(this.typeObjet, sauvegardeArme);
		}
		else
		{
			logger.error("Le nom de l'arme est vide.");
			this.vue.boiteDialogueAvert("Le nom de l'arme ne peut-être vide.");
		}
	}

	@Override
	public void notifierCreation(String nom)
	{
		// Logger
		logger.trace("Notification d'une demande de création d'une arme " + nom + ".");

		this.modeleSauvegardes.creerArme(this.typeObjet, nom);
	}

	@Override
	public void notifierSuppression(Object sauvegarde)
	{
		// Cast
		SauvegardeArme sauvegardeArme = (SauvegardeArme) sauvegarde;
		
		// Logger
		logger.trace("Notification d'une demande de suppression d'une arme " + sauvegardeArme.getNom() + ".");

		if(this.vue.boiteDialogueQuestion("Question", "Voulez vous vraiment supprimer '" + sauvegardeArme.getNom() + "' (" + this.typeObjet.getNom() + ") ?"))
		{
			this.modeleSauvegardes.supprimerArme(this.typeObjet, sauvegardeArme);
		}
	}

	@Override
	public void notifierFermeture()
	{
		// Logger
		logger.trace("Notification d'une demande de fermeture de la fenêtre de gestion des armes.");

		this.vue.fermer();
		this.modeleSauvegardes.removeObservateurSauvegardesArmes((ObservateurSauvegardesArmes) this.vue);
		this.vue = null;
		try
		{
			this.finalize();
		}
		catch(Throwable exception)
		{
			exception.printStackTrace();
		}
	}
	
	/*
	 * Accesseurs
	 */

	@Override
	public Object getTypeObjet()
	{
		return this.typeObjet;
	}
}