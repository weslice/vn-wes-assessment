package com.visualnuts;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class Execise2App
{

    private static final String GERMAN = "de";
    public static void main( String[] args ) throws IOException {
        InputStream inputStream = Execise2App.class.getResourceAsStream("/country-languages.json");
        final ObjectMapper objectMapper = new ObjectMapper();

        var countryService = new CountryService(objectMapper.readValue(inputStream, new TypeReference<>(){}));

        System.out.printf("Number of countries in the world: %s %n", countryService.countCountries());
        System.out.printf(
                "Country with most official language spoken, but speaks German: %s %n",
                countryService.findCountryMostOfficialLanguagesFilteredByLanguage(GERMAN).get().country()
        );
        System.out.printf("Amount of languages spoken: %s%n", countryService.countDistinctLanguageInCountries());
        System.out.printf(
                "Find the country whit Most official languages spoken: %s%n",
                countryService.findCountryWithMostOfficialLanguages().get().country()
        );
        System.out.printf(
                "Most commonly official language spoken: %s%n",
                countryService.findMostCommonlySpokenLanguage().get()
        );

    }


}

