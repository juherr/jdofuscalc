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

import org.JDofusCalc.controleurs.ControleurUpdateur;
import org.JDofusCalc.observateurs.ObservateurUpdate;
import org.JDofusCalc.vues.Qt.composants.QWindowUpdateur;

import com.trolltech.qt.gui.QApplication;

/**
 * Vue du module de mise à jour.
 * 
 * @author PAPAYA Alexandre
 * @category Vue
 * @version 1.0
 */
public class VQtUpdateur extends VueQt implements ObservateurUpdate
{
	/*
	 * Variables d'instances
	 */

	/**
	 * Fenêtre de la vue.
	 */
	private QWindowUpdateur fenetre;

	/**
	 * Controleur de la vue.
	 */
	private ControleurUpdateur controleur;

	/*
	 * Constructeurs / Destructeur
	 */

	/**
	 * Construit une nouvelle vue.
	 * 
	 * @param controleur - Controleur de la vue.
	 * @category Constructeur
	 */
	public VQtUpdateur(ControleurUpdateur controleur)
	{
		// Enregistrement du controleur
		this.controleur = controleur;

		// Enregistrement de la fenetre
		this.fenetre = new QWindowUpdateur(this.controleur.getParent().getVue().getFenetre());

		/* Connexions signal->slot */
		this.fenetre.ui.btnAnnuler.clicked.connect(this.controleur, "notifierArretMiseAJour()");
	}

	/*
	 * Méthodes heritées
	 */

	public void changementAction(String action)
	{
		Thread thread = new Thread(new InvokeAction(action));
		thread.setDaemon(true);
		thread.start();
	}
	/**
	 * Classe tampon d'affichage de l'action en cours.
	 * 
	 * @author PAPAYA Alexandre
	 * @category Invoke
	 * @version 1.0
	 */
	private class InvokeAction implements Runnable
	{
		/*
		 * Variables d'instances
		 */
		
		/**
		 * Action en cours.
		 */
		private String action;
		
		/*
		 * Constructeurs / Destructeur
		 */

		/**
		 * Construit une nouvelle Invoke.
		 * 
		 * @param action - Action en cours.
		 * @category Constructeur
		 */
		private InvokeAction(String action)
		{
			this.action = action;
		}

		public void run()
		{
			QApplication.invokeLater(new Runnable()
			{

				public void run()
				{
					VQtUpdateur.this.fenetre.ui.lblAction.setText(InvokeAction.this.action);
				}
			});
		}
	}

	public void changementAvancement(double avancement)
	{
		Thread thread = new Thread(new InvokeAvancement(avancement));
		thread.setDaemon(true);
		thread.start();
	}

	/**
	 * Classe tampon d'affichage de l'avancement du téléchargement en cours.
	 * 
	 * @author PAPAYA Alexandre
	 * @category Invoke
	 * @version 1.0
	 */
	private class InvokeAvancement implements Runnable
	{
		/*
		 * Variables d'instances
		 */
		
		/**
		 * Avancement du téléchargement en %.
		 */
		private double avancement = 0;

		/*
		 * Constructeurs / Destructeur
		 */

		/**
		 * Construit une nouvelle Invoke.
		 * 
		 * @param avancement - Avancement du téléchargement en %.
		 * @category Constructeur
		 */
		private InvokeAvancement(double avancement)
		{
			this.avancement = avancement;
		}

		public void run()
		{
			QApplication.invokeLater(new Runnable()
			{

				public void run()
				{
					VQtUpdateur.this.fenetre.ui.progressBar.setValue((int) InvokeAvancement.this.avancement);
				}
			});
		}
	}

	public void changementVitesse(float vitesse)
	{
		Thread thread = new Thread(new InvokeVitesse(vitesse));
		thread.setDaemon(true);
		thread.start();
	}

	/**
	 * Classe tampon d'affichage de la vitesse du téléchargement en cours.
	 * 
	 * @author PAPAYA Alexandre
	 * @category Invoke
	 * @version 1.0
	 */
	private class InvokeVitesse implements Runnable
	{
		/*
		 * Variables d'instances
		 */
		
		/**
		 * Vitesse du téléchargement.
		 */
		private float vitesse = 0;

		/*
		 * Constructeurs / Destructeur
		 */

		/**
		 * Construit une nouvelle Invoke.
		 * 
		 * @param vitesse - Vitesse du téléchargement.
		 * @category Constructeur
		 */
		private InvokeVitesse(float vitesse)
		{
			this.vitesse = vitesse;
		}

		public void run()
		{
			QApplication.invokeLater(new Runnable()
			{

				public void run()
				{
					VQtUpdateur.this.fenetre.ui.lblVitesse.setText(String.valueOf(InvokeVitesse.this.vitesse) + " Ko/s");
				}
			});
		}
	}

	public void changementFichier(String fichier)
	{
		Thread thread = new Thread(new InvokeFichier(fichier));
		thread.setDaemon(true);
		thread.start();
	}

	/**
	 * Classe tampon d'affichage du ficher en cours de téléchargement.
	 * 
	 * @author PAPAYA Alexandre
	 * @category Invoke
	 * @version 1.0
	 */
	private class InvokeFichier implements Runnable
	{
		/*
		 * Variables d'instances
		 */
		
		/**
		 * Nom du fichier.
		 */
		private String fichier;

		/*
		 * Constructeurs / Destructeur
		 */

		/**
		 * Construit une nouvelle Invoke.
		 * 
		 * @param fichier - Nom du fichier.
		 * @category Constructeur
		 */
		public InvokeFichier(String fichier)
		{
			this.fichier = fichier;
		}

		public void run()
		{
			QApplication.invokeLater(new Runnable()
			{

				public void run()
				{
					VQtUpdateur.this.fenetre.ui.lblFichier.setText(InvokeFichier.this.fichier);
				}
			});
		}
	}

	public void finTelechargement()
	{
		Thread thread = new Thread(new InvokeFinTelechargement());
		thread.setDaemon(true);
		thread.start();
	}

	/**
	 * Classe tampon d'affichage de la fin du téléchargement.
	 * 
	 * @author PAPAYA Alexandre
	 * @category Invoke
	 * @version 1.0
	 */
	private class InvokeFinTelechargement implements Runnable
	{
		public void run()
		{
			QApplication.invokeLater(new Runnable()
			{

				public void run()
				{
					VQtUpdateur.this.controleur.notiferRedemarrage();
				}
			});
		}
	}

	@Override
	public void afficher()
	{
		VQtUpdateur.centrerFenetre(this.fenetre);
		this.fenetre.show();
	}

	@Override
	public void fermer()
	{
		this.fenetre.close();
	}

	/*
	 * Accesseurs
	 */

	/**
	 * Renvoie {@code fenetre}.
	 * 
	 * @return La fenêtre de la vue.
	 * @category Accesseur
	 */
	public final QWindowUpdateur getFenetre()
	{
		return this.fenetre;
	}

	/**
	 * Renvoie {@code controleur}.
	 * 
	 * @return Le controleur de la vue.
	 * @category Accesseur
	 */
	public final ControleurUpdateur getControleur()
	{
		return this.controleur;
	}
}