<%-- 
    Document   : SeleccionPelicula
    Created on : 25 nov. 2024, 23:32:11
    Author     : JEFFERSON
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/PeliculasInfo.css"/>
        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/Diseno_web_seleccion_pelis.css"/>
        
    
    </head>
    <body>


        <%@include file="Cabecera.jsp" %>

        <article class="article_acomodar">


            <input type="text" id="input" placeholder="¿Qué película deseas reservar?">


            <div>

                <!-- CARGAR PELICULAS -->
                <ul id="box">
                </ul>	
            </div>





            <content class="content_total_informacion">

                <h2 id="title_pelicula_escoger">s</h2>

                <section class="content_imagen_informacion">
                    <div class="img_informacion_descripcion">
                        <img id="img_ajax"  src="" width="400px" height="500px">
                    </div>

                    <div class="content_informacion_detallepeli">
                        <h2>Sinópsis.</h2>
                        <p id="sinopsis"></p>
                        <h3>Director
                        </h3>
                        <p id="director_ajax"></p>

                        <h3>Idioma
                        </h3>
                        <div class="idioma">
                            <p id="idioma_ajax" class="idioma_ind"></p>
                            <p class="idioma_ind2">Doblada</p>
                        </div>


                        <h3>Precio
                        </h3>
                        <p id="precio_ajax"></p>



                    </div>

                </section>


                <h2 id="title_horario">Elige tu horario</h2>


                <content class="content_sedes" id="sedes_mostrar_seleccion">



                </content>



            </content>
        </article>

        <script src="<%= request.getContextPath()%>/js/SeleccionPeliculaAjx.js"></script>

        <%@include file="Pie.jsp" %>
    </body>
</html>
