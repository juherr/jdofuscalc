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

import java.util.ArrayList;

import org.JDofusCalc.dofus.autres.Degats.FlagsTypesDegats;
import org.JDofusCalc.dofus.autres.Effets.FlagsTypesEffets;

/**
 * Classe de génération des réquêtes pour les modèles.
 *
 * @author PAPAYA Alexandre
 * @category Generateur
 * @version 1.0
 */
public class GenerateurRequete
{
	/*
	 * Constantes / Enums
	 */
	
	/*
	 * Variables d'instances
	 */
	
	/**
	 * Nom de la table principale.
	 */
	private String nomTablePrincipale;
	
	/**
	 * Alias de la table principale.
	 */
	private String aliasTablePrincipale;
	
	/**
	 * Liste des champs de la table principale.
	 */
	private ArrayList<String> champsTablePrincipale;
	
	/**
	 * Liste des champs de la table "EFFETS".
	 */
	private ArrayList<String> champsTableEffets;
	
	/**
	 * Liste des champs de la table "DEGATS".
	 */
	private ArrayList<String> champsTableDegats;
	
	/**
	 * Liste des jointures avec la table EFFETS.
	 */
	private ArrayList<String[]> jointuresEffets;
	
	/**
	 * Liste des jointures avec la table DEGATS.
	 */
	private ArrayList<String[]> jointuresDegats;
	
	/**
	 * Nom du champ de la table principale à utiliser pour ordonner les résultats.
	 */
	private String nomChampTrier;
	
	/**
	 * Sens du triage des résultats (ASC ou DESC).
	 */
	private String sensTriage;
	
	/**
	 * Clause "WHERE X=Y".
	 */
	private String whereEgal;
	
	/*
	 * Constructeurs / Destructeur
	 */
	
	/**
	 * Construit un nouveau générateur.
	 * 
	 * @category Constructeur
	 */
	public GenerateurRequete()
	{
		this.champsTableEffets = new ArrayList<String>();
		
		// Création de la liste des champs de la table EFFETS
		for(FlagsTypesEffets flag : FlagsTypesEffets.values())
		{
			String champ = flag.getChamp();
			if(champ != null)
				this.champsTableEffets.add(champ);
		}
		
		this.champsTableDegats = new ArrayList<String>();
		
		// Création de la liste des champs de la table EFFETS
		for(FlagsTypesDegats flag : FlagsTypesDegats.values())
		{
			String champ = flag.getChamp();
			if(champ != null)
				this.champsTableDegats.add(champ);
		}
	}
	
	/**
	 * Construit un nouveau générateur.
	 * 
	 * @param nomTablePrincipale - Nom de la table principale.
	 * @param aliasTablePrincipale - Alias de la table principale.
	 * @category Constructeur
	 */
	public GenerateurRequete(String nomTablePrincipale, String aliasTablePrincipale)
	{
		this();
		
		this.setNomTablePrincipale(nomTablePrincipale);
		this.setAliasTablePrincipale(aliasTablePrincipale);
	}
	
	/*
	 * Méthodes
	 */
	
	public String construireRequete()
	{
		String requete = "";
		requete+= "SELECT ";
		String listeChamps = "";
		for(int i = 0; i < this.champsTablePrincipale.size(); i++)
		{
			listeChamps+= this.aliasTablePrincipale + "." + this.champsTablePrincipale.get(i);
			
			if(i < (this.champsTablePrincipale.size() - 1))
				listeChamps+= ", ";
		}
		
		String listeJoin = "";
		if(this.jointuresEffets != null)
		{
			listeChamps+= ", ";
			for(int i = 0; i < this.jointuresEffets.size(); i++)
			{
				listeChamps+= this.jointuresEffets.get(i)[0] + ".ID AS " + this.jointuresEffets.get(i)[0] + "_ID, " + this.jointuresEffets.get(i)[0] + ".TABLE AS " + this.jointuresEffets.get(i)[0] + "_TABLE, " + this.jointuresEffets.get(i)[0] + ".CHAMP AS " + this.jointuresEffets.get(i)[0] + "_CHAMP, ";
				for(int j = 0; j < this.champsTableEffets.size(); j++)
				{
					listeChamps+= this.jointuresEffets.get(i)[0] + "." + this.champsTableEffets.get(j) + " AS " + this.jointuresEffets.get(i)[0] + "_" + this.champsTableEffets.get(j);
					
					if(i < (this.jointuresEffets.size() - 1) || j < (this.champsTableEffets.size() - 1))
						listeChamps+= ", ";
				}
				
				listeJoin+= " LEFT JOIN EFFETS AS " + this.jointuresEffets.get(i)[0] + " ON " + this.jointuresEffets.get(i)[0] + ".ID = " + this.aliasTablePrincipale + "." + this.jointuresEffets.get(i)[1];	
			}
		}
		if(this.jointuresDegats != null)
		{
			listeChamps+= ", ";
			for(int i = 0; i < this.jointuresDegats.size(); i++)
			{
				listeChamps+= this.jointuresDegats.get(i)[0] + ".ID AS " + this.jointuresDegats.get(i)[0] + "_ID, " + this.jointuresDegats.get(i)[0] + ".TABLE AS " + this.jointuresDegats.get(i)[0] + "_TABLE, " + this.jointuresDegats.get(i)[0] + ".CHAMP AS " + this.jointuresDegats.get(i)[0] + "_CHAMP, ";
				for(int j = 0; j < this.champsTableDegats.size(); j++)
				{
					listeChamps+= this.jointuresDegats.get(i)[0] + "." + this.champsTableDegats.get(j) + " AS " + this.jointuresDegats.get(i)[0] + "_" + this.champsTableDegats.get(j);
					
					if(i < (this.jointuresDegats.size() - 1) || j < (this.champsTableDegats.size() - 1))
						listeChamps+= ", ";
				}
				
				listeJoin+= " LEFT JOIN DEGATS AS " + this.jointuresDegats.get(i)[0] + " ON " + this.jointuresDegats.get(i)[0] + ".ID = " + this.aliasTablePrincipale + "." + this.jointuresDegats.get(i)[1];	
			}
		}
		requete+= listeChamps + " FROM " + this.nomTablePrincipale + " AS " + this.aliasTablePrincipale + listeJoin;
		
		if(this.whereEgal != null)
			requete+= " WHERE " + this.whereEgal;
		
		if(this.sensTriage != null && this.nomChampTrier != null)
			requete+= " ORDER BY " + this.aliasTablePrincipale + "." + this.nomChampTrier + " " + this.sensTriage;
		
		return requete;
	}
	
