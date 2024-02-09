
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.mycompany.consultorioodintologico2.logica.Odontologo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/head.jsp" %>
<%@include file="components/bodyPrimeraParte.jsp" %>

    
    <div class="container">
        <h1>Editar Odontólogo</h1>
        
        <% Odontologo o = (Odontologo) request.getSession().getAttribute("odontologo");%>
        
        <form class="user" action="SvEditarOdontologo" method="POST">
            <div class="form-group col">
                <input type="hidden" id="id" name="id" value="<%=o.getId()%>"/>
                <div class="col-sm-6 mb-3">
                    <input type="text" class="form-control form-control-user" id="dni"
                           placeholder="Documento Identidad" name="dni" value="<%=o.getDocumento_identidad()%>">
                </div>
                <div class="col-sm-6 mb-3">
                    <input type="text" class="form-control form-control-user" id="nombre"
                        placeholder="Nombre" name="nombre" value="<%=o.getNombre()%>">
                </div>
                <div class="col-sm-6 mb-3">
                    <input type="text" class="form-control form-control-user" id="apellido"
                           placeholder="Apellido" name="apellido" value="<%=o.getApellido()%>">
                </div>
                <div class="col-sm-6 mb-3">
                    <input type="text" class="form-control form-control-user" id="telefono"
                           placeholder="Teléfono" name="telefono" value="<%=o.getTelefono()%>">
                </div>
                <div class="col-sm-6 mb-3">
                    <input type="text" class="form-control form-control-user" id="direccion"
                           placeholder="Direccion" name="direccion" value="<%=o.getDireccion()%>">
                </div>
                <div class="col-sm-6 mb-3">
                    <label>Fecha de Nacimiento:</label>
                    <%
                        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                        String fechaString = formato.format(o.getFecha_nac());
                        System.out.println(fechaString);
                    %>
                    <input type="date" class="form-control form-control-user" id="fechanac"
                           placeholder="fechaNac" name="fechanac" 
                           value="<%=fechaString%>">
                </div>
                <div class="col-sm-6 mb-3">
                    <input type="text" class="form-control form-control-user" id="especialidad"
                           placeholder="Especialidad" name="especialidad" value="<%=o.getEspecialidad()%>">
                </div>
                <div class="col-sm-6 mb-3">
                    <input type="text" class="form-control form-control-user" id="username"
                           placeholder="Nombre de usuario asignado" name="username" value="<%=o.getUnUsuario().getUsername()%>">
                </div>
                <div class="col-sm-6 mb-3">
                    <input type="text" class="form-control form-control-user" id="hora_entrada"
                           placeholder="Hora de entrada (24h)" name="hora_entrada" value="<%=o.getUnHorario().getHorario_inicio()%>">
                </div>
                <div class="col-sm-6 mb-3">
                    <input type="text" class="form-control form-control-user" id="hora_salida"
                           placeholder="Hora de salida (24h)" name="hora_salida" value="<%=o.getUnHorario().getHorario_fin()%>">
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
