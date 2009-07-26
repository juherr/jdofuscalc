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

package org.JDofusCalc.dofus.objets;

import java.util.HashMap;

import org.JDofusCalc.dofus.autres.Effets;

/**
 * Classe représentant une panoplie du jeu.
 * 
 * @author PAPAYA Alexandre
 * @category Dofus
 * @version 1.0
 */
public class Panoplie
{
	/*
	 * Variables d'instances
	 */
	
	/**
	 * Id de la panoplie.
	 */
	private int id;

	/**
	 * IdDofus de la panoplie.
	 */
	private int idDofus;

	/**
	 * Nom de la panoplie.
	 */
	private String nom;

	/**
	 * Niveau maximum de la panoplie.
	 */
	private int niveau;

	/**
	 * Nombre d'objets totals de la panoplie.
	 */
	private int nbObjets;

	/**
	 * Bonus de la panoplie.
	 */
	private HashMap<Integer, Effets> bonus;

	/*
	 * Constructeurs / Destructeur
	 */

	/**
	 * Construit une nouvelle panoplie.
	 * 
	 * @param id - Id de la panoplie.
	 * @param nom - Nom de la panoplie.
	 * @category Constructeur
	 */
	public Panoplie(int id, String nom)
	{
		this.id = id;
		this.nom = nom;

		this.bonus = new HashMap<Integer, Effets>();
	}
	
	/*
	 * Accesseurs
	 */

	/**
	 * Renvoie les bonus de la panoplie avec {@code nbObjets} équipés.
	 * 
	 * @return Les bonus de la panoplie.
	 * @category Accesseur
	 */
	public final Effets getBonus(int nbObjets)
	{
		return this.bonus.get(nbObjets);
	}

	/**
	 * Renvoie {@code id}.
	 * 
	 * @return L'id de la panoplie.
	 * @category Accesseur
	 */
	public final int getId()
	{
		return this.id;
	}

	/**
	 * Renvoie {@code idDofus}.
	 * 
	 * @return L'id dofus de la panoplie.
	 * @category Accesseur
	 */
	public final int getIdDofus()
	{
		return this.idDofus;
	}

	/**
	 * Renvoie {@code nbObjets}.
	 * 
	 * @return Le nombre d'objets de la panoplie.
	 * @category Accesseur
	 */
	public final int getNbObjets()
	{
		return this.nbObjets;
	}

	/**
	 * Renvoie {@code niveau}.
	 * 
	 * @return Le niveau nécessaire pour porter tous les objets de la panoplie.
	 * @category Accesseur
	 */
	public final int getNiveau()
	{
		return this.niveau;
	}

	/**
	 * Renvoie {@code nom}.
	 * 
	 * @return Le nom de la panoplie.
	 * @category Accesseur
	 */
	public final String getNom()
	{
		return this.nom;
	}

	/**
	 * Définit les bonus de la panoplie avec {@code nbObjets} équipés.
	 * 
	 * @param conditions - Les bonus de la panoplie.
	 * @category Accesseur
	 */
	public final void setBonus(int nbObjets, Effets bonus)
	{
		this.bonus.put(nbObjets, bonus);
	}

	/**
	 * Définit {@code id}.
	 * 
	 * @param id - Id de la panoplie.
	 * @category Accesseur
	 */
	public final void setId(int id)
	{
		this.id = id;
	}

	/**
	 * Définit {@code idDofus}.
	 * 
	 * @param idDofus - Id dofus de la panoplie.
	 * @category Accesseur
	 */
	public final void setIdDofus(int idDofus)
	{
		this.idDofus = idDofus;
	}

	/**
	 * Définit {@code nbObjets}.
	 * 
	 * @param nbObjets - Le nombre d'objets de la panoplie.
	 * @category Accesseur
	 */
	public final void setNbObjets(int nbObjets)
	{
		this.nbObjets = nbObjets;
	}

	/**
	 * Définit {@code niveau}.
	 * 
	 * @param niveau - Le niveau nécessaire pour porter tous les objets de la panoplie.
	 * @category Accesseur
	 */
	public final void setNiveau(int niveau)
	{
		this.niveau = niveau;
	}

	/**
	 * Définit {@code nom}.
	 * 
	 * @param nom - Le nom de la panoplie.
	 * @category Accesseur
	 */
	public final void setNom(String nom)
	{
		this.nom = nom;
	}
}