package com.tuhin47.mongo.domain;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Document(collection = "biller")
public class Biller {
    @Id
    private String id;
    private String name;
    private Integer category;
    private Integer subcategory;

}