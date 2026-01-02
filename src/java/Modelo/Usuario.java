/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author JEFFERSON
 */
public class Usuario {
    private int id;
    private String nombre;
    private String apellido;
    private int dni;
    private String genero;
    private String fecha;
    private int telefono;
    private String correo;
    private String correoc;
    private String pass;
    private String passc;
    private String promocion;
    private String sede;
    private String horario;
    private String domicilio;
    private String nacimiento;
    private String hora;
    private int estado;

    
    public Usuario() {
    }

    public Usuario(int id, String nombre, String apellido, int dni, String genero, String fecha, int telefono, String correo, String correoc, String pass, String passc, String promocion, String sede, String horario, String domicilio, String nacimiento, String hora, int estado) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.genero = genero;
        this.fecha = fecha;
        this.telefono = telefono;
        this.correo = correo;
        this.correoc = correoc;
        this.pass = pass;
        this.passc = passc;
        this.promocion = promocion;
        this.sede = sede;
        this.horario = horario;
        this.domicilio = domicilio;
        this.nacimiento = nacimiento;
        this.hora = hora;
        this.estado = estado;
    }

    
    
    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCorreoc() {
        return correoc;
    }

    public void setCorreoc(String correoc) {
        this.correoc = correoc;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPassc() {
        return passc;
    }

    public void setPassc(String passc) {
        this.passc = passc;
    }

    public String getPromocion() {
        return promocion;
    }

    public void setPromocion(String promocion) {
        this.promocion = promocion;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
}
