/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import DAO.LibroReclamacionesDao;
import Modelo.LibroReclamaciones;
import Modelo.Tipo;
import Modelo.Usuario;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.File;
import java.io.IOException;
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
public class ControladorLibroReclamaciones extends HttpServlet {

    LibroReclamacionesDao libr = new LibroReclamacionesDao();
    LibroReclamaciones libro = new LibroReclamaciones();

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
        /*TRAE LAS SESIONES*/
        String mensaje = (String) request.getSession().getAttribute("mensaje");
        String result = (String) request.getSession().getAttribute("result");

        if (mensaje != null) {
            request.setAttribute("mensaje", mensaje);
            request.setAttribute("result", result);
            /*Limpiar SESIONES*/
            request.getSession().removeAttribute("mensaje");
            request.getSession().removeAttribute("result");
        }

        /*-----------------------------------------------Sala de la película*/
        String estadcomb = request.getParameter("estadoSele");

        if (estadcomb != null) {

            if (estadcomb.equals("tipo_bien_mostrar")) {
                ArrayList<LibroReclamaciones> tipo = libr.obtenerTipoBien();

                response.setContentType("application/json;charset=UTF-8");
                String conseguir = new Gson().toJson(tipo);
                response.getWriter().println(conseguir);
                return;
            }

            if (estadcomb.equals("tipo_reclamacion_mostrar")) {
                ArrayList<LibroReclamaciones> tipo = libr.obtenerTipoReclamacion();

                response.setContentType("application/json;charset=UTF-8");
                String conseguir = new Gson().toJson(tipo);
                response.getWriter().println(conseguir);
                return;
            }

            if (estadcomb.equals("tipo_check_mostrar")) {
                ArrayList<LibroReclamaciones> tipo = libr.obtenerTipoCondicion();

                response.setContentType("application/json;charset=UTF-8");
                String conseguir = new Gson().toJson(tipo);
                response.getWriter().println(conseguir);
                return;
            }

        }

        /*------------------------------------------------------------------------*/

 /*request.setAttribute("tipo_bien", libr.obtenerTipoBien());
        request.setAttribute("tipo_reclamacion", libr.obtenerTipoReclamacion());
        request.setAttribute("tipo_condicion", libr.obtenerTipoCondicion());*/
        String accion = request.getParameter("accion");
        String nombreFile = "";

