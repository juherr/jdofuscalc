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

package org.JDofusCalc.observateurs;

import java.util.EventListener;
import java.util.HashMap;

import org.JDofusCalc.dofus.autres.Classe;
import org.JDofusCalc.dofus.autres.Effets;
import org.JDofusCalc.dofus.autres.Effets.FlagsTypesEffets;
import org.JDofusCalc.dofus.objets.Dofus.FlagsTypesDofus;
import org.JDofusCalc.dofus.objets.Equipement.FlagsTypesEquipements;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeAnimal;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeArme;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeDofus;
import org.JDofusCalc.dofus.sauvegardes.SauvegardeEquipement;
import org.JDofusCalc.dofus.sauvegardes.SauvegardePersonnage;

/**
 * Observateur des évènements du calculateur de l'application.
 * 
 * @author PAPAYA Alexandre
 * @category Observateur
 * @version 1.0
 */
public interface ObservateurCalculateur extends EventListener
{
	/**
	 * Méthode invoquée lors d'un changement d'une statistique.
	 * 
	 * @param effet - Effet modifié.
	 * @param valeur - Valeur du champ modifié.
	 */
	public void changementStatistique(FlagsTypesEffets effet, int valeur);

	/**
	 * Méthode invoquée lors d'un changement d'équipement.
	 * 
	 * @param type - Type d'équipement modifié.
	 * @param sauvegarde - Objet sauvegarde de l'équipement.
	 * @param erreurs - Chaine contenant les erreurs eventuelles d'endossage de l'équipement.
	 */
	public void changementEquipement(FlagsTypesEquipements type, SauvegardeEquipement sauvegarde, String erreurs);

	/**
	 * Méthode invoquée lors d'un changement des bonus des panoplies.
	 * 
	 * @param nomsPanoplies - Noms des panoplies équipées.
	 * @param effetsPanoplies - Effets des panoplies.
	 */
	public void changementPanoplie(String nomsPanoplies, Effets effetsPanoplies);

	/**
	 * Méthode invoquée lors d'un changement sur les dofus.
	 * 
	 * @param type - Type du Dofus modifié.
	 * @param sauvegarde - Objet sauvegarde du Dofus.
	 * @param erreurs - Chaine contenant les erreurs eventuelles d'équipement du Dofus.
	 * @param statistiquesDofus - Total des statistiques données par tous les Dofus équipés.
	 */
	public void changementDofus(FlagsTypesDofus type, SauvegardeDofus sauvegarde, String erreurs, Effets statistiquesDofus);

	/**
	 * Méthode invoquée lors d'un changement de l'arme.
	 * 
	 * @param sauvegarde - Objet sauvegarde de l'arme.
	 * @param erreurs - Chaine contenant les erreurs eventuelles d'équipement de l'arme.
	 */
	public void changementArme(SauvegardeArme sauvegarde, String erreurs);

	/**
	 * Méthode invoquée lors d'un changement de classe du personnage.
	 * 
	 * @param classe - Classe modifiée.
	 */
	public void changementClasse(Classe classe);
	
	/**
	 * Méthode invoquée lors d'un changement de sexe du personnage.
	 * 
	 * @param sexe - Sexe modifié.
	 * @param classe - Classe du personnage.
	 */
	public void changementSexe(char sexe, Classe classe);
	
	/**
	 * Méthode invoquée lors d'un changement de sauvegarde de personnage.
	 * 
	 * @param sauvegarde - Sauvegarde du personnage a chargé.
	 */
	public void changementSauvegardePersonnage(SauvegardePersonnage sauvegarde);

	/**
	 * Méthode invoquée lors d'un changement effectué sur la simulation en cours.
	 * 
	 * @param donnees - Nouvelles données de la simulation.
	 */
	public void changementSimulation(HashMap<String, String> donnees);

	/**
	 * Méthode invoquée lors d'un changement de l'animal.
	 * 
	 * @param sauvegarde - Objet sauvegarde de l'animal.
	 * @param erreurs - Chaine contenant les erreurs eventuelles d'équipement de l'animal.
	 */
	public void changementAnimal(SauvegardeAnimal sauvegarde, String erreurs);
}