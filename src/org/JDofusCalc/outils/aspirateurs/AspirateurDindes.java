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
import java.util.Iterator;
import java.util.List;

import org.JDofusCalc.dofus.autres.Effets;
import org.JDofusCalc.dofus.autres.Effets.FlagsTypesEffets;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import fr.ayapap.ASQL;

/**
 * Enregistre toutes les dindes
 * 
 * @author PAPAYA Alexandre
 * @category Aspirateur
 * @version 1.0
 */
public class AspirateurDindes
{
	/**
	 * @category Constructeur
	 */
	@SuppressWarnings("unchecked")
	public AspirateurDindes(ASQL bdd)
	{
		try
		{
			SAXBuilder builder = new SAXBuilder();
			Document fichierXML = builder.build(new File("dofusdatabase/dindes.xml"));
			List listeDofus = fichierXML.getRootElement().getChildren("dinde");
			Iterator iterator = listeDofus.iterator();
			while(iterator.hasNext())
			{
				Element dofus = (Element) iterator.next();
				String nom = dofus.getChildText("nom");
				int niveau = 60;

				Effets effets = new Effets();

				List caracteristiques = dofus.getChild("bonus").getChildren("caracteristique");
				Iterator iteratorCaracteristiques = caracteristiques.iterator();
				while(iteratorCaracteristiques.hasNext())
				{
					Element caracteristique = (Element) iteratorCaracteristiques.next();

					String nomCaracteristique = caracteristique.getAttributeValue("nom");
					double valeurMin = Double.parseDouble(caracteristique.getText());

					FlagsTypesEffets flag = FlagsTypesEffets.getFlag(nomCaracteristique);
					effets.setDouble(flag, valeurMin);
				}

				bdd.requetePreparee("INSERT INTO MONTURES VALUES(?, ?, ?, ?, ?);", new Object[] { null, nom, niveau, null, effets.sauvegarder(bdd, "MONTURES", "EFFETS") });

				//System.out.println(nom);
				// System.out.println(effets);
			}

			System.out.println("Dindes Done.");
		}
		catch(JDOMException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}