/**
 * Projet JDofusCalc
 * 
 * Copyright PAPAYA Alexandre, 2008
 * 
 * alexandre.papaya@gmail.com
 * 
 * Ce logiciel est un programme informatique de Gestion et de Calcul pour le jeu DOFUS. Il permet de gérer les différents personnages et équipements du joueur, et de voir directement les effets de ses choix en matière d’effet sur le jeu. 
 * 
 * Ce logiciel est régi par la licence CeCILL soumise au droit français et respectant les principes de diffusion des logiciels libres.
 * Vous pouvez utiliser, modifier et/ou redistribuer ce programme sous les conditions de la licence CeCILL telle que diffusée par le CEA, le CNRS et l'INRIA sur le site "http://www.cecill.info".
 * 
 * En contrepartie de l'accessibilité au code source et des droits de copie, de modification  * et de redistribution accordés par cette licence, il n'est offert aux utilisateurs qu'une  * garantie limitée.  Pour les mêmes raisons, seule une responsabilité restreinte pèse sur  * l'auteur du programme, le titulaire des droits patrimoniaux et les concédants successifs.
 * 
 * A cet égard  l'attention de l'utilisateur est attirée sur les risques associés au chargement,  à l'utilisation,  à la modification et/ou au développement et à la reproduction du logiciel par l'utilisateur étant donné sa spécificité de logiciel libre, qui peut le rendre complexe à manipuler et qui le réserve donc à des développeurs et des professionnels avertis possédant  des  connaissances  informatiques approfondies. Les utilisateurs sont donc invités à charger  et  tester  l'adéquation  du logiciel à leurs besoins dans des conditions permettant d'assurer la sécurité de leurs systèmes et ou de leurs données et, plus généralement, à l'utiliser et l'exploiter dans les mêmes conditions de sécurité. 
 * 
 * Le fait que vous puissiez accéder à cet en-tête signifie que vous avez pris connaissance de la licence CeCILL, et que vous en avez accepté les termes.
 * 
 */

package org.JDofusCalc.outils.aspirateurs;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.JDofusCalc.dofus.autres.Degats;
import org.JDofusCalc.dofus.autres.Degats.FlagsTypesDegats;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import fr.ayapap.ASQL;
import fr.ayapap.ASQLRequete;

/**
 * Sorts
 * 
 * @author PAPAYA Alexandre
 * @category Aspirateur
 * @version 1.0
 */
public class AspirateurSorts
{
	@SuppressWarnings("unchecked")
	public AspirateurSorts(ASQL bdd, int classe, String fichier)
	{
		try
		{
			SAXBuilder builder = new SAXBuilder();
			Document fichierXML = builder.build(new File(fichier));
			int idClasse = classe;
			
			List listeSorts = fichierXML.getRootElement().getChildren("sort");
			Iterator iterator = listeSorts.iterator();
			while(iterator.hasNext())
			{
				int idSort = 0;
				String nomSort = "";
				int niveauSort = 0;
				int pa = 0;
				int ec = 0;
				int cc = 0;

				Element sort = (Element) iterator.next();
				nomSort = sort.getChildText("nom");
				niveauSort = Integer.parseInt(sort.getChildText("niveau"));
				
				//System.out.println(nomSort);
				
				ASQLRequete req = bdd.requete("INSERT INTO SORTS VALUES(null, '" + ASQL.securise(nomSort) + "', " + niveauSort + ", " + idClasse + ", 'attaque', null, null, null, null, null, null)", true);
				req.getClefs().next();
				idSort = (int) req.getClefs().getLong(1);
				
				List listeCaracteristiquesort = sort.getChildren("caracteristiques");
				Iterator iteratorCaracteristiques = listeCaracteristiquesort.iterator();
				while(iteratorCaracteristiques.hasNext())
				{
					Element caracteristiques = (Element) iteratorCaracteristiques.next();

					int niveau = Integer.parseInt(caracteristiques.getAttributeValue("niveau"));
					pa = Integer.parseInt(caracteristiques.getChildText("pa"));
					cc = Integer.parseInt(caracteristiques.getChildText("cc"));
					ec = Integer.parseInt(caracteristiques.getChildText("ec"));
					
					// Effets
					String effetsNormal = caracteristiques.getChild("normal").getChildText("effets");
					String effetsCritique;
					if(cc > 0)
						effetsCritique = caracteristiques.getChild("critique").getChildText("effets");
					
					// Normal
					Degats degatsNormaux = new Degats();
					List listeDegatsNormaux = caracteristiques.getChild("normal").getChildren("degats");
					Iterator iteratorDegatsNormaux = listeDegatsNormaux.iterator();
					while(iteratorDegatsNormaux.hasNext())
					{
						Element degatsNormal = (Element) iteratorDegatsNormaux.next();
						String type = degatsNormal.getAttributeValue("type");
						if(type != null)
						{
							int minimum = Integer.parseInt(degatsNormal.getChildText("min"));
							int maximum = Integer.parseInt(degatsNormal.getChildText("max"));
							degatsNormaux.set(FlagsTypesDegats.getFlag(type + " maximums"), maximum);
							degatsNormaux.set(FlagsTypesDegats.getFlag(type + " minimums"), minimum);
						}
						else
						{
							continue;
						}
					}
					
					// Critiques
					int idDegatsCC = 0;
					if(cc > 0)
					{
						Degats degatsCC = new Degats();
						List listeDegatsCritiques = caracteristiques.getChild("critique").getChildren("degats");
						Iterator iteratorDegatsCritiques = listeDegatsCritiques.iterator();
						while(iteratorDegatsCritiques.hasNext())
						{
							Element degatsCritique = (Element) iteratorDegatsCritiques.next();
							String type = degatsCritique.getAttributeValue("type");
							if(type != null)
							{
								int minimum = Integer.parseInt(degatsCritique.getChildText("min"));
								int maximum = Integer.parseInt(degatsCritique.getChildText("max"));
								degatsCC.set(FlagsTypesDegats.getFlag(type + " maximums"), maximum);
								degatsCC.set(FlagsTypesDegats.getFlag(type + " minimums"), minimum);
							}
							else
							{
								continue;
							}
						}
						idDegatsCC = degatsCC.sauvegarder(bdd, "NIVEAUX_SORTS", "DEGATS_CC");
					}					
					
					ASQLRequete reqNiveau = bdd.requete("INSERT INTO NIVEAUX_SORTS VALUES(null, " + pa + ", " + cc + ", " + ec + ", " + degatsNormaux.sauvegarder(bdd, "NIVEAUX_SORTS", "DEGATS") + ", " + idDegatsCC + ", null, null);", true);
					reqNiveau.getClefs().next();
					int idNiveau = (int) reqNiveau.getClefs().getLong(1);
					bdd.requete("UPDATE SORTS SET NIVEAU_" + niveau + "=" + idNiveau + " WHERE ID=" + idSort);
				}
			}

			System.out.println("Lecture de " + fichier + " terminée.");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(JDOMException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}