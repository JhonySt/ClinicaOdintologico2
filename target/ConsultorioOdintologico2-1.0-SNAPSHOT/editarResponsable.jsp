<%@page import="com.mycompany.consultorioodintologico2.logica.Responsable"%>
<%@page import="com.mycompany.consultorioodintologico2.logica.Secretaria"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.mycompany.consultorioodintologico2.logica.Odontologo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/head.jsp" %>
<%@include file="components/bodyPrimeraParte.jsp" %>

    
    <div class="container">
        <h1>Editar Responsable</h1>
        
        <% Responsable r = (Responsable) request.getSession().getAttribute("responsable"); String tipo = r.getTipo_responsabilidad();%>
        
        <form class="user" action="SvEditarResponsable" method="POST">
            <div class="form-group col">
                <input type="hidden" id="id" name="id" value="<%=r.getId()%>"/>
                <div class="col-sm-6 mb-3">
                    <input type="text" class="form-control form-control-user" id="dni"
                           placeholder="Documento Identidad" name="dni" value="<%=r.getDocumento_identidad()%>">
                </div>
                <div class="col-sm-6 mb-3">
                    <input type="text" class="form-control form-control-user" id="nombre"
                        placeholder="Nombre" name="nombre" value="<%=r.getNombre()%>">
                </div>
                <div class="col-sm-6 mb-3">
                    <input type="text" class="form-control form-control-user" id="apellido"
                           placeholder="Apellido" name="apellido" value="<%=r.getApellido()%>">
                </div>
                <div class="col-sm-6 mb-3">
                    <input type="text" class="form-control form-control-user" id="telefono"
                           placeholder="Teléfono" name="telefono" value="<%=r.getTelefono()%>">
                </div>
                <div class="col-sm-6 mb-3">
                    <input type="text" class="form-control form-control-user" id="direccion"
                           placeholder="Direccion" name="direccion" value="<%=r.getDireccion()%>">
                </div>
                <div class="col-sm-6 mb-3">
                    <label>Fecha de Nacimiento:</label>
                    <%
                        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                        String fechaString = formato.format(r.getFecha_nac());
                    %>
                    <input type="date" class="form-control form-control-user" id="fechanac"
                           placeholder="fechaNac" name="fechanac" 
                           value="<%=fechaString%>">
                </div>
                <div class="col-sm-6 mb-3">
                    <select name="responsabilidad" class="custom-select custom-select-lg mb-3">
                        <option>Seleccione el tipo de responsabilidad</option>
                        <option value="padre" <% if(tipo == "padre"){%>selected<%}%> >Padre</option>
                        <option value="madre" <% if(tipo == "madre"){%>selected<%}%> >Madre</option>
                        <option value="hermano(a)" <% if(tipo == "hermano(a)"){%>selected<%}%> >Hermano(a)</option>
                        <option value="abuelo(a)" <% if(tipo == "abuelo(a)"){%>selected<%}%> >Abuelo(a)</option>
                        <option value="tutor" <% if(tipo == "tutor"){%>selected<%}%> >Tutor legal</option>
                        <option value="otro" <% if(tipo == "otro"){%>selected<%}%> >Otro</option>
                    </select>
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
