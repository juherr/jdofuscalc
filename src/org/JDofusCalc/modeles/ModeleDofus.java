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
import java.util.LinkedHashMap;

import org.JDofusCalc.dofus.autres.Classe;
import org.JDofusCalc.dofus.autres.Degats;
import org.JDofusCalc.dofus.autres.DegatsArme;
import org.JDofusCalc.dofus.autres.Effets;
import org.JDofusCalc.dofus.autres.Paliers;
import org.JDofusCalc.dofus.autres.Sort;
import org.JDofusCalc.dofus.conditions.Condition;
import org.JDofusCalc.dofus.objets.Arme;
import org.JDofusCalc.dofus.objets.Dofus;
import org.JDofusCalc.dofus.objets.Equipement;
import org.JDofusCalc.dofus.objets.Familier;
import org.JDofusCalc.dofus.objets.Monture;
import org.JDofusCalc.dofus.objets.Panoplie;
import org.JDofusCalc.dofus.objets.Animal.FlagsTypesAnimaux;
import org.JDofusCalc.dofus.objets.Arme.FlagsTypesArmes;
import org.JDofusCalc.dofus.objets.Dofus.FlagsTypesDofus;
import org.JDofusCalc.dofus.objets.Equipement.FlagsTypesEquipements;

import fr.ayapap.ASQLRequete;
import fr.ayapap.ASQL;

/**
 * Modèle des données pré-enregistrées du jeu Dofus.
 * 
 * @author PAPAYA Alexandre
 * @category Modele
 * @version 1.0
 */
public class ModeleDofus extends Modele
{
	/*
	 * Variables d'instances
	 */
	
	// Caches
	
	/**
	 * Liste des classes.
	 */
	private HashMap<Integer, Classe> cacheClasses = null;
	
	/**
	 * Liste des armes.
	 */
	private HashMap<FlagsTypesArmes, ArrayList<Arme>> cacheArmes = new HashMap<FlagsTypesArmes, ArrayList<Arme>>();
	
	/**
	 * Liste des équipements.
	 */
	private HashMap<FlagsTypesEquipements, ArrayList<Equipement>> cacheEquipements =  new HashMap<FlagsTypesEquipements, ArrayList<Equipement>>();
	
	/**
	 * Liste des panoplies.
	 */
	private HashMap<Integer, Panoplie> cachePanoplies = null;
	
	/**
	 * Liste des sorts.
	 */
	private HashMap<Integer, ArrayList<Sort>> cacheSorts =  new HashMap<Integer, ArrayList<Sort>>();

	
	/*
	 * Constructeurs / Destructeur
	 */

	/**
	 * Construit un nouveau modèle de données du Jeu.
	 * 
	 * @category Constructeur
	 */
	public ModeleDofus()
	{
		// Execution du constructeur père
		super("dofusdatabase");
	}
	
	/*
	 * Méthodes métier de l'application
	 */

	/**
	 * Renvoie les bonus d'une panoplie représentée par son {@code id} en fonction du nombre d'objets équipés {@code nombreObjets}.
	 * 
	 * @param idPanoplie - Id de la panoplie dans la DofusDatabase.
	 * @param nombreObjets - Nombre d'objets équipés.
	 * @return Les bonus contenus dans un objet {@link Effets}.
	 */
	public Effets getBonusPanoplie(int idPanoplie, int nombreObjets)
	{
		// Logger
		logger.trace("Appel de ModeleDofus::getBonusPanoplie(Panoplie=" + idPanoplie + ", Objets=" + nombreObjets + ").");

		try
		{
			String nomChamp = "BONUS_" + nombreObjets + "O";
			GenerateurRequete generateur = new GenerateurRequete("PANOPLIES", "P");
			ArrayList<String> champsTablePrincipale = new ArrayList<String>();
			champsTablePrincipale.add("ID");
			champsTablePrincipale.add(nomChamp);;
			generateur.setChampsTablePrincipale(champsTablePrincipale);
			ArrayList<String[]> jointuresEffets = new ArrayList<String[]>();
			jointuresEffets.add(new String[] {"E", nomChamp});
			generateur.setJointuresEffets(jointuresEffets);
			generateur.setWhereEgal("ID", idPanoplie);
			
			ASQLRequete req = this.bdd.requete(generateur.construireRequete());
			ResultSet res = req.getResultats();
			res.next();
			if(res.getString(nomChamp) != null)
			{
				return new Effets().charger(res, "E");
			}
			else
			{
				return new Effets();
			}
		}
		catch(SQLException exception)
		{
			// Logger
			logger.error("Impossible d'obtenir les bonus de la panoplie " + idPanoplie + " avec " + nombreObjets + " objet(s) équipé(s).");

			ASQL.erreur(exception);
			return null;
		}
	}

