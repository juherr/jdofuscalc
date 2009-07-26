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

package org.JDofusCalc.vues.Qt;

import java.util.ArrayList;
import java.util.HashMap;

import org.JDofusCalc.controleurs.ControleurPrincipal;
import org.JDofusCalc.controleurs.ControleurUpdateur;
import org.JDofusCalc.dofus.autres.Classe;
import org.JDofusCalc.dofus.autres.Effets;
import org.JDofusCalc.dofus.autres.Sort;
import org.JDofusCalc.dofus.autres.Effets.FlagsTypesEffets;
import org.JDofusCalc.dofus.objets.Animal;
import org.JDofusCalc.dofus.objets.Arme.FlagsTypesArmes;
import org.JDofusCalc.dofus.objets.Dofus.FlagsTypesDofus;
import org.JDofusCalc.dofus.objets.Equipement.FlagsTypesEquipements;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeAnimal;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeArme;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeDofus;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeEquipement;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeFamilier;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeMonture;
import org.JDofusCalc.dofus.sauvegardes.SauvegardePersonnage;
import org.JDofusCalc.observateurs.ObservateurCalculateur;
import org.JDofusCalc.observateurs.ObservateurSauvegardesArmes;
import org.JDofusCalc.observateurs.ObservateurSauvegardesDofus;
import org.JDofusCalc.observateurs.ObservateurSauvegardesEquipements;
import org.JDofusCalc.observateurs.ObservateurSauvegardesFamiliers;
import org.JDofusCalc.observateurs.ObservateurSauvegardesMontures;
import org.JDofusCalc.vues.Qt.composants.QWindowBonusPanoplies;
import org.JDofusCalc.vues.Qt.composants.QWindowDetails;
import org.JDofusCalc.vues.Qt.composants.QWindowPrincipale;

import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QMessageBox;

/**
 * Vue de la fenêtre principale de l'application.
 * 
 * @author PAPAYA Alexandre
 * @category Vue
 * @version 1.0
 */
public class VQtPrincipale extends VueQt implements ObservateurSauvegardesEquipements, ObservateurSauvegardesArmes, ObservateurCalculateur, ObservateurSauvegardesDofus, ObservateurSauvegardesFamiliers, ObservateurSauvegardesMontures
{
	/*
	 * Variables d'instances
	 */
	
	/**
	 * Fenêtre de la vue.
	 */
	private QWindowPrincipale fenetre;

	/**
	 * Controleur de la vue.
	 */
	private ControleurPrincipal controleur;

	/*
	 * Constructeurs / Destructeur
	 */
	
