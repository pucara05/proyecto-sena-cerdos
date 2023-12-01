package admin_user.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import admin_user.model.Animal_celo;
import admin_user.model.Animal_for_user;
import admin_user.model.Animal_monta;
import admin_user.service.Animal_for_user_service;
import admin_user.service.Animal_monta_service;

@Controller

public class Animal_monta_controller {
    
private final Animal_monta_service animal_monta_service;
private final Animal_for_user_service animal_for_user_service;


@Autowired
public Animal_monta_controller(Animal_monta_service animal_monta_service, Animal_for_user_service animal_for_user_service ) {
    this.animal_monta_service = animal_monta_service;
    this.animal_for_user_service = animal_for_user_service;
}

 @GetMapping("/monta-registro")
    public String mostrarVistaMontaRegistro(Model model) {
        model.addAttribute("animal_monta", new Animal_monta()); // Agregar un objeto Animal_monta al modelo
        return "monta-registro"; // Devolver el nombre de la vista
    }




/* 
//mostrar formulario vista 
@GetMapping("/monta-registro")
    public String mostrarFormularioCelo(Model model) {
        // Crear un nuevo objeto Animal_celo y agregarlo al modelo
        Animal_monta animalMonta = new Animal_monta();
        model.addAttribute("animalMonta", animalMonta);

        // Devolver la vista que contiene el formulario
        return "monta-registro";
    }
*/

    //registar ya sirve 
 @PostMapping("/registrar-monta")
        public String guardarDato(@ModelAttribute("animal_monta") Animal_monta animal_monta, Principal principal) {
            try {
                // Guarda el Animal_for_user en la base de datos
                animal_monta_service.saveAnimalMonta(animal_monta);

                return "redirect:/animal-monta";
            } catch (Exception e) {
                return "Error en :" + e.getMessage();
            }
        }


/* 
//metodo para registrar 
    @PostMapping("/registrar-monta")
    public String registrarAnimal(@ModelAttribute("animal_monta") Animal_monta animalMonta) {
        Animal_monta animalRegistrado = animal_monta_service.saveAnimalMonta(animalMonta);
        // Aquí podrías agregar lógica adicional, como enviar datos a la vista o redireccionar a otra página.
        return "redirect:/animal-monta";  // + animalRegistrado.getId();
    }
*/


   
//select hembra dni sirve
    @GetMapping("/hembra-dni")
    @ResponseBody
    public List<Animal_for_user> getHembraAnimalsDni() {
        return animal_for_user_service.getHembraAnimals();
    }


    //select dni macho
    @GetMapping("/macho-dni")
@ResponseBody
public List<Animal_for_user> getMachoAnimalsDni() {
    return animal_for_user_service.getMachoAnimals();
}





}
