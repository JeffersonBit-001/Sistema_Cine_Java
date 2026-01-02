/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

cargarPrincipal();
function cargarPrincipal() {
    fetch("../ControladorPreguntasFrecuentes")
            .then(response => {
                if (!response.ok) {
                    throw new Error("Network response was not ok " + response.statusText);
                }
                return response.json();
            })
            .then(data => {

                const tbody = document.querySelector("#preguntas_mostrar");
                tbody.innerHTML = "";
                let text = "";
                data.forEach(preguntasx => {
                    let a = `
                    <div class="faq-item">
                        <div class="faq-question">
                            <h2>${preguntasx.nombre}</h2>
                        </div>
                        <div class="faq-answer">
                            <p>${preguntasx.descripcion}</p>
                        </div>
                    </div>
                    `;

                    text = text + a;
                });

                tbody.innerHTML = text;
                detalles();
            })
            .catch(error => {
                console.error('Error al obtener datos:', error);
            });
}

function detalles() {
    document.querySelectorAll('.faq-question').forEach(question => {
        question.addEventListener('click', () => {
            const parent = question.parentElement;

            parent.classList.toggle('active');


            document.querySelectorAll('.faq-item').forEach(item => {
                if (item !== parent) {

                    item.classList.remove('active');


                }
            });
        });
    });
}