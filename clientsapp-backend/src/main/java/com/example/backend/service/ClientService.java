package com.example.backend.service;

import com.example.backend.dto.ClientCreateRequest;
import com.example.backend.repository.model.Client;
import com.example.backend.repository.model.Country;
import com.example.backend.repository.model.User;
import com.example.backend.repository.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    final ClientRepository clientRepository;

    final CountryService countryService;

    private static final Logger logger = LoggerFactory.getLogger(ClientService.class);

    public ClientService(ClientRepository clientRepository, CountryService countryService) {
        this.clientRepository = clientRepository;
        this.countryService = countryService;
    }

    public List<Client> getClientsByUser(User user) {
        logger.debug("Finding clients for user, username: {}", user.getUsername());
        return clientRepository.findByManagerId(user.getId());
    }

    public void createClient(ClientCreateRequest clientCreateRequest, User creator) {
        logger.debug("Creating a new client, username: {}, manager: {}", clientCreateRequest.getUsername(),
                creator.getUsername());
        Client client = new Client()
                .setFirstName(clientCreateRequest.getFirstName())
                .setLastName(clientCreateRequest.getLastName())
                .setUsername(clientCreateRequest.getUsername())
                .setEmail(clientCreateRequest.getEmail())
                .setAddress(clientCreateRequest.getAddress())
                .setCountry(getCountry(clientCreateRequest.getCountry()))
                .setManager(creator);
        clientRepository.save(client);
        logger.info("Created a new client, username: {}, manager: {}", clientCreateRequest.getUsername(),
                creator.getUsername());
    }

    private Country getCountry(String countryName) {
        Country country = countryService.getByName(countryName);
        if (country == null) {
            throw new IllegalArgumentException(String.format("No countries found by name %s", countryName));
        }
        return country;
    }

}
