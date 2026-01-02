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
        <title>Historial</title>
        <link rel="stylesheet" href="<%= request.getContextPath()%>/css/PanelCliente.css">
        <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous" />
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

        <style>
            .contenedorOcultar{
                display: none
            }

            .row{
                cursor: pointer
            }
            
            h3{
                font-weight: bold;
                text-shadow: 0px 0px 8px gray
            }
        </style>
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
                    <h3 id="title_nombre" class="titulo"><%= (us != null) ? "" + us.getNombres() + " "+ us.getApellidos() : "" %></h3>
                    <p class="texto">Persona dinámica en todo sitio, puedes contar conmigo en donde quieras.</p>
                    <div class="col-4">
                        <a href="<%= request.getContextPath()%>/Vista/PanelCliente.jsp" class="btn btn-primary">Ver mi Perfil</a>

                    </div>
                </div>

                <div class="perfil-usuario-footer" id="cargarHistorialInfo">
                    <div class="perfil-usuario-footer">

                        <div class="row g-3">







                        </div>


                    </div>


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

        <script src="<%= request.getContextPath()%>/js/HistorialClienteAjx.js"></script>

    </body>

</html>
