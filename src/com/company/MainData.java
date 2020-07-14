package com.company;

import com.company.DataStructures.Mesa;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;

public class MainData {
    private Statement mainStatementDB; //CONECTOR PARA BASE DE DATOS

    private ArrayList<Mesa> mainMesaArray = new ArrayList<>();
    private JFrame mainWindow; //THE MAIN FRAME
    private JFrame mainTableManager; // FRAME THAT CONTAINS THE RESTAURANT TABLES
    private JFrame cuentaFrame; //PANEL QUE CONTIENE LA CUENTA DE LA MESA

    public MainData() {
        tableConfig();
        initConnectionToDB();
    }

    public void initConnectionToDB (){
        try {
            Connection conectionDataB= DriverManager.getConnection("jdbc:mysql://localhost:3306/cenaduria","root","");
            mainStatementDB = conectionDataB.createStatement();
        }catch (Exception e){
            System.out.println("ERROR AL CONECTARSE A LA BASE DE DATOS: "+e.getMessage());
        }
    }

    private void tableConfig(){
        for (int i=0;i<12;i++){
            int numTable=i+1;
            JButton availableTableButton=new JButton(new ImageIcon("images/Mesas/Available/"+numTable+"_.png"));
            JButton usedTableButton=new JButton(new ImageIcon("images/Mesas/Used/"+numTable+"_.png"));
            mainMesaArray.add(new Mesa(numTable,availableTableButton,usedTableButton));
        }
    }

    public Statement getMainStatementDB() {
        return mainStatementDB;
    }

    public void setMainWindow(JFrame mainWindow) {
        this.mainWindow = mainWindow;
    }

    public void setMainTableManager(JFrame mainTableManager) {
        this.mainTableManager = mainTableManager;
    }

    public void setCuentaFrame(JFrame cuentaFrame) {
        this.cuentaFrame = cuentaFrame;
    }

    public JFrame getCuentaFrame() {
        return cuentaFrame;
    }

    public JFrame getMainWindow() {
        return mainWindow;
    }

    public JFrame getMainTableManager() {
        return mainTableManager;
    }
    public ArrayList<Mesa> getMainMesaArray() {
        return mainMesaArray;
    }
}
