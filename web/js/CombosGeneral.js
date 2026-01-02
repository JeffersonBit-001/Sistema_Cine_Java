/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


const contenedor = document.querySelector('.container_selector2');


    const aumentar = contenedor.querySelector('.aumentar_perso');
    const disminuir = contenedor.querySelector('.disminuir_perso');
    const valorInput = contenedor.querySelector('.value_input_pers');

    let contador_num = 1;

    
    valorInput.value = contador_num;

    disminuir.addEventListener('click', () => {
        contador_num = Math.max(contador_num - 1, 1);
        valorInput.value = contador_num;
    });

    aumentar.addEventListener('click', () => {
        contador_num++;
        valorInput.value = contador_num;
    });



document.addEventListener('DOMContentLoaded', () => {
    const tabla = document.getElementById('lista-carrito-2').querySelector('tbody');
    const boton = document.getElementById('vaciar-carrito-2');

    
    function verificar() {
        const filas = tabla.getElementsByTagName('tr');
        let vacio = false;

        for (let i = 0; i < filas.length; i++) {
            const celdas = filas[i].getElementsByTagName('td');
            for (let j = 0; j < celdas.length; j++) {
                if (celdas[j].textContent.trim() !== '') {
                    vacio = true;
                    break;
                }
            }
            if (vacio) break;
        }

        
        boton.disabled = !vacio;
    }

    
    verificar();
});




/*CAPTURA FOTO*/