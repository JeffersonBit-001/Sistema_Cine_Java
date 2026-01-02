/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author JEFFERSON
 */
public class Sugerencias extends Tipo{
    private Usuario cliente;

    public Sugerencias(Usuario cliente) {
        this.cliente = cliente;
    }

    public Sugerencias(Usuario cliente, int id, String nombre, String descripcion, String caracteristica) {
        super(id, nombre, descripcion, caracteristica);
        this.cliente = cliente;
    }

    public Sugerencias() {
    }

    public Sugerencias(int id, String nombre, String descripcion, String caracteristica) {
        super(id, nombre, descripcion, caracteristica);
    }


    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }
    
}
