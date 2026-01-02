/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConexionBD.ConexionBD;
import Modelo.PeliIndex;
import Modelo.Vista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author JEFFERSON
 */
public class VistaDao {
    private Connection cn=null;

    
    private PreparedStatement ps=null;
    private ResultSet rs=null;
    
    public ArrayList<Vista> obtenerVista() {
        ArrayList<Vista> vista = new ArrayList<>();
        String sql = "SELECT * FROM vista ";

        try {
            cn = ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                Vista dd = new Vista();
                dd.setId(rs.getInt("id"));
                dd.setNombre(rs.getString("nombre"));
                vista.add(dd);
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
        return vista;
    }
    
    
    
}
