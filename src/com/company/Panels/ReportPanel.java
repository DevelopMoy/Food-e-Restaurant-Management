package com.company.Panels;

import com.company.DataStructures.ReportField;
import com.company.DataStructures.ReportTableModel;
import com.company.MainData;
import com.company.SwingComponents;
import net.miginfocom.swing.MigLayout;
import javax.swing.*;
import javax.swing.text.DateFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;

public class ReportPanel extends JPanel {
    private SwingComponents allComp;
    private MainData allData;
    private JFrame superFrame;
    private MigLayout mainLayout = new MigLayout("fillx,filly","[grow][grow][grow][grow]","[][][]");
    private ArrayList <ReportField> arregloDatos=new ArrayList<>();
    private ReportTableModel modeloActualTabla = new ReportTableModel(arregloDatos);
    private JPanel thisPane;

    public ReportPanel(SwingComponents allComp, MainData allData, JFrame superComp){
        setLayout(mainLayout);
        this.allComp=allComp;
        thisPane=this;
        this.allData=allData;
        superFrame=superComp;
        eventsConfig();
        layoutConfig();
    }

    private void eventsConfig (){ //NOTA: SELECT * FROM ventas WHERE fecha BETWEEN '2020-07-15' AND '2020-07-16' ORDER BY `fecha`  DESC
        allComp.getBotonHomeReport().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                arregloDatos.clear();
                allComp.getCampoTotalReport().setText("");
                allData.getReportFrame().setVisible(false);
                allData.getMainWindow().setVisible(true);
            }
        });

        allComp.getBotonGenerarReporte().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                arregloDatos.clear();
                String fecha1 = DateFormat.getDateInstance().format(allComp.getCampoFecha().getValue());
                String fecha2 = DateFormat.getDateInstance().format(allComp.getCampoFecha2().getValue());
                double acum=0;
                try {
                    ResultSet resultado = allData.getMainStatementDB().executeQuery("SELECT productos.nombre,ventas.fecha,ventas.montoTotal FROM ventas LEFT JOIN productos ON ventas.id=productos.id WHERE ventas.fecha BETWEEN '"+formatDate(fecha1)+"' AND '"+formatDate(fecha2)+"'");
                    while (resultado.next()){
                        arregloDatos.add(new ReportField(resultado.getString(1),resultado.getString(2),Double.parseDouble(resultado.getString(3))));
                        acum+=Double.parseDouble(resultado.getString(3));
                    }
                    allComp.getCampoTotalReport().setText(String.valueOf(acum));
                    modeloActualTabla.fireTableDataChanged();
                } catch (SQLException throwables) {
                    JOptionPane.showMessageDialog(thisPane,"Error: "+throwables.getMessage());
                }

            }
        });

    }

    private String formatDate (String fecha){
        StringBuilder st=new StringBuilder();
        int acum=0;
        for (int i=0;i<fecha.length();i++){
            if (fecha.charAt(i) == '/') {
                break;
            }else{
                acum++;
            }
        }
        System.out.println("Acum:"+acum);
        if (acum==1){
            fecha="0"+fecha;
        }
        System.out.println(fecha);
        st.append(fecha.substring(6,10));
        st.append("-");
        st.append(fecha.substring(3,5));
        st.append("-");
        st.append(fecha.substring(0,2));
        return st.toString();
    }

    private void layoutConfig (){
        //CONFIGURE THE DATE SPINNERS
        JSpinner.DateEditor editor = new JSpinner.DateEditor(allComp.getCampoFecha(), "dd/MM/yyyy");
        DateFormatter formatter = (DateFormatter)editor.getTextField().getFormatter();
        formatter.setAllowsInvalid(false);
        formatter.setOverwriteMode(true);
        allComp.getCampoFecha().setEditor(editor);
        add(allComp.getCampoFecha());

        JSpinner.DateEditor editor2 = new JSpinner.DateEditor(allComp.getCampoFecha2(), "dd/MM/yyyy");
        DateFormatter formatter2 = (DateFormatter)editor2.getTextField().getFormatter();
        formatter2.setAllowsInvalid(false);
        formatter2.setOverwriteMode(true);
        allComp.getCampoFecha2().setEditor(editor2);
        //
        allComp.getCampoFecha().setFont(new Font("Times New Roman",Font.BOLD,34));
        add(allComp.getCampoFecha(),"width 280!,height 90!,align center");
        JLabel etiqueta = new JLabel("Hasta fecha: ");
        etiqueta.setFont(new Font("Times New Roman",Font.BOLD,38));
        add(etiqueta,"align center");
        allComp.getCampoFecha2().setFont(new Font("Times New Roman",Font.BOLD,34));
        add(allComp.getCampoFecha2(),"width 280!,height 90!,align center");
        add(allComp.getBotonGenerarReporte(),"align center,wrap");
        allComp.getTablaReport().setModel(modeloActualTabla);
        add(allComp.getContenedorTablaReport(),"width 1050!,height 540!,align center,span,wrap");
        allComp.getEtiquetaGanancias().setFont(new Font("Times New Roman",Font.BOLD,38));
        add(allComp.getEtiquetaGanancias(),"align right");
        allComp.getCampoTotalReport().setEnabled(false);
        allComp.getCampoTotalReport().setFont(new Font("Times New Roman",Font.BOLD,34));
        add(allComp.getCampoTotalReport(),"width 280!,height 55!,align center");
        add(new JLabel("   "));
        add(allComp.getBotonHomeReport());
    }
}
