package admin_user.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import admin_user.model.Animal_manejo;
import admin_user.model.Animal_parto;

@Repository
public interface Animal_manejo_repository extends JpaRepository<Animal_manejo,Long> {


      
  //metodo para buscar por dni
      @Query("SELECT a FROM Animal_manejo a WHERE a.dni = :dni")
    public Animal_manejo findByDni(Long dni);


   // Método para obtener los DNIs de partos
   @Query("SELECT ap.dni FROM Animal_manejo ap")
   List<String> getDniManejos();
  



}
