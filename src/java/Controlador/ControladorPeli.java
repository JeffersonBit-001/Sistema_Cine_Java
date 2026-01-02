/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import DAO.CategoriaPeliculaDao;
import DAO.CombosDao;
import DAO.DetallesPeliculaDao;
import DAO.DiaDao;
import DAO.HoraDao;
import DAO.PeliIndexDao;
import DAO.SalasDao;
import DAO.SedesDao;
import DAO.VistaDao;
import Modelo.CategoriaPelicula;
import Modelo.DetallesPelicula;
import Modelo.Dia;
import Modelo.Hora;
import Modelo.PeliIndex;
import Modelo.Salas;
import Modelo.Sedes;
import Modelo.Vista;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author JEFFERSON
 */
@MultipartConfig
public class ControladorPeli extends HttpServlet {

    private PeliIndexDao pel = new PeliIndexDao();
    private CombosDao com = new CombosDao();
    private SedesDao sedes = new SedesDao();
    private DiaDao dia = new DiaDao();
    private HoraDao hora = new HoraDao();
    private SalasDao salas = new SalasDao();
    private VistaDao vista = new VistaDao();
    private CategoriaPeliculaDao cat = new CategoriaPeliculaDao();
    private DetallesPeliculaDao detalles = new DetallesPeliculaDao();
    JsonObject jsonResponse;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String tipoc = request.getParameter("tipoc");

        /*request.setAttribute("buscar", pel.obtenerPeliculaFull());
        request.setAttribute("categoria", cat.obtenerCat());
        request.setAttribute("sedes", sedes.getSedes());
        request.setAttribute("dia", dia.obtenerDia());
        request.setAttribute("hora", hora.obtenerHora());
        request.setAttribute("vista", vista.obtenerVista());*/


        String nombre = "";
        String descrip = "";

        String precio = "";
        String sinopsis = "";

        String idioma = "";
        String director = "";
        String disponible = "";
        String sala = "";
        String link = "";
        String nombrePelicula = "";
        String nombreFile = "";

        /*-----------------------------------------------Sala de la película*/
        /*------------------------------------------------------------------------*/
        /*------------------------------------------------------------------------*/
        /*------------------------------------------------------------------------*/
                String estadpel = request.getParameter("estadoPeli");

                if (estadpel != null) {

                    if (estadpel.equals("pelicula")) {
                        ArrayList<PeliIndex> tipo = pel.obtenerPeliculaFull();

                        response.setContentType("application/json;charset=UTF-8");
                        String conseguirSala = new Gson().toJson(tipo);
                        response.getWriter().println(conseguirSala);
                        return;
                    }

                    if (estadpel.equals("sede")) {
                        ArrayList<Sedes> tipo = sedes.getSedes();

                        response.setContentType("application/json;charset=UTF-8");
                        String conseguirSala = new Gson().toJson(tipo);
                        response.getWriter().println(conseguirSala);
                        return;
                    }

                    if (estadpel.equals("hora")) {
                        ArrayList<Hora> tipo = hora.obtenerHora();

                        response.setContentType("application/json;charset=UTF-8");
                        String conseguirSala = new Gson().toJson(tipo);
                        response.getWriter().println(conseguirSala);
                        return;
                    }

                    if (estadpel.equals("categoria")) {
                        ArrayList<CategoriaPelicula> tipo = cat.obtenerCat();

                        response.setContentType("application/json;charset=UTF-8");
                        String conseguirSala = new Gson().toJson(tipo);
                        response.getWriter().println(conseguirSala);
                        return;
                    }

                    if (estadpel.equals("dia")) {
                        ArrayList<Dia> tipo = dia.obtenerDia();

                        response.setContentType("application/json;charset=UTF-8");
                        String conseguirSala = new Gson().toJson(tipo);
                        response.getWriter().println(conseguirSala);
                        return;
                    }

                    if (estadpel.equals("vista")) {
                        ArrayList<Vista> tipo = vista.obtenerVista();

                        response.setContentType("application/json;charset=UTF-8");
                        String conseguirSala = new Gson().toJson(tipo);
                        response.getWriter().println(conseguirSala);
                        return;
                    }

                }

                /*------------------------------------------------------------------------*/
                /*------------------------------------------------------------------------*/
                /*------------------------------------------------------------------------*/
                /*------------------------------------------------------------------------*/
        
        
        
        String accion = request.getParameter("accion");

