package com.jazztech.STAG2504_ClientApi.infrastructure.repository;

import com.jazztech.STAG2504_ClientApi.applicationService.domain.entity.DomainClient;
import com.jazztech.STAG2504_ClientApi.infrastructure.repository.entity.Client;
import com.jazztech.STAG2504_ClientApi.presentation.dto.ClientDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = AddressMapper.class)
public interface ClientMapper {
    //Mapeando dto > entidade do domínio
    DomainClient dtoToDomainEntity(ClientDto clientDto);

    //Mapeando dto > entidade
    Client dtoToEntity(ClientDto clientDto);

    //Mapeando entidade do domínio > dto
    ClientDto domainEntityToDto(DomainClient domainClient);

    //Mapeando entidade do domínio > entidade
    Client domainEntityToEntity(DomainClient domainClient);

    //Mapeando entidade > entidade do domínio
    DomainClient entityToDomainEntity(Client client);

    //Mapeamento entidade > dto
    ClientDto entityToDto(Client client);

    //Mapeamento lista<entidade> > List<dto>
    List<ClientDto> listEntityToListDto(List<Client> clients);

    //Mapeando entidade do domínio > repository
    ClientsRepository domainEntityToRepository(DomainClient domainClient);

    //Mapeando entidade do domínio > repository
    ClientsRepository dtoToRepository(ClientDto clientDto);

    //Mapeando repository > entidade
    Client repositoryToEntity(ClientsRepository clientsRepository);
}