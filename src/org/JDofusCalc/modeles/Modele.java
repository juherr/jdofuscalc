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

package org.JDofusCalc.modeles;

import javax.swing.event.EventListenerList;

import org.JDofusCalc.observateurs.ObservateurGroupeObjets;
import org.JDofusCalc.observateurs.ObservateurSauvegardesArmes;
import org.JDofusCalc.observateurs.ObservateurSauvegardesDofus;
import org.JDofusCalc.observateurs.ObservateurSauvegardesFamiliers;
import org.JDofusCalc.observateurs.ObservateurSauvegardesMontures;
import org.JDofusCalc.observateurs.ObservateurSauvegardesEquipements;
import org.JDofusCalc.observateurs.ObservateurSauvegardesPersonnages;
import org.JDofusCalc.observateurs.ObservateurCalculateur;
import org.JDofusCalc.observateurs.ObservateurUpdate;
import org.apache.log4j.Logger;

import fr.ayapap.ASQL;

/**
 * Modele abstrait.
 * 
 * @author PAPAYA Alexandre
 * @category Modele
 * @version 1.0
 */
public abstract class Modele
{
	/*
	 * Variables d'instances
	 */
	
	/**
	 * Logger.
	 */
	protected final static Logger logger = Logger.getLogger("org.JDofusCalc.Modele");

	/**
	 * Connexion à la base de données.
	 */
	protected ASQL bdd = null;

	/**
	 * Liste des observateurs enregistrés au modèle.
	 */
	protected EventListenerList listeObservateurs = new EventListenerList();

	/*
	 * Constructeurs / Destructeur
	 */

	/**
	 * Construit un nouveau modèle avec une connexion à une base de données SQL.
	 * 
	 * @param nomBdd - Nom de la base de données.
	 * @category Constructeur
	 */
	public Modele(String nomBdd)
	{
		// Initialisation de la connexion à la basse de données
		this.bdd = new ASQL("org.h2.Driver", "h2:file:donnees/" + nomBdd, nomBdd, "JDOFUSCALC", "jdc");
	}

	/**
	 * Construit un nouveau modèle.
	 * 
	 * @category Constructeur
	 */
	public Modele()
	{
		// Vide
	}
	
	/*
	 * Observateurs
	 */

	/**
	 * Ajoute un observateur {@link ObservateurSauvegardesEquipements} au modèle.
	 * 
	 * @param observateur - Observateur du modèle.
	 */
	public void addObservateurSauvegardesEquipements(ObservateurSauvegardesEquipements observateur)
	{
		this.listeObservateurs.add(ObservateurSauvegardesEquipements.class, observateur);
	}

	/**
	 * Supprime un observateur {@link ObservateurSauvegardesDofus} au modèle.
	 * 
	 * @param observateur - Observateur du modèle.
	 */
	public void removeObservateurSauvegardesDofus(ObservateurSauvegardesDofus observateur)
	{
		this.listeObservateurs.remove(ObservateurSauvegardesDofus.class, observateur);
	}

	/**
	 * Ajoute un observateur {@link ObservateurSauvegardesDofus} au modèle.
	 * 
	 * @param observateur - Observateur du modèle.
	 */
	public void addObservateurSauvegardesDofus(ObservateurSauvegardesDofus observateur)
	{
		this.listeObservateurs.add(ObservateurSauvegardesDofus.class, observateur);
	}

	/**
	 * Supprime un observateur {@link ObservateurSauvegardesEquipements} au modèle.
	 * 
	 * @param observateur - Observateur du modèle.
	 */
	public void removeObservateurSauvegardesEquipements(ObservateurSauvegardesEquipements observateur)
	{
		this.listeObservateurs.remove(ObservateurSauvegardesEquipements.class, observateur);
	}

	/**
	 * Ajoute un observateur {@link ObservateurSauvegardesFamiliers} au modèle.
	 * 
	 * @param observateur - Observateur du modèle.
	 */
	public void addObservateurSauvegardesFamiliers(ObservateurSauvegardesFamiliers observateur)
	{
		this.listeObservateurs.add(ObservateurSauvegardesFamiliers.class, observateur);
	}

	/**
	 * Supprime un observateur {@link ObservateurSauvegardesFamiliers} au modèle.
	 * 
	 * @param observateur - Observateur du modèle.
	 */
	public void removeObservateurSauvegardesFamiliers(ObservateurSauvegardesFamiliers observateur)
	{
		this.listeObservateurs.remove(ObservateurSauvegardesFamiliers.class, observateur);
	}

