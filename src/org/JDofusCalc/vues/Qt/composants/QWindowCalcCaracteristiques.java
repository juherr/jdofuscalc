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

import org.JDofusCalc.dofus.autres.Classe;
import org.JDofusCalc.dofus.autres.Paliers.TypePalier;
import org.JDofusCalc.dofus.sauvegardes.SauvegardePersonnage;
import org.JDofusCalc.vues.Qt.designer.UICalcCaracteristiques;

import com.trolltech.qt.core.Qt;
import com.trolltech.qt.gui.QHeaderView;
import com.trolltech.qt.gui.QTableWidgetItem;
import com.trolltech.qt.gui.QWidget;
import com.trolltech.qt.gui.QHeaderView.ResizeMode;

/**
 * Fenêtre de calculs des caractéristiques.
 * 
 * @author PAPAYA Alexandre
 * @category Fenêtre
 * @version 1.0
 */
public class QWindowCalcCaracteristiques extends QWidget
{
	/*
	 * Variables d'instances
	 */

	/* Composants */

	/**
	 * L'interface graphique.
	 */
	public UICalcCaracteristiques ui;

	/* Autres */
	
	/**
	 * La classe chargée.
	 */
	private Classe classe;
	
	/**
	 * La sauvegarde du personnage.
	 */
	private SauvegardePersonnage sauvegardePersonnage;

	/*
	 * Constructeurs / Destructeur
	 */

