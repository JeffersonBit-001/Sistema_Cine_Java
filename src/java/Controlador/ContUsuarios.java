/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import DAO.UsuariosDao;
import Modelo.Login;
import Modelo.Tipo;
import Modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;

/**
 *
 * @author JEFFERSON
 */
public class ContUsuarios extends HttpServlet {

    UsuariosDao cli = new UsuariosDao();

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
        /*MENSAJES*/
        int dni = 0;
        int cel = 0;
        int estado = 0;
        String nombre = "";
        String apellido = "";

        String genero = "";
        String fecha = "";

        String domicilio = "";
        String correo = "";
        String correoc = "";
        String pass = "";
        String passc = "";
        String nombreUsuario = "";

        /*String mensaje = (String) request.getSession().getAttribute("mensaje");
        String result = (String) request.getSession().getAttribute("result");

        if (mensaje != null) {
            request.setAttribute("mensaje", mensaje);
            request.setAttribute("result", result);
            /*Limpiar SESIONES
            request.getSession().removeAttribute("mensaje");
            request.getSession().removeAttribute("result");
        }*/
 /*-----------------------------------------------Estados del Usuario*/
        String estad = request.getParameter("estad");

        if (estad != null) {

            if (estad.equals("listo")) {
                ArrayList<Tipo> tipo = cli.obtenerEstados();

                response.setContentType("application/json;charset=UTF-8");
                String conseguirEstado = new Gson().toJson(tipo);
                response.getWriter().println(conseguirEstado);
                return;
            }

        }

