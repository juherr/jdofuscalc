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

import java.util.Map.Entry;

import org.JDofusCalc.dofus.autres.Effets;
import org.JDofusCalc.dofus.autres.Effets.FlagsTypesEffets;

import com.trolltech.qt.gui.QFont;
import com.trolltech.qt.gui.QLabel;
import com.trolltech.qt.gui.QWidget;

/**
 * Ligne panoplie d'un tableau {@link QWidgetTableauObjets}.
 * 
 * @author PAPAYA Alexandre
 * @category Composant
 * @version 1.0
 */
public class QWidgetLignePanoplie extends QWidgetLigneAbstraite
{
	/*
	 * Variables d'instances
	 */
	
	/* Autres */
	
	private String nomsPanoplies;
	
	/*
	 * Constructeurs / Destructeur
	 */

	/**
	 * Construit un nouveau composant.
	 * 
	 * @param parent - Composant parent.
	 * @category Constructeur
	 */
	public QWidgetLignePanoplie(QWidget parent)
	{
		// Execution du constructeur de la classe mère
		super(parent);
	}
	
	/*
	 * Méthodes d'affichage des données du composant
	 */

	@Override
	public void afficherDonnees(Effets effets, String erreurs)
	{
		for(Entry<QLabel, FlagsTypesEffets> entry : this.champs.entrySet())
		{
			int valeur = effets.getInt(entry.getValue());
			QLabel txt = entry.getKey();
			if(valeur != 0)
			{
				QFont font = new QFont();
				font.setBold(true);
				txt.setFont(font);

				txt.setText(String.valueOf(valeur));
			}
			else
			{
				txt.setText("");
			}
		}
	}
	
	/*
	 * Méthodes de génération du composant
	 */

	@Override
	public void genererMenu()
	{
	}
	
	/*
	 * Accesseurs
	 */
	
	/**
	 * Définit les noms des panoplies équipées.
	 * 
	 * @param nomsPanoplies - Les noms des panoplies.
	 * @category Accesseur
	 */
	public final void setNomsPanoplies(String nomsPanoplies)
	{
		this.nomsPanoplies = nomsPanoplies;
	}
	
	@Override
	public final String getNomObjet()
	{
		return nomsPanoplies;
	}
}