	/**
	 * Construit une nouvelle fenêtre.
	 * 
	 * @param classe - Classe chargée.
	 * @param sauvegardePersonnage  - Sauvegarde du personnage.
	 * @param parent - Fenêtre parente.
	 * @category Constructeur
	 */
	public QWindowCalcCaracteristiques(QWidget parent, Classe classe, SauvegardePersonnage sauvegardePersonnage)
	{
		// Execution du constructeur de la classe mère
		super(parent, Qt.WindowType.Window);
		this.classe = classe;
		this.sauvegardePersonnage = sauvegardePersonnage;

		// Initialisation de l'interface graphique
		this.ui = new UICalcCaracteristiques();
		this.ui.setupUi(this);

		this.ui.lblClasse.setText(classe.getNom());
		this.ui.lblVitaActuel.setText(String.valueOf(sauvegardePersonnage.getVitalite()));
		this.ui.sbVita.setMinimum(sauvegardePersonnage.getVitalite());
		this.ui.lblSagActuel.setText(String.valueOf(sauvegardePersonnage.getSagesse()));
		this.ui.sbSag.setMinimum(sauvegardePersonnage.getSagesse());
		this.ui.lblForceActuel.setText(String.valueOf(sauvegardePersonnage.getForce()));
		this.ui.sbForce.setMinimum(sauvegardePersonnage.getForce());
		this.ui.lblIntActuel.setText(String.valueOf(sauvegardePersonnage.getIntelligence()));
		this.ui.sbInt.setMinimum(sauvegardePersonnage.getIntelligence());
		this.ui.lblChanceActuel.setText(String.valueOf(sauvegardePersonnage.getChance()));
		this.ui.sbChance.setMinimum(sauvegardePersonnage.getChance());
		this.ui.lblAgiActuel.setText(String.valueOf(sauvegardePersonnage.getAgilite()));
		this.ui.sbAgi.setMinimum(sauvegardePersonnage.getAgilite());

		QTableWidgetItem item;
		String caracteristique;
		int row;

		caracteristique = "Sagesse";
		row = 1;
		item = new QTableWidgetItem(this.classe.getPaliers(caracteristique).getString(TypePalier.UnPourUn));
		this.ui.tableauPaliers.setItem(row, 1, item);
		item = new QTableWidgetItem(this.classe.getPaliers(caracteristique).getString(TypePalier.DeuxPourUn));
		this.ui.tableauPaliers.setItem(row, 2, item);
		item = new QTableWidgetItem(this.classe.getPaliers(caracteristique).getString(TypePalier.TroisPourUn));
		this.ui.tableauPaliers.setItem(row, 3, item);
		item = new QTableWidgetItem(this.classe.getPaliers(caracteristique).getString(TypePalier.QuatrePourUn));
		this.ui.tableauPaliers.setItem(row, 4, item);
		item = new QTableWidgetItem(this.classe.getPaliers(caracteristique).getString(TypePalier.CinqPourUn));
		this.ui.tableauPaliers.setItem(row, 5, item);

		caracteristique = "Force";
		row = 2;
		item = new QTableWidgetItem(this.classe.getPaliers(caracteristique).getString(TypePalier.UnPourUn));
		this.ui.tableauPaliers.setItem(row, 1, item);
		item = new QTableWidgetItem(this.classe.getPaliers(caracteristique).getString(TypePalier.DeuxPourUn));
		this.ui.tableauPaliers.setItem(row, 2, item);
		item = new QTableWidgetItem(this.classe.getPaliers(caracteristique).getString(TypePalier.TroisPourUn));
		this.ui.tableauPaliers.setItem(row, 3, item);
		item = new QTableWidgetItem(this.classe.getPaliers(caracteristique).getString(TypePalier.QuatrePourUn));
		this.ui.tableauPaliers.setItem(row, 4, item);
		item = new QTableWidgetItem(this.classe.getPaliers(caracteristique).getString(TypePalier.CinqPourUn));
		this.ui.tableauPaliers.setItem(row, 5, item);

		caracteristique = "Intelligence";
		row = 3;
		item = new QTableWidgetItem(this.classe.getPaliers(caracteristique).getString(TypePalier.UnPourUn));
		this.ui.tableauPaliers.setItem(row, 1, item);
		item = new QTableWidgetItem(this.classe.getPaliers(caracteristique).getString(TypePalier.DeuxPourUn));
		this.ui.tableauPaliers.setItem(row, 2, item);
		item = new QTableWidgetItem(this.classe.getPaliers(caracteristique).getString(TypePalier.TroisPourUn));
		this.ui.tableauPaliers.setItem(row, 3, item);
		item = new QTableWidgetItem(this.classe.getPaliers(caracteristique).getString(TypePalier.QuatrePourUn));
		this.ui.tableauPaliers.setItem(row, 4, item);
		item = new QTableWidgetItem(this.classe.getPaliers(caracteristique).getString(TypePalier.CinqPourUn));
		this.ui.tableauPaliers.setItem(row, 5, item);

		caracteristique = "Chance";
		row = 4;
		item = new QTableWidgetItem(this.classe.getPaliers(caracteristique).getString(TypePalier.UnPourUn));
		this.ui.tableauPaliers.setItem(row, 1, item);
		item = new QTableWidgetItem(this.classe.getPaliers(caracteristique).getString(TypePalier.DeuxPourUn));
		this.ui.tableauPaliers.setItem(row, 2, item);
		item = new QTableWidgetItem(this.classe.getPaliers(caracteristique).getString(TypePalier.TroisPourUn));
		this.ui.tableauPaliers.setItem(row, 3, item);
		item = new QTableWidgetItem(this.classe.getPaliers(caracteristique).getString(TypePalier.QuatrePourUn));
		this.ui.tableauPaliers.setItem(row, 4, item);
		item = new QTableWidgetItem(this.classe.getPaliers(caracteristique).getString(TypePalier.CinqPourUn));
		this.ui.tableauPaliers.setItem(row, 5, item);

		caracteristique = "Agilité";
		row = 5;
		item = new QTableWidgetItem(this.classe.getPaliers(caracteristique).getString(TypePalier.UnPourUn));
		this.ui.tableauPaliers.setItem(row, 1, item);
		item = new QTableWidgetItem(this.classe.getPaliers(caracteristique).getString(TypePalier.DeuxPourUn));
		this.ui.tableauPaliers.setItem(row, 2, item);
		item = new QTableWidgetItem(this.classe.getPaliers(caracteristique).getString(TypePalier.TroisPourUn));
		this.ui.tableauPaliers.setItem(row, 3, item);
		item = new QTableWidgetItem(this.classe.getPaliers(caracteristique).getString(TypePalier.QuatrePourUn));
		this.ui.tableauPaliers.setItem(row, 4, item);
		item = new QTableWidgetItem(this.classe.getPaliers(caracteristique).getString(TypePalier.CinqPourUn));
		this.ui.tableauPaliers.setItem(row, 5, item);

		caracteristique = "Vitalité";
		row = 0;
		item = new QTableWidgetItem(this.classe.getPaliers(caracteristique).getString(TypePalier.UnPourUn));
		this.ui.tableauPaliers.setItem(row, 1, item);
		item = new QTableWidgetItem(this.classe.getPaliers(caracteristique).getString(TypePalier.DeuxPourUn));
		this.ui.tableauPaliers.setItem(row, 2, item);
		item = new QTableWidgetItem(this.classe.getPaliers(caracteristique).getString(TypePalier.TroisPourUn));
		this.ui.tableauPaliers.setItem(row, 3, item);
		item = new QTableWidgetItem(this.classe.getPaliers(caracteristique).getString(TypePalier.QuatrePourUn));
		this.ui.tableauPaliers.setItem(row, 4, item);
		item = new QTableWidgetItem(this.classe.getPaliers(caracteristique).getString(TypePalier.CinqPourUn));
		this.ui.tableauPaliers.setItem(row, 5, item);
		if(!this.classe.getPaliers(caracteristique).getString(TypePalier.UnPourDeux).equals(""))
		{
			item = new QTableWidgetItem(this.classe.getPaliers(caracteristique).getString(TypePalier.UnPourDeux));
			this.ui.tableauPaliers.setItem(row, 0, item);
		}
		else
		{
			this.ui.tableauPaliers.horizontalHeader().hideSection(0);
		}

		QHeaderView headerHonrizontal = this.ui.tableauPaliers.horizontalHeader();
		headerHonrizontal.resizeSections(ResizeMode.ResizeToContents);
		QHeaderView headerVertical = this.ui.tableauPaliers.verticalHeader();
		headerVertical.resizeSections(ResizeMode.ResizeToContents);

		/* Connexions signal->slot */
		this.ui.sbVita.valueChanged.connect(this, "slotChangementVita()");
		this.ui.sbSag.valueChanged.connect(this, "slotChangementSag()");
		this.ui.sbForce.valueChanged.connect(this, "slotChangementForce()");
		this.ui.sbInt.valueChanged.connect(this, "slotChangementInt()");
		this.ui.sbChance.valueChanged.connect(this, "slotChangementChance()");
		this.ui.sbAgi.valueChanged.connect(this, "slotChangementAgi()");
		this.ui.btnFermer.clicked.connect(this, "slotFermeture()");
	}
	
