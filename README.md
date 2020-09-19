# CRM

# Requirment

- Java 11
- Maven
- Spring Boot 2
- Spring Security
- Sprint Data JPA
- H2 DataBase
- Swagger UI
- Lombok

# Authentication/Authorizaiton

## Basic Auth

- Basic Authentication credentials is required within Request Headers for every request.

## Test account/password:
- SuperUser
    - account: superuser
    - password: 123
- Manager
    - account: manager
    - password: 123
- Operator
    - account: operator
    - password: 123
    
## Swagger UI
- http://localhost:8080/swagger-ui.html

## Implementation

- Use Spring Boot Framewokr to build rest api
- HTTP method POST, GET, PUT, DELETE for rest API
- Use Spring Data Jpa to map entity `Company` and `Client`
- Implment Port and Adapter architecture
- Use Spring Security to handler every request. Use Basic Authentication due to time limit.
- Use @ControllerAdvice to handler all Exception throwed, preventing internal error stack trace message send out
- Use Lombok to reduce duplicate code, making development easier, faster and comfortable.
- Clean Code, meaningful naming, avoid duplicate code, fewer lines of the method, guard clause.