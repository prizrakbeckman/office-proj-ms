package com.adamhard.restapi.refractoring.service;

import com.adamhard.restapi.refractoring.model.Employee;
import com.adamhard.restapi.refractoring.service.exception.EmployeeNotFoundException;
import com.adamhard.restapi.refractoring.service.exception.OfficeNotFoundException;

import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployees();

    void saveUpdateEmployee(Employee employee) throws OfficeNotFoundException, EmployeeNotFoundException;

}
