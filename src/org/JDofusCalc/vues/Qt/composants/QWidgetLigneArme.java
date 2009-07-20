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
import java.util.List;

import org.JDofusCalc.dofus.objets.Arme.FlagsTypesArmes;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeArme;

import com.trolltech.qt.gui.QAction;
import com.trolltech.qt.gui.QMenu;
import com.trolltech.qt.gui.QWidget;

/**
 * Ligne arme d'un tableau {@link QWidgetTableauObjets}.
 * 
 * @author PAPAYA Alexandre
 * @category Composant
 * @version 1.0
 * @see {@link QWidgetTableauObjets} et {@link QWidgetLigneAbstraite}.
 */
public class QWidgetLigneArme extends QWidgetLigneAbstraite
{
	/*
	 * Variables d'instances
	 */

	/* Composants */

	// Vide

	/* Autres */

	/**
	 * Le {@link QAction} représentant l'arme équipée.
	 */
	private QAction actionSelectionne;

	/**
	 * Liste des {@link QAction} du sous menu "équiper".
	 */
	private HashMap<FlagsTypesArmes, QAction> listeActionsEquiper;

	/**
	 * Références des {@link QAction} des armes.
	 */
	private HashMap<FlagsTypesArmes, HashMap<Integer, QAction>> references;

	/*
	 * Signaux
	 */

	/**
	 * <p>Ce signal prend 1 argument(s) générique(s) : &lt;{@link FlagsTypesArmes} (nom: type)&gt;.</p>
	 * <p>Ce signal est émit lors d'une demande d'ouverture de la fenêtre de gestion des armes {@code type}.</p>
	 */
	public Signal1<FlagsTypesArmes> signalGerer = new Signal1<FlagsTypesArmes>();

	/**
	 * <p>Ce signal prend 1 argument(s) générique(s) : &lt;{@link Object} (nom: sauvegarde)&gt;.</p>
	 * <p>Ce signal est émit lors d'une demande de retrait de l'arme équipée.</p>
	 */
	public Signal1<Object> signalEquiper = new Signal1<Object>();

	/**
	 * <p>Ce signal prend aucun argument générique.</p>
	 * <p>Ce signal est émit lors d'une demande de retrait de l'arme équipée.</p>
	 */
	public Signal0 signalRetirer = new Signal0();

	/*
	 * Constructeurs / Destructeur
	 */

	/**
	 * Construit un nouveau composant.
	 * 
	 * @param parent - Composant parent.
	 * @category Constructeur
	 */
	public QWidgetLigneArme(QWidget parent)
	{
		// Execution du constructeur de la classe mère
		super(parent);
		
		this.references = new HashMap<FlagsTypesArmes, HashMap<Integer, QAction>>();
	}

	/*
	 * Méthodes de génération du composant
	 */

