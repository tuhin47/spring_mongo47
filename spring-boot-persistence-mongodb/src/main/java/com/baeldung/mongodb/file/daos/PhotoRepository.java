package com.baeldung.mongodb.file.daos;

import com.baeldung.mongodb.file.models.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PhotoRepository extends MongoRepository<Photo, Long> {

}
