package admin_user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import admin_user.model.Animal;
import admin_user.repositories.Animal_repository;

public class Animal_service {

    @Autowired
    Animal_repository animal_repository;



    //metodo para buscar por id
    public Animal getAnimalById(Long id){
return animal_repository.findById(id).orElse(null);

    }

    //metodo para buscar todos los animales
public List<Animal> getAllAnimals(){
    return animal_repository.findAll();
}






}