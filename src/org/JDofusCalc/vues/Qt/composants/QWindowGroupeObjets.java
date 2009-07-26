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
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.JDofusCalc.controleurs.ControleurGroupeObjets;
import org.JDofusCalc.dofus.objets.Animal;
import org.JDofusCalc.dofus.objets.Arme;
import org.JDofusCalc.dofus.objets.Dofus.FlagsTypesDofus;
import org.JDofusCalc.dofus.objets.Equipement.FlagsTypesEquipements;
import org.JDofusCalc.dofus.sauvegardes.GroupeObjets;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeAnimal;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeArme;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeDofus;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeEquipement;
import org.JDofusCalc.vues.Qt.designer.UIGroupeObjets;

import com.trolltech.qt.core.Qt;
import com.trolltech.qt.core.Qt.ItemDataRole;
import com.trolltech.qt.gui.QInputDialog;
import com.trolltech.qt.gui.QListWidgetItem;
import com.trolltech.qt.gui.QWidget;
import com.trolltech.qt.gui.QAbstractItemView.SelectionMode;

/**
 * Fenêtre des groupes d'objets.
 * 
 * @author PAPAYA Alexandre
 * @category Fenêtre
 * @version 1.0
 */
public class QWindowGroupeObjets extends QWidget
{
	/*
	 * Variables d'instances
	 */
	
	/* Composants */

	/**
	 * L'interface graphique.
	 */
	private UIGroupeObjets ui = null;

	/* Autres */
	
	/**
	 * Mode de la fenêtre.
	 */
	private int mode;

	/*
	 * Signaux
	 */

	/**
	 * <p>Ce signal prend 1 argument(s) générique(s) : &lt;{@link GroupeObjets} (nom: groupe)&gt;.</p>
	 * <p>Ce signal est émit lors d'une demande de suppression du groupe d'objets {@code groupe}.</p>
	 */
	public Signal1<GroupeObjets> signalSupprimerGroupe = new Signal1<GroupeObjets>();

	/**
	 * <p>Ce signal prend 2 argument(s) générique(s) : &lt;{@link GroupeObjets} (nom: groupe), {@link String} (nom: nouveauNom)&gt;.</p>
	 * <p>Ce signal est émit lors d'une demande de renommage du groupe d'objets {@code groupe} en {@code nouveauNom}.</p>
	 */
	public Signal2<GroupeObjets, String> signalRenommerGroupe = new Signal2<GroupeObjets, String>();

	/**
	 * <p>Ce signal prend 1 argument(s) générique(s) : &lt;{@link GroupeObjets} (nom: groupe)&gt;.</p>
	 * <p>Ce signal est émit lors d'une demande de chargement du groupe d'objets {@code groupe}.</p>
	 */
	public Signal1<GroupeObjets> signalChargerGroupe = new Signal1<GroupeObjets>();

	/**
	 * <p>Ce signal prend 1 argument(s) générique(s) : &lt;{@link GroupeObjets} (nom: groupe)&gt;.</p>
	 * <p>Ce signal est émit lors d'une demande de sauvegarde du groupe d'objets {@code groupe}.</p>
	 */
	public Signal1<GroupeObjets> signalSauvegardeGroupe = new Signal1<GroupeObjets>();

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
	public QWindowGroupeObjets(QWidget parent, int mode)
	{
		// Execution du constructeur de la classe mère
		super(parent, Qt.WindowType.Window);

		// Initialisation de l'interface graphique
		this.ui = new UIGroupeObjets();
		this.ui.setupUi(this);
		this.mode = mode;

		if(mode == ControleurGroupeObjets.MODE_SAUVEGARDE)
		{
			this.ui.txtNomGroupe.setEnabled(true);
			this.ui.btnCharger.setVisible(false);
			this.ui.btnSauvegarder.setVisible(true);

			this.ui.btnSauvegarder.clicked.connect(this, "slotSauvegardeGroupe()");
		}
		else if(mode == ControleurGroupeObjets.MODE_CHARGEMENT)
		{
			this.ui.txtNomGroupe.setEnabled(false);
			this.ui.listeObjets.setSelectionMode(SelectionMode.NoSelection);
			this.ui.btnCharger.setVisible(true);
			this.ui.btnSauvegarder.setVisible(false);
			this.ui.btnSelectionnerTout.setVisible(false);
			this.ui.btnDeselectionnerTout.setVisible(false);

			this.ui.btnCharger.clicked.connect(this, "slotChargementGroupe()");
		}

		/* Connexions signal->slot */
		this.ui.listeGroupeObjets.itemClicked.connect(this, "slotAffichageInformations(QListWidgetItem)");
		this.ui.btnFermer.clicked.connect(this, "slotFermeture()");
		this.ui.btnRenommer.clicked.connect(this, "slotRenommageGroupe()");
		this.ui.btnSupprimer.clicked.connect(this, "slotSuppressionGroupe()");
		this.ui.btnSelectionnerTout.clicked.connect(this, "slotSelectionnerTout()");
		this.ui.btnDeselectionnerTout.clicked.connect(this, "slotDeselectionnerTout()");
	}

