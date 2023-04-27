package com.jazztech.STAG2504_ClientApi.infrastructure.apiClients;

import com.jazztech.STAG2504_ClientApi.infrastructure.apiClients.dto.AddressDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://viacep.com.br/ws", name = "ViaCepApi")
public interface ViaCepApiClient {
    @GetMapping("/{cep}/json")
    AddressDto address(@PathVariable String cep);
}