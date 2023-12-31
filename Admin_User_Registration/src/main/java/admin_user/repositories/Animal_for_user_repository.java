package admin_user.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import admin_user.model.Animal_for_user;

@Repository
public interface Animal_for_user_repository  extends JpaRepository <Animal_for_user,Long>{

    //metodo buscar animal por dni sirve comentado para implementar otro  es un metodo personalizado
    //ya que no existe algun metodo con este name  findByDni
     @Query("SELECT a FROM Animal_for_user a WHERE a.dni = :dni")
    public Animal_for_user findByDni(Long dni);
    
}
