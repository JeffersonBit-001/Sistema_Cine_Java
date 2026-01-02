/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author JEFFERSON
 */
public class HistorialCliente {
    private int idPago;
    private String fecha;
    private String hora;
    private String nombrePelicula;
    private float precioPelicula;
    private int cantPelicula;
    private float totalPelicula;
    private String imgPelicula;
    
    private String asiento;
    
    private String nombreBebida;
    private float precioBebida;
    private int cantidadBebida;
    private float totalBebida;
    private String imgBebida;
    
    private String nombreCombos;
    private float precioCombos;
    private int cantidadCombos;
    private float totalCombos;
    private String imgCombos;
    
    
    private String nombreDulceria;
    private float precioDulceria;
    private int cantidadDulceria;
    private float totalDulceria;
    private String imgDulceria;

    private String nombreCliente;

    public HistorialCliente(int idPago, String fecha, String hora, String nombrePelicula, float precioPelicula, int cantPelicula, float totalPelicula, String imgPelicula, String asiento, String nombreBebida, float precioBebida, int cantidadBebida, float totalBebida, String imgBebida, String nombreCombos, float precioCombos, int cantidadCombos, float totalCombos, String imgCombos, String nombreDulceria, float precioDulceria, int cantidadDulceria, float totalDulceria, String imgDulceria, String nombreCliente) {
        this.idPago = idPago;
        this.fecha = fecha;
        this.hora = hora;
        this.nombrePelicula = nombrePelicula;
        this.precioPelicula = precioPelicula;
        this.cantPelicula = cantPelicula;
        this.totalPelicula = totalPelicula;
        this.imgPelicula = imgPelicula;
        this.asiento = asiento;
        this.nombreBebida = nombreBebida;
        this.precioBebida = precioBebida;
        this.cantidadBebida = cantidadBebida;
        this.totalBebida = totalBebida;
        this.imgBebida = imgBebida;
        this.nombreCombos = nombreCombos;
        this.precioCombos = precioCombos;
        this.cantidadCombos = cantidadCombos;
        this.totalCombos = totalCombos;
        this.imgCombos = imgCombos;
        this.nombreDulceria = nombreDulceria;
        this.precioDulceria = precioDulceria;
        this.cantidadDulceria = cantidadDulceria;
        this.totalDulceria = totalDulceria;
        this.imgDulceria = imgDulceria;
        this.nombreCliente = nombreCliente;
    }

    public HistorialCliente() {
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    public float getPrecioPelicula() {
        return precioPelicula;
    }

    public void setPrecioPelicula(float precioPelicula) {
        this.precioPelicula = precioPelicula;
    }

    public int getCantPelicula() {
        return cantPelicula;
    }

    public void setCantPelicula(int cantPelicula) {
        this.cantPelicula = cantPelicula;
    }

    public float getTotalPelicula() {
        return totalPelicula;
    }

    public void setTotalPelicula(float totalPelicula) {
        this.totalPelicula = totalPelicula;
    }

    public String getImgPelicula() {
        return imgPelicula;
    }

    public void setImgPelicula(String imgPelicula) {
        this.imgPelicula = imgPelicula;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    public String getNombreBebida() {
        return nombreBebida;
    }

    public void setNombreBebida(String nombreBebida) {
        this.nombreBebida = nombreBebida;
    }

    public float getPrecioBebida() {
        return precioBebida;
    }

    public void setPrecioBebida(float precioBebida) {
        this.precioBebida = precioBebida;
    }

    public int getCantidadBebida() {
        return cantidadBebida;
    }

    public void setCantidadBebida(int cantidadBebida) {
        this.cantidadBebida = cantidadBebida;
    }

    public float getTotalBebida() {
        return totalBebida;
    }

    public void setTotalBebida(float totalBebida) {
        this.totalBebida = totalBebida;
    }

    public String getImgBebida() {
        return imgBebida;
    }

    public void setImgBebida(String imgBebida) {
        this.imgBebida = imgBebida;
    }

    public String getNombreCombos() {
        return nombreCombos;
    }

    public void setNombreCombos(String nombreCombos) {
        this.nombreCombos = nombreCombos;
    }

    public float getPrecioCombos() {
        return precioCombos;
    }

    public void setPrecioCombos(float precioCombos) {
        this.precioCombos = precioCombos;
    }

    public int getCantidadCombos() {
        return cantidadCombos;
    }

    public void setCantidadCombos(int cantidadCombos) {
        this.cantidadCombos = cantidadCombos;
    }

    public float getTotalCombos() {
        return totalCombos;
    }

    public void setTotalCombos(float totalCombos) {
        this.totalCombos = totalCombos;
    }

    public String getImgCombos() {
        return imgCombos;
    }

    public void setImgCombos(String imgCombos) {
        this.imgCombos = imgCombos;
    }

    public String getNombreDulceria() {
        return nombreDulceria;
    }

    public void setNombreDulceria(String nombreDulceria) {
        this.nombreDulceria = nombreDulceria;
    }

    public float getPrecioDulceria() {
        return precioDulceria;
    }

    public void setPrecioDulceria(float precioDulceria) {
        this.precioDulceria = precioDulceria;
    }

    public int getCantidadDulceria() {
        return cantidadDulceria;
    }

    public void setCantidadDulceria(int cantidadDulceria) {
        this.cantidadDulceria = cantidadDulceria;
    }

    public float getTotalDulceria() {
        return totalDulceria;
    }

    public void setTotalDulceria(float totalDulceria) {
        this.totalDulceria = totalDulceria;
    }

    public String getImgDulceria() {
        return imgDulceria;
    }

    public void setImgDulceria(String imgDulceria) {
        this.imgDulceria = imgDulceria;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    
    
    
}
