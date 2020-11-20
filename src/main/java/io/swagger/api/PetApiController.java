package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import io.swagger.model.Pet;
import io.swagger.service.PetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-18T10:50:13.013Z")

@Controller
public class PetApiController implements PetApi {

    private static final Logger log = LoggerFactory.getLogger(PetApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private PetService petService;

    @org.springframework.beans.factory.annotation.Autowired
    public PetApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Pet> addPet(
            @ApiParam(value = "Pet object that needs to be added to the store", required = true)
            @Valid @RequestBody
                    Pet pet) {
        String accept = request.getHeader("Accept");
        Pet res = petService.getPet(pet.getId());
        if (res != null)
            return new ResponseEntity<Pet>(HttpStatus.CONFLICT);
        return new ResponseEntity<Pet>(petService.createPet(pet), HttpStatus.OK);
    }

    public ResponseEntity<Pet> deletePet(
            @ApiParam(value = "Pet id to delete", required = true)
            @PathVariable("petId")
                    Long petId,
            @ApiParam(value = "")
            @RequestHeader(value = "api_key", required = false)
                    String apiKey) {
        String accept = request.getHeader("Accept");
        Pet pet = petService.getPet(petId);
        if (pet != null)
            return new ResponseEntity<Pet>(petService.deletePet(petId), HttpStatus.OK);
        return new ResponseEntity<Pet>(HttpStatus.NOT_FOUND);
    }


    public ResponseEntity<Pet> getPetById(
            @ApiParam(value = "ID of pet to return", required = true)
            @PathVariable("petId")
                    Long petId) {
        String accept = request.getHeader("Accept");
        Pet pet = petService.getPet(petId);
        if (pet != null)
            return new ResponseEntity<Pet>(petService.getPet(petId), HttpStatus.OK);
        return new ResponseEntity<Pet>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Pet> updatePet(
            @ApiParam(value = "Pet object that needs to be added to the store", required = true)
            @Valid @RequestBody
                    Pet pet) {
        String accept = request.getHeader("Accept");
        Pet res = petService.getPet(pet.getId());
        if (res !=null)
            return new ResponseEntity<Pet>(petService.updatePet(pet.getId(), pet), HttpStatus.OK);
        return new ResponseEntity<Pet>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Void> updatePetWithForm(
            @ApiParam(value = "ID of pet that needs to be updated", required = true)
            @PathVariable("petId")
                    Long petId,
            @ApiParam(value = "Updated name of the pet")
            @RequestParam(value = "name", required = false)
                    String name,
            @ApiParam(value = "Updated status of the pet")
            @RequestParam(value = "status", required = false)
                    String status) {
        String accept = request.getHeader("Accept");
        Pet pet = petService.getPet(petId);
        if (pet != null) {
            pet.setName(name);
            pet.setStatus(Pet.StatusEnum.fromValue(status));
            petService.updatePet(petId, pet);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

}
