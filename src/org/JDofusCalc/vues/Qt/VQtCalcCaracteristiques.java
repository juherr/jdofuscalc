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

import org.JDofusCalc.controleurs.ControleurPrincipal;
import org.JDofusCalc.dofus.autres.Classe;
import org.JDofusCalc.dofus.sauvegardes.SauvegardePersonnage;
import org.JDofusCalc.vues.Qt.composants.QWindowCalcCaracteristiques;
import org.JDofusCalc.vues.Qt.composants.QWindowPrincipale;

/**
 * Vue de la fenêtre de calcul sur les caracteristiques.
 * 
 * @author PAPAYA Alexandre
 * @category Vue
 * @version 1.0
 */
public class VQtCalcCaracteristiques extends VueQt
{
	/*
	 * Variables d'instances
	 */
	/**
	 * Fenêtre de la vue.
	 */
	private QWindowCalcCaracteristiques fenetre;

	/**
	 * Controleur de la vue.
	 */
	private ControleurPrincipal controleur;

	/*
	 * Constructeurs / Destructeur
	 */

	/**
	 * Construit une nouvelle vue.
	 * 
	 * @param controleur - Controleur de la vue.
	 * @param parent - Fenêtre parente de la fenêtre de la vue.
	 * @param classe - Classe à utiliser pour faire les calculs.
	 * @param sauvegardePersonnage - Personnage à utiliser pour faire les calculs.
	 * @category Constructeur
	 */
	public VQtCalcCaracteristiques(ControleurPrincipal controleur, QWindowPrincipale parent, Classe classe, SauvegardePersonnage sauvegardePersonnage)
	{
		// Enregistrement du controleur
		this.controleur = controleur;

		// Enregistrement de la fenetre
		this.fenetre = new QWindowCalcCaracteristiques(parent, classe, sauvegardePersonnage);
	}

	/*
	 * Méthodes heritées
	 */

	@Override
	public void afficher()
	{
		VueQt.centrerFenetre(this.fenetre);

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
	public final QWindowCalcCaracteristiques getFenetre()
	{
		return this.fenetre;
	}

	/**
	 * Renvoie {@code controleur}.
	 * 
	 * @return Le controleur de la vue.
	 * @category Accesseur
	 */
	public final ControleurPrincipal getControleur()
	{
		return this.controleur;
	}
}