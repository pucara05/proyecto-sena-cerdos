package admin_user.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
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
 private  ModelMapper modelMapper;

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



//tabla
    @GetMapping("/tabla-celo")
    public String mostrarDatos(Model model){

        try {
            List<AnimalCeloDTO> datosRegistrados = animal_celo_service.getAllAnimalCeloDTO();
            model.addAttribute("datosRegistrados" ,datosRegistrados);

            return "tabla-celo";
        }
        catch(  Exception e) {
            return " Error al mostrar la lista " + e.getMessage();
        }


    }

    //buscar por id
//metodo para buscar por id 
@GetMapping("/buscar-por-id-animal-celo")
    public String buscarPorId(@RequestParam(required = false) Long id, Model model) {
        if (id != null) {
            AnimalCeloDTO animalDTO = animal_celo_service.obtenerAnimalId(id);

            if (animalDTO != null) {
                model.addAttribute("animal", animalDTO);
                return "tabla-celo"; // Nombre de la vista para mostrar los datos del animal
            } else {
                return "animal_no_encontrado"; // Vista para mostrar cuando no se encuentra el animal
            }
        } else {
            return "animal_no_encontrado"; // Tratar el caso en el que id sea nulo
        }
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




   /* @GetMapping("/tabla-celo")
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
*/

// Método para mostrar la tabla
   /*  @GetMapping("/tabla-celo")
    public String mostrarTabla(Model model) {
        List<Animal_celo> animales = animal_celo_service.getAllAnimalCelo();
        List<AnimalCeloDTO> dtos = new ArrayList<>();

        for (Animal_celo animal : animales) {
            AnimalCeloDTO dto = modelMapper.map(animal, AnimalCeloDTO.class);
            // Aquí puedes realizar más ajustes o mapeos según tus necesidades
            dtos.add(dto);
        }

        model.addAttribute("datosRegistrados", dtos);
        return "tabla-celo";
    }

*/






   

 

/* 
@PostMapping("/actualizar-animal-celo")
public String actualizarAnimalCelo(@ModelAttribute("animalCeloDTO") AnimalCeloDTO animalDTO) {
    try {
        animal_celo_service.updateAnimalCeloFromDTO(animalDTO);
        return "redirect:/tabla-celo"; // Redirigir a la vista que muestra los datos actualizados
    } catch (IllegalArgumentException e) {
        // Manejar el error, por ejemplo, redirigir a una página de error o mostrar un mensaje
        return "redirect:/error";
    }
}
*/


// Suponiendo que tienes una entidad Animal_celo y un servicio animal_celo_service para operaciones con Animal_celo
/*@PostMapping("/animal_celo/modificar/{id}")
public String modificarAnimalCelo(@PathVariable Long id, @ModelAttribute Animal_celo animalCelo) {
    Animal_celo animalExistente = animal_celo_service.obtenerAnimalCeloPorId(id);

    if (animalExistente != null) {
        // Verifica si hay otro animal con el mismo DNI (o la lógica necesaria para la verificación)
        // Aquí puedes implementar la lógica de verificación adecuada para Animal_celo

        // Actualiza los campos del animalExistente con los datos del animalCelo
        animalExistente.setDniCelo(animalCelo.getDniCelo());
        animalExistente.setFechaCelo(animalCelo.getFechaCelo());
        // Actualiza otros campos según las necesidades de tu entidad Animal_celo

        // Guarda el animal actualizado en el repositorio
        animal_celo_service.saveAnimalCelo(animalExistente);

        return "redirect:/tabla-celo"; // Redirecciona a la vista que muestra los datos actualizados de Animal_celo
    } else {
        // El animal no existe, mostrar un mensaje de error o redireccionar a una página de error
        return "animal_no_encontrado";
    }
}

*/


//metodo para la vista  modificar celo
//agarra el modelo y carga los datos al registro con el id para modificarlos cuando se le de al boton



@GetMapping("/animal_celo/editar/{id}")
public String mostrarFormularioEditarAnimalCelo(@PathVariable Long id, Model model) {
    AnimalCeloDTO animal = animal_celo_service.obtenerAnimalId(id);

    if (animal != null) {
        model.addAttribute("animalCelo", animal); // Asegúrate de agregar el objeto animalCelo al modelo
        return "modificar-celo";
    } else {
        return "animal_no_encontrado";
    }
}



@PostMapping("/animal_celo/modificar")
public String modificarAnimalCelo(@ModelAttribute Animal_celo animalCelo) {
    try {
        Animal_celo animalExistente = animal_celo_service.obtenerAnimalCeloPorId(animalCelo.getId());

        if (animalExistente != null) {
            // Actualiza los campos del animal existente con los nuevos valores
            animalExistente.setDniCelo(animalCelo.getDniCelo());
            animalExistente.setFechaCelo(animalCelo.getFechaCelo());
            // Actualiza otros campos según sea necesario

            // Guarda los cambios en la base de datos
            animal_celo_service.saveAnimalCelo(animalExistente);

            return "redirect:/tabla-celo"; // Redirige a donde sea necesario
        } else {
            // El animal no existe, manejar el error o redirigir a una página de error
            return "animal_no_encontrado";
        }
    } catch (Exception e) {
        // Manejar cualquier excepción que pueda ocurrir durante la modificación
        // Por ejemplo, registrar el error en un log y redirigir a una vista de error
        // log.error("Error al modificar el animal: " + e.getMessage());
        return "redirect:/error"; // Redirigir a una vista de error
    }
}

  








    
}
