<%-- 
    Document   : AUsuarios
    Created on : 3 nov. 2024, 12:16:55
    Author     : JEFFERSON
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

        <style>
            /* Estilo del contenedor del scroll 
            .dataTables_wrapper .dataTables_scrollBody {
                border: 1px solid #808080;
                background-color: rgba(128, 128, 128, 0.1);
            }*/

            .dataTables_scrollBody::-webkit-scrollbar {
                width: 12px; /* Ancho del scrollbar */
            }

            .dataTables_scrollBody::-webkit-scrollbar-thumb {
                background-color: rgba(0, 0, 0, 0.8); /* Color del thumb gris más oscuro */
                border-radius: 6px;
            }

            .dataTables_scrollBody::-webkit-scrollbar-track {
                background: rgba(0, 128, 128, 0.2); /* Color del track gris más claro */
            }

        </style>
    </head>
    <body>

        
        <!-- AGREGAR MODAL Empleados -->

        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#agregarModal" data-bs-whatever="@mdo">Agregar Empleado</button>

        <div class="modal fade" id="agregarModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="exampleModalLabel">Nuevo Empleado</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">

                        <!-- FORMULARIO -->
                        <form id="form_agg" action="<%=request.getContextPath()%>/ContUsuarios?tipoc=AdministradorUsuarios" method="post">


                            <div class="mb-2">
                                <label for="nombre" class="form-label">Nombre:</label>
                                <input type="text" name="nombres2" id="nombres2" class="form-control" required>
                            </div>


                            <div class="mb-2">
                                <label for="nombre" class="form-label">Apellido:</label>
                                <input type="text" name="apellidos2" id="apellidos2" class="form-control" required>
                            </div>


                            <div class="mb-2">
                                <label for="nombre" class="form-label">DNI:</label>
                                <input type="text" name="dni2" id="dni2" class="form-control" required>
                            </div>

                            <div class="mb-2">
                                <label for="genero" class="form-label">Género:</label>
                                <input type="text" name="genero2" id="genero2" class="form-control" required>
                            </div>

                            <div class="mb-2">
                                <label for="nombre" class="form-label">Fecha Nacimiento:</label>
                                <input type="date" name="fecha2" id="fecha2" class="form-control" required>
                            </div>


                            <div class="mb-2">
                                <label for="nombre" class="form-label">Teléfono:</label>
                                <input type="text" name="cel2" id="cel2" class="form-control" required>
                            </div>

                            <div class="mb-2">
                                <label for="nombre" class="form-label">Domicilio:</label>
                                <input type="text" name="domicilio2" id="domicilio2" class="form-control" required>
                            </div>



                            <div class="mb-2">
                                <label for="nombre" class="form-label">Email:</label>
                                <input type="email" name="correo2" id="correo2" class="form-control" required>
                            </div>

                            <div class="mb-2">
                                <label for="nombre" class="form-label">Email Confirmación:</label>
                                <input type="email" name="correo_confirm2" id="correo_confirm2" class="form-control" required>
                            </div>


                            <div class="mb-2">
                                <label for="nombre" class="form-label">Contraseña:</label>
                                <input type="password" name="pass2" id="pass2" class="form-control" required>
                            </div>


                            <div class="mb-2">
                                <label for="nombre" class="form-label">Confirma contraseña:</label>
                                <input type="password" name="pass_confirm2" id="pass_confirm2" class="form-control" required>
                            </div>



                            <div class="mb-2">
                                <label for="floatingSelect">Estado</label>
                                <select class="form-select" name="estado2" id="estado2" aria-label="Floating label select example">


                                </select>

                            </div>

                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary me-1" data-bs-dismiss="modal">Cerrar</button>
                                <button type="submit" name="accion" value="agregar"  class="btn btn-primary ms-1"><i class="fa-solid fa-floppy-disk"></i> Guardar</button>
                            </div>


                        </form>


                    </div>




                </div>
            </div>
        </div>


        <!-- MODIFICAR MODAL -->
        <div class="modal fade" id="modificarModal" tabindex="-1" aria-labelledby="exampleModalLabel2" aria-hidden="true">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="exampleModalLabel2">Modificar ${titulo}</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">

                        <!-- FORMULARIO -->
                        <form id="formUpdate" action="<%=request.getContextPath()%>/ContUsuarios?tipoc=AdministradorUsuarios" method="post">

                            <input type="hidden" id="id" name="id">


                            <div class="mb-2">
                                <label for="nombre" class="form-label">Nombre:</label>
                                <input type="text" name="nombres" id="nombres" class="form-control" required>
                            </div>


                            <div class="mb-2">
                                <label for="nombre" class="form-label">Apellido:</label>
                                <input type="text" name="apellidos" id="apellidos" class="form-control" required>
                            </div>


                            <div class="mb-2">
                                <label for="nombre" class="form-label">DNI:</label>
                                <input type="text" name="dni" id="dni" class="form-control" required>
                            </div>

                            <div class="mb-2">
                                <label for="genero" class="form-label">Género:</label>
                                <input type="text" name="genero" id="genero" class="form-control" required>
                            </div>

                            <div class="mb-2">
                                <label for="nombre" class="form-label">Fecha Nacimiento:</label>
                                <input type="date" name="fecha" id="fecha" class="form-control" required>
                            </div>


                            <div class="mb-2">
                                <label for="nombre" class="form-label">Teléfono:</label>
                                <input type="text" name="cel" id="cel" class="form-control" required>
                            </div>

                            <div class="mb-2">
                                <label for="nombre" class="form-label">Domicilio:</label>
                                <input type="text" name="domicilio" id="domicilio" class="form-control" required>
                            </div>



                            <div class="mb-2">
                                <label for="nombre" class="form-label">Email:</label>
                                <input type="email" name="correo" id="correo" class="form-control" required>
                            </div>

                            <div class="mb-2">
                                <label for="nombre" class="form-label">Email Confirmación:</label>
                                <input type="email" name="correo_confirm" id="correo_confirm" class="form-control" required>
                            </div>


                            <div class="mb-2">
                                <label for="nombre" class="form-label">Contraseña:</label>
                                <input type="password" name="pass" id="pass" class="form-control" required>
                            </div>


                            <div class="mb-2">
                                <label for="nombre" class="form-label">Confirma contraseña:</label>
                                <input type="password" name="pass_confirm" id="pass_confirm" class="form-control" required>
                            </div>



                            <div class="mb-2">
                                <label for="floatingSelect">Estado</label>
                                <select class="form-select" name="estado" id="estado" aria-label="Floating label select example">



                                </select>

                            </div>

                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary me-1" data-bs-dismiss="modal">Cerrar</button>
                                <button type="submit" name="accion" value="update2"  class="btn btn-primary ms-1"><i class="fa-solid fa-floppy-disk"></i> Guardar</button>
                            </div>


                        </form>


                    </div>

                </div>
            </div>
        </div>




        <!--TABLA DE REGISTROS-->

        <div class="container"> <!--begin::Row-->

            <div class="row">
                <div class="col-lg-12">
                    <table id="tablax" class="table table-hover border-top-color-black display nowrap" style="width:100%">
                        <thead class="table-dark">
                            <tr>
                                <th scope="col">Id</th>
                                <th scope="col">Nombres</th>
                                <th scope="col">Apellidos</th>
                                <th scope="col">DNI</th>
                                <th scope="col">Género</th>
                                <th scope="col">Fecha Nac.</th>
                                <th scope="col">Teléfono</th>
                                <th scope="col">Domicilio</th>
                                <th scope="col">Correo</th>
                                <th scope="col">Correo C.</th>
                                <th scope="col">Contraseña</th>
                                <th scope="col">Contraseña C.</th>
                                <th scope="col">Acción</th>

                            </tr>
                        </thead>


                        <tbody class="tbody_cuerpo table-group-divider">






                        </tbody>
                    </table>

                </div>

            </div>




        </div> <!--end::Container-->









    </body>

    




    <script src="<%= request.getContextPath()%>/js/Adm_usuarios.js" type="text/javascript"></script>




</html>
