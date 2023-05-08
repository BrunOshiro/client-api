package com.jazztech.STAG2504_ClientApi.infrastructure.repository.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Immutable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

//Dados que serão enviados para o banco de dados
@Entity
@Table(name = "ENDERECO")
@Immutable
public class AddressEntity {
    @Id
    UUID id;
    @Column(name = "cep")
    String cep;
    @Column(name = "numero")
    Integer enderecoNumero;
    @Column(name = "complemento")
    String enderecoComplemento;
    @Column(name = "rua")
    String enderecoRua;
    @Column(name = "bairro")
    String enderecoBairro;
    @Column(name = "cidade")
    String enderecoCidade;
    @Column(name = "uf")
    String enderecoUf;
    @CreationTimestamp
    @Column(name = "data_criacao")
    LocalDateTime creationDate;
    @UpdateTimestamp
    @Column(name = "data_alteracao")
    LocalDateTime updateDate;

    private AddressEntity() {}

    public AddressEntity(
            String cep,
            Integer enderecoNumero,
            String enderecoComplemento,
            String enderecoRua,
            String enderecoBairro,
            String enderecoCidade,
            String enderecoUf
    ) {
        this.id = UUID.randomUUID();
        this.cep = cep;
        this.enderecoNumero = enderecoNumero;
        this.enderecoComplemento = enderecoComplemento;
        this.enderecoRua = enderecoRua;
        this.enderecoBairro = enderecoBairro;
        this.enderecoCidade = enderecoCidade;
        this.enderecoUf = enderecoUf;
    }

    public UUID getId() {
        return id;
    }

    public String getCep() {
        return cep;
    }

    public Integer getEnderecoNumero() {
        return enderecoNumero;
    }

    public String getEnderecoComplemento() {
        return enderecoComplemento;
    }

    public String getEnderecoRua() {
        return enderecoRua;
    }

    public String getEnderecoBairro() {
        return enderecoBairro;
    }

    public String getEnderecoCidade() {
        return enderecoCidade;
    }

    public String getEnderecoUf() {
        return enderecoUf;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }
}