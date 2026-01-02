/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

mostrarInfoReserva();

function mostrarInfoReserva() {
    fetch("../ControladorReservas?mostrarInfoReserva=mostrarInfo")
            .then(response => {
                if (!response.ok) {
                    throw new Error("Network response was not ok " + response.statusText);
                }
                return response.json();
            })
            .then(data => {
                if (data.cantidadEntradas !== 0) {
                    document.getElementById('img_pelicula').src = "../img/" + data.peli.img;
                    document.getElementById('img_pelicula').style.width = "200px"; 
                    document.getElementById('img_pelicula').style.height = "200px";
                    document.getElementById('titulo_peli').textContent = "" + data.peli.nombre;
                    document.getElementById('disponible_peli').textContent = "🔻 " + data.peli.disponible;
                    document.getElementById('sede_peli').textContent = data.sede.nombre;
                    document.getElementById('dia_peli').textContent = "📅 " + data.dia.nombre;
                    document.getElementById('hora_peli').textContent = "🕛 " + data.hora.nombre;
                    document.getElementById('sala_peli').textContent = "⚪ " + data.peli.sala;
                } else {
                    document.getElementById('img_pelicula').src = "";
                    let tbody = document.querySelector("#edit_resumen_text");
                    tbody.innerHTML = "<div><h5 id='precio_total'>Precio Total: S/. 0.00</h5></div>";
                }
                
                cargarPrincipal();
            })

            .catch(error => {
                console.error('Error al obtener datos:', error);
            });
}



function cargarPrincipal() {
    fetch("../ControladorReservas?cargarCombosSeleccionados=true")
            .then(response => {
                if (!response.ok) {
                    throw new Error("Network response was not ok " + response.statusText);
                }
                return response.json();
            })
            .then(data => {
                document.getElementById('precio_total').textContent = "Precio Total Combos: S/. " + data.precioCarritoCompras;




                let tbody = document.querySelector("#lista-carrito-tbody");
                tbody.innerHTML = "";

                if (Array.isArray(data.arrayCarritoCombos) && data.arrayCarritoCombos.length > 0) {
                    data.arrayCarritoCombos.forEach(combo => {
                        let row = document.createElement('tr');

                        row.innerHTML = `
                        <input type="hidden" value="${combo.id}"/>
                        <td>${combo.tabla}</td>
                        <td><img src="${combo.imagen}" width="100"></td>
                        <td>${combo.titulo}</td>
                        <td>${combo.precio}</td>
                        <td>${combo.cantidad}</td>
                    `;

                        tbody.appendChild(row);
                    });
                } else {
                    tbody = document.querySelector("#lista-carrito-tbody");
                    tbody.innerHTML = "";
                    tbody = document.querySelector("#carrito");
                    tbody.innerHTML = "";
                    tbody.innerHTML = "<h1>No has seleccionado un combo</h1><br><a href='CombosGeneral.jsp'>Elegir Combos</a>\n\
        <br><p>!IMPORTANTE¡ No es necario elegir un combo para continuar</p>";
                }


            })
            .catch(error => {
                console.error('Error al obtener datos:', error);
            });
}


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