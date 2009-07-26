/**
 * Fichier : AUtil.java
 * Auteur : PAPAYA Alexandre
 * 
 * Copyright Alexandre, 2009, tous droits réservés.
 */

package fr.ayapap;

import java.io.File;
import java.io.IOException;

/**
 * Classe abstraite de méthodes utiles.
 * 
 * @author PAPAYA Alexandre
 * @version 1.0
 * @category Util
 */
public abstract class AUtil
{	
	/*
	 * Constantes / Enums
	 */
	
	/**
	 * Enum des systèmes d'exploitation.
	 * 
	 * @author PAPAYA Alexandre
	 * @category Enum
	 * @version 1.0
	 */
	public enum OS
	{
		/**
		 * Windows.
		 */
		Windows("Microsoft Windows", "windows"),
		/**
		 * Mas OS.
		 */
		Mac("Mas OS", "mac"),
		/**
		 * Linux.
		 */
		Linux("GNU/Linux", "linux");
		
		/*
		 * Variables d'intances
		 */
		
		/**
		 * Nom de l'os.
		 */
		private String nom;
		
		/**
		 * Abréviation de l'os.
		 */
		private String abreviation;
		
		/*
		 * Constructeurs / Destructeur
		 */
		
		/**
		 * Construit un nouvel enum.
		 * 
		 * @param nom - Nom de l'os.
		 * @param abreviation - Abréviation de l'os.
		 * @category Constructeur
		 */
		private OS(String nom, String abreviation)
		{
			this.nom = nom;
			this.abreviation = abreviation;
		}
		
		/*
		 * Accesseurs
		 */
		
		/**
		 * Renvoie le nom de l'os.
		 * 
		 * @return Le nom de l'os.
		 * @category Accesseur
		 */
		public final String getNom()
		{
			return nom;
		}

		/**
		 * Renvoie l'abréviation de l'os.
		 * 
		 * @return L'abréviation de l'os.
		 * @category Accesseur
		 */
		public final String getAbreviation()
		{
			return abreviation;
		}
	}
	
	/**
	 * Enum des architectures de processeurs.
	 * 
	 * @author PAPAYA Alexandre
	 * @category Enum
	 * @version 1.0
	 */
	public enum Architecture
	{
		/**
		 * 32-bits.
		 */
		x32("32-bits"),
		/**
		 * 64-bits.
		 */
		x64("64-bits");
		
		/*
		 * Variables d'intances
		 */
		
		/**
		 * Nom de l'architecture.
		 */
		private String nom;
		
		/*
		 * Constructeurs / Destructeur
		 */
		
		/**
		 * Construit un nouvel enum.
		 * 
		 * @param nom - Nom de l'architecture.
		 * @category Constructeur
		 */
		private Architecture(String nom)
		{
			this.nom = nom;
		}
		
		/*
		 * Accesseurs
		 */
		
		/**
		 * Renvoie le nom de l'architecture.
		 * 
		 * @return Le nom de l'architecture.
		 * @category Accesseur
		 */
		public final String getNom()
		{
			return nom;
		}
	}
	
	/*
	 * Méthodes
	 */
	
	/**
	 * Renvoie le nom du système d'exploitation.
	 * 
	 * @return Un enum {@link OS} caractérisant le système d'exploitation sous lequel la JVM est exécutée.
	 */
	public final static OS getOS()
	{
		String nomOS = System.getProperty("os.name");

		if(nomOS.startsWith("Linux") || nomOS.startsWith("LINUX"))
		{
			return OS.Linux;
		}
		else if(nomOS.startsWith("Mac"))
		{
			return OS.Mac;
		}
		else if(nomOS.startsWith("Windows"))
		{
			return OS.Windows;
		}
		else
		{
			return null;
		}
	}

	/**
	 * Renvoie l'architecture du système d'exploitation.
	 * 
	 * @return Un entier caractérisant l'architecture du système d'exploitation sous lequel la JVM est exécutée.
	 */
	public final static int getArchitecture()
	{
		return Integer.parseInt(System.getProperty("sun.arch.data.model"));
	}

	/**
	 * Lance l'archive Java {@code jar}.
	 * 
	 * @param jar - Fichier jar à executer.
	 * @return {@code True} si l'action à été correctement exétucée, sinon {@code False}.
	 * @throws Exception Exception levée lorsque l'ouverture du fichier {@code jar} est impossible.
	 * @since Java 1.6
	 */
	/*
	 * public final static boolean lancerJar(File jar) throws Exception {
	 * Desktop desktop = null; boolean executerCommande = false;
	 * if(Desktop.isDesktopSupported()) { desktop = Desktop.getDesktop();
	 * 
	 * if(desktop.isSupported(Desktop.Action.OPEN)) { try { desktop.open(jar);
	 * 
	 * return true; } catch(IllegalArgumentException e) { e.printStackTrace();
	 * 
	 * executerCommande = true; } catch(IOException e) { e.printStackTrace();
	 * 
	 * executerCommande = true; } } else { executerCommande = true; } } else {
	 * executerCommande = true; }
	 * 
	 * if(executerCommande) { try { Process process =
	 * Runtime.getRuntime().exec("java -jar " + jar.getPath()); InputStream in =
	 * process.getErrorStream(); InputStreamReader reader = new
	 * InputStreamReader(in); BufferedReader buffer = new
	 * BufferedReader(reader); String ligne = ""; String erreurs = "";
	 * while((ligne = buffer.readLine()) != null) { erreurs+= ligne; }
	 * if(!erreurs.equals("")) { throw new IOException(erreurs); } else { return
	 * true; } } catch(IOException e) { e.printStackTrace();
	 * 
	 * throw new Exception("Imposible de lancer le fichier jar '" +
	 * jar.getPath() + "'"); } }
	 * 
	 * return false; }
	 */

	/**
	 * Lance l'archive Java {@code jar}.
	 * 
	 * @param jar - Fichier jar à executer.
	 * @return {@code True} si l'action à été correctement exécutée, sinon {@code False}.
	 * @throws Exception Exception levée lorsque l'ouverture du fichier {@code jar} est impossible.
	 * @since Java 1.5
	 */
	public final static boolean lancerJar(File jar) throws Exception
	{
		try
		{
			String commande;
			if(AUtil.getOS() != OS.Mac)
				commande = "java -jar " + jar.getPath();
			else
				commande = "java -XstartOnFirstThread -jar " + jar.getPath();

			Runtime.getRuntime().exec(commande);
			
			return true;
		}
		catch(IOException e)
		{
			e.printStackTrace();

			throw new Exception("Imposible de lancer le fichier jar '" + jar.getPath() + "'");
		}
	}
}