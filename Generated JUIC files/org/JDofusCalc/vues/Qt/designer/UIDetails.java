/********************************************************************************
** Form generated from reading ui file 'UIDetails.jui'
**
** Created: mer. 24. juin 12:04:04 2009
**      by: Qt User Interface Compiler version 4.5.0
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

package org.JDofusCalc.vues.Qt.designer;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class UIDetails implements com.trolltech.qt.QUiForm<QWidget>
{
    public QGridLayout layoutFenetre;
    public QLabel lblType;
    public QLabel lblNom;
    public QLabel lblDegatsNeutre;
    public QLabel lblDegatsTerre;
    public QLabel lblDegatsFeu;
    public QLabel lblDegatsEau;
    public QLabel lblDegatsAir;
    public QLabel lblDegatsVdV;
    public QLabel lblSoins;
    public QLabel lblMoyCoup;
    public QLabel lblMoyCoupNeutre;
    public QLabel lblMoyCoupTerre;
    public QLabel lblMoyCoupFeu;
    public QLabel lblMoyCoupEau;
    public QLabel lblMoyCoupAir;
    public QLabel lblMoyCoupVdv;
    public QLabel lblMoyCoupSoins;
    public QLabel lblCoupNorm;
    public QLabel lblMoyCoupNormNeutre;
    public QLabel lblMoyCoupNormTerre;
    public QLabel lblMoyCoupNormFeu;
    public QLabel lblMoyCoupNormEau;
    public QLabel lblMoyCoupNormAir;
    public QLabel lblMoyCoupNormVdv;
    public QLabel lblMoyCoupNormSoins;
    public QLabel lblMoyCoupCC;
    public QLabel lblMoyCoupCCNeutre;
    public QLabel lblMoyCoupCCTerre;
    public QLabel lblMoyCoupCCFeu;
    public QLabel lblMoyCoupCCEau;
    public QLabel lblMoyCoupCCAir;
    public QLabel lblMoyCoupCCVdv;
    public QLabel lblMoyCoupCCSoins;
    public QLabel lblMoyTour;
    public QLabel lblMoyTourNeutre;
    public QLabel lblMoyTourTerre;
    public QLabel lblMoyTourFeu;
    public QLabel lblMoyTourEau;
    public QLabel lblMoyTourAir;
    public QLabel lblMoyTourVdv;
    public QLabel lblMoyTourSoins;
    public QLabel lblMinTour;
    public QLabel lblMinTourNeutre;
    public QLabel lblMinTourTerre;
    public QLabel lblMinTourFeu;
    public QLabel lblMinTourEau;
    public QLabel lblMinTourAir;
    public QLabel lblMinTourVdv;
    public QLabel lblMinTourSoins;
    public QLabel lblMaxTour;
    public QLabel lblMaxTourNeutre;
    public QLabel lblMaxTourTerre;
    public QLabel lblMaxTourFeu;
    public QLabel lblMaxTourEau;
    public QLabel lblMaxTourAir;
    public QLabel lblMaxTourVdv;
    public QLabel lblMaxTourSoins;
    public QFrame line;
    public QGroupBox grpCaract;
    public QGridLayout gridLayout_2;
    public QLabel imgPA;
    public QLabel lblPA;
    public QLabel imgCC;
    public QLabel lblCC;
    public QLabel imgEC;
    public QLabel lblEC;
    public QPushButton btnFermer;
    public QLabel lblInfo;
    public QPushButton btnExporter;

    public UIDetails() { super(); }

    public void setupUi(QWidget UIDetails)
    {
        UIDetails.setObjectName("UIDetails");
        UIDetails.setWindowModality(com.trolltech.qt.core.Qt.WindowModality.WindowModal);
        UIDetails.resize(new QSize(538, 228).expandedTo(UIDetails.minimumSizeHint()));
        layoutFenetre = new QGridLayout(UIDetails);
        layoutFenetre.setObjectName("layoutFenetre");
        lblType = new QLabel(UIDetails);
        lblType.setObjectName("lblType");
        QSizePolicy sizePolicy = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy.setHorizontalStretch((byte)0);
        sizePolicy.setVerticalStretch((byte)0);
        sizePolicy.setHeightForWidth(lblType.sizePolicy().hasHeightForWidth());
        lblType.setSizePolicy(sizePolicy);

        layoutFenetre.addWidget(lblType, 0, 0, 1, 1);

        lblNom = new QLabel(UIDetails);
        lblNom.setObjectName("lblNom");
        QSizePolicy sizePolicy1 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.MinimumExpanding, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy1.setHorizontalStretch((byte)0);
        sizePolicy1.setVerticalStretch((byte)0);
        sizePolicy1.setHeightForWidth(lblNom.sizePolicy().hasHeightForWidth());
        lblNom.setSizePolicy(sizePolicy1);
        QFont font = new QFont();
        font.setBold(true);
        font.setWeight(75);
        lblNom.setFont(font);
        lblNom.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        layoutFenetre.addWidget(lblNom, 0, 1, 1, 1);

        lblDegatsNeutre = new QLabel(UIDetails);
        lblDegatsNeutre.setObjectName("lblDegatsNeutre");
        QSizePolicy sizePolicy2 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy2.setHorizontalStretch((byte)0);
        sizePolicy2.setVerticalStretch((byte)0);
        sizePolicy2.setHeightForWidth(lblDegatsNeutre.sizePolicy().hasHeightForWidth());
        lblDegatsNeutre.setSizePolicy(sizePolicy2);
        lblDegatsNeutre.setMinimumSize(new QSize(25, 20));
        lblDegatsNeutre.setMaximumSize(new QSize(25, 20));
        lblDegatsNeutre.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border-color: rgb(0, 0, 0);Z");
        lblDegatsNeutre.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/degatsNeutre.png")));
        lblDegatsNeutre.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        layoutFenetre.addWidget(lblDegatsNeutre, 0, 2, 1, 1);

        lblDegatsTerre = new QLabel(UIDetails);
        lblDegatsTerre.setObjectName("lblDegatsTerre");
        QSizePolicy sizePolicy3 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy3.setHorizontalStretch((byte)0);
        sizePolicy3.setVerticalStretch((byte)0);
        sizePolicy3.setHeightForWidth(lblDegatsTerre.sizePolicy().hasHeightForWidth());
        lblDegatsTerre.setSizePolicy(sizePolicy3);
        lblDegatsTerre.setMinimumSize(new QSize(25, 20));
        lblDegatsTerre.setMaximumSize(new QSize(25, 20));
        lblDegatsTerre.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border-color: rgb(0, 0, 0);Z");
        lblDegatsTerre.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/degatsTerre.png")));
        lblDegatsTerre.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        layoutFenetre.addWidget(lblDegatsTerre, 0, 3, 1, 1);

        lblDegatsFeu = new QLabel(UIDetails);
        lblDegatsFeu.setObjectName("lblDegatsFeu");
        QSizePolicy sizePolicy4 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy4.setHorizontalStretch((byte)0);
        sizePolicy4.setVerticalStretch((byte)0);
        sizePolicy4.setHeightForWidth(lblDegatsFeu.sizePolicy().hasHeightForWidth());
        lblDegatsFeu.setSizePolicy(sizePolicy4);
        lblDegatsFeu.setMinimumSize(new QSize(25, 20));
        lblDegatsFeu.setMaximumSize(new QSize(25, 20));
        lblDegatsFeu.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border-color: rgb(0, 0, 0);Z");
        lblDegatsFeu.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/degatsFeu.png")));
        lblDegatsFeu.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        layoutFenetre.addWidget(lblDegatsFeu, 0, 4, 1, 1);

        lblDegatsEau = new QLabel(UIDetails);
        lblDegatsEau.setObjectName("lblDegatsEau");
        QSizePolicy sizePolicy5 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy5.setHorizontalStretch((byte)0);
        sizePolicy5.setVerticalStretch((byte)0);
        sizePolicy5.setHeightForWidth(lblDegatsEau.sizePolicy().hasHeightForWidth());
        lblDegatsEau.setSizePolicy(sizePolicy5);
        lblDegatsEau.setMinimumSize(new QSize(25, 20));
        lblDegatsEau.setMaximumSize(new QSize(25, 20));
        lblDegatsEau.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border-color: rgb(0, 0, 0);Z");
        lblDegatsEau.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/degatsEau.png")));
        lblDegatsEau.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        layoutFenetre.addWidget(lblDegatsEau, 0, 5, 1, 1);

        lblDegatsAir = new QLabel(UIDetails);
        lblDegatsAir.setObjectName("lblDegatsAir");
        QSizePolicy sizePolicy6 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy6.setHorizontalStretch((byte)0);
        sizePolicy6.setVerticalStretch((byte)0);
        sizePolicy6.setHeightForWidth(lblDegatsAir.sizePolicy().hasHeightForWidth());
        lblDegatsAir.setSizePolicy(sizePolicy6);
        lblDegatsAir.setMinimumSize(new QSize(25, 20));
        lblDegatsAir.setMaximumSize(new QSize(25, 20));
        lblDegatsAir.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border-color: rgb(0, 0, 0);Z");
        lblDegatsAir.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/degatsAir.png")));
        lblDegatsAir.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        layoutFenetre.addWidget(lblDegatsAir, 0, 6, 1, 1);

        lblDegatsVdV = new QLabel(UIDetails);
        lblDegatsVdV.setObjectName("lblDegatsVdV");
        QSizePolicy sizePolicy7 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy7.setHorizontalStretch((byte)0);
        sizePolicy7.setVerticalStretch((byte)0);
        sizePolicy7.setHeightForWidth(lblDegatsVdV.sizePolicy().hasHeightForWidth());
        lblDegatsVdV.setSizePolicy(sizePolicy7);
        lblDegatsVdV.setMinimumSize(new QSize(25, 20));
        lblDegatsVdV.setMaximumSize(new QSize(25, 20));
        lblDegatsVdV.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border-color: rgb(0, 0, 0);Z");
        lblDegatsVdV.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/volvie.png")));
        lblDegatsVdV.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        layoutFenetre.addWidget(lblDegatsVdV, 0, 7, 1, 1);

        lblSoins = new QLabel(UIDetails);
        lblSoins.setObjectName("lblSoins");
        QSizePolicy sizePolicy8 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy8.setHorizontalStretch((byte)0);
        sizePolicy8.setVerticalStretch((byte)0);
        sizePolicy8.setHeightForWidth(lblSoins.sizePolicy().hasHeightForWidth());
        lblSoins.setSizePolicy(sizePolicy8);
        lblSoins.setMinimumSize(new QSize(25, 20));
        lblSoins.setMaximumSize(new QSize(25, 20));
        lblSoins.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border-color: rgb(0, 0, 0);Z");
        lblSoins.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/soins.png")));
        lblSoins.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        layoutFenetre.addWidget(lblSoins, 0, 8, 1, 1);

        lblMoyCoup = new QLabel(UIDetails);
        lblMoyCoup.setObjectName("lblMoyCoup");
        QSizePolicy sizePolicy9 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy9.setHorizontalStretch((byte)0);
        sizePolicy9.setVerticalStretch((byte)0);
        sizePolicy9.setHeightForWidth(lblMoyCoup.sizePolicy().hasHeightForWidth());
        lblMoyCoup.setSizePolicy(sizePolicy9);

        layoutFenetre.addWidget(lblMoyCoup, 1, 1, 1, 1);

        lblMoyCoupNeutre = new QLabel(UIDetails);
        lblMoyCoupNeutre.setObjectName("lblMoyCoupNeutre");
        lblMoyCoupNeutre.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblMoyCoupNeutre.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblMoyCoupNeutre.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        layoutFenetre.addWidget(lblMoyCoupNeutre, 1, 2, 1, 1);

        lblMoyCoupTerre = new QLabel(UIDetails);
        lblMoyCoupTerre.setObjectName("lblMoyCoupTerre");
        lblMoyCoupTerre.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblMoyCoupTerre.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblMoyCoupTerre.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        layoutFenetre.addWidget(lblMoyCoupTerre, 1, 3, 1, 1);

        lblMoyCoupFeu = new QLabel(UIDetails);
        lblMoyCoupFeu.setObjectName("lblMoyCoupFeu");
        lblMoyCoupFeu.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblMoyCoupFeu.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblMoyCoupFeu.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        layoutFenetre.addWidget(lblMoyCoupFeu, 1, 4, 1, 1);

        lblMoyCoupEau = new QLabel(UIDetails);
        lblMoyCoupEau.setObjectName("lblMoyCoupEau");
        lblMoyCoupEau.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblMoyCoupEau.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblMoyCoupEau.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        layoutFenetre.addWidget(lblMoyCoupEau, 1, 5, 1, 1);

        lblMoyCoupAir = new QLabel(UIDetails);
        lblMoyCoupAir.setObjectName("lblMoyCoupAir");
        lblMoyCoupAir.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblMoyCoupAir.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblMoyCoupAir.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        layoutFenetre.addWidget(lblMoyCoupAir, 1, 6, 1, 1);

        lblMoyCoupVdv = new QLabel(UIDetails);
        lblMoyCoupVdv.setObjectName("lblMoyCoupVdv");
        lblMoyCoupVdv.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblMoyCoupVdv.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblMoyCoupVdv.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        layoutFenetre.addWidget(lblMoyCoupVdv, 1, 7, 1, 1);

        lblMoyCoupSoins = new QLabel(UIDetails);
        lblMoyCoupSoins.setObjectName("lblMoyCoupSoins");
        lblMoyCoupSoins.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblMoyCoupSoins.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblMoyCoupSoins.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        layoutFenetre.addWidget(lblMoyCoupSoins, 1, 8, 1, 1);

        lblCoupNorm = new QLabel(UIDetails);
        lblCoupNorm.setObjectName("lblCoupNorm");
        QSizePolicy sizePolicy10 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy10.setHorizontalStretch((byte)0);
        sizePolicy10.setVerticalStretch((byte)0);
        sizePolicy10.setHeightForWidth(lblCoupNorm.sizePolicy().hasHeightForWidth());
        lblCoupNorm.setSizePolicy(sizePolicy10);
        lblCoupNorm.setMargin(0);
        lblCoupNorm.setIndent(10);

        layoutFenetre.addWidget(lblCoupNorm, 2, 1, 1, 1);

        lblMoyCoupNormNeutre = new QLabel(UIDetails);
        lblMoyCoupNormNeutre.setObjectName("lblMoyCoupNormNeutre");
        lblMoyCoupNormNeutre.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblMoyCoupNormNeutre.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblMoyCoupNormNeutre.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        layoutFenetre.addWidget(lblMoyCoupNormNeutre, 2, 2, 1, 1);

        lblMoyCoupNormTerre = new QLabel(UIDetails);
        lblMoyCoupNormTerre.setObjectName("lblMoyCoupNormTerre");
        lblMoyCoupNormTerre.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblMoyCoupNormTerre.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblMoyCoupNormTerre.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        layoutFenetre.addWidget(lblMoyCoupNormTerre, 2, 3, 1, 1);

        lblMoyCoupNormFeu = new QLabel(UIDetails);
        lblMoyCoupNormFeu.setObjectName("lblMoyCoupNormFeu");
        lblMoyCoupNormFeu.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblMoyCoupNormFeu.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblMoyCoupNormFeu.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        layoutFenetre.addWidget(lblMoyCoupNormFeu, 2, 4, 1, 1);

        lblMoyCoupNormEau = new QLabel(UIDetails);
        lblMoyCoupNormEau.setObjectName("lblMoyCoupNormEau");
        lblMoyCoupNormEau.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblMoyCoupNormEau.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblMoyCoupNormEau.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        layoutFenetre.addWidget(lblMoyCoupNormEau, 2, 5, 1, 1);

        lblMoyCoupNormAir = new QLabel(UIDetails);
        lblMoyCoupNormAir.setObjectName("lblMoyCoupNormAir");
        lblMoyCoupNormAir.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblMoyCoupNormAir.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblMoyCoupNormAir.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        layoutFenetre.addWidget(lblMoyCoupNormAir, 2, 6, 1, 1);

        lblMoyCoupNormVdv = new QLabel(UIDetails);
        lblMoyCoupNormVdv.setObjectName("lblMoyCoupNormVdv");
        lblMoyCoupNormVdv.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblMoyCoupNormVdv.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblMoyCoupNormVdv.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        layoutFenetre.addWidget(lblMoyCoupNormVdv, 2, 7, 1, 1);

        lblMoyCoupNormSoins = new QLabel(UIDetails);
        lblMoyCoupNormSoins.setObjectName("lblMoyCoupNormSoins");
        lblMoyCoupNormSoins.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblMoyCoupNormSoins.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblMoyCoupNormSoins.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        layoutFenetre.addWidget(lblMoyCoupNormSoins, 2, 8, 1, 1);

        lblMoyCoupCC = new QLabel(UIDetails);
        lblMoyCoupCC.setObjectName("lblMoyCoupCC");
        QSizePolicy sizePolicy11 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy11.setHorizontalStretch((byte)0);
        sizePolicy11.setVerticalStretch((byte)0);
        sizePolicy11.setHeightForWidth(lblMoyCoupCC.sizePolicy().hasHeightForWidth());
        lblMoyCoupCC.setSizePolicy(sizePolicy11);
        lblMoyCoupCC.setMargin(0);
        lblMoyCoupCC.setIndent(10);

        layoutFenetre.addWidget(lblMoyCoupCC, 3, 1, 1, 1);

        lblMoyCoupCCNeutre = new QLabel(UIDetails);
        lblMoyCoupCCNeutre.setObjectName("lblMoyCoupCCNeutre");
        lblMoyCoupCCNeutre.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblMoyCoupCCNeutre.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblMoyCoupCCNeutre.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        layoutFenetre.addWidget(lblMoyCoupCCNeutre, 3, 2, 1, 1);

        lblMoyCoupCCTerre = new QLabel(UIDetails);
        lblMoyCoupCCTerre.setObjectName("lblMoyCoupCCTerre");
        lblMoyCoupCCTerre.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblMoyCoupCCTerre.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblMoyCoupCCTerre.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        layoutFenetre.addWidget(lblMoyCoupCCTerre, 3, 3, 1, 1);

        lblMoyCoupCCFeu = new QLabel(UIDetails);
        lblMoyCoupCCFeu.setObjectName("lblMoyCoupCCFeu");
        lblMoyCoupCCFeu.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblMoyCoupCCFeu.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblMoyCoupCCFeu.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        layoutFenetre.addWidget(lblMoyCoupCCFeu, 3, 4, 1, 1);

        lblMoyCoupCCEau = new QLabel(UIDetails);
        lblMoyCoupCCEau.setObjectName("lblMoyCoupCCEau");
        lblMoyCoupCCEau.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblMoyCoupCCEau.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblMoyCoupCCEau.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        layoutFenetre.addWidget(lblMoyCoupCCEau, 3, 5, 1, 1);

        lblMoyCoupCCAir = new QLabel(UIDetails);
        lblMoyCoupCCAir.setObjectName("lblMoyCoupCCAir");
        lblMoyCoupCCAir.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblMoyCoupCCAir.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblMoyCoupCCAir.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        layoutFenetre.addWidget(lblMoyCoupCCAir, 3, 6, 1, 1);

        lblMoyCoupCCVdv = new QLabel(UIDetails);
        lblMoyCoupCCVdv.setObjectName("lblMoyCoupCCVdv");
        lblMoyCoupCCVdv.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblMoyCoupCCVdv.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblMoyCoupCCVdv.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        layoutFenetre.addWidget(lblMoyCoupCCVdv, 3, 7, 1, 1);

        lblMoyCoupCCSoins = new QLabel(UIDetails);
        lblMoyCoupCCSoins.setObjectName("lblMoyCoupCCSoins");
        lblMoyCoupCCSoins.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblMoyCoupCCSoins.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblMoyCoupCCSoins.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        layoutFenetre.addWidget(lblMoyCoupCCSoins, 3, 8, 1, 1);

        lblMoyTour = new QLabel(UIDetails);
        lblMoyTour.setObjectName("lblMoyTour");
        QSizePolicy sizePolicy12 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy12.setHorizontalStretch((byte)0);
        sizePolicy12.setVerticalStretch((byte)0);
        sizePolicy12.setHeightForWidth(lblMoyTour.sizePolicy().hasHeightForWidth());
        lblMoyTour.setSizePolicy(sizePolicy12);

        layoutFenetre.addWidget(lblMoyTour, 5, 1, 1, 1);

        lblMoyTourNeutre = new QLabel(UIDetails);
        lblMoyTourNeutre.setObjectName("lblMoyTourNeutre");
        lblMoyTourNeutre.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblMoyTourNeutre.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblMoyTourNeutre.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        layoutFenetre.addWidget(lblMoyTourNeutre, 5, 2, 1, 1);

        lblMoyTourTerre = new QLabel(UIDetails);
        lblMoyTourTerre.setObjectName("lblMoyTourTerre");
        lblMoyTourTerre.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblMoyTourTerre.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblMoyTourTerre.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        layoutFenetre.addWidget(lblMoyTourTerre, 5, 3, 1, 1);

        lblMoyTourFeu = new QLabel(UIDetails);
        lblMoyTourFeu.setObjectName("lblMoyTourFeu");
        lblMoyTourFeu.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblMoyTourFeu.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblMoyTourFeu.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        layoutFenetre.addWidget(lblMoyTourFeu, 5, 4, 1, 1);

        lblMoyTourEau = new QLabel(UIDetails);
        lblMoyTourEau.setObjectName("lblMoyTourEau");
        lblMoyTourEau.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblMoyTourEau.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblMoyTourEau.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        layoutFenetre.addWidget(lblMoyTourEau, 5, 5, 1, 1);

        lblMoyTourAir = new QLabel(UIDetails);
        lblMoyTourAir.setObjectName("lblMoyTourAir");
        lblMoyTourAir.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblMoyTourAir.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblMoyTourAir.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        layoutFenetre.addWidget(lblMoyTourAir, 5, 6, 1, 1);

        lblMoyTourVdv = new QLabel(UIDetails);
        lblMoyTourVdv.setObjectName("lblMoyTourVdv");
        lblMoyTourVdv.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblMoyTourVdv.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblMoyTourVdv.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        layoutFenetre.addWidget(lblMoyTourVdv, 5, 7, 1, 1);

        lblMoyTourSoins = new QLabel(UIDetails);
        lblMoyTourSoins.setObjectName("lblMoyTourSoins");
        lblMoyTourSoins.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblMoyTourSoins.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblMoyTourSoins.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        layoutFenetre.addWidget(lblMoyTourSoins, 5, 8, 1, 1);

        lblMinTour = new QLabel(UIDetails);
        lblMinTour.setObjectName("lblMinTour");
        QSizePolicy sizePolicy13 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy13.setHorizontalStretch((byte)0);
        sizePolicy13.setVerticalStretch((byte)0);
        sizePolicy13.setHeightForWidth(lblMinTour.sizePolicy().hasHeightForWidth());
        lblMinTour.setSizePolicy(sizePolicy13);
        lblMinTour.setIndent(10);

        layoutFenetre.addWidget(lblMinTour, 6, 1, 1, 1);

        lblMinTourNeutre = new QLabel(UIDetails);
        lblMinTourNeutre.setObjectName("lblMinTourNeutre");
        lblMinTourNeutre.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblMinTourNeutre.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblMinTourNeutre.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        layoutFenetre.addWidget(lblMinTourNeutre, 6, 2, 1, 1);

        lblMinTourTerre = new QLabel(UIDetails);
        lblMinTourTerre.setObjectName("lblMinTourTerre");
        lblMinTourTerre.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblMinTourTerre.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblMinTourTerre.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        layoutFenetre.addWidget(lblMinTourTerre, 6, 3, 1, 1);

        lblMinTourFeu = new QLabel(UIDetails);
        lblMinTourFeu.setObjectName("lblMinTourFeu");
        lblMinTourFeu.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblMinTourFeu.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblMinTourFeu.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        layoutFenetre.addWidget(lblMinTourFeu, 6, 4, 1, 1);

        lblMinTourEau = new QLabel(UIDetails);
        lblMinTourEau.setObjectName("lblMinTourEau");
        lblMinTourEau.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblMinTourEau.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblMinTourEau.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        layoutFenetre.addWidget(lblMinTourEau, 6, 5, 1, 1);

        lblMinTourAir = new QLabel(UIDetails);
        lblMinTourAir.setObjectName("lblMinTourAir");
        lblMinTourAir.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblMinTourAir.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblMinTourAir.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        layoutFenetre.addWidget(lblMinTourAir, 6, 6, 1, 1);

        lblMinTourVdv = new QLabel(UIDetails);
        lblMinTourVdv.setObjectName("lblMinTourVdv");
        lblMinTourVdv.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblMinTourVdv.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblMinTourVdv.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        layoutFenetre.addWidget(lblMinTourVdv, 6, 7, 1, 1);

        lblMinTourSoins = new QLabel(UIDetails);
        lblMinTourSoins.setObjectName("lblMinTourSoins");
        lblMinTourSoins.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblMinTourSoins.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblMinTourSoins.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        layoutFenetre.addWidget(lblMinTourSoins, 6, 8, 1, 1);

        lblMaxTour = new QLabel(UIDetails);
        lblMaxTour.setObjectName("lblMaxTour");
        QSizePolicy sizePolicy14 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy14.setHorizontalStretch((byte)0);
        sizePolicy14.setVerticalStretch((byte)0);
        sizePolicy14.setHeightForWidth(lblMaxTour.sizePolicy().hasHeightForWidth());
        lblMaxTour.setSizePolicy(sizePolicy14);
        lblMaxTour.setIndent(10);

        layoutFenetre.addWidget(lblMaxTour, 10, 1, 1, 1);

        lblMaxTourNeutre = new QLabel(UIDetails);
        lblMaxTourNeutre.setObjectName("lblMaxTourNeutre");
        lblMaxTourNeutre.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblMaxTourNeutre.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblMaxTourNeutre.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        layoutFenetre.addWidget(lblMaxTourNeutre, 10, 2, 1, 1);

        lblMaxTourTerre = new QLabel(UIDetails);
        lblMaxTourTerre.setObjectName("lblMaxTourTerre");
        lblMaxTourTerre.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblMaxTourTerre.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblMaxTourTerre.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        layoutFenetre.addWidget(lblMaxTourTerre, 10, 3, 1, 1);

        lblMaxTourFeu = new QLabel(UIDetails);
        lblMaxTourFeu.setObjectName("lblMaxTourFeu");
        lblMaxTourFeu.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblMaxTourFeu.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblMaxTourFeu.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        layoutFenetre.addWidget(lblMaxTourFeu, 10, 4, 1, 1);

        lblMaxTourEau = new QLabel(UIDetails);
        lblMaxTourEau.setObjectName("lblMaxTourEau");
        lblMaxTourEau.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblMaxTourEau.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblMaxTourEau.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        layoutFenetre.addWidget(lblMaxTourEau, 10, 5, 1, 1);

        lblMaxTourAir = new QLabel(UIDetails);
        lblMaxTourAir.setObjectName("lblMaxTourAir");
        lblMaxTourAir.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblMaxTourAir.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblMaxTourAir.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        layoutFenetre.addWidget(lblMaxTourAir, 10, 6, 1, 1);

        lblMaxTourVdv = new QLabel(UIDetails);
        lblMaxTourVdv.setObjectName("lblMaxTourVdv");
        lblMaxTourVdv.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblMaxTourVdv.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblMaxTourVdv.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        layoutFenetre.addWidget(lblMaxTourVdv, 10, 7, 1, 1);

        lblMaxTourSoins = new QLabel(UIDetails);
        lblMaxTourSoins.setObjectName("lblMaxTourSoins");
        lblMaxTourSoins.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblMaxTourSoins.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.StyledPanel);
        lblMaxTourSoins.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        layoutFenetre.addWidget(lblMaxTourSoins, 10, 8, 1, 1);

        line = new QFrame(UIDetails);
        line.setObjectName("line");
        line.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.HLine);
        line.setFrameShadow(com.trolltech.qt.gui.QFrame.Shadow.Sunken);

        layoutFenetre.addWidget(line, 4, 1, 1, 8);

        grpCaract = new QGroupBox(UIDetails);
        grpCaract.setObjectName("grpCaract");
        QSizePolicy sizePolicy15 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);
        sizePolicy15.setHorizontalStretch((byte)0);
        sizePolicy15.setVerticalStretch((byte)0);
        sizePolicy15.setHeightForWidth(grpCaract.sizePolicy().hasHeightForWidth());
        grpCaract.setSizePolicy(sizePolicy15);
        gridLayout_2 = new QGridLayout(grpCaract);
        gridLayout_2.setObjectName("gridLayout_2");
        imgPA = new QLabel(grpCaract);
        imgPA.setObjectName("imgPA");
        QSizePolicy sizePolicy16 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy16.setHorizontalStretch((byte)0);
        sizePolicy16.setVerticalStretch((byte)0);
        sizePolicy16.setHeightForWidth(imgPA.sizePolicy().hasHeightForWidth());
        imgPA.setSizePolicy(sizePolicy16);
        imgPA.setMinimumSize(new QSize(20, 20));
        imgPA.setMaximumSize(new QSize(20, 20));
        imgPA.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border-color: rgb(0, 0, 0);Z");
        imgPA.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/pa.png")));
        imgPA.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(imgPA, 0, 0, 1, 1);

        lblPA = new QLabel(grpCaract);
        lblPA.setObjectName("lblPA");
        QSizePolicy sizePolicy17 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Preferred);
        sizePolicy17.setHorizontalStretch((byte)0);
        sizePolicy17.setVerticalStretch((byte)0);
        sizePolicy17.setHeightForWidth(lblPA.sizePolicy().hasHeightForWidth());
        lblPA.setSizePolicy(sizePolicy17);
        lblPA.setMinimumSize(new QSize(30, 0));
        lblPA.setMaximumSize(new QSize(30, 16777215));
        lblPA.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;\n"+
"");
        lblPA.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(lblPA, 0, 1, 1, 1);

        imgCC = new QLabel(grpCaract);
        imgCC.setObjectName("imgCC");
        QSizePolicy sizePolicy18 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy18.setHorizontalStretch((byte)0);
        sizePolicy18.setVerticalStretch((byte)0);
        sizePolicy18.setHeightForWidth(imgCC.sizePolicy().hasHeightForWidth());
        imgCC.setSizePolicy(sizePolicy18);
        imgCC.setMinimumSize(new QSize(20, 20));
        imgCC.setMaximumSize(new QSize(20, 20));
        imgCC.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border-color: rgb(0, 0, 0);Z");
        imgCC.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/icoCritique.png")));
        imgCC.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(imgCC, 1, 0, 1, 1);

        lblCC = new QLabel(grpCaract);
        lblCC.setObjectName("lblCC");
        QSizePolicy sizePolicy19 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Preferred);
        sizePolicy19.setHorizontalStretch((byte)0);
        sizePolicy19.setVerticalStretch((byte)0);
        sizePolicy19.setHeightForWidth(lblCC.sizePolicy().hasHeightForWidth());
        lblCC.setSizePolicy(sizePolicy19);
        lblCC.setMinimumSize(new QSize(30, 0));
        lblCC.setMaximumSize(new QSize(30, 16777215));
        lblCC.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;\n"+
"");
        lblCC.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(lblCC, 1, 1, 1, 1);

        imgEC = new QLabel(grpCaract);
        imgEC.setObjectName("imgEC");
        QSizePolicy sizePolicy20 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy20.setHorizontalStretch((byte)0);
        sizePolicy20.setVerticalStretch((byte)0);
        sizePolicy20.setHeightForWidth(imgEC.sizePolicy().hasHeightForWidth());
        imgEC.setSizePolicy(sizePolicy20);
        imgEC.setMinimumSize(new QSize(20, 20));
        imgEC.setMaximumSize(new QSize(20, 20));
        imgEC.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border-color: rgb(0, 0, 0);Z");
        imgEC.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/icoEchec.png")));
        imgEC.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(imgEC, 2, 0, 1, 1);

        lblEC = new QLabel(grpCaract);
        lblEC.setObjectName("lblEC");
        QSizePolicy sizePolicy21 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Preferred);
        sizePolicy21.setHorizontalStretch((byte)0);
        sizePolicy21.setVerticalStretch((byte)0);
        sizePolicy21.setHeightForWidth(lblEC.sizePolicy().hasHeightForWidth());
        lblEC.setSizePolicy(sizePolicy21);
        lblEC.setMinimumSize(new QSize(30, 0));
        lblEC.setMaximumSize(new QSize(30, 16777215));
        lblEC.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;\n"+
"");
        lblEC.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(lblEC, 2, 1, 1, 1);


        layoutFenetre.addWidget(grpCaract, 0, 9, 5, 1);

        btnFermer = new QPushButton(UIDetails);
        btnFermer.setObjectName("btnFermer");
        btnFermer.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        btnFermer.setIcon(new QIcon(new QPixmap("classpath:org/JDofusCalc/ressources/images/exit.png")));
        btnFermer.setIconSize(new QSize(24, 24));

        layoutFenetre.addWidget(btnFermer, 12, 9, 1, 1);

        lblInfo = new QLabel(UIDetails);
        lblInfo.setObjectName("lblInfo");
        QSizePolicy sizePolicy22 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy22.setHorizontalStretch((byte)0);
        sizePolicy22.setVerticalStretch((byte)0);
        sizePolicy22.setHeightForWidth(lblInfo.sizePolicy().hasHeightForWidth());
        lblInfo.setSizePolicy(sizePolicy22);

        layoutFenetre.addWidget(lblInfo, 12, 0, 1, 2);

        btnExporter = new QPushButton(UIDetails);
        btnExporter.setObjectName("btnExporter");
        btnExporter.setEnabled(false);
        QSizePolicy sizePolicy23 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy23.setHorizontalStretch((byte)0);
        sizePolicy23.setVerticalStretch((byte)0);
        sizePolicy23.setHeightForWidth(btnExporter.sizePolicy().hasHeightForWidth());
        btnExporter.setSizePolicy(sizePolicy23);
        btnExporter.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        btnExporter.setIcon(new QIcon(new QPixmap("classpath:org/JDofusCalc/ressources/images/up.png")));
        btnExporter.setIconSize(new QSize(24, 24));

        layoutFenetre.addWidget(btnExporter, 12, 6, 1, 3);

        retranslateUi(UIDetails);

        UIDetails.connectSlotsByName();
    } // setupUi

    void retranslateUi(QWidget UIDetails)
    {
        UIDetails.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("UIDetails", "D\u00e9tails des d\u00e9g\u00e2ts inflig\u00e9s", null));
        lblType.setText(com.trolltech.qt.core.QCoreApplication.translate("UIDetails", "Type arme", null));
        lblNom.setText(com.trolltech.qt.core.QCoreApplication.translate("UIDetails", "Nom", null));
        lblDegatsNeutre.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIDetails", "D\u00e9g\u00e2ts Neutre inflig\u00e9s", null));
        lblDegatsNeutre.setText("");
        lblDegatsTerre.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIDetails", "D\u00e9g\u00e2ts Terre inflig\u00e9s", null));
        lblDegatsTerre.setText("");
        lblDegatsFeu.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIDetails", "D\u00e9g\u00e2ts Feu inflig\u00e9s", null));
        lblDegatsFeu.setText("");
        lblDegatsEau.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIDetails", "D\u00e9g\u00e2ts Eau inflig\u00e9s", null));
        lblDegatsEau.setText("");
        lblDegatsAir.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIDetails", "D\u00e9g\u00e2ts Air inflig\u00e9s", null));
        lblDegatsAir.setText("");
        lblDegatsVdV.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIDetails", "Vie vol\u00e9e", null));
        lblDegatsVdV.setText("");
        lblSoins.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIDetails", "Soins g\u00e9n\u00e9r\u00e9s", null));
        lblSoins.setText("");
        lblMoyCoup.setText(com.trolltech.qt.core.QCoreApplication.translate("UIDetails", "Moyenne par coup :", null));
        lblMoyCoupNeutre.setText("");
        lblMoyCoupTerre.setText("");
        lblMoyCoupFeu.setText("");
        lblMoyCoupEau.setText("");
        lblMoyCoupAir.setText("");
        lblMoyCoupVdv.setText("");
        lblMoyCoupSoins.setText("");
        lblCoupNorm.setText(com.trolltech.qt.core.QCoreApplication.translate("UIDetails", "Moyenne par coup normal :", null));
        lblMoyCoupNormNeutre.setText("");
        lblMoyCoupNormTerre.setText("");
        lblMoyCoupNormFeu.setText("");
        lblMoyCoupNormEau.setText("");
        lblMoyCoupNormAir.setText("");
        lblMoyCoupNormVdv.setText("");
        lblMoyCoupNormSoins.setText("");
        lblMoyCoupCC.setText(com.trolltech.qt.core.QCoreApplication.translate("UIDetails", "Moyenne par coup critique :", null));
        lblMoyCoupCCNeutre.setText("");
        lblMoyCoupCCTerre.setText("");
        lblMoyCoupCCFeu.setText("");
        lblMoyCoupCCEau.setText("");
        lblMoyCoupCCAir.setText("");
        lblMoyCoupCCVdv.setText("");
        lblMoyCoupCCSoins.setText("");
        lblMoyTour.setText(com.trolltech.qt.core.QCoreApplication.translate("UIDetails", "Moyenne par tour * :", null));
        lblMoyTourNeutre.setText("");
        lblMoyTourTerre.setText("");
        lblMoyTourFeu.setText("");
        lblMoyTourEau.setText("");
        lblMoyTourAir.setText("");
        lblMoyTourVdv.setText("");
        lblMoyTourSoins.setText("");
        lblMinTour.setText(com.trolltech.qt.core.QCoreApplication.translate("UIDetails", "Minimum par tour :", null));
        lblMinTourNeutre.setText("");
        lblMinTourTerre.setText("");
        lblMinTourFeu.setText("");
        lblMinTourEau.setText("");
        lblMinTourAir.setText("");
        lblMinTourVdv.setText("");
        lblMinTourSoins.setText("");
        lblMaxTour.setText(com.trolltech.qt.core.QCoreApplication.translate("UIDetails", "Maximum par tour :", null));
        lblMaxTourNeutre.setText("");
        lblMaxTourTerre.setText("");
        lblMaxTourFeu.setText("");
        lblMaxTourEau.setText("");
        lblMaxTourAir.setText("");
        lblMaxTourVdv.setText("");
        lblMaxTourSoins.setText("");
        grpCaract.setTitle(com.trolltech.qt.core.QCoreApplication.translate("UIDetails", "Caract\u00e9ristiques", null));
        imgPA.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIDetails", "Co\u00fbt d'uilisation", null));
        imgPA.setText("");
        lblPA.setText(com.trolltech.qt.core.QCoreApplication.translate("UIDetails", "0", null));
        imgCC.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIDetails", "Probabilit\u00e9 de coups critiques", null));
        imgCC.setText("");
        lblCC.setText(com.trolltech.qt.core.QCoreApplication.translate("UIDetails", "1/X", null));
        imgEC.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIDetails", "Probabilit\u00e9 d'\u00e9checs critiques", null));
        lblEC.setText(com.trolltech.qt.core.QCoreApplication.translate("UIDetails", "1/X", null));
        btnFermer.setText(com.trolltech.qt.core.QCoreApplication.translate("UIDetails", "Fermer", null));
        lblInfo.setText(com.trolltech.qt.core.QCoreApplication.translate("UIDetails", "* : Inclus les \u00e9checs et coups critiques", null));
        btnExporter.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIDetails", "[WIP]", null));
        btnExporter.setText(com.trolltech.qt.core.QCoreApplication.translate("UIDetails", "Exporter", null));
    } // retranslateUi

}

