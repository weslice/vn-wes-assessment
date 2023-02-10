package com.visualnuts;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountryService {

    private final List<Country> countries;

    public CountryService(List<Country> countries) {
        if(countries == null) {
            this.countries = new ArrayList<>();
        } else {
            this.countries = countries.stream()
                    .sorted(Comparator.comparing(Country::country))
                    .toList();
        }
    }

    public int countCountries() {
        return countries.size();
    }

    /**
     * If multiple countries have the same amount of languages the first one from the list
     */
    public Optional<Country> findCountryMostOfficialLanguagesFilteredByLanguage(String language) {
        if (language == null || language.isBlank()) {
            return Optional.empty();
        }
        var filteredStream = countries.stream()
                .filter(country -> country.languages().contains(language));
        return findCountryWithMostOfficialLanguages(filteredStream);
    }

    public int countDistinctLanguageInCountries() {
        return (int) countries.stream()
                .flatMap(country -> country.languages().stream())
                .distinct()
                .count();
    }

    public Optional<Country> findCountryWithMostOfficialLanguages() {
        return findCountryWithMostOfficialLanguages(countries.stream());
    }

    private Optional<Country> findCountryWithMostOfficialLanguages(Stream<Country> countryStream) {
        return countryStream
                .max(Comparator.comparingInt(c -> c.languages().size()));
    }

    public Optional<String> findMostCommonlySpokenLanguage() {
        var laguageUseCountMap = countries.stream()
                .flatMap(country -> country.languages().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return laguageUseCountMap.entrySet().stream().max(Comparator.comparingLong(Map.Entry::getValue)).map(Map.Entry::getKey);
    }

}
