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

import org.JDofusCalc.dofus.autres.Effets.FlagsTypesEffets;
import org.JDofusCalc.dofus.objets.Equipement.FlagsTypesEquipements;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeEquipement;

import com.trolltech.qt.gui.QAction;
import com.trolltech.qt.gui.QMenu;
import com.trolltech.qt.gui.QWidget;

/**
 * Ligne équipement d'un tableau {@link QWidgetTableauObjets}.
 * 
 * @author PAPAYA Alexandre
 * @category Composant
 * @version 1.0
 */
public class QWidgetLigneEquipement extends QWidgetLigneAbstraite
{
	/*
	 * Variables d'instances
	 */

	/* Composants */

	// Vide

	/*
	 * Autres
	 */

	/* Autres */

	/**
	 * Le {@link QAction} représentant l'équipement équipée.
	 */
	private QAction actionSelectionne;

	/**
	 * Le {@link QAction} vérrouillé.
	 */
	private QAction actionDisabled;

	/**
	 * Références des {@link QAction} des équipements.
	 */
	private HashMap<Integer, QAction> references;
	
	/**
	 * Type de l'équipement.
	 */
	private FlagsTypesEquipements typeEquipement;

	/*
	 * Signaux
	 */

	/**
	 * <p>Ce signal prend 1 argument(s) générique(s) : &lt;{@link FlagsTypesEquipements} (nom: type)&gt;.</p>
	 * <p>Ce signal est émit lors d'une demande d'ouverture de la fenêtre de gestion des équipements {@code type}.</p>
	 */
	public Signal1<FlagsTypesEquipements> signalGerer = new Signal1<FlagsTypesEquipements>();

	/**
	 * <p>Ce signal prend 2 argument(s) générique(s) : &lt;{@link FlagsTypesEquipements} (nom: type), {@link Object} (nom: sauvegarde)&gt;.</p>
	 * <p>Ce signal est émit lors d'une demande d'équipement de l'équipement {@code sauvegarde} de type {@code type}.</p>
	 */
	public Signal2<FlagsTypesEquipements, Object> signalEquiper = new Signal2<FlagsTypesEquipements, Object>();

	/**
	 * <p>Ce signal prend 1 argument(s) générique(s) : &lt;{@link FlagsTypesEquipements} (nom: type)&gt;.</p>
	 * <p>Ce signal est émit lors d'une demande de retrait de l'équipement {@code type} équipé.</p>
	 */
	public Signal1<FlagsTypesEquipements> signalRetirer = new Signal1<FlagsTypesEquipements>();

	/*
	 * Constructeurs / Destructeur
	 */

	/**
	 * Construit un nouveau composant.
	 * 
	 * @param parent - Composant parent.
	 * @category Constructeur
	 */
	public QWidgetLigneEquipement(QWidget parent)
	{
		// Execution du constructeur de la classe mère
		super(parent);
	}

	/*
	 * Méthodes de génération du composant
	 */

	/**
	 * Vérrouille un anneau qui devient non-équipable.
	 * 
	 * @param id - Id de l'anneau.
	 */
	public void verrouillerAnneau(int id)
	{
		this.actionDisabled = this.references.get(id);
		this.actionDisabled.setEnabled(false);
	}

	/**
	 * Devérrouille l'anneau vérrouillé.
	 */
	public void deverrouillerAnneau()
	{
		if(this.actionDisabled != null)
		{
			this.actionDisabled.setEnabled(true);
		}
	}

	@Override
	public void genererMenu()
	{
		this.typeEquipement = FlagsTypesEquipements.getFlag((String) this.property("nomObjet"));

		// Si le compasant doit generer un menu
		if(this.afficherMenu)
		{
			// Création du menu
			QMenu menu = new QMenu();
			this.ui.actionRetirer.setText("Retirer " + this.typeEquipement.getNom());
			menu.addAction(this.ui.actionRetirer);
			this.ui.actionEquiper.setText("Equiper " + this.typeEquipement.getNom());
			menu.addAction(this.ui.actionEquiper);
			this.ui.actionGerer.setText("Gérer " + this.typeEquipement.getNom());
			menu.addAction(this.ui.actionGerer);

			this.ui.btnActions.setMenu(menu);

			// Connexions signal/slot
			this.ui.actionGerer.triggered.connect(this, "slotGestionEquipement()");
			this.ui.actionRetirer.triggered.connect(this, "slotRetire()");
		}
	}

