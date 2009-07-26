/********************************************************************************
** Form generated from reading ui file 'UICalcTacle.jui'
**
** Created: mer. 24. juin 12:04:04 2009
**      by: Qt User Interface Compiler version 4.5.0
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

package org.JDofusCalc.vues.Qt.designer;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class UICalcTacle implements com.trolltech.qt.QUiForm<QWidget>
{
    public QGridLayout gridLayout;
    public QPushButton btnFermer;
    public QSpacerItem horizontalSpacer;
    public QGroupBox grpTacle;
    public QGridLayout gridLayout_2;
    public QLabel lblAgiPerso;
    public QSpinBox sbAgiPerso;
    public QPushButton btnGetAgi;
    public QLabel lblAgiAdv;
    public QSpinBox sbAgiAdv;
    public QLabel lblProbaTacle;
    public QLabel lblResProbaTacle;
    public QLabel lblPA;
    public QLabel lblResPA;

    public UICalcTacle() { super(); }

    public void setupUi(QWidget UICalcTacle)
    {
        UICalcTacle.setObjectName("UICalcTacle");
        UICalcTacle.setWindowModality(com.trolltech.qt.core.Qt.WindowModality.WindowModal);
        UICalcTacle.resize(new QSize(308, 191).expandedTo(UICalcTacle.minimumSizeHint()));
        gridLayout = new QGridLayout(UICalcTacle);
        gridLayout.setObjectName("gridLayout");
        btnFermer = new QPushButton(UICalcTacle);
        btnFermer.setObjectName("btnFermer");
        QSizePolicy sizePolicy = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy.setHorizontalStretch((byte)0);
        sizePolicy.setVerticalStretch((byte)0);
        sizePolicy.setHeightForWidth(btnFermer.sizePolicy().hasHeightForWidth());
        btnFermer.setSizePolicy(sizePolicy);
        btnFermer.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        btnFermer.setIcon(new QIcon(new QPixmap("classpath:org/JDofusCalc/ressources/images/exit.png")));
        btnFermer.setIconSize(new QSize(24, 24));

        gridLayout.addWidget(btnFermer, 1, 3, 1, 1);

        horizontalSpacer = new QSpacerItem(0, 0, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        gridLayout.addItem(horizontalSpacer, 1, 2, 1, 1);

        grpTacle = new QGroupBox(UICalcTacle);
        grpTacle.setObjectName("grpTacle");
        gridLayout_2 = new QGridLayout(grpTacle);
        gridLayout_2.setObjectName("gridLayout_2");
        lblAgiPerso = new QLabel(grpTacle);
        lblAgiPerso.setObjectName("lblAgiPerso");
        QSizePolicy sizePolicy1 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy1.setHorizontalStretch((byte)0);
        sizePolicy1.setVerticalStretch((byte)0);
        sizePolicy1.setHeightForWidth(lblAgiPerso.sizePolicy().hasHeightForWidth());
        lblAgiPerso.setSizePolicy(sizePolicy1);

        gridLayout_2.addWidget(lblAgiPerso, 0, 0, 1, 1);

        sbAgiPerso = new QSpinBox(grpTacle);
        sbAgiPerso.setObjectName("sbAgiPerso");
        QSizePolicy sizePolicy2 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy2.setHorizontalStretch((byte)0);
        sizePolicy2.setVerticalStretch((byte)0);
        sizePolicy2.setHeightForWidth(sbAgiPerso.sizePolicy().hasHeightForWidth());
        sbAgiPerso.setSizePolicy(sizePolicy2);
        sbAgiPerso.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.WheelFocus);
        sbAgiPerso.setMaximum(10000);

        gridLayout_2.addWidget(sbAgiPerso, 0, 1, 1, 1);

        btnGetAgi = new QPushButton(grpTacle);
        btnGetAgi.setObjectName("btnGetAgi");
        QSizePolicy sizePolicy3 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy3.setHorizontalStretch((byte)0);
        sizePolicy3.setVerticalStretch((byte)0);
        sizePolicy3.setHeightForWidth(btnGetAgi.sizePolicy().hasHeightForWidth());
        btnGetAgi.setSizePolicy(sizePolicy3);
        btnGetAgi.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        btnGetAgi.setIcon(new QIcon(new QPixmap("classpath:org/JDofusCalc/ressources/images/up.png")));
        btnGetAgi.setIconSize(new QSize(10, 10));

        gridLayout_2.addWidget(btnGetAgi, 0, 2, 1, 1);

        lblAgiAdv = new QLabel(grpTacle);
        lblAgiAdv.setObjectName("lblAgiAdv");
        QSizePolicy sizePolicy4 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy4.setHorizontalStretch((byte)0);
        sizePolicy4.setVerticalStretch((byte)0);
        sizePolicy4.setHeightForWidth(lblAgiAdv.sizePolicy().hasHeightForWidth());
        lblAgiAdv.setSizePolicy(sizePolicy4);

        gridLayout_2.addWidget(lblAgiAdv, 1, 0, 1, 1);

        sbAgiAdv = new QSpinBox(grpTacle);
        sbAgiAdv.setObjectName("sbAgiAdv");
        QSizePolicy sizePolicy5 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy5.setHorizontalStretch((byte)0);
        sizePolicy5.setVerticalStretch((byte)0);
        sizePolicy5.setHeightForWidth(sbAgiAdv.sizePolicy().hasHeightForWidth());
        sbAgiAdv.setSizePolicy(sizePolicy5);
        sbAgiAdv.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.WheelFocus);
        sbAgiAdv.setMaximum(10000);

        gridLayout_2.addWidget(sbAgiAdv, 1, 1, 1, 1);

        lblProbaTacle = new QLabel(grpTacle);
        lblProbaTacle.setObjectName("lblProbaTacle");
        QSizePolicy sizePolicy6 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy6.setHorizontalStretch((byte)0);
        sizePolicy6.setVerticalStretch((byte)0);
        sizePolicy6.setHeightForWidth(lblProbaTacle.sizePolicy().hasHeightForWidth());
        lblProbaTacle.setSizePolicy(sizePolicy6);

        gridLayout_2.addWidget(lblProbaTacle, 2, 0, 1, 1);

        lblResProbaTacle = new QLabel(grpTacle);
        lblResProbaTacle.setObjectName("lblResProbaTacle");
        QSizePolicy sizePolicy7 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy7.setHorizontalStretch((byte)0);
        sizePolicy7.setVerticalStretch((byte)0);
        sizePolicy7.setHeightForWidth(lblResProbaTacle.sizePolicy().hasHeightForWidth());
        lblResProbaTacle.setSizePolicy(sizePolicy7);
        lblResProbaTacle.setMinimumSize(new QSize(0, 20));
        lblResProbaTacle.setMaximumSize(new QSize(16777215, 20));
        lblResProbaTacle.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblResProbaTacle.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(lblResProbaTacle, 2, 1, 1, 2);

        lblPA = new QLabel(grpTacle);
        lblPA.setObjectName("lblPA");

        gridLayout_2.addWidget(lblPA, 3, 0, 1, 1);

        lblResPA = new QLabel(grpTacle);
        lblResPA.setObjectName("lblResPA");
        QSizePolicy sizePolicy8 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy8.setHorizontalStretch((byte)0);
        sizePolicy8.setVerticalStretch((byte)0);
        sizePolicy8.setHeightForWidth(lblResPA.sizePolicy().hasHeightForWidth());
        lblResPA.setSizePolicy(sizePolicy8);
        lblResPA.setMinimumSize(new QSize(0, 20));
        lblResPA.setMaximumSize(new QSize(16777215, 20));
        lblResPA.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblResPA.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(lblResPA, 3, 1, 1, 2);


        gridLayout.addWidget(grpTacle, 0, 0, 1, 4);

        retranslateUi(UICalcTacle);

        UICalcTacle.connectSlotsByName();
    } // setupUi

    void retranslateUi(QWidget UICalcTacle)
    {
        UICalcTacle.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("UICalcTacle", "Calculateur de probabilit\u00e9 de tacle", null));
        btnFermer.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcTacle", "Fermer", null));
        grpTacle.setTitle(com.trolltech.qt.core.QCoreApplication.translate("UICalcTacle", "Probabilit\u00e9 de tacle", null));
        lblAgiPerso.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcTacle", "Agilit\u00e9 du personnage :", null));
        btnGetAgi.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UICalcTacle", "Obtenir les donn\u00e9es du personnage charg\u00e9", null));
        btnGetAgi.setText("");
        lblAgiAdv.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcTacle", "Agilit\u00e9 de l'adversaire :", null));
        lblProbaTacle.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcTacle", "Probabilit\u00e9 de tacle ou d'esquive :", null));
        lblResProbaTacle.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcTacle", "?", null));
        lblPA.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcTacle", "Nombre de PAs perdus lors d'un tacle :", null));
        lblResPA.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcTacle", "?", null));
    } // retranslateUi

}

