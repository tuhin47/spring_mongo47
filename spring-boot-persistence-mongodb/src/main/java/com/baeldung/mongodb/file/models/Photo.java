package com.baeldung.mongodb.file.models;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "photos")
public class Photo {

    @Transient
    public static final String SEQUENCE_NAME = "photo_sequence";

    @Id
    private Long id;

    private String title;

    private Binary image;

    public Photo(String title) {
        super();
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Binary getImage() {
        return image;
    }

    public void setImage(Binary image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Photo [id=" + id + ", title=" + title + ", image=" + image + "]";
    }

}