	/**
	 * Définit la liste des sauvegardes des équipements.
	 * 
	 * @param sauvegardes - Sauvegardes des équipements.
	 */
	public void setListeSauvegardesEquipements(ArrayList<SauvegardeEquipement> sauvegardes)
	{
		// Si c'est la ligne des boucliers
		if(this.typeEquipement == FlagsTypesEquipements.Bouclier)
		{
			this.champs.put(this.ui.lblStatsResNeutre, FlagsTypesEffets.ResistancesNeutrePvp);
			this.champs.put(this.ui.lblStatsResTerre, FlagsTypesEffets.ResistancesTerrePvp);
			this.champs.put(this.ui.lblStatsResFeu, FlagsTypesEffets.ResistancesFeuPvp);
			this.champs.put(this.ui.lblStatsResEau, FlagsTypesEffets.ResistancesEauPvp);
			this.champs.put(this.ui.lblStatsResAir, FlagsTypesEffets.ResistancesAirPvp);
			this.champs.put(this.ui.lblStatsPResNeutre, FlagsTypesEffets.PourcentagesResistancesNeutrePvp);
			this.champs.put(this.ui.lblStatsPResTerre, FlagsTypesEffets.PourcentagesResistancesTerrePvp);
			this.champs.put(this.ui.lblStatsPResFeu, FlagsTypesEffets.PourcentagesResistancesFeuPvp);
			this.champs.put(this.ui.lblStatsPResEau, FlagsTypesEffets.PourcentagesResistancesEauPvp);
			this.champs.put(this.ui.lblStatsPResAir, FlagsTypesEffets.PourcentagesResistancesAirPvp);
		}

		this.ui.actionEquiper.setEnabled(false);
		QMenu menuEquiper = new QMenu();
		this.references = new HashMap<Integer, QAction>();
		for(int i = 0; i < sauvegardes.size(); i++)
		{
			SauvegardeEquipement sauvegarde = sauvegardes.get(i);
			this.ui.actionEquiper.setEnabled(true);
			QAction action = new QAction(this);
			action.setCheckable(true);
			action.setText(sauvegarde.getNom());
			action.setData(sauvegarde);
			menuEquiper.addAction(action);
			this.references.put(sauvegarde.getId(), action);
		}
		menuEquiper.triggered.connect(this, "slotEquipe(QAction)");
		this.ui.actionEquiper.setMenu(menuEquiper);
	}

	/*
	 * Méthodes
	 */
	
	/**
	 * <p>Définit l'équipement équipée. Si {@code sauvegarde} est {@code null}, alors le composant se vide.</p>
	 * 
	 * @param sauvegarde - Sauvegarde de l'équipement.
	 * @param erreurs - Erreurs à afficher.
	 */
	public void setEquipementEquipe(SauvegardeEquipement sauvegarde, String erreurs)
	{
		if(sauvegarde != null)
		{
			QAction action = this.references.get(sauvegarde.getId());
			
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
	 * Demande l'ouverture d'une fenêtre de gestion de l'équipements.
	 * 
	 * @category Slot-Signal
	 */
	public void slotGestionEquipement()
	{
		this.signalGerer.emit(this.typeEquipement);
	}

	/**
	 * Demande l'équipement de l'équipement représenté par le {@link QAction} {@code action}.
	 * 
	 * @param action - Le {@link QAction} de l'équipement.
	 * @category Slot-Signal
	 */
	public void slotEquipe(QAction action)
	{
		this.signalEquiper.emit(this.typeEquipement, action.data());
	}

	/**
	 * Demande le retrait de l'équipement équipé.
	 * 
	 * @category Slot-Signal
	 */
	public void slotRetire()
	{
		this.signalRetirer.emit(this.typeEquipement);
	}
	
	/*
	 * Accesseurs
	 */

	/**
	 * Renvoie {@code actionSelectionne}.
	 * 
	 * @return Le {@link QAction} représantant l'équipement équipée.
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
			SauvegardeEquipement sauvegarde = (SauvegardeEquipement) this.getActionSelectionne().data();
			
			if(sauvegarde != null)
				return sauvegarde.getNom();
		}
		
		return null;
	}
}