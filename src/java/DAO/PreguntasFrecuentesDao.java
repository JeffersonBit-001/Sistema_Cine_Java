/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConexionBD.ConexionBD;
import Modelo.Bebidas;
import Modelo.PreguntasFrecuentes;
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
public class PreguntasFrecuentesDao {
    
    private Connection cn=null;

    
    private PreparedStatement ps=null;
    private ResultSet rs=null;
    
    public ArrayList<PreguntasFrecuentes> obtenerPreguntas(){
    ArrayList<PreguntasFrecuentes> preguntas = new ArrayList<>();
    String sql = "select * from preguntas_frecuentes";
    
        try {
            cn= ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);

            rs = ps.executeQuery();
            
            while(rs.next()){
                PreguntasFrecuentes preg=new PreguntasFrecuentes();
                preg.setId(rs.getInt("id_preguntas"));
                preg.setNombre(rs.getString("nombre"));
                preg.setDescripcion(rs.getString("informacion"));
                preguntas.add(preg);
            }
            
        } catch (SQLException e) {
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
            } catch (SQLException e) {
                
            }
        }
    return preguntas;
    }
    
    
    
    
    
}
