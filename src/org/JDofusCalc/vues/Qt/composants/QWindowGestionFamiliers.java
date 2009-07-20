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

import org.JDofusCalc.dofus.autres.Effets;
import org.JDofusCalc.dofus.autres.Effets.FlagsTypesEffets;
import org.JDofusCalc.dofus.objets.Familier;
import org.JDofusCalc.dofus.objets.Panoplie;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeFamilier;
import org.JDofusCalc.vues.Qt.designer.UIGestionFamiliers;

import com.trolltech.qt.core.Qt;
import com.trolltech.qt.core.Qt.ItemDataRole;
import com.trolltech.qt.gui.QCloseEvent;
import com.trolltech.qt.gui.QLineEdit;
import com.trolltech.qt.gui.QListWidgetItem;
import com.trolltech.qt.gui.QWidget;

/**
 * Fenêtre de gestion des familiers.
 * 
 * @author PAPAYA Alexandre
 * @category Fenêtre
 * @version 1.0
 */
public class QWindowGestionFamiliers extends QWidget
{
	/*
	 * Variables d'instances
	 */
	
	/* Composants */

	/**
	 * L'interface graphique.
	 */
	public UIGestionFamiliers ui;

	/**
	 * Fenêtre parente.
	 */
	QWidget parent;
	
	/* Autres */

	/**
	 * Liste des champs liés à une clef.
	 */
	private HashMap<QLineEdit, FlagsTypesEffets> champs;

	/*
	 * Signaux
	 */

	/**
	 * <p>Ce signal prend 1 argument(s) générique(s) : &lt;{@link SauvegardeFamilier} (nom: sauvegarde)&gt;.</p>
	 * <p>Ce signal est émit lors d'une demande de sauvegarde du familier {@code sauvegarde}.</p>
	 */
	public Signal1<SauvegardeFamilier> signalSauvergarderFamilier = new Signal1<SauvegardeFamilier>();

	/**
	 * <p>Ce signal prend 1 argument(s) générique(s) : &lt;{@link SauvegardeFamilier} (nom: sauvegarde)&gt;.</p>
	 * <p>Ce signal est émit lors d'une demande de suppression du familier {@code sauvegarde}.</p>
	 */
	public Signal1<SauvegardeFamilier> signalSupprimerFamilier = new Signal1<SauvegardeFamilier>();
	
