CREATE TABLE clientes
    (
        id_cli serial NOT NULL,
        nome text NOT NULL,
        endereco text,
        complemento text,
        cep text,
        cidade text,
        telefone text,
        nascimento date,
        CONSTRAINT pk_id_cli PRIMARY KEY(id_cli)
    )
WITH(
    OIDS = FALSE
);
ALTER TABLE clientes
OWNER TO postgres;