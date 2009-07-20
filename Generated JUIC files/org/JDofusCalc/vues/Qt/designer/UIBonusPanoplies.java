/********************************************************************************
** Form generated from reading ui file 'UIBonusPanoplies.jui'
**
** Created: mer. 24. juin 12:04:03 2009
**      by: Qt User Interface Compiler version 4.5.0
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

package org.JDofusCalc.vues.Qt.designer;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

import org.JDofusCalc.vues.Qt.composants.*;

public class UIBonusPanoplies implements com.trolltech.qt.QUiForm<QWidget>
{
    public QGridLayout gridLayout;
    public QFrame frame1;
    public QGridLayout gridLayout_4;
    public QLabel lbl;
    public QComboBox cmbPanoplies;
    public QWidgetFiltre filtre;
    public QFrame frame;
    public QGridLayout gridLayout_6;
    public QSpacerItem horizontalSpacer;
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
    public QWidgetBonusPanopliesLigne ligne1;
    public QWidgetBonusPanopliesLigne ligne2;
    public QWidgetBonusPanopliesLigne ligne3;
    public QWidgetBonusPanopliesLigne ligne4;
    public QWidgetBonusPanopliesLigne ligne5;
    public QWidgetBonusPanopliesLigne ligne6;
    public QWidgetBonusPanopliesLigne ligne7;
    public QWidgetBonusPanopliesLigne ligne8;
    public QFrame frame2;
    public QHBoxLayout horizontalLayout_2;
    public QSpacerItem horizontalSpacer_2;
    public QPushButton btnFermer;
    public QLabel lblNom;

    public UIBonusPanoplies() { super(); }

    public void setupUi(QWidget UIBonusPanoplies)
    {
        UIBonusPanoplies.setObjectName("UIBonusPanoplies");
        UIBonusPanoplies.resize(new QSize(839, 360).expandedTo(UIBonusPanoplies.minimumSizeHint()));
        QSizePolicy sizePolicy = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.MinimumExpanding, com.trolltech.qt.gui.QSizePolicy.Policy.MinimumExpanding);
        sizePolicy.setHorizontalStretch((byte)0);
        sizePolicy.setVerticalStretch((byte)0);
        sizePolicy.setHeightForWidth(UIBonusPanoplies.sizePolicy().hasHeightForWidth());
        UIBonusPanoplies.setSizePolicy(sizePolicy);
        gridLayout = new QGridLayout(UIBonusPanoplies);
        gridLayout.setObjectName("gridLayout");
        frame1 = new QFrame(UIBonusPanoplies);
        frame1.setObjectName("frame1");
        QSizePolicy sizePolicy1 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy1.setHorizontalStretch((byte)0);
        sizePolicy1.setVerticalStretch((byte)0);
        sizePolicy1.setHeightForWidth(frame1.sizePolicy().hasHeightForWidth());
        frame1.setSizePolicy(sizePolicy1);
        frame1.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        frame1.setFrameShadow(com.trolltech.qt.gui.QFrame.Shadow.Raised);
        gridLayout_4 = new QGridLayout(frame1);
        gridLayout_4.setObjectName("gridLayout_4");
        lbl = new QLabel(frame1);
        lbl.setObjectName("lbl");

        gridLayout_4.addWidget(lbl, 0, 1, 1, 1);

        cmbPanoplies = new QComboBox(frame1);
        cmbPanoplies.setObjectName("cmbPanoplies");
        cmbPanoplies.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.WheelFocus);

        gridLayout_4.addWidget(cmbPanoplies, 0, 2, 1, 2);

        filtre = new QWidgetFiltre(frame1);
        filtre.setObjectName("filtre");

        gridLayout_4.addWidget(filtre, 1, 1, 1, 3);


        gridLayout.addWidget(frame1, 0, 0, 1, 1);

        frame = new QFrame(UIBonusPanoplies);
        frame.setObjectName("frame");
        QSizePolicy sizePolicy2 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy2.setHorizontalStretch((byte)0);
        sizePolicy2.setVerticalStretch((byte)0);
        sizePolicy2.setHeightForWidth(frame.sizePolicy().hasHeightForWidth());
        frame.setSizePolicy(sizePolicy2);
        frame.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        frame.setFrameShadow(com.trolltech.qt.gui.QFrame.Shadow.Raised);
        gridLayout_6 = new QGridLayout(frame);
        gridLayout_6.setSpacing(2);
        gridLayout_6.setMargin(1);
        gridLayout_6.setObjectName("gridLayout_6");
        horizontalSpacer = new QSpacerItem(50, 0, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        gridLayout_6.addItem(horizontalSpacer, 0, 0, 1, 1);

        frameStatsGene = new QFrame(frame);
        frameStatsGene.setObjectName("frameStatsGene");
        QSizePolicy sizePolicy3 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy3.setHorizontalStretch((byte)0);
        sizePolicy3.setVerticalStretch((byte)0);
        sizePolicy3.setHeightForWidth(frameStatsGene.sizePolicy().hasHeightForWidth());
        frameStatsGene.setSizePolicy(sizePolicy3);
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
        QSizePolicy sizePolicy4 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy4.setHorizontalStretch((byte)0);
        sizePolicy4.setVerticalStretch((byte)0);
        sizePolicy4.setHeightForWidth(lblStatsPA.sizePolicy().hasHeightForWidth());
        lblStatsPA.setSizePolicy(sizePolicy4);
        lblStatsPA.setMinimumSize(new QSize(20, 25));
        lblStatsPA.setMaximumSize(new QSize(20, 16777215));
        lblStatsPA.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsPA.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/pa.png")));
        lblStatsPA.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(lblStatsPA, 0, 1, 1, 1);

        lblStatsPM = new QLabel(frameStatsGene);
        lblStatsPM.setObjectName("lblStatsPM");
        QSizePolicy sizePolicy5 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy5.setHorizontalStretch((byte)0);
        sizePolicy5.setVerticalStretch((byte)0);
        sizePolicy5.setHeightForWidth(lblStatsPM.sizePolicy().hasHeightForWidth());
        lblStatsPM.setSizePolicy(sizePolicy5);
        lblStatsPM.setMinimumSize(new QSize(20, 25));
        lblStatsPM.setMaximumSize(new QSize(20, 16777215));
        lblStatsPM.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsPM.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/pm.png")));
        lblStatsPM.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(lblStatsPM, 0, 2, 1, 1);

        lblStatsPO = new QLabel(frameStatsGene);
        lblStatsPO.setObjectName("lblStatsPO");
        QSizePolicy sizePolicy6 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy6.setHorizontalStretch((byte)0);
        sizePolicy6.setVerticalStretch((byte)0);
        sizePolicy6.setHeightForWidth(lblStatsPO.sizePolicy().hasHeightForWidth());
        lblStatsPO.setSizePolicy(sizePolicy6);
        lblStatsPO.setMinimumSize(new QSize(20, 25));
        lblStatsPO.setMaximumSize(new QSize(20, 16777215));
        lblStatsPO.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsPO.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/po.png")));
        lblStatsPO.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(lblStatsPO, 0, 3, 1, 1);

        lblStatsIni = new QLabel(frameStatsGene);
        lblStatsIni.setObjectName("lblStatsIni");
        QSizePolicy sizePolicy7 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy7.setHorizontalStretch((byte)0);
        sizePolicy7.setVerticalStretch((byte)0);
        sizePolicy7.setHeightForWidth(lblStatsIni.sizePolicy().hasHeightForWidth());
        lblStatsIni.setSizePolicy(sizePolicy7);
        lblStatsIni.setMinimumSize(new QSize(30, 25));
        lblStatsIni.setMaximumSize(new QSize(30, 16777215));
        lblStatsIni.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsIni.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/ini.png")));
        lblStatsIni.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(lblStatsIni, 0, 4, 1, 1);

        lblStatsPP = new QLabel(frameStatsGene);
        lblStatsPP.setObjectName("lblStatsPP");
        QSizePolicy sizePolicy8 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy8.setHorizontalStretch((byte)0);
        sizePolicy8.setVerticalStretch((byte)0);
        sizePolicy8.setHeightForWidth(lblStatsPP.sizePolicy().hasHeightForWidth());
        lblStatsPP.setSizePolicy(sizePolicy8);
        lblStatsPP.setMinimumSize(new QSize(20, 25));
        lblStatsPP.setMaximumSize(new QSize(20, 16777215));
        lblStatsPP.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsPP.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/pp.png")));
        lblStatsPP.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(lblStatsPP, 0, 5, 1, 1);

        lblStatsVie = new QLabel(frameStatsGene);
        lblStatsVie.setObjectName("lblStatsVie");
        QSizePolicy sizePolicy9 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy9.setHorizontalStretch((byte)0);
        sizePolicy9.setVerticalStretch((byte)0);
        sizePolicy9.setHeightForWidth(lblStatsVie.sizePolicy().hasHeightForWidth());
        lblStatsVie.setSizePolicy(sizePolicy9);
        lblStatsVie.setMinimumSize(new QSize(30, 25));
        lblStatsVie.setMaximumSize(new QSize(30, 16777215));
        lblStatsVie.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsVie.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/vie.png")));
        lblStatsVie.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(lblStatsVie, 0, 0, 1, 1);


        gridLayout_6.addWidget(frameStatsGene, 0, 1, 1, 1);

        frameStatsCaract = new QFrame(frame);
        frameStatsCaract.setObjectName("frameStatsCaract");
        QSizePolicy sizePolicy10 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy10.setHorizontalStretch((byte)0);
        sizePolicy10.setVerticalStretch((byte)0);
        sizePolicy10.setHeightForWidth(frameStatsCaract.sizePolicy().hasHeightForWidth());
        frameStatsCaract.setSizePolicy(sizePolicy10);
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
        QSizePolicy sizePolicy11 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy11.setHorizontalStretch((byte)0);
        sizePolicy11.setVerticalStretch((byte)0);
        sizePolicy11.setHeightForWidth(lblStatsSag.sizePolicy().hasHeightForWidth());
        lblStatsSag.setSizePolicy(sizePolicy11);
        lblStatsSag.setMinimumSize(new QSize(25, 25));
        lblStatsSag.setMaximumSize(new QSize(25, 25));
        lblStatsSag.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsSag.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/sagesse.png")));
        lblStatsSag.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_3.addWidget(lblStatsSag, 0, 1, 1, 1);

        lblStatsChance = new QLabel(frameStatsCaract);
        lblStatsChance.setObjectName("lblStatsChance");
        QSizePolicy sizePolicy12 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy12.setHorizontalStretch((byte)0);
        sizePolicy12.setVerticalStretch((byte)0);
        sizePolicy12.setHeightForWidth(lblStatsChance.sizePolicy().hasHeightForWidth());
        lblStatsChance.setSizePolicy(sizePolicy12);
        lblStatsChance.setMinimumSize(new QSize(25, 25));
        lblStatsChance.setMaximumSize(new QSize(25, 25));
        lblStatsChance.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsChance.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/chance.png")));
        lblStatsChance.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_3.addWidget(lblStatsChance, 0, 4, 1, 1);

        lblStatsForce = new QLabel(frameStatsCaract);
        lblStatsForce.setObjectName("lblStatsForce");
        QSizePolicy sizePolicy13 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy13.setHorizontalStretch((byte)0);
        sizePolicy13.setVerticalStretch((byte)0);
        sizePolicy13.setHeightForWidth(lblStatsForce.sizePolicy().hasHeightForWidth());
        lblStatsForce.setSizePolicy(sizePolicy13);
        lblStatsForce.setMinimumSize(new QSize(25, 25));
        lblStatsForce.setMaximumSize(new QSize(25, 25));
        lblStatsForce.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsForce.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/force.png")));
        lblStatsForce.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_3.addWidget(lblStatsForce, 0, 2, 1, 1);

        lblStatsInt = new QLabel(frameStatsCaract);
        lblStatsInt.setObjectName("lblStatsInt");
        QSizePolicy sizePolicy14 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy14.setHorizontalStretch((byte)0);
        sizePolicy14.setVerticalStretch((byte)0);
        sizePolicy14.setHeightForWidth(lblStatsInt.sizePolicy().hasHeightForWidth());
        lblStatsInt.setSizePolicy(sizePolicy14);
        lblStatsInt.setMinimumSize(new QSize(25, 25));
        lblStatsInt.setMaximumSize(new QSize(25, 25));
        lblStatsInt.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsInt.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/intelligence.png")));
        lblStatsInt.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_3.addWidget(lblStatsInt, 0, 3, 1, 1);

        lblStatsAgi = new QLabel(frameStatsCaract);
        lblStatsAgi.setObjectName("lblStatsAgi");
        QSizePolicy sizePolicy15 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy15.setHorizontalStretch((byte)0);
        sizePolicy15.setVerticalStretch((byte)0);
        sizePolicy15.setHeightForWidth(lblStatsAgi.sizePolicy().hasHeightForWidth());
        lblStatsAgi.setSizePolicy(sizePolicy15);
        lblStatsAgi.setMinimumSize(new QSize(25, 25));
        lblStatsAgi.setMaximumSize(new QSize(25, 25));
        lblStatsAgi.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsAgi.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/agilite.png")));
        lblStatsAgi.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_3.addWidget(lblStatsAgi, 0, 5, 1, 1);

        lblStatsVita = new QLabel(frameStatsCaract);
        lblStatsVita.setObjectName("lblStatsVita");
        QSizePolicy sizePolicy16 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy16.setHorizontalStretch((byte)0);
        sizePolicy16.setVerticalStretch((byte)0);
        sizePolicy16.setHeightForWidth(lblStatsVita.sizePolicy().hasHeightForWidth());
        lblStatsVita.setSizePolicy(sizePolicy16);
        lblStatsVita.setMinimumSize(new QSize(30, 25));
        lblStatsVita.setMaximumSize(new QSize(30, 16777215));
        lblStatsVita.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsVita.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/vita.png")));
        lblStatsVita.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_3.addWidget(lblStatsVita, 0, 0, 1, 1);


        gridLayout_6.addWidget(frameStatsCaract, 0, 2, 1, 1);

        frameStatsAutre = new QFrame(frame);
        frameStatsAutre.setObjectName("frameStatsAutre");
        QSizePolicy sizePolicy17 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy17.setHorizontalStretch((byte)0);
        sizePolicy17.setVerticalStretch((byte)0);
        sizePolicy17.setHeightForWidth(frameStatsAutre.sizePolicy().hasHeightForWidth());
        frameStatsAutre.setSizePolicy(sizePolicy17);
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
        QSizePolicy sizePolicy18 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy18.setHorizontalStretch((byte)0);
        sizePolicy18.setVerticalStretch((byte)0);
        sizePolicy18.setHeightForWidth(lblStatsPDom.sizePolicy().hasHeightForWidth());
        lblStatsPDom.setSizePolicy(sizePolicy18);
        lblStatsPDom.setMinimumSize(new QSize(20, 25));
        lblStatsPDom.setMaximumSize(new QSize(20, 16777215));
        lblStatsPDom.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsPDom.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/pdommages.png")));
        lblStatsPDom.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_5.addWidget(lblStatsPDom, 0, 1, 1, 1);

        lblStatsInvoc = new QLabel(frameStatsAutre);
        lblStatsInvoc.setObjectName("lblStatsInvoc");
        QSizePolicy sizePolicy19 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy19.setHorizontalStretch((byte)0);
        sizePolicy19.setVerticalStretch((byte)0);
        sizePolicy19.setHeightForWidth(lblStatsInvoc.sizePolicy().hasHeightForWidth());
        lblStatsInvoc.setSizePolicy(sizePolicy19);
        lblStatsInvoc.setMinimumSize(new QSize(20, 25));
        lblStatsInvoc.setMaximumSize(new QSize(20, 16777215));
        lblStatsInvoc.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsInvoc.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/invoc.png")));
        lblStatsInvoc.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_5.addWidget(lblStatsInvoc, 0, 4, 1, 1);

        lblStatsCC = new QLabel(frameStatsAutre);
        lblStatsCC.setObjectName("lblStatsCC");
        QSizePolicy sizePolicy20 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy20.setHorizontalStretch((byte)0);
        sizePolicy20.setVerticalStretch((byte)0);
        sizePolicy20.setHeightForWidth(lblStatsCC.sizePolicy().hasHeightForWidth());
        lblStatsCC.setSizePolicy(sizePolicy20);
        lblStatsCC.setMinimumSize(new QSize(20, 25));
        lblStatsCC.setMaximumSize(new QSize(20, 16777215));
        lblStatsCC.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsCC.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/critique.png")));
        lblStatsCC.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_5.addWidget(lblStatsCC, 0, 2, 1, 1);

        lblStatsSoin = new QLabel(frameStatsAutre);
        lblStatsSoin.setObjectName("lblStatsSoin");
        QSizePolicy sizePolicy21 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy21.setHorizontalStretch((byte)0);
        sizePolicy21.setVerticalStretch((byte)0);
        sizePolicy21.setHeightForWidth(lblStatsSoin.sizePolicy().hasHeightForWidth());
        lblStatsSoin.setSizePolicy(sizePolicy21);
        lblStatsSoin.setMinimumSize(new QSize(20, 25));
        lblStatsSoin.setMaximumSize(new QSize(20, 16777215));
        lblStatsSoin.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsSoin.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/soins.png")));
        lblStatsSoin.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_5.addWidget(lblStatsSoin, 0, 3, 1, 1);

        lblStatsDomPiege = new QLabel(frameStatsAutre);
        lblStatsDomPiege.setObjectName("lblStatsDomPiege");
        QSizePolicy sizePolicy22 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy22.setHorizontalStretch((byte)0);
        sizePolicy22.setVerticalStretch((byte)0);
        sizePolicy22.setHeightForWidth(lblStatsDomPiege.sizePolicy().hasHeightForWidth());
        lblStatsDomPiege.setSizePolicy(sizePolicy22);
        lblStatsDomPiege.setMinimumSize(new QSize(20, 25));
        lblStatsDomPiege.setMaximumSize(new QSize(20, 16777215));
        lblStatsDomPiege.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsDomPiege.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/piege.png")));
        lblStatsDomPiege.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_5.addWidget(lblStatsDomPiege, 0, 5, 1, 1);

        lblStatsPDomPiege = new QLabel(frameStatsAutre);
        lblStatsPDomPiege.setObjectName("lblStatsPDomPiege");
        QSizePolicy sizePolicy23 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy23.setHorizontalStretch((byte)0);
        sizePolicy23.setVerticalStretch((byte)0);
        sizePolicy23.setHeightForWidth(lblStatsPDomPiege.sizePolicy().hasHeightForWidth());
        lblStatsPDomPiege.setSizePolicy(sizePolicy23);
        lblStatsPDomPiege.setMinimumSize(new QSize(20, 25));
        lblStatsPDomPiege.setMaximumSize(new QSize(20, 16777215));
        lblStatsPDomPiege.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsPDomPiege.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/ppiege.png")));
        lblStatsPDomPiege.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_5.addWidget(lblStatsPDomPiege, 0, 6, 1, 1);

        lblStatsEC = new QLabel(frameStatsAutre);
        lblStatsEC.setObjectName("lblStatsEC");
        QSizePolicy sizePolicy24 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy24.setHorizontalStretch((byte)0);
        sizePolicy24.setVerticalStretch((byte)0);
        sizePolicy24.setHeightForWidth(lblStatsEC.sizePolicy().hasHeightForWidth());
        lblStatsEC.setSizePolicy(sizePolicy24);
        lblStatsEC.setMinimumSize(new QSize(20, 25));
        lblStatsEC.setMaximumSize(new QSize(20, 16777215));
        lblStatsEC.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsEC.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/echecs_critiques.png")));
        lblStatsEC.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_5.addWidget(lblStatsEC, 0, 7, 1, 1);

        lblStatsRenvois = new QLabel(frameStatsAutre);
        lblStatsRenvois.setObjectName("lblStatsRenvois");
        QSizePolicy sizePolicy25 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy25.setHorizontalStretch((byte)0);
        sizePolicy25.setVerticalStretch((byte)0);
        sizePolicy25.setHeightForWidth(lblStatsRenvois.sizePolicy().hasHeightForWidth());
        lblStatsRenvois.setSizePolicy(sizePolicy25);
        lblStatsRenvois.setMinimumSize(new QSize(20, 25));
        lblStatsRenvois.setMaximumSize(new QSize(20, 16777215));
        lblStatsRenvois.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsRenvois.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/renvois.png")));
        lblStatsRenvois.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_5.addWidget(lblStatsRenvois, 0, 8, 1, 1);

        lblStatsDom = new QLabel(frameStatsAutre);
        lblStatsDom.setObjectName("lblStatsDom");
        QSizePolicy sizePolicy26 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy26.setHorizontalStretch((byte)0);
        sizePolicy26.setVerticalStretch((byte)0);
        sizePolicy26.setHeightForWidth(lblStatsDom.sizePolicy().hasHeightForWidth());
        lblStatsDom.setSizePolicy(sizePolicy26);
        lblStatsDom.setMinimumSize(new QSize(20, 25));
        lblStatsDom.setMaximumSize(new QSize(20, 16777215));
        lblStatsDom.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsDom.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/dommages.png")));
        lblStatsDom.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_5.addWidget(lblStatsDom, 0, 0, 1, 1);


        gridLayout_6.addWidget(frameStatsAutre, 0, 3, 1, 1);

        frameStatsRes = new QFrame(frame);
        frameStatsRes.setObjectName("frameStatsRes");
        QSizePolicy sizePolicy27 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy27.setHorizontalStretch((byte)0);
        sizePolicy27.setVerticalStretch((byte)0);
        sizePolicy27.setHeightForWidth(frameStatsRes.sizePolicy().hasHeightForWidth());
        frameStatsRes.setSizePolicy(sizePolicy27);
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
        QSizePolicy sizePolicy28 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy28.setHorizontalStretch((byte)0);
        sizePolicy28.setVerticalStretch((byte)0);
        sizePolicy28.setHeightForWidth(lblStatsResMagique.sizePolicy().hasHeightForWidth());
        lblStatsResMagique.setSizePolicy(sizePolicy28);
        lblStatsResMagique.setMinimumSize(new QSize(20, 25));
        lblStatsResMagique.setMaximumSize(new QSize(20, 25));
        lblStatsResMagique.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsResMagique.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/resMagique.png")));
        lblStatsResMagique.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsResMagique, 0, 0, 1, 1);

        lblStatsResPhysique = new QLabel(frameStatsRes);
        lblStatsResPhysique.setObjectName("lblStatsResPhysique");
        QSizePolicy sizePolicy29 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy29.setHorizontalStretch((byte)0);
        sizePolicy29.setVerticalStretch((byte)0);
        sizePolicy29.setHeightForWidth(lblStatsResPhysique.sizePolicy().hasHeightForWidth());
        lblStatsResPhysique.setSizePolicy(sizePolicy29);
        lblStatsResPhysique.setMinimumSize(new QSize(20, 25));
        lblStatsResPhysique.setMaximumSize(new QSize(20, 25));
        lblStatsResPhysique.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsResPhysique.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/resPhysique.png")));
        lblStatsResPhysique.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsResPhysique, 0, 1, 1, 1);

        lblStatsResNeutre = new QLabel(frameStatsRes);
        lblStatsResNeutre.setObjectName("lblStatsResNeutre");
        QSizePolicy sizePolicy30 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy30.setHorizontalStretch((byte)0);
        sizePolicy30.setVerticalStretch((byte)0);
        sizePolicy30.setHeightForWidth(lblStatsResNeutre.sizePolicy().hasHeightForWidth());
        lblStatsResNeutre.setSizePolicy(sizePolicy30);
        lblStatsResNeutre.setMinimumSize(new QSize(20, 25));
        lblStatsResNeutre.setMaximumSize(new QSize(20, 25));
        lblStatsResNeutre.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsResNeutre.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/resNeutre.png")));
        lblStatsResNeutre.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsResNeutre, 0, 2, 1, 1);

        lblStatsPResNeutre = new QLabel(frameStatsRes);
        lblStatsPResNeutre.setObjectName("lblStatsPResNeutre");
        QSizePolicy sizePolicy31 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy31.setHorizontalStretch((byte)0);
        sizePolicy31.setVerticalStretch((byte)0);
        sizePolicy31.setHeightForWidth(lblStatsPResNeutre.sizePolicy().hasHeightForWidth());
        lblStatsPResNeutre.setSizePolicy(sizePolicy31);
        lblStatsPResNeutre.setMinimumSize(new QSize(20, 25));
        lblStatsPResNeutre.setMaximumSize(new QSize(20, 25));
        lblStatsPResNeutre.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsPResNeutre.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/PResNeutre.png")));
        lblStatsPResNeutre.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsPResNeutre, 0, 3, 1, 1);

        lblStatsResTerre = new QLabel(frameStatsRes);
        lblStatsResTerre.setObjectName("lblStatsResTerre");
        QSizePolicy sizePolicy32 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy32.setHorizontalStretch((byte)0);
        sizePolicy32.setVerticalStretch((byte)0);
        sizePolicy32.setHeightForWidth(lblStatsResTerre.sizePolicy().hasHeightForWidth());
        lblStatsResTerre.setSizePolicy(sizePolicy32);
        lblStatsResTerre.setMinimumSize(new QSize(20, 25));
        lblStatsResTerre.setMaximumSize(new QSize(20, 25));
        lblStatsResTerre.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsResTerre.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/resTerre.png")));
        lblStatsResTerre.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsResTerre, 0, 4, 1, 1);

        lblStatsPResTerre = new QLabel(frameStatsRes);
        lblStatsPResTerre.setObjectName("lblStatsPResTerre");
        QSizePolicy sizePolicy33 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy33.setHorizontalStretch((byte)0);
        sizePolicy33.setVerticalStretch((byte)0);
        sizePolicy33.setHeightForWidth(lblStatsPResTerre.sizePolicy().hasHeightForWidth());
        lblStatsPResTerre.setSizePolicy(sizePolicy33);
        lblStatsPResTerre.setMinimumSize(new QSize(20, 25));
        lblStatsPResTerre.setMaximumSize(new QSize(20, 25));
        lblStatsPResTerre.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsPResTerre.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/PResTerre.png")));
        lblStatsPResTerre.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsPResTerre, 0, 5, 1, 1);

        lblStatsResFeu = new QLabel(frameStatsRes);
        lblStatsResFeu.setObjectName("lblStatsResFeu");
        QSizePolicy sizePolicy34 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy34.setHorizontalStretch((byte)0);
        sizePolicy34.setVerticalStretch((byte)0);
        sizePolicy34.setHeightForWidth(lblStatsResFeu.sizePolicy().hasHeightForWidth());
        lblStatsResFeu.setSizePolicy(sizePolicy34);
        lblStatsResFeu.setMinimumSize(new QSize(20, 25));
        lblStatsResFeu.setMaximumSize(new QSize(20, 25));
        lblStatsResFeu.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsResFeu.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/resFeu.png")));
        lblStatsResFeu.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsResFeu, 0, 6, 1, 1);

        lblStatsPResFeu = new QLabel(frameStatsRes);
        lblStatsPResFeu.setObjectName("lblStatsPResFeu");
        QSizePolicy sizePolicy35 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy35.setHorizontalStretch((byte)0);
        sizePolicy35.setVerticalStretch((byte)0);
        sizePolicy35.setHeightForWidth(lblStatsPResFeu.sizePolicy().hasHeightForWidth());
        lblStatsPResFeu.setSizePolicy(sizePolicy35);
        lblStatsPResFeu.setMinimumSize(new QSize(20, 25));
        lblStatsPResFeu.setMaximumSize(new QSize(20, 25));
        lblStatsPResFeu.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsPResFeu.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/PResFeu.png")));
        lblStatsPResFeu.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsPResFeu, 0, 7, 1, 1);

        lblStatsResEau = new QLabel(frameStatsRes);
        lblStatsResEau.setObjectName("lblStatsResEau");
        QSizePolicy sizePolicy36 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy36.setHorizontalStretch((byte)0);
        sizePolicy36.setVerticalStretch((byte)0);
        sizePolicy36.setHeightForWidth(lblStatsResEau.sizePolicy().hasHeightForWidth());
        lblStatsResEau.setSizePolicy(sizePolicy36);
        lblStatsResEau.setMinimumSize(new QSize(20, 25));
        lblStatsResEau.setMaximumSize(new QSize(20, 25));
        lblStatsResEau.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsResEau.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/resEau.png")));
        lblStatsResEau.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsResEau, 0, 8, 1, 1);

        lblStatsPResEau = new QLabel(frameStatsRes);
        lblStatsPResEau.setObjectName("lblStatsPResEau");
        QSizePolicy sizePolicy37 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy37.setHorizontalStretch((byte)0);
        sizePolicy37.setVerticalStretch((byte)0);
        sizePolicy37.setHeightForWidth(lblStatsPResEau.sizePolicy().hasHeightForWidth());
        lblStatsPResEau.setSizePolicy(sizePolicy37);
        lblStatsPResEau.setMinimumSize(new QSize(20, 25));
        lblStatsPResEau.setMaximumSize(new QSize(20, 25));
        lblStatsPResEau.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsPResEau.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/PResEau.png")));
        lblStatsPResEau.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsPResEau, 0, 9, 1, 1);

        lblStatsResAir = new QLabel(frameStatsRes);
        lblStatsResAir.setObjectName("lblStatsResAir");
        QSizePolicy sizePolicy38 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy38.setHorizontalStretch((byte)0);
        sizePolicy38.setVerticalStretch((byte)0);
        sizePolicy38.setHeightForWidth(lblStatsResAir.sizePolicy().hasHeightForWidth());
        lblStatsResAir.setSizePolicy(sizePolicy38);
        lblStatsResAir.setMinimumSize(new QSize(20, 25));
        lblStatsResAir.setMaximumSize(new QSize(20, 25));
        lblStatsResAir.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsResAir.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/resAir.png")));
        lblStatsResAir.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsResAir, 0, 10, 1, 1);

        lblStatsPResAir = new QLabel(frameStatsRes);
        lblStatsPResAir.setObjectName("lblStatsPResAir");
        QSizePolicy sizePolicy39 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy39.setHorizontalStretch((byte)0);
        sizePolicy39.setVerticalStretch((byte)0);
        sizePolicy39.setHeightForWidth(lblStatsPResAir.sizePolicy().hasHeightForWidth());
        lblStatsPResAir.setSizePolicy(sizePolicy39);
        lblStatsPResAir.setMinimumSize(new QSize(20, 25));
        lblStatsPResAir.setMaximumSize(new QSize(20, 25));
        lblStatsPResAir.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsPResAir.setPixmap(new QPixmap(("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/PResAir.png")));
        lblStatsPResAir.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsPResAir, 0, 11, 1, 1);


        gridLayout_6.addWidget(frameStatsRes, 0, 4, 1, 1);

        ligne1 = new QWidgetBonusPanopliesLigne(frame);
        ligne1.setObjectName("ligne1");
        QSizePolicy sizePolicy40 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy40.setHorizontalStretch((byte)0);
        sizePolicy40.setVerticalStretch((byte)0);
        sizePolicy40.setHeightForWidth(ligne1.sizePolicy().hasHeightForWidth());
        ligne1.setSizePolicy(sizePolicy40);
        ligne1.setProperty("test", 1);

        gridLayout_6.addWidget(ligne1, 1, 0, 1, 5);

        ligne2 = new QWidgetBonusPanopliesLigne(frame);
        ligne2.setObjectName("ligne2");
        QSizePolicy sizePolicy41 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy41.setHorizontalStretch((byte)0);
        sizePolicy41.setVerticalStretch((byte)0);
        sizePolicy41.setHeightForWidth(ligne2.sizePolicy().hasHeightForWidth());
        ligne2.setSizePolicy(sizePolicy41);
        ligne2.setProperty("test", 2);

        gridLayout_6.addWidget(ligne2, 2, 0, 1, 5);

        ligne3 = new QWidgetBonusPanopliesLigne(frame);
        ligne3.setObjectName("ligne3");
        QSizePolicy sizePolicy42 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy42.setHorizontalStretch((byte)0);
        sizePolicy42.setVerticalStretch((byte)0);
        sizePolicy42.setHeightForWidth(ligne3.sizePolicy().hasHeightForWidth());
        ligne3.setSizePolicy(sizePolicy42);
        ligne3.setProperty("test", 3);

        gridLayout_6.addWidget(ligne3, 3, 0, 1, 5);

        ligne4 = new QWidgetBonusPanopliesLigne(frame);
        ligne4.setObjectName("ligne4");
        QSizePolicy sizePolicy43 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy43.setHorizontalStretch((byte)0);
        sizePolicy43.setVerticalStretch((byte)0);
        sizePolicy43.setHeightForWidth(ligne4.sizePolicy().hasHeightForWidth());
        ligne4.setSizePolicy(sizePolicy43);
        ligne4.setProperty("test", 4);

        gridLayout_6.addWidget(ligne4, 4, 0, 1, 5);

        ligne5 = new QWidgetBonusPanopliesLigne(frame);
        ligne5.setObjectName("ligne5");
        QSizePolicy sizePolicy44 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy44.setHorizontalStretch((byte)0);
        sizePolicy44.setVerticalStretch((byte)0);
        sizePolicy44.setHeightForWidth(ligne5.sizePolicy().hasHeightForWidth());
        ligne5.setSizePolicy(sizePolicy44);
        ligne5.setProperty("test", 5);

        gridLayout_6.addWidget(ligne5, 5, 0, 1, 5);

        ligne6 = new QWidgetBonusPanopliesLigne(frame);
        ligne6.setObjectName("ligne6");
        QSizePolicy sizePolicy45 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy45.setHorizontalStretch((byte)0);
        sizePolicy45.setVerticalStretch((byte)0);
        sizePolicy45.setHeightForWidth(ligne6.sizePolicy().hasHeightForWidth());
        ligne6.setSizePolicy(sizePolicy45);
        ligne6.setProperty("test", 6);

        gridLayout_6.addWidget(ligne6, 6, 0, 1, 5);

        ligne7 = new QWidgetBonusPanopliesLigne(frame);
        ligne7.setObjectName("ligne7");
        QSizePolicy sizePolicy46 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy46.setHorizontalStretch((byte)0);
        sizePolicy46.setVerticalStretch((byte)0);
        sizePolicy46.setHeightForWidth(ligne7.sizePolicy().hasHeightForWidth());
        ligne7.setSizePolicy(sizePolicy46);
        ligne7.setProperty("test", 7);

        gridLayout_6.addWidget(ligne7, 7, 0, 1, 5);

        ligne8 = new QWidgetBonusPanopliesLigne(frame);
        ligne8.setObjectName("ligne8");
        QSizePolicy sizePolicy47 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy47.setHorizontalStretch((byte)0);
        sizePolicy47.setVerticalStretch((byte)0);
        sizePolicy47.setHeightForWidth(ligne8.sizePolicy().hasHeightForWidth());
        ligne8.setSizePolicy(sizePolicy47);
        ligne8.setProperty("test", 8);

        gridLayout_6.addWidget(ligne8, 8, 0, 1, 5);


        gridLayout.addWidget(frame, 1, 0, 1, 2);

        frame2 = new QFrame(UIBonusPanoplies);
        frame2.setObjectName("frame2");
        QSizePolicy sizePolicy48 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy48.setHorizontalStretch((byte)0);
        sizePolicy48.setVerticalStretch((byte)0);
        sizePolicy48.setHeightForWidth(frame2.sizePolicy().hasHeightForWidth());
        frame2.setSizePolicy(sizePolicy48);
        frame2.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        frame2.setFrameShadow(com.trolltech.qt.gui.QFrame.Shadow.Raised);
        horizontalLayout_2 = new QHBoxLayout(frame2);
        horizontalLayout_2.setSpacing(0);
        horizontalLayout_2.setMargin(0);
        horizontalLayout_2.setObjectName("horizontalLayout_2");
        horizontalSpacer_2 = new QSpacerItem(738, 17, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        horizontalLayout_2.addItem(horizontalSpacer_2);

        btnFermer = new QPushButton(frame2);
        btnFermer.setObjectName("btnFermer");
        btnFermer.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        btnFermer.setIcon(new QIcon(new QPixmap("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/exit.png")));
        btnFermer.setIconSize(new QSize(24, 24));

        horizontalLayout_2.addWidget(btnFermer);


        gridLayout.addWidget(frame2, 2, 0, 1, 2);

        lblNom = new QLabel(UIBonusPanoplies);
        lblNom.setObjectName("lblNom");
        QSizePolicy sizePolicy49 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy49.setHorizontalStretch((byte)0);
        sizePolicy49.setVerticalStretch((byte)0);
        sizePolicy49.setHeightForWidth(lblNom.sizePolicy().hasHeightForWidth());
        lblNom.setSizePolicy(sizePolicy49);
        QFont font = new QFont();
        font.setPointSize(12);
        font.setBold(true);
        font.setWeight(75);
        lblNom.setFont(font);
        lblNom.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout.addWidget(lblNom, 0, 1, 1, 1);

        retranslateUi(UIBonusPanoplies);

        UIBonusPanoplies.connectSlotsByName();
    } // setupUi

    void retranslateUi(QWidget UIBonusPanoplies)
    {
        UIBonusPanoplies.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanoplies", "Bonus des panoplies", null));
        lbl.setText(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanoplies", "Panoplie :", null));
        lblStatsPA.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanoplies", "Points d'action", null));
        lblStatsPA.setText("");
        lblStatsPM.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanoplies", "Points de mouvement", null));
        lblStatsPM.setText("");
        lblStatsPO.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanoplies", "Bonus de Port\u00e9e", null));
        lblStatsPO.setText("");
        lblStatsIni.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanoplies", "Initiative", null));
        lblStatsIni.setText("");
        lblStatsPP.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanoplies", "Prospection", null));
        lblStatsPP.setText("");
        lblStatsVie.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanoplies", "Vie totale", null));
        lblStatsVie.setText("");
        lblStatsSag.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanoplies", "Sagesse", null));
        lblStatsSag.setText("");
        lblStatsChance.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanoplies", "Chance", null));
        lblStatsChance.setText("");
        lblStatsForce.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanoplies", "Force", null));
        lblStatsForce.setText("");
        lblStatsInt.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanoplies", "Intelligence", null));
        lblStatsInt.setText("");
        lblStatsAgi.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanoplies", "Agilit\u00e9", null));
        lblStatsAgi.setText("");
        lblStatsVita.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanoplies", "Vitalit\u00e9", null));
        lblStatsVita.setText("");
        lblStatsPDom.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanoplies", "% Dommages", null));
        lblStatsPDom.setText("");
        lblStatsInvoc.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanoplies", "Cr\u00e9atures invocables", null));
        lblStatsInvoc.setText("");
        lblStatsCC.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanoplies", "Bonus Coups Critiques", null));
        lblStatsCC.setText("");
        lblStatsSoin.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanoplies", "Soins", null));
        lblStatsSoin.setText("");
        lblStatsDomPiege.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanoplies", "Dommages aux pi\u00e8ges", null));
        lblStatsDomPiege.setText("");
        lblStatsPDomPiege.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanoplies", "% Dommages aux pi\u00e8ges", null));
        lblStatsPDomPiege.setText("");
        lblStatsEC.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanoplies", "Malus aux \u00e9checs critiques", null));
        lblStatsEC.setText("");
        lblStatsRenvois.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanoplies", "Revois", null));
        lblStatsRenvois.setText("");
        lblStatsDom.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanoplies", "Dommages", null));
        lblStatsDom.setText("");
        lblStatsResMagique.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanoplies", "R\u00e9sistance Magique", null));
        lblStatsResMagique.setText("");
        lblStatsResPhysique.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanoplies", "R\u00e9sistance physique", null));
        lblStatsResPhysique.setText("");
        lblStatsResNeutre.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanoplies", "R\u00e9sistance Neutre", null));
        lblStatsResNeutre.setText("");
        lblStatsPResNeutre.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanoplies", "% R\u00e9sistance Neutre", null));
        lblStatsPResNeutre.setText("");
        lblStatsResTerre.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanoplies", "R\u00e9sistance Terre", null));
        lblStatsResTerre.setText("");
        lblStatsPResTerre.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanoplies", "% R\u00e9sistance Terre", null));
        lblStatsPResTerre.setText("");
        lblStatsResFeu.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanoplies", "R\u00e9sistance Feu", null));
        lblStatsResFeu.setText("");
        lblStatsPResFeu.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanoplies", "% R\u00e9sistance Feu", null));
        lblStatsPResFeu.setText("");
        lblStatsResEau.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanoplies", "R\u00e9sistance Eau", null));
        lblStatsResEau.setText("");
        lblStatsPResEau.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanoplies", "% R\u00e9sistance Eau", null));
        lblStatsPResEau.setText("");
        lblStatsResAir.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanoplies", "R\u00e9sistance Air", null));
        lblStatsResAir.setText("");
        lblStatsPResAir.setStatusTip(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanoplies", "% R\u00e9sistance Air", null));
        lblStatsPResAir.setText("");
        btnFermer.setText(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanoplies", "Fermer", null));
        lblNom.setText(com.trolltech.qt.core.QCoreApplication.translate("UIBonusPanoplies", "Aucune panoplie s\u00e9lectionn\u00e9e", null));
    } // retranslateUi

}

