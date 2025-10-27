package com.nukhbahire.platform.dao;

import com.nukhbahire.platform.repository.EducationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EducationDAO {

    private final EducationRepository educationRepository;
}
