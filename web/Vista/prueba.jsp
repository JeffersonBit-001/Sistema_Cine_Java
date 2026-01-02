<%-- 
    Document   : prueba
    Created on : 22 set. 2024, 22:54:08
    Author     : JEFFERSON
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="">
        <div class="container_selector">
            <button class="button_t decrease">-</button>
            <input type="text" class="input_t valueInput" value="0" readonly>
            <button class="button_t increase">+</button>
        </div>
        <div class="container_selector">
            <button class="button_t decrease">-</button>
            <input type="text" class="input_t valueInput" value="0" readonly>
            <button class="button_t increase">+</button>
        </div>
        <div class="container_selector">
            <button class="button_t decrease">-</button>
            <input type="text" class="input_t valueInput" value="0" readonly>
            <button class="button_t increase">+</button>
        </div>
    </div>
    
    <script>
        // Seleccionamos todos los contenedores de selector
        const containers = document.querySelectorAll('.container_selector');

        containers.forEach(container => {
            const decreaseButton = container.querySelector('.decrease');
            const increaseButton = container.querySelector('.increase');
            const valueInput = container.querySelector('.valueInput');

            let currentValue = 0;

            decreaseButton.addEventListener('click', () => {
                currentValue--;
                valueInput.value = currentValue;
            });

            increaseButton.addEventListener('click', () => {
                currentValue++;
                valueInput.value = currentValue;
            });
        });
    </script>
    </body>
</html>
