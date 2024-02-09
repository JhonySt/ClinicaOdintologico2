
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/head.jsp" %>
<%@include file="components/bodyPrimeraParte.jsp" %>

<!-- Validacion Sesión -->
    <% //HttpSession misesion = request.getSession(); 
            String usuario = (String) request.getSession().getAttribute("username");
            String rol = (String) request.getSession().getAttribute("rol");
            
            if(rol != "Administrador"){
                response.sendRedirect("sinPermiso.jsp");
            }
    %>
    
    <div class="container">
        <h1>Crear Usuarios</h1>
        <p>Este es el apartado para dar de alta a los diferentes usuarios del sistema.</p>
        
        <div class="container ">
            <form class="user" action="SvUsuarios" method="POST">
                <div class="form-group col">
                    <div class="col-sm-6 mb-3">
                        <input type="text" class="form-control form-control-user" id="username" name="username"
                            placeholder="Nombre de usuario">
                    </div>
                    <div class="col-sm-6 mb-3">
                        <input type="password" class="form-control form-control-user" id="password" name="password"
                            placeholder="Contraseña">
                    </div>
                    <!--
                    <div class="col-sm-6 mb-3">
                        <input type="text" class="form-control form-control-user" id="rol" name="rol"
                            placeholder="Rol">
                    </div>
                    -->
                    <div class="col-sm-6 mb-3">
                        <select name="rol" class="custom-select custom-select-lg mb-3">
                            <option selected>Seleccione un rol</option>
                            <option value="Administrador">Administrador</option>
                            <option value="Odontologo">Odontologo</option>
                            <option value="Secretaria">Secretaria(o)</option>
                        </select>
                    </div>

                    <div class="col-sm-6 mb-3">
                        <button class="btn btn-primary btn-user btn-block" type="submit">
                        Crear Usuario
                        </button>
                    </div>
                </div>

            </form>
         </div>
    </div>
<%@include file="components/bodyFinal.jsp" %>
