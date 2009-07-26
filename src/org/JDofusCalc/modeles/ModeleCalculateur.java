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

package org.JDofusCalc.modeles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import org.JDofusCalc.dofus.autres.Classe;
import org.JDofusCalc.dofus.autres.Degats;
import org.JDofusCalc.dofus.autres.DegatsArme;
import org.JDofusCalc.dofus.autres.Effets;
import org.JDofusCalc.dofus.autres.Formules;
import org.JDofusCalc.dofus.autres.Sort;
import org.JDofusCalc.dofus.autres.Degats.FlagsTypesDegats;
import org.JDofusCalc.dofus.autres.Effets.FlagsTypesEffets;
import org.JDofusCalc.dofus.autres.Formules.TauxPunition;
import org.JDofusCalc.dofus.autres.Sort.NatureSortsFlags;
import org.JDofusCalc.dofus.conditions.Condition;
import org.JDofusCalc.dofus.conditions.ConditionAlignement;
import org.JDofusCalc.dofus.conditions.ConditionCaracteristique;
import org.JDofusCalc.dofus.conditions.ConditionClasse;
import org.JDofusCalc.dofus.conditions.ConditionGrade;
import org.JDofusCalc.dofus.conditions.ConditionSexe;
import org.JDofusCalc.dofus.conditions.ConditionAlignement.Alignement;
import org.JDofusCalc.dofus.conditions.ConditionSexe.Sexe;
import org.JDofusCalc.dofus.objets.Panoplie;
import org.JDofusCalc.dofus.objets.Arme.FlagsTypesArmes;
import org.JDofusCalc.dofus.objets.Dofus.FlagsTypesDofus;
import org.JDofusCalc.dofus.objets.Equipement.FlagsTypesEquipements;
import org.JDofusCalc.dofus.sauvegardes.GroupeObjets;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeAnimal;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeArme;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeDofus;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeEquipement;
import org.JDofusCalc.dofus.sauvegardes.SauvegardePersonnage;
import org.JDofusCalc.observateurs.ObservateurCalculateur;

/**
 * Modèle chargé d'effectuer tous les calculs de statistiques et de simulations.
 * 
 * @author PAPAYA Alexandre
 * @category Modele
 * @version 1.0
 */
public class ModeleCalculateur extends Modele
{
	/*
	 * Constantes
	 */
	
	/**
	 * Constante du mode PvM.
	 */
	public final static int MODE_PVM = 0x01;

	/**
	 * Constante du mode PvP.
	 */
	public final static int MODE_PVP = 0x02;
	
	/*
	 * Variables d'instances
	 */
	
	/**
	 * Classes de dofus.
	 */
	private HashMap<Integer, Classe> classes;
	
	/**
	 * Classe selectionnée.
	 */
	private Classe classe;

	/**
	 * Statistiques globales.
	 */
	private Effets statistiquesGlobales;

	/**
	 * Statistiques apportées par l'équipement.
	 */
	private Effets statistiquesEquipement;

	/**
	 * Statistiques apportées par les dofus.
	 */
	private Effets statistiquesDofus;

	/**
	 * Statistiques apportées par les boost.
	 */
	private Effets statistiquesBoost;

	/**
	 * Résistances de la simulation.
	 */
	private Effets resistances;

	/**
	 * Sauvegarde du personnage.
	 */
	private SauvegardePersonnage sauvegardePersonnage;
	/**
	 * Liste des sauvegardes des équipements endossés.
	 */
	private HashMap<FlagsTypesEquipements, SauvegardeEquipement> sauvegardesEquipement;
	/**
	 * Liste des sauvegardes des Dofus équipés.
	 */
	private HashMap<FlagsTypesDofus, SauvegardeDofus> sauvegardesDofus;
	/**
	 * Sauvegarde de l'arme équipée.
	 */
	private SauvegardeArme sauvegardeArme;
	/**
	 * Sauvegarde de l'animal équipé.
	 */
	private SauvegardeAnimal sauvegardeAnimal;

	/**
	 * Mode de calcul des statistiques.
	 */
	private int mode = ModeleCalculateur.MODE_PVM;

	/**
	 * Données de la dernière simulation.
	 */
	private HashMap<String, Object> donneesDerniereSimulation;

	/**
	 * Liste des panoplies de Dofus chargé par le {@link ModeleDofus}.
	 */
	private HashMap<Integer, Panoplie> listePanoplies;

	/**
	 * Liste des classes de Dofus chargé par le {@link ModeleDofus}.
	 */
	private HashMap<Integer, Classe> listeClasses;

	/*
	 * Constructeurs / Destructeur
	 */

	/**
	 * Construit un nouveau modèle de calcul.
	 * 
	 * @category Constructeur
	 */
	public ModeleCalculateur(HashMap<Integer, Classe> classes)
	{
		super();
		
		this.classes = classes;

		this.sauvegardePersonnage = new SauvegardePersonnage("Nouvelle Sauvegarde");
		this.sauvegardesEquipement = new HashMap<FlagsTypesEquipements, SauvegardeEquipement>();
		this.sauvegardesEquipement.put(FlagsTypesEquipements.Amulette, null);
		this.sauvegardesEquipement.put(FlagsTypesEquipements.AnneauD, null);
		this.sauvegardesEquipement.put(FlagsTypesEquipements.AnneauG, null);
		this.sauvegardesEquipement.put(FlagsTypesEquipements.Bottes, null);
		this.sauvegardesEquipement.put(FlagsTypesEquipements.Bouclier, null);
		this.sauvegardesEquipement.put(FlagsTypesEquipements.Cape, null);
		this.sauvegardesEquipement.put(FlagsTypesEquipements.Ceinture, null);
		this.sauvegardesEquipement.put(FlagsTypesEquipements.Coiffe, null);
		this.sauvegardesDofus = new HashMap<FlagsTypesDofus, SauvegardeDofus>();
		this.sauvegardesDofus.put(FlagsTypesDofus.Cawotte, null);
		this.sauvegardesDofus.put(FlagsTypesDofus.Dofawa, null);
		this.sauvegardesDofus.put(FlagsTypesDofus.Emeraude, null);
		this.sauvegardesDofus.put(FlagsTypesDofus.Kaliptus, null);
		this.sauvegardesDofus.put(FlagsTypesDofus.Ocre, null);
		this.sauvegardesDofus.put(FlagsTypesDofus.Pourpre, null);
		this.sauvegardesDofus.put(FlagsTypesDofus.Turquoise, null);
		this.sauvegardesDofus.put(FlagsTypesDofus.Vulbis, null);
		this.statistiquesGlobales = new Effets();
		this.statistiquesEquipement = new Effets();
		this.statistiquesDofus = new Effets();
		this.statistiquesBoost = new Effets();
		this.resistances = new Effets();
		this.donneesDerniereSimulation = new HashMap<String, Object>();
	}

	/*
	 * Méthode de mise à jour du modèle
	 */

	/**
	 * Calcule l'agilité.
	 */
	public void updateAgilite()
	{
		FlagsTypesEffets effet = FlagsTypesEffets.Agilite;

		int valeur = 0;
		// Agilite de base du personnage
		valeur += this.sauvegardePersonnage.getAgilite();
		// Bonus équipement
		valeur += this.statistiquesEquipement.getInt(effet);

		this.statistiquesGlobales.setInt(effet, valeur);
		
		// Logger
		logger.trace("Mise à jour de l'effet " + effet.getNom() + " des statistiques globales par " + valeur + ".");

		// Lancement de l'evenement
		ObservateurCalculateur[] observateurs = (ObservateurCalculateur[]) this.listeObservateurs.getListeners(ObservateurCalculateur.class);
		for(ObservateurCalculateur observateur : observateurs)
		{
			observateur.changementStatistique(effet, valeur);
		}
	}

	/**
	 * Met à jour toutes les statistiques.
	 */
	public void updateAll()
	{
		this.updateVie();
		this.updatePa();
		this.updatePm();
		this.updatePo();
		this.updateProspection();
		this.updateVitalite();
		this.updateSagesse();
		this.updateForce();
		this.updateIntelligence();
		this.updateChance();
		this.updateAgilite();
		this.updateInitiative();
		this.updateDommages();
		this.updatePourcentageDommages();
		this.updatePieges();
		this.updatePourcentagePieges();
		this.updateCoupsCritiques();
		this.updateEchecsCritiques();
		this.updateRenvois();
		this.updateSoins();
		this.updateInvocations();
		this.updateResistanceMagique();
		this.updateResistancePhysique();
		this.updateResistanceNeutre();
		this.updateResistanceTerre();
		this.updateResistanceFeu();
		this.updateResistanceEau();
		this.updateResistanceAir();
		this.updatePourcentageResistanceNeutre();
		this.updatePourcentageResistanceTerre();
		this.updatePourcentageResistanceFeu();
		this.updatePourcentageResistanceEau();
		this.updatePourcentageResistanceAir();
	}

	/**
	 * Calcule la chance.
	 */
	public void updateChance()
	{
		FlagsTypesEffets effet = FlagsTypesEffets.Chance;

		int valeur = 0;
		// Chance de base du personnage
		valeur += this.sauvegardePersonnage.getChance();
		// Bonus équipement
		valeur += this.statistiquesEquipement.getInt(effet);

		this.statistiquesGlobales.setInt(effet, valeur);
		
		// Logger
		logger.trace("Mise à jour de l'effet " + effet.getNom() + " des statistiques globales par " + valeur + ".");

		// Lancement de l'evenement
		ObservateurCalculateur[] observateurs = (ObservateurCalculateur[]) this.listeObservateurs.getListeners(ObservateurCalculateur.class);
		for(ObservateurCalculateur observateur : observateurs)
		{
			observateur.changementStatistique(effet, valeur);
		}

		this.updateProspection();
	}

	/**
	 * Calcule les bonus aux coups critiques.
	 */
	public void updateCoupsCritiques()
	{
		FlagsTypesEffets effet = FlagsTypesEffets.CoupsCritiques;

		int valeur = 0;
		// Bonus équipement
		valeur += this.statistiquesEquipement.getInt(effet);

		this.statistiquesGlobales.setInt(effet, valeur);
		
		// Logger
		logger.trace("Mise à jour de l'effet " + effet.getNom() + " des statistiques globales par " + valeur + ".");

		// Lancement de l'evenement
		ObservateurCalculateur[] observateurs = (ObservateurCalculateur[]) this.listeObservateurs.getListeners(ObservateurCalculateur.class);
		for(ObservateurCalculateur observateur : observateurs)
		{
			observateur.changementStatistique(effet, valeur);
		}
	}

