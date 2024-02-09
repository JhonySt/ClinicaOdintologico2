<%@page import="com.mycompany.consultorioodintologico2.logica.Paciente"%>
<%@page import="com.mycompany.consultorioodintologico2.logica.Odontologo"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/head.jsp" %>
<%@include file="components/bodyPrimeraParte.jsp" %>

<!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">Ver Pacientes</h1>
                    <p class="mb-4">A continuación podrá visualizar la lista completa de pacientes</p>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Pacientes</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Id</th>
                                            <th>Documento Identidad</th>
                                            <th>Nombre</th>
                                            <th>Apellido</th>
                                            <th>Tipo de Sangre</th>
                                            <th style="width: 210px;">Acción</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Id</th>
                                            <th>Documento Identidad</th>
                                            <th>Nombre</th>
                                            <th>Apellido</th>
                                            <th>Tipo de Sangre</th>
                                            <th style="width: 210px;">Acción</th>
                                        </tr>
                                    </tfoot>
                                    
                                    <%
                                        List<Paciente> listaPacientes = (List) request.getSession().getAttribute("listaPacientes");
                                    %>
                                    
                                    <tbody>
                                        <% for(Paciente p : listaPacientes){ %>
                                        <tr>
                                            <td><%=p.getId()%></td>
                                            <td><%=p.getDocumento_identidad()%></td>
                                            <td><%=p.getNombre()%></td>
                                            <td><%=p.getApellido()%></td>
                                            <td><%=p.getTipo_sangre()%></td>
                                            <td style="display: flex; justify-content: space-around;">
                                                <form name="eliminar" action="SvEliminarPaciente" method="POST">
                                                        <button type="submit" class="btn btn-danger ">
                                                            <i class="fas fa-trash-alt"></i> Eliminar
                                                        </button>
                                                    <input type="hidden" name="id" value="<%=p.getId()%>"/>
                                                </form>
                                                <form name="editar" action="SvEditarPaciente" method="GET">
                                                        <button type="submit" class="btn btn-primary ">
                                                            <i class="fas fa-pencil-alt"></i> Editar
                                                        </button>
                                                    <input type="hidden" name="id" value="<%=p.getId()%>"/>
                                                </form>
                                            </td>
                                        </tr>
                                        <% } %>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->
            
    
<%@include file="components/bodyFinal.jsp" %>

