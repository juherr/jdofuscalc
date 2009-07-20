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

import org.JDofusCalc.dofus.autres.Degats;
import org.JDofusCalc.dofus.autres.Effets;
import org.JDofusCalc.dofus.autres.Degats.FlagsTypesDegats;
import org.JDofusCalc.dofus.conditions.Condition;
import org.JDofusCalc.dofus.conditions.ConditionClasse;
import org.JDofusCalc.dofus.objets.Arme.FlagsTypesArmes;

import fr.ayapap.ASQL;

/**
 * Enregistre toutes les armes présentes sur le site officiel
 * 
 * @author PAPAYA Alexandre
 * @category Aspirateur
 * @version 1.0
 */
public class AspirateurArmes
{
	/**
	 * Connexion à la base de données
	 */
	protected ASQL bdd = null;

	/**
	 * Le constructeur
	 * 
	 */
	public AspirateurArmes(ASQL bdd)
	{
		// Initialisation de la connexion à la basse de données
		this.bdd = bdd;

		/* Epées */
		this.aspirer("http://www.dofus.com/fr/mmorpg-jeux/objets/1-armes/6-epee.html?pa=", 12, FlagsTypesArmes.Epee.getId());
		System.out.println("Epées Done.");

		/* Faux */
		this.aspirer("http://www.dofus.com/fr/mmorpg-jeux/objets/1-armes/22-faux.html?pa=", 1, FlagsTypesArmes.Faux.getId());
		System.out.println("Faux Done.");

		/* Haches */
		this.aspirer("http://www.dofus.com/fr/mmorpg-jeux/objets/1-armes/19-hache.html?pa=", 7, FlagsTypesArmes.Hache.getId());
		System.out.println("Haches Done.");

		/* Marteaux */
		this.aspirer("http://www.dofus.com/fr/mmorpg-jeux/objets/1-armes/7-marteau.html?pa=", 11, FlagsTypesArmes.Marteau.getId());
		System.out.println("Marteaux Done.");

		/* Outils */
		this.aspirer("http://www.dofus.com/fr/mmorpg-jeux/objets/1-armes/20-outil.html?pa=", 4, FlagsTypesArmes.Outil.getId());
		System.out.println("Outils Done.");

		/* Arcs */
		this.aspirer("http://www.dofus.com/fr/mmorpg-jeux/objets/1-armes/2-arc.html?pa=", 12, FlagsTypesArmes.Arc.getId());
		System.out.println("Arcs Done.");

		/* Baguettes */
		this.aspirer("http://www.dofus.com/fr/mmorpg-jeux/objets/1-armes/3-baguette.html?pa=", 9, FlagsTypesArmes.Baguette.getId());
		System.out.println("Baguettes Done.");

		/* Bâtons */
		this.aspirer("http://www.dofus.com/fr/mmorpg-jeux/objets/1-armes/4-baton.html?pa=", 10, FlagsTypesArmes.Baton.getId());
		System.out.println("Bâtons Done.");

		/* Pelles */
		this.aspirer("http://www.dofus.com/fr/mmorpg-jeux/objets/1-armes/8-pelle.html?pa=", 8, FlagsTypesArmes.Pelle.getId());
		System.out.println("Pelles Done.");

		/* Pioches */
		this.aspirer("http://www.dofus.com/fr/mmorpg-jeux/objets/1-armes/21-pioche.html?pa=", 1, FlagsTypesArmes.Pioche.getId());
		System.out.println("Pioches Done.");

		/* Dagues */
		this.aspirer("http://www.dofus.com/fr/mmorpg-jeux/objets/1-armes/5-dague.html?pa=", 10, FlagsTypesArmes.Dague.getId());
		System.out.println("Dagues Done.");

		System.out.println("Armes Done.");
	}

