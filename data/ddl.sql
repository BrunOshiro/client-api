CREATE TABLE IF NOT EXISTS CLIENTE(
        id uuid NOT NULL,
        nome varchar(100),
        cpf varchar(11) UNIQUE,
        data_nascimento date,
        endereco_id uuid unique,
        data_criacao timestamp,
        data_alteracao timestamp,
        PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS ENDERECO(
        id uuid NOT NULL,
        rua varchar(100),
        bairro varchar(100),
        uf varchar(2),
        cidade varchar(100),
        numero integer,
        complemento varchar(100),
        cep varchar(9),
        data_criacao timestamp,
        data_alteracao timestamp,
        PRIMARY KEY (id)
);

ALTER TABLE CLIENTE
ADD CONSTRAINT fk_address_id
FOREIGN KEY (endereco_id) REFERENCES ENDERECO (id);