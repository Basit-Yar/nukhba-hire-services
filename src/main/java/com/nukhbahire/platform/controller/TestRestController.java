package com.nukhbahire.platform.controller;

import com.nukhbahire.platform.model.User;
import com.nukhbahire.platform.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {

    @Autowired
    TestService testService;

    @PostMapping(path = "/v1/test")
    public ResponseEntity<User> handleSaveUser() {
        User user = new User();
        user.setEmail("user@gmail.com");
        User savedUser = testService.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.OK);
    }
}
