<%-- 
    Document   : AReservaciones
    Created on : 3 dic. 2024, 21:02:31
    Author     : JEFFERSON
--%>

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
                width: 12px;
            }

            .dataTables_scrollBody::-webkit-scrollbar-thumb {
                background-color: rgba(0, 0, 0, 0.8);
                border-radius: 6px;
            }

            .dataTables_scrollBody::-webkit-scrollbar-track {
                background: rgba(0, 128, 128, 0.2);
            }

        </style>
    </head>
    <body>


        <!-- AGREGAR MODAL Empleados -->

        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#agregarModal" data-bs-whatever="@mdo">Agregar Reservaciones</button>

        <div class="modal fade" id="agregarModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="exampleModalLabel">Nueva Reservación</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">

                        <!-- FORMULARIO -->
                        <form id ="form_agg" action="<%= request.getContextPath()%>/ControladorPeli?tipoc=${estados_contralador}" method="post" enctype="multipart/form-data">

                           


                                <div class="mb-2">
                                    <label for="floatingSelect">Películas</label>
                                    <select class="form-select" name="pelicula2" id="pelicula2" aria-label="Floating label select example">
                                        <option selected>--Selecciona--</option>
                                        

                                    </select>
                                </div>

                                <div class="mb-2">
                                    <label for="floatingSelect">Sede</label>
                                    <select class="form-select" name="sede2" id="sede2" aria-label="Floating label select example">
                                        <option selected>--Selecciona--</option>
                                        

                                    </select>
                                </div>


                                <div class="mb-2">
                                    <label for="floatingSelect">Hora</label>
                                    <select class="form-select" name="hora2" id="hora2" aria-label="Floating label select example">
                                        <option selected>--Selecciona--</option>
                                        

                                    </select>
                                </div>



                                <div class="mb-2">
                                    <label for="floatingSelect">Categoria</label>
                                    <select class="form-select" name="categoria2" id="categoria2" aria-label="Floating label select example">
                                        <option selected>--Selecciona--</option>
                                        

                                    </select>
                                </div>


                                <div class="mb-2">
                                    <label for="floatingSelect">Día</label>
                                    <select class="form-select" name="dia2" id="dia2" aria-label="Floating label select example">
                                        <option selected>--Selecciona--</option>
                                        

                                    </select>
                                </div>


                                <div class="mb-2">
                                    <label for="floatingSelect">Vista</label>
                                    <select class="form-select" name="vista2" id="vista2" aria-label="Floating label select example">
                                        <option selected>--Selecciona--</option>
                                        

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
                        <h1 class="modal-title fs-5" id="exampleModalLabel2">Modificar Detalle Película</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">

                        <!-- FORMULARIO -->
                        <form id="formUpdate" action="<%=request.getContextPath()%>/ControladorPeli?tipoc=${estados_contralador}" method="post" enctype="multipart/form-data">


                            <input type="hidden" id="id" name="id">

                            <div class="mb-2">
                                <label for="floatingSelect">Películas</label>
                                <select class="form-select" name="pelicula" id="pelicula" aria-label="Floating label select example">
                                    <option selected>--Selecciona--</option>
                                    

                                </select>
                            </div>

                            <div class="mb-2">
                                <label for="floatingSelect">Sede</label>
                                <select class="form-select" name="sede" id="sede" aria-label="Floating label select example">
                                    <option selected>--Selecciona--</option>
                                    

                                </select>
                            </div>


                            <div class="mb-2">
                                <label for="floatingSelect">Hora</label>
                                <select class="form-select" name="hora" id="hora" aria-label="Floating label select example">
                                    <option selected>--Selecciona--</option>
                                    

                                </select>
                            </div>



                            <div class="mb-2">
                                <label for="floatingSelect">Categoria</label>
                                <select class="form-select" name="categoria" id="categoria" aria-label="Floating label select example">
                                    <option selected>--Selecciona--</option>
                                    

                                </select>
                            </div>


                            <div class="mb-2">
                                <label for="floatingSelect">Día</label>
                                <select class="form-select" name="dia" id="dia" aria-label="Floating label select example">
                                    <option selected>--Selecciona--</option>
                                    

                                </select>
                            </div>


                            <div class="mb-2">
                                <label for="floatingSelect">Vista</label>
                                <select class="form-select" name="vista" id="vista" aria-label="Floating label select example">
                                    <option selected>--Selecciona--</option>
                                    

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
                                <th scope="col">ID</th>
                                <th scope="col">ID Pago</th>
                                <th scope="col">ID Cliente</th>
                                <th scope="col">Nombre</th>
                                <th scope="col">ID Bebida</th>
                                <th scope="col">Nombre</th>
                                <th scope="col">Cantidad</th>
                                <th scope="col">Precio Total</th>
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






    <script src="<%= request.getContextPath()%>/js/ADetalleDulceriaReservaAjx.js" type="text/javascript"></script>


</html>

