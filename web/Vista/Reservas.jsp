<%-- 
    Document   : Reservas
    Created on : 26 nov. 2024, 21:12:15
    Author     : JEFFERSON
--%>
<%@page import="Modelo.DetalleReserva"%>
<%@page import="Modelo.PeliIndex"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page session="true" %>
<%
    if (session != null && session.getAttribute("usuario") == null && session.getAttribute("detalleReserva") == null) {
        response.sendRedirect("Login.jsp");
    } else if (session != null && session.getAttribute("usuario") != null) {  
        Object detalleReserva = session.getAttribute("detalleReserva");
        if (detalleReserva != null && detalleReserva instanceof DetalleReserva) {
            DetalleReserva reserva = (DetalleReserva) detalleReserva;
            PeliIndex peliIndex = reserva.getPeli();
            if (peliIndex == null) {
                response.sendRedirect("SeleccionPelicula.jsp");
            }
        } else {
            response.sendRedirect("SeleccionPelicula.jsp");
        }
    }
%>
<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/html.html to edit this template
-->
<html>
    <head>
        <title>CINESTAR METRO UNI</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/Reservas.css"/>
        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/Comprar_entrada.css">
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    </head>
    <body>

        <%@include file="Cabecera.jsp" %>

        <article class="form_registro_tot">

            <div class="title_cancelar">
                <a id="cancelar_a" href="">Cancelar</a>
                <h1 id="session_form">Reservaciones</h1>

            </div>

            <form id="form_id" action="envio.jsp" method="POST">




                <div class="contenedor_form_chek">

                    <div class="form_registro">
                        <img id="img_pelicula" src="../img/>" width="200px" height="200px">
                        <div class="text_align">


                            <h2 id="titulo_peli"></h2>
                            <p id="disponible_peli">🔻</p>
                            <h3 id="sede_peli"></h3>
                            <p id="dia_peli">📅 Hoy, 17 de Junio, 2024</p>



                            <div id="linea_align">
                                <p id="hora_peli">🕛 </p>
                                <p id="sala_peli">⚪ </p>
                            </div>


                            <div>
                                <h5 id="contador_seleccionados">Entradas: 0</h5>
                                <input id="contador_asientos" name = "contador_asientos" type="hidden">


                                <h5 id="precio_seleccionados">Pelicula: S/. </h5>


                                <input type="hidden" id="precio_seleccionados_input" name="precio_seleccionados_input" value="0">


                                <h5 id="precio_total">Precio Total: S/. 0</h5>
                                <input id="precio_total_input" type="hidden" name="precio_total_input" value="0">

                            </div>



                        </div>


                    </div>

                </div>


                <div class="content_mover_sientos">

                    <div class="content_img_seleccion">
                        <img id="seleccion_1" src="<%= request.getContextPath()%>/img/asientos.png" width="30px" height="30px">
                        <img id="seleccion_2" src="<%= request.getContextPath()%>/img/img_ticket.png"  width="30px" height="30px">
                        <img id="seleccion_3" src="<%= request.getContextPath()%>/img/cancha.png" width="30px" height="30px">
                        <img id="seleccion_5" src="<%= request.getContextPath()%>/img/tarjeta.png"  width="30px" height="30px">
                        <img id="seleccion_4" src="<%= request.getContextPath()%>/img/entrega.png"  width="30px" height="30px">


                    </div>


                    <div class="responsive_ahora">
                        <h4 id="asientos_disponibles_h4">Asientos Disponibles</h4>




                        <div class="contenedor">
                            <div class="ordenar_or">
                                <p>A</p>
                                <p>B</p>
                                <p>C</p>
                                <p>D</p>

                                <p>E</p>
                                <p>F</p>

                                <p>G</p>
                                <p>H</p>

                                <p>I</p>
                                <p>J</p>

                                <p>K</p>
                            </div>

                            <div class="ordenar_or" id="asientos_container">

                            </div>

                            <div class="ordenar_or">
                                <p>A</p>
                                <p>B</p>
                                <p>C</p>
                                <p>D</p>

                                <p>E</p>
                                <p>F</p>

                                <p>G</p>
                                <p>H</p>

                                <p>I</p>
                                <p>J</p>

                                <p>K</p>
                            </div>

                        </div>

                        <div class="texto_abajo">
                            <div class="edit">
                                <div class="texto1"></div>
                                <p>Disponible</p>
                            </div>

                            <div class="edit">
                                <div class="texto2"></div>
                                <p>Ocupada</p>
                            </div>

                            <div class="edit">
                                <div class="texto3"></div>
                                <p>Seleccionada</p>
                            </div>


                            <div class="edit">
                                <div class="texto4"><img src="<%= request.getContextPath()%>/img/discapacitado.png" width="20px" height="20px"></div>
                                <p>Discapacitados</p>
                            </div>


                        </div>





                        <div class="text_butacas">
                            <div>

                                <h5 id="butaca_seleccionadas">Butacas seleccionadas:</h5>

                            </div>

                            <div>
                                <button type="submit" id="btn_reserva" class="btn_reservar" name="btnaccion">Siguiente</button>
                            </div>

                        </div>

                    </div>


                </div>




            </form>




        </article>



        <script src="<%= request.getContextPath()%>/js/ReservasAjx.js"></script>


        <%@include file="Pie.jsp" %>


    </body>
</html>