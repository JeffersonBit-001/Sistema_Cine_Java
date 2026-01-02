/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
var cerrarSes = document.getElementById("salir_button");

cerrarSes.addEventListener("click", function () {
    cerrarTodo();
});

function cerrarTodo() {
    event.preventDefault();
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
                            window.location.href = "AdmUsuarios.jsp";

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
