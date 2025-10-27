package com.nukhbahire.platform.model;

import com.nukhbahire.platform.model.enums.GradeScale;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Education {

    private String id;
    private String degree;
    private String fieldOfStudy;
    private String instituteName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String grade;
    private GradeScale gradeScale;
}