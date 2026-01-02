<%-- 
    Document   : LibroReclamaciones
    Created on : 31 ago. 2024, 20:06:30
    Author     : JEFFERSON
--%>
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

    
    
    <link rel="stylesheet" href="<%= request.getContextPath()%>/css/LibroReclamaciones.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css" integrity="sha512-vKMx8UnXk60zUwyUnUPM3HbQo8QfmNx7+ltw8Pm5zLusl1XIfwcxo8DbWCqMGKaWeNxWA8yrx5v3SaVpMvR3CA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</head>

<body>
    <%@include file="Cabecera.jsp" %>

    <!-- Header Start -->
    <div class="jumbotron jumbotron-fluid bg-jumbotron" style="margin-bottom: 90px;">
        <div class="container text-center py-5">
            <h3 class="text-white display-3 mb-4">Libro de<br> Reclamaciones</h3>
            <div class="d-inline-flex align-items-center text-white flex_what">
                <p class="m-0"><a class="text-white" href="../Main.jsp">Home</a></p>
                <i class="far fa-circle px-3"></i>
                <p class="m-0">Libro de Reclamaciones</p>
            </div>
        </div>
    </div>
    <!-- Header End -->

    
    
     <!-- Libro -->
    <div class="container">
        <div class="form-container">
            <h1>Libro de Reclamaciones</h1>
            <form id="form_id" action="<%= request.getContextPath()%>/ControladorLibroReclamaciones" method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="nombre">Nombre:</label>
                    <input type="text" id="nombre" name="nombre" value="${nombre}" required>
                </div>
                <div class="form-group">
                    <label for="apellido">Apellido:</label>
                    <input type="text" id="apellido" name="apellido" value="${apellido}" required>
                </div>
                <div class="form-group">
                    <label for="domicilio">Domicilio:</label>
                    <input type="text" id="domicilio" name="domicilio" value="${domicilio}" required>
                </div>
                <div class="form-group">
                    <label for="dni">DNI/CE:</label>
                    <input type="text" id="dni" name="dni" value="${dni}" required>
                </div>
                <div class="form-group">
                    <label for="telefono">Teléfono:</label>
                    <input type="text" id="telefono" name="telefono" value="${telefono}"  required>
                </div>
                <div class="form-group">
                    <label for="correo">Correo Electrónico:</label>
                    <input type="text" id="correo" name="correo" value="${correo}" required>
                </div>

                
                <div class="form-group">
                    <label for="tipo_bien">Tipo de Bien:</label>
                    <select id="tipo_bien" name="tipo_bien" required>
                        
                        
                    </select>
                </div>
                
                <div class="form-group" id="otro_tipo_div" style="display: none;">
                    <label for="otro_tipo">Especificar Tipo:</label>
                    <input type="text" id="otro_tipo" value="${otro_tipo}" name="otro_tipo">
                </div>
                <div class="form-group">
                    <label for="monto">Monto Reclamado:</label>
                    <input type="text" id="monto" name="monto" value="${monto}" required>
                </div>
                <div class="form-group">
                    <label for="descripcion">Descripción del Bien o Servicio:</label>
                    <input type="text" id="descripcion" name="descripcion" value="${descripcion}" required>
                </div>

                <div class="form-group">
                    <label for="tipo_reclamacion">Tipo de Reclamación:</label>
                    <select id="tipo_reclamacion" name="tipo_reclamacion" required>
                        
                        
                    </select>
                </div>
                <div class="form-group" id="otros_tipo_div" style="display: none;">
                    <label for="otros_tipo">Especificar Tipo:</label>
                    <input type="text" id="otros_tipo" value="${otros_tipo}" name="otros_tipo">
                </div>
                <div class="form-group">
                    <label for="detalle">Detalle de la Reclamación:</label>
                    <textarea id="detalle" name="detalle" required>${detalle}</textarea>
                </div>
                <div class="form-group">
                    <label for="pedido">Pedido del Consumidor:</label>
                    <textarea id="pedido" name="pedido" required>${pedido}</textarea>
                </div>

                <!-- Adjuntar Archivo -->
                <div class="form-group">
                    <label for="archivo">Adjuntar Archivo:</label>
                    <input type="file" id="archivo" name="archivo">
                </div>

                <div id="cargar_check_box" class="form-group">
                    
                    <c:forEach items="${tipo_condicion}" var="item">
                        <div class="checkbox-group">
                            <input type="checkbox" id="${item.getTipo_condicion().id}" 
                                   name="terminos${item.getTipo_condicion().id}" 
                                   ${10+item.getTipo_condicion().id == item.getTipo_condicion().id ? "checked" : ""}
                                   value="${item.getTipo_condicion().id}" 
                                    >
                            <label for="${item.getTipo_condicion().id}">${item.getTipo_condicion().descripcion}</label>
                        </div>
                    </c:forEach>
                    
                    
                </div>

                        
                        
                <div class="form-group">
                    <button id="button_enviar" type="submit" name="accion">Enviar Reclamación</button>
                </div>
            </form>
        </div>
        <div class="image-container">
            <img src="<%= request.getContextPath()%>/img/img_soporte.png" alt="Imagen descriptiva">
        </div>
    </div>

        <script>
        document.getElementById('tipo_bien').addEventListener('change', function () {
            var otroTipoDiv = document.getElementById('otro_tipo_div');


            var selectedOption = this.options[this.selectedIndex];

            otroTipoDiv.style.display = (selectedOption.getAttribute('data-name') === 'Otros') ? 'block' : 'none';

            if (selectedOption.getAttribute('data-name') !== 'Otros') {
                document.getElementById('otro_tipo').value = '';
            }
        });
        
        document.getElementById('tipo_reclamacion').addEventListener('change', function () {
            var otroTipoDiv = document.getElementById('otros_tipo_div');


            var selectedOption = this.options[this.selectedIndex];

            otroTipoDiv.style.display = (selectedOption.getAttribute('data-name') === 'Otros') ? 'block' : 'none';

            if (selectedOption.getAttribute('data-name') !== 'Otros') {
                document.getElementById('otros_tipo').value = '';
            }
        });
        
    </script>
    

    
    <!-- Libro -->
    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>         
    <script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js" integrity="sha512-VEd+nq25CkR676O+pLBnDW09R7VQX9Mdiij052gVCp5yVH3jGtH70Ho/UUv4mJDsEdTvqRCFZg0NKGiojGnUCw==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>                

    
    <c:if test="${requestScope.mensaje != null}">
            <script>
                toastr.options = {
                    "closeButton": true,
                    "positionClass": "toast-bottom-left",
                    "preventDuplicates": false,
                    "timeOut": "2000",
                    "showMethod": "fadeIn",
                    "hideMethod": "fadeOut"
                };
                <c:if test="${requestScope.result == 'ok'}">
                toastr.success('${requestScope.mensaje}', toastr.options);
                </c:if>
                <c:if test="${requestScope.result == 'error'}">
                toastr.error('${requestScope.mensaje}', toastr.options);
                </c:if>
                <c:if test="${requestScope.result == 'info'}">
                toastr.info('${requestScope.mensaje}', toastr.options);
                </c:if>
            </script>
        </c:if>
    
    
    


    <%@include file="Pie.jsp" %>
    
    <script src="<%= request.getContextPath()%>/js/LibroReclamacionesAjx.js"></script>
    
</body>

</html>

