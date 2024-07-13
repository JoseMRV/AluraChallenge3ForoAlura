# 🌐 Challenge 3 Foro Alura 🌐

En este último challenge creamos un Foro donde los participantes pueden crear/responder preguntas sobre diferentes temas. 

## 📋Requisitos 📋

- Java 17.
- Spring Boot.
- Spring Data JPA.
- Validation.
- MySQL.
- Flyway Migration.
- Lombok.
- JWT.

## ⚙️ Configuración ⚙️ 

Cuando descargue este proyecto , primero debe crear una base de datos en MySQL.  

⚠️ Después debe configurar las siguientes variables de entorno en su sistema: ⚠️

* `${DB_HOST}` : Por defecto localhost.
* `${DB_NAME}` : Nombre de la base de datos.
* `${DB_USER}` : El usuario definido en MySQL.
* `${DB_PASS}` : Contraseña definida en MySQL.

## 📄Descripción 📄

La API permite:  ✅

- **Registrar/ Modificar/ Eliminar un usuario.**
- **Crear un tema/ Modificar un tema/ Mostrar los temas creados/ Actualizar un tema/ Eliminar un tema.**
- **Crear una respuesta/ Modificar una respuesta/ Borrar una respuesta.**

Endpoints disponibles:  ✅

* `POST /usuario` : Registrar usuario.
* `POST /login` : Autenticación de usuario.
* `POST /temas` : Crear un nuevo tema.
* `PUT /temas/{id}` : Actualizar un tema.
* `GET /temas` : Muestra todos los temas.
* `GET /tema/{id}` : Muestra tema por id.
* `DELETE /tema` : Borra el tema.
* `POST /respuestas` : Agrega una respuesta a un tema.
* `PUT /respuestas/{id}` : Actualiza una respuesta.
* `DELETE /respuestas/{id}` : Borra una respuesta.

## ⚠️ Atención ⚠️

👀 Las solicitudes que se hagan para modificar información (`POST, PUT, DELETE`) requiere que sean autenticadas por un ***Bearer token*** en la opción de autorización. (`POST /login`)

Gracias por visitar mi proyecto 🤝
