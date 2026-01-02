/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dto;

import com.example.demo.entidades.Tb_Pagos;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author JEFFERSON
 */
public class TB_PagosDetellasDTO {
    private Long id;
    private int cantidadButacas;
    private float totalPrecioCombos;
    private float totalNeto;
    private String codigoAleatorio;
    private float descuento;
    private float totalDescuento;
    private String estadoVale;
    private String hora;
    private String fecha;
    private ClienteDTO cliente;
    private List<Tb_Pag_PeliculasDTO> detallesPeliculas;

    public TB_PagosDetellasDTO(Tb_Pagos pago) {
        this.id = pago.getId();
        this.cantidadButacas = pago.getCantidad_butacas();
        this.totalPrecioCombos = pago.getTotal_precio_combos();
        this.totalNeto = pago.getTotal_neto();
        this.codigoAleatorio = pago.getCodigo_aleatorio();
        this.descuento = pago.getDescuento();
        this.totalDescuento = pago.getTotal_descuento();
        this.estadoVale = pago.getEstado_vale();
        this.hora = pago.getHora();
        this.fecha = pago.getFecha();
        if (pago.getCliente() != null) {
            this.cliente = new ClienteDTO(pago.getCliente());
        }
        this.detallesPeliculas = pago.getDetalles_peliculas().stream()
                                      .map(Tb_Pag_PeliculasDTO::new)
                                      .collect(Collectors.toList());
    }

    public TB_PagosDetellasDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCantidadButacas() {
        return cantidadButacas;
    }

    public void setCantidadButacas(int cantidadButacas) {
        this.cantidadButacas = cantidadButacas;
    }

    public float getTotalPrecioCombos() {
        return totalPrecioCombos;
    }

    public void setTotalPrecioCombos(float totalPrecioCombos) {
        this.totalPrecioCombos = totalPrecioCombos;
    }

    public float getTotalNeto() {
        return totalNeto;
    }

    public void setTotalNeto(float totalNeto) {
        this.totalNeto = totalNeto;
    }

    public String getCodigoAleatorio() {
        return codigoAleatorio;
    }

    public void setCodigoAleatorio(String codigoAleatorio) {
        this.codigoAleatorio = codigoAleatorio;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public float getTotalDescuento() {
        return totalDescuento;
    }

    public void setTotalDescuento(float totalDescuento) {
        this.totalDescuento = totalDescuento;
    }

    public String getEstadoVale() {
        return estadoVale;
    }

    public void setEstadoVale(String estadoVale) {
        this.estadoVale = estadoVale;
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

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public List<Tb_Pag_PeliculasDTO> getDetallesPeliculas() {
        return detallesPeliculas;
    }

    public void setDetallesPeliculas(List<Tb_Pag_PeliculasDTO> detallesPeliculas) {
        this.detallesPeliculas = detallesPeliculas;
    }

    
}
