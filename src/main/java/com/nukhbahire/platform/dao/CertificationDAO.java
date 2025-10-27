package com.nukhbahire.platform.dao;

import com.nukhbahire.platform.repository.CertificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CertificationDAO {

    private final CertificationRepository certificationRepository;
}
