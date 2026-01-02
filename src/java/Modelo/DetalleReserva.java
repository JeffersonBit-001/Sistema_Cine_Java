/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author JEFFERSON
 */
public class DetalleReserva {
    private PeliIndex peli;
    private Sedes sede;
    private Hora hora;
    private Dia dia;
    private int cantidadEntradas;
    private float totalAsientosPrecio;
    private ArrayList<Asientos> arrayAsientos;
    private ArrayList<CarritoCombos> arrayCarritoCombos;
    private float precioCarritoCompras=0;
    private float precioTotal;
    private String codigoPago;
    private int idReserva;

    public DetalleReserva() {
    }

    
    public void calcularTotalNeto(){
        this.precioTotal = peli.getPrecio()*cantidadEntradas+precioCarritoCompras;
    }
    
    public void calcularPrecioCarritoCompras() {
        float total = 0;
        for (CarritoCombos combo : arrayCarritoCombos) {
            
            String precioStr = combo.getPrecio();
            float precio = extraerPrecio(precioStr);
            total += precio*combo.getCantidad();
        }
        this.precioCarritoCompras = total;
    }

    private float extraerPrecio(String precioStr) {
        
        precioStr = precioStr.replace("S/", "").trim();
        try {
            return Float.parseFloat(precioStr);
        } catch (NumberFormatException e) {
            return 0.0f; 
        }
    }

    public DetalleReserva(PeliIndex peli, Sedes sede, Hora hora, Dia dia, int cantidadEntradas, float totalAsientosPrecio, ArrayList<Asientos> arrayAsientos, ArrayList<CarritoCombos> arrayCarritoCombos, float precioTotal, String codigoPago, int idReserva) {
        this.peli = peli;
        this.sede = sede;
        this.hora = hora;
        this.dia = dia;
        this.cantidadEntradas = cantidadEntradas;
        this.totalAsientosPrecio = totalAsientosPrecio;
        this.arrayAsientos = arrayAsientos;
        this.arrayCarritoCombos = arrayCarritoCombos;
        this.precioTotal = precioTotal;
        this.codigoPago = codigoPago;
        this.idReserva = idReserva;
    }

    

    
    public Hora getHora() {
        return hora;
    }

    public void setHora(Hora hora) {
        this.hora = hora;
    }

    public PeliIndex getPeli() {
        return peli;
    }

    public void setPeli(PeliIndex peli) {
        this.peli = peli;
    }

    public Sedes getSede() {
        return sede;
    }

    public void setSede(Sedes sede) {
        this.sede = sede;
    }

    public Dia getDia() {
        return dia;
    }

    public void setDia(Dia dia) {
        this.dia = dia;
    }

    public int getCantidadEntradas() {
        return cantidadEntradas;
    }

    public void setCantidadEntradas(int cantidadEntradas) {
        this.cantidadEntradas = cantidadEntradas;
    }

    public float getTotalAsientosPrecio() {
        return totalAsientosPrecio;
    }

    public void setTotalAsientosPrecio(float totalAsientosPrecio) {
        this.totalAsientosPrecio = totalAsientosPrecio;
    }

    public ArrayList<Asientos> getArrayAsientos() {
        return arrayAsientos;
    }

    public void setArrayAsientos(ArrayList<Asientos> arrayAsientos) {
        this.arrayAsientos = arrayAsientos;
    }

    public ArrayList<CarritoCombos> getArrayCarritoCombos() {
        return arrayCarritoCombos;
    }

    public void setArrayCarritoCombos(ArrayList<CarritoCombos> arrayCarritoCombos) {
        this.arrayCarritoCombos = arrayCarritoCombos;
    }
    
    
    public float getPrecioCarritoCompras() {
        return precioCarritoCompras;
    }

    public void setPrecioCarritoCompras(float precioCarritoCompras) {
        this.precioCarritoCompras = precioCarritoCompras;
    }

    public float getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(float precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getCodigoPago() {
        return codigoPago;
    }

    public void setCodigoPago(String codigoPago) {
        this.codigoPago = codigoPago;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }
    
    
    
}
