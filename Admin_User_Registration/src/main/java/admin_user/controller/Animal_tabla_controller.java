package admin_user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import admin_user.model.Animal_for_user;
import admin_user.model.CerdoRegistro;
import admin_user.service.Animal_for_user_service;

@Controller
public class Animal_tabla_controller {
    private final Animal_for_user_service animal_for_user_service;

    @Autowired
    public Animal_tabla_controller(Animal_for_user_service animal_for_user_service) {

        this.animal_for_user_service = animal_for_user_service;
    }

 //metodo para mostrar tabla  sirve 
        @GetMapping("/tabla-animal-for-user")
    public String mostrarDatos(Model model){

        try {
            List<Animal_for_user> animal = animal_for_user_service.getAllAnimalForUser();
            model.addAttribute("animal" ,animal);

            return "tabla-animal-for-user";
        }
        catch(  Exception e) {
            return " Error al mostrar la lista " + e.getMessage();
        }


    }

  



   
    /* 

     @GetMapping("/tabla-animales")
    public String buscarPorId(@RequestParam Long id, Model model) {
        Optional<Animal_for_user> productoOptional = animal_for_user_service.buscarPorId(id);

        if (productoOptional.isPresent()) {
            model.addAttribute("productoEncontrado", productoOptional.get());
        } else {
            model.addAttribute("mensaje", "No se encontró ningún producto con el ID proporcionado.");
        }

        return "redirect:/tabla-animal-for-user"; // Debes crear una vista llamada "resultados.html"
    }
    */












    

//metodo para buscar por id con el archivo js buscarpor id
/* 
@GetMapping("/tabla-animales/{id}")
@ResponseBody
public String buscarPorId(@PathVariable Long id) {
    try {
        Animal_for_user animal = animal_for_user_service.buscarPorId(id);

        if (animal != null) {
            return "Animal encontrado: " + animal.toString();
        } else {
            return "Animal no encontrado";
        }
    } catch (Exception e) {
        return "Error: " + e.getMessage();
    }
}
*/





}