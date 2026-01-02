/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConexionBD.ConexionBD;
import Modelo.Asientos;
import Modelo.DetalleReserva;
import Modelo.Dia;
import Modelo.Hora;
import Modelo.PeliIndex;
import Modelo.Sedes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author JEFFERSON
 */
public class DetalleReservaDao {

    private Connection cn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public DetalleReserva getSeleccion(String nombre, String sedenom, int idhora) {

        DetalleReserva detalleReserva = null;
        String sql = "SELECT ds.id_dia as dia_id, ds.descripcion as dia_descripcion,"
                + " sd.id as sd_id, sd.nombre as sd_nom, "
                + " pel.id as pel_id, pel.disponible as pel_disponible, pel.nombre"
                + " as pel_nom, pel.imagen,pel.precio as pel_precio,"
                + " sl.nombre_sala, "
                + " hr.id id_hora, hr.hora "
                + " FROM pelicula pel "
                + " INNER JOIN detalle_pelicula det ON pel.id = det.id_pelicula "
                + " INNER JOIN horarios hr ON det.id_hora = hr.id "
                + " INNER JOIN sede sd ON det.id_sede = sd.id "
                + " INNER JOIN salas_peli sl ON pel.id_salas = sl.id_sala "
                + " INNER JOIN dias ds ON det.id_dia = ds.id_dia "
                + " WHERE pel.nombre = ? AND sd.nombre = ? AND hr.id = ?";

        try {
            cn = ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, sedenom);
            ps.setInt(3, idhora);
            rs = ps.executeQuery();

            if (rs.next()) {
                detalleReserva = new DetalleReserva();

                detalleReserva.setPeli(new PeliIndex(
                        rs.getInt("pel_id"),
                        rs.getString("pel_nom"),
                        "",
                        "",
                        rs.getString("imagen"),
                        "",
                        rs.getFloat("pel_precio"),
                        "",
                        "",
                        rs.getString("pel_disponible"),
                        rs.getString("nombre_sala"),
                        ""
                ));

                detalleReserva.setSede(new Sedes(
                        rs.getInt("sd_id"),
                        rs.getString("sd_nom"),
                        "",
                        "",
                        ""
                ));

                detalleReserva.setHora(new Hora(
                        rs.getInt("id_hora"),
                        rs.getString("hora"),
                        "",
                        ""
                ));

                detalleReserva.setDia(new Dia(
                        rs.getInt("dia_id"),
                        rs.getString("dia_descripcion"),
                        "",
                        ""
                ));
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
        return detalleReserva;
    }

    public ArrayList<Asientos> getAsientos(int id_peli, int id_sede, int idhora) {
        ArrayList<Asientos> asientos = new ArrayList<>();
        String sql = "SELECT CONCAT(cat.nombre, asi.numero) AS nom, "
                + " det.id_categoria AS iddet, "
                + " deasi.nombre AS estado, det.id as idpe"
                + " FROM detalle_asiento det"
                + " INNER JOIN numero_asiento asi ON det.id_asiento = asi.id"
                + " INNER JOIN categoria_asiento cat ON det.id_categoria = cat.id"
                + " INNER JOIN pelicula pel ON det.id_pelicula = pel.id"
                + " INNER JOIN estado_asientos deasi ON det.id_estado = deasi.id"
                + " INNER JOIN sede sd on det.id_sede = sd.id "
                + " INNER JOIN horarios hor on det.id_sede = hor.id "
                + " WHERE det.id_pelicula = ? and det.id_sede=?  and det.id_hora =?"
                + " ORDER BY "
                + " cat.nombre ASC, "
                + " CAST(asi.numero AS UNSIGNED) ASC";

        try {
            cn = ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id_peli);
            ps.setInt(2, id_sede);
            ps.setInt(3, idhora);
            rs = ps.executeQuery();

            while (rs.next()) {
                Asientos as=new Asientos();
                as.setNombre(rs.getString("nom"));
                as.setIdDet(rs.getInt("iddet"));
                as.setEstado(rs.getString("estado"));
                as.setIdPeli(rs.getInt("idpe"));
                asientos.add(as);
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
        return asientos;
    }

}
