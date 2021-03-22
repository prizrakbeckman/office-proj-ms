package com.luxoft.interview.service;

import com.luxoft.interview.model.Office;
import com.luxoft.interview.service.exception.OfficeNotFoundException;
import com.luxoft.interview.service.impl.OfficeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OfficeServiceTest {

    @InjectMocks
    private OfficeServiceImpl officeService;
    private Office o;
    @Test
    void whenRetrieveEmployeeByIdReturnEmployeeModel() {
        when(this.officeService.getOffices()).thenReturn(createOffices());
    }

    @Test
    void whenCreateOfficeShouldReturnVoid(){
       this.officeService.createOffice(getOffice(1));
    }

    @Test
    void whenCreatingEmployeeExceptionThrown()  {
        assertThrows(OfficeNotFoundException.class, this::whenFetchingOfficeNotFound);
    }

    @Test
    void whenCreatingEmployeeNoExceptionThrown() throws OfficeNotFoundException  {
        whenFetchingOffice();
    }

    private void whenFetchingOffice() throws OfficeNotFoundException {
        if(this.officeService.getByid(this.o.getId()).isEmpty())
            throw new OfficeNotFoundException("no office to update");
        this.officeService.updateOffice(1);
    }

    private void whenFetchingOfficeNotFound() throws OfficeNotFoundException {
        this.o = getOfficeWithException();
        if(this.officeService.getByid(this.o.getId()).isEmpty())
            throw new OfficeNotFoundException("no office to update");
        this.officeService.updateOffice(1);
    }

    private List<Office> createOffices() {
        return Arrays.asList(getOffice(1), getOffice(2));
    }

    private Office getOffice(Integer officeId) {
        Office o = new Office();
        o.setId(officeId);
        o.setCity("Warszawa");
        o.setName("Poslki Buro");
        return o;
    }

    private Office getOfficeWithException() {
        Office o = new Office();
        o.setId(16);
        o.setName("Pawel Yablonovic Buro");
        o.setCity("Warszawa");
        return o;
    }

}
