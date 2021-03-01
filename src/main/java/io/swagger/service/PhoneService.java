package io.swagger.service;

import io.swagger.model.Phone;

import java.util.List;

public interface PhoneService {
    Phone createPhone(Phone phone);
    Phone updatePhone(Long id, Phone phone);
    Phone deletePhone(Long id);
    Phone getPhone(Long id);
    List<Phone> listPhones();
    Void raiseError() throws Exception;
    
}