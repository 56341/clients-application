package com.example.backend.service;

import com.example.backend.repository.CountryRepository;
import com.example.backend.repository.model.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    final CountryRepository countryRepository;

    private static final Logger logger = LoggerFactory.getLogger(CountryService.class);

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getCountries() {
        logger.debug("Finding countries");
        return countryRepository.findAll();
    }

    public Country getByName(String name) {
        logger.debug("Finding countries by name, name: {}", name);
        return countryRepository.findCountryByName(name);
    }

}
