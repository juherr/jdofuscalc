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

package org.JDofusCalc.controleurs;

import org.JDofusCalc.dofus.autres.Classe;
import org.JDofusCalc.dofus.autres.Effets;
import org.JDofusCalc.dofus.autres.Sort;
import org.JDofusCalc.dofus.objets.Arme.FlagsTypesArmes;
import org.JDofusCalc.dofus.objets.Dofus.FlagsTypesDofus;
import org.JDofusCalc.dofus.objets.Equipement.FlagsTypesEquipements;
import org.JDofusCalc.dofus.sauvegardes.GroupeObjets;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeArme;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeDofus;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeEquipement;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeFamilier;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeMonture;
import org.JDofusCalc.dofus.sauvegardes.SauvegardePersonnage;
import org.JDofusCalc.modeles.ModeleCalculateur;
import org.JDofusCalc.modeles.ModeleDofus;
import org.JDofusCalc.modeles.ModeleSauvegardes;
import org.JDofusCalc.vues.Qt.VQtCalcCaracteristiques;
import org.JDofusCalc.vues.Qt.VQtEcranDemarrage;
import org.JDofusCalc.vues.Qt.VQtExportation;
import org.JDofusCalc.vues.Qt.VQtPrincipale;

/**
 * Controleur principal de l'application.
 * 
 * @author PAPAYA Alexandre
 * @category Controleur
 * @version 1.0
 */
public class ControleurPrincipal extends Controleur
{
	/*
	 * Variables d'instances
	 */
	
	/**
	 * Vue du controleur.
	 */
	private VQtPrincipale vue;

	/**
	 * Vue de l'écran de démarrage.
	 */
	private VQtEcranDemarrage splash;

	/**
	 * Modèle {@link ModeleDofus} du controleur.
	 */
	private ModeleDofus modeleDofus;
	/**
	 * Modèle {@link ModeleDofus} du controleur.
	 */
	private ModeleSauvegardes modeleSauvegardes;
	/**
	 * Modèle {@link ModeleCalculateur} du controleur
	 */
	private ModeleCalculateur modeleCalculateur;

	/**
	 * Variable témoin des sauvegardes des personnages.
	 */
	boolean nouvelleSauvegarde = true;

	/*
	 * Constructeurs / Destructeur
	 */

	/**
	 * Construit un nouveau controleur principal.
	 * 
	 * @category Constructeur
	 */
	public ControleurPrincipal()
	{
		// Lance l'ecran de démarrage
		this.splash = new VQtEcranDemarrage();
		this.splash.changerMessage("Lancement de l'application ...");
		this.splash.afficher();

		// Enregistre les modeles dans le controleur
		this.modeleDofus = new ModeleDofus();
		this.modeleSauvegardes = new ModeleSauvegardes();
		this.modeleCalculateur = new ModeleCalculateur(this.modeleDofus.getClasses());
		this.modeleCalculateur.setListePanoplies(this.modeleDofus.getPanoplies());
		this.modeleCalculateur.setListeClasses(this.modeleDofus.getClasses());

		// Enregistre la vue dans le controleur
		this.vue = new VQtPrincipale(this);
		this.modeleSauvegardes.addObservateurSauvegardesEquipements(this.vue);
		this.modeleSauvegardes.addObservateurSauvegardesArmes(this.vue);
		this.modeleSauvegardes.addObservateurSauvegardesDofus(this.vue);
		this.modeleCalculateur.addObservateurStatistiques(this.vue);
		this.modeleSauvegardes.addObservateurSauvegardesFamiliers(this.vue);
		this.modeleSauvegardes.addObservateurSauvegardesMontures(this.vue);
		this.vue.getFenetre().slotChangementClasse();

		// Affiche la vue enregistrée
		this.vue.afficher();
		// Ferme l'ecran de démarrage
		this.splash.fermer();
		
	}
	
	/*
	 * Traitements des notifications
	 */