	/**
	 * Calcule les dégats du corps à corps équipé.
	 * 
	 * @param maitrise - Passez {@code true} pour prendre en compte la maîtrise correspondante.
	 * @param ccMaitrise - Passez {@code true} pour prendre en compte le coup critique de la maîtrise correspondante.
	 */
	public void updateDegatsCaCSimulation(boolean maitrise, boolean ccMaitrise)
	{
		// Logger
		logger.trace("Simulation du corps à corps. Maitrise = " + maitrise + ",  CC Maitrise = " + ccMaitrise + ".");

		HashMap<String, String> retour = new HashMap<String, String>();

		int force;
		int intelligence;
		int chance;
		int agi;
		int dommages;
		int pourcentDommages;
		int soins;
		int cc;
		// Si boost activés
		if(this.statistiquesBoost != null)
		{
			force = this.statistiquesGlobales.getInt(FlagsTypesEffets.Force) + this.statistiquesBoost.getInt(FlagsTypesEffets.Force);
			intelligence = this.statistiquesGlobales.getInt(FlagsTypesEffets.Intelligence) + this.statistiquesBoost.getInt(FlagsTypesEffets.Intelligence);
			chance = this.statistiquesGlobales.getInt(FlagsTypesEffets.Chance) + this.statistiquesBoost.getInt(FlagsTypesEffets.Chance);
			agi = this.statistiquesGlobales.getInt(FlagsTypesEffets.Agilite) + this.statistiquesBoost.getInt(FlagsTypesEffets.Agilite);
			soins = this.statistiquesGlobales.getInt(FlagsTypesEffets.Soins) + this.statistiquesBoost.getInt(FlagsTypesEffets.Soins);
			dommages = this.statistiquesGlobales.getInt(FlagsTypesEffets.Dommages) + this.statistiquesBoost.getInt(FlagsTypesEffets.Dommages);
			pourcentDommages = this.statistiquesGlobales.getInt(FlagsTypesEffets.PourcentagesDommages) + this.statistiquesBoost.getInt(FlagsTypesEffets.PourcentagesDommages);
			cc = this.statistiquesGlobales.getInt(FlagsTypesEffets.CoupsCritiques) + this.statistiquesBoost.getInt(FlagsTypesEffets.CoupsCritiques);
		}
		else
		{
			force = this.statistiquesGlobales.getInt(FlagsTypesEffets.Force);
			intelligence = this.statistiquesGlobales.getInt(FlagsTypesEffets.Intelligence);
			chance = this.statistiquesGlobales.getInt(FlagsTypesEffets.Chance);
			agi = this.statistiquesGlobales.getInt(FlagsTypesEffets.Agilite);
			soins = this.statistiquesGlobales.getInt(FlagsTypesEffets.Soins);
			dommages = this.statistiquesGlobales.getInt(FlagsTypesEffets.Dommages);
			pourcentDommages = this.statistiquesGlobales.getInt(FlagsTypesEffets.PourcentagesDommages);
			cc = this.statistiquesGlobales.getInt(FlagsTypesEffets.CoupsCritiques);
		}

		int resistanceNeutre = 0;
		int pourcentageResistanceNeutre = 0;
		int resistanceTerre = 0;
		int pourcentageResistanceTerre = 0;
		int resistanceFeu = 0;
		int pourcentageResistanceFeu = 0;
		int resistanceEau = 0;
		int pourcentageResistanceEau = 0;
		int resistanceAir = 0;
		int pourcentageResistanceAir = 0;
		// Si résistances activées
		if(this.resistances != null)
		{
			resistanceNeutre = this.resistances.getInt(FlagsTypesEffets.ResistancesNeutre) + this.resistances.getInt(FlagsTypesEffets.ResistancesPhysiques);
			resistanceTerre = this.resistances.getInt(FlagsTypesEffets.ResistancesTerre) + this.resistances.getInt(FlagsTypesEffets.ResistancesPhysiques);
			resistanceFeu = this.resistances.getInt(FlagsTypesEffets.ResistancesFeu) + this.resistances.getInt(FlagsTypesEffets.ResistancesMagiques);
			resistanceEau = this.resistances.getInt(FlagsTypesEffets.ResistancesEau) + this.resistances.getInt(FlagsTypesEffets.ResistancesMagiques);
			resistanceAir = this.resistances.getInt(FlagsTypesEffets.ResistancesAir) + this.resistances.getInt(FlagsTypesEffets.ResistancesMagiques);

			pourcentageResistanceNeutre = this.resistances.getInt(FlagsTypesEffets.PourcentagesResistancesNeutre);
			pourcentageResistanceTerre = this.resistances.getInt(FlagsTypesEffets.PourcentagesResistancesTerre);
			pourcentageResistanceFeu = this.resistances.getInt(FlagsTypesEffets.PourcentagesResistancesFeu);
			pourcentageResistanceEau = this.resistances.getInt(FlagsTypesEffets.PourcentagesResistancesEau);
			pourcentageResistanceAir = this.resistances.getInt(FlagsTypesEffets.PourcentagesResistancesAir);
		}

		int degatsNeutreMin = 0;
		int degatsVoleNeutreMin = 0;
		int voleNeutreMin = 0;
		int degatsNeutreMax = 0;
		int degatsVoleNeutreMax = 0;
		int voleNeutreMax = 0;

		int degatsTerreMin = 0;
		int degatsVoleTerreMin = 0;
		int voleTerreMin = 0;
		int degatsTerreMax = 0;
		int degatsVoleTerreMax = 0;
		int voleTerreMax = 0;

		int degatsFeuMin = 0;
		int degatsVoleFeuMin = 0;
		int voleFeuMin = 0;
		int degatsFeuMax = 0;
		int degatsVoleFeuMax = 0;
		int voleFeuMax = 0;

		int degatsEauMin = 0;
		int degatsVoleEauMin = 0;
		int voleEauMin = 0;
		int degatsEauMax = 0;
		int degatsVoleEauMax = 0;
		int voleEauMax = 0;

		int degatsAirMin = 0;
		int degatsVoleAirMin = 0;
		int voleAirMin = 0;
		int degatsAirMax = 0;
		int degatsVoleAirMax = 0;
		int voleAirMax = 0;

		int totalVoleMin = 0;
		int totalVoleMax = 0;

		int soinsMin = 0;
		int soinsMax = 0;

		int degatsNeutreMinCC = 0;
		int degatsVoleNeutreMinCC = 0;
		int voleNeutreMinCC = 0;
		int degatsNeutreMaxCC = 0;
		int degatsVoleNeutreMaxCC = 0;
		int voleNeutreMaxCC = 0;

		int degatsTerreMinCC = 0;
		int degatsVoleTerreMinCC = 0;
		int voleTerreMinCC = 0;
		int degatsTerreMaxCC = 0;
		int degatsVoleTerreMaxCC = 0;
		int voleTerreMaxCC = 0;

		int degatsFeuMinCC = 0;
		int degatsVoleFeuMinCC = 0;
		int voleFeuMinCC = 0;
		int degatsFeuMaxCC = 0;
		int degatsVoleFeuMaxCC = 0;
		int voleFeuMaxCC = 0;

		int degatsEauMinCC = 0;
		int degatsVoleEauMinCC = 0;
		int voleEauMinCC = 0;
		int degatsEauMaxCC = 0;
		int degatsVoleEauMaxCC = 0;
		int voleEauMaxCC = 0;

		int degatsAirMinCC = 0;
		int degatsVoleAirMinCC = 0;
		int voleAirMinCC = 0;
		int degatsAirMaxCC = 0;
		int degatsVoleAirMaxCC = 0;
		int voleAirMaxCC = 0;

		int totalVoleMinCC = 0;
		int totalVoleMaxCC = 0;

		int soinsMinCC = 0;
		int soinsMaxCC = 0;

		FlagsTypesArmes typeArmeChargee = this.sauvegardeArme.getType();
		int malusClasse = 0;
		if(this.classe.getArmePrincipale() == typeArmeChargee)
		{
			malusClasse = 100;
		}
		else if(this.classe.getArmeSecondaire() == typeArmeChargee)
		{
			malusClasse = 95;
		}
		else
		{
			malusClasse = 90;
		}

		FlagsTypesArmes typeArme = this.sauvegardeArme.getType();
		int niveauMaitrise = 0;
		if(typeArme == FlagsTypesArmes.Arc)
		{
			niveauMaitrise = this.sauvegardePersonnage.getMaitrise(FlagsTypesArmes.Arc);
		}
		else if(typeArme == FlagsTypesArmes.Baguette)
		{
			niveauMaitrise = this.sauvegardePersonnage.getMaitrise(FlagsTypesArmes.Baguette);
		}
		else if(typeArme == FlagsTypesArmes.Baton)
		{
			niveauMaitrise = this.sauvegardePersonnage.getMaitrise(FlagsTypesArmes.Baton);
		}
		else if(typeArme == FlagsTypesArmes.Dague)
		{
			niveauMaitrise = this.sauvegardePersonnage.getMaitrise(FlagsTypesArmes.Dague);
		}
		else if(typeArme == FlagsTypesArmes.Epee)
		{
			niveauMaitrise = this.sauvegardePersonnage.getMaitrise(FlagsTypesArmes.Epee);
		}
		else if(typeArme == FlagsTypesArmes.Hache)
		{
			niveauMaitrise = this.sauvegardePersonnage.getMaitrise(FlagsTypesArmes.Hache);
		}
		else if(typeArme == FlagsTypesArmes.Marteau)
		{
			niveauMaitrise = this.sauvegardePersonnage.getMaitrise(FlagsTypesArmes.Marteau);
		}
		else if(typeArme == FlagsTypesArmes.Pelle)
		{
			niveauMaitrise = this.sauvegardePersonnage.getMaitrise(FlagsTypesArmes.Pelle);
		}

		// Si pas de maitrise activé
		if(!maitrise)
		{
			niveauMaitrise = 0;
		}

		for(int i = 1; i <= 5; i++)
		{
			DegatsArme degats = this.sauvegardeArme.getDegats(i);

			if(degats != null)
			{
				degatsNeutreMin += Formules.getDegatsArme(degats.get(FlagsTypesDegats.DegatsNeutreMin), force, niveauMaitrise, ccMaitrise, malusClasse, pourcentDommages, (dommages + this.statistiquesBoost.getInt(FlagsTypesEffets.DommagesPhysiques)), pourcentageResistanceNeutre, resistanceNeutre);
				degatsVoleNeutreMin += Formules.getDegatsArme(degats.get(FlagsTypesDegats.VoleNeutreMin), force, niveauMaitrise, ccMaitrise, malusClasse, pourcentDommages, (dommages + this.statistiquesBoost.getInt(FlagsTypesEffets.DommagesPhysiques)), pourcentageResistanceNeutre, resistanceNeutre);
				voleNeutreMin += (int) Math.floor((double) degatsVoleNeutreMin / (double) 2);
				degatsNeutreMax += Formules.getDegatsArme(degats.get(FlagsTypesDegats.DegatsNeutreMax), force, niveauMaitrise, ccMaitrise, malusClasse, pourcentDommages, (dommages + this.statistiquesBoost.getInt(FlagsTypesEffets.DommagesPhysiques)), pourcentageResistanceNeutre, resistanceNeutre);
				degatsVoleNeutreMax += Formules.getDegatsArme(degats.get(FlagsTypesDegats.VoleNeutreMax), force, niveauMaitrise, ccMaitrise, malusClasse, pourcentDommages, (dommages + this.statistiquesBoost.getInt(FlagsTypesEffets.DommagesPhysiques)), pourcentageResistanceNeutre, resistanceNeutre);
				voleNeutreMax += (int) Math.floor((double) degatsVoleNeutreMax / (double) 2);

				degatsTerreMin += Formules.getDegatsArme(degats.get(FlagsTypesDegats.DegatsTerreMin), force, niveauMaitrise, ccMaitrise, malusClasse, pourcentDommages, dommages, pourcentageResistanceTerre, resistanceTerre);
				degatsVoleTerreMin += Formules.getDegatsArme(degats.get(FlagsTypesDegats.VoleTerreMin), force, niveauMaitrise, ccMaitrise, malusClasse, pourcentDommages, dommages, pourcentageResistanceTerre, resistanceTerre);
				voleTerreMin += (int) Math.floor((double) degatsVoleTerreMin / (double) 2);
				degatsTerreMax += Formules.getDegatsArme(degats.get(FlagsTypesDegats.DegatsTerreMax), force, niveauMaitrise, ccMaitrise, malusClasse, pourcentDommages, dommages, pourcentageResistanceTerre, resistanceTerre);
				degatsVoleTerreMax += Formules.getDegatsArme(degats.get(FlagsTypesDegats.VoleTerreMax), force, niveauMaitrise, ccMaitrise, malusClasse, pourcentDommages, dommages, pourcentageResistanceTerre, resistanceTerre);
				voleTerreMax += (int) Math.floor((double) degatsVoleTerreMax / (double) 2);

				degatsFeuMin += Formules.getDegatsArme(degats.get(FlagsTypesDegats.DegatsFeuMin), intelligence, niveauMaitrise, ccMaitrise, malusClasse, pourcentDommages, dommages, pourcentageResistanceFeu, resistanceFeu);
				degatsVoleFeuMin += Formules.getDegatsArme(degats.get(FlagsTypesDegats.VoleFeuMin), intelligence, niveauMaitrise, ccMaitrise, malusClasse, pourcentDommages, dommages, pourcentageResistanceFeu, resistanceFeu);
				voleFeuMin += (int) Math.floor((double) degatsVoleFeuMin / (double) 2);
				degatsFeuMax += Formules.getDegatsArme(degats.get(FlagsTypesDegats.DegatsFeuMax), intelligence, niveauMaitrise, ccMaitrise, malusClasse, pourcentDommages, dommages, pourcentageResistanceFeu, resistanceFeu);
				degatsVoleFeuMax += Formules.getDegatsArme(degats.get(FlagsTypesDegats.VoleFeuMax), intelligence, niveauMaitrise, ccMaitrise, malusClasse, pourcentDommages, dommages, pourcentageResistanceFeu, resistanceFeu);
				voleFeuMax += (int) Math.floor((double) degatsVoleFeuMax / (double) 2);

				degatsEauMin += Formules.getDegatsArme(degats.get(FlagsTypesDegats.DegatsEauMin), chance, niveauMaitrise, ccMaitrise, malusClasse, pourcentDommages, dommages, pourcentageResistanceEau, resistanceEau);
				degatsVoleEauMin += Formules.getDegatsArme(degats.get(FlagsTypesDegats.VoleEauMin), chance, niveauMaitrise, ccMaitrise, malusClasse, pourcentDommages, dommages, pourcentageResistanceEau, resistanceEau);
				voleEauMin += (int) Math.floor((double) degatsVoleEauMin / (double) 2);
				degatsEauMax += Formules.getDegatsArme(degats.get(FlagsTypesDegats.DegatsEauMax), chance, niveauMaitrise, ccMaitrise, malusClasse, pourcentDommages, dommages, pourcentageResistanceEau, resistanceEau);
				degatsVoleEauMax += Formules.getDegatsArme(degats.get(FlagsTypesDegats.VoleEauMax), chance, niveauMaitrise, ccMaitrise, malusClasse, pourcentDommages, dommages, pourcentageResistanceEau, resistanceEau);
				voleEauMax += (int) Math.floor((double) degatsVoleEauMax / (double) 2);

				degatsAirMin += Formules.getDegatsArme(degats.get(FlagsTypesDegats.DegatsAirMin), agi, niveauMaitrise, ccMaitrise, malusClasse, pourcentDommages, dommages, pourcentageResistanceAir, resistanceAir);
				degatsVoleAirMin += Formules.getDegatsArme(degats.get(FlagsTypesDegats.VoleAirMin), agi, niveauMaitrise, ccMaitrise, malusClasse, pourcentDommages, dommages, pourcentageResistanceAir, resistanceAir);
				voleAirMin += (int) Math.floor((double) degatsVoleAirMin / (double) 2);
				degatsAirMax += Formules.getDegatsArme(degats.get(FlagsTypesDegats.DegatsAirMax), agi, niveauMaitrise, ccMaitrise, malusClasse, pourcentDommages, dommages, pourcentageResistanceAir, resistanceAir);
				degatsVoleAirMax += Formules.getDegatsArme(degats.get(FlagsTypesDegats.VoleAirMax), agi, niveauMaitrise, ccMaitrise, malusClasse, pourcentDommages, dommages, pourcentageResistanceAir, resistanceAir);
				voleAirMax += (int) Math.floor((double) degatsVoleAirMax / (double) 2);

				totalVoleMin += voleNeutreMin + voleTerreMin + voleFeuMin + voleEauMin + voleAirMin;
				totalVoleMax += voleNeutreMax + voleTerreMax + voleFeuMax + voleEauMax + voleAirMax;

				soinsMin += Formules.getSoins(degats.get(FlagsTypesDegats.SoinsMin), intelligence, soins);
				soinsMax += Formules.getSoins(degats.get(FlagsTypesDegats.SoinsMax), intelligence, soins);

				int bonucCoupCritique = this.sauvegardeArme.getDommagesCoupsCritiques();
				degatsNeutreMinCC += Formules.getDegatsArme(degats.get(FlagsTypesDegats.DegatsNeutreMin), bonucCoupCritique, force, niveauMaitrise, ccMaitrise, malusClasse, pourcentDommages, (dommages + this.statistiquesBoost.getInt(FlagsTypesEffets.DommagesPhysiques)), pourcentageResistanceNeutre, resistanceNeutre);
				degatsVoleNeutreMinCC += Formules.getDegatsArme(degats.get(FlagsTypesDegats.VoleNeutreMin), bonucCoupCritique, force, niveauMaitrise, ccMaitrise, malusClasse, pourcentDommages, (dommages + this.statistiquesBoost.getInt(FlagsTypesEffets.DommagesPhysiques)), pourcentageResistanceNeutre, resistanceNeutre);
				voleNeutreMinCC += (int) Math.floor((double) degatsVoleNeutreMin / (double) 2);
				degatsNeutreMaxCC += Formules.getDegatsArme(degats.get(FlagsTypesDegats.DegatsNeutreMax), bonucCoupCritique, force, niveauMaitrise, ccMaitrise, malusClasse, pourcentDommages, (dommages + this.statistiquesBoost.getInt(FlagsTypesEffets.DommagesPhysiques)), pourcentageResistanceNeutre, resistanceNeutre);
				degatsVoleNeutreMaxCC += Formules.getDegatsArme(degats.get(FlagsTypesDegats.VoleNeutreMax), bonucCoupCritique, force, niveauMaitrise, ccMaitrise, malusClasse, pourcentDommages, (dommages + this.statistiquesBoost.getInt(FlagsTypesEffets.DommagesPhysiques)), pourcentageResistanceNeutre, resistanceNeutre);
				voleNeutreMaxCC += (int) Math.floor((double) degatsVoleNeutreMax / (double) 2);

				degatsTerreMinCC += Formules.getDegatsArme(degats.get(FlagsTypesDegats.DegatsTerreMin), bonucCoupCritique, force, niveauMaitrise, ccMaitrise, malusClasse, pourcentDommages, dommages, pourcentageResistanceTerre, resistanceTerre);
				degatsVoleTerreMinCC += Formules.getDegatsArme(degats.get(FlagsTypesDegats.VoleTerreMin), bonucCoupCritique, force, niveauMaitrise, ccMaitrise, malusClasse, pourcentDommages, dommages, pourcentageResistanceTerre, resistanceTerre);
				voleTerreMinCC += (int) Math.floor((double) degatsVoleTerreMin / (double) 2);
				degatsTerreMaxCC += Formules.getDegatsArme(degats.get(FlagsTypesDegats.DegatsTerreMax), bonucCoupCritique, force, niveauMaitrise, ccMaitrise, malusClasse, pourcentDommages, dommages, pourcentageResistanceTerre, resistanceTerre);
				degatsVoleTerreMaxCC += Formules.getDegatsArme(degats.get(FlagsTypesDegats.VoleTerreMax), bonucCoupCritique, force, niveauMaitrise, ccMaitrise, malusClasse, pourcentDommages, dommages, pourcentageResistanceTerre, resistanceTerre);
				voleTerreMaxCC += (int) Math.floor((double) degatsVoleTerreMax / (double) 2);

				degatsFeuMinCC += Formules.getDegatsArme(degats.get(FlagsTypesDegats.DegatsFeuMin), bonucCoupCritique, intelligence, niveauMaitrise, ccMaitrise, malusClasse, pourcentDommages, dommages, pourcentageResistanceFeu, resistanceFeu);
				degatsVoleFeuMinCC += Formules.getDegatsArme(degats.get(FlagsTypesDegats.VoleFeuMin), bonucCoupCritique, intelligence, niveauMaitrise, ccMaitrise, malusClasse, pourcentDommages, dommages, pourcentageResistanceFeu, resistanceFeu);
				voleFeuMinCC += (int) Math.floor((double) degatsVoleFeuMin / (double) 2);
				degatsFeuMaxCC += Formules.getDegatsArme(degats.get(FlagsTypesDegats.DegatsFeuMax), bonucCoupCritique, intelligence, niveauMaitrise, ccMaitrise, malusClasse, pourcentDommages, dommages, pourcentageResistanceFeu, resistanceFeu);
				degatsVoleFeuMaxCC += Formules.getDegatsArme(degats.get(FlagsTypesDegats.VoleFeuMax), bonucCoupCritique, intelligence, niveauMaitrise, ccMaitrise, malusClasse, pourcentDommages, dommages, pourcentageResistanceFeu, resistanceFeu);
				voleFeuMaxCC += (int) Math.floor((double) degatsVoleFeuMax / (double) 2);

				degatsEauMinCC += Formules.getDegatsArme(degats.get(FlagsTypesDegats.DegatsEauMin), bonucCoupCritique, chance, niveauMaitrise, ccMaitrise, malusClasse, pourcentDommages, dommages, pourcentageResistanceEau, resistanceEau);
				degatsVoleEauMinCC += Formules.getDegatsArme(degats.get(FlagsTypesDegats.VoleEauMin), bonucCoupCritique, chance, niveauMaitrise, ccMaitrise, malusClasse, pourcentDommages, dommages, pourcentageResistanceEau, resistanceEau);
				voleEauMinCC += (int) Math.floor((double) degatsVoleEauMin / (double) 2);
				degatsEauMaxCC += Formules.getDegatsArme(degats.get(FlagsTypesDegats.DegatsEauMax), bonucCoupCritique, chance, niveauMaitrise, ccMaitrise, malusClasse, pourcentDommages, dommages, pourcentageResistanceEau, resistanceEau);
				degatsVoleEauMaxCC += Formules.getDegatsArme(degats.get(FlagsTypesDegats.VoleEauMax), bonucCoupCritique, chance, niveauMaitrise, ccMaitrise, malusClasse, pourcentDommages, dommages, pourcentageResistanceEau, resistanceEau);
				voleEauMaxCC += (int) Math.floor((double) degatsVoleEauMax / (double) 2);

				degatsAirMinCC += Formules.getDegatsArme(degats.get(FlagsTypesDegats.DegatsAirMin), bonucCoupCritique, agi, niveauMaitrise, ccMaitrise, malusClasse, pourcentDommages, dommages, pourcentageResistanceAir, resistanceAir);
				degatsVoleAirMinCC += Formules.getDegatsArme(degats.get(FlagsTypesDegats.VoleAirMin), bonucCoupCritique, agi, niveauMaitrise, ccMaitrise, malusClasse, pourcentDommages, dommages, pourcentageResistanceAir, resistanceAir);
				voleAirMinCC += (int) Math.floor((double) degatsVoleAirMin / (double) 2);
				degatsAirMaxCC += Formules.getDegatsArme(degats.get(FlagsTypesDegats.DegatsAirMax), bonucCoupCritique, agi, niveauMaitrise, ccMaitrise, malusClasse, pourcentDommages, dommages, pourcentageResistanceAir, resistanceAir);
				degatsVoleAirMaxCC += Formules.getDegatsArme(degats.get(FlagsTypesDegats.VoleAirMax), bonucCoupCritique, agi, niveauMaitrise, ccMaitrise, malusClasse, pourcentDommages, dommages, pourcentageResistanceAir, resistanceAir);
				voleAirMaxCC += (int) Math.floor((double) degatsVoleAirMax / (double) 2);

				totalVoleMinCC += voleNeutreMin + voleTerreMin + voleFeuMin + voleEauMin + voleAirMin;
				totalVoleMaxCC += voleNeutreMax + voleTerreMax + voleFeuMax + voleEauMax + voleAirMax;

				soinsMinCC += Formules.getSoins(degats.get(FlagsTypesDegats.SoinsMin), bonucCoupCritique, intelligence, soins);
				soinsMaxCC += Formules.getSoins(degats.get(FlagsTypesDegats.SoinsMax), bonucCoupCritique, intelligence, soins);
			}
		}

		retour.put("Neutre Minimum", String.valueOf(degatsNeutreMin + degatsVoleNeutreMin));
		retour.put("Neutre Maximum", String.valueOf(degatsNeutreMax + degatsVoleNeutreMax));
		retour.put("Terre Minimum", String.valueOf(degatsTerreMin + degatsVoleTerreMin));
		retour.put("Terre Maximum", String.valueOf(degatsTerreMax + degatsVoleTerreMax));
		retour.put("Feu Minimum", String.valueOf(degatsFeuMin + degatsVoleFeuMin));
		retour.put("Feu Maximum", String.valueOf(degatsFeuMax + degatsVoleFeuMax));
		retour.put("Eau Minimum", String.valueOf(degatsEauMin + degatsVoleEauMin));
		retour.put("Eau Maximum", String.valueOf(degatsEauMax + degatsVoleEauMax));
		retour.put("Air Minimum", String.valueOf(degatsAirMin + degatsVoleAirMin));
		retour.put("Air Maximum", String.valueOf(degatsAirMax + degatsVoleAirMax));
		retour.put("Vole Minimum", String.valueOf(totalVoleMin));
		retour.put("Vole Maximum", String.valueOf(totalVoleMax));
		retour.put("Soins Minimum", String.valueOf(soinsMin));
		retour.put("Soins Maximum", String.valueOf(soinsMax));
		retour.put("Neutre Minimum CC", String.valueOf(degatsNeutreMinCC + degatsVoleNeutreMinCC));
		retour.put("Neutre Maximum CC", String.valueOf(degatsNeutreMaxCC + degatsVoleNeutreMaxCC));
		retour.put("Terre Minimum CC", String.valueOf(degatsTerreMinCC + degatsVoleTerreMinCC));
		retour.put("Terre Maximum CC", String.valueOf(degatsTerreMaxCC + degatsVoleTerreMaxCC));
		retour.put("Feu Minimum CC", String.valueOf(degatsFeuMinCC + degatsVoleFeuMinCC));
		retour.put("Feu Maximum CC", String.valueOf(degatsFeuMaxCC + degatsVoleFeuMaxCC));
		retour.put("Eau Minimum CC", String.valueOf(degatsEauMinCC + degatsVoleEauMinCC));
		retour.put("Eau Maximum CC", String.valueOf(degatsEauMaxCC + degatsVoleEauMaxCC));
		retour.put("Air Minimum CC", String.valueOf(degatsAirMinCC + degatsVoleAirMinCC));
		retour.put("Air Maximum CC", String.valueOf(degatsAirMaxCC + degatsVoleAirMaxCC));
		retour.put("Vole Minimum CC", String.valueOf(totalVoleMinCC));
		retour.put("Vole Maximum CC", String.valueOf(totalVoleMaxCC));
		retour.put("Soins Minimum CC", String.valueOf(soinsMinCC));
		retour.put("Soins Maximum CC", String.valueOf(soinsMaxCC));

		retour.put("PA", String.valueOf(this.sauvegardeArme.getCoutUtilisation()));
		int probaCc = this.sauvegardeArme.getCoupsCritiques();
		if(probaCc != 0)
		{
			retour.put("CC", "1/" + String.valueOf(Formules.getCoupsCritiques(probaCc, agi, cc)));
			retour.put("Dégâts CC", String.valueOf(this.sauvegardeArme.getDommagesCoupsCritiques()));
		}
		else
		{
			retour.put("CC", "-");
		}
		int ec = this.sauvegardeArme.getEchecsCritiques();
		if(ec != 0)
		{
			retour.put("EC", "1/" + String.valueOf(ec - this.statistiquesGlobales.getInt(FlagsTypesEffets.EchecsCritiques)));
		}
		else
		{
			retour.put("EC", "-");
		}
		
		this.donneesDerniereSimulation.put("Type", "CaC");
		this.donneesDerniereSimulation.put("Dégâts", retour);

		this.donneesDerniereSimulation.put("Arme", this.sauvegardeArme);
		this.donneesDerniereSimulation.put("Maitrise", maitrise);
		this.donneesDerniereSimulation.put("Coup Critique Maitrise", ccMaitrise);

		// Lancement de l'evenement
		ObservateurCalculateur[] observateurs = (ObservateurCalculateur[]) this.listeObservateurs.getListeners(ObservateurCalculateur.class);
		for(ObservateurCalculateur observateur : observateurs)
		{
			observateur.changementSimulation(retour);
		}
	}

