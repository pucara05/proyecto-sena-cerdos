package admin_user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import admin_user.model.CerdoRegistro;
import admin_user.service.CerdoRegistroService;
import java.util.List;

@Controller
public class TablaCerdoController {


private final CerdoRegistroService cerdoRegistroService;

@Autowired
public TablaCerdoController(CerdoRegistroService cerdoRegistroService){
    this.cerdoRegistroService = cerdoRegistroService;
}


     /*  este metodo sirve para mostrar la tabla 2
      @GetMapping("/tabla-cerdo")
    public String tablaCerdo(@ModelAttribute("cerdoRegistroDto") CerdoRegistroDto cerdoRegistroDto){
        try{
        return "tabla-cerdo";
        }catch(Exception e){
            return "Error en " + e.getMessage();
        }
    }

    */
    







// este metodo tambien sirve para mostrar usando 1
     @GetMapping("/tabla-cerdo")
    public String mostrarDatos(Model model){

        try {
            List<CerdoRegistro> datos = cerdoRegistroService.obtenerTodosLosUsuarios();
            model.addAttribute("datas" ,datos);

            return "tabla-cerdo";
        }
        catch(  Exception e) {
            return " Error al mostrar la lista " + e.getMessage();
        }


    }
    


    //metodo para buscar por id 100% funcional
    @GetMapping("/buscar-por-id")
    public String buscarAnimalPorId(@RequestParam(required = false) Long id, Model model) {
        if (id != null) {
            CerdoRegistro animal = cerdoRegistroService.obtenerAnimalPorId(id);
        
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
    
    
    


   


}
    


