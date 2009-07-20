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

import java.io.File;

import org.JDofusCalc.modeles.ModeleUpdateur;
import org.JDofusCalc.vues.Qt.VQtUpdateur;

import fr.ayapap.AUtil;

/**
 * Controleur de l'updateur
 * 
 * @author PAPAYA Alexandre
 * @category Controleur
 * @version 1.0
 */
public class ControleurUpdateur extends Controleur
{
	/*
	 * Variables d'instances
	 */

	/**
	 * Modèle {@link ModeleUpdateur} du controleur.
	 */
	private ModeleUpdateur modele;

	/**
	 * Vue {@link VQtUpdateur} du controleur.
	 */
	private VQtUpdateur vue;

	/**
	 * Controleur {@link ControleurPrincipal} parent.
	 */
	private ControleurPrincipal controleurParent;

	/*
	 * Constructeurs / Destructeur
	 */

	/**
	 * Constuit un controleur de mise à jour de l'application.
	 * 
	 * @param controleurParent - Controleur parent.
	 * @category Constructeur
	 */
	public ControleurUpdateur(ControleurPrincipal controleurParent)
	{
		// Enregistre le controleur parent
		this.controleurParent = controleurParent;

		// Enregistre le modele dans le controleur
		this.controleurParent.getVue().getFenetre().afficherBarreProgression("Connexion au serveur");
		this.modele = new ModeleUpdateur();

		// Enregistre la vue
		this.vue = new VQtUpdateur(this);

		// Lance le thread de vérification
		Thread thread = new ThreadVerificationMaJ();
		thread.start();
	}
	
	/*
	 * Actions
	 */

	/**
	 * Verifie les mises à jour.
	 */
	private void verifierMisesAJour()
	{
		if(this.modele.isConnecte())
		{
			if(!this.modele.existNouvelleVersion())
			{
				this.controleurParent.getVue().boiteDialogueUpdateur(1, "Il n'y a pas de nouvelle version disponible.");
			}
			else
			{
				this.controleurParent.getVue().boiteDialogueUpdateurQuestion(this);
			}
		}
		else
		{
			logger.error("Impossible de se connecter au serveur de mise à jour.");
			this.controleurParent.getVue().boiteDialogueUpdateur(2, "Impossible de se connecter au serveur de mise à jour.\nVérifiez votre connexion internet.");
		}
	}

	/**
	 * Thread de vérification des mises à jour.
	 * 
	 * @author PAPAYA Alexandre
	 * @category Thread
	 * @version 1.0
	 */
	private class ThreadVerificationMaJ extends Thread
	{
		@Override
		public void run()
		{
			// Tant que la connexion n'est pas terminée, on attends
			while(ControleurUpdateur.this.modele.getThreadConstructeur().isAlive())
			{
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException e)
				{
					e.printStackTrace();
				}
			}
			ControleurUpdateur.this.controleurParent.getVue().getFenetre().cacherBarreProgression();

			ControleurUpdateur.this.verifierMisesAJour();
		}
	}

	/*
	 * Traitements des actions
	 */

	/**
	 * Traite la demande de lancement de la mise à jour.
	 */
	public void notifierLancementMiseAJour()
	{
		// Logger
		logger.trace("Notification d'une demande de lancement de la mise à jour.");
		
		this.modele.addObservateurUpdate(this.vue);
		this.vue.afficher();
		this.controleurParent.getVue().getFenetre().afficherBarreProgression("Mise à jour en cours");
		this.modele.getDerniereVersion();
	}

	/**
	 * Traite la demande d'arrêt du téléchargement.
	 */
	public void notifierArretMiseAJour()
	{
		// Logger
		logger.trace("Notification d'une demande d'arrêt de la mise à jour.");
		
		this.modele.getThreadTelechargement().getTelechargeur().mettreEnPause();

		if(this.vue.boiteDialogueQuestion("Updateur", "Voulez vous vraiment arrêter le téléchargement ?"))
		{
			this.modele.getThreadTelechargement().getTelechargeur().annuler();
			this.vue.fermer();
			this.modele.removeObservateurUpdate(this.vue);
			this.modele.getThreadTelechargement().getTelechargeur().removeObservateur(this.modele);
			this.modele.supprimerDossierUpdateur();
			ControleurUpdateur.this.controleurParent.getVue().getFenetre().cacherBarreProgression();
		}
		else
		{
			this.modele.getThreadTelechargement().getTelechargeur().relancer();
		}
	}

	/**
	 * Traite la demande de redemarrage de l'application.
	 */
	public void notiferRedemarrage()
	{
		// Logger
		logger.trace("Notification d'une demande dde redemarrage de l'application.");

		this.controleurParent.getVue().getFenetre().cacherBarreProgression();
		this.vue.boiteDialogueInfo("Updateur", "Mise à jour correctement téléchargée, l'application va redemarrer.");
		this.vue.fermer();

		try
		{
			AUtil.lancerJar(new File("JDofusCalc.jar"));
			System.exit(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();

			logger.fatal(e.getMessage());
			this.vue.boiteDialogueErreur("Updateur", e.getMessage());
		}

		this.modele.removeObservateurUpdate(this.vue);
	}

	/*
	 * Accesseurs
	 */

	/**
	 * Renvoie le controleur parent {@link ControleurPrincipal}.
	 * 
	 * @return Le controleur parent {@link ControleurPrincipal}.
	 * @category Accesseur
	 */
	public final ControleurPrincipal getParent()
	{
		return this.controleurParent;
	}
}