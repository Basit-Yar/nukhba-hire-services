package com.nukhbahire.platform.controller;

import com.nukhbahire.platform.service.EducationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class EducationRestController {

    private final EducationService educationService;
}