	/**
	 * Construit une nouvelle vue.
	 * 
	 * @param controleur - Controleur de la vue.
	 * @category Constructeur
	 */
	public VQtPrincipale(ControleurPrincipal controleur)
	{
		// Enregistrement du controleur
		this.controleur = controleur;

		// Enregistrement de la fenetre
		this.fenetre = new QWindowPrincipale();
		//super.fenetre = this.fenetre;

		/* Génération des données de la vue */
		// Classe
		this.fenetre.setListeClasses(this.controleur.getModeleDofus().getClasses());
		// Equipement
		this.fenetre.getTableauObjets().setListeSauvegardesEquipements(FlagsTypesEquipements.Amulette, this.controleur.getModeleSauvegardes().getSauvegardesEquipements(FlagsTypesEquipements.Amulette));
		this.fenetre.getTableauObjets().setListeSauvegardesEquipements(FlagsTypesEquipements.Anneau, this.controleur.getModeleSauvegardes().getSauvegardesEquipements(FlagsTypesEquipements.Anneau));
		this.fenetre.getTableauObjets().setListeSauvegardesEquipements(FlagsTypesEquipements.Bottes, this.controleur.getModeleSauvegardes().getSauvegardesEquipements(FlagsTypesEquipements.Bottes));
		this.fenetre.getTableauObjets().setListeSauvegardesEquipements(FlagsTypesEquipements.Coiffe, this.controleur.getModeleSauvegardes().getSauvegardesEquipements(FlagsTypesEquipements.Coiffe));
		this.fenetre.getTableauObjets().setListeSauvegardesEquipements(FlagsTypesEquipements.Cape, this.controleur.getModeleSauvegardes().getSauvegardesEquipements(FlagsTypesEquipements.Cape));
		this.fenetre.getTableauObjets().setListeSauvegardesEquipements(FlagsTypesEquipements.Ceinture, this.controleur.getModeleSauvegardes().getSauvegardesEquipements(FlagsTypesEquipements.Ceinture));
		this.fenetre.getTableauObjets().setListeSauvegardesEquipements(FlagsTypesEquipements.Bouclier, this.controleur.getModeleSauvegardes().getSauvegardesEquipements(FlagsTypesEquipements.Bouclier));
		// Dofus
		for(FlagsTypesDofus flag : FlagsTypesDofus.values())
		{
			this.fenetre.getTableauObjets().setListeSauvegardesDofus(flag, this.controleur.getModeleSauvegardes().getSauvegardesDofus(flag));
		}
		// Animaux
		this.fenetre.getTableauObjets().setListeSauvegardesFamiliers(this.controleur.getModeleSauvegardes().getSauvegardesFamiliers());
		this.fenetre.getTableauObjets().setListeSauvegardesMontures(this.controleur.getModeleSauvegardes().getSauvegardesMontures());
		// Armes
		HashMap<FlagsTypesArmes, ArrayList<SauvegardeArme>> armes = new HashMap<FlagsTypesArmes, ArrayList<SauvegardeArme>>();
		for(FlagsTypesArmes flag : FlagsTypesArmes.values())
		{
			this.fenetre.getTableauObjets().setListeSauvegardesArmes(flag, this.controleur.getModeleSauvegardes().getSauvegardesArmes(flag));
			armes.put(flag, this.controleur.getModeleSauvegardes().getSauvegardesArmes(flag));
		}
		this.fenetre.setListeSauvegardesArmes(armes);
		
		/* Connexions signal->slot */
		this.fenetre.signalChangerNomPersonnage.connect(this.controleur, "notifierChangementNomPersonnage(String)");
		this.fenetre.signalChangerSexe.connect(this.controleur, "notifierChangementSexe(char)");
		this.fenetre.signalChangerAlignement.connect(this.controleur, "notifierChangementAlignement(int, int, int, int)");
		this.fenetre.signalChangerCaracteristiques.connect(this.controleur, "notifierChangementCaracteristiques(String, int)");
		this.fenetre.signalChangerClasse.connect(this.controleur, "notifierChangementClasse(Classe)");
		this.fenetre.signalChangerNiveau.connect(this.controleur, "notifierChangementNiveau(int)");
		this.fenetre.signalChangerNiveauMaitrise.connect(this.controleur, "notifierChangementNiveauMaitrise(org.JDofusCalc.dofus.objets.Arme$FlagsTypesArmes, int)");
		this.fenetre.signalChangerNiveauSort.connect(this.controleur, "notifierChangementNiveauSort(String, int)");
		this.fenetre.signalChangerBoost.connect(this.controleur, "notifierChangementBoost(Effets)");
		this.fenetre.signalChangerResistances.connect(this.controleur, "notifierChangementResistances(Effets)");
		this.fenetre.signalChangerMode.connect(this.controleur, "notifierChangementMode(int)");
		this.fenetre.signalMettreAJour.connect(this.controleur, "notifierMiseAJour()");
		this.fenetre.signalGererEquipement.connect(this.controleur, "notifierGestionEquipement(org.JDofusCalc.dofus.objets.Equipement$FlagsTypesEquipements)");
		this.fenetre.signalGererFamiliers.connect(this.controleur, "notifierGestionFamiliers()");
		this.fenetre.signalGererMontures.connect(this.controleur, "notifierGestionMontures()");
		this.fenetre.signalGererDofus.connect(this.controleur, "notifierGestionDofus(org.JDofusCalc.dofus.objets.Dofus$FlagsTypesDofus)");
		this.fenetre.signalGererArmes.connect(this.controleur, "notifierGestionArmes(org.JDofusCalc.dofus.objets.Arme$FlagsTypesArmes)");
		this.fenetre.signalEquiperEquipement.connect(this.controleur, "notifierEquipeEquipement(org.JDofusCalc.dofus.objets.Equipement$FlagsTypesEquipements, SauvegardeEquipement)");
		this.fenetre.signalEquiperDofus.connect(this.controleur, "notifierEquipeDofus(org.JDofusCalc.dofus.objets.Dofus$FlagsTypesDofus, SauvegardeDofus)");
		this.fenetre.signalEquiperFamilier.connect(this.controleur, "notifierEquipeFamilier(SauvegardeFamilier)");
		this.fenetre.signalEquiperMonture.connect(this.controleur, "notifierEquipeMonture(SauvegardeMonture)");
		this.fenetre.signalEquiperArme.connect(this.controleur, "notifierEquipeArme(SauvegardeArme)");
		this.fenetre.signalRetirerEquipement.connect(this.controleur, "notifierRetraitEquipement(org.JDofusCalc.dofus.objets.Equipement$FlagsTypesEquipements)");
		this.fenetre.signalRetirerDofus.connect(this.controleur, "notifierRetraitDofus(org.JDofusCalc.dofus.objets.Dofus$FlagsTypesDofus)");
		this.fenetre.signalRetirerAnimal.connect(this.controleur, "notifierRetraitAnimal()");
		this.fenetre.signalRetirerArme.connect(this.controleur, "notifierRetraitArme()");
		this.fenetre.signalNouveauPersonnage.connect(this.controleur, "notifierNouveauPersonnage()");
		this.fenetre.signalSauvegarderPersonnage.connect(this.controleur, "notifierSauvegardePersonnage()");
		this.fenetre.signalChargerPersonnage.connect(this.controleur, "notifierChargementPersonnage()");
		this.fenetre.signalNouveauGroupe.connect(this.controleur, "notifierNouveauGroupe()");
		this.fenetre.signalSauvegarderGroupe.connect(this.controleur, "notifierSauvegardeGroupe()");
		this.fenetre.signalChargerGroupe.connect(this.controleur, "notifierChargementGroupe()");
		this.fenetre.signalSimulerCaC.connect(this.controleur, "notifierSimulationCaC(boolean, boolean)");
		this.fenetre.signalSimulerSort.connect(this.controleur, "notifierSimulationSort(Sort, int)");
		this.fenetre.signalOuvrirDetails.connect(this, "slotOuvertureDetails()");
		this.fenetre.signalOuvrirBonusPanoplies.connect(this, "slotOuvertureBonusPanoplies()");
		this.fenetre.signalSelectionnerSortSimulation.connect(this, "slotSelctionnerSortSimulation(Sort)");
		this.fenetre.signalOuvrirCalcCaracteristiques.connect(this.controleur, "notifierOuvertureCalcCaracteristiques()");
		this.fenetre.signalOuvrirExportation.connect(this.controleur, "notifierOuvertureExportation()");
	}

