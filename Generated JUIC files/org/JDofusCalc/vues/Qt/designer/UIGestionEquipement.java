/********************************************************************************
** Form generated from reading ui file 'UIGestionEquipement.jui'
**
** Created: mer. 22. juil. 00:13:47 2009
**      by: Qt User Interface Compiler version 4.5.0
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

package org.JDofusCalc.vues.Qt.designer;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

import org.JDofusCalc.vues.Qt.composants.*;

public class UIGestionEquipement implements com.trolltech.qt.QUiForm<QWidget>
{
    public QGridLayout gridLayout_11;
    public QGroupBox grpModele;
    public QGridLayout gridLayout_12;
    public QComboBox comboModele;
    public QPushButton btnChargerModele;
    public QFrame frame;
    public QHBoxLayout horizontalLayout_2;
    public QRadioButton rbtnMini;
    public QRadioButton rbtnMoy;
    public QRadioButton rbtnMaxi;
    public QWidgetFiltre filtre;
    public QFrame frameListe;
    public QVBoxLayout verticalLayout_5;
    public QLabel lblListe;
    public QListWidget listeEquip;
    public QFrame frameActions;
    public QHBoxLayout horizontalLayout;
    public QPushButton btnNouveau;
    public QPushButton btnSupp;
    public QSpacerItem horizontalSpacer;
    public QPushButton btnSauv;
    public QPushButton btnFermer;
    public QTabWidget onglets;
    public QWidget ongletCaract;
    public QGridLayout gridLayout_8;
    public QFrame frameStats;
    public QGridLayout gridLayout_13;
    public QFrame frameStatsGene;
    public QVBoxLayout verticalLayout;
    public QFrame frameStatsGeneIcones;
    public QGridLayout gridLayout_2;
    public QLabel lblStatsPA;
    public QLabel lblStatsPM;
    public QLabel lblStatsPO;
    public QLabel lblStatsIni;
    public QLabel lblStatsPP;
    public QLabel lblStatsVie;
    public QFrame frameStatsGeneTxt;
    public QGridLayout gridLayout_4;
    public QLineEdit txtStatsPA;
    public QLineEdit txtStatsIni;
    public QLineEdit txtStatsVie;
    public QLineEdit txtStatsPO;
    public QLineEdit txtStatsPP;
    public QLineEdit txtStatsPM;
    public QFrame frameStatsAutre;
    public QVBoxLayout verticalLayout_3;
    public QFrame frameStatsAutreIcones;
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
    public QFrame frameStatsAutreTxt;
    public QGridLayout gridLayout_7;
    public QLineEdit txtStatsDomPiege;
    public QLineEdit txtStatsPDomPiege;
    public QLineEdit txtStatsPDom;
    public QLineEdit txtStatsSoin;
    public QLineEdit txtStatsCC;
    public QLineEdit txtStatsEC;
    public QLineEdit txtStatsRenvois;
    public QLineEdit txtStatsDom;
    public QLineEdit txtStatsInvoc;
    public QFrame frameStatsRes;
    public QVBoxLayout verticalLayout_4;
    public QFrame frameStatsResIcones;
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
    public QFrame frameStatsResTxt;
    public QGridLayout gridLayout_10;
    public QLineEdit txtStatsResMagique;
    public QLineEdit txtStatsResPhysique;
    public QLineEdit txtStatsResNeutre;
    public QLineEdit txtStatsPResNeutre;
    public QLineEdit txtStatsResTerre;
    public QLineEdit txtStatsPResTerre;
    public QLineEdit txtStatsResFeu;
    public QLineEdit txtStatsPResFeu;
    public QLineEdit txtStatsResEau;
    public QLineEdit txtStatsPResEau;
    public QLineEdit txtStatsResAir;
    public QLineEdit txtStatsPResAir;
    public QFrame frameStatsCaract;
    public QVBoxLayout verticalLayout_2;
    public QFrame frameStatsCaractIcones;
    public QGridLayout gridLayout_3;
    public QLabel lblStatsSag;
    public QLabel lblStatsChance;
    public QLabel lblStatsForce;
    public QLabel lblStatsInt;
    public QLabel lblStatsAgi;
    public QLabel lblStatsVita;
    public QFrame frameStatsCaractTxt;
    public QGridLayout gridLayout_6;
    public QLineEdit txtStatsAgi;
    public QLineEdit txtStatsChance;
    public QLineEdit txtStatsInt;
    public QLineEdit txtStatsVita;
    public QLineEdit txtStatsSag;
    public QLineEdit txtStatsForce;
    public QLabel lblNom;
    public QLineEdit txtNom;
    public QLabel lblPano;
    public QComboBox comboPano;
    public QSpinBox spinBoxNiveau;
    public QLabel lblNiveau;
    public QWidget ongletCondition;
    public QGridLayout gridLayout;
    public QWidgetConditions widgetConditions;

    public UIGestionEquipement() { super(); }

    public void setupUi(QWidget UIGestionEquipement)
    {
        UIGestionEquipement.setObjectName("UIGestionEquipement");
        UIGestionEquipement.resize(new QSize(666, 385).expandedTo(UIGestionEquipement.minimumSizeHint()));
        gridLayout_11 = new QGridLayout(UIGestionEquipement);
        gridLayout_11.setObjectName("gridLayout_11");
        grpModele = new QGroupBox(UIGestionEquipement);
        grpModele.setObjectName("grpModele");
        gridLayout_12 = new QGridLayout(grpModele);
        gridLayout_12.setObjectName("gridLayout_12");
        comboModele = new QComboBox(grpModele);
        comboModele.setObjectName("comboModele");
        QSizePolicy sizePolicy = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy.setHorizontalStretch((byte)0);
        sizePolicy.setVerticalStretch((byte)0);
        sizePolicy.setHeightForWidth(comboModele.sizePolicy().hasHeightForWidth());
        comboModele.setSizePolicy(sizePolicy);
        comboModele.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.WheelFocus);

        gridLayout_12.addWidget(comboModele, 0, 1, 1, 1);

        btnChargerModele = new QPushButton(grpModele);
        btnChargerModele.setObjectName("btnChargerModele");
        btnChargerModele.setEnabled(false);
        QSizePolicy sizePolicy1 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy1.setHorizontalStretch((byte)0);
        sizePolicy1.setVerticalStretch((byte)0);
        sizePolicy1.setHeightForWidth(btnChargerModele.sizePolicy().hasHeightForWidth());
        btnChargerModele.setSizePolicy(sizePolicy1);
        btnChargerModele.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        btnChargerModele.setIcon(new QIcon(new QPixmap("classpath:org/JDofusCalc/ressources/images/fileopen.png")));
        btnChargerModele.setIconSize(new QSize(24, 24));

        gridLayout_12.addWidget(btnChargerModele, 0, 3, 1, 2);

        frame = new QFrame(grpModele);
        frame.setObjectName("frame");
        frame.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        frame.setFrameShadow(com.trolltech.qt.gui.QFrame.Shadow.Raised);
        horizontalLayout_2 = new QHBoxLayout(frame);
        horizontalLayout_2.setSpacing(1);
        horizontalLayout_2.setMargin(1);
        horizontalLayout_2.setObjectName("horizontalLayout_2");
        rbtnMini = new QRadioButton(frame);
        rbtnMini.setObjectName("rbtnMini");
        QSizePolicy sizePolicy2 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy2.setHorizontalStretch((byte)0);
        sizePolicy2.setVerticalStretch((byte)0);
        sizePolicy2.setHeightForWidth(rbtnMini.sizePolicy().hasHeightForWidth());
        rbtnMini.setSizePolicy(sizePolicy2);
        rbtnMini.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);

        horizontalLayout_2.addWidget(rbtnMini);

        rbtnMoy = new QRadioButton(frame);
        rbtnMoy.setObjectName("rbtnMoy");
        QSizePolicy sizePolicy3 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy3.setHorizontalStretch((byte)0);
        sizePolicy3.setVerticalStretch((byte)0);
        sizePolicy3.setHeightForWidth(rbtnMoy.sizePolicy().hasHeightForWidth());
        rbtnMoy.setSizePolicy(sizePolicy3);
        rbtnMoy.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        rbtnMoy.setChecked(true);

        horizontalLayout_2.addWidget(rbtnMoy);

        rbtnMaxi = new QRadioButton(frame);
        rbtnMaxi.setObjectName("rbtnMaxi");
        QSizePolicy sizePolicy4 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy4.setHorizontalStretch((byte)0);
        sizePolicy4.setVerticalStretch((byte)0);
        sizePolicy4.setHeightForWidth(rbtnMaxi.sizePolicy().hasHeightForWidth());
        rbtnMaxi.setSizePolicy(sizePolicy4);
        rbtnMaxi.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        rbtnMaxi.setChecked(false);

        horizontalLayout_2.addWidget(rbtnMaxi);


        gridLayout_12.addWidget(frame, 2, 0, 1, 5);

        filtre = new QWidgetFiltre(grpModele);
        filtre.setObjectName("filtre");
        QSizePolicy sizePolicy5 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Preferred);
        sizePolicy5.setHorizontalStretch((byte)0);
        sizePolicy5.setVerticalStretch((byte)0);
        sizePolicy5.setHeightForWidth(filtre.sizePolicy().hasHeightForWidth());
        filtre.setSizePolicy(sizePolicy5);

        gridLayout_12.addWidget(filtre, 0, 0, 1, 1);


        gridLayout_11.addWidget(grpModele, 0, 1, 1, 1);

        frameListe = new QFrame(UIGestionEquipement);
        frameListe.setObjectName("frameListe");
        QSizePolicy sizePolicy6 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Preferred);
        sizePolicy6.setHorizontalStretch((byte)0);
        sizePolicy6.setVerticalStretch((byte)0);
        sizePolicy6.setHeightForWidth(frameListe.sizePolicy().hasHeightForWidth());
        frameListe.setSizePolicy(sizePolicy6);
        frameListe.setMinimumSize(new QSize(165, 0));
        frameListe.setMaximumSize(new QSize(165, 16777215));
        frameListe.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        frameListe.setFrameShadow(com.trolltech.qt.gui.QFrame.Shadow.Raised);
        verticalLayout_5 = new QVBoxLayout(frameListe);
        verticalLayout_5.setSpacing(0);
        verticalLayout_5.setMargin(0);
        verticalLayout_5.setObjectName("verticalLayout_5");
        lblListe = new QLabel(frameListe);
        lblListe.setObjectName("lblListe");
        QFont font = new QFont();
        font.setBold(true);
        font.setWeight(75);
        lblListe.setFont(font);

        verticalLayout_5.addWidget(lblListe);

        listeEquip = new QListWidget(frameListe);
        listeEquip.setObjectName("listeEquip");
        listeEquip.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.WheelFocus);

        verticalLayout_5.addWidget(listeEquip);


        gridLayout_11.addWidget(frameListe, 0, 0, 3, 1);

        frameActions = new QFrame(UIGestionEquipement);
        frameActions.setObjectName("frameActions");
        frameActions.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        frameActions.setFrameShadow(com.trolltech.qt.gui.QFrame.Shadow.Raised);
        horizontalLayout = new QHBoxLayout(frameActions);
        horizontalLayout.setSpacing(0);
        horizontalLayout.setMargin(0);
        horizontalLayout.setObjectName("horizontalLayout");
        btnNouveau = new QPushButton(frameActions);
        btnNouveau.setObjectName("btnNouveau");
        btnNouveau.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        btnNouveau.setIcon(new QIcon(new QPixmap("classpath:org/JDofusCalc/ressources/images/filenew.png")));
        btnNouveau.setIconSize(new QSize(24, 24));

        horizontalLayout.addWidget(btnNouveau);

        btnSupp = new QPushButton(frameActions);
        btnSupp.setObjectName("btnSupp");
        btnSupp.setEnabled(false);
        QSizePolicy sizePolicy7 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy7.setHorizontalStretch((byte)0);
        sizePolicy7.setVerticalStretch((byte)0);
        sizePolicy7.setHeightForWidth(btnSupp.sizePolicy().hasHeightForWidth());
        btnSupp.setSizePolicy(sizePolicy7);
        btnSupp.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        btnSupp.setIcon(new QIcon(new QPixmap("classpath:org/JDofusCalc/ressources/images/edit_remove.png")));
        btnSupp.setIconSize(new QSize(24, 24));

        horizontalLayout.addWidget(btnSupp);

        horizontalSpacer = new QSpacerItem(418, 17, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        horizontalLayout.addItem(horizontalSpacer);

        btnSauv = new QPushButton(frameActions);
        btnSauv.setObjectName("btnSauv");
        btnSauv.setEnabled(false);
        btnSauv.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        btnSauv.setIcon(new QIcon(new QPixmap("classpath:org/JDofusCalc/ressources/images/filesave.png")));
        btnSauv.setIconSize(new QSize(24, 24));

        horizontalLayout.addWidget(btnSauv);

        btnFermer = new QPushButton(frameActions);
        btnFermer.setObjectName("btnFermer");
        btnFermer.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        btnFermer.setIcon(new QIcon(new QPixmap("classpath:org/JDofusCalc/ressources/images/exit.png")));
        btnFermer.setIconSize(new QSize(24, 24));

        horizontalLayout.addWidget(btnFermer);


        gridLayout_11.addWidget(frameActions, 3, 0, 1, 2);

        onglets = new QTabWidget(UIGestionEquipement);
        onglets.setObjectName("onglets");
        onglets.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.TabFocus);
        ongletCaract = new QWidget();
        ongletCaract.setObjectName("ongletCaract");
        gridLayout_8 = new QGridLayout(ongletCaract);
        gridLayout_8.setObjectName("gridLayout_8");
        frameStats = new QFrame(ongletCaract);
        frameStats.setObjectName("frameStats");
        QSizePolicy sizePolicy8 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy8.setHorizontalStretch((byte)0);
        sizePolicy8.setVerticalStretch((byte)0);
        sizePolicy8.setHeightForWidth(frameStats.sizePolicy().hasHeightForWidth());
        frameStats.setSizePolicy(sizePolicy8);
        frameStats.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        frameStats.setFrameShadow(com.trolltech.qt.gui.QFrame.Shadow.Raised);
        gridLayout_13 = new QGridLayout(frameStats);
        gridLayout_13.setSpacing(0);
        gridLayout_13.setMargin(0);
        gridLayout_13.setObjectName("gridLayout_13");
        frameStatsGene = new QFrame(frameStats);
        frameStatsGene.setObjectName("frameStatsGene");
        QSizePolicy sizePolicy9 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy9.setHorizontalStretch((byte)0);
        sizePolicy9.setVerticalStretch((byte)0);
        sizePolicy9.setHeightForWidth(frameStatsGene.sizePolicy().hasHeightForWidth());
        frameStatsGene.setSizePolicy(sizePolicy9);
        frameStatsGene.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        frameStatsGene.setFrameShadow(com.trolltech.qt.gui.QFrame.Shadow.Raised);
        verticalLayout = new QVBoxLayout(frameStatsGene);
        verticalLayout.setSpacing(0);
        verticalLayout.setMargin(0);
        verticalLayout.setObjectName("verticalLayout");
        frameStatsGeneIcones = new QFrame(frameStatsGene);
        frameStatsGeneIcones.setObjectName("frameStatsGeneIcones");
        QSizePolicy sizePolicy10 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy10.setHorizontalStretch((byte)0);
        sizePolicy10.setVerticalStretch((byte)0);
        sizePolicy10.setHeightForWidth(frameStatsGeneIcones.sizePolicy().hasHeightForWidth());
        frameStatsGeneIcones.setSizePolicy(sizePolicy10);
        frameStatsGeneIcones.setStyleSheet("QFrame {\n"+
"	border: 1px solid #4578ba;\n"+
"	background-color: #8aaad9;\n"+
"}");
        frameStatsGeneIcones.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        gridLayout_2 = new QGridLayout(frameStatsGeneIcones);
        gridLayout_2.setSpacing(1);
        gridLayout_2.setMargin(1);
        gridLayout_2.setObjectName("gridLayout_2");
        gridLayout_2.setSizeConstraint(com.trolltech.qt.gui.QLayout.SizeConstraint.SetDefaultConstraint);
        lblStatsPA = new QLabel(frameStatsGeneIcones);
        lblStatsPA.setObjectName("lblStatsPA");
        QSizePolicy sizePolicy11 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy11.setHorizontalStretch((byte)0);
        sizePolicy11.setVerticalStretch((byte)0);
        sizePolicy11.setHeightForWidth(lblStatsPA.sizePolicy().hasHeightForWidth());
        lblStatsPA.setSizePolicy(sizePolicy11);
        lblStatsPA.setMinimumSize(new QSize(20, 25));
        lblStatsPA.setMaximumSize(new QSize(20, 16777215));
        lblStatsPA.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsPA.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/pa.png")));
        lblStatsPA.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(lblStatsPA, 0, 1, 1, 1);

        lblStatsPM = new QLabel(frameStatsGeneIcones);
        lblStatsPM.setObjectName("lblStatsPM");
        QSizePolicy sizePolicy12 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy12.setHorizontalStretch((byte)0);
        sizePolicy12.setVerticalStretch((byte)0);
        sizePolicy12.setHeightForWidth(lblStatsPM.sizePolicy().hasHeightForWidth());
        lblStatsPM.setSizePolicy(sizePolicy12);
        lblStatsPM.setMinimumSize(new QSize(20, 25));
        lblStatsPM.setMaximumSize(new QSize(20, 16777215));
        lblStatsPM.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsPM.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/pm.png")));
        lblStatsPM.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(lblStatsPM, 0, 2, 1, 1);

        lblStatsPO = new QLabel(frameStatsGeneIcones);
        lblStatsPO.setObjectName("lblStatsPO");
        QSizePolicy sizePolicy13 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy13.setHorizontalStretch((byte)0);
        sizePolicy13.setVerticalStretch((byte)0);
        sizePolicy13.setHeightForWidth(lblStatsPO.sizePolicy().hasHeightForWidth());
        lblStatsPO.setSizePolicy(sizePolicy13);
        lblStatsPO.setMinimumSize(new QSize(20, 25));
        lblStatsPO.setMaximumSize(new QSize(20, 16777215));
        lblStatsPO.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsPO.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/po.png")));
        lblStatsPO.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(lblStatsPO, 0, 3, 1, 1);

        lblStatsIni = new QLabel(frameStatsGeneIcones);
        lblStatsIni.setObjectName("lblStatsIni");
        QSizePolicy sizePolicy14 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy14.setHorizontalStretch((byte)0);
        sizePolicy14.setVerticalStretch((byte)0);
        sizePolicy14.setHeightForWidth(lblStatsIni.sizePolicy().hasHeightForWidth());
        lblStatsIni.setSizePolicy(sizePolicy14);
        lblStatsIni.setMinimumSize(new QSize(30, 25));
        lblStatsIni.setMaximumSize(new QSize(30, 16777215));
        lblStatsIni.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsIni.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/ini.png")));
        lblStatsIni.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(lblStatsIni, 0, 4, 1, 1);

        lblStatsPP = new QLabel(frameStatsGeneIcones);
        lblStatsPP.setObjectName("lblStatsPP");
        QSizePolicy sizePolicy15 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy15.setHorizontalStretch((byte)0);
        sizePolicy15.setVerticalStretch((byte)0);
        sizePolicy15.setHeightForWidth(lblStatsPP.sizePolicy().hasHeightForWidth());
        lblStatsPP.setSizePolicy(sizePolicy15);
        lblStatsPP.setMinimumSize(new QSize(20, 25));
        lblStatsPP.setMaximumSize(new QSize(20, 16777215));
        lblStatsPP.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsPP.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/pp.png")));
        lblStatsPP.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(lblStatsPP, 0, 5, 1, 1);

        lblStatsVie = new QLabel(frameStatsGeneIcones);
        lblStatsVie.setObjectName("lblStatsVie");
        QSizePolicy sizePolicy16 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy16.setHorizontalStretch((byte)0);
        sizePolicy16.setVerticalStretch((byte)0);
        sizePolicy16.setHeightForWidth(lblStatsVie.sizePolicy().hasHeightForWidth());
        lblStatsVie.setSizePolicy(sizePolicy16);
        lblStatsVie.setMinimumSize(new QSize(30, 25));
        lblStatsVie.setMaximumSize(new QSize(30, 16777215));
        lblStatsVie.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsVie.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/vie.png")));
        lblStatsVie.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(lblStatsVie, 0, 0, 1, 1);


        verticalLayout.addWidget(frameStatsGeneIcones);

        frameStatsGeneTxt = new QFrame(frameStatsGene);
        frameStatsGeneTxt.setObjectName("frameStatsGeneTxt");
        QSizePolicy sizePolicy17 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy17.setHorizontalStretch((byte)0);
        sizePolicy17.setVerticalStretch((byte)0);
        sizePolicy17.setHeightForWidth(frameStatsGeneTxt.sizePolicy().hasHeightForWidth());
        frameStatsGeneTxt.setSizePolicy(sizePolicy17);
        frameStatsGeneTxt.setStyleSheet("QFrame {\n"+
"	border: 1px solid #4578ba;\n"+
"	background-color: #8aaad9;\n"+
"}");
        frameStatsGeneTxt.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        gridLayout_4 = new QGridLayout(frameStatsGeneTxt);
        gridLayout_4.setSpacing(1);
        gridLayout_4.setMargin(1);
        gridLayout_4.setObjectName("gridLayout_4");
        gridLayout_4.setSizeConstraint(com.trolltech.qt.gui.QLayout.SizeConstraint.SetDefaultConstraint);
        txtStatsPA = new QLineEdit(frameStatsGeneTxt);
        txtStatsPA.setObjectName("txtStatsPA");
        QSizePolicy sizePolicy18 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy18.setHorizontalStretch((byte)0);
        sizePolicy18.setVerticalStretch((byte)0);
        sizePolicy18.setHeightForWidth(txtStatsPA.sizePolicy().hasHeightForWidth());
        txtStatsPA.setSizePolicy(sizePolicy18);
        txtStatsPA.setMinimumSize(new QSize(20, 0));
        txtStatsPA.setMaximumSize(new QSize(20, 16777215));
        QFont font1 = new QFont();
        font1.setPointSize(7);
        txtStatsPA.setFont(font1);
        txtStatsPA.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        txtStatsPA.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_4.addWidget(txtStatsPA, 0, 1, 1, 1);

        txtStatsIni = new QLineEdit(frameStatsGeneTxt);
        txtStatsIni.setObjectName("txtStatsIni");
        QSizePolicy sizePolicy19 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy19.setHorizontalStretch((byte)0);
        sizePolicy19.setVerticalStretch((byte)0);
        sizePolicy19.setHeightForWidth(txtStatsIni.sizePolicy().hasHeightForWidth());
        txtStatsIni.setSizePolicy(sizePolicy19);
        txtStatsIni.setMinimumSize(new QSize(30, 0));
        txtStatsIni.setMaximumSize(new QSize(30, 16777215));
        QFont font2 = new QFont();
        font2.setPointSize(7);
        txtStatsIni.setFont(font2);
        txtStatsIni.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        txtStatsIni.setMaxLength(5);
        txtStatsIni.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_4.addWidget(txtStatsIni, 0, 4, 1, 1);

        txtStatsVie = new QLineEdit(frameStatsGeneTxt);
        txtStatsVie.setObjectName("txtStatsVie");
        QSizePolicy sizePolicy20 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy20.setHorizontalStretch((byte)0);
        sizePolicy20.setVerticalStretch((byte)0);
        sizePolicy20.setHeightForWidth(txtStatsVie.sizePolicy().hasHeightForWidth());
        txtStatsVie.setSizePolicy(sizePolicy20);
        txtStatsVie.setMinimumSize(new QSize(30, 0));
        txtStatsVie.setMaximumSize(new QSize(30, 16777215));
        QFont font3 = new QFont();
        font3.setPointSize(7);
        txtStatsVie.setFont(font3);
        txtStatsVie.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        txtStatsVie.setMaxLength(5);
        txtStatsVie.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_4.addWidget(txtStatsVie, 0, 0, 1, 1);

        txtStatsPO = new QLineEdit(frameStatsGeneTxt);
        txtStatsPO.setObjectName("txtStatsPO");
        QSizePolicy sizePolicy21 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy21.setHorizontalStretch((byte)0);
        sizePolicy21.setVerticalStretch((byte)0);
        sizePolicy21.setHeightForWidth(txtStatsPO.sizePolicy().hasHeightForWidth());
        txtStatsPO.setSizePolicy(sizePolicy21);
        txtStatsPO.setMinimumSize(new QSize(20, 0));
        txtStatsPO.setMaximumSize(new QSize(20, 16777215));
        QFont font4 = new QFont();
        font4.setPointSize(7);
        txtStatsPO.setFont(font4);
        txtStatsPO.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        txtStatsPO.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_4.addWidget(txtStatsPO, 0, 3, 1, 1);

        txtStatsPP = new QLineEdit(frameStatsGeneTxt);
        txtStatsPP.setObjectName("txtStatsPP");
        QSizePolicy sizePolicy22 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy22.setHorizontalStretch((byte)0);
        sizePolicy22.setVerticalStretch((byte)0);
        sizePolicy22.setHeightForWidth(txtStatsPP.sizePolicy().hasHeightForWidth());
        txtStatsPP.setSizePolicy(sizePolicy22);
        txtStatsPP.setMinimumSize(new QSize(20, 0));
        txtStatsPP.setMaximumSize(new QSize(20, 16777215));
        QFont font5 = new QFont();
        font5.setPointSize(7);
        txtStatsPP.setFont(font5);
        txtStatsPP.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        txtStatsPP.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_4.addWidget(txtStatsPP, 0, 5, 1, 1);

        txtStatsPM = new QLineEdit(frameStatsGeneTxt);
        txtStatsPM.setObjectName("txtStatsPM");
        QSizePolicy sizePolicy23 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy23.setHorizontalStretch((byte)0);
        sizePolicy23.setVerticalStretch((byte)0);
        sizePolicy23.setHeightForWidth(txtStatsPM.sizePolicy().hasHeightForWidth());
        txtStatsPM.setSizePolicy(sizePolicy23);
        txtStatsPM.setMinimumSize(new QSize(20, 0));
        txtStatsPM.setMaximumSize(new QSize(20, 16777215));
        QFont font6 = new QFont();
        font6.setPointSize(7);
        txtStatsPM.setFont(font6);
        txtStatsPM.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        txtStatsPM.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_4.addWidget(txtStatsPM, 0, 2, 1, 1);


        verticalLayout.addWidget(frameStatsGeneTxt);


        gridLayout_13.addWidget(frameStatsGene, 0, 0, 1, 1);

        frameStatsAutre = new QFrame(frameStats);
        frameStatsAutre.setObjectName("frameStatsAutre");
        QSizePolicy sizePolicy24 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy24.setHorizontalStretch((byte)0);
        sizePolicy24.setVerticalStretch((byte)0);
        sizePolicy24.setHeightForWidth(frameStatsAutre.sizePolicy().hasHeightForWidth());
        frameStatsAutre.setSizePolicy(sizePolicy24);
        frameStatsAutre.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        frameStatsAutre.setFrameShadow(com.trolltech.qt.gui.QFrame.Shadow.Raised);
        verticalLayout_3 = new QVBoxLayout(frameStatsAutre);
        verticalLayout_3.setSpacing(0);
        verticalLayout_3.setMargin(0);
        verticalLayout_3.setObjectName("verticalLayout_3");
        frameStatsAutreIcones = new QFrame(frameStatsAutre);
        frameStatsAutreIcones.setObjectName("frameStatsAutreIcones");
        QSizePolicy sizePolicy25 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy25.setHorizontalStretch((byte)0);
        sizePolicy25.setVerticalStretch((byte)0);
        sizePolicy25.setHeightForWidth(frameStatsAutreIcones.sizePolicy().hasHeightForWidth());
        frameStatsAutreIcones.setSizePolicy(sizePolicy25);
        frameStatsAutreIcones.setStyleSheet("QFrame {\n"+
"	border: 1px solid #47af64;\n"+
"	background-color: #8fc794;\n"+
"}");
        frameStatsAutreIcones.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        gridLayout_5 = new QGridLayout(frameStatsAutreIcones);
        gridLayout_5.setSpacing(1);
        gridLayout_5.setMargin(1);
        gridLayout_5.setObjectName("gridLayout_5");
        lblStatsPDom = new QLabel(frameStatsAutreIcones);
        lblStatsPDom.setObjectName("lblStatsPDom");
        QSizePolicy sizePolicy26 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy26.setHorizontalStretch((byte)0);
        sizePolicy26.setVerticalStretch((byte)0);
        sizePolicy26.setHeightForWidth(lblStatsPDom.sizePolicy().hasHeightForWidth());
        lblStatsPDom.setSizePolicy(sizePolicy26);
        lblStatsPDom.setMinimumSize(new QSize(20, 25));
        lblStatsPDom.setMaximumSize(new QSize(20, 16777215));
        lblStatsPDom.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsPDom.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/pdommages.png")));
        lblStatsPDom.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_5.addWidget(lblStatsPDom, 0, 1, 1, 1);

        lblStatsInvoc = new QLabel(frameStatsAutreIcones);
        lblStatsInvoc.setObjectName("lblStatsInvoc");
        QSizePolicy sizePolicy27 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy27.setHorizontalStretch((byte)0);
        sizePolicy27.setVerticalStretch((byte)0);
        sizePolicy27.setHeightForWidth(lblStatsInvoc.sizePolicy().hasHeightForWidth());
        lblStatsInvoc.setSizePolicy(sizePolicy27);
        lblStatsInvoc.setMinimumSize(new QSize(20, 25));
        lblStatsInvoc.setMaximumSize(new QSize(20, 16777215));
        lblStatsInvoc.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsInvoc.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/invoc.png")));
        lblStatsInvoc.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_5.addWidget(lblStatsInvoc, 0, 4, 1, 1);

        lblStatsCC = new QLabel(frameStatsAutreIcones);
        lblStatsCC.setObjectName("lblStatsCC");
        QSizePolicy sizePolicy28 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy28.setHorizontalStretch((byte)0);
        sizePolicy28.setVerticalStretch((byte)0);
        sizePolicy28.setHeightForWidth(lblStatsCC.sizePolicy().hasHeightForWidth());
        lblStatsCC.setSizePolicy(sizePolicy28);
        lblStatsCC.setMinimumSize(new QSize(20, 25));
        lblStatsCC.setMaximumSize(new QSize(20, 16777215));
        lblStatsCC.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsCC.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/critique.png")));
        lblStatsCC.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_5.addWidget(lblStatsCC, 0, 2, 1, 1);

        lblStatsSoin = new QLabel(frameStatsAutreIcones);
        lblStatsSoin.setObjectName("lblStatsSoin");
        QSizePolicy sizePolicy29 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy29.setHorizontalStretch((byte)0);
        sizePolicy29.setVerticalStretch((byte)0);
        sizePolicy29.setHeightForWidth(lblStatsSoin.sizePolicy().hasHeightForWidth());
        lblStatsSoin.setSizePolicy(sizePolicy29);
        lblStatsSoin.setMinimumSize(new QSize(20, 25));
        lblStatsSoin.setMaximumSize(new QSize(20, 16777215));
        lblStatsSoin.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsSoin.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/soins.png")));
        lblStatsSoin.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_5.addWidget(lblStatsSoin, 0, 3, 1, 1);

        lblStatsDomPiege = new QLabel(frameStatsAutreIcones);
        lblStatsDomPiege.setObjectName("lblStatsDomPiege");
        QSizePolicy sizePolicy30 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy30.setHorizontalStretch((byte)0);
        sizePolicy30.setVerticalStretch((byte)0);
        sizePolicy30.setHeightForWidth(lblStatsDomPiege.sizePolicy().hasHeightForWidth());
        lblStatsDomPiege.setSizePolicy(sizePolicy30);
        lblStatsDomPiege.setMinimumSize(new QSize(20, 25));
        lblStatsDomPiege.setMaximumSize(new QSize(20, 16777215));
        lblStatsDomPiege.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsDomPiege.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/piege.png")));
        lblStatsDomPiege.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_5.addWidget(lblStatsDomPiege, 0, 5, 1, 1);

        lblStatsPDomPiege = new QLabel(frameStatsAutreIcones);
        lblStatsPDomPiege.setObjectName("lblStatsPDomPiege");
        QSizePolicy sizePolicy31 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy31.setHorizontalStretch((byte)0);
        sizePolicy31.setVerticalStretch((byte)0);
        sizePolicy31.setHeightForWidth(lblStatsPDomPiege.sizePolicy().hasHeightForWidth());
        lblStatsPDomPiege.setSizePolicy(sizePolicy31);
        lblStatsPDomPiege.setMinimumSize(new QSize(20, 25));
        lblStatsPDomPiege.setMaximumSize(new QSize(20, 16777215));
        lblStatsPDomPiege.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsPDomPiege.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/ppiege.png")));
        lblStatsPDomPiege.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_5.addWidget(lblStatsPDomPiege, 0, 6, 1, 1);

        lblStatsEC = new QLabel(frameStatsAutreIcones);
        lblStatsEC.setObjectName("lblStatsEC");
        QSizePolicy sizePolicy32 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy32.setHorizontalStretch((byte)0);
        sizePolicy32.setVerticalStretch((byte)0);
        sizePolicy32.setHeightForWidth(lblStatsEC.sizePolicy().hasHeightForWidth());
        lblStatsEC.setSizePolicy(sizePolicy32);
        lblStatsEC.setMinimumSize(new QSize(20, 25));
        lblStatsEC.setMaximumSize(new QSize(20, 16777215));
        lblStatsEC.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsEC.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/echecs_critiques.png")));
        lblStatsEC.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_5.addWidget(lblStatsEC, 0, 7, 1, 1);

        lblStatsRenvois = new QLabel(frameStatsAutreIcones);
        lblStatsRenvois.setObjectName("lblStatsRenvois");
        QSizePolicy sizePolicy33 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy33.setHorizontalStretch((byte)0);
        sizePolicy33.setVerticalStretch((byte)0);
        sizePolicy33.setHeightForWidth(lblStatsRenvois.sizePolicy().hasHeightForWidth());
        lblStatsRenvois.setSizePolicy(sizePolicy33);
        lblStatsRenvois.setMinimumSize(new QSize(20, 25));
        lblStatsRenvois.setMaximumSize(new QSize(20, 16777215));
        lblStatsRenvois.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsRenvois.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/renvois.png")));
        lblStatsRenvois.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_5.addWidget(lblStatsRenvois, 0, 8, 1, 1);

        lblStatsDom = new QLabel(frameStatsAutreIcones);
        lblStatsDom.setObjectName("lblStatsDom");
        QSizePolicy sizePolicy34 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy34.setHorizontalStretch((byte)0);
        sizePolicy34.setVerticalStretch((byte)0);
        sizePolicy34.setHeightForWidth(lblStatsDom.sizePolicy().hasHeightForWidth());
        lblStatsDom.setSizePolicy(sizePolicy34);
        lblStatsDom.setMinimumSize(new QSize(20, 25));
        lblStatsDom.setMaximumSize(new QSize(20, 16777215));
        lblStatsDom.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsDom.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/dommages.png")));
        lblStatsDom.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_5.addWidget(lblStatsDom, 0, 0, 1, 1);


        verticalLayout_3.addWidget(frameStatsAutreIcones);

        frameStatsAutreTxt = new QFrame(frameStatsAutre);
        frameStatsAutreTxt.setObjectName("frameStatsAutreTxt");
        QSizePolicy sizePolicy35 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy35.setHorizontalStretch((byte)0);
        sizePolicy35.setVerticalStretch((byte)0);
        sizePolicy35.setHeightForWidth(frameStatsAutreTxt.sizePolicy().hasHeightForWidth());
        frameStatsAutreTxt.setSizePolicy(sizePolicy35);
        frameStatsAutreTxt.setStyleSheet("QFrame {\n"+
"	border: 1px solid #47af64;\n"+
"	background-color: #8fc794;\n"+
"}");
        frameStatsAutreTxt.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        gridLayout_7 = new QGridLayout(frameStatsAutreTxt);
        gridLayout_7.setSpacing(1);
        gridLayout_7.setMargin(1);
        gridLayout_7.setObjectName("gridLayout_7");
        txtStatsDomPiege = new QLineEdit(frameStatsAutreTxt);
        txtStatsDomPiege.setObjectName("txtStatsDomPiege");
        QSizePolicy sizePolicy36 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy36.setHorizontalStretch((byte)0);
        sizePolicy36.setVerticalStretch((byte)0);
        sizePolicy36.setHeightForWidth(txtStatsDomPiege.sizePolicy().hasHeightForWidth());
        txtStatsDomPiege.setSizePolicy(sizePolicy36);
        txtStatsDomPiege.setMinimumSize(new QSize(20, 0));
        txtStatsDomPiege.setMaximumSize(new QSize(20, 16777215));
        QFont font7 = new QFont();
        font7.setPointSize(7);
        txtStatsDomPiege.setFont(font7);
        txtStatsDomPiege.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        txtStatsDomPiege.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_7.addWidget(txtStatsDomPiege, 0, 5, 1, 1);

        txtStatsPDomPiege = new QLineEdit(frameStatsAutreTxt);
        txtStatsPDomPiege.setObjectName("txtStatsPDomPiege");
        QSizePolicy sizePolicy37 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy37.setHorizontalStretch((byte)0);
        sizePolicy37.setVerticalStretch((byte)0);
        sizePolicy37.setHeightForWidth(txtStatsPDomPiege.sizePolicy().hasHeightForWidth());
        txtStatsPDomPiege.setSizePolicy(sizePolicy37);
        txtStatsPDomPiege.setMinimumSize(new QSize(20, 0));
        txtStatsPDomPiege.setMaximumSize(new QSize(20, 16777215));
        QFont font8 = new QFont();
        font8.setPointSize(7);
        txtStatsPDomPiege.setFont(font8);
        txtStatsPDomPiege.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        txtStatsPDomPiege.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_7.addWidget(txtStatsPDomPiege, 0, 6, 1, 1);

        txtStatsPDom = new QLineEdit(frameStatsAutreTxt);
        txtStatsPDom.setObjectName("txtStatsPDom");
        QSizePolicy sizePolicy38 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy38.setHorizontalStretch((byte)0);
        sizePolicy38.setVerticalStretch((byte)0);
        sizePolicy38.setHeightForWidth(txtStatsPDom.sizePolicy().hasHeightForWidth());
        txtStatsPDom.setSizePolicy(sizePolicy38);
        txtStatsPDom.setMinimumSize(new QSize(20, 0));
        txtStatsPDom.setMaximumSize(new QSize(20, 16777215));
        QFont font9 = new QFont();
        font9.setPointSize(7);
        txtStatsPDom.setFont(font9);
        txtStatsPDom.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        txtStatsPDom.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_7.addWidget(txtStatsPDom, 0, 1, 1, 1);

        txtStatsSoin = new QLineEdit(frameStatsAutreTxt);
        txtStatsSoin.setObjectName("txtStatsSoin");
        QSizePolicy sizePolicy39 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy39.setHorizontalStretch((byte)0);
        sizePolicy39.setVerticalStretch((byte)0);
        sizePolicy39.setHeightForWidth(txtStatsSoin.sizePolicy().hasHeightForWidth());
        txtStatsSoin.setSizePolicy(sizePolicy39);
        txtStatsSoin.setMinimumSize(new QSize(20, 0));
        txtStatsSoin.setMaximumSize(new QSize(20, 16777215));
        QFont font10 = new QFont();
        font10.setPointSize(7);
        txtStatsSoin.setFont(font10);
        txtStatsSoin.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        txtStatsSoin.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_7.addWidget(txtStatsSoin, 0, 3, 1, 1);

        txtStatsCC = new QLineEdit(frameStatsAutreTxt);
        txtStatsCC.setObjectName("txtStatsCC");
        QSizePolicy sizePolicy40 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy40.setHorizontalStretch((byte)0);
        sizePolicy40.setVerticalStretch((byte)0);
        sizePolicy40.setHeightForWidth(txtStatsCC.sizePolicy().hasHeightForWidth());
        txtStatsCC.setSizePolicy(sizePolicy40);
        txtStatsCC.setMinimumSize(new QSize(20, 0));
        txtStatsCC.setMaximumSize(new QSize(20, 16777215));
        QFont font11 = new QFont();
        font11.setPointSize(7);
        txtStatsCC.setFont(font11);
        txtStatsCC.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        txtStatsCC.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_7.addWidget(txtStatsCC, 0, 2, 1, 1);

        txtStatsEC = new QLineEdit(frameStatsAutreTxt);
        txtStatsEC.setObjectName("txtStatsEC");
        QSizePolicy sizePolicy41 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy41.setHorizontalStretch((byte)0);
        sizePolicy41.setVerticalStretch((byte)0);
        sizePolicy41.setHeightForWidth(txtStatsEC.sizePolicy().hasHeightForWidth());
        txtStatsEC.setSizePolicy(sizePolicy41);
        txtStatsEC.setMinimumSize(new QSize(20, 0));
        txtStatsEC.setMaximumSize(new QSize(20, 16777215));
        QFont font12 = new QFont();
        font12.setPointSize(7);
        txtStatsEC.setFont(font12);
        txtStatsEC.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        txtStatsEC.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_7.addWidget(txtStatsEC, 0, 7, 1, 1);

        txtStatsRenvois = new QLineEdit(frameStatsAutreTxt);
        txtStatsRenvois.setObjectName("txtStatsRenvois");
        QSizePolicy sizePolicy42 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy42.setHorizontalStretch((byte)0);
        sizePolicy42.setVerticalStretch((byte)0);
        sizePolicy42.setHeightForWidth(txtStatsRenvois.sizePolicy().hasHeightForWidth());
        txtStatsRenvois.setSizePolicy(sizePolicy42);
        txtStatsRenvois.setMinimumSize(new QSize(20, 0));
        txtStatsRenvois.setMaximumSize(new QSize(20, 16777215));
        QFont font13 = new QFont();
        font13.setPointSize(7);
        txtStatsRenvois.setFont(font13);
        txtStatsRenvois.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        txtStatsRenvois.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_7.addWidget(txtStatsRenvois, 0, 8, 1, 1);

        txtStatsDom = new QLineEdit(frameStatsAutreTxt);
        txtStatsDom.setObjectName("txtStatsDom");
        QSizePolicy sizePolicy43 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy43.setHorizontalStretch((byte)0);
        sizePolicy43.setVerticalStretch((byte)0);
        sizePolicy43.setHeightForWidth(txtStatsDom.sizePolicy().hasHeightForWidth());
        txtStatsDom.setSizePolicy(sizePolicy43);
        txtStatsDom.setMinimumSize(new QSize(20, 0));
        txtStatsDom.setMaximumSize(new QSize(20, 16777215));
        QFont font14 = new QFont();
        font14.setPointSize(7);
        txtStatsDom.setFont(font14);
        txtStatsDom.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        txtStatsDom.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_7.addWidget(txtStatsDom, 0, 0, 1, 1);

        txtStatsInvoc = new QLineEdit(frameStatsAutreTxt);
        txtStatsInvoc.setObjectName("txtStatsInvoc");
        QSizePolicy sizePolicy44 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy44.setHorizontalStretch((byte)0);
        sizePolicy44.setVerticalStretch((byte)0);
        sizePolicy44.setHeightForWidth(txtStatsInvoc.sizePolicy().hasHeightForWidth());
        txtStatsInvoc.setSizePolicy(sizePolicy44);
        txtStatsInvoc.setMinimumSize(new QSize(20, 0));
        txtStatsInvoc.setMaximumSize(new QSize(20, 16777215));
        QFont font15 = new QFont();
        font15.setPointSize(7);
        txtStatsInvoc.setFont(font15);
        txtStatsInvoc.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        txtStatsInvoc.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_7.addWidget(txtStatsInvoc, 0, 4, 1, 1);


        verticalLayout_3.addWidget(frameStatsAutreTxt);


        gridLayout_13.addWidget(frameStatsAutre, 1, 0, 1, 2);

        frameStatsRes = new QFrame(frameStats);
        frameStatsRes.setObjectName("frameStatsRes");
        QSizePolicy sizePolicy45 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy45.setHorizontalStretch((byte)0);
        sizePolicy45.setVerticalStretch((byte)0);
        sizePolicy45.setHeightForWidth(frameStatsRes.sizePolicy().hasHeightForWidth());
        frameStatsRes.setSizePolicy(sizePolicy45);
        frameStatsRes.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        frameStatsRes.setFrameShadow(com.trolltech.qt.gui.QFrame.Shadow.Raised);
        verticalLayout_4 = new QVBoxLayout(frameStatsRes);
        verticalLayout_4.setSpacing(0);
        verticalLayout_4.setMargin(0);
        verticalLayout_4.setObjectName("verticalLayout_4");
        frameStatsResIcones = new QFrame(frameStatsRes);
        frameStatsResIcones.setObjectName("frameStatsResIcones");
        QSizePolicy sizePolicy46 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy46.setHorizontalStretch((byte)0);
        sizePolicy46.setVerticalStretch((byte)0);
        sizePolicy46.setHeightForWidth(frameStatsResIcones.sizePolicy().hasHeightForWidth());
        frameStatsResIcones.setSizePolicy(sizePolicy46);
        frameStatsResIcones.setStyleSheet("QFrame {\n"+
"	border: 1px solid #ab46a0;\n"+
"	background-color: #c38cbc;\n"+
"}");
        frameStatsResIcones.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        gridLayout_9 = new QGridLayout(frameStatsResIcones);
        gridLayout_9.setSpacing(1);
        gridLayout_9.setMargin(1);
        gridLayout_9.setObjectName("gridLayout_9");
        gridLayout_9.setSizeConstraint(com.trolltech.qt.gui.QLayout.SizeConstraint.SetDefaultConstraint);
        lblStatsResMagique = new QLabel(frameStatsResIcones);
        lblStatsResMagique.setObjectName("lblStatsResMagique");
        QSizePolicy sizePolicy47 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy47.setHorizontalStretch((byte)0);
        sizePolicy47.setVerticalStretch((byte)0);
        sizePolicy47.setHeightForWidth(lblStatsResMagique.sizePolicy().hasHeightForWidth());
        lblStatsResMagique.setSizePolicy(sizePolicy47);
        lblStatsResMagique.setMinimumSize(new QSize(20, 25));
        lblStatsResMagique.setMaximumSize(new QSize(20, 16777215));
        lblStatsResMagique.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsResMagique.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/resMagique.png")));
        lblStatsResMagique.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsResMagique, 0, 0, 1, 1);

        lblStatsResPhysique = new QLabel(frameStatsResIcones);
        lblStatsResPhysique.setObjectName("lblStatsResPhysique");
        QSizePolicy sizePolicy48 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy48.setHorizontalStretch((byte)0);
        sizePolicy48.setVerticalStretch((byte)0);
        sizePolicy48.setHeightForWidth(lblStatsResPhysique.sizePolicy().hasHeightForWidth());
        lblStatsResPhysique.setSizePolicy(sizePolicy48);
        lblStatsResPhysique.setMinimumSize(new QSize(20, 25));
        lblStatsResPhysique.setMaximumSize(new QSize(20, 16777215));
        lblStatsResPhysique.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsResPhysique.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/resPhysique.png")));
        lblStatsResPhysique.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsResPhysique, 0, 1, 1, 1);

        lblStatsResNeutre = new QLabel(frameStatsResIcones);
        lblStatsResNeutre.setObjectName("lblStatsResNeutre");
        QSizePolicy sizePolicy49 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy49.setHorizontalStretch((byte)0);
        sizePolicy49.setVerticalStretch((byte)0);
        sizePolicy49.setHeightForWidth(lblStatsResNeutre.sizePolicy().hasHeightForWidth());
        lblStatsResNeutre.setSizePolicy(sizePolicy49);
        lblStatsResNeutre.setMinimumSize(new QSize(20, 25));
        lblStatsResNeutre.setMaximumSize(new QSize(20, 16777215));
        lblStatsResNeutre.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsResNeutre.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/resNeutre.png")));
        lblStatsResNeutre.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsResNeutre, 0, 2, 1, 1);

        lblStatsPResNeutre = new QLabel(frameStatsResIcones);
        lblStatsPResNeutre.setObjectName("lblStatsPResNeutre");
        QSizePolicy sizePolicy50 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy50.setHorizontalStretch((byte)0);
        sizePolicy50.setVerticalStretch((byte)0);
        sizePolicy50.setHeightForWidth(lblStatsPResNeutre.sizePolicy().hasHeightForWidth());
        lblStatsPResNeutre.setSizePolicy(sizePolicy50);
        lblStatsPResNeutre.setMinimumSize(new QSize(20, 25));
        lblStatsPResNeutre.setMaximumSize(new QSize(20, 16777215));
        lblStatsPResNeutre.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsPResNeutre.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/PResNeutre.png")));
        lblStatsPResNeutre.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsPResNeutre, 0, 3, 1, 1);

        lblStatsResTerre = new QLabel(frameStatsResIcones);
        lblStatsResTerre.setObjectName("lblStatsResTerre");
        QSizePolicy sizePolicy51 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy51.setHorizontalStretch((byte)0);
        sizePolicy51.setVerticalStretch((byte)0);
        sizePolicy51.setHeightForWidth(lblStatsResTerre.sizePolicy().hasHeightForWidth());
        lblStatsResTerre.setSizePolicy(sizePolicy51);
        lblStatsResTerre.setMinimumSize(new QSize(20, 25));
        lblStatsResTerre.setMaximumSize(new QSize(20, 16777215));
        lblStatsResTerre.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsResTerre.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/resTerre.png")));
        lblStatsResTerre.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsResTerre, 0, 4, 1, 1);

        lblStatsPResTerre = new QLabel(frameStatsResIcones);
        lblStatsPResTerre.setObjectName("lblStatsPResTerre");
        QSizePolicy sizePolicy52 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy52.setHorizontalStretch((byte)0);
        sizePolicy52.setVerticalStretch((byte)0);
        sizePolicy52.setHeightForWidth(lblStatsPResTerre.sizePolicy().hasHeightForWidth());
        lblStatsPResTerre.setSizePolicy(sizePolicy52);
        lblStatsPResTerre.setMinimumSize(new QSize(20, 25));
        lblStatsPResTerre.setMaximumSize(new QSize(20, 16777215));
        lblStatsPResTerre.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsPResTerre.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/PResTerre.png")));
        lblStatsPResTerre.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsPResTerre, 0, 5, 1, 1);

        lblStatsResFeu = new QLabel(frameStatsResIcones);
        lblStatsResFeu.setObjectName("lblStatsResFeu");
        QSizePolicy sizePolicy53 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy53.setHorizontalStretch((byte)0);
        sizePolicy53.setVerticalStretch((byte)0);
        sizePolicy53.setHeightForWidth(lblStatsResFeu.sizePolicy().hasHeightForWidth());
        lblStatsResFeu.setSizePolicy(sizePolicy53);
        lblStatsResFeu.setMinimumSize(new QSize(20, 25));
        lblStatsResFeu.setMaximumSize(new QSize(20, 16777215));
        lblStatsResFeu.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsResFeu.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/resFeu.png")));
        lblStatsResFeu.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsResFeu, 0, 6, 1, 1);

        lblStatsPResFeu = new QLabel(frameStatsResIcones);
        lblStatsPResFeu.setObjectName("lblStatsPResFeu");
        QSizePolicy sizePolicy54 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy54.setHorizontalStretch((byte)0);
        sizePolicy54.setVerticalStretch((byte)0);
        sizePolicy54.setHeightForWidth(lblStatsPResFeu.sizePolicy().hasHeightForWidth());
        lblStatsPResFeu.setSizePolicy(sizePolicy54);
        lblStatsPResFeu.setMinimumSize(new QSize(20, 25));
        lblStatsPResFeu.setMaximumSize(new QSize(20, 16777215));
        lblStatsPResFeu.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsPResFeu.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/PResFeu.png")));
        lblStatsPResFeu.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsPResFeu, 0, 7, 1, 1);

        lblStatsResEau = new QLabel(frameStatsResIcones);
        lblStatsResEau.setObjectName("lblStatsResEau");
        QSizePolicy sizePolicy55 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy55.setHorizontalStretch((byte)0);
        sizePolicy55.setVerticalStretch((byte)0);
        sizePolicy55.setHeightForWidth(lblStatsResEau.sizePolicy().hasHeightForWidth());
        lblStatsResEau.setSizePolicy(sizePolicy55);
        lblStatsResEau.setMinimumSize(new QSize(20, 25));
        lblStatsResEau.setMaximumSize(new QSize(20, 16777215));
        lblStatsResEau.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsResEau.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/resEau.png")));
        lblStatsResEau.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsResEau, 0, 8, 1, 1);

        lblStatsPResEau = new QLabel(frameStatsResIcones);
        lblStatsPResEau.setObjectName("lblStatsPResEau");
        QSizePolicy sizePolicy56 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy56.setHorizontalStretch((byte)0);
        sizePolicy56.setVerticalStretch((byte)0);
        sizePolicy56.setHeightForWidth(lblStatsPResEau.sizePolicy().hasHeightForWidth());
        lblStatsPResEau.setSizePolicy(sizePolicy56);
        lblStatsPResEau.setMinimumSize(new QSize(20, 25));
        lblStatsPResEau.setMaximumSize(new QSize(20, 16777215));
        lblStatsPResEau.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsPResEau.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/PResEau.png")));
        lblStatsPResEau.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsPResEau, 0, 9, 1, 1);

        lblStatsResAir = new QLabel(frameStatsResIcones);
        lblStatsResAir.setObjectName("lblStatsResAir");
        QSizePolicy sizePolicy57 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy57.setHorizontalStretch((byte)0);
        sizePolicy57.setVerticalStretch((byte)0);
        sizePolicy57.setHeightForWidth(lblStatsResAir.sizePolicy().hasHeightForWidth());
        lblStatsResAir.setSizePolicy(sizePolicy57);
        lblStatsResAir.setMinimumSize(new QSize(20, 25));
        lblStatsResAir.setMaximumSize(new QSize(20, 16777215));
        lblStatsResAir.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsResAir.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/resAir.png")));
        lblStatsResAir.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsResAir, 0, 10, 1, 1);

        lblStatsPResAir = new QLabel(frameStatsResIcones);
        lblStatsPResAir.setObjectName("lblStatsPResAir");
        QSizePolicy sizePolicy58 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy58.setHorizontalStretch((byte)0);
        sizePolicy58.setVerticalStretch((byte)0);
        sizePolicy58.setHeightForWidth(lblStatsPResAir.sizePolicy().hasHeightForWidth());
        lblStatsPResAir.setSizePolicy(sizePolicy58);
        lblStatsPResAir.setMinimumSize(new QSize(20, 25));
        lblStatsPResAir.setMaximumSize(new QSize(20, 16777215));
        lblStatsPResAir.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsPResAir.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/PResAir.png")));
        lblStatsPResAir.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsPResAir, 0, 11, 1, 1);


        verticalLayout_4.addWidget(frameStatsResIcones);

        frameStatsResTxt = new QFrame(frameStatsRes);
        frameStatsResTxt.setObjectName("frameStatsResTxt");
        QSizePolicy sizePolicy59 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy59.setHorizontalStretch((byte)0);
        sizePolicy59.setVerticalStretch((byte)0);
        sizePolicy59.setHeightForWidth(frameStatsResTxt.sizePolicy().hasHeightForWidth());
        frameStatsResTxt.setSizePolicy(sizePolicy59);
        frameStatsResTxt.setStyleSheet("QFrame {\n"+
"	border: 1px solid #ab46a0;\n"+
"	background-color: #c38cbc;\n"+
"}");
        frameStatsResTxt.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        gridLayout_10 = new QGridLayout(frameStatsResTxt);
        gridLayout_10.setSpacing(1);
        gridLayout_10.setMargin(1);
        gridLayout_10.setObjectName("gridLayout_10");
        gridLayout_10.setSizeConstraint(com.trolltech.qt.gui.QLayout.SizeConstraint.SetDefaultConstraint);
        txtStatsResMagique = new QLineEdit(frameStatsResTxt);
        txtStatsResMagique.setObjectName("txtStatsResMagique");
        QSizePolicy sizePolicy60 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy60.setHorizontalStretch((byte)0);
        sizePolicy60.setVerticalStretch((byte)0);
        sizePolicy60.setHeightForWidth(txtStatsResMagique.sizePolicy().hasHeightForWidth());
        txtStatsResMagique.setSizePolicy(sizePolicy60);
        txtStatsResMagique.setMinimumSize(new QSize(20, 0));
        txtStatsResMagique.setMaximumSize(new QSize(20, 16777215));
        QFont font16 = new QFont();
        font16.setPointSize(7);
        txtStatsResMagique.setFont(font16);
        txtStatsResMagique.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        txtStatsResMagique.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_10.addWidget(txtStatsResMagique, 0, 0, 1, 1);

        txtStatsResPhysique = new QLineEdit(frameStatsResTxt);
        txtStatsResPhysique.setObjectName("txtStatsResPhysique");
        QSizePolicy sizePolicy61 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy61.setHorizontalStretch((byte)0);
        sizePolicy61.setVerticalStretch((byte)0);
        sizePolicy61.setHeightForWidth(txtStatsResPhysique.sizePolicy().hasHeightForWidth());
        txtStatsResPhysique.setSizePolicy(sizePolicy61);
        txtStatsResPhysique.setMinimumSize(new QSize(20, 0));
        txtStatsResPhysique.setMaximumSize(new QSize(20, 16777215));
        QFont font17 = new QFont();
        font17.setPointSize(7);
        txtStatsResPhysique.setFont(font17);
        txtStatsResPhysique.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        txtStatsResPhysique.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_10.addWidget(txtStatsResPhysique, 0, 1, 1, 1);

        txtStatsResNeutre = new QLineEdit(frameStatsResTxt);
        txtStatsResNeutre.setObjectName("txtStatsResNeutre");
        QSizePolicy sizePolicy62 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy62.setHorizontalStretch((byte)0);
        sizePolicy62.setVerticalStretch((byte)0);
        sizePolicy62.setHeightForWidth(txtStatsResNeutre.sizePolicy().hasHeightForWidth());
        txtStatsResNeutre.setSizePolicy(sizePolicy62);
        txtStatsResNeutre.setMinimumSize(new QSize(20, 0));
        txtStatsResNeutre.setMaximumSize(new QSize(20, 16777215));
        QFont font18 = new QFont();
        font18.setPointSize(7);
        txtStatsResNeutre.setFont(font18);
        txtStatsResNeutre.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        txtStatsResNeutre.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_10.addWidget(txtStatsResNeutre, 0, 2, 1, 1);

        txtStatsPResNeutre = new QLineEdit(frameStatsResTxt);
        txtStatsPResNeutre.setObjectName("txtStatsPResNeutre");
        QSizePolicy sizePolicy63 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy63.setHorizontalStretch((byte)0);
        sizePolicy63.setVerticalStretch((byte)0);
        sizePolicy63.setHeightForWidth(txtStatsPResNeutre.sizePolicy().hasHeightForWidth());
        txtStatsPResNeutre.setSizePolicy(sizePolicy63);
        txtStatsPResNeutre.setMinimumSize(new QSize(20, 0));
        txtStatsPResNeutre.setMaximumSize(new QSize(20, 16777215));
        QFont font19 = new QFont();
        font19.setPointSize(7);
        txtStatsPResNeutre.setFont(font19);
        txtStatsPResNeutre.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        txtStatsPResNeutre.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_10.addWidget(txtStatsPResNeutre, 0, 3, 1, 1);

        txtStatsResTerre = new QLineEdit(frameStatsResTxt);
        txtStatsResTerre.setObjectName("txtStatsResTerre");
        QSizePolicy sizePolicy64 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy64.setHorizontalStretch((byte)0);
        sizePolicy64.setVerticalStretch((byte)0);
        sizePolicy64.setHeightForWidth(txtStatsResTerre.sizePolicy().hasHeightForWidth());
        txtStatsResTerre.setSizePolicy(sizePolicy64);
        txtStatsResTerre.setMinimumSize(new QSize(20, 0));
        txtStatsResTerre.setMaximumSize(new QSize(20, 16777215));
        QFont font20 = new QFont();
        font20.setPointSize(7);
        txtStatsResTerre.setFont(font20);
        txtStatsResTerre.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        txtStatsResTerre.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_10.addWidget(txtStatsResTerre, 0, 4, 1, 1);

        txtStatsPResTerre = new QLineEdit(frameStatsResTxt);
        txtStatsPResTerre.setObjectName("txtStatsPResTerre");
        QSizePolicy sizePolicy65 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy65.setHorizontalStretch((byte)0);
        sizePolicy65.setVerticalStretch((byte)0);
        sizePolicy65.setHeightForWidth(txtStatsPResTerre.sizePolicy().hasHeightForWidth());
        txtStatsPResTerre.setSizePolicy(sizePolicy65);
        txtStatsPResTerre.setMinimumSize(new QSize(20, 0));
        txtStatsPResTerre.setMaximumSize(new QSize(20, 16777215));
        QFont font21 = new QFont();
        font21.setPointSize(7);
        txtStatsPResTerre.setFont(font21);
        txtStatsPResTerre.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        txtStatsPResTerre.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_10.addWidget(txtStatsPResTerre, 0, 5, 1, 1);

        txtStatsResFeu = new QLineEdit(frameStatsResTxt);
        txtStatsResFeu.setObjectName("txtStatsResFeu");
        QSizePolicy sizePolicy66 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy66.setHorizontalStretch((byte)0);
        sizePolicy66.setVerticalStretch((byte)0);
        sizePolicy66.setHeightForWidth(txtStatsResFeu.sizePolicy().hasHeightForWidth());
        txtStatsResFeu.setSizePolicy(sizePolicy66);
        txtStatsResFeu.setMinimumSize(new QSize(20, 0));
        txtStatsResFeu.setMaximumSize(new QSize(20, 16777215));
        QFont font22 = new QFont();
        font22.setPointSize(7);
        txtStatsResFeu.setFont(font22);
        txtStatsResFeu.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        txtStatsResFeu.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_10.addWidget(txtStatsResFeu, 0, 6, 1, 1);

        txtStatsPResFeu = new QLineEdit(frameStatsResTxt);
        txtStatsPResFeu.setObjectName("txtStatsPResFeu");
        QSizePolicy sizePolicy67 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy67.setHorizontalStretch((byte)0);
        sizePolicy67.setVerticalStretch((byte)0);
        sizePolicy67.setHeightForWidth(txtStatsPResFeu.sizePolicy().hasHeightForWidth());
        txtStatsPResFeu.setSizePolicy(sizePolicy67);
        txtStatsPResFeu.setMinimumSize(new QSize(20, 0));
        txtStatsPResFeu.setMaximumSize(new QSize(20, 16777215));
        QFont font23 = new QFont();
        font23.setPointSize(7);
        txtStatsPResFeu.setFont(font23);
        txtStatsPResFeu.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        txtStatsPResFeu.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_10.addWidget(txtStatsPResFeu, 0, 7, 1, 1);

        txtStatsResEau = new QLineEdit(frameStatsResTxt);
        txtStatsResEau.setObjectName("txtStatsResEau");
        QSizePolicy sizePolicy68 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy68.setHorizontalStretch((byte)0);
        sizePolicy68.setVerticalStretch((byte)0);
        sizePolicy68.setHeightForWidth(txtStatsResEau.sizePolicy().hasHeightForWidth());
        txtStatsResEau.setSizePolicy(sizePolicy68);
        txtStatsResEau.setMinimumSize(new QSize(20, 0));
        txtStatsResEau.setMaximumSize(new QSize(20, 16777215));
        QFont font24 = new QFont();
        font24.setPointSize(7);
        txtStatsResEau.setFont(font24);
        txtStatsResEau.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        txtStatsResEau.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_10.addWidget(txtStatsResEau, 0, 8, 1, 1);

        txtStatsPResEau = new QLineEdit(frameStatsResTxt);
        txtStatsPResEau.setObjectName("txtStatsPResEau");
        QSizePolicy sizePolicy69 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy69.setHorizontalStretch((byte)0);
        sizePolicy69.setVerticalStretch((byte)0);
        sizePolicy69.setHeightForWidth(txtStatsPResEau.sizePolicy().hasHeightForWidth());
        txtStatsPResEau.setSizePolicy(sizePolicy69);
        txtStatsPResEau.setMinimumSize(new QSize(20, 0));
        txtStatsPResEau.setMaximumSize(new QSize(20, 16777215));
        QFont font25 = new QFont();
        font25.setPointSize(7);
        txtStatsPResEau.setFont(font25);
        txtStatsPResEau.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        txtStatsPResEau.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_10.addWidget(txtStatsPResEau, 0, 9, 1, 1);

        txtStatsResAir = new QLineEdit(frameStatsResTxt);
        txtStatsResAir.setObjectName("txtStatsResAir");
        QSizePolicy sizePolicy70 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy70.setHorizontalStretch((byte)0);
        sizePolicy70.setVerticalStretch((byte)0);
        sizePolicy70.setHeightForWidth(txtStatsResAir.sizePolicy().hasHeightForWidth());
        txtStatsResAir.setSizePolicy(sizePolicy70);
        txtStatsResAir.setMinimumSize(new QSize(20, 0));
        txtStatsResAir.setMaximumSize(new QSize(20, 16777215));
        QFont font26 = new QFont();
        font26.setPointSize(7);
        txtStatsResAir.setFont(font26);
        txtStatsResAir.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        txtStatsResAir.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_10.addWidget(txtStatsResAir, 0, 10, 1, 1);

        txtStatsPResAir = new QLineEdit(frameStatsResTxt);
        txtStatsPResAir.setObjectName("txtStatsPResAir");
        QSizePolicy sizePolicy71 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy71.setHorizontalStretch((byte)0);
        sizePolicy71.setVerticalStretch((byte)0);
        sizePolicy71.setHeightForWidth(txtStatsPResAir.sizePolicy().hasHeightForWidth());
        txtStatsPResAir.setSizePolicy(sizePolicy71);
        txtStatsPResAir.setMinimumSize(new QSize(20, 0));
        txtStatsPResAir.setMaximumSize(new QSize(20, 16777215));
        QFont font27 = new QFont();
        font27.setPointSize(7);
        txtStatsPResAir.setFont(font27);
        txtStatsPResAir.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        txtStatsPResAir.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_10.addWidget(txtStatsPResAir, 0, 11, 1, 1);


        verticalLayout_4.addWidget(frameStatsResTxt);


        gridLayout_13.addWidget(frameStatsRes, 1, 2, 1, 1);

        frameStatsCaract = new QFrame(frameStats);
        frameStatsCaract.setObjectName("frameStatsCaract");
        QSizePolicy sizePolicy72 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy72.setHorizontalStretch((byte)0);
        sizePolicy72.setVerticalStretch((byte)0);
        sizePolicy72.setHeightForWidth(frameStatsCaract.sizePolicy().hasHeightForWidth());
        frameStatsCaract.setSizePolicy(sizePolicy72);
        frameStatsCaract.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        frameStatsCaract.setFrameShadow(com.trolltech.qt.gui.QFrame.Shadow.Raised);
        verticalLayout_2 = new QVBoxLayout(frameStatsCaract);
        verticalLayout_2.setSpacing(0);
        verticalLayout_2.setMargin(0);
        verticalLayout_2.setObjectName("verticalLayout_2");
        frameStatsCaractIcones = new QFrame(frameStatsCaract);
        frameStatsCaractIcones.setObjectName("frameStatsCaractIcones");
        QSizePolicy sizePolicy73 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy73.setHorizontalStretch((byte)0);
        sizePolicy73.setVerticalStretch((byte)0);
        sizePolicy73.setHeightForWidth(frameStatsCaractIcones.sizePolicy().hasHeightForWidth());
        frameStatsCaractIcones.setSizePolicy(sizePolicy73);
        frameStatsCaractIcones.setStyleSheet("QFrame {\n"+
"	border: 1px solid #f19142;\n"+
"	background-color: #f9c884;\n"+
"}");
        frameStatsCaractIcones.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        gridLayout_3 = new QGridLayout(frameStatsCaractIcones);
        gridLayout_3.setSpacing(1);
        gridLayout_3.setMargin(1);
        gridLayout_3.setObjectName("gridLayout_3");
        lblStatsSag = new QLabel(frameStatsCaractIcones);
        lblStatsSag.setObjectName("lblStatsSag");
        QSizePolicy sizePolicy74 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy74.setHorizontalStretch((byte)0);
        sizePolicy74.setVerticalStretch((byte)0);
        sizePolicy74.setHeightForWidth(lblStatsSag.sizePolicy().hasHeightForWidth());
        lblStatsSag.setSizePolicy(sizePolicy74);
        lblStatsSag.setMinimumSize(new QSize(25, 25));
        lblStatsSag.setMaximumSize(new QSize(25, 16777215));
        lblStatsSag.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsSag.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/sagesse.png")));
        lblStatsSag.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_3.addWidget(lblStatsSag, 0, 1, 1, 1);

        lblStatsChance = new QLabel(frameStatsCaractIcones);
        lblStatsChance.setObjectName("lblStatsChance");
        QSizePolicy sizePolicy75 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy75.setHorizontalStretch((byte)0);
        sizePolicy75.setVerticalStretch((byte)0);
        sizePolicy75.setHeightForWidth(lblStatsChance.sizePolicy().hasHeightForWidth());
        lblStatsChance.setSizePolicy(sizePolicy75);
        lblStatsChance.setMinimumSize(new QSize(25, 25));
        lblStatsChance.setMaximumSize(new QSize(25, 16777215));
        lblStatsChance.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsChance.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/chance.png")));
        lblStatsChance.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_3.addWidget(lblStatsChance, 0, 4, 1, 1);

        lblStatsForce = new QLabel(frameStatsCaractIcones);
        lblStatsForce.setObjectName("lblStatsForce");
        QSizePolicy sizePolicy76 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy76.setHorizontalStretch((byte)0);
        sizePolicy76.setVerticalStretch((byte)0);
        sizePolicy76.setHeightForWidth(lblStatsForce.sizePolicy().hasHeightForWidth());
        lblStatsForce.setSizePolicy(sizePolicy76);
        lblStatsForce.setMinimumSize(new QSize(25, 25));
        lblStatsForce.setMaximumSize(new QSize(25, 16777215));
        lblStatsForce.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsForce.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/force.png")));
        lblStatsForce.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_3.addWidget(lblStatsForce, 0, 2, 1, 1);

        lblStatsInt = new QLabel(frameStatsCaractIcones);
        lblStatsInt.setObjectName("lblStatsInt");
        QSizePolicy sizePolicy77 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy77.setHorizontalStretch((byte)0);
        sizePolicy77.setVerticalStretch((byte)0);
        sizePolicy77.setHeightForWidth(lblStatsInt.sizePolicy().hasHeightForWidth());
        lblStatsInt.setSizePolicy(sizePolicy77);
        lblStatsInt.setMinimumSize(new QSize(25, 25));
        lblStatsInt.setMaximumSize(new QSize(25, 16777215));
        lblStatsInt.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsInt.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/intelligence.png")));
        lblStatsInt.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_3.addWidget(lblStatsInt, 0, 3, 1, 1);

        lblStatsAgi = new QLabel(frameStatsCaractIcones);
        lblStatsAgi.setObjectName("lblStatsAgi");
        QSizePolicy sizePolicy78 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy78.setHorizontalStretch((byte)0);
        sizePolicy78.setVerticalStretch((byte)0);
        sizePolicy78.setHeightForWidth(lblStatsAgi.sizePolicy().hasHeightForWidth());
        lblStatsAgi.setSizePolicy(sizePolicy78);
        lblStatsAgi.setMinimumSize(new QSize(25, 25));
        lblStatsAgi.setMaximumSize(new QSize(25, 16777215));
        lblStatsAgi.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsAgi.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/agilite.png")));
        lblStatsAgi.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_3.addWidget(lblStatsAgi, 0, 5, 1, 1);

        lblStatsVita = new QLabel(frameStatsCaractIcones);
        lblStatsVita.setObjectName("lblStatsVita");
        QSizePolicy sizePolicy79 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy79.setHorizontalStretch((byte)0);
        sizePolicy79.setVerticalStretch((byte)0);
        sizePolicy79.setHeightForWidth(lblStatsVita.sizePolicy().hasHeightForWidth());
        lblStatsVita.setSizePolicy(sizePolicy79);
        lblStatsVita.setMinimumSize(new QSize(30, 25));
        lblStatsVita.setMaximumSize(new QSize(30, 16777215));
        lblStatsVita.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsVita.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/vita.png")));
        lblStatsVita.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_3.addWidget(lblStatsVita, 0, 0, 1, 1);


        verticalLayout_2.addWidget(frameStatsCaractIcones);

        frameStatsCaractTxt = new QFrame(frameStatsCaract);
        frameStatsCaractTxt.setObjectName("frameStatsCaractTxt");
        QSizePolicy sizePolicy80 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy80.setHorizontalStretch((byte)0);
        sizePolicy80.setVerticalStretch((byte)0);
        sizePolicy80.setHeightForWidth(frameStatsCaractTxt.sizePolicy().hasHeightForWidth());
        frameStatsCaractTxt.setSizePolicy(sizePolicy80);
        frameStatsCaractTxt.setStyleSheet("QFrame {\n"+
"	border: 1px solid #f19142;\n"+
"	background-color: #f9c884;\n"+
"}");
        frameStatsCaractTxt.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        gridLayout_6 = new QGridLayout(frameStatsCaractTxt);
        gridLayout_6.setSpacing(1);
        gridLayout_6.setMargin(1);
        gridLayout_6.setObjectName("gridLayout_6");
        txtStatsAgi = new QLineEdit(frameStatsCaractTxt);
        txtStatsAgi.setObjectName("txtStatsAgi");
        QSizePolicy sizePolicy81 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy81.setHorizontalStretch((byte)0);
        sizePolicy81.setVerticalStretch((byte)0);
        sizePolicy81.setHeightForWidth(txtStatsAgi.sizePolicy().hasHeightForWidth());
        txtStatsAgi.setSizePolicy(sizePolicy81);
        txtStatsAgi.setMinimumSize(new QSize(25, 0));
        txtStatsAgi.setMaximumSize(new QSize(25, 16777215));
        QFont font28 = new QFont();
        font28.setPointSize(7);
        txtStatsAgi.setFont(font28);
        txtStatsAgi.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        txtStatsAgi.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_6.addWidget(txtStatsAgi, 0, 5, 1, 1);

        txtStatsChance = new QLineEdit(frameStatsCaractTxt);
        txtStatsChance.setObjectName("txtStatsChance");
        QSizePolicy sizePolicy82 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy82.setHorizontalStretch((byte)0);
        sizePolicy82.setVerticalStretch((byte)0);
        sizePolicy82.setHeightForWidth(txtStatsChance.sizePolicy().hasHeightForWidth());
        txtStatsChance.setSizePolicy(sizePolicy82);
        txtStatsChance.setMinimumSize(new QSize(25, 0));
        txtStatsChance.setMaximumSize(new QSize(25, 16777215));
        QFont font29 = new QFont();
        font29.setPointSize(7);
        txtStatsChance.setFont(font29);
        txtStatsChance.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        txtStatsChance.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_6.addWidget(txtStatsChance, 0, 4, 1, 1);

        txtStatsInt = new QLineEdit(frameStatsCaractTxt);
        txtStatsInt.setObjectName("txtStatsInt");
        QSizePolicy sizePolicy83 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy83.setHorizontalStretch((byte)0);
        sizePolicy83.setVerticalStretch((byte)0);
        sizePolicy83.setHeightForWidth(txtStatsInt.sizePolicy().hasHeightForWidth());
        txtStatsInt.setSizePolicy(sizePolicy83);
        txtStatsInt.setMinimumSize(new QSize(25, 0));
        txtStatsInt.setMaximumSize(new QSize(25, 16777215));
        QFont font30 = new QFont();
        font30.setPointSize(7);
        txtStatsInt.setFont(font30);
        txtStatsInt.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        txtStatsInt.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_6.addWidget(txtStatsInt, 0, 3, 1, 1);

        txtStatsVita = new QLineEdit(frameStatsCaractTxt);
        txtStatsVita.setObjectName("txtStatsVita");
        QSizePolicy sizePolicy84 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Ignored);
        sizePolicy84.setHorizontalStretch((byte)0);
        sizePolicy84.setVerticalStretch((byte)0);
        sizePolicy84.setHeightForWidth(txtStatsVita.sizePolicy().hasHeightForWidth());
        txtStatsVita.setSizePolicy(sizePolicy84);
        txtStatsVita.setMinimumSize(new QSize(30, 0));
        txtStatsVita.setMaximumSize(new QSize(30, 16777215));
        QFont font31 = new QFont();
        font31.setPointSize(7);
        txtStatsVita.setFont(font31);
        txtStatsVita.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        txtStatsVita.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_6.addWidget(txtStatsVita, 0, 0, 1, 1);

        txtStatsSag = new QLineEdit(frameStatsCaractTxt);
        txtStatsSag.setObjectName("txtStatsSag");
        QSizePolicy sizePolicy85 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy85.setHorizontalStretch((byte)0);
        sizePolicy85.setVerticalStretch((byte)0);
        sizePolicy85.setHeightForWidth(txtStatsSag.sizePolicy().hasHeightForWidth());
        txtStatsSag.setSizePolicy(sizePolicy85);
        txtStatsSag.setMinimumSize(new QSize(25, 0));
        txtStatsSag.setMaximumSize(new QSize(25, 16777215));
        QFont font32 = new QFont();
        font32.setPointSize(7);
        txtStatsSag.setFont(font32);
        txtStatsSag.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        txtStatsSag.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_6.addWidget(txtStatsSag, 0, 1, 1, 1);

        txtStatsForce = new QLineEdit(frameStatsCaractTxt);
        txtStatsForce.setObjectName("txtStatsForce");
        QSizePolicy sizePolicy86 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy86.setHorizontalStretch((byte)0);
        sizePolicy86.setVerticalStretch((byte)0);
        sizePolicy86.setHeightForWidth(txtStatsForce.sizePolicy().hasHeightForWidth());
        txtStatsForce.setSizePolicy(sizePolicy86);
        txtStatsForce.setMinimumSize(new QSize(25, 0));
        txtStatsForce.setMaximumSize(new QSize(25, 16777215));
        QFont font33 = new QFont();
        font33.setPointSize(7);
        txtStatsForce.setFont(font33);
        txtStatsForce.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        txtStatsForce.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_6.addWidget(txtStatsForce, 0, 2, 1, 1);


        verticalLayout_2.addWidget(frameStatsCaractTxt);


        gridLayout_13.addWidget(frameStatsCaract, 0, 1, 1, 2);


        gridLayout_8.addWidget(frameStats, 2, 0, 1, 8);

        lblNom = new QLabel(ongletCaract);
        lblNom.setObjectName("lblNom");

        gridLayout_8.addWidget(lblNom, 0, 0, 1, 1);

        txtNom = new QLineEdit(ongletCaract);
        txtNom.setObjectName("txtNom");
        txtNom.setEnabled(false);
        QSizePolicy sizePolicy87 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy87.setHorizontalStretch((byte)0);
        sizePolicy87.setVerticalStretch((byte)0);
        sizePolicy87.setHeightForWidth(txtNom.sizePolicy().hasHeightForWidth());
        txtNom.setSizePolicy(sizePolicy87);
        txtNom.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);

        gridLayout_8.addWidget(txtNom, 0, 1, 1, 1);

        lblPano = new QLabel(ongletCaract);
        lblPano.setObjectName("lblPano");

        gridLayout_8.addWidget(lblPano, 3, 2, 1, 1);

        comboPano = new QComboBox(ongletCaract);
        comboPano.setObjectName("comboPano");
        QSizePolicy sizePolicy88 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy88.setHorizontalStretch((byte)0);
        sizePolicy88.setVerticalStretch((byte)0);
        sizePolicy88.setHeightForWidth(comboPano.sizePolicy().hasHeightForWidth());
        comboPano.setSizePolicy(sizePolicy88);
        comboPano.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.WheelFocus);

        gridLayout_8.addWidget(comboPano, 3, 3, 1, 1);

        spinBoxNiveau = new QSpinBox(ongletCaract);
        spinBoxNiveau.setObjectName("spinBoxNiveau");
        QSizePolicy sizePolicy89 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy89.setHorizontalStretch((byte)0);
        sizePolicy89.setVerticalStretch((byte)0);
        sizePolicy89.setHeightForWidth(spinBoxNiveau.sizePolicy().hasHeightForWidth());
        spinBoxNiveau.setSizePolicy(sizePolicy89);
        spinBoxNiveau.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.WheelFocus);
        spinBoxNiveau.setMinimum(1);
        spinBoxNiveau.setMaximum(200);

        gridLayout_8.addWidget(spinBoxNiveau, 3, 1, 1, 1);

        lblNiveau = new QLabel(ongletCaract);
        lblNiveau.setObjectName("lblNiveau");

        gridLayout_8.addWidget(lblNiveau, 3, 0, 1, 1);

        onglets.addTab(ongletCaract, com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "Caract\u00e9ristiques", null));
        ongletCondition = new QWidget();
        ongletCondition.setObjectName("ongletCondition");
        gridLayout = new QGridLayout(ongletCondition);
        gridLayout.setObjectName("gridLayout");
        widgetConditions = new QWidgetConditions(ongletCondition);
        widgetConditions.setObjectName("widgetConditions");

        gridLayout.addWidget(widgetConditions, 0, 0, 1, 1);

        onglets.addTab(ongletCondition, com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "Conditions", null));

        gridLayout_11.addWidget(onglets, 1, 1, 1, 1);

        lblNom.setBuddy(txtNom);
        lblPano.setBuddy(comboPano);
        lblNiveau.setBuddy(spinBoxNiveau);
        QWidget.setTabOrder(btnNouveau, btnSupp);
        QWidget.setTabOrder(btnSupp, comboModele);
        QWidget.setTabOrder(comboModele, btnChargerModele);
        QWidget.setTabOrder(btnChargerModele, txtStatsVie);
        QWidget.setTabOrder(txtStatsVie, txtStatsPA);
        QWidget.setTabOrder(txtStatsPA, txtStatsPM);
        QWidget.setTabOrder(txtStatsPM, txtStatsPO);
        QWidget.setTabOrder(txtStatsPO, txtStatsIni);
        QWidget.setTabOrder(txtStatsIni, txtStatsPP);
        QWidget.setTabOrder(txtStatsPP, txtStatsVita);
        QWidget.setTabOrder(txtStatsVita, txtStatsSag);
        QWidget.setTabOrder(txtStatsSag, txtStatsForce);
        QWidget.setTabOrder(txtStatsForce, txtStatsInt);
        QWidget.setTabOrder(txtStatsInt, txtStatsChance);
        QWidget.setTabOrder(txtStatsChance, txtStatsAgi);
        QWidget.setTabOrder(txtStatsAgi, txtStatsDom);
        QWidget.setTabOrder(txtStatsDom, txtStatsPDom);
        QWidget.setTabOrder(txtStatsPDom, txtStatsCC);
        QWidget.setTabOrder(txtStatsCC, txtStatsSoin);
        QWidget.setTabOrder(txtStatsSoin, txtStatsInvoc);
        QWidget.setTabOrder(txtStatsInvoc, txtStatsDomPiege);
        QWidget.setTabOrder(txtStatsDomPiege, txtStatsPDomPiege);
        QWidget.setTabOrder(txtStatsPDomPiege, txtStatsResMagique);
        QWidget.setTabOrder(txtStatsResMagique, txtStatsResPhysique);
        QWidget.setTabOrder(txtStatsResPhysique, txtStatsResNeutre);
        QWidget.setTabOrder(txtStatsResNeutre, txtStatsPResNeutre);
        QWidget.setTabOrder(txtStatsPResNeutre, txtStatsResTerre);
        QWidget.setTabOrder(txtStatsResTerre, txtStatsPResTerre);
        QWidget.setTabOrder(txtStatsPResTerre, txtStatsResFeu);
        QWidget.setTabOrder(txtStatsResFeu, txtStatsPResFeu);
        QWidget.setTabOrder(txtStatsPResFeu, txtStatsResEau);
        QWidget.setTabOrder(txtStatsResEau, txtStatsPResEau);
        QWidget.setTabOrder(txtStatsPResEau, txtStatsResAir);
        QWidget.setTabOrder(txtStatsResAir, txtStatsPResAir);
        QWidget.setTabOrder(txtStatsPResAir, btnSauv);
        QWidget.setTabOrder(btnSauv, btnFermer);
        retranslateUi(UIGestionEquipement);
        btnFermer.clicked.connect(UIGestionEquipement, "close()");

        onglets.setCurrentIndex(0);


        UIGestionEquipement.connectSlotsByName();
    } // setupUi

    void retranslateUi(QWidget UIGestionEquipement)
    {
        UIGestionEquipement.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "Gestion", null));
        grpModele.setTitle(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "Mod\u00e8le", null));
        btnChargerModele.setText(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "Charger", null));
        rbtnMini.setText(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "Jets minimums", null));
        rbtnMoy.setText(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "Jets moyens", null));
        rbtnMaxi.setText(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "Jets maximums", null));
        lblListe.setText(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "Objets enregistr\u00e9s :", null));
        btnNouveau.setText(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "Nouveau", null));
        btnSupp.setText(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "Supprimer", null));
        btnSauv.setText(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "Sauvegarder", null));
        btnFermer.setText(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "Fermer", null));
        lblStatsPA.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "Points d'action", null));
        lblStatsPA.setText("");
        lblStatsPM.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "Points de mouvement", null));
        lblStatsPM.setText("");
        lblStatsPO.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "Bonus de Port\u00e9e", null));
        lblStatsPO.setText("");
        lblStatsIni.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "Initiative", null));
        lblStatsIni.setText("");
        lblStatsPP.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "Prospection", null));
        lblStatsPP.setText("");
        lblStatsVie.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "Vie totale", null));
        lblStatsVie.setText("");
        txtStatsPA.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "Points d'action", null));
        txtStatsPA.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "#9; ", null));
        txtStatsIni.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "Initiative", null));
        txtStatsIni.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "#9999; ", null));
        txtStatsVie.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "Vie totale", null));
        txtStatsVie.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "#9999; ", null));
        txtStatsPO.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "Bonus de Port\u00e9e", null));
        txtStatsPO.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "#9; ", null));
        txtStatsPP.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "Prospection", null));
        txtStatsPP.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "#99; ", null));
        txtStatsPM.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "Points de mouvement", null));
        txtStatsPM.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "#9; ", null));
        lblStatsPDom.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "% Dommages", null));
        lblStatsPDom.setText("");
        lblStatsInvoc.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "Cr\u00e9atures invocables", null));
        lblStatsInvoc.setText("");
        lblStatsCC.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "Bonus Coups Critiques", null));
        lblStatsCC.setText("");
        lblStatsSoin.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "Soins", null));
        lblStatsSoin.setText("");
        lblStatsDomPiege.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "Dommages aux pi\u00e8ges", null));
        lblStatsDomPiege.setText("");
        lblStatsPDomPiege.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "% Dommages aux pi\u00e8ges", null));
        lblStatsPDomPiege.setText("");
        lblStatsEC.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "Malus aux \u00e9checs critiques", null));
        lblStatsEC.setText("");
        lblStatsRenvois.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "Renvois", null));
        lblStatsRenvois.setText("");
        lblStatsDom.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "Dommages", null));
        lblStatsDom.setText("");
        txtStatsDomPiege.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "Dommages aux pi\u00e8ges", null));
        txtStatsDomPiege.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "#99; ", null));
        txtStatsPDomPiege.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "% Dommages aux pi\u00e8ges", null));
        txtStatsPDomPiege.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "#99; ", null));
        txtStatsPDom.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "% Dommages", null));
        txtStatsPDom.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "#99; ", null));
        txtStatsSoin.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "Soins", null));
        txtStatsSoin.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "#99; ", null));
        txtStatsCC.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "Bonus Coups Critiques", null));
        txtStatsCC.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "#99; ", null));
        txtStatsEC.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "Malus aux \u00e9checs critiques", null));
        txtStatsEC.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "#99; ", null));
        txtStatsRenvois.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "Renvois", null));
        txtStatsRenvois.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "#99; ", null));
        txtStatsDom.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "Dommages", null));
        txtStatsDom.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "#99; ", null));
        txtStatsInvoc.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "Cr\u00e9atures invocables", null));
        txtStatsInvoc.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "#99; ", null));
        lblStatsResMagique.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "R\u00e9sistance Magique", null));
        lblStatsResMagique.setText("");
        lblStatsResPhysique.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "R\u00e9sistance Physique", null));
        lblStatsResPhysique.setText("");
        lblStatsResNeutre.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "R\u00e9sistance Neutre", null));
        lblStatsResNeutre.setText("");
        lblStatsPResNeutre.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "% R\u00e9sistance Neutre", null));
        lblStatsPResNeutre.setText("");
        lblStatsResTerre.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "R\u00e9sistance Terre", null));
        lblStatsResTerre.setText("");
        lblStatsPResTerre.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "% R\u00e9sistance Terre", null));
        lblStatsPResTerre.setText("");
        lblStatsResFeu.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "R\u00e9sistance Feu", null));
        lblStatsResFeu.setText("");
        lblStatsPResFeu.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "% R\u00e9sistance Feu", null));
        lblStatsPResFeu.setText("");
        lblStatsResEau.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "R\u00e9sistance Eau", null));
        lblStatsResEau.setText("");
        lblStatsPResEau.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "% R\u00e9sistance Eau", null));
        lblStatsPResEau.setText("");
        lblStatsResAir.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "R\u00e9sistance Air", null));
        lblStatsResAir.setText("");
        lblStatsPResAir.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "% R\u00e9sistance Air", null));
        lblStatsPResAir.setText("");
        txtStatsResMagique.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "R\u00e9sistance Magique", null));
        txtStatsResMagique.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "#99; ", null));
        txtStatsResPhysique.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "R\u00e9sistance Physique", null));
        txtStatsResPhysique.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "#99; ", null));
        txtStatsResNeutre.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "R\u00e9sistance Neutre", null));
        txtStatsResNeutre.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "#99; ", null));
        txtStatsPResNeutre.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "% Resistance Neutre", null));
        txtStatsPResNeutre.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "#99; ", null));
        txtStatsResTerre.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "R\u00e9sistance Terre", null));
        txtStatsResTerre.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "#99; ", null));
        txtStatsPResTerre.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "% R\u00e9sistance Terre", null));
        txtStatsPResTerre.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "#99; ", null));
        txtStatsResFeu.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "R\u00e9sistance Feu", null));
        txtStatsResFeu.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "#99; ", null));
        txtStatsPResFeu.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "% R\u00e9sistance Feu", null));
        txtStatsPResFeu.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "#99; ", null));
        txtStatsResEau.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "R\u00e9sistance Eau", null));
        txtStatsResEau.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "#99; ", null));
        txtStatsPResEau.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "% R\u00e9sistnace Eau", null));
        txtStatsPResEau.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "#99; ", null));
        txtStatsResAir.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "R\u00e9sistance Air", null));
        txtStatsResAir.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "#99; ", null));
        txtStatsPResAir.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "% R\u00e9sistance Air", null));
        txtStatsPResAir.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "#99; ", null));
        lblStatsSag.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "Sagesse", null));
        lblStatsSag.setText("");
        lblStatsChance.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "Chance", null));
        lblStatsChance.setText("");
        lblStatsForce.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "Force", null));
        lblStatsForce.setText("");
        lblStatsInt.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "Intelligence", null));
        lblStatsInt.setText("");
        lblStatsAgi.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "Agilit\u00e9", null));
        lblStatsAgi.setText("");
        lblStatsVita.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "Vitalit\u00e9", null));
        lblStatsVita.setText("");
        txtStatsAgi.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "Agilit\u00e9", null));
        txtStatsAgi.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "#999; ", null));
        txtStatsChance.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "Chance", null));
        txtStatsChance.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "#999; ", null));
        txtStatsInt.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "Intelligence", null));
        txtStatsInt.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "#999; ", null));
        txtStatsVita.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "Vitalit\u00e9", null));
        txtStatsVita.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "#9999; ", null));
        txtStatsSag.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "Sagesse", null));
        txtStatsSag.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "#999; ", null));
        txtStatsForce.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "Force", null));
        txtStatsForce.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "#999; ", null));
        lblNom.setText(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "Nom", null));
        lblPano.setText(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "Panoplie :", null));
        comboPano.clear();
        comboPano.addItem(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "<G\u00e9n\u00e9r\u00e9>", null));
        lblNiveau.setText(com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "Niveau :", null));
        onglets.setTabText(onglets.indexOf(ongletCaract), com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "Caract\u00e9ristiques", null));
        onglets.setTabText(onglets.indexOf(ongletCondition), com.trolltech.qt.core.QCoreApplication.translate("UIGestionEquipement", "Conditions", null));
    } // retranslateUi

}

