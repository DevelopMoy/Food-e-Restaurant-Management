package com.company.Frames;

import com.company.ActionWhenClosing;
import com.company.MainData;
import com.company.Panels.ReportPanel;
import com.company.Panels.SearchPanel;
import com.company.SwingComponents;

import javax.swing.*;
import java.awt.*;

public class SearchFrame extends JFrame {
    private SearchPanel panelPrincipal;

    public SearchFrame(SwingComponents allComp,MainData allData){
        addWindowListener(new ActionWhenClosing(allData));
        setTitle("Cenaduria Loma Bonita : Food-e");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Dimension displayScreen = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(1366, 768);
        setMinimumSize(new Dimension(1366,768));
        setLocationRelativeTo(null);
        panelPrincipal=new SearchPanel(allComp,allData,this);
        add(panelPrincipal);
        setVisible(false);
    }

    public void actualizarComboBox (){
        panelPrincipal.actualizarProductos();
    }
}
