
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
    
    <div class="container">
        <h1>Crear Odontólogo</h1>
        <p>Este es el apartado para dar de alta a los diferentes odontólogos del sistema.</p>
        
        <form class="user" action="SvOdontologo" method="POST">
            <div class="form-group col">
                <div class="col-sm-6 mb-3">
                    <input type="text" class="form-control form-control-user" id="dni"
                           placeholder="Documento Identidad" name="dni">
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
                    <label>Fecha de Nacimiento:</label>
                    <input type="date" class="form-control form-control-user" id="fechanac"
                           placeholder="fechaNac" name="fechanac">
                </div>
                <div class="col-sm-6 mb-3">
                    <input type="text" class="form-control form-control-user" id="especialidad"
                           placeholder="Especialidad" name="especialidad">
                </div>
                <div class="col-sm-6 mb-3">
                    <input type="text" class="form-control form-control-user" id="username"
                           placeholder="Nombre de usuario asignado" name="username">
                </div>
                <div class="col-sm-6 mb-3">
                    <input type="text" class="form-control form-control-user" id="hora_entrada"
                           placeholder="Hora de entrada (24h)" name="hora_entrada">
                </div>
                <div class="col-sm-6 mb-3">
                    <input type="text" class="form-control form-control-user" id="hora_salida"
                           placeholder="Hora de salida (24h)" name="hora_salida">
                </div>
                <div class="col-sm-6 mb-3">
                    <input type="time" class="form-control form-control-user" id=""
                           placeholder="Hora de salida (24h)" name="hora">
                </div>
                
                <!-- Aca ira todo lo que tiene que ver con horarios y usuarios-->
                
                <div class="col-sm-6 mb-3">
                        <button class="btn btn-primary btn-user btn-block" type="submit">
                        Crear Odontólogo
                        </button>
                    </div>
            </div>
            
        </form>
    </div>
<%@include file="components/bodyFinal.jsp" %>
