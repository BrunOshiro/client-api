package com.jazztech.STAG2504_ClientApi.infrastructure.apiClients;

import com.jazztech.STAG2504_ClientApi.infrastructure.apiClients.dto.AddressDto;
import com.jazztech.STAG2504_ClientApi.infrastructure.exceptions.ApiClientException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ViaCepApiClient {

    private final RestTemplate restTemplate;

    public ViaCepApiClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public AddressDto getAddressByCep(String cep) throws ApiClientException {
        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        ResponseEntity<AddressDto> response = restTemplate.getForEntity(url, AddressDto.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            throw new ApiClientException("Não foi possível encontrar informações sobre o endereço");
        }
    }
}
