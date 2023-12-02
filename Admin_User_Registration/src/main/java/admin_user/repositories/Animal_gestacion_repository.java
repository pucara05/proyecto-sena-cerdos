package admin_user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import admin_user.model.Animal_gestacion;
import admin_user.model.Animal_monta;

public interface Animal_gestacion_repository extends JpaRepository<Animal_gestacion,Long> {
    
      //metodo para buscar por dni
      @Query("SELECT a FROM Animal_gestacion a WHERE a.dni = :dni")
    public Animal_gestacion findByDni(Long dni);


}
