-- Geração de Modelo físico
-- Sql ANSI 2003 - brModelo.



CREATE DATABASE borabora;

USE borabora;

CREATE TABLE Destino (
id INTEGER PRIMARY KEY AUTO_INCREMENT,
destino VARCHAR(50),
data_ida DATE,
horario_ida TIME,
data_volta DATE,
horario_volta TIME,
cia_aerea VARCHAR(50),
hotel VARCHAR(50),
observacoes VARCHAR(100),
valor DECIMAL(10)
);

CREATE TABLE Promocao (
id INTEGER PRIMARY KEY AUTO_INCREMENT,
destino VARCHAR(50),
data_ida DATE,
horario_ida TIME,
data_volta DATE,
horario_volta TIME,
cia_aerea VARCHAR(50),
hotel VARCHAR(50),
observacoes VARCHAR(100),
valor DECIMAL(10),
valor_promocional DECIMAL(10)
);