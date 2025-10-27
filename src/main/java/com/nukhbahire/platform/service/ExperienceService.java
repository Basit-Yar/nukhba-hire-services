package com.nukhbahire.platform.service;

import com.nukhbahire.platform.dao.ExperienceDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ExperienceService {

    private final ExperienceDAO experienceDAO;
}
