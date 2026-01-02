/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConexionBD.ConexionBD;
import Modelo.Asientos;
import Modelo.CarritoCombos;
import Modelo.DetalleReserva;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author JEFFERSON
 */
public class FacturaDao {

    private Connection cn = null;

    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public String insertarFactura(DetalleReserva detalle, int id) {

        String respuesta = "";
        String sql = "INSERT INTO tb_pagos(id_cliente, cantidad_butacas, total_precio_combos, total_neto,"
                + " codigo_aleatorio, total_descuento) "
                + "VALUES (?, ?, ?, ?, ?, ?);";

        try {
            cn = ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, detalle.getCantidadEntradas());
            ps.setFloat(3, detalle.getPrecioCarritoCompras());
            ps.setFloat(4, detalle.getPrecioTotal());
            ps.setString(5, detalle.getCodigoPago());
            ps.setFloat(6, detalle.getPrecioTotal());

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

    public void obtenerFactura(DetalleReserva detalle) {
        String sql = "select * from tb_pagos  where codigo_aleatorio = ?";

        try {
            cn = ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setString(1, detalle.getCodigoPago());
            rs = ps.executeQuery();

            if (rs.next()) {
                detalle.setIdReserva(rs.getInt("id"));
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
    }

    public String insertarFacturaDetalleAsiento(DetalleReserva detalle) {

        String respuesta = "";
        String sql = "INSERT INTO detalle_pago_asiento(id_pago, id_asiento) "
                + "VALUES (?, ?);";

        try {
            cn = ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);

            for (Asientos asientos : detalle.getArrayAsientos()) {
                ps.setInt(1, detalle.getIdReserva());
                ps.setInt(2, asientos.getIdDet());
                ps.executeUpdate();
            }

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
    
    public String actualizarAsiento(DetalleReserva detalle) {

        String respuesta = "";
        String sql = "update detalle_asiento set id_estado=? where id = ? ";

        try {
            cn = ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);

            for (Asientos asientos : detalle.getArrayAsientos()) {
                ps.setInt(1, 2);
                ps.setInt(2, asientos.getIdDet());
                ps.executeUpdate();
            }

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

    public String insertarFacturaDetalleBebidas(DetalleReserva detalle) {

        String respuesta = "";
        String sql = "INSERT INTO detalle_pago_bebidas(id_pago, id_bebidas,cantidad,precio_total) "
                + "VALUES (?, ?,?,?);";

        try {
            cn = ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);

            for (CarritoCombos carrito : detalle.getArrayCarritoCombos()) {
                if (carrito.getTabla().equals("Bebidas")) {
                    
                    String precioStr = carrito.getPrecio();
                    float precio = 0;
                    try {
                        
                        precioStr = precioStr.replace("S/", "").trim();
                        precio = Float.parseFloat(precioStr);
                    } catch (NumberFormatException e) {
                        System.out.println("Error al convertir el precio: " + e.getMessage());
                    }

                    ps.setInt(1, detalle.getIdReserva());
                    ps.setString(2, carrito.getId());
                    ps.setInt(3, carrito.getCantidad());
                    ps.setFloat(4, carrito.getCantidad() * precio);

                    ps.executeUpdate();
                }
            }

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
    
    public String insertarFacturaDetalleCombos(DetalleReserva detalle) {

        String respuesta = "";
        String sql = "INSERT INTO detalle_pago_combos(id_pago, id_combo,cantidad,precio_total) "
                + "VALUES (?, ?,?,?);";

        try {
            cn = ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);

            for (CarritoCombos carrito : detalle.getArrayCarritoCombos()) {
                if (carrito.getTabla().equals("Combos")) {
                    
                    String precioStr = carrito.getPrecio();
                    float precio = 0;
                    try {
                        
                        precioStr = precioStr.replace("S/", "").trim();
                        precio = Float.parseFloat(precioStr);
                    } catch (NumberFormatException e) {
                        System.out.println("Error al convertir el precio: " + e.getMessage());
                    }

                    ps.setInt(1, detalle.getIdReserva());
                    ps.setString(2, carrito.getId());
                    ps.setInt(3, carrito.getCantidad());
                    ps.setFloat(4, carrito.getCantidad() * precio);

                    ps.executeUpdate();
                }
            }

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
    
    public String insertarFacturaDetalleDulceria(DetalleReserva detalle) {

        String respuesta = "";
        String sql = "INSERT INTO detalle_pago_dulceria(id_pago, id_dulceria,cantidad,precio_total) "
                + "VALUES (?, ?,?,?);";

        try {
            cn = ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);

            for (CarritoCombos carrito : detalle.getArrayCarritoCombos()) {
                if (carrito.getTabla().equals("Dulceria")) {
                    
                    String precioStr = carrito.getPrecio();
                    float precio = 0;
                    try {
                        
                        precioStr = precioStr.replace("S/", "").trim();
                        precio = Float.parseFloat(precioStr);
                    } catch (NumberFormatException e) {
                        System.out.println("Error al convertir el precio: " + e.getMessage());
                    }

                    ps.setInt(1, detalle.getIdReserva());
                    ps.setString(2, carrito.getId());
                    ps.setInt(3, carrito.getCantidad());
                    ps.setFloat(4, carrito.getCantidad() * precio);

                    ps.executeUpdate();
                }
            }

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
    
    public String insertarFacturaDetallePelicula(DetalleReserva detalle) {

        String respuesta = "";
        String sql = "INSERT INTO detalle_pago_pelicula(id_pago, id_pelicula,cantidad,precio_total) "
                + "VALUES (?, ?,?,?);";

        try {
            cn = ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);

            

                    ps.setInt(1, detalle.getIdReserva());
                    ps.setInt(2, detalle.getPeli().getId());
                    ps.setInt(3, detalle.getArrayAsientos().size());
                    ps.setFloat(4, detalle.getArrayAsientos().size() * detalle.getPeli().getPrecio());

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
