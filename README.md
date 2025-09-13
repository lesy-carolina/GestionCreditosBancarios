markdown
# Proyecto NTT DATA

Este proyecto es una arquitectura de microservicios desarrollada con Java, Spring Boot y Maven. Incluye varios servicios independientes que se comunican entre sí y pueden ser orquestados mediante Docker Compose.

## Estructura de directorios

- `api-gateway/`: Puerta de entrada para las peticiones, gestiona el enrutamiento hacia los microservicios.
- `ServicioClientes/`: Microservicio para la gestión de clientes.
- `ServicioCuentas/`: Microservicio para la gestión de cuentas bancarias.
- `ServicioEureka/`: Servicio de descubrimiento Eureka para registro y localización de microservicios.
- `ServicioPrestamos/`: Microservicio para la gestión de préstamos.
- `ServicioTransacciones/`: Microservicio para la gestión de transacciones.

## Tecnologías utilizadas

- Java 173. **Acceso a Eureka**  
   Visita [http://localhost:8761](http://localhost:8761) para ver el panel de Eureka.

## Base de datos

Cada microservicio que lo requiera incluye un archivo `data.sql` para inicializar datos de ejemplo.

## Pruebas

Ejecuta las pruebas unitarias con:+
- Spring Boot
- Spring Cloud (Eureka)
- Maven
- SQL
- Docker & Docker Compose

## Ejecución local

1. **Compilar los servicios**  
   Ejecuta en cada carpeta de microservicio: