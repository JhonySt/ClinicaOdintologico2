
package com.mycompany.consultorioodintologico2.servlets;

import com.mycompany.consultorioodintologico2.logica.Controladora;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "SvEliminarUsuario", urlPatterns = {"/SvEliminarUsuario"})
public class SvEliminarUsuario extends HttpServlet {

    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        
        control.borrarUsuario(id);
        
        response.sendRedirect("SvUsuarios");
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
