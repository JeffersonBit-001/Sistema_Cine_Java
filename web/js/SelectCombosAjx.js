/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

cargarPrincipal();

function cargarPrincipal() {
    fetch("../ControladorCombosIndex?accion=Combos&cargar=true&objeto=comboss")
            .then(response => {
                if (!response.ok) {
                    throw new Error("Network response was not ok " + response.statusText);
                }
                return response.json();
            })
            .then(data => {

                document.getElementById('img_sede_print').src = "../img/" + data[0].sedes.img;
                document.getElementById('h3_sede_print').textContent = "Combos " + data[0].sedes.nombre;

                const tbody = document.querySelector("#cargar_comboss");
                tbody.innerHTML = "";
                let text = "";
                data.forEach(combox => {
                    let a = `
                    <div class="col-lg-4 col-md-6 edit_separar div_comb_beb_dul" data-link="combos" data-subcat="${combox.categoria}">
                        <div class="card">
                            <img src="../img/${combox.imagen}" class="imagen-curso u-full-width">
                            <div class="info-card">
                                <div class="team position-relative overflow-hidden">
                                    <div class="position-relative">
                                        <div class="team-text bg-white text-white">
                                            <h4 class="text-black text_edit_nom">${combox.nombre}</h4>
                                            <p class="content_text_edit">CineStar</p>
                                        </div>
                                        <div class="team-social bg-dark text-center">
                                            <a class="btn btn-outline-primary btn-square mr-2" href="#"><i class="fa-regular fa-eye fa-xl" style="color: #fd8b8b;"></i></a>
                                            <p class="m-0 cursor_p" style="color: #fd8b8b;">Más Información</p>
                                        </div>
                                    </div>
                                </div>
                                <img src="../img/estrellas.png">
                                <div class="flex_edit_cont_precio">
                                    <div class="container_selector margin_conta">
                                        <button href="#" class="u-full-width input borrar-curso button_t aumentar carrito_eliminar_e" data-id="${combox.id}" data-nombre="Combos">-</button>
                                        <input type="text" class="input_t valorInput marg_edt" value="0" data-idii="${combox.id}" data-nombre2="Combos" readonly>
                                        <button href="#" class="u-full-width button-primary input agregar-carrito button_t disminuir" data-id="${combox.id}" data-nombre="Combos">+</button>
                                    </div>
                                    <p class="precio"><span class="u-pull-right">S/${combox.precio}</span></p>
                                </div>
                            </div>
                        </div> <!--.card-->
                    </div>
                `;

                    text = text + a;
                });

                tbody.innerHTML = text;
                cargarDulceria(text);
            })
            .catch(error => {
                console.error('Error al obtener datos:', error);
            });
}


function cargarDulceria(text) {
    fetch("../ControladorCombosIndex?accion=Combos&cargar=true&objeto=dulceria")
            .then(response => {
                if (!response.ok) {
                    throw new Error("Network response was not ok " + response.statusText);
                }
                return response.json();
            })
            .then(data => {

                const tbody = document.querySelector("#cargar_comboss");

                data.forEach(combox => {
                    let a = `
                <div class="col-lg-4 col-md-6 edit_separar div_comb_beb_dul" data-link="dulceria" data-subcat="${combox.categoria}">
                    <div class="card">
                        <img src="../img/${combox.imagen}" class="imagen-curso u-full-width">
                        <div class="info-card">
                            <div class="team position-relative overflow-hidden">
                                <div class="position-relative">
                                    <div class="team-text bg-white text-white">
                                        <h4 class="text-black text_edit_nom">${combox.nombre}</h4>
                                        <p class="content_text_edit">CineStar</p>
                                    </div>
                                    <div class="team-social bg-dark text-center">
                                        <a class="btn btn-outline-primary btn-square mr-2" href="#"><i class="fa-regular fa-eye fa-xl" style="color: #fd8b8b;"></i></a>
                                        <p class="m-0 cursor_p" style="color: #fd8b8b;">Más Información</p>
                                    </div>
                                </div>
                            </div>
                            <img src="../img/estrellas.png" alt="Estrellas">
                            <div class="flex_edit_cont_precio">
                                <div class="container_selector margin_conta">
                                    <button type="button" class="u-full-width input borrar-curso button_t aumentar carrito_eliminar_e" data-id="${combox.id}" data-nombre="Dulceria">-</button>
                                    <input type="text" class="input_t valorInput marg_edt" value="0" data-idii="${combox.id}" data-nombre2="Dulceria" readonly>
                                    <button type="button" class="u-full-width button-primary input agregar-carrito button_t disminuir" data-id="${combox.id}" data-nombre="Dulceria">+</button>
                                </div>
                                <p class="precio">
                                    <span class="u-pull-right">S/${combox.precio}</span>
                                </p>
                            </div>
                        </div>
                    </div> <!--.card-->
                </div>
            `;


                    text = text + a;
                });

                tbody.innerHTML = text;
                cargarBebida(text);
            })
            .catch(error => {
                console.error('Error al obtener datos:', error);
            });
}


