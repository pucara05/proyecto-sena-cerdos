package admin_user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import admin_user.model.Animal_manejo;
import admin_user.model.Animal_parto;
import admin_user.repositories.Animal_for_user_repository;
import admin_user.repositories.Animal_manejo_repository;
import admin_user.repositories.Animal_parto_repository;

@Service
public class Animal_manejo_service {


     private final Animal_manejo_repository animal_manejo_repository;
    private final Animal_parto_repository animal_parto_repository;
    
      @Autowired
    public Animal_manejo_service(Animal_parto_repository animal_parto_repository, Animal_manejo_repository animal_manejo_repository) {
        this.animal_parto_repository = animal_parto_repository;
        this.animal_manejo_repository = animal_manejo_repository;
    }


      // Método para guardar un Animal_manejo
    public Animal_manejo saveAnimalManejo(Animal_manejo animalManejo) {
        return animal_manejo_repository.save(animalManejo);
    }



 

//metodo para listar en la tabla traer todos los datos de la entidad
public List< Animal_manejo> getManejo(){

    return animal_manejo_repository.findAll();
}


 //metodo para buscar por dni
    public Animal_manejo buscarPorDni(Long dni) {
        return animal_manejo_repository.findByDni(dni);
    }

    public List<String> obtenerEstadoManejo() {
        return animal_manejo_repository.obtenerEstadoManejo(); // Método en tu repositorio para obtener los estados de salud
    }



}
