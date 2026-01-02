/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author JEFFERSON
 */
public class DetalleCategoriaCombos {

    private int id;
    private int idcombo;
    private int idcat;
    private int idsede;

    public DetalleCategoriaCombos() {
    }

    public DetalleCategoriaCombos(int id, int idcombo, int idcat, int idsede) {
        this.id = id;
        this.idcombo = idcombo;
        this.idcat = idcat;
        this.idsede = idsede;
    }

    public int getIdsede() {
        return idsede;
    }

    public void setIdsede(int idsede) {
        this.idsede = idsede;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdcombo() {
        return idcombo;
    }

    public void setIdcombo(int idcombo) {
        this.idcombo = idcombo;
    }

    public int getIdcat() {
        return idcat;
    }

    public void setIdcat(int idcat) {
        this.idcat = idcat;
    }

    
    
    
}
