package com.example.backend.repository;

import com.example.backend.repository.model.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientRepository extends CrudRepository<Client, Long> {

    List<Client> findByManagerId(long id);

}