
function cargarapp() {
    const carrito = document.querySelector("#carrito");
    const listaCarrito = document.querySelector("#lista-carrito-tbody");
    const vaciarCarritoBtn = document.querySelector("#vaciar-carrito");
    const listaCursos = document.querySelector("#lista-cursos");
    const botonesBorrar = document.querySelectorAll('.borrar-curso');


    /*
     const combosdiv = document.querySelectorAll('.combos_div');
     const dulceriadiv = document.querySelectorAll('.dulceria_div');
     const bebidasdiv = document.querySelectorAll('.bebidas_div');
     
     const combosbtn = document.querySelector('.combosbtn');
     const dulceriabtn = document.querySelector('.dulceriabtn');
     const bebidasbtn = document.querySelector('.bebidasbtn');*/


    let articuloCarrito = [];

    cargarEventListeners();

    function cargarEventListeners() {
        /*SELECCIONAR COMBOS BEBIDAS DULCERIA*/
        const buttons = document.querySelectorAll('.btn_seleccion');
        const contentDivs = document.querySelectorAll('.div_comb_beb_dul');

        buttons.forEach(button => {
            button.addEventListener('click', () => {
                const selectedLink = button.getAttribute('data-link');

                // Mostrar los divs que coincidan con el data-link del botón seleccionado
                contentDivs.forEach(div => {
                    if (div.getAttribute('data-link') === selectedLink) {
                        div.style.display = 'block'; // Mostrar
                    } else {
                        div.style.display = 'none'; // Ocultar
                    }
                });

            });
        });


        /*Desaparecer personalizar*/
        contentDivs.forEach(div => {
            if (div.getAttribute('data-link') === 'personalizar') {
                div.style.display = 'none'; // Mostrar
            }
        });


        listaCursos.addEventListener("click", agregar_curso);

        //eliminar combo del carrito
        carrito.addEventListener('click', eliminarCurso2_1);


        botonesBorrar.forEach(boton => {
            boton.addEventListener('click', eliminarCurso);
        });


        document.addEventListener('DOMContentLoaded', () => {
            articuloCarrito = JSON.parse(localStorage.getItem('carrito')) || [];
            carritoHTML();
        });

        //Vaciar carrito
        vaciarCarritoBtn.addEventListener('click', () => {

            articuloCarrito = [];  //Resetear arreglo
            limpiarInput = document.querySelectorAll(".input_t");

            limpiarInput.forEach(input => {
                input.value = 0;
            });

            limpiarHTML();

            sincronizarStorage();



        }
        );





    }

    function agregar_curso(e) {
        e.preventDefault();
        if (e.target.classList.contains("agregar-carrito")) {
            cursoSeleccionado = e.target.closest('.card');
            leerDatosCurso(cursoSeleccionado);
        }

    }


    function eliminarCurso(e) {
        e.preventDefault();

        if (e.target.classList.contains('borrar-curso')) {
            const cursoId = e.target.getAttribute('data-id');
            const cursoName = e.target.getAttribute('data-nombre');


            const cursoExistente = articuloCarrito.find(curso =>
                curso.id === cursoId && curso.tabla === cursoName
            );

            if (cursoExistente) {
                if (cursoExistente.cantidad > 1) {

                    articuloCarrito = articuloCarrito.map(curso => {
                        if (curso.id === cursoId && curso.tabla === cursoName) {
                            curso.cantidad--;


                            const inputCurso = document.querySelector(`input[data-idii="${curso.id}"][data-nombre2="${curso.tabla}"]`);
                            if (inputCurso) {
                                inputCurso.value = curso.cantidad; // Actualizamos el input
                            }
                        }
                        return curso;
                    });
                } else {

                    articuloCarrito = articuloCarrito.filter(curso =>
                        !(curso.id === cursoId && curso.tabla === cursoName)
                    );


                    const inputCurso = document.querySelector(`input[data-idii="${cursoId}"][data-nombre2="${cursoName}"]`);
                    if (inputCurso) {
                        inputCurso.value = 0;
                    }
                }
            }

            carritoHTML();
        }
    }



    function eliminarCurso2_1(e) {
        e.preventDefault();

        if (e.target.classList.contains('borrar-curso')) {
            const cursoId = e.target.getAttribute('data-idi2');
            const cursoName = e.target.getAttribute('data-nombre3');
            if (!cursoId || !cursoName) {
                console.error('ID o nombre del curso no encontrados.');
                return;
            } else {
                console.error('ENCONTRADOS.');
            }
            const cursoEncontrado = articuloCarrito.find(curso =>
                Number(curso.id) === Number(cursoId) && curso.tabla === cursoName
            );

            console.log("aasdasdas");
            console.log(cursoEncontrado);
            console.log(articuloCarrito);
            console.log(cursoId);
            console.log(cursoName);


            articuloCarrito.forEach(curso => {
                console.log(curso.id, "qeqwe", curso.tabla);
            });

            if (cursoEncontrado) {

                articuloCarrito = articuloCarrito.filter(curso => !(Number(curso.id) === Number(cursoId) && curso.tabla === cursoName));

                const inputCurso = document.querySelector(`input[data-idii="${cursoId}"][data-nombre2="${cursoName}"]`);

                if (inputCurso) {
                    inputCurso.value = 0;
                }
            } else {
                console.error('Curso no encontrado en el carrito.');
            }

            carritoHTML();
        }
    }





    function leerDatosCurso(curso) {

        //crear un objeto con contenido
        infoCurso = {
            imagen: curso.querySelector('img.imagen-curso').src,
            titulo: curso.querySelector('h4').textContent,
            precio: curso.querySelector('.precio span').textContent,
            id: curso.querySelector('.agregar-carrito').getAttribute('data-id'),
            tabla: curso.querySelector('.agregar-carrito').getAttribute('data-nombre'),
            cantidad: 1
        };
        console.log(infoCurso);

        const inputCurso = document.querySelector(`input[data-idii="${infoCurso.id}"][data-nombre2="${infoCurso.tabla}"]`);

        if (inputCurso) {
            inputCurso.value = infoCurso.cantidad;
        }



        const existe = articuloCarrito.some(curso => curso.id === infoCurso.id && curso.tabla === infoCurso.tabla);
        //recorre todo el arreglo del carrito comparando ids devolviendo true si coincide 

        if (existe) {
            //actualizar cantidad

            const cursos = articuloCarrito.map(
                    curso => {
                        if (curso.id === infoCurso.id && curso.tabla === infoCurso.tabla) {

                            curso.cantidad++;
                            inputCurso.value = curso.cantidad;
                            return curso;
                        } else {
                            return curso;
                        }
                    }
            );//crea otro arreglo con esos elementos

            articuloCarrito = [...cursos];

        } else {

            articuloCarrito = [...articuloCarrito, infoCurso];
        }
        console.log(articuloCarrito);
        carritoHTML();
    }


    function carritoHTML() {

        limpiarHTML();
        let sumaPre = 0;
        articuloCarrito.forEach(
                curso => {
                    const {tabla, imagen, titulo, precio, cantidad, id} = curso;
            let precio_num_pre = parseFloat(precio.replace("S/", "").trim()) * cantidad;
            sumaPre += precio_num_pre;

                    const row = document.createElement('tr');

                    row.innerHTML = `
            
            <input type="hidden" value="${id}"/>
            
            <td>
                ${tabla} 
            </td>
            
            <td>
                <img src="${imagen}" width="100">
            </td>
            
            
            <td>
                ${titulo} 
            </td>

            <td>
                ${precio} 
            </td>


            <td>
                ${cantidad} 
            </td>

            <td>
                <a href="#" class="borrar-curso" data-idi2="${id}" data-nombre3="${tabla}"> X </a>
            </td>

            `;

                    listaCarrito.appendChild(row);
                }



        );

        if (articuloCarrito.length !== 0) {
            const row_cal_precio = document.createElement('tr');



            row_cal_precio.innerHTML = `
            
            
            
            <td>Total:</td>
            <td></td>
            <td></td>
            <td>S/${sumaPre.toFixed(1)}</td>
            <td></td>
            <td>
                
            </td>
        `;
            listaCarrito.appendChild(row_cal_precio);
            // CARRITO AL STORAGE
            sincronizarStorage();

        }
    }





    function sincronizarStorage() {
        localStorage.setItem('carrito', JSON.stringify(articuloCarrito));

        let carritoStorage = JSON.parse(localStorage.getItem('carrito'));

        console.log("asientos:", carritoStorage);

        guardarStorage(carritoStorage);

    }

    function guardarStorage(carritoStorage) {
        fetch('../ControladorCombosCompras?seleccionCombos=true', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(carritoStorage)
        })
                .then(response => response.json())
                .then(data => {
                    console.log('Respuesta del servidor:', data);
                })
                .catch(error => {
                    console.error('Error al enviar datos al servidor:', error);
                });
    }


    /************************ASDASD****************************/

    function cargarCarritoDesdeSesion() {
        fetch('../ControladorReservas?verificarCombos=true', {
            method: 'GET'
        })
                .then(response => response.json())
                .then(data => {

                    if (data && Array.isArray(data)) {
                        localStorage.setItem('carrito', JSON.stringify(data));
                        articuloCarrito = data;

                        articuloCarrito.forEach(curso => {
                            const inputCurso = document.querySelector(`input[data-idii="${curso.id}"][data-nombre2="${curso.tabla}"]`);
                            if (inputCurso) {
                                inputCurso.value = curso.cantidad;
                            }
                        });

                        carritoHTML();
                    } else {
                        console.log("No se encontró carrito en la sesión.");
                    }
                })
                .catch(error => {
                    console.error('Error al cargar el carrito desde el servidor:', error);
                });
    }


    cargarCarritoDesdeSesion();
    /****************************************************/


    function limpiarHTML() {
        //listaCarrito.innerHTML = "";

        while (listaCarrito.firstChild) {
            listaCarrito.removeChild(listaCarrito.firstChild);
        }

    }


//FIXED CARRITO BUSQUEDA
    var head_carrito = document.querySelector('.fixed_navbar2');

    window.addEventListener('scroll', () => {
        var scroll = window.scrollY;

        if (scroll > 1400) {
            head_carrito.style.position = 'fixed';
            head_carrito.style.top = '85px';
            head_carrito.style.borderBottom = '2px solid white';
        } else {
            head_carrito.style.position = ''; // Resetea la posición
            head_carrito.style.borderBottom = ''; // Resetea el borde
        }

    });
}

