package com.jazztech.STAG2504_ClientApi.applicationService.domain.entity;

import com.jazztech.STAG2504_ClientApi.infrastructure.util.ValidationCustom;
import jakarta.validation.constraints.*;
import lombok.Builder;

public record AddressDomain(
        @Pattern(regexp = "^\\d{5}-\\d{3}$", message = "CEP inválido, deve estar no formato 00000-000")
        @NotBlank(message = "O campo 'CEP' não pode estar em branco")
        String cep,
        @NotNull
        @Digits(integer = 10, fraction = 0, message = "O campo 'Número' deve estar entre 1 e 10 dígitos")
        Integer enderecoNumero,
        String enderecoComplemento,
        String enderecoRua,
        String enderecoBairro,
        String enderecoCidade,
        String enderecoUf
) {
    @Builder
    public AddressDomain(
            String cep,
            Integer enderecoNumero,
            String enderecoComplemento,
            String enderecoRua,
            String enderecoBairro,
            String enderecoCidade,
            String enderecoUf
    ) {
        this.cep = cep;
        this.enderecoNumero = enderecoNumero;
        this.enderecoComplemento = enderecoComplemento;
        this.enderecoRua = enderecoRua;
        this.enderecoBairro = enderecoBairro;
        this.enderecoCidade = enderecoCidade;
        this.enderecoUf = enderecoUf;
        ValidationCustom.validator(this);
    }
}