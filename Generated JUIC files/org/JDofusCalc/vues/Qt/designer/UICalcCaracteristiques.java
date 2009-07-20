/********************************************************************************
** Form generated from reading ui file 'UICalcCaracteristiques.jui'
**
** Created: mer. 24. juin 12:04:03 2009
**      by: Qt User Interface Compiler version 4.5.0
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

package org.JDofusCalc.vues.Qt.designer;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class UICalcCaracteristiques implements com.trolltech.qt.QUiForm<QWidget>
{
    public QGridLayout gridLayout_3;
    public QGroupBox grpCalc;
    public QGridLayout gridLayout_2;
    public QLabel lblActuel;
    public QLabel lblPoints;
    public QLabel lblVita;
    public QLabel lblVitaActuel;
    public QSpinBox sbVita;
    public QLabel lblVitaPoints;
    public QLabel lblSag;
    public QLabel lblSagActuel;
    public QSpinBox sbSag;
    public QLabel lblSagPoints;
    public QLabel lblForce;
    public QLabel lblForceActuel;
    public QSpinBox sbForce;
    public QLabel lblForcePoints;
    public QLabel lblInt;
    public QLabel lblIntActuel;
    public QSpinBox sbInt;
    public QLabel lblIntPoints;
    public QLabel lblChance;
    public QLabel lblChanceActuel;
    public QSpinBox sbChance;
    public QLabel lblChancePoints;
    public QLabel lblAgi;
    public QLabel lblAgiActuel;
    public QSpinBox sbAgi;
    public QLabel lblAgiPoints;
    public QLabel lblPrevu;
    public QLabel icoVita;
    public QLabel icoSagesse;
    public QLabel icoForce;
    public QLabel icoInt;
    public QLabel icoChance;
    public QLabel icoAgi;
    public QLabel lblTotal;
    public QLabel lblCoutTotal;
    public QLabel lblNiveaux;
    public QGroupBox grpPaliers;
    public QGridLayout gridLayout;
    public QLabel lbl;
    public QLabel lblClasse;
    public QTableWidget tableauPaliers;
    public QPushButton btnFermer;
    public QSpacerItem horizontalSpacer;

    public UICalcCaracteristiques() { super(); }

    public void setupUi(QWidget UICalcCaracteristiques)
    {
        UICalcCaracteristiques.setObjectName("UICalcCaracteristiques");
        UICalcCaracteristiques.resize(new QSize(635, 306).expandedTo(UICalcCaracteristiques.minimumSizeHint()));
        gridLayout_3 = new QGridLayout(UICalcCaracteristiques);
        gridLayout_3.setObjectName("gridLayout_3");
        grpCalc = new QGroupBox(UICalcCaracteristiques);
        grpCalc.setObjectName("grpCalc");
        QSizePolicy sizePolicy = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);
        sizePolicy.setHorizontalStretch((byte)0);
        sizePolicy.setVerticalStretch((byte)0);
        sizePolicy.setHeightForWidth(grpCalc.sizePolicy().hasHeightForWidth());
        grpCalc.setSizePolicy(sizePolicy);
        gridLayout_2 = new QGridLayout(grpCalc);
        gridLayout_2.setObjectName("gridLayout_2");
        lblActuel = new QLabel(grpCalc);
        lblActuel.setObjectName("lblActuel");
        lblActuel.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(lblActuel, 0, 2, 1, 1);

        lblPoints = new QLabel(grpCalc);
        lblPoints.setObjectName("lblPoints");
        QSizePolicy sizePolicy1 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Preferred);
        sizePolicy1.setHorizontalStretch((byte)0);
        sizePolicy1.setVerticalStretch((byte)0);
        sizePolicy1.setHeightForWidth(lblPoints.sizePolicy().hasHeightForWidth());
        lblPoints.setSizePolicy(sizePolicy1);
        lblPoints.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(lblPoints, 0, 4, 1, 1);

        lblVita = new QLabel(grpCalc);
        lblVita.setObjectName("lblVita");

        gridLayout_2.addWidget(lblVita, 1, 1, 1, 1);

        lblVitaActuel = new QLabel(grpCalc);
        lblVitaActuel.setObjectName("lblVitaActuel");
        QSizePolicy sizePolicy2 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Preferred, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);
        sizePolicy2.setHorizontalStretch((byte)0);
        sizePolicy2.setVerticalStretch((byte)0);
        sizePolicy2.setHeightForWidth(lblVitaActuel.sizePolicy().hasHeightForWidth());
        lblVitaActuel.setSizePolicy(sizePolicy2);
        lblVitaActuel.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblVitaActuel.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(lblVitaActuel, 1, 2, 1, 1);

        sbVita = new QSpinBox(grpCalc);
        sbVita.setObjectName("sbVita");
        sbVita.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.WheelFocus);
        sbVita.setMaximum(999);

        gridLayout_2.addWidget(sbVita, 1, 3, 1, 1);

        lblVitaPoints = new QLabel(grpCalc);
        lblVitaPoints.setObjectName("lblVitaPoints");
        QSizePolicy sizePolicy3 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Preferred, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);
        sizePolicy3.setHorizontalStretch((byte)0);
        sizePolicy3.setVerticalStretch((byte)0);
        sizePolicy3.setHeightForWidth(lblVitaPoints.sizePolicy().hasHeightForWidth());
        lblVitaPoints.setSizePolicy(sizePolicy3);
        lblVitaPoints.setMinimumSize(new QSize(30, 20));
        lblVitaPoints.setMaximumSize(new QSize(30, 20));
        lblVitaPoints.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblVitaPoints.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(lblVitaPoints, 1, 4, 1, 1);

        lblSag = new QLabel(grpCalc);
        lblSag.setObjectName("lblSag");

        gridLayout_2.addWidget(lblSag, 2, 1, 1, 1);

        lblSagActuel = new QLabel(grpCalc);
        lblSagActuel.setObjectName("lblSagActuel");
        QSizePolicy sizePolicy4 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Preferred, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);
        sizePolicy4.setHorizontalStretch((byte)0);
        sizePolicy4.setVerticalStretch((byte)0);
        sizePolicy4.setHeightForWidth(lblSagActuel.sizePolicy().hasHeightForWidth());
        lblSagActuel.setSizePolicy(sizePolicy4);
        lblSagActuel.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblSagActuel.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(lblSagActuel, 2, 2, 1, 1);

        sbSag = new QSpinBox(grpCalc);
        sbSag.setObjectName("sbSag");
        sbSag.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.WheelFocus);
        sbSag.setMaximum(999);

        gridLayout_2.addWidget(sbSag, 2, 3, 1, 1);

        lblSagPoints = new QLabel(grpCalc);
        lblSagPoints.setObjectName("lblSagPoints");
        QSizePolicy sizePolicy5 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Preferred, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);
        sizePolicy5.setHorizontalStretch((byte)0);
        sizePolicy5.setVerticalStretch((byte)0);
        sizePolicy5.setHeightForWidth(lblSagPoints.sizePolicy().hasHeightForWidth());
        lblSagPoints.setSizePolicy(sizePolicy5);
        lblSagPoints.setMinimumSize(new QSize(30, 20));
        lblSagPoints.setMaximumSize(new QSize(30, 20));
        lblSagPoints.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblSagPoints.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(lblSagPoints, 2, 4, 1, 1);

        lblForce = new QLabel(grpCalc);
        lblForce.setObjectName("lblForce");

        gridLayout_2.addWidget(lblForce, 3, 1, 1, 1);

        lblForceActuel = new QLabel(grpCalc);
        lblForceActuel.setObjectName("lblForceActuel");
        QSizePolicy sizePolicy6 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Preferred, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);
        sizePolicy6.setHorizontalStretch((byte)0);
        sizePolicy6.setVerticalStretch((byte)0);
        sizePolicy6.setHeightForWidth(lblForceActuel.sizePolicy().hasHeightForWidth());
        lblForceActuel.setSizePolicy(sizePolicy6);
        lblForceActuel.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblForceActuel.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(lblForceActuel, 3, 2, 1, 1);

        sbForce = new QSpinBox(grpCalc);
        sbForce.setObjectName("sbForce");
        sbForce.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.WheelFocus);
        sbForce.setMaximum(999);

        gridLayout_2.addWidget(sbForce, 3, 3, 1, 1);

        lblForcePoints = new QLabel(grpCalc);
        lblForcePoints.setObjectName("lblForcePoints");
        QSizePolicy sizePolicy7 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Preferred, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);
        sizePolicy7.setHorizontalStretch((byte)0);
        sizePolicy7.setVerticalStretch((byte)0);
        sizePolicy7.setHeightForWidth(lblForcePoints.sizePolicy().hasHeightForWidth());
        lblForcePoints.setSizePolicy(sizePolicy7);
        lblForcePoints.setMinimumSize(new QSize(30, 20));
        lblForcePoints.setMaximumSize(new QSize(30, 20));
        lblForcePoints.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblForcePoints.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(lblForcePoints, 3, 4, 1, 1);

        lblInt = new QLabel(grpCalc);
        lblInt.setObjectName("lblInt");

        gridLayout_2.addWidget(lblInt, 4, 1, 1, 1);

        lblIntActuel = new QLabel(grpCalc);
        lblIntActuel.setObjectName("lblIntActuel");
        QSizePolicy sizePolicy8 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Preferred, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);
        sizePolicy8.setHorizontalStretch((byte)0);
        sizePolicy8.setVerticalStretch((byte)0);
        sizePolicy8.setHeightForWidth(lblIntActuel.sizePolicy().hasHeightForWidth());
        lblIntActuel.setSizePolicy(sizePolicy8);
        lblIntActuel.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblIntActuel.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(lblIntActuel, 4, 2, 1, 1);

        sbInt = new QSpinBox(grpCalc);
        sbInt.setObjectName("sbInt");
        sbInt.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.WheelFocus);
        sbInt.setMaximum(999);

        gridLayout_2.addWidget(sbInt, 4, 3, 1, 1);

        lblIntPoints = new QLabel(grpCalc);
        lblIntPoints.setObjectName("lblIntPoints");
        QSizePolicy sizePolicy9 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Preferred, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);
        sizePolicy9.setHorizontalStretch((byte)0);
        sizePolicy9.setVerticalStretch((byte)0);
        sizePolicy9.setHeightForWidth(lblIntPoints.sizePolicy().hasHeightForWidth());
        lblIntPoints.setSizePolicy(sizePolicy9);
        lblIntPoints.setMinimumSize(new QSize(30, 20));
        lblIntPoints.setMaximumSize(new QSize(30, 20));
        lblIntPoints.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblIntPoints.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(lblIntPoints, 4, 4, 1, 1);

        lblChance = new QLabel(grpCalc);
        lblChance.setObjectName("lblChance");

        gridLayout_2.addWidget(lblChance, 5, 1, 1, 1);

        lblChanceActuel = new QLabel(grpCalc);
        lblChanceActuel.setObjectName("lblChanceActuel");
        QSizePolicy sizePolicy10 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Preferred, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);
        sizePolicy10.setHorizontalStretch((byte)0);
        sizePolicy10.setVerticalStretch((byte)0);
        sizePolicy10.setHeightForWidth(lblChanceActuel.sizePolicy().hasHeightForWidth());
        lblChanceActuel.setSizePolicy(sizePolicy10);
        lblChanceActuel.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblChanceActuel.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(lblChanceActuel, 5, 2, 1, 1);

        sbChance = new QSpinBox(grpCalc);
        sbChance.setObjectName("sbChance");
        sbChance.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.WheelFocus);
        sbChance.setMaximum(999);

        gridLayout_2.addWidget(sbChance, 5, 3, 1, 1);

        lblChancePoints = new QLabel(grpCalc);
        lblChancePoints.setObjectName("lblChancePoints");
        QSizePolicy sizePolicy11 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Preferred, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);
        sizePolicy11.setHorizontalStretch((byte)0);
        sizePolicy11.setVerticalStretch((byte)0);
        sizePolicy11.setHeightForWidth(lblChancePoints.sizePolicy().hasHeightForWidth());
        lblChancePoints.setSizePolicy(sizePolicy11);
        lblChancePoints.setMinimumSize(new QSize(30, 20));
        lblChancePoints.setMaximumSize(new QSize(30, 20));
        lblChancePoints.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblChancePoints.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(lblChancePoints, 5, 4, 1, 1);

        lblAgi = new QLabel(grpCalc);
        lblAgi.setObjectName("lblAgi");

        gridLayout_2.addWidget(lblAgi, 6, 1, 1, 1);

        lblAgiActuel = new QLabel(grpCalc);
        lblAgiActuel.setObjectName("lblAgiActuel");
        QSizePolicy sizePolicy12 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Preferred, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);
        sizePolicy12.setHorizontalStretch((byte)0);
        sizePolicy12.setVerticalStretch((byte)0);
        sizePolicy12.setHeightForWidth(lblAgiActuel.sizePolicy().hasHeightForWidth());
        lblAgiActuel.setSizePolicy(sizePolicy12);
        lblAgiActuel.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblAgiActuel.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(lblAgiActuel, 6, 2, 1, 1);

        sbAgi = new QSpinBox(grpCalc);
        sbAgi.setObjectName("sbAgi");
        sbAgi.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.WheelFocus);
        sbAgi.setMaximum(999);

        gridLayout_2.addWidget(sbAgi, 6, 3, 1, 1);

        lblAgiPoints = new QLabel(grpCalc);
        lblAgiPoints.setObjectName("lblAgiPoints");
        QSizePolicy sizePolicy13 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Preferred, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);
        sizePolicy13.setHorizontalStretch((byte)0);
        sizePolicy13.setVerticalStretch((byte)0);
        sizePolicy13.setHeightForWidth(lblAgiPoints.sizePolicy().hasHeightForWidth());
        lblAgiPoints.setSizePolicy(sizePolicy13);
        lblAgiPoints.setMinimumSize(new QSize(30, 20));
        lblAgiPoints.setMaximumSize(new QSize(30, 20));
        lblAgiPoints.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblAgiPoints.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(lblAgiPoints, 6, 4, 1, 1);

        lblPrevu = new QLabel(grpCalc);
        lblPrevu.setObjectName("lblPrevu");
        lblPrevu.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(lblPrevu, 0, 3, 1, 1);

        icoVita = new QLabel(grpCalc);
        icoVita.setObjectName("icoVita");
        icoVita.setPixmap(new QPixmap());

        gridLayout_2.addWidget(icoVita, 1, 0, 1, 1);

        icoSagesse = new QLabel(grpCalc);
        icoSagesse.setObjectName("icoSagesse");
        icoSagesse.setPixmap(new QPixmap());

        gridLayout_2.addWidget(icoSagesse, 2, 0, 1, 1);

        icoForce = new QLabel(grpCalc);
        icoForce.setObjectName("icoForce");
        icoForce.setPixmap(new QPixmap());

        gridLayout_2.addWidget(icoForce, 3, 0, 1, 1);

        icoInt = new QLabel(grpCalc);
        icoInt.setObjectName("icoInt");
        icoInt.setPixmap(new QPixmap());

        gridLayout_2.addWidget(icoInt, 4, 0, 1, 1);

        icoChance = new QLabel(grpCalc);
        icoChance.setObjectName("icoChance");
        icoChance.setPixmap(new QPixmap());

        gridLayout_2.addWidget(icoChance, 5, 0, 1, 1);

        icoAgi = new QLabel(grpCalc);
        icoAgi.setObjectName("icoAgi");
        icoAgi.setPixmap(new QPixmap());

        gridLayout_2.addWidget(icoAgi, 6, 0, 1, 1);

        lblTotal = new QLabel(grpCalc);
        lblTotal.setObjectName("lblTotal");
        lblTotal.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(lblTotal, 7, 2, 1, 2);

        lblCoutTotal = new QLabel(grpCalc);
        lblCoutTotal.setObjectName("lblCoutTotal");
        QSizePolicy sizePolicy14 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Preferred, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);
        sizePolicy14.setHorizontalStretch((byte)0);
        sizePolicy14.setVerticalStretch((byte)0);
        sizePolicy14.setHeightForWidth(lblCoutTotal.sizePolicy().hasHeightForWidth());
        lblCoutTotal.setSizePolicy(sizePolicy14);
        lblCoutTotal.setMinimumSize(new QSize(30, 20));
        lblCoutTotal.setMaximumSize(new QSize(30, 20));
        lblCoutTotal.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblCoutTotal.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(lblCoutTotal, 7, 4, 1, 1);

        lblNiveaux = new QLabel(grpCalc);
        lblNiveaux.setObjectName("lblNiveaux");
        lblNiveaux.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(lblNiveaux, 8, 2, 1, 3);


        gridLayout_3.addWidget(grpCalc, 0, 1, 1, 1);

        grpPaliers = new QGroupBox(UICalcCaracteristiques);
        grpPaliers.setObjectName("grpPaliers");
        QSizePolicy sizePolicy15 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);
        sizePolicy15.setHorizontalStretch((byte)0);
        sizePolicy15.setVerticalStretch((byte)0);
        sizePolicy15.setHeightForWidth(grpPaliers.sizePolicy().hasHeightForWidth());
        grpPaliers.setSizePolicy(sizePolicy15);
        gridLayout = new QGridLayout(grpPaliers);
        gridLayout.setObjectName("gridLayout");
        lbl = new QLabel(grpPaliers);
        lbl.setObjectName("lbl");
        QSizePolicy sizePolicy16 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy16.setHorizontalStretch((byte)0);
        sizePolicy16.setVerticalStretch((byte)0);
        sizePolicy16.setHeightForWidth(lbl.sizePolicy().hasHeightForWidth());
        lbl.setSizePolicy(sizePolicy16);

        gridLayout.addWidget(lbl, 0, 0, 1, 1);

        lblClasse = new QLabel(grpPaliers);
        lblClasse.setObjectName("lblClasse");
        QFont font = new QFont();
        font.setBold(true);
        font.setWeight(75);
        lblClasse.setFont(font);

        gridLayout.addWidget(lblClasse, 0, 1, 1, 1);

        tableauPaliers = new QTableWidget(grpPaliers);
        tableauPaliers.setObjectName("tableauPaliers");
        tableauPaliers.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.WheelFocus);
        tableauPaliers.setEditTriggers(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.createQFlags(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.NoEditTriggers));
        tableauPaliers.setSelectionMode(com.trolltech.qt.gui.QAbstractItemView.SelectionMode.NoSelection);

        gridLayout.addWidget(tableauPaliers, 1, 0, 1, 2);


        gridLayout_3.addWidget(grpPaliers, 0, 2, 1, 2);

        btnFermer = new QPushButton(UICalcCaracteristiques);
        btnFermer.setObjectName("btnFermer");
        btnFermer.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        btnFermer.setIcon(new QIcon(new QPixmap("classpath:org/JDofusCalc/ressources/images/exit.png")));
        btnFermer.setIconSize(new QSize(24, 24));

        gridLayout_3.addWidget(btnFermer, 1, 3, 1, 1);

        horizontalSpacer = new QSpacerItem(0, 0, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        gridLayout_3.addItem(horizontalSpacer, 1, 2, 1, 1);

        retranslateUi(UICalcCaracteristiques);

        UICalcCaracteristiques.connectSlotsByName();
    } // setupUi

    void retranslateUi(QWidget UICalcCaracteristiques)
    {
        UICalcCaracteristiques.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("UICalcCaracteristiques", "Calculateur de caract\u00e9ristiques", null));
        grpCalc.setTitle(com.trolltech.qt.core.QCoreApplication.translate("UICalcCaracteristiques", "Calculateur", null));
        lblActuel.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCaracteristiques", "Actuel", null));
        lblPoints.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCaracteristiques", "Co\u00fbt", null));
        lblVita.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCaracteristiques", "Vitalit\u00e9", null));
        lblVitaActuel.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCaracteristiques", "0", null));
        lblVitaPoints.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCaracteristiques", "0", null));
        lblSag.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCaracteristiques", "Sagesse", null));
        lblSagActuel.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCaracteristiques", "0", null));
        lblSagPoints.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCaracteristiques", "0", null));
        lblForce.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCaracteristiques", "Force", null));
        lblForceActuel.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCaracteristiques", "0", null));
        lblForcePoints.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCaracteristiques", "0", null));
        lblInt.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCaracteristiques", "Intelligence", null));
        lblIntActuel.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCaracteristiques", "0", null));
        lblIntPoints.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCaracteristiques", "0", null));
        lblChance.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCaracteristiques", "Chance", null));
        lblChanceActuel.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCaracteristiques", "0", null));
        lblChancePoints.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCaracteristiques", "0", null));
        lblAgi.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCaracteristiques", "Agilit\u00e9", null));
        lblAgiActuel.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCaracteristiques", "0", null));
        lblAgiPoints.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCaracteristiques", "0", null));
        lblPrevu.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCaracteristiques", "Pr\u00e9vu", null));
        lblTotal.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCaracteristiques", "Total :", null));
        lblCoutTotal.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCaracteristiques", "0", null));
        lblNiveaux.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCaracteristiques", "Soit <strong>0 niveau(x)</strong>.", null));
        grpPaliers.setTitle(com.trolltech.qt.core.QCoreApplication.translate("UICalcCaracteristiques", "Paliers de classe", null));
        lbl.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCaracteristiques", "Classe :", null));
        lblClasse.setText("");
        tableauPaliers.clear();
        tableauPaliers.setColumnCount(6);

        QTableWidgetItem __colItem = new QTableWidgetItem();
        __colItem.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCaracteristiques", "1 pour 2", null));
        tableauPaliers.setHorizontalHeaderItem(0, __colItem);

        QTableWidgetItem __colItem1 = new QTableWidgetItem();
        __colItem1.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCaracteristiques", "1 pour 1", null));
        tableauPaliers.setHorizontalHeaderItem(1, __colItem1);

        QTableWidgetItem __colItem2 = new QTableWidgetItem();
        __colItem2.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCaracteristiques", "2 pour 1", null));
        tableauPaliers.setHorizontalHeaderItem(2, __colItem2);

        QTableWidgetItem __colItem3 = new QTableWidgetItem();
        __colItem3.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCaracteristiques", "3 pour 1", null));
        tableauPaliers.setHorizontalHeaderItem(3, __colItem3);

        QTableWidgetItem __colItem4 = new QTableWidgetItem();
        __colItem4.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCaracteristiques", "4 pour 1", null));
        tableauPaliers.setHorizontalHeaderItem(4, __colItem4);

        QTableWidgetItem __colItem5 = new QTableWidgetItem();
        __colItem5.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCaracteristiques", "5 pour 1", null));
        tableauPaliers.setHorizontalHeaderItem(5, __colItem5);
        tableauPaliers.setRowCount(6);

        QTableWidgetItem __rowItem = new QTableWidgetItem();
        __rowItem.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCaracteristiques", "Vitalit\u00e9", null));
        tableauPaliers.setVerticalHeaderItem(0, __rowItem);

        QTableWidgetItem __rowItem1 = new QTableWidgetItem();
        __rowItem1.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCaracteristiques", "Sagesse", null));
        tableauPaliers.setVerticalHeaderItem(1, __rowItem1);

        QTableWidgetItem __rowItem2 = new QTableWidgetItem();
        __rowItem2.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCaracteristiques", "Force", null));
        tableauPaliers.setVerticalHeaderItem(2, __rowItem2);

        QTableWidgetItem __rowItem3 = new QTableWidgetItem();
        __rowItem3.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCaracteristiques", "Intelligence", null));
        tableauPaliers.setVerticalHeaderItem(3, __rowItem3);

        QTableWidgetItem __rowItem4 = new QTableWidgetItem();
        __rowItem4.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCaracteristiques", "Chance", null));
        tableauPaliers.setVerticalHeaderItem(4, __rowItem4);

        QTableWidgetItem __rowItem5 = new QTableWidgetItem();
        __rowItem5.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCaracteristiques", "Agilit\u00e9", null));
        tableauPaliers.setVerticalHeaderItem(5, __rowItem5);
        btnFermer.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCaracteristiques", "Fermer", null));
    } // retranslateUi

}

