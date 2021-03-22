package com.luxoft.interview.service;

import com.luxoft.interview.model.Employee;
import com.luxoft.interview.service.exception.EmployeeNotFoundException;
import com.luxoft.interview.service.exception.OfficeNotFoundException;

import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployees();

    void saveUpdateEmployee(Employee employee) throws OfficeNotFoundException, EmployeeNotFoundException;

}
