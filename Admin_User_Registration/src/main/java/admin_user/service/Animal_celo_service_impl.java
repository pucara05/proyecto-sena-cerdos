package admin_user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.asm.Advice.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import admin_user.dto.AnimalCeloDTO;
import admin_user.model.Animal_celo;
import admin_user.model.Animal_for_user;
import admin_user.repositories.Animal_celo_repository;
import admin_user.repositories.Animal_for_user_repository;

@Service
public class Animal_celo_service_impl implements Animal_celo_service {

    private final Animal_celo_repository animal_celo_repository;
   private final Animal_for_user_repository animal_for_user_repository;

   @Autowired
   private ModelMapper modelMapper;


     @Autowired
    public Animal_celo_service_impl(Animal_celo_repository animal_celo_repository, Animal_for_user_repository animal_for_user_repository) {
        this.animal_celo_repository = animal_celo_repository;
        this.animal_for_user_repository = animal_for_user_repository;
    }
    

     @Override
    public List<AnimalCeloDTO> getAllAnimalCeloDTO() {
        List<Animal_celo> animalCeloList = animal_celo_repository.findAll();
        return animalCeloList.stream()
                .map(animalCelo -> modelMapper.map(animalCelo, AnimalCeloDTO.class))
                .collect(Collectors.toList());
    }


   

    



    @Override
    public List<Animal_celo> getAllAnimalCelo() {
        return animal_celo_repository.findAll();
    }

  /*  @Override
    public Animal_celo saveAnimalCelo(Animal_celo animal) {
        return animal_celo_repository.save(animal);
    }
    */


    @Override
    public Animal_celo saveAnimalCelo(Animal_celo animal) {
        Long dni = animal.getDni();
    
        // Verificar si el DNI ya existe en la base de datos
        Animal_celo existingAnimal = animal_celo_repository.findByDni(dni);
        if (existingAnimal != null) {
            // Si ya existe un animal con el mismo DNI, muestra un mensaje o realiza alguna acción
            // Aquí puedes imprimir un mensaje en la consola, loggear un mensaje, o realizar otra acción que desees
            System.out.println("El DNI ya está registrado.");
    
            // En este ejemplo, se devuelve null para indicar que no se ha guardado el animal
            return null;
        }
    
        // Si el DNI no existe, se guarda el animal y se devuelve
        return animal_celo_repository.save(animal);
    }
    
    @Override
    public void deleteAnimalCelo(Long id) {
        animal_celo_repository.deleteById(id);
    }

    @Override
    public Animal_celo obtenerAnimalCeloPorId(Long id) {
        return animal_celo_repository.findById(id).orElse(null);
    }


    //metodo para buscar por id
    @Override
    public AnimalCeloDTO obtenerAnimalId(Long id) {
        Animal_celo animalCelo = animal_celo_repository.findById(id).orElse(null);
        if (animalCelo != null) {
            return modelMapper.map(animalCelo, AnimalCeloDTO.class);
        }
        return null; // O puedes lanzar una excepción o devolver un DTO vacío según tu lógica
    }
    






   @Override
    public Animal_celo obtenerAnimalCeloPorDni(Long dni) {
        // Implementa la lógica para buscar por DNI
      
        if (dni!= null) {
            return  animal_celo_repository.findByDni(dni);
       
    }return null;
}


//sirve metodo para buscar por id 
/*@Override
public Animal_celo obtenerAnimalPorId(Long id) {
    return animal_celo_repository.findById(id).orElse(null);
}
*/
//metodo personalizado para buscar por id 


/* 
@Override
    public Animal_celo updateAnimalCeloFromDTO(AnimalCeloDTO animalDTO) {
        if (animalDTO != null && animalDTO.getId() != null) {
            Animal_celo animal = animal_celo_repository.findById(animalDTO.getId())
                    .orElseThrow(() -> new IllegalArgumentException("Animal no encontrado"));

            modelMapper.map(animalDTO, animal);

            // Suponiendo que tienes una relación con el cerdo hembra en el DTO
            if (animalDTO.getCerdoHembraId() != null) {
                Animal_for_user cerdoHembra = new Animal_for_user();
                cerdoHembra.setId(animalDTO.getCerdoHembraId());
                // Puedes mapear más propiedades si es necesario para el cerdo hembra

                animal.setCerdoHembra(cerdoHembra);
            }

            return animal_celo_repository.save(animal);
        } else {
            throw new IllegalArgumentException("El ID del animal no puede ser nulo para actualizar.");
        }
    }
*/


public Animal_celo obtenerCeloPorDni(Long dni) {
    // Implementa la lógica para buscar un animal por su DNI en el repositorio
    return animal_celo_repository.findByDni(dni);
}


}
