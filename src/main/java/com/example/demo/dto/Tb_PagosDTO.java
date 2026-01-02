/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dto;

import com.example.demo.entidades.Tb_Pagos;

/**
 *
 * @author JEFFERSON
 */
public class Tb_PagosDTO {
    private Long id;
    private long id_cliente;
    private int cantidad_butacas;
    private float total_precio_combos;
    private float total_neto;
    private String codigo_aleatorio;
    private String hora;
    private String fecha;
    private String nombres;
    private String apellidos;

    public Tb_PagosDTO() {
    }

    public Tb_PagosDTO(Tb_Pagos pagos) {
        this.id = pagos.getId();
        this.id_cliente = pagos.getCliente().getId();
        this.cantidad_butacas = pagos.getCantidad_butacas();
        this.total_precio_combos = pagos.getTotal_precio_combos();
        this.total_neto = pagos.getTotal_neto();
        this.codigo_aleatorio = pagos.getCodigo_aleatorio();
        this.hora = pagos.getHora();
        this.fecha = pagos.getFecha();
        this.nombres = pagos.getCliente().getNombres()+" "+pagos.getCliente().getApellidos();
    }

    public long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
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

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }


    
    
}