	/*
	 * Méthodes
	 */
	
	/**
	 * Vide la vue des toutes ses données personnages.
	 */
	public void viderFenetre()
	{
		this.fenetre.vider();
	}
	
	/**
	 * Ouvre une boîte de dialogue invoquée par l'updateur.
	 * 
	 * @param type - Type de la boîte de dialogue.
	 * @param message - Message de la boîte de dialogue.
	 */
	public void boiteDialogueUpdateur(int type, String message)
	{
		String titre = "Updateur";
		InvokeBoiteDialogueUpdateur runnable = new InvokeBoiteDialogueUpdateur(type, titre, message);
		Thread thread = new Thread(runnable);
		thread.setDaemon(true);
		thread.start();
	}
	/**
	 * Classe tampon d'ouverture d'une boîte de dialogue invoquée par l'updateur.
	 * 
	 * @author PAPAYA Alexandre
	 * @category Invoke
	 * @version 1.0
	 */
	private class InvokeBoiteDialogueUpdateur implements Runnable
	{
		/*
		 * Variables d'instances
		 */
		
		/**
		 * Type de la boîte de dialogue.
		 */
		private int type;
		
		/**
		 * Titre de la boîte de dialogue.
		 */
		private String titre;
		
		/**
		 * Message de la boîte de dialogue.
		 */
		private String messages;

		/*
		 * Constructeurs / Destructeur
		 */

