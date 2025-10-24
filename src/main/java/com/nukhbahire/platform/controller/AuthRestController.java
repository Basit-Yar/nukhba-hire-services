package com.nukhbahire.platform.controller;

import com.nukhbahire.platform.dto.JwtResponseVO;
import com.nukhbahire.platform.dto.LoginRequestVO;
import com.nukhbahire.platform.dto.RegistrationRequestVO;
import com.nukhbahire.platform.model.User;
import com.nukhbahire.platform.service.JwtUtil;
import com.nukhbahire.platform.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
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

    @PostMapping("/v1/auth/register")
    public ResponseEntity<User> registerUser(@RequestBody RegistrationRequestVO requestVO) {
        User savedUser = myUserDetailsService.saveUser(requestVO);
        return ResponseEntity.ok(savedUser);
    }

    @PostMapping("/v1/auth/login")
    public ResponseEntity<JwtResponseVO> createAuthenticationToken(@RequestBody LoginRequestVO loginRequestVO) throws Exception {
//        System.out.println("Sign in process start");
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequestVO.getUsername(), loginRequestVO.getPassword())
            );
        } catch (Exception e) {
            System.out.println(e);
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = myUserDetailsService.loadUserByUsername(loginRequestVO.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponseVO(jwt, userDetails));
    }

}