	/**
	 * Calcule les dégats du sort {@code sort}.
	 * 
	 * @param sort - Sort à simuler.
	 * @param niveau - Niveau du sort.
	 */
	public void updateDegatsSortSimulation(Sort sort, int niveau)
	{
		// Logger
		logger.trace("Simulation du sort " + sort.getNom() + " niveau " + niveau + ".");
		
		HashMap<String, String> retour = new HashMap<String, String>();
		
		int force;
		int intelligence;
		int chance;
		int agi;
		int dommages;
		int pourcentDommages;
		int soins;
		int cc;
		// Si boost activés
		if(this.statistiquesBoost != null)
		{
			force = this.statistiquesGlobales.getInt(FlagsTypesEffets.Force) + this.statistiquesBoost.getInt(FlagsTypesEffets.Force);
			intelligence = this.statistiquesGlobales.getInt(FlagsTypesEffets.Intelligence) + this.statistiquesBoost.getInt(FlagsTypesEffets.Intelligence);
			chance = this.statistiquesGlobales.getInt(FlagsTypesEffets.Chance) + this.statistiquesBoost.getInt(FlagsTypesEffets.Chance);
			agi = this.statistiquesGlobales.getInt(FlagsTypesEffets.Agilite) + this.statistiquesBoost.getInt(FlagsTypesEffets.Agilite);
			soins = this.statistiquesGlobales.getInt(FlagsTypesEffets.Soins) + this.statistiquesBoost.getInt(FlagsTypesEffets.Soins);
			dommages = this.statistiquesGlobales.getInt(FlagsTypesEffets.Dommages) + this.statistiquesBoost.getInt(FlagsTypesEffets.Dommages);
			pourcentDommages = this.statistiquesGlobales.getInt(FlagsTypesEffets.PourcentagesDommages) + this.statistiquesBoost.getInt(FlagsTypesEffets.PourcentagesDommages);
			cc = this.statistiquesGlobales.getInt(FlagsTypesEffets.CoupsCritiques) + this.statistiquesBoost.getInt(FlagsTypesEffets.CoupsCritiques);
		}
		else
		{
			force = this.statistiquesGlobales.getInt(FlagsTypesEffets.Force);
			intelligence = this.statistiquesGlobales.getInt(FlagsTypesEffets.Intelligence);
			chance = this.statistiquesGlobales.getInt(FlagsTypesEffets.Chance);
			agi = this.statistiquesGlobales.getInt(FlagsTypesEffets.Agilite);
			soins = this.statistiquesGlobales.getInt(FlagsTypesEffets.Soins);
			dommages = this.statistiquesGlobales.getInt(FlagsTypesEffets.Dommages);
			pourcentDommages = this.statistiquesGlobales.getInt(FlagsTypesEffets.PourcentagesDommages);
			cc = this.statistiquesGlobales.getInt(FlagsTypesEffets.CoupsCritiques);
		}
		
		// Si le sort est un piège
		if(sort.getNature() == Sort.NatureSortsFlags.Piege)
		{
			dommages = this.statistiquesGlobales.getInt(FlagsTypesEffets.DommagesPieges);
			pourcentDommages = this.statistiquesGlobales.getInt(FlagsTypesEffets.PourcentagesDommagesPieges);
		}

		int resistanceNeutre = 0;
		int pourcentageResistanceNeutre = 0;
		int resistanceTerre = 0;
		int pourcentageResistanceTerre = 0;
		int resistanceFeu = 0;
		int pourcentageResistanceFeu = 0;
		int resistanceEau = 0;
		int pourcentageResistanceEau = 0;
		int resistanceAir = 0;
		int pourcentageResistanceAir = 0;
		// Si résistances activées
		if(this.resistances != null)
		{
			resistanceNeutre = this.resistances.getInt(FlagsTypesEffets.ResistancesNeutre) + this.resistances.getInt(FlagsTypesEffets.ResistancesPhysiques);
			resistanceTerre = this.resistances.getInt(FlagsTypesEffets.ResistancesTerre) + this.resistances.getInt(FlagsTypesEffets.ResistancesPhysiques);
			resistanceFeu = this.resistances.getInt(FlagsTypesEffets.ResistancesFeu) + this.resistances.getInt(FlagsTypesEffets.ResistancesMagiques);
			resistanceEau = this.resistances.getInt(FlagsTypesEffets.ResistancesEau) + this.resistances.getInt(FlagsTypesEffets.ResistancesMagiques);
			resistanceAir = this.resistances.getInt(FlagsTypesEffets.ResistancesAir) + this.resistances.getInt(FlagsTypesEffets.ResistancesMagiques);

			pourcentageResistanceNeutre = this.resistances.getInt(FlagsTypesEffets.PourcentagesResistancesNeutre);
			pourcentageResistanceTerre = this.resistances.getInt(FlagsTypesEffets.PourcentagesResistancesTerre);
			pourcentageResistanceFeu = this.resistances.getInt(FlagsTypesEffets.PourcentagesResistancesFeu);
			pourcentageResistanceEau = this.resistances.getInt(FlagsTypesEffets.PourcentagesResistancesEau);
			pourcentageResistanceAir = this.resistances.getInt(FlagsTypesEffets.PourcentagesResistancesAir);
		}
		
		// Si c'est le sort punition
		if(sort.getNature() == NatureSortsFlags.Punition)
		{
			retour.put("Neutre Minimum", String.valueOf(Formules.getDegatsPunition(TauxPunition.CoupNormal.getValeur(), this.statistiquesGlobales.getInt(FlagsTypesEffets.Vie), this.statistiquesBoost.getInt(FlagsTypesEffets.Vie), pourcentageResistanceNeutre, resistanceNeutre)));
			retour.put("Neutre Maximum", "0");
			retour.put("Terre Minimum", "0");
			retour.put("Terre Maximum", "0");
			retour.put("Feu Minimum", "0");
			retour.put("Feu Maximum", "0");
			retour.put("Eau Minimum", "0");
			retour.put("Eau Maximum", "0");
			retour.put("Air Minimum", "0");
			retour.put("Air Maximum", "0");
			retour.put("Vole Minimum", "0");
			retour.put("Vole Maximum", "0");
			retour.put("Soins Minimum", "0");
			retour.put("Soins Maximum", "0");
			retour.put("Neutre Minimum CC", String.valueOf(Formules.getDegatsPunition(TauxPunition.CoupCritique.getValeur(), this.statistiquesGlobales.getInt(FlagsTypesEffets.Vie), this.statistiquesBoost.getInt(FlagsTypesEffets.Vie), pourcentageResistanceNeutre, resistanceNeutre)));
			retour.put("Neutre Maximum CC", "0");
			retour.put("Terre Minimum CC", "0");
			retour.put("Terre Maximum CC", "0");
			retour.put("Feu Minimum CC", "0");
			retour.put("Feu Maximum CC", "0");
			retour.put("Eau Minimum CC", "0");
			retour.put("Eau Maximum CC", "0");
			retour.put("Air Minimum CC", "0");
			retour.put("Air Maximum CC", "0");
			retour.put("Vole Minimum CC", "0");
			retour.put("Vole Maximum CC", "0");
			retour.put("Soins Minimum CC", "0");
			retour.put("Soins Maximum CC", "0");
		}
		else
		{	
			Degats degats = (Degats) sort.get(niveau, "Degats");
	
			int degatsNeutreMin = Formules.getDegatsSort(degats.get(FlagsTypesDegats.DegatsNeutreMin), force, pourcentDommages, (dommages + this.statistiquesBoost.getInt(FlagsTypesEffets.DommagesPhysiques)), pourcentageResistanceNeutre, resistanceNeutre);
			int degatsVoleNeutreMin = Formules.getDegatsSort(degats.get(FlagsTypesDegats.VoleNeutreMin), force, pourcentDommages, (dommages + this.statistiquesBoost.getInt(FlagsTypesEffets.DommagesPhysiques)), pourcentageResistanceNeutre, resistanceNeutre);
			int voleNeutreMin = (int) Math.floor((double) degatsVoleNeutreMin / (double) 2);
			int degatsNeutreMax = Formules.getDegatsSort(degats.get(FlagsTypesDegats.DegatsNeutreMax), force, pourcentDommages, (dommages + this.statistiquesBoost.getInt(FlagsTypesEffets.DommagesPhysiques)), pourcentageResistanceNeutre, resistanceNeutre);
			int degatsVoleNeutreMax = Formules.getDegatsSort(degats.get(FlagsTypesDegats.VoleNeutreMax), force, pourcentDommages, (dommages + this.statistiquesBoost.getInt(FlagsTypesEffets.DommagesPhysiques)), pourcentageResistanceNeutre, resistanceNeutre);
			int voleNeutreMax = (int) Math.floor((double) degatsVoleNeutreMax / (double) 2);
	
			int degatsTerreMin = Formules.getDegatsSort(degats.get(FlagsTypesDegats.DegatsTerreMin), force, pourcentDommages, dommages, pourcentageResistanceTerre, resistanceTerre);
			int degatsVoleTerreMin = Formules.getDegatsSort(degats.get(FlagsTypesDegats.VoleTerreMin), force, pourcentDommages, dommages, pourcentageResistanceTerre, resistanceTerre);
			int voleTerreMin = (int) Math.floor((double) degatsVoleTerreMin / (double) 2);
			int degatsTerreMax = Formules.getDegatsSort(degats.get(FlagsTypesDegats.DegatsTerreMax), force, pourcentDommages, dommages, pourcentageResistanceTerre, resistanceTerre);
			int degatsVoleTerreMax = Formules.getDegatsSort(degats.get(FlagsTypesDegats.VoleTerreMax), force, pourcentDommages, dommages, pourcentageResistanceTerre, resistanceTerre);
			int voleTerreMax = (int) Math.floor((double) degatsVoleTerreMax / (double) 2);
	
			int degatsFeuMin = Formules.getDegatsSort(degats.get(FlagsTypesDegats.DegatsFeuMin), intelligence, pourcentDommages, dommages, pourcentageResistanceFeu, resistanceFeu);
			int degatsVoleFeuMin = Formules.getDegatsSort(degats.get(FlagsTypesDegats.VoleFeuMin), intelligence, pourcentDommages, dommages, pourcentageResistanceFeu, resistanceFeu);
			int voleFeuMin = (int) Math.floor((double) degatsVoleFeuMin / (double) 2);
			int degatsFeuMax = Formules.getDegatsSort(degats.get(FlagsTypesDegats.DegatsFeuMax), intelligence, pourcentDommages, dommages, pourcentageResistanceFeu, resistanceFeu);
			int degatsVoleFeuMax = Formules.getDegatsSort(degats.get(FlagsTypesDegats.VoleFeuMax), intelligence, pourcentDommages, dommages, pourcentageResistanceFeu, resistanceFeu);
			int voleFeuMax = (int) Math.floor((double) degatsVoleFeuMax / (double) 2);
	
			int degatsEauMin = Formules.getDegatsSort(degats.get(FlagsTypesDegats.DegatsEauMin), chance, pourcentDommages, dommages, pourcentageResistanceEau, resistanceEau);
			int degatsVoleEauMin = Formules.getDegatsSort(degats.get(FlagsTypesDegats.VoleEauMin), chance, pourcentDommages, dommages, pourcentageResistanceEau, resistanceEau);
			int voleEauMin = (int) Math.floor((double) degatsVoleEauMin / (double) 2);
			int degatsEauMax = Formules.getDegatsSort(degats.get(FlagsTypesDegats.DegatsEauMax), chance, pourcentDommages, dommages, pourcentageResistanceEau, resistanceEau);
			int degatsVoleEauMax = Formules.getDegatsSort(degats.get(FlagsTypesDegats.VoleEauMax), chance, pourcentDommages, dommages, pourcentageResistanceEau, resistanceEau);
			int voleEauMax = (int) Math.floor((double) degatsVoleEauMax / (double) 2);
	
			int degatsAirMin = Formules.getDegatsSort(degats.get(FlagsTypesDegats.DegatsAirMin), agi, pourcentDommages, dommages, pourcentageResistanceAir, resistanceAir);
			int degatsVoleAirMin = Formules.getDegatsSort(degats.get(FlagsTypesDegats.VoleAirMin), agi, pourcentDommages, dommages, pourcentageResistanceAir, resistanceAir);
			int voleAirMin = (int) Math.floor((double) degatsVoleAirMin / (double) 2);
			int degatsAirMax = Formules.getDegatsSort(degats.get(FlagsTypesDegats.DegatsAirMax), agi, pourcentDommages, dommages, pourcentageResistanceAir, resistanceAir);
			int degatsVoleAirMax = Formules.getDegatsSort(degats.get(FlagsTypesDegats.VoleAirMax), agi, pourcentDommages, dommages, pourcentageResistanceAir, resistanceAir);
			int voleAirMax = (int) Math.floor((double) degatsVoleAirMax / (double) 2);
	
			int totalVoleMin = voleNeutreMin + voleTerreMin + voleFeuMin + voleEauMin + voleAirMin;
			int totalVoleMax = voleNeutreMax + voleTerreMax + voleFeuMax + voleEauMax + voleAirMax;
	
			int soinsMin = Formules.getSoins(degats.get(FlagsTypesDegats.SoinsMin), intelligence, soins);
			int soinsMax = Formules.getSoins(degats.get(FlagsTypesDegats.SoinsMax), intelligence, soins);
	
			retour.put("Neutre Minimum", String.valueOf(degatsNeutreMin + degatsVoleNeutreMin));
			retour.put("Neutre Maximum", String.valueOf(degatsNeutreMax + degatsVoleNeutreMax));
			retour.put("Terre Minimum", String.valueOf(degatsTerreMin + degatsVoleTerreMin));
			retour.put("Terre Maximum", String.valueOf(degatsTerreMax + degatsVoleTerreMax));
			retour.put("Feu Minimum", String.valueOf(degatsFeuMin + degatsVoleFeuMin));
			retour.put("Feu Maximum", String.valueOf(degatsFeuMax + degatsVoleFeuMax));
			retour.put("Eau Minimum", String.valueOf(degatsEauMin + degatsVoleEauMin));
			retour.put("Eau Maximum", String.valueOf(degatsEauMax + degatsVoleEauMax));
			retour.put("Air Minimum", String.valueOf(degatsAirMin + degatsVoleAirMin));
			retour.put("Air Maximum", String.valueOf(degatsAirMax + degatsVoleAirMax));
			retour.put("Vole Minimum", String.valueOf(totalVoleMin));
			retour.put("Vole Maximum", String.valueOf(totalVoleMax));
			retour.put("Soins Minimum", String.valueOf(soinsMin));
			retour.put("Soins Maximum", String.valueOf(soinsMax));
	
			Degats degatsCC = (Degats) sort.get(niveau, "DegatsCC");
			// Si le sort a un coup critique
			if(degatsCC != null)
			{
				int degatsNeutreMinCC = Formules.getDegatsSort(degatsCC.get(FlagsTypesDegats.DegatsNeutreMin), force, pourcentDommages, (dommages + this.statistiquesBoost.getInt(FlagsTypesEffets.DommagesPhysiques)), pourcentageResistanceNeutre, resistanceNeutre);
				int degatsVoleNeutreMinCC = Formules.getDegatsSort(degatsCC.get(FlagsTypesDegats.VoleNeutreMin), force, pourcentDommages, (dommages + this.statistiquesBoost.getInt(FlagsTypesEffets.DommagesPhysiques)), pourcentageResistanceNeutre, resistanceNeutre);
				int voleNeutreMinCC = (int) Math.floor((double) degatsVoleNeutreMinCC / (double) 2);
				int degatsNeutreMaxCC = Formules.getDegatsSort(degatsCC.get(FlagsTypesDegats.DegatsNeutreMax), force, pourcentDommages, (dommages + this.statistiquesBoost.getInt(FlagsTypesEffets.DommagesPhysiques)), pourcentageResistanceNeutre, resistanceNeutre);
				int degatsVoleNeutreMaxCC = Formules.getDegatsSort(degatsCC.get(FlagsTypesDegats.VoleNeutreMax), force, pourcentDommages, (dommages + this.statistiquesBoost.getInt(FlagsTypesEffets.DommagesPhysiques)), pourcentageResistanceNeutre, resistanceNeutre);
				int voleNeutreMaxCC = (int) Math.floor((double) degatsVoleNeutreMaxCC / (double) 2);
	
				int degatsTerreMinCC = Formules.getDegatsSort(degatsCC.get(FlagsTypesDegats.DegatsTerreMin), force, pourcentDommages, dommages, pourcentageResistanceTerre, resistanceTerre);
				int degatsVoleTerreMinCC = Formules.getDegatsSort(degatsCC.get(FlagsTypesDegats.VoleTerreMin), force, pourcentDommages, dommages, pourcentageResistanceTerre, resistanceTerre);
				int voleTerreMinCC = (int) Math.floor((double) degatsVoleTerreMinCC / (double) 2);
				int degatsTerreMaxCC = Formules.getDegatsSort(degatsCC.get(FlagsTypesDegats.DegatsTerreMax), force, pourcentDommages, dommages, pourcentageResistanceTerre, resistanceTerre);
				int degatsVoleTerreMaxCC = Formules.getDegatsSort(degatsCC.get(FlagsTypesDegats.VoleTerreMax), force, pourcentDommages, dommages, pourcentageResistanceTerre, resistanceTerre);
				int voleTerreMaxCC = (int) Math.floor((double) degatsVoleTerreMaxCC / (double) 2);
	
				int degatsFeuMinCC = Formules.getDegatsSort(degatsCC.get(FlagsTypesDegats.DegatsFeuMin), intelligence, pourcentDommages, dommages, pourcentageResistanceFeu, resistanceFeu);
				int degatsVoleFeuMinCC = Formules.getDegatsSort(degatsCC.get(FlagsTypesDegats.VoleFeuMin), intelligence, pourcentDommages, dommages, pourcentageResistanceFeu, resistanceFeu);
				int voleFeuMinCC = (int) Math.floor((double) degatsVoleFeuMinCC / (double) 2);
				int degatsFeuMaxCC = Formules.getDegatsSort(degatsCC.get(FlagsTypesDegats.DegatsFeuMax), intelligence, pourcentDommages, dommages, pourcentageResistanceFeu, resistanceFeu);
				int degatsVoleFeuMaxCC = Formules.getDegatsSort(degatsCC.get(FlagsTypesDegats.VoleFeuMax), intelligence, pourcentDommages, dommages, pourcentageResistanceFeu, resistanceFeu);
				int voleFeuMaxCC = (int) Math.floor((double) degatsVoleFeuMaxCC / (double) 2);
	
				int degatsEauMinCC = Formules.getDegatsSort(degatsCC.get(FlagsTypesDegats.DegatsEauMin), chance, pourcentDommages, dommages, pourcentageResistanceEau, resistanceEau);
				int degatsVoleEauMinCC = Formules.getDegatsSort(degatsCC.get(FlagsTypesDegats.VoleEauMin), chance, pourcentDommages, dommages, pourcentageResistanceEau, resistanceEau);
				int voleEauMinCC = (int) Math.floor((double) degatsVoleEauMinCC / (double) 2);
				int degatsEauMaxCC = Formules.getDegatsSort(degatsCC.get(FlagsTypesDegats.DegatsEauMax), chance, pourcentDommages, dommages, pourcentageResistanceEau, resistanceEau);
				int degatsVoleEauMaxCC = Formules.getDegatsSort(degatsCC.get(FlagsTypesDegats.VoleEauMax), chance, pourcentDommages, dommages, pourcentageResistanceEau, resistanceEau);
				int voleEauMaxCC = (int) Math.floor((double) degatsVoleEauMaxCC / (double) 2);
	
				int degatsAirMinCC = Formules.getDegatsSort(degatsCC.get(FlagsTypesDegats.DegatsAirMin), agi, pourcentDommages, dommages, pourcentageResistanceAir, resistanceAir);
				int degatsVoleAirMinCC = Formules.getDegatsSort(degatsCC.get(FlagsTypesDegats.VoleAirMin), agi, pourcentDommages, dommages, pourcentageResistanceAir, resistanceAir);
				int voleAirMinCC = (int) Math.floor((double) degatsVoleAirMinCC / (double) 2);
				int degatsAirMaxCC = Formules.getDegatsSort(degatsCC.get(FlagsTypesDegats.DegatsAirMax), agi, pourcentDommages, dommages, pourcentageResistanceAir, resistanceAir);
				int degatsVoleAirMaxCC = Formules.getDegatsSort(degatsCC.get(FlagsTypesDegats.VoleAirMax), agi, pourcentDommages, dommages, pourcentageResistanceAir, resistanceAir);
				int voleAirMaxCC = (int) Math.floor((double) degatsVoleAirMaxCC / (double) 2);
	
				int totalVoleMinCC = voleNeutreMinCC + voleTerreMinCC + voleFeuMinCC + voleEauMinCC + voleAirMinCC;
				int totalVoleMaxCC = voleNeutreMaxCC + voleTerreMaxCC + voleFeuMaxCC + voleEauMaxCC + voleAirMaxCC;
	
				int soinsMinCC = Formules.getSoins(degatsCC.get(FlagsTypesDegats.SoinsMin), intelligence, soins);
				int soinsMaxCC = Formules.getSoins(degatsCC.get(FlagsTypesDegats.SoinsMax), intelligence, soins);
	
				retour.put("Neutre Minimum CC", String.valueOf(degatsNeutreMinCC + degatsVoleNeutreMinCC));
				retour.put("Neutre Maximum CC", String.valueOf(degatsNeutreMaxCC + degatsVoleNeutreMaxCC));
				retour.put("Terre Minimum CC", String.valueOf(degatsTerreMinCC + degatsVoleTerreMinCC));
				retour.put("Terre Maximum CC", String.valueOf(degatsTerreMaxCC + degatsVoleTerreMaxCC));
				retour.put("Feu Minimum CC", String.valueOf(degatsFeuMinCC + degatsVoleFeuMinCC));
				retour.put("Feu Maximum CC", String.valueOf(degatsFeuMaxCC + degatsVoleFeuMaxCC));
				retour.put("Eau Minimum CC", String.valueOf(degatsEauMinCC + degatsVoleEauMinCC));
				retour.put("Eau Maximum CC", String.valueOf(degatsEauMaxCC + degatsVoleEauMaxCC));
				retour.put("Air Minimum CC", String.valueOf(degatsAirMinCC + degatsVoleAirMinCC));
				retour.put("Air Maximum CC", String.valueOf(degatsAirMaxCC + degatsVoleAirMaxCC));
				retour.put("Vole Minimum CC", String.valueOf(totalVoleMinCC));
				retour.put("Vole Maximum CC", String.valueOf(totalVoleMaxCC));
				retour.put("Soins Minimum CC", String.valueOf(soinsMinCC));
				retour.put("Soins Maximum CC", String.valueOf(soinsMaxCC));
			}
			else
			{
				retour.put("Neutre Minimum CC", "-");
				retour.put("Neutre Maximum CC", "-");
				retour.put("Terre Minimum CC", "-");
				retour.put("Terre Maximum CC", "-");
				retour.put("Feu Minimum CC", "-");
				retour.put("Feu Maximum CC", "-");
				retour.put("Eau Minimum CC", "-");
				retour.put("Eau Maximum CC", "-");
				retour.put("Air Minimum CC", "-");
				retour.put("Air Maximum CC", "-");
				retour.put("Vole Minimum CC", "-");
				retour.put("Vole Maximum CC", "-");
				retour.put("Soins Minimum CC", "-");
				retour.put("Soins Maximum CC", "-");
			}
		}

		retour.put("PA", String.valueOf(sort.get(niveau, "PA")));
		int probaCc = Integer.parseInt((String) sort.get(niveau, "CC"));
		if(probaCc != 0)
		{
			retour.put("CC", "1/" + String.valueOf(Formules.getCoupsCritiques(probaCc, agi, cc)));
		}
		else
		{
			retour.put("CC", "-");
		}
		int ec = Integer.parseInt((String) sort.get(niveau, "EC"));
		if(ec != 0)
		{
			retour.put("EC", "1/" + String.valueOf(ec - this.statistiquesGlobales.getInt(FlagsTypesEffets.EchecsCritiques)));
		}
		else
		{
			retour.put("EC", "-");
		}
		retour.put("Dégâts CC", "-");
		retour.put("Nom Sort", sort.getNom());

		this.donneesDerniereSimulation.put("Type", "Sort");
		this.donneesDerniereSimulation.put("Dégâts", retour);

		this.donneesDerniereSimulation.put("Sort", sort);
		this.donneesDerniereSimulation.put("Niveau", niveau);

		// Lancement de l'evenement
		ObservateurCalculateur[] observateurs = (ObservateurCalculateur[]) this.listeObservateurs.getListeners(ObservateurCalculateur.class);
		for(ObservateurCalculateur observateur : observateurs)
		{
			observateur.changementSimulation(retour);
		}
	}

