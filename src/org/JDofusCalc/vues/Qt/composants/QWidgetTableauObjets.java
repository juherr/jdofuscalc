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

import org.JDofusCalc.dofus.autres.Effets;
import org.JDofusCalc.dofus.objets.Animal.FlagsTypesAnimaux;
import org.JDofusCalc.dofus.objets.Arme.FlagsTypesArmes;
import org.JDofusCalc.dofus.objets.Dofus.FlagsTypesDofus;
import org.JDofusCalc.dofus.objets.Equipement.FlagsTypesEquipements;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeAnimal;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeArme;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeDofus;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeEquipement;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeFamilier;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeMonture;
import org.JDofusCalc.vues.Qt.designer.UITableauObjets;

import com.trolltech.qt.gui.QWidget;

/**
 * Tableau récapitulatif des effets des objets équipés.
 * 
 * @author PAPAYA Alexandre
 * @category Composant
 * @version 1.0
 */
public class QWidgetTableauObjets extends QWidget
{
	/*
	 * Variables d'instances
	 */

	/* Composants */

	/**
	 * L'interface graphique.
	 */
	public UITableauObjets ui;

	/* Autres */
	
	/**
	 * Liste des lignes du tableau.
	 */
	private ArrayList<QWidgetLigneAbstraite> lignes;
	
	/**
	 * Variable témoin d'affichage des noms des objets.
	 */
	private boolean nomsObjetsAffiches = false;

	/*
	 * Signaux
	 */

	/**
	 * <p>Ce signal prend 1 argument(s) générique(s) : &lt;{@link FlagsTypesEquipements} (nom: type)&gt;.</p>
	 * <p>Ce signal est émit lors d'une demande d'ouverture de la fenêtre de gestion des équipements {@code type}.</p>
	 */
	public Signal1<FlagsTypesEquipements> signalGererEquipement = new Signal1<FlagsTypesEquipements>();

	/**
	 * <p>Ce signal prend 1 argument(s) générique(s) : &lt;{@link FlagsTypesDofus} (nom: type)&gt;.</p>
	 * <p>Ce signal est émit lors d'une demande d'ouverture de la fenêtre de gestion des Dofus {@code type}.</p>
	 */
	public Signal1<FlagsTypesDofus> signalGererDofus = new Signal1<FlagsTypesDofus>();

	/**
	 * <p>Ce signal prend 1 argument(s) générique(s) : &lt;{@link FlagsTypesArmes} (nom: type)&gt;.</p>
	 * <p>Ce signal est émit lors d'une demande d'ouverture de la fenêtre de gestion des armes {@code type}.</p>
	 */
	public Signal1<FlagsTypesArmes> signalGererArmes = new Signal1<FlagsTypesArmes>();

	/**
	 * <p>Ce signal prend aucun argument générique.</p>
	 * <p>Ce signal est émit lors d'une demande d'ouverture de la fenêtre de gestion des familiers.</p>
	 */
	public Signal0 signalGererFamiliers = new Signal0();

	/**
	 * <p>Ce signal prend aucun argument générique.</p>
	 * <p>Ce signal est émit lors d'une demande d'ouverture de la fenêtre de gestion des montures.</p>
	 */
	public Signal0 signalGererMontures = new Signal0();

	/**
	 * <p>Ce signal prend 2 argument(s) générique(s) : &lt;{@link FlagsTypesEquipements} (nom: type), {@link SauvegardeEquipement} (nom: sauvegarde)&gt;.</p>
	 * <p>Ce signal est émit lors d'une demande d'équipement de l'équipement {@code sauvegarde} de type {@code type}.</p>
	 */
	public Signal2<FlagsTypesEquipements, SauvegardeEquipement> signalEquiperEquipement = new Signal2<FlagsTypesEquipements, SauvegardeEquipement>();

	/**
	 * <p>Ce signal prend 1 argument(s) générique(s) : &lt;{@link SauvegardeFamilier} (nom: sauvegarde)&gt;.</p>
	 * <p>Ce signal est émit lors d'une demande d'équipement du familier {@code sauvegarde}.</p>
	 */
	public Signal1<SauvegardeFamilier> signalEquiperFamilier = new Signal1<SauvegardeFamilier>();

	/**
	 * <p>Ce signal prend 1 argument(s) générique(s) : &lt;{@link SauvegardeMonture} (nom: sauvegarde)&gt;.</p>
	 * <p>Ce signal est émit lors d'une demande d'équipement de la monture {@code sauvegarde}.</p>
	 */
	public Signal1<SauvegardeMonture> signalEquiperMonture = new Signal1<SauvegardeMonture>();

