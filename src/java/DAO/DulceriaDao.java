/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConexionBD.ConexionBD;
import Modelo.Dulceria;
import Modelo.Sedes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author JEFFERSON
 */
public class DulceriaDao {
    private Connection cn=null;

    
    private PreparedStatement ps=null;
    private ResultSet rs=null;
    
    public ArrayList<Dulceria> obtenerDulceria(String cat){
    ArrayList<Dulceria> dulceria = new ArrayList<>();
    String sql = "select cb.id_dulceria as idd,cb.nom_dulceria as nom1, null as abastece," +
                "cb.img_dulceria as imagen,null as sinopsis," +
                "cb.precio_dulceria as precio,null as oferta," +
                "ct.nom_cat_dulceriacol as nom2,"
                + "sd.nombre as nomsd,sd.img as imgsd, cb.imagen_diseno as img2 from " +
                "detalle_dulceria detco " +
                "inner join categoria_dulceria ct " +
                "on detco.id_cat_dulceria=ct.id_cat_dulceria " +
                "inner join dulceria cb " +
                "on detco.id_dulceria=cb.id_dulceria " +
                "inner join sede sd " +
                "on detco.id_sede = sd.id " +
                "where sd.nombre=?";
    
        try {
            cn= ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setString(1, cat);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                Dulceria dul=new Dulceria();
                dul.setId(rs.getInt("idd"));
                dul.setNombre(rs.getString("nom1"));
                dul.setAbastece(rs.getString("abastece"));
                dul.setImagen(rs.getString("imagen"));
                dul.setSinopsis(rs.getString("sinopsis"));
                dul.setPrecio(rs.getDouble("precio"));
                dul.setOferta(rs.getString("oferta"));
                dul.setCategoria(rs.getString("nom2"));
                dul.setSedes(new Sedes(0,rs.getString("nomsd"),"","",rs.getString("imgsd")));
                dul.setImg2(rs.getString("img2"));
                dulceria.add(dul);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(cn !=null){
                    cn.close();
                }
                
                if (rs != null){
                    rs.close();
                }
                
                if(ps != null){
                    ps.close();
                }
            } catch (Exception e) {
                
            }
        }
    return dulceria;
    }
    
    
    
    public ArrayList<Dulceria> obtenerCategoriasDulceria(){
    ArrayList<Dulceria> dulceria = new ArrayList<>();
    String sql = "select id_cat_dulceria,nom_cat_dulceriacol from categoria_dulceria";
    
        try {
            cn= ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Dulceria dul=new Dulceria();
                dul.setId(rs.getInt("id_cat_dulceria"));
                dul.setNombre(rs.getString("nom_cat_dulceriacol"));
                dulceria.add(dul);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(cn !=null){
                    cn.close();
                }
                
                if (rs != null){
                    rs.close();
                }
                
                if(ps != null){
                    ps.close();
                }
            } catch (Exception e) {
                
            }
        }
    return dulceria;
    }
}
