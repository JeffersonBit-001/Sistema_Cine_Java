<%-- 
    Document   : Login
    Created on : 1 dic. 2024, 13:01:22
    Author     : JEFFERSON
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page session="true" %>
<%
    
    if (session != null && session.getAttribute("usuario") != null) {
    
        if(session.getAttribute("rol").equals("Administrador")){
            response.sendRedirect("../VistaAdministrador/AdmUsuarios.jsp");
        } else if (session.getAttribute("rol").equals("Cliente")){
            response.sendRedirect("PanelCliente.jsp");      
        }
    }
%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <title>CINESTAR</title>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
        <link rel="stylesheet" href="<%= request.getContextPath()%>/css/Login.css">
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>


    </head>

    <body>

        <div class="container" id="container">
            <div class="form-container sign-up create_register">
                <form id="form_id_create">
                    <h1>Crear Cuenta</h1>
                    <div class="social-icons">
                        <a href="#" class="icon"><i class="fa-brands fa-google-plus-g"></i></a>
                        <a href="#" class="icon"><i class="fa-brands fa-facebook-f"></i></a>
                        <a href="#" class="icon"><i class="fa-brands fa-github"></i></a>
                        <a href="#" class="icon"><i class="fa-brands fa-linkedin-in"></i></a>
                    </div>
                    <span>Ingresa tus datos</span>
                    <input type="text" name="nombres" id="nombres" placeholder="Nombres" required>
                    <input type="text" name="apellidos" id="apellidos" placeholder="Apellidos" required>
                    <input type="text" name="dni" id="dni" placeholder="DNI" required>
                    <select name="genero" id="genero" required>
                        <option value="" disabled selected>Selecciona tu género</option>
                        <option value="Hombre">Hombre</option>
                        <option value="Mujer">Mujer</option>
                    </select>
                    <input type="date"  id="nacimiento" name="nacimiento" placeholder="Fecha de Nacimiento" required>
                    <input type="text" id="telefono" name="telefono" placeholder="Teléfono" required>
                    <input type="text" id="domicilio" name="domicilio" placeholder="Domicilio" required>
                    <input type="email" id="correo" name="correo" placeholder="Correo Electrónico" required>
                    <input type="email" id="correo_confirm" name="correo_confirm" placeholder="Confirmar Correo Electrónico" required>
                    <input type="password" id="pass" name="pass" placeholder="Contraseña" required>
                    <input type="password" id="pass_confirm" name="pass_confirm" placeholder="Confirmar Contraseña" required>
                    <div id="#display_button">
                        <button>Registrar</button>
                        <a class="volver_edit" href="<%= request.getContextPath()%>/Main.jsp">Volver</a>
                    </div>
                </form>
            </div>
            <div class="form-container sign-in login_register">
                <form id="form_id_sesion">
                    <h1>Iniciar Sesión</h1>
                    <div class="social-icons">
                        <a href="#" class="icon"><i class="fa-brands fa-google-plus-g"></i></a>
                        <a href="#" class="icon"><i class="fa-brands fa-facebook-f"></i></a>
                        <a href="#" class="icon"><i class="fa-brands fa-github"></i></a>
                        <a href="#" class="icon"><i class="fa-brands fa-linkedin-in"></i></a>
                    </div>
                    <span>Ingresa tus datos</span>
                    <input id="correo2" name="correo2" type="email" placeholder="Email">
                    <input id="pass2" name="pass2" type="password" placeholder="Password">
                    <div class="g-recaptcha" data-sitekey="x"></div>
                    <a id="diseno_contra_olvd" href="#">¿Olvidaste tu contraseña?</a>
                    <div id="#display_button">
                        <button>Ingresar</button>
                        <a class="volver_edit" href="<%= request.getContextPath()%>/Main.jsp">Volver</a>
                    </div>

                </form>
            </div>
            <div class="toggle-container">
                <div class="toggle">
                    <div class="toggle-panel toggle-left">
                        <h1>Únete a esta gran familia!</h1>
                        <p>Te proporcionaremos los mejores resultados</p>
                        <button class="hidden" id="login">Iniciar Sesión</button>
                    </div>
                    <div class="toggle-panel toggle-right">
                        <h1>Bienvenido, Amigo!</h1>
                        <p>Ingresa con tus datos para sacar el máximo beneficio</p>
                        <button class="hidden" id="register">Crear Cuenta</button>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://www.google.com/recaptcha/api.js" async defer></script>
        <script src="<%= request.getContextPath()%>/js/LoginAjx.js"></script>
    </body>



</html>
