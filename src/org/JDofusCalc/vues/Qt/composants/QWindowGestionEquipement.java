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

import org.JDofusCalc.dofus.autres.Classe;
import org.JDofusCalc.dofus.autres.Effets;
import org.JDofusCalc.dofus.autres.Effets.FlagsTypesEffets;
import org.JDofusCalc.dofus.objets.Equipement;
import org.JDofusCalc.dofus.objets.Panoplie;
import org.JDofusCalc.dofus.objets.Equipement.FlagsTypesEquipements;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeEquipement;
import org.JDofusCalc.vues.Qt.designer.UIGestionEquipement;

import com.trolltech.qt.core.Qt;
import com.trolltech.qt.core.Qt.ItemDataRole;
import com.trolltech.qt.gui.QCloseEvent;
import com.trolltech.qt.gui.QLineEdit;
import com.trolltech.qt.gui.QListWidgetItem;
import com.trolltech.qt.gui.QWidget;

/**
 * Fenêtre de gestion de l'équipement.
 * 
 * @author PAPAYA Alexandre
 * @category Fenêtre
 * @version 1.0
 */
public class QWindowGestionEquipement extends QWidget
{
	/*
	 * Variables d'instances
	 */
	
	/* Composants */

	/**
	 * L'interface graphique.
	 */
	public UIGestionEquipement ui = null;

	/* Autres */

	/**
	 * Type de l'équipement.
	 */
	private FlagsTypesEquipements typeEquipement;

	/**
	 * Liste des champs liés à une clef.
	 */
	private HashMap<QLineEdit, FlagsTypesEffets> champs;

	/*
	 * Signaux
	 */

	/**
	 * <p>Ce signal prend 1 argument(s) générique(s) : &lt;{@link SauvegardeEquipement} (nom: sauvegarde)&gt;.</p>
	 * <p>Ce signal est émit lors d'une demande de sauvegarde de l'équipement {@code sauvegarde}.</p>
	 */
	public Signal1<SauvegardeEquipement> signalSauvergarderEquipement = new Signal1<SauvegardeEquipement>();

	/**
	 * <p>Ce signal prend 1 argument(s) générique(s) : &lt;{@link SauvegardeEquipement} (nom: sauvegarde)&gt;.</p>
	 * <p>Ce signal est émit lors d'une demande de suppression de l'équipement {@code sauvegarde}.</p>
	 */
	public Signal1<SauvegardeEquipement> signalSupprimerEquipement = new Signal1<SauvegardeEquipement>();

	/**
	 * <p>Ce signal prend 1 argument(s) générique(s) : &lt;{@link String} (nom: nom)&gt;.</p>
	 * <p>Ce signal est émit lors d'une demande de création d'un équipement {@code nom}.</p>
	 */
	public Signal1<String> signalCreerEquipement = new Signal1<String>();

	/**
	 * <p>Ce signal prend aucun argument générique.</p>
	 * <p>Ce signal est émit lors d'une demande de fermeture de la fenêtre.</p>
	 */
	public Signal0 signalFermer = new Signal0();

	/*
	 * Constructeurs / Destructeur
	 */

