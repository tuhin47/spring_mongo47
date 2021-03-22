package com.tuhin47.mongo.domain;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TemplateParticular {
    @NonNull
    private String title;
    private String columnType;
    private String sampleValue;
    private boolean searchable;
}
