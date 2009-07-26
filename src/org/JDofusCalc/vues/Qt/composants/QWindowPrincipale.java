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

import org.JDofusCalc.Main;
import org.JDofusCalc.dofus.autres.Classe;
import org.JDofusCalc.dofus.autres.Degats;
import org.JDofusCalc.dofus.autres.Effets;
import org.JDofusCalc.dofus.autres.Sort;
import org.JDofusCalc.dofus.autres.Degats.FlagsTypesDegats;
import org.JDofusCalc.dofus.autres.Effets.FlagsTypesEffets;
import org.JDofusCalc.dofus.autres.Formules.TauxPunition;
import org.JDofusCalc.dofus.autres.Sort.NatureSortsFlags;
import org.JDofusCalc.dofus.objets.Arme.FlagsTypesArmes;
import org.JDofusCalc.dofus.objets.Dofus.FlagsTypesDofus;
import org.JDofusCalc.dofus.objets.Equipement.FlagsTypesEquipements;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeArme;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeDofus;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeEquipement;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeFamilier;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeMonture;
import org.JDofusCalc.dofus.sauvegardes.SauvegardePersonnage;
import org.JDofusCalc.vues.Qt.VueQt;
import org.JDofusCalc.vues.Qt.designer.UIPrincipale;

import com.trolltech.qt.QSignalEmitter;
import com.trolltech.qt.core.QSize;
import com.trolltech.qt.core.Qt;
import com.trolltech.qt.core.Qt.AlignmentFlag;
import com.trolltech.qt.gui.QAction;
import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QFrame;
import com.trolltech.qt.gui.QHBoxLayout;
import com.trolltech.qt.gui.QLabel;
import com.trolltech.qt.gui.QLineEdit;
import com.trolltech.qt.gui.QMainWindow;
import com.trolltech.qt.gui.QPixmap;
import com.trolltech.qt.gui.QProgressBar;
import com.trolltech.qt.gui.QSpinBox;
import com.trolltech.qt.gui.QStandardItem;
import com.trolltech.qt.gui.QStandardItemModel;
import com.trolltech.qt.gui.QTableWidgetItem;
import com.trolltech.qt.gui.QWidget;
import com.trolltech.qt.gui.QAbstractSpinBox.ButtonSymbols;
import com.trolltech.qt.gui.QSizePolicy.Policy;

/**
 * Fenêtre principale de l'application.
 * 
 * @author PAPAYA Alexandre
 * @category Fenetre
 * @version 1.0
 */
public class QWindowPrincipale extends QMainWindow
{
	/*
	 * Variables d'instances
	 */

	/* Composants */

	/**
	 * L'interface graphique.
	 */
	public UIPrincipale ui;

	/**
	 * Label de la barre de progression.
	 */
	private QLabel lblBarreProgression;

	/**
	 * La barre de progression.
	 */
	private QProgressBar barreProgression;

	/**
	 * La frame contenant les composants de progression.
	 */
	private QFrame frameBarreProgression;

	/* Autres */

	/**
	 * Tableau de correspondances effet -> champ.
	 */
	HashMap<FlagsTypesEffets, QLineEdit> tableauCorrespondances;
	
	/**
	 * Références des {@link QAction} des armes.
	 */
	private HashMap<Integer, QStandardItem> referencesArmes;

	/*
	 * Signaux
	 */

	/**
	 * <p>
	 * Ce signal prend 1 argument(s) générique(s) : &lt;{@link SauvegardeArme} (nom: classe)&gt;.
	 * </p>
	 * <p>
	 * Ce signal est émit lors d'une demande de changement de classe du personnage.
	 * </p>
	 */
	public Signal1<Classe> signalChangerClasse = new Signal1<Classe>();

	/**
	 * <p>
	 * Ce signal prend aucun argument générique.
	 * </p>
	 * <p>
	 * Ce signal est émit lors d'une demande de sauvegarde du personnage.
	 * </p>
	 */
	public Signal0 signalSauvegarderPersonnage = new Signal0();

	/**
	 * <p>
	 * Ce signal prend aucun argument générique.
	 * </p>
	 * <p>
	 * Ce signal est émit lors d'une demande de génération d'un nouveau personnage.
	 * </p>
	 */
	public Signal0 signalNouveauPersonnage = new Signal0();

	/**
	 * <p>
	 * Ce signal prend aucun argument générique.
	 * </p>
	 * <p>
	 * Ce signal est émit lors d'une demande de chargement d'un personnage.
	 * </p>
	 */
	public Signal0 signalChargerPersonnage = new Signal0();

	/**
	 * <p>
	 * Ce signal prend aucun argument générique.
	 * </p>
	 * <p>
	 * Ce signal est émit lors d'une demande de sauvegarde du groupe d'objets.
	 * </p>
	 */
	public Signal0 signalSauvegarderGroupe = new Signal0();

	/**
	 * <p>
	 * Ce signal prend aucun argument générique.
	 * </p>
	 * <p>
	 * Ce signal est émit lors d'une demande de génération d'un nouveau groupe d'objets.
	 * </p>
	 */
	public Signal0 signalNouveauGroupe = new Signal0();

	/**
	 * <p>
	 * Ce signal prend aucun argument générique.
	 * </p>
	 * <p>
	 * Ce signal est émit lors d'une demande de chargement d'un groupe d'objets.
	 * </p>
	 */
	public Signal0 signalChargerGroupe = new Signal0();

	/**
	 * <p>
	 * Ce signal prend 1 argument(s) générique(s) : &lt;{@link FlagsTypesEquipements} (nom: type)&gt;.
	 * </p>
	 * <p>
	 * Ce signal est émit lors d'une demande d'ouverture d'une fenêtre de gestion des équipements {@code type}.
	 * </p>
	 */
	public Signal1<FlagsTypesEquipements> signalGererEquipement = new Signal1<FlagsTypesEquipements>();

	/**
	 * <p>
	 * Ce signal prend aucun argument générique.
	 * </p>
	 * <p>
	 * Ce signal est émit lors d'une demande d'ouverture d'une fenêtre de gestion des familiers.
	 * </p>
	 */
	public Signal0 signalGererFamiliers = new Signal0();

	/**
	 * <p>
	 * Ce signal prend aucun argument générique.
	 * </p>
	 * <p>
	 * Ce signal est émit lors d'une demande d'ouverture d'une fenêtre de gestion des montures.
	 * </p>
	 */
	public Signal0 signalGererMontures = new Signal0();

	/**
	 * <p>
	 * Ce signal prend 1 argument(s) générique(s) : &lt;{@link FlagsTypesDofus} (nom: type)&gt;.
	 * </p>
	 * <p>
	 * Ce signal est émit lors d'une demande d'ouverture d'une fenêtre de gestion des Dofus {@code type}.
	 * </p>
	 */
	public Signal1<FlagsTypesDofus> signalGererDofus = new Signal1<FlagsTypesDofus>();

	/**
	 * <p>
	 * Ce signal prend 1 argument(s) générique(s) : &lt;{@link FlagsTypesArmes} (nom: type)&gt;.
	 * </p>
	 * <p>
	 * Ce signal est émit lors d'une demande d'ouverture d'une fenêtre de gestion des armes {@code type}.
	 * </p>
	 */
	public Signal1<FlagsTypesArmes> signalGererArmes = new Signal1<FlagsTypesArmes>();

	/**
	 * <p>
	 * Ce signal prend aucun argument générique.
	 * </p>
	 * <p>
	 * Ce signal est émit lors d'une demande de mise à jour de l'application.
	 * </p>
	 */
	public Signal0 signalMettreAJour = new Signal0();

	/**
	 * <p>
	 * Ce signal prend 2 argument(s) générique(s) : &lt;{@link String} (nom: nomSort), {@link Integer} (nom: niveau)&gt;.
	 * </p>
	 * <p>
	 * Ce signal est émit lors d'une demande de changement de niveau d'un sort.
	 * </p>
	 */
	public Signal2<String, Integer> signalChangerNiveauSort = new Signal2<String, Integer>();

	/**
	 * <p>
	 * Ce signal prend 2 argument(s) générique(s) : &lt;{@link FlagsTypesArmes} (nom: type), {@link Integer} (nom: niveau)&gt;.
	 * </p>
	 * <p>
	 * Ce signal est émit lors d'une demande de changement de niveau d'une maîtrise de l'arme {@code type}.
	 * </p>
	 */
	public Signal2<FlagsTypesArmes, Integer> signalChangerNiveauMaitrise = new Signal2<FlagsTypesArmes, Integer>();

	/**
	 * <p>
	 * Ce signal prend 1 argument(s) générique(s) : &lt;{@link Integer} (nom: mode)&gt;.
	 * </p>
	 * <p>
	 * Ce signal est émit lors d'une demande de changement du mode de calcul des statistiques globales.
	 * </p>
	 */
	public Signal1<Integer> signalChangerMode = new Signal1<Integer>();

	/**
	 * <p>
	 * Ce signal prend 1 argument(s) générique(s) : &lt;{@link Integer} (nom: niveau)&gt;.
	 * </p>
	 * <p>
	 * Ce signal est émit lors d'une demande de changement du niveau du personnage.
	 * </p>
	 */
	public Signal1<Integer> signalChangerNiveau = new Signal1<Integer>();

	/**
	 * <p>
	 * Ce signal prend 1 argument(s) générique(s) : &lt;{@link String} (nom: nom)&gt;.
	 * </p>
	 * <p>
	 * Ce signal est émit lors d'une demande de changement du nom du personnage.
	 * </p>
	 */
	public Signal1<String> signalChangerNomPersonnage = new Signal1<String>();

	/**
	 * <p>
	 * Ce signal prend 1 argument(s) générique(s) : &lt;{@link Character} (nom: sexe)&gt;.
	 * </p>
	 * <p>
	 * Ce signal est émit lors d'une demande de changement du sexe du personnage.
	 * </p>
	 */
	public Signal1<Character> signalChangerSexe = new Signal1<Character>();

	/**
	 * <p>
	 * Ce signal prend 2 argument(s) générique(s) : &lt;{@link String} (nom: clef), {@link Integer} (nom: valeur)&gt;.
	 * </p>
	 * <p>
	 * Ce signal est émit lors d'une demande de changement de la caractéristique {@code clef} du personnage.
	 * </p>
	 */
	public Signal2<String, Integer> signalChangerCaracteristiques = new Signal2<String, Integer>();

	/**
	 * <p>
	 * Ce signal prend 4 argument(s) générique(s) : &lt;{@link Integer} (nom: alignement), {@link Integer} (nom: specialisation), {@link Integer} (nom: niveauAlignement), {@link Integer} (nom: grade)&gt;.
	 * </p>
	 * <p>
	 * Ce signal est émit lors d'une demande de changement de l'alignement du personnage.
	 * </p>
	 */
	public Signal4<Integer, Integer, Integer, Integer> signalChangerAlignement = new Signal4<Integer, Integer, Integer, Integer>();

	/**
	 * <p>
	 * Ce signal prend 2 argument(s) générique(s) : &lt;{@link Boolean} (nom: maitrise), {@link Boolean} (nom: ccMaitrise)&gt;.
	 * </p>
	 * <p>
	 * Ce signal est émit lors d'une demande de simulation du corps à corps du personnage.
	 * </p>
	 */
	public Signal2<Boolean, Boolean> signalSimulerCaC = new Signal2<Boolean, Boolean>();

	/**
	 * <p>
	 * Ce signal prend 2 argument(s) générique(s) : &lt;{@link Sort} (nom: sort), {@link Integer} (nom: niveauSort)&gt;.
	 * </p>
	 * <p>
	 * Ce signal est émit lors d'une demande de simulation d'un sort du personnage.
	 * </p>
	 */
	public Signal2<Sort, Integer> signalSimulerSort = new Signal2<Sort, Integer>();

