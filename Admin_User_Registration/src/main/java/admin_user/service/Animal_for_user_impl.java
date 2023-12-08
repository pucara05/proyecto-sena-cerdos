package admin_user.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import admin_user.model.Animal_for_user;
import admin_user.repositories.Animal_for_user_repository;

@Service    //clase que implementa de la interfas Animal_for_user_service y aqui dentro se inyecta el repositorio  Animal_for_user_repository
public class Animal_for_user_impl implements Animal_for_user_service {

      @Autowired
    Animal_for_user_repository animal_for_user_repository;


   //metodos para la logica del repositorio de buscar por sexo hembra y macho
   //para los selects en la vista registro-monta
//select mostrar hembras sirve 
  @Override
  public List<Animal_for_user> getHembraAnimals() {
    return animal_for_user_repository.findHembraAnimals();
}

 // Método para obtener los DNIs de los cerdos macho
 @Override
 public List<Animal_for_user> getMachoAnimals() {
    return animal_for_user_repository.findMachoAnimals();
}






    //metodo para buscar por id
   /*  @Override
    public Animal_for_user buscarPorId(Long id) {
        return animal_for_user_repository.findById(id).orElse(null);
}
*/

//metodo para buscar todos los animales para mostraslos en la tabla 
@Override
public List<Animal_for_user>getAllAnimalForUser(){
    return animal_for_user_repository.findAll();
}


//metodo para guardar animales
@Override
public void saveAnimal(Animal_for_user animal_for_user){
     animal_for_user_repository.save(animal_for_user);
    
}


@Override
public void deleteAnimalForUser(Long id) {
    animal_for_user_repository.deleteById(id);
}
  


//sirve metodo para buscar por id 
@Override
public Animal_for_user obtenerAnimalPorId(Long id) {
    return animal_for_user_repository.findById(id).orElse(null);
}



//metodo para buscar animal por dni sirve 
@Override
public Animal_for_user obtenerAnimalPorDni(Long dni) {
    return animal_for_user_repository.findByDni(dni);
}








/*public List<Long> obtenerDnisCerdosHembra() {
    return animal_for_user_repository.obtenerDnisCerdosHembra(); // Método que se conecta con el repositorio
}
*/






/*public List<Long> obtenerDnisCerdosHembraPorAnimalForUser(Animal_for_user animalForUser) {
    return animal_for_user_repository.obtenerDnisCerdosHembraPorAnimalForUser(animalForUser);
}
*/

@Override
public List<Animal_for_user> obtenerTodosLosAnimales() {
    return animal_for_user_repository.findAll();
}


@Override
public boolean dniExiste(Long dni) {
    // Verificar si el DNI existe en la base de datos
    return animal_for_user_repository.existsByDni(dni);
}

}
