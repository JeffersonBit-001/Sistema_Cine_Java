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

        <!--Combos-->

        <link rel="stylesheet" href="<%= request.getContextPath()%>/css/skeleton.css">
        <link rel="stylesheet" href="<%= request.getContextPath()%>/css/custom.css">

        <link rel="stylesheet" href="<%= request.getContextPath()%>/css/CombosIndi.css">
        <link rel="stylesheet" href="<%= request.getContextPath()%>/css/CombosGeneral.css"/>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/1.4.1/html2canvas.min.js"></script>
        
        <style>
            #comprar_combos{
                cursor: pointer;
            }
            
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
            
            #cambiar_sede_button{
                cursor:pointer;
            }
        </style>
    </head>

    <body>
        <div class="jumbotron jumbotron-fluid bg-jumbotron3" style="margin-bottom: 90px;">
            <div class="container text-center py-5">

                <img id="img_sede_print" class="class_img_sede img-fluid" src="" alt="alt" width="400px" height="400px"/>



                <h3 id="h3_sede_print" class="display-3 mb-4 text_decox">
                    Combos
                </h3>
            </div>
        </div>





        <div class="container-fluid p-0 sdback fixed_navbar2">
            <nav class="navbar navbar-expand-lg navbar-light py-3 py-lg-0 px-lg-5">

                <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse2">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse justify-content-between px-lg-3" id="navbarCollapse2">
                    <div class="navbar-nav m-auto py-0">




                        <a class="nav-item nav-link active name_letra name_letra_2 fixed_navbar btn_seleccion" 
                           onclick="cargarCategoria('combo_cat')" data-link="combos">Combos</a>

                        <a class="nav-item nav-link name_letra name_letra_2 fixed_navbar btn_seleccion" 
                           onclick="cargarCategoria('dulceria_cat')"
                           data-link="dulceria">Dulcería</a>

                        <a class="nav-item nav-link name_letra name_letra_2 fixed_navbar btn_seleccion"
                           onclick="cargarCategoria('bebida_cat')"
                           data-link="bebidas">Bebidas</a>

                        <a class="nav-item nav-link name_letra name_letra_2 fixed_navbar btn_seleccion"
                           onclick="cargarCategoria('personalizacion_cat')"
                           data-link="personalizar">Personalizar</a>


                        <div class="nav-item nav-link name_letr fixed_navbar">
                            <div class="row_edit">

                                <div class="two u-pull-right row_edit">
                                    <ul>
                                        <li class="submenu row_edit">
                                            <img src="<%= request.getContextPath()%>/img/cart.png" id="" class="row_edit">

                                            <div id="carrito">

                                                <table id="lista-carrito" class="u-full-width">
                                                    <thead>
                                                        <tr>
                                                            <th>Tipo</th>
                                                            <th>Imagen</th>
                                                            <th>Nombre</th>
                                                            <th>Precio</th>
                                                            <th>Cantidad</th>
                                                            <th></th>
                                                        </tr>
                                                    </thead>
                                                    <tbody id="lista-carrito-tbody"></tbody>
                                                </table>

                                                <a href="#" id="vaciar-carrito" class="button u-full-width">Vaciar Carrito</a>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                            </div> 
                        </div>



                    </div>


                </div>
            </nav>
        </div>




        <div id="contenido_categoria">
            <ul class="menu_peli">

                <li>
                    <a class="edit_peliculas">Sub-Categoria</a>
                    <ul id="construir_enlace">




                    </ul>
                </li>



                <li>
                    <!-- comment<input type="text" id="input-search-ser" class="input_text_busqueda" placeholder="¿Qué película deseas reservar?">
                    <a id="href_id">
                        <i class="fa-solid fa-magnifying-glass fa-lg" style="color: #ffffff;"></i>
                    </a>

                    <ul id="ul_edit">



                    </ul> -->
                    <a id="cambiar_sede_button" class="edit_peliculas">Cambiar Sede</a>
                    
                </li>    
                
                <li>
                    <a id="comprar_combos" href="CompraCombos.jsp" class="edit_peliculas">Comprar</a>
                    
                </li>
        </div>         








        <!-- COMBOS -->


        <!-- CARGAR AJAX -->
        <div id="lista-cursos" class="container pt-5">
            <h1 id="encabezado" class="encabezado">Combos En Línea</h1>
            <div class="row" id="cargar_comboss">



            </div> <!--.row-->



        </div>  


        <div class="nav-item nav-link name_letr fixed_navbar nav-solid-stea container-fluid position-relative div_comb_beb_dul" data-link="personalizar" data-subcat="">
            <div class="row_edit">

                <div class="two row_edit">
                    <ul>
                        <li class="submenu row_edit sub_mennu_2">

                            <div class="edit_flex_conte">

                                <div id="carrito-2">

                                    <table id="lista-carrito-2" class="u-full-width">
                                        <thead>
                                            <tr>
                                                <th>Tipo</th>
                                                <th>Imagen</th>
                                                <th>Nombre</th>
                                                <th>Precio</th>
                                                <th>Cantidad</th>
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody id="lista-carrito-tbody-2" class="lista-carrito-tbody-2">

                                        </tbody>
                                    </table>



                                    <div class="container_selector edit_btn_marg">

                                        <button id="vaciar-carrito-2" class="vaciar-carrito-2 button u-full-width">Agregar Carrito</button>

                                        <div class="container_selector margin_conta edit_btn_marg container_selector2">
                                            <button class="u-full-width input borrar-curso-3 button_t aumentar carrito_eliminar_e disminuir_perso" data-nombre-3="Personalizado">-</button>

                                            <input type="text" class="input_t-3 valorInput-2 marg_edt value_input_pers value_inp" value="1" data-nombre2-3="Personalizado" readonly>

                                            <button class="u-full-width button-primary input agregar-carrito-3 button_t disminuir aumentar_perso" data-nombre-3="Personalizado">+</button>


                                        </div>

                                    </div>


                                </div>

                                <div id="carrito-2-img" class="jumbotron jumbotron-fluid bg-jumbotron2 jumb_s disfruta_combos u-full-width carrito-2-img">

                                </div>

                            </div>



                        </li>
                    </ul>
                </div>
            </div> 
        </div>




        <!--
        
        
        <div class="container-fluid py-5">
            <div class="container pt-5">
               
                
                <div class="row">
                    
        <c:forEach items="${comboss}" var="item">
        <div class="col-lg-4 col-md-8 edit_separar">
            <div class="team position-relative overflow-hidden combos_cad">
                <img class="img-fluid" src="<%= request.getContextPath()%>/img/${item.imagen}" alt="" width="100%" style="max-height: 300px;">
                <div class="position-relative text-center">
                    <div class="team-text bg-primary text-white">
                        <h5 class="text-white text-uppercase">${item.nombre}</h5>
                        <p class="m-0">${item.precio}</p>
                    </div>
                    <div class="team-social bg-dark text-center">
                        <a class="btn btn-outline-primary btn-square mr-2" href="#"><i class="fa-regular fa-eye fa-xl" style="color: #fd8b8b;"></i></a>
                        <a class="btn btn-outline-primary btn-square mr-2" href="#"><i class="fa-solid fa-ticket fa-xl" style="color: #fd8b8b;"></i></a>
                    </div>
                </div>
            </div>
                    
            <div class="team-text bg-primary text-white">
                <div class="container_selector">
                    <button class="button_t aumentar">-</button>
                    <input type="text" class="input_t valorInput" value="0" readonly>
                    <button class="button_t disminuir">+</button>
                </div>

            </div>
        </div>
        
        </c:forEach>

    </div>
</div>
</div>-->


        <script src="<%= request.getContextPath()%>/js/SelectCombosAjx.js"></script>
        <script src="<%= request.getContextPath()%>/js/app.js"></script>
        <script src="<%= request.getContextPath()%>/js/app2.js"></script>

        <script src="<%= request.getContextPath()%>/js/CombosGeneral.js"></script>

        


    </body>

</html>