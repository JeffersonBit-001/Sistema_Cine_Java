<%-- 
    Document   : index
    Created on : 26 ago. 2024, 19:45:39
    Author     : JEFFERSON
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CINESTAR</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="Free HTML Templates" name="keywords">
    <meta content="Free HTML Templates" name="description">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap" rel="stylesheet">

    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

    
    
    
    
    
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!-- Site CSS -->
    <link rel="stylesheet" href="css/style_1.css">
    <!-- Responsive CSS -->
    <link rel="stylesheet" href="css/responsive.css">
    
    
    
    
    
    
    <!-- Libraries Stylesheet -->
    <link href="lib/animate/animate.min.css" rel="stylesheet">
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="css/index.css"/>

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/style.css" rel="stylesheet">
    
    
    
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
                    
                    
                    <a href="Vista/CombosGeneral.jsp" class="nav-item nav-link name_letra">Combos</a>

                    
                    <a href="<%= request.getContextPath()%>/Vista/SeleccionPelicula.jsp" class="nav-item nav-link name_letra">Reservas</a>
                    
                    <a href="Vista/contact.jsp?openModal=true" class="nav-item nav-link name_letra">Sedes</a>
                    
                    <a href="Vista/Redes.jsp" class="nav-item nav-link name_letra">Redes</a>
                    
                    <a href="#" class="nav-item nav-link name_letra">Nosotros</a>
                    
                    <a href="Vista/Huella.jsp" class="nav-item nav-link name_letra">Cinestar Verde</a>
                </div>
                
                <div class="nav-item nav-link display_head">
                    <a href="" class="btn   d-lg-block  busqueda">
                    <img id="buscar_btn" src="img/img_buscar.png" width="30px" height="30px">
                    </a>
                    <a href="<%= request.getContextPath()%>/Vista/Login.jsp" class="btn btn-primary  d-lg-block busqueda bus">Login</a>
                </div>
                
            </div>
        </nav>
    </div>
    <!-- Navbar End -->

    
    
    
    
    
    
    
    <!-- Slider Inicio -->
    <div id="slides-shop" class="cover-slides" style="min-height: 95.5vh;">
        <ul id="slider_container" class="slides-container">
            
            <!-- comment
            <c:forEach items="${index_env}" var="item_index">
            <li class="text-center">
                <img class="position-absolute img_edit" src="img/${item_index.img}" style="object-fit: cover;">
                <div class="container">
                    <div class="row d-flex">
                        <div class="p-3" style="max-width: 700px;">

                            <h3 class="display-3 text-capitalize  mb-3 text_title_peli">
                                ${item_index.nombre}
                            </h3>
                            <p class="mx-md-8 px-5 descrip_text">
                                ${item_index.sinopsis}
                            </p>
                            
                            
                            <div class="text_com">
                                <a class="btn_comprar_caja" href="#otro">
                                    
                                    <i class="fa-solid fa-ticket fa-2xl ffs_sol" style="color: #e9902b;"></i>Comprar
                                </a>
                                
                            </div>
                                
                            
                        </div>
                    </div>
                </div>
            </li>
            </c:forEach>
            
             -->
            
            
        </ul>
        <script src="<%= request.getContextPath()%>/js/indexAjx.js"></script>
        
        <div class="slides-navigation">
            <a href="#" class="next"><i class="fa fa-angle-right" aria-hidden="true"></i></a>
            <a href="#" class="prev"><i class="fa fa-angle-left" aria-hidden="true"></i></a>
        </div>
    </div>
    <!-- End Slider -->
    
    
    
    <!-- Carousel Start 
    <div class="container-fluid p-0 mb-5 pb-5">
        <div id="header-carousel" class="carousel slide carousel-fade" data-ride="carousel">
            <ol class="carousel-indicators">
                <li data-target="#header-carousel" data-slide-to="0" class="active"></li>
                <li data-target="#header-carousel" data-slide-to="1"></li>
                <li data-target="#header-carousel" data-slide-to="2"></li>
                <li data-target="#header-carousel" data-slide-to="3"></li>
                <li data-target="#header-carousel" data-slide-to="4"></li>
            </ol>
            <div class="carousel-inner">
                <div class="carousel-item position-relative active" style="min-height: 100vh;">
                    <img class="position-absolute w-100 h-100 img_edit" src="img/img_spy_portada_guardianes.png" style="object-fit: cover;">
                    <div class="carousel-caption d-flex flex-column  justify-content-center">
                        <div class="p-3" style="max-width: 900px;">
                            
                            <h3 class="display-3 text-capitalize  mb-3 text_title_peli">
                                Guardianes del Museo
                            </h3>
                            <p class="mx-md-5 px-5 descrip_text">
                                Un naufragio y el azar 
                                llevan al gato Vincent y al
                                ratón Maurice al museo Hermitage
                                de San Petersburgo. Allí, Vincent 
                                conoce a un grupo de gatos que protege las obras
                                de arte de los roedores. Él quiere ser uno de ellos, pero Maurice es su amigo.

                            </p>
                            <a class="btn btn-outline-light py-2 px-2 mt-1 animate__animated animate__fadeInUp btn_comprar_caja" href="#">
                                <img id="comprar_btn" src="img/img_ticket.png" width="60px" height="60px">Comprar
                            </a>
                        </div>
                    </div>
                </div>
                
                <div class="carousel-item position-relative" style="min-height: 100vh;">
                    <img class="position-absolute w-100 h-100 img_edit" src="img/img_spy_portada_gar.png" style="object-fit: cover;">
                    <div class="carousel-caption d-flex flex-column  justify-content-center">
                        <div class="p-3" style="max-width: 900px;">
                            
                            <h3 class="display-3 text-capitalize  mb-3 text_title_peli">The Garfield Movie</h3>
                            <p class="mx-md-5 px-5 descrip_text">
                                Garfield, el gato casero mundialmente famoso 
                                odia-lunes y amante de las lasañas, está por 
                                tener una aventura fuera de casa. Después de una 
                                inesperada reunión con su ausente padre – un sucio 
                                gato callejero llamado Vic – Garfield y su canino amigo
                                Odie, son forzados a dejar su consentida vida para unirse 
                                a Vic en un divertido asalto de gran riesgo.

                            </p>
                            <a class="btn btn-outline-light py-2 px-2 mt-1 animate__animated animate__fadeInUp btn_comprar_caja" href="#">
                                <img id="comprar_btn" src="img/img_ticket.png" width="60px" height="60px">Comprar
                            </a>
                        </div>
                    </div>
                </div>
                
                
                <div class="carousel-item position-relative" style="min-height: 100vh;">
                    <img class="position-absolute w-100 h-100 img_edit" src="img/img_spy_portada_gato_con_suerte.png" style="object-fit: cover;">
                    <div class="carousel-caption d-flex flex-column  justify-content-center">
                        <div class="p-3" style="max-width: 900px;">
                            
                            <h3 class="display-3 text-capitalize  mb-3 text_title_peli">Un Gato con Suerte</h3>
                            <p class="mx-md-5 px-5 descrip_text">
                                Un gato mimado da por sentada
                                la suerte que le ha tocado tras 
                                ser rescatado y amado por Rose, una
                                estudiante apasionada y de buen corazón. 
                                Cuando pierde su novena vida, el destino
                                interviene para que emprenda un viaje transformador.                        

                            </p>
                            <a class="btn btn-outline-light py-2 px-2 mt-1 animate__animated animate__fadeInUp btn_comprar_caja" href="#">
                                <img id="comprar_btn" src="img/img_ticket.png" width="60px" height="60px">Comprar
                            </a>
                        </div>
                    </div>
                </div>
                
                
                <div class="carousel-item position-relative" style="min-height: 100vh;">
                    <img class="position-absolute w-100 h-100 img_edit" src="img/img_spy_portada_furiosa.png" style="object-fit: cover;">
                    <div class="carousel-caption d-flex flex-column  justify-content-center">
                        <div class="p-3" style="max-width: 900px;">
                            
                            <h3 class="display-3 text-capitalize  mb-3 text_title_peli">Furiosa A Mad Max Saga</h3>
                            <p class="mx-md-5 px-5 descrip_text">
                                Al caer el mundo, la joven 
                                Furiosa es arrebatada del Lugar
                                Verde de Muchas Madres y cae en 
                                manos de una gran horda de motoristas
                                liderada por el señor de la guerra Dementus.

                            </p>
                            <a class="btn btn-outline-light py-2 px-2 mt-1 animate__animated animate__fadeInUp btn_comprar_caja" href="#">
                                <img id="comprar_btn" src="img/img_ticket.png" width="60px" height="60px">Comprar
                            </a>
                        </div>
                    </div>
                </div>
                
                
                <div class="carousel-item position-relative" style="min-height: 100vh;">
                    <img class="position-absolute w-100 h-100 img_edit" src="img/img_portada_vaguito.png" style="object-fit: cover;">
                    <div class="carousel-caption d-flex flex-column  justify-content-center">
                        <div class="p-3" style="max-width: 900px;">
                            
                            <h3 class="display-3 text-capitalize  mb-3 text_title_peli">Vaguito</h3>
                            <p class="mx-md-5 px-5 descrip_text">
                                Vaguito, un perro abandonado 
                                es rescatado por Pancho un dirigente 
                                honesto de una asociación pesquera. Pancho 
                                se encuentra enfrentado a una mafia de pescadores
                                y su lucha por impartir justicia desencadenará junto 
                                a Vaguito, una serie de eventos por lo que será víctima de
                                una traición en alta mar. Luego de la traición, Vaguito, fiel 
                                a su amigo se rehusará a abandonar la playa y se quedará a esperar
                                día tras día al amigo del que no pudo despedirse y que yace en las 
                                profundidades del mar.
]
                            </p>
                            <a class="btn btn-outline-light py-2 px-2 mt-1 animate__animated animate__fadeInUp btn_comprar_caja" href="#">
                                <img id="comprar_btn" src="img/img_ticket.png" width="60px" height="60px">Comprar
                            </a>
                        </div>
                    </div>
                </div>
                
                
                
                
                
                
                
                
                
            </div>
        </div>
    </div>
    <!-- Carousel End -->


    
    
    
    
    
    
    
    
    
    
    

    <!-- Info cineStar -->
    <div class="container-fluid py-5">
        <div class="container py-5">
            <div class="row align-items-center">
                <div class="col-lg-6 pb-5 pb-lg-0">
                    <img class="img-fluid w-100" src="img/img_cinestar_tendencia.jpg" alt="">
                </div>
                <div class="col-lg-6">
                    <h6 class="d-inline-block text-primary text-uppercase bg-light py-1 px-2">Dato</h6>
                    <h1 class="mb-4">Cinestar y su demanda creciente en los últimos años</h1>
                    <p class="pl-4 border-left border-primary">
                        Cinestar poco a poco se fue convirtiendo en uno de los mejores cines de todo el Perú.
                        Actualmente, se encuentra como uno de los más demandados por sus buena atención y
                        calidad de servicio. A continuación tenemos las estadísticas en esta última semana:
                    </p>
                    <div class="row pt-3">
                        <div class="col-6">
                            <div class="bg-light text-center p-4">
                                <h3 class="display-4 text-primary" data-toggle="counter-up">99</h3>
                                <h6 class="text-uppercase">Entradas por día</h6>
                            </div>
                        </div>
                        <div class="col-6">
                            <div class="bg-light text-center p-4">
                                <h3 class="display-4 text-primary" data-toggle="counter-up">999</h3>
                                <h6 class="text-uppercase">Clientes felices</h6>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Carrusel de opciones-->
    <div id="regresar_container" ></div>
    <!-- Service Start -->
    <div class="container-fluid px-0 py-5 my-5">
        <div class="row mx-0 justify-content-center text-center">
            <div class="col-lg-6">
                <h6 class="d-inline-block bg-light text-primary text-uppercase py-1 px-2">Destacado</h6>
                <h1>¡No te lo pierdas!</h1>
            </div>
        </div>
        <div class="owl-carousel service-carousel">
            <div class="service-item position-relative">
                <img class="img-fluid" src="img/img_tendencia.jpg" alt="">
                <div class="service-text text-center">
                    <h4 class="text-white font-weight-medium px-3">Tendencia</h4>
                    <p class="text-white px-3 mb-3">
                        Películas más buscadas y pedidas por el público para este mes
                    </p>
                    <div class="w-100 bg-white text-center p-4" >
                        <a class="btn btn-primary" href="#otroContenido" onclick="cargar('<%= request.getContextPath()%>/Vista/PeliIndex.jsp');">Ver</a>
                    </div>
                </div>
            </div>
            <div class="service-item position-relative">
                <img class="img-fluid" src="img/img_sede_mayor.jpg" alt="">
                <div class="service-text text-center">
                    <h4 class="text-white font-weight-medium px-3">Zona popular</h4>
                    <p class="text-white px-3 mb-3">
                        Más del 50% de las personas asiste a esta sede de Cinestar. ¿Quiéres saber
                        de cuál se trata?
                    </p>
                    <div class="w-100 bg-white text-center p-4" >
                        <a class="btn btn-primary" href="#otroContenido" onclick="cargar('<%= request.getContextPath()%>/Vista/ZonaPopular.jsp');">Ver</a>
                    </div>
                </div>
            </div>
            <div class="service-item position-relative">
                <img class="img-fluid" src="img/img_comelona.jpg" alt="">
                <div class="service-text text-center">
                    <h4 class="text-white font-weight-medium px-3">Comelona</h4>
                    <p class="text-white px-3 mb-3">
                        Tenemos los combos más destacados a nivel globa. Descubre cuales son
                    </p>
                    <div class="w-100 bg-white text-center p-4" >
                        <a class="btn btn-primary" href="#Tendencia" onclick="cargar('<%= request.getContextPath()%>/Vista/Comelona.jsp');">Ver</a>
                    </div>
                </div>
            </div>
            <div class="service-item position-relative">
                <img class="img-fluid" src="img/img_combo_oferta.png" alt="">
                <div class="service-text text-center">
                    <h4 class="text-white font-weight-medium px-3">Combos Nuevos</h4>
                    <p class="text-white px-3 mb-3">
                        Oferta limitada
                    </p>
                    <div class="w-100 bg-white text-center p-4" >
                        <a class="btn btn-primary" href="#Pedido" onclick="cargar('<%= request.getContextPath()%>/Vista/Comelona.jsp');">Ver</a>
                    </div>
                </div>
            </div>
            <div class="service-item position-relative">
                <img class="img-fluid" src="img/img_promo.png" alt="">
                <div class="service-text text-center">
                    <h4 class="text-white font-weight-medium px-3">Promo Entel</h4>
                    <p class="text-white px-3 mb-3">
                        Canjea tu código Entel para recibir un descuento 
                    </p>
                    <div class="w-100 bg-white text-center p-4" >
                        <a class="btn btn-primary" href="#otroContenido" onclick="cargar('<%= request.getContextPath()%>/Vista/PlanesIndex.jsp');">Ver</a>
                    </div>
                </div>
            </div>
            <div class="service-item position-relative">
                <img class="img-fluid" src="img/img_regalo.png" alt="">
                <div class="service-text text-center">
                    <h4 class="text-white font-weight-medium px-3">Regalos</h4>
                    <p class="text-white px-3 mb-3">Puedes ganar una entrada gratuita</p>
                    <div class="w-100 bg-white text-center p-4" >
                        <a class="btn btn-primary" href="">Make Order</a>
                    </div>
                </div>
            </div>
        </div>
        
        
        
        
        <div id="otroContenido">
            
            
            
            
        </div>
        
               <script>
                function cargar(archivo) {
                    fetch(archivo)
                        .then(response => response.text())
                        .then(data => {
                            // Crea un contenedor temporal para el contenido HTML
                            let tempDiv = document.createElement('div');
                            tempDiv.innerHTML = data;

                            // Inserta el contenido HTML en el DOM
                            document.getElementById('otroContenido').innerHTML = tempDiv.innerHTML;

                            // Extrae los scripts del contenido HTML
                            let scripts = tempDiv.querySelectorAll('script');

                            // Carga y ejecuta los scripts con src
                            scripts.forEach(script => {
                                if (script.src) {
                                    // Crea un nuevo elemento script con el atributo src
                                    let newScript = document.createElement('script');
                                    newScript.src = script.src;
                                    // Opcional: Puedes añadir un evento onload para manejar cuando el script ha cargado
                                    newScript.onload = () => console.log(`Script cargado: ${script.src}`);
                                    newScript.onerror = () => console.error(`Error al cargar el script: ${script.src}`);
                                    // Añade el nuevo script al head
                                    document.head.appendChild(newScript);
                                }
                            });

                            // Desplaza hacia el contenido cargado
                            document.getElementById('otroContenido').scrollIntoView({ behavior: 'smooth', block: 'start' });
                            const ventanaAltura = window.innerHeight;

                            // Calcula el desplazamiento en píxeles
                            const porcentaje = 0.10;
                            const desplazamientoPixeles = ventanaAltura * porcentaje;

                            // Desplaza la ventana hacia arriba
                            window.scrollBy(0, -desplazamientoPixeles);
                        })
                        .catch(error => console.error('Error al cargar el contenido:', error));
                }
            </script>
            
            
    
    
        
        
        
        
        
        <!--Formulario-->
        <div class="row justify-content-center bg-appointment mx-0 cambio_img">
            <div class="col-lg-6 py-5">
                <div class="p-5 my-5" style="background: rgba(33, 30, 28, 0.7);">
                    <h1 class="text-white text-center mb-4">¿Deseas reservar una película?</h1>
                    <form action="Vista/FormRegistro.jsp" method="post">
                        <div class="form-row">
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <input type="text" class="form-control bg-transparent p-4" placeholder="Tu Nombre" required="required" />
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <input type="text" class="form-control bg-transparent p-4" placeholder="Tu Apellido" required="required" />
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <div class="date" id="date" data-target-input="nearest">
                                        <input type="text" class="form-control bg-transparent p-4 datetimepicker-input" placeholder="Nacimiento" data-target="#date" data-toggle="datetimepicker"/>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <div class="time" id="time" data-target-input="nearest">
                                        <input type="text" class="form-control bg-transparent p-4 datetimepicker-input" placeholder="Hora de Función" data-target="#time" data-toggle="datetimepicker"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <select class="custom-select bg-transparent px-4" style="height: 47px;">
                                        <option selected>Sede</option>
                                        <option value="benavides">Benavides</option>
                                        <option value="breña">Breña</option>
                                        <option value="uni">UNI</option>
                                        <option value="sjl">SJL</option>
                                        <option value="porteño">Porteño</option>
                                        <option value="excelsior">Excelsior</option>
                                        <option value="borja">San Borja</option>
                                        <option value="chorrillos">Chorrillos</option>
                                        <option value="miraflores">Miraflores</option>
                                        <option value="comas">COMAS</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <button class="btn btn-primary btn-block" type="submit" style="height: 47px;">Regístrate</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!-- Service End -->


    <!-- Open Hours Start -->
    <div class="container-fluid py-5">
        <div class="container py-5">
            <div class="row">
                <div class="col-lg-6" style="min-height: 500px;">
                    <div class="position-relative h-100">
                        <img class="position-absolute w-100 h-100" src="img/img_fam.jpg" style="object-fit: cover;">
                    </div>
                </div>
                <div class="col-lg-6 pt-5 pb-lg-5">
                    <div class="hours-text bg-light p-4 p-lg-5 my-lg-5">
                        <h6 class="d-inline-block text-white text-uppercase bg-primary py-1 px-2">Relájate</h6>
                        <h1 class="mb-4">Disfruta Tus fines de semana</h1>
                        <p id="just_hour">
                            Cuando buscas una manera de relajarte y desconectar 
                            del estrés diario, ir al cine Cinestar es una excelente 
                            opción. Al entrar, te envuelves en un ambiente moderno y
                            acogedor que te invita a dejar atrás las preocupaciones. 
                            Las butacas cómodas y reclinables te permiten acomodarte y 
                            disfrutar plenamente de la película. La calidad de imagen y 
                            sonido te ofrece una experiencia inmersiva que te ayudará a 
                            olvidarte de todo lo que te rodea.
                        </p>
                        <ul class="list-inline">
                            <li class="h6 py-1"><i class="far fa-circle text-primary mr-3"></i>Lunes - Viernes : 13:00 PM - 11:00 PM</li>
                            <li class="h6 py-1"><i class="far fa-circle text-primary mr-3"></i>Sábado - Domingo : 11:00 AM - 11:00 PM</li>
                            <li class="h6 py-1"><i class="far fa-circle text-primary mr-3"></i>Feriados: Descuento del 20%</li>
                        </ul>
                        <a href="" class="btn btn-primary mt-2">Book Now</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Open Hours End -->

