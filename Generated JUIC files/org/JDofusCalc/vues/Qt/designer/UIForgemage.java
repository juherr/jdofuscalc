/********************************************************************************
** Form generated from reading ui file 'UIForgemage.jui'
**
** Created: mer. 24. juin 12:06:10 2009
**      by: Qt User Interface Compiler version 4.5.0
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

package org.JDofusCalc.vues.Qt.designer;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class UIForgemage implements com.trolltech.qt.QUiForm<QWidget>
{
    public QGridLayout gridLayout;
    public QGroupBox grpNautre;
    public QVBoxLayout verticalLayout;
    public QRadioButton rbtnTerre;
    public QRadioButton rbtnFeu;
    public QRadioButton rbtnEau;
    public QRadioButton rbtnAir;
    public QGroupBox grpPuissance;
    public QVBoxLayout verticalLayout_2;
    public QRadioButton rbtnPForte;
    public QRadioButton rbtnPMoy;
    public QRadioButton rbtnPFaible;
    public QPushButton btnFermer;
    public QPushButton btnForgemager;
    public QGroupBox grpRes;
    public QGridLayout gridLayout_2;
    public QLabel lblJetsMin;
    public QLabel flecheMin;
    public QLabel flecheMax;
    public QLabel lblJetsMaxFM;
    public QLabel lblBase;
    public QLabel lblFM;
    public QFrame line;
    public QLabel lblJetsMax;
    public QLabel lblJetsMinFM;

    public UIForgemage() { super(); }

    public void setupUi(QWidget UIForgemage)
    {
        UIForgemage.setObjectName("UIForgemage");
        UIForgemage.setWindowModality(com.trolltech.qt.core.Qt.WindowModality.WindowModal);
        UIForgemage.resize(new QSize(360, 237).expandedTo(UIForgemage.minimumSizeHint()));
        gridLayout = new QGridLayout(UIForgemage);
        gridLayout.setObjectName("gridLayout");
        grpNautre = new QGroupBox(UIForgemage);
        grpNautre.setObjectName("grpNautre");
        QSizePolicy sizePolicy = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);
        sizePolicy.setHorizontalStretch((byte)0);
        sizePolicy.setVerticalStretch((byte)0);
        sizePolicy.setHeightForWidth(grpNautre.sizePolicy().hasHeightForWidth());
        grpNautre.setSizePolicy(sizePolicy);
        verticalLayout = new QVBoxLayout(grpNautre);
        verticalLayout.setObjectName("verticalLayout");
        rbtnTerre = new QRadioButton(grpNautre);
        rbtnTerre.setObjectName("rbtnTerre");
        QSizePolicy sizePolicy1 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy1.setHorizontalStretch((byte)0);
        sizePolicy1.setVerticalStretch((byte)0);
        sizePolicy1.setHeightForWidth(rbtnTerre.sizePolicy().hasHeightForWidth());
        rbtnTerre.setSizePolicy(sizePolicy1);
        rbtnTerre.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        rbtnTerre.setIcon(new QIcon(new QPixmap("classpath:org/JDofusCalc/ressources/images/fm_terre.png")));
        rbtnTerre.setChecked(true);

        verticalLayout.addWidget(rbtnTerre);

        rbtnFeu = new QRadioButton(grpNautre);
        rbtnFeu.setObjectName("rbtnFeu");
        QSizePolicy sizePolicy2 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy2.setHorizontalStretch((byte)0);
        sizePolicy2.setVerticalStretch((byte)0);
        sizePolicy2.setHeightForWidth(rbtnFeu.sizePolicy().hasHeightForWidth());
        rbtnFeu.setSizePolicy(sizePolicy2);
        rbtnFeu.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        rbtnFeu.setIcon(new QIcon(new QPixmap("classpath:org/JDofusCalc/ressources/images/fm_feu.png")));

        verticalLayout.addWidget(rbtnFeu);

        rbtnEau = new QRadioButton(grpNautre);
        rbtnEau.setObjectName("rbtnEau");
        QSizePolicy sizePolicy3 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy3.setHorizontalStretch((byte)0);
        sizePolicy3.setVerticalStretch((byte)0);
        sizePolicy3.setHeightForWidth(rbtnEau.sizePolicy().hasHeightForWidth());
        rbtnEau.setSizePolicy(sizePolicy3);
        rbtnEau.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        rbtnEau.setIcon(new QIcon(new QPixmap("classpath:org/JDofusCalc/ressources/images/fm_eau.png")));

        verticalLayout.addWidget(rbtnEau);

        rbtnAir = new QRadioButton(grpNautre);
        rbtnAir.setObjectName("rbtnAir");
        QSizePolicy sizePolicy4 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy4.setHorizontalStretch((byte)0);
        sizePolicy4.setVerticalStretch((byte)0);
        sizePolicy4.setHeightForWidth(rbtnAir.sizePolicy().hasHeightForWidth());
        rbtnAir.setSizePolicy(sizePolicy4);
        rbtnAir.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        rbtnAir.setIcon(new QIcon(new QPixmap("classpath:org/JDofusCalc/ressources/images/fm_air.png")));

        verticalLayout.addWidget(rbtnAir);


        gridLayout.addWidget(grpNautre, 0, 0, 2, 1);

        grpPuissance = new QGroupBox(UIForgemage);
        grpPuissance.setObjectName("grpPuissance");
        QSizePolicy sizePolicy5 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);
        sizePolicy5.setHorizontalStretch((byte)0);
        sizePolicy5.setVerticalStretch((byte)0);
        sizePolicy5.setHeightForWidth(grpPuissance.sizePolicy().hasHeightForWidth());
        grpPuissance.setSizePolicy(sizePolicy5);
        verticalLayout_2 = new QVBoxLayout(grpPuissance);
        verticalLayout_2.setObjectName("verticalLayout_2");
        rbtnPForte = new QRadioButton(grpPuissance);
        rbtnPForte.setObjectName("rbtnPForte");
        QSizePolicy sizePolicy6 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy6.setHorizontalStretch((byte)0);
        sizePolicy6.setVerticalStretch((byte)0);
        sizePolicy6.setHeightForWidth(rbtnPForte.sizePolicy().hasHeightForWidth());
        rbtnPForte.setSizePolicy(sizePolicy6);
        rbtnPForte.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        rbtnPForte.setChecked(true);

        verticalLayout_2.addWidget(rbtnPForte);

        rbtnPMoy = new QRadioButton(grpPuissance);
        rbtnPMoy.setObjectName("rbtnPMoy");
        QSizePolicy sizePolicy7 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy7.setHorizontalStretch((byte)0);
        sizePolicy7.setVerticalStretch((byte)0);
        sizePolicy7.setHeightForWidth(rbtnPMoy.sizePolicy().hasHeightForWidth());
        rbtnPMoy.setSizePolicy(sizePolicy7);
        rbtnPMoy.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);

        verticalLayout_2.addWidget(rbtnPMoy);

        rbtnPFaible = new QRadioButton(grpPuissance);
        rbtnPFaible.setObjectName("rbtnPFaible");
        QSizePolicy sizePolicy8 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy8.setHorizontalStretch((byte)0);
        sizePolicy8.setVerticalStretch((byte)0);
        sizePolicy8.setHeightForWidth(rbtnPFaible.sizePolicy().hasHeightForWidth());
        rbtnPFaible.setSizePolicy(sizePolicy8);
        rbtnPFaible.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);

        verticalLayout_2.addWidget(rbtnPFaible);


        gridLayout.addWidget(grpPuissance, 0, 1, 2, 1);

        btnFermer = new QPushButton(UIForgemage);
        btnFermer.setObjectName("btnFermer");
        btnFermer.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        btnFermer.setIcon(new QIcon(new QPixmap("classpath:org/JDofusCalc/ressources/images/exit.png")));
        btnFermer.setIconSize(new QSize(24, 24));

        gridLayout.addWidget(btnFermer, 4, 2, 1, 1);

        btnForgemager = new QPushButton(UIForgemage);
        btnForgemager.setObjectName("btnForgemager");
        btnForgemager.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        btnForgemager.setIcon(new QIcon(new QPixmap("classpath:org/JDofusCalc/ressources/images/fm.png")));
        btnForgemager.setIconSize(new QSize(24, 24));

        gridLayout.addWidget(btnForgemager, 3, 2, 1, 1);

        grpRes = new QGroupBox(UIForgemage);
        grpRes.setObjectName("grpRes");
        gridLayout_2 = new QGridLayout(grpRes);
        gridLayout_2.setObjectName("gridLayout_2");
        lblJetsMin = new QLabel(grpRes);
        lblJetsMin.setObjectName("lblJetsMin");
        QSizePolicy sizePolicy9 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy9.setHorizontalStretch((byte)0);
        sizePolicy9.setVerticalStretch((byte)0);
        sizePolicy9.setHeightForWidth(lblJetsMin.sizePolicy().hasHeightForWidth());
        lblJetsMin.setSizePolicy(sizePolicy9);
        lblJetsMin.setMaximumSize(new QSize(40, 16777215));
        lblJetsMin.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblJetsMin.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblJetsMin.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));
        lblJetsMin.setIndent(8);

        gridLayout_2.addWidget(lblJetsMin, 0, 2, 1, 1);

        flecheMin = new QLabel(grpRes);
        flecheMin.setObjectName("flecheMin");
        QFont font = new QFont();
        font.setBold(true);
        font.setWeight(75);
        flecheMin.setFont(font);
        flecheMin.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(flecheMin, 0, 3, 1, 1);

        flecheMax = new QLabel(grpRes);
        flecheMax.setObjectName("flecheMax");
        QFont font1 = new QFont();
        font1.setBold(true);
        font1.setWeight(75);
        flecheMax.setFont(font1);
        flecheMax.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(flecheMax, 3, 3, 1, 1);

        lblJetsMaxFM = new QLabel(grpRes);
        lblJetsMaxFM.setObjectName("lblJetsMaxFM");
        QSizePolicy sizePolicy10 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy10.setHorizontalStretch((byte)0);
        sizePolicy10.setVerticalStretch((byte)0);
        sizePolicy10.setHeightForWidth(lblJetsMaxFM.sizePolicy().hasHeightForWidth());
        lblJetsMaxFM.setSizePolicy(sizePolicy10);
        lblJetsMaxFM.setMaximumSize(new QSize(40, 16777215));
        lblJetsMaxFM.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblJetsMaxFM.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblJetsMaxFM.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(lblJetsMaxFM, 3, 4, 1, 1);

        lblBase = new QLabel(grpRes);
        lblBase.setObjectName("lblBase");

        gridLayout_2.addWidget(lblBase, 0, 0, 1, 1);

        lblFM = new QLabel(grpRes);
        lblFM.setObjectName("lblFM");

        gridLayout_2.addWidget(lblFM, 3, 0, 1, 1);

        line = new QFrame(grpRes);
        line.setObjectName("line");
        line.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.HLine);
        line.setFrameShadow(com.trolltech.qt.gui.QFrame.Shadow.Sunken);

        gridLayout_2.addWidget(line, 1, 0, 1, 5);

        lblJetsMax = new QLabel(grpRes);
        lblJetsMax.setObjectName("lblJetsMax");
        QSizePolicy sizePolicy11 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy11.setHorizontalStretch((byte)0);
        sizePolicy11.setVerticalStretch((byte)0);
        sizePolicy11.setHeightForWidth(lblJetsMax.sizePolicy().hasHeightForWidth());
        lblJetsMax.setSizePolicy(sizePolicy11);
        lblJetsMax.setMaximumSize(new QSize(40, 16777215));
        lblJetsMax.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblJetsMax.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblJetsMax.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(lblJetsMax, 0, 4, 1, 1);

        lblJetsMinFM = new QLabel(grpRes);
        lblJetsMinFM.setObjectName("lblJetsMinFM");
        QSizePolicy sizePolicy12 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy12.setHorizontalStretch((byte)0);
        sizePolicy12.setVerticalStretch((byte)0);
        sizePolicy12.setHeightForWidth(lblJetsMinFM.sizePolicy().hasHeightForWidth());
        lblJetsMinFM.setSizePolicy(sizePolicy12);
        lblJetsMinFM.setMaximumSize(new QSize(40, 16777215));
        lblJetsMinFM.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblJetsMinFM.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblJetsMinFM.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(lblJetsMinFM, 3, 2, 1, 1);


        gridLayout.addWidget(grpRes, 2, 0, 3, 2);

        retranslateUi(UIForgemage);

        UIForgemage.connectSlotsByName();
    } // setupUi

    void retranslateUi(QWidget UIForgemage)
    {
        UIForgemage.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("UIForgemage", "Forgemage", null));
        grpNautre.setTitle(com.trolltech.qt.core.QCoreApplication.translate("UIForgemage", "Nature de la potion", null));
        rbtnTerre.setText(com.trolltech.qt.core.QCoreApplication.translate("UIForgemage", "Terre", null));
        rbtnFeu.setText(com.trolltech.qt.core.QCoreApplication.translate("UIForgemage", "Feu", null));
        rbtnEau.setText(com.trolltech.qt.core.QCoreApplication.translate("UIForgemage", "Eau", null));
        rbtnAir.setText(com.trolltech.qt.core.QCoreApplication.translate("UIForgemage", "Air", null));
        grpPuissance.setTitle(com.trolltech.qt.core.QCoreApplication.translate("UIForgemage", "Puissance de la potion", null));
        rbtnPForte.setText(com.trolltech.qt.core.QCoreApplication.translate("UIForgemage", "Forte", null));
        rbtnPMoy.setText(com.trolltech.qt.core.QCoreApplication.translate("UIForgemage", "Moyenne", null));
        rbtnPFaible.setText(com.trolltech.qt.core.QCoreApplication.translate("UIForgemage", "Faible", null));
        btnFermer.setText(com.trolltech.qt.core.QCoreApplication.translate("UIForgemage", "Fermer", null));
        btnForgemager.setText(com.trolltech.qt.core.QCoreApplication.translate("UIForgemage", "Forgemager", null));
        grpRes.setTitle(com.trolltech.qt.core.QCoreApplication.translate("UIForgemage", "R\u00e9sultats", null));
        lblJetsMin.setText("");
        flecheMin.setText(com.trolltech.qt.core.QCoreApplication.translate("UIForgemage", "\u00e0", null));
        flecheMax.setText(com.trolltech.qt.core.QCoreApplication.translate("UIForgemage", "\u00e0", null));
        lblJetsMaxFM.setText("");
        lblBase.setText(com.trolltech.qt.core.QCoreApplication.translate("UIForgemage", "Jets de base", null));
        lblFM.setText(com.trolltech.qt.core.QCoreApplication.translate("UIForgemage", "Jets forgemag\u00e9s", null));
        lblJetsMax.setText("");
        lblJetsMinFM.setText("");
    } // retranslateUi

}

