/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


/*DATOS RESERVACIONES*/
cargarDetallePeliculas();


function cargarDetallePeliculas() {
    
    if (!$.fn.DataTable.isDataTable('#tablax')) {
        $('#tablax').DataTable({
            responsive: true,
            ajax: {
                url: 'http://localhost:8081/cliPagos/listarPagosDetalleCombos',
                method: 'GET',
                dataSrc: '',
                error: function (xhr, error, code) {
                    console.error('Error fetching detalles:', error);
                },
                complete: function () {
                    isLoading = false;
                }
            },
            columns: [
                {
                    data: 'pago.detalles_combos',
                    render: function (data, type, row) {
                        if (data && data.length > 0) {
                            
                            return data[0].id;
                        }
                        return '';
                    }
                },
                {data: 'pago.id'},
                {data: 'cliente.id'},
                {
                    data: 'cliente',
                    render: function (data, type, row) {
                        return data.nombres + ' ' + data.apellidos;
                    }
                },
                {data: 'combos.id'},
                {data: 'combos.nombre'},
                {
                    data: 'pago.detalles_combos',
                    render: function (data, type, row) {
                        if (data && data.length > 0) {
                            return data[0].cantidad;
                        }
                        return '';
                    }
                },
                {
                    data: 'pago.detalles_combos',
                    render: function (data, type, row) {
                        if (data && data.length > 0) {
                            return data[0].precio_total;
                        }
                        return '';
                    }
                },
                {
                    data: null,
                    render: function (data, type, row) {
                        return '<div class="btn-group" role="group">' +
                                '<button class="btn btn-primary btn-edit" data-bs-toggle="modal" data-bs-target="#modificarModal" data-id="' + row.id + '">' +
                                '<i class="fa-solid fa-pen-to-square editar"></i> Editar</button>' +
                                '<button class="btn btn-danger btn-delete" data-id="' + row.id + '">' +
                                '<i class="fa-sharp fa-solid fa-trash delete"></i> Eliminar</button>' +
                                '</div>';
                    },
                    orderable: false,
                    searchable: false
                }
            ],
            language: {
                processing: "Tratamiento en curso...",
                search: "Buscar&nbsp;:",
                lengthMenu: "Número _MENU_ items",
                info: "",
                infoEmpty: "No existen datos.",
                infoFiltered: "(filtrado de _MAX_ elementos en total)",
                loadingRecords: "Cargando...",
                zeroRecords: "No se encontraron datos con tu búsqueda",
                emptyTable: "No hay datos disponibles en la tabla.",
                paginate: {
                    first: "Primero",
                    previous: "Anterior",
                    next: "Siguiente",
                    last: "Último"
                },
                aria: {
                    sortAscending: ": active para ordenar la columna en orden ascendente",
                    sortDescending: ": active para ordenar la columna en orden descendente"
                }
            },
            scrollY: '500px',
            scrollX: true,
            scrollCollapse: true,
            lengthMenu: [[10, 25, -1], [10, 25, "Todos"]]

        });


    } else {
        $('#tablax').DataTable().ajax.reload(null, false);

    }

    /***************************************************************/
    // EDITAR DETALLE
    /***************************************************************/
    $('#tablax').off('click', '.btn-edit').on('click', '.btn-edit', function (event) {
        event.preventDefault();
        var id = $(this).data('id');

        $.ajax({
            url: '../ControladorPeli?tipoc=AdministrarDetallesPeliculas&accion=update&id=' + id,
            method: 'GET',
            success: function (data) {
                $('#modificarModal #id').val(data.id);
                $('#modificarModal #pelicula').val(data.peli.id);
                $('#modificarModal #sede').val(data.sd.id);
                $('#modificarModal #hora').val(data.hora.id);
                $('#modificarModal #categoria').val(data.categoria.id);
                $('#modificarModal #dia').val(data.dia.id);
                $('#modificarModal #vista').val(data.vista.id);
            },
            error: function (error) {
                console.error('Error fetching detalle data:', error);
            }
        });
    });

    /***************************************************************/
    // ELIMINAR DETALLE
    /***************************************************************/
    $('#tablax').off('click', '.btn-delete').on('click', '.btn-delete', function (event) {
        event.preventDefault();
        var id = $(this).data('id');

        // Alerta de confirmación
        Swal.fire({
            title: "¿Estás seguro?",
            text: "¡No podrás revertir esto!",
            icon: "warning",
            showCancelButton: true,
            confirmButtonColor: "#3085d6",
            cancelButtonColor: "#d33",
            confirmButtonText: "Sí, elimínalo!"
        }).then((result) => {
            if (result.isConfirmed) {
                $.ajax({
                    type: 'POST',
                    url: '../ControladorPeli?tipoc=AdministrarDetallesPeliculas&accion=delete&id=' + id,
                    success: function (response) {
                        $('#tablax').DataTable().ajax.reload(null, false);
                        Swal.fire({
                            title: "¡Eliminado!",
                            text: "El empleado ha sido eliminado.",
                            icon: "success"
                        });
                    },
                    error: function (error) {
                        console.error('Error deleting usuario:', error);
                        Swal.fire({
                            title: "Error",
                            text: "No se pudo eliminar el empleado.",
                            icon: "error"
                        });
                    }
                });
            }
        });
    });


    /***************************************************************/
    // INSERTAR DETALLE
    /***************************************************************/
    $('#form_agg').off('submit').on('submit', function (event) {
        event.preventDefault();
        Swal.fire({
            title: "¿Datos correctos?",
            text: "¿Quieres agregar este detalle?",
            icon: "warning",
            showCancelButton: true,
            confirmButtonColor: "#3085d6",
            cancelButtonColor: "#d33",
            confirmButtonText: "Sí, agregar detalle!"
        }).then((result) => {
            if (result.isConfirmed) {
                $.ajax({
                    type: 'POST',
                    url: '../ControladorPeli?tipoc=AdministrarDetallesPeliculas&accion=agregar',
                    data: $(this).serialize(),
                    success: function (response) {
                        $('#form_agg')[0].reset();
                        $('#agregarModal').modal('hide');
                        $('#tablax').DataTable().ajax.reload(null, false);
                        Swal.fire({
                            title: "¡Agregado!",
                            text: "El detalle ha sido agregado.",
                            icon: "success"
                        });
                    },
                    error: function (xhr, status, error) {
                        alert('Error: ' + error);
                        Swal.fire({
                            title: "Error",
                            text: "No se pudo agregar el detalle.",
                            icon: "error"
                        });
                    }
                });
            }
        });
    });

    //ofuscador
    /***************************************************************/
    // MODIFICAR DETALLE
    /***************************************************************/
    $('#formUpdate').off('submit').on('submit', function (event) {
        event.preventDefault();
        Swal.fire({
            title: "¿Estás seguro?",
            text: "¿Quieres guardar los cambios?",
            icon: "warning",
            showCancelButton: true,
            confirmButtonColor: "#3085d6",
            cancelButtonColor: "#d33",
            confirmButtonText: "Sí, guardar cambios!"
        }).then((result) => {
            if (result.isConfirmed) {
                $.ajax({
                    type: 'POST',
                    url: '../ControladorPeli?tipoc=AdministrarDetallesPeliculas&accion=update2',
                    data: $(this).serialize(),
                    success: function (response) {
                        console.log(response);
                        $('#formUpdate')[0].reset();
                        $('#modificarModal').modal('hide');
                        $('#tablax').DataTable().ajax.reload(null, false);

                        const event = new CustomEvent('cerrarModal', {detail: {success: true}});
                        window.dispatchEvent(event);


                        Swal.fire({
                            title: "¡Actualizado!",
                            text: "Los cambios han sido guardados.",
                            icon: "success"
                        });
                    },
                    error: function (xhr, status, error) {
                        alert('Error: ' + error);
                        Swal.fire({
                            title: "Error",
                            text: "No se pudieron guardar los cambios.",
                            icon: "error"
                        });
                    }
                });


            }
        });
    });



}
/***************************************************************/
/*OPCIONES DE FORMULARIO*/

