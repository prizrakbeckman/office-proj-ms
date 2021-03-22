package com.adamhard.restapi.refractoring.service;

import com.adamhard.restapi.refractoring.model.Office;
import com.adamhard.restapi.refractoring.service.exception.OfficeNotFoundException;

import java.util.List;
import java.util.Optional;

public interface OfficeService {

    Optional<Office> getByid(Integer officeId);

    List<Office> getOffices();

    void createOffice(Office office);

    void updateOffice(Integer officeId) throws OfficeNotFoundException;


}
