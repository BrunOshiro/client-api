package com.jazztech.STAG2504_ClientApi.presentation.controller;

import com.jazztech.STAG2504_ClientApi.applicationService.clientsService.CreateClient;
import com.jazztech.STAG2504_ClientApi.applicationService.clientsService.SearchClient;
import com.jazztech.STAG2504_ClientApi.infrastructure.exceptions.ApiClientException;
import com.jazztech.STAG2504_ClientApi.presentation.dto.ClientDto;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import jakarta.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1.0/clients")
@Validated
public class ClientsController {
    private final CreateClient createClient;
    private final SearchClient searchClient;

    @PostMapping("/")
    public ClientDto createClient(@RequestBody @Valid ClientDto clientDto) throws ApiClientException {
        createClient.addClient(clientDto);
        return clientDto;
    }

    @GetMapping("/")
    public List<ClientDto> searchAllClients() {
        return searchClient.getAllClients();
    }
    
    @GetMapping("/{id}")
    public ClientDto searchClientById(@PathVariable("id") @Valid Long id) {
        return searchClient.getClientById(id);
    }

    @GetMapping("/{cpf}")
    public List<ClientDto> searchClientByCpf(@PathVariable("cpf") @Valid String cpf) {
        return searchClient.getClientsByCpf(cpf);
    }
}