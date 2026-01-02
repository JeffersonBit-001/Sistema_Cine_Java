/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConexionBD.ConexionBD;
import Modelo.CategoriaPelicula;
import Modelo.PeliIndex;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author JEFFERSON
 */
public class CategoriaPeliculaDao {
    
    private Connection cn=null;

    
    private PreparedStatement ps=null;
    private ResultSet rs=null;
    
    
    public ArrayList<CategoriaPelicula> obtenerCat() {
        ArrayList<CategoriaPelicula> categoria = new ArrayList<>();
        String sql = "SELECT * FROM categoria_peli ";

        try {
            cn = ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                CategoriaPelicula cat = new CategoriaPelicula();
                cat.setId(rs.getInt("id_categoria"));
                cat.setNombre(rs.getString("nombre"));

                categoria.add(cat);
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
        return categoria;
    }

    
}
