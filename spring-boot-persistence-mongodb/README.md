# Relevant Articles

- [Auto-Generated Field for MongoDB using Spring Boot](https://www.baeldung.com/spring-boot-mongodb-auto-generated-field)
- [Spring Boot Integration Testing with Embedded MongoDB](http://www.baeldung.com/spring-boot-embedded-mongodb)
- [Upload and Retrieve Files Using MongoDB and Spring Boot](https://www.baeldung.com/spring-boot-mongodb-upload-file)
- [GridFS in Spring Data MongoDB](http://www.baeldung.com/spring-data-mongodb-gridfs)
- [ZonedDateTime with Spring Data MongoDB](https://www.baeldung.com/spring-data-mongodb-zoneddatetime)

# Run Program

Mongo Server as docker:

**stack.yml**

```yml
# Use root/example as user/password credentials
version: '3.1'

services:

  mongo:
    image: mongo
    container_name: "mongo"
    restart: always
    environment:
      MONGO_INITDB_ROOT_USERNAME: root
      MONGO_INITDB_ROOT_PASSWORD: example

  mongo-express:
    image: mongo-express
    restart: always
    ports:
      - 8081:8081
    environment:
      ME_CONFIG_MONGODB_ADMINUSERNAME: root
      ME_CONFIG_MONGODB_ADMINPASSWORD: example
      ME_CONFIG_MONGODB_URL: mongodb://root:example@mongo:27017/
```

use url as `mongodb://root:example@<docekr-ip-address>:27017/`
