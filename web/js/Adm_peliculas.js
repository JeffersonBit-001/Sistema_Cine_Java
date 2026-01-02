/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


/*DATOS USUARIOS*/
$(document).ready(function () {
    cargarPeliculas();
});

function cargarPeliculas() {
    cargarSalas();
    if (!$.fn.DataTable.isDataTable('#tablax')) {
        $('#tablax').DataTable({
            responsive: true,
            ajax: {
                url: '../ControladorPeli?tipoc=AdministradorPeliculas&accion=mostrar',
                method: 'GET',
                dataSrc: '',
                error: function (xhr, error, code) {
                    console.error('Error fetching usuarios:', error);
                },
                complete: function () {
                    isLoading = false;
                }
            },
            columns: [
                {data: 'id'},
                {data: 'nombre'},
                {data: 'descripcion'},
                {data: 'precio'},
                {data: 'sinopsis'},
                {data: 'director'},
                {data: 'idioma'},
                {data: 'img'},
                {data: 'disponible'},
                {data: 'sala'},
                {data: 'linkyou'},
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
            lengthMenu: [[10, 25, -1], [10, 25, "Todos"]],
            columnDefs: [
                {
                    targets: 7,
                    createdCell: function (td, cellData, rowData, row, col) {
                        var imageUrl = '../img/' + cellData;
                        var imageHtml = '<img src="' + imageUrl + '" width="100px" height="100px" alt="Imagen de la película"/>';
                        $(td).html(imageHtml);
                    }
                },
                {
                    targets: 10,
                    createdCell: function (td, cellData, rowData, row, col) {

                        if (cellData) {
                            var videoUrl = cellData;
                            var iframeHtml = '<iframe class="iframe" width="270" height="150" ' +
                                    'src="' + videoUrl + '&autohide=0&rel=0" ' +
                                    'title="YouTube video player" frameborder="0" ' +
                                    'allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" ' +
                                    'referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>';
                            $(td).html(iframeHtml);
                        } else {

                            $(td).html('No disponible');
                        }
                    }
                },
                {
                    targets: 4,
                    createdCell: function (td, cellData, rowData, row, col) {
                        $(td).css({
                            'max-width': '160px',
                            'overflow': 'hidden',
                            'text-overflow': 'ellipsis',
                            'white-space': 'nowrap'
                        });
                    }
                }
            ]
        });


    } else {
        $('#tablax').DataTable().ajax.reload(null, false);
        cargarSalas();
    }

    /***************************************************************/
    // EDITAR PELICULAS
    /***************************************************************/
    $('#tablax').off('click', '.btn-edit').on('click', '.btn-edit', function (event) {
        event.preventDefault();
        var id = $(this).data('id');

        $.ajax({
            url: '../ControladorPeli?tipoc=AdministradorPeliculas&accion=update&id=' + id,
            method: 'GET',
            success: function (data) {
                $('#modificarModal #id').val(data.id);
                $('#modificarModal #nombre').val(data.nombre);
                $('#modificarModal #descripcion').val(data.descripcion);
                $('#modificarModal #precio').val(data.precio);
                $('#modificarModal #sinopsis').val(data.sinopsis);
                $('#modificarModal #director').val(data.director);
                $('#modificarModal #idioma').val(data.idioma);
                $("#modificarModal #vistaPreviaImagen").attr("src", "../img/" + data.img);
                $('#modificarModal #disponible').val(data.disponible);
                $('#modificarModal #sala').val(data.sala);
                $('#modificarModal #link').val(data.linkyou);
            },
            error: function (error) {
                console.error('Error fetching pelicula data:', error);
            }
        });
    });

    /***************************************************************/
    // ELIMINAR PELICULAS
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
                    url: '../ControladorPeli?tipoc=AdministradorPeliculas&accion=delete&id=' + id,
                    success: function (response) {
                        $('#tablax').DataTable().ajax.reload(null, false);
                        Swal.fire({
                            title: "¡Eliminado!",
                            text: "La pelicula ha sido eliminado.",
                            icon: "success"
                        });
                    },
                    error: function (error) {
                        console.error('Error eliminar Peli:', error);
                        Swal.fire({
                            title: "Error",
                            text: "No se pudo eliminar la pelicula.",
                            icon: "error"
                        });
                    }
                });
            }
        });
    });


    /***************************************************************/
    // INSERTAR PELICULAS
    /***************************************************************/
    $('#form_agg').off('submit').on('submit', function (event) {
        event.preventDefault();
        Swal.fire({
            title: "¿Datos correctos?",
            text: "¿Quieres agregar este película?",
            icon: "warning",
            showCancelButton: true,
            confirmButtonColor: "#3085d6",
            cancelButtonColor: "#d33",
            confirmButtonText: "Sí, agregar película!"
        }).then((result) => {
            if (result.isConfirmed) {
                $.ajax({
                    type: 'POST',
                    url: '../ControladorPeli?tipoc=AdministradorPeliculas&accion=agregar',
                    data: new FormData($('#form_agg')[0]),
                    processData: false,
                    contentType: false,
                    success: function (response) {
                        $('#form_agg')[0].reset();
                        $('#agregarModal').modal('hide');
                        $('#tablax').DataTable().ajax.reload(null, false);
                        Swal.fire({
                            title: "¡Agregado!",
                            text: "La película ha sido agregado.",
                            icon: "success"
                        });
                    },
                    error: function (xhr, status, error) {
                        alert('Error: ' + error);
                        Swal.fire({
                            title: "Error",
                            text: "No se pudo agregar la película.",
                            icon: "error"
                        });
                    }
                });
            }
        });
    });

    //ofuscador
    /***************************************************************/
    // MODIFICAR PELICULAS
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
                    url: '../ControladorPeli?tipoc=AdministradorPeliculas&accion=update2',
                    data: new FormData($('#formUpdate')[0]),
                    processData: false,
                    contentType: false,
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
/*PELICULAS DE FORMULARIO*/

function cargarSalas() {
    fetch('../ControladorPeli?tipoc=AdministradorPeliculas&estad=listo', {
        method: 'GET'
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Error en la respuesta de la red');
        }
        return response.json();
    })
    .then(data => {
        estad('#sala2', data);
        estad('#sala', data);
    })
    .catch(error => {
        console.error('Error al obtener salas:', error);
    });
}

function estad(selector, data) {
    $(selector).empty();
    $(selector).append('<option value="" disabled selected>Selecciona una sala</option>');

    data.forEach(tipo => {
        $(selector).append(`<option value="${tipo.id}">${tipo.nombre}</option>`);
    });
}



/*
function cargarSalas() {
    $.ajax({
        url: '../ControladorPeli?tipoc=AdministradorPeliculas&estad=listo',
        method: 'GET',
        dataType: 'json',
        success: function (data) {
            // Limpiar y poblar ambos dropdowns
            estad('#sala2', data);
            estad('#sala', data);
        },
        error: function (error) {
            console.error('Error al obtener salas:', error);
        }
    });
}

function estad(selector, data) {
    $(selector).empty();
    $(selector).append('<option value="" disabled selected>Selecciona una sala</option>');
    $.each(data, function (index, tipo) {
        $(selector).append(`<option value="${tipo.id}">${tipo.nombre}</option>`);
    });
}
*/
/*-------------------------------------------------*/
/***************************************************************/
