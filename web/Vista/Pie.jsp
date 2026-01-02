<%-- 
    Document   : Pie
    Created on : 3 set. 2024, 21:50:33
    Author     : JEFFERSON
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <!-- Footer Start -->
        <div class="footer container-fluid position-relative bg-dark py-5 edit_pie_pag" style="margin-top: 90px;">
            <div class="container pt-5">
                <div class="row">
                    <div class="col-lg-6 pr-lg-5 mb-5">
                        <a href="../Main.jsp" class="navbar-brand">
                            <h1 class="mb-3 text-white"><span class="text-primary">CINE</span> STAR</h1>
                        </a>
                        <p>Aliquyam sed elitr elitr erat sed diam ipsum eirmod eos lorem nonumy. Tempor sea ipsum diam  sed clita dolore eos dolores magna erat dolore sed stet justo et dolor.</p>
                        <p><i class="fa fa-map-marker-alt mr-2"></i>555 Santa Luisa, Lima, Perú</p>
                        <p><i class="fa fa-phone-alt mr-2"></i>+51 93456890</p>
                        <p><i class="fa fa-envelope mr-2"></i>cineutp@utp.edu.pe</p>
                        <div class="d-flex justify-content-start mt-4">
                            <a class="btn btn-lg btn-primary btn-lg-square mr-2" href="https://x.com/multicinestar?lang=es"><i class="fab fa-twitter"></i></a>
                            <a class="btn btn-lg btn-primary btn-lg-square mr-2" href="https://www.facebook.com/multicinestar/?locale=es_LA"><i class="fab fa-facebook-f"></i></a>
                            <a class="btn btn-lg btn-primary btn-lg-square mr-2" href="https://www.tiktok.com/discover/cinestar-peru?lang=es"><i class="fab fa-tiktok"></i></a>
                            <a class="btn btn-lg btn-primary btn-lg-square" href="https://www.instagram.com/multicines_cinestar/?hl=es"><i class="fab fa-instagram"></i></a>
                        </div>
                    </div>
                    <div class="col-lg-6 pl-lg-5">
                        <div class="row">
                            <div class="col-sm-6 mb-5">
                                <h5 class="text-white text-uppercase mb-4">Servicio</h5>
                                <div class="d-flex flex-column justify-content-start">
                                    <a class="text-white-50 mb-2" href="../Main.jsp"><i class="fa fa-angle-right mr-2"></i>Home</a>
                                    <a class="text-white-50 mb-2" href="PeliculasGeneral.jsp?tipoc=Cartelera"><i class="fa fa-angle-right mr-2"></i>Cartelera</a>
                                    <a class="text-white-50 mb-2" href="PeliculasGeneral.jsp?tipoc=Estreno"><i class="fa fa-angle-right mr-2"></i>Estrenos</a>
                                    <a class="text-white-50 mb-2" href="<%= request.getContextPath()%>/Vista/PeliculasGeneral.jsp?tipoc=Combos"><i class="fa fa-angle-right mr-2"></i>Combos</a>
                                    <a class="text-white-50" href="contact.jsp"><i class="fa fa-angle-right mr-2"></i>Contacto</a>
                                </div>
                            </div>
                            <div class="col-sm-6 mb-5">
                                <h5 class="text-white text-uppercase mb-4">General</h5>
                                <div class="d-flex flex-column justify-content-start">
                                    <a class="text-white-50 mb-2" href="<%= request.getContextPath()%>/Vista/contact.jsp?openModal=true"><i class="fa fa-angle-right mr-2"></i>Sedes</a>
                                    <a class="text-white-50 mb-2" href="FormSugerencia.jsp"><i class="fa fa-angle-right mr-2"></i>Sugerencias</a>
                                    <a class="text-white-50 mb-2" href="Redes.jsp"><i class="fa fa-angle-right mr-2"></i>Nosotros</a>
                                    <a class="text-white-50 mb-2" href="LibroReclamaciones.jsp"><i class="fa fa-angle-right mr-2"></i>Libro de Reclamaciones</a>
                                    <a class="text-white-50" href="PreguntasFrecuentes.jsp"><i class="fa fa-angle-right mr-2"></i>Preguntas</a>
                                </div>
                            </div>
                            <div class="col-sm-12 mb-5">
                                <h5 class="text-white text-uppercase mb-4">Bienvenido</h5>
                                <div class="w-100">
                                    <div class="input-group">
                                        <input type="text" class="form-control border-light" style="padding: 30px;" placeholder="Your Email Address">
                                        <div class="input-group-append">
                                            <button class="btn btn-primary px-4">Registro</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="container-fluid bg-dark text-light border-top py-4" style="border-color: rgba(256, 256, 256, .15) !important;">
            <div class="container">
                <div class="row">
                    <div class="col-md-6 text-center text-md-left mb-3 mb-md-0">
                        <p class="m-0 text-white">&copy; <a href="#">CINESTAR</a>. Todos los derechos reservados.</p>
                    </div>
                    <div class="col-md-6 text-center text-md-right">
                        <p class="m-0 text-white">Diseñado por <a href="?utpgroup">GRUPO UTP</a></p>
                    </div>
                </div>
            </div>
        </div>
        <!-- Footer End -->


        <!-- Back to Top -->
        <a href="#" class="btn btn-lg btn-primary back-to-top"><i class="fa fa-angle-double-up"></i></a>


        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <script src="../lib/easing/easing.min.js"></script>
        <script src="../lib/waypoints/waypoints.min.js"></script>
        <script src="../lib/counterup/counterup.min.js"></script>
        <script src="../lib/owlcarousel/owl.carousel.min.js"></script>
        <script src="../lib/tempusdominus/js/moment.min.js"></script>
        <script src="../lib/tempusdominus/js/moment-timezone.min.js"></script>
        <script src="../lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

        <!-- Contact Javascript File -->
        <script src="../mail/jqBootstrapValidation.min.js"></script>
        <script src="../mail/contact.js"></script>

        <!-- Template Javascript -->
        <script src="../js/main.js"></script>
        <script src="../js/index.js"></script>
    </body>
</html>
