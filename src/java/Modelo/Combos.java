/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author JEFFERSON
 */
public class Combos {
    private int id;
    private String nombre;
    private String abastece;
    private String imagen;
    private String sinopsis;
    private Double precio;
    private String oferta;
    private String categoria;
    private Sedes sedes;
    private String img2;

    public Combos() {
    }

    public Combos(int id, String nombre, String abastece, String imagen, String sinopsis, Double precio, String oferta, String categoria, Sedes sedes, String img2) {
        this.id = id;
        this.nombre = nombre;
        this.abastece = abastece;
        this.imagen = imagen;
        this.sinopsis = sinopsis;
        this.precio = precio;
        this.oferta = oferta;
        this.categoria = categoria;
        this.sedes = sedes;
        this.img2 = img2;
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

    public String getAbastece() {
        return abastece;
    }

    public void setAbastece(String abastece) {
        this.abastece = abastece;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getOferta() {
        return oferta;
    }

    public void setOferta(String oferta) {
        this.oferta = oferta;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Sedes getSedes() {
        return sedes;
    }

    public void setSedes(Sedes sedes) {
        this.sedes = sedes;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }
    
    
    
    
    
}
