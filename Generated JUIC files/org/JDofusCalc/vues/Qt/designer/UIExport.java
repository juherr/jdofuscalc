/********************************************************************************
** Form generated from reading ui file 'UIExport.jui'
**
** Created: mer. 22. juil. 00:13:47 2009
**      by: Qt User Interface Compiler version 4.5.0
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

package org.JDofusCalc.vues.Qt.designer;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class UIExport implements com.trolltech.qt.QUiForm<QWidget>
{
    public QGridLayout gridLayout;
    public QGroupBox grpPerso;
    public QGridLayout gridLayout_2;
    public QPushButton btnSelectAllPerso;
    public QPushButton btnDeselectAllPerso;
    public QSpacerItem verticalSpacer;
    public QTableWidget listePerso;
    public QLabel lblNbPersoSelect;
    public QPushButton btnExport;
    public QPushButton btnFermer;
    public QSpacerItem horizontalSpacer;
    public QGroupBox grpObjets;
    public QGridLayout gridLayout_3;
    public QPushButton btnSelectAllObjets;
    public QPushButton btnDeselectAllObjets;
    public QLabel lblNbObjetsSelect;
    public QSpacerItem verticalSpacer_2;
    public QTabWidget ongletsObjets;
    public QWidget ongletEquip;
    public QGridLayout gridLayout_4;
    public QTableWidget listeEquip;
    public QPushButton btnSelectAllEquip;
    public QPushButton btnDeselectAllEquip;
    public QSpacerItem verticalSpacer_3;
    public QWidget ongletArmes;
    public QGridLayout gridLayout_5;
    public QTableWidget listeArmes;
    public QPushButton btnSelectAllArmes;
    public QPushButton btnDeselectAllArmes;
    public QSpacerItem verticalSpacer_4;
    public QWidget ongletAnimaux;
    public QGridLayout gridLayout_6;
    public QTableWidget listeFamiliers;
    public QPushButton btnSelectAllFamiliers;
    public QPushButton btnDeselectAllFamilier;
    public QSpacerItem verticalSpacer_5;
    public QFrame line;
    public QTableWidget listeMontures;
    public QPushButton btnSelectAllMontures;
    public QPushButton btnDeselectAllMontures;
    public QSpacerItem verticalSpacer_7;
    public QLabel lblMontures;
    public QLabel lblFamiliers;
    public QWidget ongletDofus;
    public QGridLayout gridLayout_7;
    public QTableWidget listeDofus;
    public QPushButton btnSelectAllDofus;
    public QPushButton btnDeselectAllDofus;
    public QSpacerItem verticalSpacer_6;

    public UIExport() { super(); }

    public void setupUi(QWidget UIExport)
    {
        UIExport.setObjectName("UIExport");
        UIExport.setWindowModality(com.trolltech.qt.core.Qt.WindowModality.WindowModal);
        UIExport.resize(new QSize(706, 586).expandedTo(UIExport.minimumSizeHint()));
        gridLayout = new QGridLayout(UIExport);
        gridLayout.setObjectName("gridLayout");
        grpPerso = new QGroupBox(UIExport);
        grpPerso.setObjectName("grpPerso");
        QSizePolicy sizePolicy = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);
        sizePolicy.setHorizontalStretch((byte)0);
        sizePolicy.setVerticalStretch((byte)0);
        sizePolicy.setHeightForWidth(grpPerso.sizePolicy().hasHeightForWidth());
        grpPerso.setSizePolicy(sizePolicy);
        grpPerso.setCheckable(true);
        gridLayout_2 = new QGridLayout(grpPerso);
        gridLayout_2.setObjectName("gridLayout_2");
        btnSelectAllPerso = new QPushButton(grpPerso);
        btnSelectAllPerso.setObjectName("btnSelectAllPerso");

        gridLayout_2.addWidget(btnSelectAllPerso, 0, 1, 1, 1);

        btnDeselectAllPerso = new QPushButton(grpPerso);
        btnDeselectAllPerso.setObjectName("btnDeselectAllPerso");

        gridLayout_2.addWidget(btnDeselectAllPerso, 1, 1, 1, 1);

        verticalSpacer = new QSpacerItem(20, 60, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.MinimumExpanding);

        gridLayout_2.addItem(verticalSpacer, 2, 1, 1, 1);

        listePerso = new QTableWidget(grpPerso);
        listePerso.setObjectName("listePerso");
        listePerso.setEditTriggers(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.createQFlags(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.NoEditTriggers));
        listePerso.setSelectionMode(com.trolltech.qt.gui.QAbstractItemView.SelectionMode.NoSelection);

        gridLayout_2.addWidget(listePerso, 0, 0, 3, 1);

        lblNbPersoSelect = new QLabel(grpPerso);
        lblNbPersoSelect.setObjectName("lblNbPersoSelect");

        gridLayout_2.addWidget(lblNbPersoSelect, 3, 0, 1, 1);


        gridLayout.addWidget(grpPerso, 0, 0, 1, 3);

        btnExport = new QPushButton(UIExport);
        btnExport.setObjectName("btnExport");
        btnExport.setIcon(new QIcon(new QPixmap("classpath:org/JDofusCalc/ressources/images/up.png")));
        btnExport.setIconSize(new QSize(24, 24));

        gridLayout.addWidget(btnExport, 2, 1, 1, 1);

        btnFermer = new QPushButton(UIExport);
        btnFermer.setObjectName("btnFermer");
        btnFermer.setIcon(new QIcon(new QPixmap("classpath:org/JDofusCalc/ressources/images/exit.png")));
        btnFermer.setIconSize(new QSize(24, 24));

        gridLayout.addWidget(btnFermer, 2, 2, 1, 1);

        horizontalSpacer = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        gridLayout.addItem(horizontalSpacer, 2, 0, 1, 1);

        grpObjets = new QGroupBox(UIExport);
        grpObjets.setObjectName("grpObjets");
        QSizePolicy sizePolicy1 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);
        sizePolicy1.setHorizontalStretch((byte)0);
        sizePolicy1.setVerticalStretch((byte)0);
        sizePolicy1.setHeightForWidth(grpObjets.sizePolicy().hasHeightForWidth());
        grpObjets.setSizePolicy(sizePolicy1);
        grpObjets.setCheckable(true);
        gridLayout_3 = new QGridLayout(grpObjets);
        gridLayout_3.setObjectName("gridLayout_3");
        btnSelectAllObjets = new QPushButton(grpObjets);
        btnSelectAllObjets.setObjectName("btnSelectAllObjets");

        gridLayout_3.addWidget(btnSelectAllObjets, 0, 1, 1, 1);

        btnDeselectAllObjets = new QPushButton(grpObjets);
        btnDeselectAllObjets.setObjectName("btnDeselectAllObjets");

        gridLayout_3.addWidget(btnDeselectAllObjets, 1, 1, 1, 1);

        lblNbObjetsSelect = new QLabel(grpObjets);
        lblNbObjetsSelect.setObjectName("lblNbObjetsSelect");

        gridLayout_3.addWidget(lblNbObjetsSelect, 3, 0, 1, 1);

        verticalSpacer_2 = new QSpacerItem(20, 40, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);

        gridLayout_3.addItem(verticalSpacer_2, 2, 1, 1, 1);

        ongletsObjets = new QTabWidget(grpObjets);
        ongletsObjets.setObjectName("ongletsObjets");
        ongletEquip = new QWidget();
        ongletEquip.setObjectName("ongletEquip");
        gridLayout_4 = new QGridLayout(ongletEquip);
        gridLayout_4.setObjectName("gridLayout_4");
        listeEquip = new QTableWidget(ongletEquip);
        listeEquip.setObjectName("listeEquip");

        gridLayout_4.addWidget(listeEquip, 0, 0, 3, 1);

        btnSelectAllEquip = new QPushButton(ongletEquip);
        btnSelectAllEquip.setObjectName("btnSelectAllEquip");

        gridLayout_4.addWidget(btnSelectAllEquip, 0, 1, 1, 1);

        btnDeselectAllEquip = new QPushButton(ongletEquip);
        btnDeselectAllEquip.setObjectName("btnDeselectAllEquip");

        gridLayout_4.addWidget(btnDeselectAllEquip, 1, 1, 1, 1);

        verticalSpacer_3 = new QSpacerItem(20, 97, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);

        gridLayout_4.addItem(verticalSpacer_3, 2, 1, 1, 1);

        ongletsObjets.addTab(ongletEquip, com.trolltech.qt.core.QCoreApplication.translate("UIExport", "Equipements (0)", null));
        ongletArmes = new QWidget();
        ongletArmes.setObjectName("ongletArmes");
        gridLayout_5 = new QGridLayout(ongletArmes);
        gridLayout_5.setObjectName("gridLayout_5");
        listeArmes = new QTableWidget(ongletArmes);
        listeArmes.setObjectName("listeArmes");

        gridLayout_5.addWidget(listeArmes, 0, 0, 3, 1);

        btnSelectAllArmes = new QPushButton(ongletArmes);
        btnSelectAllArmes.setObjectName("btnSelectAllArmes");

        gridLayout_5.addWidget(btnSelectAllArmes, 0, 1, 1, 1);

        btnDeselectAllArmes = new QPushButton(ongletArmes);
        btnDeselectAllArmes.setObjectName("btnDeselectAllArmes");

        gridLayout_5.addWidget(btnDeselectAllArmes, 1, 1, 1, 1);

        verticalSpacer_4 = new QSpacerItem(20, 96, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);

        gridLayout_5.addItem(verticalSpacer_4, 2, 1, 1, 1);

        ongletsObjets.addTab(ongletArmes, com.trolltech.qt.core.QCoreApplication.translate("UIExport", "Armes (0)", null));
        ongletAnimaux = new QWidget();
        ongletAnimaux.setObjectName("ongletAnimaux");
        gridLayout_6 = new QGridLayout(ongletAnimaux);
        gridLayout_6.setObjectName("gridLayout_6");
        listeFamiliers = new QTableWidget(ongletAnimaux);
        listeFamiliers.setObjectName("listeFamiliers");

        gridLayout_6.addWidget(listeFamiliers, 1, 0, 3, 1);

        btnSelectAllFamiliers = new QPushButton(ongletAnimaux);
        btnSelectAllFamiliers.setObjectName("btnSelectAllFamiliers");

        gridLayout_6.addWidget(btnSelectAllFamiliers, 1, 1, 1, 1);

        btnDeselectAllFamilier = new QPushButton(ongletAnimaux);
        btnDeselectAllFamilier.setObjectName("btnDeselectAllFamilier");

        gridLayout_6.addWidget(btnDeselectAllFamilier, 2, 1, 1, 1);

        verticalSpacer_5 = new QSpacerItem(99, 38, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);

        gridLayout_6.addItem(verticalSpacer_5, 3, 1, 1, 1);

        line = new QFrame(ongletAnimaux);
        line.setObjectName("line");
        line.setFrameShape(QFrame.Shape.HLine);
        line.setFrameShadow(QFrame.Shadow.Sunken);

        gridLayout_6.addWidget(line, 4, 0, 1, 2);

        listeMontures = new QTableWidget(ongletAnimaux);
        listeMontures.setObjectName("listeMontures");

        gridLayout_6.addWidget(listeMontures, 6, 0, 3, 1);

        btnSelectAllMontures = new QPushButton(ongletAnimaux);
        btnSelectAllMontures.setObjectName("btnSelectAllMontures");

        gridLayout_6.addWidget(btnSelectAllMontures, 6, 1, 1, 1);

        btnDeselectAllMontures = new QPushButton(ongletAnimaux);
        btnDeselectAllMontures.setObjectName("btnDeselectAllMontures");

        gridLayout_6.addWidget(btnDeselectAllMontures, 7, 1, 1, 1);

        verticalSpacer_7 = new QSpacerItem(99, 38, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);

        gridLayout_6.addItem(verticalSpacer_7, 8, 1, 1, 1);

        lblMontures = new QLabel(ongletAnimaux);
        lblMontures.setObjectName("lblMontures");

        gridLayout_6.addWidget(lblMontures, 5, 0, 1, 1);

        lblFamiliers = new QLabel(ongletAnimaux);
        lblFamiliers.setObjectName("lblFamiliers");

        gridLayout_6.addWidget(lblFamiliers, 0, 0, 1, 1);

        ongletsObjets.addTab(ongletAnimaux, com.trolltech.qt.core.QCoreApplication.translate("UIExport", "Animaux (0)", null));
        ongletDofus = new QWidget();
        ongletDofus.setObjectName("ongletDofus");
        gridLayout_7 = new QGridLayout(ongletDofus);
        gridLayout_7.setObjectName("gridLayout_7");
        listeDofus = new QTableWidget(ongletDofus);
        listeDofus.setObjectName("listeDofus");

        gridLayout_7.addWidget(listeDofus, 0, 0, 3, 1);

        btnSelectAllDofus = new QPushButton(ongletDofus);
        btnSelectAllDofus.setObjectName("btnSelectAllDofus");

        gridLayout_7.addWidget(btnSelectAllDofus, 0, 1, 1, 1);

        btnDeselectAllDofus = new QPushButton(ongletDofus);
        btnDeselectAllDofus.setObjectName("btnDeselectAllDofus");

        gridLayout_7.addWidget(btnDeselectAllDofus, 1, 1, 1, 1);

        verticalSpacer_6 = new QSpacerItem(20, 96, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);

        gridLayout_7.addItem(verticalSpacer_6, 2, 1, 1, 1);

        ongletsObjets.addTab(ongletDofus, com.trolltech.qt.core.QCoreApplication.translate("UIExport", "Dofus (0)", null));

        gridLayout_3.addWidget(ongletsObjets, 0, 0, 3, 1);


        gridLayout.addWidget(grpObjets, 1, 0, 1, 3);

        retranslateUi(UIExport);

        ongletsObjets.setCurrentIndex(2);


        UIExport.connectSlotsByName();
    } // setupUi

    void retranslateUi(QWidget UIExport)
    {
        UIExport.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("UIExport", "Exporter", null));
        grpPerso.setTitle(com.trolltech.qt.core.QCoreApplication.translate("UIExport", "Personnages", null));
        btnSelectAllPerso.setText(com.trolltech.qt.core.QCoreApplication.translate("UIExport", "S\u00e9lectionner tout", null));
        btnDeselectAllPerso.setText(com.trolltech.qt.core.QCoreApplication.translate("UIExport", "D\u00e9s\u00e9lectionner tout", null));
        listePerso.clear();
        listePerso.setColumnCount(4);

        QTableWidgetItem __colItem = new QTableWidgetItem();
        __colItem.setText("");
        listePerso.setHorizontalHeaderItem(0, __colItem);

        QTableWidgetItem __colItem1 = new QTableWidgetItem();
        __colItem1.setText(com.trolltech.qt.core.QCoreApplication.translate("UIExport", "Nom de la sauvegarde", null));
        listePerso.setHorizontalHeaderItem(1, __colItem1);

        QTableWidgetItem __colItem2 = new QTableWidgetItem();
        __colItem2.setText(com.trolltech.qt.core.QCoreApplication.translate("UIExport", "Nom du personnage", null));
        listePerso.setHorizontalHeaderItem(2, __colItem2);

        QTableWidgetItem __colItem3 = new QTableWidgetItem();
        __colItem3.setText(com.trolltech.qt.core.QCoreApplication.translate("UIExport", "Niveau", null));
        listePerso.setHorizontalHeaderItem(3, __colItem3);
        listePerso.setRowCount(0);
        lblNbPersoSelect.setText(com.trolltech.qt.core.QCoreApplication.translate("UIExport", "0 personnage(s) s\u00e9lectionn\u00e9(s)", null));
        btnExport.setText(com.trolltech.qt.core.QCoreApplication.translate("UIExport", "Exporter", null));
        btnFermer.setText(com.trolltech.qt.core.QCoreApplication.translate("UIExport", "Fermer", null));
        grpObjets.setTitle(com.trolltech.qt.core.QCoreApplication.translate("UIExport", "Objets", null));
        btnSelectAllObjets.setText(com.trolltech.qt.core.QCoreApplication.translate("UIExport", "S\u00e9lectionner tout", null));
        btnDeselectAllObjets.setText(com.trolltech.qt.core.QCoreApplication.translate("UIExport", "D\u00e9s\u00e9lectionner tout", null));
        lblNbObjetsSelect.setText(com.trolltech.qt.core.QCoreApplication.translate("UIExport", "0 objet(s) s\u00e9lectionn\u00e9(s)", null));
        listeEquip.clear();
        listeEquip.setColumnCount(4);

        QTableWidgetItem __colItem4 = new QTableWidgetItem();
        __colItem4.setText("");
        listeEquip.setHorizontalHeaderItem(0, __colItem4);

        QTableWidgetItem __colItem5 = new QTableWidgetItem();
        __colItem5.setText(com.trolltech.qt.core.QCoreApplication.translate("UIExport", "Nom de l'\u00e9quipement", null));
        listeEquip.setHorizontalHeaderItem(1, __colItem5);

        QTableWidgetItem __colItem6 = new QTableWidgetItem();
        __colItem6.setText(com.trolltech.qt.core.QCoreApplication.translate("UIExport", "Type", null));
        listeEquip.setHorizontalHeaderItem(2, __colItem6);

        QTableWidgetItem __colItem7 = new QTableWidgetItem();
        __colItem7.setText(com.trolltech.qt.core.QCoreApplication.translate("UIExport", "Niveau", null));
        listeEquip.setHorizontalHeaderItem(3, __colItem7);
        listeEquip.setRowCount(0);
        btnSelectAllEquip.setText(com.trolltech.qt.core.QCoreApplication.translate("UIExport", "S\u00e9lectionner tout", null));
        btnDeselectAllEquip.setText(com.trolltech.qt.core.QCoreApplication.translate("UIExport", "D\u00e9s\u00e9lectionner tout", null));
        ongletsObjets.setTabText(ongletsObjets.indexOf(ongletEquip), com.trolltech.qt.core.QCoreApplication.translate("UIExport", "Equipements (0)", null));
        listeArmes.clear();
        listeArmes.setColumnCount(4);

        QTableWidgetItem __colItem8 = new QTableWidgetItem();
        __colItem8.setText("");
        listeArmes.setHorizontalHeaderItem(0, __colItem8);

        QTableWidgetItem __colItem9 = new QTableWidgetItem();
        __colItem9.setText(com.trolltech.qt.core.QCoreApplication.translate("UIExport", "Nom de l'arme", null));
        listeArmes.setHorizontalHeaderItem(1, __colItem9);

        QTableWidgetItem __colItem10 = new QTableWidgetItem();
        __colItem10.setText(com.trolltech.qt.core.QCoreApplication.translate("UIExport", "Type", null));
        listeArmes.setHorizontalHeaderItem(2, __colItem10);

        QTableWidgetItem __colItem11 = new QTableWidgetItem();
        __colItem11.setText(com.trolltech.qt.core.QCoreApplication.translate("UIExport", "Niveau", null));
        listeArmes.setHorizontalHeaderItem(3, __colItem11);
        listeArmes.setRowCount(0);
        btnSelectAllArmes.setText(com.trolltech.qt.core.QCoreApplication.translate("UIExport", "S\u00e9lectionner tout", null));
        btnDeselectAllArmes.setText(com.trolltech.qt.core.QCoreApplication.translate("UIExport", "D\u00e9s\u00e9lectionner tout", null));
        ongletsObjets.setTabText(ongletsObjets.indexOf(ongletArmes), com.trolltech.qt.core.QCoreApplication.translate("UIExport", "Armes (0)", null));
        listeFamiliers.clear();
        listeFamiliers.setColumnCount(3);

        QTableWidgetItem __colItem12 = new QTableWidgetItem();
        __colItem12.setText("");
        listeFamiliers.setHorizontalHeaderItem(0, __colItem12);

        QTableWidgetItem __colItem13 = new QTableWidgetItem();
        __colItem13.setText(com.trolltech.qt.core.QCoreApplication.translate("UIExport", "Nom du familier", null));
        listeFamiliers.setHorizontalHeaderItem(1, __colItem13);

        QTableWidgetItem __colItem14 = new QTableWidgetItem();
        __colItem14.setText(com.trolltech.qt.core.QCoreApplication.translate("UIExport", "Niveau requis", null));
        listeFamiliers.setHorizontalHeaderItem(2, __colItem14);
        listeFamiliers.setRowCount(0);
        btnSelectAllFamiliers.setText(com.trolltech.qt.core.QCoreApplication.translate("UIExport", "S\u00e9lectionner tout", null));
        btnDeselectAllFamilier.setText(com.trolltech.qt.core.QCoreApplication.translate("UIExport", "D\u00e9s\u00e9lectionner tout", null));
        listeMontures.clear();
        listeMontures.setColumnCount(4);

        QTableWidgetItem __colItem15 = new QTableWidgetItem();
        __colItem15.setText("");
        listeMontures.setHorizontalHeaderItem(0, __colItem15);

        QTableWidgetItem __colItem16 = new QTableWidgetItem();
        __colItem16.setText(com.trolltech.qt.core.QCoreApplication.translate("UIExport", "Nom de la monture", null));
        listeMontures.setHorizontalHeaderItem(1, __colItem16);

        QTableWidgetItem __colItem17 = new QTableWidgetItem();
        __colItem17.setText(com.trolltech.qt.core.QCoreApplication.translate("UIExport", "Race", null));
        listeMontures.setHorizontalHeaderItem(2, __colItem17);

        QTableWidgetItem __colItem18 = new QTableWidgetItem();
        __colItem18.setText(com.trolltech.qt.core.QCoreApplication.translate("UIExport", "Niveau", null));
        listeMontures.setHorizontalHeaderItem(3, __colItem18);
        listeMontures.setRowCount(0);
        btnSelectAllMontures.setText(com.trolltech.qt.core.QCoreApplication.translate("UIExport", "S\u00e9lectionner tout", null));
        btnDeselectAllMontures.setText(com.trolltech.qt.core.QCoreApplication.translate("UIExport", "D\u00e9s\u00e9lectionner tout", null));
        lblMontures.setText(com.trolltech.qt.core.QCoreApplication.translate("UIExport", "Montures :", null));
        lblFamiliers.setText(com.trolltech.qt.core.QCoreApplication.translate("UIExport", "Familiers :", null));
        ongletsObjets.setTabText(ongletsObjets.indexOf(ongletAnimaux), com.trolltech.qt.core.QCoreApplication.translate("UIExport", "Animaux (0)", null));
        listeDofus.clear();
        listeDofus.setColumnCount(4);

        QTableWidgetItem __colItem19 = new QTableWidgetItem();
        __colItem19.setText("");
        listeDofus.setHorizontalHeaderItem(0, __colItem19);

        QTableWidgetItem __colItem20 = new QTableWidgetItem();
        __colItem20.setText(com.trolltech.qt.core.QCoreApplication.translate("UIExport", "Nom du Dofus", null));
        listeDofus.setHorizontalHeaderItem(1, __colItem20);

        QTableWidgetItem __colItem21 = new QTableWidgetItem();
        __colItem21.setText(com.trolltech.qt.core.QCoreApplication.translate("UIExport", "Type", null));
        listeDofus.setHorizontalHeaderItem(2, __colItem21);

        QTableWidgetItem __colItem22 = new QTableWidgetItem();
        __colItem22.setText(com.trolltech.qt.core.QCoreApplication.translate("UIExport", "Niveau", null));
        listeDofus.setHorizontalHeaderItem(3, __colItem22);
        listeDofus.setRowCount(0);
        btnSelectAllDofus.setText(com.trolltech.qt.core.QCoreApplication.translate("UIExport", "S\u00e9lectionner tout", null));
        btnDeselectAllDofus.setText(com.trolltech.qt.core.QCoreApplication.translate("UIExport", "D\u00e9s\u00e9lectionner tout", null));
        ongletsObjets.setTabText(ongletsObjets.indexOf(ongletDofus), com.trolltech.qt.core.QCoreApplication.translate("UIExport", "Dofus (0)", null));
    } // retranslateUi

}

