package com.nukhbahire.platform.controller;

import com.nukhbahire.platform.service.ExperienceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ExperienceRestController {

    private final ExperienceService experienceService;
}
