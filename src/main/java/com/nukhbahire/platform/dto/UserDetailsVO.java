package com.nukhbahire.platform.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsVO {

    private String userId;
    private String username;
    private String email;
    private Collection<? extends GrantedAuthority> roles;
}
