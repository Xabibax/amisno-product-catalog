package io.swagger.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import io.swagger.api.PhoneApi;
import io.swagger.model.Phone;
import io.swagger.service.PhoneService;
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

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-18T10:50:13.013Z")

@Controller
public class PhoneApiController implements PhoneApi {

    private static final Logger log = LoggerFactory.getLogger(PhoneApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private PhoneService phoneService;

    @org.springframework.beans.factory.annotation.Autowired
    public PhoneApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Phone> addPhone(
            @ApiParam(value = "Phone object that needs to be added to the store", required = true)
            @Valid @RequestBody
                    Phone phone) {
        String accept = request.getHeader("Accept");
        Phone res = phoneService.getPhone(phone.getId());
        if (res != null)
            return new ResponseEntity<Phone>(HttpStatus.CONFLICT);
        return new ResponseEntity<Phone>(phoneService.createPhone(phone), HttpStatus.OK);
    }

    public ResponseEntity<Phone> deletePhone(
            @ApiParam(value = "Phone id to delete", required = true)
            @PathVariable("phoneId")
                    Long phoneId,
            @ApiParam(value = "")
            @RequestHeader(value = "api_key", required = false)
                    String apiKey) {
        String accept = request.getHeader("Accept");
        Phone phone = phoneService.getPhone(phoneId);
        if (phone != null)
            return new ResponseEntity<Phone>(phoneService.deletePhone(phoneId), HttpStatus.OK);
        return new ResponseEntity<Phone>(HttpStatus.NOT_FOUND);
    }


    public ResponseEntity<Phone> getPhoneById(
            @ApiParam(value = "ID of phone to return", required = true)
            @PathVariable("phoneId")
                    Long phoneId) {
        String accept = request.getHeader("Accept");
        Phone phone = phoneService.getPhone(phoneId);
        if (phone != null)
            return new ResponseEntity<Phone>(phoneService.getPhone(phoneId), HttpStatus.OK);
        return new ResponseEntity<Phone>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Phone> updatePhone(
            @ApiParam(value = "Phone object that needs to be added to the store", required = true)
            @Valid @RequestBody
                    Phone phone) {
        String accept = request.getHeader("Accept");
        Phone res = phoneService.getPhone(phone.getId());
        if (res != null)
            return new ResponseEntity<Phone>(phoneService.updatePhone(phone.getId(), phone), HttpStatus.OK);
        return new ResponseEntity<Phone>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Phone> updatePhoneWithForm(
            @ApiParam(value = "ID of phone that needs to be updated", required = true)
            @PathVariable("phoneId")
                    Long phoneId,
            @ApiParam(value = "Updated name of the phone")
            @RequestParam(value = "name", required = false)
                    String name,
            @ApiParam(value = "Updated name of the phone")
            @RequestParam(value = "status", required = false)
                    String status,
            @ApiParam(value = "Updated status of the phone")
            @RequestParam(value = "price", required = false)
                    Float price,
            @ApiParam(value = "Updated status of the phone")
            @RequestParam(value = "img", required = false)
                    String img) {
        String accept = request.getHeader("Accept");
        Phone phone = phoneService.getPhone(phoneId);
        if (phone != null) {
            if (name == null) name = phone.getName();
            if (price == null) price = phone.getPrice();
            if (img == null) img = phone.getImg();
            if (status == null) status = phone.getStatus().toString();
            phone
                    .name(name)
                    .price(price)
                    .img(img)
                    .status(Phone.StatusEnum.fromValue(status));
            phoneService.updatePhone(phoneId, phone);
            return new ResponseEntity<Phone>(phone,HttpStatus.OK);
        }
        return new ResponseEntity<Phone>(HttpStatus.NOT_FOUND);
    }

}
