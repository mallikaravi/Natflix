# Natflix
#TOC

## Build and Generate the JAR file (compile the source code)
```
# Git clone (download the soruce code)
$ git clone https://github.com/mallikaravi/Natflix.git

# Project structure
.
├── ...
    ├──natflix-backend/
         ├──src
         ├──pom.xml
    ├──natflix-frontend/
         ├──src
         ├──package.json
    ├──sql
    ├──design/
    ├──docker-compose.yml
    ├──Dockerfile.backend
    ├──Dockerfile.frontend
    ├──README.md

$ cd Natflix
```
```
# Backend Application: Build and Run the JAR file (compile the source code)
$ cd natflix-backend
$ mvn clean package -DskipTests=true
$ java -jar -Dspring.profiles.active=prod target/natflix-backend-0.0.1.jar

# Frontenf Application : Install and run 
$ cd natflix-frontend
$ npm install
$ npm run start
```
## How to run and build Docker 
```
$ cd Natflix
$ docker compose up --build
```
## How to Setup and Access the Database, Backend and Frontend application
Note: Docker container setup the database enviroenment default data using sql/init.sql file.

- Database: 
   - User     : test
   - Password : root
   - Database Schema: natflix
   - Port : 3306
   - Initial Database schema: sql/init.sql
- Backend:
   - Profiles : prod (production environemnt) and dev (used during the development phase)
   - Server Port: 8080
   - Server Address : localhost
- Frontend:
   - Port: 3000
   - Address: localhost

Natflix Web application URL: http://localhost:3000/<br>
Login: admin@natflix.com 
Password: 12345

Prerequisites
============
* JDK 17.0.2
* [Maven](https://maven.apache.org/) for managing the project's build
* [Spring Boot](http://spring.io/projects/spring-boot) for creating the RESTful Web Services
* [NPM](https://docs.npmjs.com/about-npm) the package manager for the Node JavaScript platform
* [React](https://docs.retool.com/docs) for building web application.
* [Postgres](https://www.mysql.com/downloads/) as database
* [Docker](https://www.docker.com/) for building and managing the application distribution using containers
* [Postman](https://www.postman.com/downloads/) Postman is an API platform for developers to design, build, test and iterate their APIs

## ReST API Usage

Request Method | URI | Body (JSON) | Description |  
:---: | :--- | :---: | :--- |
POST | http://localhost:8080/api/login | {username: ""....} | Login as a admin . | 
POST | http://localhost:8080/api/signup | {username: ""....} | Registertion| 
GET | http://localhost:8080/api/logout | - | Logout and clear the cookies. | 
GET | http://localhost:8080/api/user | - | Get all the registered users | 
GET | http://localhost:8080/api/user/{id} | - | Get the details for selected user | 
PUT | http://localhost:8080/api/user/{id} | {....}  | Update User |
DELETE | http://localhost:8080/api/user/{id} | - | Remove User |
GET | http://localhost:8080/api/admin-content | - | Get all the conetent as a admin |
GET | http://localhost:8080/api/admin-content/movies | - | Get all the movies as a admin |
GET | http://localhost:8080/api/admin-content/series | - | Get all the series as a admin |
GET | http://localhost:8080/api/admin-content/documentaries | - | Get all the movies as a admin |
GET | http://localhost:8080/api/admin-details-series/{id} | - | Get series details  |
GET | http://localhost:8080/api/admin-details-movies/{id} | - | Get movie details |
GET | http://localhost:8080/api/admin-details-documentaries/{id} | - | Get documenteries details |
POST | http://localhost:8080/api/admin-content/create | {....} | Create content based on type Series/Movie/Documentaries details |
PUT | http://localhost:8080/api/admin-content/update | {....} | Get documenteries details |
DELETE | http://localhost:8080/api/"/admin-content/delete-series/{id}" | - | Delete Series |
DELETE | http://localhost:8080/api/"/admin-content/delete-episode/{id}" | - | Delete Episode |
DELETE | http://localhost:8080/api/"/admin-content/delete-movies/{id}" | - | Delete Movie |
DELETE | http://localhost:8080/api/"/admin-content/delete-documentaries/{id}" | - | Delete Movie |


