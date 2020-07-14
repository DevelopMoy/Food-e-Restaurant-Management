package com.company.DataStructures;

import javax.swing.*;
import java.util.ArrayList;

public class Mesa {
    private int numTable;
    private JButton availableTableButton;
    private JButton usedTableButton;
    private boolean isAvailable;
    private ArrayList <Product> accountProducts=new ArrayList<>();//Will contain the data of the account for this table

    public Mesa(int numTable, JButton availableTableButton, JButton usedTableButton) {
        this.numTable = numTable;
        isAvailable=true;
        this.availableTableButton = availableTableButton;
        this.usedTableButton = usedTableButton;
    }

    public ArrayList<Product> getAccountProducts() {
        return accountProducts;
    }

    public int getNumTable() {
        return numTable;
    }

    public void setNumTable(int numTable) {
        this.numTable = numTable;
    }

    public JButton getAvailableTableButton() {
        return availableTableButton;
    }

    public void setAvailableTableButton(JButton availableTableButton) {
        this.availableTableButton = availableTableButton;
    }

    public JButton getUsedTableButton() {
        return usedTableButton;
    }

    public void setUsedTableButton(JButton usedTableButton) {
        this.usedTableButton = usedTableButton;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Table{" +
                "numTable=" + numTable +
                ", availableTableButton=" + availableTableButton +
                ", usedTableButton=" + usedTableButton +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
