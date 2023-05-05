package com.jazztech.STAG2504_ClientApi.infrastructure.repository;

import com.jazztech.STAG2504_ClientApi.applicationService.domain.entity.ClientDomain;
import com.jazztech.STAG2504_ClientApi.infrastructure.repository.entity.ClientEntity;
import com.jazztech.STAG2504_ClientApi.presentation.dto.ClientDto;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring", uses = AddressMapper.class)
public interface ClientMapper {
    //Mapeando entidade do domínio > dto
    ClientDto domainEntityToDto(ClientDomain clientDomain);

    //Mapeando entidade do domínio > entidade
    ClientEntity domainEntityToEntity(@Valid ClientDto clientDomain);

    //Mapeamento entidade > dto
    ClientDto entityToDto(ClientEntity clientEntity);

    //Mapeamento lista<entidade> > List<dto>
    List<ClientDto> listEntityToListDto(List<ClientEntity> clientEntities);
}