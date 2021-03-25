package com.tuhin47.mongo.dbref.model;

import com.tuhin47.mongo.dbref.annotation.CascadeSave;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

/*
import com.querydsl.core.annotations.QueryEntity;

@QueryEntity*/
@Data
@Document
@CompoundIndexes({@CompoundIndex(name = "email_age", def = "{'email.id' : 1, 'age': 1}")})
public class User {

    @Id
    private String id;
    @Indexed(direction = IndexDirection.ASCENDING)
    private String name;
    @Indexed(direction = IndexDirection.ASCENDING)
    private Integer age;

    @DBRef
    @Field("email")
    @CascadeSave
    private EmailAddress emailAddress;

    @DBRef
    @Field("address")
    @CascadeSave
    private List<Address> addresses;

    @Transient
    private Integer yearOfBirth;

    public User() {
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @PersistenceConstructor
    public User(final String name, @Value("#root.age ?: 0") final Integer age, final com.tuhin47.mongo.dbref.model.EmailAddress emailAddress) {
        this.name = name;
        this.age = age;
        this.emailAddress = emailAddress;
    }

}
