
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.mycompany.consultorioodintologico2.logica.Cita"%>
<%@page import="com.mycompany.consultorioodintologico2.logica.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/head.jsp" %>
<%@include file="components/bodyPrimeraParte.jsp" %>

<!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">Ver Citas</h1>
                    <p class="mb-4">A continuación podrá visualizar la lista completa de citas</p>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Citas</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Id</th>
                                            <th>Fecha Cita</th>
                                            <th>Hora</th>
                                            <th>Nombre Odontologo</th>
                                            <th>Nombre Paciente</th>
                                            <th style="width: 210px;">Acción</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Id</th>
                                            <th>Fecha Cita</th>
                                            <th>Hora</th>
                                            <th>Nombre Odontologo</th>
                                            <th>Nombre Paciente</th>
                                            <th style="width: 210px;">Acción</th>
                                        </tr>
                                    </tfoot>
                                    
                                    <%
                                        List<Cita> citas = (List) request.getSession().getAttribute("citas");
                                    %>
                                    
                                    <tbody>
                                        <% for(Cita c : citas){ %>
                                        <tr>
                                            <td><%=c.getId_cita()%></td>
                                            <%
                                                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                                                String fechaString = formato.format(c.getFecha_cita());
                                            %>
                                            <td><%=fechaString%></td>
                                            <td><%=c.getHora_cita()%></td>
                                            <td><%=c.getOdontologo().getNombre()%> <%=c.getOdontologo().getApellido()%></td>
                                            <td><%=c.getPaciente().getNombre()%> <%=c.getPaciente().getApellido()%></td>
                                            <td style="display: flex; justify-content: space-around;">
                                                <form name="eliminar" action="SvEliminarUsuario" method="POST">
                                                        <button type="submit" class="btn btn-danger ">
                                                            <i class="fas fa-trash-alt"></i> Eliminar
                                                        </button>
                                                    <input type="hidden" name="id" value="<%=c.getId_cita()%>"/>
                                                </form>
                                                <form name="editar" action="SvEditarUsuario" method="GET">
                                                        <button type="submit" class="btn btn-primary ">
                                                            <i class="fas fa-pencil-alt"></i> Editar
                                                        </button>
                                                    <input type="hidden" name="id" value="<%=c.getId_cita()%>"/>
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
