/**
 * Fichier : ASQL.java
 * Auteur : PAPAYA Alexandre
 * 
 * Copyright Alexandre, 2009, tous droits réservés.
 */

package fr.ayapap;

import java.sql.ResultSet;
import java.util.HashMap;

/**
 * Conteneur de {@link ResultSet} généré par la classe {@link ASQL}.
 * 
 * @author PAPAYA Alexandre
 * @version 1.0
 * @category SQL
 */
public class ASQLRequete
{
	/*
	 * Enums
	 */

	/**
	 * Types des {@link ResultSet} contenus dans la classe.
	 */
	private enum Type
	{
		Resulats, Clefs;
	}

	/*
	 * Variables d'instances
	 */

	/**
	 * HashMap contenant tous les {@link ResultSet}.
	 */
	private HashMap<Type, ResultSet> resultsets;

	/*
	 * Constructeurs / Destructeur
	 */

	public ASQLRequete(ResultSet resultats, ResultSet clefs)
	{
		this.resultsets = new HashMap<Type, ResultSet>();
		this.resultsets.put(Type.Resulats, resultats);
		this.resultsets.put(Type.Clefs, clefs);
	}

	public ASQLRequete(ResultSet resultats)
	{
		this(resultats, null);
	}

	public ASQLRequete()
	{
		this(null, null);
	}

	/*
	 * Méthodes
	 */

	// Vide
	
	/*
	 * Accesseurs
	 */

	/**
	 * @param clefs
	 * @category Accesseur
	 */
	public void setClefs(ResultSet clefs)
	{
		this.resultsets.put(Type.Clefs, clefs);
	}

	/**
	 * @param resultats
	 * @category Accesseur
	 */
	public void setResultats(ResultSet resultats)
	{
		this.resultsets.put(Type.Resulats, resultats);
	}

	/**
	 * @return
	 * @category Accesseur
	 */
	public ResultSet getClefs()
	{
		return this.resultsets.get(Type.Clefs);
	}

	/**
	 * @return
	 * @category Accesseur
	 */
	public ResultSet getResultats()
	{
		return this.resultsets.get(Type.Resulats);
	}
}
