/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "combos")
public class Combos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String abastece;
    private String imagen;
    private String sinopsis;
    private float precio;
    private String oferta;
    
    @OneToMany(mappedBy = "combos")
    @JsonManagedReference
    private List<Tb_Pag_Combos> detalles_combos;

    public Combos() {
    }

    public Combos(Long id, String nombre, String abastece, String imagen, String sinopsis, float precio, String oferta, List<Tb_Pag_Combos> detalles_combos) {
        this.id = id;
        this.nombre = nombre;
        this.abastece = abastece;
        this.imagen = imagen;
        this.sinopsis = sinopsis;
        this.precio = precio;
        this.oferta = oferta;
        this.detalles_combos = detalles_combos;
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

    public String getAbastece() {
        return abastece;
    }

    public void setAbastece(String abastece) {
        this.abastece = abastece;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getOferta() {
        return oferta;
    }

    public void setOferta(String oferta) {
        this.oferta = oferta;
    }

    public List<Tb_Pag_Combos> getDetalles_combos() {
        return detalles_combos;
    }

    public void setDetalles_combos(List<Tb_Pag_Combos> detalles_combos) {
        this.detalles_combos = detalles_combos;
    }

    
    
    
    
    
}