function cargarBebida(text) {
    fetch("../ControladorCombosIndex?accion=Combos&cargar=true&objeto=bebida")
            .then(response => {
                if (!response.ok) {
                    throw new Error("Network response was not ok " + response.statusText);
                }
                return response.json();
            })
            .then(data => {

                const tbody = document.querySelector("#cargar_comboss");

                data.forEach(combox => {
                    let a = `
                        <div class="col-lg-4 col-md-6 edit_separar div_comb_beb_dul" data-link="bebidas" data-subcat="${combox.categoria}">
                            <div class="card">
                                <img src="../img/${combox.imagen}" class="imagen-curso u-full-width">
                                <div class="info-card">
                                    <div class="team position-relative overflow-hidden">
                                        <div class="position-relative">
                                            <div class="team-text bg-white text-white">
                                                <h4 class="text-black text_edit_nom">${combox.nombre}</h4>
                                                <p class="content_text_edit">CineStar</p>
                                            </div>
                                            <div class="team-social bg-dark text-center">
                                                <a class="btn btn-outline-primary btn-square mr-2" href="#"><i class="fa-regular fa-eye fa-xl" style="color: #fd8b8b;"></i></a>
                                                <p class="m-0 cursor_p" style="color: #fd8b8b;">Más Información</p>
                                            </div>
                                        </div>
                                    </div>
                                    <img src="../img/estrellas.png" alt="Estrellas">
                                    <div class="flex_edit_cont_precio">
                                        <div class="container_selector margin_conta">
                                            <button href="#" class="u-full-width input borrar-curso button_t aumentar carrito_eliminar_e" data-id="${combox.id}" data-nombre="Bebidas">-</button>
                                            <input type="text" class="input_t valorInput marg_edt" value="0" data-idii="${combox.id}" data-nombre2="Bebidas" readonly>
                                            <button href="#" class="u-full-width button-primary input agregar-carrito button_t disminuir" data-id="${combox.id}" data-nombre="Bebidas">+</button>
                                        </div>
                                        <p class="precio"><span class="u-pull-right">S/${combox.precio}</span></p>
                                    </div>
                                </div>
                            </div> <!--.card-->
                        </div>
                    `;



                    text = text + a;
                });

                tbody.innerHTML = text;
                cargarBebida2(text);
            })
            .catch(error => {
                console.error('Error al obtener datos:', error);
            });
}


function cargarBebida2(text) {
    fetch("../ControladorCombosIndex?accion=Combos&cargar=true&objeto=bebida")
            .then(response => {
                if (!response.ok) {
                    throw new Error("Network response was not ok " + response.statusText);
                }
                return response.json();
            })
            .then(data => {

                const tbody = document.querySelector("#cargar_comboss");

                data.forEach(combox => {
                    let a = `
                    <div class="col-lg-4 col-md-6 edit_separar div_comb_beb_dul" data-link="personalizar" data-subcat="">
                        <div class="card">
                            <img src="../img/${combox.img2}" class="imagen-curso u-full-width">
                            <div class="info-card">
                                <div class="team position-relative overflow-hidden">
                                    <div class="position-relative">
                                        <div class="team-text bg-white text-white">
                                            <h4 class="text-black text_edit_nom">${combox.nombre}</h4>
                                            <p class="content_text_edit">CineStar</p>
                                        </div>
                                        <div class="team-social bg-dark text-center">
                                            <a class="btn btn-outline-primary btn-square mr-2" href="#"><i class="fa-regular fa-eye fa-xl" style="color: #fd8b8b;"></i></a>
                                            <p class="m-0 cursor_p" style="color: #fd8b8b;">Más Información</p>
                                        </div>
                                    </div>
                                </div>
                                <img src="../img/estrellas.png" alt="Estrellas">
                                <div class="flex_edit_cont_precio">
                                    <div class="container_selector margin_conta">
                                        <button href="#" class="u-full-width input borrar-curso-2 button_t aumentar carrito_eliminar_e" data-id-2="${combox.id}" data-nombre-2="Bebidas">-</button>
                                        <input type="text" class="input_t-2 valorInput-2 marg_edt" value="0" data-idii-2="${combox.id}" data-nombre2-2="Bebidas" readonly>
                                        <button href="#" class="u-full-width button-primary input agregar-carrito-2 button_t disminuir" data-id-2="${combox.id}" data-nombre-2="Bebidas">+</button>
                                    </div>
                                    <p class="precio"><span class="u-pull-right">S/${combox.precio}</span></p>
                                </div>
                            </div>
                        </div> <!--.card-->
                    </div>
                `;


                    text = text + a;
                });

                tbody.innerHTML = text;
                cargarDulceria2(text);
            })
            .catch(error => {
                console.error('Error al obtener datos:', error);
            });
}


