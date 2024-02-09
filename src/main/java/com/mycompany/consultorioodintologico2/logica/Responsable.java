
package com.mycompany.consultorioodintologico2.logica;

import java.util.Date;
import javax.persistence.Entity;

@Entity
public class Responsable extends Persona{
    
    //private int id_responsable;
    private String tipo_responsabilidad;

    public Responsable() {
    }

    public Responsable(String tipo_responsabilidad, int id, String documento_identidad, String nombre, String apellido, String telefono, String direccion, Date fecha_nac) {
        super(id, documento_identidad, nombre, apellido, telefono, direccion, fecha_nac);
        this.tipo_responsabilidad = tipo_responsabilidad;
    }

    /*
    public int getId_responsable() {
        return id_responsable;
    }

    public void setId_responsable(int id_responsable) {
        this.id_responsable = id_responsable;
    }
*/

    public String getTipo_responsabilidad() {
        return tipo_responsabilidad;
    }

    public void setTipo_responsabilidad(String tipo_responsabilidad) {
        this.tipo_responsabilidad = tipo_responsabilidad;
    }
    
    
}