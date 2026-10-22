CREATE TABLE consulta (
   id INT AUTO_INCREMENT PRIMARY KEY,
   cpf_cliente CHAR(11) NOT NULL,
   id_pet INT NOT NULL,
   convenio ENUM('PetLove', 'DogLife', 'Particular'),
   especie_pet ENUM(
       'GATO',
       'CACHORRO'
       ),
   data_hora DATETIME,
   servicos VARCHAR(255) NOT NULL,
   status_consulta ENUM(
        'ativa',
        'cancelada',
        'finalizada'
    ) NOT NULL,
  /*CONSTRAINT fk_consulta_cliente*/
  FOREIGN KEY (cpf_cliente) REFERENCES cliente(cpf),
  /*CONSTRAINT fk_consulta_pet*/
  FOREIGN KEY (id_pet) REFERENCES pet(id)
);