CREATE TABLE pet (
      id INT AUTO_INCREMENT PRIMARY KEY,
      nome VARCHAR(100) NOT NULL,
      data_nasc DATE,
      especie ENUM('GATO', 'CACHORRO') NOT NULL,
      sexo ENUM('FEMEA', 'MACHO') NOT NULL,
      raca VARCHAR(100),
      peso DECIMAL(5,2),
      cpf_cliente CHAR(11) NOT NULL,
--    idCliente tinyint NOT NULL,
      ativo tinyint NOT NULL,

--    CONSTRAINT fk_pet_cliente
      FOREIGN KEY (cpf_Cliente) REFERENCES cliente(cpf)
--    FOREIGN KEY (idCliente) REFERENCES cliente(id)
);
