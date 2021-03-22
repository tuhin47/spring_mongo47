package com.tuhin47.mongo.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Document(collection = "template_structure")
public class TemplateStructure {
    @Id
    private String id;
    private Integer category;
    private Integer subcategory;

    List<TemplateParticular> templateParticulars = new ArrayList<>();

}
