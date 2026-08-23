CREATE TABLE consulta (
   id INT AUTO_INCREMENT PRIMARY KEY,
   cpfCliente CHAR(11) NOT NULL,
   idPet INT NOT NULL,
   dataHora DATETIME,
   servicos VARCHAR(255) NOT NULL,
   statusConsulta ENUM(
        'ativo',
        'cancelada',
        'emAndamento',
        'finalizada'
    ),
  /*CONSTRAINT fk_consulta_cliente*/
  FOREIGN KEY (cpfCliente) REFERENCES cliente(cpf),
  /*CONSTRAINT fk_consulta_pet*/
  FOREIGN KEY (idPet) REFERENCES pet(id)
);