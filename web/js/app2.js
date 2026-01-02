/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
function cargarapp2() {
    let id_const = 1;
    const carrito2 = document.querySelector("#carrito-2");
    const carrito2_img = document.querySelector("#carrito-2-img");
    const listaCarrito2 = document.querySelector("#lista-carrito-tbody-2");
    const vaciarCarritoBtn2 = document.querySelector("#vaciar-carrito-2");
    const listaCursos2 = document.querySelector("#lista-cursos");
    const botonesBorrar2 = document.querySelectorAll('.borrar-curso-2');
    const listaElimi = document.getElementById('carrito-2-img');



    /*
     const combosdiv = document.querySelectorAll('.combos_div');
     const dulceriadiv = document.querySelectorAll('.dulceria_div');
     const bebidasdiv = document.querySelectorAll('.bebidas_div');
     
     const combosbtn = document.querySelector('.combosbtn');
     const dulceriabtn = document.querySelector('.dulceriabtn');
     const bebidasbtn = document.querySelector('.bebidasbtn');*/


    let articuloCarrito2 = [];

    cargarEventListeners2();

    function cargarEventListeners2() {

        listaCursos2.addEventListener("click", agregar_curso2);

        //eliminar curso del carrito
        carrito2.addEventListener('click', eliminarCurso22);


        botonesBorrar2.forEach(boton => {
            boton.addEventListener('click', eliminarCurso2);
        });


        document.addEventListener('DOMContentLoaded', () => {
            articuloCarrito2 = JSON.parse(localStorage.getItem('carrito2')) || [];
            carritoHTML2();
        });

        //Vaciar carrito
        vaciarCarritoBtn2.addEventListener('click', (e) => {
            /*CAPTURA DEL CARRITO*/
            html2canvas(listaElimi).then(function (canvas) {
                // Crear una imagen a partir del canvas
                const imgData = canvas.toDataURL('image/png');

                // Generar un nombre aleatorio para la imagen
                const nombreImagen = `captura-${Date.now()}.png`;

                // Cambiar el src del elemento img existente
                const resultadoImg = document.querySelector('.id_img_captura');
                resultadoImg.src = imgData; // Reemplaza el src con la nueva imagen
                resultadoImg.alt = nombreImagen; // Usar el nombre como alt (opcional)

                // Guardar la imagen en el almacenamiento local
                localStorage.setItem(nombreImagen, imgData);

                // Mostrar la imagen guardada
                const imgGuardada = localStorage.getItem(nombreImagen);
                if (imgGuardada) {
                    resultadoImg.src = imgGuardada; // Asignar el src con la imagen guardada
                    resultadoImg.alt = nombreImagen; // Usar el nombre como alt
                }

                // Funcionalidad para vaciar el carrito (ahora dentro del then)
                agregar_carro1(e);
                articuloCarrito2 = [];  // Resetear arreglo
                limpiarHTML2();
                sincronizarStorage2();

                // Limpiar inputs
                const limpiarInput2 = document.querySelectorAll(".input_t-2");
                const limpiarInput3 = document.querySelector(".input_t-3");


                limpiarInput3.value = 1;


                limpiarInput2.forEach(input => {
                    input.value = 0;
                });

            }).catch(function (error) {
                console.error("Error al capturar el elemento:", error);
            });
        });








    }

    function agregar_curso2(e) {
        e.preventDefault();
        if (e.target.classList.contains("agregar-carrito-2")) {
            cursoSeleccionado2 = e.target.closest('.card');
            leerDatosCurso2(cursoSeleccionado2);
        }

    }

    function agregar_carro1(e) {
        if (e.target.classList.contains("vaciar-carrito-2")) {
            seleccion = e.target.closest('.submenu');

            leerDatos2(seleccion);
        }

    }


    function eliminarCurso2(e) {
        e.preventDefault();

        if (e.target.classList.contains('borrar-curso-2')) {
            const cursoId2 = e.target.getAttribute('data-id-2');
            const cursoName2 = e.target.getAttribute('data-nombre-2');


            const cursoExistente2 = articuloCarrito2.find(curso =>
                curso.id === cursoId2 && curso.tabla === cursoName2
            );

            if (cursoExistente2) {
                if (cursoExistente2.cantidad > 1) {

                    articuloCarrito2 = articuloCarrito2.map(curso => {
                        if (curso.id === cursoId2 && curso.tabla === cursoName2) {
                            curso.cantidad--;


                            const inputCurso2 = document.querySelector(`input[data-idii-2="${curso.id}"][data-nombre2-2="${curso.tabla}"]`);
                            if (inputCurso2) {
                                inputCurso2.value = curso.cantidad; // Actualizamos el input
                            }
                        }
                        return curso;
                    });
                } else {

                    articuloCarrito2 = articuloCarrito2.filter(curso =>
                        !(curso.id === cursoId2 && curso.tabla === cursoName2)
                    );


                    const inputCurso2 = document.querySelector(`input[data-idii-2="${cursoId2}"][data-nombre2-2="${cursoName2}"]`);
                    if (inputCurso2) {
                        inputCurso2.value = 0;
                    }
                }
            }

            carritoHTML2();
        }
    }



    function eliminarCurso22(e) {
        e.preventDefault();

        if (e.target.classList.contains('borrar-curso-2')) {
            const cursoId2 = e.target.getAttribute('data-idi2-2');
            const cursoName2 = e.target.getAttribute('data-nombre3-2');
            if (!cursoId2 || !cursoName2) {
                console.error('ID o nombre del curso no encontrados.');
                return;
            }
            const cursoEncontrado2 = articuloCarrito2.find(curso => curso.id === cursoId2 && curso.tabla === cursoName2);
            if (cursoEncontrado2) {

                articuloCarrito2 = articuloCarrito2.filter(curso => !(curso.id === cursoId2 && curso.tabla === cursoName2));

                const inputCurso2 = document.querySelector(`input[data-idii-2="${cursoId2}"][data-nombre2-2="${cursoName2}"]`);

                if (inputCurso2) {
                    inputCurso2.value = 0;
                }
            } else {
                console.error('Curso no encontrado en el carrito.');
            }

            carritoHTML2();
        }
    }



    function leerDatos2(carrito) {

        infoPrecio = {

            imagen: carrito.querySelector('.id_img_captura').src,
            titulo: "Personalizadosadasdsada",
            precio: carrito.querySelector('#lista-carrito-tbody-2 tr td[data-preciototal]').getAttribute('data-preciototal'),
            id: id_const,
            tabla: "Personalizado",
            cantidad: carrito.querySelector('.value_input_pers').value

        };

        console.log(infoPrecio);
        const existe3 = articuloCarrito.some(curso => curso.id === infoPrecio.id && curso.tabla === infoPrecio.tabla);

        if (existe3) {
            //actualizar cantidad

            const cursos3 = articuloCarrito.map(
                    curso => {
                        if (curso.id === infoPrecio.id && curso.tabla === infoPrecio.tabla) {

                            curso.cantidad++;
                            infoPrecio.value = curso.cantidad;
                            return curso;
                        } else {

                            return curso;
                        }
                    }
            );//crea otro arreglo con esos elementos

            articuloCarrito = [...cursos3];

        } else {

            articuloCarrito = [...articuloCarrito, infoPrecio];
            id_const++;
        }
        console.log(articuloCarrito);
        carritoHTML();

    }

    function leerDatosCurso2(curso) {

        //crear un objeto con contenido
        infoCurso2 = {
            imagen: curso.querySelector('img.imagen-curso').src,
            titulo: curso.querySelector('h4').textContent,
            precio: curso.querySelector('.precio span').textContent,
            id: curso.querySelector('.agregar-carrito-2').getAttribute('data-id-2'),
            tabla: curso.querySelector('.agregar-carrito-2').getAttribute('data-nombre-2'),
            cantidad: 1
        };
        console.log(infoCurso2);

        const inputCurso2 = document.querySelector(`input[data-idii-2="${infoCurso2.id}"][data-nombre2-2="${infoCurso2.tabla}"]`);

        if (inputCurso2) {
            inputCurso2.value = infoCurso2.cantidad;
        }



        const existe2 = articuloCarrito2.some(curso => curso.id === infoCurso2.id && curso.tabla === infoCurso2.tabla);
        //recorre todo el arreglo del carrito comparando ids devolviendo true si coincide 

        if (existe2) {
            //actualizar cantidad

            const cursos2 = articuloCarrito2.map(
                    curso => {
                        if (curso.id === infoCurso2.id && curso.tabla === infoCurso2.tabla) {

                            curso.cantidad++;
                            inputCurso2.value = curso.cantidad;
                            return curso;
                        } else {
                            return curso;
                        }
                    }
            );//crea otro arreglo con esos elementos

            articuloCarrito2 = [...cursos2];

        } else {

            articuloCarrito2 = [...articuloCarrito2, infoCurso2];
        }
        console.log(articuloCarrito2);
        carritoHTML2();
    }


    function carritoHTML2() {
        limpiarHTML2();

        // Limpiar el contenedor de personalización antes de añadir nuevas imágenes
        carrito2_img.innerHTML = ''; // Asegúrate de que `carrito2_img` esté definido
        let suma = 0;

        articuloCarrito2.forEach(curso => {
            const {tabla, imagen, titulo, precio, cantidad, id} = curso;
            let precio_num = parseFloat(precio.replace("S/", "").trim()) * cantidad;
            suma += precio_num;
            const row2 = document.createElement('tr');

            row2.innerHTML = `
            <input type="hidden" value="Personalizacion"/>
            <input type="hidden" value="${id}"/>
            
            <td>${tabla}</td>
            <td><img src="${imagen}" width="50"></td>
            <td>${titulo}</td>
            <td>${precio}</td>
            <td>${cantidad}</td>
            <td>
                <a href="#" class="borrar-curso-2" data-idi2-2="${id}" data-nombre3-2="${tabla}"> X </a>
            </td>
        `;

            // Agregar la fila a la tabla del carrito
            listaCarrito2.appendChild(row2);

            // Crear y agregar la imagen al contenedor de personalización
            const imgElement = document.createElement('img');
            imgElement.src = imagen;
            imgElement.width = 100;
            imgElement.height = 100;
            imgElement.style.margin = '0px';

            // Agregar la imagen al contenedor de personalización
            carrito2_img.appendChild(imgElement);
        });

        if (articuloCarrito2.length !== 0) {
            const row_precio = document.createElement('tr');



            row_precio.innerHTML = `
            
            
            
            <td>Total:</td>
            <td><img class="id_img_captura" src="qwe"></td>
            <td><input type="hidden" value="Personalizacion"/></td>
            <td data-preciototal="S/${suma.toFixed(1)}">S/${suma.toFixed(1)}</td>
            <td></td>
            <td>
                
            </td>
        `;

            // Agregar la fila a la tabla del carrito
            listaCarrito2.appendChild(row_precio);

        }




        // CARRITO AL STORAGE
        sincronizarStorage2();
    }


    function sincronizarStorage2() {
        localStorage.setItem('carrito2', JSON.stringify(articuloCarrito));
    }

    function limpiarHTML2() {
        //listaCarrito.innerHTML = "";

        while (listaCarrito2.firstChild) {
            listaCarrito2.removeChild(listaCarrito2.firstChild);

        }
        while (listaElimi.firstChild) {
            listaElimi.removeChild(listaElimi.firstChild);
        }


    }


}
