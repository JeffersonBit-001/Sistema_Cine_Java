/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

cargarTipoBien();
cargarEnvio();

function cargarTipoBien() {
    fetch('../ControladorLibroReclamaciones?estadoSele=tipo_bien_mostrar', {
        method: 'GET'
    })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Error en la respuesta de la red');
                }
                return response.json();
            })
            .then(data => {

                estad('#tipo_bien', data, 'Selecciona tipo de bien');
                cargarTipoReclamacion();
            })
            .catch(error => {
                console.error('Error al obtener categoría:', error);
            });
}

function cargarTipoReclamacion() {
    fetch('../ControladorLibroReclamaciones?estadoSele=tipo_reclamacion_mostrar', {
        method: 'GET'
    })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Error en la respuesta de la red');
                }
                return response.json();
            })
            .then(data => {

                estad2('#tipo_reclamacion', data, 'Selecciona tipo de reclamación');
                cargarCheck();
            })
            .catch(error => {
                console.error('Error al obtener categoría:', error);
            });
}

function cargarCheck() {
    fetch("../ControladorLibroReclamaciones?estadoSele=tipo_check_mostrar")
            .then(response => {
                if (!response.ok) {
                    throw new Error("Network response was not ok " + response.statusText);
                }
                return response.json();
            })
            .then(data => {

                const tbody = document.querySelector("#cargar_check_box");
                tbody.innerHTML = "";
                let text = "";
                data.forEach(checkx => {
                    let a = `
                        <div class="checkbox-group">
                            <input type="checkbox" id="${checkx.tipo_condicion.id}" 
                                   name="terminos${checkx.tipo_condicion.id}" 
                                   value="${checkx.tipo_condicion.id}">
                            <label for="${checkx.tipo_condicion.id}">${checkx.tipo_condicion.descripcion}</label>
                        </div>
                    `;

                    text = text + a;
                });

                tbody.innerHTML = text;
            })
            .catch(error => {
                console.error('Error al obtener datos:', error);
            });
}

function estad(selector, data, nom) {
    $(selector).empty();
    $(selector).append(`<option value="" disabled selected>${nom}</option>`);

    data.forEach(tipo => {

        $(selector).append(`
                    <option value="${tipo.tipo_bien.id}" data-name="${tipo.tipo_bien.nombre}">
                        ${tipo.tipo_bien.nombre}
                    </option>
                `);

    });
}
;

function estad2(selector, data, nom) {
    $(selector).empty();
    $(selector).append(`<option value="" disabled selected>${nom}</option>`);

    data.forEach(tipo => {

        $(selector).append(`
                    <option value="${tipo.tipo_reclamacion.id}" data-name="${tipo.tipo_reclamacion.nombre}">
                        ${tipo.tipo_reclamacion.nombre}
                    </option>
                `);

    });
}



function cargarEnvio() {
    var button = document.getElementById("button_enviar");

    button.addEventListener('click', function (event) {
        event.preventDefault();

        Swal.fire({
            title: "¿Datos correctos?",
            text: "¿Quieres agregar esta Reclamación?",
            icon: "warning",
            showCancelButton: true,
            confirmButtonColor: "#3085d6",
            cancelButtonColor: "#d33",
            confirmButtonText: "Sí, agregar Reclamación!"
        }).then((result) => {
            if (result.isConfirmed) {
                $.ajax({
                    type: 'POST',
                    url: '../ControladorLibroReclamaciones?accion=EnviarReclamacion',
                    data: new FormData($('#form_id')[0]),
                    processData: false,
                    contentType: false,
                    success: function (response) {
                        
                        try {
                            const data = JSON.parse(response);

                            if (data.status === "success") {
                                Swal.fire({
                                    title: "¡Agregado!",
                                    text: data.message,
                                    icon: "success"
                                }).then(() => {
                                    window.location.href = "/Proyecto_Avance1/Vista/LibroReclamaciones.jsp";
                                });
                            } else {
                                Swal.fire({
                                    title: "Error",
                                    text: data.message,
                                    icon: "error"
                                });
                            }
                        } catch (error) {
                            console.error('Error al procesar la respuesta:', error);
                            Swal.fire({
                                title: "Error",
                                text: "No se pudo agregar la Reclamación. Inténtalo nuevamente.",
                                icon: "error"
                            });
                        }
                    },
                    error: function (xhr, status, error) {
                        console.error('Error en la solicitud AJAX:', error);
                        Swal.fire({
                            title: "Error",
                            text: "No se pudo agregar la Reclamación. Inténtalo nuevamente.",
                            icon: "error"
                        });
                    }
                });
            }
        });
    });
}


