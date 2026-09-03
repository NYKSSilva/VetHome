CREATE TABLE pet (
      id INT AUTO_INCREMENT PRIMARY KEY,
      nome VARCHAR(100) NOT NULL,
      dataNasc DATE,
      especie ENUM('GATO', 'CACHORRO') NOT NULL,
      raca VARCHAR(100),
      peso DECIMAL(5,2),
      convenio ENUM('PetLove', 'DogLife', 'Particular'),
      cpfCliente CHAR(11) NOT NULL,
      ativo tinyint NOT NULL,

--    CONSTRAINT fk_pet_cliente
      FOREIGN KEY (cpfCliente) REFERENCES cliente(cpf)
);
