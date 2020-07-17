package com.company;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;

public class ActionWhenClosing implements WindowListener {
    private MainData allData;
    public ActionWhenClosing (MainData allData){
        this.allData=allData;
    }
    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {
        try {
            allData.getMainStatementDB().close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        allData.getReportFrame().dispose();
        allData.getMainWindow().dispose();
        allData.getAddNewProduct().dispose();
        allData.getCuentaFrame().dispose();
        allData.getMainTableManager().dispose();
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
