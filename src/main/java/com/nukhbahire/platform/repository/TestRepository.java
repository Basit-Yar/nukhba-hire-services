package com.nukhbahire.platform.repository;

import com.nukhbahire.platform.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TestRepository extends MongoRepository<User, String> {

}
