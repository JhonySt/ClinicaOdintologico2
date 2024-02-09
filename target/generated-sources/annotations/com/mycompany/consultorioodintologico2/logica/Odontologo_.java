package com.mycompany.consultorioodintologico2.logica;

import com.mycompany.consultorioodintologico2.logica.Cita;
import com.mycompany.consultorioodintologico2.logica.Horario;
import com.mycompany.consultorioodintologico2.logica.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2024-02-09T07:45:00")
@StaticMetamodel(Odontologo.class)
public class Odontologo_ extends Persona_ {

    public static volatile SingularAttribute<Odontologo, Usuario> unUsuario;
    public static volatile ListAttribute<Odontologo, Cita> listaCitas;
    public static volatile SingularAttribute<Odontologo, String> especialidad;
    public static volatile SingularAttribute<Odontologo, Horario> unHorario;

}