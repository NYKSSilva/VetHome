CREATE TABLE consulta (
   id INT AUTO_INCREMENT PRIMARY KEY,
   nome_usuario VARCHAR(100) NOT NULL,
   cpf_usuario CHAR(11) NOT NULL,
   id_pet INT NOT NULL,
   especie_pet ENUM('gato', 'cachorro') NOT NULL,
   data_hora DATETIME,
   servicos VARCHAR(255) NOT NULL,
   statusConsulta ENUM(
        'ativa',
        'cancelada',
        'finalizada'
    ) NOT NULL,
  FOREIGN KEY (nome_usuario) REFERENCES usuarios(nome),
  FOREIGN KEY (id_pet) REFERENCES pet(id)
);