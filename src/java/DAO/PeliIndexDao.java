/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConexionBD.ConexionBD;
import Modelo.DetallesPelicula;
import Modelo.PeliIndex;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JEFFERSON
 */
public class PeliIndexDao {

    private Connection cn=null;

    
    private PreparedStatement ps=null;
    private ResultSet rs=null;

    /*INDEX Y CARTELERA DE PELICULAS*/
    public ArrayList<PeliIndex> obtenerPeliculasIndex(String tip, String cat) {
        ArrayList<PeliIndex> peliculas = new ArrayList<>();
        String sql = "SELECT peli.id AS id, peli.nombre AS nombre, peli.descripcion AS descripcion, "
                + "peli.sinopsis AS sinopsis, peli.imagen AS img, vs.nombre as tip "
                + "FROM detalle_pelicula det "
                + "INNER JOIN pelicula peli ON det.id_pelicula = peli.id "
                + "INNER JOIN categoria_peli cat ON det.id_categoria = cat.id_categoria "
                + "INNER JOIN vista vs ON det.id_vista = vs.id "
                + "INNER JOIN sede sd ON det.id_sede = sd.id "
                + "INNER JOIN dias da ON det.id_dia = da.id_dia "
                + "WHERE vs.nombre = ? and peli.estado = 'NE' "
                + "AND (cat.nombre = ? OR sd.nombre = ? OR da.nombre = ? or peli.nombre = ?) "
                + "GROUP BY peli.id";

        try {
            cn = ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setString(1, tip);
            ps.setString(2, cat);
            ps.setString(3, cat);
            ps.setString(4, cat);
            ps.setString(5, cat);

            rs = ps.executeQuery();

            while (rs.next()) {
                PeliIndex peli = new PeliIndex();
                peli.setId(rs.getInt("id"));
                peli.setNombre(rs.getString("nombre"));
                peli.setDescripcion(rs.getString("descripcion"));
                peli.setSinopsis(rs.getString("sinopsis"));
                peli.setImg(rs.getString("img"));
                peli.setVista(rs.getString("tip"));
                peliculas.add(peli);
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
        return peliculas;
    }

    public PeliIndex obtenerPeliculasIndex2(String tip, String cat) {
        PeliIndex peli = new PeliIndex();
        String sql = "SELECT peli.id AS id, peli.nombre AS nombre, peli.descripcion AS descripcion, "
                + "peli.sinopsis AS sinopsis, peli.imagen AS img, vs.nombre as tip "
                + "FROM detalle_pelicula det "
                + "INNER JOIN pelicula peli ON det.id_pelicula = peli.id "
                + "INNER JOIN categoria_peli cat ON det.id_categoria = cat.id_categoria "
                + "INNER JOIN vista vs ON det.id_vista = vs.id "
                + "INNER JOIN sede sd ON det.id_sede = sd.id "
                + "INNER JOIN dias da ON det.id_dia = da.id_dia "
                + "WHERE vs.nombre = ? and peli.estado = 'NE' "
                + "AND peli.nombre = ? "
                + "GROUP BY peli.id";

        try {
            cn = ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setString(1, tip);
            ps.setString(2, cat);

            rs = ps.executeQuery();

            while (rs.next()) {

                peli.setId(rs.getInt("id"));
                peli.setNombre(rs.getString("nombre"));
                peli.setDescripcion(rs.getString("descripcion"));
                peli.setSinopsis(rs.getString("sinopsis"));
                peli.setImg(rs.getString("img"));
                peli.setVista(rs.getString("tip"));

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
        return peli;
    }

    public ArrayList<PeliIndex> obtenerPeliculasGeneral(String tip) {
        ArrayList<PeliIndex> peliculas = new ArrayList<>();
        String sql = "SELECT peli.id AS id, peli.nombre AS nombre, peli.descripcion AS descripcion, "
                + "peli.sinopsis AS sinopsis, peli.imagen AS img, vs.nombre as tip "
                + "FROM detalle_pelicula det "
                + "INNER JOIN pelicula peli ON det.id_pelicula = peli.id "
                + "INNER JOIN categoria_peli cat ON det.id_categoria = cat.id_categoria "
                + "INNER JOIN vista vs ON det.id_vista = vs.id "
                + "INNER JOIN sede sd ON det.id_sede = sd.id "
                + "INNER JOIN dias da ON det.id_dia = da.id_dia "
                + "WHERE vs.nombre = ? and peli.estado = 'NE' "
                + "GROUP BY peli.id";

        try {
            cn = ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setString(1, tip);

            rs = ps.executeQuery();

            while (rs.next()) {
                PeliIndex peli = new PeliIndex();
                peli.setId(rs.getInt("id"));
                peli.setNombre(rs.getString("nombre"));
                peli.setDescripcion(rs.getString("descripcion"));
                peli.setSinopsis(rs.getString("sinopsis"));
                peli.setImg(rs.getString("img"));
                peli.setVista(rs.getString("tip"));
                peliculas.add(peli);
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
        return peliculas;
    }

    public ArrayList<PeliIndex> obtenerPeliculasSlider() {
        ArrayList<PeliIndex> peliculas = new ArrayList<>();
        String sql = "SELECT peli.id AS id, peli.nombre AS nombre, detcn.sinopsis AS sinopsis, "
                + "detcn.img AS img "
                + "FROM detalle_cine detcn "
                + "INNER JOIN pelicula peli ON detcn.id_pelicula = peli.id "
                + "INNER JOIN vista vs ON detcn.id_vista=vs.id "
                + "WHERE vs.nombre = 'Principal' and peli.estado = 'NE' ";

        try {
            cn = ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                PeliIndex peli = new PeliIndex();
                peli.setId(rs.getInt("id"));
                peli.setNombre(rs.getString("nombre"));
                peli.setSinopsis(rs.getString("sinopsis"));
                peli.setImg(rs.getString("img"));
                peliculas.add(peli);
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
        return peliculas;
    }

    public PeliIndex obtenerPeliculasInfo(String nombre) {
        PeliIndex peli = new PeliIndex();
        String sql = "SELECT pel.id,pel.nombre,pel.descripcion "
                + ",pel.precio,pel.sinopsis,pel.director, pel.idioma,"
                + "pel.imagen,pel.disponible,pel.link ,vs.nombre as vnombre "
                + "FROM detalle_pelicula"
                + " det inner join pelicula pel "
                + "on det.id_pelicula= pel.id "
                + "inner join vista vs "
                + "on det.id_vista=vs.id "
                + "WHERE pel.nombre = ? and pel.estado = 'NE' "
                + "group by pel.id,pel.nombre,pel.descripcion ,"
                + "pel.precio,pel.sinopsis,pel.director, pel.idioma,"
                + "pel.imagen,pel.disponible,pel.link,vs.nombre";

        try {
            cn = ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setString(1, nombre);
            rs = ps.executeQuery();

            if (rs.next()) {

                peli.setId(rs.getInt("id"));
                peli.setNombre(rs.getString("nombre"));
                peli.setDescripcion(rs.getString("descripcion"));
                peli.setPrecio(rs.getFloat("precio"));
                peli.setSinopsis(rs.getString("sinopsis"));
                peli.setDirector(rs.getString("director"));
                peli.setIdioma(rs.getString("idioma"));
                peli.setImg(rs.getString("imagen"));
                peli.setDisponible(rs.getString("disponible"));
                peli.setLinkyou(rs.getString("link"));
                peli.setVista(rs.getString("vnombre"));

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
        return peli;
    }

    
    
    /*PELICULAS CONSULTA*/
    public ArrayList<PeliIndex> obtenerPeliculaFull() {
        ArrayList<PeliIndex> peliculas = new ArrayList<>();
        String sql = "SELECT * FROM PELICULA pel "
                + "inner join salas_peli sal "
                + "on pel.id_salas = sal.id_sala "
                + "WHERE pel.estado = 'NE'";

        try {
            cn = ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                PeliIndex peli = new PeliIndex();
                peli.setId(rs.getInt("id"));
                peli.setNombre(rs.getString("nombre"));
                peli.setDescripcion(rs.getString("descripcion"));
                peli.setPrecio(rs.getFloat("precio"));
                peli.setSinopsis(rs.getString("sinopsis"));
                peli.setDirector(rs.getString("director"));
                peli.setIdioma(rs.getString("idioma"));
                peli.setImg(rs.getString("imagen"));
                peli.setDisponible(rs.getString("disponible"));
                peli.setLinkyou(rs.getString("link"));
                peli.setSala(rs.getString("nombre_sala"));

                peliculas.add(peli);
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
        return peliculas;
    }

    public PeliIndex obtenerPeliculaWhere(int id) {
        PeliIndex peli = new PeliIndex();
        
        String sql = "SELECT pel.id as idpel, pel.nombre as nom, pel.descripcion, pel.precio ," +
        "pel.sinopsis, pel. director, pel.idioma, pel.imagen, pel.disponible," +
        "pel.link, sal.id_sala as nomsa " +
        "FROM PELICULA pel " +
        "inner join salas_peli sal " +
        "on pel.id_salas = sal.id_sala where pel.id = ? and pel.estado = 'NE' ";

        try {
            cn = ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                peli.setId(rs.getInt("idpel"));
                peli.setNombre(rs.getString("nom"));
                peli.setDescripcion(rs.getString("descripcion"));
                peli.setPrecio(rs.getFloat("precio"));
                peli.setSinopsis(rs.getString("sinopsis"));
                peli.setDirector(rs.getString("director"));
                peli.setIdioma(rs.getString("idioma"));
                peli.setImg(rs.getString("imagen"));
                peli.setDisponible(rs.getString("disponible"));
                peli.setLinkyou(rs.getString("link"));
                peli.setSala(rs.getString("nomsa"));
                
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
        return peli;
    }
    
    /*ELIMINAR*/
    public String eliminarPelicula(int id) {
        String respuesta = "";
        String sql = "UPDATE pelicula SET estado = 'E' WHERE id = ? and estado = 'NE' ";

        try {
            cn = ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);

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
    
    /*Agregar PELICuLA*/
    public String insertarPelicula(
            String nombre, String descripcion, float precio, String sinopsis, String director,
            String idioma, String imagen, String disponible, int id_salas, String link) {

        String respuesta = "";
        String sql = "INSERT INTO `taller_final`.`PELICULA` "
            + "(`nombre`, `descripcion`, `precio`, `sinopsis`, "
            + "`director`, `idioma`, `imagen`, `disponible`, `id_salas`, "
            + "`link`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            cn = ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, descripcion);
            ps.setFloat(3, precio);
            ps.setString(4, sinopsis);
            ps.setString(5, director);
            ps.setString(6, idioma);
            ps.setString(7, imagen);
            ps.setString(8, disponible);
            ps.setInt(9, id_salas);
            ps.setString(10, link);

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
    
    
    /*update pelicula*/
    public String updatePelicula(int id,
            String nombre, String descripcion, float precio, String sinopsis, String director,
            String idioma, String imagen, String disponible, int id_salas, String link) {

        String respuesta = "";
        String sql = "UPDATE PELICULA SET "
            + "nombre = ?, descripcion = ?, precio = ?, "
            + "sinopsis = ?, director = ?, idioma = ?, "
            + "imagen = ?, disponible = ?, id_salas = ?, "
            + "link = ? "
            + "WHERE id = ? ";
        try {
            cn = ConexionBD.getConexion();
            ps = cn.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, descripcion);
            ps.setFloat(3, precio);
            ps.setString(4, sinopsis);
            ps.setString(5, director);
            ps.setString(6, idioma);
            ps.setString(7, imagen);
            ps.setString(8, disponible);
            ps.setInt(9, id_salas);
            ps.setString(10, link);
            ps.setInt(11, id);

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
