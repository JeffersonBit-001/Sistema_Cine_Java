/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import DAO.SugerenciaDao;
import Modelo.Sugerencias;
import Modelo.Usuario;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JEFFERSON
 */
public class ControladorSugerencias extends HttpServlet {

    SugerenciaDao sugerencias = new SugerenciaDao();

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

        /*String mensaje = (String) request.getSession().getAttribute("mensaje");
        String result = (String) request.getSession().getAttribute("result");

        if (mensaje != null) {
            request.setAttribute("mensaje", mensaje);
            request.setAttribute("result", result);
            /*Limpiar SESIONES
            request.getSession().removeAttribute("mensaje");
            request.getSession().removeAttribute("result");
        }*/
        String accion = request.getParameter("accion");

        if (accion != null) {

            switch (accion) {
                case "LibroReclamaciones":

                    break;

                case "EnviarSugerencia":
                    JsonObject jsonResponse = new JsonObject();
                    String nombre = request.getParameter("name");
                    String correo = request.getParameter("email");
                    String sugges = request.getParameter("suggestion");
                    /*Busca al cliente de acuerdo a la información brindada*/
                    Usuario usu = sugerencias.buscarCliente(nombre, correo);

                    if (usu.getId() == 0) {
                        jsonResponse.addProperty("status", "error");
                        jsonResponse.addProperty("message", "No se pudo agregar tu reclamación. Inténtalo nuevamente.");
                        response.getWriter().write(jsonResponse.toString());
                    } else {


                        /*Insertar Sugerencia*/
                        String inser = sugerencias.InsertarSugerencia(usu.getId(), "Pendiente", usu);
                        if (!inser.equals("")) {
                            jsonResponse.addProperty("status", "error");
                            jsonResponse.addProperty("message", "No se pudo agregar tu reclamación. Inténtalo nuevamente.");
                            response.getWriter().write(jsonResponse.toString());
                        } else {

                            /*Recuperar sugerencia*/
                            usu.setId(sugerencias.RecuperarSugerenciaClientes(correo, usu.getFecha(), usu.getHora()));

                            if (usu.getId() == 0) {
                                jsonResponse.addProperty("status", "error");
                                jsonResponse.addProperty("message", "No se pudo agregar tu reclamación. Inténtalo nuevamente.");
                                response.getWriter().write(jsonResponse.toString());
                            } else {

                                /*Insertar los detalles*/
                                String detalles = sugerencias.InsertarSugerenciaDetalle(usu.getId(), sugges);

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
        //request.getRequestDispatcher("/Vista/FormSugerencia.jsp").forward(request, response);

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
