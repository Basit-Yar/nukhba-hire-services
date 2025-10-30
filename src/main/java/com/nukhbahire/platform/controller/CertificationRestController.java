package com.nukhbahire.platform.controller;

import com.nukhbahire.platform.service.CertificationService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CertificationRestController {

    private CertificationService certificationService;
}