	/**
	 * Renvoie la liste des classes de dofus.
	 * 
	 * @return Une {@code HashMap} liant les classes à leurs id.
	 */
	public HashMap<Integer, Classe> getClasses()
	{
		// Logger
		logger.trace("Appel de ModeleDofus::getClasses().");
		
		if(this.cacheClasses == null)
		{
			try
			{
				LinkedHashMap<Integer, Classe> classes = new LinkedHashMap<Integer, Classe>();
	
				ASQLRequete req = this.bdd.requete("SELECT C.ID AS C_ID, C.NOM AS C_NOM, C.DESCRIPTION AS C_DESCRIPTION, C.IMAGE AS C_IMAGE, C.ARME1 AS C_ARME1, C.ARME2 AS C_ARME2, C.PALIERS_VITALITE AS C_PALIERS_VITALITE, C.PALIERS_SAGESSE AS C_PALIERS_SAGESSE, C.PALIERS_FORCE AS C_PALIERS_FORCE, C.PALIERS_INTELLIGENCE AS C_PALIERS_INTELLIGENCE, C.PALIERS_CHANCE AS C_PALIERS_CHANCE, C.PALIERS_AGILITE AS C_PALIERS_AGILITE, C.VIE AS C_VIE, C.PA AS C_PA, C.PM AS C_PM, C.PO AS C_PO, C.INI AS C_INI, C.PP AS C_PP, " +
												   "P_VITA.ID AS P_VITA_ID, P_VITA.UN_POUR_DEUX AS P_VITA_UN_POUR_DEUX, P_VITA.UN_POUR_UN AS P_VITA_UN_POUR_UN, P_VITA.DEUX_POUR_UN AS P_VITA_DEUX_POUR_UN, P_VITA.TROIS_POUR_UN AS P_VITA_TROIS_POUR_UN, P_VITA.QUATRE_POUR_UN AS P_VITA_QUATRE_POUR_UN, P_VITA.CINQ_POUR_UN AS P_VITA_CINQ_POUR_UN, " +
												   "P_SAG.ID AS P_SAG_ID, P_SAG.UN_POUR_DEUX AS P_SAG_UN_POUR_DEUX, P_SAG.UN_POUR_UN AS P_SAG_UN_POUR_UN, P_SAG.DEUX_POUR_UN AS P_SAG_DEUX_POUR_UN, P_SAG.TROIS_POUR_UN AS P_SAG_TROIS_POUR_UN, P_SAG.QUATRE_POUR_UN AS P_SAG_QUATRE_POUR_UN, P_SAG.CINQ_POUR_UN AS P_SAG_CINQ_POUR_UN, " +
												   "P_FORCE.ID AS P_FORCE_ID, P_FORCE.UN_POUR_DEUX AS P_FORCE_UN_POUR_DEUX, P_FORCE.UN_POUR_UN AS P_FORCE_UN_POUR_UN, P_FORCE.DEUX_POUR_UN AS P_FORCE_DEUX_POUR_UN, P_FORCE.TROIS_POUR_UN AS P_FORCE_TROIS_POUR_UN, P_FORCE.QUATRE_POUR_UN AS P_FORCE_QUATRE_POUR_UN, P_FORCE.CINQ_POUR_UN AS P_FORCE_CINQ_POUR_UN, " +
												   "P_INT.ID AS P_INT_ID, P_INT.UN_POUR_DEUX AS P_INT_UN_POUR_DEUX, P_INT.UN_POUR_UN AS P_INT_UN_POUR_UN, P_INT.DEUX_POUR_UN AS P_INT_DEUX_POUR_UN, P_INT.TROIS_POUR_UN AS P_INT_TROIS_POUR_UN, P_INT.QUATRE_POUR_UN AS P_INT_QUATRE_POUR_UN, P_INT.CINQ_POUR_UN AS P_INT_CINQ_POUR_UN, " +
												   "P_CHA.ID AS P_CHA_ID, P_CHA.UN_POUR_DEUX AS P_CHA_UN_POUR_DEUX, P_CHA.UN_POUR_UN AS P_CHA_UN_POUR_UN, P_CHA.DEUX_POUR_UN AS P_CHA_DEUX_POUR_UN, P_CHA.TROIS_POUR_UN AS P_CHA_TROIS_POUR_UN, P_CHA.QUATRE_POUR_UN AS P_CHA_QUATRE_POUR_UN, P_CHA.CINQ_POUR_UN AS P_CHA_CINQ_POUR_UN, " +
												   "P_AGI.ID AS P_AGI_ID, P_AGI.UN_POUR_DEUX AS P_AGI_UN_POUR_DEUX, P_AGI.UN_POUR_UN AS P_AGI_UN_POUR_UN, P_AGI.DEUX_POUR_UN AS P_AGI_DEUX_POUR_UN, P_AGI.TROIS_POUR_UN AS P_AGI_TROIS_POUR_UN, P_AGI.QUATRE_POUR_UN AS P_AGI_QUATRE_POUR_UN, P_AGI.CINQ_POUR_UN AS P_AGI_CINQ_POUR_UN " +
												   "FROM CLASSES AS C " +
												   "LEFT JOIN PALIERS AS P_VITA ON P_VITA.ID = C.PALIERS_VITALITE " +
												   "LEFT JOIN PALIERS AS P_SAG ON P_SAG.ID = C.PALIERS_SAGESSE " +
												   "LEFT JOIN PALIERS AS P_FORCE ON P_FORCE.ID = C.PALIERS_FORCE " +
												   "LEFT JOIN PALIERS AS P_INT ON P_INT.ID = C.PALIERS_INTELLIGENCE " +
												   "LEFT JOIN PALIERS AS P_CHA ON P_CHA.ID = C.PALIERS_CHANCE " +
												   "LEFT JOIN PALIERS AS P_AGI ON P_AGi.ID = C.PALIERS_AGILITE " +
												   "ORDER BY C.NOM ASC");
				ResultSet res = req.getResultats();
				while(res.next())
				{
					Classe classe = new Classe(res.getInt("C_ID"), res.getString("C_NOM"));
					classe.setDescription(res.getString("C_DESCRIPTION"));
					classe.setAvatar(res.getString("C_IMAGE"));
					classe.setArmePrincipale(Arme.FlagsTypesArmes.getFlag(res.getInt("C_ARME1")));
					classe.setArmeSecondaire(Arme.FlagsTypesArmes.getFlag(res.getInt("C_ARME2")));
					classe.setBaseVie(res.getInt("C_VIE"));
					classe.setBasePA(res.getInt("C_PA"));
					classe.setBasePM(res.getInt("C_PM"));
					classe.setBasePO(res.getInt("C_PO"));
					classe.setBaseIni(res.getInt("C_INI"));
					classe.setBasePP(res.getInt("C_PP"));
	
					Paliers paliersVita = new Paliers();
					paliersVita.charger(res, "P_VITA");
					classe.setPaliers("Vitalité", paliersVita);
					Paliers paliersSag = new Paliers();
					paliersSag.charger(res, "P_SAG");
					classe.setPaliers("Sagesse", paliersSag);
					Paliers paliersForce = new Paliers();
					paliersForce.charger(res, "P_FORCE");
					classe.setPaliers("Force", paliersForce);
					Paliers paliersInt = new Paliers();
					paliersInt.charger(res, "P_INT");
					classe.setPaliers("Intelligence", paliersInt);
					Paliers paliersChance = new Paliers();
					paliersChance.charger(res, "P_CHA");
					classe.setPaliers("Chance", paliersChance);
					Paliers paliersAgi = new Paliers();
					paliersAgi.charger(res, "P_AGI");
					classe.setPaliers("Agilité", paliersAgi);
	
					classes.put(res.getInt("C_ID"), classe);
				}
	
				this.cacheClasses = classes;
				return classes;
			}
			catch(SQLException exception)
			{
				// Logger
				logger.error("Impossible d'obtenir la liste des classes.");
				
				ASQL.erreur(exception);
				return null;
			}
		}
		else
		{
			return this.cacheClasses;
		}
	}

	/**
	 * Renvoie le modèle du Dofus démandé.
	 * 
	 * @param type - Type du Dofus.
	 * @return Le modèle du Dofus.
	 */
	public Dofus getModeleDofus(FlagsTypesDofus type)
	{
		// Logger
		logger.trace("Appel de ModeleDofus::getModeleDofus(Type=" + type.getNom() + ").");

		try
		{
			GenerateurRequete generateur = new GenerateurRequete("DOFUS", "D");
			generateur.setNomChampTrier("NOM");
			generateur.setSensTriage("ASC");
			ArrayList<String> champsTablePrincipale = new ArrayList<String>();
			champsTablePrincipale.add("ID");
			champsTablePrincipale.add("NOM");
			//champsTablePrincipale.add("DESCRIPTION");
			champsTablePrincipale.add("NIVEAU");
			champsTablePrincipale.add("EFFETS_MINI");
			champsTablePrincipale.add("EFFETS_MAXI");
			generateur.setChampsTablePrincipale(champsTablePrincipale);
			ArrayList<String[]> jointuresEffets = new ArrayList<String[]>();
			jointuresEffets.add(new String[] {"EMIN", "EFFETS_MINI"});
			jointuresEffets.add(new String[] {"EMAX", "EFFETS_MAXI"});
			generateur.setJointuresEffets(jointuresEffets);
			generateur.setWhereEgal("TYPE", type.getId());
			
			ASQLRequete req = this.bdd.requete(generateur.construireRequete());
			ResultSet res = req.getResultats();
			res.next();

			Dofus dofus = new Dofus(res.getString("NOM"));
			dofus.setId(res.getInt("ID"));
			dofus.setDescription(res.getString("DESCRIPTION"));
			dofus.setNiveau(res.getInt("NIVEAU"));
			dofus.setEffetsMinimums(new Effets().charger(res, "EMIN"));
			dofus.setEffetsMaximums(new Effets().charger(res, "EMAX"));
			
			return dofus;
		}
		catch(SQLException exception)
		{
			// Logger
			logger.error("Impossible d'obtenir le modèle du Dofus " + type.getNom() + ".");

			ASQL.erreur(exception);
			return null;
		}
	}

