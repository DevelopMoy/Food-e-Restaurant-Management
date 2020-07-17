package com.company.DataStructures;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ReportTableModel extends AbstractTableModel {
    private ArrayList<ReportField>dataSet;
    public ReportTableModel (ArrayList <ReportField> dataSet){
        this.dataSet=dataSet;
    }

    @Override
    public int getRowCount() {
        return dataSet.size();
    }

    @Override
    public String getColumnName(int row){
        switch (row){
            case 0:
                return "Producto";
            case 1:
                return "Fecha";
            case 2:
                return "Monto Vendido";
            default:
                return "";
        }
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex==0){
            return dataSet.get(rowIndex).getNombrePlatillo();
        }else{
            if (columnIndex==1){
                return dataSet.get(rowIndex).getFecha();
            }else{
                if (columnIndex==2){
                    return dataSet.get(rowIndex).getMontoVenta();
                }
            }
        }
        return "";
    }
}
