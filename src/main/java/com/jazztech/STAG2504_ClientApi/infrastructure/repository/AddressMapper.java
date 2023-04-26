package com.jazztech.STAG2504_ClientApi.infrastructure.repository;

import com.jazztech.STAG2504_ClientApi.applicationService.domain.entity.Address;
import com.jazztech.STAG2504_ClientApi.infrastructure.apiClients.dto.AddressDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    //Mapeando dto para entidade
    Address toEntity(AddressDto addressDto);
    //Mapeando entidade para dto
    AddressDto toDto(Address addressEntity);
}