	/**
	 * Renvoie la liste des modèles des armes {@code type} de dofus.
	 * 
	 * @param type - Type des modèles à renvoyer.
	 * @return Une {@code ArrayList} des armes.
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Arme> getModelesArmes(FlagsTypesArmes type)
	{
		// Logger
		logger.trace("Appel de ModeleDofus::getModelesArmes(Type=" + type.getNom() + ").");

		if(this.cacheArmes.get(type) == null)
		{
			try
			{
				ArrayList<Arme> modeles = new ArrayList<Arme>();
				
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
				champsTablePrincipale.add("EFFETS_MINI");
				champsTablePrincipale.add("EFFETS_MAXI");
				//champsTablePrincipale.add("EFFETS_AUTRE");
				generateur.setChampsTablePrincipale(champsTablePrincipale);
				ArrayList<String[]> jointuresEffets = new ArrayList<String[]>();
				jointuresEffets.add(new String[] {"EMIN", "EFFETS_MINI"});
				jointuresEffets.add(new String[] {"EMAX", "EFFETS_MAXI"});
				generateur.setJointuresEffets(jointuresEffets);
				ArrayList<String[]> jointuresDegats = new ArrayList<String[]>();
				jointuresDegats.add(new String[] {"D1", "DEGATS_1"});
				jointuresDegats.add(new String[] {"D2", "DEGATS_2"});
				jointuresDegats.add(new String[] {"D3", "DEGATS_3"});
				jointuresDegats.add(new String[] {"D4", "DEGATS_4"});
				jointuresDegats.add(new String[] {"D5", "DEGATS_5"});
				generateur.setJointuresDegats(jointuresDegats);
				generateur.setWhereEgal("TYPE", type.getId());
	
				ASQLRequete req = this.bdd.requete(generateur.construireRequete());
				ResultSet res = req.getResultats();
				while(res.next())
				{
					Arme modele = new Arme(res.getString("NOM"));
					modele.setId(res.getInt("ID"));
					modele.setNiveau(res.getInt("NIVEAU"));
					modele.setCoupsCritiques(res.getInt("CC"));
					modele.setDommagesCoupsCritiques(res.getInt("BONUS_CC"));
					modele.setEchecsCritiques(res.getInt("EC"));
					modele.setCoutUtilisation(res.getInt("PA"));
					modele.setPanoplie(res.getInt("PANOPLIE"));
					modele.setConditions((ArrayList<Condition>) res.getObject("CONDITIONS"));
					modele.setEffetsMinimums(new Effets().charger(res, "EMIN"));
					modele.setEffetsMaximums(new Effets().charger(res, "EMAX"));
					for(int i = 1; i <= 5; i++)
					{
						if(res.getInt("DEGATS_" + i) != 0)
						{
							modele.setDegats(i, (DegatsArme) new DegatsArme().charger(res, "D" + i));
						}
					}
					modeles.add(modele);
				}
	
				this.cacheArmes.put(type, modeles);
				return modeles;
			}
			catch(SQLException exception)
			{
				// Logger
				logger.error("Impossible d'obtenir la liste des modèles des armes " + type.getNom() + ".");
	
				ASQL.erreur(exception);
				return null;
			}
		}
		else
		{
			return this.cacheArmes.get(type);
		}
	}

	/**
	 * Renvoie la liste des modèles de l'équipements {@code type} de dofus.
	 * 
	 * @param type - Type de l'équipement.
	 * @return Une {@code ArrayList} des équipements.
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Equipement> getModelesEquipements(FlagsTypesEquipements type)
	{
		// Logger
		logger.trace("Appel de ModeleDofus::getModelesEquipements(Type=" + type.getNom() + ").");
		
		if(this.cacheEquipements.get(type) == null)
		{
			try
			{
				ArrayList<Equipement> modeles = new ArrayList<Equipement>();

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
				champsTablePrincipale.add("EFFETS_MINI");
				champsTablePrincipale.add("EFFETS_MAXI");
				//champsTablePrincipale.add("EFFETS_AUTRE");
				generateur.setChampsTablePrincipale(champsTablePrincipale);
				ArrayList<String[]> jointuresEffets = new ArrayList<String[]>();
				jointuresEffets.add(new String[] { "EMIN", "EFFETS_MINI" });
				jointuresEffets.add(new String[] { "EMAX", "EFFETS_MAXI" });
				generateur.setJointuresEffets(jointuresEffets);
				generateur.setWhereEgal("TYPE", type.getId());

				ASQLRequete req = this.bdd.requete(generateur.construireRequete());
				ResultSet res = req.getResultats();
				while(res.next())
				{
					Equipement modele = new Equipement(res.getString("NOM"));
					modele.setId(res.getInt("ID"));
					modele.setNiveau(res.getInt("NIVEAU"));
					modele.setPanoplie(res.getInt("PANOPLIE"));
					modele.setConditions((ArrayList<Condition>) res.getObject("CONDITIONS"));
					modele.setEffetsMinimums(new Effets().charger(res, "EMIN"));
					modele.setEffetsMaximums(new Effets().charger(res, "EMAX"));

					modeles.add(modele);
				}

				this.cacheEquipements.put(type, modeles);
				return modeles;
			}
			catch(SQLException exception)
			{
				// Logger
				logger.error("Impossible d'obtenir la liste des modèles de l'équipements " + type.getNom() + ".");

				ASQL.erreur(exception);
				return null;
			}
		}
		else
		{
			return this.cacheEquipements.get(type);
		}
	}

	/**
	 *  Renvoie la liste des modèles des familiers de dofus.
	 * 
	 * @return Une {@code ArrayList} des familiers.
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Familier> getModelesFamiliers()
	{
		// Logger
		logger.trace("Appel de ModeleDofus::getModelesFamiliers().");

		try
		{
			ArrayList<Familier> modeles = new ArrayList<Familier>();
			
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
			champsTablePrincipale.add("EFFETS_MINI");
			champsTablePrincipale.add("EFFETS_MAXI");
			//champsTablePrincipale.add("EFFETS_AUTRE");
			generateur.setChampsTablePrincipale(champsTablePrincipale);
			ArrayList<String[]> jointuresEffets = new ArrayList<String[]>();
			jointuresEffets.add(new String[] {"EMIN", "EFFETS_MINI"});
			jointuresEffets.add(new String[] {"EMAX", "EFFETS_MAXI"});
			generateur.setJointuresEffets(jointuresEffets);
			generateur.setWhereEgal("TYPE", FlagsTypesAnimaux.Familier.getId());

			ASQLRequete req = this.bdd.requete(generateur.construireRequete());
			ResultSet res = req.getResultats();
			while(res.next())
			{
				Familier modele = new Familier(res.getString("NOM"));
				modele.setId(res.getInt("ID"));
				modele.setNiveau(res.getInt("NIVEAU"));
				modele.setPanoplie(res.getInt("PANOPLIE"));
				modele.setConditions((ArrayList<Condition>) res.getObject("CONDITIONS"));
				modele.setEffetsMinimums(new Effets().charger(res, "EMIN"));
				modele.setEffetsMaximums(new Effets().charger(res, "EMAX"));

				modeles.add(modele);
			}

			return modeles;
		}
		catch(SQLException exception)
		{
			// Logger
			logger.error("Impossible d'obtenir la liste des modèles des familiers.");

			ASQL.erreur(exception);
			return null;
		}
	}

	/**
	 *  Renvoie la liste des modèles des montures de dofus.
	 * 
	 * @return Une {@code ArrayList} des montures.
	 */
	@SuppressWarnings("unchecked")
	public HashMap<Integer, Monture> getModelesMontures()
	{
		// Logger
		logger.trace("Appel de ModeleDofus::getModelesMontures().");

		try
		{
			HashMap<Integer, Monture> modeles = new HashMap<Integer, Monture>();
			
			GenerateurRequete generateur = new GenerateurRequete("MONTURES", "M");
			generateur.setNomChampTrier("NOM");
			generateur.setSensTriage("ASC");
			ArrayList<String> champsTablePrincipale = new ArrayList<String>();
			champsTablePrincipale.add("ID");
			champsTablePrincipale.add("NOM");
			champsTablePrincipale.add("NIVEAU");
			champsTablePrincipale.add("CONDITIONS");
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
				Monture modele = new Monture(res.getString("NOM"));
				modele.setIndex(i);
				modele.setId(res.getInt("ID"));
				modele.setNiveau(res.getInt("NIVEAU"));
				modele.setConditions((ArrayList<Condition>) res.getObject("CONDITIONS"));
				modele.setEffetsNiveau(new Effets().charger(res, "E"));
				modeles.put(res.getInt("ID"), modele);
				i++;
			}

			return modeles;
		}
		catch(SQLException exception)
		{
			// Logger
			logger.error("Impossible d'obtenir la liste des modèles des montures.");

			ASQL.erreur(exception);
			return null;
		}
	}

	/**
	 * Renvoie la liste des panoplies de dofus.
	 * 
	 * @return Une {@code HashMap} liant les panoplies à leurs id.
	 */
	public HashMap<Integer, Panoplie> getPanoplies()
	{
		// Logger
		logger.trace("Appel de ModeleDofus::getPanoplies().");
		
		if(this.cachePanoplies == null)
		{
			try
			{
				LinkedHashMap<Integer, Panoplie> panoplies = new LinkedHashMap<Integer, Panoplie>();

				GenerateurRequete generateur = new GenerateurRequete("PANOPLIES", "P");
				generateur.setNomChampTrier("NOM");
				generateur.setSensTriage("ASC");
				ArrayList<String> champsTablePrincipale = new ArrayList<String>();
				champsTablePrincipale.add("ID");
				champsTablePrincipale.add("ID_DOFUS");
				champsTablePrincipale.add("NOM");
				champsTablePrincipale.add("NIVEAU");
				champsTablePrincipale.add("NB_OBJETS");
				champsTablePrincipale.add("BONUS_1O");
				champsTablePrincipale.add("BONUS_2O");
				champsTablePrincipale.add("BONUS_3O");
				champsTablePrincipale.add("BONUS_4O");
				champsTablePrincipale.add("BONUS_5O");
				champsTablePrincipale.add("BONUS_6O");
				champsTablePrincipale.add("BONUS_7O");
				champsTablePrincipale.add("BONUS_8O");
				generateur.setChampsTablePrincipale(champsTablePrincipale);
				ArrayList<String[]> jointuresEffets = new ArrayList<String[]>();
				jointuresEffets.add(new String[] { "E1", "BONUS_1O" });
				jointuresEffets.add(new String[] { "E2", "BONUS_2O" });
				jointuresEffets.add(new String[] { "E3", "BONUS_3O" });
				jointuresEffets.add(new String[] { "E4", "BONUS_4O" });
				jointuresEffets.add(new String[] { "E5", "BONUS_5O" });
				jointuresEffets.add(new String[] { "E6", "BONUS_6O" });
				jointuresEffets.add(new String[] { "E7", "BONUS_7O" });
				jointuresEffets.add(new String[] { "E8", "BONUS_8O" });
				generateur.setJointuresEffets(jointuresEffets);

				ASQLRequete req = this.bdd.requete(generateur.construireRequete());
				ResultSet res = req.getResultats();
				while(res.next())
				{
					Panoplie pano = new Panoplie(res.getInt("ID"), res.getString("NOM"));
					pano.setIdDofus(res.getInt("ID_DOFUS"));
					pano.setNiveau(res.getInt("NIVEAU"));
					pano.setNbObjets(res.getInt("NB_OBJETS"));

					if(res.getString("BONUS_1O") != null)
					{
						pano.setBonus(1, new Effets().charger(res, "E1"));
					}
					if(res.getString("BONUS_2O") != null)
					{
						pano.setBonus(2, new Effets().charger(res, "E2"));
					}
					if(res.getString("BONUS_3O") != null)
					{
						pano.setBonus(3, new Effets().charger(res, "E3"));
					}
					if(res.getString("BONUS_4O") != null)
					{
						pano.setBonus(4, new Effets().charger(res, "E4"));
					}
					if(res.getString("BONUS_5O") != null)
					{
						pano.setBonus(5, new Effets().charger(res, "E5"));
					}
					if(res.getString("BONUS_6O") != null)
					{
						pano.setBonus(6, new Effets().charger(res, "E6"));
					}
					if(res.getString("BONUS_7O") != null)
					{
						pano.setBonus(7, new Effets().charger(res, "E7"));
					}
					if(res.getString("BONUS_8O") != null)
					{
						pano.setBonus(8, new Effets().charger(res, "E8"));
					}

					panoplies.put(res.getInt("ID_DOFUS"), pano);
				}

				this.cachePanoplies = panoplies;
				return panoplies;
			}
			catch(SQLException exception)
			{
				// Logger
				logger.error("Impossible d'obtenir la liste des panoplies.");

				ASQL.erreur(exception);
				return null;
			}
		}
		else
		{
			return this.cachePanoplies;
		}
	}

	/**
	 * Renvoie la liste des sorts de la classe {@code classe}.
	 * 
	 * @param classe - La classe.
	 * @return Une {@code ArrayList} des sort.
	 */
	public ArrayList<Sort> getSorts(Classe classe)
	{
		// Logger
		logger.trace("Appel de ModeleDofus::getSorts(Classe=" + classe.getNom() + ").");

		if(this.cacheSorts.get(classe.getId()) == null)
		{
			try
			{
				ArrayList<Sort> sorts = new ArrayList<Sort>();

				ASQLRequete req = this.bdd.requete("SELECT S.ID AS S_ID, S.NOM AS S_NOM, S.NIVEAU AS S_NIVEAU, S.CLASSE AS S_CLASSE, S.NATURE AS S_NATURE, S.NIVEAU_1 AS S_NIVEAU_1, S.NIVEAU_2 AS S_NIVEAU_2, S.NIVEAU_3 AS S_NIVEAU_3, S.NIVEAU_4 AS S_NIVEAU_4, S.NIVEAU_5 AS S_NIVEAU_5, S.NIVEAU_6 AS S_NIVEAU_6, " + "N1.ID AS N1_ID, N1.PA AS N1_PA, N1.CC AS N1_CC, N1.EC AS N1_EC, N1.DEGATS AS N1_DEGATS, N1.DEGATS_CC AS N1_DEGATS_CC, N1.EFFETS AS N1_EFFETS, N1.EFFETS_CC AS N1_EFFETS_CC, " + "N2.ID AS N2_ID, N2.PA AS N2_PA, N2.CC AS N2_CC, N2.EC AS N2_EC, N2.DEGATS AS N2_DEGATS, N2.DEGATS_CC AS N2_DEGATS_CC, N2.EFFETS AS N2_EFFETS, N2.EFFETS_CC AS N2_EFFETS_CC, " + "N3.ID AS N3_ID, N3.PA AS N3_PA, N3.CC AS N3_CC, N3.EC AS N3_EC, N3.DEGATS AS N3_DEGATS, N3.DEGATS_CC AS N3_DEGATS_CC, N3.EFFETS AS N3_EFFETS, N3.EFFETS_CC AS N3_EFFETS_CC, " + "N4.ID AS N4_ID, N4.PA AS N4_PA, N4.CC AS N4_CC, N4.EC AS N4_EC, N4.DEGATS AS N4_DEGATS, N4.DEGATS_CC AS N4_DEGATS_CC, N4.EFFETS AS N4_EFFETS, N4.EFFETS_CC AS N4_EFFETS_CC, " + "N5.ID AS N5_ID, N5.PA AS N5_PA, N5.CC AS N5_CC, N5.EC AS N5_EC, N5.DEGATS AS N5_DEGATS, N5.DEGATS_CC AS N5_DEGATS_CC, N5.EFFETS AS N5_EFFETS, N5.EFFETS_CC AS N5_EFFETS_CC, " + "N6.ID AS N6_ID, N6.PA AS N6_PA, N6.CC AS N6_CC, N6.EC AS N6_EC, N6.DEGATS AS N6_DEGATS, N6.DEGATS_CC AS N6_DEGATS_CC, N6.EFFETS AS N6_EFFETS, N6.EFFETS_CC AS N6_EFFETS_CC, " + "DEGN1.ID AS DEGN1_ID, DEGN1.TABLE AS DEGN1_TABLE, DEGN1.CHAMP AS DEGN1_CHAMP, DEGN1.DEGATS_NEUTRE_MINI AS DEGN1_DEGATS_NEUTRE_MINI, DEGN1.DEGATS_NEUTRE_MAXI AS DEGN1_DEGATS_NEUTRE_MAXI, DEGN1.DEGATS_TERRE_MINI AS DEGN1_DEGATS_TERRE_MINI, DEGN1.DEGATS_TERRE_MAXI AS DEGN1_DEGATS_TERRE_MAXI, DEGN1.DEGATS_FEU_MINI AS DEGN1_DEGATS_FEU_MINI, DEGN1.DEGATS_FEU_MAXI AS DEGN1_DEGATS_FEU_MAXI, DEGN1.DEGATS_EAU_MINI AS DEGN1_DEGATS_EAU_MINI, DEGN1.DEGATS_EAU_MAXI AS DEGN1_DEGATS_EAU_MAXI, DEGN1.DEGATS_AIR_MINI AS DEGN1_DEGATS_AIR_MINI, DEGN1.DEGATS_AIR_MAXI AS DEGN1_DEGATS_AIR_MAXI, DEGN1.VOLE_NEUTRE_MINI AS DEGN1_VOLE_NEUTRE_MINI, DEGN1.VOLE_NEUTRE_MAXI AS DEGN1_VOLE_NEUTRE_MAXI, DEGN1.VOLE_TERRE_MINI AS DEGN1_VOLE_TERRE_MINI, DEGN1.VOLE_TERRE_MAXI AS DEGN1_VOLE_TERRE_MAXI, DEGN1.VOLE_FEU_MINI AS DEGN1_VOLE_FEU_MINI, DEGN1.VOLE_FEU_MAXI AS DEGN1_VOLE_FEU_MAXI, DEGN1.VOLE_EAU_MINI AS DEGN1_VOLE_EAU_MINI, DEGN1.VOLE_EAU_MAXI AS DEGN1_VOLE_EAU_MAXI, DEGN1.VOLE_AIR_MINI AS DEGN1_VOLE_AIR_MINI, DEGN1.VOLE_AIR_MAXI AS DEGN1_VOLE_AIR_MAXI, DEGN1.SOINS_MINI AS DEGN1_SOINS_MINI, DEGN1.SOINS_MAXI AS DEGN1_SOINS_MAXI, " + "DEGCCN1.ID AS DEGCCN1_ID, DEGCCN1.TABLE AS DEGCCN1_TABLE, DEGCCN1.CHAMP AS DEGCCN1_CHAMP, DEGCCN1.DEGATS_NEUTRE_MINI AS DEGCCN1_DEGATS_NEUTRE_MINI, DEGCCN1.DEGATS_NEUTRE_MAXI AS DEGCCN1_DEGATS_NEUTRE_MAXI, DEGCCN1.DEGATS_TERRE_MINI AS DEGCCN1_DEGATS_TERRE_MINI, DEGCCN1.DEGATS_TERRE_MAXI AS DEGCCN1_DEGATS_TERRE_MAXI, DEGCCN1.DEGATS_FEU_MINI AS DEGCCN1_DEGATS_FEU_MINI, DEGCCN1.DEGATS_FEU_MAXI AS DEGCCN1_DEGATS_FEU_MAXI, DEGCCN1.DEGATS_EAU_MINI AS DEGCCN1_DEGATS_EAU_MINI, DEGCCN1.DEGATS_EAU_MAXI AS DEGCCN1_DEGATS_EAU_MAXI, DEGCCN1.DEGATS_AIR_MINI AS DEGCCN1_DEGATS_AIR_MINI, DEGCCN1.DEGATS_AIR_MAXI AS DEGCCN1_DEGATS_AIR_MAXI, DEGCCN1.VOLE_NEUTRE_MINI AS DEGCCN1_VOLE_NEUTRE_MINI, DEGCCN1.VOLE_NEUTRE_MAXI AS DEGCCN1_VOLE_NEUTRE_MAXI, DEGCCN1.VOLE_TERRE_MINI AS DEGCCN1_VOLE_TERRE_MINI, DEGCCN1.VOLE_TERRE_MAXI AS DEGCCN1_VOLE_TERRE_MAXI, DEGCCN1.VOLE_FEU_MINI AS DEGCCN1_VOLE_FEU_MINI, DEGCCN1.VOLE_FEU_MAXI AS DEGCCN1_VOLE_FEU_MAXI, DEGCCN1.VOLE_EAU_MINI AS DEGCCN1_VOLE_EAU_MINI, DEGCCN1.VOLE_EAU_MAXI AS DEGCCN1_VOLE_EAU_MAXI, DEGCCN1.VOLE_AIR_MINI AS DEGCCN1_VOLE_AIR_MINI, DEGCCN1.VOLE_AIR_MAXI AS DEGCCN1_VOLE_AIR_MAXI, DEGCCN1.SOINS_MINI AS DEGCCN1_SOINS_MINI, DEGCCN1.SOINS_MAXI AS DEGCCN1_SOINS_MAXI, " + "DEGN2.ID AS DEGN2_ID, DEGN2.TABLE AS DEGN2_TABLE, DEGN2.CHAMP AS DEGN2_CHAMP, DEGN2.DEGATS_NEUTRE_MINI AS DEGN2_DEGATS_NEUTRE_MINI, DEGN2.DEGATS_NEUTRE_MAXI AS DEGN2_DEGATS_NEUTRE_MAXI, DEGN2.DEGATS_TERRE_MINI AS DEGN2_DEGATS_TERRE_MINI, DEGN2.DEGATS_TERRE_MAXI AS DEGN2_DEGATS_TERRE_MAXI, DEGN2.DEGATS_FEU_MINI AS DEGN2_DEGATS_FEU_MINI, DEGN2.DEGATS_FEU_MAXI AS DEGN2_DEGATS_FEU_MAXI, DEGN2.DEGATS_EAU_MINI AS DEGN2_DEGATS_EAU_MINI, DEGN2.DEGATS_EAU_MAXI AS DEGN2_DEGATS_EAU_MAXI, DEGN2.DEGATS_AIR_MINI AS DEGN2_DEGATS_AIR_MINI, DEGN2.DEGATS_AIR_MAXI AS DEGN2_DEGATS_AIR_MAXI, DEGN2.VOLE_NEUTRE_MINI AS DEGN2_VOLE_NEUTRE_MINI, DEGN2.VOLE_NEUTRE_MAXI AS DEGN2_VOLE_NEUTRE_MAXI, DEGN2.VOLE_TERRE_MINI AS DEGN2_VOLE_TERRE_MINI, DEGN2.VOLE_TERRE_MAXI AS DEGN2_VOLE_TERRE_MAXI, DEGN2.VOLE_FEU_MINI AS DEGN2_VOLE_FEU_MINI, DEGN2.VOLE_FEU_MAXI AS DEGN2_VOLE_FEU_MAXI, DEGN2.VOLE_EAU_MINI AS DEGN2_VOLE_EAU_MINI, DEGN2.VOLE_EAU_MAXI AS DEGN2_VOLE_EAU_MAXI, DEGN2.VOLE_AIR_MINI AS DEGN2_VOLE_AIR_MINI, DEGN2.VOLE_AIR_MAXI AS DEGN2_VOLE_AIR_MAXI, DEGN2.SOINS_MINI AS DEGN2_SOINS_MINI, DEGN2.SOINS_MAXI AS DEGN2_SOINS_MAXI, " + "DEGCCN2.ID AS DEGCCN2_ID, DEGCCN2.TABLE AS DEGCCN2_TABLE, DEGCCN2.CHAMP AS DEGCCN2_CHAMP, DEGCCN2.DEGATS_NEUTRE_MINI AS DEGCCN2_DEGATS_NEUTRE_MINI, DEGCCN2.DEGATS_NEUTRE_MAXI AS DEGCCN2_DEGATS_NEUTRE_MAXI, DEGCCN2.DEGATS_TERRE_MINI AS DEGCCN2_DEGATS_TERRE_MINI, DEGCCN2.DEGATS_TERRE_MAXI AS DEGCCN2_DEGATS_TERRE_MAXI, DEGCCN2.DEGATS_FEU_MINI AS DEGCCN2_DEGATS_FEU_MINI, DEGCCN2.DEGATS_FEU_MAXI AS DEGCCN2_DEGATS_FEU_MAXI, DEGCCN2.DEGATS_EAU_MINI AS DEGCCN2_DEGATS_EAU_MINI, DEGCCN2.DEGATS_EAU_MAXI AS DEGCCN2_DEGATS_EAU_MAXI, DEGCCN2.DEGATS_AIR_MINI AS DEGCCN2_DEGATS_AIR_MINI, DEGCCN2.DEGATS_AIR_MAXI AS DEGCCN2_DEGATS_AIR_MAXI, DEGCCN2.VOLE_NEUTRE_MINI AS DEGCCN2_VOLE_NEUTRE_MINI, DEGCCN2.VOLE_NEUTRE_MAXI AS DEGCCN2_VOLE_NEUTRE_MAXI, DEGCCN2.VOLE_TERRE_MINI AS DEGCCN2_VOLE_TERRE_MINI, DEGCCN2.VOLE_TERRE_MAXI AS DEGCCN2_VOLE_TERRE_MAXI, DEGCCN2.VOLE_FEU_MINI AS DEGCCN2_VOLE_FEU_MINI, DEGCCN2.VOLE_FEU_MAXI AS DEGCCN2_VOLE_FEU_MAXI, DEGCCN2.VOLE_EAU_MINI AS DEGCCN2_VOLE_EAU_MINI, DEGCCN2.VOLE_EAU_MAXI AS DEGCCN2_VOLE_EAU_MAXI, DEGCCN2.VOLE_AIR_MINI AS DEGCCN2_VOLE_AIR_MINI, DEGCCN2.VOLE_AIR_MAXI AS DEGCCN2_VOLE_AIR_MAXI, DEGCCN2.SOINS_MINI AS DEGCCN2_SOINS_MINI, DEGCCN2.SOINS_MAXI AS DEGCCN2_SOINS_MAXI, " + "DEGN3.ID AS DEGN3_ID, DEGN3.TABLE AS DEGN3_TABLE, DEGN3.CHAMP AS DEGN3_CHAMP, DEGN3.DEGATS_NEUTRE_MINI AS DEGN3_DEGATS_NEUTRE_MINI, DEGN3.DEGATS_NEUTRE_MAXI AS DEGN3_DEGATS_NEUTRE_MAXI, DEGN3.DEGATS_TERRE_MINI AS DEGN3_DEGATS_TERRE_MINI, DEGN3.DEGATS_TERRE_MAXI AS DEGN3_DEGATS_TERRE_MAXI, DEGN3.DEGATS_FEU_MINI AS DEGN3_DEGATS_FEU_MINI, DEGN3.DEGATS_FEU_MAXI AS DEGN3_DEGATS_FEU_MAXI, DEGN3.DEGATS_EAU_MINI AS DEGN3_DEGATS_EAU_MINI, DEGN3.DEGATS_EAU_MAXI AS DEGN3_DEGATS_EAU_MAXI, DEGN3.DEGATS_AIR_MINI AS DEGN3_DEGATS_AIR_MINI, DEGN3.DEGATS_AIR_MAXI AS DEGN3_DEGATS_AIR_MAXI, DEGN3.VOLE_NEUTRE_MINI AS DEGN3_VOLE_NEUTRE_MINI, DEGN3.VOLE_NEUTRE_MAXI AS DEGN3_VOLE_NEUTRE_MAXI, DEGN3.VOLE_TERRE_MINI AS DEGN3_VOLE_TERRE_MINI, DEGN3.VOLE_TERRE_MAXI AS DEGN3_VOLE_TERRE_MAXI, DEGN3.VOLE_FEU_MINI AS DEGN3_VOLE_FEU_MINI, DEGN3.VOLE_FEU_MAXI AS DEGN3_VOLE_FEU_MAXI, DEGN3.VOLE_EAU_MINI AS DEGN3_VOLE_EAU_MINI, DEGN3.VOLE_EAU_MAXI AS DEGN3_VOLE_EAU_MAXI, DEGN3.VOLE_AIR_MINI AS DEGN3_VOLE_AIR_MINI, DEGN3.VOLE_AIR_MAXI AS DEGN3_VOLE_AIR_MAXI, DEGN3.SOINS_MINI AS DEGN3_SOINS_MINI, DEGN3.SOINS_MAXI AS DEGN3_SOINS_MAXI, " + "DEGCCN3.ID AS DEGCCN3_ID, DEGCCN3.TABLE AS DEGCCN3_TABLE, DEGCCN3.CHAMP AS DEGCCN3_CHAMP, DEGCCN3.DEGATS_NEUTRE_MINI AS DEGCCN3_DEGATS_NEUTRE_MINI, DEGCCN3.DEGATS_NEUTRE_MAXI AS DEGCCN3_DEGATS_NEUTRE_MAXI, DEGCCN3.DEGATS_TERRE_MINI AS DEGCCN3_DEGATS_TERRE_MINI, DEGCCN3.DEGATS_TERRE_MAXI AS DEGCCN3_DEGATS_TERRE_MAXI, DEGCCN3.DEGATS_FEU_MINI AS DEGCCN3_DEGATS_FEU_MINI, DEGCCN3.DEGATS_FEU_MAXI AS DEGCCN3_DEGATS_FEU_MAXI, DEGCCN3.DEGATS_EAU_MINI AS DEGCCN3_DEGATS_EAU_MINI, DEGCCN3.DEGATS_EAU_MAXI AS DEGCCN3_DEGATS_EAU_MAXI, DEGCCN3.DEGATS_AIR_MINI AS DEGCCN3_DEGATS_AIR_MINI, DEGCCN3.DEGATS_AIR_MAXI AS DEGCCN3_DEGATS_AIR_MAXI, DEGCCN3.VOLE_NEUTRE_MINI AS DEGCCN3_VOLE_NEUTRE_MINI, DEGCCN3.VOLE_NEUTRE_MAXI AS DEGCCN3_VOLE_NEUTRE_MAXI, DEGCCN3.VOLE_TERRE_MINI AS DEGCCN3_VOLE_TERRE_MINI, DEGCCN3.VOLE_TERRE_MAXI AS DEGCCN3_VOLE_TERRE_MAXI, DEGCCN3.VOLE_FEU_MINI AS DEGCCN3_VOLE_FEU_MINI, DEGCCN3.VOLE_FEU_MAXI AS DEGCCN3_VOLE_FEU_MAXI, DEGCCN3.VOLE_EAU_MINI AS DEGCCN3_VOLE_EAU_MINI, DEGCCN3.VOLE_EAU_MAXI AS DEGCCN3_VOLE_EAU_MAXI, DEGCCN3.VOLE_AIR_MINI AS DEGCCN3_VOLE_AIR_MINI, DEGCCN3.VOLE_AIR_MAXI AS DEGCCN3_VOLE_AIR_MAXI, DEGCCN3.SOINS_MINI AS DEGCCN3_SOINS_MINI, DEGCCN3.SOINS_MAXI AS DEGCCN3_SOINS_MAXI, " + "DEGN4.ID AS DEGN4_ID, DEGN4.TABLE AS DEGN4_TABLE, DEGN4.CHAMP AS DEGN4_CHAMP, DEGN4.DEGATS_NEUTRE_MINI AS DEGN4_DEGATS_NEUTRE_MINI, DEGN4.DEGATS_NEUTRE_MAXI AS DEGN4_DEGATS_NEUTRE_MAXI, DEGN4.DEGATS_TERRE_MINI AS DEGN4_DEGATS_TERRE_MINI, DEGN4.DEGATS_TERRE_MAXI AS DEGN4_DEGATS_TERRE_MAXI, DEGN4.DEGATS_FEU_MINI AS DEGN4_DEGATS_FEU_MINI, DEGN4.DEGATS_FEU_MAXI AS DEGN4_DEGATS_FEU_MAXI, DEGN4.DEGATS_EAU_MINI AS DEGN4_DEGATS_EAU_MINI, DEGN4.DEGATS_EAU_MAXI AS DEGN4_DEGATS_EAU_MAXI, DEGN4.DEGATS_AIR_MINI AS DEGN4_DEGATS_AIR_MINI, DEGN4.DEGATS_AIR_MAXI AS DEGN4_DEGATS_AIR_MAXI, DEGN4.VOLE_NEUTRE_MINI AS DEGN4_VOLE_NEUTRE_MINI, DEGN4.VOLE_NEUTRE_MAXI AS DEGN4_VOLE_NEUTRE_MAXI, DEGN4.VOLE_TERRE_MINI AS DEGN4_VOLE_TERRE_MINI, DEGN4.VOLE_TERRE_MAXI AS DEGN4_VOLE_TERRE_MAXI, DEGN4.VOLE_FEU_MINI AS DEGN4_VOLE_FEU_MINI, DEGN4.VOLE_FEU_MAXI AS DEGN4_VOLE_FEU_MAXI, DEGN4.VOLE_EAU_MINI AS DEGN4_VOLE_EAU_MINI, DEGN4.VOLE_EAU_MAXI AS DEGN4_VOLE_EAU_MAXI, DEGN4.VOLE_AIR_MINI AS DEGN4_VOLE_AIR_MINI, DEGN4.VOLE_AIR_MAXI AS DEGN4_VOLE_AIR_MAXI, DEGN4.SOINS_MINI AS DEGN4_SOINS_MINI, DEGN4.SOINS_MAXI AS DEGN4_SOINS_MAXI, " + "DEGCCN4.ID AS DEGCCN4_ID, DEGCCN4.TABLE AS DEGCCN4_TABLE, DEGCCN4.CHAMP AS DEGCCN4_CHAMP, DEGCCN4.DEGATS_NEUTRE_MINI AS DEGCCN4_DEGATS_NEUTRE_MINI, DEGCCN4.DEGATS_NEUTRE_MAXI AS DEGCCN4_DEGATS_NEUTRE_MAXI, DEGCCN4.DEGATS_TERRE_MINI AS DEGCCN4_DEGATS_TERRE_MINI, DEGCCN4.DEGATS_TERRE_MAXI AS DEGCCN4_DEGATS_TERRE_MAXI, DEGCCN4.DEGATS_FEU_MINI AS DEGCCN4_DEGATS_FEU_MINI, DEGCCN4.DEGATS_FEU_MAXI AS DEGCCN4_DEGATS_FEU_MAXI, DEGCCN4.DEGATS_EAU_MINI AS DEGCCN4_DEGATS_EAU_MINI, DEGCCN4.DEGATS_EAU_MAXI AS DEGCCN4_DEGATS_EAU_MAXI, DEGCCN4.DEGATS_AIR_MINI AS DEGCCN4_DEGATS_AIR_MINI, DEGCCN4.DEGATS_AIR_MAXI AS DEGCCN4_DEGATS_AIR_MAXI, DEGCCN4.VOLE_NEUTRE_MINI AS DEGCCN4_VOLE_NEUTRE_MINI, DEGCCN4.VOLE_NEUTRE_MAXI AS DEGCCN4_VOLE_NEUTRE_MAXI, DEGCCN4.VOLE_TERRE_MINI AS DEGCCN4_VOLE_TERRE_MINI, DEGCCN4.VOLE_TERRE_MAXI AS DEGCCN4_VOLE_TERRE_MAXI, DEGCCN4.VOLE_FEU_MINI AS DEGCCN4_VOLE_FEU_MINI, DEGCCN4.VOLE_FEU_MAXI AS DEGCCN4_VOLE_FEU_MAXI, DEGCCN4.VOLE_EAU_MINI AS DEGCCN4_VOLE_EAU_MINI, DEGCCN4.VOLE_EAU_MAXI AS DEGCCN4_VOLE_EAU_MAXI, DEGCCN4.VOLE_AIR_MINI AS DEGCCN4_VOLE_AIR_MINI, DEGCCN4.VOLE_AIR_MAXI AS DEGCCN4_VOLE_AIR_MAXI, DEGCCN4.SOINS_MINI AS DEGCCN4_SOINS_MINI, DEGCCN4.SOINS_MAXI AS DEGCCN4_SOINS_MAXI, " + "DEGN5.ID AS DEGN5_ID, DEGN5.TABLE AS DEGN5_TABLE, DEGN5.CHAMP AS DEGN5_CHAMP, DEGN5.DEGATS_NEUTRE_MINI AS DEGN5_DEGATS_NEUTRE_MINI, DEGN5.DEGATS_NEUTRE_MAXI AS DEGN5_DEGATS_NEUTRE_MAXI, DEGN5.DEGATS_TERRE_MINI AS DEGN5_DEGATS_TERRE_MINI, DEGN5.DEGATS_TERRE_MAXI AS DEGN5_DEGATS_TERRE_MAXI, DEGN5.DEGATS_FEU_MINI AS DEGN5_DEGATS_FEU_MINI, DEGN5.DEGATS_FEU_MAXI AS DEGN5_DEGATS_FEU_MAXI, DEGN5.DEGATS_EAU_MINI AS DEGN5_DEGATS_EAU_MINI, DEGN5.DEGATS_EAU_MAXI AS DEGN5_DEGATS_EAU_MAXI, DEGN5.DEGATS_AIR_MINI AS DEGN5_DEGATS_AIR_MINI, DEGN5.DEGATS_AIR_MAXI AS DEGN5_DEGATS_AIR_MAXI, DEGN5.VOLE_NEUTRE_MINI AS DEGN5_VOLE_NEUTRE_MINI, DEGN5.VOLE_NEUTRE_MAXI AS DEGN5_VOLE_NEUTRE_MAXI, DEGN5.VOLE_TERRE_MINI AS DEGN5_VOLE_TERRE_MINI, DEGN5.VOLE_TERRE_MAXI AS DEGN5_VOLE_TERRE_MAXI, DEGN5.VOLE_FEU_MINI AS DEGN5_VOLE_FEU_MINI, DEGN5.VOLE_FEU_MAXI AS DEGN5_VOLE_FEU_MAXI, DEGN5.VOLE_EAU_MINI AS DEGN5_VOLE_EAU_MINI, DEGN5.VOLE_EAU_MAXI AS DEGN5_VOLE_EAU_MAXI, DEGN5.VOLE_AIR_MINI AS DEGN5_VOLE_AIR_MINI, DEGN5.VOLE_AIR_MAXI AS DEGN5_VOLE_AIR_MAXI, DEGN5.SOINS_MINI AS DEGN5_SOINS_MINI, DEGN5.SOINS_MAXI AS DEGN5_SOINS_MAXI, " + "DEGCCN5.ID AS DEGCCN5_ID, DEGCCN5.TABLE AS DEGCCN5_TABLE, DEGCCN5.CHAMP AS DEGCCN5_CHAMP, DEGCCN5.DEGATS_NEUTRE_MINI AS DEGCCN5_DEGATS_NEUTRE_MINI, DEGCCN5.DEGATS_NEUTRE_MAXI AS DEGCCN5_DEGATS_NEUTRE_MAXI, DEGCCN5.DEGATS_TERRE_MINI AS DEGCCN5_DEGATS_TERRE_MINI, DEGCCN5.DEGATS_TERRE_MAXI AS DEGCCN5_DEGATS_TERRE_MAXI, DEGCCN5.DEGATS_FEU_MINI AS DEGCCN5_DEGATS_FEU_MINI, DEGCCN5.DEGATS_FEU_MAXI AS DEGCCN5_DEGATS_FEU_MAXI, DEGCCN5.DEGATS_EAU_MINI AS DEGCCN5_DEGATS_EAU_MINI, DEGCCN5.DEGATS_EAU_MAXI AS DEGCCN5_DEGATS_EAU_MAXI, DEGCCN5.DEGATS_AIR_MINI AS DEGCCN5_DEGATS_AIR_MINI, DEGCCN5.DEGATS_AIR_MAXI AS DEGCCN5_DEGATS_AIR_MAXI, DEGCCN5.VOLE_NEUTRE_MINI AS DEGCCN5_VOLE_NEUTRE_MINI, DEGCCN5.VOLE_NEUTRE_MAXI AS DEGCCN5_VOLE_NEUTRE_MAXI, DEGCCN5.VOLE_TERRE_MINI AS DEGCCN5_VOLE_TERRE_MINI, DEGCCN5.VOLE_TERRE_MAXI AS DEGCCN5_VOLE_TERRE_MAXI, DEGCCN5.VOLE_FEU_MINI AS DEGCCN5_VOLE_FEU_MINI, DEGCCN5.VOLE_FEU_MAXI AS DEGCCN5_VOLE_FEU_MAXI, DEGCCN5.VOLE_EAU_MINI AS DEGCCN5_VOLE_EAU_MINI, DEGCCN5.VOLE_EAU_MAXI AS DEGCCN5_VOLE_EAU_MAXI, DEGCCN5.VOLE_AIR_MINI AS DEGCCN5_VOLE_AIR_MINI, DEGCCN5.VOLE_AIR_MAXI AS DEGCCN5_VOLE_AIR_MAXI, DEGCCN5.SOINS_MINI AS DEGCCN5_SOINS_MINI, DEGCCN5.SOINS_MAXI AS DEGCCN5_SOINS_MAXI, " + "DEGN6.ID AS DEGN6_ID, DEGN6.TABLE AS DEGN6_TABLE, DEGN6.CHAMP AS DEGN6_CHAMP, DEGN6.DEGATS_NEUTRE_MINI AS DEGN6_DEGATS_NEUTRE_MINI, DEGN6.DEGATS_NEUTRE_MAXI AS DEGN6_DEGATS_NEUTRE_MAXI, DEGN6.DEGATS_TERRE_MINI AS DEGN6_DEGATS_TERRE_MINI, DEGN6.DEGATS_TERRE_MAXI AS DEGN6_DEGATS_TERRE_MAXI, DEGN6.DEGATS_FEU_MINI AS DEGN6_DEGATS_FEU_MINI, DEGN6.DEGATS_FEU_MAXI AS DEGN6_DEGATS_FEU_MAXI, DEGN6.DEGATS_EAU_MINI AS DEGN6_DEGATS_EAU_MINI, DEGN6.DEGATS_EAU_MAXI AS DEGN6_DEGATS_EAU_MAXI, DEGN6.DEGATS_AIR_MINI AS DEGN6_DEGATS_AIR_MINI, DEGN6.DEGATS_AIR_MAXI AS DEGN6_DEGATS_AIR_MAXI, DEGN6.VOLE_NEUTRE_MINI AS DEGN6_VOLE_NEUTRE_MINI, DEGN6.VOLE_NEUTRE_MAXI AS DEGN6_VOLE_NEUTRE_MAXI, DEGN6.VOLE_TERRE_MINI AS DEGN6_VOLE_TERRE_MINI, DEGN6.VOLE_TERRE_MAXI AS DEGN6_VOLE_TERRE_MAXI, DEGN6.VOLE_FEU_MINI AS DEGN6_VOLE_FEU_MINI, DEGN6.VOLE_FEU_MAXI AS DEGN6_VOLE_FEU_MAXI, DEGN6.VOLE_EAU_MINI AS DEGN6_VOLE_EAU_MINI, DEGN6.VOLE_EAU_MAXI AS DEGN6_VOLE_EAU_MAXI, DEGN6.VOLE_AIR_MINI AS DEGN6_VOLE_AIR_MINI, DEGN6.VOLE_AIR_MAXI AS DEGN6_VOLE_AIR_MAXI, DEGN6.SOINS_MINI AS DEGN6_SOINS_MINI, DEGN6.SOINS_MAXI AS DEGN6_SOINS_MAXI, " + "DEGCCN6.ID AS DEGCCN6_ID, DEGCCN6.TABLE AS DEGCCN6_TABLE, DEGCCN6.CHAMP AS DEGCCN6_CHAMP, DEGCCN6.DEGATS_NEUTRE_MINI AS DEGCCN6_DEGATS_NEUTRE_MINI, DEGCCN6.DEGATS_NEUTRE_MAXI AS DEGCCN6_DEGATS_NEUTRE_MAXI, DEGCCN6.DEGATS_TERRE_MINI AS DEGCCN6_DEGATS_TERRE_MINI, DEGCCN6.DEGATS_TERRE_MAXI AS DEGCCN6_DEGATS_TERRE_MAXI, DEGCCN6.DEGATS_FEU_MINI AS DEGCCN6_DEGATS_FEU_MINI, DEGCCN6.DEGATS_FEU_MAXI AS DEGCCN6_DEGATS_FEU_MAXI, DEGCCN6.DEGATS_EAU_MINI AS DEGCCN6_DEGATS_EAU_MINI, DEGCCN6.DEGATS_EAU_MAXI AS DEGCCN6_DEGATS_EAU_MAXI, DEGCCN6.DEGATS_AIR_MINI AS DEGCCN6_DEGATS_AIR_MINI, DEGCCN6.DEGATS_AIR_MAXI AS DEGCCN6_DEGATS_AIR_MAXI, DEGCCN6.VOLE_NEUTRE_MINI AS DEGCCN6_VOLE_NEUTRE_MINI, DEGCCN6.VOLE_NEUTRE_MAXI AS DEGCCN6_VOLE_NEUTRE_MAXI, DEGCCN6.VOLE_TERRE_MINI AS DEGCCN6_VOLE_TERRE_MINI, DEGCCN6.VOLE_TERRE_MAXI AS DEGCCN6_VOLE_TERRE_MAXI, DEGCCN6.VOLE_FEU_MINI AS DEGCCN6_VOLE_FEU_MINI, DEGCCN6.VOLE_FEU_MAXI AS DEGCCN6_VOLE_FEU_MAXI, DEGCCN6.VOLE_EAU_MINI AS DEGCCN6_VOLE_EAU_MINI, DEGCCN6.VOLE_EAU_MAXI AS DEGCCN6_VOLE_EAU_MAXI, DEGCCN6.VOLE_AIR_MINI AS DEGCCN6_VOLE_AIR_MINI, DEGCCN6.VOLE_AIR_MAXI AS DEGCCN6_VOLE_AIR_MAXI, DEGCCN6.SOINS_MINI AS DEGCCN6_SOINS_MINI, DEGCCN6.SOINS_MAXI AS DEGCCN6_SOINS_MAXI " + "FROM SORTS AS S " + "LEFT JOIN NIVEAUX_SORTS AS N1 ON N1.ID = S.NIVEAU_1 " + "LEFT JOIN NIVEAUX_SORTS AS N2 ON N2.ID = S.NIVEAU_2 " + "LEFT JOIN NIVEAUX_SORTS AS N3 ON N3.ID = S.NIVEAU_3 " + "LEFT JOIN NIVEAUX_SORTS AS N4 ON N4.ID = S.NIVEAU_4 " + "LEFT JOIN NIVEAUX_SORTS AS N5 ON N5.ID = S.NIVEAU_5 " + "LEFT JOIN NIVEAUX_SORTS AS N6 ON N6.ID = S.NIVEAU_6 " + "LEFT JOIN DEGATS AS DEGN1 ON DEGN1.ID = N1.DEGATS " + "LEFT JOIN DEGATS AS DEGCCN1 ON DEGCCN1.ID = N1.DEGATS_CC " + "LEFT JOIN DEGATS AS DEGN2 ON DEGN2.ID = N2.DEGATS " + "LEFT JOIN DEGATS AS DEGCCN2 ON DEGCCN2.ID = N2.DEGATS_CC " + "LEFT JOIN DEGATS AS DEGN3 ON DEGN3.ID = N3.DEGATS " + "LEFT JOIN DEGATS AS DEGCCN3 ON DEGCCN3.ID = N3.DEGATS_CC " + "LEFT JOIN DEGATS AS DEGN4 ON DEGN4.ID = N4.DEGATS " + "LEFT JOIN DEGATS AS DEGCCN4 ON DEGCCN4.ID = N4.DEGATS_CC " + "LEFT JOIN DEGATS AS DEGN5 ON DEGN5.ID = N5.DEGATS " + "LEFT JOIN DEGATS AS DEGCCN5 ON DEGCCN5.ID = N5.DEGATS_CC " + "LEFT JOIN DEGATS AS DEGN6 ON DEGN6.ID = N6.DEGATS " + "LEFT JOIN DEGATS AS DEGCCN6 ON DEGCCN6.ID = N6.DEGATS_CC " + "WHERE S.CLASSE=" + classe.getId() + " OR S.CLASSE=0 ORDER BY S.ID ASC");
				ResultSet res = req.getResultats();
				while(res.next())
				{
					Sort sort = new Sort(res.getString("NOM"));
					sort.setId(res.getInt("ID"));
					sort.setNature(Sort.NatureSortsFlags.getType(res.getString("NATURE")));

					for(int i = 1; i <= 6; i++)
					{
						sort.set(i, "PA", res.getString("N" + i + "_PA"));
						sort.set(i, "CC", res.getString("N" + i + "_CC"));
						sort.set(i, "EC", res.getString("N" + i + "_EC"));
						sort.set(i, "Degats", new Degats().charger(res, "DEGN" + i));
						sort.set(i, "DegatsCC", new Degats().charger(res, "DEGCCN" + i));
					}

					sorts.add(sort);
				}

				this.cacheSorts.put(classe.getId(), sorts);
				return sorts;
			}
			catch(SQLException exception)
			{
				// Logger
				logger.error("Impossible d'obtenir les liste des sorts de la classe " + classe.getNom() + ".");

				ASQL.erreur(exception);
				return null;
			}
		}
		else
		{
			return this.cacheSorts.get(classe.getId());
		}
	}
}