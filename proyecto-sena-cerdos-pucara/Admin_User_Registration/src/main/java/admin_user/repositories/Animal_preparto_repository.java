package admin_user.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import admin_user.model.Animal_gestacion;
import admin_user.model.Animal_preparto;

@Repository
public interface Animal_preparto_repository extends JpaRepository<Animal_preparto,Long> {
    
  //metodo para buscar por dni
      @Query("SELECT a FROM Animal_preparto a WHERE a.dni = :dni")
    public Animal_preparto findByDni(Long dni);


    @Query("SELECT DISTINCT a.estadoSalud FROM Animal_preparto a") // Query para obtener estados de salud sin duplicados
    List<String> obtenerEstadosSalud();

}
