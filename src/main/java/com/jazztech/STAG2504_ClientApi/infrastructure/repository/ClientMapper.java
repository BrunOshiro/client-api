package com.jazztech.STAG2504_ClientApi.infrastructure.repository;

import com.jazztech.STAG2504_ClientApi.applicationService.domain.entity.AddressDomain;
import com.jazztech.STAG2504_ClientApi.applicationService.domain.entity.ClientDomain;
import com.jazztech.STAG2504_ClientApi.infrastructure.apiClients.dto.AddressDto;
import com.jazztech.STAG2504_ClientApi.infrastructure.repository.entity.AddressEntity;
import com.jazztech.STAG2504_ClientApi.infrastructure.repository.entity.ClientEntity;
import com.jazztech.STAG2504_ClientApi.presentation.dto.ClientDto;
import com.jazztech.STAG2504_ClientApi.presentation.dto.ClientDtoResponse;
import jakarta.validation.Valid;
import org.mapstruct.Mapper;
import java.util.List;

//@Mapper(componentModel = "spring", uses = AddressMapper.class)
@Mapper(componentModel = "spring")
public interface ClientMapper {
    //Mapeando domínio > dto
    ClientDto domainToDto(ClientDomain clientDomain);

    //Mapeando domínio > entidade
    ClientEntity domainToEntity(@Valid ClientDomain clientDomain);

    //Mapeando dto > domínio
    ClientDomain dtoToDomain(@Valid ClientDto clientDto);
    ClientDomain dtoToDomain(@Valid ClientDto.Address addressDto);

    //Mapeamento entidade > dto
    ClientDtoResponse entityToDto(ClientEntity clientEntity);
    ClientDtoResponse.AddressDtoResponse entityToDto(AddressEntity addressEntity);

    //Mapeamento lista<entidade> > List<dto>
    List<ClientDto> listEntityToListDto(List<ClientEntity> clientEntities);
}