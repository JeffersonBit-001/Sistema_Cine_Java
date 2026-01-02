<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <title>CINESTAR</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="Free HTML Templates" name="keywords">
        <meta content="Free HTML Templates" name="description">
        


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

        </style>

    </head>

    <body>
        <%@include file="Cabecera.jsp" %>









        <div id="otroContenido"></div>






        <script>

            let url = new URL(window.location.href);
            
            let parametroEnvio = "../ControladorPeli?tipoc=" + encodeURIComponent(url.searchParams.get('tipoc'));

            if (url.searchParams.get('tipoc') === "Cartelera") {
                parametroEnvio = "PeliCartelera.jsp";
            } else {
                parametroEnvio = "PeliEstreno.jsp";
            }

            console.log(":", parametroEnvio);


            document.addEventListener('DOMContentLoaded', function () {

                cargar(parametroEnvio);
            });




            function cargar(archivo) {


                fetch(archivo)
                        .then(response => {
                            if (!response.ok) {
                                throw new Error('Error en la respuesta de la red');
                            }
                            return response.text();
                        })
                        .then(data => {

                            let tempDiv = document.createElement('div');
                            tempDiv.innerHTML = data;


                            let otroContenido = document.getElementById('otroContenido');
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
                            const ventanaAltura = window.innerHeight;


                            const porcentaje = 0.5;
                            const desplazamientoPixeles = ventanaAltura * porcentaje;


                            window.scrollBy(0, desplazamientoPixeles);
                        })
                        .catch(error => console.error('Error al cargar el contenido:', error));


            }


        </script>











        <%@include file="Pie.jsp" %>
    </body>

</html>