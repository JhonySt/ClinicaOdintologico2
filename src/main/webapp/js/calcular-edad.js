function habilitarCrear(){
            var dniResponsable = document.getElementById("dni_responsable").value;
            var btnCrearPaciente = document.getElementById("crearPaciente");
            if(dniResponsable !== ""){
                btnCrearPaciente.removeAttribute("disabled");
                console.log("boton");
            }
            
    }
    
    function calcularEdad() {
    // Obtener la referencia al elemento input de fecha
    var fechaNacimientoInput = document.getElementById("fechanac");

    // Obtener el valor de la fecha de nacimiento
    var fechaNacimiento = fechaNacimientoInput.value;

    // Crear un objeto Date a partir de la cadena de fecha
    var fechaNacimientoDate = new Date(fechaNacimiento);

    // Obtener la fecha actual
    var fechaActual = new Date();

    // Calcular la diferencia de tiempo entre las dos fechas en milisegundos
    var diferenciaTiempo = fechaActual - fechaNacimientoDate;

    // Calcular la edad en años
    var edadEnMilisegundos = diferenciaTiempo;
    var edadEnAnios = Math.floor(edadEnMilisegundos / (365.25 * 24 * 60 * 60 * 1000));

    // Mostrar la edad en el input de texto
    var edadInput = document.getElementById("edad");
    edadInput.value = edadEnAnios + " años";
    
    var formularioResponsable = document.getElementById("formularioResponsable");
    var dniResponsable = document.getElementById("dni_responsable").value;
    var btnCrearPaciente = document.getElementById("crearPaciente");
    
    if(edadEnAnios < 18){
        formularioResponsable.style.cssText = "display: block; border: solid 2px #9C9DA2; padding: 5px; border-radius: 10px; ";
        btnCrearPaciente.setAttribute("disabled","true");
        console.log("mostrar");
    }
    else{
        formularioResponsable.style.display = "none";
        btnCrearPaciente.removeAttribute("disabled");
    }
}

function enviarFormulario(){
    var edadInput = document.getElementById("edad");

    edadInput.disabled = false;

    document.getElementById("formulario").submit();
    edadInput.disabled = true;
}