	/**
	 * Construit une nouvelle fenêtre.
	 * 
	 * @param parent - Fenêtre parente.
	 * @param typeEquipement - Type de l'arme.
	 * @category Constructeur
	 */
	public QWindowGestionEquipement(QWidget parent, FlagsTypesEquipements typeEquipement)
	{
		// Execution du constructeur de la classe mère
		super(parent, Qt.WindowType.Window);
		this.typeEquipement = typeEquipement;

		// Initialisation de l'interface graphique
		this.ui = new UIGestionEquipement();
		this.ui.setupUi(this);
		this.setWindowTitle("Gérer " + typeEquipement.getNom());
		this.ui.lblListe.setText(typeEquipement.getNom() + " enregistré(e)s :");

		this.champs = new HashMap<QLineEdit, FlagsTypesEffets>();
		this.champs.put(this.ui.txtStatsVie, FlagsTypesEffets.Vie);
		this.champs.put(this.ui.txtStatsPA, FlagsTypesEffets.Pa);
		this.champs.put(this.ui.txtStatsPM, FlagsTypesEffets.Pm);
		this.champs.put(this.ui.txtStatsPO, FlagsTypesEffets.Po);
		this.champs.put(this.ui.txtStatsIni, FlagsTypesEffets.Initiative);
		this.champs.put(this.ui.txtStatsPP, FlagsTypesEffets.Prospection);

		this.champs.put(this.ui.txtStatsVita, FlagsTypesEffets.Vitalite);
		this.champs.put(this.ui.txtStatsSag, FlagsTypesEffets.Sagesse);
		this.champs.put(this.ui.txtStatsForce, FlagsTypesEffets.Force);
		this.champs.put(this.ui.txtStatsInt, FlagsTypesEffets.Intelligence);
		this.champs.put(this.ui.txtStatsChance, FlagsTypesEffets.Chance);
		this.champs.put(this.ui.txtStatsAgi, FlagsTypesEffets.Agilite);

		this.champs.put(this.ui.txtStatsDom, FlagsTypesEffets.Dommages);
		this.champs.put(this.ui.txtStatsPDom, FlagsTypesEffets.PourcentagesDommages);
		this.champs.put(this.ui.txtStatsCC, FlagsTypesEffets.CoupsCritiques);
		this.champs.put(this.ui.txtStatsSoin, FlagsTypesEffets.Soins);
		this.champs.put(this.ui.txtStatsInvoc, FlagsTypesEffets.CreaturesInvocables);
		this.champs.put(this.ui.txtStatsDomPiege, FlagsTypesEffets.DommagesPieges);
		this.champs.put(this.ui.txtStatsPDomPiege, FlagsTypesEffets.PourcentagesDommagesPieges);
		this.champs.put(this.ui.txtStatsEC, FlagsTypesEffets.EchecsCritiques);
		this.champs.put(this.ui.txtStatsRenvois, FlagsTypesEffets.Renvois);

		this.champs.put(this.ui.txtStatsResMagique, FlagsTypesEffets.ResistancesMagiques);
		this.champs.put(this.ui.txtStatsResPhysique, FlagsTypesEffets.ResistancesPhysiques);

		if(!this.typeEquipement.equals(FlagsTypesEquipements.Bouclier.getNom()))
		{
			this.champs.put(this.ui.txtStatsResNeutre, FlagsTypesEffets.ResistancesNeutre);
			this.champs.put(this.ui.txtStatsResTerre, FlagsTypesEffets.ResistancesTerre);
			this.champs.put(this.ui.txtStatsResFeu, FlagsTypesEffets.ResistancesFeu);
			this.champs.put(this.ui.txtStatsResEau, FlagsTypesEffets.ResistancesEau);
			this.champs.put(this.ui.txtStatsResAir, FlagsTypesEffets.ResistancesAir);
			this.champs.put(this.ui.txtStatsPResNeutre, FlagsTypesEffets.PourcentagesResistancesNeutre);
			this.champs.put(this.ui.txtStatsPResTerre, FlagsTypesEffets.PourcentagesResistancesTerre);
			this.champs.put(this.ui.txtStatsPResFeu, FlagsTypesEffets.PourcentagesResistancesFeu);
			this.champs.put(this.ui.txtStatsPResEau, FlagsTypesEffets.PourcentagesResistancesEau);
			this.champs.put(this.ui.txtStatsPResAir, FlagsTypesEffets.PourcentagesResistancesAir);

		}
		else
		{
			this.champs.put(this.ui.txtStatsResNeutre, FlagsTypesEffets.ResistancesNeutrePvp);
			this.champs.put(this.ui.txtStatsResTerre, FlagsTypesEffets.ResistancesTerrePvp);
			this.champs.put(this.ui.txtStatsResFeu, FlagsTypesEffets.ResistancesFeuPvp);
			this.champs.put(this.ui.txtStatsResEau, FlagsTypesEffets.ResistancesEauPvp);
			this.champs.put(this.ui.txtStatsResAir, FlagsTypesEffets.ResistancesAirPvp);
			this.champs.put(this.ui.txtStatsPResNeutre, FlagsTypesEffets.PourcentagesResistancesNeutrePvp);
			this.champs.put(this.ui.txtStatsPResTerre, FlagsTypesEffets.PourcentagesResistancesTerrePvp);
			this.champs.put(this.ui.txtStatsPResFeu, FlagsTypesEffets.PourcentagesResistancesFeuPvp);
			this.champs.put(this.ui.txtStatsPResEau, FlagsTypesEffets.PourcentagesResistancesEauPvp);
			this.champs.put(this.ui.txtStatsPResAir, FlagsTypesEffets.PourcentagesResistancesAirPvp);

		}

		/* Connexions signal->slot */
		this.ui.btnChargerModele.clicked.connect(this, "slotChargementModele()");
		this.ui.btnSauv.clicked.connect(this, "slotSauvegardeEquipement()");
		this.ui.listeEquip.clicked.connect(this, "slotSelectionSauvegarde()");
		this.ui.btnSupp.clicked.connect(this, "slotSuppressionEquipement()");
		this.ui.btnNouveau.clicked.connect(this, "slotCreationEquipement()");
	}

