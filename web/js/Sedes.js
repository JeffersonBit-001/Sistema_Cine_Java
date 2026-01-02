/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


/*seleccion e ir al mapa */

function complementosCargar(){
var seleccionSedes = document.querySelectorAll('.content_sedes');

var nombreMapaMostrar = document.getElementById('ubicacion_title_map');

var nombreSedeGlobal="";


seleccionSedes.forEach(function(enlace) {
    enlace.addEventListener("click", function() {
        
        var nombreSede = enlace.querySelector('.nombre_cine_sede').textContent;

        nombreSedeGlobal = nombreSede;
        var dirigirMapa = document.getElementById("mapa");
        dirigirMapa.scrollIntoView({ behavior: "smooth", block: "start" });
        

        nombreMapaMostrar.textContent = "VISÍTANOS EN "+nombreSede;
    });
});


/*Cambiar nombre de la sede */
/*regresar del mapa */
var seleccionSedes2 = document.querySelector('.mapa_ir_direccion');

var nombre_regreso_sede = document.querySelectorAll('.nombre_cine_sede');

seleccionSedes2.addEventListener("click", function(event) {
    

    if (nombreSedeGlobal) {
        event.preventDefault();
        nombre_regreso_sede.forEach(function(nombreSede) {

            if (nombreSede.textContent === nombreSedeGlobal) {
                nombreSede.scrollIntoView({ behavior: "smooth", block: "center" });
            }
        });
    }
});
}