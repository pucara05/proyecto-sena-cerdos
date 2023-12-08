package admin_user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import admin_user.model.Animal_atencion_lechon;
import admin_user.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
	User findByEmail (String email);


	 @Query("SELECT a FROM User a WHERE a.email = :email")
    public User findByEmailUser(String email);
}
