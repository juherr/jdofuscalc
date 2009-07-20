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

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import org.JDofusCalc.dofus.autres.DegatsArme;
import org.JDofusCalc.dofus.autres.Effets;
import org.JDofusCalc.dofus.autres.Degats.FlagsTypesDegats;
import org.JDofusCalc.dofus.conditions.Condition;
import org.JDofusCalc.dofus.objets.Animal.FlagsTypesAnimaux;
import org.JDofusCalc.dofus.objets.Arme.FlagsTypesArmes;
import org.JDofusCalc.dofus.objets.Dofus.FlagsTypesDofus;
import org.JDofusCalc.dofus.objets.Equipement.FlagsTypesEquipements;
import org.JDofusCalc.dofus.sauvegardes.GroupeObjets;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeAnimal;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeArme;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeDofus;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeEquipement;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeFamilier;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeMonture;
import org.JDofusCalc.dofus.sauvegardes.SauvegardePersonnage;
import org.JDofusCalc.observateurs.ObservateurGroupeObjets;
import org.JDofusCalc.observateurs.ObservateurSauvegardesArmes;
import org.JDofusCalc.observateurs.ObservateurSauvegardesDofus;
import org.JDofusCalc.observateurs.ObservateurSauvegardesFamiliers;
import org.JDofusCalc.observateurs.ObservateurSauvegardesMontures;
import org.JDofusCalc.observateurs.ObservateurSauvegardesEquipements;
import org.JDofusCalc.observateurs.ObservateurSauvegardesPersonnages;

import fr.ayapap.ASQLRequete;
import fr.ayapap.ASQL;

/**
 * Modèle des sauvegardes générées par l'application.
 * 
 * @author PAPAYA Alexandre
 * @category Modele
 * @version 1.0
 */
public class ModeleSauvegardes extends Modele
{
	/*
	 * Constructeurs / Destructeur
	 */

	/**
	 * Construit un nouveau modèle des sauvegardes.
	 * 
	 * @category Constructeur
	 */
	public ModeleSauvegardes()
	{
		// Execution du constructeur père
		super("sauvegardes");
	}
	
	/*
	 * Méthodes métier de l'application
	 */

	/**
	 * Créé une nouvelle arme.
	 * 
	 * @param typeArme - Type de l'arme.
	 * @param nom - Nom de l'arme.
	 * @return Retourne {@code true} si l'action a réussi, sinon {@code false}.
	 */
	public boolean creerArme(FlagsTypesArmes typeArme, String nom)
	{
		// Logger
		logger.debug("Création d'une nouvelle arme. Type = " + typeArme.getNom() + ", Nom = " + nom + ".");
		
		try
		{
			// Création d'un nouvel objet
			SauvegardeArme sauvegarde = new SauvegardeArme(nom);
			DegatsArme degats1 = new DegatsArme();
			degats1.set(FlagsTypesDegats.DegatsNeutreMin, 1);
			degats1.set(FlagsTypesDegats.DegatsNeutreMax, 1);
			sauvegarde.setDegats(1, degats1);
			Effets effets = new Effets();
			sauvegarde.setEffets(effets);
			
			// Ajout en base de données
			ASQLRequete req = this.bdd.requete("INSERT INTO ARMES(TYPE, NOM, NIVEAU, PANOPLIE, EFFETS, DEGATS_1, CONDITIONS, PO) " + "VALUES(" + typeArme.getId() + ", '" + ASQL.securise(nom) + "', 1, 0, " + effets.sauvegarder(this.bdd, "ARMES", "EFFETS") + ", " + degats1.sauvegarder(this.bdd, "ARMES", "DEGATS_1") + ", null, 1);", true);
			
			// Récupération de la clef auto-générée
			req.getClefs().next();
			int id = (int) req.getClefs().getLong(1);
			sauvegarde.setId(id);

			// Lancement de l'evenement
			ObservateurSauvegardesArmes[] observateurs = (ObservateurSauvegardesArmes[]) this.listeObservateurs.getListeners(ObservateurSauvegardesArmes.class);
			for(ObservateurSauvegardesArmes observateur : observateurs)
			{
				observateur.creationArme(typeArme, sauvegarde);
			}

			return true;
		}
		catch(SQLException exception)
		{
			// Logger
			logger.error("Impossible de créer la nouvelle arme " + nom + " (" + typeArme.getNom() + ").");

			ASQL.erreur(exception);
			return false;
		}
	}

	/**
	 * Créé un nouveau Dofus.
	 * 
	 * @param typeDofus - Type du Dofus.
	 * @param nom - Nom du Dofus.
	 * @return Retourne {@code true} si l'action a réussi, sinon {@code false}.
	 */
	public boolean creerDofus(FlagsTypesDofus typeDofus, String nom)
	{
		// Logger
		logger.debug("Création d'un nouveau Dofus. Type = " + typeDofus.getNom() + ", Nom = " + nom + ".");

		try
		{
			// Création d'un nouvel objet
			SauvegardeDofus sauvegarde = new SauvegardeDofus(nom);

			// Ajout en base de données
			ASQLRequete req = this.bdd.requete("INSERT INTO DOFUS(TYPE, NOM, NIVEAU, EFFETS) " + "VALUES(" + typeDofus.getId() + ", '" + ASQL.securise(nom) + "', 6, " + new Effets().sauvegarder(this.bdd, "Dofus", "EFFETS") + ");", true);
			
			// Récupération de la clef auto-générée
			req.getClefs().next();
			int id = (int) req.getClefs().getLong(1);
			sauvegarde.setId(id);

			// Lancement de l'evenement
			ObservateurSauvegardesDofus[] observateurs = (ObservateurSauvegardesDofus[]) this.listeObservateurs.getListeners(ObservateurSauvegardesDofus.class);
			for(ObservateurSauvegardesDofus observateur : observateurs)
			{
				observateur.creationDofus(typeDofus, sauvegarde);
			}

			return true;
		}
		catch(SQLException exception)
		{
			// Logger
			logger.error("Impossible de créer le nouveau Dofus " + nom + " (" + typeDofus.getNom() + ").");

			ASQL.erreur(exception);
			return false;
		}
	}

	/**
	 * Créé un nouvel équipement.
	 * 
	 * @param typeEquipement - Type de l'équipement.
	 * @param nom - Nom de l'équipement.
	 * @return Retourne {@code true} si l'action a réussi, sinon {@code false}.
	 */
	public boolean creerEquipement(FlagsTypesEquipements typeEquipement, String nom)
	{
		// Logger
		logger.debug("Création d'un nouvel équipement. Type = " + typeEquipement.getNom() + ", Nom = " + nom + ".");

		try
		{
			// Création d'un nouvel objet
			SauvegardeEquipement sauvegarde = new SauvegardeEquipement(nom);

			// Ajout en base de données
			ASQLRequete req = this.bdd.requete("INSERT INTO EQUIPEMENTS(TYPE, NOM, NIVEAU, PANOPLIE, EFFETS, CONDITIONS) " + "VALUES(" + typeEquipement.getId() + ", '" + ASQL.securise(nom) + "', 1, 0, " + new Effets().sauvegarder(this.bdd, "EQUIPEMENTS", "EFFETS") + ", null);", true);

			// Récupération de la clef auto-générée
			req.getClefs().next();
			int id = (int) req.getClefs().getLong(1);
			sauvegarde.setId(id);

			// Lancement de l'evenement
			ObservateurSauvegardesEquipements[] observateurs = (ObservateurSauvegardesEquipements[]) this.listeObservateurs.getListeners(ObservateurSauvegardesEquipements.class);
			for(ObservateurSauvegardesEquipements observateur : observateurs)
			{
				observateur.creationEquipement(typeEquipement, sauvegarde);
			}

			return true;
		}
		catch(SQLException exception)
		{
			// Logger
			logger.error("Impossible de créer le nouvel équipement " + nom + " (" + typeEquipement.getNom() + ").");

			ASQL.erreur(exception);
			return false;
		}
	}

	/**
	 * Créé un nouveau familier.
	 * 
	 * @param nom - Nom du familier.
	 * @return Retourne {@code true} si l'action a réussi, sinon {@code false}.
	 */
	public boolean creerFamilier(String nom)
	{
		// Logger
		logger.debug("Création d'un nouveau familier. Nom = " + nom + ".");

		try
		{
			// Création d'un nouvel objet
			SauvegardeFamilier sauvegarde = new SauvegardeFamilier(nom);

			// Ajout en base de données
			ASQLRequete req = this.bdd.requete("INSERT INTO EQUIPEMENTS(TYPE, NOM, NIVEAU, PANOPLIE, EFFETS, CONDITIONS) " + "VALUES(" + FlagsTypesAnimaux.Familier.getId() + ", '" + ASQL.securise(nom) + "', 1, 0, " + new Effets().sauvegarder(this.bdd, "EQUIPEMENTS", "EFFETS") + ", null);", true);

			// Récupération de la clef auto-générée
			req.getClefs().next();
			int id = (int) req.getClefs().getLong(1);
			sauvegarde.setId(id);

			// Lancement de l'evenement
			ObservateurSauvegardesFamiliers[] observateurs = (ObservateurSauvegardesFamiliers[]) this.listeObservateurs.getListeners(ObservateurSauvegardesFamiliers.class);
			for(ObservateurSauvegardesFamiliers observateur : observateurs)
			{
				observateur.creationFamilier(sauvegarde);
			}

			return true;
		}
		catch(SQLException exception)
		{
			// Logger
			logger.error("Impossible de créer le nouveau familier " + nom + ".");

			ASQL.erreur(exception);
			return false;
		}
	}