	/**
	 * Aspire tout un type d'arme
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
				String description = "";
				ArrayList<Condition> conditions = new ArrayList<Condition>();
				ConditionClasse conditionClasse = null;
				int niveau = 0;
				int idPano = 0;
				int pa = 0;
				int po = 0;
				int cc = 0;
				int domCC = 0;
				int ec = 0;
				String autresEffets = "";
				Effets effetsMini = new Effets();
				Effets effetsMaxi = new Effets();
				Degats[] degats = new Degats[5];
				int ligneEnCours = 0;

				String ligne;
				int etape = 1;
				Pattern patternNom = Pattern.compile("              <div class=\"txt_white\" style=\"float:left; margin-left: 10px;cursor:pointer;\" onclick=\"OpenCloseDiv\\('.+'\\);\" >(.+)</div>");
				Pattern patternNiveau = Pattern.compile("              <div class=\"txt_white\" style=\"float:right; margin-right: 10px;\">Niveau (.+)</div>");
				Pattern patternDegats = Pattern.compile("                      <td height=\"20\">((Dommages|Vole|PDV rendus).+)</td>");
				Pattern patternEffets = Pattern.compile("                      <td height=\"20\"(class=\"(txt_green|txt_red)\")?>(.+)</td>");
				Pattern patternCaracteritiques1 = Pattern.compile("                    <tr><td width=\"350\" class=\"txt_title\">Caractéristique</td></tr>");
				Pattern patternCaracteritiques2 = Pattern.compile("                    <tr( bgcolor=\"#dfd7c0\")?><td height=\"20\">(.+)</td></tr>");
				Pattern patternConditions1 = Pattern.compile("                    <tr><td width=\"350\" class=\"txt_title\">Conditions</td></tr>");
				Pattern patternConditions2 = Pattern.compile(".+<tr( bgcolor=\"#dfd7c0\")?><td height=\"20\">(.+)</td></tr>");
				Pattern patternDescription1 = Pattern.compile("          <tr><td class=\"txt_title\">Description</td></tr>");
				Pattern patternDescription2 = Pattern.compile("          <tr><td height=\"20\">(.+)</td></tr>");
				Pattern patternPano = Pattern.compile("                <a href=\"/fr/mmorpg-jeux/panoplies/([0-9]+)-(.+)/\" target=\"_blank\">(.+)</a>");
				Pattern patternFin = Pattern.compile("  </table>");

				// Lecture ligne par ligne de la page
				while((ligne = reader.readLine()) != null)
				{
					// Recherche du nom
					if(etape == 1)
					{
						Matcher matcher = patternNom.matcher(ligne);
						if(matcher.matches())
						{
							nom = matcher.group(1);
							String[] exclus = new String[] { "Canne à Koinkoin" };
							Arrays.sort(exclus);
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
						Matcher matcher2 = patternDegats.matcher(ligne);
						Matcher matcher3 = patternCaracteritiques1.matcher(ligne);
						// Si degats
						if(matcher2.matches())
						{
							Pattern pattern = Pattern.compile("(Dommages|Vole|PDV rendus)( \\:)? (\\+|\\-)?([0-9]+)( &agrave; (\\+|\\-)?([0-9]+))?( PDV)? ?(\\((neutre|terre|feu|eau|air)\\))?");
							Matcher matcher5 = pattern.matcher(matcher2.group(1));
							if(matcher5.matches())
							{
								degats[ligneEnCours] = new Degats();
								if(matcher5.group(1).equals("Dommages"))
								{
									degats[ligneEnCours].set(FlagsTypesDegats.getFlag("Dégâts " + matcher5.group(10) + " minimums"), Integer.parseInt(matcher5.group(4)));
									if(matcher5.group(7) != null)
									{
										degats[ligneEnCours].set(FlagsTypesDegats.getFlag("Dégâts " + matcher5.group(10) + " maximums"), Integer.parseInt(matcher5.group(7)));
									}
									else
									{
										degats[ligneEnCours].set(FlagsTypesDegats.getFlag("Dégâts " + matcher5.group(10) + " maximums"), Integer.parseInt(matcher5.group(4)));
									}
								}
								else if(matcher5.group(1).equals("Vole"))
								{
									degats[ligneEnCours].set(FlagsTypesDegats.getFlag("Vols de vie " + matcher5.group(10) + " minimums"), Integer.parseInt(matcher5.group(4)));
									if(matcher5.group(7) != null)
									{
										degats[ligneEnCours].set(FlagsTypesDegats.getFlag("Vols de vie " + matcher5.group(10) + " maximums"), Integer.parseInt(matcher5.group(7)));
									}
									else
									{
										degats[ligneEnCours].set(FlagsTypesDegats.getFlag("Vols de vie " + matcher5.group(10) + " maximums"), Integer.parseInt(matcher5.group(4)));
									}
								}
								else if(matcher5.group(1).equals("PDV rendus"))
								{
									degats[ligneEnCours].set(FlagsTypesDegats.SoinsMin, Integer.parseInt(matcher5.group(4)));
									degats[ligneEnCours].set(FlagsTypesDegats.SoinsMax, Integer.parseInt(matcher5.group(7)));
								}
								ligneEnCours++;
							}
							else
							{
								Pattern patternVoleOr = Pattern.compile("Vole  ([0-9]+) &agrave; ([0-9]+) d'or");
								Matcher matcherVoleOr = patternVoleOr.matcher(matcher2.group(1));
								if(matcherVoleOr.matches())
								{
									autresEffets += "Vole " + matcherVoleOr.group(1) + " à " + matcherVoleOr.group(2) + " d'or.\n";
								}
								else
								{
									System.err.println("Degats illisibles : '" + matcher2.group(1) + "'");
								}
							}
						}
						// Si effets
						else if(matcher.matches())
						{
							Pattern patternPAPerdus = Pattern.compile("PA perdus &agrave; la cible : ([0-9&agrave; ]+)");
							Matcher matcherPAPerdus = patternPAPerdus.matcher(matcher.group(3));
							Pattern patternResist = Pattern.compile("R&eacute;sistance : [0-9]+ / [0-9]+");
							Matcher matcherResist = patternResist.matcher(matcher.group(3));
							if(matcherPAPerdus.matches())
							{
								String[] armePertePAPorteur = new String[] { "Corbalame", "Hache Térophyle", "Bâton d'Oubli", "Lames Sanglantes D'Ortimus Contrari" };
								Arrays.sort(armePertePAPorteur);
								// Si c'est une arme qui fait perdre des PAs aux
								// porteurs
								if((Arrays.binarySearch(armePertePAPorteur, nom) >= 0))
								{
									// System.err.println(nom);
									Aspirateur.genererEffets(matcher.group(3), effetsMini, effetsMaxi);
								}
								else
								{
									autresEffets += "Fait perdre " + matcher.group(3) + " PA(s) à la cible.\n";
									// System.err.println(nom +
									// " : Pertes de PA !");
								}
							}
							else if(matcherResist.matches())
							{
								autresEffets += "Arme éphémère.\n" + autresEffets;
							}
							else if(matcher.group(3).equals("Permet d'utiliser l'&eacute;moticon Jouer de la fl?"))
							{
								autresEffets += "Permet d'utiliser l'émoticon 'Jouer de la flûte'.\n";
							}
							else
							{
								Aspirateur.genererEffets(matcher.group(3), effetsMini, effetsMaxi);
							}
						}
						// Si caractéristiques
						else if(matcher3.matches())
						{
							etape++;
						}
					}
					// Recherhe des caractéristiques de l'arme
					else if(etape == 4)
					{
						Matcher matcher = patternCaracteritiques2.matcher(ligne);
						Matcher matcher2 = patternConditions1.matcher(ligne);
						Matcher matcher3 = patternDescription1.matcher(ligne);
						if(matcher.matches())
						{
							// System.out.println(matcher.group(2));
							Pattern pattern = Pattern.compile("(PA|Portée|CC|EC) : (1\\/)?([0-9]+) ?(\\(\\+([0-9]+)\\))?");
							Matcher matcher4 = pattern.matcher(matcher.group(2));
							if(matcher4.matches())
							{
								if(matcher4.group(1).equals("PA"))
								{
									pa = Integer.parseInt(matcher4.group(3));
								}
								else if(matcher4.group(1).equals("CC"))
								{
									cc = Integer.parseInt(matcher4.group(3));
									if(cc != 0)
									{
										domCC = Integer.parseInt(matcher4.group(5));
									}
								}
								else if(matcher4.group(1).equals("EC"))
								{
									ec = Integer.parseInt(matcher4.group(3));
								}
								else if(matcher4.group(1).equals("Portée"))
								{
									po = Integer.parseInt(matcher4.group(3));
								}
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
							etape = 6;
						}
					}
					// Recherhe des conditions
					else if(etape == 5)
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
					else if(etape == 6)
					{
						Matcher matcher = patternDescription2.matcher(ligne);
						if(matcher.matches())
						{
							description = matcher.group(1);
							etape++;
						}
					}
					// Recherche pano
					else if(etape == 7)
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
							int[] idDegats = new int[degats.length];
							for(int y = 0; y < degats.length; y++)
							{
								if(degats[y] != null)
								{
									idDegats[y] = degats[y].sauvegarder(this.bdd, "ARMES", "DEGATS_" + (y + 1));
								}
								else
								{
									idDegats[y] = 0;
								}
							}

							if(conditionClasse != null)
							{
								conditions.add(conditionClasse);
							}

							if(conditions.size() == 0)
							{
								conditions = null;
							}

							this.bdd.requetePreparee("INSERT INTO ARMES VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);", new Object[] { type, nom, description, niveau, conditions, idPano, pa, po, cc, domCC, ec, idDegats[0], idDegats[1], idDegats[2], idDegats[3], idDegats[4], effetsMini.sauvegarder(this.bdd, "ARMES", "EFFETS_MINI"), effetsMaxi.sauvegarder(this.bdd, "ARMES", "EFFETS_MAXI"), autresEffets });
							//System.out.println(nom + " [N. " + niveau + "] [P. " + idPano + "]");
							// System.out.println(conditions);
							// System.out.println(description);
							// System.out.println(domCC);

							etape = 1;
							nom = "";
							description = "";
							conditions = new ArrayList<Condition>();
							conditionClasse = null;
							niveau = 0;
							idPano = 0;
							pa = 0;
							cc = 0;
							domCC = 0;
							ec = 0;
							autresEffets = "";
							effetsMini = new Effets();
							effetsMaxi = new Effets();
							degats = new Degats[5];
							ligneEnCours = 0;
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