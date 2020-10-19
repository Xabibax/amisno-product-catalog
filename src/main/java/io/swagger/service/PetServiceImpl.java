package io.swagger.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.swagger.model.Pet;
import io.swagger.repository.PetRepository;

@Service
public class PetServiceImpl implements PetService {

@Autowired
private PetRepository petRepository;@SuppressWarnings("finally")
private Pet findOne(Long Id) { Pet instance = null;
  try {
    List < Pet > petList = petRepository.findAll();
    for (Pet pet: petList) {
      if (pet.getId().equals(Id)) {
        instance = pet;
        break;
      }
    }
  } catch(Exception e) {
    e.printStackTrace();
  } finally {
    return instance;
  }
}
 
@Override
public Pet createPet(Pet pet) {
  return petRepository.save(pet);
}

@Override
public List < Pet > listPets() {
  return petRepository.findAll();
}

@Override
public Pet updatePet(Long id, Pet pet) {
  Pet updateInstance = this.findOne(id);
  updateInstance.setName(pet.getName());
  return petRepository.save(updateInstance);
}

@Override
public Pet deletePet(Long id) {
  Pet instance = findOne(id);
  petRepository.delete(instance);
  return instance;
}

@Override
public Pet getPet(Long id) {//return petRepository.findById(id).get();
  return this.findOne(id);
}}