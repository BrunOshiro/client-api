package com.jazztech.STAG2504_ClientApi.infrastructure.repository;

import com.jazztech.STAG2504_ClientApi.applicationService.domain.entity.AddressDomain;
import com.jazztech.STAG2504_ClientApi.infrastructure.apiClients.dto.AddressDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    //Mapeando dto para entidade
    AddressDomain toEntity(AddressDto addressDto);
    //Mapeando entidade para dto
    AddressDto toDto(AddressDomain addressDomainEntity);
}
