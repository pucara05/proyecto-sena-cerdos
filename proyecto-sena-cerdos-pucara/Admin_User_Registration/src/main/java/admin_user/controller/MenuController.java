package admin_user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {

    //vista menu
    @GetMapping("/menu")
    public String mostrarMenu(){
        return "menu";
    }

    //vista inicio de la pagina
    @GetMapping("/")
    public String paginaPrincipal() {
        return "index";
    }
}