	/**
	 * Créé une nouvelle monture.
	 * 
	 * @param nom - Nom de la monture.
	 * @return Retourne {@code true} si l'action a réussi, sinon {@code false}.
	 */
	public boolean creerMonture(String nom)
	{
		// Logger
		logger.debug("Création d'une nouvelle monture. Nom = " + nom + ".");

		try
		{
			// Création d'un nouvel objet
			SauvegardeMonture sauvegarde = new SauvegardeMonture(nom);
			sauvegarde.setRace(1);

			// Ajout en base de données
			ASQLRequete req = this.bdd.requete("INSERT INTO MONTURES(RACE, NOM, NIVEAU, NIVEAU_MONTURE, EFFETS, CONDITIONS) " + "VALUES(1, '" + ASQL.securise(nom) + "', 60, 1, " + new Effets().sauvegarder(this.bdd, "EQUIPEMENTS", "EFFETS") + ", null);", true);
			
			// Récupération de la clef auto-générée
			req.getClefs().next();
			int id = (int) req.getClefs().getLong(1);
			sauvegarde.setId(id);

			// Lancement de l'evenement
			ObservateurSauvegardesMontures[] observateurs = (ObservateurSauvegardesMontures[]) this.listeObservateurs.getListeners(ObservateurSauvegardesMontures.class);
			for(ObservateurSauvegardesMontures observateur : observateurs)
			{
				observateur.creationMonture(sauvegarde);
			}

			return true;
		}
		catch(SQLException exception)
		{
			// Logger
			logger.error("Impossible de créer la nouvelle monture " + nom + ".");

			ASQL.erreur(exception);
			return false;
		}
	}

	/**
	 * Verifie si le groupe {@code nomGroupe} existe.
	 * 
	 * @param nomGroupe - Nom du groupe à tester.
	 * @return Retourne {@code true} si le groupe existe, sinon {@code false}.
	 */
	public boolean existsGroupeObjets(String nomGroupe)
	{
		// Logger
		logger.trace("Appel de ModeleSauvegardes::existsGroupeObjets(Nom=" + nomGroupe + ").");

		try
		{
			ASQLRequete req = this.bdd.requete("SELECT COUNT(*) AS RESULTATS FROM GROUPES_OBJETS WHERE NOM='" + nomGroupe + "'");
			req.getResultats().next();
			int nbResultats = req.getResultats().getInt("RESULTATS");
			
			if(nbResultats == 0)
				return false;
			else
				return true;
		}
		catch(SQLException exception)
		{
			// Logger
			logger.error("Impossible de vérifier l'existance du groupe d'objets " + nomGroupe + ".");

			ASQL.erreur(exception);
			return false;
		}
	}

	/**
	 * Verifie si la sauvegarde {@code nomSauvegarde} des armes existe.
	 * 
	 * @param typeArme - Type de la sauvegarde.
	 * @param nomSauvegarde - Nom de la sauvegarde à tester.
	 * @return Retourne {@code true} si la sauvegarde existe, sinon {@code false}.
	 */
	public boolean existsSauvegardeArme(FlagsTypesArmes typeArme, String nomSauvegarde)
	{
		// Logger
		logger.trace("Appel de ModeleSauvegardes::existsSauvegardeArme(Type=" + typeArme.getNom() + ", Nom=" + nomSauvegarde + ").");

		try
		{
			ASQLRequete req = this.bdd.requete("SELECT COUNT(*) AS RESULTATS FROM ARMES WHERE NOM='" + ASQL.securise(nomSauvegarde) + "' AND TYPE=" + typeArme.getId());
			req.getResultats().next();
			int nbResultats = req.getResultats().getInt("RESULTATS");
			
			if(nbResultats == 0)
				return false;
			else
				return true;
		}
		catch(SQLException exception)
		{
			// Logger
			logger.error("Impossible de vérifier l'existance de la sauvegarde de l'arme " + nomSauvegarde + " (" + typeArme.getNom() + ").");

			ASQL.erreur(exception);
			return false;
		}
	}

	/**
	 * Verifie si la sauvegarde {@code nomSauvegarde} des Dofus existe.
	 * 
	 * @param typeDofus - Type de la sauvegarde.
	 * @param nomSauvegarde - Nom de la sauvegarde à tester.
	 * @return Retourne {@code true} si la sauvegarde existe, sinon {@code false}.
	 */
	public boolean existsSauvegardeDofus(FlagsTypesDofus typeDofus, String nomSauvegarde)
	{
		// Logger
		logger.trace("Appel de ModeleSauvegardes::existsSauvegardeDofus(Type=" + typeDofus.getNom() + ", Nom=" + nomSauvegarde + ").");

		try
		{
			ASQLRequete req = this.bdd.requete("SELECT COUNT(*) AS RESULTATS FROM DOFUS WHERE NOM='" + ASQL.securise(nomSauvegarde) + "' AND TYPE=" + typeDofus.getId());
			req.getResultats().next();
			int nbResultats = req.getResultats().getInt("RESULTATS");
			
			if(nbResultats == 0)
				return false;
			else
				return true;
		}
		catch(SQLException exception)
		{
			// Logger
			logger.error("Impossible de vérifier l'existance de la sauvegarde du Dofus " + nomSauvegarde + " (" + typeDofus.getNom() + ").");

			ASQL.erreur(exception);
			return false;
		}
	}

	/**
	 * Verifie si la sauvegarde {@code nomSauvegarde} des équipements existe.
	 * 
	 * @param typeEquipement - Type de la sauvegarde.
	 * @param nomSauvegarde - Nom de la sauvegarde à tester.
	 * @return Retourne {@code true} si la sauvegarde existe, sinon {@code false}.
	 */
	public boolean existsSauvegardeEquipement(FlagsTypesEquipements typeEquipement, String nomSauvegarde)
	{
		// Logger
		logger.trace("Appel de ModeleSauvegardes::existsSauvegardeEquipement(Type=" + typeEquipement.getNom() + ", Nom=" + nomSauvegarde + ").");

		try
		{
			ASQLRequete req = this.bdd.requete("SELECT COUNT(*) AS RESULTATS FROM EQUIPEMENTS WHERE NOM='" + ASQL.securise(nomSauvegarde) + "' AND TYPE=" + typeEquipement.getId());
			req.getResultats().next();
			int nbResultats = req.getResultats().getInt("RESULTATS");
			
			if(nbResultats == 0)
				return false;
			else
				return true;
		}
		catch(SQLException exception)
		{
			// Logger
			logger.error("Impossible de vérifier l'existance de la sauvegarde d'équipement " + nomSauvegarde + " (" + typeEquipement.getNom() + ").");

			ASQL.erreur(exception);
			return false;
		}
	}

	/**
	 * Verifie si la sauvegarde {@code nomSauvegarde} des personnages existe.
	 * 
	 * @param nomSauvegarde - Nom de la sauvegarde à tester.
	 * @return Retourne {@code true} si la sauvegarde existe, sinon {@code false}.
	 */
	public boolean existsSauvegardePersonnage(String nomSauvegarde)
	{
		// Logger
		logger.trace("Appel de ModeleSauvegardes::existsSauvegardePersonnage(Nom=" + nomSauvegarde + ").");

		try
		{
			ASQLRequete req = this.bdd.requete("SELECT COUNT(*) AS RESULTATS FROM PERSONNAGES WHERE NOM='" + ASQL.securise(nomSauvegarde) + "'");
			req.getResultats().next();
			int nbResultats = req.getResultats().getInt("RESULTATS");
			
			if(nbResultats == 0)
				return false;
			else
				return true;
		}
		catch(SQLException exception)
		{
			// Logger
			logger.error("Impossible de vérifier l'existance de la sauvegarde personnage " + nomSauvegarde + ".");

			ASQL.erreur(exception);
			return false;
		}
	}

	/**
	 * Renvoie la liste des groupes d'objets.
	 * 
	 * @return Une {@code ArrayList} des groupes d'objets.
	 */
	public ArrayList<GroupeObjets> getGroupesObjets()
	{
		// Logger
		logger.trace("Appel de ModeleSauvegardes::getGroupesObjets().");

		try
		{
			ArrayList<GroupeObjets> groupes = new ArrayList<GroupeObjets>();

			ASQLRequete req = this.bdd.requete("SELECT * FROM GROUPES_OBJETS ORDER BY ID ASC");
			ResultSet res = req.getResultats();
			while(res.next())
			{
				GroupeObjets groupe = new GroupeObjets();
				groupe.setId(res.getInt("ID"));
				groupe.setNom(res.getString("NOM"));
				// Equipements
				groupe.setEquipement(FlagsTypesEquipements.Amulette, this.getSauvegardeEquipement(res.getInt("AMULETTE")));
				groupe.setEquipement(FlagsTypesEquipements.AnneauG, this.getSauvegardeEquipement(res.getInt("ANNEAU_G")));
				groupe.setEquipement(FlagsTypesEquipements.AnneauD, this.getSauvegardeEquipement(res.getInt("ANNEAU_D")));
				groupe.setEquipement(FlagsTypesEquipements.Ceinture, this.getSauvegardeEquipement(res.getInt("CEINTURE")));
				groupe.setEquipement(FlagsTypesEquipements.Bottes, this.getSauvegardeEquipement(res.getInt("BOTTES")));
				groupe.setEquipement(FlagsTypesEquipements.Cape, this.getSauvegardeEquipement(res.getInt("CAPE")));
				groupe.setEquipement(FlagsTypesEquipements.Coiffe, this.getSauvegardeEquipement(res.getInt("COIFFE")));
				groupe.setEquipement(FlagsTypesEquipements.Bouclier, this.getSauvegardeEquipement(res.getInt("BOUCLIER")));
				// Arme
				groupe.setArme(this.getSauvegardeArme(res.getInt("ARME")));
				// Animal
				SauvegardeAnimal animal = this.getSauvegardeMonture(res.getInt("MONTURE"));
				if(animal == null)
					animal = this.getSauvegardeMonture(res.getInt("FAMILIER"));
				groupe.setAnimal(animal);
				// Dofus
				groupe.setDofus(FlagsTypesDofus.Cawotte, this.getSauvegardeDofus(res.getInt("DOFUS_CAWOTTE")));
				groupe.setDofus(FlagsTypesDofus.Ocre, this.getSauvegardeDofus(res.getInt("DOFUS_OCRE")));
				groupe.setDofus(FlagsTypesDofus.Vulbis, this.getSauvegardeDofus(res.getInt("DOFUS_VULBIS")));
				groupe.setDofus(FlagsTypesDofus.Emeraude, this.getSauvegardeDofus(res.getInt("DOFUS_EMERAUDE")));
				groupe.setDofus(FlagsTypesDofus.Pourpre, this.getSauvegardeDofus(res.getInt("DOFUS_POURPRE")));
				groupe.setDofus(FlagsTypesDofus.Kaliptus, this.getSauvegardeDofus(res.getInt("DOFUS_KALIPTUS")));
				groupe.setDofus(FlagsTypesDofus.Dofawa, this.getSauvegardeDofus(res.getInt("DOFAWA")));
				groupes.add(groupe);
			}

			return groupes;
		}
		catch(SQLException exception)
		{
			// Logger
			logger.error("Impossible d'obtenir la liste des groupes d'objets.");

			ASQL.erreur(exception);
			return null;
		}
	}

