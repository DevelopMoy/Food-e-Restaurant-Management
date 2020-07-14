package com.company.DataStructures;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ProductTableModel extends AbstractTableModel {
    ArrayList <Product> prod;
    public ProductTableModel (ArrayList<Product> productos){
        prod=productos;
    }
    @Override
    public int getRowCount() {
        return prod.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex==0){
            return prod.get(rowIndex).getIdProduct();
        }else {
            if (columnIndex==1){
                return prod.get(rowIndex).getProductName();
            }else {
                if (columnIndex==2){
                    return prod.get(rowIndex).getPrice();
                }else {
                    if (columnIndex==3){
                        return prod.get(rowIndex).getCantidad();
                    }else{
                        return prod.get(rowIndex).getCantidad()*prod.get(rowIndex).getCantidad();
                    }
                }
            }
        }
    }
    @Override
    public String getColumnName (int c){
        switch (c){
            case 0:
                return "ID";
            case 1:
                return "Platillo";
            case 2:
                return "Precio Unitario";
            case 3:
                return "Cantidad";
            case 4:
                return "Precio Total";
            default:
                return "";
        }
    }
}
