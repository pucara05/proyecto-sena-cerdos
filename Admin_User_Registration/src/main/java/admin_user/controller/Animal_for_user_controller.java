package admin_user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import admin_user.dto.CerdoRegistroDto;
import admin_user.model.Animal_for_user;
import admin_user.model.CerdoRegistro;
import admin_user.service.Animal_for_user_service;

@Controller
public class Animal_for_user_controller {
    
    private final Animal_for_user_service animal_for_user_service;

    @Autowired
    public Animal_for_user_controller(Animal_for_user_service animal_for_user_service) {

        this.animal_for_user_service = animal_for_user_service;
    }

    //metodo para mostrar el formulario html vista  siempre es mejor colocar el mismo nombre del html en el get/post o demas para evitar errores 
@GetMapping("/cerdo-registro")
    public String index(@ModelAttribute("animal_for_user")Animal_for_user animal_for_user){
        try {

            return "cerdo-registro";
        }
        catch (Exception e) {


            return "Error en cargar la pagina " + e.getMessage();
        }

    }


//metodo para guardar si sirve para evitar errores se coloca el mismo name que la vista html a menos que redirecione a otra vista como aqui
      @PostMapping("/cerdo-registro")
    public String  guardarDato(@ModelAttribute ("animal_for_user") Animal_for_user animal_for_user){
        try {
        animal_for_user_service.saveAnimal(animal_for_user);;

            return "redirect:/tabla-animal-for-user";
        }catch (Exception e){
            return "Error en :" + e.getMessage();

        }
    }
  

@PostMapping("/animal_for_user/modificar/{id}")
public String modificarAnimal(@PathVariable Long id, @ModelAttribute Animal_for_user animal) {
    Animal_for_user animalExistente = animal_for_user_service.obtenerAnimalPorId(id);
    
    if (animalExistente != null) {
        // El animal existe, podemos proceder con la modificación
        animalExistente.setDni(animal.getDni());
        animalExistente.setRaza(animal.getRaza());
        animalExistente.setPeso(animal.getPeso());
        animalExistente.setFechaNacimientoCerdo(animal.getFechaNacimientoCerdo());
        // Actualiza cualquier otro atributo según sea necesario

        animal_for_user_service.saveAnimal(animalExistente);
        return "redirect:/animal_for_user/tabla"; // Redireccionar a la tabla
    } else {
        // El animal no existe, mostrar un mensaje de error o redireccionar a una página de error
        return "animal_no_encontrado";
    }
}

  


}
