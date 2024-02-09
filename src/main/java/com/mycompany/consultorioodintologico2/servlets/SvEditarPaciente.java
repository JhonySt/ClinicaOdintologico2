
package com.mycompany.consultorioodintologico2.servlets;

import com.mycompany.consultorioodintologico2.logica.Controladora;
import com.mycompany.consultorioodintologico2.logica.Paciente;
import com.mycompany.consultorioodintologico2.logica.Responsable;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "SvEditarPaciente", urlPatterns = {"/SvEditarPaciente"})
public class SvEditarPaciente extends HttpServlet {

    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Paciente paciente = new Paciente();
        paciente = control.traerPaciente(id);
        
        HttpSession misesion = request.getSession();
        misesion.setAttribute("paciente", paciente);
        
        response.sendRedirect("editarPaciente.jsp");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Paciente paciente = (Paciente) request.getSession().getAttribute("paciente");
        
        int edad = Integer.parseInt(request.getParameter("edad"));
        Responsable responsable = new Responsable();
        
        if(edad < 18){
            String dni = request.getParameter("dni_responsable");
            responsable = control.traerResponsableDni(dni);
            if(responsable == null ){
                response.sendRedirect("odontologoError.jsp");
            }
        }
        if(edad > 18 || responsable != null){
            
            responsable.setId(Integer.parseInt(request.getParameter("id")));
            paciente.setDocumento_identidad(request.getParameter("dni"));
            paciente.setNombre(request.getParameter("nombre"));
            paciente.setApellido(request.getParameter("apellido"));
            paciente.setTelefono(request.getParameter("telefono"));
            paciente.setDireccion(request.getParameter("direccion"));
            paciente.setTipo_sangre(request.getParameter("tiposangre"));
            if(edad < 18) paciente.setUnResponsable(responsable);
            
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date fechaJava = formato.parse(request.getParameter("fechanac"));
                paciente.setFecha_nac(fechaJava);
            } catch (ParseException ex) {
                Logger.getLogger(SvOdontologo.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            control.editarPaciente(paciente);
            
            response.sendRedirect("SvPaciente");
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
