package com.jazztech.STAG2504_ClientApi.infrastructure.repository.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

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
        @JoinColumn(name = "endereco_id", referencedColumnName = "ID")
        AddressEntity address;

        @CreationTimestamp
        @Column(name = "datacriacao")
        LocalDateTime creationDate;

        @UpdateTimestamp
        @Column(name = "data_alteracao")
        LocalDateTime updateDate;

        private ClientEntity() {}

        public ClientEntity(
                String nome,
                String cpf,
                LocalDate dataNascimento,
                AddressEntity address
        ) {
                this.id = UUID.randomUUID();
                this.nome = nome;
                this.cpf = cpf;
                this.dataNascimento = dataNascimento;
                this.address = address;
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

        public AddressEntity getAddress() {
                return address;
        }

        public LocalDateTime getCreationDate() {
                return creationDate;
        }

        public LocalDateTime getUpdateDate() {
                return updateDate;
        }
}