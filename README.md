# Spring Boot WebFlux User Service and Unit Tests
This repository contains a Spring Boot application that serves as a user management service, backed by a MongoDB database. The application is built using JDK 17 and utilizes the WebFlux framework for reactive programming. Below, you will find detailed information about the application and its unit tests using Karate.
## Application Overview
### Features
1. Get All Users: Retrieve a list of all users from the database. 
1. Get User by ID: Retrieve a user by their unique ID. 
1. Get Users by State: Retrieve a list of users with a specific state (true or false).
1. Add User: Add a new user to the database.
1. Update User: Update an existing user's information.
1. Delete User: Delete a user from the database.

### Technologies Used
+ Spring Boot: A Java-based framework for building web applications and microservices.
+ MongoDB: A NoSQL database used to store user information.
+ WebFlux: A reactive programming framework for building non-blocking, asynchronous web applications.

### Application Structure
The application's source code is structured as follows:
```
src/
|-- main/
|   |-- java/
|   |   |-- cl.foxcorp.app.webfluxkarate/
|   |   |   |-- controller/
|   |   |   |   |-- UserController.java     # RESTful API controller
|   |   |   |-- dto/
|   |   |   |   |-- request/
|   |   |   |   |   |-- InUserDto.java      # User in dto class
|   |   |   |   |-- response/
|   |   |   |   |   |-- UserDto.java        # User out dto class
|   |   |   |-- mapper/
|   |   |   |   |-- UserMapper.java         # User mapper class
|   |   |   |-- model/
|   |   |   |   |-- User.java               # User entity class
|   |   |   |-- repository/
|   |   |   |   |-- UserRepository.java     # User repository interface
|   |   |   |-- service/
|   |   |   |   |-- UserService.java        # User service implementation
|   |   |-- WebfluxKarate.java              # Spring Boot application entry point
|
|-- test/
|   |-- java/
|   |   |-- cl.foxcorp.app.webfluxkarate
|   |   |   |-- users.feature  # Karate test feature file
|   |   |   |-- UsersTest.java  # Karate test step definitions
```
### Running the Application
To run the Spring Boot application, execute the following command:
```
mvn spring-boot:run
```

The application will start on http://localhost:8080/api/v1/users

## Unit Tests with Karate
We have implemented unit tests for the user service using Karate. These tests cover various scenarios for creating, retrieving, updating, and deleting user records. Below are the detailed explanations of each test scenario
### Get list of users
1. This scenario tests the ability to retrieve a list of all users.
1. Given we have the base URL set to the user API endpoint.
1. When we send a GET request.
1. Then we expect a status code of 200.
1. And we ensure that each response contains fields id, username, email, and state.
 
### Get user by id
1. This scenario tests the ability to retrieve a user by their ID.
1. Given we have the base URL set to the user API endpoint along with a specific id.
1. When we send a GET request.
1. Then we expect a status code of 200.
1. And we ensure that the response contains the fields username, email, and state with specific values. 

### Get list of users with state true
1. This scenario tests the ability to retrieve a list of users with a specific state value (true).
1. Given we have the base URL set to the user API endpoint with a /state/true filter.
1. When we send a GET request.
1. Then we expect a status code of 200.
1. And we ensure that each response contains fields id, username, email, and state with the state field set to true.

### Add a new user
1. This scenario tests the ability to add a new user to the system.
1. Given we have the base URL set to the user API endpoint.
1. And we have a request body containing user data.
1. When we send a POST request.
1. Then we expect a status code of 201.
1. And we ensure that the response contains the fields username, email, and state with specific values.

### Update a user
1. This scenario tests the ability to update an existing user's information.
1. Given we have the base URL set to the user API endpoint along with a specific userId.
1. And we have a request body containing updated user data.
1. When we send a PUT request.
1. Then we expect a status code of 200.
1. And we ensure that the response contains the fields username, email, and state with specific updated values.

### Delete a user
1. This scenario tests the ability to delete a user from the system.
1. Given we have the base URL set to the user API endpoint along with a specific userId.
1. When we send a DELETE request.
1. Then we expect a status code of 204.

## Running Unit Tests
To run the unit tests using Karate, execute the following command from the project root directory:
```
mvn clean test -Dtest=UserServiceImplKarateTest
```

These tests will verify the functionality of the user service API endpoints as described in the scenarios above.

# Note: MongoDB Configuration
**Important**: Create an application.yml file in the src/main/resources directory with the following content:

```
spring:
  data:
    mongodb:
      uri: YOUR_MONGODB_CONNECTION_URL 
```
Replace **YOUR_MONGODB_CONNECTION_URL** with the actual MongoDB connection URL, including the protocol, hostname, port, and authentication credentials if required. Using YAML format is preferred for Spring Boot configuration, and this single property (uri) will handle your MongoDB connection settings. Ensure that the URL is correctly formatted to establish a connection with your MongoDB database.