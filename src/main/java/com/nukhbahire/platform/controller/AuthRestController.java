package com.nukhbahire.platform.controller;

import com.nukhbahire.platform.dto.JwtResponseVO;
import com.nukhbahire.platform.dto.LoginRequestVO;
import com.nukhbahire.platform.dto.RegistrationRequestVO;
import com.nukhbahire.platform.model.User;
import com.nukhbahire.platform.service.AuthService;
import com.nukhbahire.platform.service.JwtUtil;
import com.nukhbahire.platform.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthRestController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    MyUserDetailsService myUserDetailsService;

    @Autowired
    AuthService authService;

    @PostMapping("/v1/auth/register")
    public ResponseEntity<User> handleRegisterUser(@RequestBody RegistrationRequestVO requestVO) {
        User savedUser = authService.registerUser(requestVO);
        return ResponseEntity.ok(savedUser);
    }

    @PostMapping("/v1/auth/login")
    public ResponseEntity<JwtResponseVO> handleCreateAuthenticationToken(@RequestBody LoginRequestVO loginRequestVO) throws Exception {
        return ResponseEntity.ok(authService.authenticateUser(loginRequestVO));
    }

}
