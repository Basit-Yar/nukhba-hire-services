package com.nukhbahire.platform.service;

import com.nukhbahire.platform.dao.EducationDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EducationService {

    private final EducationDAO educationDAO;
}
