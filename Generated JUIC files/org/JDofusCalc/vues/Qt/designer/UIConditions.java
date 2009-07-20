/********************************************************************************
** Form generated from reading ui file 'UIConditions.jui'
**
** Created: mer. 24. juin 12:04:04 2009
**      by: Qt User Interface Compiler version 4.5.0
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

package org.JDofusCalc.vues.Qt.designer;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class UIConditions implements com.trolltech.qt.QUiForm<QWidget>
{
    public QGridLayout gridLayout;
    public QLabel lblCondVita;
    public QComboBox comboCondVita;
    public QSpinBox spinBoxVita;
    public QLabel lblCondSag;
    public QComboBox comboCondSag;
    public QSpinBox spinBoxSag;
    public QLabel lblCondSexe;
    public QComboBox comboCondSexe;
    public QLabel lblCondForce;
    public QComboBox comboCondForce;
    public QSpinBox spinBoxForce;
    public QLabel lblCondInt;
    public QComboBox comboCondInt;
    public QSpinBox spinBoxInt;
    public QLabel lblCondAli;
    public QComboBox comboCondAli;
    public QLabel lblCondChance;
    public QComboBox comboCondChance;
    public QSpinBox spinBoxChance;
    public QLabel lblCondAgi;
    public QComboBox comboCondAgi;
    public QSpinBox spinBoxAgi;
    public QLabel lblCondGrade;
    public QComboBox comboCondGradeOp;
    public QComboBox comboCondGrade;
    public QLabel lblCondClasse;
    public QListWidget listClasse;
    public QSpacerItem verticalSpacer;

    public UIConditions() { super(); }

    public void setupUi(QWidget UIConditions)
    {
        UIConditions.setObjectName("UIConditions");
        UIConditions.resize(new QSize(393, 159).expandedTo(UIConditions.minimumSizeHint()));
        gridLayout = new QGridLayout(UIConditions);
        gridLayout.setSpacing(4);
        gridLayout.setMargin(4);
        gridLayout.setObjectName("gridLayout");
        lblCondVita = new QLabel(UIConditions);
        lblCondVita.setObjectName("lblCondVita");
        lblCondVita.setEnabled(false);
        QSizePolicy sizePolicy = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy.setHorizontalStretch((byte)0);
        sizePolicy.setVerticalStretch((byte)0);
        sizePolicy.setHeightForWidth(lblCondVita.sizePolicy().hasHeightForWidth());
        lblCondVita.setSizePolicy(sizePolicy);
        lblCondVita.setMinimumSize(new QSize(25, 25));
        lblCondVita.setMaximumSize(new QSize(25, 16777215));
        lblCondVita.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblCondVita.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/vita.png")));
        lblCondVita.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout.addWidget(lblCondVita, 0, 0, 1, 1);

        comboCondVita = new QComboBox(UIConditions);
        comboCondVita.setObjectName("comboCondVita");
        comboCondVita.setEnabled(false);
        comboCondVita.setMinimumSize(new QSize(30, 20));
        comboCondVita.setMaximumSize(new QSize(30, 20));
        comboCondVita.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.WheelFocus);

        gridLayout.addWidget(comboCondVita, 0, 1, 1, 1);

        spinBoxVita = new QSpinBox(UIConditions);
        spinBoxVita.setObjectName("spinBoxVita");
        spinBoxVita.setMinimumSize(new QSize(40, 0));
        spinBoxVita.setMaximumSize(new QSize(40, 16777215));
        spinBoxVita.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.WheelFocus);
        spinBoxVita.setMaximum(2000);

        gridLayout.addWidget(spinBoxVita, 0, 2, 1, 1);

        lblCondSag = new QLabel(UIConditions);
        lblCondSag.setObjectName("lblCondSag");
        lblCondSag.setEnabled(false);
        QSizePolicy sizePolicy1 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy1.setHorizontalStretch((byte)0);
        sizePolicy1.setVerticalStretch((byte)0);
        sizePolicy1.setHeightForWidth(lblCondSag.sizePolicy().hasHeightForWidth());
        lblCondSag.setSizePolicy(sizePolicy1);
        lblCondSag.setMinimumSize(new QSize(25, 25));
        lblCondSag.setMaximumSize(new QSize(25, 16777215));
        lblCondSag.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblCondSag.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/sagesse.png")));
        lblCondSag.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout.addWidget(lblCondSag, 0, 3, 1, 1);

        comboCondSag = new QComboBox(UIConditions);
        comboCondSag.setObjectName("comboCondSag");
        comboCondSag.setEnabled(false);
        comboCondSag.setMinimumSize(new QSize(30, 20));
        comboCondSag.setMaximumSize(new QSize(30, 20));
        comboCondSag.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.WheelFocus);

        gridLayout.addWidget(comboCondSag, 0, 4, 1, 1);

        spinBoxSag = new QSpinBox(UIConditions);
        spinBoxSag.setObjectName("spinBoxSag");
        spinBoxSag.setMinimumSize(new QSize(40, 0));
        spinBoxSag.setMaximumSize(new QSize(40, 16777215));
        spinBoxSag.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.WheelFocus);
        spinBoxSag.setMaximum(1000);

        gridLayout.addWidget(spinBoxSag, 0, 5, 1, 1);

        lblCondSexe = new QLabel(UIConditions);
        lblCondSexe.setObjectName("lblCondSexe");
        lblCondSexe.setEnabled(false);

        gridLayout.addWidget(lblCondSexe, 0, 6, 1, 1);

        comboCondSexe = new QComboBox(UIConditions);
        comboCondSexe.setObjectName("comboCondSexe");
        comboCondSexe.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.WheelFocus);

        gridLayout.addWidget(comboCondSexe, 0, 7, 1, 2);

        lblCondForce = new QLabel(UIConditions);
        lblCondForce.setObjectName("lblCondForce");
        lblCondForce.setEnabled(false);
        QSizePolicy sizePolicy2 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy2.setHorizontalStretch((byte)0);
        sizePolicy2.setVerticalStretch((byte)0);
        sizePolicy2.setHeightForWidth(lblCondForce.sizePolicy().hasHeightForWidth());
        lblCondForce.setSizePolicy(sizePolicy2);
        lblCondForce.setMinimumSize(new QSize(25, 25));
        lblCondForce.setMaximumSize(new QSize(25, 16777215));
        lblCondForce.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblCondForce.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/force.png")));
        lblCondForce.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout.addWidget(lblCondForce, 1, 0, 1, 1);

        comboCondForce = new QComboBox(UIConditions);
        comboCondForce.setObjectName("comboCondForce");
        comboCondForce.setEnabled(false);
        comboCondForce.setMinimumSize(new QSize(30, 20));
        comboCondForce.setMaximumSize(new QSize(30, 20));
        comboCondForce.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.WheelFocus);

        gridLayout.addWidget(comboCondForce, 1, 1, 1, 1);

        spinBoxForce = new QSpinBox(UIConditions);
        spinBoxForce.setObjectName("spinBoxForce");
        spinBoxForce.setMinimumSize(new QSize(40, 0));
        spinBoxForce.setMaximumSize(new QSize(40, 16777215));
        spinBoxForce.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.WheelFocus);
        spinBoxForce.setMaximum(1000);

        gridLayout.addWidget(spinBoxForce, 1, 2, 1, 1);

        lblCondInt = new QLabel(UIConditions);
        lblCondInt.setObjectName("lblCondInt");
        lblCondInt.setEnabled(false);
        QSizePolicy sizePolicy3 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy3.setHorizontalStretch((byte)0);
        sizePolicy3.setVerticalStretch((byte)0);
        sizePolicy3.setHeightForWidth(lblCondInt.sizePolicy().hasHeightForWidth());
        lblCondInt.setSizePolicy(sizePolicy3);
        lblCondInt.setMinimumSize(new QSize(25, 25));
        lblCondInt.setMaximumSize(new QSize(25, 16777215));
        lblCondInt.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblCondInt.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/intelligence.png")));
        lblCondInt.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout.addWidget(lblCondInt, 1, 3, 1, 1);

        comboCondInt = new QComboBox(UIConditions);
        comboCondInt.setObjectName("comboCondInt");
        comboCondInt.setEnabled(false);
        comboCondInt.setMinimumSize(new QSize(30, 20));
        comboCondInt.setMaximumSize(new QSize(30, 20));
        comboCondInt.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.WheelFocus);

        gridLayout.addWidget(comboCondInt, 1, 4, 1, 1);

        spinBoxInt = new QSpinBox(UIConditions);
        spinBoxInt.setObjectName("spinBoxInt");
        spinBoxInt.setMinimumSize(new QSize(40, 0));
        spinBoxInt.setMaximumSize(new QSize(40, 16777215));
        spinBoxInt.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.WheelFocus);
        spinBoxInt.setMaximum(1000);

        gridLayout.addWidget(spinBoxInt, 1, 5, 1, 1);

        lblCondAli = new QLabel(UIConditions);
        lblCondAli.setObjectName("lblCondAli");
        lblCondAli.setEnabled(false);

        gridLayout.addWidget(lblCondAli, 1, 6, 1, 1);

        comboCondAli = new QComboBox(UIConditions);
        comboCondAli.setObjectName("comboCondAli");
        comboCondAli.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.WheelFocus);

        gridLayout.addWidget(comboCondAli, 1, 7, 1, 2);

        lblCondChance = new QLabel(UIConditions);
        lblCondChance.setObjectName("lblCondChance");
        lblCondChance.setEnabled(false);
        QSizePolicy sizePolicy4 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy4.setHorizontalStretch((byte)0);
        sizePolicy4.setVerticalStretch((byte)0);
        sizePolicy4.setHeightForWidth(lblCondChance.sizePolicy().hasHeightForWidth());
        lblCondChance.setSizePolicy(sizePolicy4);
        lblCondChance.setMinimumSize(new QSize(25, 25));
        lblCondChance.setMaximumSize(new QSize(25, 16777215));
        lblCondChance.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblCondChance.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/chance.png")));
        lblCondChance.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout.addWidget(lblCondChance, 2, 0, 1, 1);

        comboCondChance = new QComboBox(UIConditions);
        comboCondChance.setObjectName("comboCondChance");
        comboCondChance.setEnabled(false);
        comboCondChance.setMinimumSize(new QSize(30, 20));
        comboCondChance.setMaximumSize(new QSize(30, 20));
        comboCondChance.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.WheelFocus);

        gridLayout.addWidget(comboCondChance, 2, 1, 1, 1);

        spinBoxChance = new QSpinBox(UIConditions);
        spinBoxChance.setObjectName("spinBoxChance");
        spinBoxChance.setMinimumSize(new QSize(40, 0));
        spinBoxChance.setMaximumSize(new QSize(40, 16777215));
        spinBoxChance.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.WheelFocus);
        spinBoxChance.setMaximum(1000);

        gridLayout.addWidget(spinBoxChance, 2, 2, 1, 1);

        lblCondAgi = new QLabel(UIConditions);
        lblCondAgi.setObjectName("lblCondAgi");
        lblCondAgi.setEnabled(false);
        QSizePolicy sizePolicy5 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy5.setHorizontalStretch((byte)0);
        sizePolicy5.setVerticalStretch((byte)0);
        sizePolicy5.setHeightForWidth(lblCondAgi.sizePolicy().hasHeightForWidth());
        lblCondAgi.setSizePolicy(sizePolicy5);
        lblCondAgi.setMinimumSize(new QSize(25, 25));
        lblCondAgi.setMaximumSize(new QSize(25, 16777215));
        lblCondAgi.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblCondAgi.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/agilite.png")));
        lblCondAgi.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout.addWidget(lblCondAgi, 2, 3, 1, 1);

        comboCondAgi = new QComboBox(UIConditions);
        comboCondAgi.setObjectName("comboCondAgi");
        comboCondAgi.setEnabled(false);
        comboCondAgi.setMinimumSize(new QSize(30, 20));
        comboCondAgi.setMaximumSize(new QSize(30, 20));
        comboCondAgi.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.WheelFocus);

        gridLayout.addWidget(comboCondAgi, 2, 4, 1, 1);

        spinBoxAgi = new QSpinBox(UIConditions);
        spinBoxAgi.setObjectName("spinBoxAgi");
        spinBoxAgi.setMinimumSize(new QSize(40, 0));
        spinBoxAgi.setMaximumSize(new QSize(40, 16777215));
        spinBoxAgi.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.WheelFocus);
        spinBoxAgi.setMaximum(1000);

        gridLayout.addWidget(spinBoxAgi, 2, 5, 1, 1);

        lblCondGrade = new QLabel(UIConditions);
        lblCondGrade.setObjectName("lblCondGrade");
        lblCondGrade.setEnabled(false);

        gridLayout.addWidget(lblCondGrade, 2, 6, 1, 1);

        comboCondGradeOp = new QComboBox(UIConditions);
        comboCondGradeOp.setObjectName("comboCondGradeOp");
        QSizePolicy sizePolicy6 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy6.setHorizontalStretch((byte)0);
        sizePolicy6.setVerticalStretch((byte)0);
        sizePolicy6.setHeightForWidth(comboCondGradeOp.sizePolicy().hasHeightForWidth());
        comboCondGradeOp.setSizePolicy(sizePolicy6);
        comboCondGradeOp.setMinimumSize(new QSize(30, 20));
        comboCondGradeOp.setMaximumSize(new QSize(30, 20));
        comboCondGradeOp.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.WheelFocus);

        gridLayout.addWidget(comboCondGradeOp, 2, 7, 1, 1);

        comboCondGrade = new QComboBox(UIConditions);
        comboCondGrade.setObjectName("comboCondGrade");
        comboCondGrade.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.WheelFocus);

        gridLayout.addWidget(comboCondGrade, 2, 8, 1, 1);

        lblCondClasse = new QLabel(UIConditions);
        lblCondClasse.setObjectName("lblCondClasse");
        lblCondClasse.setEnabled(false);
        QSizePolicy sizePolicy7 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Preferred, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy7.setHorizontalStretch((byte)0);
        sizePolicy7.setVerticalStretch((byte)0);
        sizePolicy7.setHeightForWidth(lblCondClasse.sizePolicy().hasHeightForWidth());
        lblCondClasse.setSizePolicy(sizePolicy7);

        gridLayout.addWidget(lblCondClasse, 3, 0, 1, 2);

        listClasse = new QListWidget(UIConditions);
        listClasse.setObjectName("listClasse");
        listClasse.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.WheelFocus);
        listClasse.setVerticalScrollBarPolicy(com.trolltech.qt.core.Qt.ScrollBarPolicy.ScrollBarAlwaysOn);
        listClasse.setSelectionMode(com.trolltech.qt.gui.QAbstractItemView.SelectionMode.MultiSelection);

        gridLayout.addWidget(listClasse, 3, 2, 2, 4);

        verticalSpacer = new QSpacerItem(0, 0, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);

        gridLayout.addItem(verticalSpacer, 4, 0, 1, 1);

        lblCondVita.setBuddy(comboCondVita);
        lblCondSag.setBuddy(comboCondSag);
        lblCondForce.setBuddy(comboCondForce);
        lblCondInt.setBuddy(comboCondInt);
        lblCondAli.setBuddy(comboCondAli);
        lblCondChance.setBuddy(comboCondChance);
        lblCondAgi.setBuddy(comboCondAgi);
        lblCondGrade.setBuddy(comboCondGrade);
        retranslateUi(UIConditions);

        UIConditions.connectSlotsByName();
    } // setupUi

    void retranslateUi(QWidget UIConditions)
    {
        UIConditions.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("UIConditions", "Form", null));
        lblCondVita.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIConditions", "Vitalit\u00e9", null));
        lblCondVita.setText("");
        comboCondVita.clear();
        comboCondVita.addItem(com.trolltech.qt.core.QCoreApplication.translate("UIConditions", ">", null));
        comboCondVita.addItem(com.trolltech.qt.core.QCoreApplication.translate("UIConditions", "<", null));
        comboCondVita.addItem(com.trolltech.qt.core.QCoreApplication.translate("UIConditions", "=", null));
        lblCondSag.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIConditions", "Sagesse", null));
        lblCondSag.setText("");
        comboCondSag.clear();
        comboCondSag.addItem(com.trolltech.qt.core.QCoreApplication.translate("UIConditions", ">", null));
        comboCondSag.addItem(com.trolltech.qt.core.QCoreApplication.translate("UIConditions", "<", null));
        comboCondSag.addItem(com.trolltech.qt.core.QCoreApplication.translate("UIConditions", "=", null));
        lblCondSexe.setText(com.trolltech.qt.core.QCoreApplication.translate("UIConditions", "Sexe :", null));
        comboCondSexe.clear();
        comboCondSexe.addItem(com.trolltech.qt.core.QCoreApplication.translate("UIConditions", "<Aucun>", null));
        comboCondSexe.addItem(com.trolltech.qt.core.QCoreApplication.translate("UIConditions", "Masculin", null));
        comboCondSexe.addItem(com.trolltech.qt.core.QCoreApplication.translate("UIConditions", "F\u00e9minin", null));
        lblCondForce.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIConditions", "Force", null));
        lblCondForce.setText("");
        comboCondForce.clear();
        comboCondForce.addItem(com.trolltech.qt.core.QCoreApplication.translate("UIConditions", ">", null));
        comboCondForce.addItem(com.trolltech.qt.core.QCoreApplication.translate("UIConditions", "<", null));
        comboCondForce.addItem(com.trolltech.qt.core.QCoreApplication.translate("UIConditions", "=", null));
        lblCondInt.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIConditions", "Intelligence", null));
        lblCondInt.setText("");
        comboCondInt.clear();
        comboCondInt.addItem(com.trolltech.qt.core.QCoreApplication.translate("UIConditions", ">", null));
        comboCondInt.addItem(com.trolltech.qt.core.QCoreApplication.translate("UIConditions", "<", null));
        comboCondInt.addItem(com.trolltech.qt.core.QCoreApplication.translate("UIConditions", "=", null));
        lblCondAli.setText(com.trolltech.qt.core.QCoreApplication.translate("UIConditions", "Alignement :", null));
        comboCondAli.clear();
        comboCondAli.addItem(com.trolltech.qt.core.QCoreApplication.translate("UIConditions", "<Aucun>", null));
        comboCondAli.addItem(com.trolltech.qt.core.QCoreApplication.translate("UIConditions", "Bonta", null));
        comboCondAli.addItem(com.trolltech.qt.core.QCoreApplication.translate("UIConditions", "Br\u00e2kmar", null));
        comboCondAli.addItem(com.trolltech.qt.core.QCoreApplication.translate("UIConditions", "Mercenaire", null));
        lblCondChance.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIConditions", "Chance", null));
        lblCondChance.setText("");
        comboCondChance.clear();
        comboCondChance.addItem(com.trolltech.qt.core.QCoreApplication.translate("UIConditions", ">", null));
        comboCondChance.addItem(com.trolltech.qt.core.QCoreApplication.translate("UIConditions", "<", null));
        comboCondChance.addItem(com.trolltech.qt.core.QCoreApplication.translate("UIConditions", "=", null));
        lblCondAgi.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIConditions", "Agilit\u00e9", null));
        lblCondAgi.setText("");
        comboCondAgi.clear();
        comboCondAgi.addItem(com.trolltech.qt.core.QCoreApplication.translate("UIConditions", ">", null));
        comboCondAgi.addItem(com.trolltech.qt.core.QCoreApplication.translate("UIConditions", "<", null));
        comboCondAgi.addItem(com.trolltech.qt.core.QCoreApplication.translate("UIConditions", "=", null));
        lblCondGrade.setText(com.trolltech.qt.core.QCoreApplication.translate("UIConditions", "Grade :", null));
        comboCondGradeOp.clear();
        comboCondGradeOp.addItem(com.trolltech.qt.core.QCoreApplication.translate("UIConditions", ">", null));
        comboCondGradeOp.addItem(com.trolltech.qt.core.QCoreApplication.translate("UIConditions", "<", null));
        comboCondGradeOp.addItem(com.trolltech.qt.core.QCoreApplication.translate("UIConditions", "=", null));
        comboCondGrade.clear();
        comboCondGrade.addItem(com.trolltech.qt.core.QCoreApplication.translate("UIConditions", "<Aucun>", null));
        comboCondGrade.addItem(com.trolltech.qt.core.QCoreApplication.translate("UIConditions", "0", null));
        comboCondGrade.addItem(com.trolltech.qt.core.QCoreApplication.translate("UIConditions", "1", null));
        comboCondGrade.addItem(com.trolltech.qt.core.QCoreApplication.translate("UIConditions", "2", null));
        comboCondGrade.addItem(com.trolltech.qt.core.QCoreApplication.translate("UIConditions", "3", null));
        comboCondGrade.addItem(com.trolltech.qt.core.QCoreApplication.translate("UIConditions", "4", null));
        comboCondGrade.addItem(com.trolltech.qt.core.QCoreApplication.translate("UIConditions", "5", null));
        comboCondGrade.addItem(com.trolltech.qt.core.QCoreApplication.translate("UIConditions", "6", null));
        comboCondGrade.addItem(com.trolltech.qt.core.QCoreApplication.translate("UIConditions", "7", null));
        comboCondGrade.addItem(com.trolltech.qt.core.QCoreApplication.translate("UIConditions", "8", null));
        comboCondGrade.addItem(com.trolltech.qt.core.QCoreApplication.translate("UIConditions", "9", null));
        comboCondGrade.addItem(com.trolltech.qt.core.QCoreApplication.translate("UIConditions", "10", null));
        lblCondClasse.setText(com.trolltech.qt.core.QCoreApplication.translate("UIConditions", "Classe :", null));
    } // retranslateUi

}

