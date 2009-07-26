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

package org.JDofusCalc.vues.Qt.composants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.JDofusCalc.dofus.autres.Classe;
import org.JDofusCalc.dofus.autres.Effets.FlagsTypesEffets;
import org.JDofusCalc.dofus.conditions.Condition;
import org.JDofusCalc.dofus.conditions.ConditionAlignement;
import org.JDofusCalc.dofus.conditions.ConditionCaracteristique;
import org.JDofusCalc.dofus.conditions.ConditionClasse;
import org.JDofusCalc.dofus.conditions.ConditionGrade;
import org.JDofusCalc.dofus.conditions.ConditionSexe;
import org.JDofusCalc.dofus.conditions.Condition.Operateur;
import org.JDofusCalc.dofus.conditions.ConditionAlignement.Alignement;
import org.JDofusCalc.dofus.conditions.ConditionSexe.Sexe;
import org.JDofusCalc.vues.Qt.designer.UIConditions;

import com.trolltech.qt.core.Qt;
import com.trolltech.qt.core.Qt.MatchFlag;
import com.trolltech.qt.gui.QListWidgetItem;
import com.trolltech.qt.gui.QWidget;

/**
 * Composant affichant la liste des conditions modifiables d'un objet.
 * 
 * @author PAPAYA Alexandre
 * @category Composant
 * @version 1.0
 */
public class QWidgetConditions extends QWidget
{
	/*
	 * Variables d'instances
	 */
	
	/* Composants */

	/**
	 * L'interface graphique.
	 */
	private UIConditions ui = null;

	/*
	 * Constructeurs / Destructeur
	 */

	/**
	 * Construit un nouveau composant.
	 * 
	 * @param parent - Composant parent.
	 * @category Constructeur
	 */
	public QWidgetConditions(QWidget parent)
	{
		// Execution du constructeur de la classe mère
		super(parent);

		// Initialisation de l'interface graphique
		this.ui = new UIConditions();
		this.ui.setupUi(this);

		/* Connexions signal->slot */
		this.ui.spinBoxVita.valueChanged.connect(this, "slotChangementConditionVita(int)");
		this.ui.spinBoxSag.valueChanged.connect(this, "slotChangementConditionSag(int)");
		this.ui.spinBoxForce.valueChanged.connect(this, "slotChangementConditionForce(int)");
		this.ui.spinBoxInt.valueChanged.connect(this, "slotChangementConditionInt(int)");
		this.ui.spinBoxChance.valueChanged.connect(this, "slotChangementConditionChance(int)");
		this.ui.spinBoxAgi.valueChanged.connect(this, "slotChangementConditionAgi(int)");
		this.ui.listClasse.itemSelectionChanged.connect(this, "slotChangementConditionClasse()");
		this.ui.comboCondGrade.currentIndexChanged.connect(this, "slotChangementConditionGrade(int)");
		this.ui.comboCondAli.currentIndexChanged.connect(this, "slotChangementConditionAli(int)");
	}

	/*
	 * Méthodes d'affichage des données du composant
	 */

	/**
	 * Remet toutes les conditions du composant à leurs valeurs initiales.
	 */
	public void nettoyer()
	{
		this.ui.spinBoxVita.setValue(0);
		this.ui.spinBoxSag.setValue(0);
		this.ui.spinBoxForce.setValue(0);
		this.ui.spinBoxInt.setValue(0);
		this.ui.spinBoxChance.setValue(0);
		this.ui.spinBoxAgi.setValue(0);
		this.ui.listClasse.clearSelection();
		this.ui.comboCondSexe.setCurrentIndex(0);
		this.ui.comboCondGrade.setCurrentIndex(0);
		this.ui.comboCondAli.setCurrentIndex(0);
	}
	
