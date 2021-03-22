package com.luxoft.interview.service.impl;

import com.luxoft.interview.model.Employee;
import com.luxoft.interview.repository.EmployeeRepository;
import com.luxoft.interview.service.CountriesCitiesService;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CountriesCitiesServiceImpl implements CountriesCitiesService {

    private final EmployeeRepository employeeRepository;

    CountriesCitiesServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Set<String> getAllCities() {
        return this.employeeRepository.findAll().stream()
                .map(Employee::getCountry)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getAllCountries() {
        return this.employeeRepository.findAll().stream()
                .map(Employee::getCity)
                .collect(Collectors.toSet());
    }



}
