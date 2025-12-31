# REST API Receive Data

A Spring Boot REST API application for receiving and managing data.

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
$ cd /opt/projects/java/rest-api-data/1_receive
$ mvn-local clean package
```

### Running

```
mvn spring-boot:run
```
```
user@machine-local:
$ cd /opt/projects/java/rest-api-data/1_receive
$ mvn-local spring-boot:run
```

The API will be available at http://localhost:8011



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
$ cd /opt/projects/java/rest-api-data/1_receive

$ gradle-local wrapper --gradle-version 8.6

# build the project
$ ./gradlew clean build
```

#### ERROR with v9
```
user@machine-local:
/opt/projects/java/rest-api-data/1_receive
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
$ cd /opt/projects/java/rest-api-data/1_receive

# run the app
$ ./gradlew bootRun
```

The API will be available at http://localhost:8011



## API Endpoints
### Create Data

```
POST /api/data
Content-Type: application/json
{
  "name": "John Doe",
  "email": "john@example.com",
  "message": "This is a test message"
}
```

```
GET /api/data
```

```
GET /api/data/{id}
```

```
GET /api/data/email/{email}
```


### Update Data
```
PUT /api/data/{id}
Content-Type: application/json

{
  "name": "Updated Name",
  "email": "updated@example.com",
  "message": "Updated message"
}
```
### Delete Data
```
DELETE /api/data/{id}
```

## Use with CURL

```
BASE_URL="http://localhost:8011/api/data"
```
### POST
```
$ curl --silent -X POST "${BASE_URL}" \
  -H "Content-Type: application/json" \
  -d '{
    "name": "John Doe",
    "email": "john@example.com",
    "message": "This is a test message"
  }' | jq

BASH STDOUT
{
  "id": 2,
  "name": "John Doe",
  "email": "john@example.com",
  "message": "This is a test message",
  "createdAt": "2025-12-14T22:43:59.777279796"
}
```

### GET
```
$ curl --silent -X GET "${BASE_URL}" | jq

BASH STDOUT
[
  {
    "id": 1,
    "name": "John Doe",
    "email": "john@example.com",
    "message": "This is a test message",
    "createdAt": "2025-12-14T22:43:29.594591"
  },
  {
    "id": 2,
    "name": "John Doe",
    "email": "john@example.com",
    "message": "This is a test message",
    "createdAt": "2025-12-14T22:43:59.77728"
  }
]

```

### PUT
```
$ curl --silent -X PUT "${BASE_URL}/1" \
  -H "Content-Type: application/json" \
  -d '{
    "name": "John Doe",
    "email": "john.updated@example.com",
    "message": "Updated message"
  }' | jq

BASH STDOUT
{
  "id": 1,
  "name": "John Doe",
  "email": "john.updated@example.com",
  "message": "Updated message",
  "createdAt": "2025-12-14T22:43:29.594591"
}

```

### DELETE
```
$ curl --silent -X DELETE "${BASE_URL}/1"
```

## H2 Console
Access the H2 database console at: http://localhost:8011/h2-console

JDBC URL: jdbc:h2:mem:testdb  
Username: sa  
Password: (leave empty) 

## Swagger

### Open the Swagger UI in your browser
http://localhost:8011/swagger-ui.html (redirects to /swagger-ui/index.html)

### Raw OpenAPI JSON/YAML
http://localhost:8011/v3/api-docs  
http://localhost:8011/v3/api-docs.yaml (if requested by client)


