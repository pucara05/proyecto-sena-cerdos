package admin_user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import admin_user.dto.UserDto;
import admin_user.model.Animal_for_user;
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
		User user = new User(userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()) , userDto.getRole(), userDto.getFullname());
		return userRepository.save(user);
	}


	public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

@Override
 public List<User>getAllUser(){
    return userRepository.findAll();
}


@Override
public void deleteUser(Long id) {
    userRepository.deleteById(id);
}


	

}