	@Override
	public void genererMenu()
	{
		// Si le compasant doit generer un menu
		if(this.afficherMenu)
		{
			QAction actionEquiperArc = new QAction("Arcs", this);
			QAction actionEquiperDague = new QAction("Dagues", this);
			QAction actionEquiperEpee = new QAction("Epées", this);
			QAction actionEquiperFaux = new QAction("Faux", this);
			QAction actionEquiperHache = new QAction("Hache", this);
			QAction actionEquiperOutil = new QAction("Outils", this);
			QAction actionEquiperBaguette = new QAction("Baguette", this);
			QAction actionEquiperBaton = new QAction("Bâton", this);
			QAction actionEquiperPelle = new QAction("Pelle", this);
			QAction actionEquiperPioche = new QAction("Pioche", this);
			QAction actionEquiperMarteau = new QAction("Marteaux", this);

			this.listeActionsEquiper = new HashMap<FlagsTypesArmes, QAction>();
			this.listeActionsEquiper.put(FlagsTypesArmes.Arc, actionEquiperArc);
			this.listeActionsEquiper.put(FlagsTypesArmes.Dague, actionEquiperDague);
			this.listeActionsEquiper.put(FlagsTypesArmes.Epee, actionEquiperEpee);
			this.listeActionsEquiper.put(FlagsTypesArmes.Faux, actionEquiperFaux);
			this.listeActionsEquiper.put(FlagsTypesArmes.Hache, actionEquiperHache);
			this.listeActionsEquiper.put(FlagsTypesArmes.Outil, actionEquiperOutil);
			this.listeActionsEquiper.put(FlagsTypesArmes.Baguette, actionEquiperBaguette);
			this.listeActionsEquiper.put(FlagsTypesArmes.Baton, actionEquiperBaton);
			this.listeActionsEquiper.put(FlagsTypesArmes.Pelle, actionEquiperPelle);
			this.listeActionsEquiper.put(FlagsTypesArmes.Pioche, actionEquiperPioche);
			this.listeActionsEquiper.put(FlagsTypesArmes.Marteau, actionEquiperMarteau);

			QMenu menuEquiper = new QMenu();
			List<QAction> listeQActions = new ArrayList<QAction>(this.listeActionsEquiper.values());
			menuEquiper.addActions(listeQActions);

			QAction actionArc = new QAction("Arcs", this);
			actionArc.triggered.connect(this, "slotGestionArc()");
			QAction actionDague = new QAction("Dagues", this);
			actionDague.triggered.connect(this, "slotGestionDague()");
			QAction actionEpee = new QAction("Epées", this);
			actionEpee.triggered.connect(this, "slotGestionEpee()");
			QAction actionFaux = new QAction("Faux", this);
			actionFaux.triggered.connect(this, "slotGestionFaux()");
			QAction actionHache = new QAction("Hache", this);
			actionHache.triggered.connect(this, "slotGestionHache()");
			QAction actionOutil = new QAction("Outils", this);
			actionOutil.triggered.connect(this, "slotGestionOutil()");
			QAction actionBaguette = new QAction("Baguette", this);
			actionBaguette.triggered.connect(this, "slotGestionBaguette()");
			QAction actionBaton = new QAction("Bâton", this);
			actionBaton.triggered.connect(this, "slotGestionBaton()");
			QAction actionPelle = new QAction("Pelle", this);
			actionPelle.triggered.connect(this, "slotGestionPelle()");
			QAction actionPioche = new QAction("Pioche", this);
			actionPioche.triggered.connect(this, "slotGestionPioche()");
			QAction actionMarteau = new QAction("Marteaux", this);
			actionMarteau.triggered.connect(this, "slotGestionMarteau()");

			ArrayList<QAction> liste = new ArrayList<QAction>();
			liste.add(actionArc);
			liste.add(actionDague);
			liste.add(actionEpee);
			liste.add(actionFaux);
			liste.add(actionHache);
			liste.add(actionOutil);
			liste.add(actionBaguette);
			liste.add(actionBaton);
			liste.add(actionPelle);
			liste.add(actionPioche);
			liste.add(actionMarteau);
			QMenu menuGerer = new QMenu();
			menuGerer.addActions(liste);

			
			// Création du menu
			QMenu menu = new QMenu();
			this.ui.actionRetirer.setText("Retirer l'arme");
			menu.addAction(this.ui.actionRetirer);
			this.ui.actionEquiper.setText("Equiper une arme");
			this.ui.actionEquiper.setMenu(menuEquiper);
			this.ui.actionEquiper.setEnabled(true);
			menu.addAction(this.ui.actionEquiper);
			this.ui.actionGerer.setText("Gérer mes armes");
			this.ui.actionGerer.setMenu(menuGerer);
			menu.addAction(this.ui.actionGerer);

			this.ui.btnActions.setMenu(menu);

			/* Connexions signal->slot */
			this.ui.actionRetirer.triggered.connect(this, "slotRetire()");
		}
	}

	/**
	 * Définit la liste des sauvegardes des armes de type {@code typeArme}.
	 * 
	 * @param typeArme - Type des armes.
	 * @param sauvegardes - Sauvegardes des armes.
	 */
	public void setListeSauvegardesArmes(FlagsTypesArmes typeArme, ArrayList<SauvegardeArme> sauvegardes)
	{		
		QAction actionEquiper = this.listeActionsEquiper.get(typeArme);
		actionEquiper.setEnabled(false);
		QMenu menuEquiper = new QMenu();
		HashMap<Integer, QAction> reference = new HashMap<Integer, QAction>();
		for(int i = 0; i < sauvegardes.size(); i++)
		{
			SauvegardeArme sauvegarde = sauvegardes.get(i);
			actionEquiper.setEnabled(true);
			QAction action = new QAction(this);
			action.setCheckable(true);
			action.setText(sauvegarde.getNom());
			action.setData(sauvegarde);
			menuEquiper.addAction(action);
			reference.put(sauvegarde.getId(), action);
		}
		
		this.references.put(typeArme, reference);
		menuEquiper.triggered.connect(this, "slotEquipe(QAction)");
		actionEquiper.setMenu(menuEquiper);
	}
	
	/*
	 * Méthodes
	 */
	
