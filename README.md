# Spring Boot Rest API Project

This is a sample Java / Maven / Spring Boot (version 2.6.2) application that can be used for creating, updating and retrieving recipes and their ingredients and instructions.

## How to Run 

There are two different ways to run, standalone or dockerized.
### Standalone version

This application is packaged as a war which has Tomcat 8 embedded. No Tomcat or JBoss installation is necessary. You run it using the ```java -jar``` command.

* Clone this repository 

```
https://github.com/dandinemre/assignment
```

* Make sure you are using JDK 11 and Maven 4
* Then go to your project directory in command line
* Then in the next step you have to create jar file for that, this can be done as

```
mvnw package [for WINDOWS OS ] or ./mvnw package [for MAC OS] , this will create jar file for our application.
```

* jar file is created in the target sub-directory
* Now go to target sub directory as jar was created inside of it 
* Now run the jar file in there. Use command ;

```
java -jar name.jar [ name is the name of your created jar file.]
```

and there you go , you are done . Now you can run project in browser,

 http://localhost:8080

### Dockerized
* Clone this repository

```
https://github.com/dandinemre/assignment
```
* Go to home directory
* run the following command
```
docker-compose up
```
and there you go , you are done . Now you can run project in browser,

http://localhost:8080

## About the backend

The service is just a simple receipt review REST API. 
It uses MySQL database to store the data. 
If your database connection properties work, you can call some REST endpoints defined in ```com.crediteuropebank.assignment.controller.ReceiptController``` on **port 8080**. 

Here is what this little application demonstrates: 

* Full integration with the latest **Spring** Framework: inversion of control, dependency injection, etc.
* Packaging as a single war with embedded container (tomcat 8): No need to install a container separately on the host just run using the ``java -jar`` command
* Writing a RESTful service using annotation: supports both XML and JSON request / response; simply use desired ``Accept`` header in your request
* *Spring Data* Integration with JPA/Hibernate with just a few lines of configuration and familiar annotations. 
* Whole database will be created once you run the application and initial credentials will be inserted to table as well
* Automatic CRUD functionality against the data source using Spring *Repository* pattern
* backend API secured by HTTP 
* Demonstrates MockMVC test framework with associated libraries
* You can use username : dandin and Password : 1234 as credentials to sign in
* All APIs are "self-documented" by OpenAPI 3, run the server and browse to 

```
http://localhost:8080/swagger-ui.html
```

# About Spring Boot

Spring Boot is an "opinionated" application bootstrapping framework that makes it easy to create new RESTful services (among other types of applications). 
It provides many of the usual Spring facilities that can be configured easily usually without any XML. 
In addition to easy set up of Spring Controllers, Spring Data, etc. 


## About the frontend

* The UI app is a simple HTML, Jquery and Bootstrap application
* Bootstrap has been chosen to create responsive design
* AJAX has been used for communicate to backend


## Questions and Comments: emre.dandin@gmail.com

