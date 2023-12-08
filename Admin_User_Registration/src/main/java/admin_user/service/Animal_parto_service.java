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

/* 
      // Método para guardar un Animal_monta
    public Animal_parto saveAnimalParto(Animal_parto animalParto) {
        return animal_parto_repository.save(animalParto);
    }

*/


public Animal_parto saveAnimalParto(Animal_parto animal) {
    Long dni = animal.getDni();

    // Verificar si el DNI ya existe en la base de datos
    Animal_parto existingAnimal = animal_parto_repository.findByDni(dni);
    if (existingAnimal != null) {
        // Si ya existe un animal con el mismo DNI, muestra un mensaje o realiza alguna acción
        // Aquí puedes imprimir un mensaje en la consola, loggear un mensaje, o realizar otra acción que desees
        System.out.println("El DNI ya está registrado.");

        // En este ejemplo, se devuelve null para indicar que no se ha guardado el animal
        return null;
    }

    // Si el DNI no existe, se guarda el animal y se devuelve
    return animal_parto_repository.save(animal);
}







 

//metodo para listar en la tabla traer todos los datos de la entidad
public List< Animal_parto> getParto(){

    return animal_parto_repository.findAll();
}


 //metodo para buscar por dni
    public Animal_parto buscarPorDni(Long dni) {
        return animal_parto_repository.findByDni(dni);
    }



/*  //metodo para selecionar los dniPartos arreglar
  public List<String> obtenerdniParto() {
        return animal_parto_repository.obtenerdniParto(); // Método en tu repositorio para obtener los estados de salud
    }
    */


    public List<String> obtenerdniParto() {
        // Implementa la lógica para obtener los DNIs de partos
        // Supongamos que tienes un método en tu repositorio para obtener los DNIs de partos
        // Reemplaza 'getDniPartos()' con el método apropiado de tu repositorio
        List<String> dniPartos = animal_parto_repository.getDniPartos();
        return dniPartos;
    }
}
