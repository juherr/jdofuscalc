/********************************************************************************
** Form generated from reading ui file 'UICalcCoupsCritiques.jui'
**
** Created: mer. 24. juin 12:04:04 2009
**      by: Qt User Interface Compiler version 4.5.0
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

package org.JDofusCalc.vues.Qt.designer;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class UICalcCoupsCritiques implements com.trolltech.qt.QUiForm<QWidget>
{
    public QGridLayout gridLayout;
    public QGroupBox grpTauxCC;
    public QGridLayout gridLayout_2;
    public QLabel lblCCTauxBaseCC;
    public QSpinBox sbCCTauxBase;
    public QLabel lblBCConusCC;
    public QSpinBox sbCCBonusCC;
    public QPushButton btnCCgetBonusCC;
    public QLabel lblCCAgi;
    public QSpinBox sbCCAgi;
    public QPushButton btnCCgetAgi;
    public QLabel lblCCTaux;
    public QLabel lblCCResultats;
    public QGroupBox grpAgi;
    public QGridLayout gridLayout_3;
    public QLabel lblAgiTauxBaseCC;
    public QSpinBox sbAgiTauxBaseCC;
    public QLabel lblAgiBonusCC;
    public QSpinBox sbAgiBonusCC;
    public QPushButton btnAgiGetBonusCC;
    public QLabel lblAgiTauxFinalCC;
    public QSpinBox sbAgiTauxFinalCC;
    public QLabel lblAgi;
    public QLabel lblAgiResultats;
    public QGroupBox grpGrille;
    public QGridLayout gridLayout_4;
    public QTableWidget grille;
    public QLabel label;
    public QLabel label_2;
    public QPushButton btnFermer;
    public QSpacerItem horizontalSpacer;

    public UICalcCoupsCritiques() { super(); }

    public void setupUi(QWidget UICalcCoupsCritiques)
    {
        UICalcCoupsCritiques.setObjectName("UICalcCoupsCritiques");
        UICalcCoupsCritiques.setWindowModality(com.trolltech.qt.core.Qt.WindowModality.WindowModal);
        UICalcCoupsCritiques.resize(new QSize(377, 404).expandedTo(UICalcCoupsCritiques.minimumSizeHint()));
        gridLayout = new QGridLayout(UICalcCoupsCritiques);
        gridLayout.setObjectName("gridLayout");
        grpTauxCC = new QGroupBox(UICalcCoupsCritiques);
        grpTauxCC.setObjectName("grpTauxCC");
        gridLayout_2 = new QGridLayout(grpTauxCC);
        gridLayout_2.setObjectName("gridLayout_2");
        lblCCTauxBaseCC = new QLabel(grpTauxCC);
        lblCCTauxBaseCC.setObjectName("lblCCTauxBaseCC");
        QSizePolicy sizePolicy = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy.setHorizontalStretch((byte)0);
        sizePolicy.setVerticalStretch((byte)0);
        sizePolicy.setHeightForWidth(lblCCTauxBaseCC.sizePolicy().hasHeightForWidth());
        lblCCTauxBaseCC.setSizePolicy(sizePolicy);

        gridLayout_2.addWidget(lblCCTauxBaseCC, 0, 0, 1, 1);

        sbCCTauxBase = new QSpinBox(grpTauxCC);
        sbCCTauxBase.setObjectName("sbCCTauxBase");
        QSizePolicy sizePolicy1 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy1.setHorizontalStretch((byte)0);
        sizePolicy1.setVerticalStretch((byte)0);
        sizePolicy1.setHeightForWidth(sbCCTauxBase.sizePolicy().hasHeightForWidth());
        sbCCTauxBase.setSizePolicy(sizePolicy1);
        sbCCTauxBase.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.WheelFocus);
        sbCCTauxBase.setMinimum(2);
        sbCCTauxBase.setMaximum(100);
        sbCCTauxBase.setValue(50);

        gridLayout_2.addWidget(sbCCTauxBase, 0, 1, 1, 2);

        lblBCConusCC = new QLabel(grpTauxCC);
        lblBCConusCC.setObjectName("lblBCConusCC");
        QSizePolicy sizePolicy2 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy2.setHorizontalStretch((byte)0);
        sizePolicy2.setVerticalStretch((byte)0);
        sizePolicy2.setHeightForWidth(lblBCConusCC.sizePolicy().hasHeightForWidth());
        lblBCConusCC.setSizePolicy(sizePolicy2);

        gridLayout_2.addWidget(lblBCConusCC, 1, 0, 1, 1);

        sbCCBonusCC = new QSpinBox(grpTauxCC);
        sbCCBonusCC.setObjectName("sbCCBonusCC");
        QSizePolicy sizePolicy3 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy3.setHorizontalStretch((byte)0);
        sizePolicy3.setVerticalStretch((byte)0);
        sizePolicy3.setHeightForWidth(sbCCBonusCC.sizePolicy().hasHeightForWidth());
        sbCCBonusCC.setSizePolicy(sizePolicy3);
        sbCCBonusCC.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.WheelFocus);
        sbCCBonusCC.setMaximum(100);

        gridLayout_2.addWidget(sbCCBonusCC, 1, 1, 1, 1);

        btnCCgetBonusCC = new QPushButton(grpTauxCC);
        btnCCgetBonusCC.setObjectName("btnCCgetBonusCC");
        QSizePolicy sizePolicy4 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy4.setHorizontalStretch((byte)0);
        sizePolicy4.setVerticalStretch((byte)0);
        sizePolicy4.setHeightForWidth(btnCCgetBonusCC.sizePolicy().hasHeightForWidth());
        btnCCgetBonusCC.setSizePolicy(sizePolicy4);
        btnCCgetBonusCC.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        btnCCgetBonusCC.setIcon(new QIcon(new QPixmap("classpath:org/JDofusCalc/ressources/images/up.png")));
        btnCCgetBonusCC.setIconSize(new QSize(10, 10));

        gridLayout_2.addWidget(btnCCgetBonusCC, 1, 2, 1, 1);

        lblCCAgi = new QLabel(grpTauxCC);
        lblCCAgi.setObjectName("lblCCAgi");
        QSizePolicy sizePolicy5 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy5.setHorizontalStretch((byte)0);
        sizePolicy5.setVerticalStretch((byte)0);
        sizePolicy5.setHeightForWidth(lblCCAgi.sizePolicy().hasHeightForWidth());
        lblCCAgi.setSizePolicy(sizePolicy5);

        gridLayout_2.addWidget(lblCCAgi, 2, 0, 1, 1);

        sbCCAgi = new QSpinBox(grpTauxCC);
        sbCCAgi.setObjectName("sbCCAgi");
        QSizePolicy sizePolicy6 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy6.setHorizontalStretch((byte)0);
        sizePolicy6.setVerticalStretch((byte)0);
        sizePolicy6.setHeightForWidth(sbCCAgi.sizePolicy().hasHeightForWidth());
        sbCCAgi.setSizePolicy(sizePolicy6);
        sbCCAgi.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.WheelFocus);
        sbCCAgi.setMaximum(5000);

        gridLayout_2.addWidget(sbCCAgi, 2, 1, 1, 1);

        btnCCgetAgi = new QPushButton(grpTauxCC);
        btnCCgetAgi.setObjectName("btnCCgetAgi");
        QSizePolicy sizePolicy7 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy7.setHorizontalStretch((byte)0);
        sizePolicy7.setVerticalStretch((byte)0);
        sizePolicy7.setHeightForWidth(btnCCgetAgi.sizePolicy().hasHeightForWidth());
        btnCCgetAgi.setSizePolicy(sizePolicy7);
        btnCCgetAgi.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        btnCCgetAgi.setIcon(new QIcon(new QPixmap("classpath:org/JDofusCalc/ressources/images/up.png")));
        btnCCgetAgi.setIconSize(new QSize(10, 10));

        gridLayout_2.addWidget(btnCCgetAgi, 2, 2, 1, 1);

        lblCCTaux = new QLabel(grpTauxCC);
        lblCCTaux.setObjectName("lblCCTaux");
        QSizePolicy sizePolicy8 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy8.setHorizontalStretch((byte)0);
        sizePolicy8.setVerticalStretch((byte)0);
        sizePolicy8.setHeightForWidth(lblCCTaux.sizePolicy().hasHeightForWidth());
        lblCCTaux.setSizePolicy(sizePolicy8);

        gridLayout_2.addWidget(lblCCTaux, 3, 0, 1, 1);

        lblCCResultats = new QLabel(grpTauxCC);
        lblCCResultats.setObjectName("lblCCResultats");
        lblCCResultats.setMinimumSize(new QSize(0, 20));
        lblCCResultats.setMaximumSize(new QSize(16777215, 20));
        lblCCResultats.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblCCResultats.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(lblCCResultats, 3, 1, 1, 2);


        gridLayout.addWidget(grpTauxCC, 0, 0, 1, 2);

        grpAgi = new QGroupBox(UICalcCoupsCritiques);
        grpAgi.setObjectName("grpAgi");
        gridLayout_3 = new QGridLayout(grpAgi);
        gridLayout_3.setObjectName("gridLayout_3");
        lblAgiTauxBaseCC = new QLabel(grpAgi);
        lblAgiTauxBaseCC.setObjectName("lblAgiTauxBaseCC");
        QSizePolicy sizePolicy9 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy9.setHorizontalStretch((byte)0);
        sizePolicy9.setVerticalStretch((byte)0);
        sizePolicy9.setHeightForWidth(lblAgiTauxBaseCC.sizePolicy().hasHeightForWidth());
        lblAgiTauxBaseCC.setSizePolicy(sizePolicy9);

        gridLayout_3.addWidget(lblAgiTauxBaseCC, 0, 0, 1, 1);

        sbAgiTauxBaseCC = new QSpinBox(grpAgi);
        sbAgiTauxBaseCC.setObjectName("sbAgiTauxBaseCC");
        QSizePolicy sizePolicy10 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy10.setHorizontalStretch((byte)0);
        sizePolicy10.setVerticalStretch((byte)0);
        sizePolicy10.setHeightForWidth(sbAgiTauxBaseCC.sizePolicy().hasHeightForWidth());
        sbAgiTauxBaseCC.setSizePolicy(sizePolicy10);
        sbAgiTauxBaseCC.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.WheelFocus);
        sbAgiTauxBaseCC.setMinimum(2);
        sbAgiTauxBaseCC.setMaximum(100);
        sbAgiTauxBaseCC.setValue(50);

        gridLayout_3.addWidget(sbAgiTauxBaseCC, 0, 1, 1, 2);

        lblAgiBonusCC = new QLabel(grpAgi);
        lblAgiBonusCC.setObjectName("lblAgiBonusCC");
        QSizePolicy sizePolicy11 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy11.setHorizontalStretch((byte)0);
        sizePolicy11.setVerticalStretch((byte)0);
        sizePolicy11.setHeightForWidth(lblAgiBonusCC.sizePolicy().hasHeightForWidth());
        lblAgiBonusCC.setSizePolicy(sizePolicy11);

        gridLayout_3.addWidget(lblAgiBonusCC, 1, 0, 1, 1);

        sbAgiBonusCC = new QSpinBox(grpAgi);
        sbAgiBonusCC.setObjectName("sbAgiBonusCC");
        QSizePolicy sizePolicy12 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy12.setHorizontalStretch((byte)0);
        sizePolicy12.setVerticalStretch((byte)0);
        sizePolicy12.setHeightForWidth(sbAgiBonusCC.sizePolicy().hasHeightForWidth());
        sbAgiBonusCC.setSizePolicy(sizePolicy12);
        sbAgiBonusCC.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.WheelFocus);
        sbAgiBonusCC.setMaximum(100);

        gridLayout_3.addWidget(sbAgiBonusCC, 1, 1, 1, 1);

        btnAgiGetBonusCC = new QPushButton(grpAgi);
        btnAgiGetBonusCC.setObjectName("btnAgiGetBonusCC");
        QSizePolicy sizePolicy13 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy13.setHorizontalStretch((byte)0);
        sizePolicy13.setVerticalStretch((byte)0);
        sizePolicy13.setHeightForWidth(btnAgiGetBonusCC.sizePolicy().hasHeightForWidth());
        btnAgiGetBonusCC.setSizePolicy(sizePolicy13);
        btnAgiGetBonusCC.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        btnAgiGetBonusCC.setIcon(new QIcon(new QPixmap("classpath:org/JDofusCalc/ressources/images/up.png")));
        btnAgiGetBonusCC.setIconSize(new QSize(10, 10));

        gridLayout_3.addWidget(btnAgiGetBonusCC, 1, 2, 1, 1);

        lblAgiTauxFinalCC = new QLabel(grpAgi);
        lblAgiTauxFinalCC.setObjectName("lblAgiTauxFinalCC");
        QSizePolicy sizePolicy14 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy14.setHorizontalStretch((byte)0);
        sizePolicy14.setVerticalStretch((byte)0);
        sizePolicy14.setHeightForWidth(lblAgiTauxFinalCC.sizePolicy().hasHeightForWidth());
        lblAgiTauxFinalCC.setSizePolicy(sizePolicy14);

        gridLayout_3.addWidget(lblAgiTauxFinalCC, 2, 0, 1, 1);

        sbAgiTauxFinalCC = new QSpinBox(grpAgi);
        sbAgiTauxFinalCC.setObjectName("sbAgiTauxFinalCC");
        QSizePolicy sizePolicy15 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy15.setHorizontalStretch((byte)0);
        sizePolicy15.setVerticalStretch((byte)0);
        sizePolicy15.setHeightForWidth(sbAgiTauxFinalCC.sizePolicy().hasHeightForWidth());
        sbAgiTauxFinalCC.setSizePolicy(sizePolicy15);
        sbAgiTauxFinalCC.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.WheelFocus);
        sbAgiTauxFinalCC.setMinimum(2);
        sbAgiTauxFinalCC.setMaximum(100);
        sbAgiTauxFinalCC.setValue(50);

        gridLayout_3.addWidget(sbAgiTauxFinalCC, 2, 1, 1, 2);

        lblAgi = new QLabel(grpAgi);
        lblAgi.setObjectName("lblAgi");
        QSizePolicy sizePolicy16 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy16.setHorizontalStretch((byte)0);
        sizePolicy16.setVerticalStretch((byte)0);
        sizePolicy16.setHeightForWidth(lblAgi.sizePolicy().hasHeightForWidth());
        lblAgi.setSizePolicy(sizePolicy16);

        gridLayout_3.addWidget(lblAgi, 3, 0, 1, 1);

        lblAgiResultats = new QLabel(grpAgi);
        lblAgiResultats.setObjectName("lblAgiResultats");
        lblAgiResultats.setMinimumSize(new QSize(0, 20));
        lblAgiResultats.setMaximumSize(new QSize(16777215, 20));
        lblAgiResultats.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        lblAgiResultats.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_3.addWidget(lblAgiResultats, 3, 1, 1, 2);


        gridLayout.addWidget(grpAgi, 0, 2, 1, 2);

        grpGrille = new QGroupBox(UICalcCoupsCritiques);
        grpGrille.setObjectName("grpGrille");
        gridLayout_4 = new QGridLayout(grpGrille);
        gridLayout_4.setObjectName("gridLayout_4");
        grille = new QTableWidget(grpGrille);
        grille.setObjectName("grille");
        grille.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.WheelFocus);
        grille.setEditTriggers(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.createQFlags(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.NoEditTriggers));

        gridLayout_4.addWidget(grille, 1, 0, 1, 2);

        label = new QLabel(grpGrille);
        label.setObjectName("label");
        QSizePolicy sizePolicy17 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy17.setHorizontalStretch((byte)0);
        sizePolicy17.setVerticalStretch((byte)0);
        sizePolicy17.setHeightForWidth(label.sizePolicy().hasHeightForWidth());
        label.setSizePolicy(sizePolicy17);

        gridLayout_4.addWidget(label, 0, 0, 1, 1);

        label_2 = new QLabel(grpGrille);
        label_2.setObjectName("label_2");
        QSizePolicy sizePolicy18 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy18.setHorizontalStretch((byte)0);
        sizePolicy18.setVerticalStretch((byte)0);
        sizePolicy18.setHeightForWidth(label_2.sizePolicy().hasHeightForWidth());
        label_2.setSizePolicy(sizePolicy18);
        label_2.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_4.addWidget(label_2, 0, 1, 1, 1);


        gridLayout.addWidget(grpGrille, 1, 0, 1, 4);

        btnFermer = new QPushButton(UICalcCoupsCritiques);
        btnFermer.setObjectName("btnFermer");
        QSizePolicy sizePolicy19 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy19.setHorizontalStretch((byte)0);
        sizePolicy19.setVerticalStretch((byte)0);
        sizePolicy19.setHeightForWidth(btnFermer.sizePolicy().hasHeightForWidth());
        btnFermer.setSizePolicy(sizePolicy19);
        btnFermer.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        btnFermer.setIcon(new QIcon(new QPixmap("classpath:org/JDofusCalc/ressources/images/exit.png")));
        btnFermer.setIconSize(new QSize(24, 24));

        gridLayout.addWidget(btnFermer, 2, 3, 1, 1);

        horizontalSpacer = new QSpacerItem(0, 0, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        gridLayout.addItem(horizontalSpacer, 2, 2, 1, 1);

        retranslateUi(UICalcCoupsCritiques);

        UICalcCoupsCritiques.connectSlotsByName();
    } // setupUi

    void retranslateUi(QWidget UICalcCoupsCritiques)
    {
        UICalcCoupsCritiques.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "Calculateur de coups critiques", null));
        grpTauxCC.setTitle(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "Taux de CC", null));
        lblCCTauxBaseCC.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "Taux de base :", null));
        sbCCTauxBase.setPrefix(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "1/", null));
        lblBCConusCC.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "Bonus :", null));
        btnCCgetBonusCC.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "Obtenir les donn\u00e9es du personnage charg\u00e9", null));
        btnCCgetBonusCC.setText("");
        lblCCAgi.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "Agilit\u00e9 :", null));
        btnCCgetAgi.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "Obtenir les donn\u00e9es du personnage charg\u00e9", null));
        btnCCgetAgi.setText("");
        lblCCTaux.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "Taux de CC :", null));
        lblCCResultats.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "50", null));
        grpAgi.setTitle(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "Agilit\u00e9 n\u00e9cessaire", null));
        lblAgiTauxBaseCC.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "Taux de base :", null));
        sbAgiTauxBaseCC.setPrefix(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "1/", null));
        lblAgiBonusCC.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "Bonus :", null));
        btnAgiGetBonusCC.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "Obtenir les donn\u00e9es du personnage charg\u00e9", null));
        btnAgiGetBonusCC.setText("");
        lblAgiTauxFinalCC.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "Taux final :", null));
        sbAgiTauxFinalCC.setSuffix("");
        sbAgiTauxFinalCC.setPrefix(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "1/", null));
        lblAgi.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "Agilit\u00e9 necessaire :", null));
        lblAgiResultats.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "0", null));
        grpGrille.setTitle(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "Grille", null));
        grille.clear();
        grille.setColumnCount(10);

        QTableWidgetItem __colItem = new QTableWidgetItem();
        __colItem.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "5", null));
        grille.setHorizontalHeaderItem(0, __colItem);

        QTableWidgetItem __colItem1 = new QTableWidgetItem();
        __colItem1.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "10", null));
        grille.setHorizontalHeaderItem(1, __colItem1);

        QTableWidgetItem __colItem2 = new QTableWidgetItem();
        __colItem2.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "15", null));
        grille.setHorizontalHeaderItem(2, __colItem2);

        QTableWidgetItem __colItem3 = new QTableWidgetItem();
        __colItem3.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "20", null));
        grille.setHorizontalHeaderItem(3, __colItem3);

        QTableWidgetItem __colItem4 = new QTableWidgetItem();
        __colItem4.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "25", null));
        grille.setHorizontalHeaderItem(4, __colItem4);

        QTableWidgetItem __colItem5 = new QTableWidgetItem();
        __colItem5.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "30", null));
        grille.setHorizontalHeaderItem(5, __colItem5);

        QTableWidgetItem __colItem6 = new QTableWidgetItem();
        __colItem6.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "35", null));
        grille.setHorizontalHeaderItem(6, __colItem6);

        QTableWidgetItem __colItem7 = new QTableWidgetItem();
        __colItem7.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "40", null));
        grille.setHorizontalHeaderItem(7, __colItem7);

        QTableWidgetItem __colItem8 = new QTableWidgetItem();
        __colItem8.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "45", null));
        grille.setHorizontalHeaderItem(8, __colItem8);

        QTableWidgetItem __colItem9 = new QTableWidgetItem();
        __colItem9.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "50", null));
        grille.setHorizontalHeaderItem(9, __colItem9);
        grille.setRowCount(50);

        QTableWidgetItem __rowItem = new QTableWidgetItem();
        __rowItem.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "10", null));
        grille.setVerticalHeaderItem(0, __rowItem);

        QTableWidgetItem __rowItem1 = new QTableWidgetItem();
        __rowItem1.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "20", null));
        grille.setVerticalHeaderItem(1, __rowItem1);

        QTableWidgetItem __rowItem2 = new QTableWidgetItem();
        __rowItem2.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "30", null));
        grille.setVerticalHeaderItem(2, __rowItem2);

        QTableWidgetItem __rowItem3 = new QTableWidgetItem();
        __rowItem3.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "40", null));
        grille.setVerticalHeaderItem(3, __rowItem3);

        QTableWidgetItem __rowItem4 = new QTableWidgetItem();
        __rowItem4.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "50", null));
        grille.setVerticalHeaderItem(4, __rowItem4);

        QTableWidgetItem __rowItem5 = new QTableWidgetItem();
        __rowItem5.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "60", null));
        grille.setVerticalHeaderItem(5, __rowItem5);

        QTableWidgetItem __rowItem6 = new QTableWidgetItem();
        __rowItem6.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "70", null));
        grille.setVerticalHeaderItem(6, __rowItem6);

        QTableWidgetItem __rowItem7 = new QTableWidgetItem();
        __rowItem7.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "80", null));
        grille.setVerticalHeaderItem(7, __rowItem7);

        QTableWidgetItem __rowItem8 = new QTableWidgetItem();
        __rowItem8.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "90", null));
        grille.setVerticalHeaderItem(8, __rowItem8);

        QTableWidgetItem __rowItem9 = new QTableWidgetItem();
        __rowItem9.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "100", null));
        grille.setVerticalHeaderItem(9, __rowItem9);

        QTableWidgetItem __rowItem10 = new QTableWidgetItem();
        __rowItem10.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "110", null));
        grille.setVerticalHeaderItem(10, __rowItem10);

        QTableWidgetItem __rowItem11 = new QTableWidgetItem();
        __rowItem11.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "120", null));
        grille.setVerticalHeaderItem(11, __rowItem11);

        QTableWidgetItem __rowItem12 = new QTableWidgetItem();
        __rowItem12.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "130", null));
        grille.setVerticalHeaderItem(12, __rowItem12);

        QTableWidgetItem __rowItem13 = new QTableWidgetItem();
        __rowItem13.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "140", null));
        grille.setVerticalHeaderItem(13, __rowItem13);

        QTableWidgetItem __rowItem14 = new QTableWidgetItem();
        __rowItem14.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "150", null));
        grille.setVerticalHeaderItem(14, __rowItem14);

        QTableWidgetItem __rowItem15 = new QTableWidgetItem();
        __rowItem15.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "160", null));
        grille.setVerticalHeaderItem(15, __rowItem15);

        QTableWidgetItem __rowItem16 = new QTableWidgetItem();
        __rowItem16.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "170", null));
        grille.setVerticalHeaderItem(16, __rowItem16);

        QTableWidgetItem __rowItem17 = new QTableWidgetItem();
        __rowItem17.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "180", null));
        grille.setVerticalHeaderItem(17, __rowItem17);

        QTableWidgetItem __rowItem18 = new QTableWidgetItem();
        __rowItem18.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "190", null));
        grille.setVerticalHeaderItem(18, __rowItem18);

        QTableWidgetItem __rowItem19 = new QTableWidgetItem();
        __rowItem19.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "200", null));
        grille.setVerticalHeaderItem(19, __rowItem19);

        QTableWidgetItem __rowItem20 = new QTableWidgetItem();
        __rowItem20.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "210", null));
        grille.setVerticalHeaderItem(20, __rowItem20);

        QTableWidgetItem __rowItem21 = new QTableWidgetItem();
        __rowItem21.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "220", null));
        grille.setVerticalHeaderItem(21, __rowItem21);

        QTableWidgetItem __rowItem22 = new QTableWidgetItem();
        __rowItem22.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "230", null));
        grille.setVerticalHeaderItem(22, __rowItem22);

        QTableWidgetItem __rowItem23 = new QTableWidgetItem();
        __rowItem23.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "240", null));
        grille.setVerticalHeaderItem(23, __rowItem23);

        QTableWidgetItem __rowItem24 = new QTableWidgetItem();
        __rowItem24.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "250", null));
        grille.setVerticalHeaderItem(24, __rowItem24);

        QTableWidgetItem __rowItem25 = new QTableWidgetItem();
        __rowItem25.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "260", null));
        grille.setVerticalHeaderItem(25, __rowItem25);

        QTableWidgetItem __rowItem26 = new QTableWidgetItem();
        __rowItem26.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "270", null));
        grille.setVerticalHeaderItem(26, __rowItem26);

        QTableWidgetItem __rowItem27 = new QTableWidgetItem();
        __rowItem27.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "280", null));
        grille.setVerticalHeaderItem(27, __rowItem27);

        QTableWidgetItem __rowItem28 = new QTableWidgetItem();
        __rowItem28.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "290", null));
        grille.setVerticalHeaderItem(28, __rowItem28);

        QTableWidgetItem __rowItem29 = new QTableWidgetItem();
        __rowItem29.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "300", null));
        grille.setVerticalHeaderItem(29, __rowItem29);

        QTableWidgetItem __rowItem30 = new QTableWidgetItem();
        __rowItem30.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "310", null));
        grille.setVerticalHeaderItem(30, __rowItem30);

        QTableWidgetItem __rowItem31 = new QTableWidgetItem();
        __rowItem31.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "320", null));
        grille.setVerticalHeaderItem(31, __rowItem31);

        QTableWidgetItem __rowItem32 = new QTableWidgetItem();
        __rowItem32.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "330", null));
        grille.setVerticalHeaderItem(32, __rowItem32);

        QTableWidgetItem __rowItem33 = new QTableWidgetItem();
        __rowItem33.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "340", null));
        grille.setVerticalHeaderItem(33, __rowItem33);

        QTableWidgetItem __rowItem34 = new QTableWidgetItem();
        __rowItem34.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "350", null));
        grille.setVerticalHeaderItem(34, __rowItem34);

        QTableWidgetItem __rowItem35 = new QTableWidgetItem();
        __rowItem35.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "360", null));
        grille.setVerticalHeaderItem(35, __rowItem35);

        QTableWidgetItem __rowItem36 = new QTableWidgetItem();
        __rowItem36.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "370", null));
        grille.setVerticalHeaderItem(36, __rowItem36);

        QTableWidgetItem __rowItem37 = new QTableWidgetItem();
        __rowItem37.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "380", null));
        grille.setVerticalHeaderItem(37, __rowItem37);

        QTableWidgetItem __rowItem38 = new QTableWidgetItem();
        __rowItem38.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "390", null));
        grille.setVerticalHeaderItem(38, __rowItem38);

        QTableWidgetItem __rowItem39 = new QTableWidgetItem();
        __rowItem39.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "400", null));
        grille.setVerticalHeaderItem(39, __rowItem39);

        QTableWidgetItem __rowItem40 = new QTableWidgetItem();
        __rowItem40.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "410", null));
        grille.setVerticalHeaderItem(40, __rowItem40);

        QTableWidgetItem __rowItem41 = new QTableWidgetItem();
        __rowItem41.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "420", null));
        grille.setVerticalHeaderItem(41, __rowItem41);

        QTableWidgetItem __rowItem42 = new QTableWidgetItem();
        __rowItem42.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "430", null));
        grille.setVerticalHeaderItem(42, __rowItem42);

        QTableWidgetItem __rowItem43 = new QTableWidgetItem();
        __rowItem43.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "440", null));
        grille.setVerticalHeaderItem(43, __rowItem43);

        QTableWidgetItem __rowItem44 = new QTableWidgetItem();
        __rowItem44.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "450", null));
        grille.setVerticalHeaderItem(44, __rowItem44);

        QTableWidgetItem __rowItem45 = new QTableWidgetItem();
        __rowItem45.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "460", null));
        grille.setVerticalHeaderItem(45, __rowItem45);

        QTableWidgetItem __rowItem46 = new QTableWidgetItem();
        __rowItem46.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "470", null));
        grille.setVerticalHeaderItem(46, __rowItem46);

        QTableWidgetItem __rowItem47 = new QTableWidgetItem();
        __rowItem47.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "480", null));
        grille.setVerticalHeaderItem(47, __rowItem47);

        QTableWidgetItem __rowItem48 = new QTableWidgetItem();
        __rowItem48.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "490", null));
        grille.setVerticalHeaderItem(48, __rowItem48);

        QTableWidgetItem __rowItem49 = new QTableWidgetItem();
        __rowItem49.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "500", null));
        grille.setVerticalHeaderItem(49, __rowItem49);
        label.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "Agilit\u00e9", null));
        label_2.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "Taux de coups critiques net (1/X)", null));
        btnFermer.setText(com.trolltech.qt.core.QCoreApplication.translate("UICalcCoupsCritiques", "Fermer", null));
    } // retranslateUi

}

