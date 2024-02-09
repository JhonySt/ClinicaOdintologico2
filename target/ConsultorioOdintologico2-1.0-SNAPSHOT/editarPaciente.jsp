<%@page import="com.mycompany.consultorioodintologico2.logica.Paciente"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.mycompany.consultorioodintologico2.logica.Odontologo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/head.jsp" %>
<%@include file="components/bodyPrimeraParte.jsp" %>

    
    <div class="container">
        <h1>Editar Paciente</h1>
        
        <% Paciente p = (Paciente) request.getSession().getAttribute("paciente");%>
        
        <form class="user" action="SvEditarPaciente" method="POST">
            <div class="form-group col">
                <input type="hidden" id="id" name="id" value="<%=p.getId()%>"/>
                <div class="col-sm-6 mb-3">
                    <input type="text" class="form-control form-control-user" id="dni"
                           placeholder="Documento Identidad" name="dni" value="<%=p.getDocumento_identidad()%>">
                </div>
                <div class="col-sm-6 mb-3">
                    <input type="text" class="form-control form-control-user" id="nombre"
                        placeholder="Nombre" name="nombre" value="<%=p.getNombre()%>">
                </div>
                <div class="col-sm-6 mb-3">
                    <input type="text" class="form-control form-control-user" id="apellido"
                           placeholder="Apellido" name="apellido" value="<%=p.getApellido()%>">
                </div>
                <div class="col-sm-6 mb-3">
                    <input type="text" class="form-control form-control-user" id="telefono"
                           placeholder="Teléfono" name="telefono" value="<%=p.getTelefono()%>">
                </div>
                <div class="col-sm-6 mb-3">
                    <input type="text" class="form-control form-control-user" id="direccion"
                           placeholder="Direccion" name="direccion" value="<%=p.getDireccion()%>">
                </div>
                <div class="col-sm-6 mb-3">
                    <input type="text" class="form-control form-control-user" id="tiposangre"
                           placeholder="Tipo de sangre" name="tiposangre" value="<%=p.getTipo_sangre()%>">
                </div>
                <div class="col-sm-6 mb-3">
                    <label>Fecha de Nacimiento:</label>
                    <%
                        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                        String fechaString = formato.format(p.getFecha_nac());
                    %>
                    <input type="date" class="form-control form-control-user" id="fechanac"
                           placeholder="fechaNac" name="fechanac" 
                           value="<%=fechaString%>" onchange="calcularEdad()">
                </div>
                <div class="col-sm-6 mb-3">
                    <input type="text" class="form-control form-control-user" id="edad"
                           placeholder="Edad" name="edad" disabled="true">
                </div>
               
                <div id="formularioResponsable" style="display: none; border: solid 2px #9C9DA2; padding: 5px; border-radius: 10px; ">
                    <p style="color: red;">AVISO:</p>
                    <p>El paciente a registrar es menor de edad por lo tanto debe asociar un responsable mayor de edad</p>
                    <br>
                    <label id="dni_responsable">Ingrese el documento de identidad del responsable registrado:</label>
                    <div class="col-sm-6 mb-3">
                        <input type="text" class="form-control form-control-user" id="dni_responsable"
                               placeholder="Documento Identidad responsable" name="dni_responsable" value="<%=p.getUnResponsable().getDocumento_identidad()%>" onchange="habilitarCrear()"/>
                    </div>
                    <br>
                    <p>Si el responsable no esta registrado dar click en el siguiente boton:</p>
                    <div class="col-sm-6 mb-3">
                        <a href="altaResponsable.jsp" target="_blank" class="btn btn-primary btn-user btn-block">Registrar Responsable</a>
                    </div>
                </div>
                <br>
                
                
                
                
                <!-- Aca ira todo lo que tiene que ver con horarios y usuarios-->
                
                <div class="col-sm-6 mb-3">
                    <button class="btn btn-primary btn-user btn-block" type="submit" id="crearPaciente">
                        Crear Paciente
                    </button>
                </div>
            </div>
            
        </form>
    </div>
                               

<%@include file="components/bodyFinal.jsp" %>
