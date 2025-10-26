package com.nukhbahire.platform.dto;

import com.nukhbahire.platform.model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequestVO {

    private String username;
    private String password;
    private String email;
    private Role role;
}
