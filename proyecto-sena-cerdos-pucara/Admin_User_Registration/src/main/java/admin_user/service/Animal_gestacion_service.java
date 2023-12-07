package admin_user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import admin_user.model.Animal_gestacion;
import admin_user.model.Animal_monta;
import admin_user.repositories.Animal_for_user_repository;
import admin_user.repositories.Animal_gestacion_repository;
import admin_user.repositories.Animal_monta_repository;

@Service
public class Animal_gestacion_service {
    
    private final Animal_for_user_repository animalForUserRepository;
    private final Animal_gestacion_repository animal_gestacion_repository;

    @Autowired
    public Animal_gestacion_service(Animal_gestacion_repository animal_gestacion_repository, Animal_for_user_repository animal_for_user_repository) {
        this.animal_gestacion_repository = animal_gestacion_repository;
        this.animalForUserRepository = animal_for_user_repository;
    }


     // Método para guardar un Animal_monta
    public Animal_gestacion saveAnimalGestacion(Animal_gestacion animalGestacion) {
        return animal_gestacion_repository.save(animalGestacion);
    }



    // Método para obtener los datos desde el repositorio y mostrarlos en la tabla
    public List<Animal_gestacion> obtenerGestacion() {
        return animal_gestacion_repository.findAll();
    }


    //metodo para buscar por dni
    public Animal_gestacion buscarPorDni(Long dni) {
        return animal_gestacion_repository.findByDni(dni);
    }







}
