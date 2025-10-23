package com.nukhbahire.platform;

import com.nukhbahire.platform.model.User;
import com.nukhbahire.platform.service.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CommonTest {

    @Autowired
    TestService testService;

    @Test
    public void save_user_test() {
        User user = new User();
        user.setEmail("user@gmail.com");
        user.setUsername("username hai yeh mera");
        User savedUser = testService.saveUser(user);

    }
}
