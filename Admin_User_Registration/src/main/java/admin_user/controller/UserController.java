package admin_user.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import admin_user.dto.UserDto;
import admin_user.model.Animal_atencion_lechon;
import admin_user.model.User;
import admin_user.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	private UserService userService;
	
	//Controlador para visualizar la vista del formulario de registro 
	@GetMapping("/registration")
	public String getRegistrationPage(@ModelAttribute("user") UserDto userDto) {
		return "register";
	}
	
	@PostMapping("/registration")
	public String saveUser(@ModelAttribute("user") UserDto userDto, Model model) {
		userService.save(userDto);
		model.addAttribute("message", "Registered Successfuly!");
		return "register";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("user-page")
	public String userPage (Model model, Principal principal) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user", userDetails);
		return "index";
		//return "user";

	}
	
	@GetMapping("admin-page")
	public String adminPage (Model model, Principal principal) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user", userDetails);
		return "admin";
	}




	 // metodo para mostrar los datos en la tabla
    @GetMapping("/mostrar-user-tabla")
    public String mostrarDatosTabla(Model model) {
        // Obtener los datos que deseas mostrar en la tabla
        List<User> userList =  userService.getAllUser(); // Reemplaza obtenerDatos() con el
                                                                                  // método que obtiene los datos

        // Realizar alguna operación con los datos si es necesario
        // Por ejemplo, ordenarlos o filtrarlos

        // Agregar los datos al modelo para pasarlos a la vista
        model.addAttribute("animalUserList", userList);

        // Devolver la vista que mostrará los datos en la tabla
        return "admin"; // Reemplaza "tabla-datos" con el nombre de tu vista
    }







}