function cargarPeliculas() {
    fetch('../ControladorPeli?tipoc=AdministrarDetallesPeliculas&estadoPeli=pelicula', {
        method: 'GET'
    })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Error en la respuesta de la red');
                }
                return response.json();
            })
            .then(data => {

                estad('#pelicula2', data, 'Selecciona una película');
                estad('#pelicula', data, 'Selecciona una película');
            })
            .catch(error => {
                console.error('Error al obtener película:', error);
            });
}

function cargarSede() {
    fetch('../ControladorPeli?tipoc=AdministrarDetallesPeliculas&estadoPeli=sede', {
        method: 'GET'
    })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Error en la respuesta de la red');
                }
                return response.json();
            })
            .then(data => {

                estad('#sede2', data, 'Selecciona una sede');
                estad('#sede', data, 'Selecciona una sede');
            })
            .catch(error => {
                console.error('Error al obtener sede:', error);
            });
}

function cargarHora() {
    fetch('../ControladorPeli?tipoc=AdministrarDetallesPeliculas&estadoPeli=hora', {
        method: 'GET'
    })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Error en la respuesta de la red');
                }
                return response.json();
            })
            .then(data => {

                estad('#hora2', data, 'Selecciona una hora');
                estad('#hora', data, 'Selecciona una hora');
            })
            .catch(error => {
                console.error('Error al obtener hora:', error);
            });
}

function cargarCategoria() {
    fetch('../ControladorPeli?tipoc=AdministrarDetallesPeliculas&estadoPeli=categoria', {
        method: 'GET'
    })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Error en la respuesta de la red');
                }
                return response.json();
            })
            .then(data => {

                estad('#categoria2', data, 'Selecciona una categoría');
                estad('#categoria', data, 'Selecciona una categoría');
            })
            .catch(error => {
                console.error('Error al obtener categoría:', error);
            });
}

function cargarDia() {
    fetch('../ControladorPeli?tipoc=AdministrarDetallesPeliculas&estadoPeli=dia', {
        method: 'GET'
    })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Error en la respuesta de la red');
                }
                return response.json();
            })
            .then(data => {

                estad2('#dia2', data, 'Selecciona un día');
                estad2('#dia', data, 'Selecciona un día');
            })
            .catch(error => {
                console.error('Error al obtener día:', error);
            });
}

function cargarVista() {
    fetch('../ControladorPeli?tipoc=AdministrarDetallesPeliculas&estadoPeli=vista', {
        method: 'GET'
    })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Error en la respuesta de la red');
                }
                return response.json();
            })
            .then(data => {

                estad('#vista2', data, 'Selecciona una vista');
                estad('#vista', data, 'Selecciona una vista');
            })
            .catch(error => {
                console.error('Error al obtener vista:', error);
            });
}

function estad(selector, data, nom) {
    $(selector).empty();
    $(selector).append(`<option value="" disabled selected>${nom}</option>`);
    data.forEach(tipo => {
        $(selector).append(`<option value="${tipo.id}">${tipo.nombre}</option>`);
    });
}

function estad2(selector, data, nom) {
    $(selector).empty();
    $(selector).append(`<option value="" disabled selected>${nom}</option>`);
    data.forEach(tipo => {
        $(selector).append(`<option value="${tipo.id}">${tipo.descripcion}</option>`);
    });
}



/*-------------------------------------------------*/
/***************************************************************/
