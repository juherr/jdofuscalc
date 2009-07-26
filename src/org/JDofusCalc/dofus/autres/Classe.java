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

package org.JDofusCalc.dofus.autres;

import java.util.HashMap;

import org.JDofusCalc.dofus.objets.Arme.FlagsTypesArmes;

/**
 * Classe représentant une classe de personnage du jeu.
 * 
 * @author PAPAYA Alexandre
 * @category Dofus
 * @version 1.0
 */
public class Classe
{
	/*
	 * Variables d'instances
	 */
	
	/**
	 * Id de la classe.
	 */
	private int id;

	/**
	 * Nom de la classe.
	 */
	private String nom;

	/**
	 * Description de la classe.
	 */
	private String description;

	/**
	 * Vie de base de la classe.
	 */
	private int baseVie;
	/**
	 * Points d'actions de base de la classe.
	 */
	private int basePA;
	/**
	 * Points de mouvements de base de la classe.
	 */
	private int basePM;
	/**
	 * Portée de base de la classe.
	 */
	private int basePO;
	/**
	 * Initiative de base de la classe.
	 */
	private int baseIni;
	/**
	 * Prospection de base de la classe.
	 */
	private int basePP;

	/**
	 * Type de l'arme principale de la classe.
	 */
	private FlagsTypesArmes armePrincipale;
	/**
	 * Type de l'arme secondaire de la classe.
	 */
	private FlagsTypesArmes armeSecondaire;

	/**
	 * Avatar de la classe.
	 */
	private String avatar;

	/**
	 * Paliers de caractéristiques de la classe.
	 */
	private HashMap<String, Paliers> paliers;

	/*
	 * Constructeurs / Destructeur
	 */

	/**
	 * Construit une nouvelle classe.
	 * 
	 * @param id - Id de la classe.
	 * @param nomArme - Nom de la classe.
	 * @category Constructeur
	 */
	public Classe(int id, String nom)
	{
		this.id = id;
		this.nom = nom;
		this.paliers = new HashMap<String, Paliers>();
	}
	
	/*
	 * Accesseurs
	 */

	/**
	 * Renvoie {@code armePricipale}.
	 * 
	 * @return L'arme principale de la classe.
	 * @category Accesseur
	 */
	public final FlagsTypesArmes getArmePrincipale()
	{
		return armePrincipale;
	}

	/**
	 * Renvoie {@code armeSecondaire}.
	 * 
	 * @return L'arme secondaire de la classe.
	 * @category Accesseur
	 */
	public final FlagsTypesArmes getArmeSecondaire()
	{
		return armeSecondaire;
	}

	/**
	 * Renvoie {@code avatar}.
	 * 
	 * @return {@code avatar}.
	 * @category Accesseur
	 */
	public final String getAvatar()
	{
		return avatar;
	}

	/**
	 * Renvoie {@code baseIni}.
	 * 
	 * @return {@code baseIni}.
	 * @category Accesseur
	 */
	public final int getBaseIni()
	{
		return baseIni;
	}

	/**
	 * Renvoie {@code basePA}.
	 * 
	 * @return {@code basePA}.
	 * @category Accesseur
	 */
	public final int getBasePA()
	{
		return basePA;
	}

	/**
	 * Renvoie {@code basePM}.
	 * 
	 * @return {@code basePM}.
	 * @category Accesseur
	 */
	public final int getBasePM()
	{
		return basePM;
	}

	/**
	 * Renvoie {@code basePO}.
	 * 
	 * @return {@code basePO}.
	 * @category Accesseur
	 */
	public final int getBasePO()
	{
		return basePO;
	}

	/**
	 * Renvoie {@code basePP}.
	 * 
	 * @return {@code basePP}.
	 * @category Accesseur
	 */
	public final int getBasePP()
	{
		return basePP;
	}

	/**
	 * Renvoie {@code baseVie}.
	 * 
	 * @return {@code baseVie}.
	 * @category Accesseur
	 */
	public final int getBaseVie()
	{
		return baseVie;
	}

