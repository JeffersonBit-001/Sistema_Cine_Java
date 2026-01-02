/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


/*DATOS USUARIOS*/
$(document).ready(function () {
    cargarCombos();
    cargarSede();
    cargarCategoria();
    cargarDetalleCombos();
    
});

function cargarDetalleCombos() {
    cargarCombos();
    cargarSede();
    cargarCategoria();

    


    if (!$.fn.DataTable.isDataTable('#tablax')) {
        $('#tablax').DataTable({
            responsive: true,
            ajax: {
                url: '../ControlComb?tipoc=AdministrarDetallesCombos&accion=mostrar',
                method: 'GET',
                dataSrc: '',
                error: function (xhr, error, code) {
                    console.error('Error fetching detalles:', error);
                },
                complete: function () {
                    isLoading = false; // Restablecer el estado de carga
                }
            },
            columns: [
                {data: 'id'},
                {data: 'nombre'},
                {data: 'abastece'},
                {data: 'sinopsis'},
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
        cargarCombos();
        cargarSede();
        cargarCategoria();
    }

    /***************************************************************/
    // EDITAR DETALLE
    /***************************************************************/
    $('#tablax').off('click', '.btn-edit').on('click', '.btn-edit', function (event) {
        event.preventDefault();
        var id = $(this).data('id');

        $.ajax({
            url: '../ControlComb?tipoc=AdministrarDetallesCombos&accion=update&id=' + id,
            method: 'GET',
            success: function (data) {
                $('#modificarModal #id').val(data.id);
                $('#modificarModal #combo').val(data.idcombo);
                $('#modificarModal #categoriax').val(data.idcat);
                $('#modificarModal #sedex').val(data.idsede);
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
                    url: '../ControlComb?tipoc=AdministrarDetallesCombos&accion=delete&id=' + id,
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
                    url: '../ControlComb?tipoc=AdministrarDetallesCombos&accion=agregar',
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
                    url: '../ControlComb?tipoc=AdministrarDetallesCombos&accion=update2',
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

function cargarCombos() {
    fetch('../ControlComb?estadoSeleComb=combo', {
        method: 'GET'
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Error en la respuesta de la red');
        }
        return response.json();
    })
    .then(data => {
        
        estad('#combo2', data, 'Selecciona un combo');
        estad('#combo', data, 'Selecciona un combo');
    })
    .catch(error => {
        console.error('Error al obtener combo:', error);
    });
}

function cargarSede() {
    fetch('../ControlComb?estadoSeleComb=sede', {
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
        estad('#sedex', data, 'Selecciona una sede');
    })
    .catch(error => {
        console.error('Error al obtener sede:', error);
    });
}

function cargarCategoria() {
    fetch('../ControlComb?estadoSeleComb=categoria', {
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
        estad('#categoriax', data, 'Selecciona una categoría');
    })
    .catch(error => {
        console.error('Error al obtener categoría:', error);
    });
}

function estad(selector, data, nom) {
    $(selector).empty();
    $(selector).append(`<option value="" disabled selected>${nom}</option>`);

    data.forEach(tipo => {
        $(selector).append(`<option value="${tipo.id}">${tipo.nombre}</option>`);
    });
}


/*function cargarCombos() {
    $.ajax({
        url: '../ControlComb?estadoSeleComb=combo',
        method: 'GET',
        dataType: 'json',
        success: function (data) {
            estad('#combo2', data, 'Selecciona un combo');
            estad('#combo', data, 'Selecciona un combo');
        },
        error: function (error) {
            console.error('Error al obtener película:', error);
        }
    });
}

function cargarSede() {
    $.ajax({
        url: '../ControlComb?estadoSeleComb=sede',
        method: 'GET',
        dataType: 'json',
        success: function (data) {
            estad('#sede2', data, 'Selecciona una sede');
            estad('#sedex', data, 'Selecciona una sede');
        },
        error: function (error) {
            console.error('Error al obtener sede:', error);
        }
    });
}




function cargarCategoria() {
    $.ajax({
        url: '../ControlComb?estadoSeleComb=categoria',
        method: 'GET',
        dataType: 'json',
        success: function (data) {
            estad('#categoria2', data, 'Selecciona una categoría');
            estad('#categoriax', data, 'Selecciona una categoría');
        },
        error: function (error) {
            console.error('Error al obtener categoría:', error);
        }
    });
}

function estad(selector, data, nom) {
    $(selector).empty();

    $(selector).append(`<option value="" disabled selected>${nom}</option>`);

    $.each(data, function (index, tipo) {
        $(selector).append(`<option value="${tipo.id}">${tipo.nombre}</option>`);
    });
}
/*-------------------------------------------------*/
/***************************************************************/
