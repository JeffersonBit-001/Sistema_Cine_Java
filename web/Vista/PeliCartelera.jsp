<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Modelo.PeliIndex"%>
<!-- Web Pages/WEB-INF/views/peliculaList.jsp -->
<%@ page import="java.util.List" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <title>CINESTAR METRO UNI</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/PeliTendencia.css"/>
        <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/PeliCarEst.css"/>
        
    </head>
    <body>

        
        
        <div class="jumbotron jumbotron-fluid bg-jumbotron" style="margin-bottom: 90px;">
            <div class="container text-center py-5">
                <h3 class="text-white display-3 mb-4">Películas en<br> Cartelera</h3>
                <div class="d-inline-flex align-items-center text-white flex_what">
                    <p class="m-0"><a class="text-white" href="../Main.jsp">Home</a></p>
                    <i class="far fa-circle px-3"></i>
                    <p class="m-0">Películas en Cartelera</p>
                </div>
            </div>
        </div>
        
        
        
        
        

        <article class="body_pelis" id="prueba">
            
            <center>

                <content class="content_section_selector_bodypelis">

                    
                    
                    <ul class="menu_peli">
                        <li>
                            <a href="#">Por Película</a>
                            <ul id="ul_1">
                                
                               
                            </ul>
                        </li>
                        <li>
                            <a href="#">¿Dónde estás?</a>
                            <ul id="ul_2">
                                
                                
                                   
                            </ul>
                        </li>
                        <li>
                            <a href="#">Elige un día</a>
                            <ul id="ul_3">
                                
                               
                            </ul>
                        </li>
                        
                        
                        <li id="li_id">
                            <input type="text" id="input-search-ser" placeholder="¿Qué película deseas reservar?">
                            <a id="href_id" href="">
                                <i class="fa-solid fa-magnifying-glass fa-lg" style="color: #ffffff;"></i>
                            </a>
                            
                            <ul id="ul_edit">
                                
                                

                            </ul>
                        </li>
                        
                    </ul>

                    

                <section class="peliculas_cartelera_body">

                    <h2 id="titulo_cartelera_body">CARTELERA</h2>
                    <hr>
                    <div id="otroContenido2"></div>   
                    <div class="box-container" id="box-cantainer">

                        
                        
                                <c:forEach items="${pepp}" var="item">
                                    
                                    <div class="box-1 box-1 pelifamilia sedeuni dia1-peli">
                                        <div class="content">
                                            <div class="content_2">
                                                <div class="probar">
                                                <div class="contenedor_reservar_detalles">

                                                        <a class="contenedor_reservar_detalles_title comprar_reserva_detalle" href="Reservas.jsp"><img class="ordenar" src="../img/img_ticket.png" width="35px" height="35px"><p class="ordenar">Comprar</p></a>

                                                        <a class="contenedor_reservar_detalles_title" href="../ControladorPeliInfo?valx=${item.nombre}"><img class="ordenar" src="../img/img_mas.png" width="25px" height="25px"><p class="ordenar">Ver Detalle</p></a>

                                                </div>

                                            <div class="decoracion_link" ><img class="mov_img_content_cartelera" src="../img/${item.img}" width="250" height="360"/></div>
                                                </div>
                                                <div class="contenedor_texto"><p class="text_content_nombre_tiempo_funcion_p">${item.nombre}</p><p class="text_content_nombre_tiempo_funcion">${item.descripcion}</p></div>
                                                <div class="contenedor_texto_descripcion_peli"><p class="texto_img_cartelera">
                                                        ${item.sinopsis}
                                                    </p>
                                                </div>


                                            </div>   
                                        </div>

                                    </div>
                                </c:forEach>
                        
                        
                        
                        <c:if test="${pepp.size()==0}">
                            <h3>No hay películas para esta sección</h3>
                            <br>
                        </c:if>

                            </div>
            
            
         

                        <div class="content_ver_mas_div">Ver Más Películas</div>
                        <div class="content_ver_menos_div">Ver Menos Películas</div>
                        
                        <a href="#" onclick="cargar('../ControladorPeli?tipoc=Cartelera');">Regresar</a>
                          
                    </div>
                </section>
            </content>
                
            
                
                

        </center>
        </article>
        
        
     <script src="<%= request.getContextPath()%>/js/PeliAjx.js"></script>
    <script src="<%= request.getContextPath()%>/js/FiltrarBusqueda.js"></script>
    




    </body>
</html>
