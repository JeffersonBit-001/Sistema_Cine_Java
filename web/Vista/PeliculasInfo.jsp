<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>CINESTAR</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="Free HTML Templates" name="keywords">
        <meta content="Free HTML Templates" name="description">

        <!-- Favicon -->


        <link rel="stylesheet" href="<%= request.getContextPath()%>/css/index.css"/>
        <link rel="stylesheet" href="<%= request.getContextPath()%>/css/PeliculasInfo.css"/>
        

    </head>

    <body>

        <%@include file="Cabecera.jsp" %>



        <div class="jumbotron jumbotron-fluid bg-jumbotron edit_but">
            <div class="container text-center py-5">
                <h3 class="text-white display-3 mb-4">Buena Elección</h3>
                <div class="d-inline-flex align-items-center text-white flex_what">
                    <p class="m-0"><a class="text-white" href="./Main.jsp">Home</a></p>
                    <i class="far fa-circle px-3"></i>
                    <p id="vista_peli" class="m-0">Películas en </p>
                </div>
            </div>
        </div>


        <article class="cuerpo_video">

            <div class="content_btn_iframe">
                <div class="btn_selector">
                    <button id="playVideo"><img class="edt_repro" src="<%= request.getContextPath()%>/img/reproductor.png" width="120px" height="120px"><p id="mira_trailer">Mira el trailer</p></button>
                </div>


                <div class="content_iframe">
                    <iframe class="iframe" id="framee" width="930" height="605" 
                            src="" 
                            title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write;
                            encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin"
                            allowfullscreen></iframe>
                </div>

            </div>

            <content class="content_total_informacion">


                <section class="content_title_ticket_pelicula">
                    <div class="content_tile_descripcion">
                        <h1 id="title_peli">
                        </h1>
                        <p id="descr_peli"></p>
                    </div>

                    <div class="content_div_img">

                        <a id="apeli" href="<%= request.getContextPath()%>/Diseno_web_seleccion_pelis.php" class="comprar_ticket">
                            <img src="<%= request.getContextPath()%>/img/img_ticket.png" width="60px" height="60px">
                            Comprar
                        </a>
                    </div>


                </section>


                <section class="content_imagen_informacion">
                    <div class="img_informacion_descripcion">
                        <img id="img_peli" src="<%= request.getContextPath()%>/img/" width="400px" height="700px">
                    </div>



                    <div class="content_informacion_detallepeli">
                        <h2>Sinópsis.</h2>
                        <p class="text_lind" id="sinopsis">
                        </p>
                        <h3>Director
                        </h3>
                        <p id="direc_peli" class="text_lind"></p>

                        <h3>Idioma
                        </h3>
                        <div class="idioma">
                            <p class="idioma_ind text_lind" id="idiomaind"></p>
                            <p class="idioma_ind2 text_lind">Doblada</p>
                        </div>


                        <h3>Disponible
                        </h3>
                        <p id="disp_peli" class="text_lind"></p>



                    </div>
                </section>

            </content>





        </article>

        <%@include file="Pie.jsp" %>



        <script src="<%= request.getContextPath()%>/js/Pelicula.js"></script>
        <script src="<%= request.getContextPath()%>/js/PeliInfoAjx.js"></script>
    </body>

</html>