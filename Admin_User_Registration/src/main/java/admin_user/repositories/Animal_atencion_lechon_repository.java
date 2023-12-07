package admin_user.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import admin_user.model.Animal_atencion_lechon;
import admin_user.model.Animal_manejo;

@Repository
public interface Animal_atencion_lechon_repository extends JpaRepository<Animal_atencion_lechon,Long> {

         
  //metodo para buscar por dni
      @Query("SELECT a FROM Animal_atencion_lechon a WHERE a.dni = :dni")
    public Animal_atencion_lechon findByDni(Long dni);



     @Query("SELECT DISTINCT a.tipoAtencion FROM Animal_atencion_lechon a") // Query para obtener estados de salud sin duplicados
    List<String> obtenerEstadoAtencion();


}
