
package com.mycompany.consultorioodintologico2.logica;

import com.mycompany.consultorioodintologico2.persistencia.ControladoraPersistencia;
import java.util.ArrayList;
import java.util.List;


public class Controladora {
    
    ControladoraPersistencia controlPersistencia = new ControladoraPersistencia();
    
    public void crearUsuario(String username, String password, String rol){
        Usuario usuario = new Usuario();
        usuario.setUsername(username);
        usuario.setPassword(password);
        usuario.setRol(rol);
        controlPersistencia.crearUsuario(usuario);
    }

    public List<Usuario> getUsuarios() {
        return controlPersistencia.getUsuarios();
    }

    public void borrarUsuario(int id) {
        controlPersistencia.borrarUsuario(id);
    }

    public Usuario traerUsuario(int id) {
        return controlPersistencia.traerUsuario(id);
    }
    
    public Usuario traerUsuario(String username) {
        return controlPersistencia.traerUsuario(username);
    }

    public void editarUsuario(Usuario usuario) {
        controlPersistencia.editarUsuario(usuario);
    }

    public boolean validarIngreso(String username, String password) {
        List<Usuario> listaUsuarios = new ArrayList<>();
        listaUsuarios = controlPersistencia.getUsuarios();
        
        for(Usuario u : listaUsuarios){
            if(u.getUsername().equals(username)){
                if(u.getPassword().equals(password)){
                    return true;
                }
            }
        }
        
        return false;
    }

    public List<Odontologo> getOdontologo() {
        return controlPersistencia.getOdontologos();
    }

    public void crearOdontologo(Odontologo odontologo) {
        controlPersistencia.crearOdontologo(odontologo);
    }

    public Odontologo traerOdontologo(int id) {
        return controlPersistencia.traerOdontologo(id);
    }

    public void editarOdontologo(Odontologo odontologo) {
        controlPersistencia.editarOdontologo(odontologo);
    }

    public void borrarOdontologo(int id) {
        controlPersistencia.borrarOdontologo(id);
    }

    public List<Secretaria> getSecretaria() {
        return controlPersistencia.getSecretarias();
    }

    public void crearSecretaria(Secretaria secretaria) {
        controlPersistencia.crearSecretaria(secretaria);
    }

    public Secretaria traerSecretaria(int id) {
        return controlPersistencia.traerSecretaria(id);
    }

    public void editarSecretaria(Secretaria secretaria) {
        controlPersistencia.editarSecretaria(secretaria);
    }

    public void borrarSecretaria(int id) {
        controlPersistencia.borrarSecretaria(id);
    }

    public List<Responsable> getResponsables() {
        return controlPersistencia.getResponsables();
    }

    public void crearResponsable(Responsable responsable) {
        controlPersistencia.crearResponsable(responsable);
    }

    public Responsable traerResponsable(int id) {
        return controlPersistencia.traerResponsable(id);
    }
    
    public Responsable traerResponsableDni(String dni) {
        return controlPersistencia.traerResponsableDni(dni);
    }

    public void editarResponsable(Responsable responsable) {
        controlPersistencia.editarResponsable(responsable);
    }

    public void borrarResponsable(int id) {
        controlPersistencia.borrarResponsable(id);
    }
    
    public List<Paciente> getPacientes() {
        return controlPersistencia.getPacientes();
    }

    public void crearpaciente(Paciente paciente) {
        controlPersistencia.crearPaciente(paciente);
    }

    public Paciente traerPaciente(int id) {
        return controlPersistencia.traerPaciente(id);
    }
    
    public Paciente traerPacienteDni(String dniPaciente) {
        return controlPersistencia.traerPacienteDni(dniPaciente);
    }

    public void editarPaciente(Paciente paciente) {
        controlPersistencia.editarPaciente(paciente);
    }

    public void borrarPaciente(int id) {
        controlPersistencia.borrarPaciente(id);
    }

    public Horario traerHorarioByIdOdontologo(Integer idOdontologo) {
        return controlPersistencia.traerHorarioByIdOdontologo(idOdontologo);
    }

    public List<Cita> getCitas() {
        return controlPersistencia.getCitas();
    }

    public void crearCita(Cita cita) {
        controlPersistencia.crearCita(cita);
    }



    

 

    
}
