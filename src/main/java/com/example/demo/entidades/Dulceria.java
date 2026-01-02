/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.entidades;

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
@Table(name = "dulceria")
public class Dulceria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_dulceria;
    private String nom_dulceria;
    private String descripcion_dulceria;
    private String img_dulceria;
    private float precio_dulceria;
    private String imagen_diseno;
    
    
    @OneToMany(mappedBy = "dulceria")
    @JsonManagedReference
    private List<Tb_Pag_Dulceria> detalles_dulceria;

    public Dulceria() {
    }

    public Dulceria(Long id_dulceria, String nom_dulceria, String descripcion_dulceria, String img_dulceria, float precio_dulceria, String imagen_diseno, List<Tb_Pag_Dulceria> detalles_dulceria) {
        this.id_dulceria = id_dulceria;
        this.nom_dulceria = nom_dulceria;
        this.descripcion_dulceria = descripcion_dulceria;
        this.img_dulceria = img_dulceria;
        this.precio_dulceria = precio_dulceria;
        this.imagen_diseno = imagen_diseno;
        this.detalles_dulceria = detalles_dulceria;
    }

    public Long getId_dulceria() {
        return id_dulceria;
    }

    public void setId_dulceria(Long id_dulceria) {
        this.id_dulceria = id_dulceria;
    }

    public String getNom_dulceria() {
        return nom_dulceria;
    }

    public void setNom_dulceria(String nom_dulceria) {
        this.nom_dulceria = nom_dulceria;
    }

    public String getDescripcion_dulceria() {
        return descripcion_dulceria;
    }

    public void setDescripcion_dulceria(String descripcion_dulceria) {
        this.descripcion_dulceria = descripcion_dulceria;
    }

    public String getImg_dulceria() {
        return img_dulceria;
    }

    public void setImg_dulceria(String img_dulceria) {
        this.img_dulceria = img_dulceria;
    }

    public float getPrecio_dulceria() {
        return precio_dulceria;
    }

    public void setPrecio_dulceria(float precio_dulceria) {
        this.precio_dulceria = precio_dulceria;
    }

    public String getImagen_diseno() {
        return imagen_diseno;
    }

    public void setImagen_diseno(String imagen_diseno) {
        this.imagen_diseno = imagen_diseno;
    }

    public List<Tb_Pag_Dulceria> getDetalles_dulceria() {
        return detalles_dulceria;
    }

    public void setDetalles_dulceria(List<Tb_Pag_Dulceria> detalles_dulceria) {
        this.detalles_dulceria = detalles_dulceria;
    }
    
    
    
    
    
    
}
