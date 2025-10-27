package com.nukhbahire.platform.dao;

import com.nukhbahire.platform.repository.ExperienceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExperienceDAO {

    private final ExperienceRepository experienceRepository;
}
