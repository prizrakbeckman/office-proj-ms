package com.adamhard.restapi.refractoring.service;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CountriesCitiesTest {

    @Mock
    private CountriesCitiesService countriesCitiesService;

    @Test
    void testShouldRenderListOfCitiesWhenRetrievingEmployees(){
        when(this.countriesCitiesService.getAllCities()).thenReturn(listOfCities());
    }

    @Test
    void testShouldRenderListOfCountriesWhenRetrievingEmployees(){
        when(this.countriesCitiesService.getAllCountries()).thenReturn(listOfCountries());
    }

    private Set<String> listOfCities(){
        return new HashSet<>(Arrays.asList("Nowy Yorku","Berlin"));
    }

    private Set<String> listOfCountries() {
        return new HashSet<>(Arrays.asList("France","Germany"));
    }

}
