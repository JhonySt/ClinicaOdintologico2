
package com.mycompany.consultorioodintologico2.logica;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Secretaria extends Persona{
    
    private String sector;
    
    @OneToOne
    private Usuario usuario;

    public Secretaria() {
    }

    public Secretaria(String sector, Usuario usuario, int id, String documento_identidad, String nombre, String apellido, String telefono, String direccion, Date fecha_nac) {
        super(id, documento_identidad, nombre, apellido, telefono, direccion, fecha_nac);
        this.sector = sector;
        this.usuario = usuario;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
}
