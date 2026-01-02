<%-- 
    Document   : PagoEntrada
    Created on : 30 nov. 2024, 16:02:01
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
        <title>JSP</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/Reservas.css"/>
        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/Comprar_entrada.css">
        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/PagoEntrada.css">

        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    </head>
    <body>


        <%@include file="Cabecera.jsp" %>



        <article class="form_registro_tot">






            <div class="title_cancelar">
                <a id="cancelar_a" href="Diseno_web_seleccion_pelis.php">Cancelar</a>
                <h1 id="session_form">Reservaciones</h1>

            </div>




            <form id="form_id" action="EntregaEntrada.jsp" method="POST" >




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
                        <h4 id="asientos_disponibles_h4">Procesar Boleto de Cine</h4>



                        <div class="form_pago">
                            <div class="pago">

                                <div class="flex flex_title">
                                    <div id="cir1" class="circulo"></div>
                                    <h4 id="tarjeta_title" >Tarjeta de Crédito o Débito</h4>
                                    <img src="">
                                    <img src="">

                                </div>




                                <div class="esconder_tarjeta">

                                    <div class="flex">

                                        <input id="num_tarjeta" class="num_tarjeta" type="text"  name="num" placeholder="Número de tarjeta">



                                        <select id="tipo" class="tipo" name="tipo">
                                            <option>Tipo de Tarjeta</option>
                                            <option>Crédito</option>
                                            <option>Débito</option>
                                        </select>




                                    </div>




                                    <div class="flex">

                                        <select id="mes" class="mes" name="mes">
                                            <option>Mes</option>
                                            <option>Enero</option>
                                            <option>Febrero</option>
                                            <option>Marzo</option>
                                            <option>Abril</option>
                                            <option>Mayo</option>
                                            <option>Junio</option>
                                            <option>Julio</option>
                                            <option>Agosto</option>
                                            <option>Setiembre</option>
                                            <option>Octubre</option>
                                            <option>Noviembre</option>
                                            <option>Diciembre</option>
                                        </select>

                                        <select id="año" class="año" name="año">
                                            <option>Año</option>
                                            <option>2024</option>
                                            <option>2025</option>
                                            <option>2026</option>
                                            <option>2027</option>
                                            <option>2028</option>
                                            <option>2029</option>
                                            <option>2030</option>
                                        </select>

                                        <input id="cvv" type="texto" name="CVV" placeholder="CVV">

                                    </div>



                                    <div class="flex" >
                                        <select id="doc" class="doc" name="doc">
                                            <option>Tipo de documento</option>
                                            <option>DNI</option>
                                            <option>Partida</option>
                                            <option>Carnet de extranjero</option>
                                        </select>

                                        <input id="num" type="texto" name="num" placeholder="Número de documento">

                                    </div>


                                </div>







                            </div>

                            <div class="pago">
                                <div class="flex flex_title">
                                    <div id="cir2" class="circulo"></div>
                                    <h4 id="billetera">Billeteras Electrónicas</h4>
                                </div>




                                <div class="esconder_billetera">


                                    <div class="flex" >
                                        <select id="doc2_" class="doc" name="doc">
                                            <option>Tipo de documento</option>
                                            <option>DNI</option>
                                            <option>Partida</option>
                                            <option>Carnet de extranjero</option>
                                        </select>

                                        <input id="num2" type="texto" name="num2" placeholder="Número de documento">

                                    </div>


                                    <div class="flex flex_medio">
                                        <img id="yape"  class="pago_medio" src="<%= request.getContextPath()%>/img/yape.png" width="160px" height="160px">
                                        <img id="plin" class="pago_medio" src="<%= request.getContextPath()%>/img/plin.png" width="160px" height="160px">
                                    </div>




                                </div>






                            </div>






                        </div>








                        <div class="input_terminos_condiciones">
                            <div class="recibir_publicidad_condiciones">
                                <input id="terminos_crear" class="" type="checkbox" name="pass_confirm"><p>Acepto términos y condiciones</p>
                            </div>

                            <div class="recibir_publicidad_condiciones">
                                <input  id="promociones_crear" type="checkbox" name="pass_confirm"><p>He leído y aceptado todos los términos políticos</p>
                            </div>

                        </div>


                        <div class="text_butacas">
                            <div>
                                <a href="CompraCombos.jsp" id="btn_ante" class="btn_ante" name="btnaccion">Anterior</a>
                            </div>

                            <div>
                                <button id="btn_reserva" class="btn_reservar" name="btnaccion">Procesar</button>
                            </div>

                        </div>


                    </div>


                </div>

                <div>
                    <input type="hidden" name="codigo_aleatorio" id="codigo_aleatorio" value="codigo_aleatorio" >
                </div>



            </form>



        </article>



        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>


        <%@include file="Pie.jsp" %>
        <script src="<%= request.getContextPath()%>/js/PagoEntrada.js"></script>

    </body>
</html>