/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


hash = window.location.hash;
contenido = hash.substring(1);


cargaCombo(contenido);




function cargaCombo(contenido) {

    fetch("ControladorCombosIndex?accion=" + contenido)
            .then(response => {
                if (!response.ok) {
                    throw new Error("Network response was not ok " + response.statusText);
                }
                return response.json();
            })
            .then(data => {


                const tbody = document.querySelector("#cargar_comboss");
                tbody.innerHTML = "";
                let text = "";

                if (data !== null) {
                    data.forEach(combox => {
                        let a = `
                    <article id="art1" >                                        
                                    <img class="edit edit_img" src="img/${combox.imagen}" alt=""/>
                                </article>
                                <article id="art3">                   
                                    <div class="textc">
                                        <h1>${combox.nombre}</h1>
                                         <p>${combox.abastece}</p>
                                         <h2>Contenido</h2>
                                         ${combox.sinopsis}
                                         <h3>Precio
                                         </h3>
                                         <p>S/. ${combox.precio}</p>
                                         <h3>Oferta
                                         </h3>
                                         <p>${combox.oferta}</p>
                                     </div>
                                     
                                     
                                            <a href="Vista/CombosGeneral.jsp" class="comprar_ticket">
                                                <img src="img/img_ticket.png" width="60px" height="60px">
                                                <h4>Comprar</h4>
                                            </a>
                                        
                                     
                                </article>
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
