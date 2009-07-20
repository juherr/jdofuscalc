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
import java.util.Map.Entry;

import org.JDofusCalc.dofus.objets.Arme.FlagsTypesArmes;
import org.JDofusCalc.dofus.objets.Dofus.FlagsTypesDofus;
import org.JDofusCalc.dofus.objets.Equipement.FlagsTypesEquipements;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeArme;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeDofus;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeEquipement;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeFamilier;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeMonture;
import org.JDofusCalc.dofus.sauvegardes.SauvegardePersonnage;
import org.JDofusCalc.vues.Qt.designer.UIExport;
import org.h2.expression.Alias;

import com.trolltech.qt.core.Qt;
import com.trolltech.qt.core.Qt.Alignment;
import com.trolltech.qt.core.Qt.AlignmentFlag;
import com.trolltech.qt.core.Qt.ItemDataRole;
import com.trolltech.qt.gui.QCheckBox;
import com.trolltech.qt.gui.QHBoxLayout;
import com.trolltech.qt.gui.QLayout;
import com.trolltech.qt.gui.QTableWidget;
import com.trolltech.qt.gui.QTableWidgetItem;
import com.trolltech.qt.gui.QWidget;

/**
 * Fenêtre d'exportation des données.
 * 
 * @author PAPAYA Alexandre
 * @category Fenêtre
 * @version 1.0
 */
public class QWindowExportation extends QWidget
{
	/*
	 * Variables d'instances
	 */
	
	/* Composants */

	/**
	 * L'interface graphique.
	 */
	private UIExport ui;
	
	/* Autres */
	
	/**
	 * Liste des sauvegardes de personnages sélectionées.
	 */
	private ArrayList<SauvegardePersonnage> sauvegardesPersonnagesSelectionnees;
	
	/**
	 * Liste des sauvegardes d'équipements sélectionées.
	 */
	private HashMap<FlagsTypesEquipements, ArrayList<SauvegardeEquipement>> sauvegardesEquipementsSelectionnees;
	
	/**
	 * Liste des sauvegardes d'armes sélectionées.
	 */
	private HashMap<FlagsTypesArmes, ArrayList<SauvegardeArme>> sauvegardesArmesSelectionnees;
	
	/**
	 * Liste des sauvegardes de Dofus sélectionées.
	 */
	private HashMap<FlagsTypesDofus, ArrayList<SauvegardeDofus>> sauvegardesDofusSelectionnees;
	
	/**
	 * Liste des sauvegardes de familiers sélectionées.
	 */
	private ArrayList<SauvegardeFamilier> sauvegardesFamiliersSelectionnees;
	
	/**
	 * Liste des sauvegardes de montures sélectionées.
	 */
	private ArrayList<SauvegardeMonture> sauvegardesMonturesSelectionnees;
	
	/*
	 * Constructeurs / Destructeur
	 */
	
