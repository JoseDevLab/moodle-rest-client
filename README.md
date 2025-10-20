# Moodle REST Client Library

Una librería de cliente en Java para interactuar con la API de servicios web de Moodle, construida siguiendo los principios de la Arquitectura Hexagonal y SOLID para garantizar un código limpio, mantenible y escalable.

## Características

Actualmente, la librería soporta las siguientes funciones de la API de Moodle:

- **`core_course_get_categories`**: Obtiene una lista de las categorías de cursos.
- **`core_course_create_categories`**: Crea una o más categorías de cursos nuevas.
- **`gradereport_user_get_grade_items`**: Obtiene los ítems de calificación para un usuario en un curso específico.

## Arquitectura y Estructura de Paquetes

Este proyecto está diseñado utilizando **Arquitectura Hexagonal** (Puertos y Adaptadores) con una estructura de paquetes muy definida para máxima claridad y escalabilidad.

- **`domain`**: El núcleo de la aplicación. No tiene dependencias externas.
    - **`models`**: Los objetos de dominio puros (ej: `Category`).
    - **`requests`**: Objetos que representan los datos para peticiones de escritura (ej: `CreateCategoryRequest`).
    - **`responses`**: Objetos que representan estructuras de datos de respuesta (ej: `BulkCategoryCreationResponse`).
    - **`exceptions`**: Excepciones personalizadas del dominio (ej: `MoodleApiException`).
    - **`ports/in`**: Los puertos de entrada (interfaces de casos de uso), organizados por `{componente}/{entidad}`.
    - **`ports/out`**: Los puertos de salida (interfaces para la infraestructura), organizados por `{componente}`.

- **`application`**: Orquesta los casos de uso.
    - **`services`**: Implementaciones de los casos de uso, organizadas por `{componente}`.

- **`infrastructure`**: Implementa la comunicación con el mundo exterior.
    - **`outputs`**: Contiene los adaptadores de salida.
        - **`adapters`**: Implementaciones de los puertos de salida, organizados por `{componente}/{entidad}`.
        - **`client`**: El cliente HTTP centralizado.
        - **`dtos`**: Objetos de Transferencia de Datos, organizados por `{componente}/{entidad}`.
        - **`mappers`**: Interfaces de MapStruct para el mapeo entre DTOs y modelos de dominio.
        - **`config`**: Configuración de beans de Spring.

## Tecnologías

- Java 1.8
- Spring Framework (para Inyección de Dependencias)
- Maven
- **MapStruct**: Para la generación automática de mappers, eliminando código repetitivo.
- Lombok

## Proyectos Objetivo y Dependencias

Esta librería está construida como un **"fat jar" aislado (shaded)**. Esto significa que todas sus dependencias necesarias (como Spring, Jackson, etc.) están incluidas dentro del propio JAR, pero en un paquete reubicado (`moodle.shaded.*`).

### ¿Qué significa esto para ti?

- **Proyectos Objetivo**: La librería está diseñada para ser usada en **proyectos de Java puro** o en aplicaciones grandes ya existentes donde no se desea gestionar un árbol de dependencias complejo. Simplemente puedes añadir el JAR al classpath y funcionará.

- **Sin Conflictos de Versiones**: Gracias al "shading", las versiones de las dependencias usadas por esta librería (ej. Spring) están aisladas y **no entrarán en conflicto** con las versiones que pueda tener tu proyecto principal. Esto la hace segura para integrar en entornos complejos.

- **Dependencias de Entorno**: La librería solo asume que el entorno de ejecución proveerá la **API de Servlets de Java** (estándar en servidores de aplicaciones como Tomcat, JBoss, etc.).

## Instalación

Para usar esta librería en tu proyecto, primero necesitas instalarla en tu repositorio local de Maven.

1. Clona este repositorio.
2. Navega a la raíz del proyecto y ejecuta:

```bash
mvn clean install
```

3. Añade la siguiente dependencia al `pom.xml` de tu proyecto:

```xml
<dependency>
    <groupId>org.moodle.api.client</groupId>
    <artifactId>moodle-rest-client</artifactId>
    <version>0.0.1</version>
</dependency>
```

## Guía de Inicio Rápido

A continuación se muestra un ejemplo completo de cómo inicializar y utilizar la librería, incluyendo el manejo de errores.

