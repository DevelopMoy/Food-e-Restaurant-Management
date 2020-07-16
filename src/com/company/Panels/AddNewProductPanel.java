package com.company.Panels;

import com.company.DataStructures.Mesa;
import com.company.DataStructures.Product;
import com.company.DataStructures.ProductTableModel;
import com.company.MainData;
import com.company.SwingComponents;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddNewProductPanel extends JPanel {

    private SwingComponents allComp;
    private MainData allData;
    private JFrame superFrame;
    private MigLayout mainLayout = new MigLayout("fillx,filly","[grow][grow][grow][grow]","[][][][]");
    private JPanel thisPane;

    public AddNewProductPanel(SwingComponents allComp, MainData allData, JFrame superComp){
        setLayout(mainLayout);
        this.allComp=allComp;
        thisPane=this;
        this.allData=allData;
        superFrame=superComp;
        eventsConfig();
        layoutConfig();
    }

    private void eventsConfig (){
        allComp.getBotonFinalizarAdd().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Double precio=Double.parseDouble(allComp.getCampoPrecio().getText());
                    if (allComp.getCampoNombre().getText().compareTo("")==0||precio<0){
                        throw new Exception("verifique los datos e intente nuevamente");
                    }
                    allData.getMainStatementDB().executeUpdate("INSERT INTO productos VALUES(DEFAULT,'"+allComp.getCampoNombre().getText()+"',"+allComp.getCampoPrecio().getText()+")");
                    allComp.getCampoPrecio().setText("");
                    allComp.getCampoNombre().setText("");
                }catch (Exception x){
                    JOptionPane.showMessageDialog(thisPane,"Error: "+x.getMessage());
                }
            }
        });
        allComp.getBotonHomeAddProduct().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allComp.getCampoPrecio().setText("");
                allComp.getCampoNombre().setText("");
                allData.getAddNewProduct().setVisible(false);
                allData.getMainWindow().setVisible(true);
            }
        });
    }

    private void layoutConfig (){
        add(allComp.getEtiquetaTituloAdd(),"span,align center,wrap");
        add(allComp.getEtiquetaNombre(),"align right");
        allComp.getCampoNombre().setFont(new Font("Times New Roman",Font.BOLD,34));
        add(allComp.getCampoNombre(),"height 70!,width 500!,wrap");
        add(allComp.getEtiquetaPrecio(),"align right");
        allComp.getCampoPrecio().setFont(new Font("Times New Roman",Font.BOLD,34));
        add(allComp.getCampoPrecio(),"height 70!,width 400!,wrap");
        add(allComp.getBotonFinalizarAdd(),"align center");
        add(new JLabel(""));
        add(allComp.getBotonHomeAddProduct(),"align center");
    }
}
