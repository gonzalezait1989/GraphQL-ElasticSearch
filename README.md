REQUIREMENTS
============
.- First of all, install 'docker' in your computer.

COMMENTS
========
.- This is a Spring Boot Application with all needed dependencies included in the POM file.
.- You have a docker file to run the Application. The command to run your implementation is
docker-compose up. It will automatically deploy an elasticsearch container and another container with your Application.
.- Otherwise, you can run your own elasticsearch instance (on port 9200), build the application using "mvn clean install -Plocal" and run it with "java -jar .\target\productsearchapp-0.0.1-SNAPSHOT.jar -P local".
.- You will find a simple Postman Collection that allows you to query the Product documents and also add new Products.
.- You can also check the GraphQL schema visiting "http://localhost:8080/voyager" and interact with it on "http://localhost:8080/playground".