	/**
	 * Traite la demande de changement de l'alignement du personnage.
	 * 
	 * @param alignement - Alignement du personnage.
	 * @param specialisation - Spécialisation du personnage.
	 * @param niveauAlignement - Niveau de l'alignement du personnage.
	 */
	public void notifierChangementAlignement(int alignement, int specialisation, int niveauAlignement, int grade)
	{
		// Logger
		logger.trace("Notification d'une demande de changement de l'alignement. Alignement : " + alignement + ", Spécialisation : " + specialisation + ", Niveau de l'alignement : " + niveauAlignement + ".");

		if((alignement >= 1) && (alignement <= 3))
		{
			if(!((specialisation >= 0) && (specialisation <= 3)))
			{
				specialisation = 0;
			}

			if(!((niveauAlignement >= 0) && (niveauAlignement <= 100)))
			{
				niveauAlignement = 0;
			}

			if(alignement == 3)
			{
				specialisation = 0;
				grade = 0;
			}
			else
			{
				if(!((grade >= 1) && (grade <= 10)))
				{
					grade = 1;
				}
			}
		}
		else
		{
			alignement = 0;
			specialisation = 0;
			niveauAlignement = 0;
			grade = 0;
		}

		this.modeleCalculateur.setAlignement(alignement, specialisation, niveauAlignement, grade);
	}
	
	/**
	 * Traite la demande de changement des boost de la simulation.
	 * 
	 * @param boost - Classe {@link Effets} des boost.
	 */
	public void notifierChangementBoost(Effets boost)
	{
		// Logger
		logger.trace("Notification d'une demande de changement des boost. Boost = " + boost.toString() + ".");

		if(boost != null)
		{
			this.modeleCalculateur.setStatistiquesBoost(boost);
		}
	}

	/**
	 * Traite la demande de changement des caractéristiques de base du personnage.
	 * 
	 * @param clef - Clef de la caractéristique.
	 * @param valeur - Valeur de la caractéristique.
	 */
	public void notifierChangementCaracteristiques(String clef, int valeur)
	{
		// Logger
		logger.trace("Notification d'une demande de changement des caractéristiques de base du personnage. " + clef + " = " + valeur + ".");

		if(clef.equals("Vitalité") || clef.equals("Sagesse") || clef.equals("Force") || clef.equals("Intelligence") || clef.equals("Chance") || clef.equals("Agilité"))
		{
			if(valeur <= 0)
			{
				valeur = 0;
			}

			this.modeleCalculateur.setCaracteristique(clef, valeur);
		}
		else
		{
			logger.error("La clef '" + clef + "' n'est pas valide en tant que caractéristique de base du personnage.");
		}
	}

	/**
	 * Traite la demande de changement de classe du personnage.
	 * 
	 * @param classe - Classe du personnage.
	 */
	public void notifierChangementClasse(Classe classe)
	{
		// Logger
		logger.trace("Notification d'une demande de changement de classe. Classe = " + classe.getNom() + ".");
		
		if(classe != null)
		{
			this.modeleCalculateur.setClasse(classe);
		}
	}

	/**
	 * Traite la demande de changement de mode de calcul des caractéristiques globales.
	 * 
	 * @param mode - Mode.
	 */
	public void notifierChangementMode(int mode)
	{
		// Logger
		logger.trace("Notification d'une demande de changement de mode. Mode = " + mode + ".");

		if(!((mode == 1) || (mode == 2)))
		{
			mode = 1;
		}

		this.modeleCalculateur.setMode(mode);
	}

	/**
	 * Traite la demande de changement de niveau du personnage.
	 * 
	 * @param niveau - Niveau du personnage.
	 */
	public void notifierChangementNiveau(int niveau)
	{
		// Logger
		logger.trace("Notification d'une demande de changement de niveau. Niveau = " + niveau + ".");

		if(!((niveau >= 1) || (niveau <= 200)))
		{
			niveau = 1;
		}

		this.modeleCalculateur.setNiveau(niveau);
	}

