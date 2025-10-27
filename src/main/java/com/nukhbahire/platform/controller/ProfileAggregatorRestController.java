package com.nukhbahire.platform.controller;

import com.nukhbahire.platform.service.ProfileAggregatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProfileAggregatorRestController {

    private final ProfileAggregatorService profileAggregatorService;
}
