<%-- 
    Document   : HuellaForm
    Created on : 4 set. 2024, 00:12:35
    Author     : JEFFERSON
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="../css/huella.css"/>
        <link rel="stylesheet" href="../css/huella_form.css"/>
    </head>
    <body>
        
        <%@include file="Cabecera.jsp" %>
        
        <div class="banner-container">
            <img src="../img/catarata.gif" alt="Catarata GIF" class="banner-gif">
            <div class="banner-content">
                <div class="banner-text">
                    <h1>Compromiso Verde: La Sostenibilidad en Cinestar</h1>
                    <p>Descubre cómo estamos reduciendo nuestra huella de carbono y cómo tú también puedes contribuir</p>
                </div>
                <div class="banner-menu">
                    <div class="menu-container">
                        <h3>
                        <ul>
                            <li><a class="nom_preg" href="#huella-carbono">¿Qué es la huella de carbono en la industria del cine?</a></li>
                            <li><a class="nom_preg" href="#reduccion-cinestar">¿Cómo está reduciendo Cinestar su huella de carbono?</a></li>
                            <li><a class="nom_preg" href="#contribucion-visitantes">¿Cómo puedo contribuir a reducir la huella de carbono al visitar Cinestar?</a></li>
                            <li><a class="nom_preg" href="#datos-peru">Datos en Perú</a></li>
                            <li><a class="nom_preg" href="#preguntas-frecuentes">Preguntas frecuentes</a></li>
                        </ul>
                        </h3>
                    </div>
                </div>
            </div>
        </div>

        <div class="mensaje-urgente">
            <h2>¡MENSAJE URGENTE!</h2>
            <div class="video-container">
                <iframe width="560" height="315" src="https://www.youtube.com/embed/mMA301vxz-0" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
            </div>
            <div class="texto-urgente">
                <p>Poco más de 10 años, es el tiempo que le queda a la humanidad para resarcir su impacto climático.</p>
                <p>Uno de los factores que más influyen en esta crisis, son las emisiones de dióxido de carbono emitidas a la atmósfera, estas están calentando el planeta a niveles récord, y han desencadenado alteraciones en los ecosistemas... si no actuamos rápido, según la ciencia, puede ser el principio de la extinción humana. No es un juego, la crisis climática es real.</p>
                <p>No dejes que el calentamiento global nos destruya, salva el planeta y actúa ahora.</p>
                <p>El término "Huella de Carbono" hace referencia a la suma de los gases de efecto invernadero que son emitidos a la atmósfera producto de la actividad humana. Estas emisiones pueden ser cuantificadas en diferentes niveles o enfoques, ya sea a nivel país, ciudad, empresa o incluso de manera individual.</p>
            </div>
        </div>


        <div class="alerta-peru">
            <h2>¡ALERTA PERÚ!</h2>
            <div class="mapa-container">
                <img src="../img/PerúCalor.jpg" alt="Mapa de calor de Perú" class="mapa-calor">
                <div class="leyenda">
                    <center><h3>Aumento de temperatura media anual 2041-2060</h3></center>
                    <ul>
                        <li><div class="color-rect color-0-2"></div> 0.0 - 2.0°C</li>
                        <li><div class="color-rect color-2-1-2-2"></div> 2.1 - 2.2°C</li>
                        <li><div class="color-rect color-2-3-2-4"></div> 2.3 - 2.4°C</li>
                        <li><div class="color-rect color-2-5-2-6"></div> 2.5 - 2.6°C</li>
                        <li><div class="color-rect color-2-6"></div> >2.6°C</li>
                    </ul>
                </div>

                <div class="info-adicional">
                    <p>Este mapa muestra el cambio en temperaturas predichas para el futuro en Perú. Se muestra que las áreas del sur que históricamente se han caracterizado con temperaturas frías se van a calentar más que otras. Un área de preocupación para las olas de calor podría ser en el noreste, que tiene altas temperaturas hoy en día y también se predice un calentamiento de 2.3-2.4°C para el futuro.</p>
                </div>

            </div>
        </div>





        


            <div class="huella-carbono-seccion" id="huella-carbono">
                <img src="../img/huella_carbono.jpg" alt="Huella de carbono" class="huella-carbono-imagen edit_img_verde">
                <div class="huella-carbono-texto text_justifi">
                    <h2>¿Qué es la huella de carbono en la industria del cine?</h2>
                    <p>La huella de carbono en la industria del cine se refiere a la cantidad total de gases de efecto invernadero que se emiten durante el ciclo de vida de una película, desde su producción hasta su proyección en los cines.</p>
                    <p>En términos específicos:</p>
                    <ul>
                        <li><strong>Producción de Películas:</strong> Incluye las emisiones generadas por el uso de energía en el set, transporte de actores y equipo, así como la producción de materiales y suministros para la filmación.</li>
                        <li><strong>Distribución y Marketing:</strong> Implica las emisiones derivadas del transporte de copias de películas, el marketing y las actividades promocionales.</li>
                        <li><strong>Operación de Cines:</strong> Abarca las emisiones relacionadas con el consumo de energía en las salas de cine, como la iluminación, el aire acondicionado, el sonido, y la proyección de películas.</li>
                        <li><strong>Gestión de Residuos:</strong> Considera el impacto ambiental de la gestión de residuos generados por el cine, como los residuos de papel, envases y otros materiales.</li>
                    </ul>
                    <p>Reducir la huella de carbono en la industria del cine requiere una combinación de prácticas sostenibles durante todas estas etapas.</p>
                </div>
            </div>

            <div class="reduccion-huella-seccion" id="reduccion-cinestar">
                <div class="reduccion-huella-texto text_justifi">
                    <h2>¿Cómo está reduciendo Cinestar su huella de carbono?</h2>
                    <p>Cinestar ha implementado varias medidas para reducir su huella de carbono y minimizar su impacto ambiental:</p>
                    <ul>
                        <li><strong>Uso de Energía Renovable:</strong> Cinestar ha invertido en fuentes de energía renovables, como paneles solares, para alimentar nuestras instalaciones y reducir nuestra dependencia de combustibles fósiles.</li>
                        <li><strong>Reducción de Plásticos:</strong> Hemos reemplazado envases de plástico de un solo uso con alternativas reutilizables y reciclables en nuestras concesionarias.</li>
                        <li><strong>Programas de Reciclaje:</strong> Implementamos un programa integral de reciclaje para asegurar que los residuos generados en nuestras instalaciones sean correctamente reciclados o gestionados de manera responsable.</li>
                        <li><strong>Digitalización de Tickets:</strong> La transición a tickets digitales en lugar de papel ayuda a reducir el consumo de recursos y disminuye la cantidad de desechos generados.</li>
                        <li><strong>Eficiencia Energética:</strong> Hemos optimizado el consumo energético en nuestras salas mediante el uso de iluminación LED de bajo consumo y sistemas de climatización eficientes.</li>
                    </ul>
                </div>
                <img src="../img/mitigacion.jpg" alt="Mitigación de huella de carbono" class="reduccion-huella-imagen edit_img_verde">
            </div>

            <div class="contribucion-visitantes-seccion" id="contribucion-visitantes">
                <img src="../img/reducir.png" alt="Reducir huella de carbono" class="contribucion-visitantes-imagen edit_img_verde">
                <div class="contribucion-visitantes-texto text_justifi">
                    <h2>¿Cómo puedo contribuir a reducir la huella de carbono al visitar Cinestar?</h2>
                    <p>Aquí tienes algunas maneras en que puedes ayudar a reducir la huella de carbono durante tu visita a Cinestar:</p>
                    <ul>
                        <li><strong>Usa Transporte Público:</strong> Opta por el transporte público, la bicicleta, o comparte el coche con amigos para llegar al cine, reduciendo así las emisiones de carbono de tus desplazamientos.</li>
                        <li><strong>Trae Envases Reutilizables:</strong> Lleva tu propia botella de agua o envases reutilizables para minimizar el uso de plásticos desechables en el cine.</li>
                        <li><strong>Participa en el Reciclaje:</strong> Usa los contenedores de reciclaje disponibles en nuestras instalaciones para separar tus residuos de manera correcta.</li>
                        <li><strong>Elige Películas Ecológicas:</strong> Apoya películas que traten temas ambientales o que promuevan la sostenibilidad y el respeto por el medio ambiente.</li>
                    </ul>
                </div>
            </div>

            <div class="datos-peru-seccion" id="datos-peru">
                <h2>Datos en Perú</h2>
                <div class="datos-peru-contenido">
                    <img src="../img/peru1.jpg" alt="Mapa de Perú" class="datos-peru-imagen edit_img_verde">
                    <div class="datos-peru-texto text_justifi">
                        <p>En Perú las emisiones de CO2 durante 2019 han crecido 2,442 megatoneladas, un 4,43% respecto a 2018.</p>
                        <p>Las emisiones de CO2 en 2019 han sido de 57,583 megatoneladas, con lo que Perú es el país número 129 del ranking de países por emisiones de CO2, formado por 184 países, en el que se ordenan los países de menos a más contaminantes.
                        <p>Además de sus emisiones totales de CO2 a la atmósfera, que lógicamente dependen entre otras variables de la población del país, es conveniente analizar el comportamiento de sus emisiones por habitante. En la tabla vemos que las emisiones per cápita de CO2 en Perú, han aumentado en 2019, en el que han sido de 1,75 toneladas por habitante.</p>
                        <p>Por último, es interesante observar el comportamiento de las emisiones de CO2 por cada 1.000 dólares de PIB, que mide, para un mismo país, la "eficiencia medioambiental" con la que se produce a lo largo del tiempo. En el último periodo, Perú, ha emitido 0,14 kilos por cada 1.000$ de PIB, más que en 2018.</p>
                    </div>
                </div>
            </div>

            <div class="preguntas-frecuentes-seccion" id="preguntas-frecuentes">
                <h2>Preguntas frecuentes</h2>
                <div class="preguntas-container">
                    <div class="pregunta">
                        <h3>¿Cómo mide Cinestar su huella de carbono y qué resultados han obtenido?</h3>
                        <div class="respuesta">
                            <p>Cinestar utiliza una combinación de métodos y herramientas para medir su huella de carbono:</p>
                            <ul>
                                <li>Auditorías ambientales anuales realizadas por expertos independientes.</li>
                                <li>Sistemas de monitoreo en tiempo real del consumo energético en nuestras instalaciones.</li>
                                <li>Cálculos basados en estándares internacionales como el GHG Protocol.</li>
                                <li>Seguimiento detallado de nuestro consumo de recursos y generación de residuos.</li>
                            </ul>
                            <p>Los resultados han sido positivos:</p>
                            <ul>
                                <li>Reducción del 20% en nuestras emisiones de CO2 en los últimos 3 años.</li>
                                <li>Reciclaje de más de 10 toneladas de residuos anualmente.</li>
                                <li>Disminución del 30% en el consumo energético por espectador.</li>
                            </ul>
                            <p>Estos logros son parte de nuestro compromiso continuo con la sostenibilidad y la mejora constante de nuestras prácticas ambientales.</p>
                        </div>
                    </div>
                    <div class="pregunta">
                        <h3>¿Qué beneficios tiene para el medio ambiente que Cinestar utilice energía renovable?</h3>
                        <div class="respuesta">
                            <p>El uso de energía renovable por parte de Cinestar tiene múltiples beneficios para el medio ambiente:</p>
                            <ul>
                                <li><strong>Reducción de emisiones de gases de efecto invernadero:</strong> Las fuentes renovables como la solar o eólica no emiten CO2 durante la generación de electricidad.</li>
                                <li><strong>Conservación de recursos naturales:</strong> Disminuye la dependencia de combustibles fósiles no renovables.</li>
                                <li><strong>Mejora de la calidad del aire:</strong> Menos contaminantes atmosféricos asociados con la quema de combustibles fósiles.</li>
                                <li><strong>Promoción de la innovación:</strong> Impulsa el desarrollo de tecnologías limpias y eficientes.</li>
                                <li><strong>Contribución a la economía verde:</strong> Apoya la creación de empleos en el sector de energías renovables.</li>
                            </ul>
                            <p>Además, nuestro compromiso con las energías renovables sirve como ejemplo para otras empresas y para nuestros clientes, fomentando una mayor conciencia ambiental en la comunidad.</p>
                        </div>
                    </div>
                    <div class="pregunta">
                        <h3>¿Cómo puede impactar la huella de carbono de la proyección de películas?</h3>
                        <div class="respuesta">
                            <p>La proyección de películas tiene varios impactos en la huella de carbono de un cine:</p>
                            <ul>
                                <li><strong>Consumo eléctrico de proyectores:</strong> Los proyectores digitales modernos, aunque más eficientes que los antiguos de película, aún consumen cantidades significativas de energía.</li>
                                <li><strong>Sistemas de sonido:</strong> Los equipos de audio de alta potencia necesarios para una experiencia cinematográfica inmersiva también contribuyen al consumo energético.</li>
                                <li><strong>Climatización de salas:</strong> Mantener una temperatura confortable en las salas de cine, especialmente durante las proyecciones, requiere un uso intensivo de sistemas de aire acondicionado o calefacción.</li>
                                <li><strong>Iluminación:</strong> Aunque durante la proyección la iluminación es mínima, las áreas comunes y la iluminación antes y después de las películas también suman al consumo.</li>
                            </ul>
                            <p>Para mitigar estos impactos, Cinestar está implementando varias estrategias:</p>
                            <ul>
                                <li>Uso de proyectores de última generación con mayor eficiencia energética.</li>
                                <li>Optimización de los horarios de proyección para maximizar la ocupación de las salas.</li>
                                <li>Instalación de sistemas de gestión energética inteligentes que ajustan automáticamente el consumo.</li>
                                <li>Transición a iluminación LED en todas las áreas del cine.</li>
                            </ul>
                            <p>Estas medidas nos permiten ofrecer una experiencia cinematográfica de calidad mientras reducimos nuestro impacto ambiental.</p>
                        </div>
                    </div>
                    <div class="pregunta">
                        <h3>¿Cinestar realiza alguna actividad de educación ambiental para sus empleados?</h3>
                        <div class="respuesta">
                            <p>Sí, Cinestar tiene un programa integral de educación ambiental para sus empleados que incluye:</p>
                            <ul>
                                <li><strong>Talleres de sostenibilidad:</strong> Sesiones mensuales sobre temas como reciclaje, eficiencia energética y reducción de residuos.</li>
                                <li><strong>Programa de embajadores verdes:</strong> Empleados voluntarios que lideran iniciativas ambientales en cada sede.</li>
                                <li><strong>Capacitación en prácticas sostenibles:</strong> Formación específica para cada área sobre cómo incorporar la sostenibilidad en sus tareas diarias.</li>
                                <li><strong>Retos ecológicos:</strong> Competencias amistosas entre departamentos para fomentar hábitos sostenibles.</li>
                                <li><strong>Boletín de sostenibilidad:</strong> Comunicación regular sobre nuestros avances y consejos para un estilo de vida más verde.</li>
                            </ul>
                            <p>Además, incentivamos a nuestros empleados a proponer ideas innovadoras para mejorar nuestra sostenibilidad. Muchas de nuestras iniciativas actuales surgieron de sugerencias del personal. Creemos que educar y empoderar a nuestros empleados es clave para lograr un impacto positivo duradero en el medio ambiente.</p>
                        </div>
                    </div>
                </div>
            </div>

            <div class="calcula-huella-seccion">
                <h2>¡Te ayudamos a calcular la Huella de Carbono de tu empresa!</h2>
                <a href="HuellaForm.jsp" class="boton-empieza">Empieza ahora</a>
            </div>

            
            <script>
                // JavaScript para manejar el despliegue de respuestas
                document.querySelectorAll('.pregunta h3').forEach(pregunta => {
                    pregunta.addEventListener('click', () => {
                        const respuesta = pregunta.nextElementSibling;
                        respuesta.style.display = respuesta.style.display === 'block' ? 'none' : 'block';
                    });
                });
            </script>
            
            
            
            <%@include file="Pie.jsp" %>

    </body>
</html>
