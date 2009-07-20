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
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.JDofusCalc.dofus.objets.Dofus.FlagsTypesDofus;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeDofus;

import com.trolltech.qt.QSignalEmitter;
import com.trolltech.qt.gui.QAction;
import com.trolltech.qt.gui.QMenu;
import com.trolltech.qt.gui.QWidget;

/**
 * Ligne dofus d'un tableau {@link QWidgetTableauObjets}.
 * 
 * @author PAPAYA Alexandre
 * @category Composant
 * @version 1.0
 */
public class QWidgetLigneDofus extends QWidgetLigneAbstraite
{
	/*
	 * Variables d'instances
	 */

	/* Composants */
	
	// Vide

	/* Autres */

	/**
	 * La liste des {@link QAction} représentants les Dofus équipés.
	 */
	private HashMap<FlagsTypesDofus, QAction> listeActionsSelectionnes;

	/**
	 * Liste des {@link QAction} du sous menu "équiper".
	 */
	private HashMap<FlagsTypesDofus, QAction> listeActionsEquiper;

	/**
	 * Liste des {@link QAction} "retirer" du sous menu "équiper".
	 */
	private HashMap<FlagsTypesDofus, QAction> listeActionsRetirer;

	/**
	 * Références des {@link QAction} des Dofus.
	 */
	private HashMap<FlagsTypesDofus, HashMap<Integer, QAction>> references;

	/*
	 * Signaux
	 */

	/**
	 * <p>Ce signal prend 1 argument(s) générique(s) : &lt;{@link FlagsTypesDofus} (nom: type)&gt;.</p>
	 * <p>Ce signal est émit lors d'une demande d'ouverture de la fenêtre de gestion des Dofus {@code type}.</p>
	 */
	public Signal1<FlagsTypesDofus> signalGerer = new Signal1<FlagsTypesDofus>();

	/**
	 * <p>Ce signal prend 2 argument(s) générique(s) : &lt;{@link FlagsTypesDofus} (nom: type), {@link Object} (nom: sauvegarde)&gt;.</p>
	 * <p>Ce signal est émit lors d'une demande d'équipement du Dofus {@code sauvegarde} de type {@code type}.</p>
	 */
	public Signal2<FlagsTypesDofus, Object> signalEquiper = new Signal2<FlagsTypesDofus, Object>();

	/**
	 * <p>Ce signal prend 1 argument(s) générique(s) : &lt;{@link FlagsTypesDofus} (nom: type)&gt;.</p>
	 * <p>Ce signal est émit lors d'une demande de retrait du Dofus {@code type} équipé.</p>
	 */
	public Signal1<FlagsTypesDofus> signalRetirer = new Signal1<FlagsTypesDofus>();

	/*
	 * Constructeurs / Destructeur
	 */

