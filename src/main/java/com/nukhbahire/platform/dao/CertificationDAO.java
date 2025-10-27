package com.nukhbahire.platform.dao;

import com.nukhbahire.platform.repository.CertificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CertificationDAO {

    private final CertificationRepository certificationRepository;
}
