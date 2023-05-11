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
        rua varchar(30),
        bairro varchar(30),
        uf varchar(2),
        cidade varchar(30),
        numero integer,
        complemento varchar(40),
        cep varchar(9),
        data_criacao timestamp,
        data_alteracao timestamp,
        PRIMARY KEY (id)
);

ALTER TABLE CLIENTE
ADD CONSTRAINT fk_address_id
FOREIGN KEY (endereco_id) REFERENCES ENDERECO (id);