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

import org.JDofusCalc.controleurs.ControleurGestionEquipement;
import org.JDofusCalc.dofus.objets.Equipement.FlagsTypesEquipements;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeEquipement;
import org.JDofusCalc.observateurs.ObservateurSauvegardesEquipements;
import org.JDofusCalc.vues.Qt.composants.QWindowGestionEquipement;
import org.JDofusCalc.vues.Qt.composants.QWindowPrincipale;

import com.trolltech.qt.core.Qt.ItemDataRole;
import com.trolltech.qt.gui.QListWidgetItem;

/**
 * Vue de gestion des équipements.
 * 
 * @author PAPAYA Alexandre
 * @category Vue
 * @version 1.0
 */
public class VQtGestionEquipement extends VQtAbstraiteGestion implements ObservateurSauvegardesEquipements
{
	/*
	 * Variables d'instances
	 */

	/**
	 * Fenêtre de la vue.
	 */
	private QWindowGestionEquipement fenetre;

	/*
	 * Constructeurs / Destructeur
	 */

	/**
	 * Construit une nouvelle vue.
	 * 
	 * @param controleur - Controleur de la vue.
	 * @param parent - Fenêtre parente de la fenêtre de la vue.
	 * @category Constructeur
	 */
	public VQtGestionEquipement(ControleurGestionEquipement controleur, QWindowPrincipale fenetreParente)
	{
		super(controleur);

		// Enregistrement de la fenetre
		this.fenetre = new QWindowGestionEquipement(fenetreParente, (FlagsTypesEquipements) this.controleur.getTypeObjet());

		// Génération des données de la vue
		this.fenetre.setListePanoplies(this.controleur.getModeleDofus().getPanoplies());
		this.fenetre.setListeClasses(this.controleur.getModeleDofus().getClasses());
		this.fenetre.setListeModelesEquipements(this.controleur.getModeleDofus().getModelesEquipements((FlagsTypesEquipements) this.controleur.getTypeObjet()));
		this.fenetre.setListeSauvegardesEquipements(this.controleur.getModeleSauvegardes().getSauvegardesEquipements((FlagsTypesEquipements) this.controleur.getTypeObjet()));

		/* Connexions signal->slot */
		this.fenetre.signalSauvergarderEquipement.connect(this.controleur, "notifierSauvegarde(Object)");
		this.fenetre.signalSupprimerEquipement.connect(this.controleur, "notifierSuppression(Object)");
		this.fenetre.signalCreerEquipement.connect(this.controleur, "notifierCreation(String)");
		this.fenetre.signalFermer.connect(this.controleur, "notifierFermeture()");
	}

	/*
	 * Méthodes heritées
	 */

	public void creationEquipement(FlagsTypesEquipements typeEquipement, SauvegardeEquipement sauvegarde)
	{
		this.fenetre.setListeSauvegardesEquipements(this.controleur.getModeleSauvegardes().getSauvegardesEquipements((FlagsTypesEquipements) this.controleur.getTypeObjet()));
	}

	public void sauvegardeEquipement(FlagsTypesEquipements typeEquipement, SauvegardeEquipement sauvegarde)
	{
		QListWidgetItem item = this.fenetre.ui.listeEquip.currentItem();
		item.setData(ItemDataRole.UserRole, sauvegarde);
		item.setText(sauvegarde.getNom());
	}

	public void suppressionSauvegardeEquipement(FlagsTypesEquipements typeEquipement, SauvegardeEquipement sauvegarde)
	{
		this.fenetre.setListeSauvegardesEquipements(this.controleur.getModeleSauvegardes().getSauvegardesEquipements((FlagsTypesEquipements) this.controleur.getTypeObjet()));
	}

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

	/**
	 * Renvoie {@code fenetre}.
	 * 
	 * @return La fenêtre de la vue.
	 * @category Accesseur
	 */
	public final QWindowGestionEquipement getFenetre()
	{
		return this.fenetre;
	}
}