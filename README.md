# Práctica 01 – Catálogo de suculentas

Aplicación web en Spring Boot para administrar un catálogo de suculentas: permite ver el listado, registrar, editar y eliminar suculentas guardadas en MySQL.

**Estudiante:** Alejandro Chavarría Ramírez
**Curso:** SC-403 Desarrollo de Aplicaciones Web y Patrones

## Tecnologías

- Java 21 y Spring Boot 4.1.1 (Spring Web, Thymeleaf, Validation, DevTools, Lombok)
- Spring Data JPA / Hibernate con MySQL
- Bootstrap 5 por medio de webjars

## Cómo ejecutarlo

1. **Crear la base de datos.** En MySQL Workbench, conectado como `root`, abrir y ejecutar el script `sql/practica.sql`. El script crea:
   - la base de datos `practica`
   - el usuario `usuario_practica` con clave `la_Clave`
   - la tabla `suculenta` con 5 registros de prueba

   Si MySQL da el error 1819 al crear el usuario, se debe ejecutar primero `SET GLOBAL validate_password.policy = LOW;` y luego volver a correr el script.

2. **Abrir el proyecto.** En NetBeans: *File → Open Project* y seleccionar la carpeta `practica01`.

3. **Compilar.** Clic derecho sobre el proyecto → *Clean and Build*. MySQL tiene que estar encendido, porque la prueba que trae el proyecto se conecta a la base de datos.

4. **Ejecutar.** Clic derecho → *Run* (o F6) y esperar el mensaje `Tomcat started on port 91`.

5. **Entrar a la aplicación** en el navegador: <http://localhost:91>

## Configuración (`application.properties`)

| Propiedad | Valor |
|---|---|
| Puerto | `91` |
| Base de datos | `jdbc:mysql://localhost:3306/practica` |
| Usuario / clave | `usuario_practica` / `la_Clave` |
| Log | nivel `TRACE`, cada línea empieza con día del mes, hora y minuto (`dd HH:mm`) |

## Estructura

```
src/main/java/com/practica01
 ├─ domain/Suculenta.java                  entidad mapeada a la tabla suculenta
 ├─ repository/SuculentaRepository.java    acceso a datos con JPA
 ├─ service/SuculentaService.java          lógica del catálogo
 └─ controller
     ├─ SuculentaController.java           rutas /suculenta/listado, /guardar y /eliminar
     └─ InicioController.java              la raíz / redirige al catálogo
src/main/resources
 ├─ templates/plantilla.html               cabeza, encabezado con menú, avisos y pie
 ├─ templates/suculenta/listado.html       página del catálogo
 ├─ templates/suculenta/componentes.html   tarjetas y formulario modal
 ├─ static/js/suculenta.js                 llena el formulario y confirma la eliminación
 └─ messages.properties                    textos de la aplicación
sql/practica.sql                           script de la base de datos
```

## Uso

- **Ver:** el catálogo muestra una tarjeta por cada suculenta de la base de datos.
- **Registrar:** botón *Nueva suculenta*, llenar el formulario y *Guardar*.
- **Editar:** botón *Editar* en la tarjeta; el formulario se abre con los datos cargados.
- **Eliminar:** botón *Eliminar* en la tarjeta y confirmar.

Las imágenes no se guardan en el proyecto: cada suculenta guarda el enlace (URL) de una imagen que está en internet.
