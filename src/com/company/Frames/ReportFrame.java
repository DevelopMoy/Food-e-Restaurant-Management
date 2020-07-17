package com.company.Frames;

import com.company.ActionWhenClosing;
import com.company.MainData;
import com.company.Panels.AddNewProductPanel;
import com.company.Panels.ReportPanel;
import com.company.SwingComponents;

import javax.swing.*;
import java.awt.*;

public class ReportFrame extends JFrame {
    private ReportPanel panelPrincipal;
    public ReportFrame(SwingComponents allComp, MainData allData){
        addWindowListener(new ActionWhenClosing(allData));
        setTitle("Cenaduria Loma Bonita : Food-e");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Dimension displayScreen = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(1366, 768);
        setMinimumSize(new Dimension(1366,768));
        setLocationRelativeTo(null);
        panelPrincipal=new ReportPanel(allComp,allData,this);
        add(panelPrincipal);
        setVisible(false);
    }
}
