package com.nukhbahire.platform.service;

import com.nukhbahire.platform.dao.ProfileAggregatorDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileAggregatorService {

    private final ProfileAggregatorDAO profileAggregatorDAO;
}
