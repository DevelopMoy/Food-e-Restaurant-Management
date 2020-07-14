package com.company.Frames;

import com.company.DataStructures.Table;
import com.company.MainData;
import com.company.Panels.CuentaPanel;
import com.company.Panels.TableManagePanel;
import com.company.SwingComponents;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CuentaFrame extends JFrame {
    private CuentaPanel panelPrincipal;
    public CuentaFrame(SwingComponents allComp, MainData allData){
        setTitle("Cenaduria Loma Bonita : Food-e");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Dimension displayScreen = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(1366, 768);
        setMinimumSize(new Dimension(1366,768));
        setLocationRelativeTo(null);
        panelPrincipal=new CuentaPanel(allComp,allData,this);
        add(panelPrincipal);
        setVisible(false);
    }

    public void actualizarDatosCuenta(Table mesa){
        panelPrincipal.actualizarComponentes(mesa);
    }
}
