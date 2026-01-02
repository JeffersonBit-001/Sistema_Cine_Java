/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConexionBD.ConexionBD;
import Modelo.Bebidas;
import Modelo.LibroReclamaciones;
import Modelo.Sedes;
import Modelo.Tipo;
import Modelo.Usuario;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author JEFFERSON
 */
public class LibroReclamacionesDao {

    private Connection cn = null;

    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public ArrayList<LibroReclamaciones> obtenerTipoBien() {
        ArrayList<LibroReclamaciones> libro = new ArrayList<>();
        String sql = "select * from tipo_bien";

        try {
            cn = ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                LibroReclamaciones lib = new LibroReclamaciones();
                lib.setTipo_bien(new Tipo(rs.getInt("id_tipo"), rs.getString("nombre"), "", ""));
                libro.add(lib);
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
        return libro;
    }

    public ArrayList<LibroReclamaciones> obtenerTipoReclamacion() {
        ArrayList<LibroReclamaciones> libro = new ArrayList<>();
        String sql = "select * from tipo_reclamacion";

        try {
            cn = ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                LibroReclamaciones lib = new LibroReclamaciones();
                lib.setTipo_reclamacion(new Tipo(rs.getInt("id_tipo"), rs.getString("nombre"), "", ""));
                libro.add(lib);
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
        return libro;
    }

    public ArrayList<LibroReclamaciones> obtenerTipoCondicion() {
        ArrayList<LibroReclamaciones> libro = new ArrayList<>();
        String sql = "select * from tipo_condicion";

        try {
            cn = ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                LibroReclamaciones lib = new LibroReclamaciones();
                lib.setTipo_condicion(new Tipo(rs.getInt("id_condicion"),
                        rs.getString("nombre"), rs.getString("descripcion"), ""));
                libro.add(lib);
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
        return libro;
    }

    public Usuario buscarCliente(String nombres, String apellidos, int dni) {
        Usuario us = new Usuario();

        String sql = "select id,cel,domicilio,correo from clientes "
                + "where nombres = ? and apellidos = ? "
                + "and dni=? ";

        try {
            cn = ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setString(1, nombres);
            ps.setString(2, apellidos);
            ps.setInt(3, dni);

            rs = ps.executeQuery();

            if (rs.next()) {
                us.setId(rs.getInt("id"));
                us.setTelefono(rs.getInt("cel"));
                us.setDomicilio(rs.getString("domicilio"));
                us.setCorreo(rs.getString("correo"));
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

    public String InsertarReclamacion(int dni,int id_cliente, int id_bien, int id_reclamacion, 
            int id_condicion, String id_estado, Usuario usu) {

        String respuesta = "";
        String sql = "insert into libro_reclamaciones(id_cliente"
                + ",id_bien,id_tipo_reclamacion,id_condiciones,id_estado,fecha_reclamo,"
                + "hora_reclamo,fecha_respuesta,hora_respuesta) values (?,?,?,?,?,?,?,?,?)";

        /*FECHA Y HORA REGISTRO*/
        LocalDate fechaActual = LocalDate.now();  
        LocalTime horaActual = LocalTime.now();

        //FECHA
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fechaFormateada = fechaActual.format(dateFormatter);
        //HORA
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String horaFormateada = horaActual.format(timeFormatter);
        
        usu.setDni(dni);
        usu.setFecha(fechaFormateada);
        usu.setHora(horaFormateada);
        

        try {
            cn = ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);

            if (id_estado.equals("Pendiente")) {
                ps.setInt(1, id_cliente);
                ps.setInt(2, id_bien);
                ps.setInt(3, id_reclamacion);
                ps.setInt(4, id_condicion);
                ps.setInt(5, 4);
                ps.setString(6, fechaFormateada);
                ps.setString(7, horaFormateada);
                ps.setString(8, fechaFormateada);
                ps.setString(9, horaFormateada);
            } else {
                ps.setInt(1, id_cliente);
                ps.setInt(2, id_bien);
                ps.setInt(3, id_reclamacion);
                ps.setInt(4, id_condicion);
                ps.setInt(5, Integer.parseInt(id_estado));
                ps.setString(6, fechaFormateada);
                ps.setString(7, horaFormateada);
                ps.setString(8, fechaFormateada);
                ps.setString(9, horaFormateada);
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

    public int RecuperarReclamacionClientes(int dni, String fecha, String hora) {

        int respuesta = 0;
        String sql = "select lb.id_reclamaciones as id "
                + "from libro_reclamaciones lb "
                + "inner join clientes cl "
                + "on lb.id_cliente=cl.id "
                + "where cl.dni=? and lb.fecha_reclamo=? and lb.hora_reclamo=? ";

        try {
            cn = ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, dni);
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


    public String InsertarReclamacionDetalle(int id_reclamacion, float monto, String nom_bien, String descripcion_bien,
            String nom_reclamacion, String detalle_reclamacion, String pedido, 
            String evidencias_foto,int telefono, String domicilio, String correo,Usuario us) {

        String respuesta = "";
        String sql = "insert into detalle_libro_reclamaciones(id_reclamacion"
                + ",monto,nom_bien,descripcion_bien,nom_reclamacion,detalle_reclamacion,pedido,evidencias_foto,domicilio_opcional"
                + ",telefono_opcional,correo_opcional) values (?,?,?,?,?,?,?,?,?,?,?)";
        String cel="";
        
            if(domicilio.equals(us.getDomicilio())){
                domicilio = "Ya registrado";
            }
            
            if(telefono == us.getTelefono()){
                cel = "Ya registrado";
            } else {
                cel = ""+telefono;
            }
            
            if(correo.equals(us.getCorreo())){
                correo = "Ya registrado";
            }
            if(nom_bien.equals("")){
                nom_bien = "No necesario" ;
            }
            
            if(nom_reclamacion.equals("")){
                nom_reclamacion = "No necesario" ;
            }
            



        try {
            cn = ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id_reclamacion);
            ps.setFloat(2, monto);
            ps.setString(3, nom_bien);
            ps.setString(4, descripcion_bien);
            ps.setString(5, nom_reclamacion);
            ps.setString(6, detalle_reclamacion);
            ps.setString(7, pedido);
            ps.setString(8, evidencias_foto);
            ps.setString(9, domicilio);
            ps.setString(10, cel);
            ps.setString(11, correo);
            
            

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
