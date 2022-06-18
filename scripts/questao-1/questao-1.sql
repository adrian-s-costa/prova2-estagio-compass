CREATE DATABASE loja;
USE loja;

CREATE TABLE PRODUTO (
	 id int NOT NULL AUTO_INCREMENT,
     nome VARCHAR(100),
     descricao VARCHAR(200),
     quantidade INT,
     preco FLOAT,
     PRIMARY KEY (id)
);