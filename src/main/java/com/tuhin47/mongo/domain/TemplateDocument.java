package com.tuhin47.mongo.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.Map;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Document(collection = "template_document")
public class TemplateDocument {
    @Id
    private String id;
    private String billerId;
    private String templateId;
    Map<String, ?> data = new HashMap<>();
}
