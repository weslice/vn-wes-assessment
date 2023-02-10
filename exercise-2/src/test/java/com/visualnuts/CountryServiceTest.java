package com.visualnuts;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CountryServiceTest {

    private List<Country> countries;

    CountryServiceTest() throws IOException {
        InputStream inputStream = CountryServiceTest.class.getResourceAsStream("/country-languages.json");
        final ObjectMapper objectMapper = new ObjectMapper();
        countries = objectMapper.readValue(inputStream, new TypeReference<>(){});
    }

    @Test
    @DisplayName("Count countries from JSON and expect 6")
    void countCountries() {
        assertEquals(6, new CountryService(countries).countCountries());
    }

    @Test
    @DisplayName("Given a null list of countries, when counting the countries, should return 0")
    void countCountriesNotEquals() {
        assertEquals(0, new CountryService(null).countCountries());
    }

    @Test
    @DisplayName("Given the countries from the JSON and the filter for countries that speak German, when finding the country with most official languages, should return Belgium")
    void findCountryMostOfficialLanguages() {
        var returnCountry = new CountryService(countries).findCountryMostOfficialLanguagesFilteredByLanguage("de");
        assertTrue(returnCountry.isPresent());
        assertEquals("BE", returnCountry.get().country());
    }

    @Test
    @DisplayName("Given the countries from the JSON and the language to be filtered is null, when finding the country with most official languages, should return empty optional")
    void findCountryMostOfficialLanguagesEmptyList() {
        var returnCountry = new CountryService(countries).findCountryMostOfficialLanguagesFilteredByLanguage(null);
        assertTrue(returnCountry.isEmpty());
    }

    @Test
    @DisplayName("Given the countries from the JSON, when counting all distinct languages spoken, should return 7")
    void countLanguageInCountries() {
        var totalLanguageInCountries = new CountryService(countries).countDistinctLanguageInCountries();
        assertEquals(7, totalLanguageInCountries);
    }

    @Test
    @DisplayName("Given the countries from the JSON, when finding the country with most official languages spoken, should return Belgium")
    void findCountryMoreOfficialLanguages() {
        var country = new CountryService(countries).findCountryWithMostOfficialLanguages();
        assertTrue(country.isPresent());
        assertEquals("BE", country.get().country());
    }

    @Test
    @DisplayName("Given the countries from the JSON, when finding the country with most official languages spoken, should return German")
    void findMostCommonLanguage() {
        var language = new CountryService(countries).findMostCommonlySpokenLanguage();
        assertTrue(language.isPresent());
        assertEquals("de", language.get());
    }

}