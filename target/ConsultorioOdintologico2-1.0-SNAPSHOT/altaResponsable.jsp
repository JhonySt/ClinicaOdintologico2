<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/head.jsp" %>
<%@include file="components/bodyPrimeraParte.jsp" %>

    
    <div class="container">
        <h1>Crear Responsable</h1>
        <p>Este es el apartado para dar de alta a los responsables de menores de edad.</p>
        
        <form class="user" action="SvResponsable" method="POST">
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
                    <select name="responsabilidad" class="custom-select custom-select-lg mb-3">
                        <option selected>Seleccione el tipo de responsabilidad</option>
                        <option value="padre">Padre</option>
                        <option value="madre">Madre</option>
                        <option value="hermano(a)">Hermano(a)</option>
                        <option value="abuelo(a)">Abuelo(a)</option>
                        <option value="tutor">Tutor legal</option>
                        <option value="otro">Otro</option>
                    </select>
                </div>
                
                <!-- Aca ira todo lo que tiene que ver con horarios y usuarios-->
                
                <div class="col-sm-6 mb-3">
                        <button class="btn btn-primary btn-user btn-block" type="submit">
                        Crear Responsable
                        </button>
                    </div>
            </div>
            
        </form>
    </div>
<%@include file="components/bodyFinal.jsp" %>