	/**
	 * <p>
	 * Ce signal prend 1 argument(s) générique(s) : &lt;{@link Effets} (nom: boost)&gt;.
	 * </p>
	 * <p>
	 * Ce signal est émit lors d'une demande de changement des boost de la simulation.
	 * </p>
	 */
	public Signal1<Effets> signalChangerBoost = new Signal1<Effets>();

	/**
	 * <p>
	 * Ce signal prend 1 argument(s) générique(s) : &lt;{@link Effets} (nom: resistances)&gt;.
	 * </p>
	 * <p>
	 * Ce signal est émit lors d'une demande de changement des résistances de la simulation.
	 * </p>
	 */
	public Signal1<Effets> signalChangerResistances = new Signal1<Effets>();

	/**
	 * <p>
	 * Ce signal prend aucun argument générique.
	 * </p>
	 * <p>
	 * Ce signal est émit lors d'une demande d'ouverture de la fenêtre de détails de la simulation.
	 * </p>
	 */
	public Signal0 signalOuvrirDetails = new Signal0();
	
	/**
	 * <p>
	 * Ce signal prend aucun argument générique.
	 * </p>
	 * <p>
	 * Ce signal est émit lors d'une demande d'ouverture de la fenêtre de des bones des panoplies.
	 * </p>
	 */
	public Signal0 signalOuvrirBonusPanoplies = new Signal0();
	
	/**
	 * <p>
	 * Ce signal prend aucun argument générique.
	 * </p>
	 * <p>
	 * Ce signal est émit lors d'une demande d'ouverture de la fenêtre d'exportation des données.
	 * </p>
	 */
	public Signal0 signalOuvrirExportation = new Signal0();

	/**
	 * <p>
	 * Ce signal prend aucun argument générique.
	 * </p>
	 * <p>
	 * Ce signal est émit lors d'une demande d'ouverture de la fenêtre de calcul des caractéristiques.
	 * </p>
	 */
	public Signal0 signalOuvrirCalcCaracteristiques = new Signal0();

	/**
	 * <p>
	 * Ce signal prend 1 argument(s) générique(s) : &lt;{@link Effets} (nom: resistances)&gt;.
	 * </p>
	 * <p>
	 * Ce signal est émit lors d'une selection d'un sort dans l'onglet de simulation.
	 * </p>
	 */
	public Signal1<Sort> signalSelectionnerSortSimulation = new Signal1<Sort>();

	/**
	 * <p>
	 * Ce signal prend 2 argument(s) générique(s) : &lt;{@link FlagsTypesEquipements} (nom: type), {@link SauvegardeEquipement} (nom: sauvegarde)&gt;.
	 * </p>
	 * <p>
	 * Ce signal est émit lors d'une demande d'équipement de l'équipement {@code sauvegarde}.
	 * </p>
	 */
	public Signal2<FlagsTypesEquipements, SauvegardeEquipement> signalEquiperEquipement = new Signal2<FlagsTypesEquipements, SauvegardeEquipement>();

	/**
	 * <p>
	 * Ce signal prend 2 argument(s) générique(s) : &lt;{@link FlagsTypesDofus} (nom: type), {@link SauvegardeDofus} (nom: sauvegarde)&gt;.
	 * </p>
	 * <p>
	 * Ce signal est émit lors d'une demande d'équipement du Dofus {@code sauvegarde}.
	 * </p>
	 */
	public Signal2<FlagsTypesDofus, SauvegardeDofus> signalEquiperDofus = new Signal2<FlagsTypesDofus, SauvegardeDofus>();

	/**
	 * <p>
	 * Ce signal prend 1 argument(s) générique(s) : &lt;{@link SauvegardeFamilier} (nom: sauvegarde)&gt;.
	 * </p>
	 * <p>
	 * Ce signal est émit lors d'une demande d'équipement du familier {@code sauvegarde}.
	 * </p>
	 */
	public Signal1<SauvegardeFamilier> signalEquiperFamilier = new Signal1<SauvegardeFamilier>();

	/**
	 * <p>
	 * Ce signal prend 1 argument(s) générique(s) : &lt;{@link SauvegardeMonture} (nom: sauvegarde)&gt;.
	 * </p>
	 * <p>
	 * Ce signal est émit lors d'une demande d'équipement de la monture {@code sauvegarde}.
	 * </p>
	 */
	public Signal1<SauvegardeMonture> signalEquiperMonture = new Signal1<SauvegardeMonture>();

	/**
	 * <p>
	 * Ce signal prend 1 argument(s) générique(s) : &lt;{@link SauvegardeArme} (nom: sauvegarde)&gt;.
	 * </p>
	 * <p>
	 * Ce signal est émit lors d'une demande d'équipement de l'arme {@code sauvegarde}.
	 * </p>
	 */
	public Signal1<SauvegardeArme> signalEquiperArme = new Signal1<SauvegardeArme>();

	/**
	 * <p>
	 * Ce signal prend 1 argument(s) générique(s) : &lt;{@link FlagsTypesEquipements} (nom: type)&gt;.
	 * </p>
	 * <p>
	 * Ce signal est émit lors d'une demande de retrait de l'équipement {@code type}.
	 * </p>
	 */
	public Signal1<FlagsTypesEquipements> signalRetirerEquipement = new Signal1<FlagsTypesEquipements>();

	/**
	 * <p>
	 * Ce signal prend 1 argument(s) générique(s) : &lt;{@link FlagsTypesDofus} (nom: type)&gt;.
	 * </p>
	 * <p>
	 * Ce signal est émit lors d'une demande de retrait du Dofus {@code type}.
	 * </p>
	 */
	public Signal1<FlagsTypesDofus> signalRetirerDofus = new Signal1<FlagsTypesDofus>();

	/**
	 * <p>
	 * Ce signal prend aucun argument générique.
	 * </p>
	 * <p>
	 * Ce signal est émit lors d'une demande de retrait de l'arme.
	 * </p>
	 */
	public Signal0 signalRetirerArme = new Signal0();

	/**
	 * <p>
	 * Ce signal prend aucun argument générique.
	 * </p>
	 * <p>
	 * Ce signal est émit lors d'une demande de retrait de l'animal.
	 * </p>
	 */
	public Signal0 signalRetirerAnimal = new Signal0();

	/*
	 * Constructeurs / Destructeur
	 */

