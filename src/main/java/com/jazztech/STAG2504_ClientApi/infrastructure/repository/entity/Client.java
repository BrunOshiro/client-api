package com.jazztech.STAG2504_ClientApi.infrastructure.repository.entity;

import org.hibernate.validator.constraints.br.CPF;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "CLIENTE")
public class Client{

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;

        @Column(name = "NOME")
        @Size(min = 5, max = 40, message = "O campo 'Nome' deve ter 5 a 40 caracteres")
        String nome;

        @CPF
        @Column(name = "CPF")
        String cpf;

        @Column(name = "DATA_NASCIMENTO")
        LocalDate dataNascimento;

        @Column(name = "ENDERECO_CEP")
        @NotBlank(message = "O campo 'CEP' não pode estar em branco")
        @Size(min = 8, max = 8, message = "O campo 'CEP' deve ter 8 dígitos (apenas números)")
        String cep;

        @Column(name = "ENDERECO_NUMERO")
        @NotBlank(message = "O campo 'Número' não pode estar em branco (caso não possua número informar: 0)")
        @Size(min = 1, max = 8, message = "O campo 'Número' deve estar entre 1 e 8 caracteres")
        Integer enderecoNumero;

        @Column(name = "ENDERECO_COMPLEMENTO")
        @Size(min = 0, max = 40, message = "O campo 'Complemento' possui limite 40 caracteres")
        String enderecoComplemento;

        @Column(name = "ENDERECO_RUA")
        @NotBlank(message = "O campo rua deve ser preenchido")
        @Size(min = 3, max = 30, message = "O campo 'Rua' possui limite 30 caracteres")
        String enderecoRua;

        @Column(name = "ENDERECO_BAIRRO")
        @NotBlank(message = "O campo 'Bairro' não pode estar em branco")
        @Size(min = 3, max = 30, message = "O campo 'Bairro' possui limite 30 caracteres")
        String enderecoBairro;

        @Column(name = "ENDERECO_CIDADE")
        @NotBlank(message = "O campo 'Cidade' não pode estar em branco")
        @Size(min = 3, max = 30, message = "O campo 'Cidade' possui limite 30 caracteres")
        String enderecoCidade;

        @Column(name = "ENDERECO_UF")
        @NotBlank(message = "O endereço não pode estar em branco")
        @Size(min = 2, max = 2, message = "O campo 'UF' possui limite 2 caracteres. Deve ser preenchida apenas a sigla do estado.")
        String enderecoUf;

        public Long getId() {
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

        public void setId(Long id) {
                this.id = id;
        }

        public void setNome(String nome) {
                this.nome = nome;
        }

        public void setCpf(String cpf) {
                this.cpf = cpf;
        }

        public void setDataNascimento(LocalDate dataNascimento) {
                this.dataNascimento = dataNascimento;
        }

        public void setCep(String cep) {
                this.cep = cep;
        }

        public void setEnderecoNumero(Integer enderecoNumero) {
                this.enderecoNumero = enderecoNumero;
        }

        public void setEnderecoComplemento(String enderecoComplemento) { this.enderecoComplemento = enderecoComplemento; }

        public void setEnderecoRua(String enderecoRua) {
                this.enderecoRua = enderecoRua;
        }

        public void setEnderecoBairro(String enderecoBairro) {
                this.enderecoBairro = enderecoBairro;
        }

        public void setEnderecoCidade(String enderecoCidade) {
                this.enderecoCidade = enderecoCidade;
        }

        public void setEnderecoUf(String enderecoUf) {
                this.enderecoUf = enderecoUf;
        }
}