	/**
	 * Calcule les dommages.
	 */
	public void updateDommages()
	{
		FlagsTypesEffets effet = FlagsTypesEffets.Dommages;

		int valeur = 0;
		// Bonus équipement
		valeur += this.statistiquesEquipement.getInt(effet);

		this.statistiquesGlobales.setInt(effet, valeur);
		
		// Logger
		logger.trace("Mise à jour de l'effet " + effet.getNom() + " des statistiques globales par " + valeur + ".");

		// Lancement de l'evenement
		ObservateurCalculateur[] observateurs = (ObservateurCalculateur[]) this.listeObservateurs.getListeners(ObservateurCalculateur.class);
		for(ObservateurCalculateur observateur : observateurs)
		{
			observateur.changementStatistique(effet, valeur);
		}
	}

	/**
	 * Calcule les malus aux échecs critiques.
	 */
	public void updateEchecsCritiques()
	{
		FlagsTypesEffets effet = FlagsTypesEffets.EchecsCritiques;

		int valeur = 0;
		// Malus équipement
		valeur += this.statistiquesEquipement.getInt(effet);

		this.statistiquesGlobales.setInt(effet, valeur);
		
		// Logger
		logger.trace("Mise à jour de l'effet " + effet.getNom() + " des statistiques globales par " + valeur + ".");

		// Lancement de l'evenement
		ObservateurCalculateur[] observateurs = (ObservateurCalculateur[]) this.listeObservateurs.getListeners(ObservateurCalculateur.class);
		for(ObservateurCalculateur observateur : observateurs)
		{
			observateur.changementStatistique(effet, valeur);
		}
	}

	/**
	 * Vérifie et met à jour les erreurs des conditions pour porter certains objets.
	 */
	public void updateErreursConditions()
	{
		// Logger
		logger.trace("Mise à jour des erreurs d'endossage des équipements.");
		
		ObservateurCalculateur[] observateurs = (ObservateurCalculateur[]) this.listeObservateurs.getListeners(ObservateurCalculateur.class);

		// Equipements
		for(Entry<FlagsTypesEquipements, SauvegardeEquipement> entry : this.sauvegardesEquipement.entrySet())
		{
			SauvegardeEquipement sauvegarde = this.sauvegardesEquipement.get(entry.getKey());
			String erreursConditions = null;
			if(sauvegarde != null)
			{
				erreursConditions = this.verifierConditions(sauvegarde.getConditions(), sauvegarde.getNiveau());
			}

			for(ObservateurCalculateur observateur : observateurs)
			{
				observateur.changementEquipement(entry.getKey(), sauvegarde, erreursConditions);
			}
		}
		// Dofus
		for(FlagsTypesDofus flag : FlagsTypesDofus.values())
		{
			SauvegardeDofus sauvegarde = this.sauvegardesDofus.get(flag);
			String erreursConditions = null;
			if(sauvegarde != null)
			{
				erreursConditions = this.verifierConditions(null, sauvegarde.getNiveau());
			}

			for(ObservateurCalculateur observateur : observateurs)
			{
				observateur.changementDofus(flag, sauvegarde, erreursConditions, this.statistiquesDofus);
			}
		}
		// Arme
		String erreursConditionsArme = null;
		if(this.sauvegardeArme != null)
		{
			erreursConditionsArme = this.verifierConditions(this.sauvegardeArme.getConditions(), this.sauvegardeArme.getNiveau());
		}
		for(ObservateurCalculateur observateur : observateurs)
		{
			observateur.changementArme(this.sauvegardeArme, erreursConditionsArme);
		}
		// Animal
		String erreursConditionsAnimal = null;
		if(this.sauvegardeAnimal != null)
		{
			erreursConditionsAnimal = this.verifierConditions(null, this.sauvegardeAnimal.getNiveau());
		}
		for(ObservateurCalculateur observateur : observateurs)
		{
			observateur.changementAnimal(this.sauvegardeAnimal, erreursConditionsAnimal);
		}
	}

	/**
	 * Calcule la probabilité d'esquive aux pertes de PA.
	 */
	public void updateEsquivePA()
	{
		FlagsTypesEffets effet = FlagsTypesEffets.EsquivePa;
		
		int valeur = Formules.getEsquives(this.statistiquesGlobales.getInt(FlagsTypesEffets.Sagesse));

		// Logger
		logger.trace("Mise à jour de l'effet " + effet.getNom() + " des statistiques globales par " + valeur + ".");
		
		// Lancement de l'evenement
		ObservateurCalculateur[] observateurs = (ObservateurCalculateur[]) this.listeObservateurs.getListeners(ObservateurCalculateur.class);
		for(ObservateurCalculateur observateur : observateurs)
		{
			observateur.changementStatistique(effet, valeur);
		}
	}

	/**
	 * Calcule la probabilité d'esquive aux pertes de PM.
	 */
	public void updateEsquivePM()
	{
		FlagsTypesEffets effet = FlagsTypesEffets.EsquivePm;
		
		int valeur = Formules.getEsquives(this.statistiquesGlobales.getInt(FlagsTypesEffets.Sagesse));

		// Logger
		logger.trace("Mise à jour de l'effet " + effet.getNom() + " des statistiques globales par " + valeur + ".");
		
		// Lancement de l'evenement
		ObservateurCalculateur[] observateurs = (ObservateurCalculateur[]) this.listeObservateurs.getListeners(ObservateurCalculateur.class);
		for(ObservateurCalculateur observateur : observateurs)
		{
			observateur.changementStatistique(effet, valeur);
		}
	}

