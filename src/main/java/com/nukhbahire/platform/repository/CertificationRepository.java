package com.nukhbahire.platform.repository;

import com.nukhbahire.platform.model.Certification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificationRepository extends MongoRepository<Certification, String> {

}
