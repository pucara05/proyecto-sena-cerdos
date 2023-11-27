package admin_user.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import admin_user.dto.AnimalCeloDTO;
import admin_user.model.Animal_celo;
import admin_user.model.Animal_for_user;
import admin_user.repositories.Animal_for_user_repository;
import admin_user.service.Animal_celo_service;
import admin_user.service.Animal_for_user_service;

@Controller
public class Animal_celo_controller {
/* 
private final Animal_celo_service animal_celo_service;

@Autowired
public Animal_celo_controller(Animal_celo_service animal_celo_service){
    this.animal_celo_service = animal_celo_service;
}

@Autowired
Animal_for_user_service animal_for_user_service;

*/


@Autowired
private Animal_celo_service animal_celo_service;

@Autowired
private Animal_for_user_repository animal_for_user_repository;

@Autowired
private Animal_for_user_service animal_for_user_service;

/*private final Animal_celo_service animal_celo_service;
 private final Animal_for_user_service animal_for_user_service;

    @Autowired
    public Animal_celo_controller(Animal_celo_service animal_celo_service, Animal_for_user_service animal_for_user_service) {
        this.animal_celo_service = animal_celo_service;
        this.animal_for_user_service = animal_for_user_service;
    }
*/








//mostrar formulario vista 
@GetMapping("/formulario-celo")
    public String mostrarFormularioCelo(Model model) {
        // Crear un nuevo objeto Animal_celo y agregarlo al modelo
        Animal_celo animalCelo = new Animal_celo();
        model.addAttribute("animalCelo", animalCelo);

        // Devolver la vista que contiene el formulario
        return "celo-registro";
    }


    /* 
//Mostrar formulario de celo-registro sin modelo 
    @GetMapping("/mostrar-formulario")
    public String mostrarFormulario() {
        return "celo-registro"; // Retorna el nombre de la vista que quieres mostrar
    }
    */


    //Mostrar select sirve 
    @GetMapping("/api/animals/hembra")
    @ResponseBody
    public List<Animal_for_user> getHembraAnimals() {
        return animal_for_user_service.getHembraAnimals();
    }




    @GetMapping("/tabla-celo")
    public String mostrarDatosRegistrados(Model model) {
        try {
            List<AnimalCeloDTO> datosRegistrados = animal_celo_service.getAllAnimalCeloDTO();
            model.addAttribute("datosRegistrados", datosRegistrados);
            return "tabla-celo"; // Nombre de la vista para mostrar los datos registrados en una tabla
        } catch (Exception e) {
            model.addAttribute("error", "Error al obtener los datos registrados: " + e.getMessage());
            return "error"; // Vista para manejar errores
        }
    }








   /*  @GetMapping("/datos-registrados")
    public String mostrarDatosRegistrados(Model model) {
        try {
            List<Animal_celo> datosRegistrados = animal_celo_service.getAllAnimalCelo();
            model.addAttribute("datosRegistrados", datosRegistrados);
            return "tabla-celo"; // Nombre de la vista para mostrar los datos registrados en una tabla
        } catch (Exception e) {
            model.addAttribute("error", "Error al obtener los datos registrados: " + e.getMessage());
            return "error"; // Vista para manejar errores
        }
    }
    

*/


  /*  //Mostrar tabla celos
       @GetMapping("/tabla-celo")
    public String mostrarDatos(Model model){

        try {
            List<Animal_celo> datos = animal_celo_service.getAllAnimalCelo();
            model.addAttribute("datas" ,datos);

            return "tabla-celo";
        }
        catch(  Exception e) {
            return " Error al mostrar la lista " + e.getMessage();
        }


    }

    */



    /* 
//crear 
@PostMapping("/registrar-celo")
public String registrarAnimalCelo(Animal_celo animal, Model model) {
    animal_celo_service.saveAnimalCelo(animal);

    // Agregar un mensaje de confirmación al modelo
    model.addAttribute("mensaje", "¡El animal se registró correctamente!");
    return "redirect:/tabla-celo"; // Redirección a la ruta de la tabla-celo
}*/


 @PostMapping("/registrar-celo")
public String registrarAnimalCelo(@ModelAttribute("animalCelo") Animal_celo animalCelo) {
    try {
        // Aquí iría la lógica para guardar los datos en tu base de datos o sistema
        // animalCeloService.guardarAnimalCelo(animalCelo);
        
        // Por ejemplo, supongamos que el objeto Animal_celo tiene un servicio asociado para guardar los datos:
        animal_celo_service.saveAnimalCelo(animalCelo);

        return "redirect:/tabla-celo"; // Redirigir a la vista que muestra los datos registrados
    } catch (Exception e) {
        // Manejar cualquier excepción que pueda ocurrir durante el proceso de guardado
        // Por ejemplo, podrías registrar el error en un log y redirigir a una página de error
        // log.error("Error al guardar el animal: " + e.getMessage());
        return "redirect:/error"; // Redirigir a una vista de error
    }
}

/* 
//buscar por id
//metodo para buscar por id 
         @GetMapping("/buscar-por-id-celo")
    public String buscarCeloPorId(@RequestParam(required = false) Long id, Model model) {
        if (id != null) {
            Animal_celo animal = animal_celo_service.obtenerAnimalPorId(id);
        
            if (animal != null) {
                model.addAttribute("animal", animal);
                return "tabla-celo";
            } else {    
                return "animal_no_encontrado";
            }
        } else {
            return "animal_no_encontrado"; // Tratar el caso en el que id sea nulo
        }
    }







*/



  
   







    
}
