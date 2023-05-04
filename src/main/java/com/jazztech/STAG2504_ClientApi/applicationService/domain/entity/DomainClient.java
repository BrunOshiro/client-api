package com.jazztech.STAG2504_ClientApi.applicationService.domain.entity;

import com.jazztech.STAG2504_ClientApi.infrastructure.apiClients.dto.AddressDto;
import com.jazztech.STAG2504_ClientApi.infrastructure.util.ValidationCustom;
import org.hibernate.validator.constraints.br.CPF;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;
import lombok.Builder;

public record DomainClient(

        @NotBlank(message = "O campo nome é obrigatório")
        String nome,
        @CPF(message = "CPF informado inválido")
        String cpf,
        LocalDate dataNascimento,
        Address address
) {
    private static String formatCpf(String cpf) {
        return cpf.replaceAll("[-.]","");
    }

    @Builder(toBuilder = true)
    public DomainClient (
            String nome,
            String cpf,
            LocalDate dataNascimento,
            Address address
    ) {
        this.nome = nome;
        this.cpf = formatCpf(cpf);
        this.dataNascimento = dataNascimento;
        this.address = address;
        ValidationCustom.validator(this);
    }

    //Método para atualizar o endereço adicionando campos conforme consulta do cep na api dos correios
    public DomainClient updateAddressFromViaCepApi(AddressDto addressDto) {
        return this.toBuilder()
                .address(Address.builder()
                        .cep(this.address.cep())
                        .enderecoComplemento(this.address.enderecoComplemento())
                        .enderecoNumero(this.address.enderecoNumero())
                        .enderecoRua(addressDto.logradouro())
                        .enderecoBairro(addressDto.bairro())
                        .enderecoCidade(addressDto.localidade())
                        .enderecoUf(addressDto.uf())
                        .build())
                .build();
    }
}