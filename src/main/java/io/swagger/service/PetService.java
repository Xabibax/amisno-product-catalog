package io.swagger.service;

import io.swagger.model.Pet;

import java.util.List;

public interface PetService {
    Pet createPet(Pet pet);
    Pet updatePet(Long id, Pet pet);
    Pet deletePet(Long id);
    Pet getPet(Long id);
    List<Pet> listPets();
    
}