	/**
	 * <p>Ce signal prend 1 argument(s) générique(s) : &lt;{@link String} (nom: nom)&gt;.</p>
	 * <p>Ce signal est émit lors d'une demande de création d'un familier {@code nom}.</p>
	 */
	public Signal1<String> signalCreerFamilier = new Signal1<String>();

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
	 * @category Constructeur
	 */
	public QWindowGestionFamiliers(QWidget parent)
	{
		// Execution du constructeur de la classe mère
		super(parent, Qt.WindowType.Window);
		this.parent = parent;

		// Initialisation de l'interface graphique
		this.ui = new UIGestionFamiliers();
		this.ui.setupUi(this);

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


		/* Connexions signal->slot */
		this.ui.btnChargerModele.clicked.connect(this, "slotChargementModele()");
		this.ui.listeFamiliers.currentItemChanged.connect(this, "slotSelectionSauvegarde()");
		this.ui.listeFamiliers.clicked.connect(this, "slotSelectionSauvegarde()");
		this.ui.btnSauv.clicked.connect(this, "slotSauvegardeFamilier()");
		this.ui.btnSupp.clicked.connect(this, "slotSuppressionFamilier()");
		this.ui.btnNouveau.clicked.connect(this, "slotCreationFamilier()");
		this.ui.btnFermer.clicked.connect(this, "slotFermeture()");
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
	 * Définit la liste des sauvegardes des familiers.
	 * 
	 * @param sauvegardes - La liste des sauvegardes.
	 */
	public void setListeSauvegardesFamiliers(ArrayList<SauvegardeFamilier> sauvegardes)
	{
		this.ui.listeFamiliers.clear();
		for(int i = 0; i < sauvegardes.size(); i++)
		{
			QListWidgetItem item = new QListWidgetItem();
			item.setText(sauvegardes.get(i).getNom());
			item.setData(ItemDataRole.UserRole, sauvegardes.get(i));
			this.ui.listeFamiliers.addItem(item);
		}
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
	 * Définit la liste des modèles des familiers.
	 * 
	 * @param modeles - La liste des modèles.
	 */
	public void setListeModelesFamiliers(ArrayList<Familier> modeles)
	{
		// Vide le combo
		this.ui.comboModele.clear();
		this.ui.comboModele.addItem("<Aucun>");
		for(int i = 0; i < modeles.size(); i++)
		{
			// Ajoute l'item dans le combo
			this.ui.comboModele.addItem(modeles.get(i).getNom());
			// Enregistre les données du modele
			this.ui.comboModele.setItemData((i + 1), modeles.get(i));
		}
		this.ui.filtre.setCombo(this.ui.comboModele);
	}

	/**
	 * Définit la familier à charger par la fenêtre.
	 * 
	 * @param arme - Familier à charger.
	 * @param effets - Effets du familier à charger.
	 */
	@SuppressWarnings("unchecked")
	private void setFamilier(Familier sauvegarde, Effets effets)
	{
		this.ui.txtNom.setText(sauvegarde.getNom());
		this.ui.spinBoxNiveau.setValue(sauvegarde.getNiveau());

		HashMap<Integer, Panoplie> panoData = (HashMap<Integer, Panoplie>) this.ui.comboPano.itemData(0);
		if(sauvegarde.getPanoplie() != 0)
		{
			int indexCombo = this.ui.comboPano.findText(panoData.get(sauvegarde.getPanoplie()).getNom());
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
	}

	/*
	 * Slots de la fenêtre
	 */

	/**
	 * Charge le modèle du familier selectionné.
	 * 
	 * @category Slot
	 */
	public void slotChargementModele()
	{
		if(this.ui.comboModele.currentIndex() != 0)
		{
			Familier modele = (Familier) this.ui.comboModele.itemData(this.ui.comboModele.currentIndex());

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

			this.setFamilier(modele, effets);
		}
	}

	/**
	 * Charge la sauvegarde du familier selectionné.
	 * 
	 * @category Slot
	 */
	public void slotSelectionSauvegarde()
	{
		if(this.ui.listeFamiliers.selectedItems().size() == 1)
		{
			// Activation des boutons
			this.ui.btnSupp.setEnabled(true);
			this.ui.btnSauv.setEnabled(true);
			this.ui.txtNom.setEnabled(true);
			this.ui.btnChargerModele.setEnabled(true);

			QListWidgetItem item = this.ui.listeFamiliers.currentItem();
			SauvegardeFamilier sauvegarde = (SauvegardeFamilier) item.data(ItemDataRole.UserRole);

			this.setFamilier(sauvegarde, sauvegarde.getEffets());
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

	/*
	 * Slot-Signaux de la fenêtre
	 */

	/**
	 * Demande la sauvegarde du familier selectionné.
	 * 
	 * @category Slot-Signal
	 */
	public void slotSauvegardeFamilier()
	{
		if(this.ui.listeFamiliers.selectedItems().size() == 1)
		{
			QListWidgetItem item = this.ui.listeFamiliers.currentItem();
			SauvegardeFamilier sauvegarde = (SauvegardeFamilier) item.data(ItemDataRole.UserRole);

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

			this.signalSauvergarderFamilier.emit(sauvegarde);
		}
	}

	/**
	 * Demande la suppression du familier selectionné.
	 * 
	 * @category Slot-Signal
	 */
	public void slotSuppressionFamilier()
	{
		if(this.ui.listeFamiliers.selectedItems().size() == 1)
		{
			// Désctivation des boutons
			this.ui.btnSupp.setEnabled(false);
			this.ui.btnSauv.setEnabled(false);
			this.ui.txtNom.setEnabled(false);

			QListWidgetItem item = this.ui.listeFamiliers.currentItem();
			SauvegardeFamilier sauvegarde = (SauvegardeFamilier) item.data(ItemDataRole.UserRole);

			this.signalSupprimerFamilier.emit(sauvegarde);
		}
	}

	/**
	 * Demande la création d'un nouveau familier.
	 * 
	 * @category Slot-Signal
	 */
	public void slotCreationFamilier()
	{
		// Génération d'un nouveau nom
		String nouveauNom = "Nouveau familier";
		int nbNouveauDofus = this.ui.listeFamiliers.findItems(nouveauNom, Qt.MatchFlag.MatchStartsWith).size();
		String nom = "";
		if(nbNouveauDofus == 0)
		{
			nom = nouveauNom;
		}
		else
		{
			nom = nouveauNom + (nbNouveauDofus + 1);
		}

		// Envoie d'un signal
		this.signalCreerFamilier.emit(nom);
	}
}