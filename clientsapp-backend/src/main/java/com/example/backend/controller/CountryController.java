package com.example.backend.controller;

import com.example.backend.repository.model.Country;
import com.example.backend.service.CountryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/country")
public class CountryController {
    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/all")
    public List<String> getCountries() {
        return countryService.getCountries()
                .stream()
                .map(Country::getName)
                .collect(Collectors.toList());
    }

}
