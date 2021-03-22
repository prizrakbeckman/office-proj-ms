package com.luxoft.interview.service.impl;

import com.luxoft.interview.model.Office;
import com.luxoft.interview.repository.OfficeRepository;
import com.luxoft.interview.service.OfficeService;
import com.luxoft.interview.service.exception.OfficeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfficeServiceImpl implements OfficeService {

    private final OfficeRepository officeRepository;

    public OfficeServiceImpl(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    @Override
    public Optional<Office> getByid(Integer officeId){
        return this.officeRepository.findById(officeId);
    }

    @Override
    public List<Office> getOffices() {
        return this.officeRepository.findAll();
    }

    @Override
    public void createOffice(Office office) {
        this.officeRepository.save(office);
    }

    @Override
    public void updateOffice(Integer officeId) throws OfficeNotFoundException {
        if (!this.officeRepository.findById(officeId).isPresent()) {
            throw new OfficeNotFoundException("Office not found");
        }
    }
}
