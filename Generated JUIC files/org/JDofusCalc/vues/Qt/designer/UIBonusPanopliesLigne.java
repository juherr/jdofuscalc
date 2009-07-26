/********************************************************************************
** Form generated from reading ui file 'UIBonusPanopliesLigne.jui'
**
** Created: mer. 24. juin 12:04:03 2009
**      by: Qt User Interface Compiler version 4.5.0
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

package org.JDofusCalc.vues.Qt.designer;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class UIBonusPanopliesLigne implements com.trolltech.qt.QUiForm<QWidget>
{
    public QHBoxLayout horizontalLayout_2;
    public QLabel lblNbObjets;
    public QFrame frame;
    public QHBoxLayout horizontalLayout;
    public QFrame frameStatsGene;
    public QGridLayout gridLayout_2;
    public QLabel lblStatsPA;
    public QLabel lblStatsPM;
    public QLabel lblStatsPO;
    public QLabel lblStatsIni;
    public QLabel lblStatsPP;
    public QLabel lblStatsVie;
    public QFrame frameStatsCaract;
    public QGridLayout gridLayout_3;
    public QLabel lblStatsSag;
    public QLabel lblStatsChance;
    public QLabel lblStatsForce;
    public QLabel lblStatsInt;
    public QLabel lblStatsAgi;
    public QLabel lblStatsVita;
    public QFrame frameStatsAutre;
    public QGridLayout gridLayout_5;
    public QLabel lblStatsPDom;
    public QLabel lblStatsInvoc;
    public QLabel lblStatsCC;
    public QLabel lblStatsSoin;
    public QLabel lblStatsDomPiege;
    public QLabel lblStatsPDomPiege;
    public QLabel lblStatsEC;
    public QLabel lblStatsRenvois;
    public QLabel lblStatsDom;
    public QFrame frameStatsRes;
    public QGridLayout gridLayout_9;
    public QLabel lblStatsResMagique;
    public QLabel lblStatsResPhysique;
    public QLabel lblStatsResNeutre;
    public QLabel lblStatsPResNeutre;
    public QLabel lblStatsResTerre;
    public QLabel lblStatsPResTerre;
    public QLabel lblStatsResFeu;
    public QLabel lblStatsPResFeu;
    public QLabel lblStatsResEau;
    public QLabel lblStatsPResEau;
    public QLabel lblStatsResAir;
    public QLabel lblStatsPResAir;

    public UIBonusPanopliesLigne() { super(); }

    public void setupUi(QWidget UIBonusPanopliesLigne)
    {
        UIBonusPanopliesLigne.setObjectName("UIBonusPanopliesLigne");
        UIBonusPanopliesLigne.resize(new QSize(809, 22).expandedTo(UIBonusPanopliesLigne.minimumSizeHint()));
        horizontalLayout_2 = new QHBoxLayout(UIBonusPanopliesLigne);
        horizontalLayout_2.setSpacing(4);
        horizontalLayout_2.setMargin(0);
        horizontalLayout_2.setObjectName("horizontalLayout_2");
        lblNbObjets = new QLabel(UIBonusPanopliesLigne);
        lblNbObjets.setObjectName("lblNbObjets");

        horizontalLayout_2.addWidget(lblNbObjets);

        frame = new QFrame(UIBonusPanopliesLigne);
        frame.setObjectName("frame");
        QSizePolicy sizePolicy = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy.setHorizontalStretch((byte)0);
        sizePolicy.setVerticalStretch((byte)0);
        sizePolicy.setHeightForWidth(frame.sizePolicy().hasHeightForWidth());
        frame.setSizePolicy(sizePolicy);
        frame.setLineWidth(0);
        horizontalLayout = new QHBoxLayout(frame);
        horizontalLayout.setSpacing(2);
        horizontalLayout.setMargin(0);
        horizontalLayout.setObjectName("horizontalLayout");
        frameStatsGene = new QFrame(frame);
        frameStatsGene.setObjectName("frameStatsGene");
        QSizePolicy sizePolicy1 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy1.setHorizontalStretch((byte)0);
        sizePolicy1.setVerticalStretch((byte)0);
        sizePolicy1.setHeightForWidth(frameStatsGene.sizePolicy().hasHeightForWidth());
        frameStatsGene.setSizePolicy(sizePolicy1);
        frameStatsGene.setStyleSheet("border: 0px;");
        frameStatsGene.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        frameStatsGene.setLineWidth(0);
        gridLayout_2 = new QGridLayout(frameStatsGene);
        gridLayout_2.setSpacing(1);
        gridLayout_2.setObjectName("gridLayout_2");
        gridLayout_2.setSizeConstraint(com.trolltech.qt.gui.QLayout.SizeConstraint.SetDefaultConstraint);
        gridLayout_2.setContentsMargins(3, 1, 1, 1);
        lblStatsPA = new QLabel(frameStatsGene);
        lblStatsPA.setObjectName("lblStatsPA");
        QSizePolicy sizePolicy2 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy2.setHorizontalStretch((byte)0);
        sizePolicy2.setVerticalStretch((byte)0);
        sizePolicy2.setHeightForWidth(lblStatsPA.sizePolicy().hasHeightForWidth());
        lblStatsPA.setSizePolicy(sizePolicy2);
        lblStatsPA.setMinimumSize(new QSize(20, 20));
        lblStatsPA.setMaximumSize(new QSize(20, 20));
        lblStatsPA.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblStatsPA.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblStatsPA.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(lblStatsPA, 0, 1, 1, 1);

        lblStatsPM = new QLabel(frameStatsGene);
        lblStatsPM.setObjectName("lblStatsPM");
        QSizePolicy sizePolicy3 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy3.setHorizontalStretch((byte)0);
        sizePolicy3.setVerticalStretch((byte)0);
        sizePolicy3.setHeightForWidth(lblStatsPM.sizePolicy().hasHeightForWidth());
        lblStatsPM.setSizePolicy(sizePolicy3);
        lblStatsPM.setMinimumSize(new QSize(20, 20));
        lblStatsPM.setMaximumSize(new QSize(20, 20));
        lblStatsPM.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblStatsPM.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblStatsPM.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(lblStatsPM, 0, 2, 1, 1);

        lblStatsPO = new QLabel(frameStatsGene);
        lblStatsPO.setObjectName("lblStatsPO");
        QSizePolicy sizePolicy4 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy4.setHorizontalStretch((byte)0);
        sizePolicy4.setVerticalStretch((byte)0);
        sizePolicy4.setHeightForWidth(lblStatsPO.sizePolicy().hasHeightForWidth());
        lblStatsPO.setSizePolicy(sizePolicy4);
        lblStatsPO.setMinimumSize(new QSize(20, 20));
        lblStatsPO.setMaximumSize(new QSize(20, 20));
        lblStatsPO.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblStatsPO.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblStatsPO.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(lblStatsPO, 0, 3, 1, 1);

        lblStatsIni = new QLabel(frameStatsGene);
        lblStatsIni.setObjectName("lblStatsIni");
        QSizePolicy sizePolicy5 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy5.setHorizontalStretch((byte)0);
        sizePolicy5.setVerticalStretch((byte)0);
        sizePolicy5.setHeightForWidth(lblStatsIni.sizePolicy().hasHeightForWidth());
        lblStatsIni.setSizePolicy(sizePolicy5);
        lblStatsIni.setMinimumSize(new QSize(30, 20));
        lblStatsIni.setMaximumSize(new QSize(30, 20));
        lblStatsIni.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblStatsIni.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblStatsIni.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(lblStatsIni, 0, 4, 1, 1);

        lblStatsPP = new QLabel(frameStatsGene);
        lblStatsPP.setObjectName("lblStatsPP");
        QSizePolicy sizePolicy6 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy6.setHorizontalStretch((byte)0);
        sizePolicy6.setVerticalStretch((byte)0);
        sizePolicy6.setHeightForWidth(lblStatsPP.sizePolicy().hasHeightForWidth());
        lblStatsPP.setSizePolicy(sizePolicy6);
        lblStatsPP.setMinimumSize(new QSize(20, 20));
        lblStatsPP.setMaximumSize(new QSize(20, 20));
        lblStatsPP.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblStatsPP.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblStatsPP.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(lblStatsPP, 0, 5, 1, 1);

        lblStatsVie = new QLabel(frameStatsGene);
        lblStatsVie.setObjectName("lblStatsVie");
        QSizePolicy sizePolicy7 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy7.setHorizontalStretch((byte)0);
        sizePolicy7.setVerticalStretch((byte)0);
        sizePolicy7.setHeightForWidth(lblStatsVie.sizePolicy().hasHeightForWidth());
        lblStatsVie.setSizePolicy(sizePolicy7);
        lblStatsVie.setMinimumSize(new QSize(30, 20));
        lblStatsVie.setMaximumSize(new QSize(30, 20));
        lblStatsVie.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblStatsVie.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblStatsVie.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(lblStatsVie, 0, 0, 1, 1);


        horizontalLayout.addWidget(frameStatsGene);

        frameStatsCaract = new QFrame(frame);
        frameStatsCaract.setObjectName("frameStatsCaract");
        QSizePolicy sizePolicy8 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy8.setHorizontalStretch((byte)0);
        sizePolicy8.setVerticalStretch((byte)0);
        sizePolicy8.setHeightForWidth(frameStatsCaract.sizePolicy().hasHeightForWidth());
        frameStatsCaract.setSizePolicy(sizePolicy8);
        frameStatsCaract.setStyleSheet("border: 0px;");
        frameStatsCaract.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        frameStatsCaract.setLineWidth(0);
        gridLayout_3 = new QGridLayout(frameStatsCaract);
        gridLayout_3.setSpacing(1);
        gridLayout_3.setObjectName("gridLayout_3");
        gridLayout_3.setContentsMargins(3, 1, 1, 1);
        lblStatsSag = new QLabel(frameStatsCaract);
        lblStatsSag.setObjectName("lblStatsSag");
        QSizePolicy sizePolicy9 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy9.setHorizontalStretch((byte)0);
        sizePolicy9.setVerticalStretch((byte)0);
        sizePolicy9.setHeightForWidth(lblStatsSag.sizePolicy().hasHeightForWidth());
        lblStatsSag.setSizePolicy(sizePolicy9);
        lblStatsSag.setMinimumSize(new QSize(25, 20));
        lblStatsSag.setMaximumSize(new QSize(25, 20));
        lblStatsSag.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblStatsSag.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblStatsSag.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_3.addWidget(lblStatsSag, 0, 1, 1, 1);

        lblStatsChance = new QLabel(frameStatsCaract);
        lblStatsChance.setObjectName("lblStatsChance");
        QSizePolicy sizePolicy10 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy10.setHorizontalStretch((byte)0);
        sizePolicy10.setVerticalStretch((byte)0);
        sizePolicy10.setHeightForWidth(lblStatsChance.sizePolicy().hasHeightForWidth());
        lblStatsChance.setSizePolicy(sizePolicy10);
        lblStatsChance.setMinimumSize(new QSize(25, 20));
        lblStatsChance.setMaximumSize(new QSize(25, 20));
        lblStatsChance.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblStatsChance.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblStatsChance.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_3.addWidget(lblStatsChance, 0, 4, 1, 1);

        lblStatsForce = new QLabel(frameStatsCaract);
        lblStatsForce.setObjectName("lblStatsForce");
        QSizePolicy sizePolicy11 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy11.setHorizontalStretch((byte)0);
        sizePolicy11.setVerticalStretch((byte)0);
        sizePolicy11.setHeightForWidth(lblStatsForce.sizePolicy().hasHeightForWidth());
        lblStatsForce.setSizePolicy(sizePolicy11);
        lblStatsForce.setMinimumSize(new QSize(25, 20));
        lblStatsForce.setMaximumSize(new QSize(25, 20));
        lblStatsForce.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblStatsForce.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblStatsForce.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_3.addWidget(lblStatsForce, 0, 2, 1, 1);

        lblStatsInt = new QLabel(frameStatsCaract);
        lblStatsInt.setObjectName("lblStatsInt");
        QSizePolicy sizePolicy12 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy12.setHorizontalStretch((byte)0);
        sizePolicy12.setVerticalStretch((byte)0);
        sizePolicy12.setHeightForWidth(lblStatsInt.sizePolicy().hasHeightForWidth());
        lblStatsInt.setSizePolicy(sizePolicy12);
        lblStatsInt.setMinimumSize(new QSize(25, 20));
        lblStatsInt.setMaximumSize(new QSize(25, 20));
        lblStatsInt.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblStatsInt.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblStatsInt.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_3.addWidget(lblStatsInt, 0, 3, 1, 1);

        lblStatsAgi = new QLabel(frameStatsCaract);
        lblStatsAgi.setObjectName("lblStatsAgi");
        QSizePolicy sizePolicy13 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy13.setHorizontalStretch((byte)0);
        sizePolicy13.setVerticalStretch((byte)0);
        sizePolicy13.setHeightForWidth(lblStatsAgi.sizePolicy().hasHeightForWidth());
        lblStatsAgi.setSizePolicy(sizePolicy13);
        lblStatsAgi.setMinimumSize(new QSize(25, 20));
        lblStatsAgi.setMaximumSize(new QSize(25, 20));
        lblStatsAgi.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblStatsAgi.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblStatsAgi.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_3.addWidget(lblStatsAgi, 0, 5, 1, 1);

        lblStatsVita = new QLabel(frameStatsCaract);
        lblStatsVita.setObjectName("lblStatsVita");
        QSizePolicy sizePolicy14 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy14.setHorizontalStretch((byte)0);
        sizePolicy14.setVerticalStretch((byte)0);
        sizePolicy14.setHeightForWidth(lblStatsVita.sizePolicy().hasHeightForWidth());
        lblStatsVita.setSizePolicy(sizePolicy14);
        lblStatsVita.setMinimumSize(new QSize(30, 20));
        lblStatsVita.setMaximumSize(new QSize(30, 20));
        lblStatsVita.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblStatsVita.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblStatsVita.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_3.addWidget(lblStatsVita, 0, 0, 1, 1);


        horizontalLayout.addWidget(frameStatsCaract);

        frameStatsAutre = new QFrame(frame);
        frameStatsAutre.setObjectName("frameStatsAutre");
        QSizePolicy sizePolicy15 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy15.setHorizontalStretch((byte)0);
        sizePolicy15.setVerticalStretch((byte)0);
        sizePolicy15.setHeightForWidth(frameStatsAutre.sizePolicy().hasHeightForWidth());
        frameStatsAutre.setSizePolicy(sizePolicy15);
        frameStatsAutre.setStyleSheet("border: 0px;");
        frameStatsAutre.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        frameStatsAutre.setLineWidth(0);
        gridLayout_5 = new QGridLayout(frameStatsAutre);
        gridLayout_5.setSpacing(1);
        gridLayout_5.setObjectName("gridLayout_5");
        gridLayout_5.setContentsMargins(3, 1, 1, 1);
        lblStatsPDom = new QLabel(frameStatsAutre);
        lblStatsPDom.setObjectName("lblStatsPDom");
        QSizePolicy sizePolicy16 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy16.setHorizontalStretch((byte)0);
        sizePolicy16.setVerticalStretch((byte)0);
        sizePolicy16.setHeightForWidth(lblStatsPDom.sizePolicy().hasHeightForWidth());
        lblStatsPDom.setSizePolicy(sizePolicy16);
        lblStatsPDom.setMinimumSize(new QSize(20, 20));
        lblStatsPDom.setMaximumSize(new QSize(20, 20));
        lblStatsPDom.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblStatsPDom.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblStatsPDom.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_5.addWidget(lblStatsPDom, 0, 1, 1, 1);

        lblStatsInvoc = new QLabel(frameStatsAutre);
        lblStatsInvoc.setObjectName("lblStatsInvoc");
        QSizePolicy sizePolicy17 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy17.setHorizontalStretch((byte)0);
        sizePolicy17.setVerticalStretch((byte)0);
        sizePolicy17.setHeightForWidth(lblStatsInvoc.sizePolicy().hasHeightForWidth());
        lblStatsInvoc.setSizePolicy(sizePolicy17);
        lblStatsInvoc.setMinimumSize(new QSize(20, 20));
        lblStatsInvoc.setMaximumSize(new QSize(20, 20));
        lblStatsInvoc.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblStatsInvoc.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblStatsInvoc.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_5.addWidget(lblStatsInvoc, 0, 4, 1, 1);

        lblStatsCC = new QLabel(frameStatsAutre);
        lblStatsCC.setObjectName("lblStatsCC");
        QSizePolicy sizePolicy18 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy18.setHorizontalStretch((byte)0);
        sizePolicy18.setVerticalStretch((byte)0);
        sizePolicy18.setHeightForWidth(lblStatsCC.sizePolicy().hasHeightForWidth());
        lblStatsCC.setSizePolicy(sizePolicy18);
        lblStatsCC.setMinimumSize(new QSize(20, 20));
        lblStatsCC.setMaximumSize(new QSize(20, 20));
        lblStatsCC.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblStatsCC.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblStatsCC.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_5.addWidget(lblStatsCC, 0, 2, 1, 1);

        lblStatsSoin = new QLabel(frameStatsAutre);
        lblStatsSoin.setObjectName("lblStatsSoin");
        QSizePolicy sizePolicy19 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy19.setHorizontalStretch((byte)0);
        sizePolicy19.setVerticalStretch((byte)0);
        sizePolicy19.setHeightForWidth(lblStatsSoin.sizePolicy().hasHeightForWidth());
        lblStatsSoin.setSizePolicy(sizePolicy19);
        lblStatsSoin.setMinimumSize(new QSize(20, 20));
        lblStatsSoin.setMaximumSize(new QSize(20, 20));
        lblStatsSoin.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblStatsSoin.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblStatsSoin.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_5.addWidget(lblStatsSoin, 0, 3, 1, 1);

        lblStatsDomPiege = new QLabel(frameStatsAutre);
        lblStatsDomPiege.setObjectName("lblStatsDomPiege");
        QSizePolicy sizePolicy20 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy20.setHorizontalStretch((byte)0);
        sizePolicy20.setVerticalStretch((byte)0);
        sizePolicy20.setHeightForWidth(lblStatsDomPiege.sizePolicy().hasHeightForWidth());
        lblStatsDomPiege.setSizePolicy(sizePolicy20);
        lblStatsDomPiege.setMinimumSize(new QSize(20, 20));
        lblStatsDomPiege.setMaximumSize(new QSize(20, 20));
        lblStatsDomPiege.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblStatsDomPiege.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblStatsDomPiege.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_5.addWidget(lblStatsDomPiege, 0, 5, 1, 1);

        lblStatsPDomPiege = new QLabel(frameStatsAutre);
        lblStatsPDomPiege.setObjectName("lblStatsPDomPiege");
        QSizePolicy sizePolicy21 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy21.setHorizontalStretch((byte)0);
        sizePolicy21.setVerticalStretch((byte)0);
        sizePolicy21.setHeightForWidth(lblStatsPDomPiege.sizePolicy().hasHeightForWidth());
        lblStatsPDomPiege.setSizePolicy(sizePolicy21);
        lblStatsPDomPiege.setMinimumSize(new QSize(20, 20));
        lblStatsPDomPiege.setMaximumSize(new QSize(20, 20));
        lblStatsPDomPiege.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblStatsPDomPiege.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblStatsPDomPiege.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_5.addWidget(lblStatsPDomPiege, 0, 6, 1, 1);

        lblStatsEC = new QLabel(frameStatsAutre);
        lblStatsEC.setObjectName("lblStatsEC");
        QSizePolicy sizePolicy22 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy22.setHorizontalStretch((byte)0);
        sizePolicy22.setVerticalStretch((byte)0);
        sizePolicy22.setHeightForWidth(lblStatsEC.sizePolicy().hasHeightForWidth());
        lblStatsEC.setSizePolicy(sizePolicy22);
        lblStatsEC.setMinimumSize(new QSize(20, 20));
        lblStatsEC.setMaximumSize(new QSize(20, 20));
        lblStatsEC.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblStatsEC.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblStatsEC.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_5.addWidget(lblStatsEC, 0, 7, 1, 1);

        lblStatsRenvois = new QLabel(frameStatsAutre);
        lblStatsRenvois.setObjectName("lblStatsRenvois");
        QSizePolicy sizePolicy23 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy23.setHorizontalStretch((byte)0);
        sizePolicy23.setVerticalStretch((byte)0);
        sizePolicy23.setHeightForWidth(lblStatsRenvois.sizePolicy().hasHeightForWidth());
        lblStatsRenvois.setSizePolicy(sizePolicy23);
        lblStatsRenvois.setMinimumSize(new QSize(20, 20));
        lblStatsRenvois.setMaximumSize(new QSize(20, 20));
        lblStatsRenvois.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblStatsRenvois.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblStatsRenvois.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_5.addWidget(lblStatsRenvois, 0, 8, 1, 1);

        lblStatsDom = new QLabel(frameStatsAutre);
        lblStatsDom.setObjectName("lblStatsDom");
        QSizePolicy sizePolicy24 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy24.setHorizontalStretch((byte)0);
        sizePolicy24.setVerticalStretch((byte)0);
        sizePolicy24.setHeightForWidth(lblStatsDom.sizePolicy().hasHeightForWidth());
        lblStatsDom.setSizePolicy(sizePolicy24);
        lblStatsDom.setMinimumSize(new QSize(20, 20));
        lblStatsDom.setMaximumSize(new QSize(20, 20));
        lblStatsDom.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblStatsDom.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblStatsDom.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_5.addWidget(lblStatsDom, 0, 0, 1, 1);


        horizontalLayout.addWidget(frameStatsAutre);

        frameStatsRes = new QFrame(frame);
        frameStatsRes.setObjectName("frameStatsRes");
        QSizePolicy sizePolicy25 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy25.setHorizontalStretch((byte)0);
        sizePolicy25.setVerticalStretch((byte)0);
        sizePolicy25.setHeightForWidth(frameStatsRes.sizePolicy().hasHeightForWidth());
        frameStatsRes.setSizePolicy(sizePolicy25);
        frameStatsRes.setStyleSheet("border: 0px;");
        frameStatsRes.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        frameStatsRes.setLineWidth(0);
        gridLayout_9 = new QGridLayout(frameStatsRes);
        gridLayout_9.setSpacing(1);
        gridLayout_9.setObjectName("gridLayout_9");
        gridLayout_9.setSizeConstraint(com.trolltech.qt.gui.QLayout.SizeConstraint.SetDefaultConstraint);
        gridLayout_9.setContentsMargins(3, 1, 1, 1);
        lblStatsResMagique = new QLabel(frameStatsRes);
        lblStatsResMagique.setObjectName("lblStatsResMagique");
        QSizePolicy sizePolicy26 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy26.setHorizontalStretch((byte)0);
        sizePolicy26.setVerticalStretch((byte)0);
        sizePolicy26.setHeightForWidth(lblStatsResMagique.sizePolicy().hasHeightForWidth());
        lblStatsResMagique.setSizePolicy(sizePolicy26);
        lblStatsResMagique.setMinimumSize(new QSize(20, 20));
        lblStatsResMagique.setMaximumSize(new QSize(20, 20));
        lblStatsResMagique.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblStatsResMagique.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblStatsResMagique.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsResMagique, 0, 0, 1, 1);

        lblStatsResPhysique = new QLabel(frameStatsRes);
        lblStatsResPhysique.setObjectName("lblStatsResPhysique");
        QSizePolicy sizePolicy27 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy27.setHorizontalStretch((byte)0);
        sizePolicy27.setVerticalStretch((byte)0);
        sizePolicy27.setHeightForWidth(lblStatsResPhysique.sizePolicy().hasHeightForWidth());
        lblStatsResPhysique.setSizePolicy(sizePolicy27);
        lblStatsResPhysique.setMinimumSize(new QSize(20, 20));
        lblStatsResPhysique.setMaximumSize(new QSize(20, 20));
        lblStatsResPhysique.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblStatsResPhysique.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblStatsResPhysique.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsResPhysique, 0, 1, 1, 1);

        lblStatsResNeutre = new QLabel(frameStatsRes);
        lblStatsResNeutre.setObjectName("lblStatsResNeutre");
        QSizePolicy sizePolicy28 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy28.setHorizontalStretch((byte)0);
        sizePolicy28.setVerticalStretch((byte)0);
        sizePolicy28.setHeightForWidth(lblStatsResNeutre.sizePolicy().hasHeightForWidth());
        lblStatsResNeutre.setSizePolicy(sizePolicy28);
        lblStatsResNeutre.setMinimumSize(new QSize(20, 20));
        lblStatsResNeutre.setMaximumSize(new QSize(20, 20));
        lblStatsResNeutre.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblStatsResNeutre.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblStatsResNeutre.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsResNeutre, 0, 2, 1, 1);

        lblStatsPResNeutre = new QLabel(frameStatsRes);
        lblStatsPResNeutre.setObjectName("lblStatsPResNeutre");
        QSizePolicy sizePolicy29 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy29.setHorizontalStretch((byte)0);
        sizePolicy29.setVerticalStretch((byte)0);
        sizePolicy29.setHeightForWidth(lblStatsPResNeutre.sizePolicy().hasHeightForWidth());
        lblStatsPResNeutre.setSizePolicy(sizePolicy29);
        lblStatsPResNeutre.setMinimumSize(new QSize(20, 20));
        lblStatsPResNeutre.setMaximumSize(new QSize(20, 20));
        lblStatsPResNeutre.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblStatsPResNeutre.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblStatsPResNeutre.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsPResNeutre, 0, 3, 1, 1);

        lblStatsResTerre = new QLabel(frameStatsRes);
        lblStatsResTerre.setObjectName("lblStatsResTerre");
        QSizePolicy sizePolicy30 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy30.setHorizontalStretch((byte)0);
        sizePolicy30.setVerticalStretch((byte)0);
        sizePolicy30.setHeightForWidth(lblStatsResTerre.sizePolicy().hasHeightForWidth());
        lblStatsResTerre.setSizePolicy(sizePolicy30);
        lblStatsResTerre.setMinimumSize(new QSize(20, 20));
        lblStatsResTerre.setMaximumSize(new QSize(20, 20));
        lblStatsResTerre.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblStatsResTerre.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblStatsResTerre.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsResTerre, 0, 4, 1, 1);

        lblStatsPResTerre = new QLabel(frameStatsRes);
        lblStatsPResTerre.setObjectName("lblStatsPResTerre");
        QSizePolicy sizePolicy31 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy31.setHorizontalStretch((byte)0);
        sizePolicy31.setVerticalStretch((byte)0);
        sizePolicy31.setHeightForWidth(lblStatsPResTerre.sizePolicy().hasHeightForWidth());
        lblStatsPResTerre.setSizePolicy(sizePolicy31);
        lblStatsPResTerre.setMinimumSize(new QSize(20, 20));
        lblStatsPResTerre.setMaximumSize(new QSize(20, 20));
        lblStatsPResTerre.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblStatsPResTerre.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblStatsPResTerre.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsPResTerre, 0, 5, 1, 1);

        lblStatsResFeu = new QLabel(frameStatsRes);
        lblStatsResFeu.setObjectName("lblStatsResFeu");
        QSizePolicy sizePolicy32 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy32.setHorizontalStretch((byte)0);
        sizePolicy32.setVerticalStretch((byte)0);
        sizePolicy32.setHeightForWidth(lblStatsResFeu.sizePolicy().hasHeightForWidth());
        lblStatsResFeu.setSizePolicy(sizePolicy32);
        lblStatsResFeu.setMinimumSize(new QSize(20, 20));
        lblStatsResFeu.setMaximumSize(new QSize(20, 20));
        lblStatsResFeu.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblStatsResFeu.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblStatsResFeu.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsResFeu, 0, 6, 1, 1);

        lblStatsPResFeu = new QLabel(frameStatsRes);
        lblStatsPResFeu.setObjectName("lblStatsPResFeu");
        QSizePolicy sizePolicy33 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy33.setHorizontalStretch((byte)0);
        sizePolicy33.setVerticalStretch((byte)0);
        sizePolicy33.setHeightForWidth(lblStatsPResFeu.sizePolicy().hasHeightForWidth());
        lblStatsPResFeu.setSizePolicy(sizePolicy33);
        lblStatsPResFeu.setMinimumSize(new QSize(20, 20));
        lblStatsPResFeu.setMaximumSize(new QSize(20, 20));
        lblStatsPResFeu.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblStatsPResFeu.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblStatsPResFeu.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsPResFeu, 0, 7, 1, 1);

        lblStatsResEau = new QLabel(frameStatsRes);
        lblStatsResEau.setObjectName("lblStatsResEau");
        QSizePolicy sizePolicy34 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy34.setHorizontalStretch((byte)0);
        sizePolicy34.setVerticalStretch((byte)0);
        sizePolicy34.setHeightForWidth(lblStatsResEau.sizePolicy().hasHeightForWidth());
        lblStatsResEau.setSizePolicy(sizePolicy34);
        lblStatsResEau.setMinimumSize(new QSize(20, 20));
        lblStatsResEau.setMaximumSize(new QSize(20, 20));
        lblStatsResEau.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblStatsResEau.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblStatsResEau.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsResEau, 0, 8, 1, 1);

        lblStatsPResEau = new QLabel(frameStatsRes);
        lblStatsPResEau.setObjectName("lblStatsPResEau");
        QSizePolicy sizePolicy35 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy35.setHorizontalStretch((byte)0);
        sizePolicy35.setVerticalStretch((byte)0);
        sizePolicy35.setHeightForWidth(lblStatsPResEau.sizePolicy().hasHeightForWidth());
        lblStatsPResEau.setSizePolicy(sizePolicy35);
        lblStatsPResEau.setMinimumSize(new QSize(20, 20));
        lblStatsPResEau.setMaximumSize(new QSize(20, 20));
        lblStatsPResEau.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblStatsPResEau.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblStatsPResEau.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsPResEau, 0, 9, 1, 1);

        lblStatsResAir = new QLabel(frameStatsRes);
        lblStatsResAir.setObjectName("lblStatsResAir");
        QSizePolicy sizePolicy36 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy36.setHorizontalStretch((byte)0);
        sizePolicy36.setVerticalStretch((byte)0);
        sizePolicy36.setHeightForWidth(lblStatsResAir.sizePolicy().hasHeightForWidth());
        lblStatsResAir.setSizePolicy(sizePolicy36);
        lblStatsResAir.setMinimumSize(new QSize(20, 20));
        lblStatsResAir.setMaximumSize(new QSize(20, 20));
        lblStatsResAir.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblStatsResAir.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblStatsResAir.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsResAir, 0, 10, 1, 1);

        lblStatsPResAir = new QLabel(frameStatsRes);
        lblStatsPResAir.setObjectName("lblStatsPResAir");
        QSizePolicy sizePolicy37 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy37.setHorizontalStretch((byte)0);
        sizePolicy37.setVerticalStretch((byte)0);
        sizePolicy37.setHeightForWidth(lblStatsPResAir.sizePolicy().hasHeightForWidth());
        lblStatsPResAir.setSizePolicy(sizePolicy37);
        lblStatsPResAir.setMinimumSize(new QSize(20, 20));
        lblStatsPResAir.setMaximumSize(new QSize(20, 20));
        lblStatsPResAir.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblStatsPResAir.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblStatsPResAir.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsPResAir, 0, 11, 1, 1);


        horizontalLayout.addWidget(frameStatsRes);


        horizontalLayout_2.addWidget(frame);

        retranslateUi(UIBonusPanopliesLigne);

        UIBonusPanopliesLigne.connectSlotsByName();
    } // setupUi

    void retranslateUi(QWidget UIBonusPanopliesLigne)
    {
        UIBonusPanopliesLigne.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanopliesLigne", "Ligne Bonus Panoplies", null));
        lblNbObjets.setText(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanopliesLigne", "X objets", null));
        lblStatsPA.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanopliesLigne", "Points d'action", null));
        lblStatsPA.setText("");
        lblStatsPM.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanopliesLigne", "Points de mouvement", null));
        lblStatsPM.setText("");
        lblStatsPO.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanopliesLigne", "Bonus de Port\u00e9e", null));
        lblStatsPO.setText("");
        lblStatsIni.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanopliesLigne", "Initiative", null));
        lblStatsIni.setText("");
        lblStatsPP.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanopliesLigne", "Prospection", null));
        lblStatsPP.setText("");
        lblStatsVie.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanopliesLigne", "Vie totale", null));
        lblStatsVie.setText("");
        lblStatsSag.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanopliesLigne", "Sagesse", null));
        lblStatsSag.setText("");
        lblStatsChance.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanopliesLigne", "Chance", null));
        lblStatsChance.setText("");
        lblStatsForce.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanopliesLigne", "Force", null));
        lblStatsForce.setText("");
        lblStatsInt.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanopliesLigne", "Intelligence", null));
        lblStatsInt.setText("");
        lblStatsAgi.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanopliesLigne", "Agilit\u00e9", null));
        lblStatsAgi.setText("");
        lblStatsVita.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanopliesLigne", "Vitalit\u00e9", null));
        lblStatsVita.setText("");
        lblStatsPDom.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanopliesLigne", "% Dommages", null));
        lblStatsPDom.setText("");
        lblStatsInvoc.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanopliesLigne", "Cr\u00e9atures invocables", null));
        lblStatsInvoc.setText("");
        lblStatsCC.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanopliesLigne", "Bonus Coups Critiques", null));
        lblStatsCC.setText("");
        lblStatsSoin.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanopliesLigne", "Soins", null));
        lblStatsSoin.setText("");
        lblStatsDomPiege.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanopliesLigne", "Dommages aux pi\u00e8ges", null));
        lblStatsDomPiege.setText("");
        lblStatsPDomPiege.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanopliesLigne", "% Dommages aux pi\u00e8ges", null));
        lblStatsPDomPiege.setText("");
        lblStatsEC.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanopliesLigne", "Malus aux \u00e9checs critiques", null));
        lblStatsEC.setText("");
        lblStatsRenvois.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanopliesLigne", "Revois", null));
        lblStatsRenvois.setText("");
        lblStatsDom.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanopliesLigne", "Dommages", null));
        lblStatsDom.setText("");
        lblStatsResMagique.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanopliesLigne", "R\u00e9sistance Magique", null));
        lblStatsResMagique.setText("");
        lblStatsResPhysique.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanopliesLigne", "R\u00e9sistance physique", null));
        lblStatsResPhysique.setText("");
        lblStatsResNeutre.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanopliesLigne", "R\u00e9sistance Neutre", null));
        lblStatsResNeutre.setText("");
        lblStatsPResNeutre.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanopliesLigne", "% R\u00e9sistance Neutre", null));
        lblStatsPResNeutre.setText("");
        lblStatsResTerre.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanopliesLigne", "R\u00e9sistance Terre", null));
        lblStatsResTerre.setText("");
        lblStatsPResTerre.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanopliesLigne", "% R\u00e9sistance Terre", null));
        lblStatsPResTerre.setText("");
        lblStatsResFeu.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanopliesLigne", "R\u00e9sistance Feu", null));
        lblStatsResFeu.setText("");
        lblStatsPResFeu.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanopliesLigne", "% R\u00e9sistance Feu", null));
        lblStatsPResFeu.setText("");
        lblStatsResEau.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanopliesLigne", "R\u00e9sistance Eau", null));
        lblStatsResEau.setText("");
        lblStatsPResEau.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanopliesLigne", "% R\u00e9sistance Eau", null));
        lblStatsPResEau.setText("");
        lblStatsResAir.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanopliesLigne", "R\u00e9sistance Air", null));
        lblStatsResAir.setText("");
        lblStatsPResAir.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanopliesLigne", "% R\u00e9sistance Air", null));
        lblStatsPResAir.setText("");
    } // retranslateUi

}

