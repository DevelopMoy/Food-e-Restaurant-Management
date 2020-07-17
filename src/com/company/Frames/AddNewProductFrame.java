package com.company.Frames;

import com.company.ActionWhenClosing;
import com.company.MainData;
import com.company.Panels.AddNewProductPanel;
import com.company.Panels.CuentaPanel;
import com.company.SwingComponents;

import javax.swing.*;
import java.awt.*;

public class AddNewProductFrame extends JFrame {
    private AddNewProductPanel panelPrincipal;
    public AddNewProductFrame(SwingComponents allComp, MainData allData){
        setTitle("Cenaduria Loma Bonita : Food-e");
        addWindowListener(new ActionWhenClosing(allData));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Dimension displayScreen = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(1366, 768);
        setMinimumSize(new Dimension(1366,768));
        setLocationRelativeTo(null);
        panelPrincipal=new AddNewProductPanel(allComp,allData,this);
        add(panelPrincipal);
        setVisible(false);
    }
}
