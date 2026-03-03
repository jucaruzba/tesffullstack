# 🚀 CRUD Personas - Backend API

Solución para Prueba Técnica Fullstack desarrollada con Java 21 y Spring Boot. Este módulo se encarga de la lógica de negocio y persistencia de la entidad Person.

---

## 🛠️ Tech Stack

- Lenguaje: Java 21
- Framework: Spring Boot 3.x
- Persistencia: Spring Data JPA / Hibernate
- Base de Datos: MySQL 8.0 (Configurada en repositorio externo)
- Build Tool: Maven
- Librerías: Lombok

---

## ⚙️ Configuración y Acceso

### 1. Clonación del Proyecto

git clone https://github.com/jucaruzba/tesffullstack

cd tesffullstack

git checkout ruiz_backend

cd ruiz_backend

### 2. Conexión a Base de Datos

La base de datos ya debe existir. Ajusta las credenciales en src/main/resources/application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/bd_ruiz
spring.datasource.username=conexion
spring.datasource.password=123456
spring.jpa.hibernate.ddl-auto=none
server.port=8080

---

## 🚀 Ejecución

### Compilar y Correr

mvn clean install
mvn spring-boot:run

### API Endpoints (Base URL: http://localhost:8080/persons)

- GET /persons -> Lista todos los registros.
- GET /persons/{id} -> Detalle por ID.
- POST /persons -> Crear nuevo registro.
- PUT /persons/{id} -> Actualizar registro existente.
- DELETE /persons/{id} -> Eliminar registro.

### Estructura de Respuesta Unificada

{
"status": true,
"msg": "Mensaje descriptivo",
"data": []
}

---

## 📂 Organización del Código

- controller/: Endpoints REST.
- service/: Lógica de negocio y validaciones.
- repository/: Interfaces de Spring Data JPA.
- entity/: Mapeo de tablas de base de datos.
- dto/: Data Transfer Objects para respuestas.

---

## 📂 Notas de Entrega

- Rama del repositorio: ruiz_backend
- Documentación visual: Capturas de pantalla disponibles en la carpeta /postman.

---

## 👤 Autor

Juan Carlos Ruiz Bárcenas - Software Engineer
