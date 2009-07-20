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

package org.JDofusCalc.vues.Qt;

import org.JDofusCalc.Main;

import com.trolltech.qt.core.QLocale;
import com.trolltech.qt.core.QTranslator;
import com.trolltech.qt.core.Qt;
import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QColor;
import com.trolltech.qt.gui.QPixmap;
import com.trolltech.qt.gui.QSplashScreen;

/**
 * Vue de l'écran de démarrage.
 * 
 * @author PAPAYA Alexandre
 * @category Vue
 * @version 1.0
 */
public class VQtEcranDemarrage extends VueQt
{
	/*
	 * Variables d'instances
	 */
	
	/**
	 * SplashScreen de la vue.
	 */
	private QSplashScreen splash;

	/*
	 * Constructeurs / Destructeur
	 */

	/**
	 * Construit une nouvelle vue.
	 * 
	 * @category Constructeur
	 */
	public VQtEcranDemarrage()
	{
		// Lancement du moteur Qt
		QApplication.initialize(new String[] {});
		
		// Chargement des fichiers de traduction
		String langue = QLocale.system().name();
		String cheminFichier = "classpath:org/JDofusCalc/vues/Qt/traductions/qt_" + langue + ".qm";
		QTranslator translator = new QTranslator();
		if(translator.load(cheminFichier))
			QApplication.installTranslator(translator);
		else
			logger.error("Fichier de traduction des fenêtres Qt introuvable : " + cheminFichier + ".");

		// Génération du splash
		QPixmap splashImage = new QPixmap("classpath:org/JDofusCalc/ressources/images/splashscreen.png");
		this.splash = new QSplashScreen(splashImage);
	}
	
	/*
	 * Méthodes
	 */

	/**
	 * Change le message du SplashScreen.
	 * 
	 * @param message - Message à afficher.
	 */
	public void changerMessage(String message)
	{
		this.splash.showMessage("JDofusCalc v" + Main.getVersion() + " : " + message, Qt.AlignmentFlag.AlignBottom.value() | Qt.AlignmentFlag.AlignRight.value(), new QColor(Qt.GlobalColor.white));
		QApplication.processEvents();
	}
	
	/*
	 * Méthodes héritées
	 */

	@Override
	public void afficher()
	{
		this.splash.show();
		QApplication.processEvents();
	}

	@Override
	public void fermer()
	{
		this.splash.close();
		QApplication.exec();
	}
	
	/*
	 * Accesseurs
	 */
	
	/**
	 * Renvoie {@code fenetre}.
	 * 
	 * @return La fenêtre de la vue.
	 * @category Accesseur
	 */
	public final QSplashScreen getFenetre()
	{
		return this.splash;
	}
}