	/**
	 * Calcule la force.
	 */
	public void updateForce()
	{
		FlagsTypesEffets effet = FlagsTypesEffets.Force;

		int valeur = 0;
		// Force de base du personnage
		valeur += this.sauvegardePersonnage.getForce();
		// Bonus équipement
		valeur += this.statistiquesEquipement.getInt(effet);

		this.statistiquesGlobales.setInt(effet, valeur);
		
		// Logger
		logger.trace("Mise à jour de l'effet " + effet.getNom() + " des statistiques globales par " + valeur + ".");

		// Lancement de l'evenement
		ObservateurCalculateur[] observateurs = (ObservateurCalculateur[]) this.listeObservateurs.getListeners(ObservateurCalculateur.class);
		for(ObservateurCalculateur observateur : observateurs)
		{
			observateur.changementStatistique(effet, valeur);
		}
	}

	/**
	 * Calcule l'initiative.
	 */
	public void updateInitiative()
	{
		FlagsTypesEffets effet = FlagsTypesEffets.Initiative;

		int bonus = 0;
		// Initiative de base de la classe
		bonus += this.classe.getBaseIni();
		// Bonus d'alignement
		int niveauAlignement = this.sauvegardePersonnage.getNiveauAlignement();
		int alignement = this.sauvegardePersonnage.getAlignement();
		// Si mercenaire
		if(alignement == 3)
		{
			// Bonus du niveau 20/39
			if((niveauAlignement >= 20) && (niveauAlignement < 40))
			{
				bonus += 50;
			}
			// Bonus du niveau 40/59
			if((niveauAlignement >= 40) && (niveauAlignement < 60))
			{
				bonus += 100;
			}
			// Bonus du niveau 60/79
			else if((niveauAlignement >= 60) && (niveauAlignement < 80))
			{
				bonus += 150;
			}
			// Bonus du niveau 80/99
			else if((niveauAlignement >= 80) && (niveauAlignement < 100))
			{
				bonus += 200;
			}
			// Bonus du niveau 100
			else if(niveauAlignement == 100)
			{
				bonus += 250;
			}
		}
		// Bonus équipement
		bonus += this.statistiquesEquipement.getInt(effet);

		// Calcule de l'initiative
		boolean sacrieur = false;
		if(this.classe.getNom().equals("Sacrieur"))
			sacrieur = true;
		
		int valeur = Formules.getInitiative(this.statistiquesGlobales.getInt(FlagsTypesEffets.Vie), this.sauvegardePersonnage.getVitalite(), bonus, sacrieur);

		this.statistiquesGlobales.setInt(effet, valeur);
		
		// Logger
		logger.trace("Mise à jour de l'effet " + effet.getNom() + " des statistiques globales par " + valeur + ".");

		// Lancement de l'evenement
		ObservateurCalculateur[] observateurs = (ObservateurCalculateur[]) this.listeObservateurs.getListeners(ObservateurCalculateur.class);
		for(ObservateurCalculateur observateur : observateurs)
		{
			observateur.changementStatistique(effet, valeur);
		}
	}

	/**
	 * Calcule l'intelligence.
	 */
	public void updateIntelligence()
	{
		FlagsTypesEffets effet = FlagsTypesEffets.Intelligence;

		int valeur = 0;
		// Intelligence de base du personnage
		valeur += this.sauvegardePersonnage.getIntelligence();
		// Bonus équipement
		valeur += this.statistiquesEquipement.getInt(effet);

		this.statistiquesGlobales.setInt(effet, valeur);
		
		// Logger
		logger.trace("Mise à jour de l'effet " + effet.getNom() + " des statistiques globales par " + valeur + ".");

		// Lancement de l'evenement
		ObservateurCalculateur[] observateurs = (ObservateurCalculateur[]) this.listeObservateurs.getListeners(ObservateurCalculateur.class);
		for(ObservateurCalculateur observateur : observateurs)
		{
			observateur.changementStatistique(effet, valeur);
		}
	}

	/**
	 * Calcule le bonus aux invocations.
	 */
	public void updateInvocations()
	{
		FlagsTypesEffets effet = FlagsTypesEffets.CreaturesInvocables;

		int valeur = 1;
		// Bonus équipement
		valeur += this.statistiquesEquipement.getInt(effet);

		this.statistiquesGlobales.setInt(effet, valeur);
		
		// Logger
		logger.trace("Mise à jour de l'effet " + effet.getNom() + " des statistiques globales par " + valeur + ".");

		// Lancement de l'evenement
		ObservateurCalculateur[] observateurs = (ObservateurCalculateur[]) this.listeObservateurs.getListeners(ObservateurCalculateur.class);
		for(ObservateurCalculateur observateur : observateurs)
		{
			observateur.changementStatistique(effet, valeur);
		}
	}

	/**
	 * Calcule les Pa totals.
	 */
	public void updatePa()
	{
		FlagsTypesEffets effet = FlagsTypesEffets.Pa;

		int valeur = 0;
		// PA de base de la classe
		valeur += this.classe.getBasePA();
		if(this.sauvegardePersonnage.getNiveau() >= 100)
		{
			// Bonus du niveau 100
			valeur += 1;
		}
		// Bonus de l'équipement
		valeur += this.statistiquesEquipement.getInt(effet);

		// Majoration à 0
		if(valeur < 0)
		{
			valeur = 0;
		}

		this.statistiquesGlobales.setInt(effet, valeur);
		
		// Logger
		logger.trace("Mise à jour de l'effet " + effet.getNom() + " des statistiques globales par " + valeur + ".");

		// Lancement de l'evenement
		ObservateurCalculateur[] observateurs = (ObservateurCalculateur[]) this.listeObservateurs.getListeners(ObservateurCalculateur.class);
		for(ObservateurCalculateur observateur : observateurs)
		{
			observateur.changementStatistique(effet, valeur);
		}
	}

	/**
	 * Calcule les dommages aux pièges.
	 */
	public void updatePieges()
	{
		FlagsTypesEffets effet = FlagsTypesEffets.DommagesPieges;

		int valeur = 0;
		// Bonus équipement
		valeur += this.statistiquesEquipement.getInt(effet);

		this.statistiquesGlobales.setInt(effet, valeur);
		
		// Logger
		logger.trace("Mise à jour de l'effet " + effet.getNom() + " des statistiques globales par " + valeur + ".");

		// Lancement de l'evenement
		ObservateurCalculateur[] observateurs = (ObservateurCalculateur[]) this.listeObservateurs.getListeners(ObservateurCalculateur.class);
		for(ObservateurCalculateur observateur : observateurs)
		{
			observateur.changementStatistique(effet, valeur);
		}
	}

	/**
	 * Calcule les Pm totals.
	 */
	public void updatePm()
	{
		FlagsTypesEffets effet = FlagsTypesEffets.Pm;

		int valeur = 0;
		// PM de base de la classe
		valeur += this.classe.getBasePM();
		// Bonus de l'équipement
		valeur += this.statistiquesEquipement.getInt(effet);

		// Majoration à 0
		if(valeur < 0)
		{
			valeur = 0;
		}

		this.statistiquesGlobales.setInt(effet, valeur);
		
		// Logger
		logger.trace("Mise à jour de l'effet " + effet.getNom() + " des statistiques globales par " + valeur + ".");

		// Lancement de l'evenement
		ObservateurCalculateur[] observateurs = (ObservateurCalculateur[]) this.listeObservateurs.getListeners(ObservateurCalculateur.class);
		for(ObservateurCalculateur observateur : observateurs)
		{
			observateur.changementStatistique(effet, valeur);
		}
	}

	/**
	 * Calcule la Po totale.
	 */
	public void updatePo()
	{
		FlagsTypesEffets effet = FlagsTypesEffets.Po;

		int valeur = 0;
		// PO de base de la classe
		valeur += this.classe.getBasePO();
		// Bonus de l'équipement
		valeur += this.statistiquesEquipement.getInt(effet);

		// Majoration à 0
		if(valeur < 0)
		{
			valeur = 0;
		}

		this.statistiquesGlobales.setInt(effet, valeur);
		
		// Logger
		logger.trace("Mise à jour de l'effet " + effet.getNom() + " des statistiques globales par " + valeur + ".");

		// Lancement de l'evenement
		ObservateurCalculateur[] observateurs = (ObservateurCalculateur[]) this.listeObservateurs.getListeners(ObservateurCalculateur.class);
		for(ObservateurCalculateur observateur : observateurs)
		{
			observateur.changementStatistique(effet, valeur);
		}
	}

	/**
	 * Calcule les % de dommages.
	 */
	public void updatePourcentageDommages()
	{
		FlagsTypesEffets effet = FlagsTypesEffets.PourcentagesDommages;

		int valeur = 0;
		// Bonus équipement
		valeur += this.statistiquesEquipement.getInt(effet);

		this.statistiquesGlobales.setInt(effet, valeur);
		
		// Logger
		logger.trace("Mise à jour de l'effet " + effet.getNom() + " des statistiques globales par " + valeur + ".");

		// Lancement de l'evenement
		ObservateurCalculateur[] observateurs = (ObservateurCalculateur[]) this.listeObservateurs.getListeners(ObservateurCalculateur.class);
		for(ObservateurCalculateur observateur : observateurs)
		{
			observateur.changementStatistique(effet, valeur);
		}
	}

	/**
	 * Calcule les % de dommages aux pièges.
	 */
	public void updatePourcentagePieges()
	{
		FlagsTypesEffets effet = FlagsTypesEffets.PourcentagesDommagesPieges;

		int valeur = 0;
		// Bonus équipement
		valeur += this.statistiquesEquipement.getInt(effet);

		this.statistiquesGlobales.setInt(effet, valeur);
		
		// Logger
		logger.trace("Mise à jour de l'effet " + effet.getNom() + " des statistiques globales par " + valeur + ".");

		// Lancement de l'evenement
		ObservateurCalculateur[] observateurs = (ObservateurCalculateur[]) this.listeObservateurs.getListeners(ObservateurCalculateur.class);
		for(ObservateurCalculateur observateur : observateurs)
		{
			observateur.changementStatistique(effet, valeur);
		}
	}

	/**
	 * Calcule le % de resistance air.
	 */
	public void updatePourcentageResistanceAir()
	{
		FlagsTypesEffets effet = FlagsTypesEffets.PourcentagesResistancesAir;

		int valeur = 0;
		// Bonus équipement
		valeur += this.statistiquesEquipement.getInt(effet);
		// Bonus d'alignement
		int niveauAlignement = this.sauvegardePersonnage.getNiveauAlignement();
		int alignement = this.sauvegardePersonnage.getAlignement();
		// Si mercenaire
		if(alignement == 3)
		{
			// Bonus du niveau 20/39
			if((niveauAlignement >= 20) && (niveauAlignement < 40))
			{
				valeur += 1;
			}
			// Bonus du niveau 40/59
			if((niveauAlignement >= 40) && (niveauAlignement < 60))
			{
				valeur += 2;
			}
			// Bonus du niveau 60/79
			else if((niveauAlignement >= 60) && (niveauAlignement < 80))
			{
				valeur += 3;
			}
			// Bonus du niveau 80/99
			else if((niveauAlignement >= 80) && (niveauAlignement < 100))
			{
				valeur += 4;
			}
			// Bonus du niveau 100
			else if(niveauAlignement == 100)
			{
				valeur += 5;
			}
		}
		// Si le mode pvp est activé
		if(this.mode == 2)
		{
			valeur += this.statistiquesEquipement.getInt(FlagsTypesEffets.getEquivalentPvp(effet));
		}

		this.statistiquesGlobales.setInt(effet, valeur);
		
		// Logger
		logger.trace("Mise à jour de l'effet " + effet.getNom() + " des statistiques globales par " + valeur + ".");

		// Lancement de l'evenement
		ObservateurCalculateur[] observateurs = (ObservateurCalculateur[]) this.listeObservateurs.getListeners(ObservateurCalculateur.class);
		for(ObservateurCalculateur observateur : observateurs)
		{
			observateur.changementStatistique(effet, valeur);
		}
	}

	/**
	 * Calcule le % de resistance eau.
	 */
	public void updatePourcentageResistanceEau()
	{
		FlagsTypesEffets effet = FlagsTypesEffets.PourcentagesResistancesEau;

		int valeur = 0;
		// Bonus équipement
		valeur += this.statistiquesEquipement.getInt(effet);
		// Bonus d'alignement
		int niveauAlignement = this.sauvegardePersonnage.getNiveauAlignement();
		int alignement = this.sauvegardePersonnage.getAlignement();
		// Si mercenaire
		if(alignement == 3)
		{
			// Bonus du niveau 20/39
			if((niveauAlignement >= 20) && (niveauAlignement < 40))
			{
				valeur += 1;
			}
			// Bonus du niveau 40/59
			if((niveauAlignement >= 40) && (niveauAlignement < 60))
			{
				valeur += 2;
			}
			// Bonus du niveau 60/79
			else if((niveauAlignement >= 60) && (niveauAlignement < 80))
			{
				valeur += 3;
			}
			// Bonus du niveau 80/99
			else if((niveauAlignement >= 80) && (niveauAlignement < 100))
			{
				valeur += 4;
			}
			// Bonus du niveau 100
			else if(niveauAlignement == 100)
			{
				valeur += 5;
			}
		}
		// Si le mode pvp est activé
		if(this.mode == 2)
		{
			valeur += this.statistiquesEquipement.getInt(FlagsTypesEffets.getEquivalentPvp(effet));
		}

		this.statistiquesGlobales.setInt(effet, valeur);
		
		// Logger
		logger.trace("Mise à jour de l'effet " + effet.getNom() + " des statistiques globales par " + valeur + ".");

		// Lancement de l'evenement
		ObservateurCalculateur[] observateurs = (ObservateurCalculateur[]) this.listeObservateurs.getListeners(ObservateurCalculateur.class);
		for(ObservateurCalculateur observateur : observateurs)
		{
			observateur.changementStatistique(effet, valeur);
		}
	}

	/**
	 * Calcule le % de resistance feu.
	 */
	public void updatePourcentageResistanceFeu()
	{
		FlagsTypesEffets effet = FlagsTypesEffets.PourcentagesResistancesFeu;

		int valeur = 0;
		// Bonus équipement
		valeur += this.statistiquesEquipement.getInt(effet);
		// Bonus d'alignement
		int niveauAlignement = this.sauvegardePersonnage.getNiveauAlignement();
		int alignement = this.sauvegardePersonnage.getAlignement();
		// Si mercenaire
		if(alignement == 3)
		{
			// Bonus du niveau 20/39
			if((niveauAlignement >= 20) && (niveauAlignement < 40))
			{
				valeur += 1;
			}
			// Bonus du niveau 40/59
			if((niveauAlignement >= 40) && (niveauAlignement < 60))
			{
				valeur += 2;
			}
			// Bonus du niveau 60/79
			else if((niveauAlignement >= 60) && (niveauAlignement < 80))
			{
				valeur += 3;
			}
			// Bonus du niveau 80/99
			else if((niveauAlignement >= 80) && (niveauAlignement < 100))
			{
				valeur += 4;
			}
			// Bonus du niveau 100
			else if(niveauAlignement == 100)
			{
				valeur += 5;
			}
		}
		// Si le mode pvp est activé
		if(this.mode == 2)
		{
			valeur += this.statistiquesEquipement.getInt(FlagsTypesEffets.getEquivalentPvp(effet));
		}

		this.statistiquesGlobales.setInt(effet, valeur);
		
		// Logger
		logger.trace("Mise à jour de l'effet " + effet.getNom() + " des statistiques globales par " + valeur + ".");

		// Lancement de l'evenement
		ObservateurCalculateur[] observateurs = (ObservateurCalculateur[]) this.listeObservateurs.getListeners(ObservateurCalculateur.class);
		for(ObservateurCalculateur observateur : observateurs)
		{
			observateur.changementStatistique(effet, valeur);
		}
	}

	/**
	 * Calcule le % de resistance neutre.
	 */
	public void updatePourcentageResistanceNeutre()
	{
		FlagsTypesEffets effet = FlagsTypesEffets.PourcentagesResistancesNeutre;

		int valeur = 0;
		// Bonus équipement
		valeur += this.statistiquesEquipement.getInt(effet);
		// Si le mode pvp est activé
		if(this.mode == 2)
		{
			valeur += this.statistiquesEquipement.getInt(FlagsTypesEffets.getEquivalentPvp(effet));
		}

		this.statistiquesGlobales.setInt(effet, valeur);
		
		// Logger
		logger.trace("Mise à jour de l'effet " + effet.getNom() + " des statistiques globales par " + valeur + ".");

		// Lancement de l'evenement
		ObservateurCalculateur[] observateurs = (ObservateurCalculateur[]) this.listeObservateurs.getListeners(ObservateurCalculateur.class);
		for(ObservateurCalculateur observateur : observateurs)
		{
			observateur.changementStatistique(effet, valeur);
		}
	}

