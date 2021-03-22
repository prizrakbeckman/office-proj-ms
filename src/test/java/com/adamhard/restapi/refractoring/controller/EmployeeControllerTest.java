package com.adamhard.restapi.refractoring.controller;


import com.adamhard.restapi.refractoring.controller.errors.ResourceNotFoundException;
import com.adamhard.restapi.refractoring.model.Employee;
import com.adamhard.restapi.refractoring.model.Office;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {

    @InjectMocks
    private EmployeeController employeeController;

    Optional<Employee> result;

    @Test
    void shouldRenderListOfEmployeesWhenCallingEmployeeRestMethod() {
        when(this.employeeController.getEmployees(getId()))
                .thenReturn(getEmployee());
    }

    @Test
    void shouldRenderCreatedWhenCallingSaveCreateEmployeeMethod() throws ResourceNotFoundException {
        when(this.employeeController.createOrSaveEmployee(12, getEmployee().get())).thenReturn("created");
        String result = this.employeeController.createOrSaveEmployee(12, getEmployee().get());
        assertEquals("created", result);
    }

    @Test
    void shouldRenderResourceNotFoundExceptionWhenIdNotFound() {
        assertThrows(ResourceNotFoundException.class, this::whenFetchingEmployeeInController);
    }

    private void whenFetchingEmployeeInController() {
        this.result = this.employeeController.getEmployees(getNotFoundEmployee());
    }

    private Integer getId() {
        return 1;
    }

    private Integer getNotFoundEmployee() {
        return 10000000;
    }

    private Optional<Employee> getEmployee() {
        Employee e = new Employee();
        Office o = new Office();

        o.setId(1);
        o.setCity("Warszawa");
        o.setName("Poslki Buro");

        e.setOffice(o);
        e.setId(2);
        e.setName("Pawel Yablonovic");
        e.setCity("Warszawa");
        e.setCountry("Polska");

        return Optional.of(e);
    }


}
