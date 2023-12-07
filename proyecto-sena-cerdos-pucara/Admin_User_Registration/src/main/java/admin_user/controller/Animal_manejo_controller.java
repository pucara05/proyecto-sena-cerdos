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
import admin_user.model.Animal_parto;
import admin_user.service.Animal_manejo_service;
import admin_user.service.Animal_parto_service;

@Controller
public class Animal_manejo_controller {

    private final Animal_manejo_service animal_manejo_service;
    private final Animal_parto_service animal_parto_service;

    @Autowired
    public Animal_manejo_controller(Animal_manejo_service animal_manejo_service,
            Animal_parto_service animal_parto_service) {

        this.animal_manejo_service = animal_manejo_service;
        this.animal_parto_service = animal_parto_service;
    }

    @GetMapping("/manejo-vista")
    public String mostrarVistaManejoRegistro(Model model) {
        // List<String> dniPartos = animal_parto_service.obtenerdniParto(); // Método
        // para obtener los dniParto desde tu servicio

        // model.addAttribute("dniPartos", dniPartos);
        model.addAttribute("animal_manejo", new Animal_manejo()); // Agregar un objeto Animal_manejo al modelo
        return "manejo-registro"; // Devolver el nombre de la vista
    }

    // metodo para mostrar los datos en la tabla
    @GetMapping("/mostrar-manejo-tabla")
    public String mostrarDatosTabla(Model model) {
        // Obtener los datos que deseas mostrar en la tabla
        List<Animal_manejo> animalmanejoList = animal_manejo_service.getManejo(); // Reemplaza obtenerDatos() con el
                                                                                  // método que obtiene los datos

        // Realizar alguna operación con los datos si es necesario
        // Por ejemplo, ordenarlos o filtrarlos

        // Agregar los datos al modelo para pasarlos a la vista
        model.addAttribute("animalManejoList", animalmanejoList);

        // Devolver la vista que mostrará los datos en la tabla
        return "manejo-tabla"; // Reemplaza "tabla-datos" con el nombre de tu vista
    }

    // metodo para poder buscar por dni
    // para poder cargar los datos en la misma tabla pero los buscados por dni debo
    // colocar la variable animalMonta en la logica
    // de thymeleaf en la tabla y al buscar por dni carga los datos que estoy
    // buscando
    @GetMapping("/buscar-por-dni-animal-manejo")
    public String buscarPorDni(@RequestParam("dni") Long dni, Model model) {
        Animal_manejo animalmanejo = animal_manejo_service.buscarPorDni(dni);

        model.addAttribute("animalManejo", animalmanejo);
        return "manejo-tabla"; // Reemplaza con el nombre de tu vista
    }


/* 
@PostMapping("/registrar-manejo")
public String guardarDato(@ModelAttribute("animal_manejo") Animal_manejo animal_manejo, @RequestParam("estadoSalud") String selectdniParto, Principal principal) {
    try {
        // Asignar el valor seleccionado del select a dniPreparto
     //   animal_parto.setDniPreparto(estadoSaludSeleccionado);

        // Guardar el Animal_parto en la base de datos
        animal_manejo_service.saveAnimalManejo(animal_manejo);

        return "redirect:/mostrar-manejo-tabla";
    } catch (Exception e) {
        return "Error en :" + e.getMessage();
    }
}

*/


   //registar ya sirve 
 @PostMapping("/registrar-manejo")
        public String guardarDatomanejo(@ModelAttribute("animal_manejo") Animal_manejo animal_manejo, Principal principal) {
            try {
                // Guarda el Animal_for_user en la base de datos
                animal_manejo_service.saveAnimalManejo(animal_manejo);

                return "redirect:/mostrar-manejo-tabla";
            } catch (Exception e) {
                return "Error en :" + e.getMessage();
            }
        }





}
