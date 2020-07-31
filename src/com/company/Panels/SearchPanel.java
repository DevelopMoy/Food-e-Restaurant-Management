package com.company.Panels;

import com.company.MainData;
import com.company.SwingComponents;
import jdk.nashorn.internal.scripts.JO;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SearchPanel extends JPanel {
    private SwingComponents allComp;
    private MainData allData;
    private JFrame superFrame;
    private JPanel thisPane;
    private MigLayout mainLayout = new MigLayout("fillx,filly","[grow][grow]","[][][][]");

    public SearchPanel (SwingComponents allComp, MainData allData,JFrame superFrame){
        thisPane=this;
        setLayout(mainLayout);
        this.allComp=allComp;
        this.allData=allData;
        this.superFrame=superFrame;
        configEvents();
        configLayout();
    }

    private void configEvents(){
        allComp.getComboBoxProd().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarCampoPrecio();
            }
        });
        allComp.getBotonVolver().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allData.getMainWindow().setVisible(true);
                allData.getSearchFrame().setVisible(false);
            }
        });
        allComp.getBotonCambiarPrecio().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if (!(allComp.getCampoPrecioNuevo().getText().compareTo("")==0)){
                        double num=Double.parseDouble(allComp.getCampoPrecioNuevo().getText());
                        if (num>=0){
                            //UPDATE productos SET precio=50 WHERE nombre='Enchiladas'
                            allData.getMainStatementDB().executeUpdate("UPDATE productos SET precio="+num+" WHERE nombre='"+allComp.getComboBoxProd().getSelectedItem()+"'");
                            allComp.getCampoPrecioNuevo().setText("");
                            actualizarCampoPrecio();
                        }
                    }
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(thisPane,"Error, verifique los campos e intente nuevamente");
                }
            }
        });
    }

    private void actualizarCampoPrecio (){
        try{
            Statement statement=null;
            try {
                Connection conectionDataB= DriverManager.getConnection("jdbc:mysql://localhost:3306/cenaduria","root","");
                statement = conectionDataB.createStatement();
            }catch (Exception e){
                System.out.println("ERROR AL CONECTARSE A LA BASE DE DATOS: "+e.getMessage());
            }
            ResultSet resultado = statement.executeQuery("SELECT precio FROM productos WHERE nombre='"+allComp.getComboBoxProd().getSelectedItem()+"'");
            while (resultado.next()){
                allComp.getCampoPrecioActual().setText(resultado.getString(1));
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(thisPane,"Error al actualizar TextField: "+e.getMessage());
        }
    }

    public void actualizarProductos (){
        try{
            allComp.getComboBoxProd().removeAllItems();
            ResultSet resultado = allData.getMainStatementDB().executeQuery("SELECT nombre FROM productos");
            while (resultado.next()){
                allComp.getComboBoxProd().addItem(resultado.getString(1));
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(thisPane,"Error al actualizar ComboBox: "+e.getMessage());
        }
    }

    private void configLayout (){
        AutoCompleteDecorator.decorate(allComp.getComboBoxProd());
        allComp.getComboBoxProd().setFont(new Font("Times New Roman",Font.BOLD,60));
        add(allComp.getComboBoxProd(),"width 800!,height 150!,align right");
        add(allComp.getEraseProductButton(),"align center, wrap");
        allComp.getEtiquetaActual().setFont(new Font("Times New Roman",Font.BOLD,48));
        add(allComp.getEtiquetaActual(),"align center");
        allComp.getCampoPrecioActual().setEnabled(false);
        allComp.getCampoPrecioActual().setFont(new Font("Times New Roman",Font.BOLD,40));
        add(allComp.getCampoPrecioActual(),"width 550!,height 110!,align left,wrap");
        allComp.getEtiquetaNueva().setFont(new Font("Times New Roman",Font.BOLD,48));
        add(allComp.getEtiquetaNueva(),"align center");
        allComp.getCampoPrecioNuevo().setFont(new Font("Times New Roman",Font.BOLD,40));
        add(allComp.getCampoPrecioNuevo(),"width 550!,height 110!,align left,wrap");
        add(allComp.getBotonCambiarPrecio(),"align center");
        add(allComp.getBotonVolver(),"align left");
    }


}
