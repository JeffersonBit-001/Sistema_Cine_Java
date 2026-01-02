/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

cargarEnvio();
function cargarEnvio() {
    var button = document.getElementById("button_enviar");
    var form = document.getElementById("form_id");

    button.addEventListener('click', function (event) {
        event.preventDefault();

        var formData = $("#form_id").serialize();
        console.log("Datos a enviar: ", formData);

        if (formData === "") {
            Swal.fire({
                title: "Error",
                text: "No hay datos para enviar.",
                icon: "error"
            });
            return;
        }

        Swal.fire({
            title: "¿Datos correctos?",
            text: "¿Quieres enviar este mensaje?",
            icon: "warning",
            showCancelButton: true,
            confirmButtonColor: "#3085d6",
            cancelButtonColor: "#d33",
            confirmButtonText: "Sí, enviar mensaje!"
        }).then((result) => {
            if (result.isConfirmed) {
                $.ajax({
                    type: 'POST',
                    url: '../ControladorSugerencias?accion=EnviarSugerencia',
                    data: formData,
                    success: function (response) {
                        try {
                            const data = JSON.parse(response);
                            if (data.status === "success") {
                                Swal.fire({
                                    title: "¡Enviado!",
                                    text: data.message,
                                    icon: "success"
                                }).then(() => {
                                    window.location.href = "/Proyecto_Avance1/Vista/FormSugerencia.jsp";
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
                                text: "No se pudo enviar el mensaje. Inténtalo nuevamente.",
                                icon: "error"
                            });
                        }
                    },
                    error: function (xhr, status, error) {
                        console.error('Error en la solicitud AJAX:', error);
                        Swal.fire({
                            title: "Error",
                            text: "No se pudo enviar el mensaje. Inténtalo nuevamente.",
                            icon: "error"
                        });
                    }
                });
            }
        });
    });
}
