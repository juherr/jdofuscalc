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
 * les caractéristiques, ect. Ce logiciel est programmé en java et utilise des
 * bibliothèques dont les licences sont en accord avec celle de ce logiciel.
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

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import fr.ayapap.ASQL;
import fr.ayapap.ASQLRequete;

/**
 * Classe représentant les paliers de caractéristiques des classe.
 * 
 * @author PAPAYA Alexandre
 * @category Dofus
 * @version 1.0
 */
public class Paliers
{
	/*
	 * Constantes et enums
	 */
	
	/**
	 * Enum des paliers disponibles.
	 * 
	 * @author PAPAYA Alexandre
	 * @category Dofus
	 * @version 1.0
	 */
	public enum TypePalier
	{
		Null(0),
		UnPourDeux(0.5),
		UnPourUn(1),
		DeuxPourUn(2),
		TroisPourUn(3),
		QuatrePourUn(4),
		CinqPourUn(5);

		/**
		 * Valeur du palier.
		 */
		private double valeur;

		/*
		 * Constructeurs / Destructeur
		 */

		/**
		 * Construit un nouvel alignement.
		 * 
		 * @param valeur - Valeur du palier.
		 * @category Constructeur
		 */
		private TypePalier(double valeur)
		{
			this.valeur = valeur;
		}

		/*
		 * Accesseurs
		 */
		
		/**
		 * Renvoie le palier précedent.
		 * 
		 * @return Le palier précédent.
		 * @category Accesseur
		 */
		public final TypePalier getPrecedent()
		{
			if(this == TypePalier.CinqPourUn)
			{
				return TypePalier.QuatrePourUn;
			}
			else if(this == TypePalier.QuatrePourUn)
			{
				return TypePalier.TroisPourUn;
			}
			else if(this == TypePalier.TroisPourUn)
			{
				return TypePalier.DeuxPourUn;
			}
			else if(this == TypePalier.DeuxPourUn)
			{
				return TypePalier.UnPourUn;
			}
			else if(this == TypePalier.UnPourUn)
			{
				return TypePalier.UnPourDeux;
			}
			else if(this == TypePalier.UnPourDeux)
			{
				return TypePalier.Null;
			}
			else
			{
				return null;
			}
		}

		/**
		 * Renvoie le palier suivant.
		 * 
		 * @return Le palier suivant.
		 * @category Accesseur
		 */
		public final TypePalier getSuivant()
		{
			if(this == TypePalier.CinqPourUn)
			{
				return TypePalier.Null;
			}
			else if(this == TypePalier.QuatrePourUn)
			{
				return TypePalier.CinqPourUn;
			}
			else if(this == TypePalier.TroisPourUn)
			{
				return TypePalier.QuatrePourUn;
			}
			else if(this == TypePalier.DeuxPourUn)
			{
				return TypePalier.TroisPourUn;
			}
			else if(this == TypePalier.UnPourUn)
			{
				return TypePalier.DeuxPourUn;
			}
			else if(this == TypePalier.UnPourDeux)
			{
				return TypePalier.UnPourUn;
			}
			else
			{
				return null;
			}
		}

		/**
		 * Renvoie la valeur du palier.
		 * 
		 * @return La valeur du palier.
		 * @category Accesseur
		 */
		public final double getValeur()
		{
			return this.valeur;
		}
	}
	
	/*
	 * Variables d'instances
	 */

	/**
	 * HashMap des paliers.
	 */
	private HashMap<TypePalier, Integer> paliers;

	/*
	 * Constructeurs / Destructeur
	 */

	/**
	 * Construit de nouveaux paliers.
	 * 
	 * @category Constructeur
	 */
	public Paliers()
	{
		this.paliers = new HashMap<TypePalier, Integer>();
		this.paliers.put(TypePalier.Null, 0);
		this.paliers.put(TypePalier.UnPourDeux, 0);
		this.paliers.put(TypePalier.UnPourUn, 0);
		this.paliers.put(TypePalier.DeuxPourUn, 0);
		this.paliers.put(TypePalier.TroisPourUn, 0);
		this.paliers.put(TypePalier.QuatrePourUn, 0);
		this.paliers.put(TypePalier.CinqPourUn, 0);
	}
	
	/*
	 * Méthodes de paramètrage de l'instance
	 */

	/**
	 * Charge l'objet à partir d'un ResultSet.
	 * 
	 * @param res - ResultSet de la requête avec jointure.
	 * @param prefix - Prefix de la table des champs de la jointure.
	 * @return Retourne l'objet.
	 */
	public void charger(ResultSet res, String prefix)
	{
		try
		{
			this.paliers.put(TypePalier.UnPourDeux, res.getInt(prefix + "_" + "UN_POUR_DEUX"));
			this.paliers.put(TypePalier.UnPourUn, res.getInt(prefix + "_" + "UN_POUR_UN"));
			this.paliers.put(TypePalier.DeuxPourUn, res.getInt(prefix + "_" + "DEUX_POUR_UN"));
			this.paliers.put(TypePalier.TroisPourUn, res.getInt(prefix + "_" + "TROIS_POUR_UN"));
			this.paliers.put(TypePalier.QuatrePourUn, res.getInt(prefix + "_" + "QUATRE_POUR_UN"));
			this.paliers.put(TypePalier.CinqPourUn, res.getInt(prefix + "_" + "CINQ_POUR_UN"));
		}
		catch(SQLException exception)
		{
			ASQL.erreur(exception);
		}
	}
	
