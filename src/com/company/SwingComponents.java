package com.company;

import javax.swing.*;

public class SwingComponents {
    //MainWindowPanel
    private JLabel logoMainWindow=new JLabel(new ImageIcon("images/mainWindowLogo.png"));
    private JButton mainWindSellButton = new JButton(new ImageIcon("images/botonTienda.png"));
    private JButton mainWindReportButton= new JButton(new ImageIcon("images/botonInforme.png"));
    private JButton mainWindAddButton= new JButton(new ImageIcon("images/botonAddMainW.png"));
    private JButton mainWindSearchButton = new JButton(new ImageIcon("images/searchButton.png"));

    public JButton getMainWindSearchButton() {
        return mainWindSearchButton;
    }

    public JButton getMainWindAddButton() {
        return mainWindAddButton;
    }

    public JButton getMainWindSellButton() {
        return mainWindSellButton;
    }

    public JButton getMainWindReportButton() {
        return mainWindReportButton;
    }

    public JLabel getLogoMainWindow() {
        return logoMainWindow;
    }
}
