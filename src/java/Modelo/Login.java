/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author JEFFERSON
 */
public class Login extends Usuario{
    private String cel;
    private String nombres;
    private String apellidos;

    public Login(String cel, String nombres, String apellidos) {
        this.cel = cel;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public Login(String cel, String nombres, String apellidos, int id, String nombre, String apellido, int dni, String genero, String fecha, int telefono, String correo, String correoc, String pass, String passc, String promocion, String sede, String horario, String domicilio, String nacimiento, String hora, int estado) {
        super(id, nombre, apellido, dni, genero, fecha, telefono, correo, correoc, pass, passc, promocion, sede, horario, domicilio, nacimiento, hora, estado);
        this.cel = cel;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public Login() {
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

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }
    
    

    

    
    
}
