-- Geração de Modelo físico
-- Sql ANSI 2003 - brModelo.

CREATE DATABASE borabora;

USE borabora;

CREATE TABLE Permissoes (
tipo VARCHAR(20),
id_permissao INTEGER PRIMARY KEY AUTO_INCREMENT
);

CREATE TABLE Administradores (
nome VARCHAR(80),
email VARCHAR(80),
senha VARCHAR(10),
id_admin INTEGER PRIMARY KEY AUTO_INCREMENT,
id_permissao INTEGER,
FOREIGN KEY(id_permissao) REFERENCES Permissoes (id_permissao)
);

CREATE TABLE Destinos (
data_ida VARCHAR(10),
destino VARCHAR(50),
horario_ida VARCHAR(5),
data_volta VARCHAR(10),
horario_volta VARCHAR(5),
cia_aerea VARCHAR(50),
hotel VARCHAR(50),
observacoes VARCHAR(1000),
id_destino INTEGER PRIMARY KEY AUTO_INCREMENT,
valor DECIMAL(10),
id_admin INTEGER,
FOREIGN KEY(id_admin) REFERENCES Administradores (id_admin)
);

CREATE TABLE Promocoes (
horario_ida VARCHAR(5),
horario_volta VARCHAR(5),
data_ida VARCHAR(10),
destino VARCHAR(50),
data_volta VARCHAR(10),
cia_aerea VARCHAR(50),
hotel VARCHAR(50),
observacoes VARCHAR(1000),
id_promocao INTEGER PRIMARY KEY AUTO_INCREMENT,
valor_promocional DECIMAL(10),
valor DECIMAL(10),
id_admin INTEGER,
FOREIGN KEY(id_admin) REFERENCES Administradores (id_admin)
);