package admin_user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import admin_user.model.Animal_celo;
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
   
 

    /*  // Método para guardar un Animal_monta
    public Animal_monta saveAnimalMonta(Animal_monta animalMonta) {
        return animal_monta_repository.save(animalMonta);
    }

*/


    public Animal_monta saveAnimalMonta(Animal_monta animal) {
        Long dni = animal.getDni();
    
        // Verificar si el DNI ya existe en la base de datos
        Animal_monta existingAnimal = animal_monta_repository.findByDni(dni);
        if (existingAnimal != null) {
            // Si ya existe un animal con el mismo DNI, muestra un mensaje o realiza alguna acción
            // Aquí puedes imprimir un mensaje en la consola, loggear un mensaje, o realizar otra acción que desees
            System.out.println("El DNI ya está registrado.");
    
            // En este ejemplo, se devuelve null para indicar que no se ha guardado el animal
            return null;
        }
    
        // Si el DNI no existe, se guarda el animal y se devuelve
        return animal_monta_repository.save(animal);
    }





    // Método para obtener los datos desde el repositorio y mostrarlos en la tabla
    public List<Animal_monta> obtenerDatos() {
        return animal_monta_repository.findAll();
    }

  
    //metodo para buscar por dni
    public Animal_monta buscarPorDni(Long dni) {
        return animal_monta_repository.findByDni(dni);
    }



}
