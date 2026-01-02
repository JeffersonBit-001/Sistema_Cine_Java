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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/FormSugerencias.css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css" integrity="sha512-vKMx8UnXk60zUwyUnUPM3HbQo8QfmNx7+ltw8Pm5zLusl1XIfwcxo8DbWCqMGKaWeNxWA8yrx5v3SaVpMvR3CA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

    </head>

    <body class="container-fluid">



        <!-- FORULARIO SUGERENCIAS -->
        <div class="body_form">
            <div class="form-container">   
                <div class="flex_form_img">

                    <form id="form_id"  class="form_display" action="<%= request.getContextPath()%>/ControladorSugerencias" method="post">
                        <h1 class="title_sug">Sugerencias</h1>
                        <div class="form-group">
                            <label for="name">Nombres y Apellidos:</label>
                            <input type="text" id="name" name="name" value="${nombre}"  required>
                        </div>

                        <div class="form-group">
                            <label for="email">Correo Electrónico:</label>
                            <input type="email" id="email" name="email" value="${correo}"  required>
                        </div>
                        <div class="form-group">
                            <label for="suggestion">Sugerencia:</label>
                            <textarea id="suggestion" name="suggestion"  required>${sugges}</textarea>
                        </div>
                        <div class="form-group">
                            <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                                <button id="button_enviar" class="btn btn-primary me-md-2" type="submit"  name="accion" value="EnviarSugerencia">Button</button>
                                <button class="btn btn-primary" type="button" id="btn">Regresar</button>
                            </div>
                        </div>
                    </form>

                    <div>
                        <ul id="list_dex">
                            <li>
                                <div class="class_div_form">
                                    <i class="fa-solid fa-location-dot fa-2xl"></i>
                                    <h5 class="text_form_edit">Dirección</h5>
                                    <p class="text_form_edit">Santa Luisa</p>
                                </div>

                            </li>

                            <li>
                                <div class="class_div_form">
                                    <i class="fa-solid fa-phone fa-2xl"></i>
                                    <h5 class="text_form_edit">Teléfono</h5>
                                    <p class="text_form_edit">+902122339</p>
                                </div>
                            </li>

                            <li>
                                <div class="class_div_form">
                                    <i class="fa-regular fa-envelope fa-2xl"></i>
                                    <h5 class="text_form_edit">Correo</h5>
                                    <p class="text_form_edit">grupoutp@utp.edu.pe</p>
                                </div>
                            </li>
                        </ul>

                    </div>

                </div>

            </div>

        </div>
        <!-- FORM -->


        <div id="otroContenido">




        </div>

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






        <script>
            document.addEventListener("DOMContentLoaded", function () {
                document.getElementById("btn").addEventListener("click", function () {
                    window.location.href = "${pageContext.request.contextPath}/Main.jsp";
                });
            });
        </script>


        


        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>

        
        <script src="<%= request.getContextPath()%>/js/SugerenciaAjx.js"></script>
    </body>

</html>