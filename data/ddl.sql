CREATE TABLE IF NOT EXISTS CLIENT(
        id uuid NOT NULL,
        nome varchar(300),
        cpf varchar(11) UNIQUE,
        data_nascimento date,
        endereco_id uuid unique,
        data_criacao timestamp,
        data_alteracao timestamp,
        PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS ADDRESS(
        id uuid NOT NULL,
        rua varchar(256),
        bairro varchar(100),
        uf varchar(2),
        cidade varchar(100)
        numero integer,
        complemento varchar(256),
        cep varchar(9),
        data_criacao timestamp,
        data_alteracao timestamp,
        PRIMARY KEY (id)
);

ALTER TABLE CLIENT
ADD CONSTRAINT fk_address_id
FOREIGN KEY (address_id) REFERENCES ADDRESS (id);