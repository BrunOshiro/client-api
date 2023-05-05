package com.jazztech.STAG2504_ClientApi.applicationService.domain.entity;

import com.jazztech.STAG2504_ClientApi.infrastructure.apiClients.dto.AddressDto;
import com.jazztech.STAG2504_ClientApi.infrastructure.util.ValidationCustom;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;
import lombok.Builder;

//Camada que recebe os dados do usuário(DTO) e trata para a camada de infraestrutura
public record ClientDomain(

        @NotBlank(message = "O campo nome é obrigatório")
        @Size(min = 5, max = 40, message = "O campo 'Nome' deve ter 5 a 40 caracteres")
        String nome,
        @CPF(message = "CPF informado inválido")
        String cpf,
        LocalDate dataNascimento,
        AddressDomain addressDomain
) {
    private static String formatCpf(String cpf) {
        return cpf.replaceAll("[-.]","");
    }

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