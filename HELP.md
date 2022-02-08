# Getting Started

### Docker Commands
* docker pull mongo:latest
* docker run -d -p 27017:27017 --name mongospringdata mongo:latest
* docker build -t mongo-spring-data:1.0 .
* 1st approach to Run Docker Image using LINK
  * docker run -p 8082:8082 --link mongospringdata:mongo -d mongo-spring-data:1.0
* 2nd approach to Run Docker Image using DOCKER-COMPOSE
  * docker-compose up
* docker ps
* docker exec -it mongospringdata bash
  * Run below mongodb basic commands after executing above command
    * mongo
      * show dbs
      * use store
      * show collections
      * db.store.find().pretty()

### To verify mongo db log
docker exec -it mongospringdata bash


###Running container's log
* docker logs <container_name>
### Follow container's log
* docker logs -f <container_name>
### Save container's log in a file
* docker logs <container_name> > output.log



### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.6.3/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.6.3/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.6.3/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Data MongoDB](https://docs.spring.io/spring-boot/docs/2.6.3/reference/htmlsingle/#boot-features-mongodb)

### Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing Data with MongoDB](https://spring.io/guides/gs/accessing-data-mongodb/)