	/**
	 * Construit une nouvelle fenêtre.
	 * 
	 * @param parent - Fenêtre parente.
	 * @category Constructeur
	 */
	public QWindowExportation(QWidget parent)
	{
		// Execution du constructeur de la classe mère
		super(parent, Qt.WindowType.Window);
		
		this.sauvegardesPersonnagesSelectionnees = new ArrayList<SauvegardePersonnage>();
		
		this.sauvegardesEquipementsSelectionnees = new HashMap<FlagsTypesEquipements, ArrayList<SauvegardeEquipement>>();
		this.sauvegardesEquipementsSelectionnees.put(FlagsTypesEquipements.Amulette, new ArrayList<SauvegardeEquipement>());
		this.sauvegardesEquipementsSelectionnees.put(FlagsTypesEquipements.Anneau, new ArrayList<SauvegardeEquipement>());
		this.sauvegardesEquipementsSelectionnees.put(FlagsTypesEquipements.Bottes, new ArrayList<SauvegardeEquipement>());
		this.sauvegardesEquipementsSelectionnees.put(FlagsTypesEquipements.Bouclier, new ArrayList<SauvegardeEquipement>());
		this.sauvegardesEquipementsSelectionnees.put(FlagsTypesEquipements.Cape, new ArrayList<SauvegardeEquipement>());
		this.sauvegardesEquipementsSelectionnees.put(FlagsTypesEquipements.Ceinture, new ArrayList<SauvegardeEquipement>());
		this.sauvegardesEquipementsSelectionnees.put(FlagsTypesEquipements.Coiffe, new ArrayList<SauvegardeEquipement>());
		
		this.sauvegardesArmesSelectionnees = new HashMap<FlagsTypesArmes, ArrayList<SauvegardeArme>>();
		for(FlagsTypesArmes flag : FlagsTypesArmes.values())
		{
			this.sauvegardesArmesSelectionnees.put(flag, new ArrayList<SauvegardeArme>());
		}
		
		this.sauvegardesDofusSelectionnees = new HashMap<FlagsTypesDofus, ArrayList<SauvegardeDofus>>();
		for(FlagsTypesDofus flag : FlagsTypesDofus.values())
		{
			this.sauvegardesDofusSelectionnees.put(flag, new ArrayList<SauvegardeDofus>());
		}
		
		this.sauvegardesFamiliersSelectionnees = new ArrayList<SauvegardeFamilier>();
		
		this.sauvegardesMonturesSelectionnees = new ArrayList<SauvegardeMonture>();
		
		// Initialisation de l'interface graphique
		this.ui = new UIExport();
		this.ui.setupUi(this);
		
		/* Connexions signal->slot */
		this.ui.btnSelectAllPerso.clicked.connect(this, "slotSelectionnerToutPerso()");
		this.ui.btnDeselectAllPerso.clicked.connect(this, "slotDeselectionnerToutPerso()");
		this.ui.btnSelectAllEquip.clicked.connect(this, "slotSelectionnerToutEquip()");
		this.ui.btnDeselectAllEquip.clicked.connect(this, "slotDeselectionnerToutEquip()");
		this.ui.btnSelectAllArmes.clicked.connect(this, "slotSelectionnerToutArmes()");
		this.ui.btnDeselectAllArmes.clicked.connect(this, "slotDeselectionnerToutArmes()");
		this.ui.btnSelectAllDofus.clicked.connect(this, "slotSelectionnerToutDofus()");
		this.ui.btnDeselectAllDofus.clicked.connect(this, "slotDeselectionnerToutDofus()");
		this.ui.btnSelectAllFamiliers.clicked.connect(this, "slotSelectionnerToutFamiliers()");
		this.ui.btnDeselectAllFamilier.clicked.connect(this, "slotDeselectionnerToutFamiliers()");
		this.ui.btnSelectAllMontures.clicked.connect(this, "slotSelectionnerToutMontures()");
		this.ui.btnDeselectAllMontures.clicked.connect(this, "slotDeselectionnerToutMontures()");
		this.ui.btnFermer.clicked.connect(this, "slotFermeture()");
	}
	
	/*
	 * Méthode d'affichage des données du composant
	 */

	/**
	 * Génere de la liste des sauvegardes des personnages.
	 * 
	 * @param sauvegardes - Liste des sauvegardes des personnages.
	 */
	public void setListeSauvegardesPersonnages(ArrayList<SauvegardePersonnage> sauvegardes)
	{
		this.ui.listePerso.blockSignals(true);
		this.ui.listePerso.clearContents();
		this.ui.listePerso.setRowCount(sauvegardes.size());
		this.ui.listePerso.setColumnWidth(0, 30);
		this.ui.listePerso.verticalHeader().setVisible(false);
		
		for(int i = 0; i < sauvegardes.size(); i++)
		{
			QCheckBox cb = new QCheckBox();
			cb.toggled.connect(this, "slotSelectionPerso()");
			this.ui.listePerso.setCellWidget(i, 0, cb);

			QTableWidgetItem itemNomSauvegarde = new QTableWidgetItem(sauvegardes.get(i).getNom());
			itemNomSauvegarde.setData(Qt.ItemDataRole.UserRole, sauvegardes.get(i));
			this.ui.listePerso.setItem(i, 1, itemNomSauvegarde);
			
			QTableWidgetItem itemNomPerso = new QTableWidgetItem(sauvegardes.get(i).getNomPerso());
			this.ui.listePerso.setItem(i, 2, itemNomPerso);
			
			QTableWidgetItem itemNiveauPerso = new QTableWidgetItem(String.valueOf(sauvegardes.get(i).getNiveau()));
			this.ui.listePerso.setItem(i, 3, itemNiveauPerso);
		}
		
		this.ui.listePerso.resizeColumnsToContents();
		this.ui.listePerso.resizeRowsToContents();
		this.ui.listePerso.blockSignals(false);
	}
	
