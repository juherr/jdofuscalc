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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.JDofusCalc.dofus.autres.Effets;
import org.JDofusCalc.dofus.conditions.Condition;
import org.JDofusCalc.dofus.conditions.ConditionClasse;
import org.JDofusCalc.dofus.objets.Equipement.FlagsTypesEquipements;

import fr.ayapap.ASQL;

/**
 * Enregistre toutes les armes présentes sur le site officiel
 * 
 * @author PAPAYA Alexandre
 * @category Aspirateur
 * @version 1.0
 */
public class AspirateurEquipements
{
	/**
	 * Connexion à la base de données
	 */
	protected ASQL bdd = null;

	/**
	 * Le constructeur
	 * 
	 */
	public AspirateurEquipements(ASQL bdd)
	{
		// Initialisation de la connexion à la basse de données
		this.bdd = bdd;

		/* Panoplies */
		this.aspirerPano();
		System.out.println("Panoplies Done.");

		/* Amulettes */
		this.aspirer("http://www.dofus.com/fr/mmorpg-jeux/objets/2-objets/1-amulette.html?pa=", 16, FlagsTypesEquipements.Amulette.getId());
		System.out.println("Amulettes Done.");

		/* Anneaux */
		this.aspirer("http://www.dofus.com/fr/mmorpg-jeux/objets/2-objets/9-anneau.html?pa=", 17, FlagsTypesEquipements.Anneau.getId());
		System.out.println("Anneaux Done.");

		/* Boucliers */
		this.aspirer("http://www.dofus.com/fr/mmorpg-jeux/objets/2-objets/82-bouclier.html?pa=", 4, FlagsTypesEquipements.Bouclier.getId());
		System.out.println("Boucliers Done.");

		/* Capes */
		this.aspirer("http://www.dofus.com/fr/mmorpg-jeux/objets/2-objets/17-cape.html?pa=", 16, FlagsTypesEquipements.Cape.getId());
		System.out.println("Capes Done.");
		/* Sacs */
		this.aspirer("http://www.dofus.com/fr/mmorpg-jeux/objets/2-objets/81-sac-à-dos.html?pa=", 2, FlagsTypesEquipements.Cape.getId());
		System.out.println("Sacs Done.");

		/* Ceintures */
		this.aspirer("http://www.dofus.com/fr/mmorpg-jeux/objets/2-objets/10-ceinture.html?pa=", 16, FlagsTypesEquipements.Ceinture.getId());
		System.out.println("Ceintures Done.");

		/* Coiffes */
		this.aspirer("http://www.dofus.com/fr/mmorpg-jeux/objets/2-objets/16-chapeau.html?pa=", 21, FlagsTypesEquipements.Coiffe.getId());
		System.out.println("Coiffes Done.");

		/* Bottes */
		this.aspirer("http://www.dofus.com/fr/mmorpg-jeux/objets/2-objets/11-botte.html?pa=", 16, FlagsTypesEquipements.Bottes.getId());
		System.out.println("Bottes Done.");

		System.out.println("Objets Done.");
	}

