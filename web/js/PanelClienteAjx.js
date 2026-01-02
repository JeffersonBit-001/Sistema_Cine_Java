/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

    cargarDatos();

function cargarDatos() {
    fetch("../ControladorPanelCliente?valx=true")
            .then(response => {
                if (!response.ok) {
                    throw new Error("Network response was not ok " + response.statusText);
                }
                return response.json();
            })
            .then(data => {
                document.getElementById('title_nombre').textContent = data.nombres + " " + data.apellidos;
                document.getElementById('id').value = data.id;
                document.getElementById('nombres').value = data.nombres;
                document.getElementById('apellidos').value = data.apellidos;
                document.getElementById('dni').value = data.dni;
                document.getElementById('genero').value = data.genero;
                document.getElementById('nacimiento').value = data.nacimiento;
                document.getElementById('domicilio').value = data.domicilio;
                document.getElementById('cel').value = data.cel;
                document.getElementById('email').value = data.correo;
                document.getElementById('emailc').value = data.correo;
                document.getElementById('pass').value = data.pass;
                document.getElementById('passc').value = data.pass;

                console.log(data);

            })
            .catch(error => {
                console.error('Error al obtener datos:', error);
            });

}

var buttonModificar = document.getElementById("actualizar_datos");
var buttonEliminar = document.getElementById("eliminar_datos");
var cerrarSes = document.getElementById("cerrar_sesion");

buttonModificar.addEventListener("click", function () {
    modificarDatos();
});

buttonEliminar.addEventListener("click", function () {
    eliminarDatos();
});

cerrarSes.addEventListener("click", function () {
    cerrarTodo();
});

function modificarDatos() {
    event.preventDefault();

    var cliente = {
        id: $('#id').val(),
        nombres: $('#nombres').val(),
        apellidos: $('#apellidos').val(),
        dni: $('#dni').val(),
        genero: $('#genero').val(),
        nacimiento: $('#nacimiento').val(),
        domicilio: $('#domicilio').val(),
        cel: $('#cel').val(),
        correo: $('#email').val(),
        correo_confirm: $('#emailc').val(),
        pass: $('#pass').val(),
        pass_confirm: $('#passc').val()
    };

    Swal.fire({
        title: '¿Estás seguro?',
        text: "¿Deseas modificar tus credenciales?",
        icon: 'question',
        showCancelButton: true,
        confirmButtonText: 'Sí, modificar',
        cancelButtonText: 'No, cancelar'
    }).then((result) => {
        if (result.isConfirmed) {
            $.ajax({
                url: "http://localhost:8081/cliServer/modificarAjax/" + cliente.id,
                type: 'PUT',
                contentType: 'application/json',
                data: JSON.stringify(cliente),
                success: function (response) {
                    Swal.fire({
                        title: '¡Éxito!',
                        text: 'Modificación Exitosa',
                        icon: 'success',
                        confirmButtonText: 'OK'
                    }).then(() => {
                        console.log("Datos modificados: ", response.cliente);
                        server(response.cliente);

                        cargarDatos();
                    });


                },
                error: function (xhr, status, error) {
                    Swal.fire({
                        title: 'Error',
                        text: 'Error al modificar: ' + xhr.responseText,
                        icon: 'error',
                        confirmButtonText: 'Aceptar'
                    });

                    console.log('Error modificar data', status, error);
                }
            });
        } else {
            Swal.fire({
                title: 'Cancelado',
                text: 'La modificación fue cancelada.',
                icon: 'info',
                confirmButtonText: 'Aceptar'
            });
        }
    });
}

function eliminarDatos() {
    event.preventDefault();

    var id = document.getElementById("id").value;

    Swal.fire({
        title: '¿Estás seguro?',
        text: "¿Deseas Eliminar tus credenciales?",
        icon: 'question',
        showCancelButton: true,
        confirmButtonText: 'Sí, eliminar',
        cancelButtonText: 'No, cancelar'
    }).then((result) => {
        if (result.isConfirmed) {
            $.ajax({
                url: "http://localhost:8081/cliServer/eliminarAjax/" + id,
                type: "DELETE",
                contentType: 'application/json',
                success: function (response) {
                    Swal.fire({
                        title: '¡Éxito!',
                        text: 'Elimanción Exitosa',
                        icon: 'success',
                        confirmButtonText: 'OK'
                    }).then(() => {
                        console.log("Datos eliminados: ", response.cliente);
                        cerrarSesion(response.cliente);
                        window.location.href = "PanelCliente.jsp";
                    });



                    cargarDatos();
                },
                error: function (xhr, status, error) {
                    Swal.fire({
                        title: 'Error',
                        text: 'Error al eliminar: ' + xhr.responseText,
                        icon: 'error',
                        confirmButtonText: 'Aceptar'
                    });

                    console.log('Error al eliminar data', status, error);
                }
            });
        } else {
            Swal.fire({
                title: 'Cancelado',
                text: 'La eliminación fue cancelada.',
                icon: 'info',
                confirmButtonText: 'Aceptar'
            });
        }
    });
}


function server(user) {

    fetch('../ControladorPanelCliente?actualizarSesion=true', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)
    })
            .then(response => response.json())
            .then(data => {
                console.log('El servidor recibió los datos:', data);
            })
            .catch(error => {
                console.error('Error al enviar los datos al servidor:', error);
            });
}

function cerrarSesion() {
    fetch('../ControladorPanelCliente?cerrarSesion=true', {
        method: 'GET'
    })
            .then(response => response.json())
            .then(data => {
                console.log('El servidor respondió:', data);
            })
            .catch(error => {
                console.error('Error al llamar al servidor:', error);
            });
}


function cerrarTodo() {
    Swal.fire({
        title: '¿Estás seguro?',
        text: '¿Quieres cerrar sesión?',
        icon: 'warning',
        showCancelButton: true,
        confirmButtonText: 'Sí, cerrar sesión',
        cancelButtonText: 'No, cancelar'
    }).then((result) => {
        if (result.isConfirmed) {
            fetch('../ControladorPanelCliente?cerrarSesion=true', {
                method: 'GET'
            })
                    .then(response => {
                        if (!response.ok) {
                            throw new Error('Error en la respuesta del servidor: ' + response.status);
                        }
                        return response.text();
                    })
                    .then(text => {
                        try {
                            const data = JSON.parse(text);
                            console.log('Servidor:', data);
                            window.location.href = "PanelCliente.jsp";

                        } catch (error) {
                            console.error('Error al analizar el JSON:', error, 'Respuesta del servidor:', text);
                            Swal.fire({
                                title: 'Error',
                                text: 'Hubo un problema al cerrar la sesión.',
                                icon: 'error',
                                confirmButtonText: 'Aceptar'
                            });
                        }
                    })
                    .catch(error => {
                        console.error('Error al llamar al servidor:', error);
                        Swal.fire({
                            title: 'Error',
                            text: 'No se pudo comunicar con el servidor.',
                            icon: 'error',
                            confirmButtonText: 'Aceptar'
                        });
                    });
        } else {
            Swal.fire({
                title: 'Cancelado',
                text: 'La sesión no fue cerrada.',
                icon: 'info',
                confirmButtonText: 'Aceptar'
            });
        }
    });
}
