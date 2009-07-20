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

import org.JDofusCalc.vues.Qt.designer.UIDetails;

import com.trolltech.qt.core.Qt;
import com.trolltech.qt.gui.QLabel;
import com.trolltech.qt.gui.QWidget;

/**
 * Fenêtre de détails.
 * 
 * @author PAPAYA Alexandre
 * @category Fenêtre
 * @version 1.0
 */
public class QWindowDetails extends QWidget
{
	/*
	 * Variables d'instances
	 */

	/* Composants */

	/**
	 * L'interface graphique.
	 */
	public UIDetails ui;

	/*
	 * Constructeurs / Destructeur
	 */

	/**
	 * Construit une nouvelle fenêtre.
	 * 
	 * @param parent - Fenêtre parente.
	 * @param donnees - Donnéesdes détails de la simulation à afficher.
	 * @category Constructeur
	 */
	public QWindowDetails(QWidget parent, HashMap<String, String> donnees)
	{
		// Execution du constructeur de la classe mère
		super(parent, Qt.WindowType.Window);

		// Initialisation de l'interface graphique
		this.ui = new UIDetails();
		this.ui.setupUi(this);
		
		this.ui.lblType.setText(donnees.get("Type"));
		this.ui.lblNom.setText(donnees.get("Nom"));
		donnees.remove("Type");
		donnees.remove("Nom");

		HashMap<String, QLabel> listeChamps = new HashMap<String, QLabel>();
		listeChamps.put("PA", this.ui.lblPA);
		listeChamps.put("EC", this.ui.lblEC);
		listeChamps.put("CC", this.ui.lblCC);
		listeChamps.put("Moyenne Coup Critique Neutre", this.ui.lblMoyCoupCCNeutre);
		listeChamps.put("Moyenne Coup Critique Terre", this.ui.lblMoyCoupCCTerre);
		listeChamps.put("Moyenne Coup Critique Feu", this.ui.lblMoyCoupCCFeu);
		listeChamps.put("Moyenne Coup Critique Eau", this.ui.lblMoyCoupCCEau);
		listeChamps.put("Moyenne Coup Critique Air", this.ui.lblMoyCoupCCAir);
		listeChamps.put("Moyenne Coup Critique Vdv", this.ui.lblMoyCoupCCVdv);
		listeChamps.put("Moyenne Coup Critique Soins", this.ui.lblMoyCoupCCSoins);
		listeChamps.put("Moyenne Coup Neutre", this.ui.lblMoyCoupNeutre);
		listeChamps.put("Moyenne Coup NormNeutre", this.ui.lblMoyCoupNormNeutre);
		listeChamps.put("Moyenne Coup Terre", this.ui.lblMoyCoupTerre);
		listeChamps.put("Moyenne Coup NormTerre", this.ui.lblMoyCoupNormTerre);
		listeChamps.put("Moyenne Coup Feu", this.ui.lblMoyCoupFeu);
		listeChamps.put("Moyenne Coup NormFeu", this.ui.lblMoyCoupNormFeu);
		listeChamps.put("Moyenne Coup Eau", this.ui.lblMoyCoupEau);
		listeChamps.put("Moyenne Coup NormEau", this.ui.lblMoyCoupNormEau);
		listeChamps.put("Moyenne Coup Air", this.ui.lblMoyCoupAir);
		listeChamps.put("Moyenne Coup NormAir", this.ui.lblMoyCoupNormAir);
		listeChamps.put("Moyenne Coup Vdv", this.ui.lblMoyCoupVdv);
		listeChamps.put("Moyenne Coup NormVdv", this.ui.lblMoyCoupNormVdv);
		listeChamps.put("Moyenne Coup Soins", this.ui.lblMoyCoupSoins);
		listeChamps.put("Moyenne Coup NormSoins", this.ui.lblMoyCoupNormSoins);
		listeChamps.put("Minimum Tour Neutre", this.ui.lblMinTourNeutre);
		listeChamps.put("Minimum Tour Terre", this.ui.lblMinTourTerre);
		listeChamps.put("Minimum Tour Feu", this.ui.lblMinTourFeu);
		listeChamps.put("Minimum Tour Eau", this.ui.lblMinTourEau);
		listeChamps.put("Minimum Tour Air", this.ui.lblMinTourAir);
		listeChamps.put("Minimum Tour Vdv", this.ui.lblMinTourVdv);
		listeChamps.put("Minimum Tour Soins", this.ui.lblMinTourSoins);
		listeChamps.put("Maximum Tour Neutre", this.ui.lblMaxTourNeutre);
		listeChamps.put("Maximum Tour Terre", this.ui.lblMaxTourTerre);
		listeChamps.put("Maximum Tour Feu", this.ui.lblMaxTourFeu);
		listeChamps.put("Maximum Tour Eau", this.ui.lblMaxTourEau);
		listeChamps.put("Maximum Tour Air", this.ui.lblMaxTourAir);
		listeChamps.put("Maximum Tour Vdv", this.ui.lblMaxTourVdv);
		listeChamps.put("Maximum Tour Soins", this.ui.lblMaxTourSoins);
		listeChamps.put("Moyenne Tour Neutre", this.ui.lblMoyTourNeutre);
		listeChamps.put("Moyenne Tour Terre", this.ui.lblMoyTourTerre);
		listeChamps.put("Moyenne Tour Feu", this.ui.lblMoyTourFeu);
		listeChamps.put("Moyenne Tour Eau", this.ui.lblMoyTourEau);
		listeChamps.put("Moyenne Tour Air", this.ui.lblMoyTourAir);
		listeChamps.put("Moyenne Tour Vdv", this.ui.lblMoyTourVdv);
		listeChamps.put("Moyenne Tour Soins", this.ui.lblMoyTourSoins);

		for(Entry<String, String> entry : donnees.entrySet())
		{
			listeChamps.get(entry.getKey()).setText(entry.getValue());
		}

		/* Connexions signal->slot */
		this.ui.btnFermer.clicked.connect(this, "slotFermeture()");
	}

	/*
	 * Slots de la fenêtre
	 */

	/**
	 * Ferme la fenêtre.
	 * 
	 * @category Slot
	 */
	public void slotFermeture()
	{
		this.close();
	}
}