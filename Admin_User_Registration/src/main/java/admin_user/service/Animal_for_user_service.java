package admin_user.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import admin_user.model.Animal_for_user;



@Service
public interface Animal_for_user_service {


//metodo para buscar todos los animales    
 //public Animal_for_user buscarPorId(Long id);

 //metodo para buscar todos los animales
 public List<Animal_for_user>getAllAnimalForUser();
  
 //metodo para guardar animales
 public void saveAnimal(Animal_for_user animal);

//metodo para borrar animales
 public void deleteAnimalForUser(Long id) ;

//metodo para actualizar es el mismo que el de guardar solo con algunas modificaciones es el mismo que el de guardar
 //public void actualizarAnimalForUser(Animal_for_user animal_for_user) ; no se puede colocar 2 metodos de jpa iguales 
  
 
 //public Optional<Animal_for_user> buscarPorId(Long id) ; sirve
//metodo buscar por id si sirve 
 public Animal_for_user obtenerAnimalPorId(Long id) ;


//metodo para buscar animal por dni sirve 
 public Animal_for_user obtenerAnimalPorDni(Long dni);

}