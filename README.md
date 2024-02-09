# Clinica Odontologica
***
Sistema web para la gestion de personas y citas odontologicas

## General Info
***
El sistema permite gestionar diferentes tipos de personas y realizar operaciones CRUD, los tipo de personas que contiene el sistema son:
 - Odontologos
 - Secretarias
 - Pacientes
 - Responsables: (Cuando el paciente a registrar es menor de edad)

El sitema tambien permite crear citas según una fecha, hora, odontologo y paciente a atender.

El sistema tambien cuenta con un sistema de login, para lo cual se puede gestionar usuarios y contraseñas.
Ademas cuenta con diferentes roles para manejar los permisos de la aplicacion:
 - Administrador: Rol con todos los permisos dl sistema.
 - Odontologo: Rol con los permisos de gestionar Citas.
 - Secretaria. Rol con los permisos de gestionar citas, pacientes y responsable.

-El sistema se construyo usando una arquitectura de capas separando la logica de la persistencia.

## Technologies
***
El sistema se cro usando las sigientes tecnologias:
 - JDK 17.
 - Java EE 8 con Servlets para el backend.
 - JSP y Bootstrap para el frontend.
 - JPA y EclipseLink para la gestionar la persistencia de los datos.
 - Maven para gestionar las dependencias del proyecto.
 - MySql como motor de bases de datos.

### Screenshot
![Image text](/path/to/the/screenshot.png)
