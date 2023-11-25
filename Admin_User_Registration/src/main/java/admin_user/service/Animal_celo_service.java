package admin_user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import admin_user.model.Animal_celo;
import admin_user.model.Animal_for_user;


@Service
public interface Animal_celo_service {




//metodo para buscar todos los animales    
 //public Animal_for_user buscarPorId(Long id);

 //metodo para buscar todos los animales
 public List<Animal_celo>getAllAnimalCelo();
  
 //metodo para guardar animales
 public void saveAnimalCelo(Animal_celo animal);

//metodo para borrar animales
 public void deleteAnimalCelo(Long id) ;

//metodo para actualizar es el mismo que el de guardar solo con algunas modificaciones es el mismo que el de guardar
 //public void actualizarAnimalForUser(Animal_for_user animal_for_user) ; no se puede colocar 2 metodos de jpa iguales 
  
 
 //public Optional<Animal_for_user> buscarPorId(Long id) ; sirve
//metodo buscar por id si sirve 
 public Animal_celo obtenerAnimalCeloPorId(Long id) ;


//metodo para buscar animal por dni sirve 
 public Animal_celo obtenerAnimalCeloPorDni(Long dni);


  // Método para obtener los DNIs de cerdos hembra asociados con un Animal_for_user específico
 // public List<Long> obtenerDnisCerdosHembraPorAnimalForUser(Animal_for_user animalForUser) ;


 //public List<Long> obtenerDnisCerdosHembraPorAnimalForUserAndSexo(Animal_for_user animalForUser, String sexo);

   

  
    
}
