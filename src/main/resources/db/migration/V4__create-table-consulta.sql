CREATE TABLE consulta (
   id INT AUTO_INCREMENT PRIMARY KEY,
   cpf_cliente CHAR(11) NOT NULL,
   id_pet INT NOT NULL,
   especiePet ENUM(
       'GATO',
       'CACHORRO'
       ) NOT NULL,
   data_hora DATETIME,
   servicos VARCHAR(255) NOT NULL,
   statusConsulta ENUM(
        'ativa',
        'cancelada',
        'finalizada'
    ) NOT NULL,
  /*CONSTRAINT fk_consulta_cliente*/
  FOREIGN KEY (cpf_cliente) REFERENCES cliente(cpf),
  /*CONSTRAINT fk_consulta_pet*/
  FOREIGN KEY (id_pet) REFERENCES pet(id)
);