	/**
	 * <p>Ce signal prend 2 argument(s) générique(s) : &lt;{@link FlagsTypesDofus} (nom: type), {@link SauvegardeDofus} (nom: sauvegarde)&gt;.</p>
	 * <p>Ce signal est émit lors d'une demande d'équipement du Dofus {@code sauvegarde} de type {@code type}.</p>
	 */
	public Signal2<FlagsTypesDofus, SauvegardeDofus> signalEquiperDofus = new Signal2<FlagsTypesDofus, SauvegardeDofus>();

	/**
	 * <p>Ce signal prend 1 argument(s) générique(s) : &lt;{@link SauvegardeArme} (nom: sauvegarde)&gt;.</p>
	 * <p>Ce signal est émit lors d'une demande de retrait de l'arme équipée.</p>
	 */
	public Signal1<SauvegardeArme> signalEquiperArme = new Signal1<SauvegardeArme>();

	/**
	 * <p>Ce signal prend 1 argument(s) générique(s) : &lt;{@link FlagsTypesEquipements} (nom: type)&gt;.</p>
	 * <p>Ce signal est émit lors d'une demande de retrait de l'équipement {@code type} équipé.</p>
	 */
	public Signal1<FlagsTypesEquipements> signalRetirerEquipement = new Signal1<FlagsTypesEquipements>();

	/**
	 * <p>Ce signal prend 1 argument(s) générique(s) : &lt;{@link FlagsTypesDofus} (nom: type)&gt;.</p>
	 * <p>Ce signal est émit lors d'une demande de retrait du Dofus {@code type} équipé.</p>
	 */
	public Signal1<FlagsTypesDofus> signalRetirerDofus = new Signal1<FlagsTypesDofus>();

	/**
	 * <p>Ce signal prend aucun argument générique.</p>
	 * <p>Ce signal est émit lors d'une demande de retrait de l'animal équipé.</p>
	 */
	public Signal0 signalRetirerAnimal = new Signal0();

	/**
	 * <p>Ce signal prend aucun argument générique.</p>
	 * <p>Ce signal est émit lors d'une demande de retrait de l'arme équipée.</p>
	 */
	public Signal0 signalRetirerArme = new Signal0();

	/*
	 * Constructeurs / Destructeur
	 */

