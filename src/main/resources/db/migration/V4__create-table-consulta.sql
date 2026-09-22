CREATE TABLE consulta (
   id INT AUTO_INCREMENT PRIMARY KEY,
   id_usuario INT NOT NULL,
   nome_usuario VARCHAR(100) NOT NULL,
   id_pet INT NOT NULL,
   especie_pet ENUM('gato', 'cachorro') NOT NULL,
   data_hora DATETIME,
   servicos VARCHAR(255) NOT NULL,
   status_consulta ENUM(
        'ativa',
        'cancelada',
        'finalizada'
    ) NOT NULL,
  FOREIGN KEY (id_usuario) REFERENCES usuarios(id),
  FOREIGN KEY (id_pet) REFERENCES pet(id)
);