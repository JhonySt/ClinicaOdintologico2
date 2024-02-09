
package com.mycompany.consultorioodintologico2.servlets;

import com.mycompany.consultorioodintologico2.logica.Cita;
import com.mycompany.consultorioodintologico2.logica.Controladora;
import com.mycompany.consultorioodintologico2.logica.Odontologo;
import com.mycompany.consultorioodintologico2.logica.Paciente;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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


@WebServlet(name = "SvCitas", urlPatterns = {"/SvCitas"})
public class SvCitas extends HttpServlet {

    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Cita> citas = control.getCitas();
        
        HttpSession misesion = request.getSession();
        misesion.setAttribute("citas", citas);
        
        response.sendRedirect("verCitas.jsp");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String dniPaciente = request.getParameter("dniPaciente");
        String idOdontologo = request.getParameter("idOdontologo");
        String fechaCita = request.getParameter("fechaCita");
        String horaSeleccionada = request.getParameter("horaSeleccionada");
        Cita cita = new Cita();
        
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date fechaJava = formato.parse(fechaCita);
                cita.setFecha_cita(fechaJava);
            } catch (ParseException ex) {
                Logger.getLogger(SvOdontologo.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        Odontologo odontologo = control.traerOdontologo(Integer.parseInt(idOdontologo));
        Paciente paciente = control.traerPacienteDni(dniPaciente);
        
        cita.setHora_cita(horaSeleccionada);
        cita.setOdontologo(odontologo);
        cita.setPaciente(paciente);
        
        control.crearCita(cita);
        
        response.sendRedirect("index.jsp");
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