	/**
	 * Sauvegarde l'instance de l'objet dans une base de données.
	 * 
	 * @param bdd - Connexion à la base de données.
	 * @return Retourne l'id de objet.
	 */
	public int sauvegarder(ASQL bdd)
	{
		try
		{
			String requete = "INSERT INTO PALIERS VALUES(null, " + this.paliers.get(TypePalier.UnPourDeux) + ", " + this.paliers.get(TypePalier.UnPourUn) + ", " + this.paliers.get(TypePalier.DeuxPourUn) + ", " + this.paliers.get(TypePalier.TroisPourUn) + ", " + this.paliers.get(TypePalier.QuatrePourUn) + ", " + this.paliers.get(TypePalier.CinqPourUn) + ")";
			ASQLRequete req = bdd.requete(requete, true);
			req.getClefs().next();
			return (int) req.getClefs().getLong(1);
		}
		catch(SQLException e)
		{
			ASQL.erreur(e);
			return -1;
		}
	}
	
	/*
	 * Méthodes
	 */
	
	/**
	 * Retourne le nombres de points de boost que couterais la passage de la
	 * {@code valeurActuelle} à la {@code valeurPrevue} en fonction
	 * des paliers définis de la caractéristique.
	 * 
	 * @param valeurActuelle - Valeur actuelle de la caractéristiques.
	 * @param valeurPrevue - Valeur prevue de la caractéristiques.
	 * @return Le nombre de points de boost nécessaires pour atteindre la {@ valeurPrevue} de la caractéristique.
	 */
	public int calculerCout(int valeurActuelle, int valeurPrevue)
	{
		if((valeurActuelle < 0) || (valeurPrevue < 0))
		{
			return 0;
		}

		if(valeurActuelle > valeurPrevue)
		{
			return 0;
		}

		TypePalier palierEnCours = TypePalier.UnPourDeux;
		double cout = 0;
		int i = valeurActuelle;
		while(i < valeurPrevue)
		{
			i++;

			// Tant que le palier en cours n'est pas défini, on prend le suivant
			while(this.paliers.get(palierEnCours) == 0)
			{
				palierEnCours = palierEnCours.getSuivant();
			}

			// Tant que le palier est depassé, on prend le suivant
			while((this.paliers.get(palierEnCours) != -1) && (i > this.paliers.get(palierEnCours)))
			{
				palierEnCours = palierEnCours.getSuivant();
			}

			// Augmentation des coûts
			cout += palierEnCours.getValeur();
		}

		return (int) Math.ceil(cout);
	}
	
	/*
	 * Accesseurs
	 */

	/**
	 * Renvoie la valeur du palier {@code palier}.
	 * 
	 * @param palier - Le palier.
	 * @return La valeur du palier {@code palier}.
	 * @category Accesseur
	 */
	public final int getPalier(TypePalier palier)
	{
		return this.paliers.get(palier);
	}

	/**
	 * Renvoie une chaine de caractère caractérisant le palier {@code palier}.
	 * 
	 * @param palier - Le palier.
	 * @return Une chaine de caractère caractérisant le palier {@code palier}.
	 * @category Accesseur
	 */
	public final String getString(TypePalier palier)
	{
		if(this.paliers.get(palier) == 0)
		{
			return "";
		}

		if(this.paliers.get(palier) == -1)
		{
			return String.valueOf((this.paliers.get(palier.getPrecedent()) + 1)).concat(" et +");
		}
		else
		{
			return String.valueOf((this.paliers.get(palier.getPrecedent()) + 1)).concat(" à ").concat(String.valueOf((this.paliers.get(palier))));
		}
	}

	/**
	 * Définit le palier {@code palier}.
	 * 
	 * @param palier - Le palier.
	 * @param valeur - La valeur du palier.
	 * @category Accesseur
	 */
	public final void setPalier(TypePalier palier, int valeur)
	{
		if(valeur == -1)
		{
			this.paliers.put(palier, -1);
		}

		if(valeur >= 0)
		{
			this.paliers.put(palier, valeur);
		}
	}

	/**
	 * Définit un palier.
	 * 
	 * @param valeur - Valeur du palier.
	 * @category Accesseur
	 */
	public final void setPalierCinqPourUn(int valeur)
	{
		this.setPalier(TypePalier.CinqPourUn, valeur);
	}

	/**
	 * Définit un palier.
	 * 
	 * @param valeur - Valeur du palier.
	 * @category Accesseur
	 */
	public final void setPalierDeuxPourUn(int valeur)
	{
		this.setPalier(TypePalier.DeuxPourUn, valeur);
	}

	/**
	 * Définit un palier.
	 * 
	 * @param valeur - Valeur du palier.
	 * @category Accesseur
	 */
	public final void setPalierQuatrePourUn(int valeur)
	{
		this.setPalier(TypePalier.QuatrePourUn, valeur);
	}

	/**
	 * Définit un palier.
	 * 
	 * @param valeur - Valeur du palier.
	 * @category Accesseur
	 */
	public final void setPalierTroisPourUn(int valeur)
	{
		this.setPalier(TypePalier.TroisPourUn, valeur);
	}

	/**
	 * Définit un palier.
	 * 
	 * @param valeur - Valeur du palier.
	 * @category Accesseur
	 */
	public final void setPalierUnPourDeux(int valeur)
	{
		this.setPalier(TypePalier.UnPourDeux, valeur);
	}

	/**
	 * Définit un palier.
	 * 
	 * @param valeur - Valeur du palier.
	 * @category Accesseur
	 */
	public final void setPalierUnPourUn(int valeur)
	{
		this.setPalier(TypePalier.UnPourUn, valeur);
	}
}