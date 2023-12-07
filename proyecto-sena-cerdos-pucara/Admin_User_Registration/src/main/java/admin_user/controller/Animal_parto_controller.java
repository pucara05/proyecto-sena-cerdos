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
import org.springframework.web.bind.annotation.ResponseBody;

import admin_user.model.Animal_for_user;
import admin_user.model.Animal_parto;
import admin_user.model.Animal_preparto;
import admin_user.service.Animal_for_user_service;
import admin_user.service.Animal_parto_service;
import admin_user.service.Animal_preparto_service;

@Controller
public class Animal_parto_controller {

    
private final Animal_parto_service animal_parto_service;
private final Animal_for_user_service animal_for_user_service;
private final Animal_preparto_service animal_preparto_service;


@Autowired
public Animal_parto_controller(Animal_parto_service animal_parto_service, Animal_for_user_service animal_for_user_service, Animal_preparto_service animal_preparto_service ) {
    this.animal_parto_service = animal_parto_service;
    this.animal_for_user_service = animal_for_user_service;
    this.animal_preparto_service = animal_preparto_service;
}



/* 
//vista formulario sirve
 @GetMapping("/parto-vista")
    public String mostrarVistaPrepartoRegistro(Model model) {
        model.addAttribute("animal_parto", new Animal_parto()); // Agregar un objeto Animal_monta al modelo
        return "parto-registro"; // Devolver el nombre de la vista
    }
*/

@GetMapping("/parto-vista")
public String mostrarVistaPrepartoRegistro(Model model) {
    List<String> estadosSalud = animal_preparto_service.obtenerEstadosSalud(); // Método para obtener los estados de salud desde tu servicio

    model.addAttribute("estadosSalud", estadosSalud);
    model.addAttribute("animal_parto", new Animal_parto()); // Agregar un objeto Animal_monta al modelo
    return "parto-registro"; // Devolver el nombre de la vista
}





@PostMapping("/registrar-parto")
public String guardarDato(@ModelAttribute("animal_parto") Animal_parto animal_parto, @RequestParam("estadoSalud") String estadoSaludSeleccionado, Principal principal) {
    try {
        // Asignar el valor seleccionado del select a dniPreparto
        animal_parto.setDniPreparto(estadoSaludSeleccionado);

        // Guardar el Animal_parto en la base de datos
        animal_parto_service.saveAnimalParto(animal_parto);

        return "redirect:/mostrar-parto-tabla";
    } catch (Exception e) {
        return "Error en :" + e.getMessage();
    }
}








/* *        //registar ya sirve 
 @PostMapping("/registrar-parto")
        public String guardarDato(@ModelAttribute("animal_parto") Animal_parto animal_parto, Principal principal) {
            try {

      
                // Guarda el Animal_for_user en la base de datos
                animal_parto_service.saveAnimalParto(animal_parto);

                return "redirect:/mostrar-parto-tabla";
            } catch (Exception e) {
                return "Error en :" + e.getMessage();
            }
        }

*/

         //metodo para mostrar los datos en la tabla 
    @GetMapping("/mostrar-parto-tabla")
    public String mostrarDatosTabla(Model model) {
        // Obtener los datos que deseas mostrar en la tabla
        List<Animal_parto> animalpartoList = animal_parto_service.getParto(); // Reemplaza obtenerDatos() con el método que obtiene los datos
    
        // Realizar alguna operación con los datos si es necesario
        // Por ejemplo, ordenarlos o filtrarlos
    
        // Agregar los datos al modelo para pasarlos a la vista
        model.addAttribute("animalPartoList", animalpartoList);
    
        // Devolver la vista que mostrará los datos en la tabla
        return "parto-tabla"; // Reemplaza "tabla-datos" con el nombre de tu vista
    }




    //metodo para poder buscar por dni 
//para poder cargar los datos en la misma tabla pero los buscados por dni debo colocar la variable animalMonta en la logica
//de thymeleaf en la tabla y al buscar por dni carga los datos que estoy buscando
@GetMapping("/buscar-por-dni-animal-parto")
    public String buscarPorDni(@RequestParam("dni") Long dni, Model model) {
        Animal_parto animalparto = animal_parto_service.buscarPorDni(dni);

        model.addAttribute("animalParto", animalparto);
        return "parto-tabla"; // Reemplaza con el nombre de tu vista
    }







    
}
