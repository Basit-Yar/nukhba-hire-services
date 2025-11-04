package com.nukhbahire.platform.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "certifications")
public class Certification {

    @Id
    private String id;
    private String profileId;
    private String name;
    private String issuingOrganization;
    private LocalDate issueDate;
    private LocalDate expiryDate;
    private boolean doesNotExpire;
    private LocalDate updatedOn;
}
