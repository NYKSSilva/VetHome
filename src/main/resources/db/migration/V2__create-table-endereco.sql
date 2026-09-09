CREATE TABLE endereco (
     id INT AUTO_INCREMENT PRIMARY KEY,
     logradouro VARCHAR(255) NOT NULL,
     numero INT NOT NULL,
     complemento VARCHAR(100),
     bairro VARCHAR(100) NOT NULL,
     cidade VARCHAR(100) NOT NULL,
     cep CHAR(8) NOT NULL,
--   idCliente tinyint NOT NULL,
     cpf_cliente CHAR(11) NOT NULL,
     ativo tinyint NOT NULL,

    /*CONSTRAINT fk_endereco_cliente*/
         FOREIGN KEY (cpf_cliente) REFERENCES cliente(cpf)
);