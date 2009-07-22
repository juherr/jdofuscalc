/********************************************************************************
** Form generated from reading ui file 'UIGroupeObjets.jui'
**
** Created: mer. 22. juil. 00:13:48 2009
**      by: Qt User Interface Compiler version 4.5.0
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

package org.JDofusCalc.vues.Qt.designer;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class UIGroupeObjets implements com.trolltech.qt.QUiForm<QWidget>
{
    public QGridLayout gridLayout;
    public QListWidget listeGroupeObjets;
    public QPushButton btnSauvegarder;
    public QPushButton btnCharger;
    public QPushButton btnRenommer;
    public QPushButton btnSupprimer;
    public QPushButton btnFermer;
    public QGroupBox groupBox;
    public QGridLayout gridLayout_2;
    public QLabel lblNomGroupe;
    public QLineEdit txtNomGroupe;
    public QLabel lblListeObjets;
    public QListWidget listeObjets;
    public QPushButton btnDeselectionnerTout;
    public QSpacerItem verticalSpacer;
    public QPushButton btnSelectionnerTout;

    public UIGroupeObjets() { super(); }

    public void setupUi(QWidget UIGroupeObjets)
    {
        UIGroupeObjets.setObjectName("UIGroupeObjets");
        UIGroupeObjets.resize(new QSize(295, 372).expandedTo(UIGroupeObjets.minimumSizeHint()));
        gridLayout = new QGridLayout(UIGroupeObjets);
        gridLayout.setObjectName("gridLayout");
        listeGroupeObjets = new QListWidget(UIGroupeObjets);
        listeGroupeObjets.setObjectName("listeGroupeObjets");
        listeGroupeObjets.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.WheelFocus);

        gridLayout.addWidget(listeGroupeObjets, 0, 0, 5, 1);

        btnSauvegarder = new QPushButton(UIGroupeObjets);
        btnSauvegarder.setObjectName("btnSauvegarder");
        btnSauvegarder.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        btnSauvegarder.setIcon(new QIcon(new QPixmap("classpath:org/JDofusCalc/ressources/images/filesave.png")));
        btnSauvegarder.setIconSize(new QSize(24, 24));

        gridLayout.addWidget(btnSauvegarder, 0, 1, 1, 1);

        btnCharger = new QPushButton(UIGroupeObjets);
        btnCharger.setObjectName("btnCharger");
        btnCharger.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        btnCharger.setIcon(new QIcon(new QPixmap("classpath:org/JDofusCalc/ressources/images/fileopen.png")));
        btnCharger.setIconSize(new QSize(24, 24));

        gridLayout.addWidget(btnCharger, 1, 1, 1, 1);

        btnRenommer = new QPushButton(UIGroupeObjets);
        btnRenommer.setObjectName("btnRenommer");
        btnRenommer.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        btnRenommer.setIcon(new QIcon(new QPixmap("classpath:org/JDofusCalc/ressources/images/editclear.png")));
        btnRenommer.setIconSize(new QSize(24, 24));

        gridLayout.addWidget(btnRenommer, 2, 1, 1, 1);

        btnSupprimer = new QPushButton(UIGroupeObjets);
        btnSupprimer.setObjectName("btnSupprimer");
        btnSupprimer.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        btnSupprimer.setIcon(new QIcon(new QPixmap("classpath:org/JDofusCalc/ressources/images/edit_remove.png")));
        btnSupprimer.setIconSize(new QSize(24, 24));

        gridLayout.addWidget(btnSupprimer, 3, 1, 1, 1);

        btnFermer = new QPushButton(UIGroupeObjets);
        btnFermer.setObjectName("btnFermer");
        btnFermer.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        btnFermer.setIcon(new QIcon(new QPixmap("classpath:org/JDofusCalc/ressources/images/exit.png")));
        btnFermer.setIconSize(new QSize(24, 24));

        gridLayout.addWidget(btnFermer, 4, 1, 1, 1);

        groupBox = new QGroupBox(UIGroupeObjets);
        groupBox.setObjectName("groupBox");
        QSizePolicy sizePolicy = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);
        sizePolicy.setHorizontalStretch((byte)0);
        sizePolicy.setVerticalStretch((byte)0);
        sizePolicy.setHeightForWidth(groupBox.sizePolicy().hasHeightForWidth());
        groupBox.setSizePolicy(sizePolicy);
        gridLayout_2 = new QGridLayout(groupBox);
        gridLayout_2.setObjectName("gridLayout_2");
        lblNomGroupe = new QLabel(groupBox);
        lblNomGroupe.setObjectName("lblNomGroupe");

        gridLayout_2.addWidget(lblNomGroupe, 0, 0, 1, 1);

        txtNomGroupe = new QLineEdit(groupBox);
        txtNomGroupe.setObjectName("txtNomGroupe");
        txtNomGroupe.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);

        gridLayout_2.addWidget(txtNomGroupe, 0, 1, 1, 1);

        lblListeObjets = new QLabel(groupBox);
        lblListeObjets.setObjectName("lblListeObjets");
        QSizePolicy sizePolicy1 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy1.setHorizontalStretch((byte)0);
        sizePolicy1.setVerticalStretch((byte)0);
        sizePolicy1.setHeightForWidth(lblListeObjets.sizePolicy().hasHeightForWidth());
        lblListeObjets.setSizePolicy(sizePolicy1);

        gridLayout_2.addWidget(lblListeObjets, 1, 0, 1, 1);

        listeObjets = new QListWidget(groupBox);
        listeObjets.setObjectName("listeObjets");
        listeObjets.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.WheelFocus);
        listeObjets.setEditTriggers(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.createQFlags(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.NoEditTriggers));
        listeObjets.setSelectionMode(com.trolltech.qt.gui.QAbstractItemView.SelectionMode.MultiSelection);

        gridLayout_2.addWidget(listeObjets, 1, 1, 4, 1);

        btnDeselectionnerTout = new QPushButton(groupBox);
        btnDeselectionnerTout.setObjectName("btnDeselectionnerTout");
        btnDeselectionnerTout.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);

        gridLayout_2.addWidget(btnDeselectionnerTout, 4, 0, 1, 1);

        verticalSpacer = new QSpacerItem(0, 0, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);

        gridLayout_2.addItem(verticalSpacer, 2, 0, 1, 1);

        btnSelectionnerTout = new QPushButton(groupBox);
        btnSelectionnerTout.setObjectName("btnSelectionnerTout");
        btnSelectionnerTout.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);

        gridLayout_2.addWidget(btnSelectionnerTout, 3, 0, 1, 1);


        gridLayout.addWidget(groupBox, 5, 0, 1, 2);

        retranslateUi(UIGroupeObjets);

        UIGroupeObjets.connectSlotsByName();
    } // setupUi

    void retranslateUi(QWidget UIGroupeObjets)
    {
        UIGroupeObjets.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("UIGroupeObjets", "Groupe d'Objets", null));
        btnSauvegarder.setText(com.trolltech.qt.core.QCoreApplication.translate("UIGroupeObjets", "Sauvegarder", null));
        btnCharger.setText(com.trolltech.qt.core.QCoreApplication.translate("UIGroupeObjets", "Charger", null));
        btnRenommer.setText(com.trolltech.qt.core.QCoreApplication.translate("UIGroupeObjets", "Renommer", null));
        btnSupprimer.setText(com.trolltech.qt.core.QCoreApplication.translate("UIGroupeObjets", "Supprmer", null));
        btnFermer.setText(com.trolltech.qt.core.QCoreApplication.translate("UIGroupeObjets", "Fermer", null));
        groupBox.setTitle(com.trolltech.qt.core.QCoreApplication.translate("UIGroupeObjets", "D\u00e9tails", null));
        lblNomGroupe.setText(com.trolltech.qt.core.QCoreApplication.translate("UIGroupeObjets", "Nom du groupe :", null));
        lblListeObjets.setText(com.trolltech.qt.core.QCoreApplication.translate("UIGroupeObjets", "Liste des objets :", null));
        btnDeselectionnerTout.setText(com.trolltech.qt.core.QCoreApplication.translate("UIGroupeObjets", "D\u00e9selectionner tout", null));
        btnSelectionnerTout.setText(com.trolltech.qt.core.QCoreApplication.translate("UIGroupeObjets", "S\u00e9lectionner tout", null));
    } // retranslateUi

}

