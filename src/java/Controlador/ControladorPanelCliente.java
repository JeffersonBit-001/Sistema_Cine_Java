/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import DAO.HistorialClienteDAO;
import Modelo.DetalleReserva;
import Modelo.HistorialCliente;
import Modelo.Login;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author JEFFERSON
 */
public class ControladorPanelCliente extends HttpServlet {
    HistorialClienteDAO historial = new HistorialClienteDAO();

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

        String info = request.getParameter("valx");
        String actualizarSesion = request.getParameter("actualizarSesion");

        if (info != null) {
            HttpSession session = request.getSession(false);
            Login log = (Login) session.getAttribute("usuario");
            response.setContentType("application/json;charset=UTF-8");
            String listaDetalle = new Gson().toJson(log);
            response.getWriter().println(listaDetalle);
        }

        if (actualizarSesion != null) {
            HttpSession session = request.getSession(false);
            String rol = "";

            if (session == null) {
                session = request.getSession(true);

                System.out.println("Se ha creado una nueva sesión.");
            } else {
                rol = (String) session.getAttribute("rol");
            }

            if (rol.equals("Cliente")) {
                StringBuilder sb = new StringBuilder();
                String line;
                BufferedReader reader = request.getReader();
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }

                String json = sb.toString();

                Gson gson = new Gson();

                Login user = gson.fromJson(json, Login.class);

                user.setTelefono(Integer.parseInt(user.getCel()));
                System.out.println("Recibido el usuario: " + user);

                session.setAttribute("usuario", user);

                response.setContentType("application/json;charset=UTF-8");

                String jsonResponse = gson.toJson(user);
                response.getWriter().println(jsonResponse);
            }

        }

        /*CERRAR SESION*/
        String cerrarSesion = request.getParameter("cerrarSesion");

        if (cerrarSesion != null) {

            HttpSession session = request.getSession(false);

            if (session != null) {
                session.invalidate();
            }

            response.setContentType("application/json;charset=UTF-8");
            String cerrar = new Gson().toJson("Cerran Sesion");
            response.getWriter().println(cerrar);

        }
        
        
        /*HISTORIAL */
        String mostrarHistorial = request.getParameter("mostrarHistorial");
        
        if (mostrarHistorial != null) {
            HttpSession session = request.getSession(false);
            Login log = (Login) session.getAttribute("usuario");
            
            ArrayList<HistorialCliente> histo = historial.obtenerHistorial(log.getId());
            
            
            response.setContentType("application/json;charset=UTF-8");
            String listaDetalle = new Gson().toJson(histo);
            response.getWriter().println(listaDetalle);
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

}
