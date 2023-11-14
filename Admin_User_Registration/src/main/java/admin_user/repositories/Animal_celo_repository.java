package admin_user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import admin_user.model.Animal_celo;


@Repository
public interface Animal_celo_repository  extends JpaRepository<Animal_celo,Long> {

   /*  @Query("SELECT a FROM Animal_celo a WHERE a.dni = :dni")
    public Animal_celo findByDni(Long dni);*/
    
}