        if (accion != null) {
            try {
                Part filePart = request.getPart("archivo");

                nombreFile = filePart.getSubmittedFileName();
                if (nombreFile == null || nombreFile.isEmpty()) {
                    throw new ServletException("No se ha subido ningún archivo.");
                }

                String uploadPath = getServletContext().getRealPath("/Reclamos");
                File uploadDir = new File(uploadPath);
                if (!uploadDir.exists()) {
                    uploadDir.mkdirs();
                }

                File file = new File(uploadDir, nombreFile);
                filePart.write(file.getAbsolutePath());

            } catch (Exception e) {

            }
            switch (accion) {
                case "LibroReclamaciones":

                    break;

                case "EnviarReclamacion":
                    JsonObject jsonResponse = new JsonObject();
                    int dni = 0;
                    int telefono = 0;
                    float monto = 0;

                    String nombre = request.getParameter("nombre");
                    String apellido = request.getParameter("apellido");
                    String domicilio = request.getParameter("domicilio");
                    String correo = request.getParameter("correo");
                    String tipo_bien1 = request.getParameter("tipo_bien");
                    String otro_tipo = request.getParameter("otro_tipo");
                    String descripcion = request.getParameter("descripcion");
                    String tipo_reclamacion1 = request.getParameter("tipo_reclamacion");
                    String otros_tipo = request.getParameter("otros_tipo");
                    String detalle = request.getParameter("detalle");
                    String pedido = request.getParameter("pedido");

                    String terminos1 = request.getParameter("terminos1");
                    String terminos2 = request.getParameter("terminos2");
                    String terminos3 = request.getParameter("terminos3");

                    try {
                        dni = Integer.parseInt(request.getParameter("dni"));
                        telefono = Integer.parseInt(request.getParameter("telefono"));
                        monto = Float.parseFloat(request.getParameter("monto"));

                    } catch (NumberFormatException e) {

                    } catch (Exception e) {

                    }

                    /*Busca al cliente de acuerod a la información brindada*/
                    Usuario usu = libr.buscarCliente(nombre, apellido, dni);

                    if (usu.getId() == 0) {
                        /*String mensajeEscapado = "Datos incorrectos o inválidos";
                        request.setAttribute("nombre", nombre);
                        request.setAttribute("apellido", apellido);
                        request.setAttribute("domicilio", domicilio);
                        request.setAttribute("dni", "");
                        request.setAttribute("telefono", "");
                        request.setAttribute("correo", correo);
                        request.setAttribute("tipo_bien1", tipo_bien1);
                        request.setAttribute("otro_tipo", otro_tipo);
                        request.setAttribute("monto", "");
                        request.setAttribute("descripcion", descripcion);
                        request.setAttribute("tipo_reclamacion1", tipo_reclamacion1);
                        request.setAttribute("otros_tipo", otros_tipo);
                        request.setAttribute("detalle", detalle);
                        request.setAttribute("pedido", pedido);

                        request.setAttribute("11", terminos1);
                        request.setAttribute("12", terminos2);
                        request.setAttribute("13", "" + terminos3);

                        request.setAttribute("mensaje", mensajeEscapado);
                        request.setAttribute("result", "error");*/
                        response.setContentType("application/json;charset=UTF-8");
                        String listaDetalle = new Gson().toJson(usu);
                        response.getWriter().println(listaDetalle);
                    } else {

                        int condicion = 0;
                        if (terminos3 != null) {
                            condicion = Integer.parseInt(terminos1);
                        } else if (terminos2 != null) {
                            condicion = Integer.parseInt(terminos2);
                        } else if (terminos1 != null) {
                            condicion = Integer.parseInt(terminos3);
                        } else {
                            condicion = 1;
                        }

                        /*Insertar Reclamación*/
                        String inser = libr.InsertarReclamacion(dni, usu.getId(), Integer.parseInt(tipo_bien1),
                                Integer.parseInt(tipo_reclamacion1), condicion, "Pendiente", usu);
                        if (!inser.equals("")) {
                            jsonResponse.addProperty("status", "error");
                            jsonResponse.addProperty("message", "No se pudo agregar tu reclamación. Inténtalo nuevamente.");
                            response.getWriter().write(jsonResponse.toString());
                        } else {

                            /*Recuperar reclamacion*/
                            libro.setId(libr.RecuperarReclamacionClientes(usu.getDni(), usu.getFecha(), usu.getHora()));

                            if (libro.getId() == 0) {
                                jsonResponse.addProperty("status", "error");
                                jsonResponse.addProperty("message", "No se pudo agregar tu reclamación. Inténtalo nuevamente.");
                                response.getWriter().write(jsonResponse.toString());
                            } else {

                                /*Insertar los detalles*/
                                String detalles = libr.InsertarReclamacionDetalle(libro.getId(),
                                        monto, otro_tipo, descripcion,
                                        otros_tipo, detalle, pedido,
                                        String.valueOf(nombreFile), telefono, domicilio, correo, usu
                                );

                                if (!detalles.equals("")) {
                                    jsonResponse.addProperty("status", "error");
                                    jsonResponse.addProperty("message", "No se pudo agregar tu reclamación. Inténtalo nuevamente.");
                                    response.getWriter().write(jsonResponse.toString());
                                } else {

                                    jsonResponse.addProperty("status", "success");
                                    jsonResponse.addProperty("message", "Reclamación agregado correctamente");
                                    response.getWriter().write(jsonResponse.toString());
                                }

                            }
                        }

                    }

                    break;

                default:
                    throw new AssertionError();
            }
        }

        //request.getRequestDispatcher("/Vista/LibroReclamaciones.jsp").forward(request, response);
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

}
