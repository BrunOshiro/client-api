package com.jazztech.STAG2504_ClientApi.applicationService.clientsService;

import com.jazztech.STAG2504_ClientApi.infrastructure.repository.ClientsRepository;
import com.jazztech.STAG2504_ClientApi.infrastructure.repository.entity.Client;
import com.jazztech.STAG2504_ClientApi.infrastructure.repository.ClientMapper;
import com.jazztech.STAG2504_ClientApi.presentation.dto.ClientDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SearchClient {
    private final ClientsRepository clientsRepository;
    private final ClientMapper clientMapper;
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateClient.class);

    //Busca de cliente por Id
    @Transactional
    public ClientDto getClientById(Long id) {
        Client client = clientsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
        LOGGER.info("Cliente consultado por id com sucesso");
        return clientMapper.entityToDto(client);
    }

    //Busca de clientes por CPF (Como na Jazz temos clientes)
    @Transactional
    public List<ClientDto> getClientsByCpf(String cpf) {
        List<Client> clients = StringUtils.isBlank(cpf) ?
                clientsRepository.findAll(): clientsRepository.findByCpf(cpf);
        LOGGER.info("Cliente consultado por CPF com sucesso");
        return clientMapper.listEntityToListDto(clients);
    }

    //Buscar todos os clientes
    @Transactional
    public List<ClientDto> getAllClients() {
        List<Client> clients = clientsRepository.findAll();
        LOGGER.info("Clientes listados com sucesso");
        return clientMapper.listEntityToListDto(clients);
    }
}