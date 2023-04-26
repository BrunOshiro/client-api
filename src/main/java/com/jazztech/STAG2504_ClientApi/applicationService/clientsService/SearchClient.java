package com.jazztech.STAG2504_ClientApi.applicationService.clientsService;

import com.jazztech.STAG2504_ClientApi.infrastructure.exceptions.ApiClientException;
import com.jazztech.STAG2504_ClientApi.infrastructure.apiClients.ViaCepApiClient;
import com.jazztech.STAG2504_ClientApi.infrastructure.apiClients.dto.AddressDto;
import com.jazztech.STAG2504_ClientApi.infrastructure.repository.ClientMapper;
import com.jazztech.STAG2504_ClientApi.infrastructure.repository.ClientsRepository;
import com.jazztech.STAG2504_ClientApi.infrastructure.repository.entity.Client;
import com.jazztech.STAG2504_ClientApi.presentation.dto.ClientDto;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SearchClient {
    private final ClientsRepository clientsRepository;
    private final ClientMapper clientMapper;
    private final ViaCepApiClient viaCepApiClient;

    //Busca de cliente por Id
    @Transactional
    public ClientDto getClientById(Long id) {
        Client client = clientsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
        return clientMapper.entityToDto(client);
    }

    //Busca de clientes por CPF (Como na Jazz temos clientes)
    @Transactional
    public List<ClientDto> getClientsByCpf(String cpf) {
        List<Client> clients = StringUtils.isBlank(cpf) ?
                clientsRepository.findAll(): clientsRepository.findByCpf(cpf);
        return clientMapper.listEntityToListDto(clients);
    }

    //Buscar todos os clientes
    @Transactional
    public List<ClientDto> getAllClients() {
        List<Client> clients = clientsRepository.findAll();
        return clientMapper.listEntityToListDto(clients);
    }

    //Buscar endereço por CEP
    @Transactional
    private AddressDto getAddressFromViaCep(String cep) throws ApiClientException {
        return viaCepApiClient.getAddressByCep(cep);
    }

}