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

import java.util.HashMap;
import java.util.Map.Entry;

import org.JDofusCalc.dofus.autres.Effets;
import org.JDofusCalc.dofus.autres.Effets.FlagsTypesEffets;
import org.JDofusCalc.vues.Qt.designer.UIBonusPanopliesLigne;

import com.trolltech.qt.QtPropertyReader;
import com.trolltech.qt.QtPropertyWriter;
import com.trolltech.qt.gui.QLabel;
import com.trolltech.qt.gui.QWidget;

/**
 * Ligne des bonus des panoplies.
 * 
 * @author PAPAYA Alexandre
 * @category Composant
 * @version 1.0
 */
public class QWidgetBonusPanopliesLigne extends QWidget
{
	/*
	 * Variables d'instances
	 */
	
	/* Composants */

	/**
	 * L'interface graphique.
	 */
	private UIBonusPanopliesLigne ui;
	
	/* Autres */

	/**
	 * Liste des champs d'une ligne liés à une clef.
	 */
	private HashMap<QLabel, FlagsTypesEffets> champs;
	
	/**
	 * Nombre d'objets de la ligne.
	 */
	private int nombreObjets;

	/*
	 * Constructeurs / Destructeur
	 */

	/**
	 * Construit un nouveau composant.
	 * 
	 * @param parent - Composant parent.
	 * @category Constructeur
	 */
	public QWidgetBonusPanopliesLigne(QWidget parent)
	{
		// Execution du constructeur de la classe mère
		super(parent);

		// Initialisation de l'interface graphique
		this.ui = new UIBonusPanopliesLigne();
		this.ui.setupUi(this);

		this.champs = new HashMap<QLabel, FlagsTypesEffets>();
		this.champs.put(this.ui.lblStatsVie, FlagsTypesEffets.Vie);
		this.champs.put(this.ui.lblStatsPA, FlagsTypesEffets.Pa);
		this.champs.put(this.ui.lblStatsPM, FlagsTypesEffets.Pm);
		this.champs.put(this.ui.lblStatsPO, FlagsTypesEffets.Po);
		this.champs.put(this.ui.lblStatsIni, FlagsTypesEffets.Initiative);
		this.champs.put(this.ui.lblStatsPP, FlagsTypesEffets.Prospection);

		this.champs.put(this.ui.lblStatsVita, FlagsTypesEffets.Vitalite);
		this.champs.put(this.ui.lblStatsSag, FlagsTypesEffets.Sagesse);
		this.champs.put(this.ui.lblStatsForce, FlagsTypesEffets.Force);
		this.champs.put(this.ui.lblStatsInt, FlagsTypesEffets.Intelligence);
		this.champs.put(this.ui.lblStatsChance, FlagsTypesEffets.Chance);
		this.champs.put(this.ui.lblStatsAgi, FlagsTypesEffets.Agilite);

		this.champs.put(this.ui.lblStatsDom, FlagsTypesEffets.Dommages);
		this.champs.put(this.ui.lblStatsPDom, FlagsTypesEffets.PourcentagesDommages);
		this.champs.put(this.ui.lblStatsCC, FlagsTypesEffets.CoupsCritiques);
		this.champs.put(this.ui.lblStatsSoin, FlagsTypesEffets.Soins);
		this.champs.put(this.ui.lblStatsInvoc, FlagsTypesEffets.CreaturesInvocables);
		this.champs.put(this.ui.lblStatsDomPiege, FlagsTypesEffets.DommagesPieges);
		this.champs.put(this.ui.lblStatsPDomPiege, FlagsTypesEffets.PourcentagesDommagesPieges);
		this.champs.put(this.ui.lblStatsEC, FlagsTypesEffets.EchecsCritiques);
		this.champs.put(this.ui.lblStatsRenvois, FlagsTypesEffets.Renvois);

		this.champs.put(this.ui.lblStatsResMagique, FlagsTypesEffets.ResistancesMagiques);
		this.champs.put(this.ui.lblStatsResPhysique, FlagsTypesEffets.ResistancesPhysiques);

		this.champs.put(this.ui.lblStatsResNeutre, FlagsTypesEffets.ResistancesNeutre);
		this.champs.put(this.ui.lblStatsResTerre, FlagsTypesEffets.ResistancesTerre);
		this.champs.put(this.ui.lblStatsResFeu, FlagsTypesEffets.ResistancesFeu);
		this.champs.put(this.ui.lblStatsResEau, FlagsTypesEffets.ResistancesEau);
		this.champs.put(this.ui.lblStatsResAir, FlagsTypesEffets.ResistancesAir);
		this.champs.put(this.ui.lblStatsPResNeutre, FlagsTypesEffets.PourcentagesResistancesNeutre);
		this.champs.put(this.ui.lblStatsPResTerre, FlagsTypesEffets.PourcentagesResistancesTerre);
		this.champs.put(this.ui.lblStatsPResFeu, FlagsTypesEffets.PourcentagesResistancesFeu);
		this.champs.put(this.ui.lblStatsPResEau, FlagsTypesEffets.PourcentagesResistancesEau);
		this.champs.put(this.ui.lblStatsPResAir, FlagsTypesEffets.PourcentagesResistancesAir);
	}
	
	/*
	 * Méthodes de génération du composant
	 */

	// Nothing
	
	/*
	 * Méthodes d'affichage des données du composant
	 */

	/**
	 * Affiche les effets {@code effets} dans le composant.
	 * 
	 * @param effets - Les effets à afficher.
	 */
	public void afficherDonnees(Effets effets)
	{
		for(Entry<QLabel, FlagsTypesEffets> entry : this.champs.entrySet())
		{
			int valeur = effets.getInt(entry.getValue());
			QLabel txt = entry.getKey();
			if(valeur != 0)
			{
				txt.setText(String.valueOf(valeur));
			}
			else
			{
				txt.setText("");
			}
		}
	}

	/**
	 * Vide le composant des données affichées.
	 */
	public void vider()
	{
		for(Entry<QLabel, FlagsTypesEffets> entry : this.champs.entrySet())
		{
			entry.getKey().setText("");
		}
	}
	
	/*
	 * Accesseurs
	 */
	
	/**
	 * Définit nombre d'objets de la ligne.
	 * 
	 * @param groupe - Le nombre d'objets de la ligne.
	 * @category Accesseur
	 */
	@QtPropertyWriter(name="test")
	 public final void setNombreObjets(int nombreObjets)
	 {
		 this.nombreObjets = nombreObjets;
		 this.ui.lblNbObjets.setText(nombreObjets + " objet(s)");
	 }
	 
	/**
	 * Renvoie {@code nombreObjets}.
	 * 
	 * @return Le nombre d'objets de la ligne.
	 * @category Accesseur
	 */
	@QtPropertyReader(name="test")
	 public final int getNombreObjets()
	 {
		 return this.nombreObjets;
	 }
}