	/**
	 * Génere de la liste des sauvegardes des équipements.
	 * 
	 * @param sauvegardes - Liste des sauvegardes des équipements.
	 */
	public void setListeSauvegardesEquipements(HashMap<FlagsTypesEquipements, ArrayList<SauvegardeEquipement>> sauvegardes)
	{
		QTableWidget liste = this.ui.listeEquip;
		String slot = "slotSelectionEquipement()";
		
		int size = 0;
		for(Entry<FlagsTypesEquipements, ArrayList<SauvegardeEquipement>> enrty : sauvegardes.entrySet())
		{
			ArrayList<SauvegardeEquipement> listeArmesType = enrty.getValue();
			size+= listeArmesType.size();
		}
		
		liste.blockSignals(true);
		liste.clearContents();
		liste.setRowCount(size);
		liste.setColumnWidth(0, 30);
		liste.verticalHeader().setVisible(false);
		
		int y = 0;
		for(Entry<FlagsTypesEquipements, ArrayList<SauvegardeEquipement>> enrty : sauvegardes.entrySet())
		{
			ArrayList<SauvegardeEquipement> listeObjetsType = enrty.getValue();
			for(int i = 0; i < listeObjetsType.size(); i++)
			{
				QCheckBox cb = new QCheckBox();
				cb.toggled.connect(this, slot);
				liste.setCellWidget(y, 0, cb);

				QTableWidgetItem itemNomObjet = new QTableWidgetItem(listeObjetsType.get(i).getNom());
				itemNomObjet.setData(Qt.ItemDataRole.UserRole, listeObjetsType.get(i));
				liste.setItem(y, 1, itemNomObjet);
				
				QTableWidgetItem itemTypeObjet = new QTableWidgetItem(listeObjetsType.get(i).getType().getNom());
				liste.setItem(y, 2, itemTypeObjet);
				
				QTableWidgetItem itemNiveauObjet = new QTableWidgetItem(String.valueOf(listeObjetsType.get(i).getNiveau()));
				liste.setItem(y, 3, itemNiveauObjet);
				
				y++;
			}
		}
		
		liste.resizeColumnsToContents();
		liste.resizeRowsToContents();
		liste.blockSignals(false);
	}
	
	/**
	 * Génere de la liste des sauvegardes des armes.
	 * 
	 * @param sauvegardes - Liste des sauvegardes des armes.
	 */
	public void setListeSauvegardesArmes(HashMap<FlagsTypesArmes, ArrayList<SauvegardeArme>> sauvegardes)
	{
		QTableWidget liste = this.ui.listeArmes;
		String slot = "slotSelectionArme()";
		
		int size = 0;
		for(Entry<FlagsTypesArmes, ArrayList<SauvegardeArme>> enrty : sauvegardes.entrySet())
		{
			ArrayList<SauvegardeArme> listeArmesType = enrty.getValue();
			size+= listeArmesType.size();
		}
		
		liste.blockSignals(true);
		liste.clearContents();
		liste.setRowCount(size);
		liste.setColumnWidth(0, 30);
		liste.verticalHeader().setVisible(false);
		
		int y = 0;
		for(Entry<FlagsTypesArmes, ArrayList<SauvegardeArme>> enrty : sauvegardes.entrySet())
		{
			ArrayList<SauvegardeArme> listeObjetsType = enrty.getValue();
			for(int i = 0; i < listeObjetsType.size(); i++)
			{
				QCheckBox cb = new QCheckBox();
				cb.toggled.connect(this, slot);
				liste.setCellWidget(y, 0, cb);

				QTableWidgetItem itemNomObjet = new QTableWidgetItem(listeObjetsType.get(i).getNom());
				itemNomObjet.setData(Qt.ItemDataRole.UserRole, listeObjetsType.get(i));
				liste.setItem(y, 1, itemNomObjet);
				
				QTableWidgetItem itemTypeObjet = new QTableWidgetItem(listeObjetsType.get(i).getType().getNom());
				liste.setItem(y, 2, itemTypeObjet);
				
				QTableWidgetItem itemNiveauObjet = new QTableWidgetItem(String.valueOf(listeObjetsType.get(i).getNiveau()));
				liste.setItem(y, 3, itemNiveauObjet);
				
				y++;
			}
		}
		
		liste.resizeColumnsToContents();
		liste.resizeRowsToContents();
		liste.blockSignals(false);
	}
	
