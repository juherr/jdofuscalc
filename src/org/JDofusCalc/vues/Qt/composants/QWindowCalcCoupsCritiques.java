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

import java.text.DecimalFormat;

import org.JDofusCalc.dofus.autres.Formules;
import org.JDofusCalc.vues.Qt.designer.UICalcCoupsCritiques;

import com.trolltech.qt.core.Qt;
import com.trolltech.qt.gui.QHeaderView;
import com.trolltech.qt.gui.QTableWidgetItem;
import com.trolltech.qt.gui.QWidget;
import com.trolltech.qt.gui.QHeaderView.ResizeMode;

/**
 * Fenêtre de calculs des coups critiques.
 * 
 * @author PAPAYA Alexandre
 * @category Fenêtre
 * @version 1.0
 */
public class QWindowCalcCoupsCritiques extends QWidget
{
	/*
	 * Variables d'instances
	 */

	/* Composants */

	/**
	 * L'interface graphique.
	 */
	public UICalcCoupsCritiques ui;

	/*
	 * Constructeurs / Destructeur
	 */

	/**
	 * Construit une nouvelle fenêtre.
	 * 
	 * @param parent - Fenêtre parente.
	 * @category Constructeur
	 */
	public QWindowCalcCoupsCritiques(QWidget parent)
	{
		// Execution du constructeur de la classe mère
		super(parent, Qt.WindowType.Window);

		// Initialisation de l'interface graphique
		this.ui = new UICalcCoupsCritiques();
		this.ui.setupUi(this);

		this.genererGrille();

		/* Connexions signal->slot */
		// Taux de CC
		this.ui.sbCCTauxBase.valueChanged.connect(this, "slotChangementTauxCC()");
		this.ui.sbCCBonusCC.valueChanged.connect(this, "slotChangementTauxCC()");
		this.ui.sbCCAgi.valueChanged.connect(this, "slotChangementTauxCC()");
		this.ui.btnCCgetAgi.clicked.connect(this, "slotCCGetAgilite()");
		this.ui.btnCCgetBonusCC.clicked.connect(this, "slotCCGetBonusCC()");
		// Agilité
		this.ui.sbAgiTauxBaseCC.valueChanged.connect(this, "slotChangementAgilite()");
		this.ui.sbAgiBonusCC.valueChanged.connect(this, "slotChangementAgilite()");
		this.ui.sbAgiTauxFinalCC.valueChanged.connect(this, "slotChangementAgilite()");
		this.ui.btnAgiGetBonusCC.clicked.connect(this, "slotAgiGetBonusCC()");
		// Autre
		this.ui.btnFermer.clicked.connect(this, "slotFermeture()");
	}
	
	/*
	 * Méthodes
	 */

	/**
	 * Génère la grille des coups critiques.
	 */
	private void genererGrille()
	{
		QHeaderView headerHonrizontal = this.ui.grille.horizontalHeader();
		headerHonrizontal.resizeSections(ResizeMode.Stretch);
		QHeaderView headerVertical = this.ui.grille.verticalHeader();
		headerVertical.resizeSections(ResizeMode.Stretch);

		int nbLignes = this.ui.grille.rowCount();
		int nbColonnes = this.ui.grille.columnCount();
		for(int i = 0; i < nbLignes; i++)
		{
			for(int j = 0; j < nbColonnes; j++)
			{
				int cc = Integer.parseInt(this.ui.grille.horizontalHeaderItem(j).text());
				int agilite = Integer.parseInt(this.ui.grille.verticalHeaderItem(i).text());
				QTableWidgetItem item = new QTableWidgetItem();
				item.setText(String.valueOf(Formules.getCoupsCritiques(cc, agilite, 0)));
				this.ui.grille.setItem(i, j, item);
			}
		}
	}

	/*
	 * Slots de la fenêtre
	 */

	/* Slot du calcul du taux de coups critiques */
	
	/**
	 * Gère le changement de la valeur du taux de coups critiques.
	 * 
	 * @category Slot
	 */
	public void slotChangementTauxCC()
	{
		this.ui.lblCCResultats.setText(String.valueOf(Formules.getCoupsCritiques(this.ui.sbCCTauxBase.value(), this.ui.sbCCAgi.value(), this.ui.sbCCBonusCC.value())));
	}

	/**
	 * Gère le changement de la valeur de l'agilité nécessaire.
	 * 
	 * @category Slot
	 */
	public void slotChangementAgilite()
	{
		long agilite = Formules.getAgilite(this.ui.sbAgiTauxBaseCC.value(), this.ui.sbAgiBonusCC.value(), this.ui.sbAgiTauxFinalCC.value());
		String sortie = "";
		if(agilite >= 10000)
		{
			DecimalFormat df = new DecimalFormat("0.###E0");
			sortie = df.format(agilite);
		}
		else
		{
			sortie = String.valueOf(agilite);
		}

		this.ui.lblAgiResultats.setText(sortie);
	}

	/**
	 * Gère la demande de récupération de l'agilité totale du personnage.
	 * 
	 * @category Slot
	 */
	public void slotCCGetAgilite()
	{
		QWindowPrincipale fenetrePrincipale = (QWindowPrincipale) this.parentWidget();
		this.ui.sbCCAgi.setValue(Integer.parseInt(fenetrePrincipale.ui.txtStatsAgi.text()));
	}

	/**
	 * Gère la demande de récupération des bonus aux coups critiques du personnage.
	 * 
	 * @category Slot
	 */
	public void slotCCGetBonusCC()
	{
		QWindowPrincipale fenetrePrincipale = (QWindowPrincipale) this.parentWidget();
		this.ui.sbCCBonusCC.setValue(Integer.parseInt(fenetrePrincipale.ui.txtStatsCC.text()));
	}

	/**
	 * Gère la demande de récupération des bonus aux coups critiques du personnage.
	 * 
	 * @category Slot
	 */
	public void slotAgiGetBonusCC()
	{
		QWindowPrincipale fenetrePrincipale = (QWindowPrincipale) this.parentWidget();
		this.ui.sbAgiBonusCC.setValue(Integer.parseInt(fenetrePrincipale.ui.txtStatsCC.text()));
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