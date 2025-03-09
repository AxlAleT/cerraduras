# Cerraduras API

Este proyecto implementa un API REST para calcular la cerradura de Kleene y la cerradura positiva de un conjunto de cadenas binarias de longitud máxima `n`.

## Requisitos

- Java Development Kit (JDK) 21 o superior
- Gradle 8.x o superior

## Instrucciones para ejecutar el proyecto

1. Clonar el repositorio:
   ```
   git clone https://github.com/AxlAleT/cerraduras
   cd cerraduras
   ```

2. Compilar el proyecto:
   ```
   ./gradlew build
   ```

3. Ejecutar la aplicación:
   ```
   ./gradlew bootRun
   ```

   La aplicación se iniciará en `http://localhost:8080`

## Endpoints disponibles

### Cerradura de Kleene (Estrella)

- **URL**: `/api/cerradura/estrella/{n}`
- **Método**: PUT
- **Parámetros URL**:
    - `n`: Número entero que indica la longitud máxima de las cadenas binarias a considerar
- **Respuesta**: JSON con el conjunto de cadenas binarias que forman la cerradura de Kleene

### Cerradura Positiva

- **URL**: `/api/cerradura/positiva/{n}`
- **Método**: PUT
- **Parámetros URL**:
    - `n`: Número entero que indica la longitud máxima de las cadenas binarias a considerar
- **Respuesta**: JSON con el conjunto de cadenas binarias que forman la cerradura positiva

## Ejemplos de uso

### Consultar cerradura de Kleene para n=2

```
curl -X PUT http://localhost:8080/api/cerradura/estrella/2
```

Respuesta:
```json
{
  "strings": ["", "0", "1", "00", "01", "10", "11"]
}
```

### Consultar cerradura positiva para n=2

```
curl -X PUT http://localhost:8080/api/cerradura/positiva/2
```

Respuesta:
```json
{
  "strings": ["0", "1", "00", "01", "10", "11"]
}
```

## Teoría: Cerraduras en Lenguajes Formales

- **Cerradura de Kleene (estrella)**: Para un conjunto A, la cerradura de Kleene A* es el conjunto de todas las cadenas que se pueden formar concatenando cualquier número de cadenas de A, incluyendo la cadena vacía.

- **Cerradura Positiva**: Para un conjunto A, la cerradura positiva A+ es el conjunto de todas las cadenas que se pueden formar concatenando uno o más elementos de A. A diferencia de la cerradura de Kleene, la cerradura positiva no incluye la cadena vacía (a menos que ya esté en A).