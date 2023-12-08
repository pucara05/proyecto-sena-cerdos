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
import org.springframework.web.bind.annotation.RequestParam;
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


//vista formulario sirve
 @GetMapping("/monta-registro")
    public String mostrarVistaMontaRegistro(Model model) {
        model.addAttribute("animal_monta", new Animal_monta()); // Agregar un objeto Animal_monta al modelo
        return "monta-registro"; // Devolver el nombre de la vista
    }



    //metodo para mostrar los datos en la tabla 
    @GetMapping("/mostrar-datos-tabla")
    public String mostrarDatosTabla(Model model) {
        // Obtener los datos que deseas mostrar en la tabla
        List<Animal_monta> animalMontaList = animal_monta_service.obtenerDatos(); // Reemplaza obtenerDatos() con el método que obtiene los datos
    
        // Realizar alguna operación con los datos si es necesario
        // Por ejemplo, ordenarlos o filtrarlos
    
        // Agregar los datos al modelo para pasarlos a la vista
        model.addAttribute("animalMontaList", animalMontaList);
    
        // Devolver la vista que mostrará los datos en la tabla
        return "monta-tabla"; // Reemplaza "tabla-datos" con el nombre de tu vista
    }
    






/* 
    //registar ya sirve 
 @PostMapping("/registrar-monta")
        public String guardarDato(@ModelAttribute("animal_monta") Animal_monta animal_monta, Principal principal) {
            try {
                // Guarda el Animal_for_user en la base de datos
                animal_monta_service.saveAnimalMonta(animal_monta);

                return "redirect:/mostrar-datos-tabla";
            } catch (Exception e) {
                return "Error en :" + e.getMessage();
            }
        }

*/


@PostMapping("/registrar-monta")
public String guardarDato(@ModelAttribute("animal_monta") Animal_monta animal_monta, Principal principal, Model model) {
    try {
        // Intenta guardar el Animal_celo en la base de datos
        Animal_monta savedAnimal = animal_monta_service.saveAnimalMonta(animal_monta);

        if (savedAnimal == null) {
            // Si savedAnimal es null, significa que el DNI ya está registrado
            // Agrega un mensaje de error al modelo para mostrarlo en la vista
            model.addAttribute("error", "El DNI ya está registrado.");
            // Devuelve la vista con un mensaje de error
            return "animal_no_encontrado";
        }

        // Si el animal se guarda correctamente, redirecciona a la tabla correspondiente
        return "redirect:/mostrar-datos-tabla";
    } catch (Exception e) {
        // Si ocurre una excepción, muestra un mensaje de error genérico
        model.addAttribute("error", "Error en: " + e.getMessage());
        // Devuelve la vista con un mensaje de error
        return "animal_no_encontrado";
    }
}











   //metodos del controlador para mostrar los datos en el select van conectados con 
   //el metodo para mostrar el formulario mostrarVistaMontaRegistro
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




//metodo para poder buscar por dni 
//para poder cargar los datos en la misma tabla pero los buscados por dni debo colocar la variable animalMonta en la logica
//de thymeleaf en la tabla y al buscar por dni carga los datos que estoy buscando
@GetMapping("/buscar-por-id-animal-monta")
    public String buscarPorDni(@RequestParam("dni") Long dni, Model model) {
        Animal_monta animalMonta = animal_monta_service.buscarPorDni(dni);

        model.addAttribute("animalMonta", animalMonta);
        return "monta-tabla"; // Reemplaza con el nombre de tu vista
    }


}
