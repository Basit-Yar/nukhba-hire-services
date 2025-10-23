package com.nukhbahire.platform.service;

import com.nukhbahire.platform.model.User;
import com.nukhbahire.platform.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    TestRepository testRepository;

    public User saveUser(User user) {
        return testRepository.save(user);
    }
}
