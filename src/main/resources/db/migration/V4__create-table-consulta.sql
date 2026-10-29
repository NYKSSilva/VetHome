CREATE TABLE consulta (
   id INT AUTO_INCREMENT PRIMARY KEY,
   cpf_cliente CHAR(11) NOT NULL,
   id_pet INT NOT NULL,
   convenio VARCHAR(20) NOT NULL,
   data_consulta DATE,
   horario_consulta TIME,
   descricao_consulta CHAR(255),
   servicos VARCHAR(255) NOT NULL,
   status_consulta VARCHAR(20) NOT NULL,

  /*CONSTRAINT fk_consulta_cliente*/
  FOREIGN KEY (cpf_cliente) REFERENCES cliente(cpf),
  /*CONSTRAINT fk_consulta_pet*/
  FOREIGN KEY (id_pet) REFERENCES pet(id)
);