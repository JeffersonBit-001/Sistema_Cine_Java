/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

cargarSlader();
function cargarSlader() {

    fetch("ControladorSlader?active=true")
            .then(response => {
                if (!response.ok) {
                    throw new Error("Network response was not ok " + response.statusText);
                }
                return response.json();
            })
            .then(data => {
                const tbody = document.querySelector("#slider_container");
                tbody.innerHTML = "";
                let text = "";
                data.forEach(pelix => {
                    let a = `
                    <li class="text-center">
                <img class="position-absolute img_edit" src="img/${pelix.img}" style="object-fit: cover;">
                <div class="container">
                    <div class="row d-flex">
                        <div class="p-3" style="max-width: 700px;">

                            <h3 class="display-3 text-capitalize  mb-3 text_title_peli">
                                ${pelix.nombre}
                            </h3>
                            <p class="mx-md-8 px-5 descrip_text">
                                ${pelix.sinopsis}
                            </p>
                            
                            
                            <div class="text_com">
                                <a class="btn_comprar_caja" href="Vista/Reservas.jsp">
                                    
                                    <i class="fa-solid fa-ticket fa-2xl ffs_sol" style="color: #e9902b;"></i>Comprar
                                </a>
                                
                            </div>
                                
                            
                        </div>
                    </div>
                </div>
            </li>
                `;

                    text = text + a;
                });

                tbody.innerHTML = text;

            })
            .catch(error => {
                console.error("Error en la llamada fetch: ", error);
            });
}