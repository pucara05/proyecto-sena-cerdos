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

import admin_user.model.Animal_atencion_lechon;
import admin_user.model.Animal_manejo;
import admin_user.model.Animal_parto;
import admin_user.service.Animal_manejo_service;
import admin_user.service.Animal_parto_service;

@Controller
public class Animal_manejo_controller {

    private final Animal_manejo_service animal_manejo_service;
    private final Animal_parto_service animal_parto_service;

    @Autowired
    public Animal_manejo_controller(Animal_manejo_service animal_manejo_service,
            Animal_parto_service animal_parto_service) {

        this.animal_manejo_service = animal_manejo_service;
        this.animal_parto_service = animal_parto_service;
    }

    @GetMapping("/manejo-vista")
    public String mostrarVistaManejoRegistro(Model model) {
         List<String> dniParto = animal_parto_service.obtenerdniParto(); // Método
        // para obtener los dniParto desde tu servicio

         model.addAttribute("dniPartos", dniParto);
        model.addAttribute("animal_manejo", new Animal_manejo()); // Agregar un objeto Animal_manejo al modelo
        return "manejo-registro"; // Devolver el nombre de la vista
    }

    // metodo para mostrar los datos en la tabla
    @GetMapping("/mostrar-manejo-tabla")
    public String mostrarDatosTabla(Model model) {
        // Obtener los datos que deseas mostrar en la tabla
        List<Animal_manejo> animalmanejoList = animal_manejo_service.getManejo(); // Reemplaza obtenerDatos() con el
                                                                                  // método que obtiene los datos

        // Realizar alguna operación con los datos si es necesario
        // Por ejemplo, ordenarlos o filtrarlos

        // Agregar los datos al modelo para pasarlos a la vista
        model.addAttribute("animalManejoList", animalmanejoList);

        // Devolver la vista que mostrará los datos en la tabla
        return "manejo-tabla"; // Reemplaza "tabla-datos" con el nombre de tu vista
    }

    // metodo para poder buscar por dni
    // para poder cargar los datos en la misma tabla pero los buscados por dni debo
    // colocar la variable animalMonta en la logica
    // de thymeleaf en la tabla y al buscar por dni carga los datos que estoy
    // buscando
    @GetMapping("/buscar-por-dni-animal-manejo")
    public String buscarPorDni(@RequestParam("dni") Long dni, Model model) {
        // Realizar la validación para verificar si el dni existe en la base de datos
        if (dni != null) {
            Animal_manejo animalManejo = animal_manejo_service.buscarPorDni(dni);
    
            if (animalManejo != null) {
                // Si se encuentra el registro con el dni proporcionado, lo agregamos al modelo y mostramos los detalles
                model.addAttribute("animalManejo", animalManejo);
                return "manejo-tabla"; // Reemplaza con el nombre de tu vista
            } else {
                // Si no se encuentra el registro con el dni proporcionado, puedes mostrar un mensaje de error o redirigir a una página de error
                model.addAttribute("mensajeError", "No se encontró ningún registro con el DNI proporcionado.");
                return "animal_no_encontrado"; // Reemplaza con el nombre de tu vista de error
            }
        } else {
            // Si el parámetro dni es null, puedes manejarlo de acuerdo a tu lógica
            model.addAttribute("mensajeError", "El DNI proporcionado es inválido.");
            return "animal_no_encontrado"; // Reemplaza con el nombre de tu vista de error
        }
    }


/* 
@PostMapping("/registrar-manejo")
public String guardarDato(@ModelAttribute("animal_manejo") Animal_manejo animal_manejo, @RequestParam("estadoSalud") String selectdniParto, Principal principal) {
    try {
        // Asignar el valor seleccionado del select a dniPreparto
     //   animal_parto.setDniPreparto(estadoSaludSeleccionado);

        // Guardar el Animal_parto en la base de datos
        animal_manejo_service.saveAnimalManejo(animal_manejo);

        return "redirect:/mostrar-manejo-tabla";
    } catch (Exception e) {
        return "Error en :" + e.getMessage();
    }
}

*/

/* 
   //registar ya sirve 
 @PostMapping("/registrar-manejo")
        public String guardarDatomanejo(@ModelAttribute("animal_manejo") Animal_manejo animal_manejo, Principal principal) {
            try {
                // Guarda el Animal_for_user en la base de datos
                animal_manejo_service.saveAnimalManejo(animal_manejo);

                return "redirect:/mostrar-manejo-tabla";
            } catch (Exception e) {
                return "Error en :" + e.getMessage();
            }
        }

*/



@PostMapping("/registrar-manejo")
public String guardarDato(@ModelAttribute("animal_manejo") Animal_manejo animal_manejo, Principal principal, Model model) {
    try {
        // Intenta guardar el Animal_celo en la base de datos
        Animal_manejo savedAnimal = animal_manejo_service.saveAnimalManejo(animal_manejo);

        if (savedAnimal == null) {
            // Si savedAnimal es null, significa que el DNI ya está registrado
            // Agrega un mensaje de error al modelo para mostrarlo en la vista
            model.addAttribute("error", "El DNI ya está registrado.");
            // Devuelve la vista con un mensaje de error
            return "animal_no_encontrado";
        }

        // Si el animal se guarda correctamente, redirecciona a la tabla correspondiente
        return "redirect:/mostrar-manejo-tabla";
    } catch (Exception e) {
        // Si ocurre una excepción, muestra un mensaje de error genérico
        model.addAttribute("error", "Error en: " + e.getMessage());
        // Devuelve la vista con un mensaje de error
        return "animal_no_encontrado";
    }
}





    @GetMapping("/animal_manejo/editar/{dni}")
    public String mostrarFormularioEditarAnimalManejo(@PathVariable Long dni, Model model) {
        Animal_manejo animal = animal_manejo_service.buscarPorDni(dni);
    
        if (animal != null) {
            model.addAttribute("animal", animal);
            return "modificar-manejo"; // Vista para modificar Animal_monta
        } else {
            return "animal_no_encontrado"; // Manejo cuando no se encuentra el animal
        }
    }
    
    @PostMapping("/animal_manejo/modificar/{dni}")
    public String modificarAnimalManejo(@PathVariable Long dni, @ModelAttribute Animal_manejo animalManejo) {
        Animal_manejo animalExistente = animal_manejo_service.buscarPorDni(dni);
    
        if (animalExistente != null) {
            // Verifica si el animalExistente es el mismo que se está modificando
            if (animalExistente.getId().equals(animalManejo.getId())) {
                // Actualiza los atributos del animalExistente con los datos del animalMonta
                 animalExistente.setDni(animalManejo.getDni());
                animalExistente.setFechaInicio(animalManejo.getFechaInicio());
                animalExistente.setFechaFin(animalManejo.getFechaFin());
                 
               
    
                animal_manejo_service.saveAnimalManejo(animalExistente);
                return "redirect:/mostrar-manejo-tabla"; // Redireccionar a la tabla de Animal_monta
            } else {
                // Ya hay otro Animal_monta con el mismo DNI, manejar el error
                return "animal_no_encontrado";
            }
        } else {
            // El Animal_monta no existe, mostrar un mensaje de error o redireccionar a una página de error
            return "animal_no_encontrado";
        }
    }





}
