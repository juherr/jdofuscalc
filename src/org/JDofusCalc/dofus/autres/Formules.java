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

package org.JDofusCalc.dofus.autres;

/**
 * Implémentation des formules utilisées par le jeu.
 * 
 * @author PAPAYA Alexandre
 * @category Dofus
 * @version 1.0
 */
public final class Formules
{
	/*
	 * Enums
	 */
	
	/**
	 * Enum des potion de forgemagie disponibles.
	 *
	 * @author PAPAYA Alexandre
	 * @category Formules
	 * @version 1.0
	 */
	public enum Potion
	{
		/**
		 * Potion de faible puissance.
		 */
		Faible(1/2),
		/**
		 * Potion de puissance moyenne.
		 */
		Moyenne(17/25),
		/**
		 * Potion de forte puissance.
		 */
		Forte(17/20);

		/**
		 * Valeur de la potion.
		 */
		private double valeur;

		/*
		 * Constructeurs / Destructeur
		 */

		/**
		 * Construit une nouvelle potion.
		 * 
		 * @param valeur - Valeur de la potion.
		 * @category Constructeur
		 */
		private Potion(double valeur)
		{
			this.valeur = valeur;
		}

		/*
		 * Accesseurs
		 */
		
		/**
		 * Renvoie {@code valeur}.
		 * 
		 * @return La valeur de la potion.
		 * @category Accesseur
		 */
		public double getValeur()
		{
			return this.valeur;
		}
	}
	
	/**
	 * Enum des potion de forgemagie disponibles.
	 *
	 * @author PAPAYA Alexandre
	 * @category Formules
	 * @version 1.0
	 */
	public enum TauxPunition
	{
		/**
		 * Taux de Punition en coup normal.
		 */
		CoupNormal(30),
		/**
		 * Taux de Punition en coup critique.
		 */
		CoupCritique(35);

		/**
		 * Valeur du taux de la punition.
		 */
		private int valeur;

		/*
		 * Constructeurs / Destructeur
		 */

		/**
		 * Construit un nouveau taux de Punition.
		 * 
		 * @param valeur - Valeur du taux.
		 * @category Constructeur
		 */
		private TauxPunition(int valeur)
		{
			this.valeur = valeur;
		}

		/*
		 * Accesseurs
		 */
		
		/**
		 * Renvoie {@code valeur}.
		 * 
		 * @return La valeur de la potion.
		 * @category Accesseur
		 */
		public int getValeur()
		{
			return this.valeur;
		}
	}

	/*
	 * Méthode statiques
	 */
	
	/**
	 * Calcule l'agilité nécessaire pour arriver au taux de coups critiques voulu à partir du taux de coups critiques de base et des bonus en coups critiques.
	 * 
	 * @param coupsCritiquesBase - Probabilité de faire un coup critique de base.
	 * @param bonusCoupsCritiques - Bonus de coups critiques.
	 * @param coupsCriquesFinaux - Probabilité voulue.
	 * @return
	 */
	public final static long getAgilite(int coupsCritiquesBase, int bonusCoupsCritiques, int coupsCriquesFinaux)
	{
		int coupsCritiques = coupsCritiquesBase - bonusCoupsCritiques;

		if(coupsCritiques == coupsCriquesFinaux)
		{
			return 0;
		}

		if(coupsCritiques < coupsCriquesFinaux)
		{
			return 0;
		}

		long agilite = Math.round(Math.exp(coupsCritiques / (coupsCriquesFinaux + 0.9999) * Math.E * 1.1) - 12);

		return agilite;
	}

	/**
	 * Calcule la probabilité de faire un coup critique.
	 * 
	 * @param coupsCritiquesBase - Probabilité de faire un coup critique de base.
	 * @param agilite - Agilité du personnage.
	 * @param bonusCoupsCritiques - Bonus de coups critiques.
	 * @return La probabilité de faire un coup critique.
	 */
	public final static int getCoupsCritiques(int coupsCritiquesBase, int agilite, int bonusCoupsCritiques)
	{
		int coupsCritiques = coupsCritiquesBase - bonusCoupsCritiques;

		if(agilite >= 8)
		{
			coupsCritiques = (int) Math.floor((coupsCritiques * Math.E * 1.1) / Math.log(agilite + 12));
		}

		if(coupsCritiques < 2)
		{
			return 2;
		}
		else
		{
			return coupsCritiques;
		}
	}

