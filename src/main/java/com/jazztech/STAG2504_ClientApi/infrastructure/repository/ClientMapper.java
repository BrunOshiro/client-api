package com.jazztech.STAG2504_ClientApi.infrastructure.repository;

import com.jazztech.STAG2504_ClientApi.applicationService.domain.entity.DomainClient;
import com.jazztech.STAG2504_ClientApi.infrastructure.repository.entity.ClientEntity;
import com.jazztech.STAG2504_ClientApi.presentation.dto.ClientDto;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring", uses = AddressMapper.class)
public interface ClientMapper {
    //Mapeando entidade do domínio > dto
    ClientDto domainEntityToDto(DomainClient domainClient);

    //Mapeando entidade do domínio > entidade
    ClientEntity domainEntityToEntity(DomainClient domainClient);

    //Mapeamento entidade > dto
    ClientDto entityToDto(ClientEntity clientEntity);

    //Mapeamento lista<entidade> > List<dto>
    List<ClientDto> listEntityToListDto(List<ClientEntity> clientEntities);
}