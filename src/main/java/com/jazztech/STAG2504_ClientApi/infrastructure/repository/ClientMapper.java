package com.jazztech.STAG2504_ClientApi.infrastructure.repository;

import com.jazztech.STAG2504_ClientApi.applicationService.domain.entity.DomainClient;
import com.jazztech.STAG2504_ClientApi.infrastructure.repository.entity.Client;
import com.jazztech.STAG2504_ClientApi.presentation.dto.ClientDto;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring", uses = AddressMapper.class)
public interface ClientMapper {
    //Mapeando entidade do domínio > dto
    ClientDto domainEntityToDto(DomainClient domainClient);

    //Mapeando entidade do domínio > entidade
    Client domainEntityToEntity(DomainClient domainClient);

    //Mapeamento entidade > dto
    ClientDto entityToDto(Client client);

    //Mapeamento lista<entidade> > List<dto>
    List<ClientDto> listEntityToListDto(List<Client> clients);
}