<%@page import="com.mycompany.consultorioodintologico2.logica.Secretaria"%>
<%@page import="com.mycompany.consultorioodintologico2.logica.Odontologo"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/head.jsp" %>
<%@include file="components/bodyPrimeraParte.jsp" %>

<!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">Ver Secretarias</h1>
                    <p class="mb-4">A continuación podrá visualizar la lista completa de secretarias(o)</p>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Secretarias</h6>
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
                                            <th>Sector</th>
                                            <th style="width: 210px;">Acción</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Id</th>
                                            <th>Documento Identidad</th>
                                            <th>Nombre</th>
                                            <th>Apellido</th>
                                            <th>Sector</th>
                                            <th style="width: 210px;">Acción</th>
                                        </tr>
                                    </tfoot>
                                    
                                    <%
                                        List<Secretaria> listaSecretarias = (List) request.getSession().getAttribute("listaSecretarias");
                                    %>
                                    
                                    <tbody>
                                        <% for(Secretaria s : listaSecretarias){ %>
                                        <tr>
                                            <td><%=s.getId()%></td>
                                            <td><%=s.getDocumento_identidad()%></td>
                                            <td><%=s.getNombre()%></td>
                                            <td><%=s.getApellido()%></td>
                                            <td><%=s.getSector()%></td>
                                            <td style="display: flex; justify-content: space-around;">
                                                <form name="eliminar" action="SvEliminarSecretaria" method="POST">
                                                        <button type="submit" class="btn btn-danger ">
                                                            <i class="fas fa-trash-alt"></i> Eliminar
                                                        </button>
                                                    <input type="hidden" name="id" value="<%=s.getId()%>"/>
                                                </form>
                                                <form name="editar" action="SvEditarSecretaria" method="GET">
                                                        <button type="submit" class="btn btn-primary ">
                                                            <i class="fas fa-pencil-alt"></i> Editar
                                                        </button>
                                                    <input type="hidden" name="id" value="<%=s.getId()%>"/>
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