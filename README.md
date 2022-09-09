# Running the application

The easiest way to start the application is to run the below commands in the project root folder:

  `mvn clean install`
  
  `java -jar clientsapp-backend/target/clientsapp-backend-0.0.1-SNAPSHOT.jar`

The above process ensures that a minified bundle of the frontend application is created and moved into the static content directory of the Spring Boot application.
This is handled by Maven.

Once the server has started, the application is accessible at http://localhost:8080/

#### User credentials for logging in
- user - parool
- user2 - parool2
- user3 - parool3

A few users, clients and countries are created into the in-memory database upon application initialization.
The application's in-memory database can be accessed at http://localhost:8080/h2-console. The login credentials can be found in application.properties.
