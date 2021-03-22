package com.adamhard.restapi.refractoring.service;

import com.adamhard.restapi.refractoring.model.Employee;
import com.adamhard.restapi.refractoring.model.Office;
import com.adamhard.restapi.refractoring.service.exception.EmployeeNotFoundException;
import com.adamhard.restapi.refractoring.service.exception.OfficeNotFoundException;
import com.adamhard.restapi.refractoring.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Test
    void whenRetrieveEmployeeByIdReturnEmployeeModel() {
        when(this.employeeService.getEmployees()).thenReturn(createEmployees());
    }

    @Test
    void shouldAddNewEmployeeWithNoExceptionThrown() throws EmployeeNotFoundException,OfficeNotFoundException {
        this.employeeService.saveUpdateEmployee(getEmployee(1,1));
    }

    @Test
    void shouldNotFindEmployeeAndReturnEmployeeNotFoundException(){

        assertThrows(EmployeeNotFoundException.class,this::saveEmployee);
    }

    @Test
    void whenCreatingEmployeeNoExceptionThrown() {
        assertThrows(OfficeNotFoundException.class, this::whenFetchingEmployee);
    }

    private void saveEmployee() throws EmployeeNotFoundException, OfficeNotFoundException {
        this.employeeService.saveUpdateEmployee(getEmployee(1,1));
    }

    private void whenFetchingEmployee() throws OfficeNotFoundException, EmployeeNotFoundException {
        this.employeeService.saveUpdateEmployee(getEmployeeWithException());
    }

    private List<Employee> createEmployees() {
        return Arrays.asList(getEmployee(1, 1), getEmployee(2, 1));
    }

    private Employee getEmployee(Integer emploeeId, Integer officeId) {
        Employee e = new Employee();
        Office o = new Office();
        o.setId(officeId);
        o.setCity("Warszawa");
        o.setName("Poslki Buro");

        e.setId(emploeeId);
        e.setName("Pawel Yablonovic");
        e.setOffice(o);
        e.setCity("Warszawa");
        e.setCountry("Polska");

        return e;
    }

    private Employee getEmployeeWithException() {
        Employee e = new Employee();
        e.setId(16);
        e.setName("Pawel Yablonovic");
        e.setCity("Warszawa");
        e.setCountry("Polska");
        return e;
    }
}
