/********************************************************************************
** Form generated from reading ui file 'UIGestionDofus.jui'
**
** Created: mer. 24. juin 12:06:10 2009
**      by: Qt User Interface Compiler version 4.5.0
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

package org.JDofusCalc.vues.Qt.designer;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class UIGestionDofus implements com.trolltech.qt.QUiForm<QWidget>
{
    public QGridLayout gridLayout;
    public QFrame frameListe;
    public QVBoxLayout verticalLayout_5;
    public QLabel lblListe;
    public QListWidget listeDofus;
    public QFrame frameActions;
    public QHBoxLayout horizontalLayout;
    public QPushButton btnNouveau;
    public QPushButton btnSupp;
    public QSpacerItem horizontalSpacer;
    public QPushButton btnSauv;
    public QPushButton btnFermer;
    public QGroupBox grpDofus;
    public QGridLayout gridLayout_2;
    public QLabel lblNom;
    public QLabel lblEffets;
    public QLabel imgEffet;
    public QPushButton btnEffetsMini;
    public QLineEdit txtNom;
    public QLineEdit txtValeur;
    public QPushButton btnEffetsMaxi;

    public UIGestionDofus() { super(); }

    public void setupUi(QWidget UIGestionDofus)
    {
        UIGestionDofus.setObjectName("UIGestionDofus");
        UIGestionDofus.resize(new QSize(380, 212).expandedTo(UIGestionDofus.minimumSizeHint()));
        gridLayout = new QGridLayout(UIGestionDofus);
        gridLayout.setObjectName("gridLayout");
        frameListe = new QFrame(UIGestionDofus);
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

        listeDofus = new QListWidget(frameListe);
        listeDofus.setObjectName("listeDofus");
        listeDofus.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.WheelFocus);

        verticalLayout_5.addWidget(listeDofus);


        gridLayout.addWidget(frameListe, 0, 0, 1, 1);

        frameActions = new QFrame(UIGestionDofus);
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


        gridLayout.addWidget(frameActions, 1, 0, 1, 2);

        grpDofus = new QGroupBox(UIGestionDofus);
        grpDofus.setObjectName("grpDofus");
        QSizePolicy sizePolicy2 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);
        sizePolicy2.setHorizontalStretch((byte)0);
        sizePolicy2.setVerticalStretch((byte)0);
        sizePolicy2.setHeightForWidth(grpDofus.sizePolicy().hasHeightForWidth());
        grpDofus.setSizePolicy(sizePolicy2);
        gridLayout_2 = new QGridLayout(grpDofus);
        gridLayout_2.setObjectName("gridLayout_2");
        lblNom = new QLabel(grpDofus);
        lblNom.setObjectName("lblNom");
        QSizePolicy sizePolicy3 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Preferred, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy3.setHorizontalStretch((byte)0);
        sizePolicy3.setVerticalStretch((byte)0);
        sizePolicy3.setHeightForWidth(lblNom.sizePolicy().hasHeightForWidth());
        lblNom.setSizePolicy(sizePolicy3);

        gridLayout_2.addWidget(lblNom, 0, 0, 1, 1);

        lblEffets = new QLabel(grpDofus);
        lblEffets.setObjectName("lblEffets");
        QSizePolicy sizePolicy4 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Preferred, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy4.setHorizontalStretch((byte)0);
        sizePolicy4.setVerticalStretch((byte)0);
        sizePolicy4.setHeightForWidth(lblEffets.sizePolicy().hasHeightForWidth());
        lblEffets.setSizePolicy(sizePolicy4);

        gridLayout_2.addWidget(lblEffets, 1, 0, 1, 1);

        imgEffet = new QLabel(grpDofus);
        imgEffet.setObjectName("imgEffet");
        imgEffet.setMinimumSize(new QSize(25, 25));
        imgEffet.setMaximumSize(new QSize(25, 25));
        imgEffet.setStyleSheet("background-color: rgb(255, 255, 255);\n"+
"border: 1px solid black;");
        imgEffet.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(imgEffet, 2, 0, 1, 1);

        btnEffetsMini = new QPushButton(grpDofus);
        btnEffetsMini.setObjectName("btnEffetsMini");
        btnEffetsMini.setEnabled(false);
        btnEffetsMini.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);

        gridLayout_2.addWidget(btnEffetsMini, 3, 0, 1, 3);

        txtNom = new QLineEdit(grpDofus);
        txtNom.setObjectName("txtNom");
        txtNom.setEnabled(false);
        QSizePolicy sizePolicy5 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy5.setHorizontalStretch((byte)0);
        sizePolicy5.setVerticalStretch((byte)0);
        sizePolicy5.setHeightForWidth(txtNom.sizePolicy().hasHeightForWidth());
        txtNom.setSizePolicy(sizePolicy5);
        txtNom.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);

        gridLayout_2.addWidget(txtNom, 0, 1, 1, 3);

        txtValeur = new QLineEdit(grpDofus);
        txtValeur.setObjectName("txtValeur");
        txtValeur.setEnabled(false);
        QSizePolicy sizePolicy6 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy6.setHorizontalStretch((byte)0);
        sizePolicy6.setVerticalStretch((byte)0);
        sizePolicy6.setHeightForWidth(txtValeur.sizePolicy().hasHeightForWidth());
        txtValeur.setSizePolicy(sizePolicy6);
        txtValeur.setMinimumSize(new QSize(30, 0));
        txtValeur.setMaximumSize(new QSize(30, 16777215));
        txtValeur.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        txtValeur.setAlignment(com.trolltech.qt.core.Qt.AlignmentFlag.createQFlags(com.trolltech.qt.core.Qt.AlignmentFlag.AlignCenter));

        gridLayout_2.addWidget(txtValeur, 2, 1, 1, 1);

        btnEffetsMaxi = new QPushButton(grpDofus);
        btnEffetsMaxi.setObjectName("btnEffetsMaxi");
        btnEffetsMaxi.setEnabled(false);
        btnEffetsMaxi.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);

        gridLayout_2.addWidget(btnEffetsMaxi, 3, 3, 1, 1);


        gridLayout.addWidget(grpDofus, 0, 1, 1, 1);

        retranslateUi(UIGestionDofus);

        UIGestionDofus.connectSlotsByName();
    } // setupUi

    void retranslateUi(QWidget UIGestionDofus)
    {
        UIGestionDofus.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("UIGestionDofus", "Gestion Dofus", null));
        lblListe.setText(com.trolltech.qt.core.QCoreApplication.translate("UIGestionDofus", "Dofus enregistr\u00e9s :", null));
        btnNouveau.setText(com.trolltech.qt.core.QCoreApplication.translate("UIGestionDofus", "Nouveau", null));
        btnSupp.setText(com.trolltech.qt.core.QCoreApplication.translate("UIGestionDofus", "Supprimer", null));
        btnSauv.setText(com.trolltech.qt.core.QCoreApplication.translate("UIGestionDofus", "Sauvegarder", null));
        btnFermer.setText(com.trolltech.qt.core.QCoreApplication.translate("UIGestionDofus", "Fermer", null));
        grpDofus.setTitle(com.trolltech.qt.core.QCoreApplication.translate("UIGestionDofus", "Dofus", null));
        lblNom.setText(com.trolltech.qt.core.QCoreApplication.translate("UIGestionDofus", "Nom :", null));
        lblEffets.setText(com.trolltech.qt.core.QCoreApplication.translate("UIGestionDofus", "Effet :", null));
        imgEffet.setText("");
        btnEffetsMini.setText(com.trolltech.qt.core.QCoreApplication.translate("UIGestionDofus", "Effet minimum", null));
        txtValeur.setInputMask(com.trolltech.qt.core.QCoreApplication.translate("UIGestionDofus", "#99; ", null));
        btnEffetsMaxi.setText(com.trolltech.qt.core.QCoreApplication.translate("UIGestionDofus", "Effets maximum", null));
    } // retranslateUi

}

