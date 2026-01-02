const urlParams = new URLSearchParams(window.location.search);
const tipoc = urlParams.get('tipoc');

$(document).ready(function () {
    cargarSede();
    cargarCategoria();
    cargarDia();
    cargarBuscar();
    /*CONSTRUIR*/
    cargarPeliculas("");


});


const enlaces = document.querySelectorAll('li a');

enlaces.forEach(enlace => {
    enlace.addEventListener('click', function(event) {
        event.preventDefault();

        console.log("Enlace clickeado: ", event.target.innerText);
    });
});



function cargarPeliculas(busqueda) {
    if (busqueda !== "") {
        event.preventDefault();
    }


    fetch("../ControladorPeli?tipoc=" + tipoc + busqueda)
            .then(response => {
                if (!response.ok) {
                    throw new Error("Network response was not ok " + response.statusText);
                }
                return response.json();
            })
            .then(data => {
                const tbody = document.querySelector("#box-cantainer");
                tbody.innerHTML = "";

                data.forEach(peliculax => {
                    const row = document.createElement("div");
                    row.className = "box-1 box-1 pelifamilia sedeuni dia1-peli";

                    row.innerHTML = `
                <div class="content">
                    <div class="content_2">
                        <div class="probar">
                            <div class="contenedor_reservar_detalles">
                                <a class="contenedor_reservar_detalles_title comprar_reserva_detalle" href="Reservas.jsp">
                                    <img class="ordenar" src="../img/img_ticket.png" width="35px" height="35px">
                                    <p class="ordenar">Comprar</p>
                                </a>
                                <a class="contenedor_reservar_detalles_title" href="PeliculasInfo.jsp?valx=${peliculax.nombre}">
                                    <img class="ordenar" src="../img/img_mas.png" width="25px" height="25px">
                                    <p class="ordenar">Ver Detalle</p>
                                </a>
                            </div>
                            <div class="decoracion_link">
                                <img class="mov_img_content_cartelera" src="../img/${peliculax.img}" width="250" height="360"/>
                            </div>
                        </div>
                        <div class="contenedor_texto">
                            <p class="text_content_nombre_tiempo_funcion_p">${peliculax.nombre}</p>
                            <p class="text_content_nombre_tiempo_funcion">${peliculax.descripcion}</p>
                        </div>
                        <div class="contenedor_texto_descripcion_peli">
                            <p class="texto_img_cartelera">${peliculax.sinopsis}</p>
                        </div>
                    </div>   
                </div>
            `;

                    tbody.appendChild(row);
                });

                aplicarEfectos();
                select();

            })
            .catch(error => {
                console.error("Error en la llamada fetch: ", error);
            });
}
/*BUSQUEDA*/
function cargarBuscar() {
    const url = `../ControladorPeli?tipoc=${tipoc}`;

    fetch(url, {
        method: 'GET'
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Error en la respuesta de la red');
        }
        return response.json();
    })
    .then(data => {
        estad('#ul_edit', data);
    })
    .catch(error => {
        console.error('Error al obtener buscar:', error);
    });
}


/*BUSQUEDA CARTELERA*/
function cargarCategoria() {
    fetch('../ControladorPeli?estadoPeli=categoria', {
        method: 'GET'
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Error en la respuesta de la red');
        }
        return response.json();
    })
    .then(data => {
        estad('#ul_1', data);
    })
    .catch(error => {
        console.error('Error al obtener categoría:', error);
    });
}

function cargarDia() {
    fetch('../ControladorPeli?estadoPeli=dia', {
        method: 'GET'
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Error en la respuesta de la red');
        }
        return response.json();
    })
    .then(data => {
        estad2('#ul_3', data);
    })
    .catch(error => {
        console.error('Error al obtener día:', error);
    });
}

function cargarSede() {
    fetch('../ControladorPeli?estadoPeli=sede', {
        method: 'GET'
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Error en la respuesta de la red');
        }
        return response.json();
    })
    .then(data => {
        estad('#ul_2', data);
    })
    .catch(error => {
        console.error('Error al obtener sede:', error);
    });
}

function estad(selector, data) {
    $(selector).empty();

    data.forEach(tipo => {
        $(selector).append(`<li><a href="#" onclick="cargarPeliculas('&accion=${tipo.nombre}');">${tipo.nombre}</a></li>`);
    });
}

function estad2(selector, data) {
    $(selector).empty();

    data.forEach(tipo => {
        $(selector).append(`<li><a href="#" onclick="cargarPeliculas('&accion=${tipo.nombre}');">${tipo.descripcion}</a></li>`);
    });
}