	/**
	 * Calcule le % de resistance terre.
	 */
	public void updatePourcentageResistanceTerre()
	{
		FlagsTypesEffets effet = FlagsTypesEffets.PourcentagesResistancesTerre;

		int valeur = 0;
		// Bonus équipement
		valeur += this.statistiquesEquipement.getInt(effet);
		// Bonus d'alignement
		int niveauAlignement = this.sauvegardePersonnage.getNiveauAlignement();
		int alignement = this.sauvegardePersonnage.getAlignement();
		// Si mercenaire
		if(alignement == 3)
		{
			// Bonus du niveau 20/39
			if((niveauAlignement >= 20) && (niveauAlignement < 40))
			{
				valeur += 1;
			}
			// Bonus du niveau 40/59
			if((niveauAlignement >= 40) && (niveauAlignement < 60))
			{
				valeur += 2;
			}
			// Bonus du niveau 60/79
			else if((niveauAlignement >= 60) && (niveauAlignement < 80))
			{
				valeur += 3;
			}
			// Bonus du niveau 80/99
			else if((niveauAlignement >= 80) && (niveauAlignement < 100))
			{
				valeur += 4;
			}
			// Bonus du niveau 100
			else if(niveauAlignement == 100)
			{
				valeur += 5;
			}
		}
		// Si le mode pvp est activé
		if(this.mode == 2)
		{
			valeur += this.statistiquesEquipement.getInt(FlagsTypesEffets.getEquivalentPvp(effet));
		}

		this.statistiquesGlobales.setInt(effet, valeur);
		
		// Logger
		logger.trace("Mise à jour de l'effet " + effet.getNom() + " des statistiques globales par " + valeur + ".");

		// Lancement de l'evenement
		ObservateurCalculateur[] observateurs = (ObservateurCalculateur[]) this.listeObservateurs.getListeners(ObservateurCalculateur.class);
		for(ObservateurCalculateur observateur : observateurs)
		{
			observateur.changementStatistique(effet, valeur);
		}
	}

	/**
	 * Calcule la prospection.
	 */
	public void updateProspection()
	{
		FlagsTypesEffets effet = FlagsTypesEffets.Prospection;

		int valeur = 0;
		// Prospection de base de la classe
		valeur += this.classe.getBasePP();
		// Prospection apporté par la chance
		valeur += Math.floor((double) this.statistiquesGlobales.getInt(FlagsTypesEffets.Chance) / (double) 10);
		// Bonus équipement
		valeur += this.statistiquesEquipement.getInt(effet);

		// Majoration à 0
		if(valeur < 0)
		{
			valeur = 0;
		}

		this.statistiquesGlobales.setInt(effet, valeur);
		
		// Logger
		logger.trace("Mise à jour de l'effet " + effet.getNom() + " des statistiques globales par " + valeur + ".");

		// Lancement de l'evenement
		ObservateurCalculateur[] observateurs = (ObservateurCalculateur[]) this.listeObservateurs.getListeners(ObservateurCalculateur.class);
		for(ObservateurCalculateur observateur : observateurs)
		{
			observateur.changementStatistique(effet, valeur);
		}
	}

	/**
	 * Calcule les bonus aux renvois.
	 */
	public void updateRenvois()
	{
		FlagsTypesEffets effet = FlagsTypesEffets.Renvois;

		int valeur = 0;
		// Malus équipement
		valeur += this.statistiquesEquipement.getInt(effet);

		this.statistiquesGlobales.setInt(effet, valeur);
		
		// Logger
		logger.trace("Mise à jour de l'effet " + effet.getNom() + " des statistiques globales par " + valeur + ".");

		// Lancement de l'evenement
		ObservateurCalculateur[] observateurs = (ObservateurCalculateur[]) this.listeObservateurs.getListeners(ObservateurCalculateur.class);
		for(ObservateurCalculateur observateur : observateurs)
		{
			observateur.changementStatistique(effet, valeur);
		}
	}

	/**
	 * Calcule la resistance fixe air.
	 */
	public void updateResistanceAir()
	{
		FlagsTypesEffets effet = FlagsTypesEffets.ResistancesAir;

		int valeur = 0;
		// Bonus Resistancesphysique
		valeur += this.statistiquesGlobales.getInt(FlagsTypesEffets.ResistancesMagiques);
		// Bonus équipement
		valeur += this.statistiquesEquipement.getInt(effet);
		// Si le mode pvp est activé
		if(this.mode == 2)
		{
			valeur += this.statistiquesEquipement.getInt(FlagsTypesEffets.getEquivalentPvp(effet));
		}

		this.statistiquesGlobales.setInt(effet, valeur);
		
		// Logger
		logger.trace("Mise à jour de l'effet " + effet.getNom() + " des statistiques globales par " + valeur + ".");

		// Lancement de l'evenement
		ObservateurCalculateur[] observateurs = (ObservateurCalculateur[]) this.listeObservateurs.getListeners(ObservateurCalculateur.class);
		for(ObservateurCalculateur observateur : observateurs)
		{
			observateur.changementStatistique(effet, valeur);
		}
	}

	/**
	 * Calcule la resistance fixe eau.
	 */
	public void updateResistanceEau()
	{
		FlagsTypesEffets effet = FlagsTypesEffets.ResistancesEau;

		int valeur = 0;
		// Bonus résistance physique
		valeur += this.statistiquesGlobales.getInt(FlagsTypesEffets.ResistancesMagiques);
		// Bonus équipement
		valeur += this.statistiquesEquipement.getInt(effet);
		// Si le mode pvp est activé
		if(this.mode == 2)
		{
			valeur += this.statistiquesEquipement.getInt(FlagsTypesEffets.getEquivalentPvp(effet));
		}

		this.statistiquesGlobales.setInt(effet, valeur);
		
		// Logger
		logger.trace("Mise à jour de l'effet " + effet.getNom() + " des statistiques globales par " + valeur + ".");

		// Lancement de l'evenement
		ObservateurCalculateur[] observateurs = (ObservateurCalculateur[]) this.listeObservateurs.getListeners(ObservateurCalculateur.class);
		for(ObservateurCalculateur observateur : observateurs)
		{
			observateur.changementStatistique(effet, valeur);
		}
	}

	/**
	 * Calcule la resistance fixe feu.
	 */
	public void updateResistanceFeu()
	{
		FlagsTypesEffets effet = FlagsTypesEffets.ResistancesFeu;

		int valeur = 0;
		// Bonus résistance physique
		valeur += this.statistiquesGlobales.getInt(FlagsTypesEffets.ResistancesMagiques);
		// Bonus équipement
		valeur += this.statistiquesEquipement.getInt(effet);
		// Si le mode pvp est activé
		if(this.mode == 2)
		{
			valeur += this.statistiquesEquipement.getInt(FlagsTypesEffets.getEquivalentPvp(effet));
		}

		this.statistiquesGlobales.setInt(effet, valeur);
		
		// Logger
		logger.trace("Mise à jour de l'effet " + effet.getNom() + " des statistiques globales par " + valeur + ".");

		// Lancement de l'evenement
		ObservateurCalculateur[] observateurs = (ObservateurCalculateur[]) this.listeObservateurs.getListeners(ObservateurCalculateur.class);
		for(ObservateurCalculateur observateur : observateurs)
		{
			observateur.changementStatistique(effet, valeur);
		}
	}

	/**
	 * Calcule la résistance magique.
	 */
	public void updateResistanceMagique()
	{
		FlagsTypesEffets effet = FlagsTypesEffets.ResistancesMagiques;

		int valeur = 0;
		// Bonus équipement
		valeur += this.statistiquesEquipement.getInt(effet);

		this.statistiquesGlobales.setInt(effet, valeur);
		
		// Logger
		logger.trace("Mise à jour de l'effet " + effet.getNom() + " des statistiques globales par " + valeur + ".");

		// Lancement de l'evenement
		ObservateurCalculateur[] observateurs = (ObservateurCalculateur[]) this.listeObservateurs.getListeners(ObservateurCalculateur.class);
		for(ObservateurCalculateur observateur : observateurs)
		{
			observateur.changementStatistique(effet, valeur);
		}

		this.updateResistanceFeu();
		this.updateResistanceEau();
		this.updateResistanceAir();
	}

	/**
	 * Calcule la resistance fixe neutre.
	 */
	public void updateResistanceNeutre()
	{
		FlagsTypesEffets effet = FlagsTypesEffets.ResistancesNeutre;

		int valeur = 0;
		// Bonus résistance physique
		valeur += this.statistiquesGlobales.getInt(FlagsTypesEffets.ResistancesPhysiques);
		// Bonus équipement
		valeur += this.statistiquesEquipement.getInt(effet);
		// Si le mode pvp est activé
		if(this.mode == 2)
		{
			valeur += this.statistiquesEquipement.getInt(FlagsTypesEffets.getEquivalentPvp(effet));
		}

		this.statistiquesGlobales.setInt(effet, valeur);
		
		// Logger
		logger.trace("Mise à jour de l'effet " + effet.getNom() + " des statistiques globales par " + valeur + ".");

		// Lancement de l'evenement
		ObservateurCalculateur[] observateurs = (ObservateurCalculateur[]) this.listeObservateurs.getListeners(ObservateurCalculateur.class);
		for(ObservateurCalculateur observateur : observateurs)
		{
			observateur.changementStatistique(effet, valeur);
		}
	}

	/**
	 * Calcule la Resistancesphysique.
	 */
	public void updateResistancePhysique()
	{
		FlagsTypesEffets effet = FlagsTypesEffets.ResistancesPhysiques;

		int valeur = 0;
		// Bonus équipement
		valeur += this.statistiquesEquipement.getInt(effet);

		this.statistiquesGlobales.setInt(effet, valeur);
		
		// Logger
		logger.trace("Mise à jour de l'effet " + effet.getNom() + " des statistiques globales par " + valeur + ".");

		// Lancement de l'evenement
		ObservateurCalculateur[] observateurs = (ObservateurCalculateur[]) this.listeObservateurs.getListeners(ObservateurCalculateur.class);
		for(ObservateurCalculateur observateur : observateurs)
		{
			observateur.changementStatistique(effet, valeur);
		}

		this.updateResistanceNeutre();
		this.updateResistanceTerre();
	}

	/**
	 * Calcule la resistance fixe terre.
	 */
	public void updateResistanceTerre()
	{
		FlagsTypesEffets effet = FlagsTypesEffets.ResistancesTerre;

		int valeur = 0;
		// Bonus résistance physique
		valeur += this.statistiquesGlobales.getInt(FlagsTypesEffets.ResistancesPhysiques);
		// Bonus équipement
		valeur += this.statistiquesEquipement.getInt(effet);
		// Si le mode pvp est activé
		if(this.mode == 2)
		{
			valeur += this.statistiquesEquipement.getInt(FlagsTypesEffets.getEquivalentPvp(effet));
		}

		this.statistiquesGlobales.setInt(effet, valeur);
		
		// Logger
		logger.trace("Mise à jour de l'effet " + effet.getNom() + " des statistiques globales par " + valeur + ".");

		// Lancement de l'evenement
		ObservateurCalculateur[] observateurs = (ObservateurCalculateur[]) this.listeObservateurs.getListeners(ObservateurCalculateur.class);
		for(ObservateurCalculateur observateur : observateurs)
		{
			observateur.changementStatistique(effet, valeur);
		}
	}

	/**
	 * Calcule la sagesse.
	 */
	public void updateSagesse()
	{
		FlagsTypesEffets effet = FlagsTypesEffets.Sagesse;

		int valeur = 0;
		// Sagesse de base du personnage
		valeur += this.sauvegardePersonnage.getSagesse();
		// Bonus équipement
		valeur += this.statistiquesEquipement.getInt(effet);

		this.statistiquesGlobales.setInt(effet, valeur);
		
		// Logger
		logger.trace("Mise à jour de l'effet " + effet.getNom() + " des statistiques globales par " + valeur + ".");

		// Lancement de l'evenement
		ObservateurCalculateur[] observateurs = (ObservateurCalculateur[]) this.listeObservateurs.getListeners(ObservateurCalculateur.class);
		for(ObservateurCalculateur observateur : observateurs)
		{
			observateur.changementStatistique(effet, valeur);
		}

		this.updateEsquivePA();
		this.updateEsquivePM();
	}

	/**
	 * Met à jour les données de la dernière simulation effectuée suite à des modifications des caractéristique par exemple.
	 */
	public void updateSimulation()
	{		
		String type = (String) this.donneesDerniereSimulation.get("Type");
		
		// Logger
		logger.trace("Mise à jour de la dernière simulation " + type + ".");

		// Si une simulation à été déjà effectuée
		if(type != null)
		{
			// Si la simulation portait sur un sort
			if(type.equals("Sort"))
			{
				Sort sort = (Sort) this.donneesDerniereSimulation.get("Sort");
				int niveau = (Integer) this.donneesDerniereSimulation.get("Niveau");
				this.updateDegatsSortSimulation(sort, niveau);
			}
			// Si la simulation portait sur un CaC
			else
			{
				if(this.sauvegardeArme != null)
				{
					boolean maitrise = (Boolean) this.donneesDerniereSimulation.get("Maitrise");
					boolean ccMaitrise = (Boolean) this.donneesDerniereSimulation.get("Coup Critique Maitrise");
					this.updateDegatsCaCSimulation(maitrise, ccMaitrise);
				}
			}
		}
	}

	/**
	 * Calcule les soins.
	 */
	public void updateSoins()
	{
		FlagsTypesEffets effet = FlagsTypesEffets.Soins;

		int valeur = 0;
		// Bonus équipement
		valeur += this.statistiquesEquipement.getInt(effet);

		this.statistiquesGlobales.setInt(effet, valeur);
		
		// Logger
		logger.trace("Mise à jour de l'effet " + effet.getNom() + " des statistiques globales par " + valeur + ".");

		// Lancement de l'evenement
		ObservateurCalculateur[] observateurs = (ObservateurCalculateur[]) this.listeObservateurs.getListeners(ObservateurCalculateur.class);
		for(ObservateurCalculateur observateur : observateurs)
		{
			observateur.changementStatistique(effet, valeur);
		}
	}

	/**
	 * Met à jour les statistiques apportées par les dofus.
	 */
	public void updateStatistiquesDofus()
	{
		// Logger
		logger.trace("Mise à jour des statistiques apportées par les Dofus.");
		
		this.statistiquesDofus = new Effets();

		for(Entry<FlagsTypesDofus, SauvegardeDofus> entry : this.sauvegardesDofus.entrySet())
		{
			SauvegardeDofus sauvegarde = entry.getValue();
			if(sauvegarde != null)
			{
				this.statistiquesDofus.add(sauvegarde.getEffets());
			}
		}

		this.updateStatistiquesEquipement();
	}

	/**
	 * Met à jour les statistiques apportées par l'équipement.
	 */
	public void updateStatistiquesEquipement()
	{
		// Logger
		logger.trace("Mise à jour des statistiques apportées par tout l'équipement.");
		
		this.statistiquesEquipement = new Effets();
		Effets effetsPanoplies = new Effets();
		String nomsPanoplies = null;

		HashMap<Integer, Integer> listePanopliesEquipees = new HashMap<Integer, Integer>();

		for(Entry<FlagsTypesEquipements, SauvegardeEquipement> entry : this.sauvegardesEquipement.entrySet())
		{
			SauvegardeEquipement sauvegarde = entry.getValue();
			if(sauvegarde != null)
			{
				this.statistiquesEquipement.add(sauvegarde.getEffets());

				int idPanoplie = sauvegarde.getPanoplie();
				// Si l'objet équipé appartient à une panoplie
				if(idPanoplie != 0)
				{
					int nbObjets;

					if(listePanopliesEquipees.get(idPanoplie) == null)
					{
						nbObjets = 0;
					}
					else
					{
						nbObjets = listePanopliesEquipees.get(idPanoplie);
					}

					listePanopliesEquipees.put(idPanoplie, (nbObjets + 1));
				}
			}
		}

		if(this.sauvegardeArme != null)
		{
			this.statistiquesEquipement.add(this.sauvegardeArme.getEffets());

			int idPanoplie = this.sauvegardeArme.getPanoplie();
			// Si l'arme équipée appartient à une panoplie
			if(idPanoplie != 0)
			{
				int nbObjets;

				if(listePanopliesEquipees.get(idPanoplie) == null)
				{
					nbObjets = 0;
				}
				else
				{
					nbObjets = listePanopliesEquipees.get(idPanoplie);
				}

				listePanopliesEquipees.put(idPanoplie, (nbObjets + 1));
			}
		}
		
		if(listePanopliesEquipees.size() > 0)
		{
			nomsPanoplies = "Panoplie ";
			for(Entry<Integer, Integer> entry : listePanopliesEquipees.entrySet())
			{
				int nbObjets = entry.getValue();
				
				int idPanoplie = entry.getKey();
				Panoplie panoplie = this.listePanoplies.get(idPanoplie);
				Effets effets = panoplie.getBonus(nbObjets);
	
				if(effets != null)
				{
					String nom = panoplie.getNom();
					if(nom.startsWith("Panoplie "))
						nom = nom.substring(8, nom.length());
					nomsPanoplies+= nom + ", ";
					
					effetsPanoplies.add(effets);
				}
			}
			
			if(!nomsPanoplies.equals(""))
				nomsPanoplies = nomsPanoplies.substring(0, (nomsPanoplies.length() - 2));
		}

		// Ajoute les effets des panoplies
		this.statistiquesEquipement.add(effetsPanoplies);

		// Ajoute les effets des dofus
		this.statistiquesEquipement.add(this.statistiquesDofus);

		// Ajoute les effets de l'animal
		if(this.sauvegardeAnimal != null)
		{
			this.statistiquesEquipement.add(this.sauvegardeAnimal.getEffets());
		}

		ObservateurCalculateur[] observateurs = (ObservateurCalculateur[]) this.listeObservateurs.getListeners(ObservateurCalculateur.class);
		for(ObservateurCalculateur observateur : observateurs)
		{
			observateur.changementPanoplie(nomsPanoplies, effetsPanoplies);
		}
	}

