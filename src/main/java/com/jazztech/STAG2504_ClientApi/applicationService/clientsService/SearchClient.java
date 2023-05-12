package com.jazztech.STAG2504_ClientApi.applicationService.clientsService;

import com.jazztech.STAG2504_ClientApi.infrastructure.repository.ClientMapper;
import com.jazztech.STAG2504_ClientApi.infrastructure.repository.ClientsRepository;
import com.jazztech.STAG2504_ClientApi.infrastructure.repository.entity.ClientEntity;
import com.jazztech.STAG2504_ClientApi.presentation.dto.ClientDtoResponse;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SearchClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateClient.class);
    private final ClientsRepository clientsRepository;
    private final ClientMapper clientMapper;

    //Busca de cliente por Id
    @Transactional
    public ClientDtoResponse getClientById(@Valid UUID id) {
        ClientEntity clientEntity = clientsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
        LOGGER.info("Cliente consultado por id com sucesso");
        return clientMapper.entityToDto(clientEntity);
    }

    //Busca de clientes por CPF (Como na Jazz temos clientes)
    @Transactional
    public List<ClientDtoResponse> getClientsByCpf(String cpf) {
        List<ClientEntity> clientEntities = StringUtils.isBlank(cpf) ?
                clientsRepository.findAll() : clientsRepository.findByCpf(cpf);
        LOGGER.info("Cliente consultado por CPF com sucesso");
        return clientMapper.listEntityToListDto(clientEntities);
    }

    //Buscar todos os clientes
    @Transactional
    public List<ClientDtoResponse> getAllClients() {
        List<ClientEntity> clientEntities = clientsRepository.findAll();
        LOGGER.info("Clientes listados com sucesso");
        return clientMapper.listEntityToListDto(clientEntities);
    }
}