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
package org.JDofusCalc.outils.aspirateurs;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.JDofusCalc.dofus.autres.Effets;
import org.JDofusCalc.dofus.autres.Effets.FlagsTypesEffets;
import org.JDofusCalc.dofus.conditions.Condition;
import org.JDofusCalc.dofus.conditions.ConditionAlignement;
import org.JDofusCalc.dofus.conditions.ConditionCaracteristique;
import org.JDofusCalc.dofus.conditions.ConditionClasse;
import org.JDofusCalc.dofus.conditions.ConditionGrade;
import org.JDofusCalc.dofus.conditions.ConditionKama;
import org.JDofusCalc.dofus.conditions.ConditionSexe;
import org.JDofusCalc.dofus.conditions.Condition.Operateur;
import org.JDofusCalc.dofus.conditions.ConditionAlignement.Alignement;
import org.JDofusCalc.dofus.conditions.ConditionSexe.Sexe;

import fr.ayapap.ASQL;

/**
 * Aspirateur.
 *
 * @author PAPAYA Alexandre
 * @category Aspirateur
 * @version 1.0
 */
public class Aspirateur
{
	/**
	 * Connexion à la base de données.
	 */
	protected ASQL bdd = null;
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		new Aspirateur();
	}
	
	/**
	 * Construit un nouvel aspirateur.
	 * 
	 * @category Constructeur
	 */
	public Aspirateur()
	{
		// Initialisation de la connexion à la basse de données
		this.bdd = new ASQL("org.h2.Driver", "h2:file:donnees/dofusdatabase", "dofusdatabase", "Administrateur", "admin");
			
		//new AspirateurSorts(this.bdd, 10, "dofusdatabase/sacrieur_sorts.xml");
		//System.exit(0);
		
		// Netoyage
		String[] tables = new String[] { "DEGATS", "EFFETS", "ARMES", "EQUIPEMENTS", "MONTURES", "DOFUS", "SORTS", "NIVEAUX_SORTS", "PALIERS", "PANOPLIES" };
		for(String table : tables)
		{
			this.bdd.requete("TRUNCATE TABLE " + table + ";");
			this.bdd.requete("ALTER TABLE " + table + " ALTER COLUMN ID RESTART WITH 1;");
		}
		
		// Armes
		new AspirateurArmes(this.bdd);
		
		// Equipements
		new AspirateurEquipements(this.bdd);
		
		// Dofus
		new AspirateurDofus(this.bdd);
		
		// Familiers
		new AspirateurFamiliers(this.bdd);
		
		// Dindes
		new AspirateurDindes(this.bdd);

		// Sorts
		new AspirateurSorts(this.bdd, 0, "dofusdatabase/all_sorts.xml");
		new AspirateurSorts(this.bdd, 1, "dofusdatabase/crâ_sorts.xml");
		new AspirateurSorts(this.bdd, 2, "dofusdatabase/ecaflip_sorts.xml");
		new AspirateurSorts(this.bdd, 3, "dofusdatabase/eniripsa_sorts.xml");
		new AspirateurSorts(this.bdd, 4, "dofusdatabase/enutrof_sorts.xml");
		new AspirateurSorts(this.bdd, 5, "dofusdatabase/féca_sorts.xml");
		new AspirateurSorts(this.bdd, 6, "dofusdatabase/xélor_sorts.xml");
		new AspirateurSorts(this.bdd, 7, "dofusdatabase/iop_sorts.xml");
		new AspirateurSorts(this.bdd, 8, "dofusdatabase/osamodas_sorts.xml");
		new AspirateurSorts(this.bdd, 9, "dofusdatabase/pandawa_sorts.xml");
		new AspirateurSorts(this.bdd, 10, "dofusdatabase/sacrieur_sorts.xml");
		new AspirateurSorts(this.bdd, 11, "dofusdatabase/sadida_sorts.xml");
		new AspirateurSorts(this.bdd, 12, "dofusdatabase/sram_sorts.xml");
		
		// Paliers
		new AspirateurPaliersClasses(this.bdd);
	}
	
	/**
	 * Genere les effets de l'arme
	 * 
	 * @param masque
	 * @param effetsMini
	 * @param effetsMaxi
	 */
	public final static void genererEffets(String masque, Effets effetsMini, Effets effetsMaxi)
	{
		Pattern patternVie = Pattern.compile("((\\+|\\-)[0-9&agrave; \\-]+) en vie");
		Matcher matcherVie = patternVie.matcher(masque);
		Pattern patternPA = Pattern.compile("((\\+|\\-)[0-9&agrave; \\-]+) PA");
		Matcher matcherPA = patternPA.matcher(masque);
		Pattern patternPAPerdus = Pattern.compile("PA perdus &agrave; la cible : ([0-9&agrave; ]+)");
		Matcher matcherPAPerdus = patternPAPerdus.matcher(masque);
		Pattern patternPM = Pattern.compile("((\\+|\\-)[0-9&agrave; \\-]+) PM");
		Matcher matcherPM = patternPM.matcher(masque);
		Pattern patternPMPerdus = Pattern.compile("PM perdus : ([0-9&agrave; ]+)");
		Matcher matcherPMPerdus = patternPMPerdus.matcher(masque);
		Pattern patternPO = Pattern.compile("((\\+|\\-)[0-9&agrave; \\-]+) &agrave; la port&eacute;e");
		Matcher matcherPO = patternPO.matcher(masque);
		Pattern patternIni = Pattern.compile("((\\+|\\-)[0-9&agrave; \\-]+) en initiative");
		Matcher matcherIni = patternIni.matcher(masque);
		Pattern patternPP = Pattern.compile("((\\+|\\-)[0-9&agrave; \\-]+) en prospection");
		Matcher matcherPP = patternPP.matcher(masque);

		Pattern patternVita = Pattern.compile("((\\+|\\-)[0-9&agrave; \\-]+) en vitalit&eacute;");
		Matcher matcherVita = patternVita.matcher(masque);
		Pattern patternSag = Pattern.compile("((\\+|\\-)[0-9&agrave; \\-]+) en sagesse");
		Matcher matcherSag = patternSag.matcher(masque);
		Pattern patternForce = Pattern.compile("((\\+|\\-)[0-9&agrave; \\-]+) en force");
		Matcher matcherForce = patternForce.matcher(masque);
		Pattern patternInt = Pattern.compile("((\\+|\\-)[0-9&agrave; \\-]+) en intelligence");
		Matcher matcherInt = patternInt.matcher(masque);
		Pattern patternChance = Pattern.compile("((\\+|\\-)[0-9&agrave; \\-]+) (&agrave; la|en) chance");
		Matcher matcherChance = patternChance.matcher(masque);
		Pattern patternAgi = Pattern.compile("((\\+|\\-)[0-9&agrave; \\-]+) en agilit&eacute;");
		Matcher matcherAgi = patternAgi.matcher(masque);

		Pattern patternDom = Pattern.compile("((\\+|\\-)[0-9&agrave; \\-]+) de dommages");
		Matcher matcherDom = patternDom.matcher(masque);
		Pattern patternPDom = Pattern.compile("Augmente les dommages de ([0-9&agrave; ]+)%");
		Matcher matcherPDom = patternPDom.matcher(masque);
		Pattern patternPiege = Pattern.compile("((\\+|\\-)[0-9&agrave; \\-]+) de dommages aux pi&egrave;ges");
		Matcher matcherPiege = patternPiege.matcher(masque);
		Pattern patternPPiege = Pattern.compile("((\\+|\\-)[0-9&agrave; \\-]+)% de dommages aux pi&egrave;ges");
		Matcher matcherPPiege = patternPPiege.matcher(masque);
		Pattern patternSoins = Pattern.compile("((\\+|\\-)[0-9&agrave; \\-]+) de soins");
		Matcher matcherSoins = patternSoins.matcher(masque);
		Pattern patternInvoc = Pattern.compile("((\\+|\\-)[0-9&agrave; \\-]+) cr&eacute;atures invocables");
		Matcher matcherInvoc = patternInvoc.matcher(masque);
		Pattern patternCC = Pattern.compile("((\\+|\\-)[0-9&agrave; \\-]+) aux coups critiques");
		Matcher matcherCC = patternCC.matcher(masque);
		Pattern patternPods = Pattern.compile("Augmente le poids portable de ([0-9&agrave; ]+) pods");
		Matcher matcherPods = patternPods.matcher(masque);
		Pattern patternPods2 = Pattern.compile("R&eacute;duit le poids portable de ([0-9&agrave; ]+) pods");
		Matcher matcherPods2 = patternPods2.matcher(masque);

		Pattern patternRMag = Pattern.compile("R&eacute;duction magique de ([0-9&agrave; ]+)");
		Matcher matcherRMag = patternRMag.matcher(masque);
		Pattern patternRPhy = Pattern.compile("R&eacute;duction physique de ([0-9&agrave; ]+)");
		Matcher matcherRPhy = patternRPhy.matcher(masque);
		Pattern patternRNeutre = Pattern.compile("((\\+|\\-)[0-9&agrave; \\-]+) de r&eacute;sistance neutre");
		Matcher matcherRNeutre = patternRNeutre.matcher(masque);
		Pattern patternRTerre = Pattern.compile("((\\+|\\-)[0-9&agrave; \\-]+) de r&eacute;sistance &agrave; la terre");
		Matcher matcherRTerre = patternRTerre.matcher(masque);
		Pattern patternRFeu = Pattern.compile("((\\+|\\-)[0-9&agrave; \\-]+) de r&eacute;sistance au feu");
		Matcher matcherRFeu = patternRFeu.matcher(masque);
		Pattern patternREau = Pattern.compile("((\\+|\\-)[0-9&agrave; \\-]+) de r&eacute;sistance &agrave; l'eau");
		Matcher matcherREau = patternREau.matcher(masque);
		Pattern patternRAir = Pattern.compile("((\\+|\\-)[0-9&agrave; \\-]+) de r&eacute;sistance &agrave; l'air");
		Matcher matcherRAir = patternRAir.matcher(masque);

		Pattern patternPRNeutre = Pattern.compile("([0-9&agrave; ]+) % de r&eacute;sistance neutre");
		Matcher matcherPRNeutre = patternPRNeutre.matcher(masque);
		Pattern patternPRTerre = Pattern.compile("([0-9&agrave; ]+) % de r&eacute;sistance &agrave; la terre");
		Matcher matcherPRTerre = patternPRTerre.matcher(masque);
		Pattern patternPRFeu = Pattern.compile("([0-9&agrave; ]+) % de r&eacute;sistance au feu");
		Matcher matcherPRFeu = patternPRFeu.matcher(masque);
		Pattern patternPREau = Pattern.compile("([0-9&agrave; ]+) % de r&eacute;sistance &agrave; l'eau");
		Matcher matcherPREau = patternPREau.matcher(masque);
		Pattern patternPRAir = Pattern.compile("([0-9&agrave; ]+) % de r&eacute;sistance &agrave; l'air");
		Matcher matcherPRAir = patternPRAir.matcher(masque);

		Pattern patternFPRNeutre = Pattern.compile("([0-9&agrave; ]+) % de faiblesse neutre");
		Matcher matcherFPRNeutre = patternFPRNeutre.matcher(masque);
		Pattern patternFPRTerre = Pattern.compile("([0-9&agrave; ]+) % de faiblesse face &agrave; la terre");
		Matcher matcherFPRTerre = patternFPRTerre.matcher(masque);
		Pattern patternFPRFeu = Pattern.compile("([0-9&agrave; ]+) % de faiblesse face au feu");
		Matcher matcherFPRFeu = patternFPRFeu.matcher(masque);
		Pattern patternFPREau = Pattern.compile("([0-9&agrave; ]+) % de faiblesse face &agrave; l'eau ");
		Matcher matcherFPREau = patternFPREau.matcher(masque);
		Pattern patternFPRAir = Pattern.compile("([0-9&agrave; ]+) % de faiblesse face &agrave; l'air");
		Matcher matcherFPRAir = patternFPRAir.matcher(masque);

		Pattern patternRenvois = Pattern.compile("Renvoie ([0-9]+) dommages");
		Matcher matcherRenvois = patternRenvois.matcher(masque);
		Pattern patternEC = Pattern.compile("((\\+|\\-)[0-9&agrave; \\-]+) aux &eacute;checs critiques");
		Matcher matcherEC = patternEC.matcher(masque);

		Pattern patternRNeutrePvp = Pattern.compile("((\\+|\\-)[0-9&agrave; \\-]+) de res. neutre aux combattants");
		Matcher matcherRNeutrePvp = patternRNeutrePvp.matcher(masque);
		Pattern patternRTerrePvp = Pattern.compile("((\\+|\\-)[0-9&agrave; \\-]+) de res. terre face aux combattants ");
		Matcher matcherRTerrePvp = patternRTerrePvp.matcher(masque);
		Pattern patternRFeuPvp = Pattern.compile("((\\+|\\-)[0-9&agrave; \\-]+) de res. feu aux combattants");
		Matcher matcherRFeuPvp = patternRFeuPvp.matcher(masque);
		Pattern patternREauPvp = Pattern.compile("((\\+|\\-)[0-9&agrave; \\-]+) de res. eau face aux combattants ");
		Matcher matcherREauPvp = patternREauPvp.matcher(masque);
		Pattern patternRAirPvp = Pattern.compile("((\\+|\\-)[0-9&agrave; \\-]+) de res. air face aux combattants");
		Matcher matcherRAirPvp = patternRAirPvp.matcher(masque);

		Pattern patternPRNeutrePvp = Pattern.compile("([0-9&agrave; ]+) % de res. neutre aux combattants");
		Matcher matcherPRNeutrePvp = patternPRNeutrePvp.matcher(masque);
		Pattern patternPRTerrePvp = Pattern.compile("([0-9&agrave; ]+) % de res. terre face aux combattants ");
		Matcher matcherPRTerrePvp = patternPRTerrePvp.matcher(masque);
		Pattern patternPRFeuPvp = Pattern.compile("([0-9&agrave; ]+) % de res. feu face aux combattants");
		Matcher matcherPRFeuPvp = patternPRFeuPvp.matcher(masque);
		Pattern patternPREauPvp = Pattern.compile("([0-9&agrave; ]+) % de res. eau face aux combattants");
		Matcher matcherPREauPvp = patternPREauPvp.matcher(masque);
		Pattern patternPRAirPvp = Pattern.compile("([0-9&agrave; ]+) % de res. air face aux combattants");
		Matcher matcherPRAirPvp = patternPRAirPvp.matcher(masque);

		Matcher[] matchers = new Matcher[] { matcherVie, matcherPA, matcherPM, matcherPO, matcherIni, matcherPP, matcherVita, matcherSag, matcherForce, matcherInt, matcherChance, matcherAgi, matcherDom, matcherPDom, matcherPiege, matcherPPiege, matcherCC, matcherSoins, matcherInvoc, matcherPods, matcherRMag, matcherRPhy, matcherRNeutre, matcherRTerre, matcherRFeu, matcherREau, matcherRAir, matcherPRNeutre, matcherPRTerre, matcherPRFeu, matcherPREau, matcherPRAir, matcherFPRNeutre, matcherFPRTerre, matcherFPRFeu, matcherFPREau, matcherFPRAir, matcherRenvois, matcherEC, matcherRNeutrePvp, matcherRTerrePvp, matcherRFeuPvp, matcherREauPvp, matcherRAirPvp, matcherPRNeutrePvp, matcherPRTerrePvp, matcherPRFeuPvp, matcherPREauPvp, matcherPRAirPvp, matcherPMPerdus, matcherPods2, matcherPAPerdus };

		boolean trouve = false;
		for(int i = 0; i < matchers.length; i++)
		{
			if(matchers[i].matches())
			{
				Pattern pattern = Pattern.compile("(\\+|\\-)?([0-9]+)( &agrave; (\\+|\\-)?([0-9]+))?");
				Matcher matcher = pattern.matcher(matchers[i].group(1));
				if(matcher.matches())
				{
					int resMini = 0;
					int resMaxi = 0;

					// Génération des nombres négatifs
					if(matcher.group(3) != null)
					{
						if((matcher.group(1) == null) || matcher.group(1).equals("+"))
						{
							resMini = Integer.parseInt(matcher.group(2));
						}
						else
						{
							resMini = Integer.parseInt("-" + matcher.group(2));
						}
						if(matcher.group(4) == null)
						{
							resMaxi = Integer.parseInt(matcher.group(5));
						}
						else
						{
							resMaxi = Integer.parseInt("-" + matcher.group(5));
						}
					}
					else
					{
						if((matcher.group(1) == null) || matcher.group(1).equals("+"))
						{
							resMini = Integer.parseInt(matcher.group(2));
							resMaxi = Integer.parseInt(matcher.group(2));
						}
						else
						{
							resMini = Integer.parseInt("-" + matcher.group(2));
							resMaxi = Integer.parseInt("-" + matcher.group(2));
						}

					}

					if(resMini > resMaxi)
					{
						int max = resMaxi;
						int min = resMini;

						resMini = max;
						resMaxi = min;
					}

					if(i == 0)
					{
						effetsMini.setInt(FlagsTypesEffets.Vie, resMini);
						effetsMaxi.setInt(FlagsTypesEffets.Vie, resMaxi);
						trouve = true;
					}
					else if(i == 1)
					{
						effetsMini.setInt(FlagsTypesEffets.Pa, resMini);
						effetsMaxi.setInt(FlagsTypesEffets.Pa, resMaxi);
						trouve = true;
					}
					else if(i == 2)
					{
						effetsMini.setInt(FlagsTypesEffets.Pm, resMini);
						effetsMaxi.setInt(FlagsTypesEffets.Pm, resMaxi);
						trouve = true;
					}
					else if(i == 3)
					{
						effetsMini.setInt(FlagsTypesEffets.Po, resMini);
						effetsMaxi.setInt(FlagsTypesEffets.Po, resMaxi);
						trouve = true;
					}
					else if(i == 4)
					{
						effetsMini.setInt(FlagsTypesEffets.Initiative, resMini);
						effetsMaxi.setInt(FlagsTypesEffets.Initiative, resMaxi);
						trouve = true;
					}
					else if(i == 5)
					{
						effetsMini.setInt(FlagsTypesEffets.Prospection, resMini);
						effetsMaxi.setInt(FlagsTypesEffets.Prospection, resMaxi);
						trouve = true;
					}
					else if(i == 6)
					{
						effetsMini.setInt(FlagsTypesEffets.Vitalite, resMini);
						effetsMaxi.setInt(FlagsTypesEffets.Vitalite, resMaxi);
						trouve = true;
					}
					else if(i == 7)
					{
						effetsMini.setInt(FlagsTypesEffets.Sagesse, resMini);
						effetsMaxi.setInt(FlagsTypesEffets.Sagesse, resMaxi);
						trouve = true;
					}
					else if(i == 8)
					{
						effetsMini.setInt(FlagsTypesEffets.Force, resMini);
						effetsMaxi.setInt(FlagsTypesEffets.Force, resMaxi);
						trouve = true;
					}
					else if(i == 9)
					{
						effetsMini.setInt(FlagsTypesEffets.Intelligence, resMini);
						effetsMaxi.setInt(FlagsTypesEffets.Intelligence, resMaxi);
						trouve = true;
					}
					else if(i == 10)
					{
						effetsMini.setInt(FlagsTypesEffets.Chance, resMini);
						effetsMaxi.setInt(FlagsTypesEffets.Chance, resMaxi);
						trouve = true;
					}
					else if(i == 11)
					{
						effetsMini.setInt(FlagsTypesEffets.Agilite, resMini);
						effetsMaxi.setInt(FlagsTypesEffets.Agilite, resMaxi);
						trouve = true;
					}
					else if(i == 12)
					{
						effetsMini.setInt(FlagsTypesEffets.Dommages, resMini);
						effetsMaxi.setInt(FlagsTypesEffets.Dommages, resMaxi);
						trouve = true;
					}
					else if(i == 13)
					{
						effetsMini.setInt(FlagsTypesEffets.PourcentagesDommages, resMini);
						effetsMaxi.setInt(FlagsTypesEffets.PourcentagesDommages, resMaxi);
						trouve = true;
					}
					else if(i == 14)
					{
						effetsMini.setInt(FlagsTypesEffets.DommagesPieges, resMini);
						effetsMaxi.setInt(FlagsTypesEffets.DommagesPieges, resMaxi);
						trouve = true;
					}
					else if(i == 15)
					{
						effetsMini.setInt(FlagsTypesEffets.PourcentagesDommagesPieges, resMini);
						effetsMaxi.setInt(FlagsTypesEffets.PourcentagesDommagesPieges, resMaxi);
						trouve = true;
					}
					else if(i == 16)
					{
						effetsMini.setInt(FlagsTypesEffets.CoupsCritiques, resMini);
						effetsMaxi.setInt(FlagsTypesEffets.CoupsCritiques, resMaxi);
						trouve = true;
					}
					else if(i == 17)
					{
						effetsMini.setInt(FlagsTypesEffets.Soins, resMini);
						effetsMaxi.setInt(FlagsTypesEffets.Soins, resMaxi);
						trouve = true;
					}
					else if(i == 18)
					{
						effetsMini.setInt(FlagsTypesEffets.CreaturesInvocables, resMini);
						effetsMaxi.setInt(FlagsTypesEffets.CreaturesInvocables, resMaxi);
						trouve = true;
					}
					else if(i == 19)
					{
						effetsMini.setInt(FlagsTypesEffets.Pods, resMini);
						effetsMaxi.setInt(FlagsTypesEffets.Pods, resMaxi);
						trouve = true;
					}
					else if(i == 20)
					{
						effetsMini.setInt(FlagsTypesEffets.ResistancesMagiques, resMini);
						effetsMaxi.setInt(FlagsTypesEffets.ResistancesMagiques, resMaxi);
						trouve = true;
					}
					else if(i == 21)
					{
						effetsMini.setInt(FlagsTypesEffets.ResistancesPhysiques, resMini);
						effetsMaxi.setInt(FlagsTypesEffets.ResistancesPhysiques, resMaxi);
						trouve = true;
					}
					else if(i == 22)
					{
						effetsMini.setInt(FlagsTypesEffets.ResistancesNeutre, resMini);
						effetsMaxi.setInt(FlagsTypesEffets.ResistancesNeutre, resMaxi);
						trouve = true;
					}
					else if(i == 23)
					{
						effetsMini.setInt(FlagsTypesEffets.ResistancesTerre, resMini);
						effetsMaxi.setInt(FlagsTypesEffets.ResistancesTerre, resMaxi);
						trouve = true;
					}
					else if(i == 24)
					{
						effetsMini.setInt(FlagsTypesEffets.ResistancesFeu, resMini);
						effetsMaxi.setInt(FlagsTypesEffets.ResistancesFeu, resMaxi);
						trouve = true;
					}
					else if(i == 25)
					{
						effetsMini.setInt(FlagsTypesEffets.ResistancesEau, resMini);
						effetsMaxi.setInt(FlagsTypesEffets.ResistancesEau, resMaxi);
						trouve = true;
					}
					else if(i == 26)
					{
						effetsMini.setInt(FlagsTypesEffets.ResistancesAir, resMini);
						effetsMaxi.setInt(FlagsTypesEffets.ResistancesAir, resMaxi);
						trouve = true;
					}
					else if(i == 27)
					{
						effetsMini.setInt(FlagsTypesEffets.PourcentagesResistancesNeutre, resMini);
						effetsMaxi.setInt(FlagsTypesEffets.PourcentagesResistancesNeutre, resMaxi);
						trouve = true;
					}
					else if(i == 28)
					{
						effetsMini.setInt(FlagsTypesEffets.PourcentagesResistancesTerre, resMini);
						effetsMaxi.setInt(FlagsTypesEffets.PourcentagesResistancesTerre, resMaxi);
						trouve = true;
					}
					else if(i == 29)
					{
						effetsMini.setInt(FlagsTypesEffets.PourcentagesResistancesFeu, resMini);
						effetsMaxi.setInt(FlagsTypesEffets.PourcentagesResistancesFeu, resMaxi);
						trouve = true;
					}
					else if(i == 30)
					{
						effetsMini.setInt(FlagsTypesEffets.PourcentagesResistancesEau, resMini);
						effetsMaxi.setInt(FlagsTypesEffets.PourcentagesResistancesEau, resMaxi);
						trouve = true;
					}
					else if(i == 31)
					{
						effetsMini.setInt(FlagsTypesEffets.PourcentagesResistancesAir, resMini);
						effetsMaxi.setInt(FlagsTypesEffets.PourcentagesResistancesAir, resMaxi);
						trouve = true;
					}
					else if(i == 32)
					{
						effetsMini.setInt(FlagsTypesEffets.PourcentagesResistancesNeutre, -resMini);
						effetsMaxi.setInt(FlagsTypesEffets.PourcentagesResistancesNeutre, -resMaxi);
						trouve = true;
					}
					else if(i == 33)
					{
						effetsMini.setInt(FlagsTypesEffets.PourcentagesResistancesTerre, -resMini);
						effetsMaxi.setInt(FlagsTypesEffets.PourcentagesResistancesTerre, -resMaxi);
						trouve = true;
					}
					else if(i == 34)
					{
						effetsMini.setInt(FlagsTypesEffets.PourcentagesResistancesFeu, -resMini);
						effetsMaxi.setInt(FlagsTypesEffets.PourcentagesResistancesFeu, -resMaxi);
						trouve = true;
					}
					else if(i == 35)
					{
						effetsMini.setInt(FlagsTypesEffets.PourcentagesResistancesEau, -resMini);
						effetsMaxi.setInt(FlagsTypesEffets.PourcentagesResistancesEau, -resMaxi);
						trouve = true;
					}
					else if(i == 36)
					{
						effetsMini.setInt(FlagsTypesEffets.PourcentagesResistancesAir, -resMini);
						effetsMaxi.setInt(FlagsTypesEffets.PourcentagesResistancesAir, -resMaxi);
						trouve = true;
					}
					else if(i == 37)
					{
						effetsMini.setInt(FlagsTypesEffets.Renvois, resMini);
						effetsMaxi.setInt(FlagsTypesEffets.Renvois, resMaxi);
						trouve = true;
					}
					else if(i == 38)
					{
						effetsMini.setInt(FlagsTypesEffets.EchecsCritiques, resMini);
						effetsMaxi.setInt(FlagsTypesEffets.EchecsCritiques, resMaxi);
						trouve = true;
					}
					else if(i == 39)
					{
						effetsMini.setInt(FlagsTypesEffets.ResistancesNeutrePvp, resMini);
						effetsMaxi.setInt(FlagsTypesEffets.ResistancesNeutrePvp, resMaxi);
						trouve = true;
					}
					else if(i == 40)
					{
						effetsMini.setInt(FlagsTypesEffets.ResistancesTerrePvp, resMini);
						effetsMaxi.setInt(FlagsTypesEffets.ResistancesTerrePvp, resMaxi);
						trouve = true;
					}
					else if(i == 41)
					{
						effetsMini.setInt(FlagsTypesEffets.ResistancesFeuPvp, resMini);
						effetsMaxi.setInt(FlagsTypesEffets.ResistancesFeuPvp, resMaxi);
						trouve = true;
					}
					else if(i == 42)
					{
						effetsMini.setInt(FlagsTypesEffets.ResistancesEauPvp, resMini);
						effetsMaxi.setInt(FlagsTypesEffets.ResistancesEauPvp, resMaxi);
						trouve = true;
					}
					else if(i == 43)
					{
						effetsMini.setInt(FlagsTypesEffets.ResistancesAirPvp, resMini);
						effetsMaxi.setInt(FlagsTypesEffets.ResistancesAirPvp, resMaxi);
						trouve = true;
					}
					else if(i == 44)
					{
						effetsMini.setInt(FlagsTypesEffets.PourcentagesResistancesNeutrePvp, resMini);
						effetsMaxi.setInt(FlagsTypesEffets.PourcentagesResistancesNeutrePvp, resMaxi);
						trouve = true;
					}
					else if(i == 45)
					{
						effetsMini.setInt(FlagsTypesEffets.PourcentagesResistancesTerrePvp, resMini);
						effetsMaxi.setInt(FlagsTypesEffets.PourcentagesResistancesTerrePvp, resMaxi);
						trouve = true;
					}
					else if(i == 46)
					{
						effetsMini.setInt(FlagsTypesEffets.PourcentagesResistancesFeuPvp, resMini);
						effetsMaxi.setInt(FlagsTypesEffets.PourcentagesResistancesFeuPvp, resMaxi);
						trouve = true;
					}
					else if(i == 47)
					{
						effetsMini.setInt(FlagsTypesEffets.PourcentagesResistancesEauPvp, resMini);
						effetsMaxi.setInt(FlagsTypesEffets.PourcentagesResistancesEauPvp, resMaxi);
						trouve = true;
					}
					else if(i == 48)
					{
						effetsMini.setInt(FlagsTypesEffets.PourcentagesResistancesAirPvp, resMini);
						effetsMaxi.setInt(FlagsTypesEffets.PourcentagesResistancesAirPvp, resMaxi);
						trouve = true;
					}
					else if(i == 49)
					{
						effetsMini.setInt(FlagsTypesEffets.Pm, -resMini);
						effetsMaxi.setInt(FlagsTypesEffets.Pm, -resMaxi);
						trouve = true;
					}
					else if(i == 50)
					{
						effetsMini.setInt(FlagsTypesEffets.Pods, -resMini);
						effetsMaxi.setInt(FlagsTypesEffets.Pods, -resMaxi);
						trouve = true;
					}
					else if(i == 51)
					{
						effetsMini.setInt(FlagsTypesEffets.Pa, -resMini);
						effetsMaxi.setInt(FlagsTypesEffets.Pa, -resMaxi);
						trouve = true;
					}
				}
				else
				{
					break;
				}
			}
		}

		if(!trouve)
		{
			System.err.println("Effet illisible : '" + masque + "'");
		}
	}
	
	public final static void genererConditions(String masque, ArrayList<Condition> conditions, ConditionClasse conditionClasse)
	{
		Pattern pattern = Pattern.compile("(.+) (>|<|=) (.+)");
		Matcher matcher = pattern.matcher(masque);

		if(matcher.matches())
		{
			// System.out.println(matcher4.group(1));

			if(matcher.group(1).toLowerCase().equals("classe"))
			{
				String classe = matcher.group(3);
				if(classe.equals("Xelor"))
				{
					classe = "Xélor";
				}
				else if(classe.equals("Cra"))
				{
					classe = "Crâ";
				}
				else if(classe.equals("Feca"))
				{
					classe = "Féca";
				}

				if(conditionClasse == null)
				{
					conditionClasse = new ConditionClasse(Operateur.Egal);
				}

				conditionClasse.addClasse(classe);
			}
			else
			{
				if(matcher.group(1).equals("Force") || matcher.group(1).equals("Vitalité") || matcher.group(1).equals("Agilité") || matcher.group(1).equals("Intelligence") || matcher.group(1).equals("Chance") || matcher.group(1).equals("PM") || matcher.group(1).equals("Sagesse"))
				{
					FlagsTypesEffets caracteristique = FlagsTypesEffets.getFlag(matcher.group(1));
					ConditionCaracteristique condtionCaract = new ConditionCaracteristique(Operateur.getOperateur(matcher.group(2)), caracteristique, Integer.parseInt(matcher.group(3).trim()));
					conditions.add(condtionCaract);
				}
				else if(matcher.group(1).equals("Niveau de métier"))
				{
					// ConditionNiveauMetier
					// condtionNiveauMetier = new
					// ConditionNiveauMetier(Operateur.getOperateur(matcher4.group(2)),
					// "",
					// Integer.parseInt(matcher4.group(3).trim()));
					// conditions.add(condtionNiveauMetier);
					// TODO
				}
				else if(matcher.group(1).equals("Alignement"))
				{
					ConditionAlignement condAli = new ConditionAlignement(Operateur.Egal, Alignement.getAlignement(matcher.group(3).trim()));
					conditions.add(condAli);
				}
				else if(matcher.group(1).equals("Grade"))
				{
					ConditionGrade condGrade = new ConditionGrade(Operateur.getOperateur(matcher.group(2)), Integer.parseInt(matcher.group(3).trim()));
					conditions.add(condGrade);
				}
				else if(matcher.group(1).equals("Kamas"))
				{
					ConditionKama condKama = new ConditionKama(Operateur.getOperateur(matcher.group(2)), Integer.parseInt(matcher.group(3).trim()));
					conditions.add(condKama);
				}
				else if(!masque.equals("&nbsp;"))
				{
					System.err.println("Condition illisible : '" + masque + "'");
				}
			}
		}
		else
		{
			if(masque.equals("Est du sexe masculin  "))
			{
				ConditionSexe condSexe = new ConditionSexe(Operateur.Egal, Sexe.Masculin);
				conditions.add(condSexe);
			}
			else if(masque.equals("Est du sexe feminin  "))
			{
				ConditionSexe condSexe = new ConditionSexe(Operateur.Egal, Sexe.Feminin);
				conditions.add(condSexe);
			}
			else if(!masque.equals("&nbsp;"))
			{
				System.err.println("Condition illisible : '" + masque + "'");
			}
		}
	}
}