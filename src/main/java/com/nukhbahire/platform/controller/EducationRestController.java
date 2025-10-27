package com.nukhbahire.platform.controller;

import com.nukhbahire.platform.service.EducationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EducationRestController {

    private final EducationService educationService;
}
