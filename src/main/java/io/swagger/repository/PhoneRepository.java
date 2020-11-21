package io.swagger.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import io.swagger.model.Phone;

@Repository
public interface PhoneRepository extends MongoRepository<Phone,Long>{
}