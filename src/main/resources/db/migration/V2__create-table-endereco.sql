CREATE TABLE endereco (
     id INT AUTO_INCREMENT PRIMARY KEY,
     logradouro VARCHAR(255) NOT NULL,
     numero INT NOT NULL,
     complemento VARCHAR(100),
     bairro VARCHAR(100) NOT NULL,
     cidade VARCHAR(100) NOT NULL,
     cep CHAR(8) NOT NULL,
     cpfCliente CHAR(11) NOT NULL,

     CONSTRAINT fk_endereco_cliente
         FOREIGN KEY (cpfCliente) REFERENCES cliente(cpf)
);