	/**
	 * Construit une nouvelle fenêtre.
	 * 
	 * @category Constructeur
	 */
	public QWindowPrincipale()
	{
		// Initialisation de l'interface graphique
		this.ui = new UIPrincipale();
		this.ui.setupUi(this);
		this.setWindowTitle("JDofusCalc " + Main.getVersion());
		this.ui.grpVieSimulation.setVisible(false);
		this.referencesArmes = new HashMap<Integer, QStandardItem>();
		
		// Génération de la barre de chargement
		this.frameBarreProgression = new QFrame();
		this.frameBarreProgression.setSizePolicy(Policy.Fixed, Policy.Fixed);
		QHBoxLayout layout = new QHBoxLayout(this.frameBarreProgression);
		layout.setSpacing(5);
		layout.setContentsMargins(0, 0, 0, 0);
		this.frameBarreProgression.setVisible(false);
		this.barreProgression = new QProgressBar(this.frameBarreProgression);
		this.barreProgression.setMinimum(0);
		this.barreProgression.setMaximum(0);
		this.barreProgression.setMaximumSize(new QSize(100, 13));
		// Génération du label de la barre de chargement
		this.lblBarreProgression = new QLabel(this.frameBarreProgression);
		this.lblBarreProgression.setText("");
		layout.addWidget(this.lblBarreProgression);
		layout.addWidget(this.barreProgression);
		this.statusBar().addPermanentWidget(this.frameBarreProgression);

		this.tableauCorrespondances = new HashMap<FlagsTypesEffets, QLineEdit>();
		this.tableauCorrespondances.put(FlagsTypesEffets.Vie, this.ui.txtStatsVie);
		this.tableauCorrespondances.put(FlagsTypesEffets.Pa, this.ui.txtStatsPA);
		this.tableauCorrespondances.put(FlagsTypesEffets.Pm, this.ui.txtStatsPM);
		this.tableauCorrespondances.put(FlagsTypesEffets.Po, this.ui.txtStatsPO);
		this.tableauCorrespondances.put(FlagsTypesEffets.Initiative, this.ui.txtStatsIni);
		this.tableauCorrespondances.put(FlagsTypesEffets.Prospection, this.ui.txtStatsPP);
		this.tableauCorrespondances.put(FlagsTypesEffets.Vitalite, this.ui.txtStatsVita);
		this.tableauCorrespondances.put(FlagsTypesEffets.Sagesse, this.ui.txtStatsSag);
		this.tableauCorrespondances.put(FlagsTypesEffets.Force, this.ui.txtStatsForce);
		this.tableauCorrespondances.put(FlagsTypesEffets.Intelligence, this.ui.txtStatsInt);
		this.tableauCorrespondances.put(FlagsTypesEffets.Chance, this.ui.txtStatsChance);
		this.tableauCorrespondances.put(FlagsTypesEffets.Agilite, this.ui.txtStatsAgi);
		this.tableauCorrespondances.put(FlagsTypesEffets.EsquivePa, this.ui.txtStatsPResPA);
		this.tableauCorrespondances.put(FlagsTypesEffets.EsquivePm, this.ui.txtStatsPResPM);
		this.tableauCorrespondances.put(FlagsTypesEffets.Dommages, this.ui.txtStatsDom);
		this.tableauCorrespondances.put(FlagsTypesEffets.PourcentagesDommages, this.ui.txtStatsPDom);
		this.tableauCorrespondances.put(FlagsTypesEffets.DommagesPieges, this.ui.txtStatsDomPiege);
		this.tableauCorrespondances.put(FlagsTypesEffets.PourcentagesDommagesPieges, this.ui.txtStatsPDomPiege);
		this.tableauCorrespondances.put(FlagsTypesEffets.CreaturesInvocables, this.ui.txtStatsInvoc);
		this.tableauCorrespondances.put(FlagsTypesEffets.CoupsCritiques, this.ui.txtStatsCC);
		this.tableauCorrespondances.put(FlagsTypesEffets.EchecsCritiques, this.ui.txtStatsEC);
		this.tableauCorrespondances.put(FlagsTypesEffets.Renvois, this.ui.txtStatsRenvois);
		this.tableauCorrespondances.put(FlagsTypesEffets.Soins, this.ui.txtStatsSoin);
		this.tableauCorrespondances.put(FlagsTypesEffets.ResistancesMagiques, this.ui.txtStatsResMagique);
		this.tableauCorrespondances.put(FlagsTypesEffets.ResistancesPhysiques, this.ui.txtStatsResPhysique);
		this.tableauCorrespondances.put(FlagsTypesEffets.ResistancesNeutre, this.ui.txtStatsResNeutre);
		this.tableauCorrespondances.put(FlagsTypesEffets.ResistancesTerre, this.ui.txtStatsResTerre);
		this.tableauCorrespondances.put(FlagsTypesEffets.ResistancesFeu, this.ui.txtStatsResFeu);
		this.tableauCorrespondances.put(FlagsTypesEffets.ResistancesEau, this.ui.txtStatsResEau);
		this.tableauCorrespondances.put(FlagsTypesEffets.ResistancesAir, this.ui.txtStatsResAir);
		this.tableauCorrespondances.put(FlagsTypesEffets.PourcentagesResistancesNeutre, this.ui.txtStatsPResNeutre);
		this.tableauCorrespondances.put(FlagsTypesEffets.PourcentagesResistancesTerre, this.ui.txtStatsPResTerre);
		this.tableauCorrespondances.put(FlagsTypesEffets.PourcentagesResistancesFeu, this.ui.txtStatsPResFeu);
		this.tableauCorrespondances.put(FlagsTypesEffets.PourcentagesResistancesEau, this.ui.txtStatsPResEau);
		this.tableauCorrespondances.put(FlagsTypesEffets.PourcentagesResistancesAir, this.ui.txtStatsPResAir);

		/* Connexions signal->slot */
		// Menu
		this.ui.actionNouveauPersonnage.triggered.connect(this, "slotNouveauPerso()");
		this.ui.actionSauvegarder.triggered.connect(this, "slotSauvegardePerso()");
		this.ui.actionCharger.triggered.connect(this, "slotChargementSauvegardePerso()");
		this.ui.actionMaj.triggered.connect(this, "slotMAJ()");
		this.ui.actionApropos.triggered.connect(this, "slotOuvertureAPropos()");
		this.ui.actionCalcCC.triggered.connect(this, "slotOuvertureCalcCC()");
		this.ui.actionCalcCaract.triggered.connect(this, "slotOuvertureCalcCaract()");
		this.ui.actionCalcTacle.triggered.connect(this, "slotOuvertureCalcTacle()");
		this.ui.actionBonusPanoplies.triggered.connect(this, "slotOuvertureBonusPanoplies()");
		this.ui.actionExport.triggered.connect(this, "slotOuvertureExportation()");
		// Choix des modes
		this.ui.rbtnPvP.toggled.connect(this, "slotChangementMode()");
		this.ui.rbtnPvM.toggled.connect(this, "slotChangementMode()");
		// Sauvegardes
		this.ui.btnNouveauPerso.clicked.connect(this, "slotNouveauPerso()");
		this.ui.btnSauv.clicked.connect(this, "slotSauvegardePerso()");
		this.ui.btnCharger.clicked.connect(this, "slotChargementSauvegardePerso()");
		// Onglet "Personnage"
		// Changement de nom
		this.ui.txtNom.textChanged.connect(this, "slotChangementNomPersonnage()");
		// Changement de sexe
		this.ui.rbtnFemelle.clicked.connect(this, "slotChangementSexe()");
		this.ui.rbtnMale.clicked.connect(this, "slotChangementSexe()");
		// Changement de niveau
		this.ui.spinBoxNiveau.valueChanged.connect(this, "slotChangementNiveau(int)");
		// Changement caractéristiques
		this.ui.txtVita.textChanged.connect(this, "slotChangementVitalite()");
		this.ui.txtSag.textChanged.connect(this, "slotChangementSagesse()");
		this.ui.txtForce.textChanged.connect(this, "slotChangementForce()");
		this.ui.txtInt.textChanged.connect(this, "slotChangementIntelligence()");
		this.ui.txtChance.textChanged.connect(this, "slotChangementChance()");
		this.ui.txtAgi.textChanged.connect(this, "slotChangementAgilite()");
		// Changement alignement
		this.ui.grpAlign.toggled.connect(this, "slotChangementAli()");
		this.ui.spinBoxGrade.valueChanged.connect(this, "slotChangementAli()");
		this.ui.rbtnBonta.toggled.connect(this, "slotChangementAli()");
		this.ui.rbtnBrak.toggled.connect(this, "slotChangementAli()");
		this.ui.rbtnMerc.toggled.connect(this, "slotChangementAli()");
		this.ui.rbtnAucun.toggled.connect(this, "slotChangementAli()");
		this.ui.rbtnEspion.toggled.connect(this, "slotChangementAli()");
		this.ui.rbtnGuerrier.toggled.connect(this, "slotChangementAli()");
		this.ui.rbtnPretre.toggled.connect(this, "slotChangementAli()");
		this.ui.spinBoxLvlAli.valueChanged.connect(this, "slotChangementAli()");
		// Onglet "Sorts"
		// Maitrise
		this.ui.spinBoxMaitriseArc.valueChanged.connect(this, "slotChangementMaitriseArc(int)");
		this.ui.spinBoxMaitriseBaguette.valueChanged.connect(this, "slotChangementMaitriseBaguette(int)");
		this.ui.spinBoxMaitriseBaton.valueChanged.connect(this, "slotChangementMaitriseBaton(int)");
		this.ui.spinBoxMaitriseDague.valueChanged.connect(this, "slotChangementMaitriseDague(int)");
		this.ui.spinBoxMaitriseEpee.valueChanged.connect(this, "slotChangementMaitriseEpee(int)");
		this.ui.spinBoxMaitriseHache.valueChanged.connect(this, "slotChangementMaitriseHache(int)");
		this.ui.spinBoxMaitriseMarteau.valueChanged.connect(this, "slotChangementMaitriseMarteau(int)");
		this.ui.spinBoxMaitrisePelle.valueChanged.connect(this, "slotChangementMaitrisePelle(int)");
		this.ui.comboListeSorts.currentIndexChanged.connect(this, "slotSlectionSortSimulation(int)");
		this.ui.tableListeSorts.itemSelectionChanged.connect(this, "slotSelectionSort()");
		this.ui.tableListeSorts.pressed.connect(this, "slotSelectionSort()");
		// Onglet "Equipement"
		this.ui.btnNouveauGroupe.clicked.connect(this, "slotNouveauGroupe()");
		this.ui.btnSaubegarderGroupe.clicked.connect(this, "slotSauvegardeGroupe()");
		this.ui.btnChargerGroupe.clicked.connect(this, "slotChargementGroupe()");
		this.ui.tableauObjets.signalGererEquipement.connect(this, "slotGererEquipement(org.JDofusCalc.dofus.objets.Equipement$FlagsTypesEquipements)");
		this.ui.tableauObjets.signalGererDofus.connect(this, "slotGererDofus(org.JDofusCalc.dofus.objets.Dofus$FlagsTypesDofus)");
		this.ui.tableauObjets.signalGererArmes.connect(this, "slotGererArmes(org.JDofusCalc.dofus.objets.Arme$FlagsTypesArmes)");
		this.ui.tableauObjets.signalGererFamiliers.connect(this, "slotGererFamiliers()");
		this.ui.tableauObjets.signalGererMontures.connect(this, "slotGererMontures()");
		this.ui.tableauObjets.signalEquiperFamilier.connect(this, "slotEquipeFamilier(SauvegardeFamilier)");
		this.ui.tableauObjets.signalEquiperMonture.connect(this, "slotEquipeMonture(SauvegardeMonture)");
		this.ui.tableauObjets.signalEquiperArme.connect(this, "slotEquipeArme(SauvegardeArme)");
		this.ui.tableauObjets.signalEquiperEquipement.connect(this, "slotEquipeEquipement(org.JDofusCalc.dofus.objets.Equipement$FlagsTypesEquipements, SauvegardeEquipement)");
		this.ui.tableauObjets.signalEquiperDofus.connect(this, "slotEquipeDofus(org.JDofusCalc.dofus.objets.Dofus$FlagsTypesDofus, SauvegardeDofus)");
		this.ui.tableauObjets.signalRetirerArme.connect(this, "slotRetireArme()");
		this.ui.tableauObjets.signalRetirerAnimal.connect(this, "slotRetireAnimal()");
		this.ui.tableauObjets.signalRetirerEquipement.connect(this, "slotRetireEquipement(org.JDofusCalc.dofus.objets.Equipement$FlagsTypesEquipements)");
		this.ui.tableauObjets.signalRetirerDofus.connect(this, "slotRetireDofus(org.JDofusCalc.dofus.objets.Dofus$FlagsTypesDofus)");
		// Onglet "Simulation"
		this.ui.rbtnSimuCaC.toggled.connect(this, "slotChangementSimulation()");
		this.ui.rbtnSimuSorts.toggled.connect(this, "slotChangementSimulation()");
		this.ui.cmbSimuCaC.currentIndexChanged.connect(this, "slotChangementArmeSimulation(int)");
		this.ui.spinBoxNiveauSort.valueChanged.connect(this, "slotChangementSimulation()");
		this.ui.btnDetailsSimu.clicked.connect(this, "slotOuvertureDetails()");
		this.ui.cboxMaitrise.toggled.connect(this, "slotChangementSimulation()");
		this.ui.cboxCCMaitrise.toggled.connect(this, "slotChangementSimulation()");
		// Boost
		this.ui.grpBoost.toggled.connect(this, "slotChangementBoost()");
		this.ui.spinBoxBoostAgi.valueChanged.connect(this, "slotChangementBoost()");
		this.ui.spinBoxBoostCC.valueChanged.connect(this, "slotChangementBoost()");
		this.ui.spinBoxBoostChance.valueChanged.connect(this, "slotChangementBoost()");
		this.ui.spinBoxBoostDom.valueChanged.connect(this, "slotChangementBoost()");
		this.ui.spinBoxBoostForce.valueChanged.connect(this, "slotChangementBoost()");
		this.ui.spinBoxBoostInt.valueChanged.connect(this, "slotChangementBoost()");
		this.ui.spinBoxBoostPDom.valueChanged.connect(this, "slotChangementBoost()");
		this.ui.spinBoxBoostPP.valueChanged.connect(this, "slotChangementBoost()");
		this.ui.spinBoxBoostPA.valueChanged.connect(this, "slotChangementBoost()");
		this.ui.spinBoxBoostSoins.valueChanged.connect(this, "slotChangementBoost()");
		this.ui.spinBoxBoostSag.valueChanged.connect(this, "slotChangementBoost()");
		this.ui.spinBoxBoostDomPhy.valueChanged.connect(this, "slotChangementBoost()");
		this.ui.sbVieSimulation.valueChanged.connect(this, "slotChangementVieActuelle()");
		// Resistance
		this.ui.grpResistances.toggled.connect(this, "slotChangementResistances()");
		this.ui.spinBoxBoostResMagique.valueChanged.connect(this, "slotChangementResistances()");
		this.ui.spinBoxBoostResPhysique.valueChanged.connect(this, "slotChangementResistances()");
		this.ui.spinBoxBoostResNeutre.valueChanged.connect(this, "slotChangementResistances()");
		this.ui.spinBoxBoostResTerre.valueChanged.connect(this, "slotChangementResistances()");
		this.ui.spinBoxBoostResFeu.valueChanged.connect(this, "slotChangementResistances()");
		this.ui.spinBoxBoostResEau.valueChanged.connect(this, "slotChangementResistances()");
		this.ui.spinBoxBoostResAir.valueChanged.connect(this, "slotChangementResistances()");
		this.ui.spinBoxBoostPResNeutre.valueChanged.connect(this, "slotChangementResistances()");
		this.ui.spinBoxBoostPResTerre.valueChanged.connect(this, "slotChangementResistances()");
		this.ui.spinBoxBoostPResFeu.valueChanged.connect(this, "slotChangementResistances()");
		this.ui.spinBoxBoostPResEau.valueChanged.connect(this, "slotChangementResistances()");
		this.ui.spinBoxBoostPResAir.valueChanged.connect(this, "slotChangementResistances()");
	}

	/*
	 * Méthodes d'affichage des données de la fenêtre
	 */

	/**
	 * Affiche la barre de progression dans la barre de statut avec un message.
	 * 
	 * @param message - Message à affichier à côté de la barre de progression.
	 */
	public void afficherBarreProgression(String message)
	{
		Thread thread = new Thread(new InvokeAfficherBarreProgression(message));
		thread.setDaemon(true);
		thread.start();
	}

	/**
	 * Classe tampon d'affichage de la barre de progression.
	 * 
	 * @author PAPAYA Alexandre
	 * @category Invoke
	 * @version 1.0
	 */
	private class InvokeAfficherBarreProgression implements Runnable
	{
		/*
		 * Variables d'instances
		 */

