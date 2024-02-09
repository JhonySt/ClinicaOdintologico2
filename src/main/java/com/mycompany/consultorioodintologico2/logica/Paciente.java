
package com.mycompany.consultorioodintologico2.logica;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Paciente extends Persona{
    
    //private int id_paciente;
    private boolean tiene_EPS;
    
    private String tipo_sangre;
    
    @OneToOne
    private Responsable unResponsable;
    
    @OneToMany(mappedBy = "paciente")
    private List<Cita> listaCitas;


    public Paciente() {
    }

    public Paciente(boolean tiene_EPS, String tipo_sangre, Responsable unResponsable, List<Cita> listaCitas, int id, String documento_identidad, String nombre, String apellido, String telefono, String direccion, Date fecha_nac) {
        super(id, documento_identidad, nombre, apellido, telefono, direccion, fecha_nac);
        this.tiene_EPS = tiene_EPS;
        this.tipo_sangre = tipo_sangre;
        this.unResponsable = unResponsable;
        this.listaCitas = listaCitas;
    }


    public Responsable getUnResponsable() {
        return unResponsable;
    }

    public void setUnResponsable(Responsable unResponsable) {
        this.unResponsable = unResponsable;
    }

    public List<Cita> getListaCitas() {
        return listaCitas;
    }

    public void setListaCitas(List<Cita> listaCitas) {
        this.listaCitas = listaCitas;
    }

    
/*
    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }
*/

    public boolean isTiene_EPS() {
        return tiene_EPS;
    }

    public void setTiene_EPS(boolean tiene_EPS) {
        this.tiene_EPS = tiene_EPS;
    }

    public String getTipo_sangre() {
        return tipo_sangre;
    }

    public void setTipo_sangre(String tipo_sangre) {
        this.tipo_sangre = tipo_sangre;
    }
    
    
}