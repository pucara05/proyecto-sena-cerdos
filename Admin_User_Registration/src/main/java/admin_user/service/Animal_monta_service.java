package admin_user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import admin_user.model.Animal_monta;
import admin_user.repositories.Animal_for_user_repository;
import admin_user.repositories.Animal_monta_repository;

@Service
public class Animal_monta_service {

    private final Animal_for_user_repository animalForUserRepository;
    private final Animal_monta_repository animal_monta_repository;

    @Autowired
    public Animal_monta_service(Animal_monta_repository animal_monta_repository, Animal_for_user_repository animal_for_user_repository) {
        this.animal_monta_repository = animal_monta_repository;
        this.animalForUserRepository = animal_for_user_repository;
    }
   
 

     // Método para guardar un Animal_monta
    public Animal_monta saveAnimalMonta(Animal_monta animalMonta) {
        return animal_monta_repository.save(animalMonta);
    }


  
    



}