	/**
	 * Définit les valeurs des conditions contenues dans la liste.
	 * 
	 * @param conditions - La liste des conditions.
	 */
	public void setConditions(ArrayList<Condition> conditions)
	{
		this.nettoyer();

		if(conditions != null)
		{
			for(int i = 0; i < conditions.size(); i++)
			{
				if(conditions.get(i) instanceof ConditionCaracteristique)
				{
					ConditionCaracteristique condition = (ConditionCaracteristique) conditions.get(i);
					FlagsTypesEffets caracteristique = condition.getCaracteristique();

					int indexOperateur = 0;
					if(condition.getOperateur() == Operateur.Egal)
					{
						indexOperateur = 2;
					}
					else if(condition.getOperateur() == Operateur.Superieur)
					{
						indexOperateur = 0;
					}
					else if(condition.getOperateur() == Operateur.Inferieur)
					{
						indexOperateur = 1;
					}

					if(caracteristique == FlagsTypesEffets.Vitalite)
					{
						this.ui.spinBoxVita.setValue(Integer.parseInt(String.valueOf(condition.getValeur())));
						this.ui.comboCondVita.setCurrentIndex(indexOperateur);
					}
					else if(caracteristique == FlagsTypesEffets.Sagesse)
					{
						this.ui.spinBoxSag.setValue(Integer.parseInt(String.valueOf(condition.getValeur())));
						this.ui.comboCondSag.setCurrentIndex(indexOperateur);
					}
					else if(caracteristique == FlagsTypesEffets.Force)
					{
						this.ui.spinBoxForce.setValue(Integer.parseInt(String.valueOf(condition.getValeur())));
						this.ui.comboCondForce.setCurrentIndex(indexOperateur);
					}
					else if(caracteristique == FlagsTypesEffets.Intelligence)
					{
						this.ui.spinBoxInt.setValue(Integer.parseInt(String.valueOf(condition.getValeur())));
						this.ui.comboCondInt.setCurrentIndex(indexOperateur);
					}
					else if(caracteristique == FlagsTypesEffets.Chance)
					{
						this.ui.spinBoxChance.setValue(Integer.parseInt(String.valueOf(condition.getValeur())));
						this.ui.comboCondChance.setCurrentIndex(indexOperateur);
					}
					else if(caracteristique == FlagsTypesEffets.Agilite)
					{
						this.ui.spinBoxAgi.setValue(Integer.parseInt(String.valueOf(condition.getValeur())));
						this.ui.comboCondAgi.setCurrentIndex(indexOperateur);
					}
				}
				else if(conditions.get(i) instanceof ConditionClasse)
				{
					List<QListWidgetItem> liste = this.ui.listClasse.findItems(String.valueOf(conditions.get(i).getValeur()), MatchFlag.MatchExactly);
					if(liste.size() > 0)
					{
						if(conditions.get(i).getOperateur() == Operateur.Egal)
						{
							liste.get(0).setSelected(true);
						}
						else if(conditions.get(i).getOperateur() == Operateur.Different)
						{
							// TODO
						}
					}
				}
				else if(conditions.get(i) instanceof ConditionGrade)
				{
					if(conditions.get(i).getOperateur() == Operateur.Superieur)
					{
						this.ui.comboCondGradeOp.setCurrentIndex(0);
					}
					else if(conditions.get(i).getOperateur() == Operateur.Inferieur)
					{
						this.ui.comboCondGradeOp.setCurrentIndex(1);
					}
					else if(conditions.get(i).getOperateur() == Operateur.Egal)
					{
						this.ui.comboCondGradeOp.setCurrentIndex(2);
					}

					this.ui.comboCondGrade.setCurrentIndex(Integer.parseInt(String.valueOf(conditions.get(i).getValeur())) + 1);
				}
				else if(conditions.get(i) instanceof ConditionSexe)
				{
					if(conditions.get(i).getOperateur() == Operateur.Egal)
					{
						if(conditions.get(i).getValeur() == Sexe.Masculin)
						{
							this.ui.comboCondSexe.setCurrentIndex(1);
						}
						else if(conditions.get(i).getValeur() == Sexe.Feminin)
						{
							this.ui.comboCondSexe.setCurrentIndex(2);
						}
					}
					else if(conditions.get(i).getOperateur() == Operateur.Different)
					{
						if(conditions.get(i).getValeur() == Sexe.Masculin)
						{
							this.ui.comboCondSexe.setCurrentIndex(2);
						}
						else if(conditions.get(i).getValeur() == Sexe.Feminin)
						{
							this.ui.comboCondSexe.setCurrentIndex(1);
						}
					}
				}
				else if(conditions.get(i) instanceof ConditionAlignement)
				{
					if(conditions.get(i).getValeur() == Alignement.Bontais)
					{
						this.ui.comboCondAli.setCurrentIndex(1);
					}
					else if(conditions.get(i).getValeur() == Alignement.Brakmarien)
					{
						this.ui.comboCondAli.setCurrentIndex(2);
					}
					else if(conditions.get(i).getValeur() == Alignement.Mercenaire)
					{
						this.ui.comboCondAli.setCurrentIndex(3);
					}
				}
			}
		}
	}