	/**
	 * Renvoie {@code description}.
	 * 
	 * @return {@code description}.
	 * @category Accesseur
	 */
	public final String getDescription()
	{
		return description;
	}

	/**
	 * Renvoie {@code id}.
	 * 
	 * @return {@code id}.
	 * @category Accesseur
	 */
	public final int getId()
	{
		return id;
	}

	/**
	 * Renvoie {@code nom}.
	 * 
	 * @return {@code nom}.
	 * @category Accesseur
	 */
	public final String getNom()
	{
		return nom;
	}

	/**
	 * Renvoie les paliers de la caractéristique {@code clef} de la classe.
	 * 
	 * @param clef - Nom de la caractéristique.
	 * @return Les paliers de la caractéristique.
	 * @category Accesseur
	 */
	public final Paliers getPaliers(String clef)
	{
		return this.paliers.get(clef);
	}

	/**
	 * Définit {@code armePricipale}.
	 * 
	 * @param armePrincipale - L'arme principale de la classe.
	 * @category Accesseur
	 */
	public final void setArmePrincipale(FlagsTypesArmes armePrincipale)
	{
		this.armePrincipale = armePrincipale;
	}

	/**
	 * Définit {@code armeSecondaire}.
	 * 
	 * @param armeSecondaire - L'arme secondiare de la classe.
	 * @category Accesseur
	 */
	public final void setArmeSecondaire(FlagsTypesArmes armeSecondaire)
	{
		this.armeSecondaire = armeSecondaire;
	}

	/**
	 * Définit {@code avatar}.
	 * 
	 * @param avatar - L'avatar de la classe.
	 * @category Accesseur
	 */
	public final void setAvatar(String avatar)
	{
		this.avatar = avatar;
	}

	/**
	 * Définit {@code baseIni}.
	 * 
	 * @param baseIni - L'initiative de base de la classe.
	 * @category Accesseur
	 */
	public final void setBaseIni(int baseIni)
	{
		this.baseIni = baseIni;
	}

	/**
	 * Définit {@code basePA}.
	 * 
	 * @param basePA - Les PAs de base de la classe.
	 * @category Accesseur
	 */
	public final void setBasePA(int basePA)
	{
		this.basePA = basePA;
	}

	/**
	 * Définit {@code basePM}.
	 * 
	 * @param basePM - Les PMs de base de la classe.
	 * @category Accesseur
	 */
	public final void setBasePM(int basePM)
	{
		this.basePM = basePM;
	}

	/**
	 * Définit {@code basePO}.
	 * 
	 * @param basePO - La PO de base de la classe.
	 * @category Accesseur
	 */
	public final void setBasePO(int basePO)
	{
		this.basePO = basePO;
	}

	/**
	 * Définit {@code basePP}.
	 * 
	 * @param basePP - La PP de base de la classe.
	 * @category Accesseur
	 */
	public final void setBasePP(int basePP)
	{
		this.basePP = basePP;
	}

	/**
	 * Définit {@code baseVie}.
	 * 
	 * @param baseVie - La vie de base de la classe.
	 * @category Accesseur
	 */
	public final void setBaseVie(int baseVie)
	{
		this.baseVie = baseVie;
	}

	/**
	 * Définit {@code description}.
	 * 
	 * @param description - La description de la classe.
	 * @category Accesseur
	 */
	public final void setDescription(String description)
	{
		this.description = description;
	}

	/**
	 * Définit {@code id}.
	 * 
	 * @param id - L'id de la classe.
	 * @category Accesseur
	 */
	public final void setId(int id)
	{
		this.id = id;
	}

	/**
	 * Définit {@code nom}.
	 * 
	 * @param nom - Le nom de la classe.
	 * @category Accesseur
	 */
	public final void setNom(String nom)
	{
		this.nom = nom;
	}

	/**
	 * Définit les paliers de la caractéristique {@code clef} de la classe.
	 * 
	 * @param clef - Nom de la caractéristique.
	 * @param paliers - Le palier.
	 * @category Accesseur
	 */
	public final void setPaliers(String clef, Paliers paliers)
	{
		this.paliers.put(clef, paliers);
	}
}