		/**
		 * Construit une nouvelle Invoke.
		 * 
		 * @param type - Type de la boîte de dialogue.
		 * @param titre - Titre de la boîte de dialogue.
		 * @param message - Message de la boîte de dialogue.
		 * @category Constructeur
		 */
		public InvokeBoiteDialogueUpdateur(int type, String titre, String message)
		{
			this.type = type;
			this.titre = titre;
			this.messages = message;
		}
		
		public void run()
		{
			QApplication.invokeLater(new Runnable()
			{

				public void run()
				{
					VQtPrincipale.this.fenetre.cacherBarreProgression();

					if(InvokeBoiteDialogueUpdateur.this.type == 1)
					{
						QMessageBox.information(fenetre, InvokeBoiteDialogueUpdateur.this.titre, InvokeBoiteDialogueUpdateur.this.messages);
					}
					else if(InvokeBoiteDialogueUpdateur.this.type == 2)
					{
						QMessageBox.warning(VQtPrincipale.this.fenetre, InvokeBoiteDialogueUpdateur.this.titre, InvokeBoiteDialogueUpdateur.this.messages);
					}
				}
			});
		}
	}

	/**
	 * Ouvre une boîte de dialogue {@code question} invoquée par l'updateur.
	 * 
	 * @param controleurUpdateur - Le {@link ControleurUpdateur}.
	 */
	public void boiteDialogueUpdateurQuestion(ControleurUpdateur controleurUpdateur)
	{
		InvokeBoiteDialogueUpdateurQuestion runnable = new InvokeBoiteDialogueUpdateurQuestion(controleurUpdateur, this.fenetre);
		Thread thread = new Thread(runnable);
		thread.setDaemon(true);
		thread.start();
	}
	/**
	 * Classe tampon d'ouverture d'une boîte de dialogue {@code question} invoquée par l'updateur.
	 * 
	 * @author PAPAYA Alexandre
	 * @category Invoke
	 * @version 1.0
	 */
	private class InvokeBoiteDialogueUpdateurQuestion implements Runnable
	{
		/*
		 * Variables d'instances
		 */
		
		/**
		 * Le {@link ControleurUpdateur}.
		 */
		private ControleurUpdateur controleur;

		/*
		 * Constructeurs / Destructeur
		 */

		/**
		 * Construit une nouvelle Invoke.
		 * 
		 * @param controleur - Le {@link ControleurUpdateur}.
		 * @category Constructeur
		 */
		public InvokeBoiteDialogueUpdateurQuestion(ControleurUpdateur controleur, QWindowPrincipale fenetre)
		{
			this.controleur = controleur;
		}

		public void run()
		{
			QApplication.invokeLater(new Runnable()
			{

				public void run()
				{
					QMessageBox.StandardButtons buttons = new QMessageBox.StandardButtons();
					buttons.set(QMessageBox.StandardButton.Yes);
					buttons.set(QMessageBox.StandardButton.No);

					if(QMessageBox.question(VQtPrincipale.this.fenetre, "Updateur", "Une nouvelle version est disponible, voulez-vous la télécharger maintenant ?", buttons) == QMessageBox.StandardButton.Yes)
					{
						InvokeBoiteDialogueUpdateurQuestion.this.controleur.notifierLancementMiseAJour();
					}
				}
			});
		}

	}

	/*
	 * Méthodes heritées
	 */

	@Override
	public void afficher()
	{
		VueQt.centrerFenetre(this.fenetre);

		this.fenetre.show();
	}

	public void changementAnimal(SauvegardeAnimal sauvegardeAnimal, String erreursConditions)
	{
		this.fenetre.getTableauObjets().setAnimal(sauvegardeAnimal, erreursConditions);
	}

	public void changementArme(SauvegardeArme sauvegarde, String erreurs)
	{
		this.fenetre.getTableauObjets().setArme(sauvegarde, erreurs);
		this.fenetre.setArmeEquipee(sauvegarde);
	}

	public void changementClasse(Classe classe)
	{
		// Logger
		logger.trace("Appel VQtPrincipale::changementClasse(Classe = " + classe.getNom() + ").");
		
		this.fenetre.setClasse(classe);
		this.fenetre.setListeSorts(this.controleur.getModeleDofus().getSorts(classe), this.controleur.getModeleCalculateur().getSauvegardePersonnage().getNiveauxSorts());
	}
	
