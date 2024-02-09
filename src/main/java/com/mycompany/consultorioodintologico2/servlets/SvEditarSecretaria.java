
package com.mycompany.consultorioodintologico2.servlets;

import com.mycompany.consultorioodintologico2.logica.Controladora;
import com.mycompany.consultorioodintologico2.logica.Odontologo;
import com.mycompany.consultorioodintologico2.logica.Secretaria;
import com.mycompany.consultorioodintologico2.logica.Usuario;
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


@WebServlet(name = "SvEditarSecretaria", urlPatterns = {"/SvEditarSecretaria"})
public class SvEditarSecretaria extends HttpServlet {

    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Secretaria secretaria = new Secretaria();
        secretaria = control.traerSecretaria(id);
        
        HttpSession misesion = request.getSession();
        misesion.setAttribute("secretaria", secretaria);
        
        response.sendRedirect("editarSecretaria.jsp");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        Usuario usuario = new Usuario();
        usuario = control.traerUsuario(username);
        if(usuario == null){
            response.sendRedirect("odontologoError.jsp");
        }
        else{
  
            Secretaria secretaria = (Secretaria) request.getSession().getAttribute("secretaria");
            secretaria.setId(Integer.parseInt(request.getParameter("id")));
            secretaria.setDocumento_identidad(request.getParameter("dni"));
            secretaria.setNombre(request.getParameter("nombre"));
            secretaria.setApellido(request.getParameter("apellido"));
            secretaria.setTelefono(request.getParameter("telefono"));
            secretaria.setDireccion(request.getParameter("direccion"));
            secretaria.setSector(request.getParameter("sector"));
            secretaria.setUsuario(usuario);
            
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date fechaJava = formato.parse(request.getParameter("fechanac"));
                secretaria.setFecha_nac(fechaJava);
            } catch (ParseException ex) {
                Logger.getLogger(SvOdontologo.class.getName()).log(Level.SEVERE, null, ex);
            }

            control.editarSecretaria(secretaria);
            
            response.sendRedirect("SvSecretaria");
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
