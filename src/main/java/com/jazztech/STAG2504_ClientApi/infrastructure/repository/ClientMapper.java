package com.jazztech.STAG2504_ClientApi.infrastructure.repository;

import com.jazztech.STAG2504_ClientApi.applicationService.domain.entity.AddressDomain;
import com.jazztech.STAG2504_ClientApi.applicationService.domain.entity.ClientDomain;
import com.jazztech.STAG2504_ClientApi.infrastructure.repository.entity.AddressEntity;
import com.jazztech.STAG2504_ClientApi.infrastructure.repository.entity.ClientEntity;
import com.jazztech.STAG2504_ClientApi.presentation.dto.ClientDto;
import com.jazztech.STAG2504_ClientApi.presentation.dto.ClientDtoResponse;
import jakarta.validation.Valid;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    //Mapeando domínio > entidade
    @Mapping(source = "addressDomain", target = "addressEntity")
    ClientEntity domainToEntity(@Valid ClientDomain clientDomain);
    AddressEntity addressDomainToEntity(@Valid AddressDomain addressDomain);

    //Mapeando dto > domínio
    @Mapping(source = "address", target = "addressDomain") //escrito nesse formato porque não estava mapeando automaticamente a ClientDto.Address
    ClientDomain dtoToDomain(@Valid ClientDto clientDto);
    AddressDomain dtoToAddressDomain(@Valid ClientDto.Address addressDto);

    //Mapeamento entidade > dtoResponse
    @Mapping(source = "addressEntity", target = "addressDtoResponse")
    ClientDtoResponse entityToDto(ClientEntity clientEntity);
    ClientDtoResponse.AddressDtoResponse AddressEntityToDto(AddressEntity addressEntity);

    //Mapeamento lista<entidade> > List<dto>
    List<ClientDtoResponse> listEntityToListDto(List<ClientEntity> clientEntities);
}