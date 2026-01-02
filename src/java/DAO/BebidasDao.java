/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConexionBD.ConexionBD;
import Modelo.Bebidas;

import Modelo.Sedes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author JEFFERSON
 */
public class BebidasDao {
    private Connection cn=null;

    
    private PreparedStatement ps=null;
    private ResultSet rs=null;
    
    public ArrayList<Bebidas> obtenerBebidas(String cat){
    ArrayList<Bebidas> bebida = new ArrayList<>();
    String sql = "SELECT beb.id_bebidas as idd,beb.nombre_bebida as nom1, " +
                "NULL AS abastece, beb.img_bebida as imagen,null as " +
                "sinopsis, beb.precio as precio,null as oferta," +
                "catb.nombre_cat_bebida as nom2,sdb.nombre as nomsd,sdb.img as imgsd,beb.imagen_diseno as img2 " +
                "FROM detalle_bebidas detb " +
                "inner join categoria_bebidas catb " +
                "on detb.id_cat_bebida = catb.id_cat_bebida " +
                "inner join bebidas beb " +
                "on detb.id_bebida = beb.id_bebidas " +
                "inner join sede sdb " +
                "on detb.id_sede = sdb.id " +
                "where sdb.nombre=?";
    
        try {
            cn= ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setString(1, cat);

            rs = ps.executeQuery();
            
            while(rs.next()){
                Bebidas beb=new Bebidas();
                beb.setId(rs.getInt("idd"));
                beb.setNombre(rs.getString("nom1"));
                beb.setAbastece(rs.getString("abastece"));
                beb.setImagen(rs.getString("imagen"));
                beb.setSinopsis(rs.getString("sinopsis"));
                beb.setPrecio(rs.getDouble("precio"));
                beb.setOferta(rs.getString("oferta"));
                beb.setCategoria(rs.getString("nom2"));
                beb.setSedes(new Sedes(0,rs.getString("nomsd"),"","",rs.getString("imgsd")));
                beb.setImg2(rs.getString("img2"));
                bebida.add(beb);
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
    return bebida;
    }
    
    
    public ArrayList<Bebidas> obtenerCategoriasBebidas(){
    ArrayList<Bebidas> bebida = new ArrayList<>();
    String sql = "select id_cat_bebida,nombre_cat_bebida from categoria_bebidas";
    
        try {
            cn= ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Bebidas beb=new Bebidas();
                beb.setId(rs.getInt("id_cat_bebida"));
                beb.setNombre(rs.getString("nombre_cat_bebida"));
                bebida.add(beb);
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
    return bebida;
    }
    
    
    
    
    
    
}
