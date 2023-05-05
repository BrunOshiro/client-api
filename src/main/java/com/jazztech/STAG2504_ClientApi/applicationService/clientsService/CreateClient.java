package com.jazztech.STAG2504_ClientApi.applicationService.clientsService;

import com.jazztech.STAG2504_ClientApi.applicationService.domain.entity.ClientDomain;
import com.jazztech.STAG2504_ClientApi.infrastructure.repository.ClientsRepository;
import com.jazztech.STAG2504_ClientApi.infrastructure.apiClients.ViaCepApiClient;
import com.jazztech.STAG2504_ClientApi.applicationService.domain.entity.AddressDomain;
import com.jazztech.STAG2504_ClientApi.infrastructure.apiClients.dto.AddressDto;
import com.jazztech.STAG2504_ClientApi.infrastructure.repository.entity.ClientEntity;
import com.jazztech.STAG2504_ClientApi.infrastructure.repository.ClientMapper;
import com.jazztech.STAG2504_ClientApi.presentation.dto.ClientDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import jakarta.validation.ValidationException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import java.time.LocalDate;
import org.slf4j.Logger;

@Service
@RequiredArgsConstructor
public class CreateClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateClient.class);
    private final ClientMapper clientMapper;
    private final ViaCepApiClient viaCepApiClient;
    private final ClientsRepository clientsRepository;

    //Criação de cliente
    @Transactional
    public ClientDto addClient(@Valid ClientDto clientDomain) {
        final ClientEntity clientEntity = clientMapper.domainEntityToEntity(clientDomain);
        final String cep = clientEntity.
        validateDataNascimento(clientDto.dataNascimento());
        validateCep(clientDto.addressDto().cep());
        AddressDto addressDto = getAddressFromViaCep(clientDto.addressDto().cep());
        ClientDomain clientDomain;
        clientDomain = ClientDomain.builder()
                .nome(clientDto.nome())
                .cpf(clientDto.cpf())
                .dataNascimento(clientDto.dataNascimento())
                .address(AddressDomain.builder()
                        .cep(addressDto.cep())
                        .enderecoNumero(addressDto.enderecoNumero())
                        .enderecoComplemento(addressDto.enderecoComplemento())
                        .enderecoRua(addressDto.enderecoRua())
                        .enderecoCidade(addressDto.enderecoCidade())
                        .enderecoBairro(addressDto.enderecoBairro())
                        .enderecoUf(addressDto.enderecoUf())
                        .build())
                .build();
        ClientEntity entity = clientMapper.domainEntityToEntity(clientDomain);
        clientsRepository.save(entity);

        LOGGER.info("Cliente cadastrado com sucesso");
        return clientMapper.domainEntityToDto(clientDomain);
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

    //Buscar endereço por CEP
    private AddressDto getAddressFromViaCep(String cep) {
        LOGGER.info("CEP consultado com sucesso");
        return viaCepApiClient.getAddressByCep(cep);
    }
}