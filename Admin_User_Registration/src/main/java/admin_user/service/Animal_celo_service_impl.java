package admin_user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import admin_user.model.Animal_celo;
import admin_user.repositories.Animal_celo_repository;

@Service
public class Animal_celo_service_impl implements Animal_celo_service {

    private final Animal_celo_repository animal_celo_repository;


     @Autowired
    public Animal_celo_service_impl(Animal_celo_repository animal_celo_repository) {
        this.animal_celo_repository = animal_celo_repository;
    }
    
    @Override
    public List<Animal_celo> getAllAnimalCelo() {
        return animal_celo_repository.findAll();
    }

    @Override
    public void saveAnimalCelo(Animal_celo animal) {
        animal_celo_repository.save(animal);
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
}
