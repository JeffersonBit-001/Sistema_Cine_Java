/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConexionBD.ConexionBD;
import Modelo.Bebidas;
import Modelo.Sedes;
import Modelo.Tipo;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author JEFFERSON
 */
public class UsuariosDao {

    private Connection cn = null;

    private PreparedStatement ps = null;
    private ResultSet rs = null;

    /*ESTADOS DE SELECCION*/
    public ArrayList<Tipo> obtenerEstados() {
        ArrayList<Tipo> tipo = new ArrayList<>();
        String sql = "select * from estado_cuenta";

        try {
            cn = ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Tipo tip = new Tipo();
                tip.setId(rs.getInt("id_estado"));
                tip.setNombre(rs.getString("nombre"));
                tip.setDescripcion(rs.getString("descripcion"));
                tipo.add(tip);
            }

        } catch (SQLException e) {
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
        return tipo;
    }

    public ArrayList<Usuario> obtenerClientes(String nombre) {
        ArrayList<Usuario> usuario = new ArrayList<>();
        String sql = "SELECT * FROM " + nombre + "";

        try {
            cn = ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Usuario us = new Usuario();
                us.setId(rs.getInt("id"));
                us.setNombre(rs.getString("nombres"));
                us.setApellido(rs.getString("apellidos"));
                us.setDni(rs.getInt("dni"));
                us.setGenero(rs.getString("genero"));
                us.setNacimiento(rs.getString("nacimiento"));
                us.setTelefono(rs.getInt("cel"));
                us.setDomicilio(rs.getString("domicilio"));
                us.setCorreo(rs.getString("correo"));
                us.setCorreoc(rs.getString("correo_confirm"));
                us.setPass(rs.getString("pass"));
                us.setPassc(rs.getString("pass_confirm"));
                usuario.add(us);
            }

        } catch (SQLException e) {
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
        return usuario;
    }

    public Usuario obtenerCliente(String nombre,int id) {

        String sql = "SELECT * FROM " + nombre + " where id = ?";
        Usuario us = new Usuario();
        try {
            cn = ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {

                us.setId(rs.getInt("id"));
                us.setNombre(rs.getString("nombres"));
                us.setApellido(rs.getString("apellidos"));
                us.setDni(rs.getInt("dni"));
                us.setGenero(rs.getString("genero"));
                us.setNacimiento(rs.getString("nacimiento"));
                us.setTelefono(rs.getInt("cel"));
                us.setDomicilio(rs.getString("domicilio"));
                us.setCorreo(rs.getString("correo"));
                us.setCorreoc(rs.getString("correo_confirm"));
                us.setPass(rs.getString("pass"));
                us.setPassc(rs.getString("pass_confirm"));
                us.setEstado(rs.getInt("id_estado"));

            }

        } catch (SQLException e) {
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
        return us;
    }

    public String eliminarCliente(int id, String nombre) {

        String respuesta = "";
        String sql = "UPDATE " + nombre + " SET id_estado = 4 WHERE id = ? ";

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

    public String actualizarCliente(int id, String nomac,
            String nombre, String apellido, int dni, String genero, String nacimiento,
            int celular, String domicilio, String correo, String correoConfirm, String pass, String passConfirm,
             int idEstado) {

        String respuesta = "";
        String sql = "UPDATE " + nomac + " SET "
                + "    nombres = ?,"
                + "    apellidos = ?,"
                + "    dni = ?,"
                + "    genero = ?,"
                + "    nacimiento = ?,"
                + "    cel = ?,"
                + "    domicilio = ?,"
                + "    correo = ?,"
                + "    correo_confirm = ?,"
                + "    pass = ?,"
                + "    pass_confirm = ?,"
                + "    id_estado = ? "
                + "WHERE id = ?;";


        try {
            cn = ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setInt(3, dni);
            ps.setString(4, genero);
            ps.setString(5, nacimiento);
            ps.setInt(6, celular);
            ps.setString(7, domicilio);
            ps.setString(8, correo);
            ps.setString(9, correoConfirm);
            ps.setString(10, pass);
            ps.setString(11, passConfirm);
            ps.setInt(12, idEstado);
            ps.setInt(13, id);

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

    
    
    public String insertarCliente(String nomac,
            String nombre, String apellido, int dni, String genero, String nacimiento,
            int celular, String domicilio, String correo, String correoConfirm, String pass, String passConfirm,
             int idEstado) {

        String respuesta = "";
        String sql = "INSERT INTO "+nomac+" (" +
                 "nombres, apellidos, dni, genero, nacimiento, cel, domicilio, " +
                 "correo, correo_confirm, pass, pass_confirm, id_estado) " +
                 "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";


        try {
            cn = ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setInt(3, dni);
            ps.setString(4, genero);
            ps.setString(5, nacimiento);
            ps.setInt(6, celular);
            ps.setString(7, domicilio);
            ps.setString(8, correo);
            ps.setString(9, correoConfirm);
            ps.setString(10, pass);
            ps.setString(11, passConfirm);
            ps.setInt(12, idEstado);

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
