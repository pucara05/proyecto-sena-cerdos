package admin_user.controller;

import admin_user.dto.CerdoRegistroDto;
import admin_user.model.CerdoRegistro;
import admin_user.service.CerdoRegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;


@Controller
public class CerdoRegistroController {

   // private final CerdoRegistroService cerdoRegistroService;
/* 
    @Autowired
    public CerdoRegistroController(CerdoRegistroService cerdoRegistroService) {
        this.cerdoRegistroService = cerdoRegistroService;

    }
    */

//metodo para mostrar la lista en el formulario select
   /*  @GetMapping("/cerdo-registro")
    public String mostrarFormulario(Model model) {
        List<String> cerdos = Arrays.asList("Pietrain", "Duroc", "Landrace", "Hamp Shire","Large White");
        model.addAttribute("cerdos", cerdos);
        return "cerdo-registro";
    }

    */













    // Controlador para ver la vista del formulario 
    //este controlador para mostrar la vista sirve ya encontre el error y mi falla al entender a thymeleaf
    // el @ModelAtribute carga la vista usando a "cerdoRegistroDto" que puede tener cualquier nombre para luego usarlo
    //en el formulario de esta con la etiqueta de thymeleaf th:object="${cerdoRegistroDto}" asi se llama y luego
    //se carga el return "cerdo-registro" si no tiene el campo o tiene otro nombre tirara error 500 o dira que no se
    //deteto el controlador

    //*****************************************************************************
     /*  ESTE METODO SI SIRVE
   @GetMapping("/cerdo-registro")
    public String index(@ModelAttribute("cerdoRegistroDto")CerdoRegistroDto cerdoRegistroDto){
        try {

            return "cerdo-registro";
        }
        catch (Exception e) {


            return "Error en cargar la pagina " + e.getMessage();
        }

    }
    
*/

    //Controlador para registrar en el formulario   por arreglar
/*@PostMapping("/cerdo-registro")
    public String registroCerdos(@ModelAttribute("cerdoRegistroDto") CerdoRegistroDto cerdoRegistroDto, Model model){
        try{
        // Lógica para procesar el formulario y guardar el cerdo
      //CerdoRegistro cerdoRegistro= cerdoRegistroService.registarCerdo(cerdoRegistroDto);
      cerdoRegistroService.registarCerdo(cerdoRegistroDto);

        // Puedes agregar el cerdo a la vista para mostrarlo después de guardar
      model.addAttribute("message","Registro exitoso!");

      return "cerdo-registro";}
      catch(Exception e){
        return "Error en Registrar cerdo" + e.getMessage();
      }


      */



//************************************************************************** 

    /* Controlador sacado de otro proyecto mio tesCrud para guardar*/
    /*  ESTE METODO SI SIRVE 
     @PostMapping("/cerdo-registro")
    public String  guardarDato(@ModelAttribute CerdoRegistro cerdoRegistro){
        try {
        cerdoRegistroService.crearUsuario(cerdoRegistro);

            return "redirect:/tabla-cerdo";
        }catch (Exception e){
            return "Error en :" + e.getMessage();

        }
    }
    
     
*/

     







    



/* metodo 1
      @PostMapping("/cerdo-registro")
    public String saveUser(@ModelAttribute("cerdo-registro") CerdoRegistroDto cerdoRegistroDto, Model model) {
        cerdoRegistroService.save(cerdoRegistroDto);
        model.addAttribute("message", "Registered Successfuly!");
        return "cerdo-registro";
    }
 
    */

     

    
    
    /*   @GetMapping("/buscar-cerdo-nombre")
    public String buscarPorNombre(@RequestParam String nombre, Model model){
        try{
            List<CerdoRegistro> buscarCerdo = cerdoRegistroService.buscarPorNombre(nombre);
            model.addAttribute("cerdoRegistroDto", buscarCerdo);
            return  "cerdo-registro";

        }catch (Exception e){
            return "Error no se encontro cerdo";

        }

    }
 */








  /* metodo 2   @PostMapping("/registar-cerdo")
    public String registroCerdos(@ModelAttribute CerdoRegistroDto cerdoRegistroDto, Model model){
        // Lógica para procesar el formulario y guardar el cerdo
      CerdoRegistro cerdoRegistro= cerdoRegistroService.registarCerdo(cerdoRegistroDto);

        // Puedes agregar el cerdo a la vista para mostrarlo después de guardar
      model.addAttribute("cerdoRegistro",cerdoRegistro);

      return "cerdo-registro";


    }
    */

    









    

}
