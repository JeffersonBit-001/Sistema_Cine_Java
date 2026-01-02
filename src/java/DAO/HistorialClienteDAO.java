/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConexionBD.ConexionBD;
import Modelo.HistorialCliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author JEFFERSON
 */
public class HistorialClienteDAO {
    
    private Connection cn=null;

    
    private PreparedStatement ps=null;
    private ResultSet rs=null;
    
    
    
    public ArrayList<HistorialCliente> obtenerHistorial(int id){
    ArrayList<HistorialCliente> historial = new ArrayList<>();
    String sql = "select pag.id as id_reserva, pag.fecha, pag.hora, concat_ws(' ', cl.nombres,cl.apellidos) as nombreCliente, " +
                    " " +
                    "pel.nombre as nombrePelicula, pel.precio as precioPelicula, pel.imagen as imgPelicula," +
                    "dpel.cantidad as cantPelicula, dpel.precio_total as totalPelicula," +
                    " " +
                    "concat_ws('', catas.nombre,num.numero) as asiento," +
                    " " +
                    "beb.nombre_bebida as nombreBebida, beb.precio as precioBebida, beb.img_bebida as imgBebida," +
                    "dbeb.cantidad as cantidadBebida, dbeb.precio_total as totalBebida," +
                    " " +
                    "comb.nombre as nombreCombos, comb.precio as precioCombos, comb.imagen as imgCombos," +
                    "dcomb.cantidad as cantidadCombos, dcomb.precio_total as totalCombos," +
                    " " +
                    "dul.nom_dulceria as nombreDulceria, dul.precio_dulceria as precioDulceria, dul.img_dulceria as imgDulceria," +
                    "ddul.cantidad as cantidadDulceria, ddul.precio_total as totalDulceria" +
                    " " +
                    "from tb_pagos pag " +
                    "inner join clientes cl " +
                    "on pag.id_cliente = cl.id " +
                    "inner join detalle_pago_pelicula dpel " +
                    "on pag.id = dpel.id_pago " +
                    "inner join pelicula pel " +
                    "on dpel.id_pelicula = pel.id " +
                    "left join detalle_pago_asiento dasie " +
                    "on pag.id = dasie.id_pago " +
                    "left join detalle_asiento asi " +
                    "on dasie.id_asiento = asi.id " +
                    "left join numero_asiento num " +
                    "on asi.id_asiento = num.id " +
                    "left join categoria_asiento catas " +
                    "on asi.id_categoria = catas.id " +
                    "left join detalle_pago_bebidas dbeb " +
                    "on pag.id = dbeb.id_pago " +
                    "left join bebidas beb " +
                    "on dbeb.id_bebidas = beb.id_bebidas " +
                    "left join detalle_pago_combos dcomb " +
                    "on pag.id = dcomb.id_pago " +
                    "left join combos comb " +
                    "on dcomb.id_combo = comb.id " +
                    "left join detalle_pago_dulceria ddul " +
                    "on pag.id = ddul.id_pago " +
                    "left join dulceria dul " +
                    "on ddul.id_dulceria = dul.id_dulceria " +
                    "where pag.id_cliente = ?";
    
        try {
            cn= ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            
            while(rs.next()){
                HistorialCliente hist=new HistorialCliente();
                hist.setIdPago(rs.getInt("id_reserva"));
                hist.setFecha(rs.getString("fecha"));
                hist.setHora(rs.getString("hora"));
                hist.setNombreCliente(rs.getString("nombreCliente"));
                
                hist.setNombrePelicula(rs.getString("nombrePelicula"));
                hist.setPrecioPelicula(rs.getFloat("precioPelicula"));
                hist.setImgPelicula(rs.getString("imgPelicula"));
                hist.setCantPelicula(rs.getInt("cantPelicula"));
                hist.setTotalPelicula(rs.getFloat("totalPelicula"));
                
                hist.setAsiento(rs.getString("asiento"));
                
                hist.setNombreBebida(rs.getString("nombreBebida"));
                hist.setPrecioBebida(rs.getFloat("precioBebida"));
                hist.setImgBebida(rs.getString("imgBebida"));
                hist.setCantidadBebida(rs.getInt("cantidadBebida"));
                hist.setTotalBebida(rs.getFloat("totalBebida"));
                
                hist.setNombreCombos(rs.getString("nombreCombos"));
                hist.setPrecioCombos(rs.getFloat("precioCombos"));
                hist.setImgCombos(rs.getString("imgCombos"));
                hist.setCantidadCombos(rs.getInt("cantidadCombos"));
                hist.setTotalCombos(rs.getFloat("totalCombos"));
                
                
                hist.setNombreDulceria(rs.getString("nombreDulceria"));
                hist.setPrecioDulceria(rs.getFloat("precioDulceria"));
                hist.setImgDulceria(rs.getString("imgDulceria"));
                hist.setCantidadDulceria(rs.getInt("cantidadDulceria"));
                hist.setTotalDulceria(rs.getFloat("totalDulceria"));
                
                
                historial.add(hist);
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
    return historial;
    }
    
}
