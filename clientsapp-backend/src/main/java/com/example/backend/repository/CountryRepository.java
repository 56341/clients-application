package com.example.backend.repository;

import com.example.backend.repository.model.Country;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CountryRepository extends CrudRepository<Country, Long> {

    List<Country> findAll();

    Country findCountryByName(String name);

}