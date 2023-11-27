package admin_user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
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

    @Override
    public Animal_celo saveAnimalCelo(Animal_celo animal) {
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

    @Override
    public Animal_celo obtenerAnimalCeloPorDni(Long dni) {
        // Implementa la lógica para buscar por DNI
        // Por ejemplo: return animal_celo_repository.findByDni(dni);
        return null;
    }


//sirve metodo para buscar por id 
@Override
public Animal_celo obtenerAnimalPorId(Long id) {
    return animal_celo_repository.findById(id).orElse(null);
}


}