	/**
	 * Traite la demande de changement du niveau d'une maitrise du personnage.
	 * 
	 * @param type - Type d'arme de la maitrise.
	 * @param niveau - Niveau de la maitrise.
	 */
	public void notifierChangementNiveauMaitrise(FlagsTypesArmes type, int niveau)
	{
		// Logger
		logger.trace("Notification d'une demande de changement du niveau d'une maitrise. Type : " + type.getNom() + ", Niveau : " + niveau + ".");

		if((niveau >= 0) && (niveau <= 6))
		{
			this.modeleCalculateur.setNiveauMaitrise(type, niveau);
		}
	}

	/**
	 * Traite la demande de changement du niveau d'un sort du personnage.
	 * 
	 * @param nomSort - Nom du sort stocké dans la DofusDatabase.
	 * @param niveau - Niveau du sort.
	 */
	public void notifierChangementNiveauSort(String nomSort, int niveau)
	{
		// Logger
		logger.trace("Notification d'une demande de changement du niveau d'un sort. Id : " + nomSort + ", Niveau : " + niveau + ".");

		if((niveau >= 0) && (niveau <= 6))
		{
			this.modeleCalculateur.setSort(nomSort, niveau);
		}
	}

	/**
	 * Traite la demande de changement de nom du personnage.
	 * 
	 * @param nom - Nom du personnage.
	 */
	public void notifierChangementNomPersonnage(String nom)
	{
		// Logger
		logger.trace("Notification d'une demande de changement de nom. Nom = " + nom + ".");

		this.modeleCalculateur.setNomPersonnage(nom);
	}

	/**
	 * Traite la demande de changement des résistances de la simulation.
	 * 
	 * @param resistances - Classe {@link Effets} des resistances.
	 */
	public void notifierChangementResistances(Effets resistances)
	{
		// Logger
		logger.trace("Notification d'une demande de changement des résistances. Résistances = " + resistances.toString() + ".");

		if(resistances != null)
		{
			this.modeleCalculateur.setResistances(resistances);
		}
	}

	/**
	 * Traite la demande de changement de sexe du personnage.
	 * 
	 * @param sexe - Sexe du personnage.
	 */
	public void notifierChangementSexe(char sexe)
	{
		// Logger
		logger.trace("Notification d'une demande de changement de sexe. Sexe = " + sexe + ".");

		this.modeleCalculateur.setSexe(sexe);
	}

	/**
	 * Traite la demande de chargement d'un groupe
	 */
	public void notifierChargementGroupe()
	{
		// Logger
		logger.trace("Notification d'une demande de chargement d'un groupe.");

		new ControleurGroupeObjets(this, ControleurSauvegardesPersonnages.MODE_CHARGEMENT);
	}

	/**
	 * Traite la demande de chargement d'un personnage.
	 */
	public void notifierChargementPersonnage()
	{
		// Logger
		logger.trace("Notification d'une demande de chargement d'un personnage.");

		new ControleurSauvegardesPersonnages(this, ControleurSauvegardesPersonnages.MODE_CHARGEMENT);
	}

	/**
	 * Traite la demande de chargement d'un personnage.
	 * 
	 * @param sauvegarde - Classe de sauvegarde du personnage.
	 */
	public void notifierChargementPersonnage(SauvegardePersonnage sauvegarde)
	{
		// Logger
		logger.trace("Notification d'une demande de chargement d'un personnage. Personnage = " + sauvegarde.getNom() + ".");

		this.modeleCalculateur.setSauvegardePersonnage(sauvegarde);
		this.nouvelleSauvegarde = false;
	}

	/**
	 * Traite la demande d'équipement d'une arme.
	 * 
	 * @param sauvegarde - Classe de sauvegarde de l'arme.
	 */
	public void notifierEquipeArme(SauvegardeArme sauvegarde)
	{
		// Logger
		logger.trace("Notification d'une demande d'équipement d'une arme. Arme = " + sauvegarde.getNom() + ".");

		this.modeleCalculateur.setSauvegardeArme(sauvegarde);
	}