	/**
	 * Calcule la vie totale.
	 */
	public void updateVie()
	{
		FlagsTypesEffets effet = FlagsTypesEffets.Vie;
		
		int valeur = Formules.getVie(this.sauvegardePersonnage.getNiveau(), this.classe.getBaseVie(), this.statistiquesEquipement.getInt(effet), this.statistiquesGlobales.getInt(FlagsTypesEffets.Vitalite));

		this.statistiquesGlobales.setInt(effet, valeur);
		
		// Logger
		logger.trace("Mise à jour de l'effet " + effet.getNom() + " des statistiques globales par " + valeur + ".");

		// Lancement de l'evenement
		ObservateurCalculateur[] observateurs = (ObservateurCalculateur[]) this.listeObservateurs.getListeners(ObservateurCalculateur.class);
		for(ObservateurCalculateur observateur : observateurs)
		{
			observateur.changementStatistique(effet, valeur);
		}
		
		this.updateInitiative();
	}

	/**
	 * Calcule la vitalité.
	 */
	public void updateVitalite()
	{
		FlagsTypesEffets effet = FlagsTypesEffets.Vitalite;

		int valeur = 0;
		// Vitalité de base du personnage
		valeur += this.sauvegardePersonnage.getVitalite();
		// Bonus d'alignement
		int niveauAlignement = this.sauvegardePersonnage.getNiveauAlignement();
		int alignement = this.sauvegardePersonnage.getAlignement();
		// Si mercenaire
		if(alignement == 3)
		{
			// Bonus du niveau 60/79
			if((niveauAlignement >= 60) && (niveauAlignement < 80))
			{
				valeur += 50;
			}
			// Bonus du niveau 80/99
			if((niveauAlignement >= 80) && (niveauAlignement < 100))
			{
				valeur += 100;
			}
			// Bonus du niveau 100
			if(niveauAlignement == 100)
			{
				valeur += 150;
			}
		}
		// Bonus équipement
		valeur += this.statistiquesEquipement.getInt(effet);

		this.statistiquesGlobales.setInt(effet, valeur);
		
		// Logger
		logger.trace("Mise à jour de l'effet " + effet.getNom() + " des statistiques globales par " + valeur + ".");

		// Lancement de l'evenement
		ObservateurCalculateur[] observateurs = (ObservateurCalculateur[]) this.listeObservateurs.getListeners(ObservateurCalculateur.class);
		for(ObservateurCalculateur observateur : observateurs)
		{
			observateur.changementStatistique(effet, valeur);
		}

		this.updateVie();
	}

	/**
	 * Verifie que les statistiques du personnage vérifient les conditions passées en argument.
	 * 
	 * @param conditions - Conditions nécessaires pour porter l'objet.
	 * @param niveau - Niveau nécessaire pour porter l'objet.
	 */
	public String verifierConditions(ArrayList<Condition> conditions, int niveau)
	{
		// Logger
		logger.trace("Vérification des conditions.");
		
		String erreurs = "";

		if(this.sauvegardePersonnage.getNiveau() < niveau)
		{
			erreurs += "Vous devez être niveau " + niveau + " ou supérieur pour porter cet objet.\n";
		}

		if(conditions != null)
		{
			for(int i = 0; i < conditions.size(); i++)
			{
				String message = null;
	
				if(conditions.get(i) instanceof ConditionCaracteristique)
				{
					ConditionCaracteristique condition = (ConditionCaracteristique) conditions.get(i);
					message = condition.tester(this.statistiquesGlobales.getInt(condition.getCaracteristique()));
				}
				else if(conditions.get(i) instanceof ConditionClasse)
				{
					message = conditions.get(i).tester(this.listeClasses.get(this.sauvegardePersonnage.getClasse()).getNom());
				}
				else if(conditions.get(i) instanceof ConditionGrade)
				{
					message = conditions.get(i).tester(this.sauvegardePersonnage.getGrade());
				}
				else if(conditions.get(i) instanceof ConditionSexe)
				{
					message = conditions.get(i).tester(Sexe.getSexe(this.sauvegardePersonnage.getSexe()));
				}
				else if(conditions.get(i) instanceof ConditionAlignement)
				{
					message = conditions.get(i).tester(Alignement.getAlignement(this.sauvegardePersonnage.getAlignement()));
				}
	
				if(message != null)
				{
					erreurs += message + "\n";
				}
			}
		}
		
		if(erreurs.equals(""))
		{
			return null;
		}
		else
		{
			return erreurs;
		}
	}

	/*
	 * Accesseurs
	 */
	
	/**
	 * Renvoie la classe utilisée par le modèle pour faire ses calculs.
	 * 
	 * @return La classe utilisée.
	 * @category Accesseur
	 */
	public final Classe getClasse()
	{
		return this.classe;
	}

	/**
	 * Calcule les détails de la dernière simulation.
	 * 
	 * @return Les détails de la dernière simulation.
	 * @category Accesseur
	 */
	@SuppressWarnings("unchecked")
	public final HashMap<String, String> getDetails()
	{
		// Logger
		logger.trace("Calcul des détails de la dernière simulation.");
		
		HashMap<String, String> donneesDegatsSimulation = (HashMap<String, String>) this.donneesDerniereSimulation.get("Dégâts");
		HashMap<String, String> retour = new HashMap<String, String>();

		int pa = this.statistiquesGlobales.getInt(FlagsTypesEffets.Pa) + this.statistiquesBoost.getInt(FlagsTypesEffets.Pa);
		int coutPA = Integer.parseInt(donneesDegatsSimulation.get("PA"));
		int nbCoups = (int) Math.floor(pa / coutPA);

		int ec;
		int cc;
		double nbCoupsHorsEC;
		double coefCoupsNorm;
		double coefCoupsCC;
		if(!donneesDegatsSimulation.get("EC").equals("-"))
		{
			ec = Integer.parseInt(donneesDegatsSimulation.get("EC").substring(2));
			nbCoupsHorsEC = nbCoups * (1 - (double) 1 / (double) ec);
		}
		else
		{
			ec = 0;
			nbCoupsHorsEC = nbCoups;
		}
		if(!donneesDegatsSimulation.get("CC").equals("-"))
		{
			cc = Integer.parseInt(donneesDegatsSimulation.get("CC").substring(2));
			coefCoupsNorm = nbCoupsHorsEC * (1 - (double) 1 / (double) cc);
			coefCoupsCC = nbCoupsHorsEC - coefCoupsNorm;
		}
		else
		{
			cc = 0;
			coefCoupsNorm = nbCoupsHorsEC;
			coefCoupsCC = 0;
		}

		int degatsMoyCoupNeutreNorm = (int) ((Double.parseDouble(donneesDegatsSimulation.get("Neutre Minimum")) + Double.parseDouble(donneesDegatsSimulation.get("Neutre Maximum"))) / (double) 2);
		int degatsMoyCoupTerreNorm = (int) ((Double.parseDouble(donneesDegatsSimulation.get("Terre Minimum")) + Double.parseDouble(donneesDegatsSimulation.get("Terre Maximum"))) / (double) 2);
		int degatsMoyCoupFeuNorm = (int) ((Double.parseDouble(donneesDegatsSimulation.get("Feu Minimum")) + Double.parseDouble(donneesDegatsSimulation.get("Feu Maximum"))) / (double) 2);
		int degatsMoyCoupEauNorm = (int) ((Double.parseDouble(donneesDegatsSimulation.get("Eau Minimum")) + Double.parseDouble(donneesDegatsSimulation.get("Eau Maximum"))) / (double) 2);
		int degatsMoyCoupAirNorm = (int) ((Double.parseDouble(donneesDegatsSimulation.get("Air Minimum")) + Double.parseDouble(donneesDegatsSimulation.get("Air Maximum"))) / (double) 2);
		int degatsMoyVoleNorm = (int) ((Double.parseDouble(donneesDegatsSimulation.get("Vole Minimum")) + Double.parseDouble(donneesDegatsSimulation.get("Vole Maximum"))) / (double) 2);
		int degatsMoySoinsNorm = (int) ((Double.parseDouble(donneesDegatsSimulation.get("Soins Minimum")) + Double.parseDouble(donneesDegatsSimulation.get("Soins Maximum"))) / (double) 2);

		int degatsMoyCoupNeutreCC;
		int degatsMoyCoupTerreCC;
		int degatsMoyCoupFeuCC;
		int degatsMoyCoupEauCC;
		int degatsMoyCoupAirCC;
		int degatsMoyVoleCC;
		int degatsMoySoinsCC;

		int degatsMaxTourNeutre;
		int degatsMaxTourTerre;
		int degatsMaxTourFeu;
		int degatsMaxTourEau;
		int degatsMaxTourAir;
		int degatsMaxTourVole;
		int degatsMaxTourSoins;

		int degatsMoyCoupNeutre;
		int degatsMoyCoupTerre;
		int degatsMoyCoupFeu;
		int degatsMoyCoupEau;
		int degatsMoyCoupAir;
		int degatsMoyVole;
		int degatsMoySoins;

		if(cc != 0)
		{
			degatsMoyCoupNeutreCC = (int) ((Double.parseDouble(donneesDegatsSimulation.get("Neutre Minimum CC")) + Double.parseDouble(donneesDegatsSimulation.get("Neutre Maximum CC"))) / (double) 2);
			degatsMoyCoupTerreCC = (int) ((Double.parseDouble(donneesDegatsSimulation.get("Terre Minimum CC")) + Double.parseDouble(donneesDegatsSimulation.get("Terre Maximum CC"))) / (double) 2);
			degatsMoyCoupFeuCC = (int) ((Double.parseDouble(donneesDegatsSimulation.get("Feu Minimum CC")) + Double.parseDouble(donneesDegatsSimulation.get("Feu Maximum CC"))) / (double) 2);
			degatsMoyCoupEauCC = (int) ((Double.parseDouble(donneesDegatsSimulation.get("Eau Minimum CC")) + Double.parseDouble(donneesDegatsSimulation.get("Eau Maximum CC"))) / (double) 2);
			degatsMoyCoupAirCC = (int) ((Double.parseDouble(donneesDegatsSimulation.get("Air Minimum CC")) + Double.parseDouble(donneesDegatsSimulation.get("Air Maximum CC"))) / (double) 2);
			degatsMoyVoleCC = (int) ((Double.parseDouble(donneesDegatsSimulation.get("Vole Minimum CC")) + Double.parseDouble(donneesDegatsSimulation.get("Vole Maximum CC"))) / (double) 2);
			degatsMoySoinsCC = (int) ((Double.parseDouble(donneesDegatsSimulation.get("Soins Minimum CC")) + Double.parseDouble(donneesDegatsSimulation.get("Soins Maximum CC"))) / (double) 2);

			degatsMaxTourNeutre = nbCoups * Integer.parseInt(donneesDegatsSimulation.get("Neutre Maximum CC"));
			degatsMaxTourTerre = nbCoups * Integer.parseInt(donneesDegatsSimulation.get("Terre Maximum CC"));
			degatsMaxTourFeu = nbCoups * Integer.parseInt(donneesDegatsSimulation.get("Feu Maximum CC"));
			degatsMaxTourEau = nbCoups * Integer.parseInt(donneesDegatsSimulation.get("Eau Maximum CC"));
			degatsMaxTourAir = nbCoups * Integer.parseInt(donneesDegatsSimulation.get("Air Maximum CC"));
			degatsMaxTourVole = nbCoups * Integer.parseInt(donneesDegatsSimulation.get("Vole Maximum CC"));
			degatsMaxTourSoins = nbCoups * Integer.parseInt(donneesDegatsSimulation.get("Soins Maximum CC"));

			degatsMoyCoupNeutre = (int) ((double) (degatsMoyCoupNeutreNorm + degatsMoyCoupNeutreCC) / (double) 2);
			degatsMoyCoupTerre = (int) ((double) (degatsMoyCoupTerreNorm + degatsMoyCoupTerreCC) / (double) 2);
			degatsMoyCoupFeu = (int) ((double) (degatsMoyCoupFeuNorm + degatsMoyCoupFeuCC) / (double) 2);
			degatsMoyCoupEau = (int) ((double) (degatsMoyCoupEauNorm + degatsMoyCoupEauCC) / (double) 2);
			degatsMoyCoupAir = (int) ((double) (degatsMoyCoupAirNorm + degatsMoyCoupAirCC) / (double) 2);
			degatsMoyVole = (int) ((double) (degatsMoyVoleNorm + degatsMoyVoleCC) / (double) 2);
			degatsMoySoins = (int) ((double) (degatsMoySoinsNorm + degatsMoySoinsCC) / (double) 2);
		}
		else
		{
			degatsMoyCoupNeutreCC = 0;
			degatsMoyCoupTerreCC = 0;
			degatsMoyCoupFeuCC = 0;
			degatsMoyCoupEauCC = 0;
			degatsMoyCoupAirCC = 0;
			degatsMoyVoleCC = 0;
			degatsMoySoinsCC = 0;

			degatsMaxTourNeutre = nbCoups * Integer.parseInt(donneesDegatsSimulation.get("Neutre Maximum"));
			degatsMaxTourTerre = nbCoups * Integer.parseInt(donneesDegatsSimulation.get("Terre Maximum"));
			degatsMaxTourFeu = nbCoups * Integer.parseInt(donneesDegatsSimulation.get("Feu Maximum"));
			degatsMaxTourEau = nbCoups * Integer.parseInt(donneesDegatsSimulation.get("Eau Maximum"));
			degatsMaxTourAir = nbCoups * Integer.parseInt(donneesDegatsSimulation.get("Air Maximum"));
			degatsMaxTourVole = nbCoups * Integer.parseInt(donneesDegatsSimulation.get("Vole Maximum"));
			degatsMaxTourSoins = nbCoups * Integer.parseInt(donneesDegatsSimulation.get("Soins Maximum"));

			degatsMoyCoupNeutre = degatsMoyCoupNeutreNorm;
			degatsMoyCoupTerre = degatsMoyCoupTerreNorm;
			degatsMoyCoupFeu = degatsMoyCoupFeuNorm;
			degatsMoyCoupEau = degatsMoyCoupEauNorm;
			degatsMoyCoupAir = degatsMoyCoupAirNorm;
			degatsMoyVole = degatsMoyVoleNorm;
			degatsMoySoins = degatsMoySoinsNorm;
		}

		int degatsMinTourNeutre = nbCoups * Integer.parseInt(donneesDegatsSimulation.get("Neutre Minimum"));
		int degatsMinTourTerre = nbCoups * Integer.parseInt(donneesDegatsSimulation.get("Terre Minimum"));
		int degatsMinTourFeu = nbCoups * Integer.parseInt(donneesDegatsSimulation.get("Feu Minimum"));
		int degatsMinTourEau = nbCoups * Integer.parseInt(donneesDegatsSimulation.get("Eau Minimum"));
		int degatsMinTourAir = nbCoups * Integer.parseInt(donneesDegatsSimulation.get("Air Minimum"));
		int degatsMinTourVole = nbCoups * Integer.parseInt(donneesDegatsSimulation.get("Vole Minimum"));
		int degatsMinTourSoins = nbCoups * Integer.parseInt(donneesDegatsSimulation.get("Soins Minimum"));

		int degatsMoyTourNeutre = (int) (coefCoupsNorm * degatsMoyCoupNeutre + coefCoupsCC * degatsMoyCoupNeutreCC);
		int degatsMoyTourTerre = (int) (coefCoupsNorm * degatsMoyCoupTerre + coefCoupsCC * degatsMoyCoupTerreCC);
		int degatsMoyTourFeu = (int) (coefCoupsNorm * degatsMoyCoupFeu + coefCoupsCC * degatsMoyCoupFeuCC);
		int degatsMoyTourEau = (int) (coefCoupsNorm * degatsMoyCoupEau + coefCoupsCC * degatsMoyCoupEauCC);
		int degatsMoyTourAir = (int) (coefCoupsNorm * degatsMoyCoupAir + coefCoupsCC * degatsMoyCoupAirCC);
		int degatsMoyTourVole = (int) (coefCoupsNorm * degatsMoyVole + coefCoupsCC * degatsMoyVoleCC);
		int degatsMoyTourSoins = (int) (coefCoupsNorm * degatsMoySoins + coefCoupsCC * degatsMoySoinsCC);

		retour.put("PA", String.valueOf(coutPA));
		retour.put("Moyenne Coup Neutre", String.valueOf(degatsMoyCoupNeutre));
		retour.put("Moyenne Coup NormNeutre", String.valueOf(degatsMoyCoupNeutreNorm));
		retour.put("Moyenne Coup Terre", String.valueOf(degatsMoyCoupTerre));
		retour.put("Moyenne Coup NormTerre", String.valueOf(degatsMoyCoupTerreNorm));
		retour.put("Moyenne Coup Feu", String.valueOf(degatsMoyCoupFeu));
		retour.put("Moyenne Coup NormFeu", String.valueOf(degatsMoyCoupFeuNorm));
		retour.put("Moyenne Coup Eau", String.valueOf(degatsMoyCoupEau));
		retour.put("Moyenne Coup NormEau", String.valueOf(degatsMoyCoupEauNorm));
		retour.put("Moyenne Coup Air", String.valueOf(degatsMoyCoupAir));
		retour.put("Moyenne Coup NormAir", String.valueOf(degatsMoyCoupAirNorm));
		retour.put("Moyenne Coup Vdv", String.valueOf(degatsMoyVole));
		retour.put("Moyenne Coup NormVdv", String.valueOf(degatsMoyVoleNorm));
		retour.put("Moyenne Coup Soins", String.valueOf(degatsMoySoins));
		retour.put("Moyenne Coup NormSoins", String.valueOf(degatsMoySoinsNorm));
		retour.put("Minimum Tour Neutre", String.valueOf(degatsMinTourNeutre));
		retour.put("Minimum Tour Terre", String.valueOf(degatsMinTourTerre));
		retour.put("Minimum Tour Feu", String.valueOf(degatsMinTourFeu));
		retour.put("Minimum Tour Eau", String.valueOf(degatsMinTourEau));
		retour.put("Minimum Tour Air", String.valueOf(degatsMinTourAir));
		retour.put("Minimum Tour Vdv", String.valueOf(degatsMinTourVole));
		retour.put("Minimum Tour Soins", String.valueOf(degatsMinTourSoins));
		retour.put("Maximum Tour Neutre", String.valueOf(degatsMaxTourNeutre));
		retour.put("Maximum Tour Terre", String.valueOf(degatsMaxTourTerre));
		retour.put("Maximum Tour Feu", String.valueOf(degatsMaxTourFeu));
		retour.put("Maximum Tour Eau", String.valueOf(degatsMaxTourEau));
		retour.put("Maximum Tour Air", String.valueOf(degatsMaxTourAir));
		retour.put("Maximum Tour Vdv", String.valueOf(degatsMaxTourVole));
		retour.put("Maximum Tour Soins", String.valueOf(degatsMaxTourSoins));
		retour.put("Moyenne Tour Neutre", String.valueOf(degatsMoyTourNeutre));
		retour.put("Moyenne Tour Terre", String.valueOf(degatsMoyTourTerre));
		retour.put("Moyenne Tour Feu", String.valueOf(degatsMoyTourFeu));
		retour.put("Moyenne Tour Eau", String.valueOf(degatsMoyTourEau));
		retour.put("Moyenne Tour Air", String.valueOf(degatsMoyTourAir));
		retour.put("Moyenne Tour Vdv", String.valueOf(degatsMoyTourVole));
		retour.put("Moyenne Tour Soins", String.valueOf(degatsMoyTourSoins));

		if(ec != 0)
		{
			retour.put("EC", "1/" + String.valueOf(ec));
		}
		else
		{
			retour.put("EC", "-");
		}

		if(cc != 0)
		{
			retour.put("CC", "1/" + String.valueOf(cc));
			retour.put("Moyenne Coup Critique Neutre", String.valueOf(degatsMoyCoupNeutreCC));
			retour.put("Moyenne Coup Critique Terre", String.valueOf(degatsMoyCoupTerreCC));
			retour.put("Moyenne Coup Critique Feu", String.valueOf(degatsMoyCoupFeuCC));
			retour.put("Moyenne Coup Critique Eau", String.valueOf(degatsMoyCoupEauCC));
			retour.put("Moyenne Coup Critique Air", String.valueOf(degatsMoyCoupAirCC));
			retour.put("Moyenne Coup Critique Vdv", String.valueOf(degatsMoyVoleCC));
			retour.put("Moyenne Coup Critique Soins", String.valueOf(degatsMoySoinsCC));
		}
		else
		{
			retour.put("CC", "-");
			retour.put("Moyenne Coup Critique Neutre", "-");
			retour.put("Moyenne Coup Critique Terre", "-");
			retour.put("Moyenne Coup Critique Feu", "-");
			retour.put("Moyenne Coup Critique Eau", "-");
			retour.put("Moyenne Coup Critique Air", "-");
			retour.put("Moyenne Coup Critique Vdv", "-");
			retour.put("Moyenne Coup Critique Soins", "-");

		}
		
		String type = (String) this.donneesDerniereSimulation.get("Type");
		if(type.equals("CaC"))
		{
			SauvegardeArme arme = (SauvegardeArme) this.donneesDerniereSimulation.get("Arme");
			retour.put("Type", arme.getType().getNom());
			retour.put("Nom", arme.getNom());
		}
		else
		{
			Sort sort = (Sort) this.donneesDerniereSimulation.get("Sort");
			Integer niveau = (Integer) this.donneesDerniereSimulation.get("Niveau");
			retour.put("Type", "Sort niveau " + niveau);
			retour.put("Nom", sort.getNom());
		}
	
		return retour;
	}

