package com.jazztech.clientapi.infrastructure.repository;

import com.jazztech.clientapi.infrastructure.repository.entity.AddressEntity;
import com.jazztech.clientapi.infrastructure.repository.entity.ClientEntity;
import com.jazztech.clientapi.presentation.dto.ClientDto;
import com.jazztech.clientapi.presentation.dto.ClientDtoResponse;
import com.jazztech.clientapi.service.domain.entity.AddressDomain;
import com.jazztech.clientapi.service.domain.entity.ClientDomain;
import jakarta.validation.Valid;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    //Mapeando domínio > entidade
    @Mapping(source = "addressDomain", target = "addressEntity")
    ClientEntity domainToEntity(@Valid ClientDomain clientDomain);

    AddressEntity addressDomainToEntity(@Valid AddressDomain addressDomain);

    //Mapeando dto > domínio
    @Mapping(source = "address", target = "addressDomain")
    //escrito nesse formato porque não estava mapeando automaticamente a ClientDto.Address
    ClientDomain dtoToDomain(@Valid ClientDto clientDto);

    AddressDomain dtoToAddressDomain(@Valid ClientDto.Address addressDto);

    //Mapeamento entidade > dtoResponse
    @Mapping(source = "addressEntity", target = "addressDtoResponse")
    ClientDtoResponse entityToDto(ClientEntity clientEntity);

    ClientDtoResponse.AddressDtoResponse addressEntityToDto(AddressEntity addressEntity);

    //Mapeamento lista<entidade> > List<dto>
    List<ClientDtoResponse> listEntityToListDto(List<ClientEntity> clientEntities);
}