	/*
	 * Méthodes
	 */
	
	/**
	 * Renvoie la liste des conditons définies par l'utilisateur.
	 * 
	 * @return La liste des conditons.
	 */
	public ArrayList<Condition> getConditions()
	{
		ArrayList<Condition> conditions = new ArrayList<Condition>();

		if(this.ui.spinBoxVita.value() > 0)
		{
			ConditionCaracteristique condition = new ConditionCaracteristique(Operateur.getOperateur(this.ui.comboCondVita.currentText()), FlagsTypesEffets.Vitalite, this.ui.spinBoxVita.value());
			conditions.add(condition);
		}
		if(this.ui.spinBoxSag.value() > 0)
		{
			ConditionCaracteristique condition = new ConditionCaracteristique(Operateur.getOperateur(this.ui.comboCondSag.currentText()), FlagsTypesEffets.Sagesse, this.ui.spinBoxSag.value());
			conditions.add(condition);
		}
		if(this.ui.spinBoxForce.value() > 0)
		{
			ConditionCaracteristique condition = new ConditionCaracteristique(Operateur.getOperateur(this.ui.comboCondForce.currentText()), FlagsTypesEffets.Force, this.ui.spinBoxForce.value());
			conditions.add(condition);
		}
		if(this.ui.spinBoxInt.value() > 0)
		{
			ConditionCaracteristique condition = new ConditionCaracteristique(Operateur.getOperateur(this.ui.comboCondInt.currentText()), FlagsTypesEffets.Intelligence, this.ui.spinBoxInt.value());
			conditions.add(condition);
		}
		if(this.ui.spinBoxChance.value() > 0)
		{
			ConditionCaracteristique condition = new ConditionCaracteristique(Operateur.getOperateur(this.ui.comboCondChance.currentText()), FlagsTypesEffets.Chance, this.ui.spinBoxChance.value());
			conditions.add(condition);
		}
		if(this.ui.spinBoxAgi.value() > 0)
		{
			ConditionCaracteristique condition = new ConditionCaracteristique(Operateur.getOperateur(this.ui.comboCondAgi.currentText()), FlagsTypesEffets.Agilite, this.ui.spinBoxAgi.value());
			conditions.add(condition);
		}
		if(this.ui.comboCondAli.currentIndex() > 0)
		{
			ConditionAlignement condition = new ConditionAlignement(Operateur.Egal, Alignement.getAlignement(this.ui.comboCondAli.currentText()));
			conditions.add(condition);
		}
		if(this.ui.comboCondSexe.currentIndex() > 0)
		{
			if(this.ui.comboCondSexe.currentIndex() == 1)
			{
				ConditionSexe condition = new ConditionSexe(Operateur.Egal, Sexe.Masculin);
				conditions.add(condition);
			}
			else
			{
				ConditionSexe condition = new ConditionSexe(Operateur.Egal, Sexe.Feminin);
				conditions.add(condition);
			}
		}
		if(this.ui.comboCondGrade.currentIndex() > 0)
		{
			ConditionGrade condition = new ConditionGrade(Operateur.getOperateur(this.ui.comboCondGradeOp.currentText()), Integer.parseInt(this.ui.comboCondGrade.currentText()));
			conditions.add(condition);
		}
		if(this.ui.listClasse.selectedItems().size() > 0)
		{
			List<QListWidgetItem> classes = this.ui.listClasse.selectedItems();
			ConditionClasse condition = new ConditionClasse(Operateur.Egal);
			for(int i = 0; i < classes.size(); i++)
			{
				condition.addClasse(classes.get(i).text());
			}
			conditions.add(condition);
		}

		if(conditions.size() == 0)
		{
			conditions = null;
		}

		return conditions;
	}

	/**
	 * Genere la liste des classes
	 * 
	 * @param classes
	 */
	public void setListeClasses(HashMap<Integer, Classe> classes)
	{
		// Vide le combo
		this.ui.listClasse.clear();

		for(Entry<Integer, Classe> entry : classes.entrySet())
		{
			// Ajoute l'item dans le combo
			Classe classe = entry.getValue();
			QListWidgetItem item = new QListWidgetItem(classe.getNom());
			item.setData(Qt.ItemDataRole.UserRole, classe);
			this.ui.listClasse.addItem(item);
		}
	}

