/**
 * Fichier : ASQL.java
 * Auteur : PAPAYA Alexandre
 * 
 * Copyright Alexandre, 2009, tous droits réservés.
 */

package fr.ayapap;

/**
 * Classe abstraite d'opérations sur les chaines de caractères.
 * 
 * @author PAPAYA Alexandre
 * @version 1.0
 * @category String
 */
public abstract class AString
{
	/**
	 * Renvoie le pluriel du mot passé en argument.
	 * 
	 * @param mot - Mot au singulier.
	 * @return Pluriel du mot.
	 */
	public final static String getPluriel(String chaine)
	{
		// Dernier caractère du mot
		char dernierCaractere = chaine.charAt((chaine.length() - 1));

		// Si le dernier caractère du mot n'est pas déjà un 's'
		if(dernierCaractere != 's')
		{
			// On ajoute un 'x' au mot s'il se termine par un 'u', sinon un 's'
			if(dernierCaractere == 'u')
			{
				return chaine + "x";
			}
			else
			{
				return chaine + "s";
			}
		}
		else
		{
			return chaine;
		}
	}

	/**
	 * <p>
	 * Transforme le premier caractère de <i>chaine</i> en majuscule.
	 * </p>
	 * <p>
	 * Une chaine <code>null</code> entrée returne <code>null</code>.
	 * </p>
	 * 
	 * <pre>
	 * AString.capitaliser(null)  = null
	 * AString.capitaliser(&quot;&quot;)    = &quot;&quot;
	 * AString.capitaliser(&quot;cat&quot;) = &quot;Cat&quot;
	 * AString.capitaliser(&quot;cAt&quot;) = &quot;CAt&quot;
	 * </pre>
	 * 
	 * @param chaine - La chaine à modifier.
	 * @return Une chaine capitalisée.
	 */
	public final static String capitaliser(String chaine)
	{
		int strLen;

		if((chaine == null) || ((strLen = chaine.length()) == 0))
		{
			return chaine;
		}

		return new StringBuffer(strLen).append(Character.toTitleCase(chaine.charAt(0))).append(chaine.substring(1)).toString();
	}
}