package com.company.Frames;

import com.company.ActionWhenClosing;
import com.company.MainData;
import com.company.Panels.MainWindowPanel;
import com.company.SwingComponents;

import javax.swing.*;
import java.awt.*;

public class MainWindowFrame extends JFrame {
    public MainWindowFrame(SwingComponents allComponents,MainData allData){
        addWindowListener(new ActionWhenClosing(allData));
        this.setIconImage(new ImageIcon("images/icono.png").getImage());
        setTitle("Cenaduria Loma Bonita : Food-e");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Dimension displayScreen = Toolkit.getDefaultToolkit().getScreenSize();
        setSize((int)displayScreen.getWidth(), (int)displayScreen.getHeight());
        setMinimumSize(new Dimension(1366,768));
        setLocationRelativeTo(null);
        add(new MainWindowPanel(allComponents,allData,this));
        setVisible(true);
    }
}