	/**
	 * Génere de la liste des sauvegardes des Dofus.
	 * 
	 * @param sauvegardes - Liste des sauvegardes des Dofus.
	 */
	public void setListeSauvegardesDofus(HashMap<FlagsTypesDofus, ArrayList<SauvegardeDofus>> sauvegardes)
	{
		QTableWidget liste = this.ui.listeDofus;
		String slot = "slotSelectionDofus()";
		
		int size = 0;
		for(Entry<FlagsTypesDofus, ArrayList<SauvegardeDofus>> enrty : sauvegardes.entrySet())
		{
			ArrayList<SauvegardeDofus> listeDofusType = enrty.getValue();
			size+= listeDofusType.size();
		}
		
		liste.blockSignals(true);
		liste.clearContents();
		liste.setRowCount(size);
		liste.setColumnWidth(0, 30);
		liste.verticalHeader().setVisible(false);
		
		int y = 0;
		for(Entry<FlagsTypesDofus, ArrayList<SauvegardeDofus>> enrty : sauvegardes.entrySet())
		{
			ArrayList<SauvegardeDofus> listeObjetsType = enrty.getValue();
			for(int i = 0; i < listeObjetsType.size(); i++)
			{
				QCheckBox cb = new QCheckBox();
				cb.toggled.connect(this, slot);
				liste.setCellWidget(y, 0, cb);

				QTableWidgetItem itemNomObjet = new QTableWidgetItem(listeObjetsType.get(i).getNom());
				itemNomObjet.setData(Qt.ItemDataRole.UserRole, listeObjetsType.get(i));
				liste.setItem(y, 1, itemNomObjet);
				
				QTableWidgetItem itemTypeObjet = new QTableWidgetItem(listeObjetsType.get(i).getType().getNom());
				liste.setItem(y, 2, itemTypeObjet);
				
				QTableWidgetItem itemNiveauObjet = new QTableWidgetItem(String.valueOf(listeObjetsType.get(i).getNiveau()));
				liste.setItem(y, 3, itemNiveauObjet);
				
				y++;
			}
		}
		
		liste.resizeColumnsToContents();
		liste.resizeRowsToContents();
		liste.blockSignals(false);
	}
	
	/**
	 * Génere de la liste des sauvegardes des familiers.
	 * 
	 * @param sauvegardes - Liste des sauvegardes des familiers.
	 */
	public void setListeSauvegardesFamiliers(ArrayList<SauvegardeFamilier> sauvegardes)
	{
		QTableWidget liste = this.ui.listeFamiliers;
		String slot = "slotSelectionFamilier()";
		
		liste.blockSignals(true);
		liste.clearContents();
		liste.setRowCount(sauvegardes.size());
		liste.setColumnWidth(0, 30);
		liste.verticalHeader().setVisible(false);
		
		for(int i = 0; i < sauvegardes.size(); i++)
		{
			QCheckBox cb = new QCheckBox();
			cb.toggled.connect(this, slot);
			liste.setCellWidget(i, 0, cb);

			QTableWidgetItem itemNomObjet = new QTableWidgetItem(sauvegardes.get(i).getNom());
			itemNomObjet.setData(Qt.ItemDataRole.UserRole, sauvegardes.get(i));
			liste.setItem(i, 1, itemNomObjet);
			
			QTableWidgetItem itemNiveauObjet = new QTableWidgetItem(String.valueOf(sauvegardes.get(i).getNiveau()));
			liste.setItem(i, 2, itemNiveauObjet);
		}
		
		liste.resizeColumnsToContents();
		liste.resizeRowsToContents();
		liste.blockSignals(false);
	}
	
	/**
	 * Génere de la liste des sauvegardes des montures.
	 * 
	 * @param sauvegardes - Liste des sauvegardes des montures.
	 */
	public void setListeSauvegardesMontures(ArrayList<SauvegardeMonture> sauvegardes)
	{
		QTableWidget liste = this.ui.listeMontures;
		String slot = "slotSelectionMonture()";
		
		liste.blockSignals(true);
		liste.clearContents();
		liste.setRowCount(sauvegardes.size());
		liste.setColumnWidth(0, 30);
		liste.verticalHeader().setVisible(false);
		
		for(int i = 0; i < sauvegardes.size(); i++)
		{
			QCheckBox cb = new QCheckBox();
			cb.toggled.connect(this, slot);
			liste.setCellWidget(i, 0, cb);

			QTableWidgetItem itemNomObjet = new QTableWidgetItem(sauvegardes.get(i).getNom());
			itemNomObjet.setData(Qt.ItemDataRole.UserRole, sauvegardes.get(i));
			liste.setItem(i, 1, itemNomObjet);
			
			QTableWidgetItem itemRace = new QTableWidgetItem(String.valueOf(sauvegardes.get(i).getRace()));
			liste.setItem(i, 2, itemRace);
			
			QTableWidgetItem itemNiveauMonture = new QTableWidgetItem(String.valueOf(sauvegardes.get(i).getNiveau()));
			liste.setItem(i, 3, itemNiveauMonture);
		}
		
		liste.resizeColumnsToContents();
		liste.resizeRowsToContents();
		liste.blockSignals(false);
	}
	
