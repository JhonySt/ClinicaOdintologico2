
package com.mycompany.consultorioodintologico2.servlets;

import com.mycompany.consultorioodintologico2.logica.Controladora;
import com.mycompany.consultorioodintologico2.logica.Horario;
import com.mycompany.consultorioodintologico2.logica.Odontologo;
import com.mycompany.consultorioodintologico2.logica.Usuario;
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

@WebServlet(name = "SvOdontologo", urlPatterns = {"/SvOdontologo"})
public class SvOdontologo extends HttpServlet {
    
    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Odontologo> listaOdontologos = new ArrayList<>();
        
        listaOdontologos = control.getOdontologo();
        
        HttpSession misesion = request.getSession();
        misesion.setAttribute("listaOdontologos", listaOdontologos);
        
        response.sendRedirect("verOdontologo.jsp");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //String username = request.getParameter("username");
        //String password = request.getParameter("password");
        //String rol = request.getParameter("rol");
        
        //control.crearUsuario(username, password, rol);
        
        //response.sendRedirect("index.jsp");
        
        String username = request.getParameter("username");
        Usuario usuario = new Usuario();
        usuario = control.traerUsuario(username);
        if(usuario == null){
            List<String> errores = new ArrayList<>();
            HttpSession misesion = request.getSession();
            errores.add("Error el username ingresado no esta registrado");
            misesion.setAttribute("errores", errores);
            response.sendRedirect("DatosError.jsp");
        }
        else{
  
            Odontologo odontologo = new Odontologo();
            odontologo.setDocumento_identidad(request.getParameter("dni"));
            odontologo.setNombre(request.getParameter("nombre"));
            odontologo.setApellido(request.getParameter("apellido"));
            odontologo.setTelefono(request.getParameter("telefono"));
            odontologo.setDireccion(request.getParameter("direccion"));
            odontologo.setEspecialidad(request.getParameter("especialidad"));
            odontologo.setUnUsuario(usuario);
            
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date fechaJava = formato.parse(request.getParameter("fechanac"));
                odontologo.setFecha_nac(fechaJava);
            } catch (ParseException ex) {
                Logger.getLogger(SvOdontologo.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Horario horario = new Horario();
            horario.setHorario_inicio(request.getParameter("hora_entrada"));
            horario.setHorario_fin(request.getParameter("hora_salida"));
            
            odontologo.setUnHorario(horario);
            odontologo.setUnUsuario(usuario);
            
            //control.crearOdontologo(odontologo);
            System.out.println(request.getParameter("hora"));
            
            response.sendRedirect("index.jsp");
        }
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