	public void changementSexe(char sexe, Classe classe)
	{
		// Logger
		logger.trace("Appel VQtPrincipale::changementSexe(Sexe = " + sexe + ", Classe = " + classe.getNom() + ").");
		
		this.fenetre.setSexe(sexe, classe);
	}
	
	public void changementSauvegardePersonnage(SauvegardePersonnage sauvegarde)
	{
		// Logger
		logger.trace("Appel VQtPrincipale::changementSauvegardePersonnage(Sauvegarde = " + sauvegarde.getNom() + ").");
		
		this.fenetre.setSauvegardePersonnage(sauvegarde);
	}

	public void changementDofus(FlagsTypesDofus type, SauvegardeDofus sauvegarde, String erreurs, Effets statistiquesDofus)
	{
		this.fenetre.getTableauObjets().setDofus(type, sauvegarde, erreurs, statistiquesDofus);
	}

	public void changementEquipement(FlagsTypesEquipements type, SauvegardeEquipement sauvegarde, String erreurs)
	{
		this.fenetre.getTableauObjets().setEquipement(type, sauvegarde, erreurs);
	}
	
	public void changementPanoplie(String nomsPanoplies, Effets effetsPanoplies)
	{
		this.fenetre.getTableauObjets().setPanoplie(nomsPanoplies, effetsPanoplies);
	}

	public void changementSimulation(HashMap<String, String> donnees)
	{
		this.fenetre.setDonneesSimulation(donnees);
	}

	public void changementStatistique(FlagsTypesEffets champ, int valeur)
	{
		this.fenetre.setStatistique(champ, valeur);
	}

	public void creationArme(FlagsTypesArmes typeArme, SauvegardeArme sauvegarde)
	{
		this.fenetre.getTableauObjets().setListeSauvegardesArmes(typeArme, this.controleur.getModeleSauvegardes().getSauvegardesArmes(typeArme));
		
		HashMap<FlagsTypesArmes, ArrayList<SauvegardeArme>> armes = new HashMap<FlagsTypesArmes, ArrayList<SauvegardeArme>>();
		for(FlagsTypesArmes flag : FlagsTypesArmes.values())
		{
			armes.put(flag, this.controleur.getModeleSauvegardes().getSauvegardesArmes(flag));
		}
		this.fenetre.setListeSauvegardesArmes(armes);
	}

	public void creationDofus(FlagsTypesDofus typeDofus, SauvegardeDofus sauvegarde)
	{
		this.fenetre.getTableauObjets().setListeSauvegardesDofus(typeDofus, this.controleur.getModeleSauvegardes().getSauvegardesDofus(typeDofus));
	}

	public void creationEquipement(FlagsTypesEquipements typeEquipement, SauvegardeEquipement sauvegarde)
	{
		this.fenetre.getTableauObjets().setListeSauvegardesEquipements(typeEquipement, this.controleur.getModeleSauvegardes().getSauvegardesEquipements(typeEquipement));
	}

	public void creationFamilier(SauvegardeFamilier sauvegarde)
	{
		this.fenetre.getTableauObjets().setListeSauvegardesFamiliers(this.controleur.getModeleSauvegardes().getSauvegardesFamiliers());
	}

	public void creationMonture(SauvegardeMonture sauvegarde)
	{
		this.fenetre.getTableauObjets().setListeSauvegardesMontures(this.controleur.getModeleSauvegardes().getSauvegardesMontures());
	}

	@Override
	public void fermer()
	{
		this.fenetre.close();
	}

	public void sauvegardeArme(FlagsTypesArmes typeArme, SauvegardeArme sauvegarde)
	{
		this.fenetre.getTableauObjets().setListeSauvegardesArmes(typeArme, this.controleur.getModeleSauvegardes().getSauvegardesArmes(typeArme));
	
		HashMap<FlagsTypesArmes, ArrayList<SauvegardeArme>> armes = new HashMap<FlagsTypesArmes, ArrayList<SauvegardeArme>>();
		for(FlagsTypesArmes flag : FlagsTypesArmes.values())
		{
			armes.put(flag, this.controleur.getModeleSauvegardes().getSauvegardesArmes(flag));
		}
		this.fenetre.setListeSauvegardesArmes(armes);
	}

