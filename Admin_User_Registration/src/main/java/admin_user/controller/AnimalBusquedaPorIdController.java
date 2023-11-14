package admin_user.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import admin_user.model.Animal_for_user;
import admin_user.service.Animal_for_user_service;

@Controller
public class AnimalBusquedaPorIdController {

     private final Animal_for_user_service animal_for_user_service;

    @Autowired
    public AnimalBusquedaPorIdController(Animal_for_user_service animal_for_user_service) {

        this.animal_for_user_service = animal_for_user_service;
    }



/*  ya sirve por fin mi error era que se me olvido colocar @Controller acordarse que java es fuertemente tipado y extrito
    @GetMapping("/buscar-animal")
    public String mostrarOtraTabla() {
        return "buscar-animal-for-user"; // Devuelve el nombre de la vista HTML (sin extensión)
    }

    */


     
   // metodo para mostrar la vista 
     @GetMapping("/buscar-animal")
    public String index(@ModelAttribute("animal_for_user")Animal_for_user animal_for_user){
        try {

            return "buscar-animal-for-user";
        }
        catch (Exception e) {


            return "Error en cargar la pagina " + e.getMessage();
        }

    }
 



//metodo para buscar por id o dni
@GetMapping("/buscar")
public String buscarAnimal(@RequestParam(required = false) Long id, 
                           @RequestParam(required = false) Long dni, 
                           Model model) {
    if (id != null) {
        Animal_for_user animal = animal_for_user_service.obtenerAnimalPorId(id);
        if (animal != null) {
            model.addAttribute("animal", animal);
            return "buscar-animal-for-user";
        }
    } else if (dni != null) {
        Animal_for_user animal = animal_for_user_service.obtenerAnimalPorDni(dni);
        if (animal != null) {
            model.addAttribute("animal", animal);
            return "buscar-animal-for-user";
        }
    }

    return "animal_no_encontrado";
}


       
       












    //metodo de buscar sirve para buscar se debe usar @RequestParam   @pathvariable no me ah funcionado
    //sirve completamente
   /*  @GetMapping("/buscarPorId")
    public String buscarAnimalPorId(@RequestParam Long id, Model model) {
        Animal_for_user animal = animal_for_user_service.obtenerAnimalPorId(id);
    
        if (animal != null) {
            model.addAttribute("animal", animal);
            return "buscar-animal-for-user";
        } else {
            return "animal_no_encontrado";
        }
    }
*/







    






    



}
