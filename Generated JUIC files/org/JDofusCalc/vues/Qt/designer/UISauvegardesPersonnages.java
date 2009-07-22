/********************************************************************************
** Form generated from reading ui file 'UISauvegardesPersonnages.jui'
**
** Created: mer. 22. juil. 00:15:01 2009
**      by: Qt User Interface Compiler version 4.5.0
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

package org.JDofusCalc.vues.Qt.designer;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class UISauvegardesPersonnages implements com.trolltech.qt.QUiForm<QWidget>
{
    public QGridLayout gridLayout;
    public QListWidget listeSauvegardes;
    public QPushButton btnCharger;
    public QPushButton btnSupp;
    public QPushButton btnRenommer;
    public QPushButton btnFermer;
    public QSpacerItem verticalSpacer;
    public QGroupBox grpInfo;
    public QGridLayout gridLayout_2;
    public QLabel label1;
    public QLabel lblNomPerso;
    public QLabel label2;
    public QLabel lblNiveauPerso;
    public QLabel lblNomSauvegarde;
    public QLineEdit txtNomSauvegarde;
    public QSpacerItem verticalSpacer_2;
    public QPushButton btnSauvegarder;

    public UISauvegardesPersonnages() { super(); }

    public void setupUi(QWidget UISauvegardesPersonnages)
    {
        UISauvegardesPersonnages.setObjectName("UISauvegardesPersonnages");
        UISauvegardesPersonnages.setWindowModality(com.trolltech.qt.core.Qt.WindowModality.WindowModal);
        UISauvegardesPersonnages.resize(new QSize(371, 369).expandedTo(UISauvegardesPersonnages.minimumSizeHint()));
        gridLayout = new QGridLayout(UISauvegardesPersonnages);
        gridLayout.setObjectName("gridLayout");
        listeSauvegardes = new QListWidget(UISauvegardesPersonnages);
        listeSauvegardes.setObjectName("listeSauvegardes");
        listeSauvegardes.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.WheelFocus);
        listeSauvegardes.setEditTriggers(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.createQFlags(com.trolltech.qt.gui.QAbstractItemView.EditTrigger.NoEditTriggers));
        listeSauvegardes.setSelectionRectVisible(true);

        gridLayout.addWidget(listeSauvegardes, 0, 0, 5, 1);

        btnCharger = new QPushButton(UISauvegardesPersonnages);
        btnCharger.setObjectName("btnCharger");
        btnCharger.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        btnCharger.setIcon(new QIcon(new QPixmap("classpath:org/JDofusCalc/ressources/images/fileopen.png")));
        btnCharger.setIconSize(new QSize(24, 24));

        gridLayout.addWidget(btnCharger, 0, 1, 1, 1);

        btnSupp = new QPushButton(UISauvegardesPersonnages);
        btnSupp.setObjectName("btnSupp");
        btnSupp.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        btnSupp.setIcon(new QIcon(new QPixmap("classpath:org/JDofusCalc/ressources/images/edit_remove.png")));
        btnSupp.setIconSize(new QSize(24, 24));

        gridLayout.addWidget(btnSupp, 2, 1, 1, 1);

        btnRenommer = new QPushButton(UISauvegardesPersonnages);
        btnRenommer.setObjectName("btnRenommer");
        btnRenommer.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        btnRenommer.setIcon(new QIcon(new QPixmap("classpath:org/JDofusCalc/ressources/images/editclear.png")));
        btnRenommer.setIconSize(new QSize(24, 24));

        gridLayout.addWidget(btnRenommer, 3, 1, 1, 1);

        btnFermer = new QPushButton(UISauvegardesPersonnages);
        btnFermer.setObjectName("btnFermer");
        btnFermer.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        btnFermer.setIcon(new QIcon(new QPixmap("classpath:org/JDofusCalc/ressources/images/exit.png")));
        btnFermer.setIconSize(new QSize(24, 24));

        gridLayout.addWidget(btnFermer, 6, 1, 1, 1);

        verticalSpacer = new QSpacerItem(0, 0, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);

        gridLayout.addItem(verticalSpacer, 4, 1, 1, 1);

        grpInfo = new QGroupBox(UISauvegardesPersonnages);
        grpInfo.setObjectName("grpInfo");
        QSizePolicy sizePolicy = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy.setHorizontalStretch((byte)0);
        sizePolicy.setVerticalStretch((byte)0);
        sizePolicy.setHeightForWidth(grpInfo.sizePolicy().hasHeightForWidth());
        grpInfo.setSizePolicy(sizePolicy);
        gridLayout_2 = new QGridLayout(grpInfo);
        gridLayout_2.setObjectName("gridLayout_2");
        label1 = new QLabel(grpInfo);
        label1.setObjectName("label1");
        QSizePolicy sizePolicy1 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy1.setHorizontalStretch((byte)0);
        sizePolicy1.setVerticalStretch((byte)0);
        sizePolicy1.setHeightForWidth(label1.sizePolicy().hasHeightForWidth());
        label1.setSizePolicy(sizePolicy1);

        gridLayout_2.addWidget(label1, 1, 0, 1, 1);

        lblNomPerso = new QLabel(grpInfo);
        lblNomPerso.setObjectName("lblNomPerso");

        gridLayout_2.addWidget(lblNomPerso, 1, 1, 1, 1);

        label2 = new QLabel(grpInfo);
        label2.setObjectName("label2");
        QSizePolicy sizePolicy2 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy2.setHorizontalStretch((byte)0);
        sizePolicy2.setVerticalStretch((byte)0);
        sizePolicy2.setHeightForWidth(label2.sizePolicy().hasHeightForWidth());
        label2.setSizePolicy(sizePolicy2);

        gridLayout_2.addWidget(label2, 2, 0, 1, 1);

        lblNiveauPerso = new QLabel(grpInfo);
        lblNiveauPerso.setObjectName("lblNiveauPerso");

        gridLayout_2.addWidget(lblNiveauPerso, 2, 1, 1, 1);

        lblNomSauvegarde = new QLabel(grpInfo);
        lblNomSauvegarde.setObjectName("lblNomSauvegarde");

        gridLayout_2.addWidget(lblNomSauvegarde, 0, 0, 1, 1);

        txtNomSauvegarde = new QLineEdit(grpInfo);
        txtNomSauvegarde.setObjectName("txtNomSauvegarde");
        txtNomSauvegarde.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);

        gridLayout_2.addWidget(txtNomSauvegarde, 0, 1, 1, 1);


        gridLayout.addWidget(grpInfo, 5, 0, 2, 1);

        verticalSpacer_2 = new QSpacerItem(0, 0, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        gridLayout.addItem(verticalSpacer_2, 5, 1, 1, 1);

        btnSauvegarder = new QPushButton(UISauvegardesPersonnages);
        btnSauvegarder.setObjectName("btnSauvegarder");
        btnSauvegarder.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        btnSauvegarder.setIcon(new QIcon(new QPixmap("classpath:org/JDofusCalc/ressources/images/filesave.png")));
        btnSauvegarder.setIconSize(new QSize(24, 24));

        gridLayout.addWidget(btnSauvegarder, 1, 1, 1, 1);

        QWidget.setTabOrder(listeSauvegardes, btnCharger);
        QWidget.setTabOrder(btnCharger, btnSupp);
        QWidget.setTabOrder(btnSupp, btnRenommer);
        QWidget.setTabOrder(btnRenommer, btnFermer);
        retranslateUi(UISauvegardesPersonnages);

        UISauvegardesPersonnages.connectSlotsByName();
    } // setupUi

    void retranslateUi(QWidget UISauvegardesPersonnages)
    {
        UISauvegardesPersonnages.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("UISauvegardesPersonnages", "Charger une sauvegarde", null));
        btnCharger.setText(com.trolltech.qt.core.QCoreApplication.translate("UISauvegardesPersonnages", "Charger", null));
        btnSupp.setText(com.trolltech.qt.core.QCoreApplication.translate("UISauvegardesPersonnages", "Supprimer", null));
        btnRenommer.setText(com.trolltech.qt.core.QCoreApplication.translate("UISauvegardesPersonnages", "Renommer", null));
        btnFermer.setText(com.trolltech.qt.core.QCoreApplication.translate("UISauvegardesPersonnages", "Fermer", null));
        grpInfo.setTitle(com.trolltech.qt.core.QCoreApplication.translate("UISauvegardesPersonnages", "Informations", null));
        label1.setText(com.trolltech.qt.core.QCoreApplication.translate("UISauvegardesPersonnages", "Nom du personnage :", null));
        lblNomPerso.setText("");
        label2.setText(com.trolltech.qt.core.QCoreApplication.translate("UISauvegardesPersonnages", "Niveau du personnage :", null));
        lblNiveauPerso.setText("");
        lblNomSauvegarde.setText(com.trolltech.qt.core.QCoreApplication.translate("UISauvegardesPersonnages", "Nom de la sauvegarde :", null));
        btnSauvegarder.setText(com.trolltech.qt.core.QCoreApplication.translate("UISauvegardesPersonnages", "Sauvegarder", null));
    } // retranslateUi

}

