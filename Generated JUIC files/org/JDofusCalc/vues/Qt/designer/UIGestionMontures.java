/********************************************************************************
** Form generated from reading ui file 'UIGestionMontures.jui'
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

public class UIGestionMontures implements com.trolltech.qt.QUiForm<QWidget>
{
    public QGridLayout gridLayout;
    public QFrame frameListe;
    public QVBoxLayout verticalLayout_5;
    public QLabel lblListe;
    public QListWidget listeMontures;
    public QFrame frameActions;
    public QHBoxLayout horizontalLayout;
    public QPushButton btnNouveau;
    public QPushButton btnSupp;
    public QSpacerItem horizontalSpacer;
    public QPushButton btnSauv;
    public QPushButton btnFermer;
    public QGroupBox grpMonture;
    public QGridLayout gridLayout_8;
    public QLabel lblNom;
    public QLabel lblNiveau;
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
    public QLabel lblRace;
    public QComboBox comboRaces;
    public QLineEdit txtNom;
    public QSpinBox spinBoxNiveau;
    public QSpinBox spinBoxNiveauPerso;
    public QLabel lblNiveauPerso;
    public QWidgetFiltre filtre;

    public UIGestionMontures() { super(); }

    public void setupUi(QWidget UIGestionMontures)
    {
        UIGestionMontures.setObjectName("UIGestionMontures");
        UIGestionMontures.resize(new QSize(668, 319).expandedTo(UIGestionMontures.minimumSizeHint()));
        gridLayout = new QGridLayout(UIGestionMontures);
        gridLayout.setObjectName("gridLayout");
        frameListe = new QFrame(UIGestionMontures);
        frameListe.setObjectName("frameListe");
        QSizePolicy sizePolicy = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Preferred);
        sizePolicy.setHorizontalStretch((byte)0);
        sizePolicy.setVerticalStretch((byte)0);
        sizePolicy.setHeightForWidth(frameListe.sizePolicy().hasHeightForWidth());
        frameListe.setSizePolicy(sizePolicy);
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

        listeMontures = new QListWidget(frameListe);
        listeMontures.setObjectName("listeMontures");
        listeMontures.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.WheelFocus);

        verticalLayout_5.addWidget(listeMontures);


        gridLayout.addWidget(frameListe, 0, 0, 2, 1);

        frameActions = new QFrame(UIGestionMontures);
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
        QSizePolicy sizePolicy1 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy1.setHorizontalStretch((byte)0);
        sizePolicy1.setVerticalStretch((byte)0);
        sizePolicy1.setHeightForWidth(btnSupp.sizePolicy().hasHeightForWidth());
        btnSupp.setSizePolicy(sizePolicy1);
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


        gridLayout.addWidget(frameActions, 2, 0, 1, 3);

        grpMonture = new QGroupBox(UIGestionMontures);
        grpMonture.setObjectName("grpMonture");
        QSizePolicy sizePolicy2 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);
        sizePolicy2.setHorizontalStretch((byte)0);
        sizePolicy2.setVerticalStretch((byte)0);
        sizePolicy2.setHeightForWidth(grpMonture.sizePolicy().hasHeightForWidth());
        grpMonture.setSizePolicy(sizePolicy2);
        gridLayout_8 = new QGridLayout(grpMonture);
        gridLayout_8.setObjectName("gridLayout_8");
        lblNom = new QLabel(grpMonture);
        lblNom.setObjectName("lblNom");
        QSizePolicy sizePolicy3 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy3.setHorizontalStretch((byte)0);
        sizePolicy3.setVerticalStretch((byte)0);
        sizePolicy3.setHeightForWidth(lblNom.sizePolicy().hasHeightForWidth());
        lblNom.setSizePolicy(sizePolicy3);

        gridLayout_8.addWidget(lblNom, 0, 0, 1, 1);

        lblNiveau = new QLabel(grpMonture);
        lblNiveau.setObjectName("lblNiveau");
        QSizePolicy sizePolicy4 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy4.setHorizontalStretch((byte)0);
        sizePolicy4.setVerticalStretch((byte)0);
        sizePolicy4.setHeightForWidth(lblNiveau.sizePolicy().hasHeightForWidth());
        lblNiveau.setSizePolicy(sizePolicy4);

        gridLayout_8.addWidget(lblNiveau, 2, 0, 1, 1);

        frameStats = new QFrame(grpMonture);
        frameStats.setObjectName("frameStats");
        QSizePolicy sizePolicy5 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy5.setHorizontalStretch((byte)0);
        sizePolicy5.setVerticalStretch((byte)0);
        sizePolicy5.setHeightForWidth(frameStats.sizePolicy().hasHeightForWidth());
        frameStats.setSizePolicy(sizePolicy5);
        frameStats.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        frameStats.setFrameShadow(com.trolltech.qt.gui.QFrame.Shadow.Raised);
        gridLayout_13 = new QGridLayout(frameStats);
        gridLayout_13.setSpacing(0);
        gridLayout_13.setMargin(0);
        gridLayout_13.setObjectName("gridLayout_13");
        frameStatsGene = new QFrame(frameStats);
        frameStatsGene.setObjectName("frameStatsGene");
        QSizePolicy sizePolicy6 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy6.setHorizontalStretch((byte)0);
        sizePolicy6.setVerticalStretch((byte)0);
        sizePolicy6.setHeightForWidth(frameStatsGene.sizePolicy().hasHeightForWidth());
        frameStatsGene.setSizePolicy(sizePolicy6);
        frameStatsGene.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        frameStatsGene.setFrameShadow(com.trolltech.qt.gui.QFrame.Shadow.Raised);
        verticalLayout = new QVBoxLayout(frameStatsGene);
        verticalLayout.setSpacing(0);
        verticalLayout.setMargin(0);
        verticalLayout.setObjectName("verticalLayout");
        frameStatsGeneIcones = new QFrame(frameStatsGene);
        frameStatsGeneIcones.setObjectName("frameStatsGeneIcones");
        QSizePolicy sizePolicy7 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy7.setHorizontalStretch((byte)0);
        sizePolicy7.setVerticalStretch((byte)0);
        sizePolicy7.setHeightForWidth(frameStatsGeneIcones.sizePolicy().hasHeightForWidth());
        frameStatsGeneIcones.setSizePolicy(sizePolicy7);
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
        QSizePolicy sizePolicy8 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy8.setHorizontalStretch((byte)0);
        sizePolicy8.setVerticalStretch((byte)0);
        sizePolicy8.setHeightForWidth(lblStatsPA.sizePolicy().hasHeightForWidth());
        lblStatsPA.setSizePolicy(sizePolicy8);
        lblStatsPA.setMinimumSize(new QSize(20, 25));
        lblStatsPA.setMaximumSize(new QSize(20, 16777215));
        lblStatsPA.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsPA.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/pa.png")));
        lblStatsPA.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(lblStatsPA, 0, 1, 1, 1);

        lblStatsPM = new QLabel(frameStatsGeneIcones);
        lblStatsPM.setObjectName("lblStatsPM");
        QSizePolicy sizePolicy9 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy9.setHorizontalStretch((byte)0);
        sizePolicy9.setVerticalStretch((byte)0);
        sizePolicy9.setHeightForWidth(lblStatsPM.sizePolicy().hasHeightForWidth());
        lblStatsPM.setSizePolicy(sizePolicy9);
        lblStatsPM.setMinimumSize(new QSize(20, 25));
        lblStatsPM.setMaximumSize(new QSize(20, 16777215));
        lblStatsPM.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsPM.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/pm.png")));
        lblStatsPM.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(lblStatsPM, 0, 2, 1, 1);

        lblStatsPO = new QLabel(frameStatsGeneIcones);
        lblStatsPO.setObjectName("lblStatsPO");
        QSizePolicy sizePolicy10 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy10.setHorizontalStretch((byte)0);
        sizePolicy10.setVerticalStretch((byte)0);
        sizePolicy10.setHeightForWidth(lblStatsPO.sizePolicy().hasHeightForWidth());
        lblStatsPO.setSizePolicy(sizePolicy10);
        lblStatsPO.setMinimumSize(new QSize(20, 25));
        lblStatsPO.setMaximumSize(new QSize(20, 16777215));
        lblStatsPO.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsPO.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/po.png")));
        lblStatsPO.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(lblStatsPO, 0, 3, 1, 1);

        lblStatsIni = new QLabel(frameStatsGeneIcones);
        lblStatsIni.setObjectName("lblStatsIni");
        QSizePolicy sizePolicy11 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy11.setHorizontalStretch((byte)0);
        sizePolicy11.setVerticalStretch((byte)0);
        sizePolicy11.setHeightForWidth(lblStatsIni.sizePolicy().hasHeightForWidth());
        lblStatsIni.setSizePolicy(sizePolicy11);
        lblStatsIni.setMinimumSize(new QSize(30, 25));
        lblStatsIni.setMaximumSize(new QSize(30, 16777215));
        lblStatsIni.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsIni.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/ini.png")));
        lblStatsIni.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(lblStatsIni, 0, 4, 1, 1);

        lblStatsPP = new QLabel(frameStatsGeneIcones);
        lblStatsPP.setObjectName("lblStatsPP");
        QSizePolicy sizePolicy12 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy12.setHorizontalStretch((byte)0);
        sizePolicy12.setVerticalStretch((byte)0);
        sizePolicy12.setHeightForWidth(lblStatsPP.sizePolicy().hasHeightForWidth());
        lblStatsPP.setSizePolicy(sizePolicy12);
        lblStatsPP.setMinimumSize(new QSize(20, 25));
        lblStatsPP.setMaximumSize(new QSize(20, 16777215));
        lblStatsPP.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsPP.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/pp.png")));
        lblStatsPP.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(lblStatsPP, 0, 5, 1, 1);

        lblStatsVie = new QLabel(frameStatsGeneIcones);
        lblStatsVie.setObjectName("lblStatsVie");
        QSizePolicy sizePolicy13 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy13.setHorizontalStretch((byte)0);
        sizePolicy13.setVerticalStretch((byte)0);
        sizePolicy13.setHeightForWidth(lblStatsVie.sizePolicy().hasHeightForWidth());
        lblStatsVie.setSizePolicy(sizePolicy13);
        lblStatsVie.setMinimumSize(new QSize(30, 25));
        lblStatsVie.setMaximumSize(new QSize(30, 16777215));
        lblStatsVie.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsVie.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/vie.png")));
        lblStatsVie.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(lblStatsVie, 0, 0, 1, 1);


        verticalLayout.addWidget(frameStatsGeneIcones);

        frameStatsGeneTxt = new QFrame(frameStatsGene);
        frameStatsGeneTxt.setObjectName("frameStatsGeneTxt");
        QSizePolicy sizePolicy14 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy14.setHorizontalStretch((byte)0);
        sizePolicy14.setVerticalStretch((byte)0);
        sizePolicy14.setHeightForWidth(frameStatsGeneTxt.sizePolicy().hasHeightForWidth());
        frameStatsGeneTxt.setSizePolicy(sizePolicy14);
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
        QSizePolicy sizePolicy15 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy15.setHorizontalStretch((byte)0);
        sizePolicy15.setVerticalStretch((byte)0);
        sizePolicy15.setHeightForWidth(txtStatsPA.sizePolicy().hasHeightForWidth());
        txtStatsPA.setSizePolicy(sizePolicy15);
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
        QSizePolicy sizePolicy16 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy16.setHorizontalStretch((byte)0);
        sizePolicy16.setVerticalStretch((byte)0);
        sizePolicy16.setHeightForWidth(txtStatsIni.sizePolicy().hasHeightForWidth());
        txtStatsIni.setSizePolicy(sizePolicy16);
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
        QSizePolicy sizePolicy17 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy17.setHorizontalStretch((byte)0);
        sizePolicy17.setVerticalStretch((byte)0);
        sizePolicy17.setHeightForWidth(txtStatsVie.sizePolicy().hasHeightForWidth());
        txtStatsVie.setSizePolicy(sizePolicy17);
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
        QSizePolicy sizePolicy18 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy18.setHorizontalStretch((byte)0);
        sizePolicy18.setVerticalStretch((byte)0);
        sizePolicy18.setHeightForWidth(txtStatsPO.sizePolicy().hasHeightForWidth());
        txtStatsPO.setSizePolicy(sizePolicy18);
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
        QSizePolicy sizePolicy19 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy19.setHorizontalStretch((byte)0);
        sizePolicy19.setVerticalStretch((byte)0);
        sizePolicy19.setHeightForWidth(txtStatsPP.sizePolicy().hasHeightForWidth());
        txtStatsPP.setSizePolicy(sizePolicy19);
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
        QSizePolicy sizePolicy20 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy20.setHorizontalStretch((byte)0);
        sizePolicy20.setVerticalStretch((byte)0);
        sizePolicy20.setHeightForWidth(txtStatsPM.sizePolicy().hasHeightForWidth());
        txtStatsPM.setSizePolicy(sizePolicy20);
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
        QSizePolicy sizePolicy21 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy21.setHorizontalStretch((byte)0);
        sizePolicy21.setVerticalStretch((byte)0);
        sizePolicy21.setHeightForWidth(frameStatsAutre.sizePolicy().hasHeightForWidth());
        frameStatsAutre.setSizePolicy(sizePolicy21);
        frameStatsAutre.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        frameStatsAutre.setFrameShadow(com.trolltech.qt.gui.QFrame.Shadow.Raised);
        verticalLayout_3 = new QVBoxLayout(frameStatsAutre);
        verticalLayout_3.setSpacing(0);
        verticalLayout_3.setMargin(0);
        verticalLayout_3.setObjectName("verticalLayout_3");
        frameStatsAutreIcones = new QFrame(frameStatsAutre);
        frameStatsAutreIcones.setObjectName("frameStatsAutreIcones");
        QSizePolicy sizePolicy22 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy22.setHorizontalStretch((byte)0);
        sizePolicy22.setVerticalStretch((byte)0);
        sizePolicy22.setHeightForWidth(frameStatsAutreIcones.sizePolicy().hasHeightForWidth());
        frameStatsAutreIcones.setSizePolicy(sizePolicy22);
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
        QSizePolicy sizePolicy23 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy23.setHorizontalStretch((byte)0);
        sizePolicy23.setVerticalStretch((byte)0);
        sizePolicy23.setHeightForWidth(lblStatsPDom.sizePolicy().hasHeightForWidth());
        lblStatsPDom.setSizePolicy(sizePolicy23);
        lblStatsPDom.setMinimumSize(new QSize(20, 25));
        lblStatsPDom.setMaximumSize(new QSize(20, 16777215));
        lblStatsPDom.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsPDom.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/pdommages.png")));
        lblStatsPDom.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_5.addWidget(lblStatsPDom, 0, 1, 1, 1);

        lblStatsInvoc = new QLabel(frameStatsAutreIcones);
        lblStatsInvoc.setObjectName("lblStatsInvoc");
        QSizePolicy sizePolicy24 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy24.setHorizontalStretch((byte)0);
        sizePolicy24.setVerticalStretch((byte)0);
        sizePolicy24.setHeightForWidth(lblStatsInvoc.sizePolicy().hasHeightForWidth());
        lblStatsInvoc.setSizePolicy(sizePolicy24);
        lblStatsInvoc.setMinimumSize(new QSize(20, 25));
        lblStatsInvoc.setMaximumSize(new QSize(20, 16777215));
        lblStatsInvoc.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsInvoc.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/invoc.png")));
        lblStatsInvoc.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_5.addWidget(lblStatsInvoc, 0, 4, 1, 1);

        lblStatsCC = new QLabel(frameStatsAutreIcones);
        lblStatsCC.setObjectName("lblStatsCC");
        QSizePolicy sizePolicy25 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy25.setHorizontalStretch((byte)0);
        sizePolicy25.setVerticalStretch((byte)0);
        sizePolicy25.setHeightForWidth(lblStatsCC.sizePolicy().hasHeightForWidth());
        lblStatsCC.setSizePolicy(sizePolicy25);
        lblStatsCC.setMinimumSize(new QSize(20, 25));
        lblStatsCC.setMaximumSize(new QSize(20, 16777215));
        lblStatsCC.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsCC.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/critique.png")));
        lblStatsCC.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_5.addWidget(lblStatsCC, 0, 2, 1, 1);

        lblStatsSoin = new QLabel(frameStatsAutreIcones);
        lblStatsSoin.setObjectName("lblStatsSoin");
        QSizePolicy sizePolicy26 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy26.setHorizontalStretch((byte)0);
        sizePolicy26.setVerticalStretch((byte)0);
        sizePolicy26.setHeightForWidth(lblStatsSoin.sizePolicy().hasHeightForWidth());
        lblStatsSoin.setSizePolicy(sizePolicy26);
        lblStatsSoin.setMinimumSize(new QSize(20, 25));
        lblStatsSoin.setMaximumSize(new QSize(20, 16777215));
        lblStatsSoin.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsSoin.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/soins.png")));
        lblStatsSoin.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_5.addWidget(lblStatsSoin, 0, 3, 1, 1);

        lblStatsDomPiege = new QLabel(frameStatsAutreIcones);
        lblStatsDomPiege.setObjectName("lblStatsDomPiege");
        QSizePolicy sizePolicy27 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy27.setHorizontalStretch((byte)0);
        sizePolicy27.setVerticalStretch((byte)0);
        sizePolicy27.setHeightForWidth(lblStatsDomPiege.sizePolicy().hasHeightForWidth());
        lblStatsDomPiege.setSizePolicy(sizePolicy27);
        lblStatsDomPiege.setMinimumSize(new QSize(20, 25));
        lblStatsDomPiege.setMaximumSize(new QSize(20, 16777215));
        lblStatsDomPiege.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsDomPiege.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/piege.png")));
        lblStatsDomPiege.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_5.addWidget(lblStatsDomPiege, 0, 5, 1, 1);

        lblStatsPDomPiege = new QLabel(frameStatsAutreIcones);
        lblStatsPDomPiege.setObjectName("lblStatsPDomPiege");
        QSizePolicy sizePolicy28 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy28.setHorizontalStretch((byte)0);
        sizePolicy28.setVerticalStretch((byte)0);
        sizePolicy28.setHeightForWidth(lblStatsPDomPiege.sizePolicy().hasHeightForWidth());
        lblStatsPDomPiege.setSizePolicy(sizePolicy28);
        lblStatsPDomPiege.setMinimumSize(new QSize(20, 25));
        lblStatsPDomPiege.setMaximumSize(new QSize(20, 16777215));
        lblStatsPDomPiege.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsPDomPiege.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/ppiege.png")));
        lblStatsPDomPiege.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_5.addWidget(lblStatsPDomPiege, 0, 6, 1, 1);

        lblStatsEC = new QLabel(frameStatsAutreIcones);
        lblStatsEC.setObjectName("lblStatsEC");
        QSizePolicy sizePolicy29 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy29.setHorizontalStretch((byte)0);
        sizePolicy29.setVerticalStretch((byte)0);
        sizePolicy29.setHeightForWidth(lblStatsEC.sizePolicy().hasHeightForWidth());
        lblStatsEC.setSizePolicy(sizePolicy29);
        lblStatsEC.setMinimumSize(new QSize(20, 25));
        lblStatsEC.setMaximumSize(new QSize(20, 16777215));
        lblStatsEC.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsEC.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/echecs_critiques.png")));
        lblStatsEC.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_5.addWidget(lblStatsEC, 0, 7, 1, 1);

        lblStatsRenvois = new QLabel(frameStatsAutreIcones);
        lblStatsRenvois.setObjectName("lblStatsRenvois");
        QSizePolicy sizePolicy30 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy30.setHorizontalStretch((byte)0);
        sizePolicy30.setVerticalStretch((byte)0);
        sizePolicy30.setHeightForWidth(lblStatsRenvois.sizePolicy().hasHeightForWidth());
        lblStatsRenvois.setSizePolicy(sizePolicy30);
        lblStatsRenvois.setMinimumSize(new QSize(20, 25));
        lblStatsRenvois.setMaximumSize(new QSize(20, 16777215));
        lblStatsRenvois.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsRenvois.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/renvois.png")));
        lblStatsRenvois.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_5.addWidget(lblStatsRenvois, 0, 8, 1, 1);

        lblStatsDom = new QLabel(frameStatsAutreIcones);
        lblStatsDom.setObjectName("lblStatsDom");
        QSizePolicy sizePolicy31 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy31.setHorizontalStretch((byte)0);
        sizePolicy31.setVerticalStretch((byte)0);
        sizePolicy31.setHeightForWidth(lblStatsDom.sizePolicy().hasHeightForWidth());
        lblStatsDom.setSizePolicy(sizePolicy31);
        lblStatsDom.setMinimumSize(new QSize(20, 25));
        lblStatsDom.setMaximumSize(new QSize(20, 16777215));
        lblStatsDom.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsDom.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/dommages.png")));
        lblStatsDom.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_5.addWidget(lblStatsDom, 0, 0, 1, 1);


        verticalLayout_3.addWidget(frameStatsAutreIcones);

        frameStatsAutreTxt = new QFrame(frameStatsAutre);
        frameStatsAutreTxt.setObjectName("frameStatsAutreTxt");
        QSizePolicy sizePolicy32 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy32.setHorizontalStretch((byte)0);
        sizePolicy32.setVerticalStretch((byte)0);
        sizePolicy32.setHeightForWidth(frameStatsAutreTxt.sizePolicy().hasHeightForWidth());
        frameStatsAutreTxt.setSizePolicy(sizePolicy32);
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
        QSizePolicy sizePolicy33 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy33.setHorizontalStretch((byte)0);
        sizePolicy33.setVerticalStretch((byte)0);
        sizePolicy33.setHeightForWidth(txtStatsDomPiege.sizePolicy().hasHeightForWidth());
        txtStatsDomPiege.setSizePolicy(sizePolicy33);
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
        QSizePolicy sizePolicy34 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy34.setHorizontalStretch((byte)0);
        sizePolicy34.setVerticalStretch((byte)0);
        sizePolicy34.setHeightForWidth(txtStatsPDomPiege.sizePolicy().hasHeightForWidth());
        txtStatsPDomPiege.setSizePolicy(sizePolicy34);
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
        QSizePolicy sizePolicy35 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy35.setHorizontalStretch((byte)0);
        sizePolicy35.setVerticalStretch((byte)0);
        sizePolicy35.setHeightForWidth(txtStatsPDom.sizePolicy().hasHeightForWidth());
        txtStatsPDom.setSizePolicy(sizePolicy35);
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
        QSizePolicy sizePolicy36 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy36.setHorizontalStretch((byte)0);
        sizePolicy36.setVerticalStretch((byte)0);
        sizePolicy36.setHeightForWidth(txtStatsSoin.sizePolicy().hasHeightForWidth());
        txtStatsSoin.setSizePolicy(sizePolicy36);
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
        QSizePolicy sizePolicy37 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy37.setHorizontalStretch((byte)0);
        sizePolicy37.setVerticalStretch((byte)0);
        sizePolicy37.setHeightForWidth(txtStatsCC.sizePolicy().hasHeightForWidth());
        txtStatsCC.setSizePolicy(sizePolicy37);
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
        QSizePolicy sizePolicy38 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy38.setHorizontalStretch((byte)0);
        sizePolicy38.setVerticalStretch((byte)0);
        sizePolicy38.setHeightForWidth(txtStatsEC.sizePolicy().hasHeightForWidth());
        txtStatsEC.setSizePolicy(sizePolicy38);
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
        QSizePolicy sizePolicy39 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy39.setHorizontalStretch((byte)0);
        sizePolicy39.setVerticalStretch((byte)0);
        sizePolicy39.setHeightForWidth(txtStatsRenvois.sizePolicy().hasHeightForWidth());
        txtStatsRenvois.setSizePolicy(sizePolicy39);
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
        QSizePolicy sizePolicy40 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy40.setHorizontalStretch((byte)0);
        sizePolicy40.setVerticalStretch((byte)0);
        sizePolicy40.setHeightForWidth(txtStatsDom.sizePolicy().hasHeightForWidth());
        txtStatsDom.setSizePolicy(sizePolicy40);
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
        QSizePolicy sizePolicy41 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy41.setHorizontalStretch((byte)0);
        sizePolicy41.setVerticalStretch((byte)0);
        sizePolicy41.setHeightForWidth(txtStatsInvoc.sizePolicy().hasHeightForWidth());
        txtStatsInvoc.setSizePolicy(sizePolicy41);
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
        QSizePolicy sizePolicy42 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy42.setHorizontalStretch((byte)0);
        sizePolicy42.setVerticalStretch((byte)0);
        sizePolicy42.setHeightForWidth(frameStatsRes.sizePolicy().hasHeightForWidth());
        frameStatsRes.setSizePolicy(sizePolicy42);
        frameStatsRes.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        frameStatsRes.setFrameShadow(com.trolltech.qt.gui.QFrame.Shadow.Raised);
        verticalLayout_4 = new QVBoxLayout(frameStatsRes);
        verticalLayout_4.setSpacing(0);
        verticalLayout_4.setMargin(0);
        verticalLayout_4.setObjectName("verticalLayout_4");
        frameStatsResIcones = new QFrame(frameStatsRes);
        frameStatsResIcones.setObjectName("frameStatsResIcones");
        QSizePolicy sizePolicy43 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy43.setHorizontalStretch((byte)0);
        sizePolicy43.setVerticalStretch((byte)0);
        sizePolicy43.setHeightForWidth(frameStatsResIcones.sizePolicy().hasHeightForWidth());
        frameStatsResIcones.setSizePolicy(sizePolicy43);
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
        QSizePolicy sizePolicy44 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy44.setHorizontalStretch((byte)0);
        sizePolicy44.setVerticalStretch((byte)0);
        sizePolicy44.setHeightForWidth(lblStatsResMagique.sizePolicy().hasHeightForWidth());
        lblStatsResMagique.setSizePolicy(sizePolicy44);
        lblStatsResMagique.setMinimumSize(new QSize(20, 25));
        lblStatsResMagique.setMaximumSize(new QSize(20, 16777215));
        lblStatsResMagique.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsResMagique.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/resMagique.png")));
        lblStatsResMagique.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsResMagique, 0, 0, 1, 1);

        lblStatsResPhysique = new QLabel(frameStatsResIcones);
        lblStatsResPhysique.setObjectName("lblStatsResPhysique");
        QSizePolicy sizePolicy45 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy45.setHorizontalStretch((byte)0);
        sizePolicy45.setVerticalStretch((byte)0);
        sizePolicy45.setHeightForWidth(lblStatsResPhysique.sizePolicy().hasHeightForWidth());
        lblStatsResPhysique.setSizePolicy(sizePolicy45);
        lblStatsResPhysique.setMinimumSize(new QSize(20, 25));
        lblStatsResPhysique.setMaximumSize(new QSize(20, 16777215));
        lblStatsResPhysique.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsResPhysique.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/resPhysique.png")));
        lblStatsResPhysique.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsResPhysique, 0, 1, 1, 1);

        lblStatsResNeutre = new QLabel(frameStatsResIcones);
        lblStatsResNeutre.setObjectName("lblStatsResNeutre");
        QSizePolicy sizePolicy46 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy46.setHorizontalStretch((byte)0);
        sizePolicy46.setVerticalStretch((byte)0);
        sizePolicy46.setHeightForWidth(lblStatsResNeutre.sizePolicy().hasHeightForWidth());
        lblStatsResNeutre.setSizePolicy(sizePolicy46);
        lblStatsResNeutre.setMinimumSize(new QSize(20, 25));
        lblStatsResNeutre.setMaximumSize(new QSize(20, 16777215));
        lblStatsResNeutre.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsResNeutre.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/resNeutre.png")));
        lblStatsResNeutre.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsResNeutre, 0, 2, 1, 1);

        lblStatsPResNeutre = new QLabel(frameStatsResIcones);
        lblStatsPResNeutre.setObjectName("lblStatsPResNeutre");
        QSizePolicy sizePolicy47 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy47.setHorizontalStretch((byte)0);
        sizePolicy47.setVerticalStretch((byte)0);
        sizePolicy47.setHeightForWidth(lblStatsPResNeutre.sizePolicy().hasHeightForWidth());
        lblStatsPResNeutre.setSizePolicy(sizePolicy47);
        lblStatsPResNeutre.setMinimumSize(new QSize(20, 25));
        lblStatsPResNeutre.setMaximumSize(new QSize(20, 16777215));
        lblStatsPResNeutre.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsPResNeutre.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/PResNeutre.png")));
        lblStatsPResNeutre.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsPResNeutre, 0, 3, 1, 1);

        lblStatsResTerre = new QLabel(frameStatsResIcones);
        lblStatsResTerre.setObjectName("lblStatsResTerre");
        QSizePolicy sizePolicy48 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy48.setHorizontalStretch((byte)0);
        sizePolicy48.setVerticalStretch((byte)0);
        sizePolicy48.setHeightForWidth(lblStatsResTerre.sizePolicy().hasHeightForWidth());
        lblStatsResTerre.setSizePolicy(sizePolicy48);
        lblStatsResTerre.setMinimumSize(new QSize(20, 25));
        lblStatsResTerre.setMaximumSize(new QSize(20, 16777215));
        lblStatsResTerre.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsResTerre.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/resTerre.png")));
        lblStatsResTerre.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsResTerre, 0, 4, 1, 1);

        lblStatsPResTerre = new QLabel(frameStatsResIcones);
        lblStatsPResTerre.setObjectName("lblStatsPResTerre");
        QSizePolicy sizePolicy49 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy49.setHorizontalStretch((byte)0);
        sizePolicy49.setVerticalStretch((byte)0);
        sizePolicy49.setHeightForWidth(lblStatsPResTerre.sizePolicy().hasHeightForWidth());
        lblStatsPResTerre.setSizePolicy(sizePolicy49);
        lblStatsPResTerre.setMinimumSize(new QSize(20, 25));
        lblStatsPResTerre.setMaximumSize(new QSize(20, 16777215));
        lblStatsPResTerre.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsPResTerre.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/PResTerre.png")));
        lblStatsPResTerre.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsPResTerre, 0, 5, 1, 1);

        lblStatsResFeu = new QLabel(frameStatsResIcones);
        lblStatsResFeu.setObjectName("lblStatsResFeu");
        QSizePolicy sizePolicy50 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy50.setHorizontalStretch((byte)0);
        sizePolicy50.setVerticalStretch((byte)0);
        sizePolicy50.setHeightForWidth(lblStatsResFeu.sizePolicy().hasHeightForWidth());
        lblStatsResFeu.setSizePolicy(sizePolicy50);
        lblStatsResFeu.setMinimumSize(new QSize(20, 25));
        lblStatsResFeu.setMaximumSize(new QSize(20, 16777215));
        lblStatsResFeu.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsResFeu.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/resFeu.png")));
        lblStatsResFeu.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsResFeu, 0, 6, 1, 1);

        lblStatsPResFeu = new QLabel(frameStatsResIcones);
        lblStatsPResFeu.setObjectName("lblStatsPResFeu");
        QSizePolicy sizePolicy51 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy51.setHorizontalStretch((byte)0);
        sizePolicy51.setVerticalStretch((byte)0);
        sizePolicy51.setHeightForWidth(lblStatsPResFeu.sizePolicy().hasHeightForWidth());
        lblStatsPResFeu.setSizePolicy(sizePolicy51);
        lblStatsPResFeu.setMinimumSize(new QSize(20, 25));
        lblStatsPResFeu.setMaximumSize(new QSize(20, 16777215));
        lblStatsPResFeu.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsPResFeu.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/PResFeu.png")));
        lblStatsPResFeu.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsPResFeu, 0, 7, 1, 1);

        lblStatsResEau = new QLabel(frameStatsResIcones);
        lblStatsResEau.setObjectName("lblStatsResEau");
        QSizePolicy sizePolicy52 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy52.setHorizontalStretch((byte)0);
        sizePolicy52.setVerticalStretch((byte)0);
        sizePolicy52.setHeightForWidth(lblStatsResEau.sizePolicy().hasHeightForWidth());
        lblStatsResEau.setSizePolicy(sizePolicy52);
        lblStatsResEau.setMinimumSize(new QSize(20, 25));
        lblStatsResEau.setMaximumSize(new QSize(20, 16777215));
        lblStatsResEau.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsResEau.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/resEau.png")));
        lblStatsResEau.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsResEau, 0, 8, 1, 1);

        lblStatsPResEau = new QLabel(frameStatsResIcones);
        lblStatsPResEau.setObjectName("lblStatsPResEau");
        QSizePolicy sizePolicy53 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy53.setHorizontalStretch((byte)0);
        sizePolicy53.setVerticalStretch((byte)0);
        sizePolicy53.setHeightForWidth(lblStatsPResEau.sizePolicy().hasHeightForWidth());
        lblStatsPResEau.setSizePolicy(sizePolicy53);
        lblStatsPResEau.setMinimumSize(new QSize(20, 25));
        lblStatsPResEau.setMaximumSize(new QSize(20, 16777215));
        lblStatsPResEau.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsPResEau.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/PResEau.png")));
        lblStatsPResEau.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsPResEau, 0, 9, 1, 1);

        lblStatsResAir = new QLabel(frameStatsResIcones);
        lblStatsResAir.setObjectName("lblStatsResAir");
        QSizePolicy sizePolicy54 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy54.setHorizontalStretch((byte)0);
        sizePolicy54.setVerticalStretch((byte)0);
        sizePolicy54.setHeightForWidth(lblStatsResAir.sizePolicy().hasHeightForWidth());
        lblStatsResAir.setSizePolicy(sizePolicy54);
        lblStatsResAir.setMinimumSize(new QSize(20, 25));
        lblStatsResAir.setMaximumSize(new QSize(20, 16777215));
        lblStatsResAir.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsResAir.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/resAir.png")));
        lblStatsResAir.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsResAir, 0, 10, 1, 1);

        lblStatsPResAir = new QLabel(frameStatsResIcones);
        lblStatsPResAir.setObjectName("lblStatsPResAir");
        QSizePolicy sizePolicy55 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy55.setHorizontalStretch((byte)0);
        sizePolicy55.setVerticalStretch((byte)0);
        sizePolicy55.setHeightForWidth(lblStatsPResAir.sizePolicy().hasHeightForWidth());
        lblStatsPResAir.setSizePolicy(sizePolicy55);
        lblStatsPResAir.setMinimumSize(new QSize(20, 25));
        lblStatsPResAir.setMaximumSize(new QSize(20, 16777215));
        lblStatsPResAir.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsPResAir.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/PResAir.png")));
        lblStatsPResAir.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_9.addWidget(lblStatsPResAir, 0, 11, 1, 1);


        verticalLayout_4.addWidget(frameStatsResIcones);

        frameStatsResTxt = new QFrame(frameStatsRes);
        frameStatsResTxt.setObjectName("frameStatsResTxt");
        QSizePolicy sizePolicy56 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy56.setHorizontalStretch((byte)0);
        sizePolicy56.setVerticalStretch((byte)0);
        sizePolicy56.setHeightForWidth(frameStatsResTxt.sizePolicy().hasHeightForWidth());
        frameStatsResTxt.setSizePolicy(sizePolicy56);
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
        QSizePolicy sizePolicy57 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy57.setHorizontalStretch((byte)0);
        sizePolicy57.setVerticalStretch((byte)0);
        sizePolicy57.setHeightForWidth(txtStatsResMagique.sizePolicy().hasHeightForWidth());
        txtStatsResMagique.setSizePolicy(sizePolicy57);
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
        QSizePolicy sizePolicy58 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy58.setHorizontalStretch((byte)0);
        sizePolicy58.setVerticalStretch((byte)0);
        sizePolicy58.setHeightForWidth(txtStatsResPhysique.sizePolicy().hasHeightForWidth());
        txtStatsResPhysique.setSizePolicy(sizePolicy58);
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
        QSizePolicy sizePolicy59 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy59.setHorizontalStretch((byte)0);
        sizePolicy59.setVerticalStretch((byte)0);
        sizePolicy59.setHeightForWidth(txtStatsResNeutre.sizePolicy().hasHeightForWidth());
        txtStatsResNeutre.setSizePolicy(sizePolicy59);
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
        QSizePolicy sizePolicy60 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy60.setHorizontalStretch((byte)0);
        sizePolicy60.setVerticalStretch((byte)0);
        sizePolicy60.setHeightForWidth(txtStatsPResNeutre.sizePolicy().hasHeightForWidth());
        txtStatsPResNeutre.setSizePolicy(sizePolicy60);
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
        QSizePolicy sizePolicy61 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy61.setHorizontalStretch((byte)0);
        sizePolicy61.setVerticalStretch((byte)0);
        sizePolicy61.setHeightForWidth(txtStatsResTerre.sizePolicy().hasHeightForWidth());
        txtStatsResTerre.setSizePolicy(sizePolicy61);
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
        QSizePolicy sizePolicy62 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy62.setHorizontalStretch((byte)0);
        sizePolicy62.setVerticalStretch((byte)0);
        sizePolicy62.setHeightForWidth(txtStatsPResTerre.sizePolicy().hasHeightForWidth());
        txtStatsPResTerre.setSizePolicy(sizePolicy62);
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
        QSizePolicy sizePolicy63 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy63.setHorizontalStretch((byte)0);
        sizePolicy63.setVerticalStretch((byte)0);
        sizePolicy63.setHeightForWidth(txtStatsResFeu.sizePolicy().hasHeightForWidth());
        txtStatsResFeu.setSizePolicy(sizePolicy63);
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
        QSizePolicy sizePolicy64 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy64.setHorizontalStretch((byte)0);
        sizePolicy64.setVerticalStretch((byte)0);
        sizePolicy64.setHeightForWidth(txtStatsPResFeu.sizePolicy().hasHeightForWidth());
        txtStatsPResFeu.setSizePolicy(sizePolicy64);
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
        QSizePolicy sizePolicy65 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy65.setHorizontalStretch((byte)0);
        sizePolicy65.setVerticalStretch((byte)0);
        sizePolicy65.setHeightForWidth(txtStatsResEau.sizePolicy().hasHeightForWidth());
        txtStatsResEau.setSizePolicy(sizePolicy65);
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
        QSizePolicy sizePolicy66 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy66.setHorizontalStretch((byte)0);
        sizePolicy66.setVerticalStretch((byte)0);
        sizePolicy66.setHeightForWidth(txtStatsPResEau.sizePolicy().hasHeightForWidth());
        txtStatsPResEau.setSizePolicy(sizePolicy66);
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
        QSizePolicy sizePolicy67 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy67.setHorizontalStretch((byte)0);
        sizePolicy67.setVerticalStretch((byte)0);
        sizePolicy67.setHeightForWidth(txtStatsResAir.sizePolicy().hasHeightForWidth());
        txtStatsResAir.setSizePolicy(sizePolicy67);
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
        QSizePolicy sizePolicy68 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy68.setHorizontalStretch((byte)0);
        sizePolicy68.setVerticalStretch((byte)0);
        sizePolicy68.setHeightForWidth(txtStatsPResAir.sizePolicy().hasHeightForWidth());
        txtStatsPResAir.setSizePolicy(sizePolicy68);
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
        QSizePolicy sizePolicy69 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy69.setHorizontalStretch((byte)0);
        sizePolicy69.setVerticalStretch((byte)0);
        sizePolicy69.setHeightForWidth(frameStatsCaract.sizePolicy().hasHeightForWidth());
        frameStatsCaract.setSizePolicy(sizePolicy69);
        frameStatsCaract.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        frameStatsCaract.setFrameShadow(com.trolltech.qt.gui.QFrame.Shadow.Raised);
        verticalLayout_2 = new QVBoxLayout(frameStatsCaract);
        verticalLayout_2.setSpacing(0);
        verticalLayout_2.setMargin(0);
        verticalLayout_2.setObjectName("verticalLayout_2");
        frameStatsCaractIcones = new QFrame(frameStatsCaract);
        frameStatsCaractIcones.setObjectName("frameStatsCaractIcones");
        QSizePolicy sizePolicy70 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy70.setHorizontalStretch((byte)0);
        sizePolicy70.setVerticalStretch((byte)0);
        sizePolicy70.setHeightForWidth(frameStatsCaractIcones.sizePolicy().hasHeightForWidth());
        frameStatsCaractIcones.setSizePolicy(sizePolicy70);
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
        QSizePolicy sizePolicy71 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy71.setHorizontalStretch((byte)0);
        sizePolicy71.setVerticalStretch((byte)0);
        sizePolicy71.setHeightForWidth(lblStatsSag.sizePolicy().hasHeightForWidth());
        lblStatsSag.setSizePolicy(sizePolicy71);
        lblStatsSag.setMinimumSize(new QSize(25, 25));
        lblStatsSag.setMaximumSize(new QSize(25, 16777215));
        lblStatsSag.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsSag.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/sagesse.png")));
        lblStatsSag.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_3.addWidget(lblStatsSag, 0, 1, 1, 1);

        lblStatsChance = new QLabel(frameStatsCaractIcones);
        lblStatsChance.setObjectName("lblStatsChance");
        QSizePolicy sizePolicy72 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy72.setHorizontalStretch((byte)0);
        sizePolicy72.setVerticalStretch((byte)0);
        sizePolicy72.setHeightForWidth(lblStatsChance.sizePolicy().hasHeightForWidth());
        lblStatsChance.setSizePolicy(sizePolicy72);
        lblStatsChance.setMinimumSize(new QSize(25, 25));
        lblStatsChance.setMaximumSize(new QSize(25, 16777215));
        lblStatsChance.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsChance.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/chance.png")));
        lblStatsChance.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_3.addWidget(lblStatsChance, 0, 4, 1, 1);

        lblStatsForce = new QLabel(frameStatsCaractIcones);
        lblStatsForce.setObjectName("lblStatsForce");
        QSizePolicy sizePolicy73 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy73.setHorizontalStretch((byte)0);
        sizePolicy73.setVerticalStretch((byte)0);
        sizePolicy73.setHeightForWidth(lblStatsForce.sizePolicy().hasHeightForWidth());
        lblStatsForce.setSizePolicy(sizePolicy73);
        lblStatsForce.setMinimumSize(new QSize(25, 25));
        lblStatsForce.setMaximumSize(new QSize(25, 16777215));
        lblStatsForce.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsForce.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/force.png")));
        lblStatsForce.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_3.addWidget(lblStatsForce, 0, 2, 1, 1);

        lblStatsInt = new QLabel(frameStatsCaractIcones);
        lblStatsInt.setObjectName("lblStatsInt");
        QSizePolicy sizePolicy74 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy74.setHorizontalStretch((byte)0);
        sizePolicy74.setVerticalStretch((byte)0);
        sizePolicy74.setHeightForWidth(lblStatsInt.sizePolicy().hasHeightForWidth());
        lblStatsInt.setSizePolicy(sizePolicy74);
        lblStatsInt.setMinimumSize(new QSize(25, 25));
        lblStatsInt.setMaximumSize(new QSize(25, 16777215));
        lblStatsInt.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsInt.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/intelligence.png")));
        lblStatsInt.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_3.addWidget(lblStatsInt, 0, 3, 1, 1);

        lblStatsAgi = new QLabel(frameStatsCaractIcones);
        lblStatsAgi.setObjectName("lblStatsAgi");
        QSizePolicy sizePolicy75 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy75.setHorizontalStretch((byte)0);
        sizePolicy75.setVerticalStretch((byte)0);
        sizePolicy75.setHeightForWidth(lblStatsAgi.sizePolicy().hasHeightForWidth());
        lblStatsAgi.setSizePolicy(sizePolicy75);
        lblStatsAgi.setMinimumSize(new QSize(25, 25));
        lblStatsAgi.setMaximumSize(new QSize(25, 16777215));
        lblStatsAgi.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsAgi.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/agilite.png")));
        lblStatsAgi.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_3.addWidget(lblStatsAgi, 0, 5, 1, 1);

        lblStatsVita = new QLabel(frameStatsCaractIcones);
        lblStatsVita.setObjectName("lblStatsVita");
        QSizePolicy sizePolicy76 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy76.setHorizontalStretch((byte)0);
        sizePolicy76.setVerticalStretch((byte)0);
        sizePolicy76.setHeightForWidth(lblStatsVita.sizePolicy().hasHeightForWidth());
        lblStatsVita.setSizePolicy(sizePolicy76);
        lblStatsVita.setMinimumSize(new QSize(30, 25));
        lblStatsVita.setMaximumSize(new QSize(30, 16777215));
        lblStatsVita.setStyleSheet("background-color: rgb(255, 255, 255);");
        lblStatsVita.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/vita.png")));
        lblStatsVita.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_3.addWidget(lblStatsVita, 0, 0, 1, 1);


        verticalLayout_2.addWidget(frameStatsCaractIcones);

        frameStatsCaractTxt = new QFrame(frameStatsCaract);
        frameStatsCaractTxt.setObjectName("frameStatsCaractTxt");
        QSizePolicy sizePolicy77 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy77.setHorizontalStretch((byte)0);
        sizePolicy77.setVerticalStretch((byte)0);
        sizePolicy77.setHeightForWidth(frameStatsCaractTxt.sizePolicy().hasHeightForWidth());
        frameStatsCaractTxt.setSizePolicy(sizePolicy77);
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
        QSizePolicy sizePolicy78 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy78.setHorizontalStretch((byte)0);
        sizePolicy78.setVerticalStretch((byte)0);
        sizePolicy78.setHeightForWidth(txtStatsAgi.sizePolicy().hasHeightForWidth());
        txtStatsAgi.setSizePolicy(sizePolicy78);
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
        QSizePolicy sizePolicy79 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy79.setHorizontalStretch((byte)0);
        sizePolicy79.setVerticalStretch((byte)0);
        sizePolicy79.setHeightForWidth(txtStatsChance.sizePolicy().hasHeightForWidth());
        txtStatsChance.setSizePolicy(sizePolicy79);
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
        QSizePolicy sizePolicy80 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy80.setHorizontalStretch((byte)0);
        sizePolicy80.setVerticalStretch((byte)0);
        sizePolicy80.setHeightForWidth(txtStatsInt.sizePolicy().hasHeightForWidth());
        txtStatsInt.setSizePolicy(sizePolicy80);
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
        QSizePolicy sizePolicy81 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Ignored);
        sizePolicy81.setHorizontalStretch((byte)0);
        sizePolicy81.setVerticalStretch((byte)0);
        sizePolicy81.setHeightForWidth(txtStatsVita.sizePolicy().hasHeightForWidth());
        txtStatsVita.setSizePolicy(sizePolicy81);
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
        QSizePolicy sizePolicy82 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy82.setHorizontalStretch((byte)0);
        sizePolicy82.setVerticalStretch((byte)0);
        sizePolicy82.setHeightForWidth(txtStatsSag.sizePolicy().hasHeightForWidth());
        txtStatsSag.setSizePolicy(sizePolicy82);
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
        QSizePolicy sizePolicy83 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Ignored, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy83.setHorizontalStretch((byte)0);
        sizePolicy83.setVerticalStretch((byte)0);
        sizePolicy83.setHeightForWidth(txtStatsForce.sizePolicy().hasHeightForWidth());
        txtStatsForce.setSizePolicy(sizePolicy83);
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


        gridLayout_8.addWidget(frameStats, 3, 0, 1, 7);

        lblRace = new QLabel(grpMonture);
        lblRace.setObjectName("lblRace");

        gridLayout_8.addWidget(lblRace, 1, 0, 1, 1);

        comboRaces = new QComboBox(grpMonture);
        comboRaces.setObjectName("comboRaces");
        comboRaces.setEnabled(false);
        QSizePolicy sizePolicy84 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy84.setHorizontalStretch((byte)0);
        sizePolicy84.setVerticalStretch((byte)0);
        sizePolicy84.setHeightForWidth(comboRaces.sizePolicy().hasHeightForWidth());
        comboRaces.setSizePolicy(sizePolicy84);
        comboRaces.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.WheelFocus);

        gridLayout_8.addWidget(comboRaces, 1, 1, 1, 4);

        txtNom = new QLineEdit(grpMonture);
        txtNom.setObjectName("txtNom");
        txtNom.setEnabled(false);
        QSizePolicy sizePolicy85 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy85.setHorizontalStretch((byte)0);
        sizePolicy85.setVerticalStretch((byte)0);
        sizePolicy85.setHeightForWidth(txtNom.sizePolicy().hasHeightForWidth());
        txtNom.setSizePolicy(sizePolicy85);
        txtNom.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);

        gridLayout_8.addWidget(txtNom, 0, 1, 1, 5);

        spinBoxNiveau = new QSpinBox(grpMonture);
        spinBoxNiveau.setObjectName("spinBoxNiveau");
        spinBoxNiveau.setEnabled(false);
        QSizePolicy sizePolicy86 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy86.setHorizontalStretch((byte)0);
        sizePolicy86.setVerticalStretch((byte)0);
        sizePolicy86.setHeightForWidth(spinBoxNiveau.sizePolicy().hasHeightForWidth());
        spinBoxNiveau.setSizePolicy(sizePolicy86);
        spinBoxNiveau.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.WheelFocus);
        spinBoxNiveau.setMinimum(1);
        spinBoxNiveau.setMaximum(100);
        spinBoxNiveau.setValue(1);

        gridLayout_8.addWidget(spinBoxNiveau, 2, 1, 1, 5);

        spinBoxNiveauPerso = new QSpinBox(grpMonture);
        spinBoxNiveauPerso.setObjectName("spinBoxNiveauPerso");
        QSizePolicy sizePolicy87 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy87.setHorizontalStretch((byte)0);
        sizePolicy87.setVerticalStretch((byte)0);
        sizePolicy87.setHeightForWidth(spinBoxNiveauPerso.sizePolicy().hasHeightForWidth());
        spinBoxNiveauPerso.setSizePolicy(sizePolicy87);
        spinBoxNiveauPerso.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.WheelFocus);
        spinBoxNiveauPerso.setMinimum(1);
        spinBoxNiveauPerso.setMaximum(200);

        gridLayout_8.addWidget(spinBoxNiveauPerso, 4, 3, 1, 1);

        lblNiveauPerso = new QLabel(grpMonture);
        lblNiveauPerso.setObjectName("lblNiveauPerso");
        QSizePolicy sizePolicy88 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy88.setHorizontalStretch((byte)0);
        sizePolicy88.setVerticalStretch((byte)0);
        sizePolicy88.setHeightForWidth(lblNiveauPerso.sizePolicy().hasHeightForWidth());
        lblNiveauPerso.setSizePolicy(sizePolicy88);

        gridLayout_8.addWidget(lblNiveauPerso, 4, 2, 1, 1);

        filtre = new QWidgetFiltre(grpMonture);
        filtre.setObjectName("filtre");
        QSizePolicy sizePolicy89 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Preferred);
        sizePolicy89.setHorizontalStretch((byte)0);
        sizePolicy89.setVerticalStretch((byte)0);
        sizePolicy89.setHeightForWidth(filtre.sizePolicy().hasHeightForWidth());
        filtre.setSizePolicy(sizePolicy89);

        gridLayout_8.addWidget(filtre, 0, 6, 1, 1);


        gridLayout.addWidget(grpMonture, 1, 1, 1, 1);

        retranslateUi(UIGestionMontures);

        UIGestionMontures.connectSlotsByName();
    } // setupUi

    void retranslateUi(QWidget UIGestionMontures)
    {
        UIGestionMontures.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "Gestion des montures", null));
        lblListe.setText(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "Montures enregistr\u00e9es :", null));
        btnNouveau.setText(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "Nouveau", null));
        btnSupp.setText(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "Supprimer", null));
        btnSauv.setText(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "Sauvegarder", null));
        btnFermer.setText(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "Fermer", null));
        grpMonture.setTitle(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "Monture :", null));
        lblNom.setText(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "Nom :", null));
        lblNiveau.setText(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "Niveau :", null));
        lblStatsPA.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "Points d'action", null));
        lblStatsPA.setText("");
        lblStatsPM.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "Points de mouvement", null));
        lblStatsPM.setText("");
        lblStatsPO.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "Bonus de Port\u00e9e", null));
        lblStatsPO.setText("");
        lblStatsIni.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "Initiative", null));
        lblStatsIni.setText("");
        lblStatsPP.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "Prospection", null));
        lblStatsPP.setText("");
        lblStatsVie.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "Vie totale", null));
        lblStatsVie.setText("");
        txtStatsPA.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "Points d'action", null));
        txtStatsPA.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "#9; ", null));
        txtStatsIni.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "Initiative", null));
        txtStatsIni.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "#9999; ", null));
        txtStatsVie.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "Vie totale", null));
        txtStatsVie.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "#9999; ", null));
        txtStatsPO.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "Bonus de Port\u00e9e", null));
        txtStatsPO.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "#9; ", null));
        txtStatsPP.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "Prospection", null));
        txtStatsPP.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "#99; ", null));
        txtStatsPM.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "Points de mouvement", null));
        txtStatsPM.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "#9; ", null));
        lblStatsPDom.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "% Dommages", null));
        lblStatsPDom.setText("");
        lblStatsInvoc.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "Cr\u00e9atures invocables", null));
        lblStatsInvoc.setText("");
        lblStatsCC.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "Bonus Coups Critiques", null));
        lblStatsCC.setText("");
        lblStatsSoin.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "Soins", null));
        lblStatsSoin.setText("");
        lblStatsDomPiege.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "Dommages aux pi\u00e8ges", null));
        lblStatsDomPiege.setText("");
        lblStatsPDomPiege.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "% Dommages aux pi\u00e8ges", null));
        lblStatsPDomPiege.setText("");
        lblStatsEC.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "Malus aux \u00e9checs critiques", null));
        lblStatsEC.setText("");
        lblStatsRenvois.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "Renvois", null));
        lblStatsRenvois.setText("");
        lblStatsDom.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "Dommages", null));
        lblStatsDom.setText("");
        txtStatsDomPiege.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "Dommages aux pi\u00e8ges", null));
        txtStatsDomPiege.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "#99; ", null));
        txtStatsPDomPiege.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "% Dommages aux pi\u00e8ges", null));
        txtStatsPDomPiege.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "#99; ", null));
        txtStatsPDom.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "% Dommages", null));
        txtStatsPDom.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "#99; ", null));
        txtStatsSoin.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "Soins", null));
        txtStatsSoin.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "#99; ", null));
        txtStatsCC.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "Bonus Coups Critiques", null));
        txtStatsCC.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "#99; ", null));
        txtStatsEC.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "Malus aux \u00e9checs critiques", null));
        txtStatsEC.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "#99; ", null));
        txtStatsRenvois.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "Renvois", null));
        txtStatsRenvois.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "#99; ", null));
        txtStatsDom.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "Dommages", null));
        txtStatsDom.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "#99; ", null));
        txtStatsInvoc.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "Cr\u00e9atures invocables", null));
        txtStatsInvoc.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "#99; ", null));
        lblStatsResMagique.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "R\u00e9sistance Magique", null));
        lblStatsResMagique.setText("");
        lblStatsResPhysique.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "R\u00e9sistance Physique", null));
        lblStatsResPhysique.setText("");
        lblStatsResNeutre.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "R\u00e9sistance Neutre", null));
        lblStatsResNeutre.setText("");
        lblStatsPResNeutre.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "% R\u00e9sistance Neutre", null));
        lblStatsPResNeutre.setText("");
        lblStatsResTerre.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "R\u00e9sistance Terre", null));
        lblStatsResTerre.setText("");
        lblStatsPResTerre.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "% R\u00e9sistance Terre", null));
        lblStatsPResTerre.setText("");
        lblStatsResFeu.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "R\u00e9sistance Feu", null));
        lblStatsResFeu.setText("");
        lblStatsPResFeu.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "% R\u00e9sistance Feu", null));
        lblStatsPResFeu.setText("");
        lblStatsResEau.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "R\u00e9sistance Eau", null));
        lblStatsResEau.setText("");
        lblStatsPResEau.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "% R\u00e9sistance Eau", null));
        lblStatsPResEau.setText("");
        lblStatsResAir.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "R\u00e9sistance Air", null));
        lblStatsResAir.setText("");
        lblStatsPResAir.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "% R\u00e9sistance Air", null));
        lblStatsPResAir.setText("");
        txtStatsResMagique.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "R\u00e9sistance Magique", null));
        txtStatsResMagique.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "#99; ", null));
        txtStatsResPhysique.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "R\u00e9sistance Physique", null));
        txtStatsResPhysique.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "#99; ", null));
        txtStatsResNeutre.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "R\u00e9sistance Neutre", null));
        txtStatsResNeutre.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "#99; ", null));
        txtStatsPResNeutre.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "% Resistance Neutre", null));
        txtStatsPResNeutre.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "#99; ", null));
        txtStatsResTerre.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "R\u00e9sistance Terre", null));
        txtStatsResTerre.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "#99; ", null));
        txtStatsPResTerre.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "% R\u00e9sistance Terre", null));
        txtStatsPResTerre.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "#99; ", null));
        txtStatsResFeu.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "R\u00e9sistance Feu", null));
        txtStatsResFeu.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "#99; ", null));
        txtStatsPResFeu.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "% R\u00e9sistance Feu", null));
        txtStatsPResFeu.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "#99; ", null));
        txtStatsResEau.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "R\u00e9sistance Eau", null));
        txtStatsResEau.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "#99; ", null));
        txtStatsPResEau.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "% R\u00e9sistnace Eau", null));
        txtStatsPResEau.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "#99; ", null));
        txtStatsResAir.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "R\u00e9sistance Air", null));
        txtStatsResAir.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "#99; ", null));
        txtStatsPResAir.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "% R\u00e9sistance Air", null));
        txtStatsPResAir.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "#99; ", null));
        lblStatsSag.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "Sagesse", null));
        lblStatsSag.setText("");
        lblStatsChance.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "Chance", null));
        lblStatsChance.setText("");
        lblStatsForce.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "Force", null));
        lblStatsForce.setText("");
        lblStatsInt.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "Intelligence", null));
        lblStatsInt.setText("");
        lblStatsAgi.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "Agilit\u00e9", null));
        lblStatsAgi.setText("");
        lblStatsVita.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "Vitalit\u00e9", null));
        lblStatsVita.setText("");
        txtStatsAgi.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "Agilit\u00e9", null));
        txtStatsAgi.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "#999; ", null));
        txtStatsChance.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "Chance", null));
        txtStatsChance.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "#999; ", null));
        txtStatsInt.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "Intelligence", null));
        txtStatsInt.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "#999; ", null));
        txtStatsVita.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "Vitalit\u00e9", null));
        txtStatsVita.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "#9999; ", null));
        txtStatsSag.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "Sagesse", null));
        txtStatsSag.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "#999; ", null));
        txtStatsForce.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "Force", null));
        txtStatsForce.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "#999; ", null));
        lblRace.setText(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "Race :", null));
        lblNiveauPerso.setText(com.trolltech.qt.core.QCoreApplication.translate("UIGestionMontures", "Niveau requis :", null));
    } // retranslateUi

}

