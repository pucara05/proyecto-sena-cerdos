package admin_user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import admin_user.model.Animal_atencion_lechon;
import admin_user.model.Animal_manejo;
import admin_user.repositories.Animal_atencion_lechon_repository;
import admin_user.repositories.Animal_manejo_repository;

@Service
public class Animal_atencion_lechon_service {

    private final Animal_atencion_lechon_repository animal_atencion_lechon_repository;
    private final Animal_manejo_repository animal_manejo_repository;

    @Autowired
    public Animal_atencion_lechon_service(Animal_atencion_lechon_repository animal_atencion_lechon_repository,
            Animal_manejo_repository animal_manejo_repository) {
        this.animal_atencion_lechon_repository = animal_atencion_lechon_repository;
        this.animal_manejo_repository = animal_manejo_repository;
    }

  /*   // Método para guardar un Animal_manejo
    public Animal_atencion_lechon saveAnimalAtencion(Animal_atencion_lechon animalAtencion) {
        return animal_atencion_lechon_repository.save(animalAtencion);
    }
*/


public Animal_atencion_lechon saveAnimalAtencion(Animal_atencion_lechon animal) {
    Long dni = animal.getDni();

    // Verificar si el DNI ya existe en la base de datos
    Animal_atencion_lechon existingAnimal = animal_atencion_lechon_repository.findByDni(dni);
    if (existingAnimal != null) {
        // Si ya existe un animal con el mismo DNI, muestra un mensaje o realiza alguna acción
        // Aquí puedes imprimir un mensaje en la consola, loggear un mensaje, o realizar otra acción que desees
        System.out.println("El DNI ya está registrado.");

        // En este ejemplo, se devuelve null para indicar que no se ha guardado el animal
        return null;
    }

    // Si el DNI no existe, se guarda el animal y se devuelve
    return animal_atencion_lechon_repository.save(animal);
}







    // metodo para listar en la tabla traer todos los datos de la entidad
    public List<Animal_atencion_lechon> getAtencion() {

        return animal_atencion_lechon_repository.findAll();
    }

    // metodo para buscar por dni
    public Animal_atencion_lechon buscarPorDni(Long dni) {
        return animal_atencion_lechon_repository.findByDni(dni);
    }



    public List<String> obtenerEstadoAtencion() {
        return animal_atencion_lechon_repository.obtenerEstadoAtencion(); // Método en tu repositorio para obtener los estados de salud
    }

    
}
