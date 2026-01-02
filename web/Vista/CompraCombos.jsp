<%-- 
    Document   : CompraCombos
    Created on : 30 nov. 2024, 02:00:45
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
        response.sendRedirect("CombosGeneral.jsp");
    }
     
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="<%= request.getContextPath()%>/css/skeleton.css">
        <link rel="stylesheet" href="<%= request.getContextPath()%>/css/custom.css">
        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/Reservas.css"/>
        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/Comprar_entrada.css">
        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/CompraCombos.css">
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

    </head>
    <body>

        <%@include file="Cabecera.jsp" %>

        <article class="form_registro_tot">




            <div class="title_cancelar">
                <a id="cancelar_a" href="Diseno_web_seleccion_pelis.php">Cancelar</a>
                <h1 id="session_form">Reservaciones</h1>

            </div>




            <form id="form_id" action="Pago_entrada.php" method="POST" >




                <div class="contenedor_form_chek">

                    <div class="form_registro">
                        <img id="img_pelicula" src="../img/>" width="1px" height="1px">
                        <div id="edit_resumen_text" class="text_align">


                            <h2 id="titulo_peli"></h2>
                            <p id="disponible_peli">🔻</p>
                            <h3 id="sede_peli"></h3>
                            <p id="dia_peli">📅 Hoy, 17 de Junio, 2024</p>



                            <div id="linea_align">
                                <p id="hora_peli">🕛 </p>
                                <p id="sala_peli">⚪ </p>
                            </div>


                            <div>
                                <h5 id="precio_total">Precio Total: S/. 0.00</h5>
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
                        <h4 id="asientos_disponibles_h4">Combos Disponibles</h4>




                        <!-- CARRITO -->
                        <div class="nav-item nav-link name_letr fixed_navbar">
                            <div class="row_edit">

                                <div class="two row_edit edit_carrito">
                                    <ul>
                                        <li class="">


                                            <div id="carrito">

                                                <table id="lista-carrito" class="u-full-width">
                                                    <thead>
                                                        <tr>
                                                            <th>Tipo</th>
                                                            <th>Imagen</th>
                                                            <th>Nombre</th>
                                                            <th>Precio</th>
                                                            <th>Cantidad</th>
                                                            <th></th>
                                                        </tr>
                                                    </thead>
                                                    <tbody id="lista-carrito-tbody">

                                                    </tbody>
                                                </table>

                                            </div>
                                        </li>
                                    </ul>
                                </div>
                            </div> 
                        </div>






                        <div class="text_butacas">
                            <div>
                                <a href="Reservas.jsp" id="btn_ante" class="btn_ante" name="btnaccion">Anterior</a>
                            </div>

                            <div>
                                <a href="PagoEntrada.jsp" id="btn_reserva" class="btn_reservar" name="btnaccion">Siguiente</a>
                            </div>

                        </div>














                    </div>


                </div>




            </form>














        </article>

        <%@include file="Pie.jsp" %>

        <script src="<%= request.getContextPath()%>/js/CompraCombosAjx.js"></script>





    </body>
</html>