	/**
	 * Ajoute un observateur {@link ObservateurSauvegardesMontures} au modèle.
	 * 
	 * @param observateur - Observateur du modèle.
	 */
	public void addObservateurSauvegardesMontures(ObservateurSauvegardesMontures observateur)
	{
		this.listeObservateurs.add(ObservateurSauvegardesMontures.class, observateur);
	}

	/**
	 * Supprime un observateur {@link ObservateurSauvegardesMontures} au modèle.
	 * 
	 * @param observateur - Observateur du modèle.
	 */
	public void removeObservateurSauvegardesMontures(ObservateurSauvegardesMontures observateur)
	{
		this.listeObservateurs.remove(ObservateurSauvegardesMontures.class, observateur);
	}

	/**
	 * Ajoute un observateur {@link ObservateurSauvegardesArmes} au modèle.
	 * 
	 * @param observateur - Observateur du modèle.
	 */
	public void addObservateurSauvegardesArmes(ObservateurSauvegardesArmes observateur)
	{
		this.listeObservateurs.add(ObservateurSauvegardesArmes.class, observateur);
	}

	/**
	 * Supprime un observateur {@link ObservateurSauvegardesArmes} au modèle.
	 * 
	 * @param observateur - Observateur du modèle.
	 */
	public void removeObservateurSauvegardesArmes(ObservateurSauvegardesArmes observateur)
	{
		this.listeObservateurs.remove(ObservateurSauvegardesArmes.class, observateur);
	}

	/**
	 * Ajoute un observateur {@link ObservateurSauvegardesPersonnages} au modèle.
	 * 
	 * @param observateur - Observateur du modèle.
	 */
	public void addObservateurSauvegardesPersonnages(ObservateurSauvegardesPersonnages observateur)
	{
		this.listeObservateurs.add(ObservateurSauvegardesPersonnages.class, observateur);
	}

	/**
	 * Supprime un observateur {@link ObservateurSauvegardesPersonnages} au modèle.
	 * 
	 * @param observateur - Observateur du modèle.
	 */
	public void removeObservateurSauvegardesPersonnages(ObservateurSauvegardesPersonnages observateur)
	{
		this.listeObservateurs.remove(ObservateurSauvegardesPersonnages.class, observateur);
	}

	/**
	 * Ajoute un observateur {@link ObservateurGroupeObjets} au modèle.
	 * 
	 * @param observateur - Observateur du modèle.
	 */
	public void addObservateurGroupeObjets(ObservateurGroupeObjets observateur)
	{
		this.listeObservateurs.add(ObservateurGroupeObjets.class, observateur);
	}

	/**
	 * Supprime un observateur {@link ObservateurGroupeObjets} au modèle.
	 * 
	 * @param observateur - Observateur du modèle.
	 */
	public void removeObservateurGroupeObjets(ObservateurGroupeObjets observateur)
	{
		this.listeObservateurs.remove(ObservateurGroupeObjets.class, observateur);
	}

	/**
	 * Ajoute un observateur {@link ObservateurUpdate} au modèle.
	 * 
	 * @param observateur - Observateur du modèle.
	 */
	public void addObservateurUpdate(ObservateurUpdate observateur)
	{
		this.listeObservateurs.add(ObservateurUpdate.class, observateur);
	}

	/**
	 * Supprime un observateur {@link ObservateurUpdate} au modèle.
	 * 
	 * @param observateur - Observateur du modèle.
	 */
	public void removeObservateurUpdate(ObservateurUpdate observateur)
	{
		this.listeObservateurs.remove(ObservateurUpdate.class, observateur);
	}

	/**
	 * Ajoute un observateur {@link ObservateurCalculateur} au modèle.
	 * 
	 * @param observateur - Observateur du modèle.
	 */
	public void addObservateurStatistiques(ObservateurCalculateur observateur)
	{
		this.listeObservateurs.add(ObservateurCalculateur.class, observateur);
	}

	/**
	 * Supprime un observateur {@link ObservateurCalculateur} au modèle.
	 * 
	 * @param observateur - Observateur du modèle.
	 */
	public void removeObservateurStatistiques(ObservateurCalculateur observateur)
	{
		this.listeObservateurs.remove(ObservateurCalculateur.class, observateur);
	}
}