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
import java.util.Map.Entry;

import org.JDofusCalc.dofus.autres.Effets;
import org.JDofusCalc.dofus.autres.Effets.FlagsTypesEffets;
import org.JDofusCalc.dofus.objets.Dofus;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeDofus;
import org.JDofusCalc.vues.Qt.designer.UIGestionDofus;

import com.trolltech.qt.core.Qt;
import com.trolltech.qt.core.Qt.ItemDataRole;
import com.trolltech.qt.gui.QCloseEvent;
import com.trolltech.qt.gui.QListWidgetItem;
import com.trolltech.qt.gui.QPixmap;
import com.trolltech.qt.gui.QWidget;

/**
 * Fenêtre de gestion des dofus.
 * 
 * @author PAPAYA Alexandre
 * @category Fenêtre
 * @version 1.0
 */
public class QWindowGestionDofus extends QWidget
{
	/*
	 * Variables d'instances
	 */
	
	/* Composants */

	/**
	 * L'interface graphique.
	 */
	public UIGestionDofus ui;

	/**
	 * Fenêtre parente.
	 */
	QWidget parent;
	
	/* Autres */
	
	/**
	 * Liste des images des icônes des effets des Dofus.
	 */
	private HashMap<FlagsTypesEffets, String> listeImages;

	/**
	 * Nom de l'effet du Dofus chargé.
	 */
	private FlagsTypesEffets effet;

	/**
	 * Dofus à gérer.
	 */
	private Dofus dofus;
	
	/*
	 * Signaux
	 */

	/**
	 * <p>Ce signal prend 1 argument(s) générique(s) : &lt;{@link String} (nom: nom)&gt;.</p>
	 * <p>Ce signal est émit lors d'une demande de création d'un Dofus {@code nom}.</p>
	 */
	public Signal1<String> signalCreerDofus = new Signal1<String>();

	/**
	 * <p>Ce signal prend 1 argument(s) générique(s) : &lt;{@link SauvegardeDofus} (nom: sauvegarde)&gt;.</p>
	 * <p>Ce signal est émit lors d'une demande de sauvegarde du Dofus {@code sauvegarde}.</p>
	 */
	public Signal1<SauvegardeDofus> signalSauvergarderDofus = new Signal1<SauvegardeDofus>();

	/**
	 * <p>Ce signal prend 1 argument(s) générique(s) : &lt;{@link SauvegardeDofus} (nom: sauvegarde)&gt;.</p>
	 * <p>Ce signal est émit lors d'une demande de suppression du Dofus {@code sauvegarde}.</p>
	 */
	public Signal1<SauvegardeDofus> signalSupprimerDofus = new Signal1<SauvegardeDofus>();

	/**
	 * <p>Ce signal prend aucun argument générique.</p>
	 * <p>Ce signal est émit lors d'une demande de fermeture de la fenêtre.</p>
	 */
	public Signal0 signalFermer = new Signal0();

	/*
	 * Constructeurs / Destructeur
	 */

	/**
	 * Construit une nouvelle fenêtre.
	 * 
	 * @param parent - Fenêtre parente.
	 * @param dofus - Dofus à gérer.
	 * @category Constructeur
	 */
	public QWindowGestionDofus(QWidget parent, Dofus dofus)
	{
		// Execution du constructeur de la classe mère
		super(parent, Qt.WindowType.Window);
		this.parent = parent;
		this.dofus = dofus;

		// Initialisation de l'interface graphique
		this.ui = new UIGestionDofus();
		this.ui.setupUi(this);
		this.setWindowTitle("Gestion de " + dofus.getNom());

		this.listeImages = new HashMap<FlagsTypesEffets, String>();
		this.listeImages.put(FlagsTypesEffets.Pa, "org/JDofusCalc/ressources/images/pa.png");
		this.listeImages.put(FlagsTypesEffets.Vie, "org/JDofusCalc/ressources/images/vie.png");
		this.listeImages.put(FlagsTypesEffets.Vitalite, "org/JDofusCalc/ressources/images/vita.png");
		this.listeImages.put(FlagsTypesEffets.Sagesse, "org/JDofusCalc/ressources/images/sagesse.png");
		this.listeImages.put(FlagsTypesEffets.Pm, "org/JDofusCalc/ressources/images/pm.png");
		this.listeImages.put(FlagsTypesEffets.Prospection, "org/JDofusCalc/ressources/images/pp.png");
		this.listeImages.put(FlagsTypesEffets.CoupsCritiques, "org/JDofusCalc/ressources/images/critique.png");
		this.listeImages.put(FlagsTypesEffets.PourcentagesDommages, "org/JDofusCalc/ressources/images/pdommages.png");

		for(Entry<FlagsTypesEffets, String> entry : this.listeImages.entrySet())
		{
			int valeur = dofus.getEffetsMaximum().getInt(entry.getKey());
			if(valeur != 0)
			{
				this.ui.imgEffet.setPixmap(new QPixmap("classpath:" + entry.getValue()));
				this.ui.imgEffet.setToolTip(entry.getKey().getNom());
				this.effet = entry.getKey();
				break;
			}
		}

		/* Connexions signal->slot */
		this.ui.listeDofus.currentItemChanged.connect(this, "slotSelectionSauvegarde()");
		this.ui.listeDofus.clicked.connect(this, "slotSelectionSauvegarde()");
		this.ui.btnEffetsMini.clicked.connect(this, "slotChargementEffetMini()");
		this.ui.btnEffetsMaxi.clicked.connect(this, "slotChargementEffetMaxi()");
		this.ui.btnSauv.clicked.connect(this, "slotSauvegardeDofus()");
		this.ui.btnSupp.clicked.connect(this, "slotSuppressionDofus()");
		this.ui.btnNouveau.clicked.connect(this, "slotCreationDofus()");
		this.ui.btnFermer.clicked.connect(this, "slotFermeture()");
	}

