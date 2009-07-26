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

import java.io.BufferedInputStream;
import java.io.IOException;

import org.JDofusCalc.Main;
import org.JDofusCalc.vues.Qt.designer.UIAPropos;

import com.trolltech.qt.core.Qt;
import com.trolltech.qt.gui.QWidget;

/**
 * Fenêtre "À propos".
 * 
 * @author PAPAYA Alexandre
 * @category Fenêtre
 * @version 1.0
 */
public class QWindowAPropos extends QWidget
{
	/*
	 * Variables d'instances
	 */

	/* Composants */

	/**
	 * L'interface graphique.
	 */
	private UIAPropos ui;

	/* Autres */

	/**
	 * Texte informatif.
	 */
	private String texteInfo = "Le concepteur de ce programme est totalement indépendant de l'équipe et des concepteurs de Dofus. De ce fait, Ankama Games ne saurait en aucune manière être tenue responsable des informations, inexactitudes, effets secondaire et/ou dommages causés par l'installation ou l'utilisation de ce logiciel.\n\n" + "Malgré tout le soin apporté à la réalisation de ce programme, il se peut que des erreurs subsistent, et que des effets involontaires se manifestent. Dans un tel cas, l'auteur ne saurait être tenu pour responsable de ces effets quels qu'ils soient.";

	/**
	 * Chaine contenant la licence chargée à partir du fichier jar.
	 */
	private String licence = "";

	/**
	 * Variable de témoin d'affichage de la licence.
	 */
	private boolean licenceAffichee = false;

	/*
	 * Constructeurs / Destructeur
	 */

	/**
	 * Construit une nouvelle fenêtre.
	 * 
	 * @param parent - Fenêtre parente.
	 * @category Constructeur
	 */
	public QWindowAPropos(QWidget parent)
	{
		// Execution du constructeur de la classe mère
		super(parent, Qt.WindowType.Window);

		// Initialisation de l'interface graphique
		this.ui = new UIAPropos();
		this.ui.setupUi(this);
		this.ui.lblVersionLogiciel.setText("Version : " + Main.getVersion());

		// Récuperation du texte de la licence
		try
		{
			int bytes = 0;
			byte[] buffer = new byte[1024];
			BufferedInputStream sortie = new BufferedInputStream(this.getClass().getResourceAsStream("/org/JDofusCalc/LICENCE"));
			while((bytes = sortie.read(buffer)) != -1)
			{
				this.licence += new String(buffer, 0, bytes, "utf8");
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

		/* Connexions signal->slot */
		this.ui.btnOK.clicked.connect(this, "slotFermeture()");
		this.ui.btnLicence.clicked.connect(this, "slotLicence()");
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

	/**
	 * Affiche ou cache la licence.
	 * 
	 * @category Slot
	 */
	public void slotLicence()
	{
		if(this.licenceAffichee)
		{
			this.ui.txtInformations.setText(this.texteInfo);
			this.ui.btnLicence.setText("Afficher la licence");
			this.licenceAffichee = false;
		}
		else
		{
			this.ui.txtInformations.setText(this.licence);
			this.ui.btnLicence.setText("Cacher la licence");
			this.licenceAffichee = true;
		}
	}
}