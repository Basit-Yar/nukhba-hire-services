package com.nukhbahire.platform.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProfileAggregatorDAO {

    private final ProfileDAO profileDAO;
    private final ExperienceDAO experienceDAO;
    private final EducationDAO educationDAO;
    private final CertificationDAO certificationDAO;
    private final ProfileAggregatorDAO profileAggregatorDAO;
}
