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

package org.JDofusCalc.lanceur;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import fr.ayapap.AFile;
import fr.ayapap.ASQL;
import fr.ayapap.AUtil;

/**
 * Lance l'application après avoir installé les mises à jour précédement
 * téléchargées.
 * 
 * @author PAPAYA Alexandre
 * @category Main
 * @version 1.0
 */
public class Lanceur
{
	/**
	 * Méthode Main.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
			new Lanceur();
		}
		catch(Exception e)
		{
			e.printStackTrace();

			JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Constructeur.
	 * 
	 * @throws Exception
	 *             Exception levée après un problème lors de la mise à jour ou
	 *             après le lancement du fichier jar.
	 */
	public Lanceur() throws Exception
	{
		File dossierUpdateur = new File("updateur");
		File dossierFichier = new File(dossierUpdateur.getPath() + File.separator + "fichiers");
		File dossierScripts = new File(dossierUpdateur.getPath() + File.separator + "scripts");

		// Vérifie si une nouvelle version est téléchargée
		if(dossierUpdateur.exists())
		{
			Thread.sleep(2000);

			// / Verifie si le fichier properties est bien present
			File fichierProperties = new File(dossierUpdateur.getPath() + File.separator + "jdofuscalc.properties");
			if(!fichierProperties.exists())
			{
				AFile.supprimerDossier(dossierUpdateur);
				this.lancerApplication();
			}

			boolean temoin = true;

			/* Boucle de placement des fichiers téléchargé */
			ArrayList<File> listeFichiersADeplacer = AFile.getListeFichiers(dossierFichier);
			for(int i = 0; i < listeFichiersADeplacer.size(); i++)
			{
				File fichier = listeFichiersADeplacer.get(i);

				/* Boucle de génération des chemins des fichiers à deplacer */
				String regex = File.separator;
				if(regex.equals("\\"))
				{
					regex = "\\\\";
				}
				String[] dossiers = fichier.getPath().split(regex);
				String cheminFichier = "";
				for(int y = 2; y < dossiers.length; y++)
				{
					cheminFichier += (y == 2) ? (dossiers[y]) : (File.separator + dossiers[y]);
				}

				// Deplacement des fichiers
				File fichierDestination = new File(cheminFichier);
				String chemin = "";
				if(fichierDestination.getParent() != null)
				{
					chemin = fichierDestination.getParent();
					File dossierDestination = new File(fichierDestination.getParent());
					dossierDestination.mkdirs();
				}
				System.out.println(chemin);
				temoin &= AFile.deplacerFichier(fichier, chemin);
			}

			// Si le dossier des scripts existe
			if(dossierScripts.exists())
			{
				// Connexion à la base de données des sauvegardes
				ASQL bdd = new ASQL("org.h2.Driver", "h2:file:donnees/sauvegardes", "sauvegardes", "JDOFUSCALC", "jdc");

				/* Boucle d'execution des scripts */
				ArrayList<File> listeScripts = AFile.getListeFichiers(dossierScripts);
				for(int i = 0; i < listeScripts.size(); i++)
				{
					File script = listeScripts.get(i);

					// Si le script est un scrip sql
					if(script.getName().endsWith(".sql"))
					{
						// Execution du fichier
						bdd.requete("RUNSCRIPT FROM '" + script.getPath() + "';");
					}
					else
					{
						System.err.println("Fichier de script non valide");
						temoin = false;
					}
				}
				
				bdd.fermeture();
			}

			// Si la mise à jour n'a pas été correctement effectuée
			if(!temoin)
			{
				JOptionPane.showMessageDialog(null, "Erreurs lors de l'installation de la mise à jour.\nContactez un developpeur.", "Erreur", JOptionPane.ERROR_MESSAGE);
				throw new Exception("L'installation des la mise à jour a échouée");
			}
			else
			{
				// Deplace le fichier properties
				AFile.deplacerFichier(fichierProperties, "");

				AFile.supprimerDossier(dossierUpdateur);
			}
			
			Thread.sleep(2000);
		}

		this.lancerApplication();
	}

	/**
	 * Lance l'application.
	 * 
	 * @throws Exception
	 */
	private void lancerApplication() throws Exception
	{
		// Lancement du core
		AUtil.lancerJar(new File("core.jar"));

		// Arrêt du lanceur
		System.exit(0);
	}
}