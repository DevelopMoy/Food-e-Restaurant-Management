package com.company;

import com.company.DataStructures.Table;

import javax.swing.*;
import java.util.ArrayList;

public class MainData {
    private ArrayList<Table> mainTableArray = new ArrayList<>();
    private JFrame mainWindow; //THE MAIN FRAME
    private JFrame mainTableManager; // FRAME THAT CONTAINS THE RESTAURANT TABLES

    public MainData() {
        tableConfig();
    }

    public void setMainWindow(JFrame mainWindow) {
        this.mainWindow = mainWindow;
    }

    public void setMainTableManager(JFrame mainTableManager) {
        this.mainTableManager = mainTableManager;
    }

    public JFrame getMainWindow() {
        return mainWindow;
    }

    public JFrame getMainTableManager() {
        return mainTableManager;
    }

    private void tableConfig(){
        for (int i=0;i<12;i++){
            int numTable=i+1;
            JButton availableTableButton=new JButton(new ImageIcon("images/Mesas/Available/"+numTable+"_.png"));
            JButton usedTableButton=new JButton(new ImageIcon("images/Mesas/Used/"+numTable+"_.png"));
            mainTableArray.add(new Table(numTable,availableTableButton,usedTableButton));
        }
    }

    public ArrayList<Table> getMainTableArray() {
        return mainTableArray;
    }
}
