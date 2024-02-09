<%@page import="java.util.List"%>
<%@page import="com.mycompany.consultorioodintologico2.logica.Odontologo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/head.jsp" %>
<%@include file="components/bodyPrimeraParte.jsp" %>

<%List<Odontologo> listaOdontologos = (List) request.getSession().getAttribute("listaOdontologos");%>
<%List<String> listaHoras = (List) request.getSession().getAttribute("listaHoras");%>
<%Odontologo idOdontologo = (Odontologo) request.getSession().getAttribute("idOdontologo");%>
<%String dni = (String) request.getSession().getAttribute("dniPaciente");%>
<%String fechaCita = (String) request.getSession().getAttribute("fechaCita");%>


                <div class="container-fluid ">

                    <div class="row">
                        
                        <div class="col-12 col-md-6">
                        <form action="SvDisponibilidad" method="POST">   
                            <div class="mb-3">
                                <input type="text" class="form-control form-control-user" id="dni"
                                       placeholder="Documento Identidad del Paciente" name="dni" value="<%=dni%>">
                            </div>

                            <div class="mb-3">
                                <label for="fechacita">Fecha de la Cita:</label>
                                <input type="date" class="form-control form-control-user" id="fechacita"
                                       placeholder="fechacita" name="fechacita" value="<%=fechaCita%>"/>
                            </div>

                            <div class="mb-3">
                                <select name="odontologo" class="custom-select custom-select-lg mb-3">
                                    <option selected>Seleccione un medico de su preferencia</option>
                                    
                                    <%for(Odontologo o : listaOdontologos){%>
                                    <option <%if(o.getId() == idOdontologo.getId()){%> selected="true" <%}%> value="<%=o.getId()%>"><%=o.getNombre()%> <%=o.getApellido()%></option>
                                    <%}%>
                                </select>
                            </div>

                            <div class="mb-3">
                                <button class="btn btn-primary btn-user btn-block" type="submit">
                                    Ver Disponibilidad
                                </button>
                            </div>
                        </form>
                        </div>
                    
                                
                     
                        <div class="col-12 col-md-6">
                            <form method="POST" action="SvCitas" id="formulario"> 
                            <table class="table table-light table-striped table-hover text-center">
                                <h2>Agenda de <%=idOdontologo.getNombre()%> <%=idOdontologo.getApellido()%></h2>
                                <thead>
                                    <tr>
                                        <th>Hora</th>
                                        <th>Acción</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%for(String h : listaHoras){%>
                                    <tr>
                                        <td><%=h%></td>
                                        <td><button class="btn btn-primary" onclick="agendar('<%=h%>')">Agendar</button></td>
                                    </tr>
                                    <%}%>
                                </tbody>
                            </table>
                            <input type="hidden" id="horaSeleccionada" name="horaSeleccionada" value="">
                            <input type="hidden" name="dniPaciente" value="<%=dni%>">
                            <input type="hidden" name="idOdontologo" value="<%=idOdontologo.getId()%>">
                            <input type="hidden" name="fechaCita" value="<%=fechaCita%>">
                        </form>
                    </div>
                </div>
                
            </div>

                                
    <script>
        function agendar(hora) {
            // Establecer la hora en el campo oculto
            document.getElementById("horaSeleccionada").value = hora;
            document.getElementById("formulario").submit();
        }
    </script>

<%@include file="components/bodyFinal.jsp" %>
