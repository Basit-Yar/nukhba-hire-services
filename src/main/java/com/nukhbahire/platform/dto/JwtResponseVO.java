package com.nukhbahire.platform.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@AllArgsConstructor
public class JwtResponseVO {
    private final String jwt;
    private final UserDetails userDetails;
}
