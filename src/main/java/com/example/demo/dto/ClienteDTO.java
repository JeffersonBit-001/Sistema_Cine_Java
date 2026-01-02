/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dto;

import com.example.demo.entidades.Cliente;

/**
 *
 * @author JEFFERSON
 */
public class ClienteDTO {
    private Long id;
    private String nombres;
    private String apellidos;
    private String correo;

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nombres = cliente.getNombres();
        this.apellidos = cliente.getApellidos();
        this.correo = cliente.getCorreo();
    }

    public ClienteDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    
}
