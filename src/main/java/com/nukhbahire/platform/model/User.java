package com.nukhbahire.platform.model;

import com.nukhbahire.platform.model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
public class User {

    @Id
    private String userId;
    private String username;
    private String password;
    private String email;
    private Set<Role> roles;

    private LocalDate registeredOn;
    private LocalDate updatedOn;
}