function cargarDulceria2(text) {
    fetch("../ControladorCombosIndex?accion=Combos&cargar=true&objeto=dulceria")
            .then(response => {
                if (!response.ok) {
                    throw new Error("Network response was not ok " + response.statusText);
                }
                return response.json();
            })
            .then(data => {

                const tbody = document.querySelector("#cargar_comboss");

                data.forEach(combox => {
                    let a = `
                    <div class="col-lg-4 col-md-6 edit_separar div_comb_beb_dul" data-link="personalizar" data-subcat="">
                        <div class="card">
                            <!-- Imágenes usando el contexto -->
                            <img src="../img/${combox.img2}" class="imagen-curso u-full-width">
                            <div class="info-card">
                                <div class="team position-relative overflow-hidden">
                                    <div class="position-relative">
                                        <div class="team-text bg-white text-white">
                                            <h4 class="text-black text_edit_nom">${combox.nombre}</h4>
                                            <p class="content_text_edit">CineStar</p>
                                        </div>
                                        <div class="team-social bg-dark text-center">
                                            <a class="btn btn-outline-primary btn-square mr-2" href="#"><i class="fa-regular fa-eye fa-xl" style="color: #fd8b8b;"></i></a>
                                            <p class="m-0 cursor_p" style="color: #fd8b8b;">Más Información</p>
                                        </div>
                                    </div>
                                </div>
                                <!-- Imagen de estrellas -->
                                <img src="../img/estrellas.png" alt="Estrellas">
                                <div class="flex_edit_cont_precio">
                                    <div class="container_selector margin_conta">
                                        <button href="#" class="u-full-width input borrar-curso-2 button_t aumentar carrito_eliminar_e" data-id-2="${combox.id}" data-nombre-2="Dulceria">-</button>
                                        <input type="text" class="input_t-2 valorInput-2 marg_edt" value="0" data-idii-2="${combox.id}" data-nombre2-2="Dulceria" readonly>
                                        <button href="#" class="u-full-width button-primary input agregar-carrito-2 button_t disminuir" data-id-2="${combox.id}" data-nombre-2="Dulceria">+</button>
                                    </div>
                                    <p class="precio"><span class="u-pull-right">S/${combox.precio}</span></p>
                                </div>
                            </div>
                        </div> <!--.card-->
                    </div>
                `;


                    text = text + a;
                });

                tbody.innerHTML = text;
                cargarapp();
                cargarapp2();
                cargarCatGenerales();
            })
            .catch(error => {
                console.error('Error al obtener datos:', error);
            });
}

function cargarCatGenerales() {
    var nom = document.getElementById("cambiar_sede_button");

    nom.addEventListener("click", function() {
        Swal.fire({
            title: '¿Estás seguro?',
            text: 'Perderás todas compras seleccionadas',
            icon: 'warning',
            showCancelButton: true,
            confirmButtonText: 'Sí',
            cancelButtonText: 'Cancelar'
        }).then((result) => {
            if (result.isConfirmed) {
                fetch("../ControladorReservas?cerrarSede=true", {
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
                            window.location.href = '/Proyecto_Avance1/Vista/CombosGeneral.jsp';
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





