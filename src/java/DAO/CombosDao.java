/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConexionBD.ConexionBD;
import Modelo.Combos;
import Modelo.Sedes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author JEFFERSON
 */
public class CombosDao {
    private Connection cn=null;

    
    private PreparedStatement ps=null;
    private ResultSet rs=null;
    
    public ArrayList<Combos> obtenerCobosIndex(String cat){
    ArrayList<Combos> combo = new ArrayList<>();
    String sql = "select cb.id as idd,cb.nombre as nom1, cb.abastece,cb.imagen,cb.sinopsis,"
            + "cb.precio,cb.oferta,ct.nombre as nom2,sd.nombre as nomsd,sd.img as imgsd from "
            + "detalle_combos detco "
            + "inner join categoria_combos ct "
            + "on detco.id_cat=ct.id "
            + "inner join combos cb "
            + "on detco.id_combos=cb.id "
            + "inner join sede sd "
            + "on detco.id_sede = sd.id "
            + "where ct.nombre=? or sd.nombre=? ";
    
        try {
            cn= ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setString(1, cat);
            ps.setString(2, cat);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                Combos com=new Combos();
                com.setId(rs.getInt("idd"));
                com.setNombre(rs.getString("nom1"));
                com.setAbastece(rs.getString("abastece"));
                com.setImagen(rs.getString("imagen"));
                com.setSinopsis(rs.getString("sinopsis"));
                com.setPrecio(rs.getDouble("precio"));
                com.setOferta(rs.getString("oferta"));
                com.setCategoria(rs.getString("nom2"));
                com.setSedes(new Sedes(0,rs.getString("nomsd"),"","",rs.getString("imgsd")));
                combo.add(com);
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
    return combo;
    }
    
    public Combos obtenerCombos(int cat){
    Combos combo = new Combos();
    String sql = "select cb.id as idd,cb.nombre as nom1, cb.abastece,cb.imagen,cb.sinopsis,"
            + "cb.precio,cb.oferta from combos as cb "  
            + "where cb.id = ?";
    
        try {
            cn= ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, cat);
            rs = ps.executeQuery();
            
            if(rs.next()){
                
                combo.setId(rs.getInt("idd"));
                combo.setNombre(rs.getString("nom1"));
                combo.setAbastece(rs.getString("abastece"));
                combo.setImagen(rs.getString("imagen"));
                combo.setSinopsis(rs.getString("sinopsis"));
                combo.setPrecio(rs.getDouble("precio"));
                combo.setOferta(rs.getString("oferta"));
                combo.setCategoria(rs.getString("nom2"));
                
               
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
    return combo;
    }
    
    /*MOSTRAR*/
    public ArrayList<Combos> obtenerCombosFull(){
    ArrayList<Combos> combo = new ArrayList<>();
    String sql = "select id,nombre,abastece,imagen,sinopsis,precio,oferta from combos";
    
        try {
            cn= ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Combos com=new Combos();
                com.setId(rs.getInt("id"));
                com.setNombre(rs.getString("nombre"));
                com.setAbastece(rs.getString("abastece"));
                com.setImagen(rs.getString("imagen"));
                com.setSinopsis(rs.getString("sinopsis"));
                com.setPrecio(rs.getDouble("precio"));
                com.setOferta(rs.getString("oferta"));
                combo.add(com);
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
    return combo;
    }
    
    /*ELIMINAR*/
    public String eliminarCombo(int id) {

        String respuesta = "";
        String sql = "delete from combos where id = ? ";

        try {
            cn = ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();

            respuesta = "";
        } catch (SQLException e) {
            System.out.println(e.toString());
            respuesta = "error:" + e.toString();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }

                if (rs != null) {
                    rs.close();
                }

                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {

            }
        }
        return respuesta;
    }

    /*INSERTAR*/
    public String insertarCombos(String nombre, String abastece, String imagen, String sinopsis, float precio, String oferta) {
        String respuesta = "";
        String sql = "INSERT INTO COMBOS" +
                 "(nombre, abastece, imagen, sinopsis, precio, oferta) " +
                 "VALUES (?, ?, ?, ?, ?, ?);";
        try {
            cn = ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, abastece);
            ps.setString(3, imagen);
            ps.setString(4, sinopsis);
            ps.setFloat(5, precio);
            ps.setString(6, oferta);

            ps.executeUpdate();

            respuesta = "";
        } catch (SQLException e) {
            System.out.println(e.toString());
            respuesta = "error:" + e.toString();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }

                if (rs != null) {
                    rs.close();
                }

                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {

            }
        }
        return respuesta;
    }
    
    
    public String updateCombos(int id, String nombre, String abastece, String imagen, String sinopsis, float precio, String oferta) {

        String respuesta = "";
        String sql = "UPDATE COMBOS SET " +
             "nombre = ?, " +
             "abastece = ?, " +
             "imagen = ?, " +
             "sinopsis = ?, " +
             "precio = ?, " +
             "oferta = ? " +
             "WHERE id = ?;";


        try {
            cn = ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, abastece);
            ps.setString(3, imagen);
            ps.setString(4, sinopsis);
            ps.setFloat(5, precio);
            ps.setString(6, oferta);
            ps.setInt(7, id);

            ps.executeUpdate();

            respuesta = "";
        } catch (SQLException e) {
            System.out.println(e.toString());
            respuesta = "error:" + e.toString();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }

                if (rs != null) {
                    rs.close();
                }

                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {

            }
        }
        return respuesta;
    }
    
    public ArrayList<Combos> obtenerCategoriasCombos(){
    ArrayList<Combos> combo = new ArrayList<>();
    String sql = "select id,nombre from categoria_combos";
    
        try {
            cn= ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Combos com=new Combos();
                com.setId(rs.getInt("id"));
                com.setNombre(rs.getString("nombre"));
                combo.add(com);
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
    return combo;
    }
}
