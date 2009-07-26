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

package org.JDofusCalc.outils.aspirateurs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import org.JDofusCalc.dofus.autres.Paliers;

import fr.ayapap.ASQL;
import fr.ayapap.ASQLRequete;

/**
 * Description
 * 
 * @author PAPAYA Alexandre
 * @category version 1.0
 */
public class AspirateurPaliersClasses
{
	public AspirateurPaliersClasses(ASQL bdd)
	{
		try
		{
			HashMap<Integer, HashMap<String, Paliers>> classe = new HashMap<Integer, HashMap<String, Paliers>>();

			// All
			Paliers paliersVita = new Paliers();
			paliersVita.setPalierUnPourUn(-1);
			Paliers paliersVitaSacri = new Paliers();
			paliersVitaSacri.setPalierUnPourDeux(-1);

			Paliers paliersSagesse = new Paliers();
			paliersSagesse.setPalierTroisPourUn(-1);

			// Cra
			HashMap<String, Paliers> paliersCra = new HashMap<String, Paliers>();
			paliersCra.put("Vitalité", paliersVita);
			paliersCra.put("Sagesse", paliersSagesse);
			Paliers paliersForceCra = new Paliers();
			paliersForceCra.setPalierUnPourUn(50);
			paliersForceCra.setPalierDeuxPourUn(150);
			paliersForceCra.setPalierTroisPourUn(250);
			paliersForceCra.setPalierQuatrePourUn(350);
			paliersForceCra.setPalierCinqPourUn(-1);
			paliersCra.put("Force", paliersForceCra);
			Paliers paliersIntCra = new Paliers();
			paliersIntCra.setPalierUnPourUn(50);
			paliersIntCra.setPalierDeuxPourUn(150);
			paliersIntCra.setPalierTroisPourUn(250);
			paliersIntCra.setPalierQuatrePourUn(350);
			paliersIntCra.setPalierCinqPourUn(-1);
			paliersCra.put("Intelligence", paliersIntCra);
			Paliers paliersChanceCra = new Paliers();
			paliersChanceCra.setPalierUnPourUn(20);
			paliersChanceCra.setPalierDeuxPourUn(40);
			paliersChanceCra.setPalierTroisPourUn(60);
			paliersChanceCra.setPalierQuatrePourUn(80);
			paliersChanceCra.setPalierCinqPourUn(-1);
			paliersCra.put("Chance", paliersChanceCra);
			Paliers paliersAgiCra = new Paliers();
			paliersAgiCra.setPalierUnPourUn(50);
			paliersAgiCra.setPalierDeuxPourUn(100);
			paliersAgiCra.setPalierTroisPourUn(150);
			paliersAgiCra.setPalierQuatrePourUn(200);
			paliersAgiCra.setPalierCinqPourUn(-1);
			paliersCra.put("Agilité", paliersAgiCra);
			classe.put(1, paliersCra);

			// Eca
			HashMap<String, Paliers> paliersEca = new HashMap<String, Paliers>();
			paliersEca.put("Vitalité", paliersVita);
			paliersEca.put("Sagesse", paliersSagesse);
			Paliers paliersForceEca = new Paliers();
			paliersForceEca.setPalierUnPourUn(100);
			paliersForceEca.setPalierDeuxPourUn(200);
			paliersForceEca.setPalierTroisPourUn(300);
			paliersForceEca.setPalierQuatrePourUn(400);
			paliersForceEca.setPalierCinqPourUn(-1);
			paliersEca.put("Force", paliersForceEca);
			Paliers paliersIntEca = new Paliers();
			paliersIntEca.setPalierUnPourUn(20);
			paliersIntEca.setPalierDeuxPourUn(40);
			paliersIntEca.setPalierTroisPourUn(60);
			paliersIntEca.setPalierQuatrePourUn(80);
			paliersIntEca.setPalierCinqPourUn(-1);
			paliersEca.put("Intelligence", paliersIntEca);
			Paliers paliersChanceEca = new Paliers();
			paliersChanceEca.setPalierUnPourUn(20);
			paliersChanceEca.setPalierDeuxPourUn(40);
			paliersChanceEca.setPalierTroisPourUn(60);
			paliersChanceEca.setPalierQuatrePourUn(80);
			paliersChanceEca.setPalierCinqPourUn(-1);
			paliersEca.put("Chance", paliersChanceEca);
			Paliers paliersAgiEca = new Paliers();
			paliersAgiEca.setPalierUnPourUn(50);
			paliersAgiEca.setPalierDeuxPourUn(100);
			paliersAgiEca.setPalierTroisPourUn(150);
			paliersAgiEca.setPalierQuatrePourUn(200);
			paliersAgiEca.setPalierCinqPourUn(-1);
			paliersEca.put("Agilité", paliersAgiEca);
			classe.put(2, paliersEca);

			// Eni
			HashMap<String, Paliers> paliersEni = new HashMap<String, Paliers>();
			paliersEni.put("Vitalité", paliersVita);
			paliersEni.put("Sagesse", paliersSagesse);
			Paliers paliersForceEni = new Paliers();
			paliersForceEni.setPalierDeuxPourUn(100);
			paliersForceEni.setPalierTroisPourUn(200);
			paliersForceEni.setPalierQuatrePourUn(300);
			paliersForceEni.setPalierCinqPourUn(-1);
			paliersEni.put("Force", paliersForceEni);
			Paliers paliersIntEni = new Paliers();
			paliersIntEni.setPalierUnPourUn(100);
			paliersIntEni.setPalierDeuxPourUn(200);
			paliersIntEni.setPalierTroisPourUn(300);
			paliersIntEni.setPalierQuatrePourUn(400);
			paliersIntEni.setPalierCinqPourUn(-1);
			paliersEni.put("Intelligence", paliersIntEni);
			Paliers paliersChanceEni = new Paliers();
			paliersChanceEni.setPalierUnPourUn(20);
			paliersChanceEni.setPalierDeuxPourUn(40);
			paliersChanceEni.setPalierTroisPourUn(60);
			paliersChanceEni.setPalierQuatrePourUn(80);
			paliersChanceEni.setPalierCinqPourUn(-1);
			paliersEni.put("Chance", paliersChanceEni);
			Paliers paliersAgiEni = new Paliers();
			paliersAgiEni.setPalierUnPourUn(20);
			paliersAgiEni.setPalierDeuxPourUn(40);
			paliersAgiEni.setPalierTroisPourUn(60);
			paliersAgiEni.setPalierQuatrePourUn(80);
			paliersAgiEni.setPalierCinqPourUn(-1);
			paliersEni.put("Agilité", paliersAgiEni);
			classe.put(3, paliersEni);

			// Enu
			HashMap<String, Paliers> paliersEnu = new HashMap<String, Paliers>();
			paliersEnu.put("Vitalité", paliersVita);
			paliersEnu.put("Sagesse", paliersSagesse);
			Paliers paliersForceEnu = new Paliers();
			paliersForceEnu.setPalierUnPourUn(50);
			paliersForceEnu.setPalierDeuxPourUn(150);
			paliersForceEnu.setPalierTroisPourUn(250);
			paliersForceEnu.setPalierQuatrePourUn(350);
			paliersForceEnu.setPalierCinqPourUn(-1);
			paliersEnu.put("Force", paliersForceEnu);
			Paliers paliersIntEnu = new Paliers();
			paliersIntEnu.setPalierUnPourUn(20);
			paliersIntEnu.setPalierDeuxPourUn(60);
			paliersIntEnu.setPalierTroisPourUn(100);
			paliersIntEnu.setPalierQuatrePourUn(140);
			paliersIntEnu.setPalierCinqPourUn(-1);
			paliersEnu.put("Intelligence", paliersIntEnu);
			Paliers paliersChanceEnu = new Paliers();
			paliersChanceEnu.setPalierUnPourUn(100);
			paliersChanceEnu.setPalierDeuxPourUn(150);
			paliersChanceEnu.setPalierTroisPourUn(230);
			paliersChanceEnu.setPalierQuatrePourUn(330);
			paliersChanceEnu.setPalierCinqPourUn(-1);
			paliersEnu.put("Chance", paliersChanceEnu);
			Paliers paliersAgiEnu = new Paliers();
			paliersAgiEnu.setPalierUnPourUn(20);
			paliersAgiEnu.setPalierDeuxPourUn(40);
			paliersAgiEnu.setPalierTroisPourUn(60);
			paliersAgiEnu.setPalierQuatrePourUn(80);
			paliersAgiEnu.setPalierCinqPourUn(-1);
			paliersEnu.put("Agilité", paliersAgiEnu);
			classe.put(4, paliersEnu);

			// Feca
			HashMap<String, Paliers> paliersFeca = new HashMap<String, Paliers>();
			paliersFeca.put("Vitalité", paliersVita);
			paliersFeca.put("Sagesse", paliersSagesse);
			Paliers paliersForceFeca = new Paliers();
			paliersForceFeca.setPalierDeuxPourUn(100);
			paliersForceFeca.setPalierTroisPourUn(200);
			paliersForceFeca.setPalierQuatrePourUn(300);
			paliersForceFeca.setPalierCinqPourUn(-1);
			paliersFeca.put("Force", paliersForceFeca);
			Paliers paliersIntFeca = new Paliers();
			paliersIntFeca.setPalierUnPourUn(100);
			paliersIntFeca.setPalierDeuxPourUn(200);
			paliersIntFeca.setPalierTroisPourUn(300);
			paliersIntFeca.setPalierQuatrePourUn(400);
			paliersIntFeca.setPalierCinqPourUn(-1);
			paliersFeca.put("Intelligence", paliersIntFeca);
			Paliers paliersChanceFeca = new Paliers();
			paliersChanceFeca.setPalierUnPourUn(20);
			paliersChanceFeca.setPalierDeuxPourUn(40);
			paliersChanceFeca.setPalierTroisPourUn(60);
			paliersChanceFeca.setPalierQuatrePourUn(80);
			paliersChanceFeca.setPalierCinqPourUn(-1);
			paliersFeca.put("Chance", paliersChanceFeca);
			Paliers paliersAgiFeca = new Paliers();
			paliersAgiFeca.setPalierUnPourUn(20);
			paliersAgiFeca.setPalierDeuxPourUn(40);
			paliersAgiFeca.setPalierTroisPourUn(60);
			paliersAgiFeca.setPalierQuatrePourUn(80);
			paliersAgiFeca.setPalierCinqPourUn(-1);
			paliersFeca.put("Agilité", paliersAgiFeca);
			classe.put(5, paliersFeca);

			// Xelor
			HashMap<String, Paliers> paliersXelor = new HashMap<String, Paliers>();
			paliersXelor.put("Vitalité", paliersVita);
			paliersXelor.put("Sagesse", paliersSagesse);
			Paliers paliersForceXelor = new Paliers();
			paliersForceXelor.setPalierDeuxPourUn(50);
			paliersForceXelor.setPalierTroisPourUn(150);
			paliersForceXelor.setPalierQuatrePourUn(250);
			paliersForceXelor.setPalierCinqPourUn(-1);
			paliersXelor.put("Force", paliersForceXelor);
			Paliers paliersIntXelor = new Paliers();
			paliersIntXelor.setPalierUnPourUn(100);
			paliersIntXelor.setPalierDeuxPourUn(200);
			paliersIntXelor.setPalierTroisPourUn(300);
			paliersIntXelor.setPalierQuatrePourUn(400);
			paliersIntXelor.setPalierCinqPourUn(-1);
			paliersXelor.put("Intelligence", paliersIntXelor);
			Paliers paliersChanceXelor = new Paliers();
			paliersChanceXelor.setPalierUnPourUn(20);
			paliersChanceXelor.setPalierDeuxPourUn(40);
			paliersChanceXelor.setPalierTroisPourUn(60);
			paliersChanceXelor.setPalierQuatrePourUn(80);
			paliersChanceXelor.setPalierCinqPourUn(-1);
			paliersXelor.put("Chance", paliersChanceXelor);
			Paliers paliersAgiXelor = new Paliers();
			paliersAgiXelor.setPalierUnPourUn(20);
			paliersAgiXelor.setPalierDeuxPourUn(40);
			paliersAgiXelor.setPalierTroisPourUn(60);
			paliersAgiXelor.setPalierQuatrePourUn(80);
			paliersAgiXelor.setPalierCinqPourUn(-1);
			paliersXelor.put("Agilité", paliersAgiXelor);
			classe.put(6, paliersXelor);

			// Iop
			HashMap<String, Paliers> paliersIop = new HashMap<String, Paliers>();
			paliersIop.put("Vitalité", paliersVita);
			paliersIop.put("Sagesse", paliersSagesse);
			Paliers paliersForceIop = new Paliers();
			paliersForceIop.setPalierUnPourUn(100);
			paliersForceIop.setPalierDeuxPourUn(200);
			paliersForceIop.setPalierTroisPourUn(300);
			paliersForceIop.setPalierQuatrePourUn(400);
			paliersForceIop.setPalierCinqPourUn(-1);
			paliersIop.put("Force", paliersForceIop);
			Paliers paliersIntIop = new Paliers();
			paliersIntIop.setPalierUnPourUn(20);
			paliersIntIop.setPalierDeuxPourUn(40);
			paliersIntIop.setPalierTroisPourUn(60);
			paliersIntIop.setPalierQuatrePourUn(80);
			paliersIntIop.setPalierCinqPourUn(-1);
			paliersIop.put("Intelligence", paliersIntIop);
			Paliers paliersChanceIop = new Paliers();
			paliersChanceIop.setPalierUnPourUn(20);
			paliersChanceIop.setPalierDeuxPourUn(40);
			paliersChanceIop.setPalierTroisPourUn(60);
			paliersChanceIop.setPalierQuatrePourUn(80);
			paliersChanceIop.setPalierCinqPourUn(-1);
			paliersIop.put("Chance", paliersChanceIop);
			Paliers paliersAgiIop = new Paliers();
			paliersAgiIop.setPalierUnPourUn(20);
			paliersAgiIop.setPalierDeuxPourUn(40);
			paliersAgiIop.setPalierTroisPourUn(60);
			paliersAgiIop.setPalierQuatrePourUn(80);
			paliersAgiIop.setPalierCinqPourUn(-1);
			paliersIop.put("Agilité", paliersAgiIop);
			classe.put(7, paliersIop);

			// Osa
			HashMap<String, Paliers> paliersOsa = new HashMap<String, Paliers>();
			paliersOsa.put("Vitalité", paliersVita);
			paliersOsa.put("Sagesse", paliersSagesse);
			Paliers paliersForceOsa = new Paliers();
			paliersForceOsa.setPalierDeuxPourUn(50);
			paliersForceOsa.setPalierTroisPourUn(150);
			paliersForceOsa.setPalierQuatrePourUn(250);
			paliersForceOsa.setPalierCinqPourUn(-1);
			paliersOsa.put("Force", paliersForceOsa);
			Paliers paliersIntOsa = new Paliers();
			paliersIntOsa.setPalierUnPourUn(100);
			paliersIntOsa.setPalierDeuxPourUn(200);
			paliersIntOsa.setPalierTroisPourUn(300);
			paliersIntOsa.setPalierQuatrePourUn(400);
			paliersIntOsa.setPalierCinqPourUn(-1);
			paliersOsa.put("Intelligence", paliersIntOsa);
			Paliers paliersChanceOsa = new Paliers();
			paliersChanceOsa.setPalierUnPourUn(100);
			paliersChanceOsa.setPalierDeuxPourUn(200);
			paliersChanceOsa.setPalierTroisPourUn(300);
			paliersChanceOsa.setPalierQuatrePourUn(400);
			paliersChanceOsa.setPalierCinqPourUn(-1);
			paliersOsa.put("Chance", paliersChanceOsa);
			Paliers paliersAgiOsa = new Paliers();
			paliersAgiOsa.setPalierUnPourUn(20);
			paliersAgiOsa.setPalierDeuxPourUn(40);
			paliersAgiOsa.setPalierTroisPourUn(60);
			paliersAgiOsa.setPalierQuatrePourUn(80);
			paliersAgiOsa.setPalierCinqPourUn(-1);
			paliersOsa.put("Agilité", paliersAgiOsa);
			classe.put(8, paliersOsa);

			// Panda
			HashMap<String, Paliers> paliersPanda = new HashMap<String, Paliers>();
			paliersPanda.put("Vitalité", paliersVita);
			paliersPanda.put("Sagesse", paliersSagesse);
			Paliers paliersForcePanda = new Paliers();
			paliersForcePanda.setPalierUnPourUn(50);
			paliersForcePanda.setPalierDeuxPourUn(200);
			paliersForcePanda.setPalierTroisPourUn(-1);
			paliersPanda.put("Force", paliersForcePanda);
			Paliers paliersIntPanda = new Paliers();
			paliersIntPanda.setPalierUnPourUn(50);
			paliersIntPanda.setPalierDeuxPourUn(200);
			paliersIntPanda.setPalierTroisPourUn(-1);
			paliersPanda.put("Intelligence", paliersIntPanda);
			Paliers paliersChancePanda = new Paliers();
			paliersChancePanda.setPalierUnPourUn(50);
			paliersChancePanda.setPalierDeuxPourUn(200);
			paliersChancePanda.setPalierTroisPourUn(-1);
			paliersPanda.put("Chance", paliersChancePanda);
			Paliers paliersAgiPanda = new Paliers();
			paliersAgiPanda.setPalierUnPourUn(50);
			paliersAgiPanda.setPalierDeuxPourUn(200);
			paliersAgiPanda.setPalierTroisPourUn(-1);
			paliersPanda.put("Agilité", paliersAgiPanda);
			classe.put(9, paliersPanda);

			// Sacri
			HashMap<String, Paliers> paliersSacri = new HashMap<String, Paliers>();
			paliersSacri.put("Vitalité", paliersVitaSacri);
			paliersSacri.put("Sagesse", paliersSagesse);
			Paliers paliersForceSacri = new Paliers();
			paliersForceSacri.setPalierTroisPourUn(-1);
			paliersSacri.put("Force", paliersForceSacri);
			Paliers paliersIntSacri = new Paliers();
			paliersIntSacri.setPalierTroisPourUn(-1);
			paliersSacri.put("Intelligence", paliersIntSacri);
			Paliers paliersChanceSacri = new Paliers();
			paliersChanceSacri.setPalierTroisPourUn(-1);
			paliersSacri.put("Chance", paliersChanceSacri);
			Paliers paliersAgiSacri = new Paliers();
			paliersAgiSacri.setPalierTroisPourUn(-1);
			paliersSacri.put("Agilité", paliersAgiSacri);
			classe.put(10, paliersSacri);

			// Sadi
			HashMap<String, Paliers> paliersSadi = new HashMap<String, Paliers>();
			paliersSadi.put("Vitalité", paliersVita);
			paliersSadi.put("Sagesse", paliersSagesse);
			Paliers paliersForceSadi = new Paliers();
			paliersForceSadi.setPalierUnPourUn(50);
			paliersForceSadi.setPalierDeuxPourUn(200);
			paliersForceSadi.setPalierTroisPourUn(300);
			paliersForceSadi.setPalierQuatrePourUn(400);
			paliersForceSadi.setPalierCinqPourUn(-1);
			paliersSadi.put("Force", paliersForceSadi);
			Paliers paliersIntSadi = new Paliers();
			paliersIntSadi.setPalierUnPourUn(100);
			paliersIntSadi.setPalierDeuxPourUn(200);
			paliersIntSadi.setPalierTroisPourUn(300);
			paliersIntSadi.setPalierQuatrePourUn(400);
			paliersIntSadi.setPalierCinqPourUn(-1);
			paliersSadi.put("Intelligence", paliersIntSadi);
			Paliers paliersChanceSadi = new Paliers();
			paliersChanceSadi.setPalierUnPourUn(100);
			paliersChanceSadi.setPalierDeuxPourUn(200);
			paliersChanceSadi.setPalierTroisPourUn(300);
			paliersChanceSadi.setPalierQuatrePourUn(400);
			paliersChanceSadi.setPalierCinqPourUn(-1);
			paliersSadi.put("Chance", paliersChanceSadi);
			Paliers paliersAgiSadi = new Paliers();
			paliersAgiSadi.setPalierUnPourUn(25);
			paliersAgiSadi.setPalierDeuxPourUn(50);
			paliersAgiSadi.setPalierTroisPourUn(75);
			paliersAgiSadi.setPalierQuatrePourUn(100);
			paliersAgiSadi.setPalierCinqPourUn(-1);
			paliersSadi.put("Agilité", paliersAgiSadi);
			classe.put(11, paliersSadi);

			// Sram
			HashMap<String, Paliers> paliersSram = new HashMap<String, Paliers>();
			paliersSram.put("Vitalité", paliersVita);
			paliersSram.put("Sagesse", paliersSagesse);
			Paliers paliersForceSram = new Paliers();
			paliersForceSram.setPalierUnPourUn(100);
			paliersForceSram.setPalierDeuxPourUn(200);
			paliersForceSram.setPalierTroisPourUn(300);
			paliersForceSram.setPalierQuatrePourUn(400);
			paliersForceSram.setPalierCinqPourUn(-1);
			paliersSram.put("Force", paliersForceSram);
			Paliers paliersIntSram = new Paliers();
			paliersIntSram.setPalierDeuxPourUn(50);
			paliersIntSram.setPalierTroisPourUn(150);
			paliersIntSram.setPalierQuatrePourUn(250);
			paliersIntSram.setPalierCinqPourUn(-1);
			paliersSram.put("Intelligence", paliersIntSram);
			Paliers paliersChanceSram = new Paliers();
			paliersChanceSram.setPalierUnPourUn(20);
			paliersChanceSram.setPalierDeuxPourUn(40);
			paliersChanceSram.setPalierTroisPourUn(60);
			paliersChanceSram.setPalierQuatrePourUn(80);
			paliersChanceSram.setPalierCinqPourUn(-1);
			paliersSram.put("Chance", paliersChanceSram);
			Paliers paliersAgiSram = new Paliers();
			paliersAgiSram.setPalierUnPourUn(100);
			paliersAgiSram.setPalierDeuxPourUn(200);
			paliersAgiSram.setPalierTroisPourUn(300);
			paliersAgiSram.setPalierQuatrePourUn(400);
			paliersAgiSram.setPalierCinqPourUn(-1);
			paliersSram.put("Agilité", paliersAgiSram);
			classe.put(12, paliersSram);

			ASQLRequete req = bdd.requete("SELECT * FROM CLASSES");
			ResultSet res = req.getResultats();
			while(res.next())
			{
				String requete = "UPDATE CLASSES SET PALIERS_VITALITE=" + classe.get(res.getInt("ID")).get("Vitalité").sauvegarder(bdd) + ", PALIERS_SAGESSE=" + classe.get(res.getInt("ID")).get("Sagesse").sauvegarder(bdd) + ", PALIERS_FORCE=" + classe.get(res.getInt("ID")).get("Force").sauvegarder(bdd) + ", PALIERS_INTELLIGENCE=" + classe.get(res.getInt("ID")).get("Intelligence").sauvegarder(bdd) + ", PALIERS_CHANCE=" + classe.get(res.getInt("ID")).get("Chance").sauvegarder(bdd) + ", PALIERS_AGILITE=" + classe.get(res.getInt("ID")).get("Agilité").sauvegarder(bdd) + " WHERE ID=" + res.getInt("ID");
				bdd.requete(requete);
			}

			System.out.println("Paliers done.");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}