	/**
	 * Construit un nouveau composant.
	 * 
	 * @param parent - Composant parent.
	 * @category Constructeur
	 */
	public QWidgetTableauObjets(QWidget parent)
	{
		// Execution du constructeur de la classe mère
		super(parent);

		// Initialisation de l'interface graphique
		this.ui = new UITableauObjets();
		this.ui.setupUi(this);

		this.lignes = new ArrayList<QWidgetLigneAbstraite>();
		this.lignes.add(this.ui.ligneAmu);
		this.lignes.add(this.ui.ligneAnneauD);
		this.lignes.add(this.ui.ligneAnneauG);
		this.lignes.add(this.ui.ligneBottes);
		this.lignes.add(this.ui.ligneBouclier);
		this.lignes.add(this.ui.ligneArme);
		this.lignes.add(this.ui.ligneCape);
		this.lignes.add(this.ui.ligneCeinture);
		this.lignes.add(this.ui.ligneCoiffe);
		this.lignes.add(this.ui.ligneDofus);
		this.lignes.add(this.ui.ligneAnimal);
		this.lignes.add(this.ui.lignePanoplie);

		for(int i = 0; i < this.lignes.size(); i++)
		{
			QWidgetLigneAbstraite ligneAbstraite = this.lignes.get(i);
			ligneAbstraite.genererMenu();

			// Si la ligne est un équipement
			if(ligneAbstraite instanceof QWidgetLigneEquipement)
			{
				QWidgetLigneEquipement ligne = (QWidgetLigneEquipement) ligneAbstraite;

				/* Connexions signal->slot */
				ligne.signalGerer.connect(this, "slotGestionEquipement(org.JDofusCalc.dofus.objets.Equipement$FlagsTypesEquipements)");
				ligne.signalEquiper.connect(this, "slotEquipeEquipement(org.JDofusCalc.dofus.objets.Equipement$FlagsTypesEquipements, Object)");
				ligne.signalRetirer.connect(this, "slotRetireEquipement(org.JDofusCalc.dofus.objets.Equipement$FlagsTypesEquipements)");
			}
			// Si la ligne est une arme
			else if(ligneAbstraite instanceof QWidgetLigneArme)
			{
				QWidgetLigneArme ligne = (QWidgetLigneArme) ligneAbstraite;

				/* Connexions signal->slot */
				ligne.signalGerer.connect(this, "slotGestionArmes(org.JDofusCalc.dofus.objets.Arme$FlagsTypesArmes)");
				ligne.signalEquiper.connect(this, "slotEquipeArme(Object)");
				ligne.signalRetirer.connect(this, "slotRetireArme()");

			}
			// Si la ligne est un dofus
			else if(ligneAbstraite instanceof QWidgetLigneDofus)
			{
				QWidgetLigneDofus ligne = (QWidgetLigneDofus) ligneAbstraite;

				/* Connexions signal->slot */
				ligne.signalGerer.connect(this, "slotGestionDofus(org.JDofusCalc.dofus.objets.Dofus$FlagsTypesDofus)");
				ligne.signalEquiper.connect(this, "slotEquipeDofus(org.JDofusCalc.dofus.objets.Dofus$FlagsTypesDofus, Object)");
				ligne.signalRetirer.connect(this, "slotRetireDofus(org.JDofusCalc.dofus.objets.Dofus$FlagsTypesDofus)");

			}
			// Si la ligne est un animal
			else if(ligneAbstraite instanceof QWidgetLigneAnimal)
			{
				QWidgetLigneAnimal ligne = (QWidgetLigneAnimal) ligneAbstraite;

				/* Connexions signal->slot */
				ligne.signalGerer.connect(this, "slotGestionAnimaux(org.JDofusCalc.dofus.objets.Animal$FlagsTypesAnimaux)");
				ligne.signalEquiper.connect(this, "slotEquipeAnimal(org.JDofusCalc.dofus.objets.Animal$FlagsTypesAnimaux, Object)");
				ligne.signalRetirer.connect(this, "slotRetireAnimal()");

			}
		}
		
		/* Connexions signal->slot */
		this.ui.btnNoms.clicked.connect(this, "slotAfficheNoms()");
	}

	/*
	 * Méthode d'affichage des données du composant
	 */
	
	/**
	 * Affiche ou cache la barre des résistances.
	 * 
	 * @param afficherRes - Passer {@code true} pour afficher la barre des résistances, sinon {@code false}.
	 */
	public void afficherRes(boolean afficherRes)
	{
		 if(afficherRes)
		 {
			 this.ui.frameStatsRes.setVisible(false);
		 }
		 else
		 {
			 this.ui.frameStatsRes.setVisible(true);
		 }
	}
	
	/**
	 * Affiche ou cache les noms des objets équipés.
	 * 
	 * @param afficherNoms - Passer {@code true} pour afficher les noms, sinon {@code false}.
	 */
	public void afficherNomsObjets(boolean afficherNoms)
	{
		for(int i = 0; i < this.lignes.size(); i++)
		{
			this.lignes.get(i).afficherNom(afficherNoms);
		}
	}

	/**
	 * Définit la liste des sauvegardes des équipements.
	 * 
	 * @param typeEquipement - Type des équipements.
	 * @param sauvegardes - Liste des sauvegardes des équipements.
	 */
	public void setListeSauvegardesEquipements(FlagsTypesEquipements typeEquipement, ArrayList<SauvegardeEquipement> sauvegardes)
	{
		if(typeEquipement == FlagsTypesEquipements.Amulette)
		{
			this.ui.ligneAmu.setListeSauvegardesEquipements(sauvegardes);
		}
		if((typeEquipement == FlagsTypesEquipements.Anneau) || (typeEquipement == FlagsTypesEquipements.AnneauG) || (typeEquipement == FlagsTypesEquipements.AnneauD))
		{
			this.ui.ligneAnneauG.setListeSauvegardesEquipements(sauvegardes);
			this.ui.ligneAnneauD.setListeSauvegardesEquipements(sauvegardes);
		}
		if(typeEquipement == FlagsTypesEquipements.Bottes)
		{
			this.ui.ligneBottes.setListeSauvegardesEquipements(sauvegardes);
		}
		if(typeEquipement == FlagsTypesEquipements.Cape)
		{
			this.ui.ligneCape.setListeSauvegardesEquipements(sauvegardes);
		}
		if(typeEquipement == FlagsTypesEquipements.Coiffe)
		{
			this.ui.ligneCoiffe.setListeSauvegardesEquipements(sauvegardes);
		}
		if(typeEquipement == FlagsTypesEquipements.Ceinture)
		{
			this.ui.ligneCeinture.setListeSauvegardesEquipements(sauvegardes);
		}
		if(typeEquipement == FlagsTypesEquipements.Bouclier)
		{
			this.ui.ligneBouclier.setListeSauvegardesEquipements(sauvegardes);
		}
	}

