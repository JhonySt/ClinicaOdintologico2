<%@page import="com.mycompany.consultorioodintologico2.logica.Secretaria"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.mycompany.consultorioodintologico2.logica.Odontologo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/head.jsp" %>
<%@include file="components/bodyPrimeraParte.jsp" %>

    
    <div class="container">
        <h1>Editar Secretaria</h1>
        
        <% Secretaria s = (Secretaria) request.getSession().getAttribute("secretaria");%>
        
        <form class="user" action="SvEditarSecretaria" method="POST">
            <div class="form-group col">
                <input type="hidden" id="id" name="id" value="<%=s.getId()%>"/>
                <div class="col-sm-6 mb-3">
                    <input type="text" class="form-control form-control-user" id="dni"
                           placeholder="Documento Identidad" name="dni" value="<%=s.getDocumento_identidad()%>">
                </div>
                <div class="col-sm-6 mb-3">
                    <input type="text" class="form-control form-control-user" id="nombre"
                        placeholder="Nombre" name="nombre" value="<%=s.getNombre()%>">
                </div>
                <div class="col-sm-6 mb-3">
                    <input type="text" class="form-control form-control-user" id="apellido"
                           placeholder="Apellido" name="apellido" value="<%=s.getApellido()%>">
                </div>
                <div class="col-sm-6 mb-3">
                    <input type="text" class="form-control form-control-user" id="telefono"
                           placeholder="Teléfono" name="telefono" value="<%=s.getTelefono()%>">
                </div>
                <div class="col-sm-6 mb-3">
                    <input type="text" class="form-control form-control-user" id="direccion"
                           placeholder="Direccion" name="direccion" value="<%=s.getDireccion()%>">
                </div>
                <div class="col-sm-6 mb-3">
                    <label>Fecha de Nacimiento:</label>
                    <%
                        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                        String fechaString = formato.format(s.getFecha_nac());
                    %>
                    <input type="date" class="form-control form-control-user" id="fechanac"
                           placeholder="fechaNac" name="fechanac" 
                           value="<%=fechaString%>">
                </div>
                <div class="col-sm-6 mb-3">
                    <input type="text" class="form-control form-control-user" id="especialidad"
                           placeholder="Especialidad" name="especialidad" value="<%=s.getSector()%>">
                </div>
                <div class="col-sm-6 mb-3">
                    <input type="text" class="form-control form-control-user" id="username"
                           placeholder="Nombre de usuario asignado" name="username" value="<%=s.getUsuario().getUsername()%>">
                </div>
                
                
                <!-- Aca ira todo lo que tiene que ver con horarios y usuarios-->
                
                <div class="col-sm-6 mb-3">
                        <button class="btn btn-primary btn-user btn-block" type="submit">
                        Guardar
                        </button>
                    </div>
            </div>
            
        </form>
    </div>
<%@include file="components/bodyFinal.jsp" %>
