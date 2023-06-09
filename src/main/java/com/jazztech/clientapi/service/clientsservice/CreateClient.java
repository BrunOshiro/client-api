package com.jazztech.clientapi.service.clientsservice;

import com.jazztech.clientapi.infrastructure.apiclients.ViaCepApiClient;
import com.jazztech.clientapi.infrastructure.apiclients.dto.AddressDto;
import com.jazztech.clientapi.infrastructure.exceptions.AddressNotFound;
import com.jazztech.clientapi.infrastructure.exceptions.CPFAlreadyExistException;
import com.jazztech.clientapi.infrastructure.repository.ClientMapper;
import com.jazztech.clientapi.infrastructure.repository.ClientsRepository;
import com.jazztech.clientapi.infrastructure.repository.entity.ClientEntity;
import com.jazztech.clientapi.presentation.dto.ClientDto;
import com.jazztech.clientapi.presentation.dto.ClientDtoResponse;
import com.jazztech.clientapi.service.domain.entity.ClientDomain;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateClient.class);
    private final ClientMapper clientMapper;
    private final ViaCepApiClient viaCepApiClient;
    private final ClientsRepository clientsRepository;

    //Criação de cliente
    @Transactional
    public ClientDtoResponse addClient(@Valid ClientDto clientDto) throws AddressNotFound, CPFAlreadyExistException {
        // Transforma a entrada do cliente(dto) em domínio
        final ClientDomain clientDomain = clientMapper.dtoToDomain(clientDto);

        // Pega o cep informado pelo usuário e transforma em domain
        final String cep = clientDomain.addressDomain().cep();

        // Consulta o cep na api via Cep
        final AddressDto addressDto = getAddressFromViaCep(cep);

        // Atualiza o endereço retornado pela api ViaCep no domain
        final ClientDomain clientAddressUpdated = clientDomain.updateAddressFromViaCepApi(addressDto);

        // Converte domain para entidade
        final ClientEntity clientEntity = clientMapper.domainToEntity(clientAddressUpdated);

        // Salva entidade no banco de dados
        final ClientEntity clientSaved = saveClient(clientEntity);

        // Log de cliente cadastrado com sucesso
        LOGGER.info("Cliente cadastrado com sucesso");

        // Retorna o cliente salvo
        return clientMapper.entityToDto(clientSaved);
    }

    //Validação de dataNascimento
    private void validateDataNascimento(LocalDate dataNascimento) {
        if (dataNascimento.isAfter(LocalDate.now())) {
            throw new ValidationException("Data de Nascimento inválida (não pode ser uma data futura)");
        }
    }

    //Método para salvar o cliente com excessão caso o cpf já tenha sido cadastrado
    private ClientEntity saveClient(ClientEntity clientEntity) throws CPFAlreadyExistException {
        final ClientEntity clientSaved;
        try {
            clientSaved = clientsRepository.save(clientEntity);
        } catch (DataIntegrityViolationException exception) {
            throw new CPFAlreadyExistException("CPF já cadastrado %s".formatted(clientEntity.getCpf()));
        }
        return clientSaved;
    }

    //Buscar endereço por CEP e valida a formatação
    private AddressDto getAddressFromViaCep(String cep) throws AddressNotFound {
        final AddressDto addressDto = viaCepApiClient.getAddressByCep(cep);
        if (addressDto.cep() == null) {
            throw new AddressNotFound("Endereço não existente para o CEP %s".formatted(cep));
        }
        LOGGER.info("CEP consultado com sucesso");
        return addressDto;
    }
}
