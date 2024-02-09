
<%@page import="com.mycompany.consultorioodintologico2.logica.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/head.jsp" %>
<%@include file="components/bodyPrimeraParte.jsp" %>

<!-- Validacion Sesión -->
    <% //HttpSession misesion = request.getSession(); 
            String usuario = (String) request.getSession().getAttribute("username");
            String rol = (String) request.getSession().getAttribute("rol");
            
            if(!"Administrador".equals(rol)){
                response.sendRedirect("sinPermiso.jsp");
            }
    %>

<!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">Ver Usuarios</h1>
                    <p class="mb-4">A continuación podrá visualizar la lista completa de usuarios</p>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Usuarios</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Id</th>
                                            <th>Nombre de Usuario</th>
                                            <th>Rol</th>
                                            <th style="width: 210px;">Acción</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Id</th>
                                            <th>Nombre de Usuario</th>
                                            <th>Rol</th>
                                            <th style="width: 210px;">Acción</th>
                                        </tr>
                                    </tfoot>
                                    
                                    <%
                                        List<Usuario> listaUsuarios = (List) request.getSession().getAttribute("listaUsuarios");
                                    %>
                                    
                                    <tbody>
                                        <% for(Usuario u : listaUsuarios){ %>
                                        <tr>
                                            <td><%=u.getId_usuario()%></td>
                                            <td><%=u.getUsername()%></td>
                                            <td><%=u.getRol()%></td>
                                            <td style="display: flex; justify-content: space-around;">
                                                <form name="eliminar" action="SvEliminarUsuario" method="POST">
                                                        <button type="submit" class="btn btn-danger ">
                                                            <i class="fas fa-trash-alt"></i> Eliminar
                                                        </button>
                                                    <input type="hidden" name="id" value="<%=u.getId_usuario()%>"/>
                                                </form>
                                                <form name="editar" action="SvEditarUsuario" method="GET">
                                                        <button type="submit" class="btn btn-primary ">
                                                            <i class="fas fa-pencil-alt"></i> Editar
                                                        </button>
                                                    <input type="hidden" name="id" value="<%=u.getId_usuario()%>"/>
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