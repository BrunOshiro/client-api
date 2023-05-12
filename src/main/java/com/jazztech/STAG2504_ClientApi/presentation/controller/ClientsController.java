package com.jazztech.STAG2504_ClientApi.presentation.controller;

import com.jazztech.STAG2504_ClientApi.applicationService.clientsService.CreateClient;
import com.jazztech.STAG2504_ClientApi.applicationService.clientsService.SearchClient;
import com.jazztech.STAG2504_ClientApi.infrastructure.exceptions.AddressNotFound;
import com.jazztech.STAG2504_ClientApi.infrastructure.exceptions.ApiClientException;
import com.jazztech.STAG2504_ClientApi.infrastructure.exceptions.CPFAlreadyExistException;
import com.jazztech.STAG2504_ClientApi.presentation.dto.ClientDto;
import com.jazztech.STAG2504_ClientApi.presentation.dto.ClientDtoResponse;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1.0/clients")
@Validated
public class ClientsController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientsController.class);
    private final CreateClient createClient;
    private final SearchClient searchClient;

    @PostMapping("/")
    @ResponseStatus(value = HttpStatus.CREATED)
    public ClientDtoResponse createClient(@RequestBody @Valid ClientDto clientDto)
            throws ApiClientException, CPFAlreadyExistException, AddressNotFound {
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