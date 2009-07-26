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

import org.JDofusCalc.dofus.objets.Animal;
import org.JDofusCalc.dofus.objets.Animal.FlagsTypesAnimaux;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeAnimal;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeFamilier;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeMonture;

import com.trolltech.qt.gui.QAction;
import com.trolltech.qt.gui.QMenu;
import com.trolltech.qt.gui.QWidget;

/**
 * Ligne animal d'un tableau {@link QWidgetTableauObjets}.
 * 
 * @author PAPAYA Alexandre
 * @category Composant
 * @version 1.0
 * @see {@link QWidgetTableauObjets} et {@link QWidgetLigneAbstraite}.
 */
public class QWidgetLigneAnimal extends QWidgetLigneAbstraite
{
	/*
	 * Variables d'instances
	 */

	/* Composants */

	// Vide

	/* Autres */

	/**
	 * Le {@link QAction} représentant l'animal équipé.
	 */
	private QAction actionSelectionne;

	/**
	 * Liste des {@link QAction} du sous menu "équiper".
	 */
	private ArrayList<QAction> listeActionsEquiper;

	/**
	 * Références des {@link QAction} des montures.
	 */
	private HashMap<Integer, QAction> referencesMontures;

	/**
	 * Références des {@link QAction} des familiers.
	 */
	private HashMap<Integer, QAction> referencesFamiliers;

	/*
	 * Signaux
	 */

	/**
	 * <p>Ce signal prend 1 argument(s) générique(s) : &lt;{@link FlagsTypesAnimaux} (nom: type)&gt;.</p>
	 * <p>Ce signal est émit lors d'une demande d'ouverture de la fenêtre de gestion des animaux {@code type}.</p>
	 */
	public Signal1<FlagsTypesAnimaux> signalGerer = new Signal1<FlagsTypesAnimaux>();

	/**
	 * <p>Ce signal prend 2 argument(s) générique(s) : &lt;{@link FlagsTypesAnimaux} (nom: type), {@link Object} (nom: sauvegarde)&gt;.</p>
	 * <p>Ce signal est émit lors d'une demande d'équipement de l'animal {@code sauvegarde} de type {@code }.</p>
	 */
	public Signal2<FlagsTypesAnimaux, Object> signalEquiper = new Signal2<FlagsTypesAnimaux, Object>();

	/**
	 * <p>Ce signal prend aucun argument générique.</p>
	 * <p>Ce signal est émit lors d'une demande de retrait de l'animal équipé.</p>
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
	public QWidgetLigneAnimal(QWidget parent)
	{
		// Execution du constructeur de la classe mère
		super(parent);
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
			// Création du menu
			QMenu menu = new QMenu();

			QAction actionEquiperFamiliers = new QAction("Familiers", this);
			QAction actionEquiperMontures = new QAction("Montures", this);

			this.listeActionsEquiper = new ArrayList<QAction>();
			this.listeActionsEquiper.add(actionEquiperFamiliers);
			this.listeActionsEquiper.add(actionEquiperMontures);

			QMenu menuEquiper = new QMenu();
			menuEquiper.addActions(this.listeActionsEquiper);

			QAction actionFamiliers = new QAction("Familiers", this);
			actionFamiliers.triggered.connect(this, "slotGestionFamiliers()");
			QAction actionMontures = new QAction("Montures", this);
			actionMontures.triggered.connect(this, "slotGestionMontures()");

			ArrayList<QAction> liste = new ArrayList<QAction>();
			liste.add(actionFamiliers);
			liste.add(actionMontures);

			QMenu menuGerer = new QMenu();
			menuGerer.addActions(liste);

			this.ui.actionRetirer.setText("Retirer l'animal");
			menu.addAction(this.ui.actionRetirer);
			this.ui.actionEquiper.setText("Equiper un animal");
			this.ui.actionEquiper.setMenu(menuEquiper);
			this.ui.actionEquiper.setEnabled(true);
			menu.addAction(this.ui.actionEquiper);
			this.ui.actionGerer.setText("Gérer mes animaux");
			this.ui.actionGerer.setMenu(menuGerer);
			menu.addAction(this.ui.actionGerer);

			this.ui.btnActions.setMenu(menu);

			// Connexions signal/slot
			this.ui.actionRetirer.triggered.connect(this, "slotRetire()");
		}
	}

	/**
	 * Définit la liste des sauvegardes des familiers.
	 * 
	 * @param sauvegardes - Sauvegardes des familiers.
	 */
	public void setListeSauvegardesFamiliers(ArrayList<SauvegardeFamilier> sauvegardes)
	{
		QAction actionEquiper = this.listeActionsEquiper.get(0);
		actionEquiper.setEnabled(false);
		QMenu menuEquiper = new QMenu();
		this.referencesFamiliers = new HashMap<Integer, QAction>();
		for(int i = 0; i < sauvegardes.size(); i++)
		{
			SauvegardeFamilier sauvegarde = sauvegardes.get(i);
			actionEquiper.setEnabled(true);
			QAction action = new QAction(this);
			action.setCheckable(true);
			action.setText(sauvegarde.getNom());
			action.setData(sauvegarde);
			menuEquiper.addAction(action);
			this.referencesFamiliers.put(sauvegarde.getId(), action);
		}
		menuEquiper.triggered.connect(this, "slotEquipe(QAction)");
		actionEquiper.setMenu(menuEquiper);
	}

