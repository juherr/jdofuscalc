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

import java.util.HashMap;
import java.util.Map.Entry;

import org.JDofusCalc.dofus.autres.Effets;
import org.JDofusCalc.dofus.objets.Panoplie;
import org.JDofusCalc.vues.Qt.designer.UIBonusPanoplies;

import com.trolltech.qt.core.Qt;
import com.trolltech.qt.gui.QWidget;

/**
 * Fenêtre des bonus des panoplies.
 * 
 * @author PAPAYA Alexandre
 * @category Fenêtre
 * @version 1.0
 */
public class QWindowBonusPanoplies extends QWidget
{
	/*
	 * Variables d'instances
	 */

	/* Composants */

	/**
	 * L'interface graphique.
	 */
	private UIBonusPanoplies ui;

	/*
	 * Constructeurs / Destructeur
	 */

	/**
	 * Construit une nouvelle fenêtre.
	 * 
	 * @param parent - Fenêtre parente.
	 * @category Constructeur
	 */
	public QWindowBonusPanoplies(QWidget parent)
	{
		// Execution du constructeur de la classe mère
		super(parent, Qt.WindowType.Window);

		// Initialisation de l'interface graphique
		this.ui = new UIBonusPanoplies();
		this.ui.setupUi(this);
		
		/* Connexions signal->slot */
		this.ui.btnFermer.clicked.connect(this, "slotFermeture()");
		this.ui.cmbPanoplies.currentIndexChanged.connect(this, "slotChangementPanoplies(int)");
	}
	
	/*
	 * Méthodes d'affichage des données de la fenêtre
	 */
	
	/**
	 * Définit la liste des panoplies.
	 * 
	 * @param panoplies - La liste des panoplies.
	 */
	public void setListePanoplies(HashMap<Integer, Panoplie> panoplies)
	{
		this.ui.cmbPanoplies.blockSignals(true);
		
		// Vide le combo
		this.ui.cmbPanoplies.clear();

		this.ui.cmbPanoplies.addItem("<Aucune>");
		this.ui.cmbPanoplies.setItemData(0, panoplies);

		int i = 1;
		for(Entry<Integer, Panoplie> entry : panoplies.entrySet())
		{
			Panoplie panoplie = entry.getValue();
			// Ajoute l'item dans le combo
			this.ui.cmbPanoplies.addItem(panoplie.getNom());
			// Enregistre les données de la panoplie
			this.ui.cmbPanoplies.setItemData(i, panoplie);

			i++;
		}
		
		this.slotChangementPanoplies(0);
		this.ui.cmbPanoplies.blockSignals(false);
		this.ui.filtre.setCombo(this.ui.cmbPanoplies);
	}

	/*
	 * Slots de la fenêtre
	 */
	
	public void slotChangementPanoplies(int index)
	{
		HashMap<Integer, QWidgetBonusPanopliesLigne> lignes = new HashMap<Integer, QWidgetBonusPanopliesLigne>();
		lignes.put(1, this.ui.ligne1);
		lignes.put(2, this.ui.ligne2);
		lignes.put(3, this.ui.ligne3);
		lignes.put(4, this.ui.ligne4);
		lignes.put(5, this.ui.ligne5);
		lignes.put(6, this.ui.ligne6);
		lignes.put(7, this.ui.ligne7);
		lignes.put(8, this.ui.ligne8);
		
		if(index != 0)
		{
			Panoplie panoplie = (Panoplie) this.ui.cmbPanoplies.itemData(index);
			this.ui.lblNom.setText(panoplie.getNom());
			
			for(int i = 1; i <= 8; i++)
			{
				Effets bonus = panoplie.getBonus(i);
				QWidgetBonusPanopliesLigne ligne = lignes.get(i);
				
				if(bonus != null)
				{
					ligne.setVisible(true);
					ligne.afficherDonnees(bonus);
				}
				else
				{
					ligne.setVisible(false);
				}
			}
		}
		else
		{
			this.ui.lblNom.setText("Aucune panoplie sélectionnée");
			for(int i = 1; i <= 8; i++)
			{
				QWidgetBonusPanopliesLigne ligne = lignes.get(i);
				ligne.setVisible(false);
			}
		}

		this.resize(this.minimumSizeHint());
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