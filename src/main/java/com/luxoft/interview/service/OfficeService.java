package com.luxoft.interview.service;

import com.luxoft.interview.model.Office;
import com.luxoft.interview.service.exception.OfficeNotFoundException;

import java.util.List;
import java.util.Optional;

public interface OfficeService {

    Optional<Office> getByid(Integer officeId);

    List<Office> getOffices();

    void createOffice(Office office);

    void updateOffice(Integer officeId) throws OfficeNotFoundException;


}
