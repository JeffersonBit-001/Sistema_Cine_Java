/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dto;

import java.util.List;

/**
 *
 * @author JEFFERSON
 */

public class ClientePagoPeliculasDTO {
    private Long clienteId;
    private String clienteNombre;
    private Long pagoId;
    private String fechaPago;
    private List<PeliculaDTO> peliculas;

    public ClientePagoPeliculasDTO(Long clienteId, String clienteNombre, Long pagoId, String fechaPago, List<PeliculaDTO> peliculas) {
        this.clienteId = clienteId;
        this.clienteNombre = clienteNombre;
        this.pagoId = pagoId;
        this.fechaPago = fechaPago;
        this.peliculas = peliculas;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public String getClienteNombre() {
        return clienteNombre;
    }

    public void setClienteNombre(String clienteNombre) {
        this.clienteNombre = clienteNombre;
    }

    public Long getPagoId() {
        return pagoId;
    }

    public void setPagoId(Long pagoId) {
        this.pagoId = pagoId;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public List<PeliculaDTO> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<PeliculaDTO> peliculas) {
        this.peliculas = peliculas;
    }
}