	/*
	 * Méthode d'affichage des données du composant
	 */

	/**
	 * Définit la liste des groupes d'objets.
	 * 
	 * @param groupes - La liste des groupes d'objets.
	 */
	public void setListeGroupesObjets(ArrayList<GroupeObjets> groupes)
	{
		// Vide le combo
		this.ui.listeGroupeObjets.clear();
		for(int i = 0; i < groupes.size(); i++)
		{
			QListWidgetItem item = new QListWidgetItem(groupes.get(i).getNom());
			item.setData(Qt.ItemDataRole.UserRole, groupes.get(i));
			this.ui.listeGroupeObjets.addItem(item);
		}
	}

	/**
	 * Définit la liste des objets du groupe d'objets {@code groupe}.
	 * 
	 * @param groupe - Le groupe d'objets.
	 */
	public void setListeObjets(GroupeObjets groupe)
	{
		HashMap<String, HashMap<String, Object>> liste = new HashMap<String, HashMap<String, Object>>();
		SauvegardeArme arme = groupe.getArme();
		if(arme != null)
		{
			HashMap<String, Object> hashmap = new HashMap<String, Object>();
			hashmap.put("type", Arme.class);
			hashmap.put("objet", arme);
			liste.put(arme.getNom(), hashmap);
		}
		SauvegardeAnimal animal = groupe.getAnimal();
		if(animal != null)
		{
			HashMap<String, Object> hashmap = new HashMap<String, Object>();
			hashmap.put("type", Animal.class);
			hashmap.put("objet", animal);
			liste.put(animal.getNom(), hashmap);
		}
		for(Entry<FlagsTypesEquipements, SauvegardeEquipement> entry : groupe.getListeEquipements().entrySet())
		{
			if(entry.getValue() != null)
			{
				HashMap<String, Object> hashmap = new HashMap<String, Object>();
				hashmap.put("type", entry.getKey());
				hashmap.put("objet", entry.getValue());
				liste.put(entry.getValue().getNom(), hashmap);
			}
		}
		for(Entry<FlagsTypesDofus, SauvegardeDofus> entry : groupe.getListeDofus().entrySet())
		{
			if(entry.getValue() != null)
			{
				HashMap<String, Object> hashmap = new HashMap<String, Object>();
				hashmap.put("type", entry.getKey());
				hashmap.put("objet", entry.getValue());
				liste.put(entry.getValue().getNom(), hashmap);
			}
		}

		this.ui.listeObjets.clear();
		for(Entry<String, HashMap<String, Object>> entry : liste.entrySet())
		{
			QListWidgetItem item = new QListWidgetItem(entry.getKey());
			item.setData(ItemDataRole.UserRole, entry.getValue());
			this.ui.listeObjets.addItem(item);
		}

		this.slotSelectionnerTout();
	}

	/*
	 * Slots de la fenêtre
	 */

