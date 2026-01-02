/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author JEFFERSON
 */
public class DetallesPelicula {
    private int id;
    private PeliIndex peli;
    private Sedes sd;
    private Hora hora;
    private CategoriaPelicula categoria;
    private Dia dia;
    private Vista vista;

    public DetallesPelicula() {
    }

    public DetallesPelicula(int id, PeliIndex peli, Sedes sd, Hora hora, CategoriaPelicula categoria, Dia dia, Vista vista) {
        this.id = id;
        this.peli = peli;
        this.sd = sd;
        this.hora = hora;
        this.categoria = categoria;
        this.dia = dia;
        this.vista = vista;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PeliIndex getPeli() {
        return peli;
    }

    public void setPeli(PeliIndex peli) {
        this.peli = peli;
    }

    public Sedes getSd() {
        return sd;
    }

    public void setSd(Sedes sd) {
        this.sd = sd;
    }

    public Hora getHora() {
        return hora;
    }

    public void setHora(Hora hora) {
        this.hora = hora;
    }

    public CategoriaPelicula getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaPelicula categoria) {
        this.categoria = categoria;
    }

    public Dia getDia() {
        return dia;
    }

    public void setDia(Dia dia) {
        this.dia = dia;
    }

    public Vista getVista() {
        return vista;
    }

    public void setVista(Vista vista) {
        this.vista = vista;
    }

    
    
    
    
}