	/*
	 * Evènements
	 */
	
	@Override
	protected void closeEvent(QCloseEvent event)
	{
		super.closeEvent(event);
		this.signalFermer.emit();
	}

	/*
	 * Méthodes d'affichage des données de la fenêtre
	 */
	
	/**
	 * Définit la liste des sauvegardes des Dofus.
	 * 
	 * @param sauvegardes - La liste des sauvegardes.
	 */
	public void setListeSauvegardesDofus(ArrayList<SauvegardeDofus> sauvegardes)
	{
		this.ui.listeDofus.clear();
		for(int i = 0; i < sauvegardes.size(); i++)
		{
			QListWidgetItem item = new QListWidgetItem();
			item.setText(sauvegardes.get(i).getNom());
			item.setData(ItemDataRole.UserRole, sauvegardes.get(i));
			this.ui.listeDofus.addItem(item);
		}
	}

	/**
	 * Définit la sauvegarde du Dofus à charger par la fenêtre.
	 * 
	 * @param sauvegarde - Dofus à charger.
	 */
	private void setDofus(SauvegardeDofus sauvegarde)
	{
		this.ui.txtNom.setText(sauvegarde.getNom());
		this.ui.txtValeur.setText(String.valueOf(sauvegarde.getEffets().getInt(this.effet)));
	}

	/*
	 * Slots de la fenêtre
	 */

	/**
	 * Charge la valeur minimum de l'effet du Dofus.
	 */
	public void slotChargementEffetMini()
	{
		this.ui.txtValeur.setText(String.valueOf(this.dofus.getEffetsMinimum().getInt(this.effet)));
	}

	/**
	 * Charge la valeur maximum de l'effet du Dofus.
	 */
	public void slotChargementEffetMaxi()
	{
		this.ui.txtValeur.setText(String.valueOf(this.dofus.getEffetsMaximum().getInt(this.effet)));
	}

	/**
	 * Charge la sauvegarde du Dofus selectionné.
	 * 
	 * @category Slot
	 */
	public void slotSelectionSauvegarde()
	{
		if(this.ui.listeDofus.selectedItems().size() == 1)
		{
			// Activation des boutons
			this.ui.btnSupp.setEnabled(true);
			this.ui.btnSauv.setEnabled(true);
			this.ui.txtNom.setEnabled(true);
			this.ui.txtValeur.setEnabled(true);
			this.ui.btnEffetsMaxi.setEnabled(true);
			this.ui.btnEffetsMini.setEnabled(true);

			QListWidgetItem item = this.ui.listeDofus.currentItem();
			SauvegardeDofus sauvegarde = (SauvegardeDofus) item.data(ItemDataRole.UserRole);

			this.setDofus(sauvegarde);
		}
	}
	
	/**
	 * Ferme la fenetre
	 * 
	 * @category Slot
	 */
	public void slotFermeture()
	{
		this.close();
	}
	
	/*
	 * Slot-Signaux de la fenêtre
	 */

	/**
	 * Demande la sauvegarde du Dofus selectionné.
	 * 
	 * @category Slot-Signal
	 */
	public void slotSauvegardeDofus()
	{
		if(this.ui.listeDofus.selectedItems().size() == 1)
		{
			QListWidgetItem item = this.ui.listeDofus.currentItem();
			SauvegardeDofus sauvegarde = (SauvegardeDofus) item.data(ItemDataRole.UserRole);

			Effets effet = new Effets();
			effet.setInt(this.effet, Integer.parseInt(this.ui.txtValeur.text()));

			sauvegarde.setEffets(effet);
			sauvegarde.setNom(this.ui.txtNom.text().trim());

			this.signalSauvergarderDofus.emit(sauvegarde);
		}
	}

	/**
	 * Demande la suppression du Dofus selectionné.
	 * 
	 * @category Slot-Signal
	 */
	public void slotSuppressionDofus()
	{
		if(this.ui.listeDofus.selectedItems().size() == 1)
		{
			// Désctivation des boutons
			this.ui.btnSupp.setEnabled(false);
			this.ui.btnSauv.setEnabled(false);
			this.ui.txtNom.setEnabled(false);
			this.ui.txtValeur.setEnabled(false);
			this.ui.btnEffetsMaxi.setEnabled(false);
			this.ui.btnEffetsMini.setEnabled(false);

			QListWidgetItem item = this.ui.listeDofus.currentItem();
			SauvegardeDofus sauvegarde = (SauvegardeDofus) item.data(ItemDataRole.UserRole);

			this.signalSupprimerDofus.emit(sauvegarde);
		}
	}

	/**
	 * Demande la création d'un nouveau Dofus.
	 * 
	 * @category Slot-Signal
	 */
	public void slotCreationDofus()
	{
		// Génération d'un nouveau nom
		String nouveauNom = "Nouveau Dofus";
		int nbNouveauDofus = this.ui.listeDofus.findItems(nouveauNom, Qt.MatchFlag.MatchStartsWith).size();
		String nom = "";
		if(nbNouveauDofus == 0)
		{
			nom = nouveauNom;
		}
		else
		{
			nom = nouveauNom + (nbNouveauDofus + 1);
		}

		// Envoie d'un signal
		this.signalCreerDofus.emit(nom);
	}
}