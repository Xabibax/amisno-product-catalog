package io.swagger.api;

import io.swagger.model.Phone;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import io.swagger.model.Phone;
import io.swagger.service.PhoneService;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-16T11:09:14.251Z[GMT]")
@RestController
public class V2ApiController implements V2Api {

    private static final Logger log = LoggerFactory.getLogger(V2ApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private PhoneService phoneService;

    @org.springframework.beans.factory.annotation.Autowired
    public V2ApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }


    public ResponseEntity<Phone> addPhone(@Parameter(in = ParameterIn.DEFAULT, description = "Phone object that needs to be added to the store", required=true, schema=@Schema()) @Valid @RequestBody Phone body) {
        String accept = request.getHeader("Accept");
        Phone res = phoneService.getPhone(body.getId());
        if (res != null)
            return new ResponseEntity<Phone>(HttpStatus.CONFLICT);
        return new ResponseEntity<Phone>(phoneService.createPhone(body), HttpStatus.OK);
    }

    public ResponseEntity<Phone> deletePhone(@Parameter(in = ParameterIn.PATH, description = "Phone id to delete", required=true, schema=@Schema()) @PathVariable("phoneId") Long phoneId,@Parameter(in = ParameterIn.HEADER, description = "api_key" ,schema=@Schema()) @RequestHeader(value="api_key", required=false) String apiKey) {
        String accept = request.getHeader("Accept");
        Phone phone = phoneService.getPhone(phoneId);
        if (phone != null)
            return new ResponseEntity<Phone>(phoneService.deletePhone(phoneId), HttpStatus.OK);
        return new ResponseEntity<Phone>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Phone> getPhoneById(@Parameter(in = ParameterIn.PATH, description = "ID of phone to return", required=true, schema=@Schema()) @PathVariable("phoneId") Long phoneId) {
        String accept = request.getHeader("Accept");
        Phone phone = phoneService.getPhone(phoneId);
        if (phone != null)
            return new ResponseEntity<Phone>(phoneService.getPhone(phoneId), HttpStatus.OK);
        return new ResponseEntity<Phone>(HttpStatus.NOT_FOUND);
  }

    public ResponseEntity<List<Phone>> listPhones() {
        String accept = request.getHeader("Accept");
        List<Phone> phones = phoneService.listPhones();
        return new ResponseEntity<List<Phone>>(phones, HttpStatus.OK);
    }

    public ResponseEntity<Phone> updatePhone(@Parameter(in = ParameterIn.DEFAULT, description = "Phone object that needs to be added to the store", required=true, schema=@Schema()) @Valid @RequestBody Phone body) {
        String accept = request.getHeader("Accept");
        Phone res = phoneService.getPhone(body.getId());
        if (res != null)
            return new ResponseEntity<Phone>(phoneService.updatePhone(body.getId(), body), HttpStatus.OK);
        return new ResponseEntity<Phone>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Phone> updatePhoneWithForm(
            @Parameter(in = ParameterIn.PATH,
                    description = "ID of phone that needs to be updated",
                    required=true,
                    schema=@Schema())
            @PathVariable("phoneId") Long phoneId) {
        return new ResponseEntity<Phone>(HttpStatus.NOT_IMPLEMENTED);
    }

}
