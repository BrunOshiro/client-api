package com.jazztech.STAG2504_ClientApi.infrastructure.repository;

import com.jazztech.STAG2504_ClientApi.applicationService.domain.entity.ClientDomain;
import com.jazztech.STAG2504_ClientApi.infrastructure.repository.entity.ClientEntity;
import com.jazztech.STAG2504_ClientApi.presentation.dto.ClientDto;
import jakarta.validation.Valid;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring", uses = AddressMapper.class)
public interface ClientMapper {
    //Mapeando entidade do domínio > dto
    ClientDto domainToDto(ClientDomain clientDomain);

    //Mapeando domínio > entidade
    ClientEntity domainToEntity(@Valid ClientDomain clientDomain);

    //Mapeando dto > domínio
    ClientDomain dtoToDomainEntity(@Valid ClientDto clientDto);

    //Mapeamento entidade > dto
    ClientDto entityToDto(@Valid ClientEntity clientEntity);

    //Mapeamento lista<entidade> > List<dto>
    List<ClientDto> listEntityToListDto(List<ClientEntity> clientEntities);
}