	public void sauvegardeDofus(FlagsTypesDofus typeDofus, SauvegardeDofus sauvegarde)
	{
		this.fenetre.getTableauObjets().setListeSauvegardesDofus(typeDofus, this.controleur.getModeleSauvegardes().getSauvegardesDofus(typeDofus));
		// Si le dofus modifié est lle dofus chargé
		if(this.controleur.getModeleCalculateur().getSauvegardeDofus(typeDofus) != null)
		{
			int idDofusEquipe = this.controleur.getModeleCalculateur().getSauvegardeDofus(typeDofus).getId();
			int idDofusModifie = sauvegarde.getId();
			if(idDofusEquipe == idDofusModifie)
			{
				this.controleur.getModeleCalculateur().setSauvegardeDofus(typeDofus, sauvegarde);
			}
		}
	}

	public void sauvegardeEquipement(FlagsTypesEquipements typeEquipement, SauvegardeEquipement sauvegarde)
	{
		this.fenetre.getTableauObjets().setListeSauvegardesEquipements(typeEquipement, this.controleur.getModeleSauvegardes().getSauvegardesEquipements(typeEquipement));
		// Si l'équipement modifié est l'équipement chargé
		if(this.controleur.getModeleCalculateur().getSauvegardeEquipement(typeEquipement) != null)
		{
			int idEquipementEquipe = this.controleur.getModeleCalculateur().getSauvegardeEquipement(typeEquipement).getId();
			int idEquipementModifie = sauvegarde.getId();
			if(idEquipementEquipe == idEquipementModifie)
			{
				this.controleur.getModeleCalculateur().setSauvegardeEquipement(typeEquipement, sauvegarde);
			}
		}
	}

	public void sauvegardeFamilier(SauvegardeFamilier sauvegarde)
	{
		this.fenetre.getTableauObjets().setListeSauvegardesFamiliers(this.controleur.getModeleSauvegardes().getSauvegardesFamiliers());
		// Si le dofus modifié est lle dofus chargé
		if(this.controleur.getModeleCalculateur().getSauvegardeAnimal() != null)
		{
			Animal sauvegardeEquipee = (Animal) this.controleur.getModeleCalculateur().getSauvegardeAnimal();
			int idFamilierEquipe = sauvegardeEquipee.getId();
			int idFamilierModifie = sauvegarde.getId();
			if(idFamilierEquipe == idFamilierModifie)
			{
				this.controleur.getModeleCalculateur().setSauvegardeAnimal(sauvegarde);
			}
		}
	}

	public void sauvegardeMonture(SauvegardeMonture sauvegarde)
	{
		this.fenetre.getTableauObjets().setListeSauvegardesMontures(this.controleur.getModeleSauvegardes().getSauvegardesMontures());
		// Si la monture modifié est lle dofus chargé
		if(this.controleur.getModeleCalculateur().getSauvegardeAnimal() != null)
		{
			Animal sauvegardeEquipee = (Animal) this.controleur.getModeleCalculateur().getSauvegardeAnimal();
			int idFamilierEquipe = sauvegardeEquipee.getId();
			int idFamilierModifie = sauvegarde.getId();
			if(idFamilierEquipe == idFamilierModifie)
			{
				this.controleur.getModeleCalculateur().setSauvegardeAnimal(sauvegarde);
			}
		}
	}
	
	public void suppressionSauvegardeArme(FlagsTypesArmes typeArme)
	{
		this.fenetre.getTableauObjets().setListeSauvegardesArmes(typeArme, this.controleur.getModeleSauvegardes().getSauvegardesArmes(typeArme));
	
		HashMap<FlagsTypesArmes, ArrayList<SauvegardeArme>> armes = new HashMap<FlagsTypesArmes, ArrayList<SauvegardeArme>>();
		for(FlagsTypesArmes flag : FlagsTypesArmes.values())
		{
			armes.put(flag, this.controleur.getModeleSauvegardes().getSauvegardesArmes(flag));
		}
		this.fenetre.setListeSauvegardesArmes(armes);
	}