	/**
	 * <p>Calcule les dégâts d'une arme.<br />
	 * Formule : <blockquote>Dégâts = ((Base * (Bonus Maîtrise + Malus de Classe) / 100)) * (1 + (Caractéristiques + % Dommages) / 100) * ((100 - % Résistances) / 100) - Résistances Fixe</blockquote></p>
	 * 
	 * @param degatsBase - Dégâts de base de l'arme.
	 * @param caracteristique - Caractéristique influant sur les dégâts de l'arme.
	 * @param niveauMaitrise - Niveau de la maîtrise de l'arme.
	 * @param coupCritiqueMaitrise - Passez {@code true} pour activer le coup critique de la maîtrise.
	 * @param malusClasse - Taux d'efficacité de l'arme par rapport à la classe du personnage.
	 * @param pourcentageDommages - Bonus de % de dommages.
	 * @param dommages - Bonus de dommages.
	 * @param pourcentageResistances - Résistances flottantes influant sur les dégâts de l'arme.
	 * @param resistances - Résistances fixes influant sur les dégâts de l'arme.
	 * @return Les dégâts de l'arme.
	 */
	public final static int getDegatsArme(int degatsBase, int caracteristique, int niveauMaitrise, boolean coupCritiqueMaitrise, int malusClasse, int pourcentageDommages, int dommages, int pourcentageResistances, int resistances)
	{
		if(degatsBase != 0)
		{
			if(caracteristique < 0)
			{
				caracteristique = 0;
			}
			if(dommages < 0)
			{
				dommages = 0;
			}

			if(pourcentageResistances > 100)
			{
				pourcentageResistances = 100;
			}

			int bonusMaitrise = 0;
			if(niveauMaitrise == 1)
			{
				bonusMaitrise = 10;
			}
			else if(niveauMaitrise == 2)
			{
				bonusMaitrise = 15;
			}
			else if(niveauMaitrise == 3)
			{
				bonusMaitrise = 20;
			}
			else if(niveauMaitrise == 4)
			{
				bonusMaitrise = 25;
			}
			else if(niveauMaitrise == 5)
			{
				bonusMaitrise = 30;
			}
			else if(niveauMaitrise == 6)
			{
				bonusMaitrise = 35;
			}

			if(coupCritiqueMaitrise && (bonusMaitrise != 0))
			{
				bonusMaitrise += 5;
			}

			int degats = (int) Math.floor((Math.floor(Math.floor((double) degatsBase * (double) (bonusMaitrise + malusClasse) / 100) * (1 + (double) (caracteristique + pourcentageDommages) / (double) 100)) + dommages) * ((double) (100 - pourcentageResistances) / (double) 100)) - resistances;

			if(degats < 0)
			{
				degats = 0;
			}

			return degats;

		}
		else
		{
			return 0;
		}
	}

	/**
	 * <p>Calcule les dégâts d'une arme en coup critique.<br />
	 * Formule : <blockquote>Dégâts = (((Base + Bonus Coup Critique) * (Bonus Maîtrise + Malus de Classe) / 100)) * (1 + (Caractéristiques + % Dommages) / 100) * ((100 - % Résistances) / 100) - Résistances Fixe</blockquote></p>
	 * 
	 * @param degatsBase - Dégâts de base de l'arme.
	 * @param bonusCoupsCritiques - Bonus de dégâts en coup critique.
	 * @param caracteristique - Caractéristique influant sur les dégâts de l'arme.
	 * @param niveauMaitrise - Niveau de la maîtrise de l'arme.
	 * @param coupCritiqueMaitrise - Passez {@code true} pour activer le coup critique de la maîtrise.
	 * @param malusClasse - Taux d'efficacité de l'arme par rapport à la classe du personnage.
	 * @param pourcentageDommages - Bonus de % de dommages.
	 * @param dommages - Bonus de dommages.
	 * @param pourcentageResistances - Résistances flottantes influant sur les dégâts de l'arme.
	 * @param resistances - Résistances fixes influant sur les dégâts de l'arme.
	 * @return Les dégâts de l'arme en coup critique.
	 */
	public final static int getDegatsArme(int degatsBase, int bonusCoupsCritiques, int caracteristique, int niveauMaitrise, boolean coupCritiqueMaitrise, int malusClasse, int pourcentageDommages, int dommages, int pourcentageResistances, int resistances)
	{
		if(degatsBase > 0)
		{
			return Formules.getDegatsArme(degatsBase + bonusCoupsCritiques, caracteristique, niveauMaitrise, coupCritiqueMaitrise, malusClasse, pourcentageDommages, dommages, pourcentageResistances, resistances);
		}
		else
		{
			return 0;
		}
	}

