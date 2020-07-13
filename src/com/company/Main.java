package com.company;

import com.company.Frames.MainWindowFrame;
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
        new MainWindowFrame(new SwingComponents(),new MainData()).setVisible(true);
    }
}
