package admin_user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import admin_user.model.Animal_parto;
import admin_user.model.Animal_preparto;
import admin_user.repositories.Animal_for_user_repository;
import admin_user.repositories.Animal_parto_repository;
import admin_user.repositories.Animal_preparto_repository;

@Service
public class Animal_parto_service {


     private final Animal_for_user_repository animalForUserRepository;
    private final Animal_parto_repository animal_parto_repository;
    
      @Autowired
    public Animal_parto_service(Animal_parto_repository animal_parto_repository, Animal_for_user_repository animal_for_user_repository) {
        this.animal_parto_repository = animal_parto_repository;
        this.animalForUserRepository = animal_for_user_repository;
    }


      // Método para guardar un Animal_monta
    public Animal_parto saveAnimalParto(Animal_parto animalParto) {
        return animal_parto_repository.save(animalParto);
    }



 

//metodo para listar en la tabla traer todos los datos de la entidad
public List< Animal_parto> getParto(){

    return animal_parto_repository.findAll();
}


 //metodo para buscar por dni
    public Animal_parto buscarPorDni(Long dni) {
        return animal_parto_repository.findByDni(dni);
    }




    
}