	/**
	 * Construit un nouveau composant.
	 * 
	 * @param parent - Composant parent.
	 * @category Constructeur
	 */
	public QWidgetLigneDofus(QWidget parent)
	{
		// Execution du constructeur de la classe mère
		super(parent);

		this.listeActionsEquiper = new LinkedHashMap<FlagsTypesDofus, QAction>();
		this.listeActionsEquiper.put(FlagsTypesDofus.Dofawa, null);
		this.listeActionsEquiper.put(FlagsTypesDofus.Cawotte, null);
		this.listeActionsEquiper.put(FlagsTypesDofus.Emeraude, null);
		this.listeActionsEquiper.put(FlagsTypesDofus.Kaliptus, null);
		this.listeActionsEquiper.put(FlagsTypesDofus.Ocre, null);
		this.listeActionsEquiper.put(FlagsTypesDofus.Pourpre, null);
		this.listeActionsEquiper.put(FlagsTypesDofus.Turquoise, null);
		this.listeActionsEquiper.put(FlagsTypesDofus.Vulbis, null);

		this.listeActionsRetirer = new HashMap<FlagsTypesDofus, QAction>();
		this.listeActionsSelectionnes = new HashMap<FlagsTypesDofus, QAction>();
		this.references = new HashMap<FlagsTypesDofus, HashMap<Integer, QAction>>();
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

			QMenu menuGerer = new QMenu();
			QMenu menuEquiper = new QMenu();

			for(Entry<FlagsTypesDofus, QAction> entry : this.listeActionsEquiper.entrySet())
			{
				FlagsTypesDofus typeDofus = entry.getKey();
				QAction actionEquiper = new QAction(typeDofus.getNom(), this);
				this.listeActionsEquiper.put(typeDofus, actionEquiper);
				menuEquiper.addAction(actionEquiper);

				QAction actionGerer = new QAction(typeDofus.getNom(), this);
				actionGerer.triggered.connect(this, "slotGestion()");
				menuGerer.addAction(actionGerer);
			}

			this.ui.actionEquiper.setText("Equiper un Dofus");
			this.ui.actionEquiper.setMenu(menuEquiper);
			this.ui.actionEquiper.setEnabled(true);
			menu.addAction(this.ui.actionEquiper);

			this.ui.actionGerer.setText("Gérer mes Dofus");
			this.ui.actionGerer.setMenu(menuGerer);
			menu.addAction(this.ui.actionGerer);

			this.ui.btnActions.setMenu(menu);
		}
	}

	/**
	 * Définit la liste des sauvegardes des Dofus de type {@code typeDofus}.
	 * 
	 * @param typeDofus - Type des Dofus.
	 * @param sauvegardes - Sauvegardes des Dofus.
	 */
	public void setListeSauvegardesDofus(FlagsTypesDofus typeDofus, ArrayList<SauvegardeDofus> sauvegardes)
	{
		QAction actionEquiper = this.listeActionsEquiper.get(typeDofus);

		actionEquiper.setEnabled(false);
		QMenu menuEquiper = new QMenu();
		QAction actionRetirer = new QAction("Retirer " + typeDofus.getNom(), this);
		actionRetirer.setEnabled(false);
		actionRetirer.setData(typeDofus);
		this.listeActionsRetirer.put(typeDofus, actionRetirer);
		menuEquiper.addAction(actionRetirer);
		menuEquiper.addSeparator();
		HashMap<Integer, QAction> reference = new HashMap<Integer, QAction>();
		for(int i = 0; i < sauvegardes.size(); i++)
		{
			SauvegardeDofus sauvegarde = sauvegardes.get(i);
			actionEquiper.setEnabled(true);
			QAction action = new QAction(this);
			action.setCheckable(true);
			action.setText(sauvegarde.getNom());
			action.setData(sauvegarde);
			menuEquiper.addAction(action);
			reference.put(sauvegarde.getId(), action);
		}

		this.references.put(typeDofus, reference);
		menuEquiper.triggered.connect(this, "slotEquipe(QAction)");
		actionEquiper.setMenu(menuEquiper);
	}

	/**
	 * <p>Définit l'arme équipée. Si {@code sauvegarde} est {@code null}, alors le composant se vide.</p>
	 * 
	 * @param typeDofus - Type du Dofus.
	 * @param sauvegarde - Sauvegarde de l'arme.
	 */
	public void setDofusEquipe(FlagsTypesDofus typeDofus, SauvegardeDofus sauvegarde)
	{
		if(sauvegarde != null)
		{
			QAction action = this.references.get(typeDofus).get(sauvegarde.getId());

			if(this.listeActionsSelectionnes.get(typeDofus) != null)
			{
				this.listeActionsSelectionnes.get(typeDofus).setChecked(false);
			}
			this.listeActionsSelectionnes.put(typeDofus, action);
			action.setChecked(true);

			this.listeActionsRetirer.get(typeDofus).setEnabled(true);

			this.afficherDonnees(sauvegarde.getEffets());
		}
		else
		{
			if(this.listeActionsSelectionnes.get(typeDofus) != null)
			{
				this.listeActionsSelectionnes.get(typeDofus).setChecked(false);
				this.listeActionsRetirer.get(typeDofus).setEnabled(false);
			}
			this.listeActionsSelectionnes.put(typeDofus, null);
			
			this.vider();
		}
	}
	
	/**
	 * Retire tous les Dofus équipés du composant.
	 */
	public void retireTout()
	{
		for(Entry<FlagsTypesDofus, QAction> entry : this.listeActionsSelectionnes.entrySet())
		{
			this.setDofusEquipe(entry.getKey(), null);
		}
	}

	/*
	 * Slot-Signaux du composant
	 */

	/**
	 * Demande l'ouverture d'une fenêtre de gestion des Dofus.
	 * 
	 * @category Slot-Signal
	 */
	public void slotGestion()
	{
		QAction action = (QAction) QSignalEmitter.signalSender();
		this.signalGerer.emit(FlagsTypesDofus.getFlag(action.text()));
	}

	/**
	 * Demande l'équipement du Dofus représenté par le {@link QAction} {@code action}.
	 * 
	 * @param action - Le {@link QAction} du Dofus.
	 * @category Slot-Signal
	 */
	public void slotEquipe(QAction action)
	{
		// Si le QAction représente bien une sauvegarde d'un dofus
		try
		{
			SauvegardeDofus sauvegarde = (SauvegardeDofus) action.data();
			FlagsTypesDofus type = sauvegarde.getType();
			this.signalEquiper.emit(type, sauvegarde);
		}
		// Si c'est le QAction "retirer"
		catch(ClassCastException e)
		{
			this.slotRetire(action);
		}
	}

	/**
	 * Demande le retrait de l'arme équipée.
	 * 
	 * @param action - Le {@link QAction} "retirer".
	 * @category Slot-Signal
	 */
	public void slotRetire(QAction action)
	{
		FlagsTypesDofus type;
		if(action.data() instanceof SauvegardeDofus)
		{
			SauvegardeDofus sauvegarde = (SauvegardeDofus) action.data();
			type = sauvegarde.getType();
		}
		else
		{
			type = (FlagsTypesDofus) action.data();
		}

		this.signalRetirer.emit(type);
	}
	
	/*
	 * Accesseurs
	 */

	/**
	 * Renvoie le {@link QAction} représantant le Dofus {@code type} équipée.
	 * 
	 * @param type - Type du Dofus.
	 * @return Le {@link QAction} représantant le Dofus {@code type} équipée.
	 * @category Accesseur
	 */
	public final QAction getActionSelectionne(FlagsTypesDofus type)
	{
		return this.listeActionsSelectionnes.get(type);
	}
	
	@Override
	public String getNomObjet()
	{
		String nom = "";
		
		for(FlagsTypesDofus flag : FlagsTypesDofus.values())
		{
			if(this.getActionSelectionne(flag) != null)
			{
				SauvegardeDofus sauvegarde = (SauvegardeDofus) this.getActionSelectionne(flag).data();
				
				if(sauvegarde != null)
					nom+= sauvegarde.getNom() + ", ";
			}
		}
		
		if(!nom.equals(""))
		{
			nom = nom.substring(0, (nom.length() - 2));
			return nom;
		}
		else
			return null;
	}
}