	/**
	 * Définit la liste des sauvegardes des Dofus.
	 * 
	 * @param typeDofus - Type des dofus.
	 * @param sauvegardes - Liste des sauvegardes des Dofus.
	 */
	public void setListeSauvegardesDofus(FlagsTypesDofus typeDofus, ArrayList<SauvegardeDofus> sauvegardes)
	{
		this.ui.ligneDofus.setListeSauvegardesDofus(typeDofus, sauvegardes);
	}

	/**
	 * Définit la liste des sauvegardes des familiers.
	 * 
	 * @param sauvegardes - Liste des sauvegardes des familiers.
	 */
	public void setListeSauvegardesFamiliers(ArrayList<SauvegardeFamilier> sauvegardes)
	{
		this.ui.ligneAnimal.setListeSauvegardesFamiliers(sauvegardes);
	}
	
	/**
	 * Définit la liste des sauvegardes des montures.
	 * 
	 * @param sauvegardes - Liste des sauvegardes des montures.
	 */
	public void setListeSauvegardesMontures(ArrayList<SauvegardeMonture> sauvegardesMontures)
	{
		this.ui.ligneAnimal.setListeSauvegardesMontures(sauvegardesMontures);
	}

	/**
	 * Définit la liste des sauvegardes des Ares.
	 * 
	 * @param typeArme - Type des armes.
	 * @param sauvegardes - Liste des sauvegardes des armes.
	 */
	public void setListeSauvegardesArmes(FlagsTypesArmes typeArme, ArrayList<SauvegardeArme> sauvegardes)
	{
		this.ui.ligneArme.setListeSauvegardesArmes(typeArme, sauvegardes);
	}

	/**
	 * Retire tous les objets équipés du tableau.
	 */
	public void retirerTout()
	{
		for(int i = 0; i < this.lignes.size(); i++)
		{
			QWidgetLigneAbstraite ligneAbstraite = this.lignes.get(i);

			// Si la ligne est un équipement
			if(ligneAbstraite instanceof QWidgetLigneEquipement)
			{
				QWidgetLigneEquipement ligne = (QWidgetLigneEquipement) ligneAbstraite;
				ligne.setEquipementEquipe(null, null);
			}
			// Si la ligne est une arme
			else if(ligneAbstraite instanceof QWidgetLigneArme)
			{
				QWidgetLigneArme ligne = (QWidgetLigneArme) ligneAbstraite;
				ligne.setArmeEquipee(null, null);
			}
			// Si la ligne est un dofus
			else if(ligneAbstraite instanceof QWidgetLigneDofus)
			{
				QWidgetLigneDofus ligne = (QWidgetLigneDofus) ligneAbstraite;
				ligne.retireTout();
			}
			// Si la ligne est un animal
			else if(ligneAbstraite instanceof QWidgetLigneAnimal)
			{
				QWidgetLigneAnimal ligne = (QWidgetLigneAnimal) ligneAbstraite;
				ligne.setAnimalEquipe(null, null);
			}
		}
		this.ui.ligneAnneauG.deverrouillerAnneau();
		this.ui.ligneAnneauD.deverrouillerAnneau();
	}

	/**
	 * <p>Définit l'arme équipée. Si {@code sauvegarde} est {@code null}, alors le composant se vide.</p>
	 * 
	 * @param sauvegarde - Sauvegarde de l'arme.
	 * @param erreurs - Erreurs à afficher.
	 */
	public void setArme(SauvegardeArme sauvegarde, String erreurs)
	{
		this.ui.ligneArme.setArmeEquipee(sauvegarde, erreurs);
		this.ui.ligneArme.afficherNom(this.nomsObjetsAffiches);
	}

