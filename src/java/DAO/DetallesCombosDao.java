/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConexionBD.ConexionBD;
import Modelo.Combos;
import Modelo.DetalleCategoriaCombos;
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
public class DetallesCombosDao {
    
    private Connection cn=null;

    
    private PreparedStatement ps=null;
    private ResultSet rs=null;
    
    public ArrayList<Combos> obtenerCobosIndex(String cat){
    ArrayList<Combos> combo = new ArrayList<>();
    String sql = "select detco.id as idd,cb.nombre as nom1, cb.abastece,cb.imagen,cb.sinopsis,"
            + "cb.precio,cb.oferta,ct.nombre as nom2,sd.nombre as nomsd,sd.img as imgsd from "
            + "detalle_combos detco "
            + "inner join categoria_combos ct "
            + "on detco.id_cat=ct.id "
            + "inner join combos cb "
            + "on detco.id_combos=cb.id "
            + "inner join sede sd "
            + "on detco.id_sede = sd.id "
            + " ";
    
        try {
            cn= ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                Combos com=new Combos();
                com.setId(rs.getInt("idd"));
                com.setNombre(rs.getString("nom1"));
                com.setAbastece(rs.getString("nom2"));
                com.setImagen(rs.getString("nomsd"));
                com.setSinopsis(rs.getString("nomsd"));
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
    
    
    public DetalleCategoriaCombos obtenerCombos(int cat){
    DetalleCategoriaCombos combo = new DetalleCategoriaCombos();
    String sql = "select * from  detalle_combos "
            + "where id = ?";
    
        try {
            cn= ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, cat);
            rs = ps.executeQuery();
            
            if(rs.next()){
                
                combo.setId(rs.getInt("id"));
                combo.setIdcombo(rs.getInt("id_combos"));
                combo.setIdcat(rs.getInt("id_cat"));
                combo.setIdsede(rs.getInt("id_sede"));

                
               
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
    
    public String eliminarCombo(int id) {

        String respuesta = "";
        String sql = "delete from detalle_combos where id = ? ";

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
    public String insertarCombos(int comb,int cat, int sede) {
        String respuesta = "";
        String sql = "INSERT INTO detalle_combos (id_combos,id_cat,id_sede) VALUES (?, ?, ?);";
        try {
            cn = ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, comb);
            ps.setInt(2, cat);
            ps.setInt(3, sede);

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
    
    public String updateCombos(int id,int comb,int cat, int sede) {
        String respuesta = "";
        String sql = "UPDATE detalle_combos SET id_combos = ?, id_cat = ?, id_sede = ? WHERE id = ?;";
        try {
            cn = ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, comb);
            ps.setInt(2, cat);
            ps.setInt(3, sede);
            ps.setInt(4, id);

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
    
    
    
    


    
}
