package com.nukhbahire.platform.controller;

import com.nukhbahire.platform.service.CertificationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CertificationRestController {

    private CertificationService certificationService;
}