	/**
	 * <p>Définit l'équipement équipée. Si {@code sauvegarde} est {@code null}, alors le composant se vide.</p>
	 * 
	 * @param sauvegarde - Sauvegarde de l'équipement.
	 * @param erreurs - Erreurs à afficher.
	 */
	public void setEquipement(FlagsTypesEquipements typeEquipement, SauvegardeEquipement sauvegarde, String erreurs)
	{
		QWidgetLigneEquipement ligne = null;
		if(typeEquipement == FlagsTypesEquipements.Amulette)
		{
			ligne = this.ui.ligneAmu;
		}
		else if(typeEquipement == FlagsTypesEquipements.AnneauG)
		{
			ligne = this.ui.ligneAnneauG;
			
			// Verrouillage des anneaux
			this.ui.ligneAnneauD.deverrouillerAnneau();
			if(sauvegarde != null)
			{
				this.ui.ligneAnneauD.verrouillerAnneau(sauvegarde.getId());
			}
		}
		else if(typeEquipement == FlagsTypesEquipements.AnneauD)
		{
			ligne = this.ui.ligneAnneauD;
			
			// Verrouillage des anneaux
			this.ui.ligneAnneauG.deverrouillerAnneau();
			if(sauvegarde != null)
			{
				this.ui.ligneAnneauG.verrouillerAnneau(sauvegarde.getId());
			}
		}
		else if(typeEquipement == FlagsTypesEquipements.Bottes)
		{
			ligne = this.ui.ligneBottes;
		}
		else if(typeEquipement == FlagsTypesEquipements.Cape)
		{
			ligne = this.ui.ligneCape;
		}
		else if(typeEquipement == FlagsTypesEquipements.Coiffe)
		{
			ligne = this.ui.ligneCoiffe;
		}
		else if(typeEquipement == FlagsTypesEquipements.Ceinture)
		{
			ligne = this.ui.ligneCeinture;
		}
		else if(typeEquipement == FlagsTypesEquipements.Bouclier)
		{
			ligne = this.ui.ligneBouclier;
		}

		ligne.setEquipementEquipe(sauvegarde, erreurs);
		ligne.afficherNom(this.nomsObjetsAffiches);
	}
	
	/**
	 * Définit les effets des panoplies équipées.
	 * 
	 * @param nomsPanoplies - Noms des panoplies équipées.
	 * @param effetsPanoplies - Effets cumulés des panoplies.
	 */
	public void setPanoplie(String nomsPanoplies, Effets effetsPanoplies)
	{
		QWidgetLignePanoplie ligne = this.ui.lignePanoplie;
		ligne.setNomsPanoplies(nomsPanoplies);
		ligne.afficherDonnees(effetsPanoplies);
		ligne.afficherNom(this.nomsObjetsAffiches);
	}


	/**
	 * Définit le Dofus {@code typeDofus} équipé.
	 * 
	 * @param typeDofus - Type du Dofus.
	 * @param sauvegarde - Sauvegarde du Dofus.
	 * @param erreurs - Erreurs à afficher.
	 * @param statistiquesDofus - Statistiques totales des Dofus équipés.
	 */
	public void setDofus(FlagsTypesDofus typeDofus, SauvegardeDofus sauvegarde, String erreurs, Effets statistiquesDofus)
	{
		this.ui.ligneDofus.setDofusEquipe(typeDofus, sauvegarde);
		this.ui.ligneDofus.afficherDonnees(statistiquesDofus);
		this.ui.ligneDofus.afficherNom(this.nomsObjetsAffiches);
	}

	/**
	 * <p>Définit l'animal équipé. Si {@code sauvegarde} est {@code null}, alors le composant se vide.</p>
	 * 
	 * @param sauvegarde - Sauvegarde de l'animal.
	 * @param erreurs - Erreurs à afficher.
	 */
	public void setAnimal(SauvegardeAnimal sauvegarde, String erreurs)
	{
		this.ui.ligneAnimal.setAnimalEquipe(sauvegarde, erreurs);
		this.ui.ligneAnimal.afficherNom(this.nomsObjetsAffiches);
	}

	/*
	 * Slot-Signaux du composant
	 */

	/**
	 * Demande le retrait de l'équipement équipé.
	 * 
	 * @param typeEquipement - Type de l'équipement.
	 * @category Slot-Signal
	 */
	public void slotRetireEquipement(FlagsTypesEquipements typeEquipement)
	{
		this.signalRetirerEquipement.emit(typeEquipement);
	}

	/**
	 * Demande le retrait du Dofus équipé.
	 * 
	 * @param typeDofus - Type du Dofus.
	 * @category Slot-Signal
	 */
	public void slotRetireDofus(FlagsTypesDofus typeDofus)
	{
		this.signalRetirerDofus.emit(typeDofus);
	}

