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
import org.JDofusCalc.dofus.autres.DegatsArme;
import org.JDofusCalc.dofus.autres.Effets;
import org.JDofusCalc.dofus.autres.Degats.FlagsTypesDegats;
import org.JDofusCalc.dofus.autres.Effets.FlagsTypesEffets;
import org.JDofusCalc.dofus.objets.Arme;
import org.JDofusCalc.dofus.objets.Panoplie;
import org.JDofusCalc.dofus.objets.Arme.FlagsTypesArmes;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeArme;
import org.JDofusCalc.vues.Qt.VueQt;
import org.JDofusCalc.vues.Qt.designer.UIGestionArmes;

import com.trolltech.qt.core.Qt;
import com.trolltech.qt.core.Qt.ItemDataRole;
import com.trolltech.qt.gui.QCheckBox;
import com.trolltech.qt.gui.QCloseEvent;
import com.trolltech.qt.gui.QComboBox;
import com.trolltech.qt.gui.QLineEdit;
import com.trolltech.qt.gui.QListWidgetItem;
import com.trolltech.qt.gui.QWidget;

/**
 * Fenêtre de gestion des armes.
 * 
 * @author PAPAYA Alexandre
 * @category Fenêtre
 * @version 1.0
 */
public class QWindowGestionArmes extends QWidget
{
	/*
	 * Variables d'instances
	 */
	
	/* Composants */

	/**
	 * L'interface graphique.
	 */
	public UIGestionArmes ui = null;

	/* Autres */

	/**
	 * Liste des champs liés à une clef.
	 */
	private HashMap<QLineEdit, FlagsTypesEffets> champs;

	/*
	 * Signaux
	 */

	/**
	 * <p>Ce signal prend 1 argument(s) générique(s) : &lt;{@link SauvegardeArme} (nom: sauvegarde)&gt;.</p>
	 * <p>Ce signal est émit lors d'une demande de sauvegarde de l'arme {@code sauvegarde}.</p>
	 */
	public Signal1<SauvegardeArme> signalSauvergarderArme = new Signal1<SauvegardeArme>();

	/**
	 * <p>Ce signal prend 1 argument(s) générique(s) : &lt;{@link SauvegardeArme} (nom: sauvegarde)&gt;.</p>
	 * <p>Ce signal est émit lors d'une demande de suppression de l'arme {@code sauvegarde}.</p>
	 */
	public Signal1<SauvegardeArme> signalSupprimerArme = new Signal1<SauvegardeArme>();