	/**
	 * <p>Définit l'arme équipée. Si {@code sauvegarde} est {@code null}, alors le composant se vide.</p>
	 * 
	 * @param sauvegarde - Sauvegarde de l'arme.
	 * @param erreurs - Erreurs à afficher.
	 */
	public void setArmeEquipee(SauvegardeArme sauvegarde, String erreurs)
	{
		if(sauvegarde != null)
		{
			QAction action = this.references.get(sauvegarde.getType()).get(sauvegarde.getId());
				
			if(this.actionSelectionne != null)
			{
				this.actionSelectionne.setChecked(false);
			}
			this.actionSelectionne = action;
			this.actionSelectionne.setChecked(true);
			this.ui.actionRetirer.setEnabled(true);
			this.afficherDonnees(sauvegarde.getEffets(), erreurs);
		}
		else
		{
			if(this.actionSelectionne != null)
			{
				this.actionSelectionne.setChecked(false);
			}
			this.actionSelectionne = null;
			
			this.vider();
		}
	}

	/*
	 * Slot-Signaux du composant
	 */

	/**
	 * Demande l'ouverture d'une fenêtre de gestion des arcs.
	 * 
	 * @category Slot-Signal
	 */
	public void slotGestionArc()
	{
		this.signalGerer.emit(FlagsTypesArmes.Arc);
	}
	/**
	 * Demande l'ouverture d'une fenêtre de gestion des dagues.
	 * 
	 * @category Slot-Signal
	 */
	public void slotGestionDague()
	{
		this.signalGerer.emit(FlagsTypesArmes.Dague);
	}
	/**
	 * Demande l'ouverture d'une fenêtre de gestion des épées.
	 * 
	 * @category Slot-Signal
	 */
	public void slotGestionEpee()
	{
		this.signalGerer.emit(FlagsTypesArmes.Epee);
	}
	/**
	 * Demande l'ouverture d'une fenêtre de gestion des faux.
	 * 
	 * @category Slot-Signal
	 */
	public void slotGestionFaux()
	{
		this.signalGerer.emit(FlagsTypesArmes.Faux);
	}
	/**
	 * Demande l'ouverture d'une fenêtre de gestion des haches.
	 * 
	 * @category Slot-Signal
	 */
	public void slotGestionHache()
	{
		this.signalGerer.emit(FlagsTypesArmes.Hache);
	}
	/**
	 * Demande l'ouverture d'une fenêtre de gestion des outils.
	 * 
	 * @category Slot-Signal
	 */
	public void slotGestionOutil()
	{
		this.signalGerer.emit(FlagsTypesArmes.Outil);
	}
	/**
	 * Demande l'ouverture d'une fenêtre de gestion des baguettes.
	 * 
	 * @category Slot-Signal
	 */
	public void slotGestionBaguette()
	{
		this.signalGerer.emit(FlagsTypesArmes.Baguette);
	}
	/**
	 * Demande l'ouverture d'une fenêtre de gestion des bâtons.
	 * 
	 * @category Slot-Signal
	 */
	public void slotGestionBaton()
	{
		this.signalGerer.emit(FlagsTypesArmes.Baton);
	}
	/**
	 * Demande l'ouverture d'une fenêtre de gestion des pelles.
	 * 
	 * @category Slot-Signal
	 */
	public void slotGestionPelle()
	{
		this.signalGerer.emit(FlagsTypesArmes.Pelle);
	}
	/**
	 * Demande l'ouverture d'une fenêtre de gestion des pioches.
	 * 
	 * @category Slot-Signal
	 */
	public void slotGestionPioche()
	{
		this.signalGerer.emit(FlagsTypesArmes.Pioche);
	}
	/**
	 * Demande l'ouverture d'une fenêtre de gestion des mateaux.
	 * 
	 * @category Slot-Signal
	 */
	public void slotGestionMarteau()
	{
		this.signalGerer.emit(FlagsTypesArmes.Marteau);
	}

	/**
	 * Demande l'équipement de l'arme représentée par le {@link QAction} {@code action}.
	 * 
	 * @param action - Le {@link QAction} de l'arme.
	 * @category Slot-Signal
	 */
	public void slotEquipe(QAction action)
	{
		this.signalEquiper.emit(action.data());
	}

	/**
	 * Demande le retrait de l'arme équipée.
	 * 
	 * @category Slot-Signal
	 */
	public void slotRetire()
	{
		this.signalRetirer.emit();
	}

	/*
	 * Accesseurs
	 */
	
	/**
	 * Renvoie {@code actionSelectionne}.
	 * 
	 * @return Le {@link QAction} représantant l'arme équipée.
	 * @category Accesseur
	 */
	public final QAction getActionSelectionne()
	{
		return this.actionSelectionne;
	}
	
	@Override
	public String getNomObjet()
	{
		if(this.getActionSelectionne() != null)
		{
			SauvegardeArme sauvegarde = (SauvegardeArme) this.getActionSelectionne().data();
			
			if(sauvegarde != null)
				return sauvegarde.getNom();
		}
		
		return null;
	}
}