CREATE TABLE tb_users (
    id SERIAL PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    balance NUMERIC(19, 2) NOT NULL,
    created_at TIMESTAMP NOT NULL
);