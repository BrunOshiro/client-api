package com.jazztech.clientapi.infrastructure.apiclients;

import com.jazztech.clientapi.infrastructure.apiclients.dto.AddressDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "viacep", url = "https://viacep.com.br")
public interface ViaCepApiClient {
    @GetMapping("/ws/{cep}/json/")
    AddressDto getAddressByCep(@PathVariable("cep") String cep);
}
