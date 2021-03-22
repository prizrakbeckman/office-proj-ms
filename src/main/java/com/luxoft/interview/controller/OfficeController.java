package com.luxoft.interview.controller;


import com.luxoft.interview.controller.errors.ResourceNotFoundException;
import com.luxoft.interview.model.Office;
import com.luxoft.interview.repository.OfficeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OfficeController {

    private final OfficeRepository officeRepository;

    public OfficeController(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    @GetMapping("/offices")
    @ResponseStatus(HttpStatus.OK)
    public List<Office> retrieveOffices() {
        return this.officeRepository.findAll();
    }


    @PostMapping("/office")
    @ResponseStatus(HttpStatus.CREATED)
    public String createOffice(@RequestBody Office office) {
        this.officeRepository.save(office);
        return "created";
    }

    @PutMapping("/office/update/{officeId}")
    @ResponseStatus(HttpStatus.OK)
    public String updateOffice(@PathVariable(value = "officeId") Integer officeId,
                             @RequestBody Office office)
            throws ResourceNotFoundException {
        Office officeToBeUpdated = this.officeRepository.findById(officeId)
                .orElseThrow(() -> new ResourceNotFoundException("Office not found :: " + officeId));
        this.officeRepository.save(officeToBeUpdated);
        return "updated";
    }


}
