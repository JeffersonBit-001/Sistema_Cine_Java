<%-- 
    Document   : index
    Created on : 26 ago. 2024, 19:45:39
    Author     : JEFFERSON
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CINESTAR</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="Free HTML Templates" name="keywords">
    <meta content="Free HTML Templates" name="description">

    <link href="../css/FormRegistro.css" rel="stylesheet">
    
</head>

<body>
    <%@include file="Cabecera.jsp" %>
    
    
    <!-- Header Start -->
    <div class="jumbotron jumbotron-fluid bg-jumbotron jum_edit" style="margin-bottom: 90px;">
        <div class="container text-center py-5">
            <h3 class="text-white display-3 mb-4">Formulario de Sugerencias</h3>
            <div class="d-inline-flex align-items-center text-white flex_what">
                <p class="m-0"><a class="text-white" href="../Main.jsp">Home</a></p>
                <i class="far fa-circle px-3"></i>
                <p class="m-0">Sugerencias</p>
            </div>
        </div>
    </div>
    
    
    
    <div class="container_todo">
        
    
            <div class="form_container">
                <h1 id="form_title">Formulario de Registro</h1>
                <form action="#" method="post">
                    <div class="form-row">
                        <div class="form-group">
                            <label for="nombre">Nombre</label>
                            <input type="text" id="nombre" name="nombre" required>
                        </div>
                        <div class="form-group">
                            <label for="apellido">Apellido</label>
                            <input type="text" id="apellido" name="apellido" required>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group">
                            <label for="dni">DNI</label>
                            <input type="text" id="dni" name="dni" required>
                        </div>
                        <div class="form-group">
                            <label for="genero">Género</label>
                            <select id="genero" name="genero" required>
                                <option value="" disabled selected>Seleccione...</option>
                                <option value="masculino">Masculino</option>
                                <option value="femenino">Femenino</option>
                                <option value="otro">Otro</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group">
                            <label for="fecha_nacimiento">Fecha de Nacimiento</label>
                            <input type="date" id="fecha_nacimiento" name="fecha_nacimiento" required>
                        </div>
                        <div class="form-group">
                            <label for="telefono">Teléfono</label>
                            <input type="tel" id="telefono" name="telefono" required>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group">
                            <label for="correo">Correo Electrónico</label>
                            <input type="email" id="correo" name="correo" required>
                        </div>
                        <div class="form-group">
                            <label for="correo_confirmacion">Confirmación de Correo Electrónico</label>
                            <input type="email" id="correo_confirmacion" name="correo_confirmacion" required>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group">
                            <label for="contrasena">Contraseña</label>
                            <input type="password" id="contrasena" name="contrasena" required>
                        </div>
                        <div class="form-group">
                            <label for="contrasena_confirmacion">Confirmación de Contraseña</label>
                            <input type="password" id="contrasena_confirmacion" name="contrasena_confirmacion" required>
                        </div>
                    </div>

                    <div class="form-row rowdis">
                        <div class="form-group display-check">
                            <input type="checkbox" id="proporciones" name="proporciones" required>
                            <label id="lab-chekck" for="proporciones">Acepto proporcionar mis datos para el análisis.</label>
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="form-group display-check">
                            <input type="checkbox" id="terminos" name="terminos" required>
                            <label id="lab-chekck" for="terminos">He leído y acepto los términos y condiciones.</label>
                        </div>
                    </div>
                    <div class="form-group">
                        <input type="submit" class="btn btn-lg btn-primary btn-lg-square mr-2 edit_buton" value="Registrarse">
                    </div>
                </form>
            </div>
     

        </div>
    
    <%@include file="Pie.jsp" %>
    
    
</body>

</html>