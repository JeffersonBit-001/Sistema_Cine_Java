/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

/**
 *
 * @author JEFFERSON
 */
@Entity
@Table(name = "pelicula")
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private float precio;
    private String sinopsis;
    private String director;
    private String idioma;
    private String imagen;
    private String disponible;
    private Long id_salas;
    private String link;
    private String estado;
    
    @OneToMany(mappedBy = "pelicula")
    @JsonManagedReference
    private List<Tb_Pag_Peliculas> detallesPeliculas;

    public Pelicula() {
    }

    public Pelicula(Long id, String nombre, String descripcion, float precio, String sinopsis, String director, String idioma, String imagen, String disponible, Long id_salas, String link, String estado, List<Tb_Pag_Peliculas> detallesPeliculas) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.sinopsis = sinopsis;
        this.director = director;
        this.idioma = idioma;
        this.imagen = imagen;
        this.disponible = disponible;
        this.id_salas = id_salas;
        this.link = link;
        this.estado = estado;
        this.detallesPeliculas = detallesPeliculas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDisponible() {
        return disponible;
    }

    public void setDisponible(String disponible) {
        this.disponible = disponible;
    }

    public Long getId_salas() {
        return id_salas;
    }

    public void setId_salas(Long id_salas) {
        this.id_salas = id_salas;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Tb_Pag_Peliculas> getDetallesPeliculas() {
        return detallesPeliculas;
    }

    public void setDetallesPeliculas(List<Tb_Pag_Peliculas> detallesPeliculas) {
        this.detallesPeliculas = detallesPeliculas;
    }
    
    
    
    
    
}
