-- 1. Crear la base de datos
CREATE DATABASE IF NOT EXISTS accesoDatosDAM;
USE accesoDatosDAM;

-- 2. Tabla de Equipos
CREATE TABLE equipos (
    idEquipo INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100)
);

-- 3. Tabla de Periféricos (Relación 1:1 con Jugador)
CREATE TABLE perifericos (
    idPeriferico INT AUTO_INCREMENT PRIMARY KEY,
    modelo VARCHAR(100)
);

-- 4. Tabla de Jugadores
CREATE TABLE jugadores (
    idJugador INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    idEquipo INT,
    idPeriferico INT,
    CONSTRAINT fk_equipo FOREIGN KEY (idEquipo) REFERENCES equipos(idEquipo) ON DELETE SET NULL,
    CONSTRAINT fk_periferico FOREIGN KEY (idPeriferico) REFERENCES perifericos(idPeriferico) ON DELETE SET NULL
);

-- 5. Tabla de Patrocinadores
CREATE TABLE patrocinadores (
    idPatrocinador INT AUTO_INCREMENT PRIMARY KEY,
    marca VARCHAR(100) NOT NULL
);

-- 6. Tabla de Entrenadores
CREATE TABLE entrenadores (
    idEntrenador INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    idEquipo INT,
    CONSTRAINT fk_equipo_entrenador FOREIGN KEY (idEquipo) REFERENCES equipos(idEquipo)
);

-- 7. Tabla de Juegos
CREATE TABLE juegos (
    idJuego INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    genero VARCHAR(50)
);

INSERT INTO equipos (nombre) VALUES ('KOI'), ('G2 Esports'), ('Team Heretics'), (NULL);

INSERT INTO patrocinadores (marca) VALUES ('Red Bull'), ('Logitech'), ('Disney+'), ('Nike');

INSERT INTO jugadores (nombre, idEquipo) VALUES ('Elyoya', 1), ('Caps', 2), ('Flakked', 3), ('Zwyroo', 3);