/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConexionBD.ConexionBD;
import Modelo.DetalleReserva;
import Modelo.Dia;
import Modelo.Hora;
import Modelo.PeliIndex;
import Modelo.Sedes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JEFFERSON
 */
public class SedesDao {

    private Connection cn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public ArrayList<Sedes> getSedes() {

        ArrayList<Sedes> sedes = new ArrayList<>();
        String sql = "select id,nombre,descripcion,link from sede";

        try {
            cn = ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Sedes sd = new Sedes();
                sd.setId(rs.getInt("id"));
                sd.setNombre(rs.getString("nombre"));
                sd.setDescripcion(rs.getString("descripcion"));
                sd.setLink(rs.getString("link"));
                sedes.add(sd);

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
        return sedes;
    }

    public ArrayList<Sedes> getSedesSeleccion(String nombre, String sedenom) {

        ArrayList<Sedes> sedes = new ArrayList<>();
        String sql = "SELECT hr.hora,pel.nombre,hr.id from pelicula pel "
                + "INNER JOIN detalle_pelicula det "
                + "on pel.id=det.id_pelicula "
                + "INNER JOIN horarios hr "
                + "on det.id_hora=hr.id "
                + "INNER JOIN sede sd "
                + "on det.id_sede=sd.id "
                + "where pel.nombre=? && sd.nombre=? ";

        try {
            cn = ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, sedenom);
            rs = ps.executeQuery();

            while (rs.next()) {
                Sedes sd = new Sedes();
                sd.setId(rs.getInt("id"));
                sd.setNombre(rs.getString("nombre"));
                sd.setDescripcion(rs.getString("hora"));
                
                sedes.add(sd);

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
        return sedes;
    }
    
    
    
}