<!--
     Pricing Start 
    <div class="container-fluid bg-pricing" style="margin: 90px 0;">
        <div class="container">
            <div class="row">
                <div class="col-lg-5" style="min-height: 500px;">
                    <div class="position-relative h-100">
                        <img class="position-absolute w-100 h-100" src="img/pricing.jpg" style="object-fit: cover;">
                    </div>
                </div>
                <div class="col-lg-7 pt-5 pb-lg-5">
                    <div class="pricing-text bg-light p-4 p-lg-5 my-lg-5">
                        <div class="owl-carousel pricing-carousel">
                            <div class="bg-white">
                                <div class="d-flex align-items-center justify-content-between border-bottom border-primary p-4">
                                    <h1 class="display-4 mb-0">
                                        <small class="align-top text-muted font-weight-medium" style="font-size: 22px; line-height: 45px;">$</small>49<small class="align-bottom text-muted font-weight-medium" style="font-size: 16px; line-height: 40px;">/Mo</small>
                                    </h1>
                                    <h5 class="text-primary text-uppercase m-0">Basic Plan</h5>
                                </div>
                                <div class="p-4">
                                    <p><i class="fa fa-check text-success mr-2"></i>Full Body Massage</p>
                                    <p><i class="fa fa-check text-success mr-2"></i>Deep Tissue Massage</p>
                                    <p><i class="fa fa-check text-success mr-2"></i>Hot Stone Massage</p>
                                    <p><i class="fa fa-check text-success mr-2"></i>Tissue Body Polish</p>
                                    <p><i class="fa fa-check text-success mr-2"></i>Foot & Nail Care</p>
                                    <a href="" class="btn btn-primary my-2">Order Now</a>
                                </div>
                            </div>
                            <div class="bg-white">
                                <div class="d-flex align-items-center justify-content-between border-bottom border-primary p-4">
                                    <h1 class="display-4 mb-0">
                                        <small class="align-top text-muted font-weight-medium" style="font-size: 22px; line-height: 45px;">$</small>99<small class="align-bottom text-muted font-weight-medium" style="font-size: 16px; line-height: 40px;">/Mo</small>
                                    </h1>
                                    <h5 class="text-primary text-uppercase m-0">Family Plan</h5>
                                </div>
                                <div class="p-4">
                                    <p><i class="fa fa-check text-success mr-2"></i>Full Body Massage</p>
                                    <p><i class="fa fa-check text-success mr-2"></i>Deep Tissue Massage</p>
                                    <p><i class="fa fa-check text-success mr-2"></i>Hot Stone Massage</p>
                                    <p><i class="fa fa-check text-success mr-2"></i>Tissue Body Polish</p>
                                    <p><i class="fa fa-check text-success mr-2"></i>Foot & Nail Care</p>
                                    <a href="" class="btn btn-primary my-2">Order Now</a>
                                </div>
                            </div>
                            <div class="bg-white">
                                <div class="d-flex align-items-center justify-content-between border-bottom border-primary p-4">
                                    <h1 class="display-4 mb-0">
                                        <small class="align-top text-muted font-weight-medium" style="font-size: 22px; line-height: 45px;">$</small>149<small class="align-bottom text-muted font-weight-medium" style="font-size: 16px; line-height: 40px;">/Mo</small>
                                    </h1>
                                    <h5 class="text-primary text-uppercase m-0">VIP Plan</h5>
                                </div>
                                <div class="p-4">
                                    <p><i class="fa fa-check text-success mr-2"></i>Full Body Massage</p>
                                    <p><i class="fa fa-check text-success mr-2"></i>Deep Tissue Massage</p>
                                    <p><i class="fa fa-check text-success mr-2"></i>Hot Stone Massage</p>
                                    <p><i class="fa fa-check text-success mr-2"></i>Tissue Body Polish</p>
                                    <p><i class="fa fa-check text-success mr-2"></i>Foot & Nail Care</p>
                                    <a href="" class="btn btn-primary my-2">Order Now</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
     Pricing End -->


    <!-- Team Start -->
    <div class="container-fluid py-5">
        <div class="container pt-5">
            <div class="row justify-content-center text-center">
                <div class="col-lg-6">
                    <h6 class="d-inline-block bg-light text-primary text-uppercase py-1 px-2">CUMPLE TUS SUEÑOS</h6>
                    <h1 class="mb-5">CINESTAR EJECUTIVOS</h1>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-3 col-md-6">
                    <div class="team position-relative overflow-hidden mb-5">
                        <img class="img-fluid" src="img/team-1.jpg" alt="">
                        <div class="position-relative text-center">
                            <div class="team-text bg-primary text-white">
                                <h5 class="text-white text-uppercase">JEFFERSON PERNIA</h5>
                                <p class="m-0">Ing. Sistemas</p>
                            </div>
                            <div class="team-social bg-dark text-center">
                                <a class="btn btn-outline-primary btn-square mr-2" href="#"><i class="fab fa-twitter"></i></a>
                                <a class="btn btn-outline-primary btn-square mr-2" href="#"><i class="fab fa-facebook-f"></i></a>
                                <a class="btn btn-outline-primary btn-square mr-2" href="#"><i class="fab fa-linkedin-in"></i></a>
                                <a class="btn btn-outline-primary btn-square" href="#"><i class="fab fa-instagram"></i></a>
                            </div>
                        </div>
                    </div>
                </div>
                
                <div class="col-lg-3 col-md-6">
                    <div class="team position-relative overflow-hidden mb-5">
                        <img class="img-fluid" src="img/team-3.jpg" alt="">
                        <div class="position-relative text-center">
                            <div class="team-text bg-primary text-white">
                                <h5 class="text-white text-uppercase">EIMY CAPTCHA</h5>
                                <p class="m-0">Ing. Sistemas</p>
                            </div>
                            <div class="team-social bg-dark text-center">
                                <a class="btn btn-outline-primary btn-square mr-2" href="#"><i class="fab fa-twitter"></i></a>
                                <a class="btn btn-outline-primary btn-square mr-2" href="#"><i class="fab fa-facebook-f"></i></a>
                                <a class="btn btn-outline-primary btn-square mr-2" href="#"><i class="fab fa-linkedin-in"></i></a>
                                <a class="btn btn-outline-primary btn-square" href="#"><i class="fab fa-instagram"></i></a>
                            </div>
                        </div>
                    </div>
                </div>
                
                
                <div class="col-lg-3 col-md-6">
                    <div class="team position-relative overflow-hidden mb-5">
                        <img class="img-fluid" src="img/team-2.jpg" alt="">
                        <div class="position-relative text-center">
                            <div class="team-text bg-primary text-white">
                                <h5 class="text-white text-uppercase">KIARA SANTTI</h5>
                                <p class="m-0">Ing. Software</p>
                            </div>
                            <div class="team-social bg-dark text-center">
                                <a class="btn btn-outline-primary btn-square mr-2" href="#"><i class="fab fa-twitter"></i></a>
                                <a class="btn btn-outline-primary btn-square mr-2" href="#"><i class="fab fa-facebook-f"></i></a>
                                <a class="btn btn-outline-primary btn-square mr-2" href="#"><i class="fab fa-linkedin-in"></i></a>
                                <a class="btn btn-outline-primary btn-square" href="#"><i class="fab fa-instagram"></i></a>
                            </div>
                        </div>
                    </div>
                </div>
                
                <div class="col-lg-3 col-md-6">
                    <div class="team position-relative overflow-hidden mb-5">
                        <img class="img-fluid" src="img/team-4.jpg" alt="">
                        <div class="position-relative text-center">
                            <div class="team-text bg-primary text-white">
                                <h5 class="text-white text-uppercase">JOAQUÍN LOA</h5>
                                <p class="m-0">Ing. Software</p>
                            </div>
                            <div class="team-social bg-dark text-center">
                                <a class="btn btn-outline-primary btn-square mr-2" href="#"><i class="fab fa-twitter"></i></a>
                                <a class="btn btn-outline-primary btn-square mr-2" href="#"><i class="fab fa-facebook-f"></i></a>
                                <a class="btn btn-outline-primary btn-square mr-2" href="#"><i class="fab fa-linkedin-in"></i></a>
                                <a class="btn btn-outline-primary btn-square" href="#"><i class="fab fa-instagram"></i></a>
                            </div>
                        </div>
                    </div>
                </div>
                
                <div class="col-lg-3 col-md-6">
                    <div class="team position-relative overflow-hidden mb-5">
                        <img class="img-fluid" src="img/team-5.jpg" alt="">
                        <div class="position-relative text-center">
                            <div class="team-text bg-primary text-white">
                                <h5 class="text-white text-uppercase">RAÚL SOCOALAYA</h5>
                                <p class="m-0">Ing. Software</p>
                            </div>
                            <div class="team-social bg-dark text-center">
                                <a class="btn btn-outline-primary btn-square mr-2" href="#"><i class="fab fa-twitter"></i></a>
                                <a class="btn btn-outline-primary btn-square mr-2" href="#"><i class="fab fa-facebook-f"></i></a>
                                <a class="btn btn-outline-primary btn-square mr-2" href="#"><i class="fab fa-linkedin-in"></i></a>
                                <a class="btn btn-outline-primary btn-square" href="#"><i class="fab fa-instagram"></i></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Team End -->


    <!-- Testimonial Start -->
    <div class="container-fluid py-5">
        <div class="container py-5">
            <div class="row align-items-center">
                <div class="col-lg-6 pb-5 pb-lg-0">
                    <img class="img-fluid w-100" src="img/img_comentarios.jpg" alt="">
                </div>
                <div class="col-lg-6">
                    <h6 class="d-inline-block text-primary text-uppercase bg-light py-1 px-2">Comentarios</h6>
                    <h1 class="mb-4">¿Qué opinan nuestros clientes CINESTARES?</h1>
                    <div class="owl-carousel testimonial-carousel">
                        <div class="position-relative">
                            <i class="fa fa-3x fa-quote-right text-primary position-absolute" style="top: -6px; right: 0;"></i>
                            <div class="d-flex align-items-center mb-3">
                                <img class="img-fluid rounded-circle" src="img/img_cr7.png" style="width: 60px; height: 60px;" alt="">
                                <div class="ml-3">
                                    <h6 class="text-uppercase">Cristiano Ronaldo</h6>
                                    <span>Futbolista profesional</span>
                                </div>
                            </div>
                            <p class="m-0">
                                Los estrenos suelen tener un gran despliegue, 
                                y siempre puedo contar con una buena selección de
                                películas tanto comerciales como independientes. 
                                Sin duda, es mi lugar favorito para disfrutar de una buena película.
                            </p>
                        </div>
                        <div class="position-relative">
                            <i class="fa fa-3x fa-quote-right text-primary position-absolute" style="top: -6px; right: 0;"></i>
                            <div class="d-flex align-items-center mb-3">
                                <img class="img-fluid rounded-circle" src="img/img_ruigood.png" style="width: 60px; height: 60px;" alt="">
                                <div class="ml-3">
                                    <h6 class="text-uppercase">Raúl Ruidiaz</h6>
                                    <span>Cómico</span>
                                </div>
                            </div>
                            <p class="m-0">
                                Desde que descubrí este lugar, no he querido ver películas en ningún otro sitio.
                                La primera vez que fui, me impresionó la calidad de la proyección y el sonido. 
                            </p>
                        </div>
                        <div class="position-relative">
                            <i class="fa fa-3x fa-quote-right text-primary position-absolute" style="top: -6px; right: 0;"></i>
                            <div class="d-flex align-items-center mb-3">
                                <img class="img-fluid rounded-circle" src="img/testimonial-3.jpg" style="width: 60px; height: 60px;" alt="">
                                <div class="ml-3">
                                    <h6 class="text-uppercase">Gian Franco Granda</h6>
                                    <span>Estudiante</span>
                                </div>
                            </div>
                            <p class="m-0">
                                Cuando voy al Cine Aurora, siento que estoy en el 
                                lugar perfecto para disfrutar de una película. Este 
                                cine siempre ha sido mi primera opción, no solo por 
                                la calidad de sus proyecciones y el sonido envolvente,
                                sino también por la atmósfera única que ofrece.
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Testimonial End -->


    <!-- Pie de página -->
    <div class="footer container-fluid position-relative bg-dark py-5" style="margin-top: 90px;">
        <div class="container pt-5">
            <div class="row">
                <div class="col-lg-6 pr-lg-5 mb-5">
                    <a href="Main.jsp" class="navbar-brand">
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
                                <a class="text-white-50 mb-2" href="Main.jsp"><i class="fa fa-angle-right mr-2"></i>Home</a>
                                <a class="text-white-50 mb-2" href="Vista/PeliculasGeneral.jsp?tipoc=Cartelera"><i class="fa fa-angle-right mr-2"></i>Cartelera</a>
                                <a class="text-white-50 mb-2" href="PeliculasGeneral.jsp?tipoc=Estreno"><i class="fa fa-angle-right mr-2"></i>Estrenos</a>
                                <a class="text-white-50 mb-2" href="Vista/PeliculasGeneral.jsp?tipoc=Combos"><i class="fa fa-angle-right mr-2"></i>Combos</a>
                                <a class="text-white-50" href="Vista/contact.jsp"><i class="fa fa-angle-right mr-2"></i>Contacto</a>
                            </div>
                        </div>
                        <div class="col-sm-6 mb-5">
                            <h5 class="text-white text-uppercase mb-4">General</h5>
                            <div class="d-flex flex-column justify-content-start">
                                <a class="text-white-50 mb-2" href="Vista/contact.jsp?openModal=true"><i class="fa fa-angle-right mr-2"></i>Sedes</a>
                                <a class="text-white-50 mb-2" href="Vista/FormSugerencia.jsp"><i class="fa fa-angle-right mr-2"></i>Sugerencias</a>
                                <a class="text-white-50 mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Nosotros</a>
                                <a class="text-white-50 mb-2" href="ControladorLibroReclamaciones"><i class="fa fa-angle-right mr-2"></i>Libro de Reclamaciones</a>
                                <a class="text-white-50" href="ControladorPreguntasFrecuentes"><i class="fa fa-angle-right mr-2"></i>Preguntas</a>
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
    <script src="lib/easing/easing.min.js"></script>
    <script src="lib/waypoints/waypoints.min.js"></script>
    <script src="lib/counterup/counterup.min.js"></script>
    <script src="lib/owlcarousel/owl.carousel.min.js"></script>
    <script src="lib/tempusdominus/js/moment.min.js"></script>
    <script src="lib/tempusdominus/js/moment-timezone.min.js"></script>
    <script src="lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

    <!-- Contact Javascript File -->
    <script src="mail/jqBootstrapValidation.min.js"></script>
    <script src="mail/contact.js"></script>

    <!-- Template Javascript -->
    <script src="js/main.js"></script>
    <script src="js/index.js"></script>
    
    
    
    <script src="js/jquery-3.2.1.min.js"></script>
    
    
    <!-- ALL PLUGINS -->
    <script src="js/jquery.superslides.min.js"></script>
    
    
    
    
    
    
    
    
    
    <script src="<%= request.getContextPath()%>/js/custom.js"></script>
    
</body>

</html>