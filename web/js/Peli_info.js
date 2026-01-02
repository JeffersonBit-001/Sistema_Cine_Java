/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
fetch("<%= request.getContextPath()%>/../ControladorPrincipal?accion=listarMaterialesJSON")
            .then(response => {
                if (!response.ok) {
                    throw new Error("Network response was not ok " + response.statusText);
                }
                return response.json();
            })
            .then(data => {
                /*const tbody = document.querySelector("#tabla tbody");
                tbody.innerHTML = "";   // Limpiar la tabla antes de agregar nuevos datos

                data.forEach(material => {
                    const row = document.createElement("tr");

                    row.innerHTML =
                            "<td>" + material.idMaterial + "</td>"
                            + "<td>" + material.nombre + "</td>"
                            + "<td>" + material.cantidad + "</td>"
                            + "<td>" + material.categoria.nombre + "</td>" +
                            "<td>" +
                            "<a href='" + window.location.origin + "/ControladorPrincipal?accion=edit&id=" + material.idMaterial + "'>" +
                            "<i class='fa-solid fa-pen-to-square editar'></i>" +
                            "</a>" +
                            "<a href='" + window.location.origin + "/ControladorPrincipal?accion=delete&id=" + material.idMaterial + "'>" +
                            "<i class='fa-sharp fa-solid fa-trash delete'></i>" +
                            "</a>" +
                            "</td>";

                    tbody.appendChild(row);
                });*/
    
                $("#framee").attr('src', '' + data[0].link + '&controls=0&autohide=0&rel=0');

            })
            .catch(error => {
                console.error("Error en la llamada fetch: ", error);
                     });

