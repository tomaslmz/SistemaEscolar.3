CREATE DATABASE SistemaEscolar;
USE SistemaEscolar;

CREATE TABLE Administradores(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    usuario VARCHAR(10) UNIQUE NOT NULL,
    senha VARCHAR(30) NOT NULL);

CREATE TABLE Professores(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    senha VARCHAR(30) NOT NULL,
    cpf VARCHAR(11) NOT NULL,
    dataNascimento DATE NOT NULL,
    endereco VARCHAR(100) NOT NULL,
	telefone VARCHAR(11) NOT NULL,
    salario FLOAT NOT NULL);
    
CREATE TABLE Alunos(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    senha VARCHAR(30) NOT NULL,
    cpf VARCHAR(11) NOT NULL,
    dataNascimento DATE NOT NULL,
    endereco VARCHAR(100) NOT NULL,
	telefone VARCHAR(11) NOT NULL,
    responsavel VARCHAR(100) NOT NULL,
    telefoneResponsavel VARCHAR(11) NOT NULL);
    
INSERT INTO Administradores (usuario, senha) VALUES ("tomas", "tomas"), ("gaby", "gaby");
    