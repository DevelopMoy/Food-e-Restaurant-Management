package com.company.Panels;

import com.company.MainData;
import com.company.SwingComponents;
import net.miginfocom.swing.MigLayout;
import javax.swing.*;

public class MainWindowPanel extends JPanel {
    private MigLayout mainLayout = new MigLayout("fillx,filly","[][grow][grow][grow]","[][]40[]");
    private SwingComponents allComp;
    private MainData allData;

    public MainWindowPanel(SwingComponents allComponents, MainData allData){
        allComp=allComponents;
        this.allData=allData;
        setLayout(mainLayout);
        layoutConfig();
    }

    private void layoutConfig(){
        add(new JLabel(" "));
        add(allComp.getLogoMainWindow(),"span 2,align center");
        add(new JLabel(" "),"wrap");
        add (new JLabel(" "));
        add(allComp.getMainWindSellButton(),"align center");
        add(allComp.getMainWindReportButton(),"align center");
        add(new JLabel(" "),"wrap");
        add(allComp.getMainWindAddButton(),"split 2");
        add(allComp.getMainWindSearchButton());
        add(new JLabel( " "));
        add(new JLabel(" "));
        add(new JLabel(" "));
    }
}
