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

package org.JDofusCalc.dofus.sauvegardes;

import java.util.HashMap;

import org.JDofusCalc.dofus.objets.Arme.FlagsTypesArmes;

/**
 *  Classe représentant une sauvegarde d'un personnage.
 * 
 * @author PAPAYA Alexandre
 * @category Dofus
 * @version 1.0
 */
public class SauvegardePersonnage
{
	/*
	 * Constantes
	 */
	
	/**
	 * Personnage masculin.
	 */
	 public final static char MASCULIN = 'm';
	/**
	 * Personnage féminin.
	 */
	 public final static char FEMININ = 'f';
	
	/**
	 * Personnage neutre.
	 */
	 public final static int NEUTRE = 0;
	/**
	 * Personnage bontais.
	 */
	 public final static int BONTAIS = 1;
	 /**
	  * Personnage brakmârien.
	  */
	 public final static int BRAKMARIEN = 2;
	 /**
	  * Personnage mercenaire.
	  */
	 public final static int MERCENAIRE = 3;
		 
	/**
	 * Personnage sans spécialisation.
	 */
	 public final static int NO_SPECIALISATION = 0;
	/**
	 * Personnage espion.
	 */
	 public final static int ESPION = 1;
	 /**
	  * Personnage guerrier.
	  */
	 public final static int GUERRIER = 2;
	 /**
	  * Personnage pretre.
	  */
	 public final static int PRETRE = 3;
	 
	/*
	 * Variables d'instances
	 */
	
	/**
	 * Id de la sauvegarde.
	 */
	private int id;

	/**
	 * Nom de la sauvegarde.
	 */
	private String nom;

	/**
	 * Nom du personnage.
	 */
	private String nomPerso;

	/**
	 * Niveau du personnage.
	 */
	private int niveau = 1;

	/**
	 * Classe du personnage.
	 */
	private int classe = 1;

	/**
	 * Sexe du personnage.
	 */
	private char sexe = MASCULIN;

	/**
	 * Niveaux des maîtrises du personnage.
	 */
	private HashMap<FlagsTypesArmes, Integer> maitrises;

	/**
	 * Niveaux des sorts hors maîtrises du personnage.
	 */
	private HashMap<String, Integer> sorts;

	/**
	 * Alignement du personnage.
	 */
	private int alignement;

	/**
	 * Niveau de l'alignement du personnage.
	 */
	private int niveauAlignement;

	/**
	 * Spécialisation de l'alignement du personnage.
	 */
	private int specialisationAlignement;

	/**
	 * Grade pvp du personnage.
	 */
	private int grade;

	/**
	 * Vitalité du personnage.
	 */
	private int vitalite;
	/**
	 * Sagesse du personnage.
	 */
	private int sagesse;
	/**
	 * Force du personnage.
	 */
	private int force;
	/**
	 * Intelligence du personnage.
	 */
	private int intelligence;
	/**
	 * Chance du personnage.
	 */
	private int chance;
	/**
	 * Agilité du personnage.
	 */
	private int agilite;

	/*
	 * Constructeurs / Destructeur
	 */

	/**
	 * Construit une nouvelle sauvegarde d'un personnage.
	 * 
	 * @param nomSauvegarde - Nom de sauvegarde du personnage.
	 * @category Constructeur
	 */
	public SauvegardePersonnage(String nomSauvegarde)
	{
		this.nom = nomSauvegarde;
		this.sorts = new HashMap<String, Integer>();

		this.maitrises = new HashMap<FlagsTypesArmes, Integer>();
		this.setMaitrise(FlagsTypesArmes.Arc, 0);
		this.setMaitrise(FlagsTypesArmes.Baguette, 0);
		this.setMaitrise(FlagsTypesArmes.Baton, 0);
		this.setMaitrise(FlagsTypesArmes.Dague, 0);
		this.setMaitrise(FlagsTypesArmes.Epee, 0);
		this.setMaitrise(FlagsTypesArmes.Hache, 0);
		this.setMaitrise(FlagsTypesArmes.Marteau, 0);
		this.setMaitrise(FlagsTypesArmes.Pelle, 0);
	}
	
