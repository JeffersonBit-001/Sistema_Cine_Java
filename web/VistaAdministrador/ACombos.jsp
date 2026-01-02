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

        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#agregarModal" data-bs-whatever="@mdo">Agregar Combos</button>

        <div class="modal fade" id="agregarModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="exampleModalLabel">Nueva Película</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">

                        <!-- FORMULARIO -->
                        <form id ="form_agg" action="<%= request.getContextPath()%>/ControladorPeli?tipoc=${estados_contralador}" method="post" enctype="multipart/form-data">

                            <div class="mb-2">
                                <label for="nombre" class="form-label">Nombre:</label>
                                <input type="text" name="nombre2" id="nombre2" class="form-control" required>
                            </div>


                            <div class="mb-2">
                                <label for="nombre" class="form-label">Abastece:</label>
                                <input type="text" name="abastece2" id="abastece2" class="form-control" required>
                            </div>


                            <div class="mb-2">
                                <label for="nombre" class="form-label">Imagen:</label>
                                <input type="file" name="imagen2" id="imagen2" class="custom-file input-group-text input-group-append" required>
                            </div>

                            <div class="mb-2">
                                <label for="nombre" class="form-label">Sinopsis:</label>
                                <input type="text" name="sinopsis2" id="sinopsis2" class="form-control" required>
                            </div>


                            <div class="mb-2">
                                <label for="nombre" class="form-label">Precio:</label>
                                <input type="text" name="precio2" id="precio2" class="form-control" required>
                            </div>


                            <div class="mb-2">
                                <label for="nombre" class="form-label">Oferta:</label>
                                <input type="text" name="oferta2" id="oferta2" class="form-control" required>
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
                        <h1 class="modal-title fs-5" id="exampleModalLabel2">Modificar Películas</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">

                        <!-- FORMULARIO -->
                        <form id="formUpdate" action="<%=request.getContextPath()%>/ControladorPeli?tipoc=${estados_contralador}" method="post" enctype="multipart/form-data">


                            <input type="hidden" id="id" name="id">
                            <div class="mb-2">
                                <label for="nombre" class="form-label">Nombre:</label>
                                <input type="text" name="nombre" id="nombre" class="form-control" required>
                            </div>


                            <div class="mb-2">
                                <label for="nombre" class="form-label">Abastece:</label>
                                <input type="text" name="abastece" id="abastece" class="form-control" required>
                            </div>


                            <div class="mb-2">
                                <label for="nombre" class="form-label">Imagen:</label>
                                <img id="vistaPreviaImagen" class="input-group-text input-group-append" src="#" alt="Vista previa de la imagen" style="max-width: 200px; max-height: 200px;">
                                <input type="file" name="imagen" id="imagen" class="custom-file input-group-text input-group-append" required>
                            </div>

                            <div class="mb-2">
                                <label for="nombre" class="form-label">Sinopsis:</label>
                                <input type="text" name="sinopsis" id="sinopsis" class="form-control" required>
                            </div>


                            <div class="mb-2">
                                <label for="nombre" class="form-label">Precio:</label>
                                <input type="text" name="precio" id="precio" class="form-control" required>
                            </div>


                            <div class="mb-2">
                                <label for="nombre" class="form-label">Oferta:</label>
                                <input type="text" name="oferta" id="oferta" class="form-control" required>
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
                                <th scope="col">Nombre</th>
                                <th scope="col">Abastece</th>
                                <th scope="col">Imagen</th>
                                <th scope="col">Sinopsis</th>
                                <th scope="col">Precio</th>
                                <th scope="col">Oferta</th>
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






    <script src="<%= request.getContextPath()%>/js/Adm_combos.js" type="text/javascript"></script>




</html>
