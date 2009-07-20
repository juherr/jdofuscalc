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

import java.util.ArrayList;

import org.JDofusCalc.controleurs.ControleurSauvegardesPersonnages;
import org.JDofusCalc.dofus.sauvegardes.SauvegardePersonnage;
import org.JDofusCalc.vues.Qt.designer.UISauvegardesPersonnages;

import com.trolltech.qt.core.Qt;
import com.trolltech.qt.core.Qt.ItemDataRole;
import com.trolltech.qt.gui.QInputDialog;
import com.trolltech.qt.gui.QListWidgetItem;
import com.trolltech.qt.gui.QWidget;
import com.trolltech.qt.gui.QLineEdit.EchoMode;

/**
 * Fenêtre des sauvegardes des personnages.
 * 
 * @author PAPAYA Alexandre
 * @category Fenêtre
 * @version 1.0
 */
public class QWindowSauvegardesPersonnages extends QWidget
{
	/*
	 * Variables d'instances
	 */

	/* Composants */

	/**
	 * L'interface graphique.
	 */
	private UISauvegardesPersonnages ui = null;

	/*
	 * Signaux
	 */

	/**
	 * <p>Ce signal prend 1 argument(s) générique(s) : &lt;{@link SauvegardePersonnage} (nom: sauvegarde)&gt;.</p>
	 * <p>Ce signal est émit lors d'une demande de suppression du personnage {@code sauvegarde}.</p>
	 */
	public Signal1<SauvegardePersonnage> signalSupprimerPersonnage = new Signal1<SauvegardePersonnage>();

	/**
	 * <p>Ce signal prend 2 argument(s) générique(s) : &lt;{@link SauvegardePersonnage} (nom: sauvegarde), {@link String} (nom: nouveauNom)&gt;.</p>
	 * <p>Ce signal est émit lors d'une demande de renommage du personnage {@code sauvegarde} en {@code nouveauNom}.</p>
	 */
	public Signal2<SauvegardePersonnage, String> signalRenommerPersonnage = new Signal2<SauvegardePersonnage, String>();

	/**
	 * <p>Ce signal prend 1 argument(s) générique(s) : &lt;{@link SauvegardePersonnage} (nom: sauvegarde)&gt;.</p>
	 * <p>Ce signal est émit lors d'une demande de chargement du personnage {@code sauvegarde}.</p>
	 */
	public Signal1<SauvegardePersonnage> signalChargerPersonnage = new Signal1<SauvegardePersonnage>();

	/**
	 * <p>Ce signal prend 1 argument(s) générique(s) : &lt;{@link String} (nom: nomSauvegarde)&gt;.</p>
	 * <p>Ce signal est émit lors d'une demande de sauvegarde du personnage de la fenêtre principale.</p>
	 */
	public Signal1<String> signalSauvegardePersonnage = new Signal1<String>();

	/*
	 * Constructeurs / Destructeur
	 */

	/**
	 * Construit une nouvelle fenêtre.
	 * 
	 * @param parent - Fenêtre parente.
	 * @param mode - Mode de la fenêtre.
	 * @category Constructeur
	 */
	public QWindowSauvegardesPersonnages(QWidget parent, int mode)
	{
		// Execution du constructeur de la classe mère
		super(parent, Qt.WindowType.Window);

		// Initialisation de l'interface graphique
		this.ui = new UISauvegardesPersonnages();
		this.ui.setupUi(this);

		if(mode == ControleurSauvegardesPersonnages.MODE_SAUVEGARDE)
		{
			this.ui.txtNomSauvegarde.setEnabled(true);
			this.ui.btnCharger.setVisible(false);
			this.ui.btnSauvegarder.setVisible(true);

			this.ui.btnSauvegarder.clicked.connect(this, "slotSauvegardePersonnage()");
		}
		else if(mode == ControleurSauvegardesPersonnages.MODE_CHARGEMENT)
		{
			this.ui.txtNomSauvegarde.setEnabled(false);
			this.ui.btnCharger.setVisible(true);
			this.ui.btnSauvegarder.setVisible(false);

			this.ui.btnCharger.clicked.connect(this, "slotChargementPersonnage()");
		}

		// Connexions signal/slot
		this.ui.listeSauvegardes.itemClicked.connect(this, "slotSelectionSauvegarde(QListWidgetItem)");
		this.ui.btnFermer.clicked.connect(this, "slotFermeture()");
		this.ui.btnRenommer.clicked.connect(this, "slotRenommagePersonnage()");
		this.ui.btnSupp.clicked.connect(this, "slotSuppressionPersonnage()");
	}