	/**
	 * Renvoie la sauvegarde de l'arme correspondant à l'{@code id}.
	 * 
	 * @param id - Id de la sauvegarde à récupérer.
	 * @return La sauvegarde de l'arme.
	 */
	@SuppressWarnings("unchecked")
	public SauvegardeArme getSauvegardeArme(int id)
	{
		// Logger
		logger.trace("Appel de ModeleSauvegardes::getSauvegardeArme(Id=" + id + ").");
		
		try
		{
			GenerateurRequete generateur = new GenerateurRequete("ARMES", "A");
			generateur.setNomChampTrier("NOM");
			generateur.setSensTriage("ASC");
			ArrayList<String> champsTablePrincipale = new ArrayList<String>();
			champsTablePrincipale.add("ID");
			champsTablePrincipale.add("TYPE");
			champsTablePrincipale.add("NOM");
			//champsTablePrincipale.add("DESCRIPTION");
			champsTablePrincipale.add("NIVEAU");
			champsTablePrincipale.add("CONDITIONS");
			champsTablePrincipale.add("PANOPLIE");
			champsTablePrincipale.add("PA");
			champsTablePrincipale.add("PO");
			champsTablePrincipale.add("CC");
			champsTablePrincipale.add("BONUS_CC");
			champsTablePrincipale.add("EC");
			champsTablePrincipale.add("DEGATS_1");
			champsTablePrincipale.add("DEGATS_2");
			champsTablePrincipale.add("DEGATS_3");
			champsTablePrincipale.add("DEGATS_4");
			champsTablePrincipale.add("DEGATS_5");
			champsTablePrincipale.add("EFFETS");
			//champsTablePrincipale.add("EFFETS_AUTRE");
			generateur.setChampsTablePrincipale(champsTablePrincipale);
			ArrayList<String[]> jointuresEffets = new ArrayList<String[]>();
			jointuresEffets.add(new String[] {"E", "EFFETS"});
			generateur.setJointuresEffets(jointuresEffets);
			ArrayList<String[]> jointuresDegats = new ArrayList<String[]>();
			jointuresDegats.add(new String[] {"D1", "DEGATS_1"});
			jointuresDegats.add(new String[] {"D2", "DEGATS_2"});
			jointuresDegats.add(new String[] {"D3", "DEGATS_3"});
			jointuresDegats.add(new String[] {"D4", "DEGATS_4"});
			jointuresDegats.add(new String[] {"D5", "DEGATS_5"});
			generateur.setJointuresDegats(jointuresDegats);
			generateur.setWhereEgal("ID", id);
			
			ASQLRequete req = this.bdd.requete(generateur.construireRequete());
			ResultSet res = req.getResultats();
			if(ASQL.getRows(res) != 1)
			{
				return null;
			}
			else
			{
				res.next();
				SauvegardeArme sauvegarde = new SauvegardeArme(res.getString("NOM"));
				sauvegarde.setId(res.getInt("ID"));
				sauvegarde.setType(FlagsTypesArmes.getFlag(res.getInt("TYPE")));
				sauvegarde.setNiveau(res.getInt("NIVEAU"));
				sauvegarde.setConditions((ArrayList<Condition>) res.getObject("CONDITIONS"));
				sauvegarde.setPanoplie(res.getInt("PANOPLIE"));
				sauvegarde.setCoupsCritiques(res.getInt("CC"));
				sauvegarde.setDommagesCoupsCritiques(res.getInt("BONUS_CC"));
				sauvegarde.setEchecsCritiques(res.getInt("EC"));
				sauvegarde.setCoutUtilisation(res.getInt("PA"));
				sauvegarde.setEffets(new Effets().charger(res, "E"));
				for(int y = 1; y <= 5; y++)
				{
					if(res.getInt("DEGATS_" + y) != 0)
					{
						sauvegarde.setDegats(y, (DegatsArme) new DegatsArme().charger(res, "D" + y));
					}
				}

				return sauvegarde;
			}
		}
		catch(SQLException exception)
		{
			// Logger
			logger.error("Impossible d'obtenir la sauvegarde de l'arme " + id + ".");

			ASQL.erreur(exception);
			return null;
		}
	}

	/**
	 * Renvoie la sauvegarde du Dofus correspondant à l'{@code id}.
	 * 
	 * @param id - Id de la sauvegarde à récupérer.
	 * @return La sauvegarde du DOfus.
	 */
	public SauvegardeDofus getSauvegardeDofus(int id)
	{
		// Logger
		logger.trace("Appel de ModeleSauvegardes::getSauvegardeDofus(Id=" + id + ").");

		try
		{
			GenerateurRequete generateur = new GenerateurRequete("DOFUS", "D");
			generateur.setNomChampTrier("NOM");
			generateur.setSensTriage("ASC");
			ArrayList<String> champsTablePrincipale = new ArrayList<String>();
			champsTablePrincipale.add("ID");
			champsTablePrincipale.add("NOM");
			champsTablePrincipale.add("TYPE");
			//champsTablePrincipale.add("DESCRIPTION");
			champsTablePrincipale.add("NIVEAU");
			champsTablePrincipale.add("EFFETS");
			generateur.setChampsTablePrincipale(champsTablePrincipale);
			ArrayList<String[]> jointuresEffets = new ArrayList<String[]>();
			jointuresEffets.add(new String[] {"E", "EFFETS"});
			generateur.setJointuresEffets(jointuresEffets);
			generateur.setWhereEgal("ID", id);
			
			ASQLRequete req = this.bdd.requete(generateur.construireRequete());
			ResultSet res = req.getResultats();
			if(ASQL.getRows(res) != 1)
			{
				return null;
			}
			else
			{
				res.next();
				SauvegardeDofus sauvegarde = new SauvegardeDofus(res.getString("NOM"));
				sauvegarde.setId(res.getInt("ID"));
				sauvegarde.setType(FlagsTypesDofus.getFlag(res.getInt("TYPE")));
				sauvegarde.setNiveau(res.getInt("NIVEAU"));
				sauvegarde.setEffets(new Effets().charger(res, "E"));

				return sauvegarde;
			}
		}
		catch(SQLException exception)
		{
			// Logger
			logger.error("Impossible d'obtenir la sauvegarde du Dofus " + id + ".");

			ASQL.erreur(exception);
			return null;
		}
	}

	/**
	 * Renvoie la sauvegarde de l'équipement correspondant à l'{@code id}.
	 * 
	 * @param id - Id de la sauvegarde à récupérer.
	 * @return La sauvegarde de l'équipement.
	 */
	@SuppressWarnings("unchecked")
	public SauvegardeEquipement getSauvegardeEquipement(int id)
	{
		// Logger
		logger.trace("Appel de ModeleSauvegardes::getSauvegardeEquipement(Id=" + id + ").");

		try
		{
			GenerateurRequete generateur = new GenerateurRequete("EQUIPEMENTS", "EQ");
			generateur.setNomChampTrier("NOM");
			generateur.setSensTriage("ASC");
			ArrayList<String> champsTablePrincipale = new ArrayList<String>();
			champsTablePrincipale.add("ID");
			champsTablePrincipale.add("TYPE");
			champsTablePrincipale.add("NOM");
			//champsTablePrincipale.add("DESCRIPTION");
			champsTablePrincipale.add("NIVEAU");
			champsTablePrincipale.add("CONDITIONS");
			champsTablePrincipale.add("PANOPLIE");
			champsTablePrincipale.add("EFFETS");
			//champsTablePrincipale.add("EFFETS_AUTRE");
			generateur.setChampsTablePrincipale(champsTablePrincipale);
			ArrayList<String[]> jointuresEffets = new ArrayList<String[]>();
			jointuresEffets.add(new String[] {"E", "EFFETS"});
			generateur.setJointuresEffets(jointuresEffets);
			generateur.setWhereEgal("ID", id);
			
			ASQLRequete req = this.bdd.requete(generateur.construireRequete());
			ResultSet res = req.getResultats();
			if(ASQL.getRows(res) != 1)
			{
				return null;
			}
			else
			{
				res.next();
				SauvegardeEquipement sauvegarde = new SauvegardeEquipement(res.getString("NOM"));
				sauvegarde.setId(res.getInt("ID"));
				sauvegarde.setType(FlagsTypesEquipements.getFlag(res.getInt("TYPE")));
				sauvegarde.setNiveau(res.getInt("NIVEAU"));
				sauvegarde.setConditions((ArrayList<Condition>) res.getObject("CONDITIONS"));
				sauvegarde.setPanoplie(res.getInt("PANOPLIE"));
				sauvegarde.setEffets(new Effets().charger(res, "E"));

				return sauvegarde;
			}
		}
		catch(SQLException exception)
		{
			// Logger
			logger.error("Impossible d'obtenir la sauvegarde de l'équipement " + id + ".");

			ASQL.erreur(exception);
			return null;
		}
	}

