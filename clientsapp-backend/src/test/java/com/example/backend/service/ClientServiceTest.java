package com.example.backend.service;

import com.example.backend.dto.ClientCreateRequest;
import com.example.backend.repository.ClientRepository;
import com.example.backend.repository.model.Client;
import com.example.backend.repository.model.Country;
import com.example.backend.repository.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class ClientServiceTest {

    private ClientRepository clientRepository;

    private CountryService countryService;

    private ClientService clientService;

    private final String firstName = "Klient";
    private final String lastName = "Esimene";
    private final String username = "Kasutajanimi";
    private final String email = "email@email.ee";
    private final String address = "Aadressi 2-3, Tartu";
    private final String country = "Estonia";

    @BeforeEach
    void setup() {
        clientRepository = mock(ClientRepository.class);
        countryService = mock(CountryService.class);
        clientService = new ClientService(clientRepository, countryService);
    }

    @Test
    void getClientsByUser_shouldReturnClients() {
        User userMock = mock(User.class);
        when(userMock.getId()).thenReturn(1L);
        Client clientMock = mock(Client.class);
        when(clientRepository.findByManagerId(1L)).thenReturn(List.of(clientMock));

        List<Client> clients = clientService.getClientsByUser(userMock);

        assertThat(clients.size()).isOne();
        assertThat(clients.get(0)).isEqualTo(clientMock);
    }

    @Test
    void createClient_shouldSaveNewClient_whenCountryValid() {
        ClientCreateRequest requestMock = buildClientCreateRequestMock();
        Country countryMock = mock(Country.class);
        when(countryService.getByName(country)).thenReturn(countryMock);
        User creatorMock = mock(User.class);
        ArgumentCaptor<Client> captor = ArgumentCaptor.forClass(Client.class);

        clientService.createClient(requestMock, creatorMock);

        verify(clientRepository).save(captor.capture());
        Client capturedClient = captor.getValue();
        assertThat(capturedClient.getFirstName()).isEqualTo(firstName);
        assertThat(capturedClient.getLastName()).isEqualTo(lastName);
        assertThat(capturedClient.getUsername()).isEqualTo(username);
        assertThat(capturedClient.getEmail()).isEqualTo(email);
        assertThat(capturedClient.getAddress()).isEqualTo(address);
        assertThat(capturedClient.getCountry()).isEqualTo(countryMock);
        assertThat(capturedClient.getManager()).isEqualTo(creatorMock);
    }

    @Test
    void createClient_shouldThrowException_whenCountryInvalid() {
        ClientCreateRequest requestMock = buildClientCreateRequestMock();
        when(countryService.getByName(country)).thenReturn(null);
        User creatorMock = mock(User.class);

        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    clientService.createClient(requestMock, creatorMock);
                }
        );
    }

    private ClientCreateRequest buildClientCreateRequestMock() {
        ClientCreateRequest requestMock = mock(ClientCreateRequest.class);
        when(requestMock.getFirstName()).thenReturn(firstName);
        when(requestMock.getLastName()).thenReturn(lastName);
        when(requestMock.getUsername()).thenReturn(username);
        when(requestMock.getEmail()).thenReturn(email);
        when(requestMock.getAddress()).thenReturn(address);
        when(requestMock.getCountry()).thenReturn(country);
        return requestMock;
    }

}
