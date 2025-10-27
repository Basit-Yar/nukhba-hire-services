package com.nukhbahire.platform.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "profiles")
public class Profile {

    @Id
    private String id;
    private String userId;
    private String title;
    private String name;
    private String slug;
    private String location;
    private String avatarUrl;
    private String bannerUrl;

    private String about;
    private List<String> skills;

    private Integer experienceInMonths;
    private List<Experience> experiences;
    private List<Education> educations;
    private List<Certification> certifications;

    private LocalDate createdOn;
    private LocalDate updatedOn;
}
