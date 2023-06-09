package com.jazztech.clientapi.service.domain.entity;

import com.jazztech.clientapi.infrastructure.apiclients.dto.AddressDto;
import com.jazztech.clientapi.infrastructure.util.ValidationCustom;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import lombok.Builder;
import org.hibernate.validator.constraints.br.CPF;

//Camada que recebe os dados do usuário(DTO) e trata para a camada de infraestrutura
public record ClientDomain(

        @NotBlank(message = "O campo nome é obrigatório")
        @Size(min = 5, max = 100, message = "O campo 'Nome' deve ter no mínimo 5 caracteres")
        String nome,
        @CPF(message = "CPF informado inválido")
        String cpf,
        LocalDate dataNascimento,
        AddressDomain addressDomain
) {
    @Builder(toBuilder = true)
    public ClientDomain(
            String nome,
            String cpf,
            LocalDate dataNascimento,
            AddressDomain addressDomain
    ) {
        this.nome = nome;
        this.cpf = formatCpf(cpf);
        this.dataNascimento = dataNascimento;
        this.addressDomain = addressDomain;
        ValidationCustom.validator(this);
    }

    private static String formatCpf(String cpf) {
        return cpf.replaceAll("[-.]", "");
    }

    //Método para atualizar o endereço adicionando campos conforme consulta do cep na api dos correios
    public ClientDomain updateAddressFromViaCepApi(AddressDto addressDto) {
        return this.toBuilder()
                .addressDomain(AddressDomain.builder()
                        .cep(this.addressDomain.cep())
                        .enderecoComplemento(this.addressDomain.enderecoComplemento())
                        .enderecoNumero(this.addressDomain.enderecoNumero())
                        .enderecoRua(addressDto.logradouro())
                        .enderecoBairro(addressDto.bairro())
                        .enderecoCidade(addressDto.localidade())
                        .enderecoUf(addressDto.uf())
                        .build())
                .build();
    }
}
