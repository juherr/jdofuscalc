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

import org.JDofusCalc.vues.Qt.designer.UIFiltre;

import com.trolltech.qt.core.Qt;
import com.trolltech.qt.gui.QComboBox;
import com.trolltech.qt.gui.QWidget;

/**
 * Ligne des bonus des panoplies.
 * 
 * @author PAPAYA Alexandre
 * @category Composant
 * @version 1.0
 */
public class QWidgetFiltre extends QWidget
{
	/*
	 * Variables d'instances
	 */
	
	/* Composants */

	/**
	 * L'interface graphique.
	 */
	private UIFiltre ui;
	
	/**
	 * Référence vers le combobox à filtrer.
	 */
	private QComboBox combo;
	
	/* Autres */

	private HashMap<String, Object> items;

	/*
	 * Constructeurs / Destructeur
	 */

	/**
	 * Construit un nouveau composant.
	 * 
	 * @param parent - Composant parent.
	 * @category Constructeur
	 */
	public QWidgetFiltre(QWidget parent)
	{
		// Execution du constructeur de la classe mère
		super(parent);	
		this.items = new HashMap<String, Object>();

		// Initialisation de l'interface graphique
		this.ui = new UIFiltre();
		this.ui.setupUi(this);
		
		/* Connexions signal->slot */
		this.ui.cboxFiltre.stateChanged.connect(this, "slotActivation()");
		this.ui.txtFiltre.textChanged.connect(this, "slotFiltrage(String)");
		this.ui.btnEffacer.clicked.connect(this, "slotEffacer()");
	}
	
	/*
	 * Slots du composant
	 */
	
	/**
	 * Gère l'activation ou la désactivation du composant par la QCheckBox.
	 * 
	 * @category Slot
	 */
	public void slotActivation()
	{
		if(this.ui.cboxFiltre.isChecked())
		{
			this.ui.txtFiltre.setEnabled(true);
			this.ui.btnEffacer.setEnabled(true);
		}
		else
		{
			this.ui.txtFiltre.setEnabled(false);
			this.ui.btnEffacer.setEnabled(false);
		}
		
		this.slotFiltrage(this.ui.txtFiltre.text());
	}
	
	/**
	 * Gère le filtrage du QComboBox définit.
	 * 
	 * @category Slot
	 */
	public void slotFiltrage(String clef)
	{
		if(this.combo != null)
		{
			this.combo.blockSignals(true);
			this.combo.clear();
			this.combo.addItem("<Aucune sélection>");
			for(Entry<String, Object> entry : this.items.entrySet())
			{
				if(!this.ui.cboxFiltre.isChecked() || clef.equals("") || entry.getKey().toLowerCase().contains(clef.toLowerCase()))
				{
					this.combo.addItem(entry.getKey(), entry.getValue());
				}
			}
			this.combo.blockSignals(false);
		}
	}
	
	/**
	 * Gère l'effaçage du filtre.
	 * 
	 * @category Slot
	 */
	public void slotEffacer()
	{
		this.ui.txtFiltre.setText("");
	}
	
	/*
	 * Accesseurs
	 */
	
	/**
	 * Définit le QComboBox à filtrer.
	 * 
	 * @param combo - Le QComboBox à filtrer.
	 * @category Accesseur
	 */
	public final void setCombo(QComboBox combo)
	{
		this.combo = combo;
		
		for(int i = 0; i < this.combo.count(); i++)
		{
			this.items.put(this.combo.itemText(i), this.combo.itemData(i, Qt.ItemDataRole.UserRole));
		}
	}
}