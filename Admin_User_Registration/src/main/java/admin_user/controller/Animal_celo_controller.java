package admin_user.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import admin_user.model.Animal_celo;
import admin_user.model.Animal_for_user;
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
private Animal_for_user_service animal_for_user_service;

/*private final Animal_celo_service animal_celo_service;
 private final Animal_for_user_service animal_for_user_service;

    @Autowired
    public Animal_celo_controller(Animal_celo_service animal_celo_service, Animal_for_user_service animal_for_user_service) {
        this.animal_celo_service = animal_celo_service;
        this.animal_for_user_service = animal_for_user_service;
    }
*/

@GetMapping("/form-celo")
    public String viewCelo(@ModelAttribute("animal_celo")Animal_celo animal_celo){
        try {

            return "celo-registro";
        }
        catch (Exception e) {


            return "Error en cargar la pagina " + e.getMessage();
        }

    }

    //Mostrar tabla celos
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






    @GetMapping("/create")
    public String mostrarSelect(Model model) {
        Animal_for_user animalForUser = new Animal_for_user();
        List<Animal_celo> listaCelo = animal_celo_service.getAllAnimalCelo();
    
        model.addAttribute("titulo", "Formulario: Nuevo Celo");
        model.addAttribute("animalForUser", animalForUser); // Usando "animalForUser" en lugar de "animalCelo"
        model.addAttribute("listaAnimalCelo", listaCelo); // Usando "listaAnimalCelo" en lugar de "animalForUser"
    
        return "celo-registro";
    }
   
   

  /*  //metodo para listar en la tabla 
@GetMapping("/")
public String listarCerdosCelos(Model model){
List<Animal_celo> listadoAnimalCelo = animal_celo_service.getAllAnimalCelo();

model.addAttribute("titulo", "Lista de AnimalCelo");
model.addAttribute("datas", listadoAnimalCelo);

return"tabla-celo";
}
*/





    
}
