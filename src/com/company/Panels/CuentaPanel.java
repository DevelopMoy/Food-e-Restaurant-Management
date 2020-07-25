package com.company.Panels;

import com.company.DataStructures.Mesa;
import com.company.DataStructures.Product;
import com.company.DataStructures.ProductTableModel;
import com.company.MainData;
import com.company.SwingComponents;
import jdk.nashorn.internal.scripts.JO;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CuentaPanel extends JPanel {
    private SwingComponents allComp;
    private MainData allData;
    private JFrame superFrame;
    private MigLayout mainLayout = new MigLayout("fillx,filly","[grow][grow][grow][grow]","[][][][]");
    private ProductTableModel modeloTabla=new ProductTableModel(new ArrayList<Product>());
    private JPanel thisPane;
    private Mesa mesaActual;
    private ProductTableModel modeloActual;
    private static int orden=1;

    public CuentaPanel(SwingComponents allComp, MainData allData,JFrame superComp){
        this.allComp=allComp;
        thisPane=this;
        this.allData=allData;
        superFrame=superComp;
        eventsConfig();
        layoutConfig();
    }

    public void actualizarComponentes(Mesa mesa){//SE ACTUALIZARAN TODOS LOS DATOS DE LA TABLA TOMANDO EN CUENTA LA MESA RECIBIDA POR PARAMETRO
        allData.getCuentaFrame().setTitle("Food-e Restaurant Management - Mesa "+mesa.getNumTable());
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
        allComp.getComboBoxCuenta().setFont(new Font("Times New Roman",Font.BOLD,36));
        AutoCompleteDecorator.decorate(allComp.getComboBoxCuenta());
        add(allComp.getComboBoxCuenta(),"width 490!,height 110!,span 2,align center");
        JLabel nota1=new JLabel("Cantidad");
        nota1.setFont(new Font("Times New Roman",Font.BOLD,28));
        add(nota1,"split 2,align center");
        allComp.getAreaCantidadCuenta().setFont(new Font("Times New Roman",Font.BOLD,34));
        add(allComp.getAreaCantidadCuenta(),"width 300!, height 80!,align center");
        add(allComp.getBotonAgregarCuenta(),"wrap,align center");
        allComp.getTablaCuenta().setModel(modeloTabla);
        allComp.getTablaCuenta().setFont(new Font("Times New Roman",Font.BOLD,28));
        add (allComp.getContenedorTablaCuenta(),"width 990!,span 3,align center");
        JLabel nota2=new JLabel("Total");
        nota2.setFont(new Font("Times New Roman",Font.BOLD,28));
        add(nota2,"split 2,align center");
        allComp.getMontoTotalVenta().setEnabled(false);
        allComp.getMontoTotalVenta().setFont(new Font("Times New Roman",Font.BOLD,34));
        add(allComp.getMontoTotalVenta(),"wrap,align center");
        add(allComp.getBotonClearCuenta(),"align center");
        add(allComp.getBotonTerminarVentaCuenta(),"align center");
        add(allComp.getBotonEliminarPlatillo(),"align center");
        add(allComp.getGoHomeCuenta(),"align center");
    }

    private String recortarNombre (String nombre){
        if(nombre.length()>17){
            return nombre.substring(0,17);
        }
        return nombre;
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
                StringBuilder fechaString=new StringBuilder();
                Date fecha=new Date();
                Double montoCliente = 0d;
                SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MMM-aaaa");
                SimpleDateFormat formatoHora = new SimpleDateFormat("hh: mm a");
                Double cantidadTotal=0D;
                StringBuilder ticketInfo=new StringBuilder("**Cenaduría Loma Bonita**\n\nFECHA: "+formatoFecha.format(fecha)+"\nHORA: "+formatoHora.format(fecha)+"\nOrden # "+(orden++)+"\nMesa: "+mesaActual.getNumTable()+"\n"+
                        "-------------------------\nCantidad Producto  Total\n\n");
                for (Product p:mesaActual.getAccountProducts()){
                    ticketInfo.append(p.getCantidad()+" "+recortarNombre(p.getProductName())+" $"+(p.getPrice()*p.getCantidad())+"\n");
                    try {
                        allData.getMainStatementDB().executeUpdate("INSERT INTO ventas VALUES ("+p.getIdProduct()+",NOW(),"+p.getPrice()*p.getCantidad()+")");
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
                while (true){
                    String montoPagar=JOptionPane.showInputDialog(thisPane,"¿Con cuanto esta pagando el cliente?");
                    cantidadTotal = Double.parseDouble(allComp.getMontoTotalVenta().getText());
                    try{
                        montoCliente=Double.parseDouble(montoPagar);
                        if (montoCliente<cantidadTotal){
                            throw new Exception("El monto introducido es menor al total de la cuenta");
                        }
                        JOptionPane.showMessageDialog(thisPane,"Su cambio es: "+(montoCliente-cantidadTotal));
                        break;
                    }catch (Exception ex){
                        JOptionPane.showMessageDialog(thisPane,"Dato no valido: "+ex.getMessage());
                    }
                }
                ticketInfo.append("\nTotal a pagar: "+cantidadTotal+"\n\n** GRACIAS POR SU COMPRA **\n\n\n\n\n");
                allData.getServicioImpresion().printString("58mm Series Printer",ticketInfo.toString());
                allComp.getAreaCantidadCuenta().setText("");
                mesaActual.getAccountProducts().clear();
                modeloActual.fireTableDataChanged();
                actualizarMontoTotal();
                System.out.println(ticketInfo);
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
                try{
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

                }catch (NumberFormatException except){
                    JOptionPane.showMessageDialog(thisPane,"Error, campo vacio o caracteres no permitidos.");
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(thisPane,"Error: "+ex.getMessage());
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
