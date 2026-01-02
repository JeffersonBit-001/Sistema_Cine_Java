/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dto;

import com.example.demo.entidades.Tb_Pag_Peliculas;

/**
 *
 * @author JEFFERSON
 */
public class Tb_Pag_PeliculasDTO {
    private Long id;
    private int cantidad;
    private float precioTotal;
    private PeliculaDTO pelicula;

    public Tb_Pag_PeliculasDTO(Tb_Pag_Peliculas detalle) {
        this.id = detalle.getId();
        this.cantidad = detalle.getCantidad();
        this.precioTotal = detalle.getPrecio_total();
        
    }

    public Tb_Pag_PeliculasDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(float precioTotal) {
        this.precioTotal = precioTotal;
    }

    public PeliculaDTO getPelicula() {
        return pelicula;
    }

    public void setPelicula(PeliculaDTO pelicula) {
        this.pelicula = pelicula;
    }

    
}
