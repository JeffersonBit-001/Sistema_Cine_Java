/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

cargarHistorial();

function cargarHistorial() {
    fetch("../ControladorPanelCliente?mostrarHistorial=true")
        .then(response => {
            if (!response.ok) {
                throw new Error("Network response was not ok " + response.statusText);
            }
            return response.json();
        })
        .then(data => {
            const tbody = document.querySelector("#cargarHistorialInfo");
            tbody.innerHTML = "";

            if (data && data.length > 0) {

                document.getElementById('title_nombre').textContent = data[0].nombreCliente;

                let historialAgrupado = {};

                data.forEach(item => {
                    const idPago = item.idPago;

                    if (!historialAgrupado[idPago]) {
                        historialAgrupado[idPago] = {
                            fecha: item.fecha,
                            hora: item.hora,
                            nombreCliente: item.nombreCliente,
                            peliculas: [],
                            bebidas: [],
                            combos: [],
                            dulceria: []
                        };
                    }


                    if (item.nombrePelicula && !historialAgrupado[idPago].peliculas.some(pelicula => pelicula.nombrePelicula === item.nombrePelicula)) {
                        historialAgrupado[idPago].peliculas.push({
                            nombrePelicula: item.nombrePelicula,
                            precioPelicula: item.precioPelicula,
                            cantPelicula: item.cantPelicula,
                            totalPelicula: item.totalPelicula,
                            imgPelicula: item.imgPelicula,
                            asientos: []
                        });
                    }

                    // Agrupar asientos por película
                    if (item.nombrePelicula && item.asiento) {
                        let pelicula = historialAgrupado[idPago].peliculas.find(pelicula => pelicula.nombrePelicula === item.nombrePelicula);
                        if (pelicula) {
                            
                            if (!pelicula.asientos.includes(item.asiento)) {
                                pelicula.asientos.push(item.asiento);
                            }
                        }
                    }

                    // Agrupar bebidas
                    if (item.nombreBebida) {
                        let bebida = historialAgrupado[idPago].bebidas.find(bebida => bebida.nombreBebida === item.nombreBebida);
                        if (bebida) {
                            bebida.cantidadBebida += item.cantidadBebida;
                            bebida.totalBebida += item.totalBebida;
                        } else {
                            historialAgrupado[idPago].bebidas.push({
                                nombreBebida: item.nombreBebida,
                                precioBebida: item.precioBebida,
                                cantidadBebida: item.cantidadBebida,
                                totalBebida: item.totalBebida,
                                imgBebida: item.imgBebida
                            });
                        }
                    }

                    // Agrupar combos
                    if (item.nombreCombos) {
                        let combo = historialAgrupado[idPago].combos.find(combo => combo.nombreCombos === item.nombreCombos);
                        if (combo) {
                            combo.cantidadCombos += item.cantidadCombos;
                            combo.totalCombos += item.totalCombos;
                        } else {
                            historialAgrupado[idPago].combos.push({
                                nombreCombos: item.nombreCombos,
                                precioCombos: item.precioCombos,
                                cantidadCombos: item.cantidadCombos,
                                totalCombos: item.totalCombos,
                                imgCombos: item.imgCombos
                            });
                        }
                    }

                    // Agrupar dulcería
                    if (item.nombreDulceria) {
                        let dulceria = historialAgrupado[idPago].dulceria.find(dulceria => dulceria.nombreDulceria === item.nombreDulceria);
                        if (dulceria) {
                            dulceria.cantidadDulceria += item.cantidadDulceria;
                            dulceria.totalDulceria += item.totalDulceria;
                        } else {
                            historialAgrupado[idPago].dulceria.push({
                                nombreDulceria: item.nombreDulceria,
                                precioDulceria: item.precioDulceria,
                                cantidadDulceria: item.cantidadDulceria,
                                totalDulceria: item.totalDulceria,
                                imgDulceria: item.imgDulceria
                            });
                        }
                    }
                });

                // Contruir filas idPago
                Object.values(historialAgrupado).forEach(item => {
                    
                    const row = document.createElement("div");
                    row.className = "perfil-usuario-footer";
                    row.style.marginTop = "20px";

                    const row2 = document.createElement("div");
                    row2.className = "row g-3";

                    const header = document.createElement("div");
                    header.className = "col-12";
                    header.innerHTML = `<h2>Reserva: ${item.fecha} - ${item.hora}</h2>`;
                    
                    header.addEventListener('click', () => {
                        const contenedorOcultar = row.querySelector('.contenedorOcultar');
                        if (contenedorOcultar.style.display === "none" || contenedorOcultar.style.display === "") {
                            contenedorOcultar.style.display = "block";
                        } else {
                            contenedorOcultar.style.display = "none";
                        }
                    });

                    row2.appendChild(header);

                    // div(películas, bebidas, combos, dulcería)
                    const contentDiv = document.createElement("div");
                    contentDiv.className = "col-12 contenedorOcultar";
                    contentDiv.style.display = "none";

                    // Mostrar las películas
                    item.peliculas.forEach(pelicula => {
                        const peliculaDiv = document.createElement("div");
                        peliculaDiv.className = "col-md-6 col-lg-4";
                        peliculaDiv.innerHTML = `
                            <h3>${pelicula.nombrePelicula}</h3>
                            <img src="../img/${pelicula.imgPelicula}" alt="${pelicula.nombrePelicula}" class="img-fluid">
                            <p>Precio: ${pelicula.precioPelicula} <br> Cantidad: ${pelicula.cantPelicula} <br> Total: ${pelicula.totalPelicula}</p>
                            <div><strong>Asientos:</strong></div>
                            <div class="d-flex">
                                ${pelicula.asientos.map(asiento => `
                                    <div class="d-flex flex-column align-items-center m-2">
                                        <img src="../img/img_asientos.png" alt="Asiento" class="img-fluid" style="max-width: 30px; height: auto;">
                                        <p>${asiento}</p>
                                    </div>
                                `).join('')}
                            </div>
                        `;
                        contentDiv.appendChild(peliculaDiv);
                    });

                    // Agrupar y mostrar las bebidas
                    if (item.bebidas.length > 0) {
                        const bebidaDiv = document.createElement("div");
                        bebidaDiv.className = "col-12";
                        bebidaDiv.innerHTML = "<h3>Bebidas</h3>";
                        const bebidasContainer = document.createElement("div");
                        bebidasContainer.className = "d-flex flex-wrap";
                        item.bebidas.forEach(bebida => {
                            const bebidaCard = document.createElement("div");
                            bebidaCard.className = "d-flex flex-column align-items-center m-2";
                            bebidaCard.innerHTML = ` 
                                <h4>${bebida.nombreBebida}</h4>
                                <img src="../img/${bebida.imgBebida}" alt="${bebida.nombreBebida}" class="img-fluid" style="max-width: 150px; height: auto;">
                                <p>Precio: ${bebida.precioBebida} | Cantidad: ${bebida.cantidadBebida} | Total: ${bebida.totalBebida}</p>
                            `;
                            bebidasContainer.appendChild(bebidaCard);
                        });
                        bebidaDiv.appendChild(bebidasContainer);
                        contentDiv.appendChild(bebidaDiv);
                    }

                    // Agrupar y mostrar los combos
                    if (item.combos.length > 0) {
                        const comboDiv = document.createElement("div");
                        comboDiv.className = "col-12";
                        comboDiv.innerHTML = "<h3>Combos</h3>";
                        const combosContainer = document.createElement("div");
                        combosContainer.className = "d-flex flex-wrap";
                        item.combos.forEach(combo => {
                            const comboCard = document.createElement("div");
                            comboCard.className = "d-flex flex-column align-items-center m-2";
                            comboCard.innerHTML = `
                                <h4>${combo.nombreCombos}</h4>
                                <img src="../img/${combo.imgCombos}" alt="${combo.nombreCombos}" class="img-fluid" style="max-width: 150px; height: auto;">
                                <p>Precio: ${combo.precioCombos} | Cantidad: ${combo.cantidadCombos} | Total: ${combo.totalCombos}</p>
                            `;
                            combosContainer.appendChild(comboCard);
                        });
                        comboDiv.appendChild(combosContainer);
                        contentDiv.appendChild(comboDiv);
                    }

                    // Agrupar y mostrar la dulcería
                    if (item.dulceria.length > 0) {
                        const dulceriaDiv = document.createElement("div");
                        dulceriaDiv.className = "col-12";
                        dulceriaDiv.innerHTML = "<h3>Dulcería</h3>";
                        const dulceriaContainer = document.createElement("div");
                        dulceriaContainer.className = "d-flex flex-wrap";
                        item.dulceria.forEach(dulceria => {
                            const dulceriaCard = document.createElement("div");
                            dulceriaCard.className = "d-flex flex-column align-items-center m-2";
                            dulceriaCard.innerHTML = `
                                <h4>${dulceria.nombreDulceria}</h4>
                                <img src="../img/${dulceria.imgDulceria}" alt="${dulceria.nombreDulceria}" class="img-fluid" style="max-width: 150px; height: auto;">
                                <p>Precio: ${dulceria.precioDulceria} | Cantidad: ${dulceria.cantidadDulceria} | Total: ${dulceria.totalDulceria}</p>
                            `;
                            dulceriaContainer.appendChild(dulceriaCard);
                        });
                        dulceriaDiv.appendChild(dulceriaContainer);
                        contentDiv.appendChild(dulceriaDiv);
                    }

                    row.appendChild(row2);
                    row.appendChild(contentDiv);

                    tbody.appendChild(row);
                });

            } else {
                console.log("No hay reservaciones");
                
                tbody.innerHTML = "<h3>No tienes Reservaciones</h3>";
            }
        })
        .catch(error => {
            console.error("Error en la llamada fetch: ", error);
        });
}
