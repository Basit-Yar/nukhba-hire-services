package com.nukhbahire.platform.dao;

import com.nukhbahire.platform.model.User;
import com.nukhbahire.platform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDAO {

    @Autowired
    UserRepository userRepository;


    public User saveNewUser(User user) {
        return userRepository.save(user);
    }
}
