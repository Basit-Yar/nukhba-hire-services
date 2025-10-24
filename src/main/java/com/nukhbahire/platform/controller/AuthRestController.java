package com.nukhbahire.platform.controller;

import com.nukhbahire.platform.dto.RegistrationRequestVO;
import com.nukhbahire.platform.model.User;
import com.nukhbahire.platform.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthRestController {

    @Autowired
    MyUserDetailsService myUserDetailsService;

    @PostMapping("/v1/auth/register")
    public ResponseEntity<User> registerUser(@RequestBody RegistrationRequestVO requestVO) {
        User savedUser = myUserDetailsService.saveUser(requestVO);
        return ResponseEntity.ok(savedUser);
    }
}
