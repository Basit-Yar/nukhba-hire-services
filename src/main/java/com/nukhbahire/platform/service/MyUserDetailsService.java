package com.nukhbahire.platform.service;

import com.nukhbahire.platform.dao.UserDAO;
import com.nukhbahire.platform.model.MyUserDetails;
import com.nukhbahire.platform.model.User;
import com.nukhbahire.platform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserDAO userDAO;

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (!optionalUser.isPresent()) {
            throw new UsernameNotFoundException("Not found: " + username);
        }
        User user = optionalUser.get();
        return new MyUserDetails(user);
    }
}
