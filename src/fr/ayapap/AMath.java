/**
 * Fichier : AMath.java
 * Auteur : PAPAYA Alexandre
 * 
 * Copyright Alexandre, 2009, tous droits réservés.
 */

package fr.ayapap;

/**
 * Classe abstraite d'opérations mathématiques.
 * 
 * @author PAPAYA Alexandre
 * @version 1.0
 * @category Math
 */
public abstract class AMath
{
	/**
	 * Arrondi un nombre.
	 * 
	 * @param nombre - Nombre à arrondir.
	 * @param precision - Précision de l'arrondi.
	 * @return Le nombre arrondi.
	 */
	public final static double arrondir(double nombre, int precision)
	{
		return ((int) (nombre * Math.pow(10, precision) + 0.5)) / Math.pow(10, precision);
	}
}
