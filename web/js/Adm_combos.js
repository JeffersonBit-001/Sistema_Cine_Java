/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


/*DATOS USUARIOS*/
$(document).ready(function () {
    cargarCombos();
});

function cargarCombos() {


    if (!$.fn.DataTable.isDataTable('#tablax')) {
        $('#tablax').DataTable({
            responsive: true,
            ajax: {
                url: '../ControlComb?tipoc=AdministradorCombos&accion=mostrar',
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
                {data: 'abastece'},
                {data: 'imagen'},
                {data: 'sinopsis'},
                {data: 'precio'},
                {data: 'oferta'},
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
                    targets: 3,
                    createdCell: function (td, cellData, rowData, row, col) {
                        var imageUrl = '../img/' + cellData;
                        var imageHtml = '<img src="' + imageUrl + '" width="100px" height="100px" alt="Imagen de la película"/>';
                        $(td).html(imageHtml);
                    }
                }
            ]
        });


    } else {
        $('#tablax').DataTable().ajax.reload(null, false);
       
    }

    /***************************************************************/
    // EDITAR PELICULAS
    /***************************************************************/
    $('#tablax').off('click', '.btn-edit').on('click', '.btn-edit', function (event) {
        event.preventDefault();
        var id = $(this).data('id');

        $.ajax({
            url: '../ControlComb?tipoc=AdministradorCombos&accion=update&id=' + id,
            method: 'GET',
            success: function (data) {
                $('#modificarModal #id').val(data.id);
                $('#modificarModal #nombre').val(data.nombre);
                $('#modificarModal #abastece').val(data.abastece);
                $('#modificarModal #sinopsis').val(data.sinopsis);
                $('#modificarModal #precio').val(data.precio);
                $('#modificarModal #oferta').val(data.oferta);
                $("#modificarModal #vistaPreviaImagen").attr("src", "../img/" + data.imagen);
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
                    url: '../ControlComb?tipoc=AdministradorCombos&accion=delete&id=' + id,
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
    // INSERTAR PELICULAS
    /***************************************************************/
    $('#form_agg').off('submit').on('submit', function (event) {
        event.preventDefault();
        Swal.fire({
            title: "¿Datos correctos?",
            text: "¿Quieres agregar este combo?",
            icon: "warning",
            showCancelButton: true,
            confirmButtonColor: "#3085d6",
            cancelButtonColor: "#d33",
            confirmButtonText: "Sí, agregar combo!"
        }).then((result) => {
            if (result.isConfirmed) {
                $.ajax({
                    type: 'POST',
                    url: '../ControlComb?tipoc=AdministradorCombos&accion=agregar',
                    data: new FormData($('#form_agg')[0]),
                    processData: false,
                    contentType: false,
                    success: function (response) {
                        $('#form_agg')[0].reset();
                        $('#agregarModal').modal('hide');
                        $('#tablax').DataTable().ajax.reload(null, false);
                        Swal.fire({
                            title: "¡Agregado!",
                            text: "El combo ha sido agregado.",
                            icon: "success"
                        });
                    },
                    error: function (xhr, status, error) {
                        alert('Error: ' + error);
                        Swal.fire({
                            title: "Error",
                            text: "No se pudo agregar el combo.",
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
                    url: '../ControlComb?tipoc=AdministradorCombos&accion=update2',
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


/*-------------------------------------------------*/
/***************************************************************/
