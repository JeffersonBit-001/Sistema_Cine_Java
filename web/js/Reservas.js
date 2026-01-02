
document.getElementById('btn_reserva').addEventListener('click', function(event) {
    event.preventDefault(); 

    var checkboxes = document.querySelectorAll('.btn_sala');
    var contador = 0;
    var formulario = document.getElementById('form_id');

    checkboxes.forEach(function(checkbox) {
        if (checkbox.checked) {
            contador++;
        }
    });

    
    if (contador === 0) {
        Swal.fire({
            icon: "error",
            title: "Oops...",
            text: "¡Olvidaste seleccionar tu asiento!"
        });
    } else {
        Swal.fire({
            icon: "success",
            text: "Selección exitosa"
        }).then((result) => {
            if (result.isConfirmed) {
                
                formulario.submit();
            }
        });
    }
});

document.addEventListener('DOMContentLoaded', function() {
    var texto = document.getElementById('butaca_seleccionadas');
    var contadorTexto = document.getElementById('contador_seleccionados');

    const checkboxes = document.querySelectorAll('input[name^="check_asiento["]'); // Cambiado

    checkboxes.forEach(checkbox => {
        checkbox.addEventListener('change', function() {
            var contenedor = this.parentElement;
            contenedor.style.backgroundColor = this.checked ? 'purple' : 'white';

            var seleccionados = document.querySelectorAll('input[name^="check_asiento["]:checked');
            var contador = seleccionados.length;

            texto.textContent = `Butacas seleccionadas: ${Array.from(seleccionados).map(cb => cb.value).join(', ')}`;
            contadorTexto.textContent = `Entradas: ${contador}`;

            var precioSeleccionado = parseFloat(document.getElementById('precio_seleccionados_input').value);
            var precio_total = precioSeleccionado * contador;

            var text_precio_total = document.getElementById('precio_total');
            text_precio_total.textContent = `Precio Total: S/. ${precio_total.toFixed(2)}`;
            document.getElementById('precio_total_input').value = `${precio_total.toFixed(2)}`;

            document.getElementById('butacas_seleccionadas_input').value = `${Array.from(seleccionados).map(cb => cb.value).join(', ')}`;
            document.getElementById('contador_busc').value = `${contador}`;
        });
    });
});
