/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


mostrarInfoReserva();
cargarAsientos();

function mostrarInfoReserva() {
    fetch("../ControladorReservas?mostrarInfoReserva=mostrarInfo")
            .then(response => {
                if (!response.ok) {
                    throw new Error("Network response was not ok " + response.statusText);
                }
                return response.json();
            })
            .then(data => {
                document.getElementById('img_pelicula').src = "../img/" + data.peli.img;
                document.getElementById('titulo_peli').textContent = "" + data.peli.nombre;
                document.getElementById('disponible_peli').textContent = "🔻 " + data.peli.disponible;
                document.getElementById('sede_peli').textContent = data.sede.nombre;
                document.getElementById('dia_peli').textContent = "📅 " + data.dia.nombre;
                document.getElementById('hora_peli').textContent = "🕛 " + data.hora.nombre;
                document.getElementById('sala_peli').textContent = "⚪ " + data.peli.sala;
                document.getElementById('precio_seleccionados').textContent = "Pelicula: S/. " + data.peli.precio;
                document.getElementById('precio_seleccionados_input').value = data.peli.precio;

            })
            .catch(error => {
                console.error('Error al obtener datos:', error);
            });
}


function cargarAsientos() {
    fetch('../ControladorReservas?mostrarAsientos=mostrarInfo')
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok ' + response.statusText);
                }
                return response.json();
            })
            .then(data => {
                let prev_iddet = null;
                let asientosContainer = document.getElementById("asientos_container");
                let a = "";
                asientosContainer.innerHTML = '';

                data.forEach(asiento => {
                    if (asiento.idDet !== prev_iddet) {
                        if (prev_iddet !== null) {
                            a += '</div>';
                        }

                        a += '<div class="asientos_chk">';
                        prev_iddet = asiento.idDet;
                    }

                    let checkbox = '<div class="cambio_chk">';
                    checkbox += '<input name="check_asiento[]" value="' + asiento.nombre + "-" + asiento.idPeli + '" type="checkbox" class="btn_sala ' + (asiento.estado === 'ocupado' ? 'desactivado' : '') + '" ' + (asiento.estado === 'ocupado' ? 'disabled' : '') + '>';
                    checkbox += '<img src="../img/' + (['A10', 'A11', 'A12', 'B10', 'B11', 'B12'].includes(asiento.nombre) ? 'discapacitado.png' : 'img_asientos.png') + '" width="20px" height="20px">';
                    checkbox += '</div>';
                    a += checkbox;
                });

                if (prev_iddet !== null) {
                    a += '</div>';
                }
                asientosContainer.innerHTML = a;

                cargarModificarAsientos();
            })
            .catch(error => {
                console.error("Error en la llamada Fetch:", error);
            });
}




function cargarModificarAsientos() {
    document.getElementById('btn_reserva').addEventListener('click', function (event) {
        event.preventDefault();

        var checkboxes = document.querySelectorAll('.btn_sala');
        var contador = 0;
        var formulario = document.getElementById('form_id');

        checkboxes.forEach(function (checkbox) {
            if (checkbox.checked) {
                contador++;
            }
        });


        if (contador === 0) {
            Swal.fire({
                icon: "error",
                title: "Oops...",
                text: "¡Olvidaste seleccionar tu asiento!"
            });
        }
    });


    var texto = document.getElementById('butaca_seleccionadas');
    var contadorTexto = document.getElementById('contador_seleccionados');
    var contador_asientos = document.getElementById('contador_asientos');

    const checkboxes = document.querySelectorAll('input[name^="check_asiento["]');

    checkboxes.forEach(checkbox => {
        checkbox.addEventListener('change', function () {
            var contenedor = this.parentElement;
            contenedor.style.backgroundColor = this.checked ? 'purple' : 'white';

            var seleccionados = document.querySelectorAll('input[name^="check_asiento["]:checked');
            var contador = seleccionados.length;

            texto.textContent = `Butacas seleccionadas: ${Array.from(seleccionados)
                    .map(cb => cb.value.split('-')[0])
                    .join(', ')}`;

            contadorTexto.textContent = `Entradas: ${contador}`;

            contador_asientos.value = contador;

            var precioSeleccionado = parseFloat(document.getElementById('precio_seleccionados_input').value);
            var precio_total = precioSeleccionado * contador;

            var text_precio_total = document.getElementById('precio_total');
            text_precio_total.textContent = `Precio Total: S/. ${precio_total.toFixed(2)}`;
            document.getElementById('precio_total_input').value = `${precio_total.toFixed(2)}`;
        });
    });


    var btn_reserva = document.getElementById('btn_reserva');


    /***************************************************************/
    // INSERTAR ASIENTOS, PRECIOS, CANTIDAD
    /***************************************************************/
    btn_reserva.addEventListener("click", function (event) {
        var formData = $("#form_id").serialize();
        event.preventDefault();
        Swal.fire({
            title: "¿Asientos correctos?",
            text: "Elige bien tus asientos",
            icon: "warning",
            showCancelButton: true,
            confirmButtonColor: "#3085d6",
            cancelButtonColor: "#d33",
            confirmButtonText: "Sí, agregar película!"
        }).then((result) => {
            if (result.isConfirmed) {
                $.ajax({
                    type: 'POST',
                    url: '../ControladorReservas?seleccionarAsientos=true',
                    data: formData,
                    success: function (response) {

                        window.location.href = '/Proyecto_Avance1/Vista/CompraCombos.jsp';
                    },
                    error: function (xhr, status, error) {
                        alert('Error: ' + error);
                        Swal.fire({
                            title: "Error",
                            text: "No se pudo agregar la película.",
                            icon: "error"
                        });
                    }
                });
            }
        });
    });

       /***************************************************************/
    // CERRAR SESION DE PELICULAS
    /***************************************************************/
        var nom = document.getElementById("cancelar_a");

        nom.addEventListener("click", function () {
            event.preventDefault();
            Swal.fire({
                title: '¿Estás seguro?',
                text: '¿Cancelar compra de película?',
                icon: 'warning',
                showCancelButton: true,
                confirmButtonText: 'Sí',
                cancelButtonText: 'No'
            }).then((result) => {
                if (result.isConfirmed) {
                    fetch("../ControladorReservas?cerrarReserva=true", {
                        method: 'GET'
                    })
                            .then(response => {
                                if (response.ok) {
                                    console.log('Éxito: Redirección en la sede de combo');

                                    Swal.fire({
                                        title: '¡Éxito!',
                                        text: '',
                                        icon: 'success',
                                        confirmButtonText: 'Aceptar'
                                    }).then(() => {
                                        window.location.href = '/Proyecto_Avance1/Vista/SeleccionPelicula.jsp';
                                    });
                                } else {
                                    throw new Error("La respuesta ERROR");
                                }
                            })
                            .catch(error => {
                                console.error('Error al obtener datos:', error);
                                Swal.fire({
                                    title: 'Error',
                                    text: 'Hubo un ERROR.',
                                    icon: 'error',
                                    confirmButtonText: 'Aceptar'
                                });
                            });
                }
            });
        });
    



}