	/*
	 * Slots de la fenêtre
	 */
	
	/**
	 * Gère la sélection d'un personnage.
	 * 
	 * @category Slot
	 */
	public void slotSelectionPerso()
	{
		this.sauvegardesPersonnagesSelectionnees.clear();
		
		for(int i = 0; i < this.ui.listePerso.rowCount(); i++)
		{
			QCheckBox cb = (QCheckBox) this.ui.listePerso.cellWidget(i, 0);
			if(cb.isChecked())
			{
				SauvegardePersonnage sauvegarde = (SauvegardePersonnage) this.ui.listePerso.item(i, 1).data(ItemDataRole.UserRole);
				this.sauvegardesPersonnagesSelectionnees.add(sauvegarde);
			}
		}
		
		this.ui.lblNbPersoSelect.setText(tr(this.sauvegardesPersonnagesSelectionnees.size() + " personnage(s) sélectionné(s)"));
	}
	
	/**
	 * Sélectionne tous les objets du groupe.
	 * 
	 * @category Slot
	 */
	public void slotSelectionnerToutPerso()
	{
		this.sauvegardesPersonnagesSelectionnees.clear();
		
		for(int i = 0; i < this.ui.listePerso.rowCount(); i++)
		{
			QCheckBox cb = (QCheckBox) this.ui.listePerso.cellWidget(i, 0);
			cb.blockSignals(true);
			cb.setChecked(true);
			cb.blockSignals(false);
			SauvegardePersonnage sauvegarde = (SauvegardePersonnage) this.ui.listePerso.item(i, 1).data(ItemDataRole.UserRole);
			this.sauvegardesPersonnagesSelectionnees.add(sauvegarde);
		}
		
		this.ui.lblNbPersoSelect.setText(tr(this.ui.listePerso.rowCount() + " personnage(s) sélectionné(s)"));
	}

	/**
	 * Désélectionne tous les objets du groupe.
	 * 
	 * @category Slot
	 */
	public void slotDeselectionnerToutPerso()
	{
		this.sauvegardesPersonnagesSelectionnees.clear();
		
		for(int i = 0; i < this.ui.listePerso.rowCount(); i++)
		{
			QCheckBox cb = (QCheckBox) this.ui.listePerso.cellWidget(i, 0);
			cb.blockSignals(true);
			cb.setChecked(false);
			cb.blockSignals(false);
		}
		
		this.ui.lblNbPersoSelect.setText(tr("0 personnage(s) sélectionné(s)"));
	}
	
	/**
	 * Gère la sélection d'un équipement.
	 * 
	 * @category Slot
	 */
	public void slotSelectionEquipement()
	{
		int indexTab = 0;
		QTableWidget tableau = this.ui.listeEquip;
		HashMap<FlagsTypesEquipements, ArrayList<SauvegardeEquipement>> liste = this.sauvegardesEquipementsSelectionnees;
		String texteOnglet = "Equipements";
		
		for(Entry<FlagsTypesEquipements, ArrayList<SauvegardeEquipement>> enrty : liste.entrySet())
		{
			enrty.getValue().clear();
		}
		
		int count = 0;
		for(int i = 0; i < tableau.rowCount(); i++)
		{
			QCheckBox cb = (QCheckBox) tableau.cellWidget(i, 0);
			if(cb.isChecked())
			{
				SauvegardeEquipement sauvegarde = (SauvegardeEquipement) tableau.item(i, 1).data(ItemDataRole.UserRole);
				liste.get(sauvegarde.getType()).add(sauvegarde);
				count++;
			}
		}
		
		this.ui.ongletsObjets.setTabText(indexTab, tr(texteOnglet + " (" + count + ")"));
	}
	
