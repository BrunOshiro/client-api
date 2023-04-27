package com.jazztech.STAG2504_ClientApi.applicationService.clientsService;

import com.jazztech.STAG2504_ClientApi.applicationService.domain.entity.Address;
import com.jazztech.STAG2504_ClientApi.applicationService.domain.entity.DomainClient;
import com.jazztech.STAG2504_ClientApi.infrastructure.apiClients.ViaCepApiClient;
import com.jazztech.STAG2504_ClientApi.infrastructure.apiClients.dto.AddressDto;
import com.jazztech.STAG2504_ClientApi.infrastructure.exceptions.ApiClientException;
import com.jazztech.STAG2504_ClientApi.infrastructure.repository.ClientMapper;
import com.jazztech.STAG2504_ClientApi.infrastructure.repository.ClientsRepository;
import com.jazztech.STAG2504_ClientApi.infrastructure.repository.entity.Client;
import com.jazztech.STAG2504_ClientApi.presentation.dto.ClientDto;
import jakarta.transaction.Transactional;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class CreateClient {
    private final ClientMapper clientMapper;
    private final ViaCepApiClient viaCepApiClient;
    private final ClientsRepository clientsRepository;


    //Criação de cliente
    @Transactional
    public ClientDto addClient(ClientDto clientDto) throws ApiClientException {
        validateDataNascimento(clientDto.dataNascimento());
        validateCep(clientDto.addressDto().cep());

        AddressDto addressDto = viaCepApiClient.getAddressByCep(clientDto.addressDto().cep());
        DomainClient domainClient;
        domainClient = DomainClient.builder()
                .nome(clientDto.nome())
                .cpf(clientDto.cpf())
                .dataNascimento(clientDto.dataNascimento())
                .address(Address.builder()
                        .cep(addressDto.cep())
                        .enderecoNumero(addressDto.enderecoNumero())
                        .enderecoComplemento(addressDto.enderecoComplemento())
                        .enderecoRua(addressDto.enderecoRua())
                        .enderecoCidade(addressDto.enderecoCidade())
                        .enderecoBairro(addressDto.enderecoBairro())
                        .enderecoUf(addressDto.enderecoUf())
                        .build())
                .build();
        Client entity = clientMapper.domainEntityToEntity(domainClient);
        clientsRepository.save(entity);

        return clientMapper.domainEntityToDto(domainClient);

    }

    //Validação de dataNascimento
    private void validateDataNascimento(LocalDate dataNascimento) {
        if (dataNascimento.isAfter(LocalDate.now())) {
            throw new ValidationException("Data de Nascimento inválida (não pode ser uma data futura)");
        }
    }

    //Validação do CEP
    private void validateCep(String cep) {
        if(cep.length() != 8) {
            throw new ValidationException("CEP inválido");
        }
    }

}
