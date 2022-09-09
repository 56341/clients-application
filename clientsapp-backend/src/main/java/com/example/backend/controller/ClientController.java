package com.example.backend.controller;

import com.example.backend.dto.ClientCreateRequest;
import com.example.backend.dto.ClientResponse;
import com.example.backend.repository.model.User;
import com.example.backend.security.SecurityUtil;
import com.example.backend.service.ClientService;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/client", method = { RequestMethod.POST, RequestMethod.GET })
public class ClientController {

    private final ClientService clientService;

    private final ModelMapper modelMapper;

    public ClientController(ClientService clientService, ModelMapper modelMapper) {
        this.clientService = clientService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/all")
    public List<ClientResponse> getClients() {
        User activeUser = SecurityUtil.getPrincipalUser();
        if (activeUser == null) {
            throw new IllegalStateException("Active user not found!");
        }
        return clientService.getClientsByUser(activeUser)
                .stream()
                .map(client -> modelMapper.map(client, ClientResponse.class))
                .collect(Collectors.toList());
    }

    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createClient(@Valid @RequestBody ClientCreateRequest clientCreateRequest) {
        User activeUser = SecurityUtil.getPrincipalUser();
        if (activeUser == null) {
            throw new IllegalStateException("Active user not found!");
        }
        clientService.createClient(clientCreateRequest, activeUser);
    }
}