	/*
	 * Méthode d'affichage des données du composant
	 */

	/**
	 * Génere de la liste des sauvegardes des personnages
	 * 
	 * @param sauvegardes
	 */
	public void setListeSauvegardesPersonnages(ArrayList<SauvegardePersonnage> sauvegardes)
	{
		// Vide le combo
		this.ui.listeSauvegardes.clear();
		for(int i = 0; i < sauvegardes.size(); i++)
		{
			QListWidgetItem item = new QListWidgetItem(sauvegardes.get(i).getNom());
			item.setData(Qt.ItemDataRole.UserRole, sauvegardes.get(i));
			this.ui.listeSauvegardes.addItem(item);
		}
	}
	
	/**
	 * Affiche les informations de la sauvegarde du personnage dans la fenêtre.
	 * 
	 * @param sauvegarde - Sauvegarde du personnage.
	 */
	public void setSauvegardePersonnage(SauvegardePersonnage sauvegarde)
	{
		this.ui.lblNomPerso.setText(sauvegarde.getNomPerso());
		this.ui.txtNomSauvegarde.setText(sauvegarde.getNom());
		this.ui.lblNiveauPerso.setText(String.valueOf(sauvegarde.getNiveau()));
	}

	/*
	 * Slots de la fenêtre
	 */

	/**
	 * Gère la selection d'une sauvegarde d'un personnage.
	 * 
	 * @category Slot
	 */
	public void slotSelectionSauvegarde(QListWidgetItem item)
	{
		SauvegardePersonnage sauvegarde = (SauvegardePersonnage) item.data(ItemDataRole.UserRole);
		this.setSauvegardePersonnage(sauvegarde);
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

	/*
	 * Slot-Signaux de la fenêtre
	 */

	/**
	 * Demande la sauvegarde du personnage.
	 * 
	 * @category Slot-Signal
	 */
	public void slotSauvegardePersonnage()
	{
		this.signalSauvegardePersonnage.emit(this.ui.txtNomSauvegarde.text());
	}

	/**
	 * Demande le renommage du personnage selectionné.
	 * 
	 * @category Slot-Signal
	 */
	public void slotRenommagePersonnage()
	{
		if(!this.ui.listeSauvegardes.selectedItems().isEmpty())
		{
			SauvegardePersonnage sauvegarde = (SauvegardePersonnage) this.ui.listeSauvegardes.currentItem().data(ItemDataRole.UserRole);
			String nouveauNom = QInputDialog.getText(this, "Renommer", "Renommer " + sauvegarde.getNom() + " en :", EchoMode.Normal, sauvegarde.getNom());
			if(nouveauNom != null && !nouveauNom.equals(""))
			{
				nouveauNom = nouveauNom.trim();
				this.signalRenommerPersonnage.emit(sauvegarde, nouveauNom);
			}
		}
	}

	/**
	 * Demande la suppression du personnage selectionné.
	 * 
	 * @category Slot-Signal
	 */
	public void slotSuppressionPersonnage()
	{
		if(!this.ui.listeSauvegardes.selectedItems().isEmpty())
		{
			SauvegardePersonnage sauvegarde = (SauvegardePersonnage) this.ui.listeSauvegardes.currentItem().data(ItemDataRole.UserRole);
			this.signalSupprimerPersonnage.emit(sauvegarde);
		}
	}

	/**
	 * Demande le chargement du personnage selectionné.
	 * 
	 * @category Slot-Signal
	 */
	public void slotChargementPersonnage()
	{
		if(!this.ui.listeSauvegardes.selectedItems().isEmpty())
		{
			SauvegardePersonnage itemData = (SauvegardePersonnage) this.ui.listeSauvegardes.currentItem().data(Qt.ItemDataRole.UserRole);
			this.signalChargerPersonnage.emit(itemData);
		}
	}
}