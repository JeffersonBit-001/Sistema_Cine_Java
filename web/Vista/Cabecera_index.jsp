<%-- 
    Document   : Cabecera_index
    Created on : 9 oct. 2024, 09:48:40
    Author     : JEFFERSON
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">

        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="Free HTML Templates" name="keywords">
        <meta content="Free HTML Templates" name="description">

        <!-- Favicon -->
        <link href="img/favicon.ico" rel="icon">
        
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">

        <!-- Font Awesome -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

        <!-- Libraries Stylesheet -->
        <link href="lib/animate/animate.min.css" rel="stylesheet">
        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
        <link href="lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />

        <!-- Customized Bootstrap Stylesheet -->
        <link href="css/style.css" rel="stylesheet">
        <link rel="stylesheet" href="css/index.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <!-- Topbar Start -->
        <div class="container-fluid bg-light d-none d-lg-block cabecera_desaparecer">
            <div class="row py-2 px-lg-5">
                <div class="col-lg-6 text-left mb-2 mb-lg-0">
                    <div class="d-inline-flex align-items-center">
                        <small><i class="fa fa-phone-alt mr-2"></i>+51 93456890</small>
                        <small class="px-3">|</small>
                        <small><i class="fa fa-envelope mr-2"></i>cineutp@utp.edu.pe</small>
                    </div>
                </div>
                <div class="col-lg-6 text-right">
                    <div class="d-inline-flex align-items-center">
                        <a class="text-primary px-2" href="https://www.facebook.com/multicinestar/?locale=es_LA">
                            <i class="fab fa-facebook-f"></i>
                        </a>
                        <a class="text-primary px-2" href="https://x.com/multicinestar?lang=es">
                            <i class="fab fa-twitter"></i>
                        </a>
                        <a class="text-primary px-2" href="https://www.tiktok.com/discover/cinestar-peru?lang=es">
                            <i class="fab fa-tiktok"></i>
                        </a>
                        <a class="text-primary px-2" href="https://www.instagram.com/multicines_cinestar/?hl=es">
                            <i class="fab fa-instagram"></i>
                        </a>
                        <a class="text-primary pl-2" href="https://youtu.be/2MXJZF5E0XY?si=khAPP7oObvRCxgJ6">
                            <i class="fab fa-youtube"></i>
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <!-- Topbar End -->


        <!-- Cabecera -->
        <div class="container-fluid p-0 cabecera_nuevo">
            <nav class="navbar navbar-expand-lg navbar-light py-3 py-lg-0 px-lg-5">
                <a href="Main.jsp" class="navbar-brand ml-lg-3">
                    <h1 class="m-0 text-primary"><span class="text-dark">CINE</span> STAR</h1>
                </a>
                <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse justify-content-between px-lg-3" id="navbarCollapse">
                    <div class="navbar-nav m-auto py-0">


                        <a href="Main.jsp" class="nav-item nav-link active name_letra">Home</a>
                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link dropdown-toggle name_letra" data-toggle="dropdown">Películas</a>
                            <div class="dropdown-menu rounded-0 m-0">
                                <a href="Vista/PeliculasGeneral.jsp?tipoc=Cartelera" class="dropdown-item">Cartelera</a>
                                <a href="Vista/PeliculasGeneral.jsp?tipoc=Estreno" class="dropdown-item">Estrenos</a>
                            </div>
                        </div>


                        <a href="<%= request.getContextPath()%>/ControlSedesCombos" class="nav-item nav-link name_letra">Combos</a>


                        <a href="#" class="nav-item nav-link name_letra">Reservas</a>

                        <a href="Vista/contact.jsp?openModal=true" class="nav-item nav-link name_letra">Sedes</a>

                        <a href="Vista/Redes.jsp" class="nav-item nav-link name_letra">Redes</a>

                        <a href="#" class="nav-item nav-link name_letra">Nosotros</a>

                        <a href="Vista/Huella.jsp" class="nav-item nav-link name_letra">Cinestar Verde</a>
                    </div>

                    <div class="nav-item nav-link display_head">
                        <a href="" class="btn   d-lg-block  busqueda">
                            <img id="buscar_btn" src="img/img_buscar.png" width="30px" height="30px">
                        </a>
                        <a href="ContUsuarios?tipoc=AdministradorUsuarios" class="btn btn-primary  d-lg-block busqueda bus">Login</a>
                    </div>

                </div>
            </nav>
        </div>
        <!-- Navbar End -->




    </body>
</html>
