package com.nukhbahire.platform.service;

import com.nukhbahire.platform.dao.ProfileDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final ProfileDAO profileDAO;

}
