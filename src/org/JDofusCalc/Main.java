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

package org.JDofusCalc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.JDofusCalc.controleurs.ControleurPrincipal;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * Classe main de l'application {@code JDofusCalc}.
 * 
 * @author PAPAYA Alexandre
 * @category Main
 * @version 1.0
 */
public class Main
{
	/*
	 * Variables
	 */
	
	/**
	 * Nom du fichier de propriétés.
	 */
	public static final String FICHIER_PROPERTIES = "jdofuscalc.properties";

	/**
	 * Version de l'application.
	 */
	private static String version;
	
	/**
	 * Logger.
	 */
	protected final static Logger logger = Logger.getLogger("org.JDofusCalc");

	/*
	 * MAIN
	 */
	
	/**
	 * Méthode main.
	 * 
	 * @param args - Arguments.
	 */
	public static void main(String[] args)
	{
		DOMConfigurator.configure("log4j.xml");
		
		try
		{
			// Création du controleur principal
			new ControleurPrincipal();
		}
		catch(Exception exception)
		{
			Main.logger.fatal(exception.getStackTrace()[0]);
			exception.printStackTrace();
		}
	}
	
	/*
	 * Méthodes
	 */

	/**
	 * <p>Renvoie le numéro de version de l'application présent dans le fichier de configuration.<br />
	 * Du type : 0.0.1000 .</p>
	 * 
	 * @return La version de l'application.
	 * @category Accesseur
	 */
	public static final String getVersion()
	{
		// Si c'est le premier appel de cette méthode
		if(Main.version == null)
		{
			try
			{
				Properties props = new Properties();
				props.load(new FileInputStream(FICHIER_PROPERTIES));
				int major = Integer.parseInt((String) props.get("JDofusCalc.version.major"));
				int minor = Integer.parseInt((String) props.get("JDofusCalc.version.minor"));
				int patch = Integer.parseInt((String) props.get("JDofusCalc.version.patch"));
				String tag = (String) props.get("JDofusCalc.version.tag");
				
				if(tag.equals("beta"))
					Main.version = String.format("%1$d.%2$d.%3$d %4$s", major, minor, patch, tag);
				else
					Main.version = String.format("%1$d.%2$d.%3$d", major, minor, patch);
				
				return Main.version;
			}
			catch(FileNotFoundException e)
			{
				e.printStackTrace();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}

			return null;
		}
		else
		{
			return Main.version;
		}
	}
}