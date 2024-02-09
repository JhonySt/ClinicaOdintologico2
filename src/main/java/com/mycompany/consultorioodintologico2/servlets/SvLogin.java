
package com.mycompany.consultorioodintologico2.servlets;

import com.mycompany.consultorioodintologico2.logica.Controladora;
import com.mycompany.consultorioodintologico2.logica.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "SvLogin", urlPatterns = {"/SvLogin"})
public class SvLogin extends HttpServlet {

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
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        
        boolean validacion = false;
        validacion = control.validarIngreso(username, password);
        
        if(validacion){
            Usuario usuario = control.traerUsuario(username);
            HttpSession misesion = request.getSession(true);
            misesion.setAttribute("username", username);
            misesion.setAttribute("rol", usuario.getRol());
            response.sendRedirect("index.jsp");
        }
        else{
            response.sendRedirect("loginError.jsp");
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