	/**
	 * Affiche les informations du groupe selectionné.
	 * 
	 * @category Slot
	 */
	public void slotAffichageInformations(QListWidgetItem item)
	{
		GroupeObjets groupe = (GroupeObjets) item.data(ItemDataRole.UserRole);
		if(this.mode == ControleurGroupeObjets.MODE_CHARGEMENT)
		{
			this.setListeObjets(groupe);
		}
		this.ui.txtNomGroupe.setText(groupe.getNom());
	}
	
	/**
	 * Sélectionne tous les objets du groupe.
	 * 
	 * @category Slot
	 */
	public void slotSelectionnerTout()
	{
		this.ui.listeObjets.selectAll();
		this.ui.listeObjets.setFocus();
	}

	/**
	 * Désélectionne tous les objets du groupe.
	 * 
	 * @category Slot
	 */
	public void slotDeselectionnerTout()
	{
		this.ui.listeObjets.clearSelection();
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
	 * Demande la sauvegarde du groupe d'objets selectionné.
	 * 
	 * @category Slot-Signal
	 */
	@SuppressWarnings("unchecked")
	public void slotSauvegardeGroupe()
	{
		GroupeObjets groupe = new GroupeObjets();
		List<QListWidgetItem> selection = this.ui.listeObjets.selectedItems();
		for(int i = 0; i < selection.size(); i++)
		{
			QListWidgetItem item = selection.get(i);
			HashMap<String, Object> data = (HashMap<String, Object>) item.data(ItemDataRole.UserRole);
			Object type = data.get("type");
			Object sauvegarde = data.get("objet");
			if(sauvegarde instanceof SauvegardeAnimal)
			{
				groupe.setAnimal((SauvegardeAnimal) sauvegarde);
			}
			else if(sauvegarde instanceof SauvegardeArme)
			{
				groupe.setArme((SauvegardeArme) sauvegarde);
			}
			else if(sauvegarde instanceof SauvegardeDofus)
			{
				groupe.setDofus((FlagsTypesDofus) type, (SauvegardeDofus) sauvegarde);
			}
			else if(sauvegarde instanceof SauvegardeEquipement)
			{
				groupe.setEquipement((FlagsTypesEquipements) type, (SauvegardeEquipement) sauvegarde);
			}

		}
		groupe.setNom(this.ui.txtNomGroupe.text());

		this.signalSauvegardeGroupe.emit(groupe);
	}

	/**
	 * Demande le renommage du groupe d'objets selectionné.
	 * 
	 * @category Slot-Signal
	 */
	public void slotRenommageGroupe()
	{
		if(!this.ui.listeGroupeObjets.selectedItems().isEmpty())
		{
			GroupeObjets groupe = (GroupeObjets) this.ui.listeGroupeObjets.currentItem().data(ItemDataRole.UserRole);
			String nouveauNom = QInputDialog.getText(this, "Renommer", "Renommer " + groupe.getNom() + " en :");
			if(nouveauNom != null && !nouveauNom.equals(""))
			{
				nouveauNom = nouveauNom.trim();
				this.signalRenommerGroupe.emit(groupe, nouveauNom);
			}
		}
	}

	/**
	 * Demande la suppression du groupe d'objets selectionné.
	 * 
	 * @category Slot-Signal
	 */
	public void slotSuppressionGroupe()
	{
		if(!this.ui.listeGroupeObjets.selectedItems().isEmpty())
		{
			GroupeObjets groupe = (GroupeObjets) this.ui.listeGroupeObjets.currentItem().data(ItemDataRole.UserRole);
			this.signalSupprimerGroupe.emit(groupe);
		}
	}

	/**
	 * Demande le chargement du groupe d'objets selectionné.
	 * 
	 * @category Slot-Signal
	 */
	public void slotChargementGroupe()
	{
		if(!this.ui.listeGroupeObjets.selectedItems().isEmpty())
		{
			GroupeObjets groupe = (GroupeObjets) this.ui.listeGroupeObjets.currentItem().data(Qt.ItemDataRole.UserRole);
			this.signalChargerGroupe.emit(groupe);
		}
	}
}