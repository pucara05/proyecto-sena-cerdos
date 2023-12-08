package admin_user.controller;

import java.security.Principal;
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
import admin_user.model.Animal_atencion_lechon;
import admin_user.model.Animal_celo;
import admin_user.model.Animal_for_user;
import admin_user.model.User;
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


    /* 
    //buscar por dni
    @GetMapping("/buscar-por-dni-celo")
    public String buscarAnimalPorDni(@RequestParam(required = false) Long dni, Model model) {
        try {
            if (dni != null) {
                // Lógica para buscar un animal por su número de DNI utilizando el servicio
                Animal_celo animal = animal_celo_service.obtenerCeloPorDni(dni);
    
                if (animal != null) {
                    model.addAttribute("Animal", animal);
                    return "tabla-celo"; // Reemplaza con el nombre de tu vista
                } else {
                    return "animal_no_encontrado"; // Vista para mostrar si no se encuentra el animal
                }
            } else {
                return "animal_no_encontrado"; // Tratar el caso en el que dni sea nulo
            }
        } catch (Exception e) {
            return "Error: " + e.getMessage(); // Manejo de errores si ocurre alguna excepción
        }
    }
    
*/



/* 
 @GetMapping("/buscar-por-dni-animal-celo")
    public String buscarPorDni(@RequestParam("id") Long id, Model model) {
         if (id != null) {
        Animal_celo animalDTO = animal_celo_service.obtenerAnimalCeloPorId(id);
  if (animalDTO != null) {
        model.addAttribute("animal", animalDTO);
        return "celo-tabla"; // Reemplaza con el nombre de tu vista
          } else {
                return "animal_no_encontrado"; // Vista para mostrar cuando no se encuentra el animal
            }
        } else {
            return "animal_no_encontrado"; // Tratar el caso en el que id sea nulo
    }

    }
*/





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


/* 
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
*/

/* 
//metodo para la vista  modificar cerdo
//agarra el modelo y carga los datos al registro con el id para modificarlos cuando se le de al boton
@GetMapping("/animal_for_user/editar/{id}")
public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
    AnimalCeloDTO animal = animal_celo_service.obtenerAnimalId(id);

    if (animal != null) {
        model.addAttribute("animal", animal);
        return "modificar-celo";
    } else {
        return "animal_no_encontrado";
    }
}
*/

/* 
// Método para mostrar la vista de edición del animal en celo por su ID
@GetMapping("/editar/{id}")
public String mostrarVistaEditar(@PathVariable Long id, Model model) {
    try {
        // Obtener el AnimalCeloDTO por su ID
        AnimalCeloDTO animal = animal_celo_service.obtenerAnimalId(id);

        // Agregar el AnimalCeloDTO al modelo para ser utilizado en la vista
        model.addAttribute("animal", animal);

        // Devolver el nombre de la vista para editar el animal en celo
        return "modificar-celo"; // Nombre de la vista Thymeleaf
    } catch (Exception e) {
        // Manejo de errores: redirigir a una página de error o mostrar un mensaje de error
        return "error"; // Página de error personalizada
    }
}




    // Método para manejar las peticiones de modificación
    @PostMapping("/modificar-celo")
    public String modificarAnimalCelo(@ModelAttribute AnimalCeloDTO animalCeloDTO) {
        try {
            // Llamar al método de actualización del servicio
            AnimalCeloDTO animalActualizado = animal_celo_service.updateAnimalCelo(animalCeloDTO);

            // Realizar alguna acción con el animal actualizado, como redirigir a una vista o mostrar un mensaje de éxito
            return "redirect:/tabla-cerdo/" + animalActualizado.getId(); // Redirigir a los detalles del animal modificado
        } catch (Exception e) {
            // Manejo de errores: puedes redirigir a una página de error o mostrar un mensaje de error
            return "error"; // Redirigir a una página de error personalizada
        }
    }
  */

/* 
//registar ya sirve 
 @PostMapping("/registrar-celo")
        public String guardarDato(@ModelAttribute("animal_celo") Animal_celo animal_celo, Principal principal) {
            try {
                // Guarda el Animal_for_user en la base de datos
                animal_celo_service.saveAnimalCelo(animal_celo);

                return "redirect:/tabla-celo";
            } catch (Exception e) {
                return "Error en :" + e.getMessage();
            }
        }
    */

    @PostMapping("/registrar-celo")
public String guardarDato(@ModelAttribute("animal_celo") Animal_celo animal_celo, Principal principal, Model model) {
    try {
        // Intenta guardar el Animal_celo en la base de datos
        Animal_celo savedAnimal = animal_celo_service.saveAnimalCelo(animal_celo);

        if (savedAnimal == null) {
            // Si savedAnimal es null, significa que el DNI ya está registrado
            // Agrega un mensaje de error al modelo para mostrarlo en la vista
            model.addAttribute("error", "El DNI ya está registrado.");
            // Devuelve la vista con un mensaje de error
            return "animal_no_encontrado";
        }

        // Si el animal se guarda correctamente, redirecciona a la tabla correspondiente
        return "redirect:/tabla-celo";
    } catch (Exception e) {
        // Si ocurre una excepción, muestra un mensaje de error genérico
        model.addAttribute("error", "Error en: " + e.getMessage());
        // Devuelve la vista con un mensaje de error
        return "animal_no_encontrado";
    }
}





        //buscar por id
//metodo para buscar por id 
@GetMapping("/buscar-por-dni-celo")
public String buscarAnimalPorId(@RequestParam(required = false) Long id, Model model) {
    if (id!= null) {
        AnimalCeloDTO animal = animal_celo_service.obtenerAnimalId(id);
    
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



@GetMapping("/animal_celo/editar/{id}")
public String mostrarFormularioEditarAnimalCelo(@PathVariable Long id, Model model) {
    Animal_celo animal = animal_celo_service.obtenerAnimalCeloPorId(id);

    if (animal != null) {
        model.addAttribute("animal", animal);
        return "modificar-celo"; // Vista para modificar Animal_celo
    } else {
        return "animal_no_encontrado"; // Manejo cuando no se encuentra el animal
    }
}


@PostMapping("/animal_celo/modificar/{id}")
public String modificarAnimalCelo(@PathVariable Long id, @ModelAttribute Animal_celo animalCelo) {
    Animal_celo animalExistente = animal_celo_service.obtenerAnimalCeloPorId(id);

    if (animalExistente != null) {
        // Verifica si hay otro Animal_celo con el mismo DNI
        Animal_celo otroAnimalConMismoDni = animal_celo_service.obtenerAnimalCeloPorDni(animalCelo.getDni());

        if (otroAnimalConMismoDni == null || otroAnimalConMismoDni.getId().equals(id)) {
            // No hay otro Animal_celo con el mismo DNI o es el mismo animal que estamos editando
            animalExistente.setDni(animalCelo.getDni());
            animalExistente.setFechaCelo(animalCelo.getFechaCelo());
         

            animal_celo_service.saveAnimalCelo(animalExistente);
            return "redirect:/tabla-celo"; // Redireccionar a la tabla de Animal_celo
        } else {
            // Ya hay otro Animal_celo con el mismo DNI, manejar el error
            return "animal_no_encontrado";
        }
    } else {
        // El Animal_celo no existe, mostrar un mensaje de error o redireccionar a una página de error
        return "animal_no_encontrado";
    }
}


    
}
