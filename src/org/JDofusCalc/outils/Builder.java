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
package org.JDofusCalc.outils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;
import java.util.zip.ZipEntry;

import org.apache.commons.compress.archivers.jar.JarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream;

import fr.ayapap.AFile;
import fr.ayapap.ASQL;

/**
 * Builder.
 *
 * @author PAPAYA Alexandre
 * @category Outils
 * @version 1.0
 */
public class Builder
{
	private final static String PREVIOUS_VERSION = "0.6.1000";
	private final static String VERSION = "0.6.2000";
	private final static String NOM_APP = "JDofusCalc";
	private final static int TAILLE_MAX_BUFFER = 1024;
	//private final static String CHEMIN_PROJET = "C:\\Documents and Settings\\sacha\\My Documents\\Java\\Projets\\JDofusCalc\\";
	private final static String CHEMIN_PROJET = "F:\\Mes documents\\Java\\Mes projets\\JDofusCalc\\";

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		new Builder();
	}

	/**
	 * Construit un nouveau Builder.
	 * 
	 * @category Constructeur
	 */
	public Builder()
	{
		long startTimer = System.currentTimeMillis();
		
		File dossierVersion = new File("outils" + File.separator + "distributions" + File.separator + VERSION);
		AFile.supprimerDossier(dossierVersion);
		
		System.out.println("Génération des fichiers jar.");
		
		// Nettoyage des dossiers
		AFile.supprimerDossier(new File("outils" + File.separator + "jars" + File.separator + "core" + File.separator + "org"));
		AFile.supprimerDossier(new File("outils" + File.separator + "jars" + File.separator + "core" + File.separator + "fr"));
		new File("outils" + File.separator + "jars" + File.separator + "core" + File.separator + "core.jar").delete();
		AFile.supprimerDossier(new File("outils" + File.separator + "jars" + File.separator + "lanceur" + File.separator + "org"));
		AFile.supprimerDossier(new File("outils" + File.separator + "jars" + File.separator + "lanceur" + File.separator + "fr"));
		new File("outils" + File.separator + "jars" + File.separator + "lanceur" + File.separator + "JDofusCalc.jar").delete();

		// Core
		AFile.copierDossier(new File("bin" + File.separator + "fr"), "outils" + File.separator + "jars" + File.separator + "core");
		AFile.copierDossier(new File("bin" + File.separator + "org"), "outils" + File.separator + "jars" + File.separator + "core");
		AFile.supprimerDossier(new File("outils" + File.separator + "jars" + File.separator + "core" + File.separator + "org" + File.separator + "JDofusCalc"+ File.separator + "lanceur"));
		AFile.supprimerDossier(new File("outils" + File.separator + "jars" + File.separator + "core" + File.separator + "org" + File.separator + "JDofusCalc"+ File.separator + "outils"));
		
		try
		{
			Manifest manifest = new Manifest();
			manifest.getMainAttributes().putValue("Manifest-Version", "1.0");
			manifest.getMainAttributes().putValue("Main-Class", "org.JDofusCalc.Main");
			manifest.getMainAttributes().putValue("Class-Path", "bibliotheques/qtjambi.jar bibliotheques/qtjambi-plateforme.jar bibliotheques/jdom.jar bibliotheques/h2.jar bibliotheques/log4j.jar");
			
			FileOutputStream fos = new FileOutputStream(new File("outils" + File.separator + "jars" + File.separator + "core" + File.separator + "core.jar"));
			JarOutputStream jos = new JarOutputStream(fos, manifest);
			
			try
			{
				byte data[] = new byte[TAILLE_MAX_BUFFER];
    			ArrayList<String> nomsfichiers = this.getListe(new File("outils" + File.separator + "jars" + File.separator + "core" + File.separator + "org"), "org");
    			nomsfichiers.addAll(this.getListe(new File("outils" + File.separator + "jars" + File.separator + "core" + File.separator + "fr"), "fr"));
    			for(String nomfichier : nomsfichiers)
    			{
    				nomfichier = nomfichier.replace("\\", "/");
    				//System.out.println(nomfichier);
    				File fichierAZiper = new File("outils" + File.separator + "jars" + File.separator + "core" + File.separator + nomfichier);
    				BufferedInputStream input = new BufferedInputStream(new FileInputStream(fichierAZiper), TAILLE_MAX_BUFFER);
    				if(nomfichier.charAt(0) == File.separatorChar)
    					nomfichier = nomfichier.substring(1, nomfichier.length());
    				JarArchiveEntry entry = new JarArchiveEntry(new ZipArchiveEntry(fichierAZiper, nomfichier));
    				jos.putNextEntry(entry);
    				int count;
    				while((count = input.read(data, 0, TAILLE_MAX_BUFFER)) > 0)
    				{
    					jos.write(data, 0, count);
    				}
    				jos.closeEntry();
    			}
			}
			finally
			{
				try
				{
					jos.close();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
				try
				{
					fos.close();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		System.out.println("\tcore.jar terminé.");
		
		// Lanceur
		AFile.copierDossier(new File("bin" + File.separator + "fr"), "outils" + File.separator + "jars" + File.separator + "lanceur");
		new File("outils" + File.separator + "jars" + File.separator + "lanceur" + File.separator + "org" + File.separator + "JDofusCalc"+ File.separator + "lanceur").mkdirs();
		AFile.copierFichier(new File("bin" + File.separator + "org" + File.separator + "JDofusCalc" + File.separator + "lanceur" + File.separator + "Lanceur.class"), "outils" + File.separator + "jars" + File.separator + "lanceur" + File.separator + "org" + File.separator + "JDofusCalc"+ File.separator + "lanceur");
		AFile.copierFichier(new File("LICENCE"), "outils" + File.separator + "jars" + File.separator + "lanceur" + File.separator + "org" + File.separator + "JDofusCalc");
		String[] fichiersJar = new String[] { "h2.jar", "log4j.jar" };
		for(String string : fichiersJar)
		{
			try
			{
				JarInputStream jarInput = new JarInputStream(new BufferedInputStream(new FileInputStream(new File("bibliotheques" + File.separator + string)), TAILLE_MAX_BUFFER));
				JarEntry entry = null;
				while((entry = jarInput.getNextJarEntry()) != null)
				{
					// Mise en forme du chemin du fichier en cours pour
					// le rendre compatible avec l'environnement de
					// l'utilisateur
					String cheminEntry = entry.getName().replace("/", File.separator);

					//System.out.println(cheminEntry);
					if(cheminEntry.endsWith("MANIFEST.MF") || new File(cheminEntry).getParent() == null)
						continue;
					
					
					File fichier = new File("outils" + File.separator + "jars" + File.separator + "lanceur" + File.separator + entry.getName());;
					if(cheminEntry.endsWith(File.separator))
					{
						fichier.mkdirs();
						continue;
					}
					
					File dossier = new File(fichier.getParent());
					dossier.mkdirs();
					
					// Ecriture du fichier
					FileOutputStream output = new FileOutputStream(fichier);
					BufferedOutputStream buffOutput = new BufferedOutputStream(output, TAILLE_MAX_BUFFER);
					byte[] buffer = new byte[1024];
					int byteCourant;
					while((byteCourant = jarInput.read(buffer, 0, TAILLE_MAX_BUFFER)) != -1)
					{
						buffOutput.write(buffer, 0, byteCourant);
					}
					buffOutput.flush();
				}
			}
			catch(FileNotFoundException e1)
			{
				e1.printStackTrace();
			}
			catch(IOException e1)
			{
				e1.printStackTrace();
			}
		}
		
		try
		{
			Manifest manifest = new Manifest(new FileInputStream(new File("outils" + File.separator + "jars" + File.separator + "lanceur" + File.separator + "META-INF" + File.separator + "MANIFEST.MF")));
						
			FileOutputStream fos = new FileOutputStream(new File("outils" + File.separator + "jars" + File.separator + "lanceur" + File.separator + "JDofusCalc.jar"));
			JarOutputStream jos = new JarOutputStream(fos, manifest);
			
			try
			{
				byte data[] = new byte[TAILLE_MAX_BUFFER];
				ArrayList<String> nomsfichiers = this.getListe(new File("outils" + File.separator + "jars" + File.separator + "lanceur" + File.separator + "org"), "org");
				nomsfichiers.addAll(this.getListe(new File("outils" + File.separator + "jars" + File.separator + "lanceur" + File.separator + "fr"), "fr"));
    			for(String nomfichier : nomsfichiers)
    			{
    				nomfichier = nomfichier.replace("\\", "/");
    				//System.out.println(nomfichier);
    				File fichierAZiper = new File("outils" + File.separator + "jars" + File.separator + "lanceur" + File.separator + nomfichier);
    				BufferedInputStream input = new BufferedInputStream(new FileInputStream(fichierAZiper), TAILLE_MAX_BUFFER);
    				if(nomfichier.charAt(0) == File.separatorChar)
    					nomfichier = nomfichier.substring(1, nomfichier.length());
    				JarArchiveEntry entry = new JarArchiveEntry(new ZipArchiveEntry(fichierAZiper, nomfichier));
    				jos.putNextEntry(entry);
    				int count;
    				while((count = input.read(data, 0, TAILLE_MAX_BUFFER)) > 0)
    				{
    					jos.write(data, 0, count);
    				}
    				jos.closeEntry();
    			}
			}
			finally
			{
				try
				{
					jos.close();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
				try
				{
					fos.close();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		System.out.println("\tJDofusCalc.jar terminé.");
		
		//System.exit(0);
		
		System.out.println("Création de l'arbre des dossiers.");
		
		File dossierWindows32 = new File(dossierVersion.getPath() + File.separator + "windows32");
		File dossierWindows64 = new File(dossierVersion.getPath() + File.separator + "windows64");
		File dossierMac = new File(dossierVersion.getPath() + File.separator + "mac");
		File dossierLinux32 = new File(dossierVersion.getPath() + File.separator + "linux32");
		File dossierLinux64 = new File(dossierVersion.getPath() + File.separator + "linux64");
		File[] dossiersPlateformes = new File[] {dossierWindows32, dossierWindows64, dossierMac, dossierLinux32, dossierLinux64};
		dossierVersion.mkdirs();
		for(File dossier : dossiersPlateformes)
		{
			File dossierBibliotheques = new File(dossier.getPath() + File.separator + NOM_APP + File.separator + "bibliotheques");
			dossierBibliotheques.mkdirs();
			File dossierDonnees = new File(dossier.getPath() + File.separator + NOM_APP + File.separator + "donnees");
			dossierDonnees.mkdirs();
		}
		
		/*
		File dossierPatch = new File(dossierVersion.getPath() + File.separator + "patch");
		dossierPatch.mkdirs();
		File dossierPatchFichiers = new File(dossierPatch.getPath() + File.separator + "fichiers");
		dossierPatchFichiers.mkdirs();
		File dossierPatchScripts = new File(dossierPatch.getPath() + File.separator + "scripts");
		dossierPatchScripts.mkdirs();*/
		
		//*
		System.out.println("Copie des fichiers.");
		
		// Racine
		File fichierChangements = new File("CHANGEMENTS.txt");
		File fichierRemerciements = new File("REMERCIEMENTS.txt");
		File fichierLicence = new File("LICENCE");
		File fichierProperties = new File("jdofuscalc.properties");
		File fichierLog4j = new File("log4j.xml");
		File fichierLanceur = new File("outils" + File.separator + "jars" + File.separator + "lanceur" + File.separator + "JDofusCalc.jar");
		File fichierCore = new File("outils" + File.separator + "jars" + File.separator + "core" + File.separator + "core.jar");
		File[] fichiersRacine = new File[] { fichierChangements, fichierCore, fichierLanceur, fichierLicence, fichierLog4j, fichierProperties, fichierRemerciements};
		// Bibliothèque
		File bibliothequeQt = new File("bibliotheques" + File.separator + "qtjambi.jar");
		File bibliothequeH2 = new File("bibliotheques" + File.separator + "h2.jar");
		File bibliothequeJdom = new File("bibliotheques" + File.separator + "jdom.jar");
		File bibliothequeLog4j = new File("bibliotheques" + File.separator + "log4j.jar");
		File[] fichiersBibliotheque = new File[] { bibliothequeH2, bibliothequeJdom, bibliothequeLog4j, bibliothequeQt };
		// Données
		File donneesDofusdatabaseData = new File("donnees" + File.separator + "dofusdatabase.data.db");
		//File donneesDofusdatabaseIndex = new File("donnees" + File.separator + "dofusdatabase.index.db");
		new File(dossierVersion.getPath() + File.separator + "donnees").mkdirs();
		AFile.copierFichier(new File("donnees" + File.separator + "sauvegardes.data.db"), dossierVersion.getPath() + File.separator + "donnees");
		File donneesSauvegardesData = new File(dossierVersion.getPath() + File.separator + "donnees" + File.separator + "sauvegardes.data.db");
		ASQL bdd = new ASQL("org.h2.Driver", "h2:file:" + donneesSauvegardesData.getParent() + File.separator + "sauvegardes", "sauvegardes", "JDOFUSCALC", "jdc");
		bdd.requete("TRUNCATE TABLE ARMES;" +
				"ALTER TABLE ARMES ALTER COLUMN ID RESTART WITH 1;" +
				"TRUNCATE TABLE DOFUS;" +
				"ALTER TABLE DOFUS ALTER COLUMN ID RESTART WITH 1;" +
				"TRUNCATE TABLE DEGATS;" +
				"ALTER TABLE DEGATS ALTER COLUMN ID RESTART WITH 1;" +
				"TRUNCATE TABLE EFFETS;" +
				"ALTER TABLE EFFETS ALTER COLUMN ID RESTART WITH 1;" +
				"TRUNCATE TABLE PERSONNAGES ;" +
				"ALTER TABLE PERSONNAGES ALTER COLUMN ID RESTART WITH 1;" +
				"TRUNCATE TABLE GROUPES_OBJETS;" +
				"ALTER TABLE GROUPES_OBJETS ALTER COLUMN ID RESTART WITH 1;" +
				"TRUNCATE TABLE EQUIPEMENTS;" +
				"ALTER TABLE EQUIPEMENTS ALTER COLUMN ID RESTART WITH 1;" +
				"TRUNCATE TABLE MONTURES;" +
				"ALTER TABLE MONTURES ALTER COLUMN ID RESTART WITH 1;" +
				"TRUNCATE TABLE NIVEAUX_SORTS;");
		bdd.fermeture();
		File[] fichiersDonnees = new File[] { donneesDofusdatabaseData, donneesSauvegardesData };

		// Copie
		for(File dossier : dossiersPlateformes)
		{
			for(File fichierRacine : fichiersRacine)
			{
				AFile.copierFichier(fichierRacine, dossier.getPath() + File.separator + NOM_APP);
			}
			
			for(File fichierBibliotheque : fichiersBibliotheque)
			{
				AFile.copierFichier(fichierBibliotheque, dossier.getPath() + File.separator + NOM_APP + File.separator + "bibliotheques");
			}
			
			for(File fichierDonnees : fichiersDonnees)
			{
				//System.out.println(fichierDonnees.getPath());
				AFile.copierFichier(fichierDonnees, dossier.getPath() + File.separator + NOM_APP + File.separator + "donnees");
			}
		}
		
		// Copie des bibliotheques Qt
		AFile.copierFichier(new File("F:\\Mes documents\\Java\\Outils\\Bibliothèques\\qt\\qtjambi-win32-msvc2005-4.5.0_01.jar"), dossierWindows32.getPath() + File.separator + NOM_APP + File.separator + "bibliotheques", "qtjambi-plateforme.jar");
		AFile.copierFichier(new File("F:\\Mes documents\\Java\\Outils\\Bibliothèques\\qt\\autres plateformes\\qtjambi-win64-msvc2005x64-4.5.0_01.jar"), dossierWindows64.getPath() + File.separator + NOM_APP + File.separator + "bibliotheques", "qtjambi-plateforme.jar");
		AFile.copierFichier(new File("F:\\Mes documents\\Java\\Outils\\Bibliothèques\\qt\\autres plateformes\\qtjambi-linux32-gcc-4.5.0_01.jar"), dossierLinux32.getPath() + File.separator + NOM_APP + File.separator + "bibliotheques", "qtjambi-plateforme.jar");
		AFile.copierFichier(new File("F:\\Mes documents\\Java\\Outils\\Bibliothèques\\qt\\autres plateformes\\qtjambi-linux64-gcc-4.5.0_01.jar"), dossierLinux64.getPath() + File.separator + NOM_APP + File.separator + "bibliotheques", "qtjambi-plateforme.jar");
		AFile.copierFichier(new File("F:\\Mes documents\\Java\\Outils\\Bibliothèques\\qt\\autres plateformes\\qtjambi-macosx-gcc-4.5.0_01.jar"), dossierMac.getPath() + File.separator + NOM_APP + File.separator + "bibliotheques", "qtjambi-plateforme.jar");
		
		// Autres
		AFile.copierFichier(new File("outils" + File.separator + "distributions" + File.separator + "JDofusCalc-32.exe"), dossierWindows32.getPath() + File.separator + NOM_APP, "JDofusCalc.exe");
		AFile.copierFichier(new File("outils" + File.separator + "distributions" + File.separator + "JDofusCalc-32.exe"), dossierWindows64.getPath() + File.separator + NOM_APP, "JDofusCalc.exe");
		
		/*
		// Patch
		HashMap<File, String> fichiersPatch = new HashMap<File, String>();
		fichiersPatch.put(fichierLanceur, "");
		fichiersPatch.put(fichierCore, "");
		fichiersPatch.put(fichierChangements, "");
		//fichiersPatch.put(fichierRemerciements, "");
		fichiersPatch.put(donneesDofusdatabaseData, "donnees");
		for(Entry<File, String> entry : fichiersPatch.entrySet())
		{
			new File(dossierPatchFichiers + File.separator + entry.getValue()).mkdirs();
			AFile.copierFichier(entry.getKey(), dossierPatchFichiers + File.separator + entry.getValue());
		}
		HashMap<File, String> scriptsPatch = new HashMap<File, String>();
		scriptsPatch.put(new File("sauvegardes.sql"), "");
		for(Entry<File, String> entry : scriptsPatch.entrySet())
		{
			new File(dossierPatchFichiers + File.separator + entry.getValue()).mkdirs();
			AFile.copierFichier(entry.getKey(), dossierPatchScripts + File.separator + entry.getValue());
		}*/
		
		//*/
		
		//System.exit(0);
		
		//*
		System.out.println("Compression des dossiers.");
		
		HashMap<String, File> dossiersToGz = new HashMap<String, File>();
		dossiersToGz.put("linux32", dossierLinux32);
		dossiersToGz.put("linux64", dossierLinux64);
		dossiersToGz.put("macosx", dossierMac);
		for(Entry<String, File> dossierToGz : dossiersToGz.entrySet())
		{
			try
			{
				File fichierTar = new File(dossierVersion.getPath() + File.separator + "JDofusCalc-" + VERSION + "-" + dossierToGz.getKey() + ".tar");
				
				TarArchiveOutputStream tarOutput = new TarArchiveOutputStream(new BufferedOutputStream(new FileOutputStream(fichierTar)));
				byte data[] = new byte[TAILLE_MAX_BUFFER];
				ArrayList<String> nomsfichiers = this.getListe(dossierToGz.getValue(), "");
				for(String nomfichier : nomsfichiers)
				{
					//System.out.println(nomfichier);
					File fichierATArer = new File(dossierToGz.getValue().getPath() + File.separator + nomfichier);
					BufferedInputStream input = new BufferedInputStream(new FileInputStream(fichierATArer), TAILLE_MAX_BUFFER);
					TarArchiveEntry entry = new TarArchiveEntry(fichierATArer);
					entry.setName(nomfichier);
					tarOutput.putArchiveEntry(entry);
					int count;
					while((count = input.read(data, 0, TAILLE_MAX_BUFFER)) != -1)
					{
						tarOutput.write(data, 0, count);
					}
					tarOutput.closeArchiveEntry();
					input.close();
				}
				tarOutput.close();
				
				GzipCompressorOutputStream compressor = new GzipCompressorOutputStream(new BufferedOutputStream(new FileOutputStream(new File(dossierVersion.getPath() + File.separator + fichierTar.getName() + ".gz"))));
				BufferedInputStream tarInput = new BufferedInputStream(new FileInputStream(fichierTar));
				int count;
				while((count = tarInput.read(data, 0, TAILLE_MAX_BUFFER)) != -1)
				{

					compressor.write(data, 0, count);
				}
				compressor.close();
				tarInput.close();
				
				fichierTar.delete();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		
		HashMap<String, File> dossiersToZip = new HashMap<String, File>();
		dossiersToZip.put("JDofusCalc-" + VERSION + "-win32.zip", dossierWindows32);
		dossiersToZip.put("JDofusCalc-" + VERSION + "-win64.zip", dossierWindows64);
		//dossiersToZip.put("patch-" + PREVIOUS_VERSION + "_" + VERSION + "-all.zip", dossierPatch);
		for(Entry<String, File> dossierToZip : dossiersToZip.entrySet())
		{
			try
			{
				ZipArchiveOutputStream zipOutput = new ZipArchiveOutputStream(new BufferedOutputStream(new FileOutputStream(new File(dossierVersion.getPath() + File.separator + dossierToZip.getKey()))));
				byte data[] = new byte[TAILLE_MAX_BUFFER];
				ArrayList<String> nomsfichiers = this.getListe(dossierToZip.getValue(), "");
				for(String nomfichier : nomsfichiers)
				{
					//System.out.println(nomfichier);
					File fichierAZiper = new File(dossierToZip.getValue().getPath() + File.separator + nomfichier);
					BufferedInputStream input = new BufferedInputStream(new FileInputStream(fichierAZiper), TAILLE_MAX_BUFFER);
					if(nomfichier.charAt(0) == File.separatorChar)
						nomfichier = nomfichier.substring(1, nomfichier.length());
					ZipArchiveEntry entry = new ZipArchiveEntry(fichierAZiper, nomfichier);
					zipOutput.putArchiveEntry(entry);
					int count;
					while((count = input.read(data, 0, TAILLE_MAX_BUFFER)) != -1)
					{
						zipOutput.write(data, 0, count);
					}
					zipOutput.closeArchiveEntry();
					input.close();
				}
				zipOutput.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		
		System.out.println("Suppression des dossiers temporaires.");
		
		AFile.supprimerDossier(dossierWindows32);
		AFile.supprimerDossier(dossierWindows64);
		AFile.supprimerDossier(dossierMac);
		AFile.supprimerDossier(dossierLinux32);
		AFile.supprimerDossier(dossierLinux64);
		AFile.supprimerDossier(new File(dossierVersion.getPath() + File.separator + "donnees"));
		
		//*/
		
		long endTimer = System.currentTimeMillis();
		
		System.out.println("Builder terminé en " + ((endTimer - startTimer) / 60000) +" minutes.");
	}
	
	private ArrayList<String> getListe(File dossier, String parent)
	{
		ArrayList<String> liste = new ArrayList<String>();
		
		String[] nomsFichiers = dossier.list();
		for(String nomFichier : nomsFichiers)
		{
			File fichier = new File(dossier.getPath() + File.separator + nomFichier);
			if(fichier.isDirectory())
				liste.addAll(this.getListe(fichier, parent + File.separator + nomFichier));
			else
				liste.add(parent + File.separator + nomFichier);
		}
		
		return liste;
	}
}