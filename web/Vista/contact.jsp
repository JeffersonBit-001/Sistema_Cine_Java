<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>CINESTAR</title>
        <title>Contactos</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="Free HTML Templates" name="keywords">
        <meta content="Free HTML Templates" name="description">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">

        <link rel="stylesheet" href="../css/Contacto.css"/>

        <style>
            .toast-success {
                background-color: #28a745 !important;
                color: white !important;
            }
            .toast-error {
                background-color: #dc3545 !important;
                color: white !important;
            }
            .toast-info {
                background-color: #17a2b8 !important;
                color: white !important;
            }
            .toast-warning {
                background-color: #ffc107 !important;
                color: black !important;
            }

            .foot_estilo{
                margin-top: 0px !important
            }

        </style>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>


    </head>

    <body>
        <%@include file="Cabecera.jsp" %>


        <!-- Header Start -->
        <div class="jumbotron jumbotron-fluid bg-jumbotron" style="margin-bottom: 90px;">
            <div class="container text-center py-5">
                <h3 class="text-white display-3 mb-4">Contacto</h3>
                <div class="d-inline-flex align-items-center text-white flex_what">
                    <p class="m-0"><a class="text-white" href="../Main.jsp">Home</a></p>
                    <i class="far fa-circle px-3"></i>
                    <p class="m-0">Contacto</p>
                </div>
            </div>
        </div>
        <!-- Header End -->



        <div class="row mx-0 justify-content-center text-center">
            <div class="col-lg-6">
                <h3 class="display-3 text-capitalize mb-3 dis_p">
                    SEDE <span class="decorative-rectangle">PRINCIPAL</span>
                </h3>
            </div>
        </div>
        <!-- Contacto -->
        <div class="container-fluid py-5">
            <div class="container py-5">
                <div class="row">
                    <div class="col-lg-6" style="min-height: 500px;">
                        <div class="position-relative h-100">

                            <iframe  class="position-absolute w-100 h-100"
                                     src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3902.4514514974944!2d-77.05451438902102!3d-12.012410141213557!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x9105cf1c14b8257f%3A0xf664bdc3c69fcf3!2sCinestar%20Metro%20UNI!5e0!3m2!1ses-419!2spe!4v1725049696813!5m2!1ses-419!2spe" 
                                     frameborder="0"  style="border:0;" allowfullscreen="" 
                                     aria-hidden="false" tabindex="0" loading="lazy">

                            </iframe>
                        </div>
                    </div>
                    <div class="col-lg-6 pt-5 pb-lg-5">
                        <div class="contact-form bg-light p-4 p-lg-5 my-lg-5">
                            <h6 class="d-inline-block text-white text-uppercase bg-primary py-1 px-2">Contáctanos</h6>
                            <h1 class="mb-4">Contáctanos para cualquier duda</h1>
                            <div id="success"></div>
                            <!--  id="contactForm" -->
                            <form id="form_id"  action="<%= request.getContextPath()%>/ControladorContacto" 
                                  method="post">
                                <div class="form-row">
                                    <div class="col-sm-6 control-group">
                                        <input type="text" class="form-control border-0 p-4" id="name" name="name" placeholder="Tu Nombre"
                                               required="required"/>
                                        <p class="help-block text-danger"></p>
                                    </div>
                                    <div class="col-sm-6 control-group">
                                        <input type="email" class="form-control border-0 p-4" id="email" name="email" placeholder="Tu Email"
                                               required="required"  />
                                        <p class="help-block text-danger"></p>
                                    </div>
                                </div>
                                <div class="control-group">
                                    <input type="text" class="form-control border-0 p-4" id="subject" name="subject" placeholder="Asunto"
                                           required="required"  />
                                    <p class="help-block text-danger"></p>
                                </div>
                                <div class="control-group">
                                    <textarea class="form-control border-0 py-3 px-4" rows="3" id="message" name="message" placeholder="Mensaje"
                                              required="required"
                                              ></textarea>
                                    <p class="help-block text-danger"></p>
                                </div>
                                <div>
                                    <button class="btn btn-primary py-3 px-4" type="submit" id="enviar">Enviar mensaje</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Contact End -->



        <div class="row mx-0 justify-content-center text-center">
            <div class="col-lg-6">

                <h3 class="d-inline-block bg-light text-primary text-uppercase py-1 px-2 o_edit">O</h3>


            </div>
        </div>






        <!-- Header Start -->
        <div class="jumbotron jumbotron-fluid bg-jumbotron jumb_s" style="margin-bottom: 90px;">
            <div class="container text-center py-5">
                <h3 class="text-white display-3 mb-4">Escbríbenos al Whatsapp</h3>
                <div class="d-inline-flex align-items-center text-white flex_what">
                    <h4 class="m-2 mcla">+51 999 881 123</h4>

                    <i class="fa-brands fa-whatsapp fa-fade fa-2xl" style="color: #63E6BE;"></i>
                    <h4 class="m-2 mcla">+51 900 232 231</h4>
                </div>
            </div>
        </div>
        <!-- Header End -->

        <div class="row mx-0 justify-content-center text-center edit_sedes">
            <div class="col-lg-6">

                <a class="btn btn-primary btn_aba" href="#otroContenido" onclick="cargarsede('Sedes.jsp');">Conoce todas nuestras sedes</a>
                <i class="fa-solid fa-angle-down fa-bounce fa-xl btn_aba" style="color: #f56b6b;"></i>

            </div>
        </div>


        <div id="otroContenido">




        </div>




        <script>
            function cargarsede(archivo) {
                fetch(archivo)
                        .then(response => response.text())
                        .then(data => {

                            let tempDiv = document.createElement('div');
                            tempDiv.innerHTML = data;
                            document.getElementById('otroContenido').innerHTML = tempDiv.innerHTML;
                            let scripts = tempDiv.querySelectorAll('script');
                            scripts.forEach(script => {
                                if (script.src) {

                                    let newScript = document.createElement('script');
                                    newScript.src = script.src;
                                    newScript.onload = () => console.log(`Script cargado: ${script.src}`);
                                    newScript.onerror = () => console.error(`Error al cargar el script: ${script.src}`);
                                    document.head.appendChild(newScript);
                                }
                            });
                        })
                        .catch(error => console.error('Error al cargar el contenido:', error));
            }


            document.addEventListener("DOMContentLoaded", function () {

                function getParameterByName(name) {
                    name = name.replace(/[\[\]]/g, '\\$&');
                    var regex = new RegExp('[?&]' + name + '(=([^&#]*)|&|#|$)'),
                            results = regex.exec(window.location.href);
                    if (!results)
                        return null;
                    if (!results[2])
                        return '';
                    return decodeURIComponent(results[2].replace(/\+/g, ' '));
                }


                if (getParameterByName('openModal') === 'true') {

                    cargarsede('Sedes.jsp');
                    var targetElement = document.getElementById('otroContenido');
                    if (targetElement) {
                        targetElement.scrollIntoView({behavior: 'smooth'});
                    }
                }
            });
        </script>






        <%@include file="Pie.jsp" %>




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



            <script src="<%= request.getContextPath()%>/js/ContactAjx.js"></script>
    </body>

</html>