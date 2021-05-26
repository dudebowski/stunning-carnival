# Expense Service

## GOAL
Create an Expenses SpringBoot service. It holds expenses information for all
clients (date, amount spent).
Endpoints exposed:
POST /expense → create an expense record
GET /expenses/client/{id} → return a list of all the expenses for a client

NOTE: springboot is quite new to me  

## The plan 
The idea is to create an API with three layers
- web
  The controller for responding to the API requests
- service
  The business service and DTO.  
  The service wil implement the creation of an expense recorde and the retrieval of the list of expenses per client
- domain  
  The domainmodel (just a list of expenses).
  A repository  is used to access the domain classes
  given time create a datamodel where a client hold a list of expenses

## steps

1. create project with initializer   
I only used dependencie **springweb**, When time allows I will add **H2 database** and **spring security**

2. add controller tests
Happy flow test with mocks for the service
Also a smoke test was added to check if the application will startup

3. implement controller
All test should succeed

4. More testing for not happy flow
    - wrong dates
    - wrong httpMethod
    - wrong amount
    - ..
    

    //required json property is not working
    //2021-23-23T18:25:43.511Z is an acceptable date
   
