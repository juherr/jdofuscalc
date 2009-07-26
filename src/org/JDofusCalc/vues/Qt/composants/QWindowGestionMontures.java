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
import org.JDofusCalc.dofus.objets.Monture;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeMonture;
import org.JDofusCalc.vues.Qt.designer.UIGestionMontures;

import com.trolltech.qt.core.Qt;
import com.trolltech.qt.core.Qt.ItemDataRole;
import com.trolltech.qt.gui.QCloseEvent;
import com.trolltech.qt.gui.QLineEdit;
import com.trolltech.qt.gui.QListWidgetItem;
import com.trolltech.qt.gui.QWidget;

/**
 * Fenêtre de gestion des montures.
 * 
 * @author PAPAYA Alexandre
 * @category Fenêtre
 * @version 1.0
 */
public class QWindowGestionMontures extends QWidget
{
	/*
	 * Variables d'instances
	 */
	
	/* Composants */

	/**
	 * L'interface graphique.
	 */
	public UIGestionMontures ui;

	/**
	 * Fenêtre parente.
	 */
	QWidget parent;

	/* Autres */
	
	/**
	 * Liste des champs liés à une clef.
	 */
	private HashMap<QLineEdit, FlagsTypesEffets> champs;

	/**
	 * Liste des modèles des montures.
	 */
	private HashMap<Integer, Monture> listeModeles;
	
	/*
	 * Signaux
	 */

	/**
	 * <p>Ce signal prend 1 argument(s) générique(s) : &lt;{@link SauvegardeMonture} (nom: sauvegarde)&gt;.</p>
	 * <p>Ce signal est émit lors d'une demande de sauvegarde de la monture {@code sauvegarde}.</p>
	 */
	public Signal1<SauvegardeMonture> signalSauvergarderMonture = new Signal1<SauvegardeMonture>();

	/**
	 * <p>Ce signal prend 1 argument(s) générique(s) : &lt;{@link SauvegardeMonture} (nom: sauvegarde)&gt;.</p>
	 * <p>Ce signal est émit lors d'une demande de suppression de la monture {@code sauvegarde}.</p>
	 */
	public Signal1<SauvegardeMonture> signalSupprimerMonture = new Signal1<SauvegardeMonture>();

	/**
	 * <p>Ce signal prend 1 argument(s) générique(s) : &lt;{@link String} (nom: nom)&gt;.</p>
	 * <p>Ce signal est émit lors d'une demande de création d'une monture {@code nom}.</p>
	 */
	public Signal1<String> signalCreerMonture = new Signal1<String>();

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
	public QWindowGestionMontures(QWidget parent)
	{
		// Execution du constructeur de la classe mère
		super(parent, Qt.WindowType.Window);
		this.parent = parent;

		// Initialisation de l'interface graphique
		this.ui = new UIGestionMontures();
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
		this.ui.listeMontures.currentItemChanged.connect(this, "slotSelectionSauvegarde()");
		this.ui.listeMontures.clicked.connect(this, "slotSelectionSauvegarde()");
		this.ui.comboRaces.currentIndexChanged.connect(this, "slotChangementRace()");
		this.ui.spinBoxNiveau.valueChanged.connect(this, "slotChangementRace()");
		this.ui.btnSauv.clicked.connect(this, "slotSauvegardeMonture()");
		this.ui.btnSupp.clicked.connect(this, "slotSuppressionMonture()");
		this.ui.btnNouveau.clicked.connect(this, "slotCreationMonture()");
		this.ui.btnFermer.clicked.connect(this, "slotFermeture()");
	}

	@Override
	protected void closeEvent(QCloseEvent event)
	{
		super.closeEvent(event);
		this.signalFermer.emit();
	}
	
	/*
	 * Evènements
	 */

	/**
	 * Définit la liste des sauvegardes des montures.
	 * 
	 * @param sauvegardes - La liste des sauvegardes.
	 */
	public void setListeSauvegardesMontures(ArrayList<SauvegardeMonture> sauvegardes)
	{
		this.ui.listeMontures.clear();
		for(int i = 0; i < sauvegardes.size(); i++)
		{
			QListWidgetItem item = new QListWidgetItem();
			item.setText(sauvegardes.get(i).getNom());
			item.setData(ItemDataRole.UserRole, sauvegardes.get(i));
			this.ui.listeMontures.addItem(item);
		}
	}

	/**
	 * Définit la liste des modèles des montures.
	 * 
	 * @param modeles - La liste des modèles.
	 */
	public void setListeModelesMontures(HashMap<Integer, Monture> modeles)
	{
		// Vide le combo
		this.ui.comboRaces.blockSignals(true);
		this.ui.comboRaces.clear();
		this.listeModeles = modeles;
		int i = 0;
		for(Entry<Integer, Monture> entry : modeles.entrySet())
		{
			Monture monture = entry.getValue();

			// Ajoute l'item dans le combo
			this.ui.comboRaces.addItem(monture.getNom());
			// Enregistre les données du modele
			this.ui.comboRaces.setItemData(i, monture);

			i++;
		}
		this.ui.comboRaces.blockSignals(false);
		this.ui.filtre.setCombo(this.ui.comboRaces);
	}

	/**
	 * Définit la monture à charger par la fenêtre.
	 * 
	 * @param arme - Monture à charger.
	 * @param effets - Effets de l'arme à charger.
	 */
	private void setMonture(SauvegardeMonture sauvegarde)
	{
		this.ui.txtNom.setText(sauvegarde.getNom());
		this.ui.spinBoxNiveau.setValue(sauvegarde.getNiveauMonture());
		this.ui.spinBoxNiveauPerso.setValue(sauvegarde.getNiveau());
		Monture monture = this.listeModeles.get(sauvegarde.getRace());
		int index = -1;
		if(monture != null)
		{
			index = this.ui.comboRaces.findText(monture.getNom());
		}
		if(index != -1)
		{
			this.ui.comboRaces.setCurrentIndex(index);
		}
		else
		{
			this.ui.comboRaces.setCurrentIndex(0);
		}

		for(Entry<QLineEdit, FlagsTypesEffets> entry : this.champs.entrySet())
		{
			int valeur = sauvegarde.getEffets().getInt(entry.getValue());
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
	 * Change la race de la monture.
	 * 
	 * @category Slot
	 */
	public void slotChangementRace()
	{
		Monture monture = (Monture) this.ui.comboRaces.itemData(this.ui.comboRaces.currentIndex());
		for(Entry<QLineEdit, FlagsTypesEffets> entry : this.champs.entrySet())
		{
			double valeurNiveau = monture.getEffetsNiveau().getDouble(entry.getValue());
			int valeur = (int) Math.floor(this.ui.spinBoxNiveau.value() * valeurNiveau);
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

	/**
	 * Charge la sauvegarde de la monture selectionnée.
	 * 
	 * @category Slot
	 */
	public void slotSelectionSauvegarde()
	{
		if(this.ui.listeMontures.selectedItems().size() == 1)
		{
			// Activation des boutons
			this.ui.btnSupp.setEnabled(true);
			this.ui.btnSauv.setEnabled(true);
			this.ui.txtNom.setEnabled(true);
			this.ui.spinBoxNiveau.setEnabled(true);
			this.ui.comboRaces.setEnabled(true);

			QListWidgetItem item = this.ui.listeMontures.currentItem();
			SauvegardeMonture sauvegarde = (SauvegardeMonture) item.data(ItemDataRole.UserRole);

			this.setMonture(sauvegarde);
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
	 * Demande la sauvegarde de la monture selectionnée.
	 * 
	 * @category Slot-Signal
	 */
	public void slotSauvegardeMonture()
	{
		if(this.ui.listeMontures.selectedItems().size() == 1)
		{
			QListWidgetItem item = this.ui.listeMontures.currentItem();
			SauvegardeMonture sauvegarde = (SauvegardeMonture) item.data(ItemDataRole.UserRole);

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
			Monture monture = (Monture) this.ui.comboRaces.itemData(this.ui.comboRaces.currentIndex());
			sauvegarde.setRace(monture.getId());
			sauvegarde.setNiveau(this.ui.spinBoxNiveauPerso.value());
			sauvegarde.setNiveauMonture(this.ui.spinBoxNiveau.value());
			sauvegarde.setEffets(effets);
			sauvegarde.setNom(this.ui.txtNom.text().trim());

			this.signalSauvergarderMonture.emit(sauvegarde);
		}
	}

	/**
	 * Demande la suppression de la monture selectionnée.
	 * 
	 * @category Slot-Signal
	 */
	public void slotSuppressionMonture()
	{
		if(this.ui.listeMontures.selectedItems().size() == 1)
		{
			// Désctivation des boutons
			this.ui.btnSupp.setEnabled(false);
			this.ui.btnSauv.setEnabled(false);
			this.ui.txtNom.setEnabled(false);
			this.ui.spinBoxNiveau.setEnabled(false);
			this.ui.comboRaces.setEnabled(false);

			QListWidgetItem item = this.ui.listeMontures.currentItem();
			SauvegardeMonture sauvegarde = (SauvegardeMonture) item.data(ItemDataRole.UserRole);

			this.signalSupprimerMonture.emit(sauvegarde);
		}
	}

	/**
	 * Demande la création d'une nouvelle monture.
	 * 
	 * @category Slot-Signal
	 */
	public void slotCreationMonture()
	{
		// Génération d'un nouveau nom
		String nouveauNom = "Nouvelle monture";
		int nbNouveauDofus = this.ui.listeMontures.findItems(nouveauNom, Qt.MatchFlag.MatchStartsWith).size();
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
		this.signalCreerMonture.emit(nom);
	}
}