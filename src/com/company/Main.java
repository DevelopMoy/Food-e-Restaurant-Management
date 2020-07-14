package com.company;

import com.company.Frames.MainWindowFrame;
import com.company.Frames.TableManagerFrame;
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
        //se agregan los frames creados a la variable compartida, para tener control de su visibilidad
        allData.setMainTableManager(mf);
        allData.setMainWindow(mw);
    }
}
