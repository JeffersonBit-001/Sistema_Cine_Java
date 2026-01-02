/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
cargaPlanes();

function cargaPlanes() {

    fetch("ControladorPlanes?accion=true")
            .then(response => {
                if (!response.ok) {
                    throw new Error("Network response was not ok " + response.statusText);
                }
                return response.json();
            })
            .then(data => {
                
                const tbody = document.querySelector("#cargar_planes");
                tbody.innerHTML = "";
                let text = "";
                console.log(data);

                if (data !== null) {
                    data.forEach(planex => {
                        let a = `
                    <div class="bg-white">
                                    <div class="d-flex align-items-center justify-content-between border-bottom border-primary p-4">
                                        <h1 class="display-4 mb-0">
                                            <small class="align-top text-muted font-weight-medium" style="font-size: 22px; line-height: 45px;">S/.</small>${planex.precio}<small class="align-bottom text-muted font-weight-medium" style="font-size: 16px; line-height: 40px;"></small>
                                        </h1>
                                        <h5 class="text-primary text-uppercase m-0">${planex.nombre}</h5>
                                    </div>
                                    <div class="p-4">
                                        <p><i class="fa fa-check text-success mr-2"></i>${planex.des1}</p>
                                        <p><i class="fa fa-check text-success mr-2"></i>${planex.des2}</p>
                                        <p><i class="fa fa-check text-success mr-2"></i>${planex.des3}</p>
                                        <p><i class="fa fa-check text-success mr-2"></i>${planex.des4}</p>
                                        <p><i class="fa fa-check text-success mr-2"></i>${planex.des5}</p>
                                        <a href="" class="btn btn-primary my-2">Reservar</a>
                                    </div>
                                </div>
                `;

                        text = text + a;
                    });

                    
                } else {
                    text = "<h3>No hay planes disponibles</h3><br>" ;
                }
                
                tbody.innerHTML = text;

            })
            .catch(error => {
                console.error("Error en la llamada fetch: ", error);
            });
}