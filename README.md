# REST API with Spring Boot and MongoDB
A simple RESTful API server which supports basic CRUD operations.

## Prerequisites
- maven 3.x
- Java 1.7
- cURL
- git
- MongoDB

## Installation
Clone this repository
```sh
$ git clone https://github.com/ivanmarban/spring-boot-movies-restful.git
```
Modify application.properties in src/main/resources for your environment and run the application
```sh
$ mvn spring-boot:run
```
## Testing the API using cURL
Get all movies:
```sh
$ curl -i -X GET http://localhost:3000/api/v1/movies 
```
Get movie with _id value of 5514677bda31962c1189aa23
```sh
$ curl -i -X GET http://localhost:3000/api/v1/movie/5514677bda31962c1189aa23
```
Delete movie with _id value of 5514677bda31962c1189aa23
```sh
$ curl -i -X DELETE http://localhost:3000/api/v1/movie/5514677bda31962c1189aa23
```
Add new movie
```sh
$ curl -i -X POST -H 'Content-Type: application/json' -d '{"title": "2001: A Space Odyssey","year": "1968","rated": "G","runtime": "160 min","genre": "Mystery, Sci-Fi","director": "Stanley Kubrick"}' http://localhost:3000/api/v1/movie
```
Modify movie with _id value of 5514677bda31962c1189aa23
```sh
$ curl -i -X PUT -H 'Content-Type: application/json' -d '{"title": "2001: A Space Odyssey","year": "1968","rated": "G","runtime": "160 min","genre": "Sci-Fi","director": "Stanley Kubrick"}' http://localhost:3000/api/v1/movie
```

## REST API

URL  | HTTP Verb | POST Body | Result 
------------- | ------------- | ------------- | -------------
/api/v1/movies  | GET  | empty  | Return all movies
/api/v1/movie  | POST   | JSON string  | New movie created
/api/v1/movie/:id  | GET   | empty  | Return single movie
/api/v1/movie/:id  | PUT   | JSON string  | Updates an existing movie
/api/v1/movie/:id  | DELETE   | empty  | Deletes existing keyword
