/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *
 * @author JEFFERSON
 */
@Entity
@Table(name = "detalle_pago_dulceria")
public class Tb_Pag_Dulceria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int cantidad;
    private float precio_total;
    
    @ManyToOne
    @JoinColumn(name = "id_pago")
    @JsonBackReference
    private Tb_Pagos pago;
    
    @ManyToOne
    @JoinColumn(name = "id_dulceria")
    @JsonBackReference
    private Dulceria dulceria;

    public Tb_Pag_Dulceria() {
    }

    public Tb_Pag_Dulceria(Long id, int cantidad, float precio_total, Tb_Pagos pago, Dulceria dulceria) {
        this.id = id;
        this.cantidad = cantidad;
        this.precio_total = precio_total;
        this.pago = pago;
        this.dulceria = dulceria;
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

    public float getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(float precio_total) {
        this.precio_total = precio_total;
    }

    public Tb_Pagos getPago() {
        return pago;
    }

    public void setPago(Tb_Pagos pago) {
        this.pago = pago;
    }

    public Dulceria getDulceria() {
        return dulceria;
    }

    public void setDulceria(Dulceria dulceria) {
        this.dulceria = dulceria;
    }
    
    
    
    
    
    
    
}
