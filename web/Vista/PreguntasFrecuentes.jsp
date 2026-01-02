
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Preguntas Frecuentes</title>
    <link rel="stylesheet" href="<%= request.getContextPath()%>/css/PreguntasFrecuentes.css"/>
</head>
<body>
    
    <%@include file="Cabecera.jsp" %>
    
    <!-- Título -->
    <div class="jumbotron jumbotron-fluid bg-jumbotron" style="margin-bottom: 90px;">
        <div class="container text-center py-5">
            <h3 class="text-white display-3 mb-4">Preguntas Frecuentes</h3>
            <div class="d-inline-flex align-items-center text-white flex_what">
                <p class="m-0"><a class="text-white" href="../Main.jsp">Home</a></p>
                <i class="far fa-circle px-3"></i>
                <p class="m-0">Preguntas Frecuentes</p>
            </div>
        </div>
    </div>
    <!-- Título -->
    
    
    <section class="container-general">
        <div id="preguntas_mostrar" class="faq-container">
            
            
            
            
                <div class="faq-item">
                    <div class="faq-question">
                        <h2>${item.nombre}</h2>
                    </div>
                    <div class="faq-answer">
                        <p>${item.descripcion}
                        </p>
                    </div>
                </div>
                
            
            
            
        </div>
    </section>

    
    
    
    <%@include file="Pie.jsp" %>
    <script src="<%= request.getContextPath()%>/js/PreguntasFrecuentesAjx.js"></script>
    
</body>
</html>
