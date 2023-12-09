package admin_user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import admin_user.dto.UserDto;
import admin_user.model.Animal_for_user;
import admin_user.model.Animal_monta;
import admin_user.model.User;
import admin_user.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;

	@Override
	public User save(UserDto userDto) {
		User user = new User(userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()), userDto.getRole(),
				userDto.getFullname());
		return userRepository.save(user);
	}

	@Override
	public User getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	

	@Override
	public User getUserByUser(String email) {
		return userRepository.findByEmailUser(email);
	}

	@Override
public User modifidUser(User user) {
    Long id = user.getId();

    // Verificar si el usuario existe en la base de datos
    User existingUser = userRepository.findByIdUser(id);
    if (existingUser != null) {
        // Modificar los campos necesarios del usuario existente con los valores del nuevo usuario
        existingUser.setPassword(user.getPassword());
        existingUser.setFullname(user.getFullname());
        // Puedes seguir con otros campos que desees modificar

        // Guardar y devolver el usuario actualizado en la base de datos
        return userRepository.save(existingUser);
    } else {
        // Si el usuario no existe, podrías lanzar una excepción, devolver un mensaje, o realizar otra acción
        // En este ejemplo, devolvemos null para indicar que el usuario no se ha modificado
        return null;
    }
}


public void eliminarUsuarioPorId(Long id) {
	userRepository.deleteById(id);
}



}
