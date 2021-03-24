package com.tuhin47.mongo.dbref;

import com.tuhin47.mongo.dbref.model.EmailAddress;
import com.tuhin47.mongo.dbref.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class MongoApplication implements CommandLineRunner {

    @Autowired
    private MongoTemplate mongoTemplate;

    public static void main(String[] args) {
        SpringApplication.run(MongoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        final User user = new User();
        user.setName("Brendan");
        final EmailAddress emailAddress = new EmailAddress();
        emailAddress.setValue("b@gmail.com");
        final EmailAddress emailAddress2 = new EmailAddress();
        emailAddress.setValue("b@gmail.com");
        user.setEmailAddress(emailAddress);
        mongoTemplate.insert(user);

    }
}
