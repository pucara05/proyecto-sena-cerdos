package admin_user.service;

import java.util.List;

import admin_user.dto.UserDto;
import admin_user.model.Animal_for_user;
import admin_user.model.User;



public interface UserService {
	
	User save (UserDto userDto);
	
	public User getUserByEmail(String email);
	//  User getUserByEmail(User user);


	
public List<User>getAllUser();
   

public void deleteUser(Long id) ;
  

}
