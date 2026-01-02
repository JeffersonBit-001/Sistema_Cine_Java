<%-- 
    Document   : EntregaEntrada
    Created on : 30 nov. 2024, 20:32:47
    Author     : JEFFERSON
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page session="true" %>
<%

    if (session != null && session.getAttribute("usuario") == null && session.getAttribute("detalleReserva") == null) {
        response.sendRedirect("Login.jsp");
    } else if (session != null && session.getAttribute("usuario") != null && session.getAttribute("detalleReserva") == null){
        response.sendRedirect("SeleccionPelicula.jsp");
    }


%>
<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/html.html to edit this template
-->
<html>
    <head>
        <title>CINESTAR</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/Reservas.css"/>
        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/Comprar_entrada.css">
        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/PagoEntrada.css">
        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/EntregaEntrada.css">
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    </head>
    <body>
        
        <%@include file="Cabecera.jsp" %>

        <article class="form_registro_tot">

            <div class="title_cancelar">
                <a id="cancelar_a" href="index.php">Cerrar</a>
                <h1 id="session_form">Reservaciones</h1>

            </div>
            
            <form id="form_id" action="" method="post" >

                        <div class="content_mover_sientos">

                            <div class="content_img_seleccion">
                                <img id="seleccion_1" src="<%= request.getContextPath()%>/img/asientos.png" width="30px" height="30px">
                                <img id="seleccion_2" src="<%= request.getContextPath()%>/img/img_ticket.png"  width="30px" height="30px">
                                <img id="seleccion_3" src="<%= request.getContextPath()%>/img/cancha.png" width="30px" height="30px">
                                <img id="seleccion_5" src="<%= request.getContextPath()%>/img/tarjeta.png"  width="30px" height="30px">
                                <img id="seleccion_4" src="<%= request.getContextPath()%>/img/entrega.png"  width="30px" height="30px">
                                
                            </div>

                            <div class="responsive_ahora">
                            <h4 id="asientos_disponibles_h4">Tipo de Entrega</h4>

                            <div class="content_div_boleta">
                                
                                <div class="pago">
                                    <a href="Correo.php">Envío a Correo</a>
                                    
                                </div>

                                <div class="pago">
                                    <a href="pdf.php">Descargar PDF</a>
                                </div>

                                    <div class="pago pago_entrada">
                                        <input type='hidden' name='inputVale' value="<?php echo $_SESSION['codigo_aleatorio_ps']; ?>" required>
                                        <button id="entrega_button_entrada" name="entrega_entrada" type='submit' value="entrega_entrada">Reclamar vale</button> 
                                    </div>
                                    
                            </div>
                            
                            <div>
                                <h1 id="codigo_boleto">
                                    
                                </h1>
                            </div>

                            <div class="text_butacas">
                                
                            </div>

                            </div>
                        </div>
                </form>

        </article>
        <%@include file="Pie.jsp" %>
    </body>
</html>
