CREATE DATABASE loja_filmes;
USE loja_filmes;

CREATE TABLE filmes (
	id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100),
    descricao VARCHAR(200),
    ano YEAR,
    PRIMARY KEY (id)
);

insert into filmes (nome, descricao, ano) VALUES ('Birdman', 'Filme Birdman', '2014');
insert into filmes (nome, descricao, ano) VALUES ('The Silence of the Lambs', 'Filme The Silence of the Lambs', '1991');
insert into filmes (nome, descricao, ano) VALUES ('The Thing', 'Filme The Thing', '1982');
insert into filmes (nome, descricao, ano) VALUES ('Memories of Murder', 'Filme Memories of Murder', '2003');
insert into filmes (nome, descricao, ano) VALUES ('Uncut Gems', 'Filme Uncut Gems', '2019');
insert into filmes (nome, descricao, ano) VALUES ('Moonlight', 'Filme Moonlight', '2016');
insert into filmes (nome, descricao, ano) VALUES ('Naked Lunch', 'Filme Naked Lunch', '1991');
insert into filmes (nome, descricao, ano) VALUES ('Network', 'Filme Network', '1976');
insert into filmes (nome, descricao, ano) VALUES ('The Lighthouse', 'Filme The Lighthouse', '2019');
insert into filmes (nome, descricao, ano) VALUES ('Eternal Sunshine of a Spotless Mind', 'Filme Eternal Sunshine of a Spotless Mind', '2004');
insert into filmes (nome, descricao, ano) VALUES ('Get Out', 'Filme Get Out', '2017');
insert into filmes (nome, descricao, ano) VALUES ('Bacurau', 'Filme Bacurau', '2019');
insert into filmes (nome, descricao, ano) VALUES ('Her', 'Filme Her', '2013');
insert into filmes (nome, descricao, ano) VALUES ('American History X', 'Filme American History X', '1998');
insert into filmes (nome, descricao, ano) VALUES ('The House That Jack Built', 'Filme The House That Jack Built', '2018');
insert into filmes (nome, descricao, ano) VALUES ('Punch Drunk Love', 'Punch Drunk Love', '2002');
insert into filmes (nome, descricao, ano) VALUES ('The Exorcist', 'Filme The Exorcist', '1973');
insert into filmes (nome, descricao, ano) VALUES ('Ghostbusters', 'Filme Ghostbusters', '1984');
insert into filmes (nome, descricao, ano) VALUES ('Rocky', 'Filme Rocky', '1976');
insert into filmes (nome, descricao, ano) VALUES ('Fargo', 'Filme Fargo', '1996');