	/**
	 * Renvoie la sauvegarde du familier correspondant à l'{@code id}.
	 * 
	 * @param id - Id de la sauvegarde à récupérer.
	 * @return La sauvegarde du familier.
	 */
	@SuppressWarnings("unchecked")
	public SauvegardeFamilier getSauvegardeFamilier(int id)
	{
		// Logger
		logger.trace("Appel de ModeleSauvegardes::getSauvegardeFamilier(Id=" + id + ").");

		try
		{
			GenerateurRequete generateur = new GenerateurRequete("EQUIPEMENTS", "EQ");
			generateur.setNomChampTrier("NOM");
			generateur.setSensTriage("ASC");
			ArrayList<String> champsTablePrincipale = new ArrayList<String>();
			champsTablePrincipale.add("ID");
			champsTablePrincipale.add("TYPE");
			champsTablePrincipale.add("NOM");
			//champsTablePrincipale.add("DESCRIPTION");
			champsTablePrincipale.add("NIVEAU");
			champsTablePrincipale.add("CONDITIONS");
			champsTablePrincipale.add("PANOPLIE");
			champsTablePrincipale.add("EFFETS");
			//champsTablePrincipale.add("EFFETS_AUTRE");
			generateur.setChampsTablePrincipale(champsTablePrincipale);
			ArrayList<String[]> jointuresEffets = new ArrayList<String[]>();
			jointuresEffets.add(new String[] {"E", "EFFETS"});
			generateur.setJointuresEffets(jointuresEffets);
			generateur.setWhereEgal("ID", id);
			
			ASQLRequete req = this.bdd.requete(generateur.construireRequete());
			ResultSet res = req.getResultats();
			if(ASQL.getRows(res) != 1)
			{
				return null;
			}
			else
			{
				res.next();
				SauvegardeFamilier sauvegarde = new SauvegardeFamilier(res.getString("NOM"));
				sauvegarde.setId(res.getInt("ID"));
				sauvegarde.setNiveau(res.getInt("NIVEAU"));
				sauvegarde.setConditions((ArrayList<Condition>) res.getObject("CONDITIONS"));
				sauvegarde.setPanoplie(res.getInt("PANOPLIE"));
				sauvegarde.setEffets(new Effets().charger(res, "E"));

				return sauvegarde;
			}
		}
		catch(SQLException exception)
		{
			// Logger
			logger.error("Impossible d'obtenir la sauvegarde du familier " + id + ".");

			ASQL.erreur(exception);
			return null;
		}
	}

	/**
	 * Renvoie la sauvegarde de la monture correspondant à l'{@code id}.
	 * 
	 * @param id - Id de la sauvegarde à récupérer.
	 * @return La sauvegarde de l'arme.
	 */
	@SuppressWarnings("unchecked")
	public SauvegardeMonture getSauvegardeMonture(int id)
	{
		// Logger
		logger.trace("Appel de ModeleSauvegardes::getSauvegardeMonture(Id=" + id + ").");

		try
		{
			GenerateurRequete generateur = new GenerateurRequete("MONTURES", "M");
			generateur.setNomChampTrier("NOM");
			generateur.setSensTriage("ASC");
			ArrayList<String> champsTablePrincipale = new ArrayList<String>();
			champsTablePrincipale.add("ID");
			champsTablePrincipale.add("NOM");
			champsTablePrincipale.add("NIVEAU");
			champsTablePrincipale.add("NIVEAU_MONTURE");
			champsTablePrincipale.add("CONDITIONS");
			champsTablePrincipale.add("RACE");
			champsTablePrincipale.add("EFFETS");
			generateur.setChampsTablePrincipale(champsTablePrincipale);
			ArrayList<String[]> jointuresEffets = new ArrayList<String[]>();
			jointuresEffets.add(new String[] {"E", "EFFETS"});
			generateur.setJointuresEffets(jointuresEffets);
			generateur.setWhereEgal("ID", id);
			
			ASQLRequete req = this.bdd.requete(generateur.construireRequete());
			ResultSet res = req.getResultats();
			if(ASQL.getRows(res) != 1)
			{
				return null;
			}
			else
			{
				res.next();
				SauvegardeMonture sauvegarde = new SauvegardeMonture(res.getString("NOM"));
				sauvegarde.setId(res.getInt("ID"));
				sauvegarde.setNiveau(res.getInt("NIVEAU"));
				sauvegarde.setNiveauMonture(res.getInt("NIVEAU_MONTURE"));
				sauvegarde.setConditions((ArrayList<Condition>) res.getObject("CONDITIONS"));
				sauvegarde.setRace(res.getInt("RACE"));
				sauvegarde.setEffets(new Effets().charger(res, "E"));

				return sauvegarde;
			}
		}
		catch(SQLException exception)
		{
			// Logger
			logger.error("Impossible d'obtenir la sauvegarde de la monture " + id + ".");

			ASQL.erreur(exception);
			return null;
		}
	}

	/**
	 * Renvoie la liste des sauvegardes des armes {@code type}.
	 * 
	 * @param typeArme - Type des armes.
	 * @return Une {@code ArrayList} des armes.
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<SauvegardeArme> getSauvegardesArmes(FlagsTypesArmes typeArme)
	{
		// Logger
		logger.trace("Appel de ModeleSauvegardes::getSauvegardesArmes(Type=" + typeArme.getNom() + ").");

		try
		{
			ArrayList<SauvegardeArme> sauvegardes = new ArrayList<SauvegardeArme>();

			GenerateurRequete generateur = new GenerateurRequete("ARMES", "A");
			generateur.setNomChampTrier("NOM");
			generateur.setSensTriage("ASC");
			ArrayList<String> champsTablePrincipale = new ArrayList<String>();
			champsTablePrincipale.add("ID");
			champsTablePrincipale.add("TYPE");
			champsTablePrincipale.add("NOM");
			//champsTablePrincipale.add("DESCRIPTION");
			champsTablePrincipale.add("NIVEAU");
			champsTablePrincipale.add("CONDITIONS");
			champsTablePrincipale.add("PANOPLIE");
			champsTablePrincipale.add("PA");
			champsTablePrincipale.add("PO");
			champsTablePrincipale.add("CC");
			champsTablePrincipale.add("BONUS_CC");
			champsTablePrincipale.add("EC");
			champsTablePrincipale.add("DEGATS_1");
			champsTablePrincipale.add("DEGATS_2");
			champsTablePrincipale.add("DEGATS_3");
			champsTablePrincipale.add("DEGATS_4");
			champsTablePrincipale.add("DEGATS_5");
			champsTablePrincipale.add("EFFETS");
			//champsTablePrincipale.add("EFFETS_AUTRE");
			generateur.setChampsTablePrincipale(champsTablePrincipale);
			ArrayList<String[]> jointuresEffets = new ArrayList<String[]>();
			jointuresEffets.add(new String[] {"E", "EFFETS"});
			generateur.setJointuresEffets(jointuresEffets);
			ArrayList<String[]> jointuresDegats = new ArrayList<String[]>();
			jointuresDegats.add(new String[] {"D1", "DEGATS_1"});
			jointuresDegats.add(new String[] {"D2", "DEGATS_2"});
			jointuresDegats.add(new String[] {"D3", "DEGATS_3"});
			jointuresDegats.add(new String[] {"D4", "DEGATS_4"});
			jointuresDegats.add(new String[] {"D5", "DEGATS_5"});
			generateur.setJointuresDegats(jointuresDegats);
			generateur.setWhereEgal("TYPE", typeArme.getId());
			
			ASQLRequete req = this.bdd.requete(generateur.construireRequete());
			ResultSet res = req.getResultats();
			int i = 0;
			while(res.next())
			{
				SauvegardeArme sauvegarde = new SauvegardeArme(res.getString("NOM"));
				sauvegarde.setIndex(i);
				sauvegarde.setId(res.getInt("ID"));
				sauvegarde.setType(typeArme);
				sauvegarde.setNiveau(res.getInt("NIVEAU"));
				sauvegarde.setConditions((ArrayList<Condition>) res.getObject("CONDITIONS"));
				sauvegarde.setPanoplie(res.getInt("PANOPLIE"));
				sauvegarde.setCoupsCritiques(res.getInt("CC"));
				sauvegarde.setDommagesCoupsCritiques(res.getInt("BONUS_CC"));
				sauvegarde.setEchecsCritiques(res.getInt("EC"));
				sauvegarde.setCoutUtilisation(res.getInt("PA"));
				sauvegarde.setEffets(new Effets().charger(res, "E"));
				for(int y = 1; y <= 5; y++)
				{
					if(res.getInt("DEGATS_" + y) != 0)
					{
						sauvegarde.setDegats(y, (DegatsArme) new DegatsArme().charger(res, "D" + y));
					}
				}
				sauvegardes.add(sauvegarde);
				i++;
			}

			return sauvegardes;
		}
		catch(SQLException exception)
		{
			// Logger
			logger.error("Impossible d'obtenir la liste des sauvegardes des armes " + typeArme.getNom() + ".");

			ASQL.erreur(exception);
			return null;
		}
	}

	/**
	 * Renvoie la liste des sauvegardes des Dofus {@code type}.
	 * 
	 * @param typeDofus - Type des Dofus.
	 * @return Une {@code ArrayList} des armes.
	 */
	public ArrayList<SauvegardeDofus> getSauvegardesDofus(FlagsTypesDofus typeDofus)
	{
		// Logger
		logger.trace("Appel de ModeleSauvegardes::getSauvegardesDofus(Type=" + typeDofus.getNom() + ").");

		try
		{
			ArrayList<SauvegardeDofus> sauvegardes = new ArrayList<SauvegardeDofus>();

			GenerateurRequete generateur = new GenerateurRequete("DOFUS", "D");
			generateur.setNomChampTrier("NOM");
			generateur.setSensTriage("ASC");
			ArrayList<String> champsTablePrincipale = new ArrayList<String>();
			champsTablePrincipale.add("ID");
			champsTablePrincipale.add("NOM");
			//champsTablePrincipale.add("DESCRIPTION");
			champsTablePrincipale.add("NIVEAU");;
			champsTablePrincipale.add("EFFETS");
			generateur.setChampsTablePrincipale(champsTablePrincipale);
			ArrayList<String[]> jointuresEffets = new ArrayList<String[]>();
			jointuresEffets.add(new String[] {"E", "EFFETS"});
			generateur.setJointuresEffets(jointuresEffets);
			generateur.setWhereEgal("TYPE", typeDofus.getId());
			
			ASQLRequete req = this.bdd.requete(generateur.construireRequete());
			ResultSet res = req.getResultats();
			int i = 0;
			while(res.next())
			{
				SauvegardeDofus sauvegarde = new SauvegardeDofus(res.getString("NOM"));
				sauvegarde.setIndex(i);
				sauvegarde.setType(typeDofus);
				sauvegarde.setId(res.getInt("ID"));
				sauvegarde.setNiveau(res.getInt("NIVEAU"));
				sauvegarde.setEffets(new Effets().charger(res, "E"));
				sauvegarde.setType(typeDofus);

				sauvegardes.add(sauvegarde);
				i++;
			}

			return sauvegardes;
		}
		catch(SQLException exception)
		{
			// Logger
			logger.error("Impossible d'obtenir la liste des sauvegardes des Dofus " + typeDofus.getNom() + ".");

			ASQL.erreur(exception);
			return null;
		}
	}

