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

import org.JDofusCalc.dofus.sauvegardes.SauvegardePersonnage;
import org.JDofusCalc.modeles.ModeleSauvegardes;
import org.JDofusCalc.vues.Vue;
import org.JDofusCalc.vues.Qt.VQtSauvegardesPersonnages;

/**
 * Controleur des sauvegardes des personnages.
 * 
 * @author PAPAYA Alexandre
 * @category Controleur
 * @version 1.0
 */
public class ControleurSauvegardesPersonnages extends Controleur
{
	/*
	 * Constantes
	 */

	/**
	 * Constante du mode de sauvegarde.
	 */
	public final static int MODE_SAUVEGARDE = 0x01;

	/**
	 * Constante du mode de chargement.
	 */
	public final static int MODE_CHARGEMENT = 0x02;

	/**
	 * Modèle {@link ModeleSauvegardes} du controleur.
	 */
	private ModeleSauvegardes modele;

	/**
	 * Vue {@link VQtSauvegardesPersonnages} du controleur.
	 */
	private VQtSauvegardesPersonnages vue = null;

	/**
	 * Controleur {@link ControleurPrincipal} parent.
	 */
	private ControleurPrincipal controleurParent;

	/*
	 * Constructeurs / Destructeur
	 */

	/**
	 * Constuit un controleur des sauvegardes des personnages avec un mode défini.
	 * 
	 * @param controleurParent - Controleur parent.
	 * @param mode - Mode du controleur (sauvegarde ou chargement).
	 * @category Constructeur
	 */
	public ControleurSauvegardesPersonnages(ControleurPrincipal controleurParent, int mode)
	{
		// Enregistre le controleur parent dans ce ce controleur
		this.controleurParent = controleurParent;

		// Enregistre le modele dans le controleur
		this.modele = this.controleurParent.getModeleSauvegardes();

		// Enregistre la vue dans le controleur
		if(mode == MODE_SAUVEGARDE)
			this.vue = new VQtSauvegardesPersonnages(this, controleurParent.getVue().getFenetre(), mode, controleurParent.getModeleCalculateur().getSauvegardePersonnage());
		else
			this.vue = new VQtSauvegardesPersonnages(this, controleurParent.getVue().getFenetre(), mode);
		this.modele.addObservateurSauvegardesPersonnages(this.vue);

		// Affiche la vue enregistrée
		this.vue.afficher();
	}

	/*
	 * Traitements des actions
	 */

	/**
	 * Traite la demande de sauvegarde d'un personnage.
	 * 
	 * @param nomSauvegarde - Nom de la sauvegarde.
	 */
	public void notifierSauvegardePersonnage(String nomSauvegarde)
	{
		nomSauvegarde = nomSauvegarde.trim();
		
		// Logger
		logger.trace("Notification d'une demande de sauvegarde d'un personnage. Nom = " + nomSauvegarde + ".");

		if(!nomSauvegarde.equals(""))
		{
			boolean existe = this.modele.existsSauvegardePersonnage(nomSauvegarde);
			
			if(!existe || this.vue.boiteDialogueQuestion("Cette sauvegarde existe déjà, voulez-vous l'écraser ?"))
			{
				SauvegardePersonnage sauvegarde = this.controleurParent.getModeleCalculateur().getSauvegardePersonnage();
				sauvegarde.setNom(nomSauvegarde);
				this.controleurParent.notifierSauvegardePersonnage(sauvegarde);
			}
		}
		else
		{
			logger.error("Le nom de la sauvegarde est vide.");
			this.vue.boiteDialogueErreur("Le nom de la sauvegarde ne peut être vide.");
		}
	}

	/**
	 * Traite la demande de suppression d'une sauvegarde d'un personnage.
	 * 
	 * @param sauvegarde - Classe représentant la sauvegarde du personnage à supprimer.
	 */
	public void notifierSuppressionSauvegarde(SauvegardePersonnage sauvegarde)
	{
		// Logger
		logger.trace("Notification d'une demande de suppression d'une sauvegarde d'un personnage. Personnage = " + sauvegarde.getNom() + ".");

		if(this.vue.boiteDialogueQuestion("Sauvegarde", "Voulez-vous vraiment supprimer la sauvegarde '" + sauvegarde.getNom() + "' ?"))
		{
			if(this.modele.supprimerSauvegardePersonnage(sauvegarde))
			{
				this.vue.boiteDialogueInfo("Sauvegarde", "La sauvegarde " + sauvegarde.getNom() + " a bien été supprimée.");
			}
		}
	}

	/**
	 * Traite la demande de renommage d'une sauvegarde d'un personnage.
	 * 
	 * @param sauvegarde - Classe représentant la sauvegarde du personnage à renommer.
	 * @param nouveauNom - Nouveau nom de la sauvegarde.
	 */
	public void notifierRenommageSauvegarde(SauvegardePersonnage sauvegarde, String nouveauNom)
	{
		// Logger
		logger.trace("Notification d'une demande de renommage d'une sauvegarde d'un personnage. Ancien nom = " + sauvegarde.getNom() + ", Nouveau nom = " + nouveauNom + ".");

		if(!nouveauNom.equals(""))
		{
			if(!this.modele.existsSauvegardePersonnage(nouveauNom))
			{
				if(this.modele.renommerSauvegardePersonnage(sauvegarde, nouveauNom))
				{
					this.vue.boiteDialogueInfo("Sauvegarde", "La sauvegarde " + sauvegarde.getNom() + " a bien été renommée en " + nouveauNom + ".");
				}
			}
			else
			{
				logger.error("Le nom de la sauvegarde existe déjà.");
				this.vue.boiteDialogueAvert("Ce nom de sauvegarde existe déjà.");
			}
		}
	}

	/**
	 * Traite la demande de chargement d'une sauvegarde d'un personnage.
	 * 
	 * @param sauvegarde - Classe représentant la sauvegarde du personnage à charger.
	 */
	public void notifierChargementSauvegarde(SauvegardePersonnage sauvegarde)
	{
		this.controleurParent.notifierChargementPersonnage(sauvegarde);
		this.vue.fermer();
	}

	/*
	 * Accesseurs
	 */

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
	 * Renvoie le modèle {@link ModeleSauvegardes} du controleur.
	 * 
	 * @return Le modèle {@link ModeleSauvegardes}.
	 * @category Accesseur
	 */
	public final ModeleSauvegardes getModeleSauvegardes()
	{
		return this.modele;
	}
}