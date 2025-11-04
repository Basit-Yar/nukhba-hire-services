package com.nukhbahire.platform.model;

import com.nukhbahire.platform.model.enums.GradeScale;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "educations")
public class Education {

    @Id
    private String id;
    private String profileId;
    private String degree;
    private String fieldOfStudy;
    private String instituteName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String grade;
    private GradeScale gradeScale;
    private LocalDate updatedOn;
}