	/**
	 * Sélectionne tous les équipements.
	 * 
	 * @category Slot
	 */
	public void slotSelectionnerToutEquip()
	{
		int indexTab = 0;
		QTableWidget tableau = this.ui.listeEquip;
		HashMap<FlagsTypesEquipements, ArrayList<SauvegardeEquipement>> liste = this.sauvegardesEquipementsSelectionnees;
		String texteOnglet = "Equipements";
		
		for(Entry<FlagsTypesEquipements, ArrayList<SauvegardeEquipement>> enrty : liste.entrySet())
		{
			enrty.getValue().clear();
		}
		
		for(int i = 0; i < tableau.rowCount(); i++)
		{
			QCheckBox cb = (QCheckBox) tableau.cellWidget(i, 0);
			cb.blockSignals(true);
			cb.setChecked(true);
			cb.blockSignals(false);
			SauvegardeEquipement sauvegarde = (SauvegardeEquipement) tableau.item(i, 1).data(ItemDataRole.UserRole);
			liste.get(sauvegarde.getType()).add(sauvegarde);
		}
		
		this.ui.ongletsObjets.setTabText(indexTab, tr(texteOnglet + " (" + tableau.rowCount() + ")"));
	}

	/**
	 * Désélectionne tous les équipements.
	 * 
	 * @category Slot
	 */
	public void slotDeselectionnerToutEquip()
	{
		int indexTab = 0;
		QTableWidget tableau = this.ui.listeEquip;
		HashMap<FlagsTypesEquipements, ArrayList<SauvegardeEquipement>> liste = this.sauvegardesEquipementsSelectionnees;
		String texteOnglet = "Equipements";
		
		for(Entry<FlagsTypesEquipements, ArrayList<SauvegardeEquipement>> enrty : liste.entrySet())
		{
			enrty.getValue().clear();
		}
		
		for(int i = 0; i < tableau.rowCount(); i++)
		{
			QCheckBox cb = (QCheckBox) tableau.cellWidget(i, 0);
			cb.blockSignals(true);
			cb.setChecked(false);
			cb.blockSignals(false);
		}
		
		this.ui.ongletsObjets.setTabText(indexTab, tr(texteOnglet + " (0)"));
	}
	
	/**
	 * Gère la sélection d'une arme.
	 * 
	 * @category Slot
	 */
	public void slotSelectionArme()
	{
		int indexTab = 1;
		QTableWidget tableau = this.ui.listeArmes;
		HashMap<FlagsTypesArmes, ArrayList<SauvegardeArme>> liste = this.sauvegardesArmesSelectionnees;
		String texteOnglet = "Armes";
		
		for(Entry<FlagsTypesArmes, ArrayList<SauvegardeArme>> enrty : liste.entrySet())
		{
			enrty.getValue().clear();
		}
		
		int count = 0;
		for(int i = 0; i < tableau.rowCount(); i++)
		{
			QCheckBox cb = (QCheckBox) tableau.cellWidget(i, 0);
			if(cb.isChecked())
			{
				SauvegardeArme sauvegarde = (SauvegardeArme) tableau.item(i, 1).data(ItemDataRole.UserRole);
				liste.get(sauvegarde.getType()).add(sauvegarde);
				count++;
			}
		}
		
		this.ui.ongletsObjets.setTabText(indexTab, tr(texteOnglet + " (" + count + ")"));
	}
	
	/**
	 * Sélectionne toutes les armes.
	 * 
	 * @category Slot
	 */
	public void slotSelectionnerToutArmes()
	{
		int indexTab = 1;
		QTableWidget tableau = this.ui.listeArmes;
		HashMap<FlagsTypesArmes, ArrayList<SauvegardeArme>> liste = this.sauvegardesArmesSelectionnees;
		String texteOnglet = "Armes";
		
		for(Entry<FlagsTypesArmes, ArrayList<SauvegardeArme>> enrty : liste.entrySet())
		{
			enrty.getValue().clear();
		}
		
		for(int i = 0; i < tableau.rowCount(); i++)
		{
			QCheckBox cb = (QCheckBox) tableau.cellWidget(i, 0);
			cb.blockSignals(true);
			cb.setChecked(true);
			cb.blockSignals(false);
			SauvegardeArme sauvegarde = (SauvegardeArme) tableau.item(i, 1).data(ItemDataRole.UserRole);
			liste.get(sauvegarde.getType()).add(sauvegarde);
		}
		
		this.ui.ongletsObjets.setTabText(indexTab, tr(texteOnglet + " (" + tableau.rowCount() + ")"));
	}

