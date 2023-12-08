package admin_user.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import admin_user.model.Animal_atencion_lechon;
import admin_user.model.Animal_manejo;
import admin_user.model.Animal_preparto;
import admin_user.service.Animal_atencion_lechon_service;
import admin_user.service.Animal_manejo_service;

@Controller
public class Animal_atencion_lechon_controller {

    private final Animal_atencion_lechon_service animal_atencion_lechon_service;
    private final Animal_manejo_service animal_manejo_service;

    @Autowired
    public Animal_atencion_lechon_controller(Animal_atencion_lechon_service animal_atService,
            Animal_manejo_service animal_manejo_service) {
        this.animal_atencion_lechon_service = animal_atService;
        this.animal_manejo_service = animal_manejo_service;

    }


    @GetMapping("/atencion-vista")
    public String mostrarVistaAtencionRegistro(Model model) {
         List<String> dniManejos = animal_manejo_service.obtenerdniManejo();// Método
        // para obtener los dniParto desde tu servicio

         model.addAttribute("dniManejos", dniManejos);
        model.addAttribute("animal_atencion", new Animal_atencion_lechon()); // Agregar un objeto Animal_manejo al modelo
        return "atencion-registro"; // Devolver el nombre de la vista
    }



    // metodo para mostrar los datos en la tabla
    @GetMapping("/mostrar-atencion-tabla")
    public String mostrarDatosTabla(Model model) {
        // Obtener los datos que deseas mostrar en la tabla
        List<Animal_atencion_lechon> animalatencionList = animal_atencion_lechon_service.getAtencion(); // Reemplaza obtenerDatos() con el
                                                                                  // método que obtiene los datos

        // Realizar alguna operación con los datos si es necesario
        // Por ejemplo, ordenarlos o filtrarlos

        // Agregar los datos al modelo para pasarlos a la vista
        model.addAttribute("animalAtencionList", animalatencionList);

        // Devolver la vista que mostrará los datos en la tabla
        return "atencion-tabla"; // Reemplaza "tabla-datos" con el nombre de tu vista
    }


    // metodo para poder buscar por dni
    // para poder cargar los datos en la misma tabla pero los buscados por dni debo
    // colocar la variable animalMonta en la logica
    // de thymeleaf en la tabla y al buscar por dni carga los datos que estoy
    // buscando
    @GetMapping("/buscar-por-dni-animal-atencion")
    public String buscarPorDni(@RequestParam("dni") Long dni, Model model) {
        // Realizar la validación para verificar si el dni existe en la base de datos
        if (dni != null) {
            Animal_atencion_lechon animalAtencion = animal_atencion_lechon_service.buscarPorDni(dni);
    
            if (animalAtencion != null) {
                // Si se encuentra el registro con el dni proporcionado, lo agregamos al modelo y mostramos los detalles
                model.addAttribute("animalAtencion", animalAtencion);
                return "atencion-tabla"; // Reemplaza con el nombre de tu vista
            } else {
                // Si no se encuentra el registro con el dni proporcionado, puedes mostrar un mensaje de error o redirigir a una página de error
                model.addAttribute("mensajeError", "No se encontró ningún registro con el DNI proporcionado.");
                return "animal_no_encontrado"; // Reemplaza con el nombre de tu vista de error
            }
        } else {
            // Si el parámetro dni es null, puedes manejarlo de acuerdo a tu lógica
            model.addAttribute("mensajeError", "El DNI proporcionado es inválido.");
            return "animal_no_encontrado"; // Reemplaza con el nombre de tu vista de error
        }
    }
    


/* 
@PostMapping("/registrar-atencion")
public String guardarDato(@ModelAttribute("animal_atencion") Animal_atencion_lechon animal_atencion, @RequestParam("tipoAtencion") String selectdniParto, Principal principal) {
    try {
        // Asignar el valor seleccionado del select a dniPreparto
     //   animal_parto.setDniPreparto(estadoSaludSeleccionado);

        // Guardar el Animal_parto en la base de datos
       animal_atencion_lechon_service.saveAnimalAtencion(animal_atencion);

        return "redirect:/mostrar-atencion-tabla";
    } catch (Exception e) {
        return "Error en :" + e.getMessage();
    }
}

*/



     /*  //registar ya sirve 
 @PostMapping("/registrar-atencion")
        public String guardarDato(@ModelAttribute("animal_atencion") Animal_atencion_lechon animal_atencion, Principal principal) {
            try {
                // Guarda el Animal_for_user en la base de datos
                animal_atencion_lechon_service.saveAnimalAtencion(animal_atencion);

                return "redirect:/mostrar-atencion-tabla";
            } catch (Exception e) {
                return "Error en :" + e.getMessage();
            }
        }
*/


@PostMapping("/registrar-atencion")
public String guardarDato(@ModelAttribute("animal_atencion") Animal_atencion_lechon animal_atencion_lechon, Principal principal, Model model) {
    try {
        // Intenta guardar el Animal_celo en la base de datos
        Animal_atencion_lechon savedAnimal = animal_atencion_lechon_service.saveAnimalAtencion(animal_atencion_lechon);

        if (savedAnimal == null) {
            // Si savedAnimal es null, significa que el DNI ya está registrado
            // Agrega un mensaje de error al modelo para mostrarlo en la vista
            model.addAttribute("error", "El DNI ya está registrado.");
            // Devuelve la vista con un mensaje de error
            return "animal_no_encontrado";
        }

        // Si el animal se guarda correctamente, redirecciona a la tabla correspondiente
        return "redirect:/mostrar-atencion-tabla";
    } catch (Exception e) {
        // Si ocurre una excepción, muestra un mensaje de error genérico
        model.addAttribute("error", "Error en: " + e.getMessage());
        // Devuelve la vista con un mensaje de error
        return "animal_no_encontrado";
    }
}




    

}
