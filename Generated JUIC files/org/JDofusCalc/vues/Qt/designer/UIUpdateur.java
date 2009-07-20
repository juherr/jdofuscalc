/********************************************************************************
** Form generated from reading ui file 'UIUpdateur.jui'
**
** Created: mer. 24. juin 12:06:52 2009
**      by: Qt User Interface Compiler version 4.5.0
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

package org.JDofusCalc.vues.Qt.designer;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class UIUpdateur implements com.trolltech.qt.QUiForm<QWidget>
{
    public QGridLayout gridLayout;
    public QProgressBar progressBar;
    public QLabel label;
    public QLabel lblAction;
    public QLabel label_2;
    public QLabel lblFichier;
    public QLabel lblVitesse;
    public QPushButton btnAnnuler;
    public QSpacerItem horizontalSpacer;

    public UIUpdateur() { super(); }

    public void setupUi(QWidget UIUpdateur)
    {
        UIUpdateur.setObjectName("UIUpdateur");
        UIUpdateur.resize(new QSize(400, 129).expandedTo(UIUpdateur.minimumSizeHint()));
        gridLayout = new QGridLayout(UIUpdateur);
        gridLayout.setObjectName("gridLayout");
        progressBar = new QProgressBar(UIUpdateur);
        progressBar.setObjectName("progressBar");
        QSizePolicy sizePolicy = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy.setHorizontalStretch((byte)0);
        sizePolicy.setVerticalStretch((byte)0);
        sizePolicy.setHeightForWidth(progressBar.sizePolicy().hasHeightForWidth());
        progressBar.setSizePolicy(sizePolicy);
        progressBar.setMaximum(100);
        progressBar.setValue(-1);
        progressBar.setTextVisible(true);

        gridLayout.addWidget(progressBar, 1, 0, 1, 5);

        label = new QLabel(UIUpdateur);
        label.setObjectName("label");
        QSizePolicy sizePolicy1 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy1.setHorizontalStretch((byte)0);
        sizePolicy1.setVerticalStretch((byte)0);
        sizePolicy1.setHeightForWidth(label.sizePolicy().hasHeightForWidth());
        label.setSizePolicy(sizePolicy1);

        gridLayout.addWidget(label, 3, 0, 1, 1);

        lblAction = new QLabel(UIUpdateur);
        lblAction.setObjectName("lblAction");
        QSizePolicy sizePolicy2 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy2.setHorizontalStretch((byte)0);
        sizePolicy2.setVerticalStretch((byte)0);
        sizePolicy2.setHeightForWidth(lblAction.sizePolicy().hasHeightForWidth());
        lblAction.setSizePolicy(sizePolicy2);

        gridLayout.addWidget(lblAction, 0, 0, 1, 5);

        label_2 = new QLabel(UIUpdateur);
        label_2.setObjectName("label_2");

        gridLayout.addWidget(label_2, 2, 0, 1, 1);

        lblFichier = new QLabel(UIUpdateur);
        lblFichier.setObjectName("lblFichier");

        gridLayout.addWidget(lblFichier, 2, 1, 1, 4);

        lblVitesse = new QLabel(UIUpdateur);
        lblVitesse.setObjectName("lblVitesse");
        QSizePolicy sizePolicy3 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy3.setHorizontalStretch((byte)0);
        sizePolicy3.setVerticalStretch((byte)0);
        sizePolicy3.setHeightForWidth(lblVitesse.sizePolicy().hasHeightForWidth());
        lblVitesse.setSizePolicy(sizePolicy3);

        gridLayout.addWidget(lblVitesse, 3, 1, 1, 2);

        btnAnnuler = new QPushButton(UIUpdateur);
        btnAnnuler.setObjectName("btnAnnuler");
        btnAnnuler.setEnabled(true);
        QSizePolicy sizePolicy4 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy4.setHorizontalStretch((byte)0);
        sizePolicy4.setVerticalStretch((byte)0);
        sizePolicy4.setHeightForWidth(btnAnnuler.sizePolicy().hasHeightForWidth());
        btnAnnuler.setSizePolicy(sizePolicy4);
        btnAnnuler.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);

        gridLayout.addWidget(btnAnnuler, 5, 2, 1, 3);

        horizontalSpacer = new QSpacerItem(0, 0, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        gridLayout.addItem(horizontalSpacer, 5, 1, 1, 1);

        retranslateUi(UIUpdateur);

        UIUpdateur.connectSlotsByName();
    } // setupUi

    void retranslateUi(QWidget UIUpdateur)
    {
        UIUpdateur.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("UIUpdateur", "Module de mise \u00e0 jour", null));
        label.setText(com.trolltech.qt.core.QCoreApplication.translate("UIUpdateur", "Vitesse :", null));
        lblAction.setText(com.trolltech.qt.core.QCoreApplication.translate("UIUpdateur", "?", null));
        label_2.setText(com.trolltech.qt.core.QCoreApplication.translate("UIUpdateur", "Fichier :", null));
        lblFichier.setText(com.trolltech.qt.core.QCoreApplication.translate("UIUpdateur", "?", null));
        lblVitesse.setText(com.trolltech.qt.core.QCoreApplication.translate("UIUpdateur", "?", null));
        btnAnnuler.setText(com.trolltech.qt.core.QCoreApplication.translate("UIUpdateur", "Annuler", null));
    } // retranslateUi

}