	/**
	 * Demande l'équipement de l'équipement {@code sauvegarde}.
	 * 
	 * @param typeEquipement - Type de l'équipement.
	 * @param sauvegarde - Sauvgarde de l'équipement.
	 * @category Slot-Signal
	 */
	public void slotEquipeEquipement(FlagsTypesEquipements typeEquipement, Object sauvegarde)
	{
		this.signalEquiperEquipement.emit(typeEquipement, (SauvegardeEquipement) sauvegarde);
	}

	/**
	 * Demande l'équipement de l'arme {@code sauvegarde}.
	 * 
	 * @param sauvegarde - Sauvgarde de l'arme.
	 * @category Slot-Signal
	 */
	public void slotEquipeArme(Object sauvegarde)
	{
		this.signalEquiperArme.emit((SauvegardeArme) sauvegarde);
	}

	/**
	 * Demande le retrait de l'arme équipée.
	 * 
	 * @category Slot-Signal
	 */
	public void slotRetireArme()
	{
		this.signalRetirerArme.emit();
	}

	/**
	 * Demande l'ouverture d'une fenêtre de gestion des armes {@code type}.
	 * 
	 * @param typeArme - Type de l'arme.
	 * @category Slot-Signal
	 */
	public void slotGestionArmes(FlagsTypesArmes typeArme)
	{
		this.signalGererArmes.emit(typeArme);
	}

	/**
	 * Demande l'équipement de l'animal {@code sauvegarde}.
	 * 
	 * @param typeAnimal - Type de l'animal.
	 * @param sauvegarde - Sauvgarde de l'animal.
	 * @category Slot-Signal
	 */
	public void slotEquipeAnimal(FlagsTypesAnimaux typeAnimal, Object sauvegarde)
	{
		if(typeAnimal == FlagsTypesAnimaux.Familier)
		{
			this.signalEquiperFamilier.emit((SauvegardeFamilier) sauvegarde);
		}
		else
		{
			this.signalEquiperMonture.emit((SauvegardeMonture) sauvegarde);
		}
	}

	/**
	 * Demande le retrait de l'animal équipé.
	 * 
	 * @category Slot-Signal
	 */
	public void slotRetireAnimal()
	{
		this.signalRetirerAnimal.emit();
	}

	/**
	 * Demande l'ouverture d'une fenêtre de gestion des animaux {@code typeAnimal}.
	 * 
	 * @param typeAnimal - Type de l'animal.
	 * @category Slot-Signal
	 */
	public void slotGestionAnimaux(FlagsTypesAnimaux typeAnimal)
	{
		if(typeAnimal == FlagsTypesAnimaux.Familier)
		{
			this.signalGererFamiliers.emit();
		}
		else
		{
			this.signalGererMontures.emit();
		}
	}

	/**
	 * Demande l'équipement du Dofus {@code sauvegarde}.
	 * 
	 * @param typeDofus - Type du Dofus.
	 * @param sauvegarde - Sauvgarde du Dofus.
	 * @category Slot-Signal
	 */
	public void slotEquipeDofus(FlagsTypesDofus typeDofus, Object sauvegarde)
	{
		this.signalEquiperDofus.emit(typeDofus, (SauvegardeDofus) sauvegarde);
	}

	/**
	 * Demande l'ouverture d'une fenêtre de gestion de l'équipement {@code typeEquipement}.
	 * 
	 * @param typeEquipement - Type de l'équipement.
	 * @category Slot-Signal
	 */
	public void slotGestionEquipement(FlagsTypesEquipements typeEquipement)
	{
		this.signalGererEquipement.emit(typeEquipement);
	}

	/**
	 * Demande l'ouverture d'une fenêtre de gestion du Dofus {@code typeDofus}.
	 * 
	 * @param typeDofus - Type du Dofus.
	 * @category Slot-Signal
	 */
	public void slotGestionDofus(FlagsTypesDofus typeDofus)
	{
		this.signalGererDofus.emit(typeDofus);
	}
	
	/*
	 * Slots du composant
	 */
	
	/**
	 * Demande le retrait de l'équipement équipé.
	 * 
	 * @param typeEquipement - Type de l'équipement.
	 * @category Slot
	 */
	public void slotAfficheNoms()
	{
		this.afficherNomsObjets(!this.nomsObjetsAffiches);
		this.afficherRes(!this.nomsObjetsAffiches);
		this.nomsObjetsAffiches = !this.nomsObjetsAffiches;
	}
}