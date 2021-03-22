package com.adamhard.restapi.refractoring.controller;

import com.adamhard.restapi.refractoring.model.Employee;
import com.adamhard.restapi.refractoring.model.Office;
import com.adamhard.restapi.refractoring.repository.EmployeeRepository;
import com.adamhard.restapi.refractoring.repository.OfficeRepository;
import com.adamhard.restapi.refractoring.controller.errors.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class EmployeeController {

    private static final String CREATED = "created" ;
    private final EmployeeRepository employeeRepository;
    private final OfficeRepository officeRepository;

    public EmployeeController(EmployeeRepository employeeRepository, OfficeRepository officeRepository) {
        this.employeeRepository = employeeRepository;
        this.officeRepository = officeRepository;
    }

    @GetMapping("/employee/{employeeId}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Employee> getEmployees(@PathVariable Integer employeeId) {
        return this.employeeRepository.findById(employeeId);
    }

    @PostMapping("/employee/office/{officeId}")
    @ResponseStatus(HttpStatus.CREATED)
    public String createOrSaveEmployee(@PathVariable(value = "officeId") Integer officeId,
                                     @RequestBody Employee employee) throws ResourceNotFoundException {
        Office office = this.officeRepository.findById(officeId)
                .orElseThrow(() -> new ResourceNotFoundException("office id not found " + officeId));
        employee.setOffice(office);
        this.employeeRepository.save(employee);
        return CREATED;
    }


}
