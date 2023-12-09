package admin_user.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import admin_user.dto.UserDto;
import admin_user.model.Animal_atencion_lechon;
import admin_user.model.Animal_monta;
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




	/* si sirve buscar 
	@GetMapping("/buscar-por-correo-user")
public String buscarPorEmail(@RequestParam("email") String email, Model model) {
    User user = userService.getUserByEmail(email);

    if (user != null) {
        model.addAttribute("User", user);
    } else {
        model.addAttribute("mensaje", "Usuario no encontrado para el correo electrónico proporcionado.");
    }

    return "admin"; // Reemplaza con el nombre de tu vista
}
*/

@GetMapping("/buscar-por-correo-user")
public String buscarPorEmail(@RequestParam("email") String email, Model model) {
    User user = userService.getUserByEmail(email);

    if (user != null) {
        model.addAttribute("User", user);
        return "admin"; // Reemplaza con el nombre de tu vista
    } else {
        model.addAttribute("mensaje", "Usuario no encontrado para el correo electrónico proporcionado.");
        return "animal_no_encontrado"; // Reemplaza con el nombre de tu vista de error
    }
}



@GetMapping("/user/editar/{email}")
public String mostrarFormularioEditarAnimalMonta(@PathVariable String email, Model model) {
User animal = userService.getUserByEmail(email);

	if (animal != null) {
		model.addAttribute("animal", animal);
		return "modificar-user"; // Vista para modificar Animal_monta
	} else {
		return "animal_no_encontrado"; // Manejo cuando no se encuentra el animal
	}
}





    @PostMapping("/user/modificar/{email}")
    public String modificarUser(@PathVariable String email, @ModelAttribute User user) {
        User userExistente = userService.getUserByUser(email);
    
        if (userExistente != null) {
            // Verifica si el animalExistente es el mismo que se está modificando
            if (userExistente.getId().equals(user.getId())) {
                // Actualiza los atributos del animalExistente con los datos del animalMonta
                userExistente.setFullname(user.getFullname());
                userExistente.setPassword(user.getPassword());
                // Actualiza otros atributos según sea necesario
    
                userService.modifidUser(userExistente);
                return "redirect:/mostrar-user-tabla"; // Redireccionar a la tabla de Animal_monta
            } else {
                // Ya hay otro Animal_monta con el mismo DNI, manejar el error
                return "animal_no_encontrado";
            }
        } else {
            // El Animal_monta no existe, mostrar un mensaje de error o redireccionar a una página de error
            return "animal_no_encontrado";
        }
    }
    
/*  modificar nuevo por probar
	@PostMapping("/user/modificar/{email}")
	public String modificarUser(@PathVariable String email, @ModelAttribute User modifiedUser) {
		User userExistente = userService.getUserByUser(email);
	
		if (userExistente != null) {
			// Verificar si el email del usuario existente es el mismo que se está modificando
			if (userExistente.getEmail().equals(email)) {
				// Actualiza los atributos del usuario existente con los datos del usuario modificado
				userExistente.setFullname(modifiedUser.getFullname());
				userExistente.setPassword(modifiedUser.getPassword());
				// Actualiza otros atributos según sea necesario
	
				// Llama al servicio para modificar el usuario
				User usuarioModificado = userService.modifidUser(userExistente);
	
				if (usuarioModificado != null) {
					return "redirect:/mostrar-user-tabla"; // Redireccionar a la tabla de usuarios
				} else {
					// Manejar el caso en que no se pudo modificar el usuario
					return "error_modificacion_usuario";
				}
			} else {
				// Manejar el caso en que el email no coincide
				return "error_email_no_coincide";
			}
		} else {
			// Manejar el caso en que el usuario no existe
			return "usuario_no_encontrado";
		}
	}
	
*/
/* 
@DeleteMapping("/eliminar/{id}")
public String eliminarUsuario(@PathVariable Long id) {
	userService.eliminarUsuarioPorId(id);
	return "redirect:/mostrar-user-tabla"; // Redireccionar a la tabla de usuarios o a la página que desees
}
*/

@PostMapping("/eliminar")
public String eliminarUsuario(@RequestParam Long id) {
    userService.eliminarUsuarioPorId(id);
    return "redirect:/mostrar-user-tabla";
}


}
