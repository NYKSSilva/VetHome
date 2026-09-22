CREATE TABLE endereco (
     id INT AUTO_INCREMENT PRIMARY KEY,
     logradouro VARCHAR(255) NOT NULL,
     numero INT NOT NULL,
     complemento VARCHAR(100),
     bairro VARCHAR(100) NOT NULL,
     cidade VARCHAR(100) NOT NULL,
     cep CHAR(8) NOT NULL,
     id_usuario INT NOT NULL,
--      cpf_usuario CHAR(11) NOT NULL,
     ativo tinyint NOT NULL,

         FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
);