<%-- 
    Document   : PanelCliente
    Created on : 1 dic. 2024, 20:53:12
    Author     : JEFFERSON
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page session="true" %>
<%
    if (session != null && session.getAttribute("usuario") == null) {
        response.sendRedirect("Login.jsp");
    }
%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Perfil</title>
        <link rel="stylesheet" href="<%= request.getContextPath()%>/css/PanelCliente.css">
        <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous" />
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

    </head>

    <body>
        <%@include file="Cabecera.jsp" %>


        <section class="seccion-perfil-usuario">
            <div class="perfil-usuario-header">
                <div class="perfil-usuario-portada">
                    <div class="perfil-usuario-avatar">
                        <img src="<%= request.getContextPath()%>/img/img_usuario.png" alt="img-avatar">
                        <button type="button" class="boton-avatar">
                            <i class="far fa-image"></i>
                        </button>
                    </div>
                    <button type="button" class="boton-portada">
                        <i class="far fa-image"></i> Cambiar fondo
                    </button>
                </div>
            </div>
            <div class="perfil-usuario-body">
                <div class="perfil-usuario-bio">
                    <h3 id="title_nombre" class="titulo">X</h3>
                    <p class="texto">Persona dinámica en todo sitio, puedes contar conmigo en donde quieras.</p>
                    <div class="col-4">
                        <a href="<%= request.getContextPath()%>/Vista/AHistorialCliente.jsp" class="btn btn-primary">Ver mi Historial</a>

                    </div>
                </div>
                <div class="perfil-usuario-footer">

                    <form class="row g-3">

                        <input type="hidden" class="form-control" id="id">
                        <div class="col-md-6">
                            <label for="nombres" class="form-label">Nombres</label>
                            <input type="text" class="form-control" id="nombres">
                        </div>


                        <div class="col-md-6">
                            <label for="apellidos" class="form-label">Apellidos</label>
                            <input type="text" class="form-control" id="apellidos">
                        </div>


                        <div class="col-md-4">
                            <label for="dni" class="form-label">DNI</label>
                            <input type="text" class="form-control" id="dni">
                        </div>


                        <div class="col-md-3">
                            <label for="genero" class="form-label">Género</label>
                            <select id="genero" class="form-select">
                                <option selected>Selecciona...</option>
                                <option>Hombre</option>
                                <option>Mujer</option>
                            </select>
                        </div>


                        <div class="col-md-5">
                            <label for="nacimiento" class="form-label">Nacimiento</label>
                            <input type="date" class="form-control" id="nacimiento">
                        </div>


                        <div class="col-8">
                            <label for="domicilio" class="form-label">Domicilio</label>
                            <input type="text" class="form-control" id="domicilio" placeholder="1234 Main St">
                        </div>

                        <div class="col-4">
                            <label for="cel" class="form-label">Télefono</label>
                            <input type="text" class="form-control" id="cel" placeholder="">
                        </div>


                        <div class="col-md-6">
                            <label for="email" class="form-label">Email</label>
                            <input type="email" class="form-control" id="email">
                        </div>

                        <div class="col-md-6">
                            <label for="emailc" class="form-label">Confirmar Email</label>
                            <input type="email" class="form-control" id="emailc">
                        </div>

                        <div class="col-md-6">
                            <label for="pass" class="form-label">Password</label>
                            <input type="password" class="form-control" id="pass">
                        </div>


                        <div class="col-md-6">
                            <label for="passc" class="form-label">Confirmar Password</label>
                            <input type="password" class="form-control" id="passc">
                        </div>


                        <div class="col-12">
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" id="gridCheck">
                                <label class="form-check-label" for="gridCheck">
                                    Check me out
                                </label>
                            </div>
                        </div>


                        <div class="col-4">
                            <button id="actualizar_datos" type="button" class="btn btn-primary">Actualizar Datos</button>

                        </div>
                        <div class="col-4">
                            <button id="eliminar_datos" type="submit" class="btn btn-primary">Eliminar Cuenta</button>

                        </div>

                        <div class="col-4">
                            <button id="cerrar_sesion" type="button" class="btn btn-primary">Cerrar Sesión</button>

                        </div>
                    </form>


                </div>
                <div class="redes-sociales">
                    <a href="" class="boton-redes facebook fab fa-facebook-f"><i class="icon-facebook"></i></a>
                    <a href="" class="boton-redes twitter fab fa-twitter"><i class="icon-twitter"></i></a>
                    <a href="" class="boton-redes instagram fab fa-instagram"><i class="icon-instagram"></i></a>
                </div>
            </div>
        </section>

        <div class="mis-redes" style="display: block;position: fixed;bottom: 1rem;left: 1rem; opacity: 0.5; z-index: 1000;">
            <p style="font-size: .75rem;">Derechos Reservados</p>
            <div>
                <a target="_blank" href=""><i class="fab fa-facebook-square"></i></a>
                <a target="_blank" href=""><i class="fab fa-twitter"></i></a>
                <a target="_blank" href=""><i class="fab fa-instagram"></i></a>
                <a target="_blank" href=""><i class="fab fa-youtube"></i></a>
            </div>
        </div>

        <%@include file="Pie.jsp" %>

        <script src="<%= request.getContextPath()%>/js/PanelClienteAjx.js"></script>

    </body>

</html>
