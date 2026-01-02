/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

    cargarSedes();


/*CARGAR SEDES*/

function cargarSedes() {
    $.ajax({
        url: '../ControladorPeli?estadoPeli=sede',
        method: 'GET',
        dataType: 'json',
        success: function (data) {
            // Limpiar y poblar ambos dropdowns
            estad('#select_sedes', data);
        },
        error: function (error) {
            console.error('Error al obtener salas:', error);
        }
    });
}

function estad(selector, data) {
    $(selector).empty();
    $(selector).append('<option value="" disabled selected>Selecciona una sede</option>');
    $.each(data, function (index, tipo) {
        $(selector).append(`<option value="${tipo.nombre}">${tipo.nombre}</option>`);
    });
}

/*-------------------------------------------------*/
/***************************************************************/