        switch (tipoc) {
            case "Tendencias":
                if (request.getParameter("accion") != null) {
                    ArrayList<PeliIndex> listapel = pel.obtenerPeliculasIndex(tipoc, accion);
                    response.setContentType("application/json;charset=UTF-8");
                    String listaPeliculas = new Gson().toJson(listapel);
                    response.getWriter().println(listaPeliculas);
                    /*request.setAttribute("pepp", pel.obtenerPeliculasIndex(tipoc, accion));
                    request.getRequestDispatcher("/Vista/PeliIndex.jsp").forward(request, response);*/
                } else {
                    ArrayList<PeliIndex> listapel = pel.obtenerPeliculasGeneral(tipoc);
                    response.setContentType("application/json;charset=UTF-8");
                    String listaPeliculas = new Gson().toJson(listapel);
                    response.getWriter().println(listaPeliculas);
                    /*
                    request.setAttribute("pepp", pel.obtenerPeliculasGeneral(tipoc));
                    request.getRequestDispatcher("/Vista/PeliIndex.jsp").forward(request, response);*/
                }
                break;

            case "Cartelera":

                if (request.getParameter("accion") != null) {
                    ArrayList<PeliIndex> listapel = pel.obtenerPeliculasIndex(tipoc, accion);
                    response.setContentType("application/json;charset=UTF-8");
                    String listaPeliculas = new Gson().toJson(listapel);
                    response.getWriter().println(listaPeliculas);
                    
                    

                } else {
                    ArrayList<PeliIndex> listapel = pel.obtenerPeliculasGeneral(tipoc);
                    response.setContentType("application/json;charset=UTF-8");
                    String listaPeliculas = new Gson().toJson(listapel);
                    response.getWriter().println(listaPeliculas);

                }
                break;

            case "Estreno":
                if (request.getParameter("accion") != null) {

                    ArrayList<PeliIndex> listapel = pel.obtenerPeliculasIndex(tipoc, accion);
                    response.setContentType("application/json;charset=UTF-8");
                    String listaPeliculas = new Gson().toJson(listapel);
                    response.getWriter().println(listaPeliculas);
                } else {
                    ArrayList<PeliIndex> listapel = pel.obtenerPeliculasGeneral(tipoc);
                    response.setContentType("application/json;charset=UTF-8");
                    String listaPeliculas = new Gson().toJson(listapel);
                    response.getWriter().println(listaPeliculas);
                }
                break;

            case "AdministradorPeliculas":
                nombrePelicula = "Peliculas";

                /*-----------------------------------------------Sala de la película*/
                String estad = request.getParameter("estad");

                if (estad != null) {

                    if (estad.equals("listo")) {
                        ArrayList<Salas> tipo = salas.obtenerSalas();

                        response.setContentType("application/json;charset=UTF-8");
                        String conseguirSala = new Gson().toJson(tipo);
                        response.getWriter().println(conseguirSala);
                        return;
                    }

                }

                /*------------------------------------------------------------------------*/
 /*-----------------------------USUARIOS Y CLIENTES-------------------------------------------*/
                if (accion != null) {
                    int id = 0;
                    if (request.getParameter("id") != null) {

                        id = Integer.parseInt(request.getParameter("id"));
                    }

                    switch (accion) {
                        case "agregar":
                            nombre = request.getParameter("nombre2");
                            descrip = request.getParameter("descripcion2");

                            precio = request.getParameter("precio2");
                            sinopsis = request.getParameter("sinopsis2");

                            director = request.getParameter("director2");
                            idioma = request.getParameter("idioma2");

                            disponible = request.getParameter("disponible2");
                            sala = request.getParameter("sala2");
                            link = request.getParameter("link2");

                            try {
                                Part filePart = request.getPart("imagen2");

                                nombreFile = filePart.getSubmittedFileName();
                                if (nombreFile == null || nombreFile.isEmpty()) {
                                    throw new ServletException("No se ha subido ningún archivo.");
                                }

                                String uploadPath = getServletContext().getRealPath("/img");
                                File uploadDir = new File(uploadPath);
                                if (!uploadDir.exists()) {
                                    uploadDir.mkdirs();
                                }

                                File file = new File(uploadDir, nombreFile);
                                filePart.write(file.getAbsolutePath());

                            } catch (Exception e) {

                            }

                            String agregar = pel.insertarPelicula(nombre, descrip, Float.parseFloat(precio), sinopsis,
                                    director, idioma, String.valueOf(nombreFile),
                                    disponible, Integer.parseInt(sala), link);
                            jsonResponse = new JsonObject();
                            response.setContentType("application/json;charset=UTF-8");
                            response.setCharacterEncoding("UTF-8");
                            response.getWriter().write(new Gson().toJson(jsonResponse));
                            return;

                        case "delete":
                            /*ELIMINAR CLIENTE*/
                            String eliminar = pel.eliminarPelicula(id);
                            return;
                        case "update":
                            /*UPDATE PELICULA*/
                            PeliIndex conseguir = pel.obtenerPeliculaWhere(id);
                            response.setContentType("application/json;charset=UTF-8");
                            String conseguirPeliculas = new Gson().toJson(conseguir);
                            response.getWriter().println(conseguirPeliculas);
                            return;

                        case "update2":
                            //BUSCAR DATOS DE PELICULA PARA MODIFICAR
                            nombre = request.getParameter("nombre");
                            descrip = request.getParameter("descripcion");

                            precio = request.getParameter("precio");
                            sinopsis = request.getParameter("sinopsis");

                            director = request.getParameter("director");
                            idioma = request.getParameter("idioma");

                            disponible = request.getParameter("disponible");
                            sala = request.getParameter("sala");
                            link = request.getParameter("link");

                            try {
                                Part filePart = request.getPart("imagen");
                                nombreFile = filePart.getSubmittedFileName();
                                if (nombreFile == null || nombreFile.isEmpty()) {
                                    throw new ServletException("No se ha subido ningún archivo.");
                                }
                                String uploadPath = getServletContext().getRealPath("/img");
                                File uploadDir = new File(uploadPath);
                                if (!uploadDir.exists()) {
                                    uploadDir.mkdirs();
                                }

                                File file = new File(uploadDir, nombreFile);
                                filePart.write(file.getAbsolutePath());

                                System.out.println("asdasd" + nombreFile);

                            } catch (Exception e) {

                            }

                            String update = pel.updatePelicula(id, nombre, descrip, Float.parseFloat(precio), sinopsis,
                                    director, idioma, String.valueOf(nombreFile),
                                    disponible, Integer.parseInt(sala), link);
                            jsonResponse = new JsonObject();
                            response.setContentType("application/json");
                            response.setCharacterEncoding("UTF-8");
                            response.getWriter().write(new Gson().toJson(jsonResponse));

                            return;

                        case "mostrar":
                            mostrar(request, response, nombrePelicula);
                            return;

                        default:
                            throw new AssertionError();
                    }

                }

                request.getRequestDispatcher("/VistaAdministrador/AdmPeliculas.jsp").forward(request, response);

                break;

            case "AdministrarDetallesPeliculas":

                nombrePelicula = "Detalles Peliculas";

                
 /*-----------------------------USUARIOS Y CLIENTES-------------------------------------------*/
                if (accion != null) {
                    int id = 0;
                    if (request.getParameter("id") != null) {

                        id = Integer.parseInt(request.getParameter("id"));
                    }

                    switch (accion) {
                        case "agregar":

                            int idPelicula2 = Integer.parseInt(request.getParameter("pelicula2"));
                            int idSede2 = Integer.parseInt(request.getParameter("sede2"));
                            int idHora2 = Integer.parseInt(request.getParameter("hora2"));
                            int idCategoria2 = Integer.parseInt(request.getParameter("categoria2"));
                            int idDia2 = Integer.parseInt(request.getParameter("dia2"));
                            int idVista2 = Integer.parseInt(request.getParameter("vista2"));

                            String agregar = detalles.insertarDetalles(idPelicula2, idSede2, idHora2, idCategoria2, idDia2, idVista2);

                            return;

                        case "delete":
                            /*ELIMINAR CLIENTE*/
                            String eliminar = detalles.deleteDetalles(id);

                            return;

                        case "update":
                            /*UPDATE DETALLE*/

                            DetallesPelicula conseguir = detalles.obtenerDetallesPeliculaFullWhere(id);

                            response.setContentType("application/json;charset=UTF-8");
                            String conseguirPeliculas = new Gson().toJson(conseguir);
                            response.getWriter().println(conseguirPeliculas);
                            return;

                        case "update2":

                            int idPelicula = Integer.parseInt(request.getParameter("pelicula"));
                            int idSede = Integer.parseInt(request.getParameter("sede"));
                            int idHora = Integer.parseInt(request.getParameter("hora"));
                            int idCategoria = Integer.parseInt(request.getParameter("categoria"));
                            int idDia = Integer.parseInt(request.getParameter("dia"));
                            int idVista = Integer.parseInt(request.getParameter("vista"));

                            String update = detalles.actualizarDetalles(id, idPelicula, idSede, idHora, idCategoria, idDia, idVista);

                            return;

                        case "mostrar":
                            mostrar(request, response, nombrePelicula);
                            return;

                        default:
                            throw new AssertionError();
                    }

                }

                request.getRequestDispatcher("/VistaAdministrador/AdmPeliculas.jsp").forward(request, response);
                break;

            default:

        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    protected void mostrar(HttpServletRequest request, HttpServletResponse response, String nombre)
            throws ServletException, IOException {
        /*response.setContentType("application/json;charset=UTF-8");
        String listaUsuarios = new Gson().toJson(cli.obtenerClientes(nombre));
        response.getWriter().println(listaUsuarios);*/

        if (nombre.equals("Peliculas")) {
            ArrayList<PeliIndex> conseguir = pel.obtenerPeliculaFull();

            response.setContentType("application/json");
            PrintWriter out = response.getWriter();

            String json = new Gson().toJson(conseguir);
            out.print(json);
            out.flush();
        } else {
            ArrayList<DetallesPelicula> conseguir = detalles.obtenerDetallesPeliculaFull();

            response.setContentType("application/json");
            PrintWriter out = response.getWriter();

            String json = new Gson().toJson(conseguir);
            out.print(json);
            out.flush();
        }

    }

}
