package io.swagger.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import io.swagger.model.Pet;

@Repository
public interface PetRepository extends MongoRepository<Pet,Long>{

}