		/**
		 * Le message à afficher.
		 */
		private String message;

		/*
		 * Constructeurs / Destructeur
		 */

		/**
		 * Construit une nouvelle Invoke.
		 * 
		 * @param message - Message à afficher.
		 * @category Constructeur
		 */
		private InvokeAfficherBarreProgression(String message)
		{
			this.message = message;
		}

		public void run()
		{
			QApplication.invokeLater(new Runnable()
			{
				public void run()
				{
					QWindowPrincipale.this.frameBarreProgression.setVisible(true);
					QWindowPrincipale.this.lblBarreProgression.setText(InvokeAfficherBarreProgression.this.message);
					QWindowPrincipale.this.barreProgression.setVisible(true);
				}
			});
		}
	}

	/**
	 * Cache la barre de progression de la barre de statut.
	 */
	public void cacherBarreProgression()
	{
		Thread thread = new Thread(new InvokeCacherBarreProgression());
		thread.setDaemon(true);
		thread.start();
	}

	/**
	 * Classe tampon qui cache de la barre de progression.
	 * 
	 * @author PAPAYA Alexandre
	 * @category Invoke
	 * @version 1.0
	 */
	private class InvokeCacherBarreProgression implements Runnable
	{
		public void run()
		{
			QApplication.invokeLater(new Runnable()
			{
				public void run()
				{
					QWindowPrincipale.this.frameBarreProgression.setVisible(false);
					QWindowPrincipale.this.lblBarreProgression.setText("");
				}
			});
		}
	}

	/**
	 * Définit la classe du personnage.
	 * 
	 * @param classe - Classe du personnage.
	 */
	public void setClasse(Classe classe)
	{
		this.blockSignals(true);
		
		// Change le combo
		this.ui.comboClasse.setCurrentIndex(this.ui.comboClasse.findText(classe.getNom()));
		
		// Change la description
		this.ui.txtDescriptionClasse.setText(classe.getDescription());

		// Change l'avatar
		if(this.ui.rbtnMale.isChecked())
		{
			this.ui.lblAvatar.setPixmap(new QPixmap("classpath:org/JDofusCalc/ressources/images/avatars/avatar_" + classe.getAvatar() + "_m.png"));
		}
		else
		{
			this.ui.lblAvatar.setPixmap(new QPixmap("classpath:org/JDofusCalc/ressources/images/avatars/avatar_" + classe.getAvatar() + "_f.png"));
		}
		
		this.blockSignals(false);
	}
	
	/**
	 * Définit le sexe du personnage.
	 * 
	 * @param sexe - Sexe du personnage.
	 */
	public void setSexe(char sexe, Classe classe)
	{
		this.blockSignals(true);
		
		if(sexe == 'm')
		{
			this.ui.rbtnMale.setChecked(true);
			this.ui.lblAvatar.setPixmap(new QPixmap("classpath:org/JDofusCalc/ressources/images/avatars/avatar_" + classe.getAvatar() + "_m.png"));
		}
		else
		{
			this.ui.rbtnFemelle.setChecked(true);
			this.ui.lblAvatar.setPixmap(new QPixmap("classpath:org/JDofusCalc/ressources/images/avatars/avatar_" + classe.getAvatar() + "_f.png"));
		}
		
		this.blockSignals(false);
	}

	/**
	 * Définit le sort à afficher dans l'onglet "Sorts".
	 * 
	 * @param sort - Le sort à afficher.
	 * @param niveau - Le niveau du sort à afficher.
	 */
	public void setSort(Sort sort, int niveau)
	{
		if(sort != null)
		{
			if(sort.getNature() != NatureSortsFlags.Punition)
			{
				Degats degats = (Degats) sort.get(niveau, "Degats");
	
				this.ui.txtDegatsNeutreMinSorts.setText(String.valueOf(degats.get(FlagsTypesDegats.DegatsNeutreMin) + degats.get(FlagsTypesDegats.VoleNeutreMin)));
				this.ui.txtDegatsNeutreMaxSorts.setText(String.valueOf(degats.get(FlagsTypesDegats.DegatsNeutreMax) + degats.get(FlagsTypesDegats.VoleNeutreMax)));
				this.ui.txtDegatsTerreMinSorts.setText(String.valueOf(degats.get(FlagsTypesDegats.DegatsTerreMin) + degats.get(FlagsTypesDegats.VoleTerreMin)));
				this.ui.txtDegatsTerreMaxSorts.setText(String.valueOf(degats.get(FlagsTypesDegats.DegatsTerreMax) + degats.get(FlagsTypesDegats.VoleTerreMax)));
				this.ui.txtDegatsFeuMinSorts.setText(String.valueOf(degats.get(FlagsTypesDegats.DegatsFeuMin) + degats.get(FlagsTypesDegats.VoleFeuMin)));
				this.ui.txtDegatsFeuMaxSorts.setText(String.valueOf(degats.get(FlagsTypesDegats.DegatsFeuMax) + degats.get(FlagsTypesDegats.VoleFeuMax)));
				this.ui.txtDegatsEauMinSorts.setText(String.valueOf(degats.get(FlagsTypesDegats.DegatsEauMin) + degats.get(FlagsTypesDegats.VoleEauMin)));
				this.ui.txtDegatsEauMaxSorts.setText(String.valueOf(degats.get(FlagsTypesDegats.DegatsEauMax) + degats.get(FlagsTypesDegats.VoleEauMax)));
				this.ui.txtDegatsAirMinSorts.setText(String.valueOf(degats.get(FlagsTypesDegats.DegatsAirMin) + degats.get(FlagsTypesDegats.VoleAirMin)));
				this.ui.txtDegatsAirMaxSorts.setText(String.valueOf(degats.get(FlagsTypesDegats.DegatsAirMax) + degats.get(FlagsTypesDegats.VoleAirMax)));
				this.ui.txtSoinsMinSorts.setText(String.valueOf(degats.get(FlagsTypesDegats.SoinsMin)));
				this.ui.txtSoinsMaxSorts.setText(String.valueOf(degats.get(FlagsTypesDegats.SoinsMax)));
	
				Degats degatsCC = (Degats) sort.get(niveau, "DegatsCC");
	
				if(degatsCC != null)
				{
					this.ui.txtDegatsNeutreCCMinSorts.setText(String.valueOf(degatsCC.get(FlagsTypesDegats.DegatsNeutreMin) + degatsCC.get(FlagsTypesDegats.VoleNeutreMin)));
					this.ui.txtDegatsNeutreCCMaxSorts.setText(String.valueOf(degatsCC.get(FlagsTypesDegats.DegatsNeutreMax) + degatsCC.get(FlagsTypesDegats.VoleNeutreMax)));
					this.ui.txtDegatsTerreCCMinSorts.setText(String.valueOf(degatsCC.get(FlagsTypesDegats.DegatsTerreMin) + degatsCC.get(FlagsTypesDegats.VoleTerreMin)));
					this.ui.txtDegatsTerreCCMaxSorts.setText(String.valueOf(degatsCC.get(FlagsTypesDegats.DegatsTerreMax) + degatsCC.get(FlagsTypesDegats.VoleTerreMax)));
					this.ui.txtDegatsFeuCCMinSorts.setText(String.valueOf(degatsCC.get(FlagsTypesDegats.DegatsFeuMin) + degatsCC.get(FlagsTypesDegats.VoleFeuMin)));
					this.ui.txtDegatsFeuCCMaxSorts.setText(String.valueOf(degatsCC.get(FlagsTypesDegats.DegatsFeuMax) + degatsCC.get(FlagsTypesDegats.VoleFeuMax)));
					this.ui.txtDegatsEauCCMinSorts.setText(String.valueOf(degatsCC.get(FlagsTypesDegats.DegatsEauMin) + degatsCC.get(FlagsTypesDegats.VoleEauMin)));
					this.ui.txtDegatsEauCCMaxSorts.setText(String.valueOf(degatsCC.get(FlagsTypesDegats.DegatsEauMax) + degatsCC.get(FlagsTypesDegats.VoleEauMax)));
					this.ui.txtDegatsAirCCMinSorts.setText(String.valueOf(degatsCC.get(FlagsTypesDegats.DegatsAirMin) + degatsCC.get(FlagsTypesDegats.VoleAirMin)));
					this.ui.txtDegatsAirCCMaxSorts.setText(String.valueOf(degatsCC.get(FlagsTypesDegats.DegatsAirMax) + degatsCC.get(FlagsTypesDegats.VoleAirMax)));
					this.ui.txtSoinsCCMinSorts.setText(String.valueOf(degatsCC.get(FlagsTypesDegats.SoinsMin)));
					this.ui.txtSoinsCCMaxSorts.setText(String.valueOf(degatsCC.get(FlagsTypesDegats.SoinsMax)));
				}
				else
				{
					this.ui.txtDegatsNeutreCCMinSorts.setText("-");
					this.ui.txtDegatsNeutreCCMaxSorts.setText("-");
					this.ui.txtDegatsTerreCCMinSorts.setText("-");
					this.ui.txtDegatsTerreCCMaxSorts.setText("-");
					this.ui.txtDegatsFeuCCMinSorts.setText("-");
					this.ui.txtDegatsFeuCCMaxSorts.setText("-");
					this.ui.txtDegatsEauCCMinSorts.setText("-");
					this.ui.txtDegatsEauCCMaxSorts.setText("-");
					this.ui.txtDegatsAirCCMinSorts.setText("-");
					this.ui.txtDegatsAirCCMaxSorts.setText("-");
					this.ui.txtSoinsCCMinSorts.setText("-");
					this.ui.txtSoinsCCMaxSorts.setText("-");
				}
			}
			else
			{
				this.ui.txtDegatsNeutreMinSorts.setText(TauxPunition.CoupNormal.getValeur() + "%");
				this.ui.txtDegatsNeutreMaxSorts.setText("");
				this.ui.txtDegatsTerreMinSorts.setText("");
				this.ui.txtDegatsTerreMaxSorts.setText("");
				this.ui.txtDegatsFeuMinSorts.setText("");
				this.ui.txtDegatsFeuMaxSorts.setText("");
				this.ui.txtDegatsEauMinSorts.setText("");
				this.ui.txtDegatsEauMaxSorts.setText("");
				this.ui.txtDegatsAirMinSorts.setText("");
				this.ui.txtDegatsAirMaxSorts.setText("");
				this.ui.txtSoinsMinSorts.setText("");
				this.ui.txtSoinsMaxSorts.setText("");

				this.ui.txtDegatsNeutreCCMinSorts.setText(TauxPunition.CoupCritique.getValeur() + "%");
				this.ui.txtDegatsNeutreCCMaxSorts.setText("");
				this.ui.txtDegatsTerreCCMinSorts.setText("");
				this.ui.txtDegatsTerreCCMaxSorts.setText("");
				this.ui.txtDegatsFeuCCMinSorts.setText("");
				this.ui.txtDegatsFeuCCMaxSorts.setText("");
				this.ui.txtDegatsEauCCMinSorts.setText("");
				this.ui.txtDegatsEauCCMaxSorts.setText("");
				this.ui.txtDegatsAirCCMinSorts.setText("");
				this.ui.txtDegatsAirCCMaxSorts.setText("");
				this.ui.txtSoinsCCMinSorts.setText("");
				this.ui.txtSoinsCCMaxSorts.setText("");
			}

			this.ui.txtPASorts.setText(String.valueOf(sort.get(niveau, "PA")));
			String cc = String.valueOf(sort.get(niveau, "CC"));
			if(!cc.equals("0"))
			{
				this.ui.txtCoupCritiqueCCSorts.setText("1/" + cc);
			}
			else
			{
				this.ui.txtCoupCritiqueCCSorts.setText("-");
			}

			String ec = String.valueOf(sort.get(niveau, "EC"));
			if(!ec.equals("0"))
			{
				this.ui.txtEchecECSorts.setText("1/" + ec);
			}
			else
			{
				this.ui.txtEchecECSorts.setText("-");
			}

			this.ui.lblNomNiveauSort.setText(sort.getNom() + " (Niveau " + niveau + ")");
			this.ui.lblAutresEffets.setText("");
		}
	}

