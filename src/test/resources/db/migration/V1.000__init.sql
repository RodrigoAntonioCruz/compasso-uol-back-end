CREATE TABLE cidade (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  nome varchar(155) NOT NULL,
  estado varchar(10) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE cliente (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  nome varchar(155) NOT NULL,
  idade int(20) NOT NULL,
  data_nascimento date NOT NULL,
  sexo varchar(10) NOT NULL,
  cidade_id bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT CIDADE_CLIENTE_ID_FK FOREIGN KEY (cidade_id)
  REFERENCES cidade(id)
);

INSERT INTO cidade VALUES (1, 'Porto Alegre', 'RS');
INSERT INTO cidade VALUES (2, 'Florianópolis', 'SC');
INSERT INTO cidade VALUES (3, 'Uruguaiana', 'RS');
INSERT INTO cidade VALUES (4, 'Curitiba', 'PR');
INSERT INTO cidade VALUES (5, 'Chapecó', 'SC');
INSERT INTO cidade VALUES (6, 'Fortaleza', 'CE');
INSERT INTO cidade VALUES (7, 'São Paulo', 'SP');
INSERT INTO cidade VALUES (8, 'Jundiaí', 'SP');
INSERT INTO cidade VALUES (9, 'Belford Roxo', 'RJ');
INSERT INTO cidade VALUES (10, 'Rio de Janeiro', 'RJ');

INSERT INTO cliente  VALUES (1, 'Rodrigo Cruz', '36', '1985-06-28', 'M', 1);
INSERT INTO cliente  VALUES (2, 'Antonio Cezar', '38', '1983-03-25', 'M', 3);
INSERT INTO cliente  VALUES (3, 'Jane Carla', '41', '1980-04-30', 'F', 10);
INSERT INTO cliente  VALUES (4, 'Junior Silva', '37', '1984-06-28', 'M', 4);
INSERT INTO cliente  VALUES (5, 'André Augusto Santos', '43', '1978-08-25', 'M', 1);
INSERT INTO cliente  VALUES (6, 'Flavia Ana Costa', '48', '1973-10-05', 'F', 3);
INSERT INTO cliente  VALUES (7, 'Fábio Pires', '48', '1973-01-25', 'M', 6);
INSERT INTO cliente  VALUES (8, 'Flavio Hulk ', '43', '1978-02-20', 'M', 4);
INSERT INTO cliente  VALUES (9, 'Carla Santos da Silva', '41', '1980-04-29', 'F', 4);
INSERT INTO cliente  VALUES (10, 'Clarisse da Rosa', '37', '1984-10-20', 'F', 8);