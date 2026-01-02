/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

const container = document.getElementById('container');
const registerBtn = document.getElementById('register');
const loginBtn = document.getElementById('login');
const divLogin = document.querySelector('.login_register');
const divRegister = document.querySelector('.create_register');

registerBtn.addEventListener('click', () => {
    vacear2();
});

loginBtn.addEventListener('click', () => {
    vacear();
});

function vacear() {
    grecaptcha.reset();
    document.getElementById('nombres').value = "";
    document.getElementById('apellidos').value = "";
    document.getElementById('dni').value = "";
    document.getElementById('genero').value = "";
    document.getElementById('nacimiento').value = "";
    document.getElementById('telefono').value = "";
    document.getElementById('domicilio').value = "";
    document.getElementById('correo').value = "";
    document.getElementById('correo_confirm').value = "";
    document.getElementById('pass').value = "";
    document.getElementById('pass_confirm').value = "";
    container.classList.remove("active");
    divLogin.style.display = "block";
    divRegister.style.display = "none";
}

function vacear2() {
    grecaptcha.reset();
    document.getElementById('correo2').value = "";
    document.getElementById('pass2').value = "";
    container.classList.add("active");
    divLogin.style.display = "none";
    divRegister.style.display = "block";
}


$("#form_id_sesion").on("submit", function (e) {
    e.preventDefault();

    var recaptchaLoginResponse = grecaptcha.getResponse();
    var correo = $("#correo2").val();
    var password = $("#pass2").val();

    if (correo === "" || password === "") {
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Por favor, ingrese todos los campos.',
            heightAuto: false
        });
        return;
    }

    if (!recaptchaLoginResponse) {
        Swal.fire({
            icon: 'error',
            title: 'reCAPTCHA no validado',
            text: 'Por favor, complete el reCAPTCHA.',
            heightAuto: false
        });
        return;
    }

    $.ajax({
        url: 'http://localhost:8081/cliServer/login',
        type: 'POST',
        data: {
            correo: correo,
            password: password,
            recaptchaResponse: recaptchaLoginResponse
        },
        success: function (response) {
            if (response.message === "Administrador") {
                Swal.fire({
                    icon: 'success',
                    title: 'Login exitoso',
                    text: 'Bienvenido Administrador',
                    heightAuto: false
                }).then(() => {
                    console.log(response.user);
                    server(response.user, response.message);
                    window.location.href = "../VistaAdministrador/AdmUsuarios.jsp";
                });
                ;

            } else if (response.message === "Cliente") {
                Swal.fire({
                    icon: 'success',
                    title: 'Login exitoso',
                    text: 'Bienvenido Cliente',
                    heightAuto: false
                }).then(() => {
                    console.log(response.user);
                    server(response.user, response.message);
                    window.location.href = "PanelCliente.jsp";
                });
                ;

            } else {
                Swal.fire({
                    icon: 'warning',
                    title: 'Atención',
                    text: response.message,
                    heightAuto: false
                });
            }
        },
        error: function (xhr, status, error) {
            if (xhr.responseJSON && xhr.responseJSON.message) {
                Swal.fire({
                    icon: 'error',
                    title: 'Error xd',
                    text: xhr.responseJSON.message,
                    heightAuto: false
                });
                document.getElementById('correo2').value = "";
                document.getElementById('pass2').value = "";
                grecaptcha.reset();
            } else {
                Swal.fire({
                    icon: 'error',
                    title: 'Error desconocido',
                    text: 'Ocurrió un problema al intentar procesar tu solicitud.',
                    heightAuto: false
                });
            }
        }
    });
});

function server(user, message) {

    fetch('../ControladorLogin?sesion=' + message, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)
    })
            .then(response => response.json())
            .then(data => {
                console.log('Servidor recibió el objeto:', data);
            })
            .catch(error => {
                console.error('Error al enviar los datos al servidor:', error);
            });
}



$("#form_id_create").on("submit", function (e) {
    e.preventDefault();

    var nombres = $("input[name='nombres']").val();
    var apellidos = $("input[name='apellidos']").val();
    var dni = $("input[name='dni']").val();
    var genero = $("select[name='genero']").val();
    var nacimiento = $("input[name='nacimiento']").val();
    var telefono = $("input[name='telefono']").val();
    var domicilio = $("input[name='domicilio']").val();
    var correo = $("input[name='correo']").val();
    var correoConfirm = $("input[name='correo_confirm']").val();
    var pass = $("input[name='pass']").val();
    var passConfirm = $("input[name='pass_confirm']").val();

    if (!nombres || !apellidos || !dni || !genero || !nacimiento || !telefono || !domicilio || !correo || !correoConfirm || !pass || !passConfirm) {
        alert("Por favor, ingrese todos los campos.");
        return;
    }

    if (correo !== correoConfirm) {
        alert("Los correos no coinciden.");
        return;
    }

    if (pass !== passConfirm) {
        alert("Las contraseñas no coinciden.");
        return;
    }

    $.ajax({
        url: 'http://localhost:8081/cliServer/register',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({
            nombres: nombres,
            apellidos: apellidos,
            dni: dni,
            genero: genero,
            nacimiento: nacimiento,
            cel: telefono,
            domicilio: domicilio,
            correo: correo,
            pass: pass,
            pass_confirm: passConfirm,
            correo_confirm: correoConfirm
        }),
        success: function (response) {
            Swal.fire({
                icon: 'success',
                title: 'Registro Exitoso',
                text: response.message,
                showConfirmButton: false,
                timer: 1500,
                heightAuto: false
            }).then(() => {
                vacear();
            });
        },
        error: function (xhr, status, error) {
            if (xhr.responseJSON && xhr.responseJSON.message) {
                Swal.fire({
                    icon: 'error',
                    title: 'Error',
                    text: xhr.responseJSON.message,
                    heightAuto: false
                });
            } else {
                Swal.fire({
                    icon: 'error',
                    title: 'Error desconocido',
                    text: 'Ocurrió un error en el registro.',
                    heightAuto: false
                });
            }
        }
    });
});

