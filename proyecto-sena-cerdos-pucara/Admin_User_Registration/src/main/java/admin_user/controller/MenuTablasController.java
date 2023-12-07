package admin_user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuTablasController {

    //vista menu de las tablas
    @GetMapping("/menu-tablas")
    public String menuTablas(){
        return "menu-tablas";
    }

}