	/*
	 * Accesseurs
	 */

	/**
	 * Renvoie {@code agilite}.
	 * 
	 * @return {@code agilite}.
	 * @category Accesseur
	 */
	public final int getAgilite()
	{
		return agilite;
	}

	/**
	 * Renvoie {@code alignement}.
	 * 
	 * @return {@code alignement}.
	 * @category Accesseur
	 */
	public final int getAlignement()
	{
		return alignement;
	}

	/**
	 * Renvoie {@code chance}.
	 * 
	 * @return {@code chance}.
	 * @category Accesseur
	 */
	public final int getChance()
	{
		return chance;
	}

	/**
	 * Renvoie {@code classe}.
	 * 
	 * @return {@code classe}.
	 * @category Accesseur
	 */
	public final int getClasse()
	{
		return classe;
	}

	/**
	 * Renvoie {@code force}.
	 * 
	 * @return {@code force}.
	 * @category Accesseur
	 */
	public final int getForce()
	{
		return force;
	}

	/**
	 * Renvoie {@code grade}.
	 * 
	 * @return {@code grade}.
	 * @category Accesseur
	 */
	public final int getGrade()
	{
		return grade;
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
	 * Renvoie {@code intelligence}.
	 * 
	 * @return {@code intelligence}.
	 * @category Accesseur
	 */
	public final int getIntelligence()
	{
		return intelligence;
	}

	/**
	 * Renvoie le niveau de la maîtrise {@code clef}.
	 * 
	 * @return Le niveau de la maîtrise.
	 * @category Accesseur
	 */
	public final int getMaitrise(FlagsTypesArmes clef)
	{
		return this.maitrises.get(clef);
	}

	/**
	 * Renvoie {@code niveau}.
	 * 
	 * @return {@code niveau}.
	 * @category Accesseur
	 */
	public final int getNiveau()
	{
		return niveau;
	}

	/**
	 * Renvoie {@code niveauAlignement}.
	 * 
	 * @return {@code niveauAlignement}.
	 * @category Accesseur
	 */
	public final int getNiveauAlignement()
	{
		return niveauAlignement;
	}

	/**
	 * @return
	 */
	public HashMap<String, Integer> getNiveauxSorts()
	{
		return this.sorts;
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
	 * Renvoie {@code nomPerso}.
	 * 
	 * @return {@code nomPerso}.
	 * @category Accesseur
	 */
	public final String getNomPerso()
	{
		return nomPerso;
	}

	/**
	 * Renvoie {@code sagesse}.
	 * 
	 * @return {@code sagesse}.
	 * @category Accesseur
	 */
	public final int getSagesse()
	{
		return sagesse;
	}

	/**
	 * Renvoie {@code sexe}.
	 * 
	 * @return {@code sexe}.
	 * @category Accesseur
	 */
	public final char getSexe()
	{
		return sexe;
	}

	/**
	 * Renvoie le niveau du sort {@code idSort}.
	 * 
	 * @param nomSort - Nom du sort.
	 * @return Le niveau du sort.
	 * @category Accesseur
	 */
	public final int getSort(String nomSort)
	{
		Integer niveau = this.sorts.get(nomSort);
		if(niveau != null)
			return niveau.intValue();
		else
			return 0;
	}

	/**
	 * Renvoie {@code specialisationAlignement}.
	 * 
	 * @return {@code specialisationAlignement}.
	 * @category Accesseur
	 */
	public final int getSpecialisationAlignement()
	{
		return specialisationAlignement;
	}

	/**
	 * Renvoie {@code vitalite}.
	 * 
	 * @return {@code vitalite}.
	 * @category Accesseur
	 */
	public final int getVitalite()
	{
		return vitalite;
	}

	/**
	 * Définit {@code agilite}.
	 * 
	 * @param agilite - L'agilité du personnage.
	 * @category Accesseur
	 */
	public final void setAgilite(int agilite)
	{
		this.agilite = agilite;
	}

	/**
	 * Définit {@code alignement}.
	 * 
	 * @param alignement - L'alignement du personnage.
	 * @category Accesseur
	 */
	public final void setAlignement(int alignement)
	{
		this.alignement = alignement;
	}

	/**
	 * Définit {@code chance}.
	 * 
	 * @param chance - La chance du personnage.
	 * @category Accesseur
	 */
	public final void setChance(int chance)
	{
		this.chance = chance;
	}

	/**
	 * Définit {@code classe}.
	 * 
	 * @param classe - La classe du personnage.
	 * @category Accesseur
	 */
	public final void setClasse(int classe)
	{
		this.classe = classe;
	}

	/**
	 * Définit {@code force}.
	 * 
	 * @param force - La force du personnage.
	 * @category Accesseur
	 */
	public final void setForce(int force)
	{
		this.force = force;
	}

	/**
	 * Définit {@code grade}.
	 * 
	 * @param grade - Le grade du personnage.
	 * @category Accesseur
	 */
	public final void setGrade(int grade)
	{
		this.grade = grade;
	}

	/**
	 * Définit {@code id}.
	 * 
	 * @param id - L'id du personnage.
	 * @category Accesseur
	 */
	public final void setId(int id)
	{
		this.id = id;
	}

	/**
	 * Définit {@code intelligence}.
	 * 
	 * @param intelligence - L'inteliigence du personnage.
	 * @category Accesseur
	 */
	public final void setIntelligence(int intelligence)
	{
		this.intelligence = intelligence;
	}

	/**
	 * Définit le niveau de la maîtrise {@code clef} du personnage.
	 * 
	 * @param clef - Le type de la maîtrise.
	 * @param niveau - Le niveau de la maîtrise.
	 * @category Accesseur
	 */
	public final void setMaitrise(FlagsTypesArmes clef, int niveau)
	{
		this.maitrises.put(clef, niveau);
	}

	/**
	 * Définit {@code niveau}.
	 * 
	 * @param niveau - Le niveau du personnage.
	 * @category Accesseur
	 */
	public final void setNiveau(int niveau)
	{
		this.niveau = niveau;
	}

	/**
	 * Définit {@code niveauAlignement}.
	 * 
	 * @param niveauAlignement - Le niveau d'alignement du personnage.
	 * @category Accesseur
	 */
	public final void setNiveauAlignement(int niveauAlignement)
	{
		this.niveauAlignement = niveauAlignement;
	}

	/**
	 * Définit {@code nom}.
	 * 
	 * @param nom - Le nom de la sauvegarde du personnage.
	 * @category Accesseur
	 */
	public final void setNom(String nom)
	{
		this.nom = nom;
	}

	/**
	 * Définit {@code nomPerso}.
	 * 
	 * @param nomPerso - Le nom du personnage.
	 * @category Accesseur
	 */
	public final void setNomPerso(String nomPerso)
	{
		this.nomPerso = nomPerso;
	}

	/**
	 * Définit {@code sagesse}.
	 * 
	 * @param sagesse - La sagesse du personnage.
	 * @category Accesseur
	 */
	public final void setSagesse(int sagesse)
	{
		this.sagesse = sagesse;
	}

	/**
	 * Définit {@code sexe}.
	 * 
	 * @param sexe - Le sexe du personnage.
	 * @category Accesseur
	 */
	public final void setSexe(char sexe)
	{
		this.sexe = sexe;
	}

	/**
	 * Définit le niveau du sort {@code idSort} du personnage.
	 * 
	 * @param nomSort - Le nom du sort.
	 * @param niveau - Le niveau du sort.
	 * @category Accesseur
	 */
	public final void setSort(String nomSort, int niveau)
	{
		this.sorts.put(nomSort, niveau);
	}

	/**
	 * Définit {@code specialisationAlignement}.
	 * 
	 * @param specialisationAlignement - La spécialisation de l'alignement du personnage.
	 * @category Accesseur
	 */
	public final void setSpecialisationAlignement(int specialisationAlignement)
	{
		this.specialisationAlignement = specialisationAlignement;
	}

	/**
	 * Définit {@code vitalite}.
	 * 
	 * @param vitalite - La vitalité du personnage.
	 * @category Accesseur
	 */
	public final void setVitalite(int vitalite)
	{
		this.vitalite = vitalite;
	}
}