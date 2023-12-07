package admin_user.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import admin_user.model.Animal_for_user;
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

  






}