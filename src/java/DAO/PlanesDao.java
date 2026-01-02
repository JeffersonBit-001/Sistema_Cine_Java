/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConexionBD.ConexionBD;
import Modelo.Planes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JEFFERSON
 */
public class PlanesDao {
    
    private Connection cn;

    public PlanesDao() {
        cn = new ConexionBD().getConexion();
    }
    

    private PreparedStatement ps=null;
    private ResultSet rs=null;
    
    public ArrayList<Planes> obtenerPlanesIndex(){
    ArrayList<Planes> planes = new ArrayList<>();
    String sql = "select planes.id_planes,planes.nombre,planes.precio,planes.des1,planes.des2,planes.des3"
            + ",planes.des4,planes.des5 from planes";
    
        try {
            
            ps = cn.prepareStatement(sql);            
            rs = ps.executeQuery();
            
            while(rs.next()){
                Planes plan=new Planes();
                plan.setId(rs.getInt("id_planes"));
                plan.setNombre(rs.getString("nombre"));
                plan.setPrecio(rs.getFloat("precio"));
                plan.setDes1(rs.getString("des1"));
                plan.setDes2(rs.getString("des2"));
                plan.setDes3(rs.getString("des3"));
                plan.setDes4(rs.getString("des4"));
                plan.setDes5(rs.getString("des5"));
                planes.add(plan);
            }
            
        } catch (Exception e) {
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
            } catch (Exception e) {
                
            }
        }
    return planes;
    }
}
