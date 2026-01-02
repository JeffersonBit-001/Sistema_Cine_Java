<%-- 
    Document   : HuellaForm
    Created on : 4 set. 2024, 00:12:35
    Author     : JEFFERSON
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <link rel="stylesheet" href="../css/huella_form.css"/>
    </head>
    <body id="body_form">
        
        <%@include file="Cabecera.jsp" %>
        
        <!-- TITLE -->
        <div class="jumbotron jumbotron-fluid bg-jumbotron edit_but" style="margin-bottom: 90px;">
            <div class="container text-center py-5">
                <h3 class="text-white display-3 mb-4">Cinestar Verde</h3>
                <div class="d-inline-flex align-items-center text-white flex_what">
                    <p class="m-0"><a class="text-white" href="../Main.jsp">Home</a></p>
                    <i class="far fa-circle px-3"></i>
                    <p class="m-0">Cinestar Verde</p>
                </div>
            </div>
        </div>
        <!-- TITLE -->
        
        
        <div class="formulario-container">
                <h2>Complete el siguiente formulario</h2>
                <form id="huellaForm" action="#" method="post">
                    <div class="form-group">
                        <label for="nombre">Nombre*</label>
                        <input type="text" id="nombre" name="nombre" required>
                    </div>
                    <div class="form-group">
                        <label for="correo">Correo*</label>
                        <input type="email" id="correo" name="correo" required>
                    </div>
                    <div class="form-group">
                        <label for="telefono">Teléfono*</label>
                        <input type="tel" id="telefono" name="telefono" required>
                    </div>
                    <div class="form-group">
                        <label for="pais">País*</label>
                        <select id="pais" name="pais" required>
                            <option value="">Seleccione</option>
                            <option value="Peru">Perú</option>
                            <!-- Añade más opciones de países aquí -->
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="ciudad">Ciudad*</label>
                        <input type="text" id="ciudad" name="ciudad" required>
                    </div>
                    <div class="form-group">
                        <label for="mensaje">Mensaje</label>
                        <textarea id="mensaje" name="mensaje"></textarea>
                    </div>
                    <div class="form-group checkbox">
                        <input type="checkbox" id="whatsapp" name="whatsapp">
                        <label for="whatsapp">Contactarme por Whatsapp</label>
                    </div>
                    <div class="form-group checkbox">
                        <input type="checkbox" id="privacidad" name="privacidad" required>
                        <label for="privacidad">Acepto políticas de privacidad de datos</label>
                    </div>
                    <div class="form-group">
                        <button type="submit">Enviar</button>
                    </div>
                </form>
        </div>

            <!-- Modal -->
            <div id="myModal" class="modal">
                <div class="modal-content">
                    <span class="close">&times;</span>
                    <p>Gracias por registrarte</p>
                </div>
            </div>

            <script src="JS/cabecera.js"></script>
            <script>
                // Get the modal
                var modal = document.getElementById("myModal");

                // Get the <span> element that closes the modal
                var span = document.getElementsByClassName("close")[0];

                // When the user clicks on <span> (x), close the modal
                span.onclick = function() {
                    modal.style.display = "none";
                }

                // When the user clicks anywhere outside of the modal, close it
                window.onclick = function(event) {
                    if (event.target == modal) {
                        modal.style.display = "none";
                    }
                }

                // Form submission
                document.getElementById("huellaForm").onsubmit = function(event) {
                    event.preventDefault();
                    if (this.checkValidity()) {
                        modal.style.display = "block";
                    }
                }
            </script>

            
            <%@include file="Pie.jsp" %>

    </body>
</html>
