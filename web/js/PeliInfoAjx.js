/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


const urlParams = new URLSearchParams(window.location.search);
const valx = urlParams.get('valx');
const busqueda = "";

fetch("../ControladorPeliInfo?valx=" + valx)
    .then(response => {
        if (!response.ok) {
            throw new Error("Network response was not ok " + response.statusText);
        }
        return response.json();
    })
    .then(data => {
        
        document.getElementById('vista_peli').textContent = "Películas en "+data.vista; 
        document.getElementById('title_peli').textContent = data.nombre; 
        document.getElementById('descr_peli').textContent = data.descripcion; 
        document.getElementById('img_peli').src = "../img/"+data.img; 
        document.getElementById('sinopsis').textContent = data.sinopsis; 
        document.getElementById('direc_peli').textContent = data.director; 
        document.getElementById('disp_peli').textContent = data.disponible; 
        document.getElementById('idiomaind').textContent = data.idioma; 
        document.getElementById('apeli').innerHTML = "<img src='../img/img_ticket.png' width='60px' height='60px'>S/. "+data.precio;
        document.getElementById('framee').src = data.linkyou+"&controls=0&autohide=0&rel=0";
        
    })
    .catch(error => {
        console.error('Error al obtener datos:', error);
    });
