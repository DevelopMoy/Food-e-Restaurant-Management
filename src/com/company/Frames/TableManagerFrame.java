package com.company.Frames;

import com.company.ActionWhenClosing;
import com.company.MainData;
import com.company.Panels.MainWindowPanel;
import com.company.Panels.TableManagePanel;
import com.company.SwingComponents;

import javax.swing.*;
import java.awt.*;

public class TableManagerFrame extends JFrame {
    public TableManagerFrame(SwingComponents allComp, MainData allData){
        addWindowListener(new ActionWhenClosing(allData));
        setTitle("Cenaduria Loma Bonita : Food-e");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setIconImage(new ImageIcon("images/icono.png").getImage());
        Dimension displayScreen = Toolkit.getDefaultToolkit().getScreenSize();
        setSize((int)displayScreen.getWidth(), (int)displayScreen.getHeight());
        setMinimumSize(new Dimension(1366,768));
        setLocationRelativeTo(null);
        add(new TableManagePanel(allComp,allData,this));
    }
}
