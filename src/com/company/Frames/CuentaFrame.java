package com.company.Frames;

import com.company.ActionWhenClosing;
import com.company.DataStructures.Mesa;
import com.company.MainData;
import com.company.Panels.CuentaPanel;
import com.company.SwingComponents;

import javax.swing.*;
import java.awt.*;

public class CuentaFrame extends JFrame {
    private CuentaPanel panelPrincipal;
    public CuentaFrame(SwingComponents allComp, MainData allData){
        addWindowListener(new ActionWhenClosing(allData));
        this.setIconImage(new ImageIcon("images/icono.png").getImage());
        setTitle("Cenaduria Loma Bonita : Food-e");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Dimension displayScreen = Toolkit.getDefaultToolkit().getScreenSize();
        setSize((int)displayScreen.getWidth(), (int)displayScreen.getHeight());
        setMinimumSize(new Dimension(1366,768));
        setLocationRelativeTo(null);
        panelPrincipal=new CuentaPanel(allComp,allData,this);
        add(panelPrincipal);
        setVisible(false);
    }

    public void actualizarDatosCuenta(Mesa mesa){
        panelPrincipal.actualizarComponentes(mesa);
    }
}
