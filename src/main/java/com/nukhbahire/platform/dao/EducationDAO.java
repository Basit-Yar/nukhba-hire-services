package com.nukhbahire.platform.dao;

import com.nukhbahire.platform.repository.EducationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EducationDAO {

    private final EducationRepository educationRepository;
}
