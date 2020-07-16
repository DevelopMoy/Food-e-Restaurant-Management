package com.company.Panels;

import com.company.MainData;
import com.company.SwingComponents;
import net.miginfocom.swing.MigLayout;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindowPanel extends JPanel {
    private MigLayout mainLayout = new MigLayout("fillx,filly","[shrink][shrink,grow][shrink,grow][shrink,grow]","[][]40[]");
    private SwingComponents allComp;
    private MainData allData;
    private JFrame superComp;

    public MainWindowPanel(SwingComponents allComponents, MainData allData, JFrame superComp){
        this.superComp=superComp;
        allComp=allComponents;
        this.allData=allData;
        setLayout(mainLayout);
        layoutConfig();
        configActions();
    }

    private void configActions(){
        allComp.getMainWindSellButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allData.getMainWindow().setVisible(false);
                allData.getMainTableManager().setVisible(true);
            }
        });
        allComp.getMainWindAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allData.getMainWindow().setVisible(false);
                allData.getAddNewProduct().setVisible(true);
            }
        });
    }

    private void layoutConfig(){
        add(new JLabel(""));
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