	/**
	 * Renvoie la liste des sauvegardes de l'équipements {@code type}.
	 * 
	 * @param typeEquipement - Type de l'équipement.
	 * @return Une {@code ArrayList} des équipements.
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<SauvegardeEquipement> getSauvegardesEquipements(FlagsTypesEquipements typeEquipement)
	{
		// Logger
		logger.trace("Appel de ModeleSauvegardes::getSauvegardesEquipements(Type=" + typeEquipement.getNom() + ").");

		try
		{
			ArrayList<SauvegardeEquipement> sauvegardes = new ArrayList<SauvegardeEquipement>();
			
			GenerateurRequete generateur = new GenerateurRequete("EQUIPEMENTS", "EQ");
			generateur.setNomChampTrier("NOM");
			generateur.setSensTriage("ASC");
			ArrayList<String> champsTablePrincipale = new ArrayList<String>();
			champsTablePrincipale.add("ID");
			champsTablePrincipale.add("TYPE");
			champsTablePrincipale.add("NOM");
			//champsTablePrincipale.add("DESCRIPTION");
			champsTablePrincipale.add("NIVEAU");
			champsTablePrincipale.add("CONDITIONS");
			champsTablePrincipale.add("PANOPLIE");
			champsTablePrincipale.add("EFFETS");
			//champsTablePrincipale.add("EFFETS_AUTRE");
			generateur.setChampsTablePrincipale(champsTablePrincipale);
			ArrayList<String[]> jointuresEffets = new ArrayList<String[]>();
			jointuresEffets.add(new String[] {"E", "EFFETS"});
			generateur.setJointuresEffets(jointuresEffets);
			generateur.setWhereEgal("TYPE", typeEquipement.getId());
			
				ASQLRequete req = this.bdd.requete(generateur.construireRequete());
			ResultSet res = req.getResultats();
			int i = 0;
			while(res.next())
			{
				SauvegardeEquipement sauvegarde = new SauvegardeEquipement(res.getString("NOM"));
				sauvegarde.setIndex(i);
				sauvegarde.setType(typeEquipement);
				sauvegarde.setId(res.getInt("ID"));
				sauvegarde.setNiveau(res.getInt("NIVEAU"));
				sauvegarde.setConditions((ArrayList<Condition>) res.getObject("CONDITIONS"));
				sauvegarde.setPanoplie(res.getInt("PANOPLIE"));
				sauvegarde.setEffets(new Effets().charger(res, "E"));

				sauvegardes.add(sauvegarde);
				i++;
			}

			return sauvegardes;
		}
		catch(SQLException exception)
		{
			// Logger
			logger.error("Impossible d'obtenir la liste des sauvegardes de l'équipements " + typeEquipement.getNom() + ".");

			ASQL.erreur(exception);
			return null;
		}
	}

	/**
	 * Renvoie la liste des sauvegardes des familiers.
	 * 
	 * @return Une {@code ArrayList} des familers.
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<SauvegardeFamilier> getSauvegardesFamiliers()
	{
		// Logger
		logger.trace("Appel de ModeleSauvegardes::getSauvegardesFamiliers().");

		try
		{
			ArrayList<SauvegardeFamilier> sauvegardes = new ArrayList<SauvegardeFamilier>();

			GenerateurRequete generateur = new GenerateurRequete("EQUIPEMENTS", "EQ");
			generateur.setNomChampTrier("NOM");
			generateur.setSensTriage("ASC");
			ArrayList<String> champsTablePrincipale = new ArrayList<String>();
			champsTablePrincipale.add("ID");
			champsTablePrincipale.add("TYPE");
			champsTablePrincipale.add("NOM");
			//champsTablePrincipale.add("DESCRIPTION");
			champsTablePrincipale.add("NIVEAU");
			champsTablePrincipale.add("CONDITIONS");
			champsTablePrincipale.add("PANOPLIE");
			champsTablePrincipale.add("EFFETS");
			//champsTablePrincipale.add("EFFETS_AUTRE");
			generateur.setChampsTablePrincipale(champsTablePrincipale);
			ArrayList<String[]> jointuresEffets = new ArrayList<String[]>();
			jointuresEffets.add(new String[] {"E", "EFFETS"});
			generateur.setJointuresEffets(jointuresEffets);
			generateur.setWhereEgal("TYPE", FlagsTypesAnimaux.Familier.getId());
			
			ASQLRequete req = this.bdd.requete(generateur.construireRequete());
			ResultSet res = req.getResultats();
			int i = 0;
			while(res.next())
			{
				SauvegardeFamilier sauvegarde = new SauvegardeFamilier(res.getString("NOM"));
				sauvegarde.setIndex(i);
				sauvegarde.setId(res.getInt("ID"));
				sauvegarde.setNiveau(res.getInt("NIVEAU"));
				sauvegarde.setConditions((ArrayList<Condition>) res.getObject("CONDITIONS"));
				sauvegarde.setPanoplie(res.getInt("PANOPLIE"));
				sauvegarde.setEffets(new Effets().charger(res, "E"));

				sauvegardes.add(sauvegarde);
				i++;
			}

			return sauvegardes;
		}
		catch(SQLException exception)
		{
			// Logger
			logger.error("Impossible d'obtenir la liste des sauvegardes des familiers.");

			ASQL.erreur(exception);
			return null;
		}
	}

	/**
	 * Renvoie la liste des sauvegardes des montures.
	 * 
	 * @return Une {@code ArrayList} des montures.
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<SauvegardeMonture> getSauvegardesMontures()
	{
		// Logger
		logger.trace("Appel de ModeleSauvegardes::getSauvegardesMontures().");

		try
		{
			ArrayList<SauvegardeMonture> sauvegardes = new ArrayList<SauvegardeMonture>();

			GenerateurRequete generateur = new GenerateurRequete("MONTURES", "M");
			generateur.setNomChampTrier("NOM");
			generateur.setSensTriage("ASC");
			ArrayList<String> champsTablePrincipale = new ArrayList<String>();
			champsTablePrincipale.add("ID");
			champsTablePrincipale.add("NOM");
			champsTablePrincipale.add("NIVEAU");
			champsTablePrincipale.add("NIVEAU_MONTURE");
			champsTablePrincipale.add("CONDITIONS");
			champsTablePrincipale.add("RACE");
			champsTablePrincipale.add("EFFETS");
			generateur.setChampsTablePrincipale(champsTablePrincipale);
			ArrayList<String[]> jointuresEffets = new ArrayList<String[]>();
			jointuresEffets.add(new String[] {"E", "EFFETS"});
			generateur.setJointuresEffets(jointuresEffets);
			
			ASQLRequete req = this.bdd.requete(generateur.construireRequete());
			ResultSet res = req.getResultats();
			int i = 0;
			while(res.next())
			{
				SauvegardeMonture sauvegarde = new SauvegardeMonture(res.getString("NOM"));
				sauvegarde.setIndex(i);
				sauvegarde.setId(res.getInt("ID"));
				sauvegarde.setNiveau(res.getInt("NIVEAU"));
				sauvegarde.setNiveauMonture(res.getInt("NIVEAU_MONTURE"));
				sauvegarde.setConditions((ArrayList<Condition>) res.getObject("CONDITIONS"));
				sauvegarde.setRace(res.getInt("RACE"));
				sauvegarde.setEffets(new Effets().charger(res, "E"));

				sauvegardes.add(sauvegarde);
				i++;
			}

			return sauvegardes;
		}
		catch(SQLException exception)
		{
			// Logger
			logger.error("Impossible d'obtenir la liste des sauvegardes des montures.");

			ASQL.erreur(exception);
			return null;
		}
	}

	/**
	 * Renvoie la liste des sauvegardes des personnages.
	 * 
	 * @return Une {@code ArrayList} des personnages.
	 */
	public ArrayList<SauvegardePersonnage> getSauvegardesPersonnages()
	{
		// Logger
		logger.trace("Appel de ModeleSauvegardes::getSauvegardesPersonnages().");

		try
		{
			ArrayList<SauvegardePersonnage> sauvegardes = new ArrayList<SauvegardePersonnage>();

			ASQLRequete req = this.bdd.requete("SELECT * FROM PERSONNAGES ORDER BY ID ASC");
			ResultSet res = req.getResultats();
			while(res.next())
			{
				SauvegardePersonnage sauvegarde = new SauvegardePersonnage(res.getString("NOM"));
				sauvegarde.setId(res.getInt("ID"));
				sauvegarde.setNomPerso(res.getString("NOM_PERSO"));
				sauvegarde.setNiveau(res.getInt("NIVEAU"));
				sauvegarde.setClasse(res.getInt("CLASSE"));
				sauvegarde.setSexe(res.getString("SEXE").charAt(0));
				sauvegarde.setAlignement(res.getInt("ALIGNEMENT"));
				sauvegarde.setGrade(res.getInt("GRADE"));
				sauvegarde.setNiveauAlignement(res.getInt("NIVEAU_ALIGNEMENT"));
				sauvegarde.setSpecialisationAlignement(res.getInt("SPE_ALIGNEMENT"));
				sauvegarde.setMaitrise(FlagsTypesArmes.Arc, res.getInt("MAITRISE_ARCS"));
				sauvegarde.setMaitrise(FlagsTypesArmes.Baguette, res.getInt("MAITRISE_BAGUETTES"));
				sauvegarde.setMaitrise(FlagsTypesArmes.Baton, res.getInt("MAITRISE_BATONS"));
				sauvegarde.setMaitrise(FlagsTypesArmes.Dague, res.getInt("MAITRISE_DAGUES"));
				sauvegarde.setMaitrise(FlagsTypesArmes.Epee, res.getInt("MAITRISE_EPEES"));
				sauvegarde.setMaitrise(FlagsTypesArmes.Hache, res.getInt("MAITRISE_HACHES"));
				sauvegarde.setMaitrise(FlagsTypesArmes.Marteau, res.getInt("MAITRISE_MARTEAUX"));
				sauvegarde.setMaitrise(FlagsTypesArmes.Pelle, res.getInt("MAITRISE_PELLES"));
				sauvegarde.setVitalite(res.getInt("VITALITE"));
				sauvegarde.setSagesse(res.getInt("SAGESSE"));
				sauvegarde.setForce(res.getInt("FORCE"));
				sauvegarde.setIntelligence(res.getInt("INTELLIGENCE"));
				sauvegarde.setChance(res.getInt("CHANCE"));
				sauvegarde.setAgilite(res.getInt("AGILITE"));

				// Recupération des niveaux des sorts
				ASQLRequete reqSorts = this.bdd.requete("SELECT * FROM NIVEAUX_SORTS WHERE ID_PERSONNAGE=" + sauvegarde.getId());
				ResultSet resSorts = reqSorts.getResultats();
				while(resSorts.next())
				{
					sauvegarde.setSort(resSorts.getString("NOM_SORT"), resSorts.getInt("NIVEAU_SORT"));
				}

				sauvegardes.add(sauvegarde);
			}

			return sauvegardes;
		}
		catch(SQLException exception)
		{
			// Logger
			logger.error("Impossible d'obtenir la liste des sauvegardes des personnages.");

			ASQL.erreur(exception);
			return null;
		}
	}

