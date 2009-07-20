/********************************************************************************
** Form generated from reading ui file 'UITableauObjets.jui'
**
** Created: lun. 20. juil. 21:47:19 2009
**      by: Qt User Interface Compiler version 4.5.0
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

package org.JDofusCalc.vues.Qt.designer;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

import org.JDofusCalc.vues.Qt.composants.*;

public class UITableauObjets implements com.trolltech.qt.QUiForm<QWidget>
{
    public QGridLayout gridLayout;
    public QSpacerItem horizontalSpacer;
    public QWidgetLigneEquipement ligneAmu;
    public QWidgetLigneEquipement ligneCeinture;
    public QWidgetLigneEquipement ligneCoiffe;
    public QWidgetLigneEquipement ligneAnneauG;
    public QWidgetLigneAnimal ligneAnimal;
    public QWidgetLigneEquipement ligneCape;
    public QWidgetLigneArme ligneArme;
    public QLabel lblArme;
    public QLabel lblCape;
    public QLabel lblCeinture;
    public QLabel lblBottes;
    public QLabel lblAnneauD;
    public QLabel lblAnneauG;
    public QLabel lblAmu;
    public QWidgetLigneEquipement ligneAnneauD;
    public QLabel lblCoiffe;
    public QLabel lblAnimal;
    public QWidgetLigneEquipement ligneBottes;
    public QLabel lblPanoplie;
    public QWidgetLignePanoplie lignePanoplie;
    public QLabel lblDofus;
    public QWidgetLigneDofus ligneDofus;
    public QLabel lblBouclier;
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
    public QSpacerItem horizontalSpacer_2;
    public QWidgetLigneEquipement ligneBouclier;
    public QFrame frame_2;
    public QHBoxLayout horizontalLayout_2;
    public QPushButton btnNoms;
    public QSpacerItem horizontalSpacer_3;

    public UITableauObjets() { super(); }

    public void setupUi(QWidget UITableauObjets)
    {
        UITableauObjets.setObjectName("UITableauObjets");
        UITableauObjets.resize(new QSize(865, 331).expandedTo(UITableauObjets.minimumSizeHint()));
        QSizePolicy sizePolicy = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy.setHorizontalStretch((byte)0);
        sizePolicy.setVerticalStretch((byte)0);
        sizePolicy.setHeightForWidth(UITableauObjets.sizePolicy().hasHeightForWidth());
        UITableauObjets.setSizePolicy(sizePolicy);
        gridLayout = new QGridLayout(UITableauObjets);
        gridLayout.setSpacing(1);
        gridLayout.setMargin(1);
        gridLayout.setObjectName("gridLayout");
        horizontalSpacer = new QSpacerItem(16, 0, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        gridLayout.addItem(horizontalSpacer, 0, 1, 1, 1);

        ligneAmu = new QWidgetLigneEquipement(UITableauObjets);
        ligneAmu.setObjectName("ligneAmu");
        QSizePolicy sizePolicy1 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy1.setHorizontalStretch((byte)0);
        sizePolicy1.setVerticalStretch((byte)0);
        sizePolicy1.setHeightForWidth(ligneAmu.sizePolicy().hasHeightForWidth());
        ligneAmu.setSizePolicy(sizePolicy1);
        ligneAmu.setProperty("afficherMenu", true);

        gridLayout.addWidget(ligneAmu, 1, 1, 1, 6);

        ligneCeinture = new QWidgetLigneEquipement(UITableauObjets);
        ligneCeinture.setObjectName("ligneCeinture");
        QSizePolicy sizePolicy2 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy2.setHorizontalStretch((byte)0);
        sizePolicy2.setVerticalStretch((byte)0);
        sizePolicy2.setHeightForWidth(ligneCeinture.sizePolicy().hasHeightForWidth());
        ligneCeinture.setSizePolicy(sizePolicy2);
        ligneCeinture.setProperty("afficherMenu", true);

        gridLayout.addWidget(ligneCeinture, 4, 1, 1, 6);

        ligneCoiffe = new QWidgetLigneEquipement(UITableauObjets);
        ligneCoiffe.setObjectName("ligneCoiffe");
        QSizePolicy sizePolicy3 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy3.setHorizontalStretch((byte)0);
        sizePolicy3.setVerticalStretch((byte)0);
        sizePolicy3.setHeightForWidth(ligneCoiffe.sizePolicy().hasHeightForWidth());
        ligneCoiffe.setSizePolicy(sizePolicy3);
        ligneCoiffe.setProperty("afficherMenu", true);

        gridLayout.addWidget(ligneCoiffe, 6, 1, 1, 6);

        ligneAnneauG = new QWidgetLigneEquipement(UITableauObjets);
        ligneAnneauG.setObjectName("ligneAnneauG");
        QSizePolicy sizePolicy4 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy4.setHorizontalStretch((byte)0);
        sizePolicy4.setVerticalStretch((byte)0);
        sizePolicy4.setHeightForWidth(ligneAnneauG.sizePolicy().hasHeightForWidth());
        ligneAnneauG.setSizePolicy(sizePolicy4);
        ligneAnneauG.setProperty("afficherMenu", true);

        gridLayout.addWidget(ligneAnneauG, 2, 1, 1, 6);

        ligneAnimal = new QWidgetLigneAnimal(UITableauObjets);
        ligneAnimal.setObjectName("ligneAnimal");
        QSizePolicy sizePolicy5 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy5.setHorizontalStretch((byte)0);
        sizePolicy5.setVerticalStretch((byte)0);
        sizePolicy5.setHeightForWidth(ligneAnimal.sizePolicy().hasHeightForWidth());
        ligneAnimal.setSizePolicy(sizePolicy5);
        ligneAnimal.setProperty("afficherMenu", true);

        gridLayout.addWidget(ligneAnimal, 8, 1, 1, 6);

        ligneCape = new QWidgetLigneEquipement(UITableauObjets);
        ligneCape.setObjectName("ligneCape");
        QSizePolicy sizePolicy6 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy6.setHorizontalStretch((byte)0);
        sizePolicy6.setVerticalStretch((byte)0);
        sizePolicy6.setHeightForWidth(ligneCape.sizePolicy().hasHeightForWidth());
        ligneCape.setSizePolicy(sizePolicy6);
        ligneCape.setProperty("afficherMenu", true);

        gridLayout.addWidget(ligneCape, 7, 1, 1, 6);

        ligneArme = new QWidgetLigneArme(UITableauObjets);
        ligneArme.setObjectName("ligneArme");
        QSizePolicy sizePolicy7 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy7.setHorizontalStretch((byte)0);
        sizePolicy7.setVerticalStretch((byte)0);
        sizePolicy7.setHeightForWidth(ligneArme.sizePolicy().hasHeightForWidth());
        ligneArme.setSizePolicy(sizePolicy7);
        ligneArme.setProperty("afficherMenu", true);

        gridLayout.addWidget(ligneArme, 11, 1, 1, 6);

        lblArme = new QLabel(UITableauObjets);
        lblArme.setObjectName("lblArme");
        QSizePolicy sizePolicy8 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy8.setHorizontalStretch((byte)0);
        sizePolicy8.setVerticalStretch((byte)0);
        sizePolicy8.setHeightForWidth(lblArme.sizePolicy().hasHeightForWidth());
        lblArme.setSizePolicy(sizePolicy8);

        gridLayout.addWidget(lblArme, 11, 0, 1, 1);

        lblCape = new QLabel(UITableauObjets);
        lblCape.setObjectName("lblCape");
        QSizePolicy sizePolicy9 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy9.setHorizontalStretch((byte)0);
        sizePolicy9.setVerticalStretch((byte)0);
        sizePolicy9.setHeightForWidth(lblCape.sizePolicy().hasHeightForWidth());
        lblCape.setSizePolicy(sizePolicy9);

        gridLayout.addWidget(lblCape, 7, 0, 1, 1);

        lblCeinture = new QLabel(UITableauObjets);
        lblCeinture.setObjectName("lblCeinture");
        QSizePolicy sizePolicy10 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy10.setHorizontalStretch((byte)0);
        sizePolicy10.setVerticalStretch((byte)0);
        sizePolicy10.setHeightForWidth(lblCeinture.sizePolicy().hasHeightForWidth());
        lblCeinture.setSizePolicy(sizePolicy10);

        gridLayout.addWidget(lblCeinture, 4, 0, 1, 1);

        lblBottes = new QLabel(UITableauObjets);
        lblBottes.setObjectName("lblBottes");
        QSizePolicy sizePolicy11 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy11.setHorizontalStretch((byte)0);
        sizePolicy11.setVerticalStretch((byte)0);
        sizePolicy11.setHeightForWidth(lblBottes.sizePolicy().hasHeightForWidth());
        lblBottes.setSizePolicy(sizePolicy11);

        gridLayout.addWidget(lblBottes, 5, 0, 1, 1);

        lblAnneauD = new QLabel(UITableauObjets);
        lblAnneauD.setObjectName("lblAnneauD");
        QSizePolicy sizePolicy12 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy12.setHorizontalStretch((byte)0);
        sizePolicy12.setVerticalStretch((byte)0);
        sizePolicy12.setHeightForWidth(lblAnneauD.sizePolicy().hasHeightForWidth());
        lblAnneauD.setSizePolicy(sizePolicy12);

        gridLayout.addWidget(lblAnneauD, 3, 0, 1, 1);

        lblAnneauG = new QLabel(UITableauObjets);
        lblAnneauG.setObjectName("lblAnneauG");
        QSizePolicy sizePolicy13 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy13.setHorizontalStretch((byte)0);
        sizePolicy13.setVerticalStretch((byte)0);
        sizePolicy13.setHeightForWidth(lblAnneauG.sizePolicy().hasHeightForWidth());
        lblAnneauG.setSizePolicy(sizePolicy13);

        gridLayout.addWidget(lblAnneauG, 2, 0, 1, 1);

        lblAmu = new QLabel(UITableauObjets);
        lblAmu.setObjectName("lblAmu");
        QSizePolicy sizePolicy14 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy14.setHorizontalStretch((byte)0);
        sizePolicy14.setVerticalStretch((byte)0);
        sizePolicy14.setHeightForWidth(lblAmu.sizePolicy().hasHeightForWidth());
        lblAmu.setSizePolicy(sizePolicy14);

        gridLayout.addWidget(lblAmu, 1, 0, 1, 1);

        ligneAnneauD = new QWidgetLigneEquipement(UITableauObjets);
        ligneAnneauD.setObjectName("ligneAnneauD");
        QSizePolicy sizePolicy15 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy15.setHorizontalStretch((byte)0);
        sizePolicy15.setVerticalStretch((byte)0);
        sizePolicy15.setHeightForWidth(ligneAnneauD.sizePolicy().hasHeightForWidth());
        ligneAnneauD.setSizePolicy(sizePolicy15);
        ligneAnneauD.setProperty("afficherMenu", true);

        gridLayout.addWidget(ligneAnneauD, 3, 1, 1, 6);

        lblCoiffe = new QLabel(UITableauObjets);
        lblCoiffe.setObjectName("lblCoiffe");
        QSizePolicy sizePolicy16 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy16.setHorizontalStretch((byte)0);
        sizePolicy16.setVerticalStretch((byte)0);
        sizePolicy16.setHeightForWidth(lblCoiffe.sizePolicy().hasHeightForWidth());
        lblCoiffe.setSizePolicy(sizePolicy16);

        gridLayout.addWidget(lblCoiffe, 6, 0, 1, 1);

        lblAnimal = new QLabel(UITableauObjets);
        lblAnimal.setObjectName("lblAnimal");
        QSizePolicy sizePolicy17 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy17.setHorizontalStretch((byte)0);
        sizePolicy17.setVerticalStretch((byte)0);
        sizePolicy17.setHeightForWidth(lblAnimal.sizePolicy().hasHeightForWidth());
        lblAnimal.setSizePolicy(sizePolicy17);

        gridLayout.addWidget(lblAnimal, 8, 0, 1, 1);

        ligneBottes = new QWidgetLigneEquipement(UITableauObjets);
        ligneBottes.setObjectName("ligneBottes");
        QSizePolicy sizePolicy18 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy18.setHorizontalStretch((byte)0);
        sizePolicy18.setVerticalStretch((byte)0);
        sizePolicy18.setHeightForWidth(ligneBottes.sizePolicy().hasHeightForWidth());
        ligneBottes.setSizePolicy(sizePolicy18);
        ligneBottes.setProperty("afficherMenu", true);

        gridLayout.addWidget(ligneBottes, 5, 1, 1, 6);

        lblPanoplie = new QLabel(UITableauObjets);
        lblPanoplie.setObjectName("lblPanoplie");
        QSizePolicy sizePolicy19 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy19.setHorizontalStretch((byte)0);
        sizePolicy19.setVerticalStretch((byte)0);
        sizePolicy19.setHeightForWidth(lblPanoplie.sizePolicy().hasHeightForWidth());
        lblPanoplie.setSizePolicy(sizePolicy19);

        gridLayout.addWidget(lblPanoplie, 15, 0, 1, 1);

        lignePanoplie = new QWidgetLignePanoplie(UITableauObjets);
        lignePanoplie.setObjectName("lignePanoplie");
        QSizePolicy sizePolicy20 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy20.setHorizontalStretch((byte)0);
        sizePolicy20.setVerticalStretch((byte)0);
        sizePolicy20.setHeightForWidth(lignePanoplie.sizePolicy().hasHeightForWidth());
        lignePanoplie.setSizePolicy(sizePolicy20);
        lignePanoplie.setProperty("afficherMenu", false);

        gridLayout.addWidget(lignePanoplie, 15, 1, 1, 4);

        lblDofus = new QLabel(UITableauObjets);
        lblDofus.setObjectName("lblDofus");
        QSizePolicy sizePolicy21 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy21.setHorizontalStretch((byte)0);
        sizePolicy21.setVerticalStretch((byte)0);
        sizePolicy21.setHeightForWidth(lblDofus.sizePolicy().hasHeightForWidth());
        lblDofus.setSizePolicy(sizePolicy21);

        gridLayout.addWidget(lblDofus, 14, 0, 1, 1);

        ligneDofus = new QWidgetLigneDofus(UITableauObjets);
        ligneDofus.setObjectName("ligneDofus");
        QSizePolicy sizePolicy22 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy22.setHorizontalStretch((byte)0);
        sizePolicy22.setVerticalStretch((byte)0);
        sizePolicy22.setHeightForWidth(ligneDofus.sizePolicy().hasHeightForWidth());
        ligneDofus.setSizePolicy(sizePolicy22);
        ligneDofus.setProperty("afficherMenu", true);

        gridLayout.addWidget(ligneDofus, 14, 1, 1, 4);

        lblBouclier = new QLabel(UITableauObjets);
        lblBouclier.setObjectName("lblBouclier");
        QSizePolicy sizePolicy23 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy23.setHorizontalStretch((byte)0);
        sizePolicy23.setVerticalStretch((byte)0);
        sizePolicy23.setHeightForWidth(lblBouclier.sizePolicy().hasHeightForWidth());
        lblBouclier.setSizePolicy(sizePolicy23);

        gridLayout.addWidget(lblBouclier, 10, 0, 1, 1);

        frame = new QFrame(UITableauObjets);
        frame.setObjectName("frame");
        QSizePolicy sizePolicy24 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy24.setHorizontalStretch((byte)0);
        sizePolicy24.setVerticalStretch((byte)0);
        sizePolicy24.setHeightForWidth(frame.sizePolicy().hasHeightForWidth());
        frame.setSizePolicy(sizePolicy24);
        horizontalLayout = new QHBoxLayout(frame);
        horizontalLayout.setSpacing(2);
        horizontalLayout.setMargin(0);
        horizontalLayout.setObjectName("horizontalLayout");
        frameStatsGene = new QFrame(frame);
        frameStatsGene.setObjectName("frameStatsGene");
        QSizePolicy sizePolicy25 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy25.setHorizontalStretch((byte)0);
        sizePolicy25.setVerticalStretch((byte)0);
        sizePolicy25.setHeightForWidth(frameStatsGene.sizePolicy().hasHeightForWidth());
        frameStatsGene.setSizePolicy(sizePolicy25);
        frameStatsGene.setStyleSheet("QFrame {\n"+
"	border: 1px solid #4578ba;\n"+
"	background-color: #8aaad9;\n"+
"}");
        frameStatsGene.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        frameStatsGene.setLineWidth(0);
        gridLayout_2 = new QGridLayout(frameStatsGene);
        gridLayout_2.setSpacing(1);
        gridLayout_2.setMargin(1);
        gridLayout_2.setObjectName("gridLayout_2");
        gridLayout_2.setSizeConstraint(com.trolltech.qt.gui.QLayout.SizeConstraint.SetDefaultConstraint);
        lblStatsPA = new QLabel(frameStatsGene);
        lblStatsPA.setObjectName("lblStatsPA");
        QSizePolicy sizePolicy26 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy26.setHorizontalStretch((byte)0);
        sizePolicy26.setVerticalStretch((byte)0);
        sizePolicy26.setHeightForWidth(lblStatsPA.sizePolicy().hasHeightForWidth());
        lblStatsPA.setSizePolicy(sizePolicy26);
        lblStatsPA.setMinimumSize(new QSize(20, 25));
        lblStatsPA.setMaximumSize(new QSize(20, 16777215));
        lblStatsPA.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsPA.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/pa.png")));
        lblStatsPA.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(lblStatsPA, 0, 1, 1, 1);

        lblStatsPM = new QLabel(frameStatsGene);
        lblStatsPM.setObjectName("lblStatsPM");
        QSizePolicy sizePolicy27 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy27.setHorizontalStretch((byte)0);
        sizePolicy27.setVerticalStretch((byte)0);
        sizePolicy27.setHeightForWidth(lblStatsPM.sizePolicy().hasHeightForWidth());
        lblStatsPM.setSizePolicy(sizePolicy27);
        lblStatsPM.setMinimumSize(new QSize(20, 25));
        lblStatsPM.setMaximumSize(new QSize(20, 16777215));
        lblStatsPM.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsPM.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/pm.png")));
        lblStatsPM.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(lblStatsPM, 0, 2, 1, 1);

        lblStatsPO = new QLabel(frameStatsGene);
        lblStatsPO.setObjectName("lblStatsPO");
        QSizePolicy sizePolicy28 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy28.setHorizontalStretch((byte)0);
        sizePolicy28.setVerticalStretch((byte)0);
        sizePolicy28.setHeightForWidth(lblStatsPO.sizePolicy().hasHeightForWidth());
        lblStatsPO.setSizePolicy(sizePolicy28);
        lblStatsPO.setMinimumSize(new QSize(20, 25));
        lblStatsPO.setMaximumSize(new QSize(20, 16777215));
        lblStatsPO.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsPO.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/po.png")));
        lblStatsPO.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(lblStatsPO, 0, 3, 1, 1);

        lblStatsIni = new QLabel(frameStatsGene);
        lblStatsIni.setObjectName("lblStatsIni");
        QSizePolicy sizePolicy29 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy29.setHorizontalStretch((byte)0);
        sizePolicy29.setVerticalStretch((byte)0);
        sizePolicy29.setHeightForWidth(lblStatsIni.sizePolicy().hasHeightForWidth());
        lblStatsIni.setSizePolicy(sizePolicy29);
        lblStatsIni.setMinimumSize(new QSize(30, 25));
        lblStatsIni.setMaximumSize(new QSize(30, 16777215));
        lblStatsIni.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsIni.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/ini.png")));
        lblStatsIni.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(lblStatsIni, 0, 4, 1, 1);

        lblStatsPP = new QLabel(frameStatsGene);
        lblStatsPP.setObjectName("lblStatsPP");
        QSizePolicy sizePolicy30 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy30.setHorizontalStretch((byte)0);
        sizePolicy30.setVerticalStretch((byte)0);
        sizePolicy30.setHeightForWidth(lblStatsPP.sizePolicy().hasHeightForWidth());
        lblStatsPP.setSizePolicy(sizePolicy30);
        lblStatsPP.setMinimumSize(new QSize(20, 25));
        lblStatsPP.setMaximumSize(new QSize(20, 16777215));
        lblStatsPP.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsPP.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/pp.png")));
        lblStatsPP.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(lblStatsPP, 0, 5, 1, 1);

        lblStatsVie = new QLabel(frameStatsGene);
        lblStatsVie.setObjectName("lblStatsVie");
        QSizePolicy sizePolicy31 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy31.setHorizontalStretch((byte)0);
        sizePolicy31.setVerticalStretch((byte)0);
        sizePolicy31.setHeightForWidth(lblStatsVie.sizePolicy().hasHeightForWidth());
        lblStatsVie.setSizePolicy(sizePolicy31);
        lblStatsVie.setMinimumSize(new QSize(30, 25));
        lblStatsVie.setMaximumSize(new QSize(30, 16777215));
        lblStatsVie.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsVie.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/vie.png")));
        lblStatsVie.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(lblStatsVie, 0, 0, 1, 1);


        horizontalLayout.addWidget(frameStatsGene);

        frameStatsCaract = new QFrame(frame);
        frameStatsCaract.setObjectName("frameStatsCaract");
        QSizePolicy sizePolicy32 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy32.setHorizontalStretch((byte)0);
        sizePolicy32.setVerticalStretch((byte)0);
        sizePolicy32.setHeightForWidth(frameStatsCaract.sizePolicy().hasHeightForWidth());
        frameStatsCaract.setSizePolicy(sizePolicy32);
        frameStatsCaract.setStyleSheet("QFrame {\n"+
"	border: 1px solid #f19142;\n"+
"	background-color: #f9c884;\n"+
"}");
        frameStatsCaract.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        frameStatsCaract.setLineWidth(0);
        gridLayout_3 = new QGridLayout(frameStatsCaract);
        gridLayout_3.setSpacing(1);
        gridLayout_3.setMargin(1);
        gridLayout_3.setObjectName("gridLayout_3");
        lblStatsSag = new QLabel(frameStatsCaract);
        lblStatsSag.setObjectName("lblStatsSag");
        QSizePolicy sizePolicy33 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy33.setHorizontalStretch((byte)0);
        sizePolicy33.setVerticalStretch((byte)0);
        sizePolicy33.setHeightForWidth(lblStatsSag.sizePolicy().hasHeightForWidth());
        lblStatsSag.setSizePolicy(sizePolicy33);
        lblStatsSag.setMinimumSize(new QSize(25, 25));
        lblStatsSag.setMaximumSize(new QSize(25, 25));
        lblStatsSag.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsSag.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/sagesse.png")));
        lblStatsSag.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_3.addWidget(lblStatsSag, 0, 1, 1, 1);

        lblStatsChance = new QLabel(frameStatsCaract);
        lblStatsChance.setObjectName("lblStatsChance");
        QSizePolicy sizePolicy34 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy34.setHorizontalStretch((byte)0);
        sizePolicy34.setVerticalStretch((byte)0);
        sizePolicy34.setHeightForWidth(lblStatsChance.sizePolicy().hasHeightForWidth());
        lblStatsChance.setSizePolicy(sizePolicy34);
        lblStatsChance.setMinimumSize(new QSize(25, 25));
        lblStatsChance.setMaximumSize(new QSize(25, 25));
        lblStatsChance.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsChance.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/chance.png")));
        lblStatsChance.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_3.addWidget(lblStatsChance, 0, 4, 1, 1);

        lblStatsForce = new QLabel(frameStatsCaract);
        lblStatsForce.setObjectName("lblStatsForce");
        QSizePolicy sizePolicy35 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy35.setHorizontalStretch((byte)0);
        sizePolicy35.setVerticalStretch((byte)0);
        sizePolicy35.setHeightForWidth(lblStatsForce.sizePolicy().hasHeightForWidth());
        lblStatsForce.setSizePolicy(sizePolicy35);
        lblStatsForce.setMinimumSize(new QSize(25, 25));
        lblStatsForce.setMaximumSize(new QSize(25, 25));
        lblStatsForce.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsForce.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/force.png")));
        lblStatsForce.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_3.addWidget(lblStatsForce, 0, 2, 1, 1);

        lblStatsInt = new QLabel(frameStatsCaract);
        lblStatsInt.setObjectName("lblStatsInt");
        QSizePolicy sizePolicy36 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy36.setHorizontalStretch((byte)0);
        sizePolicy36.setVerticalStretch((byte)0);
        sizePolicy36.setHeightForWidth(lblStatsInt.sizePolicy().hasHeightForWidth());
        lblStatsInt.setSizePolicy(sizePolicy36);
        lblStatsInt.setMinimumSize(new QSize(25, 25));
        lblStatsInt.setMaximumSize(new QSize(25, 25));
        lblStatsInt.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsInt.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/intelligence.png")));
        lblStatsInt.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_3.addWidget(lblStatsInt, 0, 3, 1, 1);

        lblStatsAgi = new QLabel(frameStatsCaract);
        lblStatsAgi.setObjectName("lblStatsAgi");
        QSizePolicy sizePolicy37 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy37.setHorizontalStretch((byte)0);
        sizePolicy37.setVerticalStretch((byte)0);
        sizePolicy37.setHeightForWidth(lblStatsAgi.sizePolicy().hasHeightForWidth());
        lblStatsAgi.setSizePolicy(sizePolicy37);
        lblStatsAgi.setMinimumSize(new QSize(25, 25));
        lblStatsAgi.setMaximumSize(new QSize(25, 25));
        lblStatsAgi.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsAgi.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/agilite.png")));
        lblStatsAgi.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_3.addWidget(lblStatsAgi, 0, 5, 1, 1);

        lblStatsVita = new QLabel(frameStatsCaract);
        lblStatsVita.setObjectName("lblStatsVita");
        QSizePolicy sizePolicy38 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy38.setHorizontalStretch((byte)0);
        sizePolicy38.setVerticalStretch((byte)0);
        sizePolicy38.setHeightForWidth(lblStatsVita.sizePolicy().hasHeightForWidth());
        lblStatsVita.setSizePolicy(sizePolicy38);
        lblStatsVita.setMinimumSize(new QSize(30, 25));
        lblStatsVita.setMaximumSize(new QSize(30, 16777215));
        lblStatsVita.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsVita.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/vita.png")));
        lblStatsVita.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_3.addWidget(lblStatsVita, 0, 0, 1, 1);


        horizontalLayout.addWidget(frameStatsCaract);

        frameStatsAutre = new QFrame(frame);
        frameStatsAutre.setObjectName("frameStatsAutre");
        QSizePolicy sizePolicy39 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy39.setHorizontalStretch((byte)0);
        sizePolicy39.setVerticalStretch((byte)0);
        sizePolicy39.setHeightForWidth(frameStatsAutre.sizePolicy().hasHeightForWidth());
        frameStatsAutre.setSizePolicy(sizePolicy39);
        frameStatsAutre.setStyleSheet("QFrame {\n"+
"	border: 1px solid #47af64;\n"+
"	background-color: #8fc794;\n"+
"}");
        frameStatsAutre.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        frameStatsAutre.setLineWidth(0);
        gridLayout_5 = new QGridLayout(frameStatsAutre);
        gridLayout_5.setSpacing(1);
        gridLayout_5.setMargin(1);
        gridLayout_5.setObjectName("gridLayout_5");
        lblStatsPDom = new QLabel(frameStatsAutre);
        lblStatsPDom.setObjectName("lblStatsPDom");
        QSizePolicy sizePolicy40 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy40.setHorizontalStretch((byte)0);
        sizePolicy40.setVerticalStretch((byte)0);
        sizePolicy40.setHeightForWidth(lblStatsPDom.sizePolicy().hasHeightForWidth());
        lblStatsPDom.setSizePolicy(sizePolicy40);
        lblStatsPDom.setMinimumSize(new QSize(20, 25));
        lblStatsPDom.setMaximumSize(new QSize(20, 16777215));
        lblStatsPDom.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsPDom.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/pdommages.png")));
        lblStatsPDom.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_5.addWidget(lblStatsPDom, 0, 1, 1, 1);

        lblStatsInvoc = new QLabel(frameStatsAutre);
        lblStatsInvoc.setObjectName("lblStatsInvoc");
        QSizePolicy sizePolicy41 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy41.setHorizontalStretch((byte)0);
        sizePolicy41.setVerticalStretch((byte)0);
        sizePolicy41.setHeightForWidth(lblStatsInvoc.sizePolicy().hasHeightForWidth());
        lblStatsInvoc.setSizePolicy(sizePolicy41);
        lblStatsInvoc.setMinimumSize(new QSize(20, 25));
        lblStatsInvoc.setMaximumSize(new QSize(20, 16777215));
        lblStatsInvoc.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsInvoc.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/invoc.png")));
        lblStatsInvoc.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_5.addWidget(lblStatsInvoc, 0, 4, 1, 1);

        lblStatsCC = new QLabel(frameStatsAutre);
        lblStatsCC.setObjectName("lblStatsCC");
        QSizePolicy sizePolicy42 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy42.setHorizontalStretch((byte)0);
        sizePolicy42.setVerticalStretch((byte)0);
        sizePolicy42.setHeightForWidth(lblStatsCC.sizePolicy().hasHeightForWidth());
        lblStatsCC.setSizePolicy(sizePolicy42);
        lblStatsCC.setMinimumSize(new QSize(20, 25));
        lblStatsCC.setMaximumSize(new QSize(20, 16777215));
        lblStatsCC.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsCC.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/critique.png")));
        lblStatsCC.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_5.addWidget(lblStatsCC, 0, 2, 1, 1);

        lblStatsSoin = new QLabel(frameStatsAutre);
        lblStatsSoin.setObjectName("lblStatsSoin");
        QSizePolicy sizePolicy43 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy43.setHorizontalStretch((byte)0);
        sizePolicy43.setVerticalStretch((byte)0);
        sizePolicy43.setHeightForWidth(lblStatsSoin.sizePolicy().hasHeightForWidth());
        lblStatsSoin.setSizePolicy(sizePolicy43);
        lblStatsSoin.setMinimumSize(new QSize(20, 25));
        lblStatsSoin.setMaximumSize(new QSize(20, 16777215));
        lblStatsSoin.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsSoin.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/soins.png")));
        lblStatsSoin.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_5.addWidget(lblStatsSoin, 0, 3, 1, 1);

        lblStatsDomPiege = new QLabel(frameStatsAutre);
        lblStatsDomPiege.setObjectName("lblStatsDomPiege");
        QSizePolicy sizePolicy44 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy44.setHorizontalStretch((byte)0);
        sizePolicy44.setVerticalStretch((byte)0);
        sizePolicy44.setHeightForWidth(lblStatsDomPiege.sizePolicy().hasHeightForWidth());
        lblStatsDomPiege.setSizePolicy(sizePolicy44);
        lblStatsDomPiege.setMinimumSize(new QSize(20, 25));
        lblStatsDomPiege.setMaximumSize(new QSize(20, 16777215));
        lblStatsDomPiege.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsDomPiege.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/piege.png")));
        lblStatsDomPiege.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_5.addWidget(lblStatsDomPiege, 0, 5, 1, 1);

        lblStatsPDomPiege = new QLabel(frameStatsAutre);
        lblStatsPDomPiege.setObjectName("lblStatsPDomPiege");
        QSizePolicy sizePolicy45 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy45.setHorizontalStretch((byte)0);
        sizePolicy45.setVerticalStretch((byte)0);
        sizePolicy45.setHeightForWidth(lblStatsPDomPiege.sizePolicy().hasHeightForWidth());
        lblStatsPDomPiege.setSizePolicy(sizePolicy45);
        lblStatsPDomPiege.setMinimumSize(new QSize(20, 25));
        lblStatsPDomPiege.setMaximumSize(new QSize(20, 16777215));
        lblStatsPDomPiege.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsPDomPiege.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/ppiege.png")));
        lblStatsPDomPiege.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_5.addWidget(lblStatsPDomPiege, 0, 6, 1, 1);

        lblStatsEC = new QLabel(frameStatsAutre);
        lblStatsEC.setObjectName("lblStatsEC");
        QSizePolicy sizePolicy46 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy46.setHorizontalStretch((byte)0);
        sizePolicy46.setVerticalStretch((byte)0);
        sizePolicy46.setHeightForWidth(lblStatsEC.sizePolicy().hasHeightForWidth());
        lblStatsEC.setSizePolicy(sizePolicy46);
        lblStatsEC.setMinimumSize(new QSize(20, 25));
        lblStatsEC.setMaximumSize(new QSize(20, 16777215));
        lblStatsEC.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsEC.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/echecs_critiques.png")));
        lblStatsEC.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_5.addWidget(lblStatsEC, 0, 7, 1, 1);

        lblStatsRenvois = new QLabel(frameStatsAutre);
        lblStatsRenvois.setObjectName("lblStatsRenvois");
        QSizePolicy sizePolicy47 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy47.setHorizontalStretch((byte)0);
        sizePolicy47.setVerticalStretch((byte)0);
        sizePolicy47.setHeightForWidth(lblStatsRenvois.sizePolicy().hasHeightForWidth());
        lblStatsRenvois.setSizePolicy(sizePolicy47);
        lblStatsRenvois.setMinimumSize(new QSize(20, 25));
        lblStatsRenvois.setMaximumSize(new QSize(20, 16777215));
        lblStatsRenvois.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsRenvois.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/renvois.png")));
        lblStatsRenvois.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_5.addWidget(lblStatsRenvois, 0, 8, 1, 1);

        lblStatsDom = new QLabel(frameStatsAutre);
        lblStatsDom.setObjectName("lblStatsDom");
        QSizePolicy sizePolicy48 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy48.setHorizontalStretch((byte)0);
        sizePolicy48.setVerticalStretch((byte)0);
        sizePolicy48.setHeightForWidth(lblStatsDom.sizePolicy().hasHeightForWidth());
        lblStatsDom.setSizePolicy(sizePolicy48);
        lblStatsDom.setMinimumSize(new QSize(20, 25));
        lblStatsDom.setMaximumSize(new QSize(20, 16777215));
        lblStatsDom.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsDom.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/dommages.png")));
        lblStatsDom.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_5.addWidget(lblStatsDom, 0, 0, 1, 1);


        horizontalLayout.addWidget(frameStatsAutre);

        frameStatsRes = new QFrame(frame);
        frameStatsRes.setObjectName("frameStatsRes");
        QSizePolicy sizePolicy49 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy49.setHorizontalStretch((byte)0);
        sizePolicy49.setVerticalStretch((byte)0);
        sizePolicy49.setHeightForWidth(frameStatsRes.sizePolicy().hasHeightForWidth());
        frameStatsRes.setSizePolicy(sizePolicy49);
        frameStatsRes.setStyleSheet("QFrame {\n"+
"	border: 1px solid #ab46a0;\n"+
"	background-color: #c38cbc;\n"+
"}");
        frameStatsRes.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        frameStatsRes.setLineWidth(0);
        gridLayout_9 = new QGridLayout(frameStatsRes);
        gridLayout_9.setSpacing(1);
        gridLayout_9.setMargin(1);
        gridLayout_9.setObjectName("gridLayout_9");
        gridLayout_9.setSizeConstraint(com.trolltech.qt.gui.QLayout.SizeConstraint.SetDefaultConstraint);
        lblStatsResMagique = new QLabel(frameStatsRes);
        lblStatsResMagique.setObjectName("lblStatsResMagique");
        QSizePolicy sizePolicy50 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy50.setHorizontalStretch((byte)0);
        sizePolicy50.setVerticalStretch((byte)0);
        sizePolicy50.setHeightForWidth(lblStatsResMagique.sizePolicy().hasHeightForWidth());
        lblStatsResMagique.setSizePolicy(sizePolicy50);
        lblStatsResMagique.setMinimumSize(new QSize(20, 25));
        lblStatsResMagique.setMaximumSize(new QSize(20, 25));
        lblStatsResMagique.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsResMagique.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/resMagique.png")));
        lblStatsResMagique.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsResMagique, 0, 0, 1, 1);

        lblStatsResPhysique = new QLabel(frameStatsRes);
        lblStatsResPhysique.setObjectName("lblStatsResPhysique");
        QSizePolicy sizePolicy51 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy51.setHorizontalStretch((byte)0);
        sizePolicy51.setVerticalStretch((byte)0);
        sizePolicy51.setHeightForWidth(lblStatsResPhysique.sizePolicy().hasHeightForWidth());
        lblStatsResPhysique.setSizePolicy(sizePolicy51);
        lblStatsResPhysique.setMinimumSize(new QSize(20, 25));
        lblStatsResPhysique.setMaximumSize(new QSize(20, 25));
        lblStatsResPhysique.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsResPhysique.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/resPhysique.png")));
        lblStatsResPhysique.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsResPhysique, 0, 1, 1, 1);

        lblStatsResNeutre = new QLabel(frameStatsRes);
        lblStatsResNeutre.setObjectName("lblStatsResNeutre");
        QSizePolicy sizePolicy52 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy52.setHorizontalStretch((byte)0);
        sizePolicy52.setVerticalStretch((byte)0);
        sizePolicy52.setHeightForWidth(lblStatsResNeutre.sizePolicy().hasHeightForWidth());
        lblStatsResNeutre.setSizePolicy(sizePolicy52);
        lblStatsResNeutre.setMinimumSize(new QSize(20, 25));
        lblStatsResNeutre.setMaximumSize(new QSize(20, 25));
        lblStatsResNeutre.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsResNeutre.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/resNeutre.png")));
        lblStatsResNeutre.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsResNeutre, 0, 2, 1, 1);

        lblStatsPResNeutre = new QLabel(frameStatsRes);
        lblStatsPResNeutre.setObjectName("lblStatsPResNeutre");
        QSizePolicy sizePolicy53 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy53.setHorizontalStretch((byte)0);
        sizePolicy53.setVerticalStretch((byte)0);
        sizePolicy53.setHeightForWidth(lblStatsPResNeutre.sizePolicy().hasHeightForWidth());
        lblStatsPResNeutre.setSizePolicy(sizePolicy53);
        lblStatsPResNeutre.setMinimumSize(new QSize(20, 25));
        lblStatsPResNeutre.setMaximumSize(new QSize(20, 25));
        lblStatsPResNeutre.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsPResNeutre.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/PResNeutre.png")));
        lblStatsPResNeutre.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsPResNeutre, 0, 3, 1, 1);

        lblStatsResTerre = new QLabel(frameStatsRes);
        lblStatsResTerre.setObjectName("lblStatsResTerre");
        QSizePolicy sizePolicy54 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy54.setHorizontalStretch((byte)0);
        sizePolicy54.setVerticalStretch((byte)0);
        sizePolicy54.setHeightForWidth(lblStatsResTerre.sizePolicy().hasHeightForWidth());
        lblStatsResTerre.setSizePolicy(sizePolicy54);
        lblStatsResTerre.setMinimumSize(new QSize(20, 25));
        lblStatsResTerre.setMaximumSize(new QSize(20, 25));
        lblStatsResTerre.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsResTerre.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/resTerre.png")));
        lblStatsResTerre.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsResTerre, 0, 4, 1, 1);

        lblStatsPResTerre = new QLabel(frameStatsRes);
        lblStatsPResTerre.setObjectName("lblStatsPResTerre");
        QSizePolicy sizePolicy55 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy55.setHorizontalStretch((byte)0);
        sizePolicy55.setVerticalStretch((byte)0);
        sizePolicy55.setHeightForWidth(lblStatsPResTerre.sizePolicy().hasHeightForWidth());
        lblStatsPResTerre.setSizePolicy(sizePolicy55);
        lblStatsPResTerre.setMinimumSize(new QSize(20, 25));
        lblStatsPResTerre.setMaximumSize(new QSize(20, 25));
        lblStatsPResTerre.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsPResTerre.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/PResTerre.png")));
        lblStatsPResTerre.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsPResTerre, 0, 5, 1, 1);

        lblStatsResFeu = new QLabel(frameStatsRes);
        lblStatsResFeu.setObjectName("lblStatsResFeu");
        QSizePolicy sizePolicy56 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy56.setHorizontalStretch((byte)0);
        sizePolicy56.setVerticalStretch((byte)0);
        sizePolicy56.setHeightForWidth(lblStatsResFeu.sizePolicy().hasHeightForWidth());
        lblStatsResFeu.setSizePolicy(sizePolicy56);
        lblStatsResFeu.setMinimumSize(new QSize(20, 25));
        lblStatsResFeu.setMaximumSize(new QSize(20, 25));
        lblStatsResFeu.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsResFeu.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/resFeu.png")));
        lblStatsResFeu.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsResFeu, 0, 6, 1, 1);

        lblStatsPResFeu = new QLabel(frameStatsRes);
        lblStatsPResFeu.setObjectName("lblStatsPResFeu");
        QSizePolicy sizePolicy57 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy57.setHorizontalStretch((byte)0);
        sizePolicy57.setVerticalStretch((byte)0);
        sizePolicy57.setHeightForWidth(lblStatsPResFeu.sizePolicy().hasHeightForWidth());
        lblStatsPResFeu.setSizePolicy(sizePolicy57);
        lblStatsPResFeu.setMinimumSize(new QSize(20, 25));
        lblStatsPResFeu.setMaximumSize(new QSize(20, 25));
        lblStatsPResFeu.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsPResFeu.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/PResFeu.png")));
        lblStatsPResFeu.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsPResFeu, 0, 7, 1, 1);

        lblStatsResEau = new QLabel(frameStatsRes);
        lblStatsResEau.setObjectName("lblStatsResEau");
        QSizePolicy sizePolicy58 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy58.setHorizontalStretch((byte)0);
        sizePolicy58.setVerticalStretch((byte)0);
        sizePolicy58.setHeightForWidth(lblStatsResEau.sizePolicy().hasHeightForWidth());
        lblStatsResEau.setSizePolicy(sizePolicy58);
        lblStatsResEau.setMinimumSize(new QSize(20, 25));
        lblStatsResEau.setMaximumSize(new QSize(20, 25));
        lblStatsResEau.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsResEau.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/resEau.png")));
        lblStatsResEau.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsResEau, 0, 8, 1, 1);

        lblStatsPResEau = new QLabel(frameStatsRes);
        lblStatsPResEau.setObjectName("lblStatsPResEau");
        QSizePolicy sizePolicy59 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy59.setHorizontalStretch((byte)0);
        sizePolicy59.setVerticalStretch((byte)0);
        sizePolicy59.setHeightForWidth(lblStatsPResEau.sizePolicy().hasHeightForWidth());
        lblStatsPResEau.setSizePolicy(sizePolicy59);
        lblStatsPResEau.setMinimumSize(new QSize(20, 25));
        lblStatsPResEau.setMaximumSize(new QSize(20, 25));
        lblStatsPResEau.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsPResEau.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/PResEau.png")));
        lblStatsPResEau.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsPResEau, 0, 9, 1, 1);

        lblStatsResAir = new QLabel(frameStatsRes);
        lblStatsResAir.setObjectName("lblStatsResAir");
        QSizePolicy sizePolicy60 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy60.setHorizontalStretch((byte)0);
        sizePolicy60.setVerticalStretch((byte)0);
        sizePolicy60.setHeightForWidth(lblStatsResAir.sizePolicy().hasHeightForWidth());
        lblStatsResAir.setSizePolicy(sizePolicy60);
        lblStatsResAir.setMinimumSize(new QSize(20, 25));
        lblStatsResAir.setMaximumSize(new QSize(20, 25));
        lblStatsResAir.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsResAir.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/resAir.png")));
        lblStatsResAir.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsResAir, 0, 10, 1, 1);

        lblStatsPResAir = new QLabel(frameStatsRes);
        lblStatsPResAir.setObjectName("lblStatsPResAir");
        QSizePolicy sizePolicy61 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy61.setHorizontalStretch((byte)0);
        sizePolicy61.setVerticalStretch((byte)0);
        sizePolicy61.setHeightForWidth(lblStatsPResAir.sizePolicy().hasHeightForWidth());
        lblStatsPResAir.setSizePolicy(sizePolicy61);
        lblStatsPResAir.setMinimumSize(new QSize(20, 25));
        lblStatsPResAir.setMaximumSize(new QSize(20, 25));
        lblStatsPResAir.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsPResAir.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/PResAir.png")));
        lblStatsPResAir.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsPResAir, 0, 11, 1, 1);


        horizontalLayout.addWidget(frameStatsRes);


        gridLayout.addWidget(frame, 0, 2, 1, 1);

        horizontalSpacer_2 = new QSpacerItem(24, 24, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        gridLayout.addItem(horizontalSpacer_2, 0, 3, 1, 1);

        ligneBouclier = new QWidgetLigneEquipement(UITableauObjets);
        ligneBouclier.setObjectName("ligneBouclier");
        QSizePolicy sizePolicy62 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy62.setHorizontalStretch((byte)0);
        sizePolicy62.setVerticalStretch((byte)0);
        sizePolicy62.setHeightForWidth(ligneBouclier.sizePolicy().hasHeightForWidth());
        ligneBouclier.setSizePolicy(sizePolicy62);
        ligneBouclier.setProperty("afficherMenu", true);

        gridLayout.addWidget(ligneBouclier, 10, 1, 1, 4);

        frame_2 = new QFrame(UITableauObjets);
        frame_2.setObjectName("frame_2");
        QSizePolicy sizePolicy63 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy63.setHorizontalStretch((byte)0);
        sizePolicy63.setVerticalStretch((byte)0);
        sizePolicy63.setHeightForWidth(frame_2.sizePolicy().hasHeightForWidth());
        frame_2.setSizePolicy(sizePolicy63);
        frame_2.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.NoFrame);
        frame_2.setFrameShadow(com.trolltech.qt.gui.QFrame.Shadow.Raised);
        horizontalLayout_2 = new QHBoxLayout(frame_2);
        horizontalLayout_2.setSpacing(0);
        horizontalLayout_2.setMargin(0);
        horizontalLayout_2.setObjectName("horizontalLayout_2");
        btnNoms = new QPushButton(frame_2);
        btnNoms.setObjectName("btnNoms");
        btnNoms.setMinimumSize(new QSize(25, 25));
        btnNoms.setMaximumSize(new QSize(25, 25));
        btnNoms.setIcon(new QIcon(new QPixmap("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/reload.png")));

        horizontalLayout_2.addWidget(btnNoms);


        gridLayout.addWidget(frame_2, 0, 0, 1, 1);

        horizontalSpacer_3 = new QSpacerItem(0, 0, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        gridLayout.addItem(horizontalSpacer_3, 0, 4, 1, 1);

        retranslateUi(UITableauObjets);

        UITableauObjets.connectSlotsByName();
    } // setupUi

    void retranslateUi(QWidget UITableauObjets)
    {
        ligneAmu.setProperty("nomObjet", com.trolltech.qt.core.QCoreApplication.translate("UITableauObjets", "amulette", null));
        ligneCeinture.setProperty("nomObjet", com.trolltech.qt.core.QCoreApplication.translate("UITableauObjets", "ceinture", null));
        ligneCoiffe.setProperty("nomObjet", com.trolltech.qt.core.QCoreApplication.translate("UITableauObjets", "coiffe", null));
        ligneAnneauG.setProperty("nomObjet", com.trolltech.qt.core.QCoreApplication.translate("UITableauObjets", "anneau G.", null));
        ligneAnimal.setProperty("nomObjet", com.trolltech.qt.core.QCoreApplication.translate("UITableauObjets", "animal", null));
        ligneCape.setProperty("nomObjet", com.trolltech.qt.core.QCoreApplication.translate("UITableauObjets", "cape", null));
        ligneArme.setProperty("nomObjet", com.trolltech.qt.core.QCoreApplication.translate("UITableauObjets", "arme", null));
        lblArme.setText(com.trolltech.qt.core.QCoreApplication.translate("UITableauObjets", "Arme", null));
        lblCape.setText(com.trolltech.qt.core.QCoreApplication.translate("UITableauObjets", "Cape", null));
        lblCeinture.setText(com.trolltech.qt.core.QCoreApplication.translate("UITableauObjets", "Ceinture", null));
        lblBottes.setText(com.trolltech.qt.core.QCoreApplication.translate("UITableauObjets", "Bottes", null));
        lblAnneauD.setText(com.trolltech.qt.core.QCoreApplication.translate("UITableauObjets", "Anneau D.", null));
        lblAnneauG.setText(com.trolltech.qt.core.QCoreApplication.translate("UITableauObjets", "Anneau G.", null));
        lblAmu.setText(com.trolltech.qt.core.QCoreApplication.translate("UITableauObjets", "Amulette", null));
        ligneAnneauD.setProperty("nomObjet", com.trolltech.qt.core.QCoreApplication.translate("UITableauObjets", "anneau D.", null));
        lblCoiffe.setText(com.trolltech.qt.core.QCoreApplication.translate("UITableauObjets", "Coiffe", null));
        lblAnimal.setText(com.trolltech.qt.core.QCoreApplication.translate("UITableauObjets", "Animal", null));
        ligneBottes.setProperty("nomObjet", com.trolltech.qt.core.QCoreApplication.translate("UITableauObjets", "bottes", null));
        lblPanoplie.setText(com.trolltech.qt.core.QCoreApplication.translate("UITableauObjets", "Panoplie", null));
        lignePanoplie.setProperty("nomObjet", com.trolltech.qt.core.QCoreApplication.translate("UITableauObjets", "panoplie", null));
        lblDofus.setText(com.trolltech.qt.core.QCoreApplication.translate("UITableauObjets", "Dofus", null));
        ligneDofus.setProperty("nomObjet", com.trolltech.qt.core.QCoreApplication.translate("UITableauObjets", "dofus", null));
        lblBouclier.setText(com.trolltech.qt.core.QCoreApplication.translate("UITableauObjets", "Bouclier", null));
        lblStatsPA.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UITableauObjets", "Points d'action", null));
        lblStatsPA.setText("");
        lblStatsPM.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UITableauObjets", "Points de mouvement", null));
        lblStatsPM.setText("");
        lblStatsPO.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UITableauObjets", "Bonus de Port\u00e9e", null));
        lblStatsPO.setText("");
        lblStatsIni.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UITableauObjets", "Initiative", null));
        lblStatsIni.setText("");
        lblStatsPP.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UITableauObjets", "Prospection", null));
        lblStatsPP.setText("");
        lblStatsVie.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UITableauObjets", "Vie totale", null));
        lblStatsVie.setText("");
        lblStatsSag.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UITableauObjets", "Sagesse", null));
        lblStatsSag.setText("");
        lblStatsChance.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UITableauObjets", "Chance", null));
        lblStatsChance.setText("");
        lblStatsForce.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UITableauObjets", "Force", null));
        lblStatsForce.setText("");
        lblStatsInt.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UITableauObjets", "Intelligence", null));
        lblStatsInt.setText("");
        lblStatsAgi.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UITableauObjets", "Agilit\u00e9", null));
        lblStatsAgi.setText("");
        lblStatsVita.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UITableauObjets", "Vitalit\u00e9", null));
        lblStatsVita.setText("");
        lblStatsPDom.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UITableauObjets", "% Dommages", null));
        lblStatsPDom.setText("");
        lblStatsInvoc.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UITableauObjets", "Cr\u00e9atures invocables", null));
        lblStatsInvoc.setText("");
        lblStatsCC.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UITableauObjets", "Bonus Coups Critiques", null));
        lblStatsCC.setText("");
        lblStatsSoin.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UITableauObjets", "Soins", null));
        lblStatsSoin.setText("");
        lblStatsDomPiege.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UITableauObjets", "Dommages aux pi\u00e8ges", null));
        lblStatsDomPiege.setText("");
        lblStatsPDomPiege.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UITableauObjets", "% Dommages aux pi\u00e8ges", null));
        lblStatsPDomPiege.setText("");
        lblStatsEC.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UITableauObjets", "Malus aux \u00e9checs critiques", null));
        lblStatsEC.setText("");
        lblStatsRenvois.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UITableauObjets", "Revois", null));
        lblStatsRenvois.setText("");
        lblStatsDom.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UITableauObjets", "Dommages", null));
        lblStatsDom.setText("");
        lblStatsResMagique.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UITableauObjets", "R\u00e9sistance Magique", null));
        lblStatsResMagique.setText("");
        lblStatsResPhysique.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UITableauObjets", "R\u00e9sistance physique", null));
        lblStatsResPhysique.setText("");
        lblStatsResNeutre.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UITableauObjets", "R\u00e9sistance Neutre", null));
        lblStatsResNeutre.setText("");
        lblStatsPResNeutre.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UITableauObjets", "% R\u00e9sistance Neutre", null));
        lblStatsPResNeutre.setText("");
        lblStatsResTerre.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UITableauObjets", "R\u00e9sistance Terre", null));
        lblStatsResTerre.setText("");
        lblStatsPResTerre.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UITableauObjets", "% R\u00e9sistance Terre", null));
        lblStatsPResTerre.setText("");
        lblStatsResFeu.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UITableauObjets", "R\u00e9sistance Feu", null));
        lblStatsResFeu.setText("");
        lblStatsPResFeu.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UITableauObjets", "% R\u00e9sistance Feu", null));
        lblStatsPResFeu.setText("");
        lblStatsResEau.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UITableauObjets", "R\u00e9sistance Eau", null));
        lblStatsResEau.setText("");
        lblStatsPResEau.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UITableauObjets", "% R\u00e9sistance Eau", null));
        lblStatsPResEau.setText("");
        lblStatsResAir.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UITableauObjets", "R\u00e9sistance Air", null));
        lblStatsResAir.setText("");
        lblStatsPResAir.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UITableauObjets", "% R\u00e9sistance Air", null));
        lblStatsPResAir.setText("");
        ligneBouclier.setProperty("nomObjet", com.trolltech.qt.core.QCoreApplication.translate("UITableauObjets", "bouclier", null));
        btnNoms.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UITableauObjets", "Afficher/Cacher les noms", null));
    } // retranslateUi

}

