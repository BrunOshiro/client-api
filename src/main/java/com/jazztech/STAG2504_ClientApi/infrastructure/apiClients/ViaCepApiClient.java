package com.jazztech.STAG2504_ClientApi.infrastructure.apiClients;

import com.jazztech.STAG2504_ClientApi.infrastructure.apiClients.dto.AddressDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient(name = "viacep", url = "${url.viacep.host}")
public interface ViaCepApiClient {
    @GetMapping("/ws/{cep}/json/")
    AddressDto getAddressByCep(@PathVariable("cep") String cep);
    //URL completa = "https://viacep.com.br/ws/{cep}/json/"
}