	/**
	 * <p>Ce signal prend 1 argument(s) générique(s) : &lt;{@link String} (nom: nom)&gt;.</p>
	 * <p>Ce signal est émit lors d'une demande de création d'une arme {@code nom}.</p>
	 */
	public Signal1<String> signalCreerArme = new Signal1<String>();

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
	 * @param typeArme - Type de l'arme.
	 * @category Constructeur
	 */
	public QWindowGestionArmes(QWidget parent, FlagsTypesArmes typeArme)
	{
		// Execution du constructeur de la classe mère
		super(parent, Qt.WindowType.Window);

		// Initialisation de l'interface graphique
		this.ui = new UIGestionArmes();
		this.ui.setupUi(this);
		this.setWindowTitle("Gérer mes " + typeArme.getNom());
		this.ui.lblListe.setText(typeArme + " enregistré(e)s :");

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
		this.ui.btnSauv.clicked.connect(this, "slotSauvegardeArme()");
		this.ui.listeSauvegardes.clicked.connect(this, "slotSelectionSauvegarde()");
		this.ui.btnSupp.clicked.connect(this, "slotSuppressionArme()");
		this.ui.btnNouveau.clicked.connect(this, "slotCreationArme()");
		this.ui.cboxL2.toggled.connect(this, "slotChangementLigneDegats2()");
		this.ui.cboxL3.toggled.connect(this, "slotChangementLigneDegats3()");
		this.ui.cboxL4.toggled.connect(this, "slotChangementLigneDegats4()");
		this.ui.cboxL5.toggled.connect(this, "slotChangementLigneDegats5()");
		this.ui.btnFM.clicked.connect(this, "slotOuvertureForgemage()");
		this.ui.comboTypeL1.currentIndexChanged.connect(this, "slotChangementTypeL1(int)");
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
	 * Définit l'arme à charger par la fenêtre.
	 * 
	 * @param arme - Arme à charger.
	 * @param effets - Effets de l'arme à charger.
	 */
	@SuppressWarnings("unchecked")
	private void setArme(Arme arme, Effets effets)
	{
		this.ui.txtNom.setText(arme.getNom());
		this.ui.spinBoxNiveau.setValue(arme.getNiveau());

		HashMap<Integer, Panoplie> panoData = (HashMap<Integer, Panoplie>) this.ui.comboPano.itemData(0);
		if(arme.getPanoplie() != 0)
		{
			int indexCombo = this.ui.comboPano.findText(panoData.get(arme.getPanoplie()).getNom());
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

		this.ui.txtCC.setText(String.valueOf(arme.getCoupsCritiques()));
		this.ui.txtDomCC.setText(String.valueOf(arme.getDommagesCoupsCritiques()));
		this.ui.txtEC.setText(String.valueOf(arme.getEchecsCritiques()));
		this.ui.txtPA.setText(String.valueOf(arme.getCoutUtilisation()));

		// Conditions
		this.ui.widgetConditions.setConditions(arme.getConditions());

		// Dégâts
		Object[][] lignesDegats = new Object[][] { new Object[] { arme.getDegats(1), this.ui.comboNatureDegatsL1, this.ui.comboTypeL1, this.ui.txtMinL1, this.ui.txtMaxL1, null }, new Object[] { arme.getDegats(2), this.ui.comboNatureDegatsL2, this.ui.comboTypeL2, this.ui.txtMinL2, this.ui.txtMaxL2, this.ui.cboxL2 }, new Object[] { arme.getDegats(3), this.ui.comboNatureDegatsL3, this.ui.comboTypeL3, this.ui.txtMinL3, this.ui.txtMaxL3, this.ui.cboxL3 }, new Object[] { arme.getDegats(4), this.ui.comboNatureDegatsL4, this.ui.comboTypeL4, this.ui.txtMinL4, this.ui.txtMaxL4, this.ui.cboxL4 }, new Object[] { arme.getDegats(5), this.ui.comboNatureDegatsL5, this.ui.comboTypeL5, this.ui.txtMinL5, this.ui.txtMaxL5, this.ui.cboxL5 } };
		for(int i = 0; i < lignesDegats.length; i++)
		{
			DegatsArme degats = (DegatsArme) lignesDegats[i][0];
			QComboBox comboNature = (QComboBox) lignesDegats[i][1];
			QComboBox comboType = (QComboBox) lignesDegats[i][2];
			QLineEdit txtMin = (QLineEdit) lignesDegats[i][3];
			QLineEdit txtMax = (QLineEdit) lignesDegats[i][4];
			QCheckBox cbox = (QCheckBox) lignesDegats[i][5];

			if(degats != null)
			{
				if(!degats.getNature().equals("soins"))
				{
					if(degats.getNature().equals("vole"))
					{
						comboNature.setCurrentIndex(1);
					}
					else
					{
						comboNature.setCurrentIndex(0);
					}

					if(degats.getElement().equals("neutre"))
					{
						comboType.setCurrentIndex(0);
					}
					else if(degats.getElement().equals("terre"))
					{
						comboType.setCurrentIndex(1);
					}
					else if(degats.getElement().equals("feu"))
					{
						comboType.setCurrentIndex(2);
					}
					else if(degats.getElement().equals("eau"))
					{
						comboType.setCurrentIndex(3);
					}
					else if(degats.getElement().equals("air"))
					{
						comboType.setCurrentIndex(4);
					}

					txtMin.setText(String.valueOf(degats.getMinimum()));
					txtMax.setText(String.valueOf(degats.getMaximum()));

					if(cbox != null)
					{
						cbox.setChecked(true);
					}
				}
				else
				{
					this.ui.comboNatureDegatsL1.setCurrentIndex(2);
					this.ui.comboTypeL1.setEnabled(false);
				}
			}
			else
			{
				if(i > 0)
				{
					cbox.setChecked(false);
				}
			}
		}
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
	 * Définit la liste des sauvegardes des armes.
	 * 
	 * @param sauvegardes - La liste des sauvegardes.
	 */
	public void setListeSauvegardesArmes(ArrayList<SauvegardeArme> sauvegardes)
	{
		this.ui.listeSauvegardes.clear();
		for(int i = 0; i < sauvegardes.size(); i++)
		{
			QListWidgetItem item = new QListWidgetItem();
			item.setText(sauvegardes.get(i).getNom());
			item.setData(ItemDataRole.UserRole, sauvegardes.get(i));
			this.ui.listeSauvegardes.addItem(item);
		}
	}

	/**
	 * Définit la liste des modèles des armes.
	 * 
	 * @param modeles - La liste des modèles.
	 */
	public void setListeModelesArmes(ArrayList<Arme> modeles)
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
	 * Ouvre la fenêtre de forgemagie de l'arme.
	 * 
	 * @category Slot
	 */
	public void slotOuvertureForgemage()
	{
		QWindowForgemage fenetre = new QWindowForgemage(this, Integer.parseInt(this.ui.txtMinL1.text()), Integer.parseInt(this.ui.txtMaxL1.text()));
		VueQt.centrerFenetre(fenetre);
		fenetre.show();
	}

	/**
	 * Charge le modèle de l'arme selectionnée.
	 * 
	 * @category Slot
	 */
	public void slotChargementModele()
	{
		if(this.ui.comboModele.currentIndex() != 0)
		{
			Arme modele = (Arme) this.ui.comboModele.itemData(this.ui.comboModele.currentIndex());

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

			this.setArme(modele, effets);
		}
	}

	/**
	 * Charge la sauvegarde de l'arme selectionnée.
	 * 
	 * @category Slot
	 */
	public void slotSelectionSauvegarde()
	{
		if(this.ui.listeSauvegardes.selectedItems().size() == 1)
		{
			// Activation des boutons
			this.ui.btnSupp.setEnabled(true);
			this.ui.btnSauv.setEnabled(true);
			this.ui.txtNom.setEnabled(true);
			this.ui.btnChargerModele.setEnabled(true);

			QListWidgetItem item = this.ui.listeSauvegardes.currentItem();
			SauvegardeArme sauvegarde = (SauvegardeArme) item.data(ItemDataRole.UserRole);

			this.setArme(sauvegarde, sauvegarde.getEffets());
		}
	}

	/**
	 * Gère le changement de la ligne de dégâts numéro 1.
	 * 
	 * @category Slot
	 */
	public void slotChangementTypeL1(int index)
	{
		if(index == 0)
		{
			this.ui.btnFM.setEnabled(true);
		}
		else
		{
			this.ui.btnFM.setEnabled(false);
		}
	}

	/**
	 * Gère le changement de la ligne de dégâts numéro 2.
	 * 
	 * @category Slot
	 */
	public void slotChangementLigneDegats2()
	{
		if(this.ui.cboxL2.isChecked())
		{
			this.ui.lblDegatsLigne2.setEnabled(true);
			this.ui.cboxL3.setEnabled(true);
			this.ui.comboNatureDegatsL2.setEnabled(true);
			this.ui.comboTypeL2.setEnabled(true);
			this.ui.txtMinL2.setEnabled(true);
			this.ui.txtMaxL2.setEnabled(true);
		}
		else
		{
			this.ui.lblDegatsLigne2.setEnabled(false);
			this.ui.cboxL3.setChecked(false);
			this.ui.cboxL3.setEnabled(false);
			this.ui.comboNatureDegatsL2.setEnabled(false);
			this.ui.comboTypeL2.setEnabled(false);
			this.ui.txtMinL2.setEnabled(false);
			this.ui.txtMaxL2.setEnabled(false);
			this.ui.txtMinL2.setText("");
			this.ui.txtMaxL2.setText("");
		}
	}

	/**
	 * Gère le changement de la ligne de dégâts numéro 3.
	 * 
	 * @category Slot
	 */
	public void slotChangementLigneDegats3()
	{
		if(this.ui.cboxL3.isChecked())
		{
			this.ui.cboxL4.setEnabled(true);
			this.ui.lblDegatsLigne3.setEnabled(true);
			this.ui.comboNatureDegatsL3.setEnabled(true);
			this.ui.comboTypeL3.setEnabled(true);
			this.ui.txtMinL3.setEnabled(true);
			this.ui.txtMaxL3.setEnabled(true);
		}
		else
		{
			this.ui.lblDegatsLigne3.setEnabled(false);
			this.ui.cboxL4.setChecked(false);
			this.ui.cboxL4.setEnabled(false);
			this.ui.comboNatureDegatsL3.setEnabled(false);
			this.ui.comboTypeL3.setEnabled(false);
			this.ui.txtMinL3.setEnabled(false);
			this.ui.txtMaxL3.setEnabled(false);
			this.ui.txtMinL3.setText("");
			this.ui.txtMaxL3.setText("");
		}
	}

	/**
	 * Gère le changement de la ligne de dégâts numéro 4.
	 * 
	 * @category Slot
	 */
	public void slotChangementLigneDegats4()
	{
		if(this.ui.cboxL4.isChecked())
		{
			this.ui.cboxL5.setEnabled(true);
			this.ui.lblDegatsLigne4.setEnabled(true);
			this.ui.comboNatureDegatsL4.setEnabled(true);
			this.ui.comboTypeL4.setEnabled(true);
			this.ui.txtMinL4.setEnabled(true);
			this.ui.txtMaxL4.setEnabled(true);
		}
		else
		{
			this.ui.lblDegatsLigne4.setEnabled(false);
			this.ui.cboxL5.setChecked(false);
			this.ui.cboxL5.setEnabled(false);
			this.ui.comboNatureDegatsL4.setEnabled(false);
			this.ui.comboTypeL4.setEnabled(false);
			this.ui.txtMinL4.setEnabled(false);
			this.ui.txtMaxL4.setEnabled(false);
			this.ui.txtMinL4.setText("");
			this.ui.txtMaxL4.setText("");
		}
	}

	/**
	 * Gère le changement de la ligne de dégâts numéro 5.
	 * 
	 * @category Slot
	 */
	public void slotChangementLigneDegats5()
	{
		if(this.ui.cboxL5.isChecked())
		{
			this.ui.comboNatureDegatsL5.setEnabled(true);
			this.ui.lblDegatsLigne5.setEnabled(true);
			this.ui.comboTypeL5.setEnabled(true);
			this.ui.txtMinL5.setEnabled(true);
			this.ui.txtMaxL5.setEnabled(true);
		}
		else
		{
			this.ui.lblDegatsLigne5.setEnabled(false);
			this.ui.comboNatureDegatsL5.setEnabled(false);
			this.ui.comboTypeL5.setEnabled(false);
			this.ui.txtMinL5.setEnabled(false);
			this.ui.txtMaxL5.setEnabled(false);
			this.ui.txtMinL5.setText("");
			this.ui.txtMaxL5.setText("");
		}
	}

	/*
	 * Slot-Signaux de la fenêtre
	 */

	/**
	 * Demande la sauvegarde de l'arme selectionnée.
	 * 
	 * @category Slot-Signal
	 */
	public void slotSauvegardeArme()
	{
		if(this.ui.listeSauvegardes.selectedItems().size() == 1)
		{
			QListWidgetItem item = this.ui.listeSauvegardes.currentItem();
			SauvegardeArme sauvegarde = (SauvegardeArme) item.data(ItemDataRole.UserRole);

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

			sauvegarde.setCoupsCritiques(Integer.parseInt(this.ui.txtCC.text()));
			sauvegarde.setDommagesCoupsCritiques(Integer.parseInt(this.ui.txtDomCC.text()));
			sauvegarde.setEchecsCritiques(Integer.parseInt(this.ui.txtEC.text()));
			sauvegarde.setCoutUtilisation(Integer.parseInt(this.ui.txtPA.text()));

			Object[][] lignesDegats = new Object[][] { new Object[] { new DegatsArme(), this.ui.comboNatureDegatsL1, this.ui.comboTypeL1, this.ui.txtMinL1, this.ui.txtMaxL1, null }, new Object[] { new DegatsArme(), this.ui.comboNatureDegatsL2, this.ui.comboTypeL2, this.ui.txtMinL2, this.ui.txtMaxL2, this.ui.cboxL2 }, new Object[] { new DegatsArme(), this.ui.comboNatureDegatsL3, this.ui.comboTypeL3, this.ui.txtMinL3, this.ui.txtMaxL3, this.ui.cboxL3 }, new Object[] { new DegatsArme(), this.ui.comboNatureDegatsL4, this.ui.comboTypeL4, this.ui.txtMinL4, this.ui.txtMaxL4, this.ui.cboxL4 }, new Object[] { new DegatsArme(), this.ui.comboNatureDegatsL5, this.ui.comboTypeL5, this.ui.txtMinL5, this.ui.txtMaxL5, this.ui.cboxL5 } };
			for(int i = 0; i < lignesDegats.length; i++)
			{
				DegatsArme degats = (DegatsArme) lignesDegats[i][0];
				QComboBox comboNature = (QComboBox) lignesDegats[i][1];
				QComboBox comboType = (QComboBox) lignesDegats[i][2];
				QLineEdit txtMin = (QLineEdit) lignesDegats[i][3];
				QLineEdit txtMax = (QLineEdit) lignesDegats[i][4];
				QCheckBox cbox = (QCheckBox) lignesDegats[i][5];

				// Si ligne active
				if((cbox == null) || cbox.isChecked())
				{
					// Si dommages
					if(comboNature.currentIndex() == 0)
					{
						degats.set(FlagsTypesDegats.getFlag("Dégâts " + comboType.currentText().toLowerCase() + " minimums"), Integer.parseInt(txtMin.text()));
						degats.set(FlagsTypesDegats.getFlag("Dégâts " + comboType.currentText().toLowerCase() + " maximums"), Integer.parseInt(txtMax.text()));
					}
					// Si vole
					else if(comboNature.currentIndex() == 1)
					{
						degats.set(FlagsTypesDegats.getFlag("Vols de vie " + comboType.currentText().toLowerCase() + " minimums"), Integer.parseInt(txtMin.text()));
						degats.set(FlagsTypesDegats.getFlag("Vols de vie " + comboType.currentText().toLowerCase() + " maximums"), Integer.parseInt(txtMax.text()));
					}
					// Si soins
					else
					{
						degats.set(FlagsTypesDegats.SoinsMin, Integer.parseInt(txtMin.text()));
						degats.set(FlagsTypesDegats.SoinsMax, Integer.parseInt(txtMax.text()));
					}

					sauvegarde.setDegats((i + 1), degats);
				}
				else
				{
					sauvegarde.setDegats((i + 1), null);
				}
			}

			if(this.ui.comboPano.currentIndex() != 0)
			{
				Panoplie itemData = (Panoplie) this.ui.comboPano.itemData(this.ui.comboPano.currentIndex());
				sauvegarde.setPanoplie(itemData.getIdDofus());
			}
			else
			{
				sauvegarde.setPanoplie(0);
			}

			sauvegarde.setConditions(this.ui.widgetConditions.getConditions());

			// Envoie d'un signal
			this.signalSauvergarderArme.emit(sauvegarde);
		}
	}

	/**
	 * Demande la suppression de l'arme selectionnée.
	 * 
	 * @category Slot-Signal
	 */
	public void slotSuppressionArme()
	{
		if(this.ui.listeSauvegardes.selectedItems().size() == 1)
		{
			// Activation des boutons
			this.ui.btnSupp.setEnabled(false);
			this.ui.btnSauv.setEnabled(false);
			this.ui.txtNom.setEnabled(false);

			QListWidgetItem item = this.ui.listeSauvegardes.currentItem();
			SauvegardeArme sauvegarde = (SauvegardeArme) item.data(ItemDataRole.UserRole);

			// Envoie d'un signal
			this.signalSupprimerArme.emit(sauvegarde);
		}
	}

	/**
	 * Demande la création d'une nouvelle arme.
	 * 
	 * @category Slot-Signal
	 */
	public void slotCreationArme()
	{
		// Génération d'un nouveau nom
		String nouveauNom = "Nouvelle arme";
		int nbNouveauArme = this.ui.listeSauvegardes.findItems(nouveauNom, Qt.MatchFlag.MatchStartsWith).size();
		String nom = "";
		if(nbNouveauArme == 0)
		{
			nom = nouveauNom;
		}
		else
		{
			nom = nouveauNom + (nbNouveauArme + 1);
		}

		// Envoie d'un signal
		this.signalCreerArme.emit(nom);
	}
}