	/**
	 * Calcule les dégâts d'un sort.
	 * 
	 * @param degatsBase - Dégâts de base du sort.
	 * @param caracteristique - Caractéristique influant sur les dégâts du sort.
	 * @param pourcentageDommages - Bonus de % de dommages.
	 * @param dommages - Bonus de dommages.
	 * @param pourcentageResistances - Résistances flottantes influant sur les dégâts du sort.
	 * @param resistances - Résistances fixes influant sur les dégâts du sort.
	 * @return Les dégâts du sort.
	 */
	public final static int getDegatsSort(int degatsBase, int caracteristique, int pourcentageDommages, int dommages, int pourcentageResistances, int resistances)
	{
		if(degatsBase != 0)
		{
			if(caracteristique < 0)
			{
				caracteristique = 0;
			}
			if(dommages < 0)
			{
				dommages = 0;
			}

			if(pourcentageResistances > 100)
			{
				pourcentageResistances = 100;
			}

			int degats = (int) Math.floor((Math.floor(degatsBase * (double) (100 + caracteristique + pourcentageDommages) / 100) + dommages) * ((double) (100 - pourcentageResistances) / (double) 100)) - resistances;

			if(degats < 0)
			{
				degats = 0;
			}

			return degats;
		}
		else
		{
			return 0;
		}
	}

	/**
	 * Calcul la probabilité d'esquive des pertes de PA et PM.
	 * 
	 * @param sagesse - Sagesse du personnage.
	 * @return La probabilité d'esquive des pertes de PA et PM en %.
	 */
	public final static int getEsquives(int sagesse)
	{
		return (int) Math.floor(sagesse / 4);
	}

	/**
	 * Calcule l'initiative du personnage.
	 * 
	 * @param pdv - Points de vie du personnage.
	 * @param vitalite - Vitalité de base du personnage.
	 * @param bonus - Bonus d'initiative apportés par l'équipement.
	 * @param sacrieur - Passer {@code true} pour calculer l'initiative d'un sacrieur.
	 * @return L'initiative du personnage.
	 */
	public final static int getInitiative(int pdv, int vitalite, int bonus, boolean sacrieur)
	{
		if(bonus < 0)
		{
			bonus = 0;
		}

		int coefficientDiviseur = 4;
		// Si le personnage est un sacrieur
		if(sacrieur)
			coefficientDiviseur = 8;
		
		int initiative = (int) (((double) (pdv - vitalite) / 4) + ((double) (vitalite) / coefficientDiviseur) + bonus);

		// Majoration à 1
		if(initiative <= 0)
		{
			initiative = 1;
		}

		return initiative;
	}

	/**
	 * Calcule le jet maximum d'une arme après forgemagie.
	 * 
	 * @param jetBaseMinimum - Jet minimum de base de l'arme.
	 * @param jetBaseMaximum - Jet maximum de base de l'arme.
	 * @param potion - Potion utilisée.
	 * @return
	 */
	public final static int getJetMaximumForgemage(int jetBaseMinimum, int jetBaseMaximum, Potion potion)
	{
		return (int) (Math.floor((jetBaseMinimum - 1) * potion.getValeur())) + (int) Math.floor((jetBaseMaximum - jetBaseMinimum + 1) * potion.getValeur());
	}

	/**
	 * Calcule le jet minimum d'une arme après forgemagie.
	 * 
	 * @param jetBase - Jet de base de l'arme.
	 * @param potion - Potion utilisée.
	 * @return
	 */
	public final static int getJetMinimumForgemage(int jetBase, Potion potion)
	{
		return (int) (Math.floor((jetBase - 1) * potion.getValeur())) + 1;
	}

