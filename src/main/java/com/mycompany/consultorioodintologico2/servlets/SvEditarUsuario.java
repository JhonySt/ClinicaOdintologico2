
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


@WebServlet(name = "SvEditarUsuario", urlPatterns = {"/SvEditarUsuario"})
public class SvEditarUsuario extends HttpServlet {

    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        Usuario usuario = control.traerUsuario(id);
        
        HttpSession misesion = request.getSession();
        misesion.setAttribute("usuario", usuario);
        
        response.sendRedirect("editarUsuarios.jsp");
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id =Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rol = request.getParameter("rol");
        
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        usuario.setId_usuario(Integer.parseInt(request.getParameter("id")));
        usuario.setUsername(username);
        usuario.setPassword(password);
        usuario.setRol(rol);
        
        control.editarUsuario(usuario);
        
        response.sendRedirect("SvUsuarios");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