	private void aspirerPano()
	{
		int continuer = 0;
		String nomPano = "";
		int nbObjets = 0;
		Effets[] effets = null;

		for(int i = 0; i <= 200; i++)
		{
			if(continuer > 20)
			{
				break;
			}

			try
			{
				URL siteofficiel = new URL("http://www.dofus.com/fr/mmorpg-jeux/panoplies/" + i + "-panoplie/");
				URLConnection connexion = siteofficiel.openConnection();
				BufferedReader reader = new BufferedReader(new InputStreamReader(connexion.getInputStream(), "UTF-8"));
				int objetsCourrant = 0;
				int etape = 0;

				nomPano = "";
				nbObjets = 0;
				objetsCourrant = 0;
				effets = null;
				etape = 1;

				Pattern patternNom = Pattern.compile("      <span style=\"color:#672608;font-weight:bold;\">(.+)</span>");
				Pattern patternNbObj = Pattern.compile("              <td width=\"100%\" class=\"txt_title\">(.+) Objets</td>");
				Pattern patternEffets = Pattern.compile("              <td height=\"20\"class=\".+\">(.+)</td>");
				Pattern patternFin = Pattern.compile("            <div class=\"txt_white\" style=\"float:left; margin-left: 10px;\">Bonus total de la panoplie complète</div>");

				String ligne;
				while((ligne = reader.readLine()) != null)
				{
					if(etape == 1)
					{
						Matcher matcher = patternNom.matcher((CharSequence) ligne);
						if(matcher.matches())
						{
							nomPano = matcher.group(1);
							++etape;
						}
					}
					else if(etape == 2)
					{
						Matcher matcher = patternNbObj.matcher(ligne);
						Matcher matcher2 = patternEffets.matcher(ligne);
						Matcher matcher3 = patternFin.matcher(ligne);
						if(matcher.matches())
						{
							if(nbObjets == 0)
							{
								nbObjets = Integer.parseInt(matcher.group(1));
								effets = new Effets[8];
							}

							// System.out.println(objetsCourrant);
							// System.out.println(nbObjets);

							objetsCourrant = Integer.parseInt(matcher.group(1));
							effets[objetsCourrant - 1] = new Effets();
						}
						else if(matcher2.matches())
						{
							Aspirateur.genererEffets(matcher2.group(1), effets[objetsCourrant - 1], new Effets());
						}
						else if(matcher3.matches())
						{
							break;
						}
					}

				}
			}
			catch(MalformedURLException exception)
			{
				exception.printStackTrace();
				continuer++;
				continue;
			}
			catch(IOException exception)
			{
				exception.printStackTrace();
				continuer++;
				continue;
			}

			if(nomPano.equals("") || (nbObjets == 0))
			{
				// System.out.println("http://www.dofus.com/fr/mmorpg-jeux/panoplies/"
				// + i + "-panoplie/");
				continuer++;
				continue;
			}
			else
			{
				continuer = 0;
			}
			String[] idEffets = new String[effets.length];
			for(int y = 0; y < effets.length; y++)
			{
				if(effets[y] == null)
				{
					idEffets[y] = "null";
				}
				else
				{
					idEffets[y] = String.valueOf(effets[y].sauvegarder(this.bdd, "PANOPLIES", "BONUS_" + (y + 2) + "O"));
				}
			}

			this.bdd.requete("INSERT INTO PANOPLIES VALUES(null, " + i + ", '" + ASQL.securise(nomPano) + "', 1, null, " + nbObjets + ", " + idEffets[0] + ", " + idEffets[1] + ", " + idEffets[2] + ", " + idEffets[3] + ", " + idEffets[4] + ", " + idEffets[5] + ", " + idEffets[6] + ", " + idEffets[7] + ");");

			System.out.println("_____\n#" + i + "\nNom: " + nomPano + "\nNombre d'objets: " + nbObjets);
		}
	}

