package com.jazztech.STAG2504_ClientApi.presentation.controller;

import com.jazztech.STAG2504_ClientApi.applicationService.clientsService.CreateClient;
import com.jazztech.STAG2504_ClientApi.applicationService.clientsService.SearchClient;
import com.jazztech.STAG2504_ClientApi.infrastructure.exceptions.AddressNotFound;
import com.jazztech.STAG2504_ClientApi.infrastructure.exceptions.ApiClientException;
import com.jazztech.STAG2504_ClientApi.infrastructure.exceptions.CPFAlreadyExistException;
import com.jazztech.STAG2504_ClientApi.presentation.dto.ClientDto;
import com.jazztech.STAG2504_ClientApi.presentation.dto.ClientDtoResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import lombok.RequiredArgsConstructor;
import jakarta.validation.Valid;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1.0/clients")
@Validated
public class ClientsController {
    private final CreateClient createClient;
    private final SearchClient searchClient;
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientsController.class);

    @PostMapping("/")
    @ResponseStatus(value = HttpStatus.CREATED)
    public ClientDtoResponse createClient(@RequestBody @Valid ClientDto clientDto) throws ApiClientException, CPFAlreadyExistException, AddressNotFound {
        LOGGER.info(clientDto.toString());
        return createClient.addClient(clientDto);
    }

    @GetMapping
    public List<ClientDtoResponse> searchAllClients() {
        return searchClient.getAllClients();
    }
    
    @GetMapping("/{id}")
    public ClientDtoResponse searchClientById(@PathVariable("id") @Valid UUID id) {
        return searchClient.getClientById(id);
    }

    @GetMapping("/")
    public List<ClientDtoResponse> searchClientByCpf(@RequestParam(value = "cpf", required = false) @Valid String cpf) {
        return searchClient.getClientsByCpf(cpf);
    }
}