	/**
	 * Traite la demande d'équipement d'un Dofus.
	 * 
	 * @param typeDofus - Type du Dofus.
	 * @param sauvegarde - Classe de sauvegarde du Dofus.
	 */
	public void notifierEquipeDofus(FlagsTypesDofus typeDofus, SauvegardeDofus sauvegarde)
	{
		// Logger
		logger.trace("Notification d'une demande d'équipement d'un Dofus. Type = " + typeDofus.getNom() + ", Dofus = " + sauvegarde.getNom() + ".");

		this.modeleCalculateur.setSauvegardeDofus(typeDofus, sauvegarde);
	}

	/**
	 * Traite la demande d'endossage d'un équipement.
	 * 
	 * @param typeEquipement - Type de l'équipement à endosser.
	 * @param sauvegarde - Classe de sauvegarde de l'équipement.
	 */
	public void notifierEquipeEquipement(FlagsTypesEquipements typeEquipement, SauvegardeEquipement sauvegarde)
	{
		// Logger
		logger.trace("Notification d'une demande d'endossage d'un équipement. Type = " + typeEquipement.getNom() + ", Equipement = " + sauvegarde.getNom() + ".");

		this.modeleCalculateur.setSauvegardeEquipement(typeEquipement, sauvegarde);
	}

	/**
	 * Traite la demande d'équipement d'un familier.
	 * 
	 * @param sauvegarde - Classe de sauvegarde du familier.
	 */
	public void notifierEquipeFamilier(SauvegardeFamilier sauvegarde)
	{
		// Logger
		logger.trace("Notification d'une demande d'équipement d'un familier. Familier = " + sauvegarde.getNom() + ".");

		this.modeleCalculateur.setSauvegardeAnimal(sauvegarde);
	}

	/**
	 * Traite la demande d'équipement d'une monture.
	 * 
	 * @param sauvegarde - Classe de sauvegarde de la monture.
	 */
	public void notifierEquipeMonture(SauvegardeMonture sauvegarde)
	{
		// Logger
		logger.trace("Notification d'une demande d'équipement d'une monture. Monture = " + sauvegarde.getNom() + ".");

		this.modeleCalculateur.setSauvegardeAnimal(sauvegarde);
	}

	/**
	 * Traite la demande d'ouverture d'une fenêtre de gestion des armes.
	 * 
	 * @param typeEquipement - Type d'armes à gérer.
	 */
	public void notifierGestionArmes(FlagsTypesArmes typeArme)
	{
		// Logger
		logger.trace("Notification d'une demande de gestion de " + typeArme.getNom() + ".");

		new ControleurGestionArmes(this, typeArme);
	}

	/**
	 * Traite la demande d'ouverture d'une fenêtre de gestion des dofus.
	 * 
	 * @param typeDofus - Type de Dofus à gérer.
	 */
	public void notifierGestionDofus(FlagsTypesDofus typeDofus)
	{
		// Logger
		logger.trace("Notification d'une demande de gestion de " + typeDofus.getNom() + ".");

		new ControleurGestionDofus(this, typeDofus);
	}

	/**
	 * Traite la demande d'ouverture d'une fenêtre de gestion de l'équipement.
	 * 
	 * @param typeEquipement - Type d'équipement à gérer.
	 */
	public void notifierGestionEquipement(FlagsTypesEquipements typeEquipement)
	{
		// Logger
		logger.trace("Notification d'une demande de gestion de " + typeEquipement.getNom() + ".");

		new ControleurGestionEquipement(this, typeEquipement);
	}

	/**
	 * Traite la demande d'ouverture d'une fenêtre de gestion des familiers.
	 */
	public void notifierGestionFamiliers()
	{
		// Logger
		logger.trace("Notification d'une demande de gestion des familiers.");

		new ControleurGestionFamiliers(this);
	}

	/**
	 * Traite la demande d'ouverture d'une fenêtre de gestion des montures.
	 */
	public void notifierGestionMontures()
	{
		// Logger
		logger.trace("Notification d'une demande de gestion des montures.");

		new ControleurGestionMontures(this);
	}

