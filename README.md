Festival API
La API de Festival es una aplicación Spring Boot que permite gestionar información sobre festivales de música. Esta API soporta operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre festivales.

Endpoints
La siguiente tabla describe los endpoints disponibles en la API:

## API Endpoints

| Método   | Ruta                  | Cuerpo (Ejemplo)                            | Descripción                                | Posibles Respuestas          |
|----------|-----------------------|---------------------------------------------|--------------------------------------------|------------------------------|
| `GET`    | `/api/festivales`     | N/A                                         | Obtiene todos los festivales.              | 200 (OK), 500 (Error Interno)|
| `GET`    | `/api/festivales/{id}`| N/A                                         | Obtiene un festival por su ID.             | 200 (OK), 404 (No Encontrado), 500 (Error Interno)|
| `POST`   | `/api/festivales`     | `{ "nombre": "Nombre del Festival", ... }`  | Crea un nuevo festival.                    | 201 (Creado), 500 (Error Interno)|
| `PUT`    | `/api/festivales/{id}`| `{ "nombre": "Nuevo Nombre del Festival", ... }` | Actualiza un festival existente. | 200 (OK), 404 (No Encontrado), 500 (Error Interno)|
| `DELETE` | `/api/festivales/{id}`| N/A                                         | Elimina un festival por su ID.             | 200 (OK), 404 (No Encontrado), 500 (Error Interno)|



Crear un Festival
Para crear un nuevo festival, envía una solicitud POST a /api/festivales con un cuerpo JSON que contenga la información del festival.

Ejemplo de cuerpo de solicitud:

json
{
  "nombre": "MadCool",
  "ciudad": "Madrid",
  "rangoEdad": "18+",
  "fecha": "2024-08-20",
  "duracion": "3 días",
  "tipoMusica": "Pop"
}
Leer Festivales
Para obtener una lista de todos los festivales, envía una solicitud GET a /api/festivales.
Para obtener los detalles de un festival específico, envía una solicitud GET a /api/festivales/{id}.
Actualizar un Festival
Para actualizar un festival existente, envía una solicitud PUT a /api/festivales/{id} con un cuerpo JSON que contenga las actualizaciones.

Eliminar un Festival
Para eliminar un festival, envía una solicitud DELETE a /api/festivales/{id}.



## Gestión de Excepciones

| Excepción                        | Descripción                                                                  | Respuesta HTTP          |
|----------------------------------|------------------------------------------------------------------------------|-------------------------|
| `RecursoNoEncontradoException`   | Se lanza cuando se solicita un recurso que no existe.                        | 404 (No Encontrado)     |
| `Exception` (Genérica)           | Cualquier otra excepción no capturada específicamente.                       | 500 (Error Interno)     |

Gestión de Excepciones
La API utiliza un sistema de manejo de excepciones para proporcionar respuestas claras y precisas en caso de errores. Esto incluye el manejo de casos donde un recurso no se encuentra o cuando ocurre un error interno del servidor.

Excepciones Personalizadas
RecursoNoEncontradoException: Se lanza cuando se solicita un recurso que no existe en la base de datos.
Controlador de Excepciones Global
El GlobalExceptionHandler es un controlador de excepciones a nivel de la aplicación que captura excepciones específicas y cualquier otra excepción no capturada específicamente, proporcionando respuestas HTTP adecuadas.

Manejador de RecursoNoEncontradoException: Retorna una respuesta con estatus 404 Not Found cuando se intenta acceder a un recurso que no existe.
Manejador Global de Excepciones: Captura cualquier otra excepción no manejada específicamente, retornando una respuesta con estatus 500 Internal Server Error.