/*
function cargarCategoria() {
    $.ajax({
        url: '../ControladorPeli?estadoPeli=categoria',
        method: 'GET',
        dataType: 'json',
        success: function (data) {
            estad('#ul_1', data);
        },
        error: function (error) {
            console.error('Error al obtener categoría:', error);
        }
    });
}


function cargarDia() {
    $.ajax({
        url: '../ControladorPeli?estadoPeli=dia',
        method: 'GET',
        dataType: 'json',
        success: function (data) {
            estad2('#ul_3', data);
        },
        error: function (error) {
            console.error('Error al obtener día:', error);
        }
    });
}


function cargarSede() {
    $.ajax({
        url: '../ControladorPeli?estadoPeli=sede',
        method: 'GET',
        dataType: 'json',
        success: function (data) {
            estad('#ul_2', data);
        },
        error: function (error) {
            console.error('Error al obtener sede:', error);
        }
    });
}

function estad(selector, data) {
    $(selector).empty();

    $.each(data, function (index, tipo) {
        $(selector).append(` <li><a class="" href="#" onclick="cargarPeliculas('&accion=${tipo.nombre}');">${tipo.nombre}</a></li>`);
    });
}

function estad2(selector, data) {
    $(selector).empty();


    $.each(data, function (index, tipo) {
        $(selector).append(` <li><a class="" href="#" onclick="cargarPeliculas('&accion=${tipo.nombre}');">${tipo.descripcion}</a></li>`);
    });
}


*/



/*EFECTOS*/

function aplicarEfectos() {
    var imagen = document.querySelectorAll('.probar');
    var imagen_detalle_compra = document.querySelectorAll('.contenedor_reservar_detalles');

    imagen.forEach(function (imagen2) {
        imagen2.addEventListener("mouseenter", aplicarEfecto);
        imagen2.addEventListener("mouseleave", eliminarEfecto);
    });

    imagen_detalle_compra.forEach(function (imagen3) {
        imagen3.addEventListener("mouseenter", aplicarEfecto2);
        imagen3.style.zIndex = "9999";
        imagen3.addEventListener("mouseleave", eliminarEfecto2);
    });
}

function aplicarEfecto(event) {
    var imagen2 = event.target;
    imagen2.style.opacity = "0.7";
    imagen2.style.filter = "saturate(150%) hue-rotate(30deg)";
}

function eliminarEfecto(event) {
    var imagen2 = event.target;
    imagen2.style.opacity = "1";
    imagen2.style.filter = "none";
}

function aplicarEfecto2(event) {
    var imagen3 = event.target;
    imagen3.style.opacity = "100%";
    imagen3.style.zIndex = "9999";
    imagen3.style.filter = "none";
}

function eliminarEfecto2(event) {
    var imagen3 = event.target;
    imagen3.style.opacity = "0";
    imagen3.style.filter = "none";
}



function select() {

    /*imagen.style.opacity = "0.7"; 
     
     
     imagen.style.filter = "saturate(150%) hue-rotate(200deg)";*/


    /* PELICULAS MOSTRAR */
    var boton = document.querySelector('.content_ver_mas_div');
    var contador = 3;
    var final = 0;
    var boton2 = document.querySelector('.content_ver_menos_div');

    boton.onclick = () => {
        var boxes = [...document.querySelectorAll('.box-container .box-1')];

        for (var i = final; i < final + 3 && i < boxes.length; i++) {
            boxes[i].style.display = "inline-block";
        }

        final += 3;

        if (final >= boxes.length) {
            boton.style.display = 'none';
            boton2.style.display = 'block';
        }


    };

    boton2.onclick = () => {
        var boxes = [...document.querySelectorAll('.box-container .box-1')];

        for (var i = final - 1; i >= final - 3 && i >= 3; i--) {
            boxes[i].style.display = "none";
        }

        final -= 3;

        if (final <= 3) {
            boton2.style.display = 'none';
            boton.style.display = 'block';

        }


    };



    /*CARGAR CATEGORIA */
    /*ACCION */
// FILTRA PELICULAS 




    var mostrar_3pelis = document.querySelectorAll('.box-1:nth-child(1), .box-1:nth-child(2), .box-1:nth-child(3)');


    var btnMostrarTodo = document.querySelector('.content_ver_mas_div');
    var btnMostrarFitro = document.querySelector('.selector_opciones_2');

    btnMostrarFitro.addEventListener('click', function () {
        var btntodos = document.querySelectorAll('.box-1');
        btntodos.forEach(function (box) {
            box.style.display = 'none';
            btnMostrarTodo.style.display = "block";
            mostrar_3pelis.forEach(function (fun) {
                fun.style.display = 'block';
            });
        });
    });
}