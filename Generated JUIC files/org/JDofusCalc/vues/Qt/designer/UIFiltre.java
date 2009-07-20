/********************************************************************************
** Form generated from reading ui file 'UIFiltre.jui'
**
** Created: mer. 24. juin 12:04:04 2009
**      by: Qt User Interface Compiler version 4.5.0
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

package org.JDofusCalc.vues.Qt.designer;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class UIFiltre implements com.trolltech.qt.QUiForm<QWidget>
{
    public QHBoxLayout horizontalLayout;
    public QCheckBox cboxFiltre;
    public QLineEdit txtFiltre;
    public QPushButton btnEffacer;

    public UIFiltre() { super(); }

    public void setupUi(QWidget UIFiltre)
    {
        UIFiltre.setObjectName("UIFiltre");
        UIFiltre.resize(new QSize(216, 25).expandedTo(UIFiltre.minimumSizeHint()));
        horizontalLayout = new QHBoxLayout(UIFiltre);
        horizontalLayout.setSpacing(1);
        horizontalLayout.setMargin(1);
        horizontalLayout.setObjectName("horizontalLayout");
        cboxFiltre = new QCheckBox(UIFiltre);
        cboxFiltre.setObjectName("cboxFiltre");
        cboxFiltre.setChecked(true);

        horizontalLayout.addWidget(cboxFiltre);

        txtFiltre = new QLineEdit(UIFiltre);
        txtFiltre.setObjectName("txtFiltre");

        horizontalLayout.addWidget(txtFiltre);

        btnEffacer = new QPushButton(UIFiltre);
        btnEffacer.setObjectName("btnEffacer");
        QSizePolicy sizePolicy = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy.setHorizontalStretch((byte)0);
        sizePolicy.setVerticalStretch((byte)0);
        sizePolicy.setHeightForWidth(btnEffacer.sizePolicy().hasHeightForWidth());
        btnEffacer.setSizePolicy(sizePolicy);
        btnEffacer.setIcon(new QIcon(new QPixmap("classpath:file:F:/Mes documents/Java/Mes projets/JDofusCalc/src#org/JDofusCalc/ressources/images/cancel.png")));
        btnEffacer.setIconSize(new QSize(10, 10));

        horizontalLayout.addWidget(btnEffacer);

        retranslateUi(UIFiltre);

        UIFiltre.connectSlotsByName();
    } // setupUi

    void retranslateUi(QWidget UIFiltre)
    {
        UIFiltre.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("UIFiltre", "Form", null));
        cboxFiltre.setText(com.trolltech.qt.core.QCoreApplication.translate("UIFiltre", "Filtre :", null));
        btnEffacer.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("UIFiltre", "Effacer", null));
    } // retranslateUi

}

