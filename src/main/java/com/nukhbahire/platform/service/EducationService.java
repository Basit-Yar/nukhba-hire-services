package com.nukhbahire.platform.service;

import com.nukhbahire.platform.dao.EducationDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EducationService {

    private final EducationDAO educationDAO;
}
