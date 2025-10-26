package com.nukhbahire.platform.service;

import com.nukhbahire.platform.dao.UserDAO;
import com.nukhbahire.platform.dto.RegistrationRequestVO;
import com.nukhbahire.platform.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Set;

@Service
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final UserDAO userDAO;

    public AuthService(PasswordEncoder passwordEncoder, UserDAO userDAO) {
        this.passwordEncoder = passwordEncoder;
        this.userDAO = userDAO;
    }

    public User registerUser(RegistrationRequestVO requestVO) {

        // TODO: 10/24/2025 : check user existence then save.
        User user = new User();
        user.setUsername(requestVO.getUsername());
        user.setPassword(passwordEncoder.encode(requestVO.getPassword()));
        user.setEmail(requestVO.getEmail());
        user.setRoles(Set.of(requestVO.getRole()));
        user.setRegisteredOn(LocalDate.now());

        return userDAO.saveNewUser(user);
    }
}