	/**
	 * Renomme le groupe d'objets {@code groupe}.
	 * 
	 * @param groupe - Le groupe d'objets à renommer.
	 * @param nouveauNom - Le nouveau nom du groupe.
	 * @return Retourne {@code true} si l'action a réussi, sinon {@code false}.
	 */
	public boolean renommerGroupeObjets(GroupeObjets groupe, String nouveauNom)
	{
		// Logger
		logger.debug("Renommage du groupe " + groupe.getNom() + " en " + nouveauNom + ".");

		this.bdd.requete("UPDATE GROUPES_OBJETS SET NOM='" + ASQL.securise(nouveauNom) + "' WHERE ID=" + groupe.getId());

		// Lancement de l'evenement
		ObservateurGroupeObjets[] observateurs = (ObservateurGroupeObjets[]) this.listeObservateurs.getListeners(ObservateurGroupeObjets.class);
		for(ObservateurGroupeObjets observateur : observateurs)
		{
			observateur.renommageGroupe();
		}

		return true;
	}

	/**
	 * Renomme la sauvegarde {@code sauvegarde} d'un personnage.
	 * 
	 * @param sauvegarde - Le groupe d'objets à renommer.
	 * @param nouveauNom - Le nouveau nom de la sauvegarde.
	 * @return Retourne {@code true} si l'action a réussi, sinon {@code false}.
	 */
	public boolean renommerSauvegardePersonnage(SauvegardePersonnage sauvegarde, String nouveauNom)
	{
		// Logger
		logger.debug("Renommage de la sauvegarde personnage " + sauvegarde.getNom() + " en " + nouveauNom + ".");

		this.bdd.requete("UPDATE PERSONNAGES SET NOM='" + ASQL.securise(nouveauNom) + "' WHERE ID=" + sauvegarde.getId());

		// Lancement de l'evenement
		ObservateurSauvegardesPersonnages[] observateurs = (ObservateurSauvegardesPersonnages[]) this.listeObservateurs.getListeners(ObservateurSauvegardesPersonnages.class);
		for(ObservateurSauvegardesPersonnages observateur : observateurs)
		{
			observateur.renommageSauvegardePersonnage();
		}

		return true;
	}

	/**
	 * Sauvegarde une arme.
	 * 
	 * @param typeArme - Type de l'arme.
	 * @param sauvegarde - Objet sauvegarde de l'arme.
	 * @return Retourne {@code true} si l'action a réussi, sinon {@code false}.
	 */
	public boolean sauvegarderArme(FlagsTypesArmes typeArme, SauvegardeArme sauvegarde)
	{
		// Logger
		logger.debug("Sauvegarde de l'arme " + sauvegarde.getNom() + " (" + typeArme.getNom() + ").");

		String[] listeIdDegats = new String[5];
		for(int i = 1; i <= listeIdDegats.length; i++)
		{
			DegatsArme degats = sauvegarde.getDegats(i);
			
			String idDegats;
			if(degats != null)
				idDegats = String.valueOf(degats.sauvegarder(this.bdd, "ARMES", "DEGATS_" + i));
			else
				idDegats = null;
			
			listeIdDegats[(i - 1)] = idDegats;	
		}

		Object[] parametres = new Object[] { sauvegarde.getNom(), sauvegarde.getNiveau(), sauvegarde.getConditions(), sauvegarde.getPanoplie(), sauvegarde.getEffets().sauvegarder(this.bdd, "ARMES", "EFFETS"), listeIdDegats[0], listeIdDegats[1], listeIdDegats[2], listeIdDegats[3], listeIdDegats[4], sauvegarde.getCoutUtilisation(), sauvegarde.getCoupsCritiques(), sauvegarde.getDommagesCoupsCritiques(), sauvegarde.getEchecsCritiques(), sauvegarde.getId(), typeArme.getId() };
		this.bdd.requetePreparee("UPDATE ARMES SET NOM=?, NIVEAU=?, CONDITIONS=?, PANOPLIE=?, EFFETS=?, DEGATS_1=?, DEGATS_2=?, DEGATS_3=?, DEGATS_4=?, DEGATS_5=?, PA=?, CC=?, BONUS_CC=?, EC=? WHERE ID=? AND TYPE=?", parametres);

		// Lancement de l'evenement
		ObservateurSauvegardesArmes[] observateurs = (ObservateurSauvegardesArmes[]) this.listeObservateurs.getListeners(ObservateurSauvegardesArmes.class);
		for(ObservateurSauvegardesArmes observateur : observateurs)
		{
			observateur.sauvegardeArme(typeArme, sauvegarde);
		}

		return true;
	}

	/**
	 * Sauvegarde un dofus.
	 * 
	 * @param typeDofus - Type du Dofus.
	 * @param sauvegarde - Objet sauvegarde du Dofus.
	 * @return Retourne {@code true} si l'action a réussi, sinon {@code false}.
	 */
	public boolean sauvegarderDofus(FlagsTypesDofus typeDofus, SauvegardeDofus sauvegarde)
	{
		// Logger
		logger.debug("Sauvegarde du Dofus " + sauvegarde.getNom() + " (" + typeDofus.getNom() + ").");

		this.bdd.requete("UPDATE DOFUS SET NOM='" + ASQL.securise(sauvegarde.getNom()) + "', NIVEAU=" + sauvegarde.getNiveau() + ", EFFETS=" + sauvegarde.getEffets().sauvegarder(this.bdd, "DOFUS", "EFFETS") + " WHERE ID=" + sauvegarde.getId() + " AND TYPE=" + typeDofus.getId());

		// Lancement de l'evenement
		ObservateurSauvegardesDofus[] observateurs = (ObservateurSauvegardesDofus[]) this.listeObservateurs.getListeners(ObservateurSauvegardesDofus.class);
		for(ObservateurSauvegardesDofus observateur : observateurs)
		{
			observateur.sauvegardeDofus(typeDofus, sauvegarde);
		}

		return true;
	}

