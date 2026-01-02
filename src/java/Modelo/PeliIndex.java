/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author JEFFERSON
 */
public class PeliIndex {
    private int id;
    private String nombre;
    private String descripcion;
    private String sinopsis;
    private String img;
    private String vista;
    
    private float precio = 0;
    private String director;
    private String idioma;
    private String disponible;
    private String sala;
    private String linkyou;
    
    
    
    public PeliIndex() {
    }

    public PeliIndex(int id, String nombre, String descripcion, String sinopsis, String img, String vista, float precio, String director, String idioma, String disponible, String sala, String linkyou) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.sinopsis = sinopsis;
        this.img = img;
        this.vista = vista;
        this.precio = precio;
        this.director = director;
        this.idioma = idioma;
        this.disponible = disponible;
        this.sala = sala;
        this.linkyou = linkyou;
    }

    
    
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getVista() {
        return vista;
    }

    public void setVista(String vista) {
        this.vista = vista;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getDisponible() {
        return disponible;
    }

    public void setDisponible(String disponible) {
        this.disponible = disponible;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getLinkyou() {
        return linkyou;
    }

    public void setLinkyou(String linkyou) {
        this.linkyou = linkyou;
    }
    
    
    
    
    
    
    
}