	/**
	 * Calcule les soins.
	 * 
	 * @param soinsBase - Soins de base.
	 * @param intelligence - Intelligence du personnage.
	 * @param bonusSoins - Bonus de soins.
	 * @return Les soins générés.
	 */
	public final static int getSoins(int soinsBase, int intelligence, int bonusSoins)
	{
		if(soinsBase != 0)
		{
			if(intelligence < 0)
			{
				intelligence = 0;
			}
			if(bonusSoins < 0)
			{
				bonusSoins = 0;
			}

			return (int) Math.floor(soinsBase * (double) (100 + intelligence) / 100) + bonusSoins;
		}
		else
		{
			return 0;
		}
	}

	/**
	 * Calcule les soins en coup critique.
	 * 
	 * @param soinsBase - Soins de base.
	 * @param bonusCoupsCritiques - Bonus en coup critique.
	 * @param intelligence - Intelligence du personnage.
	 * @param bonusSoins - Bonus de soins.
	 * @return Les soins générés en coup critique.
	 */
	public final static int getSoins(int soinsBase, int bonusCoupsCritiques, int intelligence, int bonusSoins)
	{
		if(soinsBase > 0)
		{
			return Formules.getSoins(soinsBase + bonusCoupsCritiques, intelligence, bonusSoins);
		}
		else
		{
			return 0;
		}
	}

	/**
	 * Calcule la vie totale du personnage.
	 * 
	 * @param niveau - Niveau du personnage.
	 * @param vieBase - Vie de base du personnage.
	 * @param bonusVie - Bonus en vie.
	 * @param vitalite - Vitalité totale du personnage.
	 * @return La vie totale du personnage.
	 */
	public final static int getVie(int niveau, int vieBase, int bonusVie, int vitalite)
	{
		int bonusNiveau = 0;
		if(niveau > 1)
		{
			bonusNiveau = niveau * 5;
		}

		int vie = vieBase + bonusNiveau + bonusVie + vitalite;

		// Majoration à 1
		if(vie <= 0)
		{
			vie = 1;
		}

		return vie;
	}
	
	/**
	 * Calcule la probabilité de tacle ou d'esquive du personnage.
	 * 
	 * @param agilitePersonnage - Agilité du personnage.
	 * @param agiliteAdversaire - Agilité de son adversaire.
	 * @return La probabilité de tacle ou d'esquive du personnage.
	 */
	public final static int getProbabiliteTacle(int agilitePersonnage, int agiliteAdversaire)
	{
		int probabilite = (int) Math.round((300 * ((double) (agilitePersonnage + 25) / (double) (agilitePersonnage + agiliteAdversaire + 50)) - 100));
		
		if(probabilite < 0)
			probabilite = 0;
		else if(probabilite > 100)
			probabilite = 100;
		
		return probabilite;
	}
	
	/**
	 * Calcule le nombre de points d'action perdus par le personnage lors de l'échec d'une esquive de tacle.
	 * 
	 * @param pa - Points d'action du personnage.
	 * @param probabiliteEsquive - Probabilité d'esquive.
	 * @return Le nombre de points d'action perdus par le personnage?
	 */
	public final static int getNombrePATacle(int pa, int probabiliteEsquive)
	{
		if(probabiliteEsquive < 0)
			return -1;
		
		if(probabiliteEsquive >= 100)
			return 0;
		
		int nombrePA = (int) (((double) probabiliteEsquive / 200) * pa);
		
		return nombrePA;
	}
	
	/**
	 * Calcule les dégâts du sort Punition de la classe Sacrieur.
	 * 
	 * @param taux - Taux de points de dégâts par rapport à la vie maximale du personnage.
	 * @param vieMax - Vie maximale du personnage.
	 * @param vieActuelle - Vie actuelle du personnage.
	 * @param pourcentageResistancesNeutre - Résistances neutre flottantes du personnage.
	 * @param resistancesNeutre - Résistances neutre fixes du personnage.
	 * @return Les dégâts du sort.
	 */
	public final static int getDegatsPunition(int taux, int vieMax, int vieActuelle, int pourcentageResistancesNeutre, int resistancesNeutre)
	{
		return (int) (Math.floor((((double) taux / 100) * Math.pow(Math.cos(2 * Math.PI * (((double) (vieActuelle) / (double) vieMax) - 0.5)) + 1, 2)) / 4 * vieMax * ((double) (100 - pourcentageResistancesNeutre) / 100)) - resistancesNeutre);
	}
}