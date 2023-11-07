package admin_user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {

    @GetMapping("/menu")
    public String mostrarMenu(){
        return "menu";
    }

    @GetMapping("/")
    public String paginaPrincipal() {
        return "index";
    }
}
