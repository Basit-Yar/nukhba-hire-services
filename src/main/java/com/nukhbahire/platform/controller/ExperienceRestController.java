package com.nukhbahire.platform.controller;

import com.nukhbahire.platform.service.ExperienceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExperienceRestController {

    private final ExperienceService experienceService;
}