	/**
	 * Traite la demande de mise à jour de l'application.
	 */
	public void notifierMiseAJour()
	{
		// Logger
		logger.trace("Notification d'une demande de mise à jour de l'application.");

		new ControleurUpdateur(this);
	}

	/**
	 * Traite la demande de génération d'un nouveau groupe.
	 */
	public void notifierNouveauGroupe()
	{
		// Logger
		logger.trace("Notification d'une demande de génération d'un nouveau groupe.");

		if(this.vue.boiteDialogueQuestion("La création d'un nouveau groupe réinitialisera votre liste d'objets équipés, voulez-vous continuer ?"))
		{
			this.modeleCalculateur.setGroupeObjets(new GroupeObjets());
		}
	}

	/**
	 * Traite la demande de génération d'un nouveau personnage.
	 */
	public void notifierNouveauPersonnage()
	{
		// Logger
		logger.trace("Notification d'une demande de génération d'un nouveau personnage.");

		if(this.vue.boiteDialogueQuestion("La création d'un nouveau personnage écrasera toutes les données non-sauvegardées, voulez-vous continuer ?"))
		{
			SauvegardePersonnage sauvegarde = new SauvegardePersonnage("");
			sauvegarde.setClasse(1);
			this.modeleCalculateur.setSauvegardePersonnage(sauvegarde);
			this.modeleCalculateur.setGroupeObjets(new GroupeObjets());
			this.vue.viderFenetre();
			this.nouvelleSauvegarde = true;
		}
	}
	
	/**
	 * Traite la demande d'ouverture de la fenêtre d'exportation des données.
	 */
	public void notifierOuvertureExportation()
	{
		// Logger
		logger.trace("Notification d'une demande d'ouverture de la fenêtre d'exportation.");
		
		new ControleurExportation(this);
	}

	/**
	 * Traite la demande d'ouverture du calculateur de caractéristiques.
	 */
	public void notifierOuvertureCalcCaracteristiques()
	{
		// Logger
		logger.trace("Notification d'une demande d'ouverture du calculateur de caractéristiques.");
		
		VQtCalcCaracteristiques vue = new VQtCalcCaracteristiques(this, this.vue.getFenetre(), this.modeleCalculateur.getClasse(), this.modeleCalculateur.getSauvegardePersonnage());
		vue.afficher();
	}

	/**
	 * Traite la demande de retrait de l'animal.
	 */
	public void notifierRetraitAnimal()
	{
		// Logger
		logger.trace("Notification d'une demande de retrait de l'animal.");

		this.modeleCalculateur.setSauvegardeAnimal(null);
	}

	/**
	 * Traite la demande de retrait de l'arme.
	 */
	public void notifierRetraitArme()
	{
		// Logger
		logger.trace("Notification d'une demande de retrait de l'arme.");

		this.modeleCalculateur.setSauvegardeArme(null);
	}

	/**
	 * Traite la demande de retrait d'un Dofus.
	 * 
	 * @param typeEquipement - Type du Dofus.
	 */
	public void notifierRetraitDofus(FlagsTypesDofus typeDofus)
	{
		// Logger
		logger.trace("Notification d'une demande de retrait d'un Dofus. Type = " + typeDofus.getNom() + ".");

		this.modeleCalculateur.setSauvegardeDofus(typeDofus, null);
	}

	/**
	 * Traite la demande de retrait d'un équipement.
	 * 
	 * @param typeEquipement - Type de l'équipement.
	 */
	public void notifierRetraitEquipement(FlagsTypesEquipements typeEquipement)
	{
		// Logger
		logger.trace("Notification d'une demande de retrait d'un équipement. Type = " + typeEquipement.getNom() + ".");
		
		this.modeleCalculateur.setSauvegardeEquipement(typeEquipement, null);
	}
	
	/**
	 * Traite la demande de sauvegarde d'un groupe.
	 */
	public void notifierSauvegardeGroupe()
	{
		// Logger
		logger.trace("Notification d'une demande de sauvegarde d'un groupe.");

		new ControleurGroupeObjets(this, ControleurSauvegardesPersonnages.MODE_SAUVEGARDE);
	}

