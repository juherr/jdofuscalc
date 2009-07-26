/********************************************************************************
** Form generated from reading ui file 'UIAPropos.jui'
**
** Created: mer. 24. juin 12:04:03 2009
**      by: Qt User Interface Compiler version 4.5.0
**
** WARNING! All changes made in this file will be lost when recompiling ui file!
********************************************************************************/

package org.JDofusCalc.vues.Qt.designer;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class UIAPropos implements com.trolltech.qt.QUiForm<QWidget>
{
    public QGridLayout gridLayout;
    public QTextEdit txtInformations;
    public QLabel lblNomLogiciel;
    public QLabel lblVersionLogiciel;
    public QLabel lblCopyright;
    public QLabel lblLicence;
    public QPushButton btnOK;
    public QPushButton btnLicence;
    public QLabel lblIconeLogiciel;
    public QLabel lblAnkama;

    public UIAPropos() { super(); }

    public void setupUi(QWidget UIAPropos)
    {
        UIAPropos.setObjectName("UIAPropos");
        UIAPropos.setWindowModality(com.trolltech.qt.core.Qt.WindowModality.WindowModal);
        UIAPropos.resize(new QSize(477, 288).expandedTo(UIAPropos.minimumSizeHint()));
        gridLayout = new QGridLayout(UIAPropos);
        gridLayout.setObjectName("gridLayout");
        txtInformations = new QTextEdit(UIAPropos);
        txtInformations.setObjectName("txtInformations");
        txtInformations.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.WheelFocus);
        txtInformations.setReadOnly(true);

        gridLayout.addWidget(txtInformations, 5, 2, 1, 4);

        lblNomLogiciel = new QLabel(UIAPropos);
        lblNomLogiciel.setObjectName("lblNomLogiciel");
        QSizePolicy sizePolicy = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy.setHorizontalStretch((byte)0);
        sizePolicy.setVerticalStretch((byte)0);
        sizePolicy.setHeightForWidth(lblNomLogiciel.sizePolicy().hasHeightForWidth());
        lblNomLogiciel.setSizePolicy(sizePolicy);
        lblNomLogiciel.setOpenExternalLinks(true);

        gridLayout.addWidget(lblNomLogiciel, 0, 2, 1, 4);

        lblVersionLogiciel = new QLabel(UIAPropos);
        lblVersionLogiciel.setObjectName("lblVersionLogiciel");
        QSizePolicy sizePolicy1 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy1.setHorizontalStretch((byte)0);
        sizePolicy1.setVerticalStretch((byte)0);
        sizePolicy1.setHeightForWidth(lblVersionLogiciel.sizePolicy().hasHeightForWidth());
        lblVersionLogiciel.setSizePolicy(sizePolicy1);

        gridLayout.addWidget(lblVersionLogiciel, 1, 2, 1, 2);

        lblCopyright = new QLabel(UIAPropos);
        lblCopyright.setObjectName("lblCopyright");

        gridLayout.addWidget(lblCopyright, 2, 2, 1, 4);

        lblLicence = new QLabel(UIAPropos);
        lblLicence.setObjectName("lblLicence");
        QSizePolicy sizePolicy2 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy2.setHorizontalStretch((byte)0);
        sizePolicy2.setVerticalStretch((byte)0);
        sizePolicy2.setHeightForWidth(lblLicence.sizePolicy().hasHeightForWidth());
        lblLicence.setSizePolicy(sizePolicy2);
        lblLicence.setOpenExternalLinks(true);

        gridLayout.addWidget(lblLicence, 3, 2, 1, 4);

        btnOK = new QPushButton(UIAPropos);
        btnOK.setObjectName("btnOK");
        QSizePolicy sizePolicy3 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy3.setHorizontalStretch((byte)0);
        sizePolicy3.setVerticalStretch((byte)0);
        sizePolicy3.setHeightForWidth(btnOK.sizePolicy().hasHeightForWidth());
        btnOK.setSizePolicy(sizePolicy3);
        btnOK.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        btnOK.setIcon(new QIcon(new QPixmap("classpath:org/JDofusCalc/ressources/images/ok.png")));
        btnOK.setIconSize(new QSize(24, 24));

        gridLayout.addWidget(btnOK, 7, 2, 1, 1);

        btnLicence = new QPushButton(UIAPropos);
        btnLicence.setObjectName("btnLicence");
        btnLicence.setFocusPolicy(com.trolltech.qt.core.Qt.FocusPolicy.StrongFocus);
        btnLicence.setIcon(new QIcon(new QPixmap("classpath:org/JDofusCalc/ressources/images/documentinfo.png")));
        btnLicence.setIconSize(new QSize(24, 24));

        gridLayout.addWidget(btnLicence, 7, 3, 1, 1);

        lblIconeLogiciel = new QLabel(UIAPropos);
        lblIconeLogiciel.setObjectName("lblIconeLogiciel");
        QSizePolicy sizePolicy4 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Fixed, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy4.setHorizontalStretch((byte)0);
        sizePolicy4.setVerticalStretch((byte)0);
        sizePolicy4.setHeightForWidth(lblIconeLogiciel.sizePolicy().hasHeightForWidth());
        lblIconeLogiciel.setSizePolicy(sizePolicy4);
        lblIconeLogiciel.setPixmap(new QPixmap(("classpath:org/JDofusCalc/ressources/images/icone.png")));

        gridLayout.addWidget(lblIconeLogiciel, 0, 0, 3, 1);

        lblAnkama = new QLabel(UIAPropos);
        lblAnkama.setObjectName("lblAnkama");

        gridLayout.addWidget(lblAnkama, 4, 2, 1, 4);

        QWidget.setTabOrder(btnLicence, txtInformations);
        QWidget.setTabOrder(txtInformations, btnOK);
        retranslateUi(UIAPropos);

        UIAPropos.connectSlotsByName();
    } // setupUi

    void retranslateUi(QWidget UIAPropos)
    {
        UIAPropos.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("UIAPropos", "\u00c0 propos", null));
        txtInformations.setHtml(com.trolltech.qt.core.QCoreApplication.translate("UIAPropos", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
"p, li { white-space: pre-wrap; }\n"+
"</style></head><body style=\" font-family:'MS Shell Dlg 2'; font-size:8.25pt; font-weight:400; font-style:normal;\">\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; font-size:8pt;\">Le concepteur de ce programme est totalement ind\u00e9pendant de l'\u00e9quipe et des concepteurs de Dofus. De ce fait, Ankama Games ne saurait en aucune mani\u00e8re \u00eatre tenue responsable des informations, inexactitudes, effets secondaire et/ou dommages caus\u00e9s par l'installation ou l'utilisation de ce logiciel.</p>\n"+
"<p style=\"-qt-paragraph-type:empty; margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; font-size:8pt;\"></p>\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; font-size:8pt;\">Malgr\u00e9 tout le soin apport\u00e9 \u00e0 la r\u00e9alisation de ce programme, il se peut que des erreurs subsistent, et que des effets involontaires se manifestent. Dans un tel cas, l'auteur ne saurait \u00eatre tenu pour responsable de ces effets quels qu'ils soient.</p></body></html>", null));
        lblNomLogiciel.setText(com.trolltech.qt.core.QCoreApplication.translate("UIAPropos", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
"p, li { white-space: pre-wrap; }\n"+
"</style></head><body style=\" font-family:'MS Shell Dlg 2'; font-size:8.25pt; font-weight:400; font-style:normal;\">\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; font-size:8pt;\"><span style=\" font-weight:600; color:#55aaff;\">J</span><span style=\" font-weight:600;\">DofusCalc</span>, d'apr\u00e8s une id\u00e9e originale de <a href=\"http://forums.jeuxonline.info/member.php?u=113776\"><span style=\" text-decoration: underline; color:#0000ff;\">HarvestR</span></a>.</p></body></html>", null));
        lblVersionLogiciel.setText(com.trolltech.qt.core.QCoreApplication.translate("UIAPropos", "Version", null));
        lblCopyright.setText(com.trolltech.qt.core.QCoreApplication.translate("UIAPropos", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
"p, li { white-space: pre-wrap; }\n"+
"</style></head><body style=\" font-family:'MS Shell Dlg 2'; font-size:8.25pt; font-weight:400; font-style:normal;\">\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px;\"><span style=\" font-size:8pt;\">(c) Copyright PAPAYA Alexandre, 2008, 2009.</span></p></body></html>", null));
        lblLicence.setText(com.trolltech.qt.core.QCoreApplication.translate("UIAPropos", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\" \"http://www.w3.org/TR/REC-html40/strict.dtd\">\n"+
"<html><head><meta name=\"qrichtext\" content=\"1\" /><style type=\"text/css\">\n"+
"p, li { white-space: pre-wrap; }\n"+
"</style></head><body style=\" font-family:'MS Shell Dlg 2'; font-size:8.25pt; font-weight:400; font-style:normal;\">\n"+
"<p style=\" margin-top:0px; margin-bottom:0px; margin-left:0px; margin-right:0px; -qt-block-indent:0; text-indent:0px; font-size:8pt;\">Logiciel distribu\u00e9 sous licence CeCILL compatible avec la licence <a href=\"http://www.gnu.org/copyleft/gpl.html\"><span style=\" text-decoration: underline; color:#0000ff;\">GNU GPL</span></a>.</p></body></html>", null));
        btnOK.setText(com.trolltech.qt.core.QCoreApplication.translate("UIAPropos", "OK", null));
        btnLicence.setText(com.trolltech.qt.core.QCoreApplication.translate("UIAPropos", "Afficher la licence", null));
        lblIconeLogiciel.setText("");
        lblAnkama.setText(com.trolltech.qt.core.QCoreApplication.translate("UIAPropos", "Dofus et certaines illustrations sont la propri\u00e9t\u00e9 d'Ankama Games - Tous droits r\u00e9serv\u00e9s.", null));
    } // retranslateUi

}

