package com.nukhbahire.platform.service;

import com.nukhbahire.platform.dao.CertificationDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CertificationService {

    private final CertificationDAO certificationDAO;
}
