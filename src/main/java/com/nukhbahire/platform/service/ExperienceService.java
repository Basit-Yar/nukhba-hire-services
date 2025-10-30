package com.nukhbahire.platform.service;

import com.nukhbahire.platform.dao.ExperienceDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExperienceService {

    private final ExperienceDAO experienceDAO;
}
