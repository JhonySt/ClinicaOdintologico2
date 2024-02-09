package com.mycompany.consultorioodintologico2.logica;

import com.mycompany.consultorioodintologico2.logica.Odontologo;
import com.mycompany.consultorioodintologico2.logica.Paciente;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2024-02-09T11:38:28")
@StaticMetamodel(Cita.class)
public class Cita_ { 

    public static volatile SingularAttribute<Cita, String> afeccion;
    public static volatile SingularAttribute<Cita, Paciente> paciente;
    public static volatile SingularAttribute<Cita, String> hora_cita;
    public static volatile SingularAttribute<Cita, Integer> id_cita;
    public static volatile SingularAttribute<Cita, Date> fecha_cita;
    public static volatile SingularAttribute<Cita, Odontologo> odontologo;

}