        /*------------------------------------------------------------------------*/
 /*-----------------------------USUARIOS Y CLIENTES-------------------------------------------*/
        String tipoc = request.getParameter("tipoc");
        String accion = request.getParameter("accion");
        if (tipoc != null) {

            switch (tipoc) {
                case "AdministradorClientes":

                    nombreUsuario = "Clientes";

                    if (accion != null) {
                        int id = 0;
                        if (request.getParameter("id") != null) {

                            id = Integer.parseInt(request.getParameter("id"));
                        }

                        switch (accion) {
                            case "agregar":

                                nombre = request.getParameter("nombres2");
                                apellido = request.getParameter("apellidos2");

                                genero = request.getParameter("genero2");
                                fecha = request.getParameter("fecha2");

                                domicilio = request.getParameter("domicilio2");
                                correo = request.getParameter("correo2");
                                correoc = request.getParameter("correo_confirm2");
                                pass = request.getParameter("pass2");
                                passc = request.getParameter("pass_confirm2");

                                try {
                                    dni = Integer.parseInt(request.getParameter("dni2"));
                                    cel = Integer.parseInt(request.getParameter("cel2"));
                                    estado = Integer.parseInt(request.getParameter("estado2"));
                                } catch (NumberFormatException e) {

                                } catch (Exception e) {

                                }

                                String agregar = cli.insertarCliente(nombreUsuario, nombre, apellido,
                                        dni, genero, fecha,
                                        cel, domicilio, correo, correoc, pass, passc, estado);

                                return;

                            case "delete":
                                /*ELIMINAR CLIENTE*/
                                String eliminar = cli.eliminarCliente(id, nombreUsuario);

                                return;

                            case "update":
                                /*UPDATE CLIENTE*/

                                Usuario conseguir = cli.obtenerCliente(nombreUsuario, id);

                                response.setContentType("application/json;charset=UTF-8");
                                String conseguirUsuarios = new Gson().toJson(conseguir);
                                response.getWriter().println(conseguirUsuarios);
                                return;

                            case "update2":
                                nombre = request.getParameter("nombres");
                                apellido = request.getParameter("apellidos");

                                genero = request.getParameter("genero");
                                fecha = request.getParameter("fecha");

                                domicilio = request.getParameter("domicilio");
                                correo = request.getParameter("correo");
                                correoc = request.getParameter("correo_confirm");
                                pass = request.getParameter("pass");
                                passc = request.getParameter("pass_confirm");

                                try {
                                    dni = Integer.parseInt(request.getParameter("dni"));
                                    cel = Integer.parseInt(request.getParameter("cel"));
                                    estado = Integer.parseInt(request.getParameter("estado"));
                                } catch (NumberFormatException e) {

                                } catch (Exception e) {

                                }

                                String update = cli.actualizarCliente(id, nombreUsuario, nombre, apellido,
                                        dni, genero, fecha,
                                        cel, domicilio, correo, correoc, pass, passc, estado);

                                HttpSession session = request.getSession(false);

                                if (session == null) {
                                    session = request.getSession(true);

                                    System.out.println("Se ha creado una nueva sesión.");
                                }

                                Login log = (Login) session.getAttribute("usuario");

                                if (log != null) {
                                    log.setNombre(nombre);
                                    log.setNombres(nombre);
                                    log.setApellido(apellido);
                                    log.setApellidos(apellido);
                                    log.setCel(String.valueOf(cel));
                                    log.setTelefono(cel);
                                    log.setGenero(genero);
                                    log.setNacimiento(fecha);
                                    log.setDomicilio(domicilio);
                                    log.setCorreo(correo);
                                    log.setCorreoc(correo);
                                    log.setPass(pass);
                                    log.setPassc(pass);
                                    log.setEstado(estado);

                                    session.setAttribute("usuario", log);
                                }

                                return;

                            case "mostrar":
                                mostrar(request, response, nombreUsuario);
                                return;

                            default:
                                throw new AssertionError();
                        }

                    }

                    break;

                case "AdministradorUsuarios":

                    nombreUsuario = "Usuarios";

                    if (accion != null) {
                        int id = 0;
                        if (request.getParameter("id") != null) {

                            id = Integer.parseInt(request.getParameter("id"));
                        }

                        switch (accion) {
                            case "agregar":

                                nombre = request.getParameter("nombres2");
                                apellido = request.getParameter("apellidos2");

                                genero = request.getParameter("genero2");
                                fecha = request.getParameter("fecha2");

                                domicilio = request.getParameter("domicilio2");
                                correo = request.getParameter("correo2");
                                correoc = request.getParameter("correo_confirm2");
                                pass = request.getParameter("pass2");
                                passc = request.getParameter("pass_confirm2");

                                try {
                                    dni = Integer.parseInt(request.getParameter("dni2"));
                                    cel = Integer.parseInt(request.getParameter("cel2"));
                                    estado = Integer.parseInt(request.getParameter("estado2"));
                                } catch (NumberFormatException e) {

                                } catch (Exception e) {

                                }

                                String agregar = cli.insertarCliente("usuarios", nombre, apellido,
                                        dni, genero, fecha,
                                        cel, domicilio, correo, correoc, pass, passc, estado);

                                return;

                            case "delete":
                                /*ELIMINAR USUARIO*/
                                String eliminar = cli.eliminarCliente(id, nombreUsuario);

                                if (!eliminar.equals("")) {
                                    request.setAttribute("mensaje", "No se eliminó el cliente");
                                    request.setAttribute("result", "error");
                                } else {
                                    request.getSession().setAttribute("mensaje", "Usuario Eliminado");
                                    request.getSession().setAttribute("result", "ok");
                                    response.sendRedirect("ContUsuarios?tipoc=AdministradorUsuarios");
                                    return;
                                }
                                break;

                            case "update":
                                /*UPDATE USUARIO*/

                                Usuario conseguir = cli.obtenerCliente(nombreUsuario, id);
                                response.setContentType("application/json;charset=UTF-8");
                                String conseguirUsuarios = new Gson().toJson(conseguir);
                                response.getWriter().println(conseguirUsuarios);
                                return;

                            case "update2":
                                nombre = request.getParameter("nombres");
                                apellido = request.getParameter("apellidos");

                                genero = request.getParameter("genero");
                                fecha = request.getParameter("fecha");

                                domicilio = request.getParameter("domicilio");
                                correo = request.getParameter("correo");
                                correoc = request.getParameter("correo_confirm");
                                pass = request.getParameter("pass");
                                passc = request.getParameter("pass_confirm");

                                try {
                                    dni = Integer.parseInt(request.getParameter("dni"));
                                    cel = Integer.parseInt(request.getParameter("cel"));
                                    estado = Integer.parseInt(request.getParameter("estado"));
                                } catch (NumberFormatException e) {

                                } catch (Exception e) {

                                }

                                String update = cli.actualizarCliente(id, nombreUsuario, nombre, apellido,
                                        dni, genero, fecha,
                                        cel, domicilio, correo, correoc, pass, passc, estado);

                                HttpSession session = request.getSession(false);

                                if (session == null) {
                                    session = request.getSession(true);

                                    System.out.println("Se ha creado una nueva sesión.");
                                }

                                Login log = (Login) session.getAttribute("usuario");
                                if (log != null) {
                                    log.setNombre(nombre);
                                    log.setNombres(nombre);
                                    log.setApellido(apellido);
                                    log.setApellidos(apellido);
                                    log.setCel(String.valueOf(cel));
                                    log.setTelefono(cel);
                                    log.setGenero(genero);
                                    log.setNacimiento(fecha);
                                    log.setDomicilio(domicilio);
                                    log.setCorreo(correo);
                                    log.setCorreoc(correo);
                                    log.setPass(pass);
                                    log.setPassc(pass);
                                    log.setEstado(estado);
                                    session.setAttribute("usuario", log);
                                }

                                return;

                            case "mostrar":
                                mostrar(request, response, nombreUsuario);
                                return;

                            default:
                                throw new AssertionError();
                        }

                    }

                    break;

                default:
                    throw new AssertionError();
            }

        }
        request.getRequestDispatcher("/VistaAdministrador/AdmUsuarios.jsp").forward(request, response);

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

        ArrayList<Usuario> conseguir = cli.obtenerClientes(nombre);

        response.setContentType("application/json");//RESSPUESTA EN FORMATO JSON
        PrintWriter out = response.getWriter();

        String json = new Gson().toJson(conseguir);//CONVERTIR EN FORMATO JSON
        out.print(json);//SE ENVIA LA CADENA
        out.flush();//ENVIO RAPIDO
    }

}
