<%-- 
    Document   : Index
    Created on : 12 oct. 2024, 11:24:27
    Author     : JEFFERSON
--%>
<%@page import="Modelo.Login"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page session="true" %>
<%
    Login us = (Login) (session != null && session.getAttribute("usuario") != null ? session.getAttribute("usuario") : null);

%>

<%    if (session != null && session.getAttribute("usuario") == null) {
        response.sendRedirect("../Vista/Login.jsp");
    } else if (session != null && session.getAttribute("usuario") != null && session.getAttribute("rol") != null) {
        if (!session.getAttribute("rol").equals("Administrador")) {
            response.sendRedirect("../index.jsp");
        }
    }
%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    </head>

    <body>


        <%@include file="CabeceraAdm.jsp" %>
        <div class="wrapper">
            <nav id="sidebar" class="sidebar js-sidebar">
                <div class="sidebar-content js-simplebar">
                    <a class="sidebar-brand" href="<%= request.getContextPath()%>/VistaAdministrador/AdmUsuarios.jsp">

                        <div class="mb-2 center_text">
                            <i class="align-middle me-2" data-feather="github"></i>
                            <span class="align-middle">Administrador
                            </span>
                        </div>


                    </a>


                    <!--BARRA NEGRA IZQUIERDA, MANTENIMIENTO-->
                    <ul class="sidebar-nav">
                        <li class="sidebar-header">Páginas</li>

                        <!--Primer Slider-->
                        <li class="sidebar-item">


                            <a class="sidebar-link" href="#"
                               data-bs-toggle="collapse" data-bs-target="#dashboard-submenu" aria-expanded="false">
                                <i class="align-middle me-2" data-feather="user-check"></i>
                                <span class="align-middle">Usuarios</span>
                            </a>



                            <ul class="collapse show" id="dashboard-submenu">
                                <li class="nav-item <%= "AdministradorUsuarios".equals(request.getAttribute("estados_contralador")) ? "sidebar-item active" : ""%>
                                    ">
                                    <a id="AdministradorUsuarios" href="" class="sidebar-link" onclick="cargar('<%= request.getContextPath()%>/VistaAdministrador/AUsuarios.jsp');">

                                        <span class="align-middle">Administrar Empleados</span>
                                    </a>
                                </li>
                                <li class="nav-item <%= "AdministradorClientes".equals(request.getAttribute("estados_contralador")) ? "sidebar-item active" : ""%>
                                    ">
                                    <a id="AdministradorClientes" href="" class="sidebar-link" onclick="cargar('<%= request.getContextPath()%>/VistaAdministrador/AClientes.jsp');">

                                        <span class="align-middle">Administrar Clientes</span>
                                    </a>
                                </li>
                            </ul>
                        </li>

                        <!--PELICULAS-->
                        <li class="sidebar-item">


                            <a class="sidebar-link" href="#"
                               data-bs-toggle="collapse" data-bs-target="#dashboard-submenu2" aria-expanded="false">
                                <i class="align-middle me-2" data-feather="monitor"></i>
                                <span class="align-middle">Películas</span>
                            </a>



                            <ul class="collapse" id="dashboard-submenu2">
                                <li class="nav-item">
                                    <a href="" class="sidebar-link" onclick="cargar('<%= request.getContextPath()%>/VistaAdministrador/APeliculas.jsp');">

                                        <span class="align-middle">Administrar Películas</span>
                                    </a>
                                </li>
                                <li class="nav-item">
                                    <a href="" class="sidebar-link" onclick="cargar('<%= request.getContextPath()%>/VistaAdministrador/ADetallePelicula.jsp');">

                                        <span class="align-middle">Administrar Detalles</span>
                                    </a>
                                </li>
                            </ul>

                        </li>


                        <!--COMBOS-->

                        <li class="sidebar-item">


                            <a class="sidebar-link" href="#"
                               data-bs-toggle="collapse" data-bs-target="#dashboard-submenu3" aria-expanded="false">
                                <i class="align-middle me-2" data-feather="package"></i>
                                <span class="align-middle">Combos</span>
                            </a>



                            <ul class="collapse" id="dashboard-submenu3">
                                <li class="nav-item <%= "AdministradorCombos".equals(request.getAttribute("estados_contralador")) ? "sidebar-item active" : ""%>">
                                    <a href="" class="sidebar-link" onclick="cargar('<%= request.getContextPath()%>/VistaAdministrador/ACombos.jsp');">

                                        <span class="align-middle">Administrar Combos</span>
                                    </a>
                                </li>
                                <li class="nav-item <%= "AdministrarDetallesCombos".equals(request.getAttribute("estados_contralador")) ? "sidebar-item active" : ""%>">
                                    <a href="" class="sidebar-link" onclick="cargar('<%= request.getContextPath()%>/VistaAdministrador/ADetalleCombo.jsp');">

                                        <span class="align-middle">Administrar detalles</span>
                                    </a>
                                </li>
                            </ul>
                        </li>


                        <!--PROMOS-->
                        <li class="sidebar-item">


                            <a class="sidebar-link" href="#"
                               data-bs-toggle="collapse" data-bs-target="#dashboard-submenu4" aria-expanded="false">
                                <i class="align-middle" data-feather="sliders"></i>
                                <span class="align-middle">Reservaciones</span>
                            </a>



                            <ul class="collapse" id="dashboard-submenu4">
                                <li class="nav-item">
                                    <a href="" onclick="cargar('<%= request.getContextPath()%>/VistaAdministrador/AReservaciones.jsp');" class="sidebar-link">

                                        <span class="align-middle">Administrar Pagos</span>
                                    </a>
                                </li>
                                <li class="nav-item">
                                    <a href="" onclick="cargar('<%= request.getContextPath()%>/VistaAdministrador/ADetallePeliculaReserva.jsp');" class="sidebar-link">

                                        <span class="align-middle">Administrar detalles Pelicula</span>
                                    </a>
                                </li>

                                <li class="nav-item">
                                    <a href="" onclick="cargar('<%= request.getContextPath()%>/VistaAdministrador/ADetalleComboReserva.jsp');" class="sidebar-link">

                                        <span class="align-middle">Administrar detalles Combos</span>
                                    </a>
                                </li>

                                <li class="nav-item">
                                    <a href="" onclick="cargar('<%= request.getContextPath()%>/VistaAdministrador/ADetalleBebidaReserva.jsp');" class="sidebar-link">

                                        <span class="align-middle">Administrar detalles Bebidas</span>
                                    </a>
                                </li>


                                <li class="nav-item">
                                    <a href="" onclick="cargar('<%= request.getContextPath()%>/VistaAdministrador/ADetalleDulceriaReserva.jsp');" class="sidebar-link">

                                        <span class="align-middle">Administrar detalles Dulceria</span>
                                    </a>
                                </li>
                            </ul>
                        </li>





                        <li class="sidebar-item">


                            <a class="sidebar-link" href="#"
                               data-bs-toggle="collapse" data-bs-target="#dashboard-submenu5" aria-expanded="false">
                                <i class="align-middle me-2" data-feather="user"></i>
                                <span class="align-middle">Asientos</span>
                            </a>



                            <ul class="collapse" id="dashboard-submenu5">
                                <li class="nav-item <%= "AdministradorCombos".equals(request.getAttribute("estados_contralador")) ? "sidebar-item active" : ""%>">
                                    <a href="" class="sidebar-link" onclick="cargar('<%= request.getContextPath()%>/VistaAdministrador/ACombos.jsp');">

                                        <span class="align-middle">Administrar Perfil</span>
                                    </a>
                                </li>
                                <li class="nav-item <%= "AdministrarDetallesCombos".equals(request.getAttribute("estados_contralador")) ? "sidebar-item active" : ""%>">
                                    <a href="" class="sidebar-link" onclick="cargar('<%= request.getContextPath()%>/VistaAdministrador/AAsientos.jsp');">

                                        <span class="align-middle">Administrar Asientos</span>
                                    </a>
                                </li>
                            </ul>
                        </li>


                    </ul>



                </div>
            </nav>

            <div class="main">
                <nav class="navbar navbar-expand navbar-light navbar-bg navar_informacion">
                    <a class="sidebar-toggle js-sidebar-toggle">
                        <i class="hamburger align-self-center"></i>
                    </a>

                    <div class="navbar-collapse collapse">
                        <ul class="navbar-nav navbar-align">
                            <li class="nav-item dropdown">
                                <a class="nav-icon dropdown-toggle" href="#" id="alertsDropdown" data-bs-toggle="dropdown">
                                    <div class="position-relative">
                                        <i class="align-middle" data-feather="bell"></i>
                                        <span class="indicator">4</span>
                                    </div>
                                </a>
                                <div class="dropdown-menu dropdown-menu-lg dropdown-menu-end py-0" aria-labelledby="alertsDropdown">
                                    <div class="dropdown-menu-header">
                                        4 notificaciones nuevas
                                    </div>
                                    <div class="list-group">
                                        <a href="#" class="list-group-item">
                                            <div class="row g-0 align-items-center">
                                                <div class="col-2">
                                                    <i class="text-danger" data-feather="alert-circle"></i>
                                                </div>
                                                <div class="col-10">
                                                    <div class="text-dark">Completa la actualización</div>
                                                    <div class="text-muted small mt-1">Actualiza tus datos.</div>
                                                    <div class="text-muted small mt-1">30m ago</div>
                                                </div>
                                            </div>
                                        </a>
                                        <a href="#" class="list-group-item">
                                            <div class="row g-0 align-items-center">
                                                <div class="col-2">
                                                    <i class="text-warning" data-feather="bell"></i>
                                                </div>
                                                <div class="col-10">
                                                    <div class="text-dark">Nuevo</div>
                                                    <div class="text-muted small mt-1">Evento de programadores.</div>
                                                    <div class="text-muted small mt-1">2h ago</div>
                                                </div>
                                            </div>
                                        </a>
                                        <a href="#" class="list-group-item">
                                            <div class="row g-0 align-items-center">
                                                <div class="col-2">
                                                    <i class="text-primary" data-feather="home"></i>
                                                </div>
                                                <div class="col-10">
                                                    <div class="text-dark">Nuevo Inicio de sesión 192.186.1.8</div>
                                                    <div class="text-muted small mt-1">5h ago</div>
                                                </div>
                                            </div>
                                        </a>
                                        <a href="#" class="list-group-item">
                                            <div class="row g-0 align-items-center">
                                                <div class="col-2">
                                                    <i class="text-success" data-feather="user-plus"></i>
                                                </div>
                                                <div class="col-10">
                                                    <div class="text-dark">New connection</div>
                                                    <div class="text-muted small mt-1">Christina aceptó tu solicitud.</div>
                                                    <div class="text-muted small mt-1">14h ago</div>
                                                </div>
                                            </div>
                                        </a>
                                    </div>
                                    <div class="dropdown-menu-footer">
                                        <a href="#" class="text-muted">Notificaciones</a>
                                    </div>
                                </div>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-icon dropdown-toggle" href="#" id="messagesDropdown" data-bs-toggle="dropdown">
                                    <div class="position-relative">
                                        <i class="align-middle" data-feather="message-square"></i>
                                    </div>
                                </a>
                                <div class="dropdown-menu dropdown-menu-lg dropdown-menu-end py-0" aria-labelledby="messagesDropdown">
                                    <div class="dropdown-menu-header">
                                        <div class="position-relative">
                                            4 New Messages
                                        </div>
                                    </div>
                                    <div class="list-group">
                                        <a href="#" class="list-group-item">
                                            <div class="row g-0 align-items-center">
                                                <div class="col-2">
                                                    <img src="<%= request.getContextPath()%>/img/avatar-5.jpg" class="avatar img-fluid rounded-circle" alt="Vanessa Tucker">
                                                </div>
                                                <div class="col-10 ps-2">
                                                    <div class="text-dark">Vanessa Tucker</div>
                                                    <div class="text-muted small mt-1">Hola.</div>
                                                    <div class="text-muted small mt-1">15m ago</div>
                                                </div>
                                            </div>
                                        </a>
                                        <a href="#" class="list-group-item">
                                            <div class="row g-0 align-items-center">
                                                <div class="col-2">
                                                    <img src="<%= request.getContextPath()%>/img/avatar-2.jpg" class="avatar img-fluid rounded-circle" alt="William Harris">
                                                </div>
                                                <div class="col-10 ps-2">
                                                    <div class="text-dark">William Harris</div>
                                                    <div class="text-muted small mt-1">¿Qué decías?.</div>
                                                    <div class="text-muted small mt-1">2h ago</div>
                                                </div>
                                            </div>
                                        </a>
                                        <a href="#" class="list-group-item">
                                            <div class="row g-0 align-items-center">
                                                <div class="col-2">
                                                    <img src="<%= request.getContextPath()%>/img/avatar-4.jpg" class="avatar img-fluid rounded-circle" alt="Christina Mason">
                                                </div>
                                                <div class="col-10 ps-2">
                                                    <div class="text-dark">Christina Mason</div>
                                                    <div class="text-muted small mt-1">Claro.</div>
                                                    <div class="text-muted small mt-1">4h ago</div>
                                                </div>
                                            </div>
                                        </a>
                                        <a href="#" class="list-group-item">
                                            <div class="row g-0 align-items-center">
                                                <div class="col-2">
                                                    <img src="<%= request.getContextPath()%>/img/avatar-3.jpg" class="avatar img-fluid rounded-circle" alt="Sharon Lessman">
                                                </div>
                                                <div class="col-10 ps-2">
                                                    <div class="text-dark">Sharon Lessman</div>
                                                    <div class="text-muted small mt-1">Trabajo ahí.</div>
                                                    <div class="text-muted small mt-1">5h ago</div>
                                                </div>
                                            </div>
                                        </a>
                                    </div>
                                    <div class="dropdown-menu-footer">
                                        <a href="#" class="text-muted">Show all messages</a>
                                    </div>
                                </div>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-icon dropdown-toggle d-inline-block d-sm-none" href="#" data-bs-toggle="dropdown">
                                    <i class="align-middle" data-feather="settings"></i>
                                </a>

                                <a class="nav-link dropdown-toggle d-none d-sm-inline-block" href="#" data-bs-toggle="dropdown">
                                    <img src="<%= request.getContextPath()%>/img/avatar.jpg" class="avatar img-fluid rounded me-1" alt="Jefferson Anonimo4" /> <span class="text-dark">
                                        <%= (us != null) ? "" + us.getNombres() + " " + us.getApellidos() : "Login"%>
                                    </span>
                                </a>
                                <div class="dropdown-menu dropdown-menu-end">
                                    <a class="dropdown-item" href="<%= request.getContextPath()%>/VistaAdministrador/AdmUsuarios.jsp"><i class="align-middle me-1" data-feather="user"></i> Perfil</a>
                                    <a class="dropdown-item" href="#"><i class="align-middle me-1" data-feather="pie-chart"></i> Alánisis</a>
                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item" href="index.html"><i class="align-middle me-1" data-feather="settings"></i> Configuración</a>
                                    <a class="dropdown-item" href="#"><i class="align-middle me-1" data-feather="help-circle"></i>Ayuda</a>
                                    <div class="dropdown-divider"></div>
                                    <a id="salir_button" class="dropdown-item" href="Main.jsp">Salir</a>
                                </div>
                            </li>
                        </ul>
                    </div>
                </nav>



                <div class="app-content-header bg-dark app_container">
                    <div class="container-fluid containt_title">
                        <div class="row">
                            <div class="col-sm-6">
                                <span class="align-middle peli_align_text">Configuración</span>
                            </div>
                            <div class="col-sm-6">
                                <ol class="breadcrumb float-sm-end">
                                    <li class="breadcrumb-item li_item_edit"><a href="#">Home </a>
                                    </li>
                                    <i class="align-middle me-2 star_edie" data-feather="star"></i>
                                    <li class="breadcrumb-item active edit_li" aria-current="page">
                                        Configuración
                                    </li>
                                </ol>
                            </div>
                        </div>
                    </div>
                </div>


                <main class="content">


                    <div id="otroContenido" class="container-fluid p-0">

                        <div class="row">
                            <div class="col-md-4 col-xl-3">
                                <div class="card mb-3">
                                    <div class="card-header">
                                        <h5 class="card-title mb-0">Detalles del Perfil</h5>
                                    </div>
                                    <div class="card-body text-center">
                                        <img src="<%= request.getContextPath()%>/img/team-1.jpg" alt="" class="img-fluid rounded-circle mb-2" width="128" height="128" />
                                        <h5 class="card-title mb-0"><%= (us != null) ? "" + us.getNombres() + " " + us.getApellidos() : ""%></h5>
                                        <div class="text-muted mb-2">Desarrollador Principal</div>

                                        <div>
                                            <a class="btn btn-primary btn-sm" href="#">Seguir</a>
                                            <a class="btn btn-primary btn-sm" href="#"><span data-feather="message-square"></span> Mensaje</a>
                                        </div>
                                    </div>
                                    <hr class="my-0" />
                                    <div class="card-body">
                                        <h5 class="h6 card-title">Habilidades</h5>
                                        <a href="#" class="badge bg-primary me-1 my-1">HTML</a>
                                        <a href="#" class="badge bg-primary me-1 my-1">JavaScript</a>
                                        <a href="#" class="badge bg-primary me-1 my-1">Sass</a>
                                        <a href="#" class="badge bg-primary me-1 my-1">Angular</a>
                                        <a href="#" class="badge bg-primary me-1 my-1">Vue</a>
                                        <a href="#" class="badge bg-primary me-1 my-1">React</a>
                                        <a href="#" class="badge bg-primary me-1 my-1">Redux</a>
                                        <a href="#" class="badge bg-primary me-1 my-1">UI</a>
                                        <a href="#" class="badge bg-primary me-1 my-1">UX</a>
                                    </div>
                                    <hr class="my-0" />
                                    <div class="card-body">
                                        <h5 class="h6 card-title">Acerca de</h5>
                                        <ul class="list-unstyled mb-0">
                                            <li class="mb-1"><span data-feather="home" class="feather-sm me-1"></span> Vivo en <a href="#"><%= (us != null) ? "" + us.getDomicilio() : ""%></a></li>
                                            <li class="mb-1"><span data-feather="phone" class="feather-sm me-1"></span> Teléfono <a href="#"><%= (us != null) ? "" + us.getTelefono() : ""%></a></li>
                                            <li class="mb-1"><span data-feather="link" class="feather-sm me-1"></span> Correo Contacto <a href="#"><%= (us != null) ? "" + us.getCorreo() : ""%></a></li>
                                            <li class="mb-1"><span data-feather="briefcase" class="feather-sm me-1"></span> Trabaja en <a href="#">GitHub</a></li>
                                            <li class="mb-1"><span data-feather="map-pin" class="feather-sm me-1"></span> De <a href="#">Boston</a></li>
                                        </ul>
                                    </div>
                                    <hr class="my-0" />
                                    <div class="card-body">
                                        <h5 class="h6 card-title">En otros lugares</h5>
                                        <ul class="list-unstyled mb-0">
                                            <li class="mb-1"><a href="#">staciehall.co</a></li>
                                            <li class="mb-1"><a href="#">Twitter</a></li>
                                            <li class="mb-1"><a href="#">Facebook</a></li>
                                            <li class="mb-1"><a href="#">Instagram</a></li>
                                            <li class="mb-1"><a href="#">LinkedIn</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>

                            <div class="col-md-8 col-xl-9">
                                <div class="card">
                                    <div class="card-header">
                                        <h5 class="card-title mb-0">Actividades</h5>
                                    </div>
                                    <div class="card-body h-100">

                                        <div class="d-flex align-items-start">
                                            <img src="<%= request.getContextPath()%>/img/avatar-5.jpg" width="36" height="36" class="rounded-circle me-2" alt="Vanessa Tucker">
                                            <div class="flex-grow-1">
                                                <small class="float-end text-navy">Hace 5m</small>
                                                <strong>Vanessa Tucker</strong> comenzó a seguir a <strong>Christina Mason</strong><br />
                                                <small class="text-muted">Hoy 7:51 pm</small><br />
                                            </div>
                                        </div>

                                        <hr />
                                        <div class="d-flex align-items-start">
                                            <img src="<%= request.getContextPath()%>/img/avatar.jpg" width="36" height="36" class="rounded-circle me-2" alt="Charles Hall">
                                            <div class="flex-grow-1">
                                                <small class="float-end text-navy">Hace 30m</small>
                                                <strong>Charles Hall</strong> publicó algo en la línea de tiempo de <strong>Christina Mason</strong><br />
                                                <small class="text-muted">Hoy 7:21 pm</small>

                                                <div class="border text-sm text-muted p-2 mt-1">
                                                    Me gustan las ratas
                                                </div>

                                                <a href="#" class="btn btn-sm btn-danger mt-1"><i class="feather-sm" data-feather="heart"></i> Me gusta</a>
                                            </div>
                                        </div>

                                        <hr />
                                        <div class="d-flex align-items-start">
                                            <img src="<%= request.getContextPath()%>/img/avatar-4.jpg" width="36" height="36" class="rounded-circle me-2" alt="Christina Mason">
                                            <div class="flex-grow-1">
                                                <small class="float-end text-navy">Hace 1h</small>
                                                <strong>Christina Mason</strong> publicó un nuevo blog<br />

                                                <small class="text-muted">Hoy 6:35 pm</small>
                                            </div>
                                        </div>

                                        <hr />
                                        <div class="d-flex align-items-start">
                                            <img src="<%= request.getContextPath()%>/img/avatar-2.jpg" width="36" height="36" class="rounded-circle me-2" alt="William Harris">
                                            <div class="flex-grow-1">
                                                <small class="float-end text-navy">Hace 3h</small>
                                                <strong>William Harris</strong> publicó dos fotos en la línea de tiempo de <strong>Christina Mason</strong><br />
                                                <small class="text-muted">Hoy 5:12 pm</small>

                                                <div class="row g-0 mt-1">
                                                    <div class="col-6 col-md-4 col-lg-4 col-xl-3">
                                                        <img src="<%= request.getContextPath()%>/img/unsplash-1.jpg" class="img-fluid pe-2" alt="Unsplash">
                                                    </div>
                                                    <div class="col-6 col-md-4 col-lg-4 col-xl-3">
                                                        <img src="<%= request.getContextPath()%>/img/unsplash-2.jpg" class="img-fluid pe-2" alt="Unsplash">
                                                    </div>
                                                </div>

                                                <a href="#" class="btn btn-sm btn-danger mt-1"><i class="feather-sm" data-feather="heart"></i> Me gusta</a>
                                            </div>
                                        </div>

                                        <hr />
                                        <div class="d-flex align-items-start">
                                            <img src="<%= request.getContextPath()%>/img/avatar-2.jpg" width="36" height="36" class="rounded-circle me-2" alt="William Harris">
                                            <div class="flex-grow-1">
                                                <small class="float-end text-navy">Hace 1d</small>
                                                <strong>William Harris</strong> comenzó a seguir a <strong>Christina Mason</strong><br />
                                                <small class="text-muted">Ayer 3:12 pm</small>

                                                <div class="d-flex align-items-start mt-1">
                                                    <a class="pe-3" href="#">
                                                        <img src="<%= request.getContextPath()%>/img/avatar-4.jpg" width="36" height="36" class="rounded-circle me-2" alt="Christina Mason">
                                                    </a>
                                                    <div class="flex-grow-1">
                                                        <div class="border text-sm text-muted p-2 mt-1">
                                                            Soy de España
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <hr />
                                        <div class="d-flex align-items-start">
                                            <img src="<%= request.getContextPath()%>/img/avatar-4.jpg" width="36" height="36" class="rounded-circle me-2" alt="Christina Mason">
                                            <div class="flex-grow-1">
                                                <small class="float-end text-navy">Hace 1d</small>
                                                <strong>Christina Mason</strong> publicó un nuevo blog<br />
                                                <small class="text-muted">Ayer 2:43 pm</small>
                                            </div>
                                        </div>

                                        <hr />
                                        <div class="d-flex align-items-start">
                                            <img src="<%= request.getContextPath()%>/img/avatar.jpg" width="36" height="36" class="rounded-circle me-2" alt="Charles Hall">
                                            <div class="flex-grow-1">
                                                <small class="float-end text-navy">Hace 1d</small>
                                                <strong>Charles Hall</strong> comenzó a seguir a <strong>Christina Mason</strong><br />
                                                <small class="text-muted">Ayer 1:51 pm</small>
                                            </div>
                                        </div>

                                        <hr />
                                        <div class="d-grid">
                                            <a href="#" class="btn btn-primary">Cargar más</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                </main>


                <footer class="footer">
                    <div class="container-fluid">
                        <div class="row text-muted">
                            <div class="col-6 text-start">

                                <!--end::To the end--> <!--begin::Copyright--> <strong>
                                    Copyright &copy; 2024-2024&nbsp;
                                    <a href="https://adminlte.io" class="text-decoration-none">GRUPO.UTP</a>.
                                </strong>


                            </div>









                            <div class="col-6 text-end">
                                <ul class="list-inline">
                                    <li class="list-inline-item">
                                        <a class="text-muted" href="https://adminkit.io/" target="_blank">Soporte</a>
                                    </li>
                                    <li class="list-inline-item">
                                        <a class="text-muted" href="https://adminkit.io/" target="_blank">Ayuda</a>
                                    </li>
                                    <li class="list-inline-item">
                                        <a class="text-muted" href="https://adminkit.io/" target="_blank">Privacidad</a>
                                    </li>
                                    <li class="list-inline-item">
                                        <a class="text-muted" href="https://adminkit.io/" target="_blank">Términos</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>








        <!-- comment
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

        -->


        <script src="${pageContext.request.contextPath}/js/jsAdm/app.js"></script>

        <script>
                                        document.addEventListener("DOMContentLoaded", function () {
                                            var ctx = document.getElementById("chartjs-dashboard-line").getContext("2d");
                                            var gradient = ctx.createLinearGradient(0, 0, 0, 225);
                                            gradient.addColorStop(0, "rgba(215, 227, 244, 1)");
                                            gradient.addColorStop(1, "rgba(215, 227, 244, 0)");
                                            // Line chart
                                            new Chart(document.getElementById("chartjs-dashboard-line"), {
                                                type: "line",
                                                data: {
                                                    labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
                                                    datasets: [{
                                                            label: "Sales ($)",
                                                            fill: true,
                                                            backgroundColor: gradient,
                                                            borderColor: window.theme.primary,
                                                            data: [
                                                                2115,
                                                                1562,
                                                                1584,
                                                                1892,
                                                                1587,
                                                                1923,
                                                                2566,
                                                                2448,
                                                                2805,
                                                                3438,
                                                                2917,
                                                                3327
                                                            ]
                                                        }]
                                                },
                                                options: {
                                                    maintainAspectRatio: false,
                                                    legend: {
                                                        display: false
                                                    },
                                                    tooltips: {
                                                        intersect: false
                                                    },
                                                    hover: {
                                                        intersect: true
                                                    },
                                                    plugins: {
                                                        filler: {
                                                            propagate: false
                                                        }
                                                    },
                                                    scales: {
                                                        xAxes: [{
                                                                reverse: true,
                                                                gridLines: {
                                                                    color: "rgba(0,0,0,0.0)"
                                                                }
                                                            }],
                                                        yAxes: [{
                                                                ticks: {
                                                                    stepSize: 1000
                                                                },
                                                                display: true,
                                                                borderDash: [3, 3],
                                                                gridLines: {
                                                                    color: "rgba(0,0,0,0.0)"
                                                                }
                                                            }]
                                                    }
                                                }
                                            });
                                        });
        </script>
        <script>
            document.addEventListener("DOMContentLoaded", function () {
                // Pie chart
                new Chart(document.getElementById("chartjs-dashboard-pie"), {
                    type: "pie",
                    data: {
                        labels: ["Chrome", "Firefox", "IE"],
                        datasets: [{
                                data: [4306, 3801, 1689],
                                backgroundColor: [
                                    window.theme.primary,
                                    window.theme.warning,
                                    window.theme.danger
                                ],
                                borderWidth: 5
                            }]
                    },
                    options: {
                        responsive: !window.MSInputMethodContext,
                        maintainAspectRatio: false,
                        legend: {
                            display: false
                        },
                        cutoutPercentage: 75
                    }
                });
            });
        </script>
        <script>
            document.addEventListener("DOMContentLoaded", function () {
                // Bar chart
                new Chart(document.getElementById("chartjs-dashboard-bar"), {
                    type: "bar",
                    data: {
                        labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
                        datasets: [{
                                label: "This year",
                                backgroundColor: window.theme.primary,
                                borderColor: window.theme.primary,
                                hoverBackgroundColor: window.theme.primary,
                                hoverBorderColor: window.theme.primary,
                                data: [54, 67, 41, 55, 62, 45, 55, 73, 60, 76, 48, 79],
                                barPercentage: .75,
                                categoryPercentage: .5
                            }]
                    },
                    options: {
                        maintainAspectRatio: false,
                        legend: {
                            display: false
                        },
                        scales: {
                            yAxes: [{
                                    gridLines: {
                                        display: false
                                    },
                                    stacked: false,
                                    ticks: {
                                        stepSize: 20
                                    }
                                }],
                            xAxes: [{
                                    stacked: false,
                                    gridLines: {
                                        color: "transparent"
                                    }
                                }]
                        }
                    }
                });
            });
        </script>
        <script>
            document.addEventListener("DOMContentLoaded", function () {
                var markers = [{
                        coords: [31.230391, 121.473701],
                        name: "Shanghai"
                    },
                    {
                        coords: [28.704060, 77.102493],
                        name: "Delhi"
                    },
                    {
                        coords: [6.524379, 3.379206],
                        name: "Lagos"
                    },
                    {
                        coords: [35.689487, 139.691711],
                        name: "Tokyo"
                    },
                    {
                        coords: [23.129110, 113.264381],
                        name: "Guangzhou"
                    },
                    {
                        coords: [40.7127837, -74.0059413],
                        name: "New York"
                    },
                    {
                        coords: [34.052235, -118.243683],
                        name: "Los Angeles"
                    },
                    {
                        coords: [41.878113, -87.629799],
                        name: "Chicago"
                    },
                    {
                        coords: [51.507351, -0.127758],
                        name: "London"
                    },
                    {
                        coords: [40.416775, -3.703790],
                        name: "Madrid "
                    }
                ];
                var map = new jsVectorMap({
                    map: "world",
                    selector: "#world_map",
                    zoomButtons: true,
                    markers: markers,
                    markerStyle: {
                        initial: {
                            r: 9,
                            strokeWidth: 7,
                            stokeOpacity: .4,
                            fill: window.theme.primary
                        },
                        hover: {
                            fill: window.theme.primary,
                            stroke: window.theme.primary
                        }
                    },
                    zoomOnScroll: false
                });
                window.addEventListener("resize", () => {
                    map.updateSize();
                });
            });
        </script>
        <script>
            document.addEventListener("DOMContentLoaded", function () {
                var date = new Date(Date.now() - 5 * 24 * 60 * 60 * 1000);
                var defaultDate = date.getUTCFullYear() + "-" + (date.getUTCMonth() + 1) + "-" + date.getUTCDate();
                document.getElementById("datetimepicker-dashboard").flatpickr({
                    inline: true,
                    prevArrow: "<span title=\"Previous month\">&laquo;</span>",
                    nextArrow: "<span title=\"Next month\">&raquo;</span>",
                    defaultDate: defaultDate
                });
            });
        </script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>         
        <script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js" integrity="sha512-VEd+nq25CkR676O+pLBnDW09R7VQX9Mdiij052gVCp5yVH3jGtH70Ho/UUv4mJDsEdTvqRCFZg0NKGiojGnUCw==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>                



        <script>
            function cargar(archivo) {
                event.preventDefault();
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



            window.addEventListener('cerrarModal', function (e) {
                if (e.detail.success) {
                    // Aquí cierras el modal con su ID (suponiendo que el modal tiene ID 'modificarModalUsuario')
                    $('#modificarModalUsuario').modal('hide');

                }
            });


        </script>



        <!--- Script tabla -->

        <!-- JQUERY -->
        <script src="https://code.jquery.com/jquery-3.4.1.js"
                integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous">
        </script>
        <!-- DATATABLES -->
        <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js">
        </script>
        <!-- BOOTSTRAP -->
        <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js">
        </script>



        <script src="<%= request.getContextPath()%>/js/AdmUsuariosAjx.js"></script>





    </body>

</html>