package com.company;

import com.company.DataStructures.Mesa;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class MainData {
    private Statement mainStatementDB; //CONECTOR PARA BASE DE DATOS

    private ArrayList<Mesa> mainMesaArray = new ArrayList<>();
    private JFrame mainWindow; //THE MAIN FRAME
    private JFrame mainTableManager; // FRAME THAT CONTAINS THE RESTAURANT TABLES
    private JFrame cuentaFrame; //PANEL QUE CONTIENE LA CUENTA DE LA MESA
    private JFrame addNewProduct;
    private JFrame reportFrame;
    private JFrame searchFrame;

    public MainData() {
        tableConfig();
        initConnectionToDB();
    }

    public static double getPriceFromDataBase (String name, Statement mainStatementDB){
        try {
            ResultSet res=mainStatementDB.executeQuery("SELECT precio FROM productos WHERE nombre='"+name+"'");
            if (res.next()){
                return Double.parseDouble(res.getString(1));
            }
            return 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public JFrame getSearchFrame() {
        return searchFrame;
    }

    public void setSearchFrame(JFrame searchFrame) {
        this.searchFrame = searchFrame;
    }

    public JFrame getAddNewProduct() {
        return addNewProduct;
    }

    public void setAddNewProduct(JFrame addNewProduct) {
        this.addNewProduct = addNewProduct;
    }

    public static int getIdFromDataBase (String prodName, Statement mainStatementDB){
        try {
            ResultSet res=mainStatementDB.executeQuery("SELECT id FROM productos WHERE nombre='"+prodName+"'");
            if (res.next()){
                return Integer.parseInt(res.getString(1));
            }
            return 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
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

    public JFrame getReportFrame() {
        return reportFrame;
    }

    public void setReportFrame(JFrame reportFrame) {
        this.reportFrame = reportFrame;
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
