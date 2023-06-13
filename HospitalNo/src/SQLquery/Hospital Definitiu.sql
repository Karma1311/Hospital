
CREATE DATABASE Hospital2

-- Crear la taula Metges
CREATE TABLE Metges (
    NIF VARCHAR(9) PRIMARY KEY,
    Nom VARCHAR(50),
    Cognoms VARCHAR(50),
    Especialitats VARCHAR(100),
    Correu VARCHAR(50),
    HorariDeFeina VARCHAR(50)
);

-- Crear la taula Consultes
CREATE TABLE Consultes (
    ID INT PRIMARY KEY IDENTITY,
    Dia DATE,
    Hora TIME,
    Lloc VARCHAR(50),
    Metge_NIF VARCHAR(9) FOREIGN KEY REFERENCES Metges(NIF),
    Pacient_NIF VARCHAR(9) FOREIGN KEY REFERENCES Pacients(NIF),
	Infermer_NIF VARCHAR (9) FOREIGN KEY REFERENCES Infermeres(NIF)
);


-- Crear la taula Infermeres
CREATE TABLE Infermeres (
    NIF VARCHAR(9) PRIMARY KEY,
    Nom VARCHAR(50),
    Cognoms VARCHAR(50),
    Correu VARCHAR(50),
    HorariDeFeina VARCHAR(50),
    Telefon VARCHAR(15)
);

-- Crear la taula Pacients
CREATE TABLE Pacients (
    NIF VARCHAR(9) PRIMARY KEY,
    Nom VARCHAR(50),
    Cognoms VARCHAR(50),
    Edat INT,
    Sexe CHAR(1),
    TipusDeSang VARCHAR(10),
    HistorialClinic VARCHAR(200),
    Telefon VARCHAR(15),
    Correu VARCHAR(50),
    Alergies VARCHAR(200)
);
