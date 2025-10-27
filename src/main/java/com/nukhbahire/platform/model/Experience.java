package com.nukhbahire.platform.model;

import com.nukhbahire.platform.model.enums.EmploymentType;
import com.nukhbahire.platform.model.enums.WorkMode;
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
@Document(collection = "experiences")
public class Experience {

    @Id
    private String id;
    private String profileId;
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