	/*
	 * Evènements
	 */
	
	@Override
	protected void closeEvent(QCloseEvent event)
	{
		super.closeEvent(event);
		this.signalFermer.emit();
	}

	/*
	 * Méthodes d'affichage des données de la fenêtre
	 */

	/**
	 * Définit l'équipement à charger par la fenêtre.
	 * 
	 * @param arme - Equipement à charger.
	 * @param effets - Effets de l'équipement à charger.
	 */
	@SuppressWarnings("unchecked")
	private void setEquipement(Equipement equipement, Effets effets)
	{
		this.ui.txtNom.setText(equipement.getNom());
		this.ui.spinBoxNiveau.setValue(equipement.getNiveau());

		HashMap<Integer, Panoplie> panoData = (HashMap<Integer, Panoplie>) this.ui.comboPano.itemData(0);
		if(equipement.getPanoplie() != 0)
		{
			int indexCombo = this.ui.comboPano.findText(panoData.get(equipement.getPanoplie()).getNom());
			if(indexCombo != -1)
			{
				this.ui.comboPano.setCurrentIndex(indexCombo);
			}
			else
			{
				this.ui.comboPano.setCurrentIndex(0);
			}
		}
		else
		{
			this.ui.comboPano.setCurrentIndex(0);
		}

		for(Entry<QLineEdit, FlagsTypesEffets> entry : this.champs.entrySet())
		{
			int valeur = effets.getInt(entry.getValue());
			QLineEdit txt = entry.getKey();
			if(valeur != 0)
			{
				txt.setText(String.valueOf(valeur));
			}
			else
			{
				txt.setText("");
			}
		}

		// Conditions
		this.ui.widgetConditions.setConditions(equipement.getConditions());
	}

	/**
	 * Définit la liste des classes.
	 * 
	 * @param classes - La liste des classes.
	 */
	public void setListeClasses(HashMap<Integer, Classe> classes)
	{
		this.ui.widgetConditions.setListeClasses(classes);
	}

	/**
	 * Définit la liste des panoplies.
	 * 
	 * @param panoplies - La liste des panoplies.
	 */
	public void setListePanoplies(HashMap<Integer, Panoplie> panoplies)
	{
		// Vide le combo
		this.ui.comboPano.clear();

		this.ui.comboPano.addItem("<Aucune>");
		this.ui.comboPano.setItemData(0, panoplies);

		int i = 1;
		for(Entry<Integer, Panoplie> entry : panoplies.entrySet())
		{
			Panoplie panoplie = entry.getValue();
			// Ajoute l'item dans le combo
			this.ui.comboPano.addItem(panoplie.getNom());
			// Enregistre les données de la panoplie
			this.ui.comboPano.setItemData(i, panoplie);

			i++;
		}
	}

	/**
	 * Définit la liste des sauvegardes des équipements.
	 * 
	 * @param sauvegardes - La liste des sauvegardes.
	 */
	public void setListeSauvegardesEquipements(ArrayList<SauvegardeEquipement> sauvegardes)
	{
		this.ui.listeEquip.clear();
		for(int i = 0; i < sauvegardes.size(); i++)
		{
			QListWidgetItem item = new QListWidgetItem();
			item.setText(sauvegardes.get(i).getNom());
			item.setData(ItemDataRole.UserRole, sauvegardes.get(i));
			this.ui.listeEquip.addItem(item);
		}
	}

	/**
	 * Définit la liste des modèles des équipements.
	 * 
	 * @param modeles - La liste des modèles.
	 */
	public void setListeModelesEquipements(ArrayList<Equipement> modeles)
	{
		// Vide le combo
		this.ui.comboModele.clear();
		this.ui.comboModele.addItem("<Aucune>");
		for(int i = 0; i < modeles.size(); i++)
		{
			// Ajoute l'item dans le combo
			this.ui.comboModele.addItem(modeles.get(i).getNom());
			// Enregistre les données du modele
			this.ui.comboModele.setItemData((i + 1), modeles.get(i));
		}
		this.ui.filtre.setCombo(this.ui.comboModele);
	}

	/*
	 * Slots de la fenêtre
	 */