	/**
	 * Définit la sauvegarde du personnage à charger dans la fenêtre.
	 * 
	 * @param sauvegarde - Sauvegarde du personnage.
	 */
	public void setSauvegardePersonnage(SauvegardePersonnage sauvegarde)
	{
		this.blockSignals(true);

		this.ui.txtNom.setText(sauvegarde.getNomPerso());
		this.ui.spinBoxNiveau.setValue(sauvegarde.getNiveau());

		this.ui.txtVita.setText(String.valueOf(sauvegarde.getVitalite()));
		this.ui.txtSag.setText(String.valueOf(sauvegarde.getSagesse()));
		this.ui.txtForce.setText(String.valueOf(sauvegarde.getForce()));
		this.ui.txtInt.setText(String.valueOf(sauvegarde.getIntelligence()));
		this.ui.txtChance.setText(String.valueOf(sauvegarde.getChance()));
		this.ui.txtAgi.setText(String.valueOf(sauvegarde.getAgilite()));
		if(sauvegarde.getAlignement() != 0)
		{
			this.ui.grpAlign.setChecked(true);
			if(sauvegarde.getAlignement() == 1)
			{
				this.ui.rbtnBonta.setChecked(true);
				this.ui.spinBoxGrade.setValue(sauvegarde.getGrade());
			}
			else if(sauvegarde.getAlignement() == 2)
			{
				this.ui.rbtnBrak.setChecked(true);
				this.ui.spinBoxGrade.setValue(sauvegarde.getGrade());
			}
			else
			{
				this.ui.rbtnMerc.setChecked(true);
			}

			if(sauvegarde.getSpecialisationAlignement() == 0)
			{
				this.ui.rbtnAucun.setChecked(true);
			}
			else if(sauvegarde.getSpecialisationAlignement() == 1)
			{
				this.ui.rbtnEspion.setChecked(true);
			}
			else if(sauvegarde.getSpecialisationAlignement() == 2)
			{
				this.ui.rbtnGuerrier.setChecked(true);
			}
			else
			{
				this.ui.rbtnPretre.setChecked(true);
			}
			this.ui.spinBoxLvlAli.setValue(sauvegarde.getNiveauAlignement());
		}
		else
		{
			this.ui.grpAlign.setChecked(false);
		}

		this.ui.spinBoxMaitriseArc.setValue(sauvegarde.getMaitrise(FlagsTypesArmes.Arc));
		this.ui.spinBoxMaitriseBaguette.setValue(sauvegarde.getMaitrise(FlagsTypesArmes.Baguette));
		this.ui.spinBoxMaitriseBaton.setValue(sauvegarde.getMaitrise(FlagsTypesArmes.Baton));
		this.ui.spinBoxMaitriseDague.setValue(sauvegarde.getMaitrise(FlagsTypesArmes.Dague));
		this.ui.spinBoxMaitriseEpee.setValue(sauvegarde.getMaitrise(FlagsTypesArmes.Epee));
		this.ui.spinBoxMaitriseHache.setValue(sauvegarde.getMaitrise(FlagsTypesArmes.Hache));
		this.ui.spinBoxMaitriseMarteau.setValue(sauvegarde.getMaitrise(FlagsTypesArmes.Marteau));
		this.ui.spinBoxMaitrisePelle.setValue(sauvegarde.getMaitrise(FlagsTypesArmes.Pelle));

		this.blockSignals(false);
	}

	/**
	 * Définit la statistique {@code clef} à afficher dans la fenêtre.
	 * 
	 * @param effet - Effet à afficher.
	 * @param valeur - Valeur de la statistique.
	 */
	public void setStatistique(FlagsTypesEffets effet, int valeur)
	{
		QLineEdit txt = this.tableauCorrespondances.get(effet);
		// Si la clef correspond à un champ txt
		if(txt != null)
		{
			txt.setText(String.valueOf(valeur));
		}
	}

	/**
	 * Définit les données de la simulation à afficher dans la fenêtre.
	 * 
	 * @param donnees - Données de la simulation.
	 */
	public void setDonneesSimulation(HashMap<String, String> donnees)
	{
		// Si les données de la simulation indiquent que le sort Punition est simulé
		if(donnees.get("Nom Sort") != null && donnees.get("Nom Sort").equals("Punition"))
			this.ui.grpVieSimulation.setVisible(true);
		else
			this.ui.grpVieSimulation.setVisible(false);
			
		this.ui.txtDegatsNeutreMin.setText(donnees.get("Neutre Minimum"));
		this.ui.txtDegatsNeutreMax.setText(donnees.get("Neutre Maximum"));
		this.ui.txtDegatsTerreMin.setText(donnees.get("Terre Minimum"));
		this.ui.txtDegatsTerreMax.setText(donnees.get("Terre Maximum"));
		this.ui.txtDegatsFeuMin.setText(donnees.get("Feu Minimum"));
		this.ui.txtDegatsFeuMax.setText(donnees.get("Feu Maximum"));
		this.ui.txtDegatsEauMin.setText(donnees.get("Eau Minimum"));
		this.ui.txtDegatsEauMax.setText(donnees.get("Eau Maximum"));
		this.ui.txtDegatsAirMin.setText(donnees.get("Air Minimum"));
		this.ui.txtDegatsAirMax.setText(donnees.get("Air Maximum"));
		this.ui.txtDegatsVdVMin.setText(donnees.get("Vole Minimum"));
		this.ui.txtDegatsVdVMax.setText(donnees.get("Vole Maximum"));
		this.ui.txtSoinsMin.setText(donnees.get("Soins Minimum"));
		this.ui.txtSoinsMax.setText(donnees.get("Soins Maximum"));

		this.ui.txtDegatsNeutreCCMin.setText(donnees.get("Neutre Minimum CC"));
		this.ui.txtDegatsNeutreCCMax.setText(donnees.get("Neutre Maximum CC"));
		this.ui.txtDegatsTerreCCMin.setText(donnees.get("Terre Minimum CC"));
		this.ui.txtDegatsTerreCCMax.setText(donnees.get("Terre Maximum CC"));
		this.ui.txtDegatsFeuCCMin.setText(donnees.get("Feu Minimum CC"));
		this.ui.txtDegatsFeuCCMax.setText(donnees.get("Feu Maximum CC"));
		this.ui.txtDegatsEauCCMin.setText(donnees.get("Eau Minimum CC"));
		this.ui.txtDegatsEauCCMax.setText(donnees.get("Eau Maximum CC"));
		this.ui.txtDegatsAirCCMin.setText(donnees.get("Air Minimum CC"));
		this.ui.txtDegatsAirCCMax.setText(donnees.get("Air Maximum CC"));
		this.ui.txtDegatsVdVCCMin.setText(donnees.get("Vole Minimum CC"));
		this.ui.txtDegatsVdVCCMax.setText(donnees.get("Vole Maximum CC"));
		this.ui.txtSoinsCCMin.setText(donnees.get("Soins Minimum CC"));
		this.ui.txtSoinsCCMax.setText(donnees.get("Soins Maximum CC"));

		this.ui.txtPA.setText(donnees.get("PA"));
		this.ui.txtCoupCritiqueCC.setText(donnees.get("CC"));
		this.ui.txtCoupCritiqueDeg.setText(donnees.get("Dégats CC"));
		this.ui.txtEchecEC.setText(donnees.get("EC"));
	}

	/**
	 * Définit la liste des sorts du personnage avec leurs niveaux.
	 * 
	 * @param sorts - Liste des sorts.
	 * @param niveaux - Liste des niveaux des sorts.
	 */
	public void setListeSorts(ArrayList<Sort> sorts, HashMap<String, Integer> niveaux)
	{
		// Combo
		this.ui.comboListeSorts.clear();
		this.ui.comboListeSorts.addItem("<Choisissez un sort>");

		// Table
		this.ui.tableListeSorts.clearContents();
		this.ui.tableListeSorts.setRowCount(sorts.size());
		this.ui.tableListeSorts.setColumnWidth(0, 200);
		this.ui.tableListeSorts.blockSignals(true);

		for(int i = 0; i < sorts.size(); i++)
		{
			// Ajoute l'item dans le combo
			this.ui.comboListeSorts.addItem(sorts.get(i).getNom());
			// Enregistre les données de la classe
			this.ui.comboListeSorts.setItemData((i + 1), sorts.get(i));

			int niveau;
			if(niveaux.get(sorts.get(i).getNom()) == null)
			{
				niveau = 1;
			}
			else
			{
				niveau = niveaux.get(sorts.get(i).getNom());
			}
			
			QTableWidgetItem itemNom = new QTableWidgetItem(sorts.get(i).getNom());
			itemNom.setFlags(Qt.ItemFlag.NoItemFlags);
			
			QSpinBox sbNiveau = new QSpinBox();
			sbNiveau.blockSignals(true);
			this.ui.tableListeSorts.setCellWidget(i, 1, sbNiveau);
			
			sbNiveau.setProperty("index", i);
			sbNiveau.setRange(1, 6);
			sbNiveau.setValue(niveau);
			sbNiveau.setAlignment(AlignmentFlag.AlignCenter);
			sbNiveau.setButtonSymbols(ButtonSymbols.PlusMinus);
			sbNiveau.valueChanged.connect(this, "slotChangementNiveauSort(int)");
			
			this.ui.tableListeSorts.setRowHeight(i, 20);
			this.ui.tableListeSorts.setItem(i, 0, itemNom);
			sbNiveau.blockSignals(false);
		}
		
		this.ui.tableListeSorts.blockSignals(false);
	}

	/**
	 * Définit la liste des classes.
	 * 
	 * @param classes - La liste des classes.
	 */
	public void setListeClasses(HashMap<Integer, Classe> classes)
	{
		// Vide le combo
		this.ui.comboClasse.clear();
		this.ui.comboClasse.blockSignals(true);

		int i = 0;
		for(Entry<Integer, Classe> entry : classes.entrySet())
		{
			Classe classe = entry.getValue();
			// Ajoute l'item dans le combo
			this.ui.comboClasse.addItem(classe.getNom());
			// Enregistre les données de la panoplie
			this.ui.comboClasse.setItemData(i, classe);

			i++;
		}

		// Connexion Signal/Slot
		this.ui.comboClasse.blockSignals(false);
		this.ui.comboClasse.currentIndexChanged.connect(this, "slotChangementClasse()");
	}

