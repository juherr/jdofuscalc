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

package org.JDofusCalc.vues.Qt.composants;

import org.JDofusCalc.dofus.autres.Formules;
import org.JDofusCalc.vues.Qt.designer.UICalcTacle;

import com.trolltech.qt.core.Qt;
import com.trolltech.qt.gui.QWidget;

/**
 * Fenêtre de calculs des coups critiques.
 * 
 * @author PAPAYA Alexandre
 * @category Fenêtre
 * @version 1.0
 */
public class QWindowCalcTacle extends QWidget
{
	/*
	 * Variables d'instances
	 */

	/* Composants */

	/**
	 * L'interface graphique.
	 */
	public UICalcTacle ui;

	/*
	 * Constructeurs / Destructeur
	 */

	/**
	 * Construit une nouvelle fenêtre.
	 * 
	 * @param parent - Fenêtre parente.
	 * @category Constructeur
	 */
	public QWindowCalcTacle(QWidget parent)
	{
		// Execution du constructeur de la classe mère
		super(parent, Qt.WindowType.Window);

		// Initialisation de l'interface graphique
		this.ui = new UICalcTacle();
		this.ui.setupUi(this);
		this.slotChangementProbabilite();

		/* Connexions signal->slot */
		// Taux de CC
		this.ui.sbAgiAdv.valueChanged.connect(this, "slotChangementProbabilite()");
		this.ui.sbAgiPerso.valueChanged.connect(this, "slotChangementProbabilite()");
		this.ui.btnGetAgi.clicked.connect(this, "slotGetAgilite()");
		// Autre
		this.ui.btnFermer.clicked.connect(this, "slotFermeture()");
	}
	
	/*
	 * Méthodes
	 */

	// Vide
	
	/*
	 * Slots de la fenêtre
	 */

	/* Slot du calcul du taux de coups critiques */
	
	/**
	 * Gère le changement des valeurs des variables de calcul de la probabilité.
	 * 
	 * @category Slot
	 */
	public void slotChangementProbabilite()
	{
		int proba = Formules.getProbabiliteTacle(this.ui.sbAgiPerso.value(), this.ui.sbAgiAdv.value());
		QWindowPrincipale fenetrePrincipale = (QWindowPrincipale) this.parentWidget();
		this.ui.lblResProbaTacle.setText(String.valueOf(proba).concat("%"));
		this.ui.lblResPA.setText(String.valueOf(Formules.getNombrePATacle(Integer.parseInt(fenetrePrincipale.ui.txtStatsPA.text()), proba)));
	}

	/**
	 * Gère la demande de récupération de l'agilité totale du personnage.
	 * 
	 * @category Slot
	 */
	public void slotGetAgilite()
	{
		QWindowPrincipale fenetrePrincipale = (QWindowPrincipale) this.parentWidget();
		this.ui.sbAgiPerso.setValue(Integer.parseInt(fenetrePrincipale.ui.txtStatsAgi.text()));
	}

	/**
	 * Ferme la fenêtre.
	 * 
	 * @category Slot
	 */
	public void slotFermeture()
	{
		this.close();
	}
}