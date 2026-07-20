package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.exception.CountryNotFoundException;
import com.cognizant.springlearn.model.Country;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private final List<Country> countries = new ArrayList<>();

    public CountryController() {
        countries.add(new Country("IN", "India"));
        countries.add(new Country("US", "United States"));
        countries.add(new Country("UK", "United Kingdom"));
    }

    @GetMapping
    public List<Country> getAllCountries() {
        return countries;
    }

    @GetMapping("/{code}")
    public Country getCountryByCode(@PathVariable String code) {
        Optional<Country> countryOpt = countries.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst();

        if (countryOpt.isPresent()) {
            return countryOpt.get();
        } else {
            throw new CountryNotFoundException();
        }
    }

    @PostMapping
    public Country addCountry(@Valid @RequestBody Country country) {
        countries.add(country);
        return country;
    }
}
