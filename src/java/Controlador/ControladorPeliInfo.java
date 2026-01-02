/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import DAO.DetalleReservaDao;
import DAO.PeliIndexDao;
import DAO.SedesDao;
import Modelo.CarritoCombos;
import Modelo.DetalleReserva;
import Modelo.PeliIndex;
import Modelo.Sedes;
import com.google.gson.Gson;
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
public class ControladorPeliInfo extends HttpServlet {

    private PeliIndexDao pel = new PeliIndexDao();
    private SedesDao sd = new SedesDao();
    private DetalleReservaDao detalledao = new DetalleReservaDao();

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

        String val = request.getParameter("valx");
        String valg = request.getParameter("valxGuardar");
        String asientos = request.getParameter("asientosPelicula");

        String reserva = request.getParameter("seleccionPeli");

        if (val != null) {
            PeliIndex listapel = pel.obtenerPeliculasInfo(val);
            response.setContentType("application/json;charset=UTF-8");
            String listaPeliculas = new Gson().toJson(listapel);
            response.getWriter().println(listaPeliculas);
        }

        if (valg != null) {
            HttpSession session = request.getSession(true);

            session.setAttribute("valxGuardar", valg);

            PeliIndex listapel = pel.obtenerPeliculasInfo(valg);
            response.setContentType("application/json;charset=UTF-8");
            String listaPeliculas = new Gson().toJson(listapel);
            response.getWriter().println(listaPeliculas);

        }

        if (asientos != null) {
            HttpSession session = request.getSession(false);
            String peliculaGuardada = (String) session.getAttribute("valxGuardar");

            ArrayList<Sedes> sed = sd.getSedesSeleccion(peliculaGuardada, asientos);
            response.setContentType("application/json;charset=UTF-8");
            String listaSedes = new Gson().toJson(sed);
            response.getWriter().println(listaSedes);
        }

        if (reserva != null) {
            response.setContentType("application/json;charset=UTF-8");
            String nombre = request.getParameter("nombreSeleccion");
            String hora = request.getParameter("idhoraSeleccion");
            String sede = request.getParameter("sedeSeleccion");

            HttpSession session = request.getSession(false); 

            if (session == null) {
                session = request.getSession(true); 

                System.out.println("Se ha creado una nueva sesión.");
            }

            DetalleReserva detalle = (DetalleReserva) session.getAttribute("detalleReserva");

            if (detalle != null) {
                
                ArrayList<CarritoCombos> guardar =  detalle.getArrayCarritoCombos();
                detalle = detalledao.getSeleccion(nombre, sede, Integer.parseInt(hora));
                detalle.setArrayCarritoCombos(guardar);
                
            } else {
                detalle = detalledao.getSeleccion(nombre, sede, Integer.parseInt(hora));
            }

            session.setAttribute("detalleReserva", detalle);

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
