package admin_user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import admin_user.model.Animal_celo;
import admin_user.service.Animal_celo_service;

@Controller
public class Animal_celo_controller {

private final Animal_celo_service animal_celo_service;

@Autowired
public Animal_celo_controller(Animal_celo_service animal_celo_service){
    this.animal_celo_service = animal_celo_service;
}


@GetMapping("/celo-registro")
    public String viewCelo(@ModelAttribute("animal_celo")Animal_celo animal_celo){
        try {

            return "celo-registro";
        }
        catch (Exception e) {


            return "Error en cargar la pagina " + e.getMessage();
        }

    }

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



    
}
