package com.jazztech.STAG2504_ClientApi.infrastructure.apiClients.dto;

public record AddressDto(
        // Variáveis com atributos conforme api do correio
        String cep,
        String logradouro,
        String complemento,
        String bairro,
        String localidade,
        String uf,
        Integer ibge,
        Integer gia,
        Integer ddd,
        Integer siafi
) {
    public AddressDto(
            String cep,
            String logradouro,
            String complemento,
            String bairro,
            String localidade,
            String uf,
            Integer ibge,
            Integer gia,
            Integer ddd,
            Integer siafi
    ) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
        this.ibge = ibge;
        this.gia = gia;
        this.ddd = ddd;
        this.siafi = siafi;
    }
}