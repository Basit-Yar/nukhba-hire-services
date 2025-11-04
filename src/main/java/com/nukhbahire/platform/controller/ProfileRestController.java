package com.nukhbahire.platform.controller;

import com.nukhbahire.platform.dto.ProfileCreateRequestVO;
import com.nukhbahire.platform.model.Profile;
import com.nukhbahire.platform.security.ServiceContext;
import com.nukhbahire.platform.service.ProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ProfileRestController {

    private final ProfileService profileService;

    public ProfileRestController(ProfileService profileService) {
        this.profileService = profileService;
    }


    @PostMapping(path = "/v1/profiles")
    public ResponseEntity<Profile> handleCreateProfile(@RequestBody ProfileCreateRequestVO requestVO, HttpServletRequest request) {

        ServiceContext ctx = ServiceContext.getInstance(request);
        Profile createdProfile = profileService.createNewProfile(requestVO, ctx.getUserId());
        return new ResponseEntity<>(createdProfile, HttpStatus.OK);
    }

    // TODO: 11/4/2025 : updateProfileById
    // TODO: 11/4/2025 : deleteProfileById

}
