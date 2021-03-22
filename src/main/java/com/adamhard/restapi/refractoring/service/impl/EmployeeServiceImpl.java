package com.adamhard.restapi.refractoring.service.impl;

import com.adamhard.restapi.refractoring.model.Employee;
import com.adamhard.restapi.refractoring.repository.EmployeeRepository;
import com.adamhard.restapi.refractoring.repository.OfficeRepository;
import com.adamhard.restapi.refractoring.service.EmployeeService;
import com.adamhard.restapi.refractoring.service.exception.OfficeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final OfficeRepository officeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, OfficeRepository officeRepository) {
        this.employeeRepository = employeeRepository;
        this.officeRepository = officeRepository;
    }

    @Override
    public List<Employee> getEmployees() {
        return this.employeeRepository.findAll();
    }

    @Override
    public void saveUpdateEmployee(Employee employee) throws OfficeNotFoundException {
        if(employee.getOffice()==null)
            throw new OfficeNotFoundException("Office not found in employee");
        this.officeRepository.save(employee.getOffice());
        this.employeeRepository.save(employee);
    }
}