	/**
	 * Sauvegarde un équipement.
	 * 
	 * @param typeEquipement - Type de l'équipement.
	 * @param sauvegarde - Objet sauvegarde de l'équipement.
	 * @return Retourne {@code true} si l'action a réussi, sinon {@code false}.
	 */
	public boolean sauvegarderEquipement(FlagsTypesEquipements typeEquipement, SauvegardeEquipement sauvegarde)
	{
		// Logger
		logger.debug("Sauvegarde de l'équipement " + sauvegarde.getNom() + " (" + typeEquipement.getNom() + ").");

		Object[] parametres = new Object[] { sauvegarde.getNom(), sauvegarde.getNiveau(), sauvegarde.getConditions(), sauvegarde.getPanoplie(), sauvegarde.getEffets().sauvegarder(this.bdd, "EQUIPEMENTS", "EFFETS"), sauvegarde.getId(), typeEquipement.getId() };
		this.bdd.requetePreparee("UPDATE EQUIPEMENTS SET NOM=?, NIVEAU=?, CONDITIONS=?, PANOPLIE=?, EFFETS=? WHERE ID=? AND TYPE=?", parametres);

		// Lancement de l'evenement
		ObservateurSauvegardesEquipements[] observateurs = (ObservateurSauvegardesEquipements[]) this.listeObservateurs.getListeners(ObservateurSauvegardesEquipements.class);
		for(ObservateurSauvegardesEquipements observateur : observateurs)
		{
			observateur.sauvegardeEquipement(typeEquipement, sauvegarde);
		}

		return true;
	}

	/**
	 * Sauvegarde un familier.
	 * 
	 * @param sauvegarde - Objet sauvegarde du familier.
	 * @return Retourne {@code true} si l'action a réussi, sinon {@code false}.
	 */
	public boolean sauvegarderFamilier(SauvegardeFamilier sauvegarde)
	{
		// Logger
		logger.debug("Sauvegarde du familier " + sauvegarde.getNom() + ".");

		Object[] parametres = new Object[] { sauvegarde.getNom(), sauvegarde.getNiveau(), sauvegarde.getConditions(), sauvegarde.getPanoplie(), sauvegarde.getEffets().sauvegarder(this.bdd, "EQUIPEMENTS", "EFFETS"), sauvegarde.getId() };
		this.bdd.requetePreparee("UPDATE EQUIPEMENTS SET NOM=?, NIVEAU=?, CONDITIONS=?, PANOPLIE=?, EFFETS=? WHERE ID=?", parametres);

		// Lancement de l'evenement
		ObservateurSauvegardesFamiliers[] observateurs = (ObservateurSauvegardesFamiliers[]) this.listeObservateurs.getListeners(ObservateurSauvegardesFamiliers.class);
		for(ObservateurSauvegardesFamiliers observateur : observateurs)
		{
			observateur.sauvegardeFamilier(sauvegarde);
		}

		return true;
	}

	/**
	 * Sauvegarde un groupe d'objets.
	 * 
	 * @param groupe - Le groupe d'objets.
	 * @return Retourne {@code true} si l'action a réussi, sinon {@code false}.
	 */
	public boolean sauvegarderGroupeObjets(GroupeObjets groupe)
	{
		// Logger
		logger.debug("Sauvegarde le groupe d'objets " + groupe.getNom() + ".");

		// Equipements
		int idAmulette = (groupe.getEquipement(FlagsTypesEquipements.Amulette) != null) ? groupe.getEquipement(FlagsTypesEquipements.Amulette).getId() : 0;
		int idAnneauG = (groupe.getEquipement(FlagsTypesEquipements.AnneauG) != null) ? groupe.getEquipement(FlagsTypesEquipements.AnneauG).getId() : 0;
		int idAnneauD = (groupe.getEquipement(FlagsTypesEquipements.AnneauD) != null) ? groupe.getEquipement(FlagsTypesEquipements.AnneauD).getId() : 0;
		int idCeinture = (groupe.getEquipement(FlagsTypesEquipements.Ceinture) != null) ? groupe.getEquipement(FlagsTypesEquipements.Ceinture).getId() : 0;
		int idBottes = (groupe.getEquipement(FlagsTypesEquipements.Bottes) != null) ? groupe.getEquipement(FlagsTypesEquipements.Bottes).getId() : 0;
		int idCoiffe = (groupe.getEquipement(FlagsTypesEquipements.Coiffe) != null) ? groupe.getEquipement(FlagsTypesEquipements.Coiffe).getId() : 0;
		int idCape = (groupe.getEquipement(FlagsTypesEquipements.Cape) != null) ? groupe.getEquipement(FlagsTypesEquipements.Cape).getId() : 0;
		int idBouclier = (groupe.getEquipement(FlagsTypesEquipements.Bouclier) != null) ? groupe.getEquipement(FlagsTypesEquipements.Bouclier).getId() : 0;
		// Animal
		SauvegardeAnimal animal = groupe.getAnimal();
		int idFamilier = 0;
		int idMonture = 0;
		if(animal != null)
		{
			if(animal instanceof SauvegardeFamilier)
			{
				idFamilier = animal.getId();
			}
			else
			{
				idFamilier = animal.getId();
			}
		}
		// Arme
		int idArme = (groupe.getArme() != null) ? groupe.getArme().getId() : 0;
		// Dofus
		int idDofusCawotte = (groupe.getDofus(FlagsTypesDofus.Cawotte) != null) ? groupe.getDofus(FlagsTypesDofus.Cawotte).getId() : 0;
		int idDofusOcre = (groupe.getDofus(FlagsTypesDofus.Ocre) != null) ? groupe.getDofus(FlagsTypesDofus.Ocre).getId() : 0;
		int idDofusVulbis = (groupe.getDofus(FlagsTypesDofus.Vulbis) != null) ? groupe.getDofus(FlagsTypesDofus.Vulbis).getId() : 0;
		int idDofusEmeraude = (groupe.getDofus(FlagsTypesDofus.Emeraude) != null) ? groupe.getDofus(FlagsTypesDofus.Emeraude).getId() : 0;
		int idDofusPourpre = (groupe.getDofus(FlagsTypesDofus.Pourpre) != null) ? groupe.getDofus(FlagsTypesDofus.Pourpre).getId() : 0;
		int idDofusKaliptus = (groupe.getDofus(FlagsTypesDofus.Kaliptus) != null) ? groupe.getDofus(FlagsTypesDofus.Kaliptus).getId() : 0;
		int idDofawa = (groupe.getDofus(FlagsTypesDofus.Dofawa) != null) ? groupe.getDofus(FlagsTypesDofus.Dofawa).getId() : 0;

		this.bdd.requete("MERGE INTO GROUPES_OBJETS(nom, amulette, anneau_g, anneau_d, ceinture, bottes, coiffe, cape, familier, monture, bouclier, arme, dofus_cawotte, dofus_ocre, dofus_vulbis, dofus_emeraude, dofus_pourpre, dofus_kaliptus, dofawa) " +
						 "KEY(NOM) " +
						 "VALUES('" + ASQL.securise(groupe.getNom()) + "', " + idAmulette + ", " + idAnneauG + ", " + idAnneauD + ", " + idCeinture + ", " + idBottes + ", " + idCoiffe + ", " + idCape + ", " + idFamilier + ", " + idMonture + ", " + idBouclier + ", " + idArme + ", " + idDofusCawotte + ", " + idDofusOcre + ", " + idDofusVulbis + ", " + idDofusEmeraude + ", " + idDofusPourpre + ", " + idDofusKaliptus + ", " + idDofawa + ")");

		// Lancement de l'evenement
		ObservateurGroupeObjets[] observateurs = (ObservateurGroupeObjets[]) this.listeObservateurs.getListeners(ObservateurGroupeObjets.class);
		for(ObservateurGroupeObjets observateur : observateurs)
		{
			observateur.sauvegardeGroupe();
		}

		return true;
	}

	/**
	 * Sauvegarde une monture.
	 * 
	 * @param sauvegarde - Objet sauvegarde de la monture.
	 * @return Retourne {@code true} si l'action a réussi, sinon {@code false}.
	 */
	public boolean sauvegarderMonture(SauvegardeMonture sauvegarde)
	{
		// Logger
		logger.debug("Sauvegarde de la monture " + sauvegarde.getNom() + ".");

		this.bdd.requete("UPDATE MONTURES SET NOM='" + ASQL.securise(sauvegarde.getNom()) + "', NIVEAU_MONTURE=" + sauvegarde.getNiveauMonture() + ", NIVEAU=" + sauvegarde.getNiveau() + ", EFFETS=" + sauvegarde.getEffets().sauvegarder(this.bdd, "MONTURES", "EFFETS") + ", RACE=" + sauvegarde.getRace() + " WHERE ID=" + sauvegarde.getId());

		// Lancement de l'evenement
		ObservateurSauvegardesMontures[] observateurs = (ObservateurSauvegardesMontures[]) this.listeObservateurs.getListeners(ObservateurSauvegardesMontures.class);
		for(ObservateurSauvegardesMontures observateur : observateurs)
		{
			observateur.sauvegardeMonture(sauvegarde);
		}

		return true;
	}

