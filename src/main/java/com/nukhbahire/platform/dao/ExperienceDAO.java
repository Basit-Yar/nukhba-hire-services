package com.nukhbahire.platform.dao;

import com.nukhbahire.platform.repository.ExperienceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ExperienceDAO {

    private final ExperienceRepository experienceRepository;
}
