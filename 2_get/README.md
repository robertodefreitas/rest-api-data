# REST API Receive Data

A Spring Boot REST API application for get or read data from a REST API.

## Features

- Create, read, update, and delete data entries
- Validation for input data
- Email-based search functionality
- H2 in-memory database
- Global exception handling
- CORS support

## Prerequisites

- Java 17+
- Maven 3.6+
- Gradle 8.6+ (Spring Boot 3.2+)



## MAVEN

### Building

```
[bash]
mvn clean package
```
```
user@machine-local:
$ cd /opt/projects/java/rest-api-data/2_get
$ mvn-local clean package
```

### Running

```
mvn spring-boot:run
```
```
user@machine-local:
$ cd /opt/projects/java/rest-api-data/2_get
$ mvn-local spring-boot:run
```

The API will be available at http://localhost:8022



## GRADLE

### Building

```
# generate the gradle wrapper (choose a compatible Gradle version; 8.6+ is typical for Spring Boot 3.2)
gradle wrapper --gradle-version 8.6
```
```
./gradlew clean build
```
```
user@machine-local:
$ cd /opt/projects/java/rest-api-data/2_get

$ gradle-local wrapper --gradle-version 8.6

# build the project
$ ./gradlew clean build
```

#### ERROR with v9
```
user@machine-local:
/opt/projects/java/rest-api-data/2_get
$ gradle-local wrapper --gradle-version 9.2.1

BUILD SUCCESSFUL in 2s
1 actionable task: 1 executed
Consider enabling configuration cache to speed up this build: https://docs.gradle.org/9.2.1/userguide/configuration_cache_enabling.html


$ ./gradlew clean build
Downloading https://services.gradle.org/distributions/gradle-9.2.1-bin.zip

This is a binary incompatibility error (method removed/changed).

👉 Gradle 9 removed internal APIs
👉 Spring Boot 3.2 + dependency-management 1.1.0 are NOT compatible with Gradle 9

```

### Running
```
./gradlew bootRun
```
```
user@machine-local:
$ cd /opt/projects/java/rest-api-data/2_get

# run the app
$ ./gradlew bootRun
```



## API Endpoints
### Create Data

```
GET /api/get-data
```

```
GET /api/get-data/{idExtern}
```


## Use with CURL

```
BASE_URL_GET="http://localhost:8022/api/get-data"
```

### GET
```
$ curl --silent -X GET "${BASE_URL_GET}" | jq

BASH STDOUT
[
  {
    "id": 1,
    "idExtern": 1,
    "name": "John Doe",
    "email": "john.updated@example.com",
    "message": "Updated message",
    "createdAt": "2025-12-29T15:28:21.194323"
  },
  {
    "id": 2,
    "idExtern": 2,
    "name": "John Doe",
    "email": "john@example.com",
    "message": "This is a test message",
    "createdAt": "2025-12-29T15:28:24.212342"
  },
  {
    "id": 3,
    "idExtern": 2,
    "name": "John Doe",
    "email": "john@example.com",
    "message": "This is a test message",
    "createdAt": "2025-12-29T15:29:51.758526"
  },
  {
    "id": 4,
    "idExtern": 1,
    "name": "John Doe",
    "email": "john.updated@example.com",
    "message": "Updated message",
    "createdAt": "2025-12-29T15:29:59.578586"
  }
]
```

```
$ curl --silent -X GET "${BASE_URL_GET}/1" | jq

BASH STDOUT
{
  "id": 4,
  "idExtern": 1,
  "name": "John Doe",
  "email": "john.updated@example.com",
  "message": "Updated message",
  "createdAt": "2025-12-29T15:22:22.317003124"
}
```

## H2 Console
Access the H2 database console at: http://localhost:8022/h2-console

JDBC URL: jdbc:h2:mem:testdb  
Username: sa  
Password: (leave empty) 

## Swagger

### Open the Swagger UI in your browser
http://localhost:8022/swagger-ui.html (redirects to /swagger-ui/index.html)

### Raw OpenAPI JSON/YAML
http://localhost:8022/v3/api-docs  
http://localhost:8022/v3/api-docs.yaml (if requested by client)