	/**
	 * Renvoie la liste des objets équipés sous forme d'un groupe d'objets.
	 * 
	 * @return Un {@link GroupeObjets} contenant les objets équipés.
	 * @category Accesseur
	 */
	public final GroupeObjets getGroupesObjets()
	{
		GroupeObjets groupe = new GroupeObjets();
		groupe.setArme(this.sauvegardeArme);
		groupe.setAnimal(this.sauvegardeAnimal);
		groupe.setListeEquipements(this.sauvegardesEquipement);
		groupe.setListeDofus(this.sauvegardesDofus);
		return groupe;
	}

	/**
	 * Renvoie la sauvegarde de l'animal équipé.
	 * 
	 * @return L'objet sauvegarde de l'animal.
	 * @category Accesseur
	 */
	public final SauvegardeAnimal getSauvegardeAnimal()
	{
		return this.sauvegardeAnimal;
	}

	/**
	 * Renvoie la sauvegarde de l'arme équipé.
	 * 
	 * @return L'objet sauvegarde de l'arme.
	 * @category Accesseur
	 */
	public final SauvegardeArme getSauvegardeArme()
	{
		return this.sauvegardeArme;
	}

	/**
	 * Renvoie la sauvegarde du Dofus défini par {@code typeDofus}.
	 * 
	 * @param typeDofus - Type du Dofus.
	 * @return L'objet sauvegarde du Dofus.
	 * @category Accesseur
	 */
	public final SauvegardeDofus getSauvegardeDofus(FlagsTypesDofus typeDofus)
	{
		return this.sauvegardesDofus.get(typeDofus);
	}

	/**
	 * Renvoie la sauvegarde de l'équipement défini par {@code typeEquipement}.
	 * 
	 * @param typeEquipement - Type de l'équipement.
	 * @return L'objet sauvegarde de l'équipement.
	 * @category Accesseur
	 */
	public final SauvegardeEquipement getSauvegardeEquipement(FlagsTypesEquipements typeEquipement)
	{
		return this.sauvegardesEquipement.get(typeEquipement);
	}

	/**
	 * Renvoie la sauvegarde du personnage.
	 * 
	 * @return L'objet sauvegarde du personnage.
	 * @category Accesseur
	 */
	public final SauvegardePersonnage getSauvegardePersonnage()
	{
		return this.sauvegardePersonnage;
	}

	/**
	 * Renvoie toutes les statisques globales.
	 * 
	 * @return Toutes les statisques globales dans une instance {@link Effets}.
	 * @category Accesseur
	 */
	public final Effets getStatistiquesGlobales()
	{
		return this.statistiquesGlobales;
	}

	/**
	 * Enregistre l'alignement du personnage en cours dans le modèle.
	 * 
	 * @param alignement - Alignement du personnage.
	 * @param specialisation - Spécialisation du personnage.
	 * @param niveauAlignement - Niveai de l'alignement du personnage.
	 * @param grade - Grade du personnage.
	 * @category Accesseur
	 */
	public final void setAlignement(int alignement, int specialisation, int niveauAlignement, int grade)
	{
		this.sauvegardePersonnage.setAlignement(alignement);
		this.sauvegardePersonnage.setSpecialisationAlignement(specialisation);
		this.sauvegardePersonnage.setNiveauAlignement(niveauAlignement);
		this.sauvegardePersonnage.setGrade(grade);

		this.updateVitalite();
		this.updateInitiative();
		this.updatePourcentageResistanceTerre();
		this.updatePourcentageResistanceFeu();
		this.updatePourcentageResistanceEau();
		this.updatePourcentageResistanceAir();

		this.updateErreursConditions();

		this.updateSimulation();
	}

	/**
	 * Enregistre la caractéristique {@code clef} de base du personnage dans le modèle.
	 * 
	 * @param clef - Nom de la caractéristique.
	 * @param valeur - Valeur de la la caractéristique.
	 * @category Accesseur
	 */
	public final void setCaracteristique(String clef, int valeur)
	{
		if(clef.equals("Vitalité"))
		{
			this.sauvegardePersonnage.setVitalite(valeur);
			this.updateVitalite();
		}
		else if(clef.equals("Sagesse"))
		{
			this.sauvegardePersonnage.setSagesse(valeur);
			this.updateSagesse();
		}
		else if(clef.equals("Force"))
		{
			this.sauvegardePersonnage.setForce(valeur);
			this.updateForce();
		}
		else if(clef.equals("Intelligence"))
		{
			this.sauvegardePersonnage.setIntelligence(valeur);
			this.updateIntelligence();
		}
		else if(clef.equals("Chance"))
		{
			this.sauvegardePersonnage.setChance(valeur);
			this.updateChance();
		}
		else if(clef.equals("Agilité"))
		{
			this.sauvegardePersonnage.setAgilite(valeur);
			this.updateAgilite();
		}

		this.updateErreursConditions();

		this.updateSimulation();
	}

	/**
	 * Enregistre dans le modèle la classe à utiliser pour faire ses calculs.
	 * 
	 * @param classe - Classe.
	 * @category Accesseur
	 */
	public final void setClasse(Classe classe)
	{
		this.classe = classe;
		this.sauvegardePersonnage.setClasse(classe.getId());

		this.updateVie();
		this.updatePa();
		this.updatePm();
		this.updatePo();
		this.updateInitiative();
		this.updateProspection();

		// Lancement de l'evenement
		ObservateurCalculateur[] observateurs = (ObservateurCalculateur[]) this.listeObservateurs.getListeners(ObservateurCalculateur.class);
		for(ObservateurCalculateur observateur : observateurs)
		{
			observateur.changementClasse(classe);
		}

		// Un changement de classe entraine l'effacement de la dernière simulation
		this.donneesDerniereSimulation.put("Type", null);

		this.updateErreursConditions();
	}

	/**
	 * Enregistre la liste des classes du jeu dans le modèle.
	 *  
	 * @param listeClasses - Liste des classes.
	 * @category Accesseur
	 */
	public final void setListeClasses(HashMap<Integer, Classe> listeClasses)
	{
		this.listeClasses = listeClasses;
	}

	/**
	 * Enregistre la liste des panoplies du jeu dans le modèle.
	 * 
	 * @param listePanoplies - Liste des panoplies.
	 * @category Accesseur
	 */
	public final void setListePanoplies(HashMap<Integer, Panoplie> listePanoplies)
	{
		this.listePanoplies = listePanoplies;
	}

	/**
	 * Définit le mode de calcul des statistiques globales.
	 * 
	 * @param mode - Mode à utiliser.
	 * @category Accesseur
	 */
	public final void setMode(int mode)
	{
		this.mode = mode;

		this.updateResistanceNeutre();
		this.updateResistanceTerre();
		this.updateResistanceFeu();
		this.updateResistanceEau();
		this.updateResistanceAir();
		this.updatePourcentageResistanceNeutre();
		this.updatePourcentageResistanceTerre();
		this.updatePourcentageResistanceFeu();
		this.updatePourcentageResistanceEau();
		this.updatePourcentageResistanceAir();
	}

	/**
	 * Enregistre le niveai du personnage dans le modèle.
	 * 
	 * @param niveau - Niveau du personnage.
	 * @category Accesseur
	 */
	public final void setNiveau(int niveau)
	{
		this.sauvegardePersonnage.setNiveau(niveau);

		this.updateVie();
		this.updatePa();

		this.updateErreursConditions();
	}

	/**
	 * Enregistre le niveau d'une maîtrise dans le modèle.
	 * 
	 * @param type - Type de la maîtise.
	 * @param niveau - Niveau de la maîtrise.
	 * @category Accesseur
	 */
	public final void setNiveauMaitrise(FlagsTypesArmes type, int niveau)
	{
		this.sauvegardePersonnage.setMaitrise(type, niveau);

		this.updateSimulation();
	}

	/**
	 * Enregistre le nom du personnage dans le modèle.
	 * 
	 * @param nom - Nom du personnage.
	 */
	public final void setNomPersonnage(String nom)
	{
		this.sauvegardePersonnage.setNomPerso(nom);
	}

	/**
	 * Définit les résistances à utiliser lors des simulations.
	 * 
	 * @param resistances - Les résistances contenues dans une instance {@link Effets}.
	 * @category Accesseur
	 */
	public final void setResistances(Effets resistances)
	{
		this.resistances = resistances;

		this.updateSimulation();
	}

	/**
	 * Enregistre un animal dans le modèle.
	 * 
	 * @param sauvegarde - Objet sauvegarde de l'animal.
	 * @category Accesseur
	 */
	public final void setSauvegardeAnimal(SauvegardeAnimal sauvegardeAnimal)
	{
		this.sauvegardeAnimal = sauvegardeAnimal;
		this.updateStatistiquesEquipement();
		this.updateAll();
		this.updateErreursConditions();
		this.updateSimulation();
	}

	/**
	 * Enregistre le corps à corps équipé dans le modèle.
	 * 
	 * @param sauvegardeArme - Objet sauvegarde du corps à corps.
	 * @category Accesseur
	 */
	public final void setSauvegardeArme(SauvegardeArme sauvegardeArme)
	{
		this.sauvegardeArme = sauvegardeArme;

		this.updateStatistiquesEquipement();
		this.updateAll();
		this.updateErreursConditions();
		this.updateSimulation();
	}

	/**
	 * Enregistre un Dofus dans le modèle.
	 * 
	 * @param type - Type du Dofus.
	 * @param dofus - Objet sauvegarde du Dofus.
	 * @category Accesseur
	 */
	public final void setSauvegardeDofus(FlagsTypesDofus type, SauvegardeDofus dofus)
	{
		this.sauvegardesDofus.put(type, dofus);
		this.updateStatistiquesDofus();
		this.updateAll();
		this.updateErreursConditions();
		this.updateSimulation();
	}

	/**
	 * Enregistre un équipement dans le modèle.
	 * 
	 * @param type - Type de l'équipement.
	 * @param sauvegarde - Objet sauvegarde de l'équipement.
	 * @category Accesseur
	 */
	public final void setSauvegardeEquipement(FlagsTypesEquipements type, SauvegardeEquipement sauvegarde)
	{
		this.sauvegardesEquipement.put(type, sauvegarde);
		this.updateStatistiquesEquipement();
		this.updateAll();
		this.updateErreursConditions();
		this.updateSimulation();
	}

	/**
	 * Enregistre la sauvegarde d'un personnage dans le modèle.
	 * 
	 * @param sauvegardePersonnage - Sauvegarde du personnage.
	 * @category Accesseur
	 */
	public final void setSauvegardePersonnage(SauvegardePersonnage sauvegardePersonnage)
	{
		this.sauvegardePersonnage = sauvegardePersonnage;

		this.updateVitalite();
		this.updateSagesse();
		this.updateForce();
		this.updateIntelligence();
		this.updateChance();
		this.updateAgilite();
		this.updateInitiative();
		
		// Lancement de l'evenement
		ObservateurCalculateur[] observateurs = (ObservateurCalculateur[]) this.listeObservateurs.getListeners(ObservateurCalculateur.class);
		for(ObservateurCalculateur observateur : observateurs)
		{
			observateur.changementSauvegardePersonnage(sauvegardePersonnage);
		}
		
		this.setClasse(this.classes.get(sauvegardePersonnage.getClasse()));
		this.setSexe(sauvegardePersonnage.getSexe());
		
		this.updateErreursConditions();
	}

	/**
	 * Enregistre le sexe du personnage dans le modèle.
	 * 
	 * @param sexe - Sexe du personnage.
	 */
	public final void setSexe(char sexe)
	{
		this.sauvegardePersonnage.setSexe(sexe);
		
		// Lancement de l'evenement
		ObservateurCalculateur[] observateurs = (ObservateurCalculateur[]) this.listeObservateurs.getListeners(ObservateurCalculateur.class);
		for(ObservateurCalculateur observateur : observateurs)
		{
			observateur.changementSexe(sexe, this.classe);
		}

		this.updateErreursConditions();
	}

	/**
	 * Enregistre le niveau d'un sort du personnage dans le modèle.
	 * 
	 * @param nomSort - Nom du sort.
	 * @param niveau - Niveau du sort.
	 */
	public final void setSort(String nomSort, int niveau)
	{
		this.sauvegardePersonnage.setSort(nomSort, niveau);
	}

	/**
	 * Définit les boost à utiliser lors des simulations.
	 * 
	 * @param statistiquesBoost - Les boost contenus dans une instance {@link Effets}.
	 * @category Accesseur
	 */
	public final void setStatistiquesBoost(Effets statistiquesBoost)
	{
		this.statistiquesBoost = statistiquesBoost;
		this.updateSimulation();
	}
	
	/**
	 * Définit le groupe d'objets à charger dans le modèle.
	 * 
	 * @param groupe - Le groupe d'objets à charger.
	 * @category Accesseur
	 */
	public final void setGroupeObjets(GroupeObjets groupe)
	{
		for(FlagsTypesEquipements flag : FlagsTypesEquipements.values())
		{
			if(flag != FlagsTypesEquipements.Anneau)
				this.setSauvegardeEquipement(flag, groupe.getEquipement(flag));
		}
		for(FlagsTypesDofus flag : FlagsTypesDofus.values())
		{
			this.setSauvegardeDofus(flag, groupe.getDofus(flag));
		}
		this.setSauvegardeArme(groupe.getArme());
		this.setSauvegardeAnimal(groupe.getAnimal());
	}
}