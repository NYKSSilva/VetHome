CREATE TABLE pet (
      id INT AUTO_INCREMENT PRIMARY KEY,
      nome VARCHAR(100) NOT NULL,
      data_nasc DATE,
      especie ENUM('gato', 'cachoorro') NOT NULL,
      raca VARCHAR(100),
      peso DECIMAL(5,2),
      convenio ENUM('PetLove', 'DogLife', 'Particular'),
--       cpf_usuario CHAR(11) NOT NULL,
      id_usuario tinyint NOT NULL,
      ativo tinyint NOT NULL,

   FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
);
