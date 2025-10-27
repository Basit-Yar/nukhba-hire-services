package com.nukhbahire.platform.model;

import com.nukhbahire.platform.model.enums.EmploymentType;
import com.nukhbahire.platform.model.enums.WorkMode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Experience {

    private String id;  // you have to manually set the id
    private String jobTitle;
    private String companyName;
    private boolean currentlyWorking;
    private EmploymentType employmentType;
    private LocalDate startDate;
    private LocalDate endDate;
    private String location;    // office city, country
    private WorkMode workMode;
    private List<String> highlights;    // Achievements or key responsibilities
}
