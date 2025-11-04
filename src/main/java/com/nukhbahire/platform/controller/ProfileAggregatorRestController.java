package com.nukhbahire.platform.controller;

import com.nukhbahire.platform.service.ProfileAggregatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProfileAggregatorRestController {

    private final ProfileAggregatorService profileAggregatorService;

    // TODO: 11/4/2025 : getProfileById
    // TODO: 11/4/2025 : getProfileByUserId
    // TODO: 11/4/2025 : getProfileBySlug
    // TODO: 11/4/2025 : getAllProfileSummary
    // TODO: 11/5/2025 : getPaginatedProfileSummary

}