```java
import org.moodle.api.client.moodle_rest_client.Moodle;
import org.moodle.api.client.moodle_rest_client.domain.exceptions.MoodleApiException;
import org.moodle.api.client.moodle_rest_client.domain.models.*;
import org.moodle.api.client.moodle_rest_client.domain.ports.in.course.category.*;
import org.moodle.api.client.moodle_rest_client.domain.ports.in.course.course.CreateCoursesUseCase;
import org.moodle.api.client.moodle_rest_client.domain.ports.in.gradereport.gradeitem.GetUserGradeItemsUseCase;
import org.moodle.api.client.moodle_rest_client.domain.requests.course.category.CreateCategoryRequest;
import org.moodle.api.client.moodle_rest_client.domain.requests.course.category.RecursiveCategoryRequest;
import org.moodle.api.client.moodle_rest_client.domain.requests.course.course.CreateCourseRequest;
import org.moodle.api.client.moodle_rest_client.domain.responses.course.category.BulkCategoryCreation;
import org.moodle.api.client.moodle_rest_client.domain.responses.course.category.BulkCategoryCreationResponse;
import org.moodle.api.client.moodle_rest_client.domain.responses.gradereport.gradeItem.GradeItems;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainApplication {
    public static void main(String[] args) {
        // 1. Define tus credenciales de Moodle
        String moodleUrl = "https://your-moodle-site.com/webservice/rest/server.php";
        String moodleToken = "your-moodle-api-token";

        // 2. Inicializa la librería una sola vez
        Moodle.init(moodleUrl, moodleToken);

        try {
            // --- EJEMPLO 1: Obtener todas las categorías ---
            System.out.println("--- Obteniendo categorías...");
            GetCourseCategoriesUseCase getCategoriesUseCase = Moodle.getBean(GetCourseCategoriesUseCase.class);
            List<Category> categories = getCategoriesUseCase.getCourseCategories();
            categories.forEach(System.out::println);

            // --- EJEMPLO 2: Crear una nueva categoría simple ---
            System.out.println("\n--- Creando una nueva categoría simple...");
            CreateCategoriesUseCase createCategoriesUseCase = Moodle.getBean(CreateCategoriesUseCase.class);
            CreateCategoryRequest newCategoryRequest = CreateCategoryRequest.builder()
                    .name("Nueva Categoría Simple")
                    .idnumber("CAT-SIMPLE-01")
                    .parent(0L)
                    .build();
            List<Category> createdCategories = createCategoriesUseCase.createCategories(Collections.singletonList(newCategoryRequest));
            createdCategories.forEach(System.out::println);

            // --- EJEMPLO 3: Creación Recursiva de Categorías ---
            System.out.println("\n--- Creando árbol de categorías...");
            BulkCreateCategoriesUseCase bulkCreateUseCase = Moodle.getBean(BulkCreateCategoriesUseCase.class);
            RecursiveCategoryRequest parentCat = RecursiveCategoryRequest.builder()
                    .name("Facultad de Ingeniería")
                    .children(Arrays.asList(
                            RecursiveCategoryRequest.builder().name("Ingeniería de Sistemas").build(),
                            RecursiveCategoryRequest.builder().name("Ingeniería Civil").build()
                    ))
                    .build();
            BulkCategoryCreation bulkResponse = bulkCreateUseCase.createCategoryTree(Collections.singletonList(parentCat));
            System.out.println("Categorías procesadas con éxito: " + bulkResponse.getSuccessfulCategories().size());
            if (!bulkResponse.getFailedCreations().isEmpty()) {
                System.out.println("Categorías que fallaron: " + bulkResponse.getFailedCreations().size());
                bulkResponse.getFailedCreations().forEach(fail -> System.out.println("  - " + fail.getRequest().getName() + ": " + fail.getFailureReason()));
            }

            // --- EJEMPLO 4: Creación de Cursos ---
            System.out.println("\n--- Creando un nuevo curso...");
            CreateCoursesUseCase createCoursesUseCase = Moodle.getBean(CreateCoursesUseCase.class);
            CreateCourseRequest newCourse = CreateCourseRequest.builder()
                    .fullname("Mi Curso Asombroso desde la Librería")
                    .shortname("CursoLibreria-01")
                    .categoryid(1L) // ID de una categoría existente
                    .build();
            List<Course> createdCourses = createCoursesUseCase.createCourses(Collections.singletonList(newCourse));
            createdCourses.forEach(System.out::println);

            // --- EJEMPLO 5: Obtener Calificaciones de un Curso ---
            System.out.println("\n--- Obteniendo calificaciones del curso ID 1...");
            GetUserGradeItemsUseCase gradeItemsUseCase = Moodle.getBean(GetUserGradeItemsUseCase.class);
            GradeItems gradeItems = gradeItemsUseCase.getUserGradeItems(1L);
            if (gradeItems.getUserGrades() != null) {
                gradeItems.getUserGrades().forEach(userGrade -> {
                    System.out.println("Calificaciones para: " + userGrade.getUserFullName());
                    userGrade.getGradeItems().forEach(System.out::println);
                });
            }

        } catch (MoodleApiException e) {
            System.err.println("\nERROR: Ocurrió un problema al comunicarse con Moodle.");
            System.err.println(e.getMessage());
        } finally {
            Moodle.destroy();
        }
    }
}
```

## Cómo Extender la Librería

Para añadir soporte para una nueva función de la API de Moodle, sigue el patrón establecido:

1.  **Dominio**:
    -   Crea el modelo de dominio en `domain/models` (ej: `MiNuevoObjeto.java`).
    -   Si es una operación de escritura, crea el objeto de petición en `domain/requests/{componente}/{entidad}/`.
    -   Si la respuesta es compleja, crea un objeto de respuesta en `domain/responses/{componente}/`.
    -   Define la interfaz del caso de uso en `domain/ports/in/{componente}/{entidad}/`.
    -   Define la interfaz del puerto de salida en `domain/ports/out/{componente}/`.

2.  **Aplicación**: Implementa la interfaz del caso de uso en un servicio dentro de `application/services/{componente}/`.

3.  **Infraestructura**:
    -   Crea los DTOs necesarios en `infrastructure/outputs/dtos/{componente}/{entidad}/`.
    -   Crea una interfaz `Mapper` con MapStruct en `infrastructure/outputs/mappers/{componente}/`.
    -   Crea un `Adapter` en `infrastructure/outputs/adapters/{componente}/` que implemente el puerto de salida.

## Licencia

Este proyecto está bajo la Licencia MIT.