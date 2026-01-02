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
public class ControladorCat extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession(false);
        String tipoc = (String) session.getAttribute("sedeCombo");

        if (request.getParameter("subcategoria") != null) {
            switch (request.getParameter("subcategoria")) {
                case "combo_cat":
                    ArrayList<Combos> comb = cb.obtenerCategoriasCombos();

                    response.setContentType("application/json;charset=UTF-8");
                    String prin = new Gson().toJson(comb);
                    response.getWriter().println(prin);
                    //request.setAttribute("comboss", cb.obtenerCobosIndex(tipoc));
                    //request.setAttribute("categoria", cb.obtenerCategoriasCombos());
                    //request.getRequestDispatcher("/Vista/Categorias_busqueda_combos.jsp").forward(request, response);
                    return;
                case "dulceria_cat":

                    ArrayList<Dulceria> dulceria = dul.obtenerCategoriasDulceria();

                    response.setContentType("application/json;charset=UTF-8");
                    String prin2 = new Gson().toJson(dulceria);
                    response.getWriter().println(prin2);

                    //request.setAttribute("comboss", dul.obtenerDulceria(tipoc));
                    //request.setAttribute("categoria", dul.obtenerCategoriasDulceria());
                    //request.getRequestDispatcher("/Vista/Categorias_busqueda_combos.jsp").forward(request, response);
                    return;
                case "bebida_cat":
                    ArrayList<Bebidas> bebida = beb.obtenerCategoriasBebidas();

                    response.setContentType("application/json;charset=UTF-8");
                    String prin3 = new Gson().toJson(bebida);
                    response.getWriter().println(prin3);
                    //request.setAttribute("comboss", beb.obtenerBebidas(tipoc));
                    //request.setAttribute("categoria", beb.obtenerCategoriasBebidas());
                    //request.getRequestDispatcher("/Vista/Categorias_busqueda_combos.jsp").forward(request, response);
                    return;
                default:
                    break;
            }
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
