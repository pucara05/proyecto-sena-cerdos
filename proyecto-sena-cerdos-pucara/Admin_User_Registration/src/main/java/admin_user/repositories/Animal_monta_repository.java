package admin_user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import admin_user.model.Animal_monta;

@Repository
public interface Animal_monta_repository extends JpaRepository<Animal_monta, Long> {

    //metodo para buscar por dni
      @Query("SELECT a FROM Animal_monta a WHERE a.dni = :dni")
    public Animal_monta findByDni(Long dni);
    
    
}
