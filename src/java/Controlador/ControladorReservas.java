/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import DAO.DetalleReservaDao;
import DAO.FacturaDao;
import Modelo.Asientos;
import Modelo.CarritoCombos;
import Modelo.DetalleReserva;
import Modelo.Login;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author JEFFERSON
 */
public class ControladorReservas extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");

        String mostrarInfoReserva = request.getParameter("mostrarInfoReserva");
        String mostrarAsientos = request.getParameter("mostrarAsientos");

        /*verificar Combos*/
        String verificarCombos = request.getParameter("verificarCombos");

        /*selección de los asientos*/
        String seleccionarAsientos = request.getParameter("seleccionarAsientos");

        /*verifcar sede Combos*/
        String verificarSede = request.getParameter("verificarSede");

        /*Mantener sesion de sede Combos*/
        String verificarSedeLlenar = request.getParameter("verificarSedeLlenar");

        if (mostrarInfoReserva != null) {
            HttpSession session = request.getSession(false);
            DetalleReserva detalle = (DetalleReserva) session.getAttribute("detalleReserva");
            response.setContentType("application/json;charset=UTF-8");
            String listaDetalle = new Gson().toJson(detalle);
            response.getWriter().println(listaDetalle);
        }

        if (mostrarAsientos != null) {
            HttpSession session = request.getSession(false);
            DetalleReserva detalle = (DetalleReserva) session.getAttribute("detalleReserva");
            ArrayList<Asientos> asientos = detalledao.getAsientos(detalle.getPeli().getId(),
                    detalle.getSede().getId(), detalle.getHora().getId());

            response.setContentType("application/json;charset=UTF-8");
            String listaDetalle = new Gson().toJson(asientos);
            response.getWriter().println(listaDetalle);
        }

        /*GUARDAR ASIENTOS*/
        if (seleccionarAsientos != null) {
            HttpSession session = request.getSession(false);
            DetalleReserva detalle = (DetalleReserva) session.getAttribute("detalleReserva");
            /* CANTIDAD Y PRECIOS */
            String cantidadAsientos = request.getParameter("contador_asientos");
            String precioTotalAsientos = request.getParameter("precio_total_input");

            String[] checkAsientos = request.getParameterValues("check_asiento[]");

            ArrayList<Asientos> asientos = new ArrayList<>();

            if (checkAsientos != null) {
                for (String valor : checkAsientos) {
                    Asientos as = new Asientos();
                    String[] partes = valor.split("-");
                    if (partes.length == 2) {
                        String nombreAsiento = partes[0];
                        String idDet = partes[1];
                        as.setIdDet(Integer.parseInt(idDet));
                        as.setNombre(nombreAsiento);

                    }
                    asientos.add(as);
                }
            }

            detalle.setArrayAsientos(asientos);
            detalle.setCantidadEntradas(Integer.parseInt(cantidadAsientos));
            detalle.setTotalAsientosPrecio(Float.parseFloat(precioTotalAsientos));

            session.setAttribute("detalleReserva", detalle);

            response.setContentType("application/json;charset=UTF-8");
            String listaDetalle = new Gson().toJson(detalle);
            response.getWriter().println(listaDetalle);
        }

        /*VERIFICAR COMBOS*/
        if (verificarCombos != null) {

            HttpSession session = request.getSession(false);
            DetalleReserva detalle = (DetalleReserva) session.getAttribute("detalleReserva");

            if (detalle.getArrayCarritoCombos() != null) {

                Gson gson = new Gson();
                String responseJson = gson.toJson(detalle.getArrayCarritoCombos());

                response.setContentType("application/json;charset=UTF-8");
                response.getWriter().write(responseJson);
            } else {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().write("{\"message\": \"No hay detalles en la sesión\"}");
            }

        }

        /*VERIFICAR SESION COMBO RESERVAS*/
        if (verificarSede != null) {
            response.setContentType("application/json;charset=UTF-8");
            String tipocc = request.getParameter("tipocc");

            HttpSession session = request.getSession(false);

            if (session == null) {
                session = request.getSession(true);

                System.out.println("Se ha creado una nueva sesión.");
            }

            session.setAttribute("sedeCombo", tipocc);

            response.getWriter().println("llego" + tipocc);

        }

        /*VERIFICAR SESION Y MANTENERLA SIN NECESIDAD DE CARGAR DE NUEVO*/
        if (verificarSedeLlenar != null) {
            response.setContentType("application/json;charset=UTF-8");

            HttpSession session = request.getSession(false);

            if (session == null || session.getAttribute("sedeCombo") == null) {
                response.getWriter().println("{}");
            } else {
                String sedeCombo = (String) session.getAttribute("sedeCombo");
                response.getWriter().println("{\"sedeCombo\": \"" + sedeCombo + "\"}");
            }
        }

        /*CERRAR SEDE DE COMBO*/
        String cerrarSede = request.getParameter("cerrarSede");

        if (cerrarSede != null) {
            response.setContentType("application/json;charset=UTF-8");

            HttpSession session = request.getSession(false);
            String sedeCombo = (String) session.getAttribute("sedeCombo");
            if(!sedeCombo.equals("")){
                session.removeAttribute("sedeCombo");
            }
            
            DetalleReserva detalle = (DetalleReserva) session.getAttribute("detalleReserva");

            if (detalle != null) {
                detalle.getArrayCarritoCombos().clear();
                session.setAttribute("detalleReserva", detalle);
            }

        }
        
        /*CERRAR PELICULA*/
        String cerrarReserva = request.getParameter("cerrarReserva");

        if (cerrarReserva != null) {
            response.setContentType("application/json;charset=UTF-8");

            HttpSession session = request.getSession(false);
            String sedeCombo = (String) session.getAttribute("sedeCombo");
            if(sedeCombo != null){
                session.removeAttribute("sedeCombo");
            }
            
            DetalleReserva detalle = (DetalleReserva) session.getAttribute("detalleReserva");

            if (detalle != null) {
                session.removeAttribute("detalleReserva");
            }

        }

        /*CARGAR Combos*/
        String cargarCombosSeleccionados = request.getParameter("cargarCombosSeleccionados");

        if (cargarCombosSeleccionados != null) {
            HttpSession session = request.getSession(false);
            DetalleReserva detalle = (DetalleReserva) session.getAttribute("detalleReserva");

            response.setContentType("application/json;charset=UTF-8");

            if (detalle.getArrayCarritoCombos() != null) {
                detalle.calcularPrecioCarritoCompras();
                session.setAttribute("detalleReserva", detalle);

            }

            String listaCombos = new Gson().toJson(detalle);
            response.getWriter().println(listaCombos);

        }

        /*RESERVAR*/
        String realizarPago = request.getParameter("realizarPago");

        if (realizarPago != null) {

            HttpSession session = request.getSession(false);
            DetalleReserva detalle = (DetalleReserva) session.getAttribute("detalleReserva");
            Login log = (Login) session.getAttribute("usuario");
            String rol = (String) session.getAttribute("rol");

            String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
            Random random = new Random();
            StringBuilder codigoAleatorio = new StringBuilder();

            for (int i = 0; i < 10; i++) {
                int index = random.nextInt(characters.length());
                codigoAleatorio.append(characters.charAt(index));
            }

            detalle.setCodigoPago(codigoAleatorio.toString());

            if (detalle.getPeli() != null) {

                detalle.calcularTotalNeto();

            } else {
                detalle.setPrecioTotal(detalle.getPrecioCarritoCompras());
            }

            /*GENERAR FACTURA*/
            FacturaDao reservas = new FacturaDao();

            if (log != null) {
                int id = 0;
                if (rol.equals("Administrador")) {
                    id = 1;
                } else if (rol.equals("Cliente")) {
                    id = log.getId();
                }

                reservas.insertarFactura(detalle, id);
                reservas.obtenerFactura(detalle);

                session.setAttribute("detalleReserva", detalle);

                /*ASIENTOS*/
                if (detalle.getArrayAsientos() != null) {
                    reservas.insertarFacturaDetalleAsiento(detalle);
                    reservas.actualizarAsiento(detalle);
                }

                /*CARRITO DE COMPRAS*/
                if (detalle.getArrayCarritoCombos() != null) {
                    reservas.insertarFacturaDetalleBebidas(detalle);
                    reservas.insertarFacturaDetalleCombos(detalle);
                    reservas.insertarFacturaDetalleDulceria(detalle);
                }

                /*
            PELICULAS*/
                if (detalle.getPeli() != null) {
                    reservas.insertarFacturaDetallePelicula(detalle);
                }

                response.setContentType("application/json;charset=UTF-8");
                String listaDetalle = new Gson().toJson(detalle);
                response.getWriter().println(listaDetalle);

                session.setAttribute("codigoValx", detalle.getCodigoPago());
                session.removeAttribute("sedeCombo");
                session.removeAttribute("detalleReserva");

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
