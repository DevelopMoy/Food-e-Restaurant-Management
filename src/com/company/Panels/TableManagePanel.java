package com.company.Panels;

import com.company.DataStructures.Table;
import com.company.Frames.MainWindowFrame;
import com.company.MainData;
import com.company.SwingComponents;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TableManagePanel extends JPanel {
    private SwingComponents allComp;
    private MainData allData;
    private MigLayout mainLayout = new MigLayout("fillx,filly","[grow][grow][grow][grow]","[][][]");
    private JFrame parentFrame;

    public TableManagePanel (SwingComponents allComp, MainData allData, JFrame parentFrame){
        this.parentFrame=parentFrame;
        this.allComp=allComp;
        this.allData=allData;
        setLayout(mainLayout);
        layoutConfig();
        actionsConfig();
    }

    private void actionsConfig(){
        allComp.getTableManageHomeButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allData.getMainWindow().setVisible(true);
                allData.getMainTableManager().setVisible(false);
            }
        });
    }

    private void layoutConfig(){
        int index=0;
        add(allComp.getTableManageHomeButton(),"align center");
        add(allComp.getTableManageTittle(),"span 2,align center");
        add(new JLabel(" "),"wrap");
        for (Table e:allData.getMainTableArray()){
            if (index<3){
                if (e.isAvailable()){
                    add(e.getAvailableTableButton(),"align center");
                }else {
                    add(e.getUsedTableButton(),"align center");
                }
                index++;
            }else{//wrap
                if (e.isAvailable()){
                    add(e.getAvailableTableButton(),"align center,wrap");
                }else {
                    add(e.getUsedTableButton(),"align center,wrap");
                }
                index=0;
            }
        }
    }
}

