<%-- 
    Document   : Comelona
    Created on : 30 ago. 2024, 00:46:00
    Author     : JEFFERSON
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="./css/PeliTendencia.css"/>
        <title>JSP Page</title>
        
       <link rel="stylesheet" type="text/css" href="./css/CombosIndex.css"/>
    </head>
    <body>
        <div class="container cl">
           <h2 id="title_uni">
               COMBOS DESTACADOS
           </h2>
                      
           <section id="cargar_comboss" class="principal">                
                       <c:forEach items="${cb}" var="itemc"> 
                                <article id="art1" >                                        
                                    <img class="edit edit_img" src="img/${itemc.imagen}" alt=""/>
                                </article>
                                <article id="art3">                   
                                    <div class="textc">
                                        <h1>${itemc.nombre}</h1>
                                         <p>${itemc.abastece}</p>
                                         <h2>Contenido</h2>
                                         ${itemc.sinopsis}
                                         <h3>Precio
                                         </h3>
                                         <p>S/. ${itemc.precio}</p>
                                         <h3>Oferta
                                         </h3>
                                         <p>${itemc.oferta}</p>
                                     </div>
                                     
                                     
                                            <a href="../Reservas.html" class="comprar_ticket">
                                                <img src="./img/img_ticket.png" width="60px" height="60px">
                                                <h4>Comprar</h4>
                                            </a>
                                        
                                     
                                </article>
                        </c:forEach>
               
                        
                                <c:if test="${cb.size()==0}">
                                    <h3>No hay combos destacados por ahora
                                    <br>
                                </c:if>
                            
                                     
                        
               
               
               
               
           </section>
           
            
           <a id="floj" href="#regresar_container">Regresar</a>
           <script src="<%= request.getContextPath()%>/js/ComelonaAjx.js"></script>
           
                   
           
           
       </div>
    </body>
</html>
