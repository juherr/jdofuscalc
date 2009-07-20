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
 * les caractéristiques, ect. Ce logiciel est programmé en java et utilise des
 * bibliothèques dont les licences sont en accord avec celle de ce logiciel.
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

package org.JDofusCalc.dofus.sauvegardes;

import java.util.HashMap;

import org.JDofusCalc.dofus.objets.Dofus.FlagsTypesDofus;
import org.JDofusCalc.dofus.objets.Equipement.FlagsTypesEquipements;

/**
 * Classe représentant un groupe d'objets.
 * 
 * @author PAPAYA Alexandre
 * @category Dofus
 * @version 1.0
 */
public class GroupeObjets
{
	/*
	 * Variables d'instances
	 */
	
	/**
	 * Id du groupe.
	 */
	private int id;

	/**
	 * Nom du groupe;
	 */
	private String nom;

	/**
	 * Dofus du groupe.
	 */
	private HashMap<FlagsTypesDofus, SauvegardeDofus> dofus;

	/**
	 * Equipements du groupe.
	 */
	private HashMap<FlagsTypesEquipements, SauvegardeEquipement> equipements;

	/**
	 * Arme du groupe.
	 */
	private SauvegardeArme arme;

	/**
	 * Animal du groupe.
	 */
	private SauvegardeAnimal animal;

	/*
	 * Constructeurs / Destructeur
	 */

	/**
	 * Construit un nouveau groupe.
	 * 
	 * @category Constructeur
	 */
	public GroupeObjets()
	{
		this.equipements = new HashMap<FlagsTypesEquipements, SauvegardeEquipement>();
		this.dofus = new HashMap<FlagsTypesDofus, SauvegardeDofus>();
	}

	/*
	 * Accesseurs
	 */
	
	/**
	 * Renvoie l'animal du groupe d'objets.
	 * 
	 * @category Accesseur
	 */
	public final SauvegardeAnimal getAnimal()
	{
		return this.animal;
	}

	/**
	 * Renvoie {@code arme}.
	 * 
	 * @return L'arme du groupe d'objets.
	 * @category Accesseur
	 */
	public final SauvegardeArme getArme()
	{
		return this.arme;
	}

	/**
	 * Renvoie le Dofus {@code typeDofus} du groupe d'objets.
	 * 
	 * @return Le Dofus {@code typeDofus} du groupe.
	 * @category Accesseur
	 */
	public final SauvegardeDofus getDofus(FlagsTypesDofus typeDofus)
	{
		return this.dofus.get(typeDofus);
	}

	/**
	 * Renvoie l'équipement {@code typeEquipement} du groupe d'objets.
	 * 
	 * @return L'équipement {@code typeEquipement} du groupe.
	 * @category Accesseur
	 */
	public final SauvegardeEquipement getEquipement(FlagsTypesEquipements typeEquipement)
	{
		return this.equipements.get(typeEquipement);
	}

	/**
	 * Renvoie {@code id}.
	 * 
	 * @return L'id du groupe.
	 * @category Accesseur
	 */
	public final int getId()
	{
		return this.id;
	}

	/**
	 * Renvoie la liste des Dofus du groupe d'objets.
	 * 
	 * @return La liste des Dofus du groupe.
	 * @category Accesseur
	 */
	public final HashMap<FlagsTypesDofus, SauvegardeDofus> getListeDofus()
	{
		return this.dofus;
	}

	/**
	 * Renvoie la liste des équipements du groupe d'objets.
	 * 
	 * @return La liste des équipements du groupe.
	 * @category Accesseur
	 */
	public final HashMap<FlagsTypesEquipements, SauvegardeEquipement> getListeEquipements()
	{
		return this.equipements;
	}

	/**
	 * Renvoie {@code nom}.
	 * 
	 * @return Le nom du groupe.
	 * @category Accesseur
	 */
	public final String getNom()
	{
		return this.nom;
	}

	/**
	 * Définit l'animal du groupe d'objets.
	 * 
	 * @param animal - Objet sauvegarde de l'animal.
	 * @category Accesseur
	 */
	public final void setAnimal(SauvegardeAnimal animal)
	{
		this.animal =  animal;
	}

	/**
	 * Définit l'arme du groupe d'objets.
	 * 
	 * @param arme - Objet sauvegarde de l'arme.
	 * @category Accesseur
	 */
	public final void setArme(SauvegardeArme arme)
	{
		this.arme = arme;
	}

	/**
	 * Définit le Dofus {@code typeDofus} du groupe d'objets.
	 * 
	 * @param typeDofus - Type du Dofus.
	 * @param dofus - Objet sauvegarde du dofus.
	 * @category Accesseur
	 */
	public final void setDofus(FlagsTypesDofus typeDofus, SauvegardeDofus dofus)
	{
		this.dofus.put(typeDofus, dofus);
	}

	/**
	 * Définit l'équipement {@code typeEquipement} du groupe d'objets.
	 * 
	 * @param typeEquipement - Type de l'équipement.
	 * @param equipement - Objet sauvegarde de l'équipement.
	 * @category Accesseur
	 */
	public final void setEquipement(FlagsTypesEquipements typeEquipement, SauvegardeEquipement equipement)
	{
		this.equipements.put(typeEquipement, equipement);
	}

	/**
	 * Définit {@code id}.
	 * 
	 * @param id - Id du groupe.
	 * @category Accesseur
	 */
	public final void setId(int id)
	{
		this.id = id;
	}

	/**
	 * Définit toute une liste de Dofus du groupe d'objets.
	 * 
	 * @param dofus - La liste des Dofus.
	 * @category Accesseur
	 */
	public final void setListeDofus(HashMap<FlagsTypesDofus, SauvegardeDofus> dofus)
	{
		this.dofus = dofus;
	}

	/**
	 * Définit toute une liste d'équipements du groupe d'objets.
	 * 
	 * @param dofus - La liste d'équipements.
	 * @category Accesseur
	 */
	public final void setListeEquipements(HashMap<FlagsTypesEquipements, SauvegardeEquipement> equipements)
	{
		this.equipements = equipements;
	}

	/**
	 * Définit {@code nom}.
	 * 
	 * @param nom - Le nom du groupe d'objets.
	 * @category Accesseur
	 */
	public final void setNom(String nom)
	{
		this.nom = nom;
	}
}