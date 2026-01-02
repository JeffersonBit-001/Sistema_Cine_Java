/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConexionBD.ConexionBD;
import Modelo.CategoriaPelicula;
import Modelo.DetallesPelicula;
import Modelo.Dia;
import Modelo.Hora;
import Modelo.PeliIndex;
import Modelo.Sedes;
import Modelo.Vista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author JEFFERSON
 */
public class DetallesPeliculaDao {
        
    private Connection cn=null;

    
    private PreparedStatement ps=null;
    private ResultSet rs=null;
    
    
    /*DETALLES PELICULA*/
    public ArrayList<DetallesPelicula> obtenerDetallesPeliculaFull() {
        ArrayList<DetallesPelicula> detalle = new ArrayList<>();
        String sql = "SELECT dt.id, pel.nombre AS nompel, cat.nombre AS nomcat, "
                   + "vs.nombre AS nomvis, sd.nombre AS nomsd, hor.hora AS nomhor, "
                   + "di.descripcion AS nomdia "
                   + "FROM pelicula pel "
                   + "INNER JOIN detalle_pelicula dt ON pel.id = dt.id_pelicula "
                   + "INNER JOIN categoria_peli cat ON dt.id_categoria = cat.id_categoria "
                   + "INNER JOIN dias di ON dt.id_dia = di.id_dia "
                   + "INNER JOIN horarios hor ON dt.id_hora = hor.id "
                   + "INNER JOIN sede sd ON dt.id_sede = sd.id "
                   + "INNER JOIN vista vs ON dt.id_vista = vs.id "
                   + "ORDER BY pel.nombre ASC;";

        try {
            cn = ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                DetallesPelicula peli = new DetallesPelicula();
                peli.setId(rs.getInt("id"));
                peli.setSd(new Sedes(0, rs.getString("nomsd"),"","",""));
                peli.setHora(new Hora(0, rs.getString("nomhor"),"",""));
                peli.setCategoria(new CategoriaPelicula(0, rs.getString("nomcat"),"",""));
                peli.setDia(new Dia(0, rs.getString("nomdia"),"",""));
                
                peli.setVista(new Vista(0, rs.getString("nomvis"),"",""));
                peli.setPeli(new PeliIndex(0, rs.getString("nompel"), "","","","",0,"",""
                ,"","",""));
                
                

                detalle.add(peli);
            }

        } catch (Exception e) {
            e.printStackTrace();
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
            } catch (Exception e) {

            }
        }
        return detalle;
    }

    public DetallesPelicula obtenerDetallesPeliculaFullWhere(int id) {
        DetallesPelicula peli = new DetallesPelicula();
        String sql = "SELECT dt.id AS detalle_id, "
                   + "pel.id AS pelicula_id, "
                   + "pel.nombre AS nompel, "
                   + "cat.id_categoria AS categoria_id, "
                   + "cat.nombre AS nomcat, "
                   + "vs.id AS vista_id, "
                   + "vs.nombre AS nomvis, "
                   + "sd.id AS sede_id, "
                   + "sd.nombre AS nomsd, "
                   + "hor.id AS horario_id, "
                   + "hor.hora AS nomhor, "
                   + "di.id_dia AS dia_id, "
                   + "di.descripcion AS nomdia "
                   + "FROM pelicula pel "
                   + "INNER JOIN detalle_pelicula dt ON pel.id = dt.id_pelicula "
                   + "INNER JOIN categoria_peli cat ON dt.id_categoria = cat.id_categoria "
                   + "INNER JOIN dias di ON dt.id_dia = di.id_dia "
                   + "INNER JOIN horarios hor ON dt.id_hora = hor.id "
                   + "INNER JOIN sede sd ON dt.id_sede = sd.id "
                   + "INNER JOIN vista vs ON dt.id_vista = vs.id "
                   + "WHERE dt.id = ? "
                   + "ORDER BY pel.nombre ASC;";


        try {
            cn = ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                
                peli.setId(rs.getInt("detalle_id"));
                peli.setPeli(new PeliIndex(rs.getInt("pelicula_id"), rs.getString("nompel"), "","","","",0,"",""
                ,"","",""));
                peli.setSd(new Sedes(rs.getInt("sede_id"), rs.getString("nomsd"),"","",""));
                peli.setHora(new Hora(rs.getInt("horario_id"), rs.getString("nomhor"),"",""));
                peli.setCategoria(new CategoriaPelicula(rs.getInt("categoria_id"), rs.getString("nomcat"),"",""));
                peli.setDia(new Dia(rs.getInt("dia_id"), rs.getString("nomdia"),"",""));
                
                peli.setVista(new Vista(rs.getInt("vista_id"), rs.getString("nomvis"),"",""));

            }

        } catch (Exception e) {
            e.printStackTrace();
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
            } catch (Exception e) {

            }
        }
        return peli;
    }

    
    
    public String actualizarDetalles(int id, int peli, int sede,int hora,int cat,int dia,int vista) {

        String respuesta = "";
        String sql = "UPDATE detalle_pelicula SET id_pelicula = ?, id_sede = ?, id_hora = ?, "
           + "id_categoria = ?, id_dia = ?, id_vista = ? "
           + "WHERE id = ?;";


        try {
            cn = ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, peli);
            ps.setInt(2, sede);
            ps.setInt(3, hora);
            ps.setInt(4, cat);
            ps.setInt(5, dia);
            ps.setInt(6, vista);
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

    public String insertarDetalles(int peli, int sede,int hora,int cat,int dia,int vista) {

        String respuesta = "";
        String sql = "INSERT INTO detalle_pelicula (id_pelicula, id_sede, id_hora, id_categoria, id_dia, id_vista) "
               + "VALUES (?, ?, ?, ?, ?, ?);";


        try {
            cn = ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, peli);
            ps.setInt(2, sede);
            ps.setInt(3, hora);
            ps.setInt(4, cat);
            ps.setInt(5, dia);
            ps.setInt(6, vista);


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

    
    public String deleteDetalles(int id) {

        String respuesta = "";
        String sql = "delete from detalle_pelicula where id = ?";


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

    
}
