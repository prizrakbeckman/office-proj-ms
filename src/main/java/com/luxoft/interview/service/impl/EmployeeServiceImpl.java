package com.luxoft.interview.service.impl;

import com.luxoft.interview.model.Employee;
import com.luxoft.interview.repository.EmployeeRepository;
import com.luxoft.interview.repository.OfficeRepository;
import com.luxoft.interview.service.EmployeeService;
import com.luxoft.interview.service.exception.EmployeeNotFoundException;
import com.luxoft.interview.service.exception.OfficeNotFoundException;
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
    public void saveUpdateEmployee(Employee employee) throws OfficeNotFoundException, EmployeeNotFoundException {
        if(employee.getOffice()==null)
            throw new OfficeNotFoundException("Office not found in employee");
        this.officeRepository.save(employee.getOffice());
        this.employeeRepository.save(employee);
    }
}
