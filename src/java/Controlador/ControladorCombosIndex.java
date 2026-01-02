/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import DAO.BebidasDao;
import DAO.CombosDao;
import DAO.DulceriaDao;
import Modelo.Bebidas;
import Modelo.Combos;
import Modelo.Dulceria;
import Modelo.PeliIndex;
import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author JEFFERSON
 */
public class ControladorCombosIndex extends HttpServlet {

    private CombosDao cb = new CombosDao();
    private DulceriaDao dul = new DulceriaDao();
    private BebidasDao beb = new BebidasDao();

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

        /* TODO output your page here. You may use following sample code. */
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");

        switch (accion) {
            case "Tendencia":
                ArrayList<Combos> combz = cb.obtenerCobosIndex(accion);

                response.setContentType("application/json;charset=UTF-8");
                String prinz = new Gson().toJson(combz);
                response.getWriter().println(prinz);
                /*
                request.setAttribute("cb", cb.obtenerCobosIndex(accion));
                request.getRequestDispatcher("/Vista/Comelona.jsp").forward(request, response);*/
                break;

            case "Pedido":
                ArrayList<Combos> combw = cb.obtenerCobosIndex(accion);

                response.setContentType("application/json;charset=UTF-8");
                String print = new Gson().toJson(combw);
                response.getWriter().println(print);
                /*
                request.setAttribute("cb", cb.obtenerCobosIndex(accion));
                request.getRequestDispatcher("/Vista/Comelona.jsp").forward(request, response);*/
                break;
            case "Combos":

                if (request.getParameter("cargar") != null) {

                    String objeto = request.getParameter("objeto");
                    HttpSession session = request.getSession(false);
                    String tipoc = (String) session.getAttribute("sedeCombo");

                    switch (objeto) {
                        case "comboss":

                            ArrayList<Combos> comb = cb.obtenerCobosIndex(tipoc);

                            response.setContentType("application/json;charset=UTF-8");
                            String prin = new Gson().toJson(comb);
                            response.getWriter().println(prin);
                            return;

                        case "dulceria":

                            ArrayList<Dulceria> dulceria = dul.obtenerDulceria(tipoc);

                            response.setContentType("application/json;charset=UTF-8");
                            String prin2 = new Gson().toJson(dulceria);
                            response.getWriter().println(prin2);
                            return;

                        case "bebida":

                            ArrayList<Bebidas> bebida = beb.obtenerBebidas(tipoc);

                            response.setContentType("application/json;charset=UTF-8");
                            String prin3 = new Gson().toJson(bebida);
                            response.getWriter().println(prin3);
                            return;
                        default:
                            throw new AssertionError();
                    }

                    /*request.setAttribute("comboss", cb.obtenerCobosIndex(tipoc));
                    
                    
                    request.setAttribute("categoria", cb.obtenerCategoriasCombos());
                    
                    request.setAttribute("dulceria", dul.obtenerDulceria(tipoc));
                    request.setAttribute("bebidas", beb.obtenerBebidas(tipoc));
                    
                    
                    request.getRequestDispatcher("/Vista/Combos.jsp").forward(request, response);*/
                } else {
                    request.setAttribute("pepp", cb.obtenerCombosFull());
                    request.getRequestDispatcher("/Vista/Combos.jsp").forward(request, response);
                }
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

}
