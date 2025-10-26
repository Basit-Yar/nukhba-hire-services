package com.nukhbahire.platform.service;

import com.nukhbahire.platform.dao.UserDAO;
import com.nukhbahire.platform.dto.JwtResponseVO;
import com.nukhbahire.platform.dto.LoginRequestVO;
import com.nukhbahire.platform.dto.RegistrationRequestVO;
import com.nukhbahire.platform.dto.UserDetailsVO;
import com.nukhbahire.platform.model.MyUserDetails;
import com.nukhbahire.platform.model.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Set;

@Service
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final MyUserDetailsService myUserDetailsService;
    private final JwtUtil jwtUtil;
    private final UserDAO userDAO;

    public AuthService(PasswordEncoder passwordEncoder,
                       UserDAO userDAO,
                       AuthenticationManager authenticationManager,
                       MyUserDetailsService myUserDetailsService,
                       JwtUtil jwtUtil) {

        this.passwordEncoder = passwordEncoder;
        this.userDAO = userDAO;
        this.authenticationManager = authenticationManager;
        this.myUserDetailsService = myUserDetailsService;
        this.jwtUtil = jwtUtil;
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

    public JwtResponseVO authenticateUser(LoginRequestVO loginRequestVO) throws Exception {
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

        UserDetailsVO userDetailsVO = new UserDetailsVO(
                ((MyUserDetails) userDetails).getUserId(),
                userDetails.getUsername(),
                ((MyUserDetails) userDetails).getEmail(),
                userDetails.getAuthorities()
        );

        return new JwtResponseVO(jwt, userDetailsVO);
    }
}
