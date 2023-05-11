package com.jazztech.STAG2504_ClientApi.applicationService.domain.entity;

import com.jazztech.STAG2504_ClientApi.infrastructure.util.ValidationCustom;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;

public record AddressDomain(
        @Pattern(regexp = "^\\d{5}-\\d{3}$", message = "CEP inválido, deve estar no formato 00000-000")
        @NotBlank(message = "O campo 'CEP' não pode estar em branco")
        String cep,
        @NotBlank(message = "O campo 'Número' não pode estar em branco (caso não possua número informar: 0)")
        @Size(min = 1, max = 100000, message = "O campo 'Número' deve estar entre 1 e 8 caracteres")
        Integer enderecoNumero,
        @Size(min = 0, max = 40, message = "O campo 'Complemento' possui limite 40 caracteres")
        String enderecoComplemento,
        @NotBlank(message = "O campo rua deve ser preenchido")
        @Size(min = 3, max = 30, message = "O campo 'Rua' possui limite 30 caracteres")
        String enderecoRua,
        @NotBlank(message = "O campo 'Bairro' não pode estar em branco")
        @Size(min = 3, max = 30, message = "O campo 'Bairro' possui limite 30 caracteres")
        String enderecoBairro,
        @NotBlank(message = "O campo 'Cidade' não pode estar em branco")
        @Size(min = 3, max = 30, message = "O campo 'Cidade' possui limite 30 caracteres")
        String enderecoCidade,
        @NotBlank(message = "O endereço não pode estar em branco")
        @Size(min = 2, max = 2, message = "O campo 'UF' possui limite 2 caracteres. Deve ser preenchida apenas a sigla do estado.")
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