package com.jazztech.STAG2504_ClientApi.applicationService.clientsService;

import com.jazztech.STAG2504_ClientApi.applicationService.domain.entity.DomainClient;
import com.jazztech.STAG2504_ClientApi.infrastructure.apiClients.dto.AddressDto;
import com.jazztech.STAG2504_ClientApi.infrastructure.exceptions.ResourceNotFoundException;
import com.jazztech.STAG2504_ClientApi.infrastructure.repository.ClientMapper;
import com.jazztech.STAG2504_ClientApi.infrastructure.repository.ClientsRepository;
import com.jazztech.STAG2504_ClientApi.infrastructure.repository.entity.Client;
import com.jazztech.STAG2504_ClientApi.presentation.dto.ClientDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UpdateClient {
    private final ClientMapper clientMapper;
    private final ClientsRepository clientsRepository;

    @Transactional
    public ClientDto updateClient(Long id, ClientDto clientDto) throws ResourceNotFoundException {
        Optional<Client> optionalClient = clientsRepository.findById(id);

        if (optionalClient.isPresent()) {
            DomainClient clientToUpdate = clientMapper.entityToDomainEntity(optionalClient.get());

            clientToUpdate.nome(clientDto.nome());
            clientToUpdate.cpf(clientDto.cpf());
            clientToUpdate.dataNascimento(clientDto.dataNascimento());

            AddressDto addressDto = clientDto.addressDto();
            if (addressDto != null) {
                clientToUpdate.address().cep(addressDto.cep());
                clientToUpdate.address().enderecoNumero(addressDto.enderecoNumero());
                clientToUpdate.address().enderecoComplemento(addressDto.enderecoComplemento());
                clientToUpdate.address().enderecoRua(addressDto.enderecoRua());
                clientToUpdate.address().enderecoBairro(addressDto.enderecoBairro());
                clientToUpdate.address().enderecoCidade(addressDto.enderecoCidade());
                clientToUpdate.address().enderecoUf(addressDto.enderecoUf());
            }

            DomainClient updatedClient = clientMapper.dtoToDomainEntity(clientDto);
            updatedClient.id(id);
            updatedClient.address(clientToUpdate.address());

            return clientMapper.domainEntityToDto(clientsRepository.save(clientMapper.domainEntityToEntity(updatedClient)));
        } else {
            throw new ResourceNotFoundException("Cliente não encontrado com o ID: " + id);
        }
    }

}