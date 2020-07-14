package com.company.Panels;

import com.company.DataStructures.Product;
import com.company.DataStructures.Table;
import com.company.MainData;
import com.company.SwingComponents;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CuentaPanel extends JPanel {
    private SwingComponents allComp;
    private MainData allData;
    private JFrame superFrame;
    public CuentaPanel(SwingComponents allComp, MainData allData,JFrame superComp){
        this.allComp=allComp;
        this.allData=allData;
        superFrame=superComp;
        eventsConfig();
        layoutConfig();
    }

    public void actualizarComponentes(Table mesa){//SE ACTUALIZARAN TODOS LOS DATOS DE LA TABLA TOMANDO EN CUENTA LA MESA RECIBIDA POR PARAMETRO
        System.out.println(mesa);
    }

    private void layoutConfig(){
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
