/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author JEFFERSON
 */
@Entity
@Table(name = "usuarios")
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String correo;
    private String pass;
    private String nombres;
    private String apellidos;
    private String dni;
    private String genero;
    private String nacimiento;
    private String cel;
    private String domicilio;
    private String correo_confirm;
    private String pass_confirm;

    public Usuarios(Long id, String correo, String pass, String nombres, String apellidos, String dni, String genero, String nacimiento, String cel, String domicilio, String correo_confirm, String pass_confirm) {
        this.id = id;
        this.correo = correo;
        this.pass = pass;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
        this.genero = genero;
        this.nacimiento = nacimiento;
        this.cel = cel;
        this.domicilio = domicilio;
        this.correo_confirm = correo_confirm;
        this.pass_confirm = pass_confirm;
    }

    public Usuarios() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCorreo_confirm() {
        return correo_confirm;
    }

    public void setCorreo_confirm(String correo_confirm) {
        this.correo_confirm = correo_confirm;
    }

    public String getPass_confirm() {
        return pass_confirm;
    }

    public void setPass_confirm(String pass_confirm) {
        this.pass_confirm = pass_confirm;
    }

    

    
    
}
