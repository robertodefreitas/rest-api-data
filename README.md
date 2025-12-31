# REST API Data

Two Spring Boot REST API application.
* rest-api-receive-data
  * save data into the DB throw POST, or update data with PUT and remove data with DELETE.
* rest-api-get-data
  * get the data from a rest api endpoint from rest-api-receive-data.



## Prerequisites

- Java 17+
- Maven 3.6+
- Gradle 8.6+ (Spring Boot 3.2+)



## RUN


### Maven

```
user@machine-local:
$ alias | grep 'mvn-local'
alias mvn-local='/opt/build-tools/java/maven/current/bin/mvn'
```
```
$ cd /opt/projects/java/rest-api-data/1_receive
$ mvn-local clean package
$ mvn-local spring-boot:run
```
```
$ cd /opt/projects/java/rest-api-data/2_get
$ mvn-local clean package
$ mvn-local spring-boot:run
```


### Gradle
```
user@machine-local:
$ alias | grep 'gradle-local'
alias gradle-local='/opt/build-tools/java/gradle/current/bin/gradle'
```
```
$ cd /opt/projects/java/rest-api-data/1_receive
$ ./gradlew clean build
$ ./gradlew bootRun
```
```
$ cd /opt/projects/java/rest-api-data/2_get
$ ./gradlew clean build
$ ./gradlew bootRun

```



## URLS


### 1_receive

#### Tools

http://localhost:8011/swagger-ui.html  
http://localhost:8011/h2-console

#### Endpoints

POST (insert) and GET  
http://localhost:8011/api/data  

PUT (update) and DELETE  
http://localhost:8011/api/data/{id}  


### 2_get

#### Tools

http://localhost:8022/swagger-ui.html  
http://localhost:8022/h2-console

#### Endpoints

GET
http://localhost:8022/api/get-data  
http://localhost:8022/api/get-data/{idExternal}

