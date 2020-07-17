package com.company.DataStructures;

public class ReportField {
    private String nombrePlatillo;
    private String fecha;
    private double montoVenta;

    public ReportField(String name, String fecha, double montoVenta) {
        this.nombrePlatillo=name;
        this.fecha = fecha;
        this.montoVenta = montoVenta;
    }

    public String getFecha() {
        return fecha;
    }

    public String getNombrePlatillo() {
        return nombrePlatillo;
    }

    public void setNombrePlatillo(String nombrePlatillo) {
        this.nombrePlatillo = nombrePlatillo;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getMontoVenta() {
        return montoVenta;
    }

    public void setMontoVenta(double montoVenta) {
        this.montoVenta = montoVenta;
    }
}
