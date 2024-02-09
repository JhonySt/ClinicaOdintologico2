
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/head.jsp" %>
<%@include file="components/bodyPrimeraParte.jsp" %>

<!-- Validacion Sesión -->
    <% //HttpSession misesion = request.getSession(); 
            String usuario = (String) request.getSession().getAttribute("username");
            String rol = (String) request.getSession().getAttribute("rol");
            
            if(rol != "Administrador" && rol != "Secretaria"){
                response.sendRedirect("sinPermiso.jsp");
            }
    %>
    
    <div class="container">
        <h1>Crear Paciente</h1>
        <p>Este es el apartado para dar de alta a los diferentes pacientes del sistema.</p>
        
        <form class="user" action="SvPaciente" method="POST" id="formulario">
            <div class="form-group col">
                <div class="col-sm-6 mb-3">
                    <input type="text" class="form-control form-control-user" id="dni"
                           placeholder="Documento Identidad" name="dni" >
                </div>
                <div class="col-sm-6 mb-3">
                    <input type="text" class="form-control form-control-user" id="nombre"
                        placeholder="Nombre" name="nombre">
                </div>
                <div class="col-sm-6 mb-3">
                    <input type="text" class="form-control form-control-user" id="apellido"
                           placeholder="Apellido" name="apellido">
                </div>
                <div class="col-sm-6 mb-3">
                    <input type="text" class="form-control form-control-user" id="telefono"
                           placeholder="Teléfono" name="telefono">
                </div>
                <div class="col-sm-6 mb-3">
                    <input type="text" class="form-control form-control-user" id="direccion"
                           placeholder="Direccion" name="direccion">
                </div>
                <div class="col-sm-6 mb-3">
                    <label>Tiene EPS:</label>
                    <input type="checkbox" class="form-control form-control-user" id="tieneEPS"
                           name="tieneEPS">
                </div>
                <div class="col-sm-6 mb-3">
                    <input type="text" class="form-control form-control-user" id="tiposangre"
                           placeholder="Tipo de sangre" name="tiposangre">
                </div>
                <div class="col-sm-6 mb-3">
                    <label>Fecha de Nacimiento:</label>
                    <input type="date" class="form-control form-control-user" id="fechanac"
                           placeholder="fechaNac" name="fechanac" onchange="calcularEdad()">
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
                           placeholder="Documento Identidad responsable" name="dni_responsable" onchange="habilitarCrear()"/>
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
                    <button class="btn btn-primary btn-user btn-block" type="button" id="crearPaciente" onclick="enviarFormulario()">
                        Crear Paciente
                    </button>
                </div>
            </div>
            
        </form>
    </div>
    
<%@include file="components/bodyFinal.jsp" %>
