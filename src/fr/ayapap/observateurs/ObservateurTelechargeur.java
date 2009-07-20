/**
 * Fichier : ObservateurTelechargeur.java
 * Auteur : PAPAYA Alexandre
 * 
 * Copyright Alexandre, 2009, tous droits réservés.
 */

package fr.ayapap.observateurs;

import java.util.EventListener;

import fr.ayapap.ATelechargeur;

/**
 * Observateur du téléchargement d'un fichier par la classe {@link ATelechargeur}.
 * 
 * @author PAPAYA Alexandre
 * @category Observateur
 * @version 1.0
 */
public interface ObservateurTelechargeur extends EventListener
{
	/**
	 * Méthode invoquée lors d'un changement de l'état du téléchargement.
	 * 
	 * @param etat - Nouvel état.
	 */
	public void changementEtat(int etat);

	/**
	 * Méthode invoquée lors du changement de l'avancement du téléchargement.
	 * 
	 * @param avancement - Nouvel avancement.
	 */
	public void changementAvancement(float avancement);

	/**
	 * Méthode invoquée lors du changement de la vitesse du téléchargement.
	 * 
	 * @param vitesse : Nouvelle vitesse.
	 */
	public void changementVitesse(float vitesse);
}