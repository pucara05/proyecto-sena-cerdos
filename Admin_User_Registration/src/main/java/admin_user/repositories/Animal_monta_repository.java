package admin_user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import admin_user.model.Animal_monta;

@Repository
public interface Animal_monta_repository extends JpaRepository<Animal_monta, Long> {

    
    
}