	/**
	 * Charge le modèle de l'équipement selectionné.
	 * 
	 * @category Slot
	 */
	public void slotChargementModele()
	{
		if(this.ui.comboModele.currentIndex() != 0)
		{
			Equipement modele = (Equipement) this.ui.comboModele.itemData(this.ui.comboModele.currentIndex());

			Effets effets;
			if(this.ui.rbtnMini.isChecked())
			{
				effets = modele.getEffetsMinimums();
			}
			else if(this.ui.rbtnMaxi.isChecked())
			{
				effets = modele.getEffetsMaximums();
			}
			else
			{
				effets = new Effets();

				HashMap<FlagsTypesEffets, Double> hashmap = modele.getEffetsMinimums().getHashMap();
				for(Entry<FlagsTypesEffets, Double> entry : hashmap.entrySet())
				{
					FlagsTypesEffets clef = entry.getKey();
					Double jetMini = entry.getValue();
					Double jetMaxi = modele.getEffetsMaximums().getDouble(clef);

					effets.setInt(clef, (int) Math.floor((jetMini + jetMaxi) / 2));
				}
			}

			this.setEquipement(modele, effets);
		}
	}

	/**
	 * Charge la sauvegarde de l'équipement selectionné.
	 * 
	 * @category Slot
	 */
	public void slotSelectionSauvegarde()
	{
		if(this.ui.listeEquip.selectedItems().size() == 1)
		{
			// Activation des boutons
			this.ui.btnSupp.setEnabled(true);
			this.ui.btnSauv.setEnabled(true);
			this.ui.txtNom.setEnabled(true);
			this.ui.btnChargerModele.setEnabled(true);

			QListWidgetItem item = this.ui.listeEquip.currentItem();
			SauvegardeEquipement sauvegarde = (SauvegardeEquipement) item.data(ItemDataRole.UserRole);

			this.setEquipement(sauvegarde, sauvegarde.getEffets());
		}
	}

	/*
	 * Slot-Signaux de la fenêtre
	 */

	/**
	 * Demande la sauvegarde de l'équipement selectionné.
	 * 
	 * @category Slot-Signal
	 */
	public void slotSauvegardeEquipement()
	{
		if(this.ui.listeEquip.selectedItems().size() == 1)
		{
			QListWidgetItem item = this.ui.listeEquip.currentItem();
			SauvegardeEquipement sauvegarde = (SauvegardeEquipement) item.data(ItemDataRole.UserRole);

			Effets effets = new Effets();
			for(Entry<QLineEdit, FlagsTypesEffets> entry : this.champs.entrySet())
			{
				FlagsTypesEffets clef = entry.getValue();
				QLineEdit txt = entry.getKey();
				if(txt.text().equals(""))
				{
					effets.setInt(clef, 0);
				}
				else
				{
					effets.setInt(clef, Integer.parseInt(txt.text()));
				}
			}
			sauvegarde.setEffets(effets);

			sauvegarde.setNom(this.ui.txtNom.text().trim());
			sauvegarde.setNiveau(this.ui.spinBoxNiveau.value());

			if(this.ui.comboPano.currentIndex() != 0)
			{
				Panoplie itemData = (Panoplie) this.ui.comboPano.itemData(this.ui.comboPano.currentIndex());
				sauvegarde.setPanoplie(itemData.getIdDofus());
			}
			else
			{
				sauvegarde.setPanoplie(0);
			}

			// Conditions
			sauvegarde.setConditions(this.ui.widgetConditions.getConditions());

			// Envoie d'un signal
			this.signalSauvergarderEquipement.emit(sauvegarde);
		}
	}

	/**
	 * Demande la suppression de l'équipement selectionné.
	 * 
	 * @category Slot-Signal
	 */
	public void slotSuppressionEquipement()
	{
		if(this.ui.listeEquip.selectedItems().size() == 1)
		{
			// Desactive les boutons
			this.ui.btnSupp.setEnabled(false);
			this.ui.btnSauv.setEnabled(false);
			this.ui.txtNom.setEnabled(false);

			QListWidgetItem item = this.ui.listeEquip.currentItem();
			SauvegardeEquipement sauvegarde = (SauvegardeEquipement) item.data(ItemDataRole.UserRole);

			this.signalSupprimerEquipement.emit(sauvegarde);
		}
	}

	/**
	 * Demande la création d'un nouvel équipement.
	 * 
	 * @category Slot-Signal
	 */
	public void slotCreationEquipement()
	{
		// Génération d'un nouveau nom
		String nouveauNom = "Nouvel équipement";
		int nbNouveau = this.ui.listeEquip.findItems(nouveauNom, Qt.MatchFlag.MatchStartsWith).size();
		String nom = "";
		if(nbNouveau == 0)
		{
			nom = nouveauNom;
		}
		else
		{
			nom = nouveauNom + (nbNouveau + 1);
		}

		// Envoie d'un signal
		this.signalCreerEquipement.emit(nom);
	}
}