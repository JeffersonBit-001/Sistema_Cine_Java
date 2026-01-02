/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConexionBD.ConexionBD;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author JEFFERSON
 */
public class SugerenciaDao {
    private Connection cn=null;

    
    private PreparedStatement ps=null;
    private ResultSet rs=null;
    
    
    
    public Usuario buscarCliente(String nombres, String correo) {
        Usuario us = new Usuario();

        String sql = "select id from clientes "
                + "where CONCAT(nombres, ' ', apellidos) like ? and correo = ? ";

        try {
            cn = ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setString(1, nombres);
            ps.setString(2, correo);

            rs = ps.executeQuery();

            if (rs.next()) {
                us.setId(rs.getInt("id"));
            }

        } catch (SQLException e) {
            System.out.println("Error en bucas cliente" + e.toString());

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
        return us;
    }

    
    
    public String InsertarSugerencia(int id_cliente, String id_estado, Usuario usu) {

        String respuesta = "";
        String sql = "insert into sugerencias(id_cliente"
                + ",fecha_registro,hora_registro,id_estado, fecha_revisada ,hora_revisada) values (?,?,?,?,?,?)";

        /*FECHA Y HORA REGISTRO*/
        LocalDate fechaActual = LocalDate.now();  
        LocalTime horaActual = LocalTime.now();

        //FECHA
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fechaFormateada = fechaActual.format(dateFormatter);
        //HORA
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String horaFormateada = horaActual.format(timeFormatter);

        usu.setFecha(fechaFormateada);
        usu.setHora(horaFormateada);
        

        try {
            cn = ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);

            if (id_estado.equals("Pendiente")) {
                ps.setInt(1, id_cliente);
                ps.setString(2, fechaFormateada);
                ps.setString(3, horaFormateada);
                ps.setInt(4, 2);
                ps.setString(5, fechaFormateada);
                ps.setString(6, horaFormateada);
            } else {
                ps.setInt(1, id_cliente);
                ps.setString(2, fechaFormateada);
                ps.setString(3, horaFormateada);
                ps.setInt(4, Integer.parseInt(id_estado));
                ps.setString(5, fechaFormateada); 
                ps.setString(6, horaFormateada);
            }

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
            } catch (Exception e) {

            }
        }
        return respuesta;
    }

    
    public int RecuperarSugerenciaClientes(String correo, String fecha, String hora) {

        int respuesta = 0;
        String sql = "select lb.id_sugerencias as id "
                + "from sugerencias lb "
                + "inner join clientes cl "
                + "on lb.id_cliente=cl.id "
                + "where cl.correo=? and lb.fecha_registro=? and lb.hora_registro=? ";

        try {
            cn = ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setString(1, correo);
            ps.setString(2, fecha);
            ps.setString(3, hora);
            rs = ps.executeQuery();

            if(rs.next()){
                respuesta = rs.getInt("id");
            }

        } catch (SQLException e) {
            System.out.println(e.toString());
            respuesta = 0;
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
        return respuesta;
    }


    
    public String InsertarSugerenciaDetalle(int id_sugerencia, String sugerencia) {

        String respuesta = "";
        String sql = "insert into detalle_sugerencia(id_sugerencias"
                + ",descripcion) values (?,?)";


        try {
            cn = ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id_sugerencia);
            ps.setString(2, sugerencia);

            

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
