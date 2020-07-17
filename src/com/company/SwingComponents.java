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
    private JButton goHomeCuenta = new JButton(new ImageIcon("images/homeAzul.png"));
    private JButton botonAgregarCuenta = new JButton(new ImageIcon("images/seleccionarAzul.png"));
    private JButton botonClearCuenta = new JButton(new ImageIcon("images/botonLimpiar.png"));
    private JButton botonTerminarVentaCuenta = new JButton(new ImageIcon("images/botonVenta.png"));
    private JButton botonEliminarPlatillo = new JButton(new ImageIcon("images/botonEliminar.png"));
    //Panel add new product
    private JButton botonHomeAddProduct = new JButton(new ImageIcon("images/homeAzul2.png"));
    private JButton botonFinalizarAdd = new JButton(new ImageIcon("images/botonAddJButton.png"));
    private JTextField campoNombre = new JTextField(16);
    private JTextField campoPrecio = new JTextField(16);
    private JLabel etiquetaNombre = new JLabel(new ImageIcon("images/etiquetaAdd1.png"));
    private JLabel etiquetaPrecio = new JLabel(new ImageIcon("images/etiquetaAdd2.png"));
    private JLabel etiquetaTituloAdd = new JLabel(new ImageIcon("images/tituloVenta2.png"));
    //Report panel
    private JButton botonHomeReport = new JButton(new ImageIcon("images/botonVolver.png"));
    private JButton botonGenerarReporte = new JButton(new ImageIcon("images/botonGenerar.png"));
    private SpinnerDateModel spinModel = new SpinnerDateModel();
    private SpinnerDateModel spinModel2 = new SpinnerDateModel();
    private JSpinner campoFecha = new JSpinner(spinModel);
    private JSpinner campoFecha2 = new JSpinner(spinModel2);
    private JTable tablaReport=new JTable();
    private JScrollPane contenedorTablaReport = new JScrollPane(tablaReport);
    private JLabel etiquetaGanancias = new JLabel("Total Vendido: ");
    private JTextField campoTotalReport = new JTextField(11);

    public SpinnerDateModel getSpinModel2() {
        return spinModel2;
    }

    public JSpinner getCampoFecha2() {
        return campoFecha2;
    }

    public JButton getBotonHomeReport() {
        return botonHomeReport;
    }

    public JButton getBotonGenerarReporte() {
        return botonGenerarReporte;
    }

    public SpinnerDateModel getSpinModel() {
        return spinModel;
    }

    public JSpinner getCampoFecha() {
        return campoFecha;
    }

    public JTable getTablaReport() {
        return tablaReport;
    }

    public JScrollPane getContenedorTablaReport() {
        return contenedorTablaReport;
    }

    public JLabel getEtiquetaGanancias() {
        return etiquetaGanancias;
    }

    public JTextField getCampoTotalReport() {
        return campoTotalReport;
    }

    public JTextField getCampoNombre() {
        return campoNombre;
    }

    public JTextField getCampoPrecio() {
        return campoPrecio;
    }

    public JButton getBotonFinalizarAdd() {
        return botonFinalizarAdd;
    }

    public JLabel getEtiquetaNombre() {
        return etiquetaNombre;
    }

    public JLabel getEtiquetaPrecio() {
        return etiquetaPrecio;
    }

    public JLabel getEtiquetaTituloAdd() {
        return etiquetaTituloAdd;
    }

    public JButton getBotonHomeAddProduct() {
        return botonHomeAddProduct;
    }

    public JButton getBotonEliminarPlatillo() {
        return botonEliminarPlatillo;
    }

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
