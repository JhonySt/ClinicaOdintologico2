
package com.mycompany.consultorioodintologico2.servlets;

import com.mycompany.consultorioodintologico2.logica.Controladora;
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


@WebServlet(name = "SvEditarResponsable", urlPatterns = {"/SvEditarResponsable"})
public class SvEditarResponsable extends HttpServlet {

    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Responsable responsable = new Responsable();
        responsable = control.traerResponsable(id);
        
        HttpSession misesion = request.getSession();
        misesion.setAttribute("responsable", responsable);
        
        response.sendRedirect("editarResponsable.jsp");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Responsable responsable = (Responsable) request.getSession().getAttribute("responsable");
        responsable.setId(Integer.parseInt(request.getParameter("id")));
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

        control.editarResponsable(responsable);

        response.sendRedirect("SvResponsable");
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
