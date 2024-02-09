
<%@page import="com.mycompany.consultorioodintologico2.logica.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/head.jsp" %>
<%@include file="components/bodyPrimeraParte.jsp" %>

    
    <div class="container">
        <h1>Edición de Usuarios</h1>
        <p>Este es el apartado para modificar un usuario del sistema.</p>
        
        <% Usuario u = (Usuario) request.getSession().getAttribute("usuario");%>
        
        <form class="user" action="SvEditarUsuario" method="POST">
            <div class="form-group col">
                <input type="hidden" name="id" value="<%=u.getId_usuario()%>"/>
                <div class="col-sm-6 mb-3">
                    <input type="text" class="form-control form-control-user" id="username" name="username"
                           placeholder="Nombre de usuario" value="<%=u.getUsername()%>">
                </div>
                <div class="col-sm-6 mb-3">
                    <input type="password" class="form-control form-control-user" id="password" name="password"
                           placeholder="Contraseña" value="<%=u.getPassword()%>">
                </div>
                <!--
                <div class="col-sm-6 mb-3">
                    <input type="text" class="form-control form-control-user" id="rol" name="rol"
                           placeholder="Rol" value="<%=u.getRol()%>">
                </div>
                -->
                <div class="col-sm-6 mb-3">
                        <select name="rol" class="custom-select custom-select-lg mb-3">
                            <option selected value="<%=u.getRol()%>"><%=u.getRol()%></option>
                            <option value="Administrador">Administrador</option>
                            <option value="Odontologo">Odontologo</option>
                            <option value="Secretaria">Secretaria(o)</option>
                        </select>
                 </div>
                
            </div>
            
            <button class="btn btn-primary btn-user btn-block" type="submit">
                Guardar
            </button>
            
        </form>
    </div>
<%@include file="components/bodyFinal.jsp" %>
