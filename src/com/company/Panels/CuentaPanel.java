package com.company.Panels;

import com.company.DataStructures.Mesa;
import com.company.DataStructures.Product;
import com.company.DataStructures.ProductTableModel;
import com.company.MainData;
import com.company.SwingComponents;
import jdk.nashorn.internal.scripts.JO;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CuentaPanel extends JPanel {
    private SwingComponents allComp;
    private MainData allData;
    private JFrame superFrame;
    private MigLayout mainLayout = new MigLayout("debug","[][][][]","[][][][]");
    private ProductTableModel modeloTabla=new ProductTableModel(new ArrayList<Product>());
    private JPanel thisPane;
    private Mesa mesaActual;
    private ProductTableModel modeloActual;

    public CuentaPanel(SwingComponents allComp, MainData allData,JFrame superComp){
        this.allComp=allComp;
        thisPane=this;
        this.allData=allData;
        superFrame=superComp;
        eventsConfig();
        layoutConfig();
    }

    public void actualizarComponentes(Mesa mesa){//SE ACTUALIZARAN TODOS LOS DATOS DE LA TABLA TOMANDO EN CUENTA LA MESA RECIBIDA POR PARAMETRO
        modeloActual=new ProductTableModel(mesa.getAccountProducts());
        allComp.getTablaCuenta().setModel(modeloActual);
        allComp.getComboBoxCuenta().removeAllItems();
        mesaActual=mesa;
        ResultSet nombrePod= null;
        try {
            nombrePod = allData.getMainStatementDB().executeQuery("SELECT nombre FROM productos");
            while (nombrePod.next()){
                allComp.getComboBoxCuenta().addItem(nombrePod.getString(1));
            }
        } catch (SQLException throwables) {
            JOptionPane.showMessageDialog(thisPane,"Error en BD: "+throwables.getMessage());
        }
        actualizarMontoTotal();
        this.repaint();
    }

    private void layoutConfig(){
        setLayout(mainLayout);
        add(allComp.getComboBoxCuenta(),"span 2");
        add(new JLabel("Cantidad"),"split 2");
        add(allComp.getAreaCantidadCuenta());
        add(allComp.getBotonAgregarCuenta(),"wrap");
        allComp.getTablaCuenta().setModel(modeloTabla);
        add (allComp.getContenedorTablaCuenta(),"span 3");
        add(new JLabel("Total"),"split 2");
        allComp.getMontoTotalVenta().setEnabled(false);
        add(allComp.getMontoTotalVenta(),"wrap");
        add(allComp.getBotonClearCuenta());
        add(allComp.getBotonTerminarVentaCuenta());
        add(allComp.getBotonEliminarPlatillo());
        add(allComp.getGoHomeCuenta());
    }

    private void actualizarMontoTotal(){
        double acum=0;
        for (Product e:mesaActual.getAccountProducts()){
            acum+=(e.getPrice()*e.getCantidad());
        }
        allComp.getMontoTotalVenta().setText(String.valueOf(acum));
    }

    private void eventsConfig(){
        allComp.getBotonTerminarVentaCuenta().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Product p:mesaActual.getAccountProducts()){
                    try {
                        allData.getMainStatementDB().executeUpdate("INSERT INTO ventas VALUES ("+p.getIdProduct()+",NOW(),"+p.getPrice()*p.getCantidad()+")");
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
                allComp.getAreaCantidadCuenta().setText("");
                mesaActual.getAccountProducts().clear();
                modeloActual.fireTableDataChanged();
                actualizarMontoTotal();
            }
        });
        allComp.getGoHomeCuenta().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                superFrame.setVisible(false);
                allData.getMainTableManager().setVisible(true);
            }
        });
        allComp.getBotonAgregarCuenta().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Integer.parseInt(allComp.getAreaCantidadCuenta().getText())>0){
                    boolean added = false;
                    try{
                        for (Product ex:mesaActual.getAccountProducts()){
                            if (ex.getProductName().compareTo((String)allComp.getComboBoxCuenta().getSelectedItem())==0){
                                ex.setCantidad(ex.getCantidad()+Integer.parseInt(allComp.getAreaCantidadCuenta().getText()));
                                added=true;
                                break;
                            }
                        }
                        if (!added){
                            mesaActual.getAccountProducts().add(new Product(MainData.getIdFromDataBase((String)allComp.getComboBoxCuenta().getSelectedItem(),allData.getMainStatementDB()),(String)allComp.getComboBoxCuenta().getSelectedItem(),MainData.getPriceFromDataBase((String)allComp.getComboBoxCuenta().getSelectedItem(),allData.getMainStatementDB()),Integer.parseInt(allComp.getAreaCantidadCuenta().getText())));
                        }
                        modeloActual.fireTableDataChanged();
                        actualizarMontoTotal();
                    }catch (Exception ex){
                        JOptionPane.showMessageDialog(thisPane,"Error: "+ex.getMessage());
                    }
                    allComp.getAreaCantidadCuenta().setText("");
                }else {
                    JOptionPane.showMessageDialog(thisPane,"Error, verifique el campo de cantidad");
                    allComp.getAreaCantidadCuenta().setText("");
                }
            }
        });
        allComp.getBotonClearCuenta().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mesaActual.getAccountProducts().clear();
                modeloActual.fireTableDataChanged();
                allComp.getAreaCantidadCuenta().setText("");
                allComp.getMontoTotalVenta().setText("");
                actualizarMontoTotal();
            }
        });
        allComp.getBotonEliminarPlatillo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int fila=allComp.getTablaCuenta().getSelectedRow();
                if (fila!=-1){
                    mesaActual.getAccountProducts().remove(fila);
                    modeloActual.fireTableDataChanged();
                    actualizarMontoTotal();
                }
            }
        });
    }
}
