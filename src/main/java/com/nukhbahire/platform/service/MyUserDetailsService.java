package com.nukhbahire.platform.service;

import com.nukhbahire.platform.dao.UserDAO;
import com.nukhbahire.platform.dto.RegistrationRequestVO;
import com.nukhbahire.platform.model.MyUserDetails;
import com.nukhbahire.platform.model.User;
import com.nukhbahire.platform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserDAO userDAO;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (!optionalUser.isPresent()) {
            throw new UsernameNotFoundException("Not found: " + username);
        }
        User user = optionalUser.get();
        return new MyUserDetails(user);
    }

    public User saveUser(RegistrationRequestVO requestVO) {

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