	public void suppressionSauvegardeDofus(FlagsTypesDofus typeDofus, SauvegardeDofus sauvegarde)
	{
		this.fenetre.getTableauObjets().setListeSauvegardesDofus(typeDofus, this.controleur.getModeleSauvegardes().getSauvegardesDofus(typeDofus));
		// Si le dofus modifié est lle dofus chargé
		if(this.controleur.getModeleCalculateur().getSauvegardeDofus(typeDofus) != null)
		{
			int idDofusEquipe = this.controleur.getModeleCalculateur().getSauvegardeDofus(typeDofus).getId();
			int idDofusModifie = sauvegarde.getId();
			if(idDofusEquipe == idDofusModifie)
			{
				this.controleur.getModeleCalculateur().setSauvegardeDofus(typeDofus, null);
			}
		}
	}

	public void suppressionSauvegardeEquipement(FlagsTypesEquipements typeEquipement, SauvegardeEquipement sauvegarde)
	{
		this.fenetre.getTableauObjets().setListeSauvegardesEquipements(typeEquipement, this.controleur.getModeleSauvegardes().getSauvegardesEquipements(typeEquipement));
		// Si l'équipement modifié est l'équipement chargé
		if(this.controleur.getModeleCalculateur().getSauvegardeEquipement(typeEquipement) != null)
		{
			int idEquipementEquipe = this.controleur.getModeleCalculateur().getSauvegardeEquipement(typeEquipement).getId();
			int idEquipementModifie = sauvegarde.getId();
			if(idEquipementEquipe == idEquipementModifie)
			{
				this.controleur.getModeleCalculateur().setSauvegardeEquipement(typeEquipement, null);
			}
		}
	}

	public void suppressionSauvegardeFamilier(SauvegardeFamilier sauvegarde)
	{
		this.fenetre.getTableauObjets().setListeSauvegardesFamiliers(this.controleur.getModeleSauvegardes().getSauvegardesFamiliers());
	}

	public void suppressionSauvegardeMonture(SauvegardeMonture sauvegarde)
	{
		this.fenetre.getTableauObjets().setListeSauvegardesMontures(this.controleur.getModeleSauvegardes().getSauvegardesMontures());
	}
	
	/*
	 * Slots
	 */

	/**
	 * Ouvre la fenêtre de details.
	 * 
	 * @category Slot
	 */
	public void slotOuvertureDetails()
	{
		QWindowDetails fenetre = new QWindowDetails(this.fenetre, this.controleur.getModeleCalculateur().getDetails());
		VueQt.centrerFenetre(fenetre);
		fenetre.show();
	}
	
	/**
	 * Ouvre la fenêtre des bonus des panoplies.
	 * 
	 * @category Slot
	 */
	public void slotOuvertureBonusPanoplies()
	{
		QWindowBonusPanoplies fenetre = new QWindowBonusPanoplies(this.fenetre);
		fenetre.setListePanoplies(this.controleur.getModeleDofus().getPanoplies());
		VueQt.centrerFenetre(fenetre);
		fenetre.show();
	}

	/**
	 * Récupère le niveau du sort selectionné dans l'onglet de simulation.
	 * 
	 * @category Slot
	 */
	public void slotSelctionnerSortSimulation(Sort sort)
	{
		String nomSort = sort.getNom();
		int niveauSort = this.controleur.getModeleCalculateur().getSauvegardePersonnage().getSort(nomSort);
		if(niveauSort != 0)
		{
			this.fenetre.setNiveauSortSimulation(niveauSort);
		}
		else
		{
			this.fenetre.setNiveauSortSimulation(1);
		}
	}

	/*
	 * Accesseurs
	 */

	/**
	 * Renvoie {@code controleur}.
	 * 
	 * @return Le controleur de la vue.
	 * @category Accesseur
	 */
	public final ControleurPrincipal getControleur()
	{
		return this.controleur;
	}

	/**
	 * Renvoie {@code fenetre}.
	 * 
	 * @return La fenêtre de la vue.
	 * @category Accesseur
	 */
	public final QWindowPrincipale getFenetre()
	{
		return this.fenetre;
	}
}