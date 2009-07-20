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
import org.JDofusCalc.dofus.autres.Formules.Potion;
import org.JDofusCalc.vues.Qt.designer.UIForgemage;

import com.trolltech.qt.core.Qt;
import com.trolltech.qt.gui.QWidget;

/**
 * Fenêtre de forgemagie.
 * 
 * @author PAPAYA Alexandre
 * @category Fenêtre
 * @version 1.0
 */
public class QWindowForgemage extends QWidget
{
	/*
	 * Variables d'instances
	 */

	/* Composants */

	/**
	 * L'interface graphique.
	 */
	public UIForgemage ui;

	/* Autres */
	
	/**
	 * Jet minimum de l'arme.
	 */
	int jetMin;
	/**
	 * Jet maximum de l'arme.
	 */
	int jetMax;

	/*
	 * Constructeurs / Destructeur
	 */

	/**
	 * Construit une nouvelle fenêtre.
	 * 
	 * @param parent - Fenêtre parente.
	 * @param jetMin - Jet minimum de l'arme.
	 * @param jetMax  - Jet maximum de l'arme.
	 * @category Constructeur
	 */
	public QWindowForgemage(QWidget parent, int jetMin, int jetMax)
	{
		// Execution du constructeur de la classe mère
		super(parent, Qt.WindowType.Window);
		this.jetMin = jetMin;
		this.jetMax = jetMax;

		// Initialisation de l'interface graphique
		this.ui = new UIForgemage();
		this.ui.setupUi(this);

		this.ui.lblJetsMin.setText(String.valueOf(jetMin));
		this.ui.lblJetsMax.setText(String.valueOf(jetMax));
		this.slotChangementPuissance();

		/* Connexions signal->slot */
		this.ui.btnFermer.clicked.connect(this, "slotFermeture()");
		this.ui.btnForgemager.clicked.connect(this, "slotForgemage()");
		this.ui.rbtnPForte.toggled.connect(this, "slotChangementPuissance()");
		this.ui.rbtnPMoy.toggled.connect(this, "slotChangementPuissance()");
		this.ui.rbtnPFaible.toggled.connect(this, "slotChangementPuissance()");
	}

	/*
	 * Slots de la fenêtre
	 */

	/**
	 * Gère le changement de la puissance de la potion.
	 * 
	 * @category Slot
	 */
	public void slotChangementPuissance()
	{
		Potion puissance = null;
		if(this.ui.rbtnPForte.isChecked())
		{
			puissance = Potion.Forte;
		}
		else if(this.ui.rbtnPMoy.isChecked())
		{
			puissance = Potion.Moyenne;
		}
		else if(this.ui.rbtnPFaible.isChecked())
		{
			puissance = Potion.Faible;
		}

		this.ui.lblJetsMinFM.setText(String.valueOf(Formules.getJetMinimumForgemage(this.jetMin, puissance)));
		this.ui.lblJetsMaxFM.setText(String.valueOf(Formules.getJetMaximumForgemage(this.jetMin, this.jetMax, puissance)));
	}

	/**
	 * Charge les données de la forgemagie dans la fenêtre parente.
	 * 
	 * @category Slot
	 */
	public void slotForgemage()
	{
		QWindowGestionArmes fenetreArme = (QWindowGestionArmes) this.parentWidget();
		fenetreArme.ui.txtMinL1.setText(this.ui.lblJetsMinFM.text());
		fenetreArme.ui.txtMaxL1.setText(this.ui.lblJetsMaxFM.text());
		if(this.ui.rbtnTerre.isChecked())
		{
			fenetreArme.ui.comboTypeL1.setCurrentIndex(1);
		}
		else if(this.ui.rbtnFeu.isChecked())
		{
			fenetreArme.ui.comboTypeL1.setCurrentIndex(2);
		}
		else if(this.ui.rbtnEau.isChecked())
		{
			fenetreArme.ui.comboTypeL1.setCurrentIndex(3);
		}
		else if(this.ui.rbtnAir.isChecked())
		{
			fenetreArme.ui.comboTypeL1.setCurrentIndex(4);
		}

		this.slotFermeture();
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