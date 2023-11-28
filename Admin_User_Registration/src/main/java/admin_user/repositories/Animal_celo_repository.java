package admin_user.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import admin_user.model.Animal_celo;
import admin_user.model.Animal_for_user;



@Repository
public interface Animal_celo_repository  extends JpaRepository<Animal_celo,Long> {


  // @Query("SELECT a FROM Animal_celo a WHERE a.id = :id")
  // Animal_celo findByIdCustomQuery(@Param("id") long id);
   /*   @Query("SELECT a FROM Animal_celo a WHERE a.dni = :dniCerdoHembra")
    public Animal_celo findByDni(Long dni); */

      // Define el método para obtener DNIs de cerdos hembra por Animal_for_user y sexo
     // @Query("SELECT ac.dniCerdoHembra FROM Animal_celo ac WHERE ac.animal_for_user.sexo = :sexo AND ac.animal_for_user = :animalForUser")
     // List<Long> obtenerDnisCerdosHembraPorAnimalForUserAndSexo(@Param("animalForUser") Animal_for_user animalForUser, @Param("sexo") String sexo);
      
    

      // Método para obtener los DNIs de cerdos de sexo hembra desde la base de datos
   // @Query("SELECT ac.dniCerdoHembra FROM Animal_celo ac WHERE ac.sexo = 'hembra'")
    //List<Long> obtenerDnisCerdosHembraDeSexoHembra();

    
}
