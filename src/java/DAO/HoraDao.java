/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConexionBD.ConexionBD;
import Modelo.Hora;
import Modelo.PeliIndex;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author JEFFERSON
 */
public class HoraDao {
    
    private Connection cn=null;

    
    private PreparedStatement ps=null;
    private ResultSet rs=null;
    
    
    public ArrayList<Hora> obtenerHora() {
        ArrayList<Hora> hora = new ArrayList<>();
        String sql = "SELECT * FROM horarios order by hora asc";

        try {
            cn = ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                Hora dd = new Hora();
                dd.setId(rs.getInt("id"));
                dd.setNombre(rs.getString("hora"));
                hora.add(dd);
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
        return hora;
    }
    
}
