package admin_user.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import admin_user.model.Animal_gestacion;
import admin_user.model.Animal_monta;
import admin_user.model.Animal_preparto;
import admin_user.repositories.Animal_for_user_repository;
import admin_user.repositories.Animal_monta_repository;
import admin_user.repositories.Animal_preparto_repository;

@Service
public class Animal_preparto_service {

     private final Animal_for_user_repository animalForUserRepository;
    private final Animal_preparto_repository animal_preparto_repository;
    
      @Autowired
    public Animal_preparto_service(Animal_preparto_repository animal_preparto_repository, Animal_for_user_repository animal_for_user_repository) {
        this.animal_preparto_repository = animal_preparto_repository;
        this.animalForUserRepository = animal_for_user_repository;
    }



     // Método para guardar un Animal_monta
    public Animal_preparto saveAnimalPreparto(Animal_preparto animalPreparto) {
        return animal_preparto_repository.save(animalPreparto);
    }

//metodo para listar en la tabla traer todos los datos de la entidad
public List< Animal_preparto> getPreparto(){

    return animal_preparto_repository.findAll();
}


 //metodo para buscar por dni
    public Animal_preparto buscarPorDni(Long dni) {
        return animal_preparto_repository.findByDni(dni);
    }




    public List<String> obtenerEstadosSalud() {
        return animal_preparto_repository.obtenerEstadosSalud(); // Método en tu repositorio para obtener los estados de salud
    }


}