	/**
	 * Sauvegarde un personnage
	 * 
	 * @param sauvegarde - Objet sauvegarde du personnage.
	 * @return Retourne {@code true} si l'action a réussi, sinon {@code false}.
	 */
	public boolean sauvegarderPersonnage(SauvegardePersonnage sauvegarde)
	{
		// Logger
		logger.debug("Sauvegarde d'un personnage " + sauvegarde.getNomPerso() + " (" + sauvegarde.getNom() + ").");

		try
		{
			String nomSauvegarde = ASQL.securise(sauvegarde.getNom());
			this.bdd.requete("MERGE INTO PERSONNAGES(NOM, NOM_PERSO, NIVEAU, CLASSE, SEXE, ALIGNEMENT, GRADE, NIVEAU_ALIGNEMENT, SPE_ALIGNEMENT, VITALITE, SAGESSE, FORCE, INTELLIGENCE, CHANCE, AGILITE) " +
							 "KEY(NOM) " +
							 "VALUES('" + nomSauvegarde + "', " + "'" + sauvegarde.getNomPerso() + "', " + "'" + sauvegarde.getNiveau() + "', " + "'" + sauvegarde.getClasse() + "', " + "'" + sauvegarde.getSexe() + "', " + "'" + sauvegarde.getAlignement() + "', " + "'" + sauvegarde.getGrade() + "', " + "'" + sauvegarde.getNiveauAlignement() + "', " + "'" + sauvegarde.getSpecialisationAlignement() + "', " + "'" + sauvegarde.getVitalite() + "', " + "'" + sauvegarde.getSagesse() + "', " + "'" + sauvegarde.getForce() + "', " + "'" + sauvegarde.getIntelligence() + "', " + "'" + sauvegarde.getChance() + "', '" + sauvegarde.getAgilite() + "'" + ")", true);
			
			ASQLRequete reqId = this.bdd.requete("SELECT ID FROM PERSONNAGES WHERE NOM='" + nomSauvegarde + "'");
			reqId.getResultats().next();
			int id = reqId.getResultats().getInt("ID");

			// Enregistrement des niveau des sorts

			// Maitrises
			HashMap<FlagsTypesArmes, String> nomChamps = new HashMap<FlagsTypesArmes, String>();
			nomChamps.put(FlagsTypesArmes.Arc, "MAITRISE_ARCS");
			nomChamps.put(FlagsTypesArmes.Baguette, "MAITRISE_BAGUETTES");
			nomChamps.put(FlagsTypesArmes.Baton, "MAITRISE_BATONS");
			nomChamps.put(FlagsTypesArmes.Dague, "MAITRISE_DAGUES");
			nomChamps.put(FlagsTypesArmes.Epee, "MAITRISE_EPEES");
			nomChamps.put(FlagsTypesArmes.Hache, "MAITRISE_HACHES");
			nomChamps.put(FlagsTypesArmes.Marteau, "MAITRISE_MARTEAUX");
			nomChamps.put(FlagsTypesArmes.Pelle, "MAITRISE_PELLES");
			for(Entry<FlagsTypesArmes, String> entry : nomChamps.entrySet())
			{
				this.bdd.requete("UPDATE PERSONNAGES SET " + entry.getValue() + "=" + sauvegarde.getMaitrise(entry.getKey()) + " WHERE ID=" + id);
			}

			// Les sorts
			for(Entry<String, Integer> entry : sauvegarde.getNiveauxSorts().entrySet())
			{
				this.bdd.requete("MERGE INTO NIVEAUX_SORTS(ID_PERSONNAGE, NOM_SORT, NIVEAU_SORT) KEY(ID_PERSONNAGE, NOM_SORT) VALUES(" + id + ", '" + entry.getKey() + "', " + entry.getValue() + ");");
			}

			// Lancement de l'evenement
			ObservateurSauvegardesPersonnages[] observateurs = (ObservateurSauvegardesPersonnages[]) this.listeObservateurs.getListeners(ObservateurSauvegardesPersonnages.class);
			for(ObservateurSauvegardesPersonnages observateur : observateurs)
			{
				observateur.suppressionSauvegardePersonnage();
			}

			return true;
		}
		catch(SQLException e)
		{
			// Logger
			logger.debug("Impossible de sauvegarder le personnage " + sauvegarde.getNomPerso() + " (" + sauvegarde.getNom() + ").");
			
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Supprime la sauvegarde d'une arme.
	 * 
	 * @param typeArme - Type de l'arme.
	 * @param sauvegarde - Objet sauvegarde de l'arme.
	 * @return Retourne {@code true} si l'action a réussi, sinon {@code false}.
	 */
	public boolean supprimerArme(FlagsTypesArmes typeArme, SauvegardeArme sauvegarde)
	{
		// Logger
		logger.debug("Suppression de l'arme " + sauvegarde.getNom() + " (" + typeArme.getNom() + ").");
		
		this.bdd.requete("DELETE FROM ARMES WHERE ID=" + sauvegarde.getId());

		// Lancement de l'evenement
		ObservateurSauvegardesArmes[] observateurs = (ObservateurSauvegardesArmes[]) this.listeObservateurs.getListeners(ObservateurSauvegardesArmes.class);
		for(ObservateurSauvegardesArmes observateur : observateurs)
		{
			observateur.suppressionSauvegardeArme(typeArme);
		}

		return true;
	}

	/**
	 * Supprime la sauvegarde d'un Dofus.
	 * 
	 * @param typeDofus - Type du Dofus.
	 * @param sauvegarde - Objet sauvegarde du Dofus.
	 * @return Retourne {@code true} si l'action a réussi, sinon {@code false}.
	 */
	public boolean supprimerDofus(FlagsTypesDofus typeDofus, SauvegardeDofus sauvegarde)
	{
		// Logger
		logger.debug("Suppression du Dofus " + sauvegarde.getNom() + " (" + typeDofus.getNom() + ").");

		this.bdd.requete("DELETE FROM DOFUS WHERE ID=" + sauvegarde.getId());

		// Lancement de l'evenement
		ObservateurSauvegardesDofus[] observateurs = (ObservateurSauvegardesDofus[]) this.listeObservateurs.getListeners(ObservateurSauvegardesDofus.class);
		for(ObservateurSauvegardesDofus observateur : observateurs)
		{
			observateur.suppressionSauvegardeDofus(typeDofus, sauvegarde);
		}

		return true;
	}

	/**
	 * Supprime la sauvegarde d'un équipement.
	 * 
	 * @param typeEquipement - Type de l'équipement.
	 * @param sauvegarde - Objet sauvegarde de l'équipement.
	 * @return Retourne {@code true} si l'action a réussi, sinon {@code false}.
	 */
	public boolean supprimerEquipement(FlagsTypesEquipements typeEquipement, SauvegardeEquipement sauvegarde)
	{
		// Logger
		logger.debug("Suppression de l'équipement " + sauvegarde.getNom() + " (" + typeEquipement.getNom() + ").");

		this.bdd.requete("DELETE FROM EQUIPEMENTS WHERE ID=" + sauvegarde.getId());

		// Lancement de l'evenement
		ObservateurSauvegardesEquipements[] observateurs = (ObservateurSauvegardesEquipements[]) this.listeObservateurs.getListeners(ObservateurSauvegardesEquipements.class);
		for(ObservateurSauvegardesEquipements observateur : observateurs)
		{
			observateur.suppressionSauvegardeEquipement(typeEquipement, sauvegarde);
		}

		return true;
	}

	/**
	 * Supprime la sauvegarde d'un familier.
	 * 
	 * @param sauvegarde - Objet sauvegarde du familier.
	 * @return Retourne {@code true} si l'action a réussi, sinon {@code false}.
	 */
	public boolean supprimerFamilier(SauvegardeFamilier sauvegarde)
	{
		// Logger
		logger.debug("Suppression du familier " + sauvegarde.getNom() + ".");

		this.bdd.requete("DELETE FROM EQUIPEMENTS WHERE ID=" + sauvegarde.getId());

		// Lancement de l'evenement
		ObservateurSauvegardesFamiliers[] observateurs = (ObservateurSauvegardesFamiliers[]) this.listeObservateurs.getListeners(ObservateurSauvegardesFamiliers.class);
		for(ObservateurSauvegardesFamiliers observateur : observateurs)
		{
			observateur.suppressionSauvegardeFamilier(sauvegarde);
		}

		return true;
	}

	/**
	 * Supprime un groupe d'objets.
	 * 
	 * @param groupe - Le groupe d'objets.
	 * @return Retourne {@code true} si l'action a réussi, sinon {@code false}.
	 */
	public boolean supprimerGroupeObjets(GroupeObjets groupe)
	{
		// Logger
		logger.debug("Suppression du groupe d'objets " + groupe.getNom() + ".");

		this.bdd.requete("DELETE FROM GROUPES_OBJETS WHERE ID='" + groupe.getId() + "'");

		// Lancement de l'evenement
		ObservateurGroupeObjets[] observateurs = (ObservateurGroupeObjets[]) this.listeObservateurs.getListeners(ObservateurGroupeObjets.class);
		for(ObservateurGroupeObjets observateur : observateurs)
		{
			observateur.suppressionGroupe();
		}

		return true;
	}

	/**
	 * Supprime la sauvegarde d'une monture.
	 * 
	 * @param sauvegarde - Objet sauvegarde de la monture.
	 * @return Retourne {@code true} si l'action a réussi, sinon {@code false}.
	 */
	public boolean supprimerMonture(SauvegardeMonture sauvegarde)
	{
		// Logger
		logger.debug("Suppression de la monture " + sauvegarde.getNom() + ".");

		this.bdd.requete("DELETE FROM MONTURES WHERE ID=" + sauvegarde.getId());

		// Lancement de l'evenement
		ObservateurSauvegardesMontures[] observateurs = (ObservateurSauvegardesMontures[]) this.listeObservateurs.getListeners(ObservateurSauvegardesMontures.class);
		for(ObservateurSauvegardesMontures observateur : observateurs)
		{
			observateur.suppressionSauvegardeMonture(sauvegarde);
		}

		return true;
	}

	/**
	 * Supprime la sauvegarde d'un personnage
	 * 
	 * @param sauvegarde - Objet sauvegarde du personnage.
	 * @return Retourne {@code true} si l'action a réussi, sinon {@code false}.
	 */
	public boolean supprimerSauvegardePersonnage(SauvegardePersonnage sauvegarde)
	{
		// Logger
		logger.debug("Suppression de la sauvegarde personnage " + sauvegarde.getNom() + ".");

		this.bdd.requete("DELETE FROM PERSONNAGES WHERE ID='" + sauvegarde.getId() + "'");

		// Lancement de l'evenement
		ObservateurSauvegardesPersonnages[] observateurs = (ObservateurSauvegardesPersonnages[]) this.listeObservateurs.getListeners(ObservateurSauvegardesPersonnages.class);
		for(ObservateurSauvegardesPersonnages observateur : observateurs)
		{
			observateur.suppressionSauvegardePersonnage();
		}

		return true;
	}
}