	/**
	 * Vide totalement la fenêtre de ses données perssonage.
	 */
	public void vider()
	{
		this.ui.txtNom.setText("");
		this.ui.spinBoxNiveau.setValue(1);
		this.ui.txtVita.setText("0");
		this.ui.txtSag.setText("0");
		this.ui.txtForce.setText("0");
		this.ui.txtInt.setText("0");
		this.ui.txtChance.setText("0");
		this.ui.txtAgi.setText("0");
		this.ui.spinBoxGrade.setValue(1);
		this.ui.spinBoxLvlAli.setValue(1);
		this.ui.rbtnAucun.setChecked(true);
		this.ui.rbtnBonta.setChecked(true);
		this.ui.grpAlign.setChecked(false);
		this.ui.rbtnMale.setChecked(true);
		this.ui.comboClasse.setCurrentIndex(0);
		this.ui.tableauObjets.retirerTout();
		this.ui.spinBoxMaitriseArc.setValue(0);
		this.ui.spinBoxMaitriseBaguette.setValue(0);
		this.ui.spinBoxMaitriseBaton.setValue(0);
		this.ui.spinBoxMaitriseDague.setValue(0);
		this.ui.spinBoxMaitriseEpee.setValue(0);
		this.ui.spinBoxMaitriseHache.setValue(0);
		this.ui.spinBoxMaitriseMarteau.setValue(0);
		this.ui.spinBoxMaitrisePelle.setValue(0);
		this.ui.spinBoxBoostAgi.setValue(0);
		this.ui.spinBoxBoostCC.setValue(0);
		this.ui.spinBoxBoostChance.setValue(0);
		this.ui.spinBoxBoostDom.setValue(0);
		this.ui.spinBoxBoostForce.setValue(0);
		this.ui.spinBoxBoostInt.setValue(0);
		this.ui.spinBoxBoostPA.setValue(0);
		this.ui.spinBoxBoostPDom.setValue(0);
		this.ui.spinBoxBoostPP.setValue(0);
		this.ui.spinBoxBoostPResAir.setValue(0);
		this.ui.spinBoxBoostPResEau.setValue(0);
		this.ui.spinBoxBoostPResFeu.setValue(0);
		this.ui.spinBoxBoostPResNeutre.setValue(0);
		this.ui.spinBoxBoostPResTerre.setValue(0);
		this.ui.spinBoxBoostResAir.setValue(0);
		this.ui.spinBoxBoostResEau.setValue(0);
		this.ui.spinBoxBoostResFeu.setValue(0);
		this.ui.spinBoxBoostResNeutre.setValue(0);
		this.ui.spinBoxBoostResTerre.setValue(0);
		this.ui.spinBoxBoostSag.setValue(0);
		this.ui.spinBoxBoostSoins.setValue(0);
		this.ui.grpBoost.setChecked(false);
		this.ui.grpResistances.setChecked(false);
	}
	
	/**
	 * Efface les données de la zone de simulation.
	 */
	public void effacerDonneesSimulation()
	{
		this.ui.btnDetailsSimu.setEnabled(false);
		this.ui.spinBoxNiveauSort.setEnabled(false);
		this.ui.txtDegatsNeutreMin.setText("");
		this.ui.txtDegatsNeutreMax.setText("");
		this.ui.txtDegatsTerreMin.setText("");
		this.ui.txtDegatsTerreMax.setText("");
		this.ui.txtDegatsFeuMin.setText("");
		this.ui.txtDegatsFeuMax.setText("");
		this.ui.txtDegatsEauMin.setText("");
		this.ui.txtDegatsEauMax.setText("");
		this.ui.txtDegatsAirMin.setText("");
		this.ui.txtDegatsAirMax.setText("");
		this.ui.txtSoinsMin.setText("");
		this.ui.txtSoinsMax.setText("");
		this.ui.txtDegatsVdVMin.setText("");
		this.ui.txtDegatsVdVMax.setText("");
		this.ui.txtDegatsNeutreCCMin.setText("");
		this.ui.txtDegatsNeutreCCMax.setText("");
		this.ui.txtDegatsTerreCCMin.setText("");
		this.ui.txtDegatsTerreCCMax.setText("");
		this.ui.txtDegatsFeuCCMin.setText("");
		this.ui.txtDegatsFeuCCMax.setText("");
		this.ui.txtDegatsEauCCMin.setText("");
		this.ui.txtDegatsEauCCMax.setText("");
		this.ui.txtDegatsAirCCMin.setText("");
		this.ui.txtDegatsAirCCMax.setText("");
		this.ui.txtSoinsCCMin.setText("");
		this.ui.txtSoinsCCMax.setText("");
		this.ui.txtDegatsVdVCCMin.setText("");
		this.ui.txtDegatsVdVCCMax.setText("");
		this.ui.txtCoupCritiqueCC.setText("");
		this.ui.txtCoupCritiqueDeg.setText("");
		this.ui.txtEchecEC.setText("");
		this.ui.txtPA.setText("");
	}
	
	/**
	 * Définit le niveau du sort sélectionné dans l'onglet "simulation".
	 * 
	 * @param niveau - Niveau du sort.
	 */
	public void setNiveauSortSimulation(int niveau)
	{
		this.ui.spinBoxNiveauSort.setValue(niveau);
	}
	
	/**
	 * Définit la liste des sauvegardes des Ares.
	 * 
	 * @param typeArme - Type des armes.
	 * @param sauvegardes - Liste des sauvegardes des armes.
	 */
	public void setListeSauvegardesArmes(HashMap<FlagsTypesArmes, ArrayList<SauvegardeArme>> sauvegardes)
	{
		this.ui.cmbSimuCaC.blockSignals(true);
		
		this.ui.cmbSimuCaC.clear();
		
		QStandardItemModel model = new QStandardItemModel();
		model.setItem(0, new QStandardItem("Corps à corps"));
		
		int i = 1;
		for(Entry<FlagsTypesArmes, ArrayList<SauvegardeArme>> entry : sauvegardes.entrySet())
		{
			FlagsTypesArmes flag = entry.getKey();
			ArrayList<SauvegardeArme> sauvegardesParFlag = entry.getValue();
			
			QStandardItem itemTitre = new QStandardItem();
			itemTitre.setText("-- " + flag.getNom());
			itemTitre.setEnabled(false);
			model.setItem(i, itemTitre);
			
			for(int y = 0; y < sauvegardesParFlag.size(); y++)
			{
				i++;
				
				SauvegardeArme sauvegarde = sauvegardesParFlag.get(y);
				QStandardItem item = new QStandardItem();
				item.setText(sauvegarde.getNom());
				item.setData(sauvegardesParFlag.get(y));
				
				model.setItem(i, item);
				this.referencesArmes.put(sauvegarde.getId(), item);
			}
			
			i++;
		}
		
		this.ui.cmbSimuCaC.setModel(model);
		
		this.ui.cmbSimuCaC.blockSignals(false);
	}
	

	/**
	 * <p>Définit l'arme équipée.</p>
	 * 
	 * @param sauvegarde - Sauvegarde de l'arme.
	 */
	public void setArmeEquipee(SauvegardeArme sauvegarde)
	{
		if(sauvegarde != null)
		{
			QStandardItem item = this.referencesArmes.get(sauvegarde.getId());
			this.ui.cmbSimuCaC.setCurrentIndex(item.index().row());
		}
		else
		{
			this.ui.cmbSimuCaC.blockSignals(true);
			this.ui.cmbSimuCaC.setCurrentIndex(0);
			this.ui.cmbSimuCaC.blockSignals(false);
			this.effacerDonneesSimulation();
		}
	}

	/*
	 * Slots de la fenêtre
	 */

	/**
	 * Ouvre la fenetre "À Propos".
	 * 
	 * @category Slot
	 */
	public void slotOuvertureAPropos()
	{
		QWidget fenetreAPropos = new QWindowAPropos(this);
		VueQt.centrerFenetre(fenetreAPropos);
		fenetreAPropos.show();
	}

	/**
	 * Gère la selection d'un sort dans l'onglet "Sorts".
	 * 
	 * @category Slot
	 */
	public void slotSelectionSort()
	{
		// Recupere les données du sort
		Sort sort = (Sort) this.ui.comboListeSorts.itemData(this.ui.tableListeSorts.currentIndex().row() + 1);
		QSpinBox sb = (QSpinBox) this.ui.tableListeSorts.cellWidget(this.ui.tableListeSorts.currentRow(), 1);
		this.setSort(sort, sb.value());
	}

	/**
	 * Ouvre la fenêtre de calcul des coups critiques.
	 * 
	 * @category Slot
	 */
	public void slotOuvertureCalcCC()
	{
		QWindowCalcCoupsCritiques calculateur = new QWindowCalcCoupsCritiques(this);
		VueQt.centrerFenetre(calculateur);
		calculateur.show();
	}
	
	/**
	 * Ouvre la fenêtre de calcul des probabilités de tacles.
	 * 
	 * @category Slot
	 */
	public void slotOuvertureCalcTacle()
	{
		QWindowCalcTacle calculateur = new QWindowCalcTacle(this);
		VueQt.centrerFenetre(calculateur);
		calculateur.show();
	}

	/*
	 * Slot-Signaux de la fenêtre
	 */

	/**
	 * Gère le changement de niveau d'un sort dans l'onglet "Sorts".
	 * 
	 * @param
	 * @category Slot-Signal
	 */
	public void slotChangementNiveauSort(int niveau)
	{
		// Recupere les données du sort
		QSpinBox sb = (QSpinBox) QSignalEmitter.signalSender();
		int index = (Integer) sb.property("index");
		Sort sort = (Sort) this.ui.comboListeSorts.itemData(index + 1);

		// Si le sort de la simulation est celui modifié
		if((index + 1) == this.ui.comboListeSorts.currentIndex())
		{
			this.ui.spinBoxNiveauSort.setValue(niveau);
		}
		
		this.signalChangerNiveauSort.emit(sort.getNom(), niveau);
		
		this.ui.tableListeSorts.blockSignals(true);
		this.ui.tableListeSorts.selectRow(index);
		this.ui.tableListeSorts.blockSignals(false);
		this.slotSelectionSort();
	}

	/**
	 * Demande d'ouverture de la fenêtre de calcul des caractéristiques.
	 * 
	 * @category Slot-Signal
	 */
	public void slotOuvertureCalcCaract()
	{
		this.signalOuvrirCalcCaracteristiques.emit();
	}

	/**
	 * Signale une selection d'un sort dans l'onglet de simulation.
	 * 
	 * @category Slot-Signal
	 */
	public void slotSlectionSortSimulation(int index)
	{
		if(index > 0)
		{
			Sort sort = (Sort) this.ui.comboListeSorts.itemData(index);
			this.signalSelectionnerSortSimulation.emit(sort);
		}

		this.slotChangementSimulation();
	}

	/**
	 * Demande de changement du mode de calcul des statistiques.
	 * 
	 * @category Slot-Signal
	 */
	public void slotChangementMode()
	{
		// Si le mode PvM est selectionné
		if(this.ui.rbtnPvM.isChecked())
		{
			this.signalChangerMode.emit(1);
		}
		// Si le mode PvP est selectionné
		else if(this.ui.rbtnPvP.isChecked())
		{
			this.signalChangerMode.emit(2);
		}
	}

	/**
	 * Demande de changement du niveau du personnage.
	 * 
	 * @param niveau - Niveau du personnage.
	 * @category Slot-Signal
	 */
	public void slotChangementNiveau(int niveau)
	{
		this.signalChangerNiveau.emit(niveau);
	}

	/**
	 * Signale un changement de vitalité.
	 * 
	 * @category Slot-Signal
	 */
	public void slotChangementVitalite()
	{
		QLineEdit qline = this.ui.txtVita;
		int valeur = 0;
		if(qline.text().equals(""))
		{
			qline.setText(String.valueOf(valeur));
		}
		else
		{
			valeur = Integer.parseInt(qline.text());
		}

		this.signalChangerCaracteristiques.emit("Vitalité", valeur);
	}

	/**
	 * Signale un changement de sagesse.
	 * 
	 * @category Slot-Signal
	 */
	public void slotChangementSagesse()
	{
		QLineEdit qline = this.ui.txtSag;
		int valeur = 0;
		if(qline.text().equals(""))
		{
			qline.setText(String.valueOf(valeur));
		}
		else
		{
			valeur = Integer.parseInt(qline.text());
		}

		this.signalChangerCaracteristiques.emit("Sagesse", valeur);
	}

