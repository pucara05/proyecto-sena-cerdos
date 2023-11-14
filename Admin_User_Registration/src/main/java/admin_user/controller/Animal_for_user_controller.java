package admin_user.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import admin_user.model.Animal_for_user;
import admin_user.model.User;
import admin_user.service.Animal_for_user_service;
import admin_user.service.UserService;

@Controller
public class Animal_for_user_controller {
    
    private final Animal_for_user_service animal_for_user_service;

    @Autowired
    public Animal_for_user_controller(Animal_for_user_service animal_for_user_service) {

        this.animal_for_user_service = animal_for_user_service;
    }


    @Autowired
    private UserService  userService;
    //metodo para mostrar el formulario html vista  siempre es mejor colocar el mismo nombre del html en el get/post o demas para evitar errores 
    //metodo para la vista cerdo-registro
@GetMapping("/cerdo-registro")
    public String index(@ModelAttribute("animal_for_user")Animal_for_user animal_for_user){
        try {

            return "cerdo-registro";
        }
        catch (Exception e) {


            return "Error en cargar la pagina " + e.getMessage();
        }

    }
//vista tabla cerdo
//metodo para la tabla-cerdo
     @GetMapping("/tabla-cerdo")
    public String mostrarDatos(Model model){

        try {
            List<Animal_for_user> datos = animal_for_user_service.getAllAnimalForUser();
            model.addAttribute("datas" ,datos);

            return "tabla-cerdo";
        }
        catch(  Exception e) {
            return " Error al mostrar la lista " + e.getMessage();
        }


    }



    // ya sirve la vista para buscar y tabla aparte
    @GetMapping("/buscar-animales")
    public String mostrarBuscar(@ModelAttribute("animal_for_user")Animal_for_user animal_for_user){
        try {

            return "buscar-animal-for-user";
        }
        catch (Exception e) {


            return "Error en cargar la pagina " + e.getMessage();
        }

    }

//buscar por id
//metodo para buscar por id 
         @GetMapping("/buscar-por-id-animal")
    public String buscarAnimalPorId(@RequestParam(required = false) Long id, Model model) {
        if (id != null) {
            Animal_for_user animal = animal_for_user_service.obtenerAnimalPorId(id);
        
            if (animal != null) {
                model.addAttribute("animal", animal);
                return "tabla-cerdo";
            } else {    
                return "animal_no_encontrado";
            }
        } else {
            return "animal_no_encontrado"; // Tratar el caso en el que id sea nulo
        }
    }
    











//metodo para guardar si sirve para evitar errores se coloca el mismo name que la vista 
// a menos que redirecione a otra vista como aqui
//metodo para la  crear registro y redireciona a la tabla-animal-for-user
    /*  @PostMapping("/cerdo-registro")
    public String  guardarDato(@ModelAttribute ("animal_for_user") Animal_for_user animal_for_user){
        try {
        animal_for_user_service.saveAnimal(animal_for_user);

            return "redirect:/tabla-animal-for-user";
        }catch (Exception e){
            return "Error en :" + e.getMessage();

        }
    }
  */

//************************************************************metodo para guarda y guardar el id_user en la bd
 //  arreglar esto para poder registrar y mostra el id de los usuarios 
       @PostMapping("/cerdo-registro")
        public String guardarDato(@ModelAttribute("animal_for_user") Animal_for_user animal_for_user, Principal principal) {
            try {
                // Obtén el usuario actual por su nombre (email)
                String userEmail = principal.getName();
                User user = userService.getUserByEmail(userEmail);

                // Establece la relación entre Animal_for_user y User
                animal_for_user.setUser(user);

                // Guarda el Animal_for_user en la base de datos
                animal_for_user_service.saveAnimal(animal_for_user);

                return "redirect:/tabla-animal-for-user";
            } catch (Exception e) {
                return "Error en :" + e.getMessage();
            }
        }
    

    
//************************************************* 















 


//metodo para la vista  modificar cerdo
//agarra el modelo y carga los datos al registro con el id para modificarlos cuando se le de al boton
     @GetMapping("/animal_for_user/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Animal_for_user animal = animal_for_user_service.obtenerAnimalPorId(id);

        if (animal != null) {
            model.addAttribute("animal", animal);
            return "modificar-cerdo";
        } else {
            return "animal_no_encontrado";
        }
    }

/*  //metodo para modificar sirve pero modifica dnis iguales falta arreglar
    @PostMapping("/animal_for_user/modificar/{id}")
    public String modificarAnimal(@PathVariable Long id, @ModelAttribute Animal_for_user animal_for_user) {
        Animal_for_user animalExistente = animal_for_user_service.obtenerAnimalPorId(id);
        
        if (animalExistente != null) {
            // El animal existe, podemos proceder con la modificación
            animalExistente.setDni(animal_for_user.getDni());
            animalExistente.setRaza(animal_for_user.getRaza());
            animalExistente.setPeso(animal_for_user.getPeso());
            animalExistente.setFechaNacimientoCerdo(animal_for_user.getFechaNacimientoCerdo());
            // Actualiza cualquier otro atributo según sea necesario
    
            animal_for_user_service.saveAnimal(animalExistente);
            return "redirect:/tabla-cerdo"; // Redireccionar a la tabla
        } else {
            // El animal no existe, mostrar un mensaje de error o redireccionar a una página de error
            return "animal_no_encontrado";
        }
    }
    

   */

//metodo para modificar nuevo si sirve por ahora faltan mas pruebas
   @PostMapping("/animal_for_user/modificar/{id}")
public String modificarAnimal(@PathVariable Long id, @ModelAttribute Animal_for_user animal_for_user) {
    Animal_for_user animalExistente = animal_for_user_service.obtenerAnimalPorId(id);

    if (animalExistente != null) {
        // Verifica si hay otro animal con el mismo DNI
        Animal_for_user otroAnimalConMismoDni = animal_for_user_service.obtenerAnimalPorDni(animal_for_user.getDni());

        if (otroAnimalConMismoDni == null || otroAnimalConMismoDni.getId() == id) {
            // No hay otro animal con el mismo DNI o es el mismo animal que estamos editando
            animalExistente.setDni(animal_for_user.getDni());
            animalExistente.setRaza(animal_for_user.getRaza());
            animalExistente.setPeso(animal_for_user.getPeso());
            animalExistente.setFechaNacimientoCerdo(animal_for_user.getFechaNacimientoCerdo());

            animal_for_user_service.saveAnimal(animalExistente);
            return "redirect:/tabla-cerdo"; // Redireccionar a la tabla
        } else {
            // Ya hay otro animal con el mismo DNI, manejar el error
            return "animal_no_encontrado";
        }
    } else {
        // El animal no existe, mostrar un mensaje de error o redireccionar a una página de error
        return "animal_no_encontrado";
    }
}

//metodo para eliminar
@GetMapping("/animal_for_user/eliminar/{id}")
public String eliminarAnimal(@PathVariable Long id) {
   // Llamada al servicio para eliminar el animal
   animal_for_user_service.deleteAnimalForUser(id);
   return "redirect:/tabla-cerdo"; // Redireccionar a la tabla o a donde desees después de eliminar
}



  


}
