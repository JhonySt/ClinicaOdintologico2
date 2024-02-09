package com.mycompany.consultorioodintologico2.logica;

import com.mycompany.consultorioodintologico2.logica.Cita;
import com.mycompany.consultorioodintologico2.logica.Responsable;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2024-02-09T11:38:28")
@StaticMetamodel(Paciente.class)
public class Paciente_ extends Persona_ {

    public static volatile SingularAttribute<Paciente, Boolean> tiene_EPS;
    public static volatile ListAttribute<Paciente, Cita> listaCitas;
    public static volatile SingularAttribute<Paciente, Responsable> unResponsable;
    public static volatile SingularAttribute<Paciente, String> tipo_sangre;

}