	/*
	 * Slots du composant
	 */

	/**
	 * Gère le changement valeur de la condition "vitalité".
	 * 
	 * @category Slot
	 */
	public void slotChangementConditionVita(int valeur)
	{
		if(valeur == 0)
		{
			this.ui.lblCondVita.setEnabled(false);
			this.ui.comboCondVita.setEnabled(false);
		}
		else
		{
			this.ui.lblCondVita.setEnabled(true);
			this.ui.comboCondVita.setEnabled(true);
		}
	}

	/**
	 * Gère le changement valeur de la condition "sagesse".
	 * 
	 * @category Slot
	 */
	public void slotChangementConditionSag(int valeur)
	{
		if(valeur == 0)
		{
			this.ui.lblCondSag.setEnabled(false);
			this.ui.comboCondSag.setEnabled(false);
		}
		else
		{
			this.ui.lblCondSag.setEnabled(true);
			this.ui.comboCondSag.setEnabled(true);
		}
	}

	/**
	 * Gère le changement valeur de la condition "force".
	 * 
	 * @category Slot
	 */
	public void slotChangementConditionForce(int valeur)
	{
		if(valeur == 0)
		{
			this.ui.lblCondForce.setEnabled(false);
			this.ui.comboCondForce.setEnabled(false);
		}
		else
		{
			this.ui.lblCondForce.setEnabled(true);
			this.ui.comboCondForce.setEnabled(true);
		}
	}

	/**
	 * Gère le changement valeur de la condition "intelligence".
	 * 
	 * @category Slot
	 */
	public void slotChangementConditionInt(int valeur)
	{
		if(valeur == 0)
		{
			this.ui.lblCondInt.setEnabled(false);
			this.ui.comboCondInt.setEnabled(false);
		}
		else
		{
			this.ui.lblCondInt.setEnabled(true);
			this.ui.comboCondInt.setEnabled(true);
		}
	}

	/**
	 * Gère le changement valeur de la condition "chance".
	 * 
	 * @category Slot
	 */
	public void slotChangementConditionChance(int valeur)
	{
		if(valeur == 0)
		{
			this.ui.lblCondChance.setEnabled(false);
			this.ui.comboCondChance.setEnabled(false);
		}
		else
		{
			this.ui.lblCondChance.setEnabled(true);
			this.ui.comboCondChance.setEnabled(true);
		}
	}

	/**
	 * Gère le changement valeur de la condition "agilité".
	 * 
	 * @category Slot
	 */
	public void slotChangementConditionAgi(int valeur)
	{
		if(valeur == 0)
		{
			this.ui.lblCondAgi.setEnabled(false);
			this.ui.comboCondAgi.setEnabled(false);
		}
		else
		{
			this.ui.lblCondAgi.setEnabled(true);
			this.ui.comboCondAgi.setEnabled(true);
		}
	}

	/**
	 * Gère le changement valeur de la condition "classe".
	 * 
	 * @category Slot
	 */
	public void slotChangementConditionClasse()
	{
		if(this.ui.listClasse.selectedItems().size() == 0)
		{
			this.ui.lblCondClasse.setEnabled(false);
		}
		else
		{
			this.ui.lblCondClasse.setEnabled(true);
		}
	}

	/**
	 * Gère le changement valeur de la condition "grade".
	 * 
	 * @category Slot
	 */
	public void slotChangementConditionGrade(int index)
	{
		if(index == 0)
		{
			this.ui.comboCondGradeOp.setEnabled(false);
			this.ui.lblCondGrade.setEnabled(false);
		}
		else
		{
			this.ui.comboCondGradeOp.setEnabled(true);
			this.ui.lblCondGrade.setEnabled(true);
		}
	}

	/**
	 * Gère le changement valeur de la condition "alignement".
	 * 
	 * @category Slot
	 */
	public void slotChangementConditionAli(int index)
	{
		if(index == 0)
		{
			this.ui.lblCondAli.setEnabled(false);
		}
		else
		{
			this.ui.lblCondAli.setEnabled(true);
		}
	}
}