	/**
	 * Signale un changement de force.
	 * 
	 * @category Slot-Signal
	 */
	public void slotChangementForce()
	{
		QLineEdit qline = this.ui.txtForce;
		int valeur = 0;
		if(qline.text().equals(""))
		{
			qline.setText(String.valueOf(valeur));
		}
		else
		{
			valeur = Integer.parseInt(qline.text());
		}

		this.signalChangerCaracteristiques.emit("Force", valeur);
	}

	/**
	 * Signale un changement d'intelligence.
	 * 
	 * @category Slot-Signal
	 */
	public void slotChangementIntelligence()
	{
		QLineEdit qline = this.ui.txtInt;
		int valeur = 0;
		if(qline.text().equals(""))
		{
			qline.setText(String.valueOf(valeur));
		}
		else
		{
			valeur = Integer.parseInt(qline.text());
		}

		this.signalChangerCaracteristiques.emit("Intelligence", valeur);
	}

	/**
	 * Signale un changement de chance.
	 * 
	 * @category Slot-Signal
	 */
	public void slotChangementChance()
	{
		QLineEdit qline = this.ui.txtChance;
		int valeur = 0;
		if(qline.text().equals(""))
		{
			qline.setText(String.valueOf(valeur));
		}
		else
		{
			valeur = Integer.parseInt(qline.text());
		}

		this.signalChangerCaracteristiques.emit("Chance", valeur);
	}

	/**
	 * Signale un changement d'agilité.
	 * 
	 * @category Slot-Signal
	 */
	public void slotChangementAgilite()
	{
		QLineEdit qline = this.ui.txtAgi;
		int valeur = 0;
		if(qline.text().equals(""))
		{
			qline.setText(String.valueOf(valeur));
		}
		else
		{
			valeur = Integer.parseInt(qline.text());
		}

		this.signalChangerCaracteristiques.emit("Agilité", valeur);
	}

	/**
	 * Singale un changement sur l'alignement.
	 * 
	 * @category Slot-Signal
	 */
	public void slotChangementAli()
	{
		/* Modifications de la fenetre */
		if(this.ui.grpAlign.isChecked())
		{
			if(this.ui.rbtnMerc.isChecked())
			{
				this.ui.rbtnAucun.setEnabled(false);
				this.ui.rbtnEspion.setEnabled(false);
				this.ui.rbtnGuerrier.setEnabled(false);
				this.ui.rbtnPretre.setEnabled(false);
				this.ui.spinBoxGrade.setEnabled(false);
				this.ui.lblGrade.setEnabled(false);

				this.ui.spinBoxLvlAli.setEnabled(true);
				this.ui.lblNiveauAli.setEnabled(true);
			}
			else
			{
				this.ui.rbtnAucun.setEnabled(true);
				this.ui.rbtnEspion.setEnabled(true);
				this.ui.rbtnGuerrier.setEnabled(true);
				this.ui.rbtnPretre.setEnabled(true);
				this.ui.spinBoxGrade.setEnabled(true);
				this.ui.lblGrade.setEnabled(true);

				if(this.ui.rbtnAucun.isChecked())
				{
					this.ui.spinBoxLvlAli.setEnabled(false);
					this.ui.lblNiveauAli.setEnabled(false);
				}
				else
				{
					this.ui.spinBoxLvlAli.setEnabled(true);
					this.ui.lblNiveauAli.setEnabled(true);
				}
			}
		}
		else
		{
			this.ui.rbtnAucun.setEnabled(false);
			this.ui.rbtnEspion.setEnabled(false);
			this.ui.rbtnGuerrier.setEnabled(false);
			this.ui.rbtnPretre.setEnabled(false);
			this.ui.spinBoxGrade.setEnabled(false);
			this.ui.lblGrade.setEnabled(false);
			this.ui.spinBoxLvlAli.setEnabled(false);
			this.ui.lblNiveauAli.setEnabled(false);
		}

		/* Génération du signal */
		int alignement;
		int specialisation;
		int niveauAlignement;
		int grade;
		if(this.ui.grpAlign.isChecked())
		{
			if(this.ui.rbtnBonta.isChecked())
			{
				alignement = 1;
			}
			else if(this.ui.rbtnBrak.isChecked())
			{
				alignement = 2;
			}
			else if(this.ui.rbtnMerc.isChecked())
			{
				alignement = 3;
			}
			else
			{
				alignement = 0;
			}

			// Si brak ou bonta
			if((alignement == 1) || (alignement == 2))
			{
				if(this.ui.rbtnEspion.isChecked())
				{
					specialisation = 1;
				}
				else if(this.ui.rbtnGuerrier.isChecked())
				{
					specialisation = 2;
				}
				else if(this.ui.rbtnPretre.isChecked())
				{
					specialisation = 3;
				}
				else
				{
					specialisation = 0;
				}

				grade = this.ui.spinBoxGrade.value();
			}
			// Si mercenaire
			else
			{
				specialisation = 0;
				grade = 0;
			}

			if((specialisation != 0) || (alignement == 3))
			{
				niveauAlignement = this.ui.spinBoxLvlAli.value();
			}
			else
			{
				niveauAlignement = 0;
			}
		}
		else
		{
			alignement = 0;
			specialisation = 0;
			niveauAlignement = 0;
			grade = 0;
		}

		this.signalChangerAlignement.emit(alignement, specialisation, niveauAlignement, grade);
	}

	/**
	 * Signale un changement sur la maitrise de l'arc.
	 * 
	 * @category Slot-Signal
	 */
	public void slotChangementMaitriseArc(int niveau)
	{
		this.signalChangerNiveauMaitrise.emit(FlagsTypesArmes.Arc, niveau);
	}

	/**
	 * Signale un changement sur la maitrise de la baguette.
	 * 
	 * @category Slot-Signal
	 */
	public void slotChangementMaitriseBaguette(int niveau)
	{
		this.signalChangerNiveauMaitrise.emit(FlagsTypesArmes.Baguette, niveau);
	}

	/**
	 * Signale un changement sur la maitrise du baton.
	 * 
	 * @category Slot-Signal
	 */
	public void slotChangementMaitriseBaton(int niveau)
	{
		this.signalChangerNiveauMaitrise.emit(FlagsTypesArmes.Baton, niveau);
	}

	/**
	 * Signale un changement sur la maitrise de la dague.
	 * 
	 * @category Slot-Signal
	 */
	public void slotChangementMaitriseDague(int niveau)
	{
		this.signalChangerNiveauMaitrise.emit(FlagsTypesArmes.Dague, niveau);
	}

	/**
	 * Signale un changement sur la maitrise de l'épee.
	 * 
	 * @category Slot-Signal
	 */
	public void slotChangementMaitriseEpee(int niveau)
	{
		this.signalChangerNiveauMaitrise.emit(FlagsTypesArmes.Epee, niveau);
	}

	/**
	 * Signale un changement sur la maitrise de la hache.
	 * 
	 * @category Slot-Signal
	 */
	public void slotChangementMaitriseHache(int niveau)
	{
		this.signalChangerNiveauMaitrise.emit(FlagsTypesArmes.Hache, niveau);
	}

	/**
	 * Signale un changement sur la maitrise du marteau.
	 * 
	 * @category Slot-Signal
	 */
	public void slotChangementMaitriseMarteau(int niveau)
	{
		this.signalChangerNiveauMaitrise.emit(FlagsTypesArmes.Marteau, niveau);
	}

	/**
	 * Signale un changement sur la maitrise de la pelle.
	 * 
	 * @category Slot-Signal
	 */
	public void slotChangementMaitrisePelle(int niveau)
	{
		this.signalChangerNiveauMaitrise.emit(FlagsTypesArmes.Pelle, niveau);
	}

	/**
	 * Signale un changement de la simulation.
	 * 
	 * @category Slot-Signal
	 */
	public void slotChangementSimulation()
	{
		// Si le CaC est coché
		if(this.ui.rbtnSimuCaC.isChecked())
		{
			this.ui.txtCoupCritiqueDeg.setEnabled(true);
			this.ui.comboListeSorts.setEnabled(false);
			this.ui.comboListeSorts.setCurrentIndex(0);
			this.ui.cboxMaitrise.setVisible(true);
			this.ui.cboxCCMaitrise.setVisible(true);
			this.ui.cboxMaitrise.setEnabled(true);
			this.ui.cboxCCMaitrise.setEnabled(false);
			this.ui.spinBoxNiveauSort.setEnabled(false);
			this.ui.btnDetailsSimu.setEnabled(true);

			if(this.ui.cmbSimuCaC.currentIndex() != 0)
			{
				boolean maitrise = false;
				boolean ccMaitrise = false;
				if(this.ui.cboxMaitrise.isChecked())
				{
					maitrise = true;
	
					this.ui.cboxCCMaitrise.setEnabled(true);
	
					if(this.ui.cboxCCMaitrise.isChecked())
					{
						ccMaitrise = true;
					}
				}
				else
				{
					this.ui.cboxCCMaitrise.setEnabled(false);
					this.ui.cboxCCMaitrise.setChecked(false);
				}
				this.signalSimulerCaC.emit(maitrise, ccMaitrise);
			}
			else
			{
				this.effacerDonneesSimulation();
			}
		}
		// Si un sort est coché
		else
		{
			this.ui.txtCoupCritiqueDeg.setText("");
			this.ui.txtCoupCritiqueDeg.setEnabled(false);
			this.ui.txtCoupCritiqueDeg.setVisible(false);
			this.ui.lblCoupCritiqueDeg.setVisible(false);
			this.ui.comboListeSorts.setEnabled(true);
			this.ui.cboxMaitrise.setVisible(false);
			this.ui.cboxCCMaitrise.setVisible(false);
			this.ui.cboxMaitrise.setEnabled(false);
			this.ui.cboxCCMaitrise.setEnabled(false);
			this.ui.btnDetailsSimu.setEnabled(true);

			if(this.ui.comboListeSorts.currentIndex() != 0)
			{
				this.ui.spinBoxNiveauSort.setEnabled(true);

				Sort sort = (Sort) this.ui.comboListeSorts.itemData(this.ui.comboListeSorts.currentIndex());
				this.signalSimulerSort.emit(sort, this.ui.spinBoxNiveauSort.value());
			}
			else
			{
				this.effacerDonneesSimulation();
			}
		}
	}
	
	/**
	 * Demande d'équipement d'une arme.
	 * 
	 * @param index - Index du de l'item du QComboBox sélectionné.
	 * @category Slot-Signal
	 */
	public void slotChangementArmeSimulation(int index)
	{
		if(index != 0)
		{
			QStandardItemModel model = (QStandardItemModel) this.ui.cmbSimuCaC.model();
			SauvegardeArme sauvegarde = (SauvegardeArme) model.item(index).data();
			this.signalEquiperArme.emit(sauvegarde);
		}
		
		this.slotChangementSimulation();
	}

