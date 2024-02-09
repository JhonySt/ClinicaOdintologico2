
package com.mycompany.consultorioodintologico2.persistencia;

import com.mycompany.consultorioodintologico2.logica.Cita;
import com.mycompany.consultorioodintologico2.logica.Horario;
import com.mycompany.consultorioodintologico2.logica.Odontologo;
import com.mycompany.consultorioodintologico2.logica.Paciente;
import com.mycompany.consultorioodintologico2.logica.Responsable;
import com.mycompany.consultorioodintologico2.logica.Secretaria;
import com.mycompany.consultorioodintologico2.logica.Usuario;
import com.mycompany.consultorioodintologico2.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {

    public ControladoraPersistencia() {
    }
    
    CitaJpaController citaJPA = new CitaJpaController();
    HorarioJpaController horaJPA = new HorarioJpaController();
    OdontologoJpaController odontologoJPA = new OdontologoJpaController();
    PacienteJpaController pacienteJPA = new PacienteJpaController();
    PersonaJpaController personaJPA = new PersonaJpaController();
    ResponsableJpaController responsableJPA = new ResponsableJpaController();
    SecretariaJpaController secretariaJPA = new SecretariaJpaController();
    UsuarioJpaController usuarioJPA = new UsuarioJpaController();

    public void crearUsuario(Usuario usuario) {
        usuarioJPA.create(usuario);
    }

    public List<Usuario> getUsuarios() {
        return usuarioJPA.findUsuarioEntities();
    }

    public void borrarUsuario(int id) {
        try {
            usuarioJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuario traerUsuario(int id) {
        return usuarioJPA.findUsuario(id);
    }
    
    public Usuario traerUsuario(String username) {
        return usuarioJPA.findUsuarioByUsername(username);
    }

    public void editarUsuario(Usuario usuario) {
        try {
            usuarioJPA.edit(usuario);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Odontologo> getOdontologos() {
        return odontologoJPA.findOdontologoEntities();
    }

    public void crearOdontologo(Odontologo odontologo) {
        odontologoJPA.create(odontologo);
    }

    public Odontologo traerOdontologo(int id) {
        return odontologoJPA.findOdontologo(id);
    }

    public void editarOdontologo(Odontologo odontologo) {
        try {
            odontologoJPA.edit(odontologo);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void borrarOdontologo(int id) {
        try {
            odontologoJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Secretaria> getSecretarias() {
        return secretariaJPA.findSecretariaEntities();
    }

    public void crearSecretaria(Secretaria secretaria) {
        secretariaJPA.create(secretaria);
    }

    public Secretaria traerSecretaria(int id) {
        return secretariaJPA.findSecretaria(id);
    }

    public void editarSecretaria(Secretaria secretaria) {
        try {
            secretariaJPA.edit(secretaria);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void borrarSecretaria(int id) {
        try {
            secretariaJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Responsable> getResponsables() {
        return responsableJPA.findResponsableEntities();
    } 

    public void crearResponsable(Responsable responsable) {
        responsableJPA.create(responsable);
    }

    public Responsable traerResponsable(int id) {
        return responsableJPA.findResponsable(id);
    }
    
    public Responsable traerResponsableDni(String dni) {
        return responsableJPA.findResponsableByDni(dni);
    }

    public void editarResponsable(Responsable responsable) {
        try {
            responsableJPA.edit(responsable);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void borrarResponsable(int id) {
        try {
            responsableJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Paciente> getPacientes() {
        return pacienteJPA.findPacienteEntities();
    }

    public void crearPaciente(Paciente paciente) {
        pacienteJPA.create(paciente);
    }

    public Paciente traerPaciente(int id) {
        return pacienteJPA.findPaciente(id);
    }
    
    public Paciente traerPacienteDni(String dniPaciente) {
        return pacienteJPA.traerPacienteDni(dniPaciente);
    }

    public void editarPaciente(Paciente paciente) {
        try {
            pacienteJPA.edit(paciente);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void borrarPaciente(int id) {
        try {
            pacienteJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Horario traerHorarioByIdOdontologo(Integer idOdontologo) {
        return horaJPA.getHorarioByIdOdontologo(idOdontologo);
    }

    public List<Cita> getCitas() {
        return citaJPA.findCitaEntities();
    }

    public void crearCita(Cita cita) {
        citaJPA.create(cita);
    }



    


}
