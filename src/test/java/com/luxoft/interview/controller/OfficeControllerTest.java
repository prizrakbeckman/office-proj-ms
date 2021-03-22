package com.luxoft.interview.controller;

import com.luxoft.interview.controller.errors.ResourceNotFoundException;
import com.luxoft.interview.model.Office;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OfficeControllerTest {

    private static final String CREATED = "created";
    private static final String UPDATED = "updated";
    @InjectMocks
    private OfficeController officeController;

    @Test
    void shouldRenderListOfOfficesWhenCallingEmployeeRestMethod() {
        when(this.officeController.retrieveOffices()).thenReturn(getOffices());
    }

    @Test
    void shouldCreateOfficeWhenCallingCreateOfficeMethod(){
        when(this.officeController.createOffice(getOffice(1))).thenReturn(CREATED);
        String result = this.officeController.createOffice(getOffice(1));
        assertEquals(CREATED, result);
    }

    @Test
    void shouldCreateOfficeWhenCallingUpdateOfficeMethod() throws ResourceNotFoundException {
        when(this.officeController.updateOffice(1,getOffice(1))).thenReturn(UPDATED);
        String result = this.officeController.updateOffice(1,getOffice(1));
        assertEquals(UPDATED, result);
    }

    @Test
    void shouldRenderResourceNotFoundExceptionWhenIdNotFound() {
        assertThrows(ResourceNotFoundException.class, this::whenFetchingOfficesInController);
    }

    private void whenFetchingOfficesInController() throws ResourceNotFoundException {
      if(this.officeController.retrieveOffices() == null)
          throw new ResourceNotFoundException("no office found");
    }

    private List<Office> getOffices() {
        return Arrays.asList(getOffice(1),getOffice(2));
    }

    private Office getOffice(Integer officeId){
        Office o = new Office();
        o.setId(officeId);
        o.setCity("Warszawa");
        o.setName("Poslki Buro");
        return o;
    }


}
