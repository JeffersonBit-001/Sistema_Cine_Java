/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author JEFFERSON
 */
public class LibroReclamaciones extends Tipo{

    private String imagen;
    private Usuario cliente;
    private Tipo tipo_bien;
    private Tipo tipo_reclamacion;
    private Tipo tipo_condicion;

    public LibroReclamaciones(String imagen, Usuario cliente, Tipo tipo_bien, Tipo tipo_reclamacion, Tipo tipo_condicion) {
        this.imagen = imagen;
        this.cliente = cliente;
        this.tipo_bien = tipo_bien;
        this.tipo_reclamacion = tipo_reclamacion;
        this.tipo_condicion = tipo_condicion;
    }

    public LibroReclamaciones(String imagen, Usuario cliente, Tipo tipo_bien, Tipo tipo_reclamacion, Tipo tipo_condicion, int id, String nombre, String descripcion, String caracteristica) {
        super(id, nombre, descripcion, caracteristica);
        this.imagen = imagen;
        this.cliente = cliente;
        this.tipo_bien = tipo_bien;
        this.tipo_reclamacion = tipo_reclamacion;
        this.tipo_condicion = tipo_condicion;
    }

    
    public LibroReclamaciones() {
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public Tipo getTipo_bien() {
        return tipo_bien;
    }

    public void setTipo_bien(Tipo tipo_bien) {
        this.tipo_bien = tipo_bien;
    }

    public Tipo getTipo_reclamacion() {
        return tipo_reclamacion;
    }

    public void setTipo_reclamacion(Tipo tipo_reclamacion) {
        this.tipo_reclamacion = tipo_reclamacion;
    }

    public Tipo getTipo_condicion() {
        return tipo_condicion;
    }

    public void setTipo_condicion(Tipo tipo_condicion) {
        this.tipo_condicion = tipo_condicion;
    }
    
    
    
    
    
}
