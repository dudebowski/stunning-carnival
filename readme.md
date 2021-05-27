# Expense Service

## GOAL
Create an Expenses SpringBoot service. It holds expenses information for all
clients (date, amount spent).

Endpoints exposed:
POST /expense → create an expense record
GET /expenses/client/{id} → return a list of all the expenses for a client

## prereq
Next to experience with maven and Java some experience with developing rest API's with springboot is expected.   

This API uses :
JAVA 11
Maven 3.8.1
Springboot 2.5.0

## test
Command `mvn test` will run all the unit tests

## run
Start application by executing  `mvn spring-boot:run`

application can be accessed by localhost:8092.
The port can be altered in the application.properties
