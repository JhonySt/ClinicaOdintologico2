
package com.mycompany.consultorioodintologico2.servlets;

import com.mycompany.consultorioodintologico2.logica.Controladora;
import com.mycompany.consultorioodintologico2.logica.Odontologo;
import com.mycompany.consultorioodintologico2.logica.Paciente;
import com.mycompany.consultorioodintologico2.logica.Responsable;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "SvPaciente", urlPatterns = {"/SvPaciente"})
public class SvPaciente extends HttpServlet {
    
    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Paciente> listaPacientes = new ArrayList<>();
        
        listaPacientes = control.getPacientes();
        
        HttpSession misesion = request.getSession();
        misesion.setAttribute("listaPacientes", listaPacientes);
        
        response.sendRedirect("verPaciente.jsp");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String edadString =request.getParameter("edad");
        String[] parts = edadString.split(" ");
        int edad = Integer.parseInt(parts[0]);
        System.out.println(edad);
        Responsable responsable = new Responsable();
        
        if(edad < 18){
            String dni = request.getParameter("dni_responsable");
            responsable = control.traerResponsableDni(dni);
            if(responsable == null ){
                List<String> errores = new ArrayList<>();
                errores.add("Error el responsable del menor de edad no esta registrado en el sistema");
                
                HttpSession misesion = request.getSession();
                misesion.setAttribute("errores", errores);
                
                response.sendRedirect("DatosError.jsp");
            }
        }
        
        if(edad > 18 || responsable != null){
  
            Paciente paciente = new Paciente();
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
            
            control.crearpaciente(paciente);
            
            response.sendRedirect("index.jsp");
        }
    }

    public void guardar(){
        
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
