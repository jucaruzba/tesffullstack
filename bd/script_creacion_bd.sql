CREATE DATABASE bd_ruiz;

USE bd_ruiz;

CREATE TABLE person (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    apellido VARCHAR(100),
    fechaNacimiento DATE,
    puesto VARCHAR(100),
    sueldo DECIMAL(10,2)
);

CREATE USER 'conexion'@'localhost' IDENTIFIED BY '123456';
GRANT ALL PRIVILEGES ON bd_ruiz.* TO 'conexion'@'localhost';
FLUSH PRIVILEGES;