	/**
	 * Aspire tout un type d'objet
	 * 
	 * @param url
	 * @param nbPages
	 * @param type
	 */
	private void aspirer(String url, int nbPages, int type)
	{
		// Boucle des pages
		for(int i = 1; i <= nbPages; i++)
		{
			try
			{
				URL siteofficiel = new URL(url + i);
				URLConnection connexion = siteofficiel.openConnection();
				BufferedReader reader = new BufferedReader(new InputStreamReader(connexion.getInputStream(), "UTF-8"));

				String nom = "";
				String autresEffets = "";
				String description = "";
				ArrayList<Condition> conditions = new ArrayList<Condition>();
				ConditionClasse conditionClasse = null;
				int niveau = 0;
				int idPano = 0;
				Effets effetsMini = new Effets();
				Effets effetsMaxi = new Effets();
				int etape = 1;

				Pattern patternNom = Pattern.compile("              <div class=\"txt_white\" style=\"float:left; margin-left: 10px;cursor:pointer;\" onclick=\"OpenCloseDiv\\('.+'\\);\" >(.+)</div>");
				Pattern patternNiveau = Pattern.compile("              <div class=\"txt_white\" style=\"float:right; margin-right: 10px;\">Niveau ([0-9]+)</div>");
				Pattern patternEffets = Pattern.compile("                      <td height=\"20\"(class=\"(txt_green|txt_red)\")?>(.+)</td>");
				Pattern patternConditions1 = Pattern.compile("                    <tr><td width=\"350\" class=\"txt_title\">Conditions</td></tr>");
				Pattern patternConditions2 = Pattern.compile(".+<tr( bgcolor=\"#dfd7c0\")?><td height=\"20\">(.+)</td></tr>");
				Pattern patternDescription1 = Pattern.compile("          <tr><td class=\"txt_title\">Description</td></tr>");
				Pattern patternDescription2 = Pattern.compile("          <tr><td height=\"20\">(.+)</td></tr>");
				Pattern patternDescription3 = Pattern.compile("          <tr><td height=\"20\">(.+)");
				Pattern patternDescription4 = Pattern.compile("(.+)</td></tr>");
				Pattern patternPano = Pattern.compile("                <a href=\"/fr/mmorpg-jeux/panoplies/([0-9]+)-(.+)/\" target=\"_blank\">(.+)</a>");
				Pattern patternFin = Pattern.compile("  </table>");

				// Lecture ligne par ligne de la page
				String ligne;
				while((ligne = reader.readLine()) != null)
				{
					// Recherche du nom
					if(etape == 1)
					{
						Matcher matcher = patternNom.matcher(ligne);
						if(matcher.matches())
						{
							nom = matcher.group(1);

							String[] exclus = new String[] { "Artefact Air", "Artefact Eau", "Artefact Feu", "Artefact Lumière", "Artefact Terre", "Artefact Vie" };
							if(!(Arrays.binarySearch(exclus, nom) >= 0))
							{
								etape++;
							}
							else
							{
								etape = 1;
							}
						}
					}
					// Recherche du niveau
					else if(etape == 2)
					{
						Matcher matcher = patternNiveau.matcher(ligne);
						if(matcher.matches())
						{
							niveau = Integer.parseInt(matcher.group(1));
							etape++;
						}
					}
					// Recherhe des effets
					else if(etape == 3)
					{
						Matcher matcher = patternEffets.matcher(ligne);
						Matcher matcher2 = patternConditions1.matcher(ligne);
						Matcher matcher3 = patternDescription1.matcher(ligne);
						if(matcher.matches())
						{
							Pattern patternResist = Pattern.compile("R&eacute;sistance : [0-9]+ / [0-9]+");
							Matcher matcherResist = patternResist.matcher(matcher.group(3));
							if(matcherResist.matches())
							{
								autresEffets = "Objet éphémère.\n" + autresEffets;
							}
							else if(matcher.group(3).equals("Change les paroles"))
							{
								autresEffets += "Change les paroles du personnage.\n";
							}
							else if(matcher.group(3).equals("Change l'apparence"))
							{
								autresEffets += "Change l'apparence du personnage.\n";
							}
							else
							{
								Aspirateur.genererEffets(matcher.group(3), effetsMini, effetsMaxi);
							}
						}
						// Si conditions
						else if(matcher2.matches())
						{
							etape++;
						}
						// Si description
						else if(matcher3.matches())
						{
							etape = 5;
						}
					}
					// Recherhe des conditions
					else if(etape == 4)
					{
						Matcher matcherCond = patternConditions2.matcher(ligne);
						Matcher matcher2 = patternDescription1.matcher(ligne);
						if(matcherCond.matches())
						{
							Aspirateur.genererConditions(matcherCond.group(2), conditions, conditionClasse);
						}
						else if(matcher2.matches())
						{
							etape++;
						}
					}
					// Recherche description
					else if(etape == 5)
					{
						Matcher matcher = patternDescription2.matcher(ligne);
						Matcher matcher2 = patternDescription3.matcher(ligne);
						Matcher matcher3 = patternDescription4.matcher(ligne);
						if(matcher.matches())
						{
							description = matcher.group(1);
							etape++;
						}
						else if(matcher2.matches())
						{
							description = matcher2.group(1);
						}
						else if(matcher3.matches())
						{
							description += matcher3.group(1);
							etape++;
						}
					}
					// Recherche pano
					else if(etape == 6)
					{
						Matcher matcher = patternPano.matcher(ligne);
						if(matcher.matches())
						{
							idPano = Integer.parseInt(matcher.group(1));
							etape++;
						}
					}
					// Recherche fin
					if(etape > 5)
					{
						Matcher matcher = patternFin.matcher(ligne);
						if(matcher.matches())
						{
							if(conditions.size() == 0)
								conditions = null;
							
							this.bdd.requetePreparee("INSERT INTO EQUIPEMENTS VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?, ?);", new Object[] {type, nom, description, niveau, conditions, idPano, effetsMini.sauvegarder(this.bdd, "EQUIPEMENTS", "EFFETS_MINI"), effetsMaxi.sauvegarder(this.bdd, "EQUIPEMENTS", "EFFETS_MAXI"), autresEffets});
							//System.out.println(nom + " [N. " + niveau + "] [P. " + idPano + "]");
							// System.out.println(conditions);
							// System.out.println(description);

							nom = "";
							autresEffets = "";
							description = "";
							conditions = new ArrayList<Condition>();
							conditionClasse = null;
							niveau = 0;
							idPano = 0;
							effetsMini = new Effets();
							effetsMaxi = new Effets();
							etape = 1;
						}
					}
				}
			}
			catch(MalformedURLException e)
			{
				e.printStackTrace();
				break;
			}
			catch(IOException e)
			{
				e.printStackTrace();
				break;
			}
		}
	}
}