<%-- 
    Document   : categorias_busqueda_combos
    Created on : 7 oct. 2024, 16:37:37
    Author     : JEFFERSON
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .menu_peli li ul li{
                margin-bottom: 0;
                padding-bottom: 0;
                padding: 5px
            }
            
            .btnselecsubcat{
                cursor: pointer
            }
            .edit_peliculas{
                cursor: default
            }
        </style>
    </head>
    <body>
        
        
        <ul class="menu_peli">
                        
                    <li>
                        <a class="edit_peliculas">Sub-Categoria</a>
                            <ul>
                                
                                <c:forEach items="${categoria}" var="item">
                                    <li><a class="btnselecsubcat" data-subcat="${item.nombre}">${item.nombre}</a></li>
                                </c:forEach>
                                    
                                
                            </ul>
                        </li>
                        
                        
                        
                        <li id="li_id">
                            <input type="text" id="input-search-ser" class="input_text_busqueda" placeholder="¿Qué película deseas reservar?">
                            <a id="href_id">
                                <i class="fa-solid fa-magnifying-glass fa-lg" style="color: #ffffff;"></i>
                            </a>
                            
                            <ul id="ul_edit">
                                
                                <c:forEach items="${comboss}" var="item">
                                    <li><a class="" href="<%= request.getContextPath()%>/ControladorPeliInfo?valx=${item.nombre}">${item.nombre}</a></li>
                                </c:forEach>

                            </ul>
                        </li>    
                        
                        
        </ul>
                        
        <script src="<%= request.getContextPath()%>/js/FiltrarBusqueda.js"></script>
        <script src="<%= request.getContextPath()%>/js/Catcomart.js"></script>
    </body>
</html>
