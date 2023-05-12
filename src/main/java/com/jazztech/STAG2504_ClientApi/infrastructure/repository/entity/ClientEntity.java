package com.jazztech.STAG2504_ClientApi.infrastructure.repository.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.UpdateTimestamp;

//Dados que serão enviados para o banco de dados
@Entity
@Table(name = "CLIENTE")
@Immutable
public class ClientEntity {
    @Id
    UUID id;

    @Column(name = "nome")
    String nome;

    @Column(name = "cpf")
    String cpf;

    @Column(name = "data_nascimento")
    LocalDate dataNascimento;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    AddressEntity addressEntity;

    @CreationTimestamp
    @Column(name = "data_criacao")
    LocalDateTime creationDate;

    @UpdateTimestamp
    @Column(name = "data_alteracao")
    LocalDateTime updateDate;

    private ClientEntity() {
    }

    public ClientEntity(
            String nome,
            String cpf,
            LocalDate dataNascimento,
            AddressEntity addressEntity
    ) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.addressEntity = addressEntity;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public AddressEntity getAddressEntity() {
        return addressEntity;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }
}