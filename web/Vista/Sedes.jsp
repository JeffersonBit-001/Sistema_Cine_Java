<%-- 
    Document   : Sedes
    Created on : 30 ago. 2024, 17:04:50
    Author     : JEFFERSON
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>

        <link rel="stylesheet" type="text/css" href="../css/Sedes.css"/>


    </head>
    <body>


        <article class="body_sedes">

            <div id="volver"></div>

            <div class="jumbotron jumbotron-fluid bg-jumbotron2 jumb_s" style="margin-bottom: 90px;">
                <div class="container text-center py-5">
                    <h3 class="text-white display-3 mb-4">SELECCIONA TU SEDE FAVORITA</h3>
                </div>
            </div>

            <div id="contenedor_sedes_ver">
                <!-- comment
                
                <c:set var="count" value="1" />
                <c:forEach items="${sedest}" var="item">
                    <c:choose>
                        <c:when test="${count % 2 != 0}">
    
                            <div  class="content_Sedes_relative">
                                <a class="content_sedes" target="IFramPrin" href="${item.link}">
                                    <div class="div_content_sedes2_align">
                                        <div class="div_content_text">
                                            <h2 class="nombre_cine_sede">${fn:toUpperCase(item.nombre)}</h2>
                                            <p>${item.descripcion}</p>
                                        </div>
                                    </div>
                                    <div class="div_content_sedes2_align">
                                        <img class="id_sedes_img"src="../img/img_sede_logo.jpg" width="320PX" height="140PX">
    
                                    </div>
                                </a>  
    
                            </div>
                        </c:when>
    
                        <c:otherwise>
                            <div  class="content_Sedes_relative">
                                <a class="content_sedes" target="IFramPrin" href="${item.link}">
                                    <div class="div_content_sedes2_align">
                                        <img class="id_sedes_img"src="../img/img_sede_logo.jpg" width="320PX" height="140PX">
                                    </div>
    
                                    <div class="div_content_sedes2_align">
                                        <div class="div_content_text">
                                            <h2  class="nombre_cine_sede">${fn:toUpperCase(item.nombre)}</h2>
                                            <p>${item.descripcion}</p>
                                        </div>
                                    </div>
    
                                </a>
    
                            </div>
                        </c:otherwise>
                    </c:choose>
    
                    <c:set var="count" value="${count + 1}" />
    
                </c:forEach>-->

            </div>





            <div id="mapa"></div>

            <center>
                <div id="efecto"></div>


                <section class="section_frame_ubic">
                    <div>
                        <h2 id="ubicacion_title_map">VISÍTANOS EN CINESTAR METRO UNI</h2>
                    </div>


                    <div id="CLFrame" class="CLFrame">

                        <iframe id="ifram_edit" name="IFramPrin" src=
                                "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3902.4513752830408!2d-77.0519341!3d-12.0124154!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x9105cf1c14b8257f%3A0xf664bdc3c69fcf3!2sCinestar%20Metro%20UNI!5e0!3m2!1ses-419!2spe!4v1714276770264!5m2!1ses-419!2spe" width="600"height="450" style="border:0;" allowfullscreen="" 
                                loading="lazy" referrerpolicy="no-referrer-when-downgrade">
                        </iframe>

                        <div class="content_mapa_ir_direccion">
                            <a href="#volver" class="mapa_ir_direccion" >Regresar</a>
                        </div>


                    </div>

                </section>


            </center>     





        </article>



        <script src="../js/Sedes.js"></script>
        <script src="<%= request.getContextPath()%>/js/SedesAjx.js"></script>

    </body>
</html>
