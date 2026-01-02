/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dto;

import com.example.demo.entidades.Pelicula;

/**
 *
 * @author JEFFERSON
 */
public class PeliculaDTO {
    private Long peliculaId;
    private String nombrePelicula;
    private float precio;

    public PeliculaDTO(Long peliculaId, String nombrePelicula, float precio) {
        this.peliculaId = peliculaId;
        this.nombrePelicula = nombrePelicula;
        this.precio = precio;
    }

    // Getters and Setters
    public Long getPeliculaId() {
        return peliculaId;
    }

    public void setPeliculaId(Long peliculaId) {
        this.peliculaId = peliculaId;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
    
}