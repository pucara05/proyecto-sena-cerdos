package admin_user.repositories;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import admin_user.model.Animal_for_user;

@Repository
public interface Animal_for_user_repository  extends JpaRepository <Animal_for_user,Long>{

    //metodo buscar animal por dni sirve comentado para implementar otro  es un metodo personalizado
    //ya que no existe algun metodo con este name  findByDni
     @Query("SELECT a FROM Animal_for_user a WHERE a.dni = :dni")
    public Animal_for_user findByDni(Long dni);
    

//metodos querry para traer los datos y mostralos en el select en la vista registro-monta
 //querry para traer los datos de la base de datos que sean de sexo = hembra
    @Query("SELECT a FROM Animal_for_user a WHERE a.sexo = 'hembra'")
    List<Animal_for_user> findHembraAnimals();

 
    

 //querry para traer los datos de la base de datos que sean de sexo = macho
    // Método en el repositorio para obtener los DNIs de los cerdos macho
    @Query("SELECT a FROM Animal_for_user a WHERE a.sexo = 'macho'")
    List<Animal_for_user> findMachoAnimals();

     // Método para verificar si existe algún registro con el mismo DNI
     boolean existsByDni(Long dni);
  
}
