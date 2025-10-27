package com.nukhbahire.platform.service;

import com.nukhbahire.platform.dao.ProfileDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProfileService {

    private final ProfileDAO profileDAO;

}
