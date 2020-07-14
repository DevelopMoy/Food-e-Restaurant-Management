package com.company;

import javax.swing.*;

public class SwingComponents {
    //MainWindowPanel
    private JLabel logoMainWindow=new JLabel(new ImageIcon("images/mainWindowLogo.png"));
    private JButton mainWindSellButton = new JButton(new ImageIcon("images/botonTienda.png"));
    private JButton mainWindReportButton= new JButton(new ImageIcon("images/botonInforme.png"));
    private JButton mainWindAddButton= new JButton(new ImageIcon("images/botonAddMainW.png"));
    private JButton mainWindSearchButton = new JButton(new ImageIcon("images/searchButton.png"));
    //TableManagerPanel
    private JLabel tableManageTittle= new JLabel(new ImageIcon("images/tituloVenta.png"));
    private JButton tableManageHomeButton = new JButton(new ImageIcon("images/homeButt.png"));
    //CuentaPanel
    private JTable tablaCuenta = new JTable();
    private JScrollPane contenedorTablaCuenta = new JScrollPane(tablaCuenta);
    private JComboBox<String> comboBoxCuenta= new JComboBox();
    private JTextField areaCantidadCuenta=new JTextField(11);
    private JTextField montoTotalVenta = new JTextField(11);
    private JButton goHomeCuenta = new JButton("goHome");
    private JButton botonAgregarCuenta = new JButton();
    private JButton botonClearCuenta = new JButton();
    private JButton botonTerminarVentaCuenta = new JButton();

    public JTable getTablaCuenta() {
        return tablaCuenta;
    }

    public JScrollPane getContenedorTablaCuenta() {
        return contenedorTablaCuenta;
    }

    public JComboBox getComboBoxCuenta() {
        return comboBoxCuenta;
    }

    public JTextField getAreaCantidadCuenta() {
        return areaCantidadCuenta;
    }

    public JTextField getMontoTotalVenta() {
        return montoTotalVenta;
    }

    public JButton getGoHomeCuenta() {
        return goHomeCuenta;
    }

    public JButton getBotonAgregarCuenta() {
        return botonAgregarCuenta;
    }

    public JButton getBotonClearCuenta() {
        return botonClearCuenta;
    }

    public JButton getBotonTerminarVentaCuenta() {
        return botonTerminarVentaCuenta;
    }

    public JButton getTableManageHomeButton() {
        return tableManageHomeButton;
    }

    public JButton getMainWindSearchButton() {
        return mainWindSearchButton;
    }

    public JLabel getTableManageTittle() {
        return tableManageTittle;
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
