package admin_user.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import admin_user.model.Animal_parto;
import admin_user.model.Animal_preparto;

@Repository
public interface Animal_parto_repository  extends JpaRepository <Animal_parto,Long>{

   
  //metodo para buscar por dni
      @Query("SELECT a FROM Animal_parto a WHERE a.dni = :dni")
    public Animal_parto findByDni(Long dni);


      // @Query("SELECT  a.dniParto FROM Animal_parto a") // Query para obtener estados de salud sin duplicados
   // List<String> obtenerdniParto();
    
    
}
