
package com.mycompany.consultorioodintologico2.servlets;

import com.mycompany.consultorioodintologico2.logica.Controladora;
import com.mycompany.consultorioodintologico2.logica.Horario;
import com.mycompany.consultorioodintologico2.logica.Odontologo;
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


@WebServlet(name = "SvEditarOdontologo", urlPatterns = {"/SvEditarOdontologo"})
public class SvEditarOdontologo extends HttpServlet {
    
    Controladora control = new Controladora();

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        Odontologo odontologo = new Odontologo();
        odontologo = control.traerOdontologo(id);
        
        HttpSession misesion = request.getSession();
        misesion.setAttribute("odontologo", odontologo);
        
        response.sendRedirect("editarOdontologo.jsp");
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Odontologo odontologo = (Odontologo) request.getSession().getAttribute("odontologo");
        
        System.out.println("####");
            System.out.println(request.getParameter("fechanac"));
        
        String username = request.getParameter("username");
        Usuario usuario = new Usuario();
        usuario = control.traerUsuario(username);
        if(usuario == null){
            response.sendRedirect("odontologoError.jsp");
        }
        else{
            
            odontologo.setId(Integer.parseInt(request.getParameter("id")));
            odontologo.setDocumento_identidad(request.getParameter("dni"));
            odontologo.setNombre(request.getParameter("nombre"));
            odontologo.setApellido(request.getParameter("apellido"));
            odontologo.setTelefono(request.getParameter("telefono"));
            odontologo.setDireccion(request.getParameter("direccion"));
            odontologo.setEspecialidad(request.getParameter("especialidad"));
            
            System.out.println("####");
            System.out.println(request.getParameter("fechanac"));
            
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date fechaJava = formato.parse(request.getParameter("fechanac"));
                odontologo.setFecha_nac(fechaJava);
                System.out.println(fechaJava);
            } catch (ParseException ex) {
                Logger.getLogger(SvOdontologo.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Horario horario = new Horario();
            horario.setId_horario(odontologo.getUnHorario().getId_horario());
            horario.setHorario_inicio(request.getParameter("hora_entrada"));
            horario.setHorario_fin(request.getParameter("hora_salida"));
            
            odontologo.setUnHorario(horario);
            odontologo.setUnUsuario(usuario);
            
            control.editarOdontologo(odontologo);
            
            response.sendRedirect("SvOdontologo");
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