	/**
	 * Signale un changement des boost.
	 * 
	 * @category Slot-Signal
	 */
	public void slotChangementBoost()
	{
		HashMap<FlagsTypesEffets, QSpinBox> boost = new HashMap<FlagsTypesEffets, QSpinBox>();
		boost.put(FlagsTypesEffets.Pa, this.ui.spinBoxBoostPA);
		boost.put(FlagsTypesEffets.Prospection, this.ui.spinBoxBoostPP);
		boost.put(FlagsTypesEffets.Sagesse, this.ui.spinBoxBoostSag);
		boost.put(FlagsTypesEffets.Force, this.ui.spinBoxBoostForce);
		boost.put(FlagsTypesEffets.Intelligence, this.ui.spinBoxBoostInt);
		boost.put(FlagsTypesEffets.Chance, this.ui.spinBoxBoostChance);
		boost.put(FlagsTypesEffets.Agilite, this.ui.spinBoxBoostAgi);
		boost.put(FlagsTypesEffets.Dommages, this.ui.spinBoxBoostDom);
		boost.put(FlagsTypesEffets.PourcentagesDommages, this.ui.spinBoxBoostPDom);
		boost.put(FlagsTypesEffets.CoupsCritiques, this.ui.spinBoxBoostCC);
		boost.put(FlagsTypesEffets.Soins, this.ui.spinBoxBoostSoins);
		boost.put(FlagsTypesEffets.DommagesPhysiques, this.ui.spinBoxBoostDomPhy);

		Effets valeurBoost = new Effets();

		for(Entry<FlagsTypesEffets, QSpinBox> entry : boost.entrySet())
		{
			if(this.ui.grpBoost.isChecked())
			{
				QSpinBox spinbox = entry.getValue();
				if(spinbox.value() < 0)
				{
					spinbox.setStyleSheet("color: rgb(255, 0, 0);");
				}
				else
				{
					spinbox.setStyleSheet("");
				}

				valeurBoost.setInt(entry.getKey(), spinbox.value());
			}
			else
			{
				valeurBoost.setInt(entry.getKey(), 0);
			}
		}

		this.signalChangerBoost.emit(valeurBoost);
	}
	
	/**
	 * Signale un changement de la vie actuelle du personnage.
	 * 
	 * @category Slot-Signal
	 */
	public void slotChangementVieActuelle()
	{
		Effets valeurBoost = new Effets();
		valeurBoost.setInt(FlagsTypesEffets.Vie, this.ui.sbVieSimulation.value());
		this.signalChangerBoost.emit(valeurBoost);
	}
	
	/**
	 * Signale un changement des résistances.
	 * 
	 * @category Slot-Signal
	 */
	public void slotChangementResistances()
	{
		HashMap<FlagsTypesEffets, QSpinBox> resistances = new HashMap<FlagsTypesEffets, QSpinBox>();
		resistances.put(FlagsTypesEffets.ResistancesMagiques, this.ui.spinBoxBoostResMagique);
		resistances.put(FlagsTypesEffets.ResistancesPhysiques, this.ui.spinBoxBoostResPhysique);
		resistances.put(FlagsTypesEffets.ResistancesNeutre, this.ui.spinBoxBoostResNeutre);
		resistances.put(FlagsTypesEffets.ResistancesTerre, this.ui.spinBoxBoostResTerre);
		resistances.put(FlagsTypesEffets.ResistancesFeu, this.ui.spinBoxBoostResFeu);
		resistances.put(FlagsTypesEffets.ResistancesEau, this.ui.spinBoxBoostResEau);
		resistances.put(FlagsTypesEffets.ResistancesAir, this.ui.spinBoxBoostResAir);
		resistances.put(FlagsTypesEffets.PourcentagesResistancesNeutre, this.ui.spinBoxBoostPResNeutre);
		resistances.put(FlagsTypesEffets.PourcentagesResistancesTerre, this.ui.spinBoxBoostPResTerre);
		resistances.put(FlagsTypesEffets.PourcentagesResistancesFeu, this.ui.spinBoxBoostPResFeu);
		resistances.put(FlagsTypesEffets.PourcentagesResistancesEau, this.ui.spinBoxBoostPResEau);
		resistances.put(FlagsTypesEffets.PourcentagesResistancesAir, this.ui.spinBoxBoostPResAir);

		Effets valeurResistances = new Effets();

		for(Entry<FlagsTypesEffets, QSpinBox> entry : resistances.entrySet())
		{
			if(this.ui.grpResistances.isChecked())
			{
				QSpinBox spinbox = entry.getValue();
				if(spinbox.value() < 0)
				{
					spinbox.setStyleSheet("color: rgb(255, 0, 0);");
				}
				else
				{
					spinbox.setStyleSheet("");
				}

				valeurResistances.setInt(entry.getKey(), spinbox.value());
			}
			else
			{
				valeurResistances.setInt(entry.getKey(), 0);
			}
		}

		this.signalChangerResistances.emit(valeurResistances);
	}

	/**
	 * Ouvre la fenêtre de details.
	 * 
	 * @category Slot-Signal
	 */
	public void slotOuvertureDetails()
	{
		this.signalOuvrirDetails.emit();
	}
	
	/**
	 * Demande d'ouverture de la fenêtre de bonus des panoplies.
	 * 
	 * @category Slot-Signal
	 */
	public void slotOuvertureBonusPanoplies()
	{
		this.signalOuvrirBonusPanoplies.emit();
	}
	
	/**
	 * Demande d'ouverture de la fenêtre d'exportation des données.
	 * 
	 * @category Slot-Signal
	 */
	public void slotOuvertureExportation()
	{
		this.signalOuvrirExportation.emit();
	}


	/**
	 * Demande de sauvegarde du personnage.
	 * 
	 * @category Slot-Signal
	 */
	public void slotSauvegardePerso()
	{
		// Envoie du signal
		this.signalSauvegarderPersonnage.emit();
	}

	/**
	 * Demande de génération d'un nouveau personnage.
	 * 
	 * @category Slot-Signal
	 */
	public void slotNouveauPerso()
	{
		// Envoie du signal
		this.signalNouveauPersonnage.emit();
	}

	/**
	 * Demande de chargement d'un personnage.
	 *  
	 * @category Slot-Signal
	 */
	public void slotChargementSauvegardePerso()
	{
		// Envoie d'un signal
		this.signalChargerPersonnage.emit();
	}

	/**
	 * Demande de sauvegarde du groupe d'objets.
	 *  
	 * @category Slot-Signal
	 */
	public void slotSauvegardeGroupe()
	{
		// Envoie du signal
		this.signalSauvegarderGroupe.emit();
	}

	/**
	 * Demande de génération d'un nouveau groupe d'objets.
	 * 
	 * @category Slot-Signal
	 */
	public void slotNouveauGroupe()
	{
		// Envoie du signal
		this.signalNouveauGroupe.emit();
	}

	/**
	 * Demande de chargement d'un groupe d'objets.
	 *  
	 * @category Slot-Signal
	 */
	public void slotChargementGroupe()
	{
		// Envoie d'un signal
		this.signalChargerGroupe.emit();
	}

	/**
	 * Ouvre une fenetre de gestion de l'équipement.
	 * 
	 * @category Slot-Signal
	 */
	public void slotGererEquipement(FlagsTypesEquipements typeObjet)
	{
		// Envoie d'un signal
		this.signalGererEquipement.emit(typeObjet);
	}

	/**
	 * Ouvre une fenetre de gestion des dofus.
	 * 
	 * @category Slot-Signal
	 */
	public void slotGererDofus(FlagsTypesDofus typeDofus)
	{
		// Envoie d'un signal
		this.signalGererDofus.emit(typeDofus);
	}

	/**
	 * Ouvre une fenetre de gestion des armes.
	 * 
	 * @category Slot-Signal
	 */
	public void slotGererArmes(FlagsTypesArmes typeObjet)
	{
		// Envoie d'un signal
		this.signalGererArmes.emit(typeObjet);
	}

	/**
	 * Ouvre une fenetre de gestion des familiers.
	 * 
	 * @category Slot-Signal
	 */
	public void slotGererFamiliers()
	{
		// Envoie d'un signal
		this.signalGererFamiliers.emit();
	}

	/**
	 * Ouvre une fenetre de gestion des montures.
	 * 
	 * @category Slot-Signal
	 */
	public void slotGererMontures()
	{
		// Envoie d'un signal
		this.signalGererMontures.emit();
	}

	/**
	 * Signale le changement de classe.
	 * 
	 * @category Slot-Signal
	 */
	public void slotChangementClasse()
	{
		// Recupere les données de la classe
		Classe itemData = (Classe) this.ui.comboClasse.itemData(this.ui.comboClasse.currentIndex());

		// Envoie d'un signal
		this.signalChangerClasse.emit(itemData);
	}

	/**
	 * Signale le changement de classe.
	 * 
	 * @category Slot-Signal
	 */
	public void slotChangementSexe()
	{
		char sexe;
		if(this.ui.rbtnMale.isChecked())
		{
			sexe = 'm';
		}
		else
		{
			sexe = 'f';
		}

		// Envoie d'un signal
		this.signalChangerSexe.emit(sexe);
	}

	/**
	 * Signale le changement de classe.
	 * 
	 * @category Slot-Signal
	 */
	public void slotChangementNomPersonnage()
	{
		// Envoie d'un signal
		this.signalChangerNomPersonnage.emit(this.ui.txtNom.text());
	}

	/**
	 * Signale une demande de mise à jour.
	 * 
	 * @category Slot-Signal
	 */
	public void slotMAJ()
	{
		this.signalMettreAJour.emit();
	}

	/**
	 * Demande d'équipement d'un équipement.
	 * 
	 * @param typeEquipement - Type de l'équipement.
	 * @param sauvegarde - Sauvegarde de l'équipement.
	 * @category Slot-Signal
	 */
	public void slotEquipeEquipement(FlagsTypesEquipements typeEquipement, SauvegardeEquipement sauvegarde)
	{
		this.signalEquiperEquipement.emit(typeEquipement, sauvegarde);
	}

	/**
	 * Demande d'équipement d'un famileir.
	 * 
	 * @param sauvegarde - Sauvegarde du familier.
	 * @category Slot-Signal
	 */
	public void slotEquipeFamilier(SauvegardeFamilier sauvegarde)
	{
		this.signalEquiperFamilier.emit(sauvegarde);
	}

	/**
	 * Demande d'équipement d'une monture.
	 * 
	 * @param sauvegarde - Sauvegarde de la monture.
	 * @category Slot-Signal
	 */
	public void slotEquipeMonture(SauvegardeMonture sauvegarde)
	{
		this.signalEquiperMonture.emit(sauvegarde);
	}

	/**
	 * Demande d'équipement d'un Dofus.
	 * 
	 * @param typeDofus - Type du Dofus.
	 * @param sauvegarde - Sauvegarde du Dofus.
	 * @category Slot-Signal
	 */
	public void slotEquipeDofus(FlagsTypesDofus typeDofus, SauvegardeDofus sauvegarde)
	{
		this.signalEquiperDofus.emit(typeDofus, sauvegarde);
	}

	/**
	 * Demande d'équipement d'une arme.
	 * 
	 * @param sauvegarde - Sauvegarde de l'arme.
	 * @category Slot-Signal
	 */
	public void slotEquipeArme(SauvegardeArme sauvegarde)
	{
		this.signalEquiperArme.emit(sauvegarde);
	}

	/**
	 * Demande le retrait d'un équipement.
	 * 
	 * @param typeEquipement - Type de l'équipement.
	 * @category Slot-Signal
	 */
	public void slotRetireEquipement(FlagsTypesEquipements typeEquipement)
	{
		this.signalRetirerEquipement.emit(typeEquipement);
	}

	/**
	 * Demande le retrait d'un Dofus.
	 * 
	 * @param typeEquipement - Type du Dofus.
	 * @category Slot-Signal
	 */
	public void slotRetireDofus(FlagsTypesDofus typeDofus)
	{
		this.signalRetirerDofus.emit(typeDofus);
	}

	/**
	 * Demande le retrait de l'arme.
	 * 
	 * @category Slot-Signal
	 */
	public void slotRetireArme()
	{
		this.signalRetirerArme.emit();
	}

	/**
	 * Demande le retrait de l'animal.
	 * 
	 * @category Slot-Signal
	 */
	public void slotRetireAnimal()
	{
		this.signalRetirerAnimal.emit();
	}

	/*
	 * Accesseurs
	 */

	/**
	 * Renvoie le tableau récapitulatif des objets équipés.
	 * 
	 * @return Tableau récapitulatif des objets équipés.
	 */
	public QWidgetTableauObjets getTableauObjets()
	{
		return this.ui.tableauObjets;
	}
}