/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


cargarSedes();

function cargarSedes() {
    fetch("../ControladorSedes?active=true")
            .then(response => {
                if (!response.ok) {
                    throw new Error("Network response was not ok " + response.statusText);
                }
                return response.json();
            })
            .then(data => {
                construirSedes(data);
                complementosCargar();
            })
            .catch(error => {
                console.error("Error al obtener las sedes: ", error);
            });
}

function construirSedes(sedes) {
    const contenedor = document.getElementById("contenedor_sedes_ver");
    contenedor.innerHTML = "";

    let count = 1;

    sedes.forEach(sede => {
        let html = '';

        if (count % 2 !== 0) {
            
            html = `
                <div class="content_Sedes_relative">
                    <a class="content_sedes" target="IFramPrin" href="${sede.link}">
                        <div class="div_content_sedes2_align">
                            <div class="div_content_text">
                                <h2 class="nombre_cine_sede">${sede.nombre.toUpperCase()}</h2>
                                <p>${sede.descripcion}</p>
                            </div>
                        </div>
                        <div class="div_content_sedes2_align">
                            <img class="id_sedes_img" src="../img/img_sede_logo.jpg" width="320PX" height="140PX">
                        </div>
                    </a>
                </div>
            `;
        } else {
            
            html = `
                <div class="content_Sedes_relative">
                    <a class="content_sedes" target="IFramPrin" href="${sede.link}">
                        <div class="div_content_sedes2_align">
                            <img class="id_sedes_img" src="../img/img_sede_logo.jpg" width="320PX" height="140PX">
                        </div>
                        <div class="div_content_sedes2_align">
                            <div class="div_content_text">
                                <h2 class="nombre_cine_sede">${sede.nombre.toUpperCase()}</h2>
                                <p>${sede.descripcion}</p>
                            </div>
                        </div>
                    </a>
                </div>
            `;
        }

        contenedor.innerHTML += html;

        count++;
    });
}
