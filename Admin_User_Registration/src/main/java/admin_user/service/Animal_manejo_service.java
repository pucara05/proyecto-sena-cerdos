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


    /*   // Método para guardar un Animal_manejo
    public Animal_manejo saveAnimalManejo(Animal_manejo animalManejo) {
        return animal_manejo_repository.save(animalManejo);
    }*/



public Animal_manejo saveAnimalManejo(Animal_manejo animal) {
    Long dni = animal.getDni();

    // Verificar si el DNI ya existe en la base de datos
    Animal_manejo existingAnimal = animal_manejo_repository.findByDni(dni);
    if (existingAnimal != null) {
        // Si ya existe un animal con el mismo DNI, muestra un mensaje o realiza alguna acción
        // Aquí puedes imprimir un mensaje en la consola, loggear un mensaje, o realizar otra acción que desees
        System.out.println("El DNI ya está registrado.");

        // En este ejemplo, se devuelve null para indicar que no se ha guardado el animal
        return null;
    }

    // Si el DNI no existe, se guarda el animal y se devuelve
    return animal_manejo_repository.save(animal);
}




 

//metodo para listar en la tabla traer todos los datos de la entidad
public List< Animal_manejo> getManejo(){

    return animal_manejo_repository.findAll();
}


 //metodo para buscar por dni
    public Animal_manejo buscarPorDni(Long dni) {
        return animal_manejo_repository.findByDni(dni);
    }


    public List<String> obtenerdniManejo() {
        // Implementa la lógica para obtener los DNIs de partos
        // Supongamos que tienes un método en tu repositorio para obtener los DNIs de partos
        // Reemplaza 'getDniPartos()' con el método apropiado de tu repositorio
        List<String> dniManejos = animal_manejo_repository.getDniManejos();
        return dniManejos;
    }
   



}
