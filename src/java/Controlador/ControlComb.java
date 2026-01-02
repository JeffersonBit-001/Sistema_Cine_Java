/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import DAO.CombosDao;
import DAO.DetallesCombosDao;
import DAO.SedesDao;
import Modelo.Combos;
import Modelo.DetalleCategoriaCombos;
import Modelo.PeliIndex;
import Modelo.Sedes;
import com.google.gson.Gson;
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
public class ControlComb extends HttpServlet {

    private CombosDao cb = new CombosDao();
    private SedesDao sedes = new SedesDao();
    private DetallesCombosDao det = new DetallesCombosDao();

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

        String nombreCombo = "";
        String nombreFile = "";

        /*-----------------------------------------------Sala de la película*/
        String estadcomb = request.getParameter("estadoSeleComb");

        if (estadcomb != null) {

            if (estadcomb.equals("combo")) {
                ArrayList<Combos> tipo = cb.obtenerCombosFull();

                response.setContentType("application/json;charset=UTF-8");
                String conseguirCombo = new Gson().toJson(tipo);
                response.getWriter().println(conseguirCombo);
                return;
            }

            if (estadcomb.equals("sede")) {
                ArrayList<Sedes> tipo = sedes.getSedes();

                response.setContentType("application/json;charset=UTF-8");
                String conseguirSala = new Gson().toJson(tipo);
                response.getWriter().println(conseguirSala);
                return;
            }

            if (estadcomb.equals("categoria")) {
                ArrayList<Combos> tipo = cb.obtenerCategoriasCombos();

                response.setContentType("application/json;charset=UTF-8");
                String conseguirCat = new Gson().toJson(tipo);
                response.getWriter().println(conseguirCat);
                return;
            }

        }

        /*------------------------------------------------------------------------*/
        String accion = request.getParameter("accion");
        switch (tipoc) {

            case "AdministradorCombos":
                nombreCombo = "Combos";

                /*request.setAttribute("datos", cb.obtenerCombosFull());
                request.setAttribute("agregarModal", "agregarModalCombos");
                request.setAttribute("modificarModal", "modificarModalCombos");
                request.setAttribute("informacion", "Agregar Combos");

                request.setAttribute("estados_contralador", "AdministradorCombos");
                request.setAttribute("titulo", nombreCombo);*/
                if (accion != null) {
                    int id = 0;
                    if (request.getParameter("id") != null) {

                        id = Integer.parseInt(request.getParameter("id"));
                    }

                    switch (accion) {
                        case "agregar":

                            String nomb = request.getParameter("nombre2");
                            String abaste = request.getParameter("abastece2");

                            String prec = request.getParameter("precio2");
                            String sinops = request.getParameter("sinopsis2");

                            String oferta = request.getParameter("oferta2");

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

                            String agregar = cb.insertarCombos(nomb, abaste, String.valueOf(nombreFile),
                                    sinops, Float.parseFloat(prec), oferta);

                            return;

                        case "delete":
                            /*ELIMINAR CLIENTE*/
                            String eliminar = cb.eliminarCombo(id);

                            return;

                        case "update":
                            /*UPDATE CLIENTE*/

                            Combos conseguir = cb.obtenerCombos(id);

                            response.setContentType("application/json");
                            PrintWriter out = response.getWriter();

                            String json = new Gson().toJson(conseguir);
                            out.print(json);
                            out.flush();
                            return;

                        case "update2":

                            String nomb2 = request.getParameter("nombre");
                            String abaste2 = request.getParameter("abastece");

                            String prec2 = request.getParameter("precio");
                            String sinops2 = request.getParameter("sinopsis");

                            String oferta2 = request.getParameter("oferta");

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

                            } catch (Exception e) {

                            }
                            /*enctype="multipart/form-data"*/

                            String update = cb.updateCombos(id, nomb2, abaste2, String.valueOf(nombreFile),
                                    sinops2, Float.parseFloat(prec2), oferta2);

                            return;

                        case "mostrar":
                            mostrar(request, response, nombreCombo);
                            return;
                        default:
                            throw new AssertionError();
                    }

                }

                request.getRequestDispatcher("/VistaAdministrador/AdmCombo.jsp").forward(request, response);

                break;

            case "AdministrarDetallesCombos":

                nombreCombo = "Detalles Combos";

                /*request.setAttribute("datos", det.obtenerCobosIndex(accion));
                
                request.setAttribute("categoria_combos", cb.obtenerCategoriasCombos());
                request.setAttribute("sedes_cat", sedes.getSedes());
                request.setAttribute("combos_cat", cb.obtenerCombosFull());
                
                
                request.setAttribute("agregarModal", "agregarDetallesCombos");
                request.setAttribute("modificarModal", "modificarModalDetallesCombos");
                request.setAttribute("informacion", "Agregar Detalle Combos");
                
                request.setAttribute("estados_contralador", "AdministrarDetallesCombos");
                request.setAttribute("titulo", nombreCombo);*/
                if (accion != null) {
                    int id = 0;
                    if (request.getParameter("id") != null) {

                        id = Integer.parseInt(request.getParameter("id"));
                    }

                    switch (accion) {
                        case "agregar":

                            int idcomb2 = Integer.parseInt(request.getParameter("combo2"));
                            int idSede2 = Integer.parseInt(request.getParameter("sede2"));
                            int idCategoria2 = Integer.parseInt(request.getParameter("categoria2"));

                            String agregar = det.insertarCombos(idcomb2, idCategoria2, idSede2);

                            return;

                        case "delete":
                            /*ELIMINAR CLIENTE*/
                            String eliminar = det.eliminarCombo(id);

                            return;

                        case "update":
                            /*UPDATE DETALLE*/

                            DetalleCategoriaCombos conseguir = det.obtenerCombos(id);

                            response.setContentType("application/json");
                            PrintWriter out = response.getWriter();

                            String json = new Gson().toJson(conseguir);
                            out.print(json);
                            out.flush();
                            return;

                        case "update2":

                            int idcomb = Integer.parseInt(request.getParameter("combo"));
                            int idSede = Integer.parseInt(request.getParameter("sedex"));
                            int idCategoria = Integer.parseInt(request.getParameter("categoriax"));

                            String update = det.updateCombos(id, idcomb, idCategoria, idSede);

                            return;

                        case "mostrar":
                            mostrar(request, response, nombreCombo);
                            return;

                        default:
                            throw new AssertionError();
                    }

                }

                request.getRequestDispatcher("/VistaAdministrador/AdmCombo.jsp").forward(request, response);
                break;

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

        if (nombre.equals("Combos")) {
            ArrayList<Combos> conseguir = cb.obtenerCombosFull();

            response.setContentType("application/json");
            PrintWriter out = response.getWriter();

            String json = new Gson().toJson(conseguir);
            out.print(json);
            out.flush();
        } else {
            ArrayList<Combos> conseguir = det.obtenerCobosIndex("");

            response.setContentType("application/json");
            PrintWriter out = response.getWriter();

            String json = new Gson().toJson(conseguir);
            out.print(json);
            out.flush();
        }

    }

}
