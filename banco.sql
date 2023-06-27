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
    salario FLOAT(5,2) NOT NULL);
    
CREATE TABLE Alunos(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    senha VARCHAR(30) NOT NULL,
    cpf VARCHAR(11),
    dataNascimento DATE NOT NULL,
    endereco VARCHAR(100) NOT NULL,
	telefone VARCHAR(11) NOT NULL,
    responsavel VARCHAR(100) NOT NULL,
    telefoneResponsavel VARCHAR(11) NOT NULL);
    
CREATE TABLE Disciplinas(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    idAluno INT NOT NULL,
    FOREIGN KEY (idAluno) REFERENCES Alunos(id),
    idProfessor INT NOT NULL,
    FOREIGN KEY (idProfessor) REFERENCES Professores(id));
    
INSERT INTO Administradores (usuario, senha) VALUES ("tomas", "tomas"), ("gaby", "gaby");
    