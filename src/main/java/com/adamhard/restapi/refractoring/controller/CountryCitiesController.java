package com.adamhard.restapi.refractoring.controller;

import com.adamhard.restapi.refractoring.model.Employee;
import com.adamhard.restapi.refractoring.model.Office;
import com.adamhard.restapi.refractoring.repository.EmployeeRepository;
import com.adamhard.restapi.refractoring.repository.OfficeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class CountryCitiesController {

    private final EmployeeRepository employeeRepository;
    private final OfficeRepository officeRepository;

    public CountryCitiesController(EmployeeRepository employeeRepository, OfficeRepository officeRepository) {
        this.employeeRepository = employeeRepository;
        this.officeRepository = officeRepository;
    }

    @GetMapping("employees/countries")
    @ResponseStatus(HttpStatus.OK)
    public Set<String> getCountries() {
        return this.employeeRepository.findAll()
                .stream().map(Employee::getCountry)
                .collect(Collectors.toSet());
    }

    @GetMapping("/cities")
    @ResponseStatus(HttpStatus.OK)
    public Set<String> getCities() {
        return this.officeRepository.findAll().stream()
                .map(Office::getCity)
                .collect(Collectors.toSet());
    }

}