	/**
	 * Traite la demande de sauvegarde d'un personnage.
	 */
	public void notifierSauvegardePersonnage()
	{
		// Logger
		logger.trace("Notification d'une demande de sauvegarde d'un personnage.");

		// Si c'est un nouveau personnage, on ouvre la fenêtre de sauvegarde
		if(this.nouvelleSauvegarde)
		{
			new ControleurSauvegardesPersonnages(this, ControleurSauvegardesPersonnages.MODE_SAUVEGARDE);
		}
		else
		{
			this.notifierSauvegardePersonnage(this.modeleCalculateur.getSauvegardePersonnage());
		}
	}

	/**
	 * Traite la demande de sauvegarde d'un personnage.
	 * 
	 * @param sauvegarde - Objet du personnage à sauvegarder.
	 */
	public void notifierSauvegardePersonnage(SauvegardePersonnage sauvegarde)
	{
		// Logger
		logger.trace("Notification d'une demande de sauvegarde du personnage " + sauvegarde.getNom() + ".");

		if(this.modeleSauvegardes.sauvegarderPersonnage(sauvegarde))
		{
			this.modeleCalculateur.setSauvegardePersonnage(sauvegarde);
			this.vue.boiteDialogueInfo("Sauvegarde", "La sauvegarde " + sauvegarde.getNom() + " a bien été effectuée.");
			this.nouvelleSauvegarde = false;
		}
	}

	/**
	 * Traite la demande de simulation du corps à corps.
	 * 
	 * @param maitrise - Passez {@code true} pour activer la maitrise.
	 * @param ccMaitrise - Passez {@code true} pour activer le coup critique de la maitrise.
	 */
	public void notifierSimulationCaC(boolean maitrise, boolean ccMaitrise)
	{
		// Logger
		logger.trace("Notification d'une demande de simulation du corps à corps. Maitrise = " + maitrise + ", CC Maitrise = " + ccMaitrise + ".");

		if(this.modeleCalculateur.getSauvegardeArme() != null)
		{
			this.modeleCalculateur.updateDegatsCaCSimulation(maitrise, ccMaitrise);
		}
		else
		{
			// Logger
			logger.error("Aucune arme équipée. Simulation du corps à corps annulée.");
		}
	}

	/**
	 * Traite la demande de simulation d'un sort.
	 * 
	 * @param sort - Sort à simuler.
	 * @param niveau - Niveau du sort.
	 */
	public void notifierSimulationSort(Sort sort, int niveau)
	{
		if(sort != null)
		{
			// Logger
			logger.trace("Notification d'une demande de simulation d'un sort. Sort = " + sort.getNom() + ", Niveau = " + niveau + ".");

			if(!((niveau >= 1) || (niveau <= 6)))
			{
				niveau = 1;
			}

			this.modeleCalculateur.updateDegatsSortSimulation(sort, niveau);
		}
	}
	
	/*
	 * Accesseurs
	 */
	
	/**
	 * Renvoie le modèle {@link ModeleCalculateur} du controleur.
	 * 
	 * @return Le modèle {@link ModeleCalculateur}.
	 * @category Accesseur
	 */
	public final ModeleCalculateur getModeleCalculateur()
	{
		return this.modeleCalculateur;
	}

	/**
	 * Renvoie le modèle {@link ModeleDofus} du controleur.
	 * 
	 * @return Le modèle {@link ModeleDofus}.
	 * @category Accesseur
	 */
	public final ModeleDofus getModeleDofus()
	{
		return this.modeleDofus;
	}

	/**
	 * Renvoie le modèle {@link ModeleSauvegardes} du controleur.
	 * 
	 * @return Le modèle {@link ModeleSauvegardes}.
	 * @category Accesseur
	 */
	public final ModeleSauvegardes getModeleSauvegardes()
	{
		return this.modeleSauvegardes;
	}

	/**
	 * Renvoie la vue du controleur.
	 * 
	 * @return La vue.
	 * @category Accesseur
	 */
	public final VQtPrincipale getVue()
	{
		return this.vue;
	}
}