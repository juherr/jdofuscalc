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

package org.JDofusCalc.vues.Qt;

import java.util.ArrayList;
import java.util.HashMap;

import org.JDofusCalc.controleurs.ControleurExportation;
import org.JDofusCalc.dofus.objets.Arme.FlagsTypesArmes;
import org.JDofusCalc.dofus.objets.Dofus.FlagsTypesDofus;
import org.JDofusCalc.dofus.objets.Equipement.FlagsTypesEquipements;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeArme;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeDofus;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeEquipement;
import org.JDofusCalc.vues.Qt.composants.QWindowExportation;

import com.trolltech.qt.gui.QWidget;

/**
 * Vue de la fenêtre d'exportation des données.
 *
 * @author PAPAYA Alexandre
 * @category Vue
 * @version 1.0
 */
public class VQtExportation extends VueQt
{
	/*
	 * Variables d'instances
	 */
	
	/**
	 * Fenêtre de la vue.
	 */
	private QWindowExportation fenetre;
	
	/**
	 * Controleur de la vue.
	 */
	private ControleurExportation controleur;
	
	/**
	 * Vue parente.
	 */
	private VQtPrincipale vueParente;
	
	/*
	 * Constructeurs / Destructeur
	 */
	
	/**
	 * Construit une nouvelle vue.
	 * 
	 * @param controleur - Controleur de la vue.
	 * @category Constructeur
	 */
	public VQtExportation(ControleurExportation controleur, VQtPrincipale vueParente)
	{
		// Enregistrement du controleur
		this.controleur = controleur;
		
		// Enregistrement de la vue parente
		this.vueParente = vueParente;

		// Enregistrement de la fenetre
		this.fenetre = new QWindowExportation(this.vueParente.getFenetre());
		
		/* Génération de la liste des sauvegardes */
			// Personnages
		this.fenetre.setListeSauvegardesPersonnages(this.controleur.getModeleSauvegardes().getSauvegardesPersonnages());
			// Equipements
		HashMap<FlagsTypesEquipements, ArrayList<SauvegardeEquipement>> equipements = new HashMap<FlagsTypesEquipements, ArrayList<SauvegardeEquipement>>();
		equipements.put(FlagsTypesEquipements.Amulette, this.controleur.getModeleSauvegardes().getSauvegardesEquipements(FlagsTypesEquipements.Amulette));
		equipements.put(FlagsTypesEquipements.Anneau, this.controleur.getModeleSauvegardes().getSauvegardesEquipements(FlagsTypesEquipements.Anneau));
		equipements.put(FlagsTypesEquipements.Bottes, this.controleur.getModeleSauvegardes().getSauvegardesEquipements(FlagsTypesEquipements.Bottes));
		equipements.put(FlagsTypesEquipements.Coiffe, this.controleur.getModeleSauvegardes().getSauvegardesEquipements(FlagsTypesEquipements.Coiffe));
		equipements.put(FlagsTypesEquipements.Cape, this.controleur.getModeleSauvegardes().getSauvegardesEquipements(FlagsTypesEquipements.Cape));
		equipements.put(FlagsTypesEquipements.Ceinture, this.controleur.getModeleSauvegardes().getSauvegardesEquipements(FlagsTypesEquipements.Ceinture));
		equipements.put(FlagsTypesEquipements.Bouclier, this.controleur.getModeleSauvegardes().getSauvegardesEquipements(FlagsTypesEquipements.Bouclier));
		this.fenetre.setListeSauvegardesEquipements(equipements);
			// Armes
		HashMap<FlagsTypesArmes, ArrayList<SauvegardeArme>> armes = new HashMap<FlagsTypesArmes, ArrayList<SauvegardeArme>>();
		for(FlagsTypesArmes flag : FlagsTypesArmes.values())
		{
			armes.put(flag, this.controleur.getModeleSauvegardes().getSauvegardesArmes(flag));
		}
		this.fenetre.setListeSauvegardesArmes(armes);
			// Dofus
		HashMap<FlagsTypesDofus, ArrayList<SauvegardeDofus>> dofus = new HashMap<FlagsTypesDofus, ArrayList<SauvegardeDofus>>();
		for(FlagsTypesDofus flag : FlagsTypesDofus.values())
		{
			dofus.put(flag, this.controleur.getModeleSauvegardes().getSauvegardesDofus(flag));
		}
		this.fenetre.setListeSauvegardesDofus(dofus);
			// Animaux
		this.fenetre.setListeSauvegardesFamiliers(this.controleur.getModeleSauvegardes().getSauvegardesFamiliers());
		this.fenetre.setListeSauvegardesMontures(this.controleur.getModeleSauvegardes().getSauvegardesMontures());
		
		/* Connexions signal->slot */
	}
	
	/*
	 * Méthodes heritées
	 */

	@Override
	public void afficher()
	{
		VueQt.centrerFenetre(this.fenetre);
		this.fenetre.show();
	}

	@Override
	public void fermer()
	{
		this.fenetre.close();
	}

	/*
	 * Accesseurs
	 */
	
	@Override
	public QWidget getFenetre()
	{
		return this.fenetre;
	}
}