	/**
	 * Définit la liste des sauvegardes des montures.
	 * 
	 * @param sauvegardes - Sauvegardes des montures.
	 */
	public void setListeSauvegardesMontures(ArrayList<SauvegardeMonture> sauvegardes)
	{
		QAction actionEquiper = this.listeActionsEquiper.get(1);
		actionEquiper.setEnabled(false);
		QMenu menuEquiper = new QMenu();
		this.referencesMontures = new HashMap<Integer, QAction>();
		for(int i = 0; i < sauvegardes.size(); i++)
		{
			SauvegardeMonture sauvegarde = sauvegardes.get(i);
			actionEquiper.setEnabled(true);
			QAction action = new QAction(this);
			action.setCheckable(true);
			action.setText(sauvegarde.getNom());
			action.setData(sauvegarde);
			menuEquiper.addAction(action);
			this.referencesMontures.put(sauvegarde.getId(), action);

			// Si l'objet de la boucle est celui selectionné
			if(this.actionSelectionne != null)
			{
				Animal sauvegardeSelectionnee = (Animal) this.actionSelectionne.data();
				if(sauvegarde.getId() == sauvegardeSelectionnee.getId())
				{
					action.setChecked(true);
					this.actionSelectionne = action;
				}
			}
		}
		menuEquiper.triggered.connect(this, "slotEquipe(QAction)");
		actionEquiper.setMenu(menuEquiper);
	}
	
	/*
	 * Méthodes
	 */

	/**
	 * <p>Définit l'animal équipé. Si {@code sauvegarde} est {@code null}, alors le composant se vide.</p>
	 * 
	 * @param sauvegarde - Sauvegarde de l'animal.
	 * @param erreurs - Erreurs à afficher.
	 */
	public void setAnimalEquipe(SauvegardeAnimal sauvegarde, String erreurs)
	{
		if(sauvegarde != null)
		{
			QAction action = null;
			if(sauvegarde instanceof SauvegardeFamilier)
				action = this.referencesFamiliers.get(sauvegarde.getId());
			else
				action = this.referencesMontures.get(sauvegarde.getId());
			
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
	 * Demande l'ouverture d'une fenêtre de gestion des familiers.
	 * 
	 * @category Slot-Signal
	 */
	public void slotGestionFamiliers()
	{
		this.signalGerer.emit(FlagsTypesAnimaux.Familier);
	}

	/**
	 * Demande l'ouverture d'une fenêtre de gestion des montures.
	 * 
	 * @category Slot-Signal
	 */
	public void slotGestionMontures()
	{
		this.signalGerer.emit(FlagsTypesAnimaux.Monture);
	}

	/**
	 * Demande l'équipement de l'animal représenté par le {@link QAction} {@code action}.
	 * 
	 * @param action - Le {@link QAction} de l'animal.
	 * @category Slot-Signal
	 */
	public void slotEquipe(QAction action)
	{
		Animal animal = (Animal) action.data();
		this.signalEquiper.emit(animal.getType(), animal);
	}

	/**
	 * Demande le retrait de l'animal équipé.
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
	 * @return Le {@link QAction} représantant l'animal équipé.
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
			SauvegardeAnimal sauvegarde = (SauvegardeAnimal) this.getActionSelectionne().data();
			
			if(sauvegarde != null)
				return sauvegarde.getNom();
		}
		
		return null;
	}
}