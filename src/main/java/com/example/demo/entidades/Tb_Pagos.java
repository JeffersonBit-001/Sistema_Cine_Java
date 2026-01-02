/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

/**
 *
 * @author JEFFERSON
 */
@Entity
@Table(name = "tb_pagos")
public class Tb_Pagos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private int cantidad_butacas;
    private float total_precio_combos;
    private float total_neto;
    private String codigo_aleatorio;
    private float descuento;
    private float total_descuento;
    private String estado_vale;
    private String hora;
    private String fecha;
    
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "pagos"}) 
    private Cliente cliente;
    
    @OneToMany(mappedBy = "pago")
    private List<Tb_Pag_Peliculas> detalles_peliculas;
    
    @OneToMany(mappedBy = "pago")
    private List<Tb_Pag_Combos> detalles_combos;
    
    @OneToMany(mappedBy = "pago")
    private List<Tb_Pag_Bebidas> detalles_bebidas;
    
    
    @OneToMany(mappedBy = "pago")
    private List<Tb_Pag_Dulceria> detalles_dulceria;

    public Tb_Pagos() {
    }

    public Tb_Pagos(Long id, int cantidad_butacas, float total_precio_combos, float total_neto, String codigo_aleatorio, float descuento, float total_descuento, String estado_vale, String hora, String fecha, Cliente cliente, List<Tb_Pag_Peliculas> detalles_peliculas, List<Tb_Pag_Combos> detalles_combos, List<Tb_Pag_Bebidas> detalles_bebidas, List<Tb_Pag_Dulceria> detalles_dulceria) {
        this.id = id;
        this.cantidad_butacas = cantidad_butacas;
        this.total_precio_combos = total_precio_combos;
        this.total_neto = total_neto;
        this.codigo_aleatorio = codigo_aleatorio;
        this.descuento = descuento;
        this.total_descuento = total_descuento;
        this.estado_vale = estado_vale;
        this.hora = hora;
        this.fecha = fecha;
        this.cliente = cliente;
        this.detalles_peliculas = detalles_peliculas;
        this.detalles_combos = detalles_combos;
        this.detalles_bebidas = detalles_bebidas;
        this.detalles_dulceria = detalles_dulceria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCantidad_butacas() {
        return cantidad_butacas;
    }

    public void setCantidad_butacas(int cantidad_butacas) {
        this.cantidad_butacas = cantidad_butacas;
    }

    public float getTotal_precio_combos() {
        return total_precio_combos;
    }

    public void setTotal_precio_combos(float total_precio_combos) {
        this.total_precio_combos = total_precio_combos;
    }

    public float getTotal_neto() {
        return total_neto;
    }

    public void setTotal_neto(float total_neto) {
        this.total_neto = total_neto;
    }

    public String getCodigo_aleatorio() {
        return codigo_aleatorio;
    }

    public void setCodigo_aleatorio(String codigo_aleatorio) {
        this.codigo_aleatorio = codigo_aleatorio;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public float getTotal_descuento() {
        return total_descuento;
    }

    public void setTotal_descuento(float total_descuento) {
        this.total_descuento = total_descuento;
    }

    public String getEstado_vale() {
        return estado_vale;
    }

    public void setEstado_vale(String estado_vale) {
        this.estado_vale = estado_vale;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Tb_Pag_Peliculas> getDetalles_peliculas() {
        return detalles_peliculas;
    }

    public void setDetalles_peliculas(List<Tb_Pag_Peliculas> detalles_peliculas) {
        this.detalles_peliculas = detalles_peliculas;
    }

    public List<Tb_Pag_Combos> getDetalles_combos() {
        return detalles_combos;
    }

    public void setDetalles_combos(List<Tb_Pag_Combos> detalles_combos) {
        this.detalles_combos = detalles_combos;
    }

    public List<Tb_Pag_Bebidas> getDetalles_bebidas() {
        return detalles_bebidas;
    }

    public void setDetalles_bebidas(List<Tb_Pag_Bebidas> detalles_bebidas) {
        this.detalles_bebidas = detalles_bebidas;
    }

    public List<Tb_Pag_Dulceria> getDetalles_dulceria() {
        return detalles_dulceria;
    }

    public void setDetalles_dulceria(List<Tb_Pag_Dulceria> detalles_dulceria) {
        this.detalles_dulceria = detalles_dulceria;
    }
    
    
    
    
    
    
    
}
