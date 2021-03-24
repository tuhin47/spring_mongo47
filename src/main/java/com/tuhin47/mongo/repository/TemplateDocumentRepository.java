package com.tuhin47.mongo.repository;


import com.tuhin47.mongo.domain.TemplateDocument;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateDocumentRepository extends ResourceRepository<TemplateDocument, String> {
}
