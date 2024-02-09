
package com.mycompany.consultorioodintologico2.servlets;

import com.mycompany.consultorioodintologico2.logica.Controladora;
import com.mycompany.consultorioodintologico2.logica.Horario;
import com.mycompany.consultorioodintologico2.logica.Odontologo;
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


@WebServlet(name = "SvDisponibilidad", urlPatterns = {"/SvDisponibilidad"})
public class SvDisponibilidad extends HttpServlet {

    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Odontologo> listaOdontologos = new ArrayList<>();
        listaOdontologos = control.getOdontologo();
        
        HttpSession misesion = request.getSession();
        misesion.setAttribute("listaOdontologos", listaOdontologos);
        
        response.sendRedirect("altaDisponibilidad.jsp");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Integer idOdontologo = Integer.parseInt(request.getParameter("odontologo"));
        String dniPaciente = request.getParameter("dni");
        String fechaCita = request.getParameter("fechacita");
        
        Odontologo odontologo = control.traerOdontologo(idOdontologo);
        
        List<Odontologo> listaOdontologos = new ArrayList<>();
        listaOdontologos = control.getOdontologo();
        
        List<String> listaHoras = calcularHorario(odontologo);
        
        HttpSession misesion = request.getSession();
        misesion.setAttribute("listaHoras", listaHoras);
        misesion.setAttribute("idOdontologo", odontologo);
        misesion.setAttribute("dniPaciente", dniPaciente);
        misesion.setAttribute("fechaCita", fechaCita);
        misesion.setAttribute("listaOdontologos", listaOdontologos);
        
        response.sendRedirect("altaCitas.jsp");
    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }
    
    public List<String> calcularHorario(Odontologo o){
        //SimpleDateFormat formatoEntrada = new SimpleDateFormat("HHmm");
        //SimpleDateFormat formatoSalida = new SimpleDateFormat("HH:mm");
        String hora;
        
        String horaInicio = o.getUnHorario().getHorario_inicio();
        String horaFin = o.getUnHorario().getHorario_fin();
        
        String[] horaInicioArray = horaInicio.split(":");
        String[] horaFinArray = horaFin.split(":");
        
        horaInicioArray[0] = horaInicioArray[0].replaceFirst("^0+", "");
        horaFinArray[0] = horaFinArray[0].replaceFirst("^0+", "");
        
        horaInicio = horaInicioArray[0] + horaInicioArray[1];
        horaFin = horaFinArray[0] + horaFinArray[1];
        
        int horaInicioInt = Integer.parseInt(horaInicio);
        int horaFinInt = Integer.parseInt(horaFin);
        
        List<String> listaHoras = new ArrayList<>();
        boolean bandera = false;
        
        for(int i = horaInicioInt; i <= horaFinInt; i+=30 ){
            if(Integer.toString(i).length() < 4) {
                hora = "0" +String.valueOf(i);
                listaHoras.add(setFormatoHora(hora));
            }
            else {
                listaHoras.add(setFormatoHora(String.valueOf(i)));
            }
            if(bandera){
                i+=40;
            }
            bandera = !bandera;
        }
        listaHoras.remove(listaHoras.size() - 1);
        
       return listaHoras;
    }
    
    public String setFormatoHora(String h){
        SimpleDateFormat formatoEntrada = new SimpleDateFormat("HHmm");
        SimpleDateFormat formatoSalida = new SimpleDateFormat("HH:mm");
        String hora = h;
        try {
            Date horaDate = formatoEntrada.parse(hora);
            return hora = formatoSalida.format(horaDate);
        } catch (ParseException ex) {
            Logger.getLogger(SvDisponibilidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
