package com.nukhbahire.platform.controller;

import com.nukhbahire.platform.service.ProfileService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileRestController {

    private final ProfileService profileService;

    public ProfileRestController(ProfileService profileService) {
        this.profileService = profileService;
    }

}
