/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

cargarBuscar();

var inputSerach2 = document.getElementById("input");
var box_search2 = document.getElementById("box");

/* Filtrar busqueda*/
function buscador2() {
    var filter = inputSerach2.value.toUpperCase();

    /*almacenar resultados - todas las etiquetas del recadro*/
    var li = box_search2.getElementsByTagName("li");
    /*Recorriendo elementos a filtrar */
    for (i = 0; i < li.length; i++) {
        let a = li[i].getElementsByTagName("a")[0];
        let textValue = a.textContent || a.innerText;

        if (textValue.toUpperCase().indexOf(filter) > -1) {
            li[i].style.display = "";
            box_search2.style.display = "block";

            if (inputSerach2.value === "") {
                box_search2.style.display = "none";
            }

        } else {
            li[i].style.display = "none";
        }
    }


}

/*BUSQUEDA*/
function cargarBuscar() {
    const url = "../ControladorPeli?tipoc=Cartelera";

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
                estad('#box', data);
                /*ejecutar mientras escribe*/
                document.getElementById("input").addEventListener("keyup", buscador2);
            })
            .catch(error => {
                console.error('Error al obtener buscar:', error);
            });
}

function estad(selector, data) {
    $(selector).empty();

    data.forEach(tipo => {
        $(selector).append(`<li>
            <a class="edit_enlace" href="?nombre=${tipo.nombre}" onclick="cargarPeliculas('${tipo.nombre}');">
                <img class="icon_buscar" src="../img/img_buscar.png" width="20px" height="20px">
                <p class="text_busqueda">${tipo.nombre}</p>
            </a>
        </li>`);
    });
}

function cargarPeliculas(valx) {
    event.preventDefault();
    fetch("../ControladorPeliInfo?valxGuardar=" + valx)
            .then(response => {
                if (!response.ok) {
                    throw new Error("Network response was not ok " + response.statusText);
                }
                return response.json();
            })
            .then(data => {

                document.getElementById('title_pelicula_escoger').textContent = data.nombre;
                document.getElementById('img_ajax').src = "../img/" + data.img;
                document.getElementById('sinopsis').textContent = data.sinopsis;
                document.getElementById('director_ajax').textContent = data.director;
                document.getElementById('idioma_ajax').textContent = data.idioma;
                document.getElementById('precio_ajax').textContent = "S/. " + data.precio;

                var acomodar = document.querySelector(".article_acomodar");
                var box_acom = document.getElementById("box");
                var ver = document.querySelector('.content_total_informacion');

                var texti = document.getElementById("input");
                texti.value = "";

                ver.style.display = "block";
                box_acom.style.display = "none";
                acomodar.style.marginBottom = '150px';

                cargarSedes();

            })
            .catch(error => {
                console.error('Error al obtener datos:', error);
            });

}
function cargarSedes() {
    fetch("../ControladorPeli?estadoPeli=sede")
            .then(response => {
                if (!response.ok) {
                    throw new Error("Network response was not ok " + response.statusText);
                }
                return response.json();
            })
            .then(data => {
                const tbody = document.querySelector("#sedes_mostrar_seleccion");
                tbody.innerHTML = "";

                data.forEach(sedex => {
                    const row = document.createElement("div");
                    row.innerHTML = '<div class="div_sede" onclick="cargarSedesAsientos(\'' + sedex.nombre + '\', this,' + sedex.id + ')">' +
                            '<h4 class="title_sede">' + sedex.nombre + '</h4>' +
                            '<div class="div_display bodyCargar" id="bodyCargar-' + sedex.nombre + '">' +
                            '</div>' +
                            '</div>';
                    tbody.appendChild(row);
                });
                cargarEventos();
            })
            .catch(error => {
                console.error("Error en la llamada fetch: ", error);
            });
}

function cargarSedesAsientos(sede, sedeElement, id) {
    fetch("../ControladorPeliInfo?asientosPelicula=" + sede)
            .then(response => {
                if (!response.ok) {
                    throw new Error("Network response was not ok " + response.statusText);
                }
                return response.json();
            })
            .then(data => {
                const tbody = sedeElement.querySelector(".bodyCargar");
                tbody.innerHTML = "";

                let fila = "";
                data.forEach((peliculax, i) => {

                    if (i % 3 === 0) {
                        if (i !== 0) {
                            fila += '</div>';
                        }
                        fila += '<div class="fila">';
                    }

                    fila += `<a href="Reservas.jsp" onclick="enviarSeleccion('${peliculax.nombre}', ${peliculax.id}, '${sede}')" class="horario_Sede" data-name="${peliculax.id}">`;
                    fila += `<p>${peliculax.descripcion}</p>`;
                    fila += `<img src="../img/img_asientos.png" width="30px" height="30px">`;
                    fila += `</a>`;


                    if ((i + 1) % 3 === 0 || i === data.length - 1) {
                        fila += '</div>';
                    }
                });

                tbody.innerHTML = fila;
            })
            .catch(error => {
                console.error("Error en la llamada fetch: ", error);
            });
}


function cargarEventos() {

    function disp(event) {

        var divDisplay = event.currentTarget.querySelector('.div_display');



        if (divDisplay.style.display === 'none' || divDisplay.style.display === '') {
            divDisplay.style.display = 'block';

        } else {
            divDisplay.style.display = 'none';

        }
    }


    var divSedes = document.querySelectorAll('.div_sede');
    divSedes.forEach(function (divSede) {
        divSede.addEventListener('click', disp);
    });

    var horarios = document.querySelectorAll('.horario_Sede');



}
;

function enviarSeleccion(nombre, id, sede) {
    event.preventDefault();

    fetch("../ControladorPeliInfo?seleccionPeli=true&nombreSeleccion=" + encodeURIComponent(nombre) +
            "&idhoraSeleccion=" + encodeURIComponent(id) +
            "&sedeSeleccion=" + encodeURIComponent(sede), {
        method: 'GET'
    })
            .then(response => {
                if (response.ok) {

                    console.log('Éxito: Redirección en el servidor');
                    window.location.href = "./Reservas.jsp";
                } else {
                    throw new Error("La respuesta del servidor no fue exitosa");
                }
            })
            .catch(error => {
                console.error('Error al obtener datos:', error);
            });
}




