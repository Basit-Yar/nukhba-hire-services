package com.nukhbahire.platform.service;

import com.nukhbahire.platform.dao.CertificationDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CertificationService {

    private final CertificationDAO certificationDAO;
}