	/*
	 * Méthodes
	 */

	/**
	 * Met à jour toute la fenêtre.
	 */
	private void updateTotal()
	{
		int vitalite = Integer.parseInt(this.ui.lblVitaPoints.text());
		int sagesse = Integer.parseInt(this.ui.lblSagPoints.text());
		int force = Integer.parseInt(this.ui.lblForcePoints.text());
		int intelligence = Integer.parseInt(this.ui.lblIntPoints.text());
		int chance = Integer.parseInt(this.ui.lblChancePoints.text());
		int agilite = Integer.parseInt(this.ui.lblAgiPoints.text());
		int total = vitalite + sagesse + force + intelligence + chance + agilite;
		this.ui.lblCoutTotal.setText(String.valueOf(total));
		this.ui.lblNiveaux.setText("Soit <strong>" + (int) Math.ceil((double) total / 5) + " niveau(x)</strong>.");
	}

	/*
	 * Slots de la fenêtre
	 */

	/**
	 * Gère le changement valeur de la caractéristique "vitalité".
	 * 
	 * @category Slot
	 */
	public void slotChangementVita()
	{
		this.ui.lblVitaPoints.setText(String.valueOf(this.classe.getPaliers("Vitalité").calculerCout(this.sauvegardePersonnage.getVitalite(), this.ui.sbVita.value())));
		this.updateTotal();
	}

	/**
	 * Gère le changement valeur de la caractéristique "sagesse".
	 * 
	 * @category Slot
	 */
	public void slotChangementSag()
	{
		this.ui.lblSagPoints.setText(String.valueOf(this.classe.getPaliers("Sagesse").calculerCout(this.sauvegardePersonnage.getSagesse(), this.ui.sbSag.value())));
		this.updateTotal();
	}

	/**
	 * Gère le changement valeur de la caractéristique "force".
	 * 
	 * @category Slot
	 */
	public void slotChangementForce()
	{
		this.ui.lblForcePoints.setText(String.valueOf(this.classe.getPaliers("Force").calculerCout(this.sauvegardePersonnage.getForce(), this.ui.sbForce.value())));
		this.updateTotal();
	}

	/**
	 * Gère le changement valeur de la caractéristique "intelligence".
	 * 
	 * @category Slot
	 */
	public void slotChangementInt()
	{
		this.ui.lblIntPoints.setText(String.valueOf(this.classe.getPaliers("Intelligence").calculerCout(this.sauvegardePersonnage.getIntelligence(), this.ui.sbInt.value())));
		this.updateTotal();
	}
	
	/**
	 * Gère le changement valeur de la caractéristique "chance".
	 * 
	 * @category Slot
	 */
	public void slotChangementChance()
	{
		this.ui.lblChancePoints.setText(String.valueOf(this.classe.getPaliers("Chance").calculerCout(this.sauvegardePersonnage.getChance(), this.ui.sbChance.value())));
		this.updateTotal();
	}

	/**
	 * Gère le changement valeur de la caractéristique "agilité".
	 * 
	 * @category Slot
	 */
	public void slotChangementAgi()
	{
		this.ui.lblAgiPoints.setText(String.valueOf(this.classe.getPaliers("Agilité").calculerCout(this.sauvegardePersonnage.getAgilite(), this.ui.sbAgi.value())));
		this.updateTotal();
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