	/*
	 * Accesseurs
	 */

	/**
	 * Renvoie {@code nomTablePrincipale}.
	 * 
	 * @return {@code nomTablePrincipale}.
	 * @category Accesseur
	 */
	public final String getNomTablePrincipale()
	{
		return nomTablePrincipale;
	}

	/**
	 * Renvoie {@code aliasTablePrincipale}.
	 * 
	 * @return {@code aliasTablePrincipale}.
	 * @category Accesseur
	 */
	public final String getAliasTablePrincipale()
	{
		return aliasTablePrincipale;
	}

	/**
	 * Renvoie {@code champsTablePrincipale}.
	 * 
	 * @return {@code champsTablePrincipale}.
	 * @category Accesseur
	 */
	public final ArrayList<String> getChampsTablePrincipale()
	{
		return champsTablePrincipale;
	}

	/**
	 * Définit {@code nomTablePrincipale}.
	 * 
	 * @param nomTablePrincipale - Nom de la table principale.
	 * @category Accesseur
	 */
	public final void setNomTablePrincipale(String nomTablePrincipale)
	{
		this.nomTablePrincipale = nomTablePrincipale;
	}

	/**
	 * Définit {@code aliasTablePrincipale}.
	 * 
	 * @param aliasTablePrincipale - Alias de la table principale.
	 * @category Accesseur
	 */
	public final void setAliasTablePrincipale(String aliasTablePrincipale)
	{
		this.aliasTablePrincipale = aliasTablePrincipale;
	}

	/**
	 * Définit {@code champsTablePrincipale}.
	 * 
	 * @param champsTablePrincipale - Liste des champs de la table principale.
	 * @category Accesseur
	 */
	public final void setChampsTablePrincipale(ArrayList<String> champsTablePrincipale)
	{
		this.champsTablePrincipale = champsTablePrincipale;
	}

	/**
	 * Renvoie {@code champsTableEffets}.
	 * 
	 * @return {@code champsTableEffets}.
	 * @category Accesseur
	 */
	public final ArrayList<String> getChampsTableEffets()
	{
		return champsTableEffets;
	}

	/**
	 * Renvoie {@code jointuresEffets}.
	 * 
	 * @return {@code jointuresEffets}.
	 * @category Accesseur
	 */
	public final ArrayList<String[]> getJointuresEffets()
	{
		return jointuresEffets;
	}
	
	/**
	 * Renvoie {@code jointuresDegats}.
	 * 
	 * @return {@code jointuresDegats}.
	 * @category Accesseur
	 */
	public final ArrayList<String[]> getJointuresDegats()
	{
		return jointuresDegats;
	}

	/**
	 * Renvoie {@code nomChampTrier}.
	 * 
	 * @return {@code nomChampTrier}.
	 * @category Accesseur
	 */
	public final String getNomChampTrier()
	{
		return nomChampTrier;
	}

	/**
	 * Renvoie {@code sensTriage}.
	 * 
	 * @return {@code sensTriage}.
	 * @category Accesseur
	 */
	public final String getSensTriage()
	{
		return sensTriage;
	}

	/**
	 * Définit {@code jointuresEffets}.
	 * 
	 * @param jointuresEffets - Liste des joinstures avec la table EFFETS.
	 * @category Accesseur
	 */
	public final void setJointuresEffets(ArrayList<String[]> jointuresEffets)
	{
		this.jointuresEffets = jointuresEffets;
	}
	
	/**
	 * Définit {@code jointuresDegats}.
	 * 
	 * @param jointuresDegats - Liste des joinstures avec la table DEGATS.
	 * @category Accesseur
	 */
	public final void setJointuresDegats(ArrayList<String[]> jointuresDegats)
	{
		this.jointuresDegats = jointuresDegats;
	}

	/**
	 * Définit {@code nomChampTrier}.
	 * 
	 * @param nomChampTrier - Nom du champ de la table principale à utiliser pour ordonner les résultats.
	 * @category Accesseur
	 */
	public final void setNomChampTrier(String nomChampTrier)
	{
		this.nomChampTrier = nomChampTrier;
	}

	/**
	 * Définit {@code sensTriage}.
	 * 
	 * @param sensTriage - Sens du triage des résultats (ASC ou DESC).
	 * @category Accesseur
	 */
	public final void setSensTriage(String sensTriage)
	{
		this.sensTriage = sensTriage;
	}
	
	/**
	 * Définit {@code whereEgal}.
	 * 
	 * @param nomChampTablePrincipale - Nom du champ de la table principale à tester.
	 * @param valeur - Valeur à tester.
	 * @category Accesseur
	 */
	public final void setWhereEgal(String nomChampTablePrincipale, int valeur)
	{
		this.whereEgal = this.aliasTablePrincipale + "." + nomChampTablePrincipale + "=" + valeur;
	}
}