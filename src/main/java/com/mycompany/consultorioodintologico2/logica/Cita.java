
package com.mycompany.consultorioodintologico2.logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Cita implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_cita;
    
    @Temporal(TemporalType.DATE)
    private Date fecha_cita;
    
    private String hora_cita;
    
    private String afeccion;
    
    @ManyToOne()
    @JoinColumn(name = "id_odontologo")
    private Odontologo odontologo;
    
    @ManyToOne()
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;

    public Cita() {
    }

    public Cita(int id_cita, Date fecha_cita, String hora_cita, String afeccion) {
        this.id_cita = id_cita;
        this.fecha_cita = fecha_cita;
        this.hora_cita = hora_cita;
        this.afeccion = afeccion;
    }

    public int getId_cita() {
        return id_cita;
    }

    public void setId_cita(int id_cita) {
        this.id_cita = id_cita;
    }

    public Date getFecha_cita() {
        return fecha_cita;
    }

    public void setFecha_cita(Date fecha_cita) {
        this.fecha_cita = fecha_cita;
    }

    public String getHora_cita() {
        return hora_cita;
    }

    public void setHora_cita(String hora_cita) {
        this.hora_cita = hora_cita;
    }

    public String getAfeccion() {
        return afeccion;
    }

    public void setAfeccion(String afeccion) {
        this.afeccion = afeccion;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    

}