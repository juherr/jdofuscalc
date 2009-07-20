/**
 * Fichier : AFile.java
 * Auteur : PAPAYA Alexandre
 * 
 * Copyright Alexandre, 2009, tous droits réservés.
 */

package fr.ayapap;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;

/**
 * Classe abstraite d'opérations sur les fichiers.
 * 
 * @author PAPAYA Alexandre
 * @version 1.0
 * @category Fichier
 */
public abstract class AFile
{
	/**
	 * Supprime le dossier non vide de manière récursive.
	 * 
	 * @param dossier - Dossier à supprimer.
	 * @return <code>True</code> si l'opération s'est correctement déroulée, sinon <code>False</code>.
	 */
	public final static boolean supprimerDossier(File dossier)
	{
		boolean resultat = true;

		if(dossier.exists())
		{
			File[] fichiers = dossier.listFiles();
			for(int i = 0; i < fichiers.length; i++)
			{
				if(fichiers[i].isDirectory())
				{
					resultat &= supprimerDossier(fichiers[i]);
				}
				else
				{
					resultat &= fichiers[i].delete();
				}
			}
		}

		resultat &= dossier.delete();

		return resultat;
	}

	/**
	 * <p>Copie le fichier <code>source</code> vers le répertoire
	 * <code>destination</code>.</p>
	 * <p>Cette méthode ecrassera le fichier portant le même nom que la chaine
	 * <code>nomFichier</code> dans le répertoire <code>destination</code> s'il
	 * existe.</p>
	 * 
	 * @param source - Fichier source à copier.
	 * @param destination - Chemin du répertoire où effectuer l'opération.
	 * @param nomFichier - Nom de la copie du fichier <code>source</code>.
	 * @return <code>True</code> si l'opération s'est correctement déroulée, sinon <code>False</code>.
	 */
	public final static boolean copierFichier(File source, String destination, String nomFichier)
	{
		FileChannel input = null; // canal d'entrée
		FileChannel output = null; // canal de sortie
		try
		{
			File dossierDestination = new File(destination);

			// Si la destination n'est pas un répertoire
			if(!dossierDestination.isDirectory())
			{
				throw new IOException("La destination doit être un répertoire");
			}
			// Si la source n'est pas un fichier
			if(!source.isFile())
			{
				throw new IOException("La source (" + source.getName() + ") doit être un fichier.");
			}
			// Si la source n'existe pas
			if(!source.exists())
			{
				throw new IOException("Le fichier " + source.getPath() + " n'existe pas");
			}
			// Si le nom de la copie est null
			if(nomFichier == null)
			{
				throw new NullPointerException("Le nom de la copie est null");
			}
			// Si le nom de la copie est vide
			if(nomFichier.equals(""))
			{
				throw new IOException("Le nom de la copie est vide");
			}

			// Mise en forme du chemin de destination
			if(!destination.endsWith(File.separator))
			{
				destination += File.separator;
			}

			File fichierDestination = new File(destination + nomFichier);

			// Initialisation
			input = new FileInputStream(source).getChannel();
			output = new FileOutputStream(fichierDestination).getChannel();

			// Copie depuis le in vers le out
			input.transferTo(0, input.size(), output);

			return true;
		}
		catch(IOException e)
		{
			e.printStackTrace();

			return false;
		}
		finally
		{
			// Fermeture des connexions
			if(input != null)
			{
				try
				{
					input.close();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}
			if(output != null)
			{
				try
				{
					output.close();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * <p>Copie le fichier <code>source</code> vers le répertoire
	 * <code>destination</code>.</p>
	 * <p>Cette méthode ecrassera le fichier portant le même nom que le fichier
	 * <code>source</code> dans le répertoire <code>destination</code> s'il
	 * existe.</p>
	 * 
	 * @param source - Fichier source à copier.
	 * @param destination - Chemin du répertoire où effectuer l'opération.
	 * @return <code>True</code> si l'opération s'est correctement déroulée, sinon <code>False</code>.
	 */
	public final static boolean copierFichier(File source, String destination)
	{
		return copierFichier(source, destination, source.getName());
	}
	
	public final static boolean copierDossier(File source, String destination)
	{
		ArrayList<String> listeCheminsDossiers = AFile.getArbreDossiers(source, "");
		for(String cheminDossier : listeCheminsDossiers)
		{
			File dossier = new File(destination + File.separator + source.getName() + cheminDossier);
			dossier.mkdirs();
		}
		
		ArrayList<String> listeCheminsFichiers = AFile.getListe(source, "");
		for(String cheminFichier : listeCheminsFichiers)
		{
			File fichier = new File(source + cheminFichier);
			AFile.copierFichier(fichier, new File(destination + File.separator + source.getName() + cheminFichier).getParent());
		}
		
		return true;
	}
	
	private static ArrayList<String> getListe(File dossier, String parent)
	{
		ArrayList<String> liste = new ArrayList<String>();
		
		String[] nomsFichiers = dossier.list();
		for(String nomFichier : nomsFichiers)
		{
			File fichier = new File(dossier.getPath() + File.separator + nomFichier);
			if(fichier.isDirectory())
				liste.addAll(AFile.getListe(fichier, parent + File.separator + nomFichier));
			else
				liste.add(parent + File.separator + nomFichier);
		}
		
		return liste;
	}
	
	private static ArrayList<String> getArbreDossiers(File dossier, String parent)
	{
		ArrayList<String> liste = new ArrayList<String>();
		
		String[] nomsFichiers = dossier.list();
		for(String nomFichier : nomsFichiers)
		{
			File fichier = new File(dossier.getPath() + File.separator + nomFichier);
			if(fichier.isDirectory())
			{
				liste.add(parent + File.separator + nomFichier);
				liste.addAll(AFile.getArbreDossiers(fichier, parent + File.separator + nomFichier));
			}
		}
		
		return liste;
	}

	/**
	 * <p>Deplace le fichier <code>source</code> vers le répertoire
	 * <code>destination</code>.</p>
	 * <p>Cette méthode ecrassera le fichier portant le même nom que le fichier
	 * <code>source</code> dans le répertoire <code>destination</code> s'il
	 * existe.</p>
	 * 
	 * @param source - Fichier source à copier.
	 * @param destination - Chemin du répertoire où effectuer l'opération.
	 * @return <code>True</code> si l'opération s'est correctement déroulée, sinon <code>False</code>.
	 */
	public final static boolean deplacerFichier(File source, String destination)
	{
		try
		{
			// Si la source n'est pas un fichier
			if(!source.isFile())
			{
				throw new IOException("La source doit être un fichier");
			}
			// Si la source n'existe pas
			if(!source.exists())
			{
				throw new IOException("Le fichier " + source.getPath() + " n'existe pas");
			}

			// Mise en forme du chemin de destination
			if(!destination.endsWith(File.separator) && (destination.length() > 0))
			{
				destination += File.separator;
			}

			File fichierDestination = new File(destination + source.getName());

			// Si le fichier existe déjà dans le répertoire destination
			if(fichierDestination.exists())
			{
				fichierDestination.delete();
			}

			// On deplace avec renameTo
			boolean deplacement = source.renameTo(fichierDestination);

			// Si renameTo a echoué
			if(!deplacement)
			{
				// On essaye de copier
				deplacement &= copierFichier(source, destination);

				// Si la copie a reussie, on supprime la source
				if(deplacement)
				{
					if(source.delete())
					{
						deplacement = true;
					}
					else
					{
						throw new IOException("Impossible de suppimer la source");
					}
				}
			}

			return deplacement;
		}
		catch(IOException e)
		{
			e.printStackTrace();

			return false;
		}
	}

	/**
	 * <p>Ajoute à la liste <code>liste</code> les fichiers du répertoire
	 * <code>dossier</code> et de tous ses sous-répertoires de manière
	 * recursive.</p>
	 * 
	 * @param liste - <code>ArrayList</code> contenant la liste des fichiers.
	 * @param dossier -  Répertoire à parcourir.
	 * @return La liste des fichiers dans une <code>ArrayList</code>.
	 */
	private final static ArrayList<File> getListeFichiers(ArrayList<File> liste, File dossier)
	{
		if(dossier.isDirectory() && dossier.exists())
		{
			// Génération de la liste des éléments du dossier (dossers et
			// fichiers)
			File[] fichiers = dossier.listFiles();
			for(int i = 0; i < fichiers.length; i++)
			{
				File fichier = fichiers[i];
				// Si l'élément du dossier est un fichier
				if(fichier.isFile())
				{
					liste.add(fichier);
				}
				// Si l'élément du dossier est un dossier
				else
				{
					getListeFichiers(liste, fichier);
				}
			}

			return liste;
		}
		else
		{
			return null;
		}
	}

	/**
	 * <p>Liste les fichiers du répertoire <code>dossier</code> et de tous ses
	 * sous-répertoires.</p>
	 * 
	 * @param dossier - Répertoire à parcourir.
	 * @return La liste des fichiers dans une <code>ArrayList</code>.
	 */
	public final static ArrayList<File> getListeFichiers(File dossier)
	{
		return getListeFichiers(new ArrayList<File>(), dossier);
	}
}