	/**
	 * Désélectionne toutes les armes.
	 * 
	 * @category Slot
	 */
	public void slotDeselectionnerToutArmes()
	{
		int indexTab = 1;
		QTableWidget tableau = this.ui.listeArmes;
		HashMap<FlagsTypesArmes, ArrayList<SauvegardeArme>> liste = this.sauvegardesArmesSelectionnees;
		String texteOnglet = "Armes";
		
		for(Entry<FlagsTypesArmes, ArrayList<SauvegardeArme>> enrty : liste.entrySet())
		{
			enrty.getValue().clear();
		}
		
		for(int i = 0; i < tableau.rowCount(); i++)
		{
			QCheckBox cb = (QCheckBox) tableau.cellWidget(i, 0);
			cb.blockSignals(true);
			cb.setChecked(false);
			cb.blockSignals(false);
		}
		
		this.ui.ongletsObjets.setTabText(indexTab, tr(texteOnglet + " (0)"));
	}
	
	/**
	 * Gère la sélection d'un Dofus.
	 * 
	 * @category Slot
	 */
	public void slotSelectionDofus()
	{
		int indexTab = 3;
		QTableWidget tableau = this.ui.listeDofus;
		HashMap<FlagsTypesDofus, ArrayList<SauvegardeDofus>> liste = this.sauvegardesDofusSelectionnees;
		String texteOnglet = "Dofus";
		
		for(Entry<FlagsTypesDofus, ArrayList<SauvegardeDofus>> enrty : liste.entrySet())
		{
			enrty.getValue().clear();
		}
		
		int count = 0;
		for(int i = 0; i < tableau.rowCount(); i++)
		{
			QCheckBox cb = (QCheckBox) tableau.cellWidget(i, 0);
			if(cb.isChecked())
			{
				SauvegardeDofus sauvegarde = (SauvegardeDofus) tableau.item(i, 1).data(ItemDataRole.UserRole);
				liste.get(sauvegarde.getType()).add(sauvegarde);
				count++;
			}
		}
		
		this.ui.ongletsObjets.setTabText(indexTab, tr(texteOnglet + " (" + count + ")"));
	}
	
	/**
	 * Sélectionne tous les Dofus.
	 * 
	 * @category Slot
	 */
	public void slotSelectionnerToutDofus()
	{
		int indexTab = 3;
		QTableWidget tableau = this.ui.listeDofus;
		HashMap<FlagsTypesDofus, ArrayList<SauvegardeDofus>> liste = this.sauvegardesDofusSelectionnees;
		String texteOnglet = "Dofus";
		
		for(Entry<FlagsTypesDofus, ArrayList<SauvegardeDofus>> enrty : liste.entrySet())
		{
			enrty.getValue().clear();
		}
		
		for(int i = 0; i < tableau.rowCount(); i++)
		{
			QCheckBox cb = (QCheckBox) tableau.cellWidget(i, 0);
			cb.blockSignals(true);
			cb.setChecked(true);
			cb.blockSignals(false);
			SauvegardeDofus sauvegarde = (SauvegardeDofus) tableau.item(i, 1).data(ItemDataRole.UserRole);
			liste.get(sauvegarde.getType()).add(sauvegarde);
		}
		
		this.ui.ongletsObjets.setTabText(indexTab, tr(texteOnglet + " (" + tableau.rowCount() + ")"));
	}

	/**
	 * Désélectionne tous les Dofus
	 * 
	 * @category Slot
	 */
	public void slotDeselectionnerToutDofus()
	{
		int indexTab = 3;
		QTableWidget tableau = this.ui.listeDofus;
		HashMap<FlagsTypesDofus, ArrayList<SauvegardeDofus>> liste = this.sauvegardesDofusSelectionnees;
		String texteOnglet = "Dofus";
		
		for(Entry<FlagsTypesDofus, ArrayList<SauvegardeDofus>> enrty : liste.entrySet())
		{
			enrty.getValue().clear();
		}
		
		for(int i = 0; i < tableau.rowCount(); i++)
		{
			QCheckBox cb = (QCheckBox) tableau.cellWidget(i, 0);
			cb.blockSignals(true);
			cb.setChecked(false);
			cb.blockSignals(false);
		}
		
		this.ui.ongletsObjets.setTabText(indexTab, tr(texteOnglet + " (0)"));
	}
	
	/**
	 * Gère la sélection d'un familier.
	 * 
	 * @category Slot
	 */
	public void slotSelectionFamilier()
	{
		QTableWidget tableau = this.ui.listeFamiliers;
		ArrayList<SauvegardeFamilier> liste = this.sauvegardesFamiliersSelectionnees;
		
		liste.clear();
		
		for(int i = 0; i < tableau.rowCount(); i++)
		{
			QCheckBox cb = (QCheckBox) tableau.cellWidget(i, 0);
			if(cb.isChecked())
			{
				SauvegardeFamilier sauvegarde = (SauvegardeFamilier) tableau.item(i, 1).data(ItemDataRole.UserRole);
				liste.add(sauvegarde);
			}
		}
	}
	
	/**
	 * Sélectionne tous les familiers.
	 * 
	 * @category Slot
	 */
	public void slotSelectionnerToutFamiliers()
	{
		QTableWidget tableau = this.ui.listeFamiliers;
		ArrayList<SauvegardeFamilier> liste = this.sauvegardesFamiliersSelectionnees;
		
		liste.clear();
		
		for(int i = 0; i < tableau.rowCount(); i++)
		{
			QCheckBox cb = (QCheckBox) tableau.cellWidget(i, 0);
			cb.blockSignals(true);
			cb.setChecked(true);
			cb.blockSignals(false);
			SauvegardeFamilier sauvegarde = (SauvegardeFamilier) tableau.item(i, 1).data(ItemDataRole.UserRole);
			liste.add(sauvegarde);
		}
		
	}

	/**
	 * Désélectionne tous les familiers.
	 * 
	 * @category Slot
	 */
	public void slotDeselectionnerToutFamiliers()
	{
		QTableWidget tableau = this.ui.listeFamiliers;
		ArrayList<SauvegardeFamilier> liste = this.sauvegardesFamiliersSelectionnees;

		liste.clear();
		
		for(int i = 0; i < tableau.rowCount(); i++)
		{
			QCheckBox cb = (QCheckBox) tableau.cellWidget(i, 0);
			cb.blockSignals(true);
			cb.setChecked(false);
			cb.blockSignals(false);
		}
	}
	
	/**
	 * Gère la sélection d'une monture.
	 * 
	 * @category Slot
	 */
	public void slotSelectionMonture()
	{
		QTableWidget tableau = this.ui.listeMontures;
		ArrayList<SauvegardeMonture> liste = this.sauvegardesMonturesSelectionnees;
		
		liste.clear();
		
		for(int i = 0; i < tableau.rowCount(); i++)
		{
			QCheckBox cb = (QCheckBox) tableau.cellWidget(i, 0);
			if(cb.isChecked())
			{
				SauvegardeMonture sauvegarde = (SauvegardeMonture) tableau.item(i, 1).data(ItemDataRole.UserRole);
				liste.add(sauvegarde);
			}
		}
	}
	
	/**
	 * Sélectionne toutes les montures.
	 * 
	 * @category Slot
	 */
	public void slotSelectionnerToutMontures()
	{
		QTableWidget tableau = this.ui.listeMontures;
		ArrayList<SauvegardeMonture> liste = this.sauvegardesMonturesSelectionnees;
		
		liste.clear();
		
		for(int i = 0; i < tableau.rowCount(); i++)
		{
			QCheckBox cb = (QCheckBox) tableau.cellWidget(i, 0);
			cb.blockSignals(true);
			cb.setChecked(true);
			cb.blockSignals(false);
			SauvegardeMonture sauvegarde = (SauvegardeMonture) tableau.item(i, 1).data(ItemDataRole.UserRole);
			liste.add(sauvegarde);
		}
		
	}

	/**
	 * Désélectionne toutes les montures.
	 * 
	 * @category Slot
	 */
	public void slotDeselectionnerToutMontures()
	{
		QTableWidget tableau = this.ui.listeMontures;
		ArrayList<SauvegardeMonture> liste = this.sauvegardesMonturesSelectionnees;

		liste.clear();
		
		for(int i = 0; i < tableau.rowCount(); i++)
		{
			QCheckBox cb = (QCheckBox) tableau.cellWidget(i, 0);
			cb.blockSignals(true);
			cb.setChecked(false);
			cb.blockSignals(false);
		}
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
