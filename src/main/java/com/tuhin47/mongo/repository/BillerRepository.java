package com.tuhin47.mongo.repository;

import com.tuhin47.mongo.domain.Biller;
import org.springframework.stereotype.Repository;

@Repository
public interface BillerRepository extends ResourceRepository<Biller, String> {
}
