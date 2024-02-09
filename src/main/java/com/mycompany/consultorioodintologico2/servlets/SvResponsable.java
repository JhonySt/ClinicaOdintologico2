
package com.mycompany.consultorioodintologico2.servlets;

import com.mycompany.consultorioodintologico2.logica.Controladora;
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


@WebServlet(name = "SvResponsable", urlPatterns = {"/SvResponsable"})
public class SvResponsable extends HttpServlet {

    Controladora control = new Controladora();
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Responsable> listaResponsables = new ArrayList<>();
        
        listaResponsables = control.getResponsables();
        
        HttpSession misesion = request.getSession();
        misesion.setAttribute("listaResponsables", listaResponsables);
        
        response.sendRedirect("verResponsable.jsp");
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Responsable responsable = new Responsable();
        responsable.setDocumento_identidad(request.getParameter("dni"));
        responsable.setNombre(request.getParameter("nombre"));
        responsable.setApellido(request.getParameter("apellido"));
        responsable.setTelefono(request.getParameter("telefono"));
        responsable.setDireccion(request.getParameter("direccion"));
        responsable.setTipo_responsabilidad(request.getParameter("responsabilidad"));

        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date fechaJava = formato.parse(request.getParameter("fechanac"));
            responsable.setFecha_nac(fechaJava);
        } catch (ParseException ex) {
            Logger.getLogger(SvOdontologo.class.getName()).log(Level.SEVERE, null, ex);
        }

        control.crearResponsable(responsable);

        response.sendRedirect("index.jsp");
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
