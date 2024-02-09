
package com.mycompany.consultorioodintologico2.logica;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Odontologo extends Persona{
    
    //private int id_odontologo;
    private String especialidad;
    
    @OneToMany(mappedBy = "odontologo")
    private List<Cita> listaCitas;
    
    @OneToOne
    private Usuario unUsuario;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Horario unHorario;

    public Odontologo() {
    }

    public Odontologo(String especialidad, List<Cita> listaCitas, Usuario unUsuario, Horario unHorario, int id, String documento_identidad, String nombre, String apellido, String telefono, String direccion, Date fecha_nac) {
        super(id, documento_identidad, nombre, apellido, telefono, direccion, fecha_nac);
        this.especialidad = especialidad;
        this.listaCitas = listaCitas;
        this.unUsuario = unUsuario;
        this.unHorario = unHorario;
    }

    

    /*
    public int getId_odontologo() {
        return id_odontologo;
    }*/

    /*
    public void setId_odontologo(int id_odontologo) {
        this.id_odontologo = id_odontologo;
    }
    */

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public List<Cita> getListaCitas() {
        return listaCitas;
    }

    public void setListaCitas(List<Cita> listaCitas) {
        this.listaCitas = listaCitas;
    }

    public Usuario getUnUsuario() {
        return unUsuario;
    }

    public void setUnUsuario(Usuario unUsuario) {
        this.unUsuario = unUsuario;
    }

    public Horario getUnHorario() {
        return unHorario;
    }

    public void setUnHorario(Horario unHorario) {
        this.unHorario = unHorario;
    }
    
    
    
    
}