<%@page import="java.util.List"%>
<%@page import="com.mycompany.consultorioodintologico2.logica.Odontologo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/head.jsp" %>
<%@include file="components/bodyPrimeraParte.jsp" %>

<%List<Odontologo> listaOdontologos = (List) request.getSession().getAttribute("listaOdontologos");%>
<form action="SvDisponibilidad" method="POST">   
                <div class="container-fluid ">

                    <div class="row">
                        <div class="col-12 col-md-6">
                            <div class="mb-3">
                                <input type="text" class="form-control form-control-user" id="dni"
                                       placeholder="Documento Identidad del Paciente" name="dni" >
                            </div>

                            <div class="mb-3">
                                <label for="fechacita">Fecha de la Cita:</label>
                                <input type="date" class="form-control form-control-user" id="fechacita"
                                       placeholder="fechacita" name="fechacita"/>
                            </div>

                            <div class="mb-3">
                                <select name="odontologo" class="custom-select custom-select-lg mb-3">
                                    <option selected>Seleccione un medico de su preferencia</option>
                                    
                                    <%for(Odontologo o : listaOdontologos){%>
                                    <option value="<%=o.getId()%>"><%=o.getNombre()%> <%=o.getApellido()%></option>
                                    <%}%>
                                </select>
                            </div>

                            <div class="mb-3">
                                <button class="btn btn-primary btn-user btn-block" type="submit">
                                    Ver Disponibilidad
                                </button>
                            </div>
                        </div>
                        
                    </div>
                    
                </div>
    </form>
<%@include file="components/bodyFinal.jsp" %>
