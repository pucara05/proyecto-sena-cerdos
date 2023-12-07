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

import admin_user.model.Animal_gestacion;
import admin_user.model.Animal_monta;
import admin_user.model.Animal_preparto;
import admin_user.service.Animal_for_user_service;
import admin_user.service.Animal_gestacion_service;
import admin_user.service.Animal_preparto_service;

@Controller
public class Animal_preparto_controller {
    
   
private final Animal_preparto_service animal_preparto_service;
private final Animal_for_user_service animal_for_user_service;


@Autowired
public Animal_preparto_controller(Animal_preparto_service animal_preparto_service, Animal_for_user_service animal_for_user_service ) {
    this.animal_preparto_service = animal_preparto_service;
    this.animal_for_user_service = animal_for_user_service;
}




//vista formulario sirve
 @GetMapping("/preparto-vista")
    public String mostrarVistaPrepartoRegistro(Model model) {
        model.addAttribute("animal_preparto", new Animal_preparto()); // Agregar un objeto Animal_monta al modelo
        return "preparto-registro"; // Devolver el nombre de la vista
    }


         //registar ya sirve 
 @PostMapping("/registrar-preparto")
        public String guardarDato(@ModelAttribute("animal_preparto") Animal_preparto animal_preparto, Principal principal) {
            try {
                // Guarda el Animal_for_user en la base de datos
                animal_preparto_service.saveAnimalPreparto(animal_preparto);

                return "redirect:/mostrar-preparto-tabla";
            } catch (Exception e) {
                return "Error en :" + e.getMessage();
            }
        }



         //metodo para mostrar los datos en la tabla 
    @GetMapping("/mostrar-preparto-tabla")
    public String mostrarDatosTabla(Model model) {
        // Obtener los datos que deseas mostrar en la tabla
        List<Animal_preparto> animalprepartoList = animal_preparto_service.getPreparto(); // Reemplaza obtenerDatos() con el método que obtiene los datos
    
        // Realizar alguna operación con los datos si es necesario
        // Por ejemplo, ordenarlos o filtrarlos
    
        // Agregar los datos al modelo para pasarlos a la vista
        model.addAttribute("animalPrepartoList", animalprepartoList);
    
        // Devolver la vista que mostrará los datos en la tabla
        return "preparto-tabla"; // Reemplaza "tabla-datos" con el nombre de tu vista
    }




    //metodo para poder buscar por dni 
//para poder cargar los datos en la misma tabla pero los buscados por dni debo colocar la variable animalMonta en la logica
//de thymeleaf en la tabla y al buscar por dni carga los datos que estoy buscando
@GetMapping("/buscar-por-id-animal-preparto")
    public String buscarPorDni(@RequestParam("dni") Long dni, Model model) {
        Animal_preparto animalpreparto = animal_preparto_service.buscarPorDni(dni);

        model.addAttribute("animalPreparto", animalpreparto);
        return "preparto-tabla"; // Reemplaza con el nombre de tu vista
    }



}
