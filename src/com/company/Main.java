package com.company;

import com.company.Frames.*;
import com.company.Panels.TableManagePanel;
import mdlaf.MaterialLookAndFeel;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel (new MaterialLookAndFeel());
        }
        catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace ();
        }
        MainData allData = new MainData();
        SwingComponents allComp=new SwingComponents();
        TableManagerFrame mf = new TableManagerFrame(allComp,allData);
        MainWindowFrame mw = new MainWindowFrame(allComp,allData);
        CuentaFrame cf= new CuentaFrame(allComp,allData);
        AddNewProductFrame pf=new AddNewProductFrame(allComp,allData);
        ReportFrame rf = new ReportFrame(allComp,allData);
        SearchFrame sf = new SearchFrame(allComp,allData);
        //se agregan los frames creados a la variable compartida, para tener control de su visibilidad
        allData.setSearchFrame(sf);
        allData.setMainTableManager(mf);
        allData.setMainWindow(mw);
        allData.setCuentaFrame(cf);
        allData.setAddNewProduct(pf);
        allData.setReportFrame(rf);
    }
}
