package com.company.Panels;

import com.company.DataStructures.Mesa;
import com.company.DataStructures.Product;
import com.company.DataStructures.ProductTableModel;
import com.company.MainData;
import com.company.SwingComponents;
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

    public CuentaPanel(SwingComponents allComp, MainData allData,JFrame superComp){
        this.allComp=allComp;
        thisPane=this;
        this.allData=allData;
        superFrame=superComp;
        eventsConfig();
        layoutConfig();
    }

    public void actualizarComponentes(Mesa mesa){//SE ACTUALIZARAN TODOS LOS DATOS DE LA TABLA TOMANDO EN CUENTA LA MESA RECIBIDA POR PARAMETRO
        allComp.getTablaCuenta().setModel(new ProductTableModel(mesa.getAccountProducts()));
        allComp.getComboBoxCuenta().removeAllItems();
        ResultSet nombrePod= null;
        try {
            nombrePod = allData.getMainStatementDB().executeQuery("SELECT nombre FROM productos");
            while (nombrePod.next()){
                allComp.getComboBoxCuenta().addItem(nombrePod.getString(1));
            }
        } catch (SQLException throwables) {
            JOptionPane.showMessageDialog(thisPane,"Error en BD: "+throwables.getMessage());
        }
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
        add(new JLabel(" "));
        add(allComp.getGoHomeCuenta());
    }

    private void eventsConfig(){
        allComp.getGoHomeCuenta().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                superFrame.setVisible(false);
                allData.getMainTableManager().setVisible(true);
            }
        });
    }
}
