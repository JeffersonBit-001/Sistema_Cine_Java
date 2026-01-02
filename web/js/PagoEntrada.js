/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

cargarPrincipal();

function cargarPrincipal() {
    fetch("../ControladorReservas?cargarCombosSeleccionados=true")
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
                } 
            })
            .catch(error => {
                console.error('Error al obtener datos:', error);
            });
}







/**************************/


const billeteraTitulo = document.getElementById('billetera');
const btnFact = document.getElementById('comprobante');
const cir1 = document.getElementById('cir1');
const cir2 = document.getElementById('cir2');
const cir3 = document.getElementById('cir3');
const elementoMostrar = document.querySelector('.esconder_billetera');
const esconder_tarjeta = document.querySelector('.esconder_tarjeta');
const esconder_content_bol_fac = document.getElementById('content_bol_fac');
const num_tarjeta = document.getElementById('num_tarjeta');
const tipo = document.getElementById('tipo');
const mes = document.getElementById('mes');
const año = document.getElementById('año');
const cvv = document.getElementById('cvv');
const doc = document.getElementById('doc');
const num = document.getElementById('num');
const doc2 = document.getElementById('doc2_');
const num2 = document.getElementById('num2');
const terminos_crear = document.getElementById('terminos_crear');
const promociones_crear = document.getElementById('promociones_crear');
const formulario = document.getElementById('form_id');
const btn = document.getElementById('btn_reserva');
const tarjeta_title = document.getElementById('tarjeta_title');

billeteraTitulo.addEventListener('click', function () {
    const estiloActual = window.getComputedStyle(elementoMostrar);
    if (estiloActual.display === 'none') {
        elementoMostrar.style.display = 'block';
        cir2.style.backgroundColor = 'red';
        cir1.style.backgroundColor = 'white';
        esconder_tarjeta.style.display = 'none';
    } else {
        elementoMostrar.style.display = 'none';
        cir2.style.backgroundColor = 'white';

        // Reiniciar valores de formulario
        num2.value = "";
        doc2.value = "Tipo de documento";
    }
});

tarjeta_title.addEventListener('click', function () {
    const estiloActual2 = window.getComputedStyle(esconder_tarjeta);
    if (estiloActual2.display === 'none') {
        esconder_tarjeta.style.display = 'block';
        cir1.style.backgroundColor = 'red';
        cir2.style.backgroundColor = 'white';
        elementoMostrar.style.display = 'none';
    } else {
        esconder_tarjeta.style.display = 'none';
        cir1.style.backgroundColor = 'white';

        // Reiniciar valores de formulario
        num_tarjeta.value = "";
        tipo.value = "Tipo de Tarjeta";
        mes.value = "Mes";
        año.value = "Año";
        cvv.value = "";
        doc.value = "Tipo de documento";
        num.value = "";
    }
});



btn.addEventListener('click', function (event) {
    event.preventDefault();

    const estilo = window.getComputedStyle(esconder_tarjeta);
    if (estilo.display === 'block') {
        if (num_tarjeta.value === "" || tipo.value === "Tipo de Tarjeta" || mes.value === "Mes" || año.value === "Año" || cvv.value === "" ||
                doc.value === "Tipo de documento" || num.value === "" || !terminos_crear.checked || !promociones_crear.checked) {
            Swal.fire({
                icon: "error",
                title: "Oops...",
                text: "Complete todos los campos!",
            });
        } else {
            fetch("../ControladorReservas?realizarPago=true", {
                method: 'GET'
            })
                    .then(response => {

                        if (response.ok) {
                            return response.json();
                        } else {
                            throw new Error('Error en la respuesta del servidor');
                        }
                    })
                    .catch(error => {
                        console.error('Error al obtener datos:', error);
                    });
            Swal.fire({
                icon: "success",
                text: "Pago Exitoso!"
            }).then((result) => {
                    if (result.isConfirmed) {
                        formulario.submit();
                    }
                });
        }
    }

    const estilo2 = window.getComputedStyle(elementoMostrar);
    if (estilo2.display === 'block') {
        if (doc2.value === "Tipo de documento" || num2.value === "" || !terminos_crear.checked || !promociones_crear.checked) {
            Swal.fire({
                icon: "error",
                title: "Oops...",
                text: "Complete todos los campos!"
            });
        } else {
            fetch("../ControladorReservas?realizarPago=true", {
                method: 'GET'
            })
                    .then(response => {

                        if (response.ok) {
                            return response.json();
                        } else {
                            throw new Error('Error en la respuesta del servidor');
                        }
                    })
                    .catch(error => {
                        console.error('Error al obtener datos:', error);
                    });
            Swal.fire({
                icon: "success",
                text: "Pago Exitoso!"
            }).then((result) => {
                    if (result.isConfirmed) {
                        formulario.submit();
                    }
                });
        }
    }
});



const yapeImg = document.getElementById('yape');
const plinImg = document.getElementById('plin');


const yapeImgHover = '../img/qr1.png';
const plinImgHover = '../img/qr2.png';


yapeImg.addEventListener('mouseover', function () {
    yapeImg.src = yapeImgHover;
});

yapeImg.addEventListener('mouseout', function () {
    yapeImg.src = '../img/yape.png';
});


plinImg.addEventListener('mouseover', function () {
    plinImg.src = plinImgHover;
});

plinImg.addEventListener('mouseout', function () {
    plinImg.src = '../img/plin.png';
});







/*
const contentNegro = document.getElementById('content_negro');
const tecla = document.getElementById('resumen');

contentNegro.addEventListener('click', function () {
    const estiloActual = window.getComputedStyle(contentNegro);

    if (estiloActual.display === 'block') {
        contentNegro.style.display = 'none';
    }
});


tecla.addEventListener('click', function () {
    const estiloActual = window.getComputedStyle(contentNegro);

    if (estiloActual.display === 'block') {
        contentNegro.style.display = 'none';
    } else {
        contentNegro.style.display = 'block';
    }
});*/

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
