package com.example.codingevaluation;

import com.example.codingevaluation.domain.models.CountryDetail;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CountryParserTest {
    @Test
    public void testCountryCreation() {
        CountryDetail country = new CountryDetail("Mexico", "Mexico City", 126000000L, 1964375.0, "Americas", "North America", "url");
        assertNotNull(country);
        assertEquals("Mexico", country.getName());
        assertEquals("Mexico City", country.getCapital());
    }
}