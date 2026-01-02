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
@Table(name = "bebidas")
public class Bebidas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_bebidas;
    private String nombre_bebida;
    private String descripcion_bebida;
    private String img_bebida;
    private float precio;
    private String imagen_diseno;
    
    
    @OneToMany(mappedBy = "bebidas")
    @JsonManagedReference
    private List<Tb_Pag_Bebidas> detalles_Bebidas;

    public Bebidas() {
    }

    public Bebidas(Long id_bebidas, String nombre_bebida, String descripcion_bebida, String img_bebida, float precio, String imagen_diseno, List<Tb_Pag_Bebidas> detalles_Bebidas) {
        this.id_bebidas = id_bebidas;
        this.nombre_bebida = nombre_bebida;
        this.descripcion_bebida = descripcion_bebida;
        this.img_bebida = img_bebida;
        this.precio = precio;
        this.imagen_diseno = imagen_diseno;
        this.detalles_Bebidas = detalles_Bebidas;
    }

    public Long getId_bebidas() {
        return id_bebidas;
    }

    public void setId_bebidas(Long id_bebidas) {
        this.id_bebidas = id_bebidas;
    }

    public String getNombre_bebida() {
        return nombre_bebida;
    }

    public void setNombre_bebida(String nombre_bebida) {
        this.nombre_bebida = nombre_bebida;
    }

    public String getDescripcion_bebida() {
        return descripcion_bebida;
    }

    public void setDescripcion_bebida(String descripcion_bebida) {
        this.descripcion_bebida = descripcion_bebida;
    }

    public String getImg_bebida() {
        return img_bebida;
    }

    public void setImg_bebida(String img_bebida) {
        this.img_bebida = img_bebida;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getImagen_diseno() {
        return imagen_diseno;
    }

    public void setImagen_diseno(String imagen_diseno) {
        this.imagen_diseno = imagen_diseno;
    }

    public List<Tb_Pag_Bebidas> getDetalles_Bebidas() {
        return detalles_Bebidas;
    }

    public void setDetalles_Bebidas(List<Tb_Pag_Bebidas> detalles_Bebidas) {
        this.detalles_Bebidas = detalles_Bebidas;
    }

   
}
