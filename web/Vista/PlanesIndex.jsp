<%-- 
    Document   : entel
    Created on : 31 ago. 2024, 00:27:07
    Author     : JEFFERSON
--%>


<%@ page import="java.util.List" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>CINESTAR</title>
        <meta content="Free HTML Templates" name="keywords">
        <meta content="Free HTML Templates" name="description">

    </head>
    <body>
        
        <div class="container-fluid bg-pricing" style="margin: 90px 0;">
        <div class="container">
            <div class="row">
                <div class="col-lg-5" style="min-height: 500px;">
                    <div class="position-relative h-100">
                        <img class="position-absolute w-100 h-100" src="img/img_prev6.jpg" style="object-fit: cover;">
                    </div>
                </div>
                
                <div class="col-lg-7 pt-5 pb-lg-5">
                    <div class="pricing-text bg-light p-4 p-lg-5 my-lg-5">
                        <div id="cargar_planes" class="owl-carousel pricing-carousel">
                            
                            <!-- 
                            <c:forEach items="${plazns}" var="itemplans">
                                <div class="bg-white">
                                    <div class="d-flex align-items-center justify-content-between border-bottom border-primary p-4">
                                        <h1 class="display-4 mb-0">
                                            <small class="align-top text-muted font-weight-medium" style="font-size: 22px; line-height: 45px;">S/.</small>${itemplans.precio}<small class="align-bottom text-muted font-weight-medium" style="font-size: 16px; line-height: 40px;"></small>
                                        </h1>
                                        <h5 class="text-primary text-uppercase m-0">${itemplans.nombre}</h5>
                                    </div>
                                    <div class="p-4">
                                        <p><i class="fa fa-check text-success mr-2"></i>${itemplans.des1}</p>
                                        <p><i class="fa fa-check text-success mr-2"></i>${itemplans.des2}</p>
                                        <p><i class="fa fa-check text-success mr-2"></i>${itemplans.des3}</p>
                                        <p><i class="fa fa-check text-success mr-2"></i>${itemplans.des4}</p>
                                        <p><i class="fa fa-check text-success mr-2"></i>${itemplans.des5}</p>
                                        <a href="" class="btn btn-primary my-2">Reservar</a>
                                    </div>
                                </div>
                            </c:forEach>
                            
                            <c:if test="${empty(plazns)}">
                                <h3>No hay planes disponibles</h3>
                                <br>
                            </c:if>
                            
                            comment -->
                            
                        </div>
                    </div>
                    <a id="floj" href="#regresar_container">Regresar</a>
                </div>
                <script src="<%= request.getContextPath()%>/js/PlanesAjx.js"></script>
                
            </div>
        </div>
    </div>
        
    

    </body>
    
    <!-- Contact Javascript File -->
    
    <!-- Template Javascript -->
    <script src="<%= request.getContextPath()%>/js/main.js"></script>
    
    
</html>

