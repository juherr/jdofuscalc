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
 * Dégâts d'une arme
 * 
 * @author PAPAYA Alexandre
 * @category Dofus
 * @version 1.0
 */
public class DegatsArme extends Degats
{
	/*
	 * Variables d'instances
	 */
	
	/**
	 * Nature des dégâts.
	 */
	private String nature;

	/**
	 * Elément des dégats.
	 */
	private String element;

	/*
	 * Constructeurs / Destructeur
	 */

	/**
	 * Construit de nouveaux dégâts d'amres.
	 * 
	 * @category Constructeur
	 */
	public DegatsArme()
	{
		super();
	}
	
	/*
	 * Accesseurs
	 */

	/**
	 * Renvoie la nature des dégâts sous forme chaine de caractères.
	 * 
	 * @return Retourne soit {@code vole}, soit {@code dommages}, soit {@code soins}.
	 * @category Accesseur
	 */
	public String getNature()
	{
		if(this.nature == null)
		{
			int sommeDommages = this.degats.get(FlagsTypesDegats.DegatsNeutreMax) + this.degats.get(FlagsTypesDegats.DegatsTerreMax) + this.degats.get(FlagsTypesDegats.DegatsFeuMax) + this.degats.get(FlagsTypesDegats.DegatsEauMax) + this.degats.get(FlagsTypesDegats.DegatsAirMax);
			int sommeVoles = this.degats.get(FlagsTypesDegats.VoleNeutreMax) + this.degats.get(FlagsTypesDegats.VoleTerreMax) + this.degats.get(FlagsTypesDegats.VoleFeuMax) + this.degats.get(FlagsTypesDegats.VoleEauMax) + this.degats.get(FlagsTypesDegats.VoleAirMax);
			if(sommeDommages > 0)
			{
				this.nature = "dommages";
			}
			else if(sommeVoles > 0)
			{
				this.nature = "vole";
			}
			else if(this.degats.get(FlagsTypesDegats.SoinsMax) > 0)
			{
				this.nature = "soins";
			}
			else
			{
				System.err.println("Nature des dégâts inconnue.");
			}
		}
		
		return this.nature;
	}

	/**
	 * Renvoie l'élément des dégâts sous forme chaine de caractères.
	 * 
	 * @return Retourne soit {@code neutre}, soit {@code terre}, soit {@code feu},
	 * 		soit {@code eau}, soit {@code air} ou {@code null} si la nature est {@code soins}.
	 * @category Accesseur
	 */
	public String getElement()
	{		
		if(this.getNature().equals("soins"))
		{
			this.element = null;
		}
		else if(this.element == null)
		{
			if(this.nature.equals("dommages"))
			{
				if(this.degats.get(FlagsTypesDegats.DegatsNeutreMax) > 0)
				{
					this.element = "neutre";
				}
				else if(this.degats.get(FlagsTypesDegats.DegatsTerreMax) > 0)
				{
					this.element = "terre";
				}
				else if(this.degats.get(FlagsTypesDegats.DegatsFeuMax) > 0)
				{
					this.element = "feu";
				}
				else if(this.degats.get(FlagsTypesDegats.DegatsEauMax) > 0)
				{
					this.element = "eau";
				}
				else if(this.degats.get(FlagsTypesDegats.DegatsAirMax) > 0)
				{
					this.element = "air";
				}
				else
				{
					this.element = null;
				}
			}
			else
			{
				if(this.degats.get(FlagsTypesDegats.VoleNeutreMax) > 0)
				{
					this.element = "neutre";
				}
				else if(this.degats.get(FlagsTypesDegats.VoleTerreMax) > 0)
				{
					this.element = "terre";
				}
				else if(this.degats.get(FlagsTypesDegats.VoleFeuMax) > 0)
				{
					this.element = "feu";
				}
				else if(this.degats.get(FlagsTypesDegats.VoleEauMax) > 0)
				{
					this.element = "eau";
				}
				else if(this.degats.get(FlagsTypesDegats.VoleAirMax) > 0)
				{
					this.element = "air";
				}
				else
				{
					this.element = null;
				}
			}
		}

		return this.element;
	}

	/**
	 * Renvoie la valeur minimum des dégâts.
	 * 
	 * @return La valeur minimum.
	 * @category Accesseur
	 */
	public int getMinimum()
	{
		if(this.getNature().equals("dommages"))
		{
			return this.degats.get(FlagsTypesDegats.getFlag("Dégâts " + this.getElement() + " minimums"));
		}
		else if(this.getNature().equals("vole"))
		{
			return this.degats.get(FlagsTypesDegats.getFlag("Vols de vie " + this.getElement() + " minimums"));
		}
		else
		{
			return this.degats.get(FlagsTypesDegats.SoinsMin);
		}
	}

	/**
	 * Retourne la valeur maximum des dégâts.
	 * 
	 * @return La valeur maximum.
	 * @category Accesseur
	 */
	public int getMaximum()
	{
		if(this.getNature().equals("dommages"))
		{
			return this.degats.get(FlagsTypesDegats.getFlag("Dégâts " + this.getElement() + " maximums"));
		}
		else if(this.getNature().equals("vole"))
		{
			return this.degats.get(FlagsTypesDegats.getFlag("Vols de vie " + this.getElement() + " maximums"));
		}
		else
		{
			return this.degats.get(FlagsTypesDegats.SoinsMax);
		}
	}
}