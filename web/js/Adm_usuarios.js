/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


/*DATOS USUARIOS*/
$(document).ready(function() {
    cargarUsuarios();
});

function cargarUsuarios() {

    
        cargarEstados();
        

        if (!$.fn.DataTable.isDataTable('#tablax')) {
            $('#tablax').DataTable({
                responsive: true,

                ajax: {
                    url: '../ContUsuarios?tipoc=AdministradorUsuarios&accion=mostrar',
                    method: 'GET',
                    dataSrc: '',
                    error: function (xhr, error, code) {
                        console.error('Error fetching usuarios:', error);
                    },
                    complete: function () {
                        isLoading = false; // Restablecer el estado de carga
                    }
                },
                columns: [
                    {data: 'id'},
                    {data: 'nombre'},
                    {data: 'apellido'},
                    {data: 'dni'},
                    {data: 'genero'},
                    {data: 'nacimiento'},
                    {data: 'telefono'},
                    {data: 'domicilio'},
                    {data: 'correo'},
                    {data: 'correoc'},
                    {data: 'pass'},
                    {data: 'passc'},
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
            cargarEstados();
        }

        /***************************************************************/
        // EDITAR USUARIO
        /***************************************************************/
        $('#tablax').off('click', '.btn-edit').on('click', '.btn-edit', function (event) {
            event.preventDefault();
            var id = $(this).data('id');

            $.ajax({
                url: '../ContUsuarios?tipoc=AdministradorUsuarios&accion=update&id=' + id,
                method: 'GET',
                success: function (data) {
                    
                    
                    $('#modificarModal #id').val(data.id);
                    $('#modificarModal #nombres').val(data.nombre);
                    $('#modificarModal #apellidos').val(data.apellido);
                    $('#modificarModal #dni').val(data.dni);
                    $('#modificarModal #genero').val(data.genero);
                    $('#modificarModal #fecha').val(data.nacimiento);
                    $('#modificarModal #cel').val(data.telefono);
                    $('#modificarModal #domicilio').val(data.domicilio);
                    $('#modificarModal #correo').val(data.correo);
                    $('#modificarModal #correo_confirm').val(data.correoc);
                    $('#modificarModal #pass').val(data.pass);
                    $('#modificarModal #pass_confirm').val(data.passc);
                    $('#modificarModal #estado').val(data.estado);
                },
                error: function (error) {
                    console.error('Error fetching cliente data:', error);
                }
            });
        });

        /***************************************************************/
        // ELIMINAR USUARIO
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
                        url: '../ContUsuarios?tipoc=AdministradorUsuarios&accion=delete&id=' + id,
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
        // INSERTAR USUARIO
        /***************************************************************/
        $('#form_agg').off('submit').on('submit', function (event) {
            event.preventDefault();
            Swal.fire({
                title: "¿Datos correctos?",
                text: "¿Quieres agregar este empleado?",
                icon: "warning",
                showCancelButton: true,
                confirmButtonColor: "#3085d6",
                cancelButtonColor: "#d33",
                confirmButtonText: "Sí, agregar empleado!"
            }).then((result) => {
                if (result.isConfirmed) {
                    $.ajax({
                        type: 'POST',
                        url: '../ContUsuarios?tipoc=AdministradorUsuarios&accion=agregar',
                        data: $(this).serialize(),
                        success: function (response) {
                            $('#form_agg')[0].reset();
                            $('#agregarModal').modal('hide');
                            $('#tablax').DataTable().ajax.reload(null, false);
                            Swal.fire({
                                title: "¡Agregado!",
                                text: "El empleado ha sido agregado.",
                                icon: "success"
                            });
                        },
                        error: function (xhr, status, error) {
                            alert('Error: ' + error);
                            Swal.fire({
                                title: "Error",
                                text: "No se pudo agregar el empleado.",
                                icon: "error"
                            });
                        }
                    });
                }
            });
        });

        //ofuscador
        /***************************************************************/
        // MODIFICAR USUARIO
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
                        url: '../ContUsuarios?tipoc=AdministradorUsuarios&accion=update2',
                        data: $(this).serialize(),
                        success: function (response) {
                            console.log(response);
                            $('#formUpdate')[0].reset();
                            $('#modificarModal').modal('hide');
                            $('#tablax').DataTable().ajax.reload(null, false);
                            
                            const event = new CustomEvent('cerrarModal', { detail: { success: true } });
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
/*ESTADOS DE FORMULARIO*/

function cargarEstados() {
    fetch('../ContUsuarios?estad=listo', {
        method: 'GET'
        
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Error en la respuesta de la red');
        }
        return response.json();
    })
    .then(data => {
        
        estad('#estado2', data);
        estad('#estado', data);
    })
    .catch(error => {
        console.error('Error al obtener estados:', error);
    });
}

function estad(selector, data) {
    $(selector).empty();
    $(selector).append('<option value="" disabled selected>Selecciona un estado</option>');
    data.forEach(tipo => {
        $(selector).append(`<option value="${tipo.id}">${tipo.nombre}</option>`);
    });
}
/*-------------------------------------------------*/
/***************************************************************/
