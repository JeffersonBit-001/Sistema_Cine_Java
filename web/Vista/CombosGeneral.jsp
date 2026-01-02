<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>CINESTAR</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="Free HTML Templates" name="keywords">
        <meta content="Free HTML Templates" name="description">

        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

        <style>
            .dis_p {
                position: relative; /* Necesario para posicionar el pseudo-elemento correctamente */
                display: inline-block;
            }

            .decorative-rectangle {
                position: relative;
                display: inline-block;
                padding: 0 0.5em; /* Añade un poco de espacio alrededor del texto */
                background: -webkit-radial-gradient(#E20613,#FABD03); /* Color de fondo del rectángulo (ajusta según el diseño) */
                border-radius: 10px; /* Opcional: agrega esquinas redondeadas al rectángulo */
            }

            .decorative-rectangle::before {
                content: '';
                position: absolute;
                top: 50%;
                left: 0;
                width: 100%;
                height: 100%;
                background: red; /* Color del rectángulo decorativo (ajusta según el diseño) */
                transform: translateY(-50%); /* Centra verticalmente el rectángulo */
                z-index: -1; /* Coloca el rectángulo detrás del texto */

                border-radius: 10px;/* Opcional: agrega esquinas redondeadas al rectángulo */
            }

            .o_edit{
                margin-bottom: 16%;
            }

            .jumb_s {
                background: linear-gradient(rgba(33, 30, 28, 0.7), rgba(33, 40, 28, 0.7)), url(../img/carousel-2.jpg), no-repeat center center;
                background-size: cover;
            }

            .fa-whatsapp{
                font-size: 6rem;
                margin: 35px
            }

            .btn_aba{
                font-size:2rem;
            }

            .edit_sol{
                margin-bottom: 5%;
                margin-top: 4%;
                font-size: 60px !important;
            }

            .edit_mouse{
                cursor: default;
                text-align: center;

            }
            .edit_mouse2{
                text-align: center;

            }

            .class_center{
                text-align: center;
                justify-content: center;
                justify-items: center;
                align-content: center;
                align-items: center;

            }

            .edit_but_d:hover{
                transition: all 1s !important;
            }

            .edit_back{
                border-radius: 20px;
                box-shadow: 0 4px 18px rgba(0, 0, 0, 0.1);
            }

            .escoger_title{
                font-weight: bold; /* Negrita para resaltar el gradiente */
                background: linear-gradient(to bottom, rgba(255, 0, 0, 0.8), rgba(0, 0, 0, 0.8));
                -webkit-background-clip: text;
                background-clip: text;
                color: transparent;

            }

        </style>

    </head>

    <body>
        <%@include file="Cabecera.jsp" %>












        <div class="jumbotron jumbotron-fluid bg-jumbotron2 jumb_s disfruta_combos" style="margin-bottom: 0px;">
            <div class="container text-center py-5">
                <i class="fa-solid fa-location-dot fa-2xl edit_sol" style="color: #f57970;"></i>
                <h3 class="text-white display-3 mb-4 text_decox">DISFRUTA DE TUS MEJORES COMBOS</h3>

            </div>
        </div>

        <div class="row justify-content-center mx-0 div_desaparecer">
            <div class="col-lg-6 py-5">
                <div class="p-5 my-5">
                    <h1 class="text-black text-center mb-4 escoger_title">Escoge tu sede favorita</h1>
                    <div class="form-row">


                        <div class="col-sm-6 edit_text">
                            <div class="form-group">
                                <input type="text" class="form-control bg-transparent p-4 edit_mouse" value="Sede" readonly/>
                            </div>
                        </div>
                        <div class="col-sm-6">

                            <div class="form-group">
                                <select id="select_sedes" class="custom-select bg-transparent px-4 edit_mouse2" style="height: 50px;">
                                    <option selected>--Selecciona--</option>

                                </select>
                            </div>

                        </div>
                    </div>

                    <div class="form-row class_center">
                        <div class="col-sm-6">
                            <button class="btn btn-primary btn-block edit_but_d" onclick="cargar('otroContenido', 'div', 'Combos.jsp')" type="submit" style="height: 47px;" disabled>Buscar</button>
                        </div>

                    </div>
                </div>
            </div>
        </div>

        <div id="otroContenido"></div>

        <script >
            function cargarCategoria(nombreCat) {
                fetch('../ControladorCat?subcategoria=' + nombreCat, {
                    method: 'GET'
                }).then(response => {
                    if (!response.ok) {
                        throw new Error('Error en la respuesta de la red');
                    }
                    return response.json();
                }).then(data => {
                    console.log('Datos recibidos:', data);
                    $("#construir_enlace").empty();

                    data.forEach(ttex => {
                        console.log('Elemento:', ttex.nombre);

                        if (ttex.nombre) {
                            $("#construir_enlace").append("<li><a class='btnselecsubcat' data-subcat='" + ttex.nombre + "'>" + ttex.nombre + "</a></li>");
                            cargarBuscarSub();
                        } else {

                            console.warn('No se encontró "nombre" para el objeto:', ttex);
                        }
                    });
                }).catch(error => {
                    $("#construir_enlace").empty();
                    console.error('Error al obtener categoría:', error);
                });
            }

            function cargarBuscarSub() {
                buttonsubcat = document.querySelectorAll('.btnselecsubcat');
                contentDivsubcat = document.querySelectorAll('.div_comb_beb_dul');

                buttonsubcat.forEach(button => {
                    button.addEventListener('click', () => {
                        selectedsub = button.getAttribute('data-subcat');

                        contentDivsubcat.forEach(div => {
                            if (div.getAttribute('data-subcat') === selectedsub) {
                                div.style.display = 'block';
                            } else {
                                div.style.display = 'none';
                            }
                        });

                        console.log(`${selectedsub.charAt(0).toUpperCase() + selectedsub.slice(1)} seleccionada`);
                    });
                });
            }




        </script>

        <script>

            cargarSedeCombo();

            const sedeSelect = document.querySelector('.edit_mouse2');
            const buscarButton = document.querySelector('.edit_but_d');

            sedeSelect.addEventListener('change', function () {
                buscarButton.disabled = this.value === '--Selecciona--' || this.value === '';
            });



            function cargar(div, tip, archivo) {

                const selectedValue = sedeSelect.value;

                //const text = archivo + "tipocc=" + selectedValue;
                const text = archivo;
                enviarSedeCombo(selectedValue);
                cargarFetch(div, tip, text);

            }


            function enviarSedeCombo(selectedValue) {
                fetch("../ControladorReservas?verificarSede=true&tipocc=" + encodeURIComponent(selectedValue), {
                    method: 'GET'
                })
                        .then(response => {
                            if (response.ok) {

                                console.log('Éxito: Redirección en la sede de combo');

                            } else {
                                throw new Error("La respuesta del servidor no fue exitosa en la sede de combo");
                            }
                        })
                        .catch(error => {
                            console.error('Error al obtener datos:', error);
                        });

            }

            function cargarSedeCombo() {
                fetch("../ControladorReservas?verificarSedeLlenar=true", {
                    method: 'GET'
                })
                        .then(response => {
                            
                            if (response.ok) {
                                return response.json();
                            } else {
                                throw new Error('Error en la respuesta del servidor');
                            }
                        })
                        .then(data => {
                            
                            if (Object.keys(data).length === 0) {
                                console.log('Respuesta vacía o sin datos');
                                
                            } else {
                                console.log('Datos recibidos:', data);
                                
                                enviarSedeCombo(data.sedeCombo);
                                cargarFetch('otroContenido', 'div', 'Combos.jsp');
                            }
                        })
                        .catch(error => {
                            console.error('Error al obtener datos:', error);
                        });
            }


            function cargarFetch(div, tip, text) {
                const desaparecer = document.querySelector('.div_desaparecer');
                desaparecer.style.display = 'none';
                console.log(text);
                fetch(text)
                        .then(response => {
                            if (!response.ok) {
                                throw new Error('Error en la respuesta de la red');
                            }
                            return response.text();
                        })
                        .then(data => {

                            let tempDiv = document.createElement(tip);
                            tempDiv.innerHTML = data;


                            let otroContenido = document.getElementById(div);
                            if (otroContenido) {
                                otroContenido.innerHTML = tempDiv.innerHTML;
                            } else {
                                console.error('Elemento con id "otroContenido" no encontrado');
                                return;
                            }


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


                            otroContenido.scrollIntoView({behavior: 'smooth', block: 'start'});

                        })
                        .catch(error => console.error('Error al cargar el contenido:', error));
            }



        </script>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>         

        <script src="<%= request.getContextPath()%>/js/SedesJxCombos.js"></script>







        <